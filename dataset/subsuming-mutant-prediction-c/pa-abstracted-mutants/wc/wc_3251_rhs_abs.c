void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) ,
program_name , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
write_counts ( uintmax_t lines ,
uintmax_t words ,
uintmax_t chars ,
uintmax_t bytes ,
uintmax_t linelength ,
const char * file )
{
static char const format_sp_int [] = lr_4 ;
char const * format_int = format_sp_int + 1 ;
char buf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
if ( print_lines )
{
printf ( format_int , number_width , umaxtostr ( lines , buf ) ) ;
format_int = format_sp_int ;
}
if ( print_words )
{
printf ( format_int , number_width , umaxtostr ( words , buf ) ) ;
format_int = format_sp_int ; MST[STMT!TRAPSTMT]MSP[N]
}
if ( print_chars )
{
printf ( format_int , number_width , umaxtostr ( chars , buf ) ) ;
format_int = format_sp_int ;
}
if ( print_bytes )
{
printf ( format_int , number_width , umaxtostr ( bytes , buf ) ) ;
format_int = format_sp_int ;
}
if ( print_linelength )
{
printf ( format_int , number_width , umaxtostr ( linelength , buf ) ) ;
}
if ( file )
printf ( lr_5 , file ) ;
putchar ( '\n' ) ;
}
static bool
wc ( int fd , char const * file_x , struct fstatus * fstatus )
{
bool ok = true ;
char buf [ BUFFER_SIZE + 1 ] ;
size_t bytes_read ;
uintmax_t lines , words , chars , bytes , linelength ;
bool count_bytes , count_chars , count_complicated ;
char const * file = file_x ? file_x : _ ( lr_6 ) ;
lines = words = chars = bytes = linelength = 0 ;
#if MB_LEN_MAX > 1
if ( MB_CUR_MAX > 1 )
{
count_bytes = print_bytes ;
count_chars = print_chars ;
}
else
#endif
{
count_bytes = print_bytes || print_chars ;
count_chars = false ;
}
count_complicated = print_words || print_linelength ;
if ( ! count_bytes || count_chars || print_lines || count_complicated )
fdadvise ( fd , 0 , 0 , FADVISE_SEQUENTIAL ) ;
if ( count_bytes && ! count_chars && ! print_lines && ! count_complicated )
{
off_t current_pos , end_pos ;
if ( 0 < fstatus -> failed )
fstatus -> failed = fstat ( fd , & fstatus -> st ) ;
if ( ! fstatus -> failed && S_ISREG ( fstatus -> st . st_mode )
&& ( current_pos = lseek ( fd , 0 , SEEK_CUR ) ) != - 1
&& ( end_pos = lseek ( fd , 0 , SEEK_END ) ) != - 1 )
{
bytes = end_pos < current_pos ? 0 : end_pos - current_pos ;
}
else
{
fdadvise ( fd , 0 , 0 , FADVISE_SEQUENTIAL ) ;
while ( ( bytes_read = safe_read ( fd , buf , BUFFER_SIZE ) ) > 0 )
{
if ( bytes_read == SAFE_READ_ERROR )
{
error ( 0 , errno , lr_7 , file ) ;
ok = false ;
break;
}
bytes += bytes_read ;
}
}
}
else if ( ! count_chars && ! count_complicated )
{
while ( ( bytes_read = safe_read ( fd , buf , BUFFER_SIZE ) ) > 0 )
{
char * p = buf ;
if ( bytes_read == SAFE_READ_ERROR )
{
error ( 0 , errno , lr_7 , file ) ;
ok = false ;
break;
}
while ( ( p = memchr ( p , '\n' , ( buf + bytes_read ) - p ) ) )
{
++ p ;
++ lines ;
}
bytes += bytes_read ;
}
}
#if MB_LEN_MAX > 1
# define SUPPORT_OLD_MBRTOWC 1
else if ( MB_CUR_MAX > 1 )
{
bool in_word = false ;
uintmax_t linepos = 0 ;
mbstate_t state = { 0 , } ;
bool in_shift = false ;
# if SUPPORT_OLD_MBRTOWC
size_t prev = 0 ;
# else
const size_t prev = 0 ;
# endif
while ( ( bytes_read = safe_read ( fd , buf + prev , BUFFER_SIZE - prev ) ) > 0 )
{
const char * p ;
# if SUPPORT_OLD_MBRTOWC
mbstate_t backup_state ;
# endif
if ( bytes_read == SAFE_READ_ERROR )
{
error ( 0 , errno , lr_7 , file ) ;
ok = false ;
break;
}
bytes += bytes_read ;
p = buf ;
bytes_read += prev ;
do
{
wchar_t wide_char ;
size_t n ;
if ( ! in_shift && is_basic ( * p ) )
{
n = 1 ;
wide_char = * p ;
}
else
{
in_shift = true ;
# if SUPPORT_OLD_MBRTOWC
backup_state = state ;
# endif
n = mbrtowc ( & wide_char , p , bytes_read , & state ) ;
if ( n == ( size_t ) - 2 )
{
# if SUPPORT_OLD_MBRTOWC
state = backup_state ;
# endif
break;
}
if ( n == ( size_t ) - 1 )
{
p ++ ;
bytes_read -- ;
continue;
}
if ( mbsinit ( & state ) )
in_shift = false ;
if ( n == 0 )
{
wide_char = 0 ;
n = 1 ;
}
}
p += n ;
bytes_read -= n ;
chars ++ ;
switch ( wide_char )
{
case '\n' :
lines ++ ;
case '\r' :
case '\f' :
if ( linepos > linelength )
linelength = linepos ;
linepos = 0 ;
goto mb_word_separator;
case '\t' :
linepos += 8 - ( linepos % 8 ) ;
goto mb_word_separator;
case ' ' :
linepos ++ ;
case '\v' :
mb_word_separator:
words += in_word ;
in_word = false ;
break;
default:
if ( iswprint ( wide_char ) )
{
int width = wcwidth ( wide_char ) ;
if ( width > 0 )
linepos += width ;
if ( iswspace ( wide_char ) )
goto mb_word_separator;
in_word = true ;
}
break;
}
}
while ( bytes_read > 0 );
# if SUPPORT_OLD_MBRTOWC
if ( bytes_read > 0 )
{
if ( bytes_read == BUFFER_SIZE )
{
p ++ ;
bytes_read -- ;
}
memmove ( buf , p , bytes_read ) ;
}
prev = bytes_read ;
# endif
}
if ( linepos > linelength )
linelength = linepos ;
words += in_word ;
}
#endif
else
{
bool in_word = false ;
uintmax_t linepos = 0 ;
while ( ( bytes_read = safe_read ( fd , buf , BUFFER_SIZE ) ) > 0 )
{
const char * p = buf ;
if ( bytes_read == SAFE_READ_ERROR )
{
error ( 0 , errno , lr_7 , file ) ;
ok = false ;
break;
}
bytes += bytes_read ;
do
{
switch ( * p ++ )
{
case '\n' :
lines ++ ;
case '\r' :
case '\f' :
if ( linepos > linelength )
linelength = linepos ;
linepos = 0 ;
goto word_separator;
case '\t' :
linepos += 8 - ( linepos % 8 ) ;
goto word_separator;
case ' ' :
linepos ++ ;
case '\v' :
word_separator:
words += in_word ;
in_word = false ;
break;
default:
if ( isprint ( to_uchar ( p [ - 1 ] ) ) )
{
linepos ++ ;
if ( isspace ( to_uchar ( p [ - 1 ] ) ) )
goto word_separator;
in_word = true ;
}
break;
}
}
while ( -- bytes_read );
}
if ( linepos > linelength )
linelength = linepos ;
words += in_word ;
}
if ( count_chars < print_chars )
chars = bytes ;
write_counts ( lines , words , chars , bytes , linelength , file_x ) ;
total_lines += lines ;
total_words += words ;
total_chars += chars ;
total_bytes += bytes ;
if ( linelength > max_line_length )
max_line_length = linelength ;
return ok ;
}
static bool
wc_file ( char const * file , struct fstatus * fstatus )
{
if ( ! file || STREQ ( file , lr_8 ) )
{
have_read_stdin = true ;
if ( O_BINARY && ! isatty ( STDIN_FILENO ) )
xfreopen ( NULL , lr_9 , stdin ) ;
return wc ( STDIN_FILENO , file , fstatus ) ;
}
else
{
int fd = open ( file , O_RDONLY | O_BINARY ) ;
if ( fd == - 1 )
{
error ( 0 , errno , lr_7 , file ) ;
return false ;
}
else
{
bool ok = wc ( fd , file , fstatus ) ;
if ( close ( fd ) != 0 )
{
error ( 0 , errno , lr_7 , file ) ;
return false ;
}
return ok ;
}
}
}
static struct fstatus *
get_input_fstatus ( int nfiles , char * const * file )
{
struct fstatus * fstatus = xnmalloc ( nfiles ? nfiles : 1 , sizeof *fstatus ) ;
if ( nfiles == 0
|| ( nfiles == 1
&& ( ( print_lines + print_words + print_chars
+ print_bytes + print_linelength )
== 1 ) ) )
fstatus [ 0 ] . failed = 1 ;
else
{
int i ;
for ( i = 0 ; i < nfiles ; i ++ )
fstatus [ i ] . failed = ( ! file [ i ] || STREQ ( file [ i ] , lr_8 )
? fstat ( STDIN_FILENO , & fstatus [ i ] . st )
: stat ( file [ i ] , & fstatus [ i ] . st ) ) ;
}
return fstatus ;
}
static int _GL_ATTRIBUTE_PURE
compute_number_width ( int nfiles , struct fstatus const * fstatus )
{
int width = 1 ;
if ( 0 < nfiles && fstatus [ 0 ] . failed <= 0 )
{
int minimum_width = 1 ;
uintmax_t regular_total = 0 ;
int i ;
for ( i = 0 ; i < nfiles ; i ++ )
if ( ! fstatus [ i ] . failed )
{
if ( S_ISREG ( fstatus [ i ] . st . st_mode ) )
regular_total += fstatus [ i ] . st . st_size ;
else
minimum_width = 7 ;
}
for (; 10 <= regular_total ; regular_total /= 10 )
width ++ ;
if ( width < minimum_width )
width = minimum_width ;
}
return width ;
}
int
main ( int argc , char * * argv )
{
bool ok ;
int optc ;
int nfiles ;
char * * files ;
char * files_from = NULL ;
struct fstatus * fstatus ;
struct Tokens tok ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_10 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
setvbuf ( stdout , NULL , _IOLBF , 0 ) ;
print_lines = print_words = print_chars = print_bytes = false ;
print_linelength = false ;
total_lines = total_words = total_chars = total_bytes = max_line_length = 0 ;
while ( ( optc = getopt_long ( argc , argv , lr_11 , longopts , NULL ) ) != - 1 )
switch ( optc )
{
case 'c' :
print_bytes = true ;
break;
case 'm' :
print_chars = true ;
break;
case 'l' :
print_lines = true ;
break;
case 'w' :
print_words = true ;
break;
case 'L' :
print_linelength = true ;
break;
case FILES0_FROM_OPTION :
files_from = optarg ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
if ( ! ( print_lines || print_words || print_chars || print_bytes
|| print_linelength ) )
print_lines = print_words = print_bytes = true ;
bool read_tokens = false ;
struct argv_iterator * ai ;
if ( files_from )
{
FILE * stream ;
if ( optind < argc )
{
error ( 0 , 0 , _ ( lr_12 ) , quote ( argv [ optind ] ) ) ;
fprintf ( stderr , lr_13 ,
_ ( lr_14 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( STREQ ( files_from , lr_8 ) )
stream = stdin ;
else
{
stream = fopen ( files_from , lr_15 ) ;
if ( stream == NULL )
error ( EXIT_FAILURE , errno , _ ( lr_16 ) ,
quote ( files_from ) ) ;
}
struct stat st ;
if ( fstat ( fileno ( stream ) , & st ) == 0
&& S_ISREG ( st . st_mode )
&& st . st_size <= MIN ( 10 * 1024 * 1024 , physmem_available () / 2 ) )
{
read_tokens = true ;
readtokens0_init ( & tok ) ;
if ( ! readtokens0 ( stream , & tok ) || fclose ( stream ) != 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_17 ) ,
quote ( files_from ) ) ;
files = tok . tok ;
nfiles = tok . n_tok ;
ai = argv_iter_init_argv ( files ) ;
}
else
{
files = NULL ;
nfiles = 0 ;
ai = argv_iter_init_stream ( stream ) ;
}
}
else
{
static char * stdin_only [] = { NULL } ;
files = ( optind < argc ? argv + optind : stdin_only ) ;
nfiles = ( optind < argc ? argc - optind : 1 ) ;
ai = argv_iter_init_argv ( files ) ;
}
if ( ! ai )
xalloc_die () ;
fstatus = get_input_fstatus ( nfiles , files ) ;
number_width = compute_number_width ( nfiles , fstatus ) ;
int i ;
ok = true ;
for ( i = 0 ; ; i ++ )
{
bool skip_file = false ;
enum argv_iter_err ai_err ;
char * file_name = argv_iter ( ai , & ai_err ) ;
if ( ! file_name )
{
switch ( ai_err )
{
case AI_ERR_EOF :
goto argv_iter_done;
case AI_ERR_READ :
error ( 0 , errno , _ ( lr_18 ) ,
quotearg_colon ( files_from ) ) ;
ok = false ;
goto argv_iter_done;
case AI_ERR_MEM :
xalloc_die () ;
default:
assert ( ! lr_19 ) ;
}
}
if ( files_from && STREQ ( files_from , lr_8 ) && STREQ ( file_name , lr_8 ) )
{
error ( 0 , 0 , _ ( lr_20
lr_21 ) ,
quote ( file_name ) ) ;
skip_file = true ;
}
if ( ! file_name [ 0 ] )
{
if ( files_from == NULL )
error ( 0 , 0 , lr_7 , _ ( lr_22 ) ) ;
else
{
unsigned long int file_number = argv_iter_n_args ( ai ) ;
error ( 0 , 0 , lr_23 , quotearg_colon ( files_from ) ,
file_number , _ ( lr_22 ) ) ;
}
skip_file = true ;
}
if ( skip_file )
ok = false ;
else
ok &= wc_file ( file_name , & fstatus [ nfiles ? i : 0 ] ) ;
}
argv_iter_done:
if ( ok && ! files_from && argv_iter_n_args ( ai ) == 0 )
ok &= wc_file ( NULL , & fstatus [ 0 ] ) ;
if ( read_tokens )
readtokens0_free ( & tok ) ;
if ( 1 < argv_iter_n_args ( ai ) )
write_counts ( total_lines , total_words , total_chars , total_bytes ,
max_line_length , _ ( lr_24 ) ) ;
argv_iter_free ( ai ) ;
free ( fstatus ) ;
if ( have_read_stdin && close ( STDIN_FILENO ) != 0 )
error ( EXIT_FAILURE , errno , lr_8 ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
