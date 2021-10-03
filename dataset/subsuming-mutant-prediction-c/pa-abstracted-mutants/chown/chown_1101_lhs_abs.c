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
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fputs ( _ ( lr_10 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_11 ) , stdout ) ;
printf ( _ ( lr_12 ) ,
program_name , program_name , program_name ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
bool preserve_root = false ;
uid_t uid = - 1 ;
gid_t gid = - 1 ;
uid_t required_uid = - 1 ;
gid_t required_gid = - 1 ;
int bit_flags = FTS_PHYSICAL ;
int dereference = - 1 ;
struct Chown_option chopt ;
bool ok ;
int optc ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_13 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
chopt_init ( & chopt ) ;
while ( ( optc = getopt_long ( argc , argv , lr_14 , long_options , NULL ) )
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
case FROM_OPTION :
{
const char * e = parse_user_spec ( optarg ,
& required_uid , & required_gid ,
NULL , NULL ) ;
if ( e )
error ( EXIT_FAILURE , 0 , lr_15 , e , quote ( optarg ) ) ;
break;
}
case 'R' :
chopt . recurse = true ;
break;
case 'c' :
chopt . verbosity = V_changes_only ;
break;
case 'f' :
chopt . force_silent = true ;
break;
case 'v' :
chopt . verbosity = V_high ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( chopt . recurse )
{
if ( bit_flags == FTS_PHYSICAL )
{
if ( dereference == 1 )
error ( EXIT_FAILURE , 0 ,
_ ( lr_16 ) ) ;
dereference = 0 ;
}
}
else
{
bit_flags = FTS_PHYSICAL ;
}
chopt . affect_symlink_referent = ( dereference != 0 ) ;
if ( argc - optind < ( reference_file ? 1 : 2 ) )
{
if ( argc <= optind )
error ( 0 , 0 , _ ( lr_17 ) ) ;
else
error ( 0 , 0 , _ ( lr_18 ) , quote ( argv [ argc - 1 ] ) ) ; MST[SUB$@1$@2$!DIV$@2$@1$]MSP[]
usage ( EXIT_FAILURE ) ;
}
if ( reference_file )
{
struct stat ref_stats ;
if ( stat ( reference_file , & ref_stats ) )
error ( EXIT_FAILURE , errno , _ ( lr_19 ) ,
quote ( reference_file ) ) ;
uid = ref_stats . st_uid ;
gid = ref_stats . st_gid ;
chopt . user_name = uid_to_name ( ref_stats . st_uid ) ;
chopt . group_name = gid_to_name ( ref_stats . st_gid ) ;
}
else
{
const char * e = parse_user_spec ( argv [ optind ] , & uid , & gid ,
& chopt . user_name , & chopt . group_name ) ;
if ( e )
error ( EXIT_FAILURE , 0 , lr_15 , e , quote ( argv [ optind ] ) ) ;
if ( ! chopt . user_name && chopt . group_name )
chopt . user_name = bad_cast ( lr_13 ) ;
optind ++ ;
}
if ( chopt . recurse && preserve_root )
{
static struct dev_ino dev_ino_buf ;
chopt . root_dev_ino = get_root_dev_ino ( & dev_ino_buf ) ;
if ( chopt . root_dev_ino == NULL )
error ( EXIT_FAILURE , errno , _ ( lr_19 ) ,
quote ( lr_20 ) ) ;
}
bit_flags |= FTS_DEFER_STAT ;
ok = chown_files ( argv + optind , bit_flags ,
uid , gid ,
required_uid , required_gid , & chopt ) ;
chopt_free ( & chopt ) ;
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
