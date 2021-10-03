void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name , program_name ) ;
fputs ( _ ( lr_2 ) ,
stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_3 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
parse_long_options ( argc , argv , PROGRAM_NAME , PACKAGE_NAME , Version ,
usage , AUTHORS , ( char const * ) NULL ) ;
if ( getopt_long ( argc , argv , lr_3 , NULL , NULL ) != - 1 )
usage ( EXIT_FAILURE ) ;
if ( argc < optind + 2 )
{
if ( argc < optind + 1 )
error ( 0 , 0 , _ ( lr_4 ) ) ;
else
error ( 0 , 0 , _ ( lr_5 ) , quote ( argv [ optind ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( optind + 2 < argc )
{
error ( 0 , 0 , _ ( lr_6 ) , quote ( argv [ optind + 2 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( link ( argv [ optind ] , argv [ optind + 1 ] ) != 0 ) MST[PADD_DEREF$P1$@2$!PDEREF_LEFTDEC$P1$]MSP[N]
error ( EXIT_FAILURE , errno , _ ( lr_7 ) ,
quote_n ( 0 , argv [ optind + 1 ] ) , quote_n ( 1 , argv [ optind ] ) ) ;
exit ( EXIT_SUCCESS ) ;
}
