void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
unsigned long nproc , ignore = 0 ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_4 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
enum nproc_query mode = NPROC_CURRENT_OVERRIDABLE ;
while ( 1 )
{
int c = getopt_long ( argc , argv , lr_4 , longopts , NULL ) ;
if ( c == - 1 )
break;
switch ( c )
{
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
case ALL_OPTION :
mode = NPROC_ALL ;
break;
case IGNORE_OPTION :
if ( xstrtoul ( optarg , NULL , 10 , & ignore , lr_4 ) != LONGINT_OK )
{
error ( 0 , 0 , _ ( lr_5 ) , optarg ) ;
usage ( EXIT_FAILURE ) ;
}
break;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( argc != optind ) MST[NEQ$@1$@2$!CONSTVAL$0$]MSP[]
{
error ( 0 , 0 , _ ( lr_6 ) , quote ( argv [ optind ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
nproc = num_processors ( mode ) ;
if ( ignore < nproc )
nproc -= ignore ;
else
nproc = 1 ;
printf ( lr_7 , nproc ) ;
exit ( EXIT_SUCCESS ) ;
}
