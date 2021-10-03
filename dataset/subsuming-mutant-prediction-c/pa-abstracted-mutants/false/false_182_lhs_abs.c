void
usage ( int status )
{
printf ( _ ( lr_1 ) ,
program_name , program_name ) ;
printf ( lr_2 ,
_ ( EXIT_STATUS == EXIT_SUCCESS
? N_ ( lr_3 )
: N_ ( lr_4 ) ) ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
printf ( USAGE_BUILTIN_WARNING , PROGRAM_NAME ) ;
emit_ancillary_info () ;
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
if ( argc == 2 )
{
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_5 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
if ( STREQ ( argv [ 1 ] , lr_6 ) ) MST[P!PLEFTDEC$P$]MSP[]
usage ( EXIT_STATUS ) ;
if ( STREQ ( argv [ 1 ] , lr_7 ) )
version_etc ( stdout , PROGRAM_NAME , PACKAGE_NAME , Version , AUTHORS ,
( char * ) NULL ) ;
}
exit ( EXIT_STATUS ) ;
}
