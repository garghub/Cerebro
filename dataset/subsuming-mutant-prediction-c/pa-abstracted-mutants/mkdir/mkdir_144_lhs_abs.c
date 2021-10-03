void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
announce_mkdir ( char const * dir , void * options )
{
struct mkdir_options const * o = options ;
if ( o -> created_directory_format )
prog_fprintf ( stdout , o -> created_directory_format , quote ( dir ) ) ;
}
static int
make_ancestor ( char const * dir , char const * component , void * options )
{
struct mkdir_options const * o = options ;
if ( o -> set_security_context && defaultcon ( dir , S_IFDIR ) < 0
&& ! ignorable_ctx_err ( errno ) )
error ( 0 , errno , _ ( lr_4 ) ,
quote ( dir ) ) ;
mode_t user_wx = S_IWUSR | S_IXUSR ;
bool self_denying_umask = ( o -> umask_value & user_wx ) != 0 ;
if ( self_denying_umask )
umask ( o -> umask_value & ~ user_wx ) ;
int r = mkdir ( component , S_IRWXUGO ) ;
if ( self_denying_umask )
{
int mkdir_errno = errno ;
umask ( o -> umask_value ) ;
errno = mkdir_errno ;
}
if ( r == 0 )
{
r = ( o -> umask_value & S_IRUSR ) != 0 ;
announce_mkdir ( dir , options ) ;
}
return r ;
}
static int
process_dir ( char * dir , struct savewd * wd , void * options )
{
struct mkdir_options const * o = options ;
bool set_defaultcon = false ;
if ( o -> set_security_context )
{
if ( ! o -> make_ancestor_function )
set_defaultcon = true ;
else
{
char * pdir = dir_name ( dir ) ;
struct stat st ;
if ( STREQ ( pdir , lr_5 )
|| ( stat ( pdir , & st ) == 0 && S_ISDIR ( st . st_mode ) ) )
set_defaultcon = true ;
free ( pdir ) ;
}
if ( set_defaultcon && defaultcon ( dir , S_IFDIR ) < 0
&& ! ignorable_ctx_err ( errno ) )
error ( 0 , errno , _ ( lr_4 ) ,
quote ( dir ) ) ;
}
int ret = ( make_dir_parents ( dir , wd , o -> make_ancestor_function , options ,
o -> mode , announce_mkdir ,
o -> mode_bits , ( uid_t ) - 1 , ( gid_t ) - 1 , true )
? EXIT_SUCCESS
: EXIT_FAILURE ) ;
if ( ret == EXIT_SUCCESS && o -> set_security_context && ! set_defaultcon )
{
if ( ! restorecon ( last_component ( dir ) , false , false )
&& ! ignorable_ctx_err ( errno ) )
error ( 0 , errno , _ ( lr_6 ) ,
quote ( dir ) ) ;
}
return ret ;
}
int
main ( int argc , char * * argv )
{
const char * specified_mode = NULL ;
int optc ;
security_context_t scontext = NULL ;
struct mkdir_options options ;
options . make_ancestor_function = NULL ;
options . mode = S_IRWXUGO ;
options . mode_bits = 0 ;
options . created_directory_format = NULL ;
options . set_security_context = false ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_7 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( optc = getopt_long ( argc , argv , lr_8 , longopts , NULL ) ) != - 1 ) MST[NEQ$@1$@2$!ADD$@1$@2$]MSP[]
{
switch ( optc )
{
case 'p' :
options . make_ancestor_function = make_ancestor ;
break;
case 'm' :
specified_mode = optarg ;
break;
case 'v' :
options . created_directory_format = _ ( lr_9 ) ;
break;
case 'Z' :
if ( is_smack_enabled () )
{
scontext = optarg ;
}
else if ( is_selinux_enabled () > 0 )
{
if ( optarg )
scontext = optarg ;
else
options . set_security_context = true ;
}
else if ( optarg )
{
error ( 0 , 0 ,
_ ( lr_10
lr_11 ) ) ;
}
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( optind == argc )
{
error ( 0 , 0 , _ ( lr_12 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( scontext )
{
int ret = 0 ;
if ( is_smack_enabled () )
ret = smack_set_label_for_self ( scontext ) ;
else
ret = setfscreatecon ( scontext ) ;
if ( ret < 0 )
error ( EXIT_FAILURE , errno ,
_ ( lr_13 ) ,
quote ( scontext ) ) ;
}
if ( options . make_ancestor_function || specified_mode )
{
mode_t umask_value = umask ( 0 ) ;
umask ( umask_value ) ;
options . umask_value = umask_value ;
if ( specified_mode )
{
struct mode_change * change = mode_compile ( specified_mode ) ;
if ( ! change )
error ( EXIT_FAILURE , 0 , _ ( lr_14 ) ,
quote ( specified_mode ) ) ;
options . mode = mode_adjust ( S_IRWXUGO , true , umask_value , change ,
& options . mode_bits ) ;
free ( change ) ;
}
else
options . mode = S_IRWXUGO ;
}
exit ( savewd_process_files ( argc - optind , argv + optind ,
process_dir , & options ) ) ;
}
