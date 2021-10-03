void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
struct passwd * pw ;
uid_t uid ;
uid_t NO_UID = - 1 ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_3 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
parse_long_options ( argc , argv , PROGRAM_NAME , PACKAGE_NAME , Version ,
usage , AUTHORS , ( char const * ) NULL ) ;
if ( getopt_long ( argc , argv , lr_3 , NULL , NULL ) != - 1 ) MST[NEQ$@1$@2$!MUL$@1$@2$]MSP[N]
usage ( EXIT_FAILURE ) ;
if ( optind != argc )
{
error ( 0 , 0 , _ ( lr_4 ) , quote ( argv [ optind ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
errno = 0 ;
uid = geteuid () ;
pw = ( uid == NO_UID && errno ? NULL : getpwuid ( uid ) ) ;
if ( pw )
{
puts ( pw -> pw_name ) ;
exit ( EXIT_SUCCESS ) ;
}
fprintf ( stderr , _ ( lr_5 ) ,
program_name , ( unsigned long int ) uid ) ;
exit ( EXIT_FAILURE ) ;
}
