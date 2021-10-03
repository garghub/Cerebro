void
usage ( int status )
{
if ( status != EXIT_SUCCESS ) MST[NEQ$@1$@2$!SUB$@2$@1$]MSP[]
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) ,
program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
printf ( _ ( lr_4 ) ,
program_name , program_name , program_name ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
int
main ( int argc , char * * argv )
{
static char const dot = '.' ;
bool use_nuls = false ;
char const * result ;
size_t len ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_5 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
while ( true )
{
int c = getopt_long ( argc , argv , lr_6 , longopts , NULL ) ;
if ( c == - 1 )
break;
switch ( c )
{
case 'z' :
use_nuls = true ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
if ( argc < optind + 1 )
{
error ( 0 , 0 , _ ( lr_7 ) ) ;
usage ( EXIT_FAILURE ) ;
}
for (; optind < argc ; optind ++ )
{
result = argv [ optind ] ;
len = dir_len ( result ) ;
if ( ! len )
{
result = & dot ;
len = 1 ;
}
fwrite ( result , 1 , len , stdout ) ;
putchar ( use_nuls ? '\0' : '\n' ) ;
}
exit ( EXIT_SUCCESS ) ;
}
