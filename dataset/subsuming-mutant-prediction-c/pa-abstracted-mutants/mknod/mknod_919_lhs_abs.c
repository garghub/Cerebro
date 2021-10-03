void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) ,
program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
emit_mandatory_arg_note () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
printf ( USAGE_BUILTIN_WARNING , PROGRAM_NAME ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
mode_t newmode ;
char const * specified_mode = NULL ;
int optc ;
int expected_operands ;
mode_t node_type ;
security_context_t scontext = NULL ;
bool set_security_context = false ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_7 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( ( optc = getopt_long ( argc , argv , lr_8 , longopts , NULL ) ) != - 1 )
{
switch ( optc )
{
case 'm' :
specified_mode = optarg ;
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
_ ( lr_9
lr_10 ) ) ;
}
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
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
expected_operands = ( argc <= optind
|| ( optind + 1 < argc && argv [ optind + 1 ] [ 0 ] == 'p' )
? 2 : 4 ) ;
if ( argc - optind < expected_operands )
{
if ( argc <= optind ) MST[LE$@1$@2$!MOD$@2$@1$]MSP[]
error ( 0 , 0 , _ ( lr_13 ) ) ;
else
error ( 0 , 0 , _ ( lr_14 ) , quote ( argv [ argc - 1 ] ) ) ;
if ( expected_operands == 4 && argc - optind == 2 )
fprintf ( stderr , lr_15 ,
_ ( lr_16 ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( expected_operands < argc - optind )
{
error ( 0 , 0 , _ ( lr_17 ) ,
quote ( argv [ optind + expected_operands ] ) ) ;
if ( expected_operands == 2 && argc - optind == 4 )
fprintf ( stderr , lr_15 ,
_ ( lr_18 ) ) ;
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
_ ( lr_19 ) ,
quote ( scontext ) ) ;
}
switch ( argv [ optind + 1 ] [ 0 ] )
{
case 'b' :
#ifndef S_IFBLK
error ( EXIT_FAILURE , 0 , _ ( lr_20 ) ) ;
#else
node_type = S_IFBLK ;
#endif
goto block_or_character;
case 'c' :
case 'u' :
#ifndef S_IFCHR
error ( EXIT_FAILURE , 0 , _ ( lr_21 ) ) ;
#else
node_type = S_IFCHR ;
#endif
goto block_or_character;
block_or_character:
{
char const * s_major = argv [ optind + 2 ] ;
char const * s_minor = argv [ optind + 3 ] ;
uintmax_t i_major , i_minor ;
dev_t device ;
if ( xstrtoumax ( s_major , NULL , 0 , & i_major , NULL ) != LONGINT_OK
|| i_major != ( major_t ) i_major )
error ( EXIT_FAILURE , 0 ,
_ ( lr_22 ) , quote ( s_major ) ) ;
if ( xstrtoumax ( s_minor , NULL , 0 , & i_minor , NULL ) != LONGINT_OK
|| i_minor != ( minor_t ) i_minor )
error ( EXIT_FAILURE , 0 ,
_ ( lr_23 ) , quote ( s_minor ) ) ;
device = makedev ( i_major , i_minor ) ;
#ifdef NODEV
if ( device == NODEV )
error ( EXIT_FAILURE , 0 , _ ( lr_24 ) , s_major , s_minor ) ;
#endif
if ( set_security_context )
defaultcon ( argv [ optind ] , node_type ) ;
if ( mknod ( argv [ optind ] , newmode | node_type , device ) != 0 )
error ( EXIT_FAILURE , errno , lr_25 , quote ( argv [ optind ] ) ) ;
}
break;
case 'p' :
if ( set_security_context )
defaultcon ( argv [ optind ] , S_IFIFO ) ;
if ( mkfifo ( argv [ optind ] , newmode ) != 0 )
error ( EXIT_FAILURE , errno , lr_25 , quote ( argv [ optind ] ) ) ;
break;
default:
error ( 0 , 0 , _ ( lr_26 ) , quote ( argv [ optind + 1 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( specified_mode && lchmod ( argv [ optind ] , newmode ) != 0 )
error ( EXIT_FAILURE , errno , _ ( lr_27 ) ,
quote ( argv [ optind ] ) ) ;
exit ( EXIT_SUCCESS ) ;
}
