static bool
mode_changed ( char const * file , mode_t old_mode , mode_t new_mode )
{
if ( new_mode & ( S_ISUID | S_ISGID | S_ISVTX ) )
{
struct stat new_stats ;
if ( stat ( file , & new_stats ) != 0 )
{
if ( ! force_silent )
error ( 0 , errno , _ ( lr_1 ) , quote ( file ) ) ;
return false ;
}
new_mode = new_stats . st_mode ;
}
return ( ( old_mode ^ new_mode ) & CHMOD_MODE_BITS ) != 0 ;
}
static void
describe_change ( const char * file , mode_t old_mode , mode_t mode ,
enum Change_status changed )
{
char perms [ 12 ] ;
char old_perms [ 12 ] ;
const char * fmt ;
if ( changed == CH_NOT_APPLIED )
{
printf ( _ ( lr_2 ) ,
quote ( file ) ) ;
return;
}
strmode ( mode , perms ) ;
perms [ 10 ] = '\0' ;
strmode ( old_mode , old_perms ) ;
old_perms [ 10 ] = '\0' ;
switch ( changed )
{
case CH_SUCCEEDED :
fmt = _ ( lr_3 ) ;
break;
case CH_FAILED :
fmt = _ ( lr_4 ) ;
break;
case CH_NO_CHANGE_REQUESTED :
fmt = _ ( lr_5 ) ;
printf ( fmt , quote ( file ) ,
(unsigned long int) ( mode & CHMOD_MODE_BITS ) , & perms [ 1 ] ) ;
return;
default:
abort () ;
}
printf ( fmt , quote ( file ) ,
(unsigned long int) ( old_mode & CHMOD_MODE_BITS ) , & old_perms [ 1 ] ,
(unsigned long int) ( mode & CHMOD_MODE_BITS ) , & perms [ 1 ] ) ;
}
static bool
process_file ( FTS * fts , FTSENT * ent )
{
char const * file_full_name = ent -> fts_path ;
char const * file = ent -> fts_accpath ;
const struct stat * file_stats = ent -> fts_statp ;
mode_t old_mode IF_LINT ( = 0 ) ;
mode_t new_mode IF_LINT ( = 0 ) ;
bool ok = true ;
bool chmod_succeeded = false ;
switch ( ent -> fts_info )
{
case FTS_DP :
return true ;
case FTS_NS :
if ( ent -> fts_level == 0 && ent -> fts_number == 0 )
{
ent -> fts_number = 1 ;
fts_set ( fts , ent , FTS_AGAIN ) ;
return true ;
}
if ( ! force_silent )
error ( 0 , ent -> fts_errno , _ ( lr_6 ) ,
quote ( file_full_name ) ) ;
ok = false ;
break;
case FTS_ERR :
if ( ! force_silent )
error ( 0 , ent -> fts_errno , lr_7 , quote ( file_full_name ) ) ;
ok = false ;
break;
case FTS_DNR :
if ( ! force_silent )
error ( 0 , ent -> fts_errno , _ ( lr_8 ) ,
quote ( file_full_name ) ) ;
ok = false ;
break;
case FTS_SLNONE :
if ( ! force_silent )
error ( 0 , 0 , _ ( lr_9 ) ,
quote ( file_full_name ) ) ;
ok = false ;
break;
case FTS_DC :
if ( cycle_warning_required ( fts , ent ) )
{
emit_cycle_warning ( file_full_name ) ;
return false ;
}
break;
default:
break;
}
if ( ok && ROOT_DEV_INO_CHECK ( root_dev_ino , file_stats ) )
{
ROOT_DEV_INO_WARN ( file_full_name ) ;
fts_set ( fts , ent , FTS_SKIP ) ;
ignore_value ( fts_read ( fts ) ) ;
return false ;
}
if ( ok )
{
old_mode = file_stats -> st_mode ;
new_mode = mode_adjust ( old_mode , S_ISDIR ( old_mode ) != 0 , umask_value ,
change , NULL ) ;
if ( ! S_ISLNK ( old_mode ) )
{
if ( chmodat ( fts -> fts_cwd_fd , file , new_mode ) == 0 )
chmod_succeeded = true ;
else
{
if ( ! force_silent )
error ( 0 , errno , _ ( lr_10 ) ,
quote ( file_full_name ) ) ;
ok = false ;
}
}
}
if ( verbosity != V_off )
{
bool changed = ( chmod_succeeded
&& mode_changed ( file , old_mode , new_mode ) ) ;
if ( changed || verbosity == V_high )
{
enum Change_status ch_status =
( ! ok ? CH_FAILED
: ! chmod_succeeded ? CH_NOT_APPLIED
: ! changed ? CH_NO_CHANGE_REQUESTED
: CH_SUCCEEDED ) ;
describe_change ( file_full_name , old_mode , new_mode , ch_status ) ;
}
}
if ( chmod_succeeded && diagnose_surprises )
{
mode_t naively_expected_mode =
mode_adjust ( old_mode , S_ISDIR ( old_mode ) != 0 , 0 , change , NULL ) ;
if ( new_mode & ~ naively_expected_mode )
{
char new_perms [ 12 ] ;
char naively_expected_perms [ 12 ] ;
strmode ( new_mode , new_perms ) ;
strmode ( naively_expected_mode , naively_expected_perms ) ;
new_perms [ 10 ] = naively_expected_perms [ 10 ] = '\0' ;
error ( 0 , 0 ,
_ ( lr_11 ) ,
quotearg_colon ( file_full_name ) ,
new_perms + 1 , naively_expected_perms + 1 ) ;
ok = false ;
}
}
if ( ! recurse )
fts_set ( fts , ent , FTS_SKIP ) ;
return ok ;
}
static bool
process_files ( char * * files , int bit_flags )
{
bool ok = true ;
FTS * fts = xfts_open ( files , bit_flags , NULL ) ;
while ( 1 )
{
FTSENT * ent ;
ent = fts_read ( fts ) ;
if ( ent == NULL )
{
if ( errno != 0 )
{
if ( ! force_silent )
error ( 0 , errno , _ ( lr_12 ) ) ;
ok = false ;
}
break;
}
ok &= process_file ( fts , ent ) ;
}
if ( fts_close ( fts ) != 0 )
{
error ( 0 , errno , _ ( lr_13 ) ) ;
ok = false ;
}
return ok ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_14 ) ,
program_name , program_name , program_name ) ;
fputs ( _ ( lr_15 ) , stdout ) ;
fputs ( _ ( lr_16 ) , stdout ) ;
fputs ( _ ( lr_17 ) , stdout ) ;
fputs ( _ ( lr_18 ) , stdout ) ;
fputs ( _ ( lr_19 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_20 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
char * mode = NULL ;
size_t mode_len = 0 ;
size_t mode_alloc = 0 ;
bool ok ;
bool preserve_root = false ;
char const * reference_file = NULL ;
int c ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_21 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
recurse = force_silent = diagnose_surprises = false ;
while ( ( c = getopt_long ( argc , argv ,
( lr_22
lr_23 ) ,
long_options , NULL ) )
!= - 1 )
{
switch ( c )
{
case 'r' :
case 'w' :
case 'x' :
case 'X' :
case 's' :
case 't' :
case 'u' :
case 'g' :
case 'o' :
case 'a' :
case ',' :
case '+' :
case '=' :
case '0' : case '1' : case '2' : case '3' :
case '4' : case '5' : case '6' : case '7' :
{
char const * arg = argv [ optind - 1 ] ;
size_t arg_len = strlen ( arg ) ;
size_t mode_comma_len = mode_len + ! ! mode_len ;
size_t new_mode_len = mode_comma_len + arg_len ;
if ( mode_alloc <= new_mode_len )
{
mode_alloc = new_mode_len + 1 ;
mode = X2REALLOC ( mode , & mode_alloc ) ;
}
mode [ mode_len ] = ',' ; MST[PADD$A1$@2$!OPERAND$@2$]MSP[]
memcpy ( mode + mode_comma_len , arg , arg_len + 1 ) ;
mode_len = new_mode_len ;
diagnose_surprises = true ;
}
break;
case NO_PRESERVE_ROOT :
preserve_root = false ;
break;
case PRESERVE_ROOT :
preserve_root = true ;
break;
case REFERENCE_FILE_OPTION :
reference_file = optarg ;
break;
case 'R' :
recurse = true ;
break;
case 'c' :
verbosity = V_changes_only ;
break;
case 'f' :
force_silent = true ;
break;
case 'v' :
verbosity = V_high ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( reference_file )
{
if ( mode )
{
error ( 0 , 0 , _ ( lr_24 ) ) ;
usage ( EXIT_FAILURE ) ;
}
}
else
{
if ( ! mode )
mode = argv [ optind ++ ] ;
}
if ( optind >= argc )
{
if ( ! mode || mode != argv [ optind - 1 ] )
error ( 0 , 0 , _ ( lr_25 ) ) ;
else
error ( 0 , 0 , _ ( lr_26 ) , quote ( argv [ argc - 1 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( reference_file )
{
change = mode_create_from_ref ( reference_file ) ;
if ( ! change )
error ( EXIT_FAILURE , errno , _ ( lr_27 ) ,
quote ( reference_file ) ) ;
}
else
{
change = mode_compile ( mode ) ;
if ( ! change )
{
error ( 0 , 0 , _ ( lr_28 ) , quote ( mode ) ) ;
usage ( EXIT_FAILURE ) ;
}
umask_value = umask ( 0 ) ;
}
if ( recurse && preserve_root )
{
static struct dev_ino dev_ino_buf ;
root_dev_ino = get_root_dev_ino ( & dev_ino_buf ) ;
if ( root_dev_ino == NULL )
error ( EXIT_FAILURE , errno , _ ( lr_27 ) ,
quote ( lr_29 ) ) ;
}
else
{
root_dev_ino = NULL ;
}
ok = process_files ( argv + optind ,
FTS_COMFOLLOW | FTS_PHYSICAL | FTS_DEFER_STAT ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
