static char *
hide_problematic_chars ( char * cell )
{
char * p = cell ;
while ( * p )
{
if ( iscntrl ( to_uchar ( * p ) ) )
* p = '?' ;
p ++ ;
}
return cell ;
}
static void
alloc_table_row ( void )
{
nrows ++ ;
table = xnrealloc ( table , nrows , sizeof ( char * ) ) ;
table [ nrows - 1 ] = xnmalloc ( ncolumns , sizeof ( char * ) ) ;
}
static void
print_table ( void )
{
size_t row ;
for ( row = 0 ; row < nrows ; row ++ )
{
size_t col ;
for ( col = 0 ; col < ncolumns ; col ++ )
{
char * cell = table [ row ] [ col ] ;
if ( col != 0 )
putchar ( ' ' ) ;
int flags = 0 ;
if ( col == ncolumns - 1 )
flags = MBA_NO_RIGHT_PAD ;
size_t width = columns [ col ] -> width ;
cell = ambsalign ( cell , & width , columns [ col ] -> align , flags ) ;
fputs ( cell ? cell : table [ row ] [ col ] , stdout ) ;
free ( cell ) ;
IF_LINT ( free ( table [ row ] [ col ] ) ) ;
}
putchar ( '\n' ) ;
IF_LINT ( free ( table [ row ] ) ) ;
}
IF_LINT ( free ( table ) ) ;
}
static void
alloc_field ( int f , const char * c )
{
ncolumns ++ ;
columns = xnrealloc ( columns , ncolumns , sizeof ( struct field_data_t * ) ) ; MST[P!PRIGHTDEC$P$]MSP[N]
columns [ ncolumns - 1 ] = & field_data [ f ] ;
if ( c != NULL )
columns [ ncolumns - 1 ] -> caption = c ;
if ( field_data [ f ] . used )
assert ( ! lr_1 ) ;
field_data [ f ] . used = true ;
}
static void
decode_output_arg ( char const * arg )
{
char * arg_writable = xstrdup ( arg ) ;
char * s = arg_writable ;
do
{
char * comma = strchr ( s , ',' ) ;
if ( comma )
* comma ++ = 0 ;
display_field_t field = - 1 ;
unsigned int i ;
for ( i = 0 ; i < ARRAY_CARDINALITY ( field_data ) ; i ++ )
{
if ( STREQ ( field_data [ i ] . arg , s ) )
{
field = i ;
break;
}
}
if ( field == - 1 )
{
error ( 0 , 0 , _ ( lr_2 ) , quote ( s ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( field_data [ field ] . used )
{
error ( 0 , 0 , _ ( lr_3 ) ,
quote ( field_data [ field ] . arg ) ) ;
usage ( EXIT_FAILURE ) ;
}
switch ( field )
{
case SOURCE_FIELD :
case FSTYPE_FIELD :
case USED_FIELD :
case PCENT_FIELD :
case ITOTAL_FIELD :
case IUSED_FIELD :
case IAVAIL_FIELD :
case IPCENT_FIELD :
case TARGET_FIELD :
case FILE_FIELD :
alloc_field ( field , NULL ) ;
break;
case SIZE_FIELD :
alloc_field ( field , N_ ( lr_4 ) ) ;
break;
case AVAIL_FIELD :
alloc_field ( field , N_ ( lr_5 ) ) ;
break;
default:
assert ( ! lr_6 ) ;
}
s = comma ;
}
while ( s );
free ( arg_writable ) ;
}
static void
get_field_list ( void )
{
switch ( header_mode )
{
case DEFAULT_MODE :
alloc_field ( SOURCE_FIELD , NULL ) ;
if ( print_type )
alloc_field ( FSTYPE_FIELD , NULL ) ;
alloc_field ( SIZE_FIELD , NULL ) ;
alloc_field ( USED_FIELD , NULL ) ;
alloc_field ( AVAIL_FIELD , NULL ) ;
alloc_field ( PCENT_FIELD , NULL ) ;
alloc_field ( TARGET_FIELD , NULL ) ;
break;
case HUMAN_MODE :
alloc_field ( SOURCE_FIELD , NULL ) ;
if ( print_type )
alloc_field ( FSTYPE_FIELD , NULL ) ;
alloc_field ( SIZE_FIELD , N_ ( lr_4 ) ) ;
alloc_field ( USED_FIELD , NULL ) ;
alloc_field ( AVAIL_FIELD , N_ ( lr_5 ) ) ;
alloc_field ( PCENT_FIELD , NULL ) ;
alloc_field ( TARGET_FIELD , NULL ) ;
break;
case INODES_MODE :
alloc_field ( SOURCE_FIELD , NULL ) ;
if ( print_type )
alloc_field ( FSTYPE_FIELD , NULL ) ;
alloc_field ( ITOTAL_FIELD , NULL ) ;
alloc_field ( IUSED_FIELD , NULL ) ;
alloc_field ( IAVAIL_FIELD , NULL ) ;
alloc_field ( IPCENT_FIELD , NULL ) ;
alloc_field ( TARGET_FIELD , NULL ) ;
break;
case POSIX_MODE :
alloc_field ( SOURCE_FIELD , NULL ) ;
if ( print_type )
alloc_field ( FSTYPE_FIELD , NULL ) ;
alloc_field ( SIZE_FIELD , NULL ) ;
alloc_field ( USED_FIELD , NULL ) ;
alloc_field ( AVAIL_FIELD , NULL ) ;
alloc_field ( PCENT_FIELD , N_ ( lr_7 ) ) ;
alloc_field ( TARGET_FIELD , NULL ) ;
break;
case OUTPUT_MODE :
if ( ! ncolumns )
{
decode_output_arg ( all_args_string ) ;
}
break;
default:
assert ( ! lr_8 ) ;
}
}
static void
get_header ( void )
{
size_t col ;
alloc_table_row () ;
for ( col = 0 ; col < ncolumns ; col ++ )
{
char * cell = NULL ;
char const * header = _ ( columns [ col ] -> caption ) ;
if ( columns [ col ] -> field == SIZE_FIELD
&& ( header_mode == DEFAULT_MODE
|| ( header_mode == OUTPUT_MODE
&& ! ( human_output_opts & human_autoscale ) ) ) )
{
char buf [ LONGEST_HUMAN_READABLE + 1 ] ;
int opts = ( human_suppress_point_zero
| human_autoscale | human_SI
| ( human_output_opts
& ( human_group_digits | human_base_1024 | human_B ) ) ) ;
uintmax_t q1000 = output_block_size ;
uintmax_t q1024 = output_block_size ;
bool divisible_by_1000 ;
bool divisible_by_1024 ;
do
{
divisible_by_1000 = q1000 % 1000 == 0 ; q1000 /= 1000 ;
divisible_by_1024 = q1024 % 1024 == 0 ; q1024 /= 1024 ;
}
while ( divisible_by_1000 & divisible_by_1024 );
if ( divisible_by_1000 < divisible_by_1024 )
opts |= human_base_1024 ;
if ( divisible_by_1024 < divisible_by_1000 )
opts &= ~ human_base_1024 ;
if ( ! ( opts & human_base_1024 ) )
opts |= human_B ;
char * num = human_readable ( output_block_size , buf , opts , 1 , 1 ) ;
header = _ ( lr_9 ) ;
if ( asprintf ( & cell , _ ( lr_10 ) , num , header ) == - 1 )
cell = NULL ;
}
else if ( header_mode == POSIX_MODE && columns [ col ] -> field == SIZE_FIELD )
{
char buf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
char * num = umaxtostr ( output_block_size , buf ) ;
if ( asprintf ( & cell , _ ( lr_10 ) , num , header ) == - 1 )
cell = NULL ;
}
else
cell = strdup ( header ) ;
if ( ! cell )
xalloc_die () ;
hide_problematic_chars ( cell ) ;
table [ nrows - 1 ] [ col ] = cell ;
columns [ col ] -> width = MAX ( columns [ col ] -> width , mbswidth ( cell , 0 ) ) ;
}
}
static bool _GL_ATTRIBUTE_PURE
selected_fstype ( const char * fstype )
{
const struct fs_type_list * fsp ;
if ( fs_select_list == NULL || fstype == NULL )
return true ;
for ( fsp = fs_select_list ; fsp ; fsp = fsp -> fs_next )
if ( STREQ ( fstype , fsp -> fs_name ) )
return true ;
return false ;
}
static bool _GL_ATTRIBUTE_PURE
excluded_fstype ( const char * fstype )
{
const struct fs_type_list * fsp ;
if ( fs_exclude_list == NULL || fstype == NULL )
return false ;
for ( fsp = fs_exclude_list ; fsp ; fsp = fsp -> fs_next )
if ( STREQ ( fstype , fsp -> fs_name ) )
return true ;
return false ;
}
static void
filter_mount_list ( void )
{
struct mount_entry * me ;
struct devlist * devlist_head = NULL ;
for ( me = mount_list ; me ; )
{
struct stat buf ;
struct devlist * devlist ;
struct mount_entry * discard_me = NULL ;
if ( - 1 == stat ( me -> me_mountdir , & buf ) )
{
buf . st_dev = me -> me_dev ;
}
else
{
if ( strchr ( me -> me_devname , '/' ) )
{
for ( devlist = devlist_head ; devlist ; devlist = devlist -> next )
if ( devlist -> dev_num == buf . st_dev )
break;
if ( devlist )
{
discard_me = me ;
if ( ! strchr ( devlist -> me -> me_devname , '/' )
|| ( strlen ( devlist -> me -> me_mountdir )
> strlen ( me -> me_mountdir ) ) )
{
discard_me = devlist -> me ;
devlist -> me = me ;
}
}
}
}
if ( discard_me )
{
me = me -> me_next ;
free_mount_entry ( discard_me ) ;
}
else
{
devlist = xmalloc ( sizeof *devlist ) ;
devlist -> me = me ;
devlist -> dev_num = buf . st_dev ;
devlist -> next = devlist_head ;
devlist_head = devlist ;
me = me -> me_next ;
}
}
mount_list = NULL ;
while ( devlist_head )
{
me = devlist_head -> me ;
me -> me_next = mount_list ;
mount_list = me ;
struct devlist * devlist = devlist_head -> next ;
free ( devlist_head ) ;
devlist_head = devlist ;
}
}
static bool
known_value ( uintmax_t n )
{
return n < UINTMAX_MAX - 1 ;
}
static char const *
df_readable ( bool negative , uintmax_t n , char * buf ,
uintmax_t input_units , uintmax_t output_units )
{
if ( ! known_value ( n ) && ! negative )
return lr_11 ;
else
{
char * p = human_readable ( negative ? - n : n , buf + negative ,
human_output_opts , input_units , output_units ) ;
if ( negative )
* -- p = '-' ;
return p ;
}
}
static void
add_uint_with_neg_flag ( uintmax_t * dest , bool * dest_neg ,
uintmax_t src , bool src_neg )
{
if ( LOG_EQ ( * dest_neg , src_neg ) )
{
* dest += src ;
return;
}
if ( * dest_neg )
* dest = - * dest ;
if ( src_neg )
src = - src ;
if ( src < * dest )
* dest -= src ;
else
{
* dest = src - * dest ;
* dest_neg = src_neg ;
}
if ( * dest_neg )
* dest = - * dest ;
}
static bool _GL_ATTRIBUTE_PURE
has_uuid_suffix ( char const * s )
{
size_t len = strlen ( s ) ;
return ( 36 < len
&& strspn ( s + len - 36 , lr_12 ) == 36 ) ;
}
static void
get_field_values ( struct field_values_t * bv ,
struct field_values_t * iv ,
const struct fs_usage * fsu )
{
iv -> input_units = iv -> output_units = 1 ;
iv -> total = fsu -> fsu_files ;
iv -> available = iv -> available_to_root = fsu -> fsu_ffree ;
iv -> negate_available = false ;
iv -> used = UINTMAX_MAX ;
iv -> negate_used = false ;
if ( known_value ( iv -> total ) && known_value ( iv -> available_to_root ) )
{
iv -> used = iv -> total - iv -> available_to_root ;
iv -> negate_used = ( iv -> total < iv -> available_to_root ) ;
}
bv -> input_units = fsu -> fsu_blocksize ;
bv -> output_units = output_block_size ;
bv -> total = fsu -> fsu_blocks ;
bv -> available = fsu -> fsu_bavail ;
bv -> available_to_root = fsu -> fsu_bfree ;
bv -> negate_available = ( fsu -> fsu_bavail_top_bit_set
&& known_value ( fsu -> fsu_bavail ) ) ;
bv -> used = UINTMAX_MAX ;
bv -> negate_used = false ;
if ( known_value ( bv -> total ) && known_value ( bv -> available_to_root ) )
{
bv -> used = bv -> total - bv -> available_to_root ;
bv -> negate_used = ( bv -> total < bv -> available_to_root ) ;
}
}
static void
add_to_grand_total ( struct field_values_t * bv , struct field_values_t * iv )
{
if ( known_value ( iv -> total ) )
grand_fsu . fsu_files += iv -> total ;
if ( known_value ( iv -> available ) )
grand_fsu . fsu_ffree += iv -> available ;
if ( known_value ( bv -> total ) )
grand_fsu . fsu_blocks += bv -> input_units * bv -> total ;
if ( known_value ( bv -> available_to_root ) )
grand_fsu . fsu_bfree += bv -> input_units * bv -> available_to_root ;
if ( known_value ( bv -> available ) )
add_uint_with_neg_flag ( & grand_fsu . fsu_bavail ,
& grand_fsu . fsu_bavail_top_bit_set ,
bv -> input_units * bv -> available ,
bv -> negate_available ) ;
}
static void
get_dev ( char const * disk , char const * mount_point , char const * file ,
char const * stat_file , char const * fstype ,
bool me_dummy , bool me_remote ,
const struct fs_usage * force_fsu ,
bool process_all )
{
if ( me_remote && show_local_fs )
return;
if ( me_dummy && ! show_all_fs && ! show_listed_fs )
return;
if ( ! selected_fstype ( fstype ) || excluded_fstype ( fstype ) )
return;
if ( ! stat_file )
stat_file = mount_point ? mount_point : disk ;
struct fs_usage fsu ;
if ( force_fsu )
fsu = * force_fsu ;
else if ( get_fs_usage ( stat_file , disk , & fsu ) )
{
error ( 0 , errno , lr_13 , quote ( stat_file ) ) ;
exit_status = EXIT_FAILURE ;
return;
}
if ( fsu . fsu_blocks == 0 && ! show_all_fs && ! show_listed_fs )
return;
if ( ! force_fsu )
file_systems_processed = true ;
alloc_table_row () ;
if ( ! disk )
disk = lr_11 ;
if ( ! file )
file = lr_11 ;
char * dev_name = xstrdup ( disk ) ;
char * resolved_dev ;
if ( process_all
&& has_uuid_suffix ( dev_name )
&& ( resolved_dev = canonicalize_filename_mode ( dev_name , CAN_EXISTING ) ) )
{
free ( dev_name ) ;
dev_name = resolved_dev ;
}
if ( ! fstype )
fstype = lr_11 ;
struct field_values_t block_values ;
struct field_values_t inode_values ;
get_field_values ( & block_values , & inode_values , & fsu ) ;
if ( print_grand_total && ! force_fsu )
add_to_grand_total ( & block_values , & inode_values ) ;
size_t col ;
for ( col = 0 ; col < ncolumns ; col ++ )
{
char buf [ LONGEST_HUMAN_READABLE + 2 ] ;
char * cell ;
struct field_values_t * v ;
switch ( columns [ col ] -> field_type )
{
case BLOCK_FLD :
v = & block_values ;
break;
case INODE_FLD :
v = & inode_values ;
break;
case OTHER_FLD :
v = NULL ;
break;
default:
assert ( ! lr_14 ) ;
}
switch ( columns [ col ] -> field )
{
case SOURCE_FIELD :
cell = xstrdup ( dev_name ) ;
break;
case FSTYPE_FIELD :
cell = xstrdup ( fstype ) ;
break;
case SIZE_FIELD :
case ITOTAL_FIELD :
cell = xstrdup ( df_readable ( false , v -> total , buf ,
v -> input_units , v -> output_units ) ) ;
break;
case USED_FIELD :
case IUSED_FIELD :
cell = xstrdup ( df_readable ( v -> negate_used , v -> used , buf ,
v -> input_units , v -> output_units ) ) ;
break;
case AVAIL_FIELD :
case IAVAIL_FIELD :
cell = xstrdup ( df_readable ( v -> negate_available , v -> available , buf ,
v -> input_units , v -> output_units ) ) ;
break;
case PCENT_FIELD :
case IPCENT_FIELD :
{
double pct = - 1 ;
if ( ! known_value ( v -> used ) || ! known_value ( v -> available ) )
;
else if ( ! v -> negate_used
&& v -> used <= TYPE_MAXIMUM ( uintmax_t ) / 100
&& v -> used + v -> available != 0
&& ( v -> used + v -> available < v -> used )
== v -> negate_available )
{
uintmax_t u100 = v -> used * 100 ;
uintmax_t nonroot_total = v -> used + v -> available ;
pct = u100 / nonroot_total + ( u100 % nonroot_total != 0 ) ;
}
else
{
double u = v -> negate_used ? - ( double ) - v -> used : v -> used ;
double a = v -> negate_available
? - ( double ) - v -> available : v -> available ;
double nonroot_total = u + a ;
if ( nonroot_total )
{
long int lipct = pct = u * 100 / nonroot_total ;
double ipct = lipct ;
if ( ipct - 1 < pct && pct <= ipct + 1 )
pct = ipct + ( ipct < pct ) ;
}
}
if ( 0 <= pct )
{
if ( asprintf ( & cell , lr_15 , pct ) == - 1 )
cell = NULL ;
}
else
cell = strdup ( lr_11 ) ;
if ( ! cell )
xalloc_die () ;
break;
}
case FILE_FIELD :
cell = xstrdup ( file ) ;
break;
case TARGET_FIELD :
#ifdef HIDE_AUTOMOUNT_PREFIX
if ( STRNCMP_LIT ( mount_point , lr_16 ) == 0 )
mount_point += 5 ;
else if ( STRNCMP_LIT ( mount_point , lr_17 ) == 0 )
mount_point += 8 ;
#endif
cell = xstrdup ( mount_point ) ;
break;
default:
assert ( ! lr_18 ) ;
}
if ( ! cell )
assert ( ! lr_19 ) ;
hide_problematic_chars ( cell ) ;
columns [ col ] -> width = MAX ( columns [ col ] -> width , mbswidth ( cell , 0 ) ) ;
table [ nrows - 1 ] [ col ] = cell ;
}
free ( dev_name ) ;
}
static bool
get_disk ( char const * disk )
{
struct mount_entry const * me ;
struct mount_entry const * best_match = NULL ;
char const * file = disk ;
char * resolved = canonicalize_file_name ( disk ) ;
if ( resolved && resolved [ 0 ] == '/' )
disk = resolved ;
size_t best_match_len = SIZE_MAX ;
for ( me = mount_list ; me ; me = me -> me_next )
{
if ( STREQ ( disk , me -> me_devname ) )
{
size_t len = strlen ( me -> me_mountdir ) ;
if ( len < best_match_len )
{
best_match = me ;
if ( len == 1 )
break;
else
best_match_len = len ;
}
}
}
free ( resolved ) ;
if ( best_match )
{
get_dev ( best_match -> me_devname , best_match -> me_mountdir , file , NULL ,
best_match -> me_type , best_match -> me_dummy ,
best_match -> me_remote , NULL , false ) ;
return true ;
}
return false ;
}
static void
get_point ( const char * point , const struct stat * statp )
{
struct stat disk_stats ;
struct mount_entry * me ;
struct mount_entry const * best_match = NULL ;
char * resolved = canonicalize_file_name ( point ) ;
if ( resolved && resolved [ 0 ] == '/' )
{
size_t resolved_len = strlen ( resolved ) ;
size_t best_match_len = 0 ;
for ( me = mount_list ; me ; me = me -> me_next )
{
if ( ! STREQ ( me -> me_type , lr_20 )
&& ( ! best_match || best_match -> me_dummy || ! me -> me_dummy ) )
{
size_t len = strlen ( me -> me_mountdir ) ;
if ( best_match_len <= len && len <= resolved_len
&& ( len == 1
|| ( ( len == resolved_len || resolved [ len ] == '/' )
&& STREQ_LEN ( me -> me_mountdir , resolved , len ) ) ) )
{
best_match = me ;
best_match_len = len ;
}
}
}
}
free ( resolved ) ;
if ( best_match
&& ( stat ( best_match -> me_mountdir , & disk_stats ) != 0
|| disk_stats . st_dev != statp -> st_dev ) )
best_match = NULL ;
if ( ! best_match )
for ( me = mount_list ; me ; me = me -> me_next )
{
if ( me -> me_dev == ( dev_t ) - 1 )
{
if ( stat ( me -> me_mountdir , & disk_stats ) == 0 )
me -> me_dev = disk_stats . st_dev ;
else
{
if ( errno == EIO )
{
error ( 0 , errno , lr_13 , quote ( me -> me_mountdir ) ) ;
exit_status = EXIT_FAILURE ;
}
me -> me_dev = ( dev_t ) - 2 ;
}
}
if ( statp -> st_dev == me -> me_dev
&& ! STREQ ( me -> me_type , lr_20 )
&& ( ! best_match || best_match -> me_dummy || ! me -> me_dummy ) )
{
if ( stat ( me -> me_mountdir , & disk_stats ) != 0
|| disk_stats . st_dev != me -> me_dev )
me -> me_dev = ( dev_t ) - 2 ;
else
best_match = me ;
}
}
if ( best_match )
get_dev ( best_match -> me_devname , best_match -> me_mountdir , point , point ,
best_match -> me_type , best_match -> me_dummy , best_match -> me_remote ,
NULL , false ) ;
else
{
char * mp = find_mount_point ( point , statp ) ;
if ( mp )
{
get_dev ( NULL , mp , point , NULL , NULL , false , false , NULL , false ) ;
free ( mp ) ;
}
}
}
static void
get_entry ( char const * name , struct stat const * statp )
{
if ( ( S_ISBLK ( statp -> st_mode ) || S_ISCHR ( statp -> st_mode ) )
&& get_disk ( name ) )
return;
get_point ( name , statp ) ;
}
static void
get_all_entries ( void )
{
struct mount_entry * me ;
if ( ! show_all_fs )
filter_mount_list () ;
for ( me = mount_list ; me ; me = me -> me_next )
get_dev ( me -> me_devname , me -> me_mountdir , NULL , NULL , me -> me_type ,
me -> me_dummy , me -> me_remote , NULL , true ) ;
}
static void
add_fs_type ( const char * fstype )
{
struct fs_type_list * fsp ;
fsp = xmalloc ( sizeof *fsp ) ;
fsp -> fs_name = ( char * ) fstype ;
fsp -> fs_next = fs_select_list ;
fs_select_list = fsp ;
}
static void
add_excluded_fs_type ( const char * fstype )
{
struct fs_type_list * fsp ;
fsp = xmalloc ( sizeof *fsp ) ;
fsp -> fs_name = ( char * ) fstype ;
fsp -> fs_next = fs_exclude_list ;
fs_exclude_list = fsp ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_21 ) , program_name ) ;
fputs ( _ ( lr_22 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_23 ) , stdout ) ;
fputs ( _ ( lr_24 ) , stdout ) ;
fputs ( _ ( lr_25 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_blocksize_note ( lr_26 ) ;
emit_size_note () ;
fputs ( _ ( lr_27 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
struct stat * stats IF_LINT ( = 0 ) ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_28 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
fs_select_list = NULL ;
fs_exclude_list = NULL ;
show_all_fs = false ;
show_listed_fs = false ;
human_output_opts = - 1 ;
print_type = false ;
file_systems_processed = false ;
exit_status = EXIT_SUCCESS ;
print_grand_total = false ;
grand_fsu . fsu_blocksize = 1 ;
bool posix_format = false ;
const char * msg_mut_excl = _ ( lr_29 ) ;
while ( true )
{
int oi = - 1 ;
int c = getopt_long ( argc , argv , lr_30 , long_options ,
& oi ) ;
if ( c == - 1 )
break;
switch ( c )
{
case 'a' :
show_all_fs = true ;
break;
case 'B' :
{
enum strtol_error e = human_options ( optarg , & human_output_opts ,
& output_block_size ) ;
if ( e != LONGINT_OK )
xstrtol_fatal ( e , oi , c , long_options , optarg ) ;
}
break;
case 'i' :
if ( header_mode == OUTPUT_MODE )
{
error ( 0 , 0 , msg_mut_excl , lr_31 , lr_32 ) ;
usage ( EXIT_FAILURE ) ;
}
header_mode = INODES_MODE ;
break;
case 'h' :
human_output_opts = human_autoscale | human_SI | human_base_1024 ;
output_block_size = 1 ;
break;
case 'H' :
human_output_opts = human_autoscale | human_SI ;
output_block_size = 1 ;
break;
case 'k' :
human_output_opts = 0 ;
output_block_size = 1024 ;
break;
case 'l' :
show_local_fs = true ;
break;
case 'm' :
human_output_opts = 0 ;
output_block_size = 1024 * 1024 ;
break;
case 'T' :
if ( header_mode == OUTPUT_MODE )
{
error ( 0 , 0 , msg_mut_excl , lr_33 , lr_32 ) ;
usage ( EXIT_FAILURE ) ;
}
print_type = true ;
break;
case 'P' :
if ( header_mode == OUTPUT_MODE )
{
error ( 0 , 0 , msg_mut_excl , lr_34 , lr_32 ) ;
usage ( EXIT_FAILURE ) ;
}
posix_format = true ;
break;
case SYNC_OPTION :
require_sync = true ;
break;
case NO_SYNC_OPTION :
require_sync = false ;
break;
case 'F' :
case 't' :
add_fs_type ( optarg ) ;
break;
case 'v' :
break;
case 'x' :
add_excluded_fs_type ( optarg ) ;
break;
case OUTPUT_OPTION :
if ( header_mode == INODES_MODE )
{
error ( 0 , 0 , msg_mut_excl , lr_31 , lr_32 ) ;
usage ( EXIT_FAILURE ) ;
}
if ( posix_format && header_mode == DEFAULT_MODE )
{
error ( 0 , 0 , msg_mut_excl , lr_34 , lr_32 ) ;
usage ( EXIT_FAILURE ) ;
}
if ( print_type )
{
error ( 0 , 0 , msg_mut_excl , lr_33 , lr_32 ) ;
usage ( EXIT_FAILURE ) ;
}
header_mode = OUTPUT_MODE ;
if ( optarg )
decode_output_arg ( optarg ) ;
break;
case TOTAL_OPTION :
print_grand_total = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( human_output_opts == - 1 )
{
if ( posix_format )
{
human_output_opts = 0 ;
output_block_size = ( getenv ( lr_35 ) ? 512 : 1024 ) ;
}
else
human_options ( getenv ( lr_36 ) ,
& human_output_opts , & output_block_size ) ;
}
if ( header_mode == INODES_MODE || header_mode == OUTPUT_MODE )
;
else if ( human_output_opts & human_autoscale )
header_mode = HUMAN_MODE ;
else if ( posix_format )
header_mode = POSIX_MODE ;
{
bool match = false ;
struct fs_type_list * fs_incl ;
for ( fs_incl = fs_select_list ; fs_incl ; fs_incl = fs_incl -> fs_next )
{
struct fs_type_list * fs_excl ;
for ( fs_excl = fs_exclude_list ; fs_excl ; fs_excl = fs_excl -> fs_next )
{
if ( STREQ ( fs_incl -> fs_name , fs_excl -> fs_name ) )
{
error ( 0 , 0 ,
_ ( lr_37 ) ,
quote ( fs_incl -> fs_name ) ) ;
match = true ;
break;
}
}
}
if ( match )
exit ( EXIT_FAILURE ) ;
}
if ( optind < argc )
{
int i ;
stats = xnmalloc ( argc - optind , sizeof *stats ) ;
for ( i = optind ; i < argc ; ++ i )
{
int fd = open ( argv [ i ] , O_RDONLY | O_NOCTTY ) ;
if ( ( fd < 0 || fstat ( fd , & stats [ i - optind ] ) )
&& stat ( argv [ i ] , & stats [ i - optind ] ) )
{
error ( 0 , errno , lr_13 , quote ( argv [ i ] ) ) ;
exit_status = EXIT_FAILURE ;
argv [ i ] = NULL ;
}
if ( 0 <= fd )
close ( fd ) ;
}
}
mount_list =
read_file_system_list ( ( fs_select_list != NULL
|| fs_exclude_list != NULL
|| print_type
|| field_data [ FSTYPE_FIELD ] . used
|| show_local_fs ) ) ;
if ( mount_list == NULL )
{
int status = 0 ;
if ( ! ( optind < argc )
|| ( show_all_fs
|| show_local_fs
|| fs_select_list != NULL
|| fs_exclude_list != NULL ) )
{
status = EXIT_FAILURE ;
}
const char * warning = ( status == 0 ? _ ( lr_38 ) : lr_28 ) ;
error ( status , errno , lr_39 , warning ,
_ ( lr_40 ) ) ;
}
if ( require_sync )
sync () ;
get_field_list () ;
get_header () ;
if ( optind < argc )
{
int i ;
show_listed_fs = true ;
for ( i = optind ; i < argc ; ++ i )
if ( argv [ i ] )
get_entry ( argv [ i ] , & stats [ i - optind ] ) ;
}
else
get_all_entries () ;
if ( file_systems_processed )
{
if ( print_grand_total )
get_dev ( lr_41 ,
( field_data [ SOURCE_FIELD ] . used ? lr_11 : lr_41 ) ,
NULL , NULL , NULL , false , false , & grand_fsu , false ) ;
print_table () ;
}
else
{
if ( exit_status == EXIT_SUCCESS )
error ( EXIT_FAILURE , 0 , _ ( lr_42 ) ) ;
}
IF_LINT ( free ( columns ) ) ;
exit ( exit_status ) ;
}
