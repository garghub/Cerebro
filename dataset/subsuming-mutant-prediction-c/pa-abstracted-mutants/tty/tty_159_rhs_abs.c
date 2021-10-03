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
char * tty ;
int optc ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_3 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
initialize_exit_failure ( TTY_WRITE_ERROR ) ;
atexit ( close_stdout ) ;
silent = false ;
while ( ( optc = getopt_long ( argc , argv , lr_4 , longopts , NULL ) ) != - 1 ) MST[NEQ$@1$@2$!BITAND$@1$@2$]MSP[N]
{
switch ( optc )
{
case 's' :
silent = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( TTY_FAILURE ) ;
}
}
if ( optind < argc )
error ( 0 , 0 , _ ( lr_5 ) , quote ( argv [ optind ] ) ) ;
tty = ttyname ( STDIN_FILENO ) ;
if ( ! silent )
{
if ( tty )
puts ( tty ) ;
else
puts ( _ ( lr_6 ) ) ;
}
exit ( isatty ( STDIN_FILENO ) ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
