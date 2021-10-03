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
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
mode_t newmode ;
char const * specified_mode = NULL ;
int exit_status = EXIT_SUCCESS ;
int optc ;
security_context_t scontext = NULL ;
bool set_security_context = false ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_5 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( optc = getopt_long ( argc , argv , lr_6 , longopts , NULL ) ) != - 1 )
{
switch ( optc )
{
case 'm' :
specified_mode = optarg ; MST[STMT!TRAPSTMT]MSP[N]
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
set_security_context = true ;
}
else if ( optarg )
{
error ( 0 , 0 ,
_ ( lr_7
lr_8 ) ) ;
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
error ( 0 , 0 , _ ( lr_9 ) ) ;
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
_ ( lr_10 ) ,
quote ( scontext ) ) ;
}
newmode = MODE_RW_UGO ;
if ( specified_mode )
{
mode_t umask_value ;
struct mode_change * change = mode_compile ( specified_mode ) ;
if ( ! change )
error ( EXIT_FAILURE , 0 , _ ( lr_11 ) ) ;
umask_value = umask ( 0 ) ;
umask ( umask_value ) ;
newmode = mode_adjust ( newmode , false , umask_value , change , NULL ) ;
free ( change ) ;
if ( newmode & ~ S_IRWXUGO )
error ( EXIT_FAILURE , 0 ,
_ ( lr_12 ) ) ;
}
for (; optind < argc ; ++ optind )
{
if ( set_security_context )
defaultcon ( argv [ optind ] , S_IFIFO ) ;
if ( mkfifo ( argv [ optind ] , newmode ) != 0 )
{
error ( 0 , errno , _ ( lr_13 ) , quote ( argv [ optind ] ) ) ;
exit_status = EXIT_FAILURE ;
}
else if ( specified_mode && lchmod ( argv [ optind ] , newmode ) != 0 )
{
error ( 0 , errno , _ ( lr_14 ) ,
quote ( argv [ optind ] ) ) ;
exit_status = EXIT_FAILURE ;
}
}
exit ( exit_status ) ;
}
