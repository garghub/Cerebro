static int
compute_context_from_mask ( security_context_t context , context_t * ret )
{
bool ok = true ;
context_t new_context = context_new ( context ) ;
if ( ! new_context )
{
error ( 0 , errno , _ ( lr_1 ) ,
quotearg_colon ( context ) ) ;
return 1 ;
}
#define SET_COMPONENT ( C , comp ) \
do \
{ \
if (specified_ ## comp \
&& context_ ## comp ## _set ((C), specified_ ## comp)) \
{ \
error (0, errno, \
_("failed to set %s security context component to %s"), \
#comp, quote (specified_ ## comp)); \
ok = false; \
} \
} \
while (0)
SET_COMPONENT ( new_context , user ) ;
SET_COMPONENT ( new_context , range ) ;
SET_COMPONENT ( new_context , role ) ;
SET_COMPONENT ( new_context , type ) ;
if ( ! ok )
{
int saved_errno = errno ;
context_free ( new_context ) ;
errno = saved_errno ;
return 1 ;
}
* ret = new_context ;
return 0 ;
}
static int
change_file_context ( int fd , char const * file )
{
security_context_t file_context = NULL ;
context_t context ;
security_context_t context_string ;
int errors = 0 ;
if ( specified_context == NULL )
{
int status = ( affect_symlink_referent
? getfileconat ( fd , file , & file_context )
: lgetfileconat ( fd , file , & file_context ) ) ;
if ( status < 0 && errno != ENODATA )
{
error ( 0 , errno , _ ( lr_2 ) ,
quote ( file ) ) ;
return 1 ;
}
if ( file_context == NULL )
{
error ( 0 , 0 , _ ( lr_3 ) ,
quote ( file ) ) ;
return 1 ;
}
if ( compute_context_from_mask ( file_context , & context ) )
return 1 ;
}
else
{
context = context_new ( specified_context ) ;
if ( ! context )
abort () ;
}
context_string = context_str ( context ) ;
if ( file_context == NULL || ! STREQ ( context_string , file_context ) )
{
int fail = ( affect_symlink_referent
? setfileconat ( fd , file , context_string )
: lsetfileconat ( fd , file , context_string ) ) ;
if ( fail )
{
errors = 1 ;
error ( 0 , errno , _ ( lr_4 ) ,
quote_n ( 0 , file ) , quote_n ( 1 , context_string ) ) ;
}
}
context_free ( context ) ;
freecon ( file_context ) ;
return errors ;
}
static bool
process_file ( FTS * fts , FTSENT * ent )
{
char const * file_full_name = ent -> fts_path ;
char const * file = ent -> fts_accpath ;
const struct stat * file_stats = ent -> fts_statp ;
bool ok = true ;
switch ( ent -> fts_info )
{
case FTS_D :
if ( recurse )
{
if ( ROOT_DEV_INO_CHECK ( root_dev_ino , ent -> fts_statp ) )
{
ROOT_DEV_INO_WARN ( file_full_name ) ;
fts_set ( fts , ent , FTS_SKIP ) ;
ignore_value ( fts_read ( fts ) ) ;
return false ;
}
return true ;
}
break;
case FTS_DP :
if ( ! recurse )
return true ;
break;
case FTS_NS :
if ( ent -> fts_level == 0 && ent -> fts_number == 0 )
{
ent -> fts_number = 1 ;
fts_set ( fts , ent , FTS_AGAIN ) ;
return true ;
}
error ( 0 , ent -> fts_errno , _ ( lr_5 ) , quote ( file_full_name ) ) ;
ok = false ;
break;
case FTS_ERR :
error ( 0 , ent -> fts_errno , lr_6 , quote ( file_full_name ) ) ;
ok = false ;
break;
case FTS_DNR :
error ( 0 , ent -> fts_errno , _ ( lr_7 ) ,
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
if ( ent -> fts_info == FTS_DP
&& ok && ROOT_DEV_INO_CHECK ( root_dev_ino , file_stats ) )
{
ROOT_DEV_INO_WARN ( file_full_name ) ;
ok = false ;
}
if ( ok )
{
if ( verbose )
printf ( _ ( lr_8 ) ,
quote ( file_full_name ) ) ;
if ( change_file_context ( fts -> fts_cwd_fd , file ) != 0 )
ok = false ;
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
error ( 0 , errno , _ ( lr_9 ) ) ;
ok = false ;
}
break;
}
ok &= process_file ( fts , ent ) ;
}
if ( fts_close ( fts ) != 0 )
{
error ( 0 , errno , _ ( lr_10 ) ) ;
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
printf ( _ ( lr_11 ) ,
program_name , program_name , program_name ) ;
fputs ( _ ( lr_12 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_13 ) , stdout ) ;
fputs ( _ ( lr_14 ) , stdout ) ;
fputs ( _ ( lr_15 ) , stdout ) ;
fputs ( _ ( lr_16 ) , stdout ) ; MST[STMT!TRAPSTMT]MSP[]
fputs ( _ ( lr_17 ) , stdout ) ;
fputs ( _ ( lr_18 ) , stdout ) ;
fputs ( _ ( lr_19 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
security_context_t ref_context = NULL ;
int bit_flags = FTS_PHYSICAL ;
int dereference = - 1 ;
bool ok ;
bool preserve_root = false ;
bool component_specified = false ;
char * reference_file = NULL ;
int optc ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_20 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( optc = getopt_long ( argc , argv , lr_21 , long_options , NULL ) )
!= - 1 )
{
switch ( optc )
{
case 'H' :
bit_flags = FTS_COMFOLLOW | FTS_PHYSICAL ;
break;
case 'L' :
bit_flags = FTS_LOGICAL ;
break;
case 'P' :
bit_flags = FTS_PHYSICAL ;
break;
case 'h' :
dereference = 0 ;
break;
case DEREFERENCE_OPTION :
dereference = 1 ;
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
case 'f' :
break;
case 'v' :
verbose = true ;
break;
case 'u' :
specified_user = optarg ;
component_specified = true ;
break;
case 'r' :
specified_role = optarg ;
component_specified = true ;
break;
case 't' :
specified_type = optarg ;
component_specified = true ;
break;
case 'l' :
specified_range = optarg ;
component_specified = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( recurse )
{
if ( bit_flags == FTS_PHYSICAL )
{
if ( dereference == 1 )
error ( EXIT_FAILURE , 0 ,
_ ( lr_22 ) ) ;
affect_symlink_referent = false ;
}
else
{
if ( dereference == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_23 ) ) ;
affect_symlink_referent = true ;
}
}
else
{
bit_flags = FTS_PHYSICAL ;
affect_symlink_referent = ( dereference != 0 ) ;
}
if ( argc - optind < ( reference_file || component_specified ? 1 : 2 ) )
{
if ( argc <= optind )
error ( 0 , 0 , _ ( lr_24 ) ) ;
else
error ( 0 , 0 , _ ( lr_25 ) , quote ( argv [ argc - 1 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( reference_file )
{
if ( getfilecon ( reference_file , & ref_context ) < 0 )
error ( EXIT_FAILURE , errno , _ ( lr_2 ) ,
quote ( reference_file ) ) ;
specified_context = ref_context ;
}
else if ( component_specified )
{
specified_context = NULL ;
}
else
{
context_t context ;
specified_context = argv [ optind ++ ] ;
context = context_new ( specified_context ) ;
if ( ! context )
error ( EXIT_FAILURE , 0 , _ ( lr_26 ) ,
quotearg_colon ( specified_context ) ) ;
context_free ( context ) ;
}
if ( reference_file && component_specified )
{
error ( 0 , 0 , _ ( lr_27 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( recurse && preserve_root )
{
static struct dev_ino dev_ino_buf ;
root_dev_ino = get_root_dev_ino ( & dev_ino_buf ) ;
if ( root_dev_ino == NULL )
error ( EXIT_FAILURE , errno , _ ( lr_28 ) ,
quote ( lr_29 ) ) ;
}
else
{
root_dev_ino = NULL ;
}
ok = process_files ( argv + optind , bit_flags | FTS_NOSTAT ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
