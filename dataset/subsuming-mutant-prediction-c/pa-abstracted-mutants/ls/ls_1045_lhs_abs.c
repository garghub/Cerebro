static void
dev_ino_push ( dev_t dev , ino_t ino )
{
void * vdi ;
struct dev_ino * di ;
int dev_ino_size = sizeof *di ;
obstack_blank ( & dev_ino_obstack , dev_ino_size ) ;
vdi = obstack_next_free ( & dev_ino_obstack ) ;
di = vdi ;
di -- ;
di -> st_dev = dev ;
di -> st_ino = ino ;
}
static struct dev_ino
dev_ino_pop ( void )
{
void * vdi ;
struct dev_ino * di ;
int dev_ino_size = sizeof *di ;
assert ( dev_ino_size <= obstack_object_size ( & dev_ino_obstack ) ) ;
obstack_blank ( & dev_ino_obstack , - dev_ino_size ) ;
vdi = obstack_next_free ( & dev_ino_obstack ) ;
di = vdi ;
return * di ;
}
static void
dired_dump_obstack ( const char * prefix , struct obstack * os )
{
size_t n_pos ;
n_pos = obstack_object_size ( os ) / sizeof ( dired_pos ) ;
if ( n_pos > 0 )
{
size_t i ;
size_t * pos ;
pos = ( size_t * ) obstack_finish ( os ) ;
fputs ( prefix , stdout ) ;
for ( i = 0 ; i < n_pos ; i ++ )
printf ( lr_1 , ( unsigned long int ) pos [ i ] ) ;
putchar ( '\n' ) ;
}
}
static size_t
abmon_init ( void )
{
#ifdef HAVE_NL_LANGINFO
required_mon_width = MAX_MON_WIDTH ;
size_t curr_max_width ;
do
{
curr_max_width = required_mon_width ;
required_mon_width = 0 ;
int i ;
for ( i = 0 ; i < 12 ; i ++ )
{
size_t width = curr_max_width ;
size_t req = mbsalign ( nl_langinfo ( ABMON_1 + i ) ,
abmon [ i ] , sizeof ( abmon [ i ] ) ,
& width , MBS_ALIGN_LEFT , 0 ) ;
if ( req == ( size_t ) - 1 || req >= sizeof ( abmon [ i ] ) )
{
required_mon_width = 0 ;
return required_mon_width ;
}
required_mon_width = MAX ( required_mon_width , width ) ;
}
}
while ( curr_max_width > required_mon_width );
#endif
return required_mon_width ;
}
static size_t
dev_ino_hash ( void const * x , size_t table_size )
{
struct dev_ino const * p = x ;
return ( uintmax_t ) p -> st_ino % table_size ;
}
static bool
dev_ino_compare ( void const * x , void const * y )
{
struct dev_ino const * a = x ;
struct dev_ino const * b = y ;
return SAME_INODE ( * a , * b ) ? true : false ;
}
static void
dev_ino_free ( void * x )
{
free ( x ) ;
}
static bool
visit_dir ( dev_t dev , ino_t ino )
{
struct dev_ino * ent ;
struct dev_ino * ent_from_table ;
bool found_match ;
ent = xmalloc ( sizeof *ent ) ;
ent -> st_ino = ino ;
ent -> st_dev = dev ;
ent_from_table = hash_insert ( active_dir_set , ent ) ;
if ( ent_from_table == NULL )
{
xalloc_die () ;
}
found_match = ( ent_from_table != ent ) ;
if ( found_match )
{
free ( ent ) ;
}
return found_match ;
}
static void
free_pending_ent ( struct pending * p )
{
free ( p -> name ) ;
free ( p -> realname ) ;
free ( p ) ;
}
static bool
is_colored ( enum indicator_no type )
{
size_t len = color_indicator [ type ] . len ;
char const * s = color_indicator [ type ] . string ;
return ! ( len == 0
|| ( len == 1 && STRNCMP_LIT ( s , lr_2 ) == 0 )
|| ( len == 2 && STRNCMP_LIT ( s , lr_3 ) == 0 ) ) ;
}
static void
restore_default_color ( void )
{
put_indicator ( & color_indicator [ C_LEFT ] ) ;
put_indicator ( & color_indicator [ C_RIGHT ] ) ;
}
static void
set_normal_color ( void )
{
if ( print_with_color && is_colored ( C_NORM ) )
{
put_indicator ( & color_indicator [ C_LEFT ] ) ;
put_indicator ( & color_indicator [ C_NORM ] ) ;
put_indicator ( & color_indicator [ C_RIGHT ] ) ;
}
}
static void
sighandler ( int sig )
{
if ( ! SA_NOCLDSTOP )
signal ( sig , SIG_IGN ) ;
if ( ! interrupt_signal )
interrupt_signal = sig ;
}
static void
stophandler ( int sig )
{
if ( ! SA_NOCLDSTOP )
signal ( sig , stophandler ) ;
if ( ! interrupt_signal )
stop_signal_count ++ ;
}
static void
process_signals ( void )
{
while ( interrupt_signal || stop_signal_count )
{
int sig ;
int stops ;
sigset_t oldset ;
if ( used_color )
restore_default_color () ;
fflush ( stdout ) ;
sigprocmask ( SIG_BLOCK , & caught_signals , & oldset ) ;
sig = interrupt_signal ;
stops = stop_signal_count ;
if ( stops )
{
stop_signal_count = stops - 1 ;
sig = SIGSTOP ;
}
else
signal ( sig , SIG_DFL ) ;
raise ( sig ) ;
sigprocmask ( SIG_SETMASK , & oldset , NULL ) ;
}
}
int
main ( int argc , char * * argv )
{
int i ;
struct pending * thispend ;
int n_files ;
static int const sig [] =
{
SIGTSTP ,
SIGALRM , SIGHUP , SIGINT , SIGPIPE , SIGQUIT , SIGTERM ,
#ifdef SIGPOLL
SIGPOLL ,
#endif
#ifdef SIGPROF
SIGPROF ,
#endif
#ifdef SIGVTALRM
SIGVTALRM ,
#endif
#ifdef SIGXCPU
SIGXCPU ,
#endif
#ifdef SIGXFSZ
SIGXFSZ ,
#endif
} ;
enum { nsigs = ARRAY_CARDINALITY (sig) };
#if ! SA_NOCLDSTOP
bool caught_sig [ nsigs ] ;
#endif
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_4 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
initialize_exit_failure ( LS_FAILURE ) ;
atexit ( close_stdout ) ;
assert ( ARRAY_CARDINALITY ( color_indicator ) + 1
== ARRAY_CARDINALITY ( indicator_name ) ) ;
exit_status = EXIT_SUCCESS ;
print_dir_name = true ;
pending_dirs = NULL ;
current_time . tv_sec = TYPE_MINIMUM ( time_t ) ;
current_time . tv_nsec = - 1 ;
i = decode_switches ( argc , argv ) ;
if ( print_with_color )
parse_ls_color () ;
if ( print_with_color )
{
if ( is_colored ( C_ORPHAN )
|| ( is_colored ( C_EXEC ) && color_symlink_as_referent )
|| ( is_colored ( C_MISSING ) && format == long_format ) )
check_symlink_color = true ;
if ( 0 <= tcgetpgrp ( STDOUT_FILENO ) )
{
int j ;
#if SA_NOCLDSTOP
struct sigaction act ;
sigemptyset ( & caught_signals ) ;
for ( j = 0 ; j < nsigs ; j ++ )
{
sigaction ( sig [ j ] , NULL , & act ) ;
if ( act . sa_handler != SIG_IGN )
sigaddset ( & caught_signals , sig [ j ] ) ;
}
act . sa_mask = caught_signals ;
act . sa_flags = SA_RESTART ;
for ( j = 0 ; j < nsigs ; j ++ )
if ( sigismember ( & caught_signals , sig [ j ] ) )
{
act . sa_handler = sig [ j ] == SIGTSTP ? stophandler : sighandler ;
sigaction ( sig [ j ] , & act , NULL ) ;
}
#else
for ( j = 0 ; j < nsigs ; j ++ )
{
caught_sig [ j ] = ( signal ( sig [ j ] , SIG_IGN ) != SIG_IGN ) ;
if ( caught_sig [ j ] )
{
signal ( sig [ j ] , sig [ j ] == SIGTSTP ? stophandler : sighandler ) ;
siginterrupt ( sig [ j ] , 0 ) ;
}
}
#endif
}
}
if ( dereference == DEREF_UNDEFINED )
dereference = ( ( immediate_dirs
|| indicator_style == classify
|| format == long_format )
? DEREF_NEVER
: DEREF_COMMAND_LINE_SYMLINK_TO_DIR ) ;
if ( recursive )
{
active_dir_set = hash_initialize ( INITIAL_TABLE_SIZE , NULL ,
dev_ino_hash ,
dev_ino_compare ,
dev_ino_free ) ;
if ( active_dir_set == NULL )
xalloc_die () ;
obstack_init ( & dev_ino_obstack ) ;
}
format_needs_stat = sort_type == sort_time || sort_type == sort_size MST[@!ABS$@$]MSP[]
|| format == long_format
|| print_scontext
|| print_block_size ;
format_needs_type = ( ! format_needs_stat
&& ( recursive
|| print_with_color
|| indicator_style != none
|| directories_first ) ) ;
if ( dired )
{
obstack_init ( & dired_obstack ) ;
obstack_init ( & subdired_obstack ) ;
}
cwd_n_alloc = 100 ;
cwd_file = xnmalloc ( cwd_n_alloc , sizeof *cwd_file ) ;
cwd_n_used = 0 ;
clear_files () ;
n_files = argc - i ;
if ( n_files <= 0 )
{
if ( immediate_dirs )
gobble_file ( lr_5 , directory , NOT_AN_INODE_NUMBER , true , lr_4 ) ;
else
queue_directory ( lr_5 , NULL , true ) ;
}
else
do
gobble_file ( argv [ i ++ ] , unknown , NOT_AN_INODE_NUMBER , true , lr_4 ) ;
while ( i < argc );
if ( cwd_n_used )
{
sort_files () ;
if ( ! immediate_dirs )
extract_dirs_from_files ( NULL , true ) ;
}
if ( cwd_n_used )
{
print_current_files () ;
if ( pending_dirs )
DIRED_PUTCHAR ( '\n' ) ;
}
else if ( n_files <= 1 && pending_dirs && pending_dirs -> next == 0 )
print_dir_name = false ;
while ( pending_dirs )
{
thispend = pending_dirs ;
pending_dirs = pending_dirs -> next ;
if ( LOOP_DETECT )
{
if ( thispend -> name == NULL )
{
struct dev_ino di = dev_ino_pop () ;
struct dev_ino * found = hash_delete ( active_dir_set , & di ) ;
assert ( found ) ;
dev_ino_free ( found ) ;
free_pending_ent ( thispend ) ;
continue;
}
}
print_dir ( thispend -> name , thispend -> realname ,
thispend -> command_line_arg ) ;
free_pending_ent ( thispend ) ;
print_dir_name = true ;
}
if ( print_with_color )
{
int j ;
if ( used_color )
{
if ( ! ( color_indicator [ C_LEFT ] . len == 2
&& memcmp ( color_indicator [ C_LEFT ] . string , lr_6 , 2 ) == 0
&& color_indicator [ C_RIGHT ] . len == 1
&& color_indicator [ C_RIGHT ] . string [ 0 ] == 'm' ) )
restore_default_color () ;
}
fflush ( stdout ) ;
#if SA_NOCLDSTOP
for ( j = 0 ; j < nsigs ; j ++ )
if ( sigismember ( & caught_signals , sig [ j ] ) )
signal ( sig [ j ] , SIG_DFL ) ;
#else
for ( j = 0 ; j < nsigs ; j ++ )
if ( caught_sig [ j ] )
signal ( sig [ j ] , SIG_DFL ) ;
#endif
for ( j = stop_signal_count ; j ; j -- )
raise ( SIGSTOP ) ;
j = interrupt_signal ;
if ( j )
raise ( j ) ;
}
if ( dired )
{
dired_dump_obstack ( lr_7 , & dired_obstack ) ;
dired_dump_obstack ( lr_8 , & subdired_obstack ) ;
printf ( lr_9 ,
quoting_style_args [ get_quoting_style ( filename_quoting_options ) ] ) ;
}
if ( LOOP_DETECT )
{
assert ( hash_get_n_entries ( active_dir_set ) == 0 ) ;
hash_free ( active_dir_set ) ;
}
exit ( exit_status ) ;
}
static int
decode_switches ( int argc , char * * argv )
{
char * time_style_option = NULL ;
bool sort_type_specified = false ;
bool kibibytes_specified = false ;
qmark_funny_chars = false ;
switch ( ls_mode )
{
case LS_MULTI_COL :
format = many_per_line ;
set_quoting_style ( NULL , escape_quoting_style ) ;
break;
case LS_LONG_FORMAT :
format = long_format ;
set_quoting_style ( NULL , escape_quoting_style ) ;
break;
case LS_LS :
if ( isatty ( STDOUT_FILENO ) )
{
format = many_per_line ;
qmark_funny_chars = true ;
}
else
{
format = one_per_line ;
qmark_funny_chars = false ;
}
break;
default:
abort () ;
}
time_type = time_mtime ;
sort_type = sort_name ;
sort_reverse = false ;
numeric_ids = false ;
print_block_size = false ;
indicator_style = none ;
print_inode = false ;
dereference = DEREF_UNDEFINED ;
recursive = false ;
immediate_dirs = false ;
ignore_mode = IGNORE_DEFAULT ;
ignore_patterns = NULL ;
hide_patterns = NULL ;
print_scontext = false ;
{
char const * q_style = getenv ( lr_10 ) ;
if ( q_style )
{
int i = ARGMATCH ( q_style , quoting_style_args , quoting_style_vals ) ;
if ( 0 <= i )
set_quoting_style ( NULL , quoting_style_vals [ i ] ) ;
else
error ( 0 , 0 ,
_ ( lr_11 ) ,
quotearg ( q_style ) ) ;
}
}
line_length = 80 ;
{
char const * p = getenv ( lr_12 ) ;
if ( p && * p )
{
unsigned long int tmp_ulong ;
if ( xstrtoul ( p , NULL , 0 , & tmp_ulong , NULL ) == LONGINT_OK
&& 0 < tmp_ulong && tmp_ulong <= SIZE_MAX )
{
line_length = tmp_ulong ;
}
else
{
error ( 0 , 0 ,
_ ( lr_13 ) ,
quotearg ( p ) ) ;
}
}
}
#ifdef TIOCGWINSZ
{
struct winsize ws ;
if ( ioctl ( STDOUT_FILENO , TIOCGWINSZ , & ws ) != - 1
&& 0 < ws . ws_col && ws . ws_col == ( size_t ) ws . ws_col )
line_length = ws . ws_col ;
}
#endif
{
char const * p = getenv ( lr_14 ) ;
tabsize = 8 ;
if ( p )
{
unsigned long int tmp_ulong ;
if ( xstrtoul ( p , NULL , 0 , & tmp_ulong , NULL ) == LONGINT_OK
&& tmp_ulong <= SIZE_MAX )
{
tabsize = tmp_ulong ;
}
else
{
error ( 0 , 0 ,
_ ( lr_15 ) ,
quotearg ( p ) ) ;
}
}
}
while ( true )
{
int oi = - 1 ;
int c = getopt_long ( argc , argv ,
lr_16 ,
long_options , & oi ) ;
if ( c == - 1 )
break;
switch ( c )
{
case 'a' :
ignore_mode = IGNORE_MINIMAL ;
break;
case 'b' :
set_quoting_style ( NULL , escape_quoting_style ) ;
break;
case 'c' :
time_type = time_ctime ;
break;
case 'd' :
immediate_dirs = true ;
break;
case 'f' :
ignore_mode = IGNORE_MINIMAL ;
sort_type = sort_none ;
sort_type_specified = true ;
if ( format == long_format )
format = ( isatty ( STDOUT_FILENO ) ? many_per_line : one_per_line ) ;
print_block_size = false ;
print_with_color = false ;
break;
case FILE_TYPE_INDICATOR_OPTION :
indicator_style = file_type ;
break;
case 'g' :
format = long_format ;
print_owner = false ;
break;
case 'h' :
file_human_output_opts = human_output_opts =
human_autoscale | human_SI | human_base_1024 ;
file_output_block_size = output_block_size = 1 ;
break;
case 'i' :
print_inode = true ;
break;
case 'k' :
kibibytes_specified = true ;
break;
case 'l' :
format = long_format ;
break;
case 'm' :
format = with_commas ;
break;
case 'n' :
numeric_ids = true ;
format = long_format ;
break;
case 'o' :
format = long_format ;
print_group = false ;
break;
case 'p' :
indicator_style = slash ;
break;
case 'q' :
qmark_funny_chars = true ;
break;
case 'r' :
sort_reverse = true ;
break;
case 's' :
print_block_size = true ;
break;
case 't' :
sort_type = sort_time ;
sort_type_specified = true ;
break;
case 'u' :
time_type = time_atime ;
break;
case 'v' :
sort_type = sort_version ;
sort_type_specified = true ;
break;
case 'w' :
{
unsigned long int tmp_ulong ;
if ( xstrtoul ( optarg , NULL , 0 , & tmp_ulong , NULL ) != LONGINT_OK
|| ! ( 0 < tmp_ulong && tmp_ulong <= SIZE_MAX ) )
error ( LS_FAILURE , 0 , _ ( lr_17 ) ,
quotearg ( optarg ) ) ;
line_length = tmp_ulong ;
break;
}
case 'x' :
format = horizontal ;
break;
case 'A' :
if ( ignore_mode == IGNORE_DEFAULT )
ignore_mode = IGNORE_DOT_AND_DOTDOT ;
break;
case 'B' :
add_ignore_pattern ( lr_18 ) ;
add_ignore_pattern ( lr_19 ) ;
break;
case 'C' :
format = many_per_line ;
break;
case 'D' :
dired = true ;
break;
case 'F' :
indicator_style = classify ;
break;
case 'G' :
print_group = false ;
break;
case 'H' :
dereference = DEREF_COMMAND_LINE_ARGUMENTS ;
break;
case DEREFERENCE_COMMAND_LINE_SYMLINK_TO_DIR_OPTION :
dereference = DEREF_COMMAND_LINE_SYMLINK_TO_DIR ;
break;
case 'I' :
add_ignore_pattern ( optarg ) ;
break;
case 'L' :
dereference = DEREF_ALWAYS ;
break;
case 'N' :
set_quoting_style ( NULL , literal_quoting_style ) ;
break;
case 'Q' :
set_quoting_style ( NULL , c_quoting_style ) ;
break;
case 'R' :
recursive = true ;
break;
case 'S' :
sort_type = sort_size ;
sort_type_specified = true ;
break;
case 'T' :
{
unsigned long int tmp_ulong ;
if ( xstrtoul ( optarg , NULL , 0 , & tmp_ulong , NULL ) != LONGINT_OK
|| SIZE_MAX < tmp_ulong )
error ( LS_FAILURE , 0 , _ ( lr_20 ) ,
quotearg ( optarg ) ) ;
tabsize = tmp_ulong ;
break;
}
case 'U' :
sort_type = sort_none ;
sort_type_specified = true ;
break;
case 'X' :
sort_type = sort_extension ;
sort_type_specified = true ;
break;
case '1' :
if ( format != long_format )
format = one_per_line ;
break;
case AUTHOR_OPTION :
print_author = true ;
break;
case HIDE_OPTION :
{
struct ignore_pattern * hide = xmalloc ( sizeof *hide ) ;
hide -> pattern = optarg ;
hide -> next = hide_patterns ;
hide_patterns = hide ;
}
break;
case SORT_OPTION :
sort_type = XARGMATCH ( lr_21 , optarg , sort_args , sort_types ) ;
sort_type_specified = true ;
break;
case GROUP_DIRECTORIES_FIRST_OPTION :
directories_first = true ;
break;
case TIME_OPTION :
time_type = XARGMATCH ( lr_22 , optarg , time_args , time_types ) ;
break;
case FORMAT_OPTION :
format = XARGMATCH ( lr_23 , optarg , format_args , format_types ) ;
break;
case FULL_TIME_OPTION :
format = long_format ;
time_style_option = bad_cast ( lr_24 ) ;
break;
case COLOR_OPTION :
{
int i ;
if ( optarg )
i = XARGMATCH ( lr_25 , optarg , color_args , color_types ) ;
else
i = color_always ;
print_with_color = ( i == color_always
|| ( i == color_if_tty
&& isatty ( STDOUT_FILENO ) ) ) ;
if ( print_with_color )
{
tabsize = 0 ;
}
break;
}
case INDICATOR_STYLE_OPTION :
indicator_style = XARGMATCH ( lr_26 , optarg ,
indicator_style_args ,
indicator_style_types ) ;
break;
case QUOTING_STYLE_OPTION :
set_quoting_style ( NULL ,
XARGMATCH ( lr_27 , optarg ,
quoting_style_args ,
quoting_style_vals ) ) ;
break;
case TIME_STYLE_OPTION :
time_style_option = optarg ;
break;
case SHOW_CONTROL_CHARS_OPTION :
qmark_funny_chars = false ;
break;
case BLOCK_SIZE_OPTION :
{
enum strtol_error e = human_options ( optarg , & human_output_opts ,
& output_block_size ) ;
if ( e != LONGINT_OK )
xstrtol_fatal ( e , oi , 0 , long_options , optarg ) ;
file_human_output_opts = human_output_opts ;
file_output_block_size = output_block_size ;
}
break;
case SI_OPTION :
file_human_output_opts = human_output_opts =
human_autoscale | human_SI ;
file_output_block_size = output_block_size = 1 ;
break;
case 'Z' :
print_scontext = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( LS_FAILURE ) ;
}
}
if ( ! output_block_size )
{
char const * ls_block_size = getenv ( lr_28 ) ;
human_options ( ls_block_size ,
& human_output_opts , & output_block_size ) ;
if ( ls_block_size || getenv ( lr_29 ) )
{
file_human_output_opts = human_output_opts ;
file_output_block_size = output_block_size ;
}
if ( kibibytes_specified )
{
human_output_opts = 0 ;
output_block_size = 1024 ;
}
}
max_idx = MAX ( 1 , line_length / MIN_COLUMN_WIDTH ) ;
filename_quoting_options = clone_quoting_options ( NULL ) ;
if ( get_quoting_style ( filename_quoting_options ) == escape_quoting_style )
set_char_quoting ( filename_quoting_options , ' ' , 1 ) ;
if ( file_type <= indicator_style )
{
char const * p ;
for ( p = & lr_30 [ indicator_style - file_type ] ; * p ; p ++ )
set_char_quoting ( filename_quoting_options , * p , 1 ) ;
}
dirname_quoting_options = clone_quoting_options ( NULL ) ;
set_char_quoting ( dirname_quoting_options , ':' , 1 ) ;
if ( dired && format != long_format )
dired = false ;
if ( ( time_type == time_ctime || time_type == time_atime )
&& ! sort_type_specified && format != long_format )
{
sort_type = sort_time ;
}
if ( format == long_format )
{
char * style = time_style_option ;
static char const posix_prefix [] = lr_31 ;
if ( ! style )
if ( ! ( style = getenv ( lr_32 ) ) )
style = bad_cast ( lr_33 ) ;
while ( STREQ_LEN ( style , posix_prefix , sizeof posix_prefix - 1 ) )
{
if ( ! hard_locale ( LC_TIME ) )
return optind ;
style += sizeof posix_prefix - 1 ;
}
if ( * style == '+' )
{
char * p0 = style + 1 ;
char * p1 = strchr ( p0 , '\n' ) ;
if ( ! p1 )
p1 = p0 ;
else
{
if ( strchr ( p1 + 1 , '\n' ) )
error ( LS_FAILURE , 0 , _ ( lr_34 ) ,
quote ( p0 ) ) ;
* p1 ++ = '\0' ;
}
long_time_format [ 0 ] = p0 ;
long_time_format [ 1 ] = p1 ;
}
else
{
ptrdiff_t res = argmatch ( style , time_style_args ,
( char const * ) time_style_types ,
sizeof ( * time_style_types ) ) ;
if ( res < 0 )
{
argmatch_invalid ( lr_35 , style , res ) ;
fputs ( _ ( lr_36 ) , stderr ) ;
char const * const * p = time_style_args ;
while ( * p )
fprintf ( stderr , lr_37 , * p ++ ) ;
fputs ( _ ( lr_38
lr_39 ) , stderr ) ;
usage ( LS_FAILURE ) ;
}
switch ( res )
{
case full_iso_time_style :
long_time_format [ 0 ] = long_time_format [ 1 ] =
lr_40 ;
break;
case long_iso_time_style :
long_time_format [ 0 ] = long_time_format [ 1 ] = lr_41 ;
break;
case iso_time_style :
long_time_format [ 0 ] = lr_42 ;
long_time_format [ 1 ] = lr_43 ;
break;
case locale_time_style :
if ( hard_locale ( LC_TIME ) )
{
int i ;
for ( i = 0 ; i < 2 ; i ++ )
long_time_format [ i ] =
dcgettext ( NULL , long_time_format [ i ] , LC_TIME ) ;
}
}
}
if ( strstr ( long_time_format [ 0 ] , lr_44 )
|| strstr ( long_time_format [ 1 ] , lr_44 ) )
if ( ! abmon_init () )
error ( 0 , 0 , _ ( lr_45 ) ) ;
}
return optind ;
}
static bool
get_funky_string ( char * * dest , const char * * src , bool equals_end ,
size_t * output_count )
{
char num ;
size_t count ;
enum {
ST_GND , ST_BACKSLASH , ST_OCTAL , ST_HEX , ST_CARET , ST_END , ST_ERROR
} state ;
const char * p ;
char * q ;
p = * src ;
q = * dest ;
count = 0 ;
num = 0 ;
state = ST_GND ;
while ( state < ST_END )
{
switch ( state )
{
case ST_GND :
switch ( * p )
{
case ':' :
case '\0' :
state = ST_END ;
break;
case '\\' :
state = ST_BACKSLASH ;
++ p ;
break;
case '^' :
state = ST_CARET ;
++ p ;
break;
case '=' :
if ( equals_end )
{
state = ST_END ;
break;
}
default:
* ( q ++ ) = * ( p ++ ) ;
++ count ;
break;
}
break;
case ST_BACKSLASH :
switch ( * p )
{
case '0' :
case '1' :
case '2' :
case '3' :
case '4' :
case '5' :
case '6' :
case '7' :
state = ST_OCTAL ;
num = * p - '0' ;
break;
case 'x' :
case 'X' :
state = ST_HEX ;
num = 0 ;
break;
case 'a' :
num = '\a' ;
break;
case 'b' :
num = '\b' ;
break;
case 'e' :
num = 27 ;
break;
case 'f' :
num = '\f' ;
break;
case 'n' :
num = '\n' ;
break;
case 'r' :
num = '\r' ;
break;
case 't' :
num = '\t' ;
break;
case 'v' :
num = '\v' ;
break;
case '?' :
num = 127 ;
break;
case '_' :
num = ' ' ;
break;
case '\0' :
state = ST_ERROR ;
break;
default:
num = * p ;
break;
}
if ( state == ST_BACKSLASH )
{
* ( q ++ ) = num ;
++ count ;
state = ST_GND ;
}
++ p ;
break;
case ST_OCTAL :
if ( * p < '0' || * p > '7' )
{
* ( q ++ ) = num ;
++ count ;
state = ST_GND ;
}
else
num = ( num << 3 ) + ( * ( p ++ ) - '0' ) ;
break;
case ST_HEX :
switch ( * p )
{
case '0' :
case '1' :
case '2' :
case '3' :
case '4' :
case '5' :
case '6' :
case '7' :
case '8' :
case '9' :
num = ( num << 4 ) + ( * ( p ++ ) - '0' ) ;
break;
case 'a' :
case 'b' :
case 'c' :
case 'd' :
case 'e' :
case 'f' :
num = ( num << 4 ) + ( * ( p ++ ) - 'a' ) + 10 ;
break;
case 'A' :
case 'B' :
case 'C' :
case 'D' :
case 'E' :
case 'F' :
num = ( num << 4 ) + ( * ( p ++ ) - 'A' ) + 10 ;
break;
default:
* ( q ++ ) = num ;
++ count ;
state = ST_GND ;
break;
}
break;
case ST_CARET :
state = ST_GND ;
if ( * p >= '@' && * p <= '~' )
{
* ( q ++ ) = * ( p ++ ) & 037 ;
++ count ;
}
else if ( * p == '?' )
{
* ( q ++ ) = 127 ;
++ count ;
}
else
state = ST_ERROR ;
break;
default:
abort () ;
}
}
* dest = q ;
* src = p ;
* output_count = count ;
return state != ST_ERROR ;
}
static void
parse_ls_color ( void )
{
const char * p ;
char * buf ;
int ind_no ;
char label [ 3 ] ;
struct color_ext_type * ext ;
if ( ( p = getenv ( lr_46 ) ) == NULL || * p == '\0' )
return;
ext = NULL ;
strcpy ( label , lr_47 ) ;
buf = color_buf = xstrdup ( p ) ;
enum parse_state state = PS_START ;
while ( true )
{
switch ( state )
{
case PS_START :
switch ( * p )
{
case ':' :
++ p ;
break;
case '*' :
ext = xmalloc ( sizeof *ext ) ;
ext -> next = color_ext_list ;
color_ext_list = ext ;
++ p ;
ext -> ext . string = buf ;
state = ( get_funky_string ( & buf , & p , true , & ext -> ext . len )
? PS_4 : PS_FAIL ) ;
break;
case '\0' :
state = PS_DONE ;
goto done;
default:
label [ 0 ] = * ( p ++ ) ;
state = PS_2 ;
break;
}
break;
case PS_2 :
if ( * p )
{
label [ 1 ] = * ( p ++ ) ;
state = PS_3 ;
}
else
state = PS_FAIL ;
break;
case PS_3 :
state = PS_FAIL ;
if ( * ( p ++ ) == '=' )
{
for ( ind_no = 0 ; indicator_name [ ind_no ] != NULL ; ++ ind_no )
{
if ( STREQ ( label , indicator_name [ ind_no ] ) )
{
color_indicator [ ind_no ] . string = buf ;
state = ( get_funky_string ( & buf , & p , false ,
& color_indicator [ ind_no ] . len )
? PS_START : PS_FAIL ) ;
break;
}
}
if ( state == PS_FAIL )
error ( 0 , 0 , _ ( lr_48 ) , quotearg ( label ) ) ;
}
break;
case PS_4 :
if ( * ( p ++ ) == '=' )
{
ext -> seq . string = buf ;
state = ( get_funky_string ( & buf , & p , false , & ext -> seq . len )
? PS_START : PS_FAIL ) ;
}
else
state = PS_FAIL ;
break;
case PS_FAIL :
goto done;
default:
abort () ;
}
}
done:
if ( state == PS_FAIL )
{
struct color_ext_type * e ;
struct color_ext_type * e2 ;
error ( 0 , 0 ,
_ ( lr_49 ) ) ;
free ( color_buf ) ;
for ( e = color_ext_list ; e != NULL ; )
{
e2 = e ;
e = e -> next ;
free ( e2 ) ;
}
print_with_color = false ;
}
if ( color_indicator [ C_LINK ] . len == 6
&& ! STRNCMP_LIT ( color_indicator [ C_LINK ] . string , lr_50 ) )
color_symlink_as_referent = true ;
}
static void
set_exit_status ( bool serious )
{
if ( serious )
exit_status = LS_FAILURE ;
else if ( exit_status == EXIT_SUCCESS )
exit_status = LS_MINOR_PROBLEM ;
}
static void
file_failure ( bool serious , char const * message , char const * file )
{
error ( 0 , errno , message , quotearg_colon ( file ) ) ;
set_exit_status ( serious ) ;
}
static void
queue_directory ( char const * name , char const * realname , bool command_line_arg )
{
struct pending * new = xmalloc ( sizeof *new ) ;
new -> realname = realname ? xstrdup ( realname ) : NULL ;
new -> name = name ? xstrdup ( name ) : NULL ;
new -> command_line_arg = command_line_arg ;
new -> next = pending_dirs ;
pending_dirs = new ;
}
static void
print_dir ( char const * name , char const * realname , bool command_line_arg )
{
DIR * dirp ;
struct dirent * next ;
uintmax_t total_blocks = 0 ;
static bool first = true ;
errno = 0 ;
dirp = opendir ( name ) ;
if ( ! dirp )
{
file_failure ( command_line_arg , _ ( lr_51 ) , name ) ;
return;
}
if ( LOOP_DETECT )
{
struct stat dir_stat ;
int fd = dirfd ( dirp ) ;
if ( ( 0 <= fd
? fstat ( fd , & dir_stat )
: stat ( name , & dir_stat ) ) < 0 )
{
file_failure ( command_line_arg ,
_ ( lr_52 ) , name ) ;
closedir ( dirp ) ;
return;
}
if ( visit_dir ( dir_stat . st_dev , dir_stat . st_ino ) )
{
error ( 0 , 0 , _ ( lr_53 ) ,
quotearg_colon ( name ) ) ;
closedir ( dirp ) ;
set_exit_status ( true ) ;
return;
}
dev_ino_push ( dir_stat . st_dev , dir_stat . st_ino ) ;
}
if ( recursive || print_dir_name )
{
if ( ! first )
DIRED_PUTCHAR ( '\n' ) ;
first = false ;
DIRED_INDENT () ;
PUSH_CURRENT_DIRED_POS ( & subdired_obstack ) ;
dired_pos += quote_name ( stdout , realname ? realname : name ,
dirname_quoting_options , NULL ) ;
PUSH_CURRENT_DIRED_POS ( & subdired_obstack ) ;
DIRED_FPUTS_LITERAL ( lr_54 , stdout ) ;
}
clear_files () ;
while ( 1 )
{
errno = 0 ;
next = readdir ( dirp ) ;
if ( next )
{
if ( ! file_ignored ( next -> d_name ) )
{
enum filetype type = unknown ;
#if HAVE_STRUCT_DIRENT_D_TYPE
switch ( next -> d_type )
{
case DT_BLK : type = blockdev ; break;
case DT_CHR : type = chardev ; break;
case DT_DIR : type = directory ; break;
case DT_FIFO : type = fifo ; break;
case DT_LNK : type = symbolic_link ; break;
case DT_REG : type = normal ; break;
case DT_SOCK : type = sock ; break;
# ifdef DT_WHT
case DT_WHT : type = whiteout ; break;
# endif
}
#endif
total_blocks += gobble_file ( next -> d_name , type ,
RELIABLE_D_INO ( next ) ,
false , name ) ;
if ( format == one_per_line && sort_type == sort_none
&& ! print_block_size && ! recursive )
{
sort_files () ;
print_current_files () ;
clear_files () ;
}
}
}
else if ( errno != 0 )
{
file_failure ( command_line_arg , _ ( lr_55 ) , name ) ;
if ( errno != EOVERFLOW )
break;
}
else
break;
process_signals () ;
}
if ( closedir ( dirp ) != 0 )
{
file_failure ( command_line_arg , _ ( lr_56 ) , name ) ;
}
sort_files () ;
if ( recursive )
extract_dirs_from_files ( name , false ) ;
if ( format == long_format || print_block_size )
{
const char * p ;
char buf [ LONGEST_HUMAN_READABLE + 1 ] ;
DIRED_INDENT () ;
p = _ ( lr_57 ) ;
DIRED_FPUTS ( p , stdout , strlen ( p ) ) ;
DIRED_PUTCHAR ( ' ' ) ;
p = human_readable ( total_blocks , buf , human_output_opts ,
ST_NBLOCKSIZE , output_block_size ) ;
DIRED_FPUTS ( p , stdout , strlen ( p ) ) ;
DIRED_PUTCHAR ( '\n' ) ;
}
if ( cwd_n_used )
print_current_files () ;
}
static void
add_ignore_pattern ( const char * pattern )
{
struct ignore_pattern * ignore ;
ignore = xmalloc ( sizeof *ignore ) ;
ignore -> pattern = pattern ;
ignore -> next = ignore_patterns ;
ignore_patterns = ignore ;
}
static bool
patterns_match ( struct ignore_pattern const * patterns , char const * file )
{
struct ignore_pattern const * p ;
for ( p = patterns ; p ; p = p -> next )
if ( fnmatch ( p -> pattern , file , FNM_PERIOD ) == 0 )
return true ;
return false ;
}
static bool
file_ignored ( char const * name )
{
return ( ( ignore_mode != IGNORE_MINIMAL
&& name [ 0 ] == '.'
&& ( ignore_mode == IGNORE_DEFAULT || ! name [ 1 + ( name [ 1 ] == '.' ) ] ) )
|| ( ignore_mode == IGNORE_DEFAULT
&& patterns_match ( hide_patterns , name ) )
|| patterns_match ( ignore_patterns , name ) ) ;
}
static uintmax_t
unsigned_file_size ( off_t size )
{
return size + ( size < 0 ) * ( ( uintmax_t ) OFF_T_MAX - OFF_T_MIN + 1 ) ;
}
static bool
has_capability ( char const * name )
{
char * result ;
bool has_cap ;
cap_t cap_d = cap_get_file ( name ) ;
if ( cap_d == NULL )
return false ;
result = cap_to_text ( cap_d , NULL ) ;
cap_free ( cap_d ) ;
if ( ! result )
return false ;
has_cap = ! ! * result ;
cap_free ( result ) ;
return has_cap ;
}
static bool
has_capability ( char const * name _GL_UNUSED )
{
errno = ENOTSUP ;
return false ;
}
static void
free_ent ( struct fileinfo * f )
{
free ( f -> name ) ;
free ( f -> linkname ) ;
if ( f -> scontext != UNKNOWN_SECURITY_CONTEXT )
{
if ( is_smack_enabled () )
free ( f -> scontext ) ;
else
freecon ( f -> scontext ) ;
}
}
static void
clear_files ( void )
{
size_t i ;
for ( i = 0 ; i < cwd_n_used ; i ++ )
{
struct fileinfo * f = sorted_file [ i ] ;
free_ent ( f ) ;
}
cwd_n_used = 0 ;
any_has_acl = false ;
inode_number_width = 0 ;
block_size_width = 0 ;
nlink_width = 0 ;
owner_width = 0 ;
group_width = 0 ;
author_width = 0 ;
scontext_width = 0 ;
major_device_number_width = 0 ;
minor_device_number_width = 0 ;
file_size_width = 0 ;
}
static bool
errno_unsupported ( int err )
{
return ( err == EINVAL
|| err == ENOSYS
|| err == ENOTSUP
|| err == EOPNOTSUPP ) ;
}
static int
getfilecon_cache ( char const * file , struct fileinfo * f , bool deref )
{
static dev_t unsupported_device ;
if ( f -> stat . st_dev == unsupported_device )
{
errno = ENOTSUP ;
return - 1 ;
}
int r = 0 ;
#ifdef HAVE_SMACK
if ( is_smack_enabled () )
r = smack_new_label_from_path ( file , lr_58 , deref ,
& f -> scontext ) ;
else
#endif
r = ( deref
? getfilecon ( file , & f -> scontext )
: lgetfilecon ( file , & f -> scontext ) ) ;
if ( r < 0 && errno_unsupported ( errno ) )
unsupported_device = f -> stat . st_dev ;
return r ;
}
static int
file_has_acl_cache ( char const * file , struct fileinfo * f )
{
static dev_t unsupported_device ;
if ( f -> stat . st_dev == unsupported_device )
{
errno = ENOTSUP ;
return 0 ;
}
errno = 0 ;
int n = file_has_acl ( file , & f -> stat ) ;
if ( n <= 0 && errno_unsupported ( errno ) )
unsupported_device = f -> stat . st_dev ;
return n ;
}
static bool
has_capability_cache ( char const * file , struct fileinfo * f )
{
static dev_t unsupported_device ;
if ( f -> stat . st_dev == unsupported_device )
{
errno = ENOTSUP ;
return 0 ;
}
bool b = has_capability ( file ) ;
if ( ! b && errno_unsupported ( errno ) )
unsupported_device = f -> stat . st_dev ;
return b ;
}
static uintmax_t
gobble_file ( char const * name , enum filetype type , ino_t inode ,
bool command_line_arg , char const * dirname )
{
uintmax_t blocks = 0 ;
struct fileinfo * f ;
assert ( ! command_line_arg || inode == NOT_AN_INODE_NUMBER ) ;
if ( cwd_n_used == cwd_n_alloc )
{
cwd_file = xnrealloc ( cwd_file , cwd_n_alloc , 2 * sizeof *cwd_file ) ;
cwd_n_alloc *= 2 ;
}
f = & cwd_file [ cwd_n_used ] ;
memset ( f , '\0' , sizeof *f ) ;
f -> stat . st_ino = inode ;
f -> filetype = type ;
if ( command_line_arg
|| format_needs_stat
|| ( type == directory && print_with_color
&& ( is_colored ( C_OTHER_WRITABLE )
|| is_colored ( C_STICKY )
|| is_colored ( C_STICKY_OTHER_WRITABLE ) ) )
|| ( ( print_inode || format_needs_type )
&& ( type == symbolic_link || type == unknown )
&& ( dereference == DEREF_ALWAYS
|| ( command_line_arg && dereference != DEREF_NEVER )
|| color_symlink_as_referent || check_symlink_color ) )
|| ( print_inode && inode == NOT_AN_INODE_NUMBER )
|| ( format_needs_type
&& ( type == unknown || command_line_arg
|| ( type == normal && ( indicator_style == classify
|| ( print_with_color
&& ( is_colored ( C_EXEC )
|| is_colored ( C_SETUID )
|| is_colored ( C_SETGID )
|| is_colored ( C_CAP ) ) )
) ) ) ) )
{
char * absolute_name ;
bool do_deref ;
int err ;
if ( name [ 0 ] == '/' || dirname [ 0 ] == 0 )
absolute_name = ( char * ) name ;
else
{
absolute_name = alloca ( strlen ( name ) + strlen ( dirname ) + 2 ) ;
attach ( absolute_name , dirname , name ) ;
}
switch ( dereference )
{
case DEREF_ALWAYS :
err = stat ( absolute_name , & f -> stat ) ;
do_deref = true ;
break;
case DEREF_COMMAND_LINE_ARGUMENTS :
case DEREF_COMMAND_LINE_SYMLINK_TO_DIR :
if ( command_line_arg )
{
bool need_lstat ;
err = stat ( absolute_name , & f -> stat ) ;
do_deref = true ;
if ( dereference == DEREF_COMMAND_LINE_ARGUMENTS )
break;
need_lstat = ( err < 0
? errno == ENOENT
: ! S_ISDIR ( f -> stat . st_mode ) ) ;
if ( ! need_lstat )
break;
}
default:
err = lstat ( absolute_name , & f -> stat ) ;
do_deref = false ;
break;
}
if ( err != 0 )
{
file_failure ( command_line_arg ,
_ ( lr_59 ) , absolute_name ) ;
if ( command_line_arg )
return 0 ;
f -> name = xstrdup ( name ) ;
cwd_n_used ++ ;
return 0 ;
}
f -> stat_ok = true ;
if ( ( type == normal || S_ISREG ( f -> stat . st_mode ) )
&& print_with_color && is_colored ( C_CAP ) )
f -> has_capability = has_capability_cache ( absolute_name , f ) ;
if ( format == long_format || print_scontext )
{
bool have_scontext = false ;
bool have_acl = false ;
int attr_len = getfilecon_cache ( absolute_name , f , do_deref ) ;
err = ( attr_len < 0 ) ;
if ( err == 0 )
{
if ( is_smack_enabled () )
have_scontext = ! STREQ ( lr_60 , f -> scontext ) ;
else
have_scontext = ! STREQ ( lr_61 , f -> scontext ) ;
}
else
{
f -> scontext = UNKNOWN_SECURITY_CONTEXT ;
if ( errno == ENOTSUP || errno == EOPNOTSUPP || errno == ENODATA )
err = 0 ;
}
if ( err == 0 && format == long_format )
{
int n = file_has_acl_cache ( absolute_name , f ) ;
err = ( n < 0 ) ;
have_acl = ( 0 < n ) ;
}
f -> acl_type = ( ! have_scontext && ! have_acl
? ACL_T_NONE
: ( have_scontext && ! have_acl
? ACL_T_SELINUX_ONLY
: ACL_T_YES ) ) ;
any_has_acl |= f -> acl_type != ACL_T_NONE ;
if ( err )
error ( 0 , errno , lr_62 , quotearg_colon ( absolute_name ) ) ;
}
if ( S_ISLNK ( f -> stat . st_mode )
&& ( format == long_format || check_symlink_color ) )
{
struct stat linkstats ;
get_link_name ( absolute_name , f , command_line_arg ) ;
char * linkname = make_link_name ( absolute_name , f -> linkname ) ;
if ( linkname
&& ( file_type <= indicator_style || check_symlink_color )
&& stat ( linkname , & linkstats ) == 0 )
{
f -> linkok = true ;
if ( ! command_line_arg || format == long_format
|| ! S_ISDIR ( linkstats . st_mode ) )
{
f -> linkmode = linkstats . st_mode ;
}
}
free ( linkname ) ;
}
if ( S_ISLNK ( f -> stat . st_mode ) )
f -> filetype = symbolic_link ;
else if ( S_ISDIR ( f -> stat . st_mode ) )
{
if ( command_line_arg && ! immediate_dirs )
f -> filetype = arg_directory ;
else
f -> filetype = directory ;
}
else
f -> filetype = normal ;
blocks = ST_NBLOCKS ( f -> stat ) ;
if ( format == long_format || print_block_size )
{
char buf [ LONGEST_HUMAN_READABLE + 1 ] ;
int len = mbswidth ( human_readable ( blocks , buf , human_output_opts ,
ST_NBLOCKSIZE , output_block_size ) ,
0 ) ;
if ( block_size_width < len )
block_size_width = len ;
}
if ( format == long_format )
{
if ( print_owner )
{
int len = format_user_width ( f -> stat . st_uid ) ;
if ( owner_width < len )
owner_width = len ;
}
if ( print_group )
{
int len = format_group_width ( f -> stat . st_gid ) ;
if ( group_width < len )
group_width = len ;
}
if ( print_author )
{
int len = format_user_width ( f -> stat . st_author ) ;
if ( author_width < len )
author_width = len ;
}
}
if ( print_scontext )
{
int len = strlen ( f -> scontext ) ;
if ( scontext_width < len )
scontext_width = len ;
}
if ( format == long_format )
{
char b [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
int b_len = strlen ( umaxtostr ( f -> stat . st_nlink , b ) ) ;
if ( nlink_width < b_len )
nlink_width = b_len ;
if ( S_ISCHR ( f -> stat . st_mode ) || S_ISBLK ( f -> stat . st_mode ) )
{
char buf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
int len = strlen ( umaxtostr ( major ( f -> stat . st_rdev ) , buf ) ) ;
if ( major_device_number_width < len )
major_device_number_width = len ;
len = strlen ( umaxtostr ( minor ( f -> stat . st_rdev ) , buf ) ) ;
if ( minor_device_number_width < len )
minor_device_number_width = len ;
len = major_device_number_width + 2 + minor_device_number_width ;
if ( file_size_width < len )
file_size_width = len ;
}
else
{
char buf [ LONGEST_HUMAN_READABLE + 1 ] ;
uintmax_t size = unsigned_file_size ( f -> stat . st_size ) ;
int len = mbswidth ( human_readable ( size , buf ,
file_human_output_opts ,
1 , file_output_block_size ) ,
0 ) ;
if ( file_size_width < len )
file_size_width = len ;
}
}
}
if ( print_inode )
{
char buf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
int len = strlen ( umaxtostr ( f -> stat . st_ino , buf ) ) ;
if ( inode_number_width < len )
inode_number_width = len ;
}
f -> name = xstrdup ( name ) ;
cwd_n_used ++ ;
return blocks ;
}
static bool
is_directory ( const struct fileinfo * f )
{
return f -> filetype == directory || f -> filetype == arg_directory ;
}
static void
get_link_name ( char const * filename , struct fileinfo * f , bool command_line_arg )
{
f -> linkname = areadlink_with_size ( filename , f -> stat . st_size ) ;
if ( f -> linkname == NULL )
file_failure ( command_line_arg , _ ( lr_63 ) ,
filename ) ;
}
static char *
make_link_name ( char const * name , char const * linkname )
{
if ( ! linkname )
return NULL ;
if ( IS_ABSOLUTE_FILE_NAME ( linkname ) )
return xstrdup ( linkname ) ;
size_t prefix_len = dir_len ( name ) ;
if ( prefix_len == 0 )
return xstrdup ( linkname ) ;
char * p = xmalloc ( prefix_len + 1 + strlen ( linkname ) + 1 ) ;
if ( ! ISSLASH ( name [ prefix_len - 1 ] ) )
++ prefix_len ;
stpcpy ( stpncpy ( p , name , prefix_len ) , linkname ) ;
return p ;
}
static bool
basename_is_dot_or_dotdot ( const char * name )
{
char const * base = last_component ( name ) ;
return dot_or_dotdot ( base ) ;
}
static void
extract_dirs_from_files ( char const * dirname , bool command_line_arg )
{
size_t i ;
size_t j ;
bool ignore_dot_and_dot_dot = ( dirname != NULL ) ;
if ( dirname && LOOP_DETECT )
{
queue_directory ( NULL , dirname , false ) ;
}
for ( i = cwd_n_used ; i -- != 0 ; )
{
struct fileinfo * f = sorted_file [ i ] ;
if ( is_directory ( f )
&& ( ! ignore_dot_and_dot_dot
|| ! basename_is_dot_or_dotdot ( f -> name ) ) )
{
if ( ! dirname || f -> name [ 0 ] == '/' )
queue_directory ( f -> name , f -> linkname , command_line_arg ) ;
else
{
char * name = file_name_concat ( dirname , f -> name , NULL ) ;
queue_directory ( name , f -> linkname , command_line_arg ) ;
free ( name ) ;
}
if ( f -> filetype == arg_directory )
free_ent ( f ) ;
}
}
for ( i = 0 , j = 0 ; i < cwd_n_used ; i ++ )
{
struct fileinfo * f = sorted_file [ i ] ;
sorted_file [ j ] = f ;
j += ( f -> filetype != arg_directory ) ;
}
cwd_n_used = j ;
}
static int
xstrcoll ( char const * a , char const * b )
{
int diff ;
errno = 0 ;
diff = strcoll ( a , b ) ;
if ( errno )
{
error ( 0 , errno , _ ( lr_64 ) ,
quote_n ( 0 , a ) , quote_n ( 1 , b ) ) ;
set_exit_status ( false ) ;
longjmp ( failed_strcoll , 1 ) ;
}
return diff ;
}
static inline int
cmp_ctime ( struct fileinfo const * a , struct fileinfo const * b ,
int (* cmp) ( char const * , char const * ) )
{
int diff = timespec_cmp ( get_stat_ctime ( & b -> stat ) ,
get_stat_ctime ( & a -> stat ) ) ;
return diff ? diff : cmp ( a -> name , b -> name ) ;
}
static inline int
cmp_mtime ( struct fileinfo const * a , struct fileinfo const * b ,
int (* cmp) ( char const * , char const * ) )
{
int diff = timespec_cmp ( get_stat_mtime ( & b -> stat ) ,
get_stat_mtime ( & a -> stat ) ) ;
return diff ? diff : cmp ( a -> name , b -> name ) ;
}
static inline int
cmp_atime ( struct fileinfo const * a , struct fileinfo const * b ,
int (* cmp) ( char const * , char const * ) )
{
int diff = timespec_cmp ( get_stat_atime ( & b -> stat ) ,
get_stat_atime ( & a -> stat ) ) ;
return diff ? diff : cmp ( a -> name , b -> name ) ;
}
static inline int
cmp_size ( struct fileinfo const * a , struct fileinfo const * b ,
int (* cmp) ( char const * , char const * ) )
{
int diff = longdiff ( b -> stat . st_size , a -> stat . st_size ) ;
return diff ? diff : cmp ( a -> name , b -> name ) ;
}
static inline int
cmp_name ( struct fileinfo const * a , struct fileinfo const * b ,
int (* cmp) ( char const * , char const * ) )
{
return cmp ( a -> name , b -> name ) ;
}
static inline int
cmp_extension ( struct fileinfo const * a , struct fileinfo const * b ,
int (* cmp) ( char const * , char const * ) )
{
char const * base1 = strrchr ( a -> name , '.' ) ;
char const * base2 = strrchr ( b -> name , '.' ) ;
int diff = cmp ( base1 ? base1 : lr_4 , base2 ? base2 : lr_4 ) ;
return diff ? diff : cmp ( a -> name , b -> name ) ;
}
static inline int
cmp_version ( struct fileinfo const * a , struct fileinfo const * b )
{
return filevercmp ( a -> name , b -> name ) ;
}
static int xstrcoll_version ( V a , V b )
{ return cmp_version ( a , b ) ; }
static int rev_xstrcoll_version ( V a , V b )
{ return cmp_version ( b , a ) ; }
static int xstrcoll_df_version ( V a , V b )
{ DIRFIRST_CHECK ( a , b ) ; return cmp_version ( a , b ) ; }
static int rev_xstrcoll_df_version ( V a , V b )
{ DIRFIRST_CHECK ( a , b ) ; return cmp_version ( b , a ) ; }
static void
initialize_ordering_vector ( void )
{
size_t i ;
for ( i = 0 ; i < cwd_n_used ; i ++ )
sorted_file [ i ] = & cwd_file [ i ] ;
}
static void
sort_files ( void )
{
bool use_strcmp ;
if ( sorted_file_alloc < cwd_n_used + cwd_n_used / 2 )
{
free ( sorted_file ) ;
sorted_file = xnmalloc ( cwd_n_used , 3 * sizeof *sorted_file ) ;
sorted_file_alloc = 3 * cwd_n_used ;
}
initialize_ordering_vector () ;
if ( sort_type == sort_none )
return;
if ( ! setjmp ( failed_strcoll ) )
use_strcmp = false ;
else
{
use_strcmp = true ;
assert ( sort_type != sort_version ) ;
initialize_ordering_vector () ;
}
mpsort ( ( void const * * ) sorted_file , cwd_n_used ,
sort_functions [ sort_type + ( sort_type == sort_time ? time_type : 0 ) ]
[ use_strcmp ] [ sort_reverse ]
[ directories_first ] ) ;
}
static void
print_current_files ( void )
{
size_t i ;
switch ( format )
{
case one_per_line :
for ( i = 0 ; i < cwd_n_used ; i ++ )
{
print_file_name_and_frills ( sorted_file [ i ] , 0 ) ;
putchar ( '\n' ) ;
}
break;
case many_per_line :
print_many_per_line () ;
break;
case horizontal :
print_horizontal () ;
break;
case with_commas :
print_with_commas () ;
break;
case long_format :
for ( i = 0 ; i < cwd_n_used ; i ++ )
{
set_normal_color () ;
print_long_format ( sorted_file [ i ] ) ;
DIRED_PUTCHAR ( '\n' ) ;
}
break;
}
}
static size_t
align_nstrftime ( char * buf , size_t size , char const * fmt , struct tm const * tm ,
int __utc , int __ns )
{
const char * nfmt = fmt ;
char rpl_fmt [ sizeof ( abmon [ 0 ] ) + 100 ] ;
const char * pb ;
if ( required_mon_width && ( pb = strstr ( fmt , lr_44 ) ) )
{
if ( strlen ( fmt ) < ( sizeof ( rpl_fmt ) - sizeof ( abmon [ 0 ] ) + 2 ) )
{
char * pfmt = rpl_fmt ;
nfmt = rpl_fmt ;
pfmt = mempcpy ( pfmt , fmt , pb - fmt ) ;
pfmt = stpcpy ( pfmt , abmon [ tm -> tm_mon ] ) ;
strcpy ( pfmt , pb + 2 ) ;
}
}
size_t ret = nstrftime ( buf , size , nfmt , tm , __utc , __ns ) ;
return ret ;
}
static int
long_time_expected_width ( void )
{
static int width = - 1 ;
if ( width < 0 )
{
time_t epoch = 0 ;
struct tm const * tm = localtime ( & epoch ) ;
char buf [ TIME_STAMP_LEN_MAXIMUM + 1 ] ;
if ( tm )
{
size_t len =
align_nstrftime ( buf , sizeof buf , long_time_format [ 0 ] , tm , 0 , 0 ) ;
if ( len != 0 )
width = mbsnwidth ( buf , len , 0 ) ;
}
if ( width < 0 )
width = 0 ;
}
return width ;
}
static void
format_user_or_group ( char const * name , unsigned long int id , int width )
{
size_t len ;
if ( name )
{
int width_gap = width - mbswidth ( name , 0 ) ;
int pad = MAX ( 0 , width_gap ) ;
fputs ( name , stdout ) ;
len = strlen ( name ) + pad ;
do
putchar ( ' ' ) ;
while ( pad -- );
}
else
{
printf ( lr_65 , width , id ) ;
len = width ;
}
dired_pos += len + 1 ;
}
static void
format_user ( uid_t u , int width , bool stat_ok )
{
format_user_or_group ( ! stat_ok ? lr_66 :
( numeric_ids ? NULL : getuser ( u ) ) , u , width ) ;
}
static void
format_group ( gid_t g , int width , bool stat_ok )
{
format_user_or_group ( ! stat_ok ? lr_66 :
( numeric_ids ? NULL : getgroup ( g ) ) , g , width ) ;
}
static int
format_user_or_group_width ( char const * name , unsigned long int id )
{
if ( name )
{
int len = mbswidth ( name , 0 ) ;
return MAX ( 0 , len ) ;
}
else
{
char buf [ INT_BUFSIZE_BOUND ( id ) ] ;
sprintf ( buf , lr_67 , id ) ;
return strlen ( buf ) ;
}
}
static int
format_user_width ( uid_t u )
{
return format_user_or_group_width ( numeric_ids ? NULL : getuser ( u ) , u ) ;
}
static int
format_group_width ( gid_t g )
{
return format_user_or_group_width ( numeric_ids ? NULL : getgroup ( g ) , g ) ;
}
static char *
format_inode ( char * buf , size_t buflen , const struct fileinfo * f )
{
assert ( INT_BUFSIZE_BOUND ( uintmax_t ) <= buflen ) ;
return ( f -> stat_ok && f -> stat . st_ino != NOT_AN_INODE_NUMBER
? umaxtostr ( f -> stat . st_ino , buf )
: ( char * ) lr_66 ) ;
}
static void
print_long_format ( const struct fileinfo * f )
{
char modebuf [ 12 ] ;
char buf
[ LONGEST_HUMAN_READABLE + 1
+ LONGEST_HUMAN_READABLE + 1
+ sizeof ( modebuf ) - 1 + 1
+ INT_BUFSIZE_BOUND ( uintmax_t )
+ LONGEST_HUMAN_READABLE + 2
+ LONGEST_HUMAN_READABLE + 1
+ TIME_STAMP_LEN_MAXIMUM + 1
] ;
size_t s ;
char * p ;
struct timespec when_timespec ;
struct tm * when_local ;
if ( f -> stat_ok )
filemodestring ( & f -> stat , modebuf ) ;
else
{
modebuf [ 0 ] = filetype_letter [ f -> filetype ] ;
memset ( modebuf + 1 , '?' , 10 ) ;
modebuf [ 11 ] = '\0' ;
}
if ( ! any_has_acl )
modebuf [ 10 ] = '\0' ;
else if ( f -> acl_type == ACL_T_SELINUX_ONLY )
modebuf [ 10 ] = '.' ;
else if ( f -> acl_type == ACL_T_YES )
modebuf [ 10 ] = '+' ;
switch ( time_type )
{
case time_ctime :
when_timespec = get_stat_ctime ( & f -> stat ) ;
break;
case time_mtime :
when_timespec = get_stat_mtime ( & f -> stat ) ;
break;
case time_atime :
when_timespec = get_stat_atime ( & f -> stat ) ;
break;
default:
abort () ;
}
p = buf ;
if ( print_inode )
{
char hbuf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
sprintf ( p , lr_68 , inode_number_width ,
format_inode ( hbuf , sizeof hbuf , f ) ) ;
p += strlen ( p ) ;
}
if ( print_block_size )
{
char hbuf [ LONGEST_HUMAN_READABLE + 1 ] ;
char const * blocks =
( ! f -> stat_ok
? lr_66
: human_readable ( ST_NBLOCKS ( f -> stat ) , hbuf , human_output_opts ,
ST_NBLOCKSIZE , output_block_size ) ) ;
int pad ;
for ( pad = block_size_width - mbswidth ( blocks , 0 ) ; 0 < pad ; pad -- )
* p ++ = ' ' ;
while ( ( * p ++ = * blocks ++ ) )
continue;
p [ - 1 ] = ' ' ;
}
{
char hbuf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
sprintf ( p , lr_69 , modebuf , nlink_width ,
! f -> stat_ok ? lr_66 : umaxtostr ( f -> stat . st_nlink , hbuf ) ) ;
}
p += strlen ( p ) ;
DIRED_INDENT () ;
if ( print_owner || print_group || print_author || print_scontext )
{
DIRED_FPUTS ( buf , stdout , p - buf ) ;
if ( print_owner )
format_user ( f -> stat . st_uid , owner_width , f -> stat_ok ) ;
if ( print_group )
format_group ( f -> stat . st_gid , group_width , f -> stat_ok ) ;
if ( print_author )
format_user ( f -> stat . st_author , author_width , f -> stat_ok ) ;
if ( print_scontext )
format_user_or_group ( f -> scontext , 0 , scontext_width ) ;
p = buf ;
}
if ( f -> stat_ok
&& ( S_ISCHR ( f -> stat . st_mode ) || S_ISBLK ( f -> stat . st_mode ) ) )
{
char majorbuf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
char minorbuf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
int blanks_width = ( file_size_width
- ( major_device_number_width + 2
+ minor_device_number_width ) ) ;
sprintf ( p , lr_70 ,
major_device_number_width + MAX ( 0 , blanks_width ) ,
umaxtostr ( major ( f -> stat . st_rdev ) , majorbuf ) ,
minor_device_number_width ,
umaxtostr ( minor ( f -> stat . st_rdev ) , minorbuf ) ) ;
p += file_size_width + 1 ;
}
else
{
char hbuf [ LONGEST_HUMAN_READABLE + 1 ] ;
char const * size =
( ! f -> stat_ok
? lr_66
: human_readable ( unsigned_file_size ( f -> stat . st_size ) ,
hbuf , file_human_output_opts , 1 ,
file_output_block_size ) ) ;
int pad ;
for ( pad = file_size_width - mbswidth ( size , 0 ) ; 0 < pad ; pad -- )
* p ++ = ' ' ;
while ( ( * p ++ = * size ++ ) )
continue;
p [ - 1 ] = ' ' ;
}
when_local = localtime ( & when_timespec . tv_sec ) ;
s = 0 ;
* p = '\1' ;
if ( f -> stat_ok && when_local )
{
struct timespec six_months_ago ;
bool recent ;
char const * fmt ;
if ( timespec_cmp ( current_time , when_timespec ) < 0 )
{
gettime ( & current_time ) ;
}
six_months_ago . tv_sec = current_time . tv_sec - 31556952 / 2 ;
six_months_ago . tv_nsec = current_time . tv_nsec ;
recent = ( timespec_cmp ( six_months_ago , when_timespec ) < 0
&& ( timespec_cmp ( when_timespec , current_time ) < 0 ) ) ;
fmt = long_time_format [ recent ] ;
s = align_nstrftime ( p , TIME_STAMP_LEN_MAXIMUM + 1 , fmt ,
when_local , 0 , when_timespec . tv_nsec ) ;
}
if ( s || ! * p )
{
p += s ;
* p ++ = ' ' ;
* p = '\0' ;
}
else
{
char hbuf [ INT_BUFSIZE_BOUND ( intmax_t ) ] ;
sprintf ( p , lr_68 , long_time_expected_width () ,
( ! f -> stat_ok
? lr_66
: timetostr ( when_timespec . tv_sec , hbuf ) ) ) ;
p += strlen ( p ) ;
}
DIRED_FPUTS ( buf , stdout , p - buf ) ;
size_t w = print_name_with_quoting ( f , false , & dired_obstack , p - buf ) ;
if ( f -> filetype == symbolic_link )
{
if ( f -> linkname )
{
DIRED_FPUTS_LITERAL ( lr_71 , stdout ) ;
print_name_with_quoting ( f , true , NULL , ( p - buf ) + w + 4 ) ;
if ( indicator_style != none )
print_type_indicator ( true , f -> linkmode , unknown ) ;
}
}
else if ( indicator_style != none )
print_type_indicator ( f -> stat_ok , f -> stat . st_mode , f -> filetype ) ;
}
static size_t
quote_name ( FILE * out , const char * name , struct quoting_options const * options ,
size_t * width )
{
char smallbuf [ BUFSIZ ] ;
size_t len = quotearg_buffer ( smallbuf , sizeof smallbuf , name , - 1 , options ) ;
char * buf ;
size_t displayed_width IF_LINT ( = 0 ) ;
if ( len < sizeof smallbuf )
buf = smallbuf ;
else
{
buf = alloca ( len + 1 ) ;
quotearg_buffer ( buf , len + 1 , name , - 1 , options ) ;
}
if ( qmark_funny_chars )
{
if ( MB_CUR_MAX > 1 )
{
char const * p = buf ;
char const * plimit = buf + len ;
char * q = buf ;
displayed_width = 0 ;
while ( p < plimit )
switch ( * p )
{
case ' ' : case '!' : case '"' : case '#' : case '%' :
case '&' : case '\'' : case '(' : case ')' : case '*' :
case '+' : case ',' : case '-' : case '.' : case '/' :
case '0' : case '1' : case '2' : case '3' : case '4' :
case '5' : case '6' : case '7' : case '8' : case '9' :
case ':' : case ';' : case '<' : case '=' : case '>' :
case '?' :
case 'A' : case 'B' : case 'C' : case 'D' : case 'E' :
case 'F' : case 'G' : case 'H' : case 'I' : case 'J' :
case 'K' : case 'L' : case 'M' : case 'N' : case 'O' :
case 'P' : case 'Q' : case 'R' : case 'S' : case 'T' :
case 'U' : case 'V' : case 'W' : case 'X' : case 'Y' :
case 'Z' :
case '[' : case '\\' : case ']' : case '^' : case '_' :
case 'a' : case 'b' : case 'c' : case 'd' : case 'e' :
case 'f' : case 'g' : case 'h' : case 'i' : case 'j' :
case 'k' : case 'l' : case 'm' : case 'n' : case 'o' :
case 'p' : case 'q' : case 'r' : case 's' : case 't' :
case 'u' : case 'v' : case 'w' : case 'x' : case 'y' :
case 'z' : case '{' : case '|' : case '}' : case '~' :
* q ++ = * p ++ ;
displayed_width += 1 ;
break;
default:
{
mbstate_t mbstate = { 0 , } ;
do
{
wchar_t wc ;
size_t bytes ;
int w ;
bytes = mbrtowc ( & wc , p , plimit - p , & mbstate ) ;
if ( bytes == ( size_t ) - 1 )
{
p ++ ;
* q ++ = '?' ;
displayed_width += 1 ;
break;
}
if ( bytes == ( size_t ) - 2 )
{
p = plimit ;
* q ++ = '?' ;
displayed_width += 1 ;
break;
}
if ( bytes == 0 )
bytes = 1 ;
w = wcwidth ( wc ) ;
if ( w >= 0 )
{
for (; bytes > 0 ; -- bytes )
* q ++ = * p ++ ;
displayed_width += w ;
}
else
{
p += bytes ;
* q ++ = '?' ;
displayed_width += 1 ;
}
}
while ( ! mbsinit ( & mbstate ) );
}
break;
}
len = q - buf ;
}
else
{
char * p = buf ;
char const * plimit = buf + len ;
while ( p < plimit )
{
if ( ! isprint ( to_uchar ( * p ) ) )
* p = '?' ;
p ++ ;
}
displayed_width = len ;
}
}
else if ( width != NULL )
{
if ( MB_CUR_MAX > 1 )
displayed_width = mbsnwidth ( buf , len , 0 ) ;
else
{
char const * p = buf ;
char const * plimit = buf + len ;
displayed_width = 0 ;
while ( p < plimit )
{
if ( isprint ( to_uchar ( * p ) ) )
displayed_width ++ ;
p ++ ;
}
}
}
if ( out != NULL )
fwrite ( buf , 1 , len , out ) ;
if ( width != NULL )
* width = displayed_width ;
return len ;
}
static size_t
print_name_with_quoting ( const struct fileinfo * f ,
bool symlink_target ,
struct obstack * stack ,
size_t start_col )
{
const char * name = symlink_target ? f -> linkname : f -> name ;
bool used_color_this_time
= ( print_with_color
&& ( print_color_indicator ( f , symlink_target )
|| is_colored ( C_NORM ) ) ) ;
if ( stack )
PUSH_CURRENT_DIRED_POS ( stack ) ;
size_t width = quote_name ( stdout , name , filename_quoting_options , NULL ) ;
dired_pos += width ;
if ( stack )
PUSH_CURRENT_DIRED_POS ( stack ) ;
process_signals () ;
if ( used_color_this_time )
{
prep_non_filename_text () ;
if ( start_col / line_length != ( start_col + width - 1 ) / line_length )
put_indicator ( & color_indicator [ C_CLR_TO_EOL ] ) ;
}
return width ;
}
static void
prep_non_filename_text ( void )
{
if ( color_indicator [ C_END ] . string != NULL )
put_indicator ( & color_indicator [ C_END ] ) ;
else
{
put_indicator ( & color_indicator [ C_LEFT ] ) ;
put_indicator ( & color_indicator [ C_RESET ] ) ;
put_indicator ( & color_indicator [ C_RIGHT ] ) ;
}
}
static size_t
print_file_name_and_frills ( const struct fileinfo * f , size_t start_col )
{
char buf [ MAX ( LONGEST_HUMAN_READABLE + 1 , INT_BUFSIZE_BOUND ( uintmax_t ) ) ] ;
set_normal_color () ;
if ( print_inode )
printf ( lr_68 , format == with_commas ? 0 : inode_number_width ,
format_inode ( buf , sizeof buf , f ) ) ;
if ( print_block_size )
printf ( lr_68 , format == with_commas ? 0 : block_size_width ,
! f -> stat_ok ? lr_66
: human_readable ( ST_NBLOCKS ( f -> stat ) , buf , human_output_opts ,
ST_NBLOCKSIZE , output_block_size ) ) ;
if ( print_scontext )
printf ( lr_68 , format == with_commas ? 0 : scontext_width , f -> scontext ) ;
size_t width = print_name_with_quoting ( f , false , NULL , start_col ) ;
if ( indicator_style != none )
width += print_type_indicator ( f -> stat_ok , f -> stat . st_mode , f -> filetype ) ;
return width ;
}
static char
get_type_indicator ( bool stat_ok , mode_t mode , enum filetype type )
{
char c ;
if ( stat_ok ? S_ISREG ( mode ) : type == normal )
{
if ( stat_ok && indicator_style == classify && ( mode & S_IXUGO ) )
c = '*' ;
else
c = 0 ;
}
else
{
if ( stat_ok ? S_ISDIR ( mode ) : type == directory || type == arg_directory )
c = '/' ;
else if ( indicator_style == slash )
c = 0 ;
else if ( stat_ok ? S_ISLNK ( mode ) : type == symbolic_link )
c = '@' ;
else if ( stat_ok ? S_ISFIFO ( mode ) : type == fifo )
c = '|' ;
else if ( stat_ok ? S_ISSOCK ( mode ) : type == sock )
c = '=' ;
else if ( stat_ok && S_ISDOOR ( mode ) )
c = '>' ;
else
c = 0 ;
}
return c ;
}
static bool
print_type_indicator ( bool stat_ok , mode_t mode , enum filetype type )
{
char c = get_type_indicator ( stat_ok , mode , type ) ;
if ( c )
DIRED_PUTCHAR ( c ) ;
return ! ! c ;
}
static bool
print_color_indicator ( const struct fileinfo * f , bool symlink_target )
{
enum indicator_no type ;
struct color_ext_type * ext ;
size_t len ;
const char * name ;
mode_t mode ;
int linkok ;
if ( symlink_target )
{
name = f -> linkname ;
mode = f -> linkmode ;
linkok = f -> linkok ? 0 : - 1 ;
}
else
{
name = f -> name ;
mode = FILE_OR_LINK_MODE ( f ) ;
linkok = f -> linkok ;
}
if ( linkok == - 1 && is_colored ( C_MISSING ) )
type = C_MISSING ;
else if ( ! f -> stat_ok )
{
static enum indicator_no filetype_indicator [] = FILETYPE_INDICATORS ;
type = filetype_indicator [ f -> filetype ] ;
}
else
{
if ( S_ISREG ( mode ) )
{
type = C_FILE ;
if ( ( mode & S_ISUID ) != 0 && is_colored ( C_SETUID ) )
type = C_SETUID ;
else if ( ( mode & S_ISGID ) != 0 && is_colored ( C_SETGID ) )
type = C_SETGID ;
else if ( is_colored ( C_CAP ) && f -> has_capability )
type = C_CAP ;
else if ( ( mode & S_IXUGO ) != 0 && is_colored ( C_EXEC ) )
type = C_EXEC ;
else if ( ( 1 < f -> stat . st_nlink ) && is_colored ( C_MULTIHARDLINK ) )
type = C_MULTIHARDLINK ;
}
else if ( S_ISDIR ( mode ) )
{
type = C_DIR ;
if ( ( mode & S_ISVTX ) && ( mode & S_IWOTH )
&& is_colored ( C_STICKY_OTHER_WRITABLE ) )
type = C_STICKY_OTHER_WRITABLE ;
else if ( ( mode & S_IWOTH ) != 0 && is_colored ( C_OTHER_WRITABLE ) )
type = C_OTHER_WRITABLE ;
else if ( ( mode & S_ISVTX ) != 0 && is_colored ( C_STICKY ) )
type = C_STICKY ;
}
else if ( S_ISLNK ( mode ) )
type = C_LINK ;
else if ( S_ISFIFO ( mode ) )
type = C_FIFO ;
else if ( S_ISSOCK ( mode ) )
type = C_SOCK ;
else if ( S_ISBLK ( mode ) )
type = C_BLK ;
else if ( S_ISCHR ( mode ) )
type = C_CHR ;
else if ( S_ISDOOR ( mode ) )
type = C_DOOR ;
else
{
type = C_ORPHAN ;
}
}
ext = NULL ;
if ( type == C_FILE )
{
len = strlen ( name ) ;
name += len ;
for ( ext = color_ext_list ; ext != NULL ; ext = ext -> next )
{
if ( ext -> ext . len <= len
&& STREQ_LEN ( name - ext -> ext . len , ext -> ext . string ,
ext -> ext . len ) )
break;
}
}
if ( type == C_LINK && ! linkok )
{
if ( color_symlink_as_referent || is_colored ( C_ORPHAN ) )
type = C_ORPHAN ;
}
{
const struct bin_str * const s
= ext ? & ( ext -> seq ) : & color_indicator [ type ] ;
if ( s -> string != NULL )
{
if ( is_colored ( C_NORM ) )
restore_default_color () ;
put_indicator ( & color_indicator [ C_LEFT ] ) ;
put_indicator ( s ) ;
put_indicator ( & color_indicator [ C_RIGHT ] ) ;
return true ;
}
else
return false ;
}
}
static void
put_indicator ( const struct bin_str * ind )
{
if ( ! used_color )
{
used_color = true ;
prep_non_filename_text () ;
}
fwrite ( ind -> string , ind -> len , 1 , stdout ) ;
}
static size_t
length_of_file_name_and_frills ( const struct fileinfo * f )
{
size_t len = 0 ;
size_t name_width ;
char buf [ MAX ( LONGEST_HUMAN_READABLE + 1 , INT_BUFSIZE_BOUND ( uintmax_t ) ) ] ;
if ( print_inode )
len += 1 + ( format == with_commas
? strlen ( umaxtostr ( f -> stat . st_ino , buf ) )
: inode_number_width ) ;
if ( print_block_size )
len += 1 + ( format == with_commas
? strlen ( ! f -> stat_ok ? lr_66
: human_readable ( ST_NBLOCKS ( f -> stat ) , buf ,
human_output_opts , ST_NBLOCKSIZE ,
output_block_size ) )
: block_size_width ) ;
if ( print_scontext )
len += 1 + ( format == with_commas ? strlen ( f -> scontext ) : scontext_width ) ;
quote_name ( NULL , f -> name , filename_quoting_options , & name_width ) ;
len += name_width ;
if ( indicator_style != none )
{
char c = get_type_indicator ( f -> stat_ok , f -> stat . st_mode , f -> filetype ) ;
len += ( c != 0 ) ;
}
return len ;
}
static void
print_many_per_line ( void )
{
size_t row ;
size_t cols = calculate_columns ( true ) ;
struct column_info const * line_fmt = & column_info [ cols - 1 ] ;
size_t rows = cwd_n_used / cols + ( cwd_n_used % cols != 0 ) ;
for ( row = 0 ; row < rows ; row ++ )
{
size_t col = 0 ;
size_t filesno = row ;
size_t pos = 0 ;
while ( 1 )
{
struct fileinfo const * f = sorted_file [ filesno ] ;
size_t name_length = length_of_file_name_and_frills ( f ) ;
size_t max_name_length = line_fmt -> col_arr [ col ++ ] ;
print_file_name_and_frills ( f , pos ) ;
filesno += rows ;
if ( filesno >= cwd_n_used )
break;
indent ( pos + name_length , pos + max_name_length ) ;
pos += max_name_length ;
}
putchar ( '\n' ) ;
}
}
static void
print_horizontal ( void )
{
size_t filesno ;
size_t pos = 0 ;
size_t cols = calculate_columns ( false ) ;
struct column_info const * line_fmt = & column_info [ cols - 1 ] ;
struct fileinfo const * f = sorted_file [ 0 ] ;
size_t name_length = length_of_file_name_and_frills ( f ) ;
size_t max_name_length = line_fmt -> col_arr [ 0 ] ;
print_file_name_and_frills ( f , 0 ) ;
for ( filesno = 1 ; filesno < cwd_n_used ; ++ filesno )
{
size_t col = filesno % cols ;
if ( col == 0 )
{
putchar ( '\n' ) ;
pos = 0 ;
}
else
{
indent ( pos + name_length , pos + max_name_length ) ;
pos += max_name_length ;
}
f = sorted_file [ filesno ] ;
print_file_name_and_frills ( f , pos ) ;
name_length = length_of_file_name_and_frills ( f ) ;
max_name_length = line_fmt -> col_arr [ col ] ;
}
putchar ( '\n' ) ;
}
static void
print_with_commas ( void )
{
size_t filesno ;
size_t pos = 0 ;
for ( filesno = 0 ; filesno < cwd_n_used ; filesno ++ )
{
struct fileinfo const * f = sorted_file [ filesno ] ;
size_t len = length_of_file_name_and_frills ( f ) ;
if ( filesno != 0 )
{
char separator ;
if ( pos + len + 2 < line_length )
{
pos += 2 ;
separator = ' ' ;
}
else
{
pos = 0 ;
separator = '\n' ;
}
putchar ( ',' ) ;
putchar ( separator ) ;
}
print_file_name_and_frills ( f , pos ) ;
pos += len ;
}
putchar ( '\n' ) ;
}
static void
indent ( size_t from , size_t to )
{
while ( from < to )
{
if ( tabsize != 0 && to / tabsize > ( from + 1 ) / tabsize )
{
putchar ( '\t' ) ;
from += tabsize - from % tabsize ;
}
else
{
putchar ( ' ' ) ;
from ++ ;
}
}
}
static void
attach ( char * dest , const char * dirname , const char * name )
{
const char * dirnamep = dirname ;
if ( dirname [ 0 ] != '.' || dirname [ 1 ] != 0 )
{
while ( * dirnamep )
* dest ++ = * dirnamep ++ ;
if ( dirnamep > dirname && dirnamep [ - 1 ] != '/' )
* dest ++ = '/' ;
}
while ( * name )
* dest ++ = * name ++ ;
* dest = 0 ;
}
static void
init_column_info ( void )
{
size_t i ;
size_t max_cols = MIN ( max_idx , cwd_n_used ) ;
static size_t column_info_alloc ;
if ( column_info_alloc < max_cols )
{
size_t new_column_info_alloc ;
size_t * p ;
if ( max_cols < max_idx / 2 )
{
column_info = xnrealloc ( column_info , max_cols ,
2 * sizeof *column_info ) ;
new_column_info_alloc = 2 * max_cols ;
}
else
{
column_info = xnrealloc ( column_info , max_idx , sizeof *column_info ) ;
new_column_info_alloc = max_idx ;
}
{
size_t column_info_growth = new_column_info_alloc - column_info_alloc ;
size_t s = column_info_alloc + 1 + new_column_info_alloc ;
size_t t = s * column_info_growth ;
if ( s < new_column_info_alloc || t / column_info_growth != s )
xalloc_die () ;
p = xnmalloc ( t / 2 , sizeof *p ) ;
}
for ( i = column_info_alloc ; i < new_column_info_alloc ; i ++ )
{
column_info [ i ] . col_arr = p ;
p += i + 1 ;
}
column_info_alloc = new_column_info_alloc ;
}
for ( i = 0 ; i < max_cols ; ++ i )
{
size_t j ;
column_info [ i ] . valid_len = true ;
column_info [ i ] . line_len = ( i + 1 ) * MIN_COLUMN_WIDTH ;
for ( j = 0 ; j <= i ; ++ j )
column_info [ i ] . col_arr [ j ] = MIN_COLUMN_WIDTH ;
}
}
static size_t
calculate_columns ( bool by_columns )
{
size_t filesno ;
size_t cols ;
size_t max_cols = MIN ( max_idx , cwd_n_used ) ;
init_column_info () ;
for ( filesno = 0 ; filesno < cwd_n_used ; ++ filesno )
{
struct fileinfo const * f = sorted_file [ filesno ] ;
size_t name_length = length_of_file_name_and_frills ( f ) ;
size_t i ;
for ( i = 0 ; i < max_cols ; ++ i )
{
if ( column_info [ i ] . valid_len )
{
size_t idx = ( by_columns
? filesno / ( ( cwd_n_used + i ) / ( i + 1 ) )
: filesno % ( i + 1 ) ) ;
size_t real_length = name_length + ( idx == i ? 0 : 2 ) ;
if ( column_info [ i ] . col_arr [ idx ] < real_length )
{
column_info [ i ] . line_len += ( real_length
- column_info [ i ] . col_arr [ idx ] ) ;
column_info [ i ] . col_arr [ idx ] = real_length ;
column_info [ i ] . valid_len = ( column_info [ i ] . line_len
< line_length ) ;
}
}
}
}
for ( cols = max_cols ; 1 < cols ; -- cols )
{
if ( column_info [ cols - 1 ] . valid_len )
break;
}
return cols ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_72 ) , program_name ) ;
fputs ( _ ( lr_73 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_74 ) , stdout ) ;
fputs ( _ ( lr_75 ) , stdout ) ;
fputs ( _ ( lr_76 ) , stdout ) ;
fputs ( _ ( lr_77 ) , stdout ) ;
fputs ( _ ( lr_78 ) , stdout ) ;
fputs ( _ ( lr_79 ) , stdout ) ;
fputs ( _ ( lr_80 ) , stdout ) ;
fputs ( _ ( lr_81 ) , stdout ) ;
fputs ( _ ( lr_82 ) , stdout ) ;
fputs ( _ ( lr_83 ) , stdout ) ;
fputs ( _ ( lr_84 ) , stdout ) ;
fputs ( _ ( lr_85 ) , stdout ) ;
fputs ( _ ( lr_86 ) , stdout ) ;
fputs ( _ ( lr_87 ) , stdout ) ;
fputs ( _ ( lr_88 ) , stdout ) ;
fputs ( _ ( lr_89 ) , stdout ) ;
fputs ( _ ( lr_90 ) , stdout ) ;
fputs ( _ ( lr_91 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_size_note () ;
fputs ( _ ( lr_92 ) , stdout ) ;
fputs ( _ ( lr_93 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
