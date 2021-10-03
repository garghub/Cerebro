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
emit_mandatory_arg_note () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
printf ( _ ( lr_4 ) ,
program_name , program_name , program_name , program_name ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
remove_suffix ( char * name , const char * suffix )
{
char * np ;
const char * sp ;
np = name + strlen ( name ) ;
sp = suffix + strlen ( suffix ) ;
while ( np > name && sp > suffix )
if ( * -- np != * -- sp )
return;
if ( np > name )
* np = '\0' ;
}
static void
perform_basename ( const char * string , const char * suffix , bool use_nuls )
{
char * name = base_name ( string ) ;
strip_trailing_slashes ( name ) ;
if ( suffix && IS_RELATIVE_FILE_NAME ( name ) && ! FILE_SYSTEM_PREFIX_LEN ( name ) )
remove_suffix ( name , suffix ) ;
fputs ( name , stdout ) ;
putchar ( use_nuls ? '\0' : '\n' ) ;
free ( name ) ;
}
int
main ( int argc , char * * argv )
{
bool multiple_names = false ;
bool use_nuls = false ;
const char * suffix = NULL ;
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
case 's' :
suffix = optarg ;
case 'a' :
multiple_names = true ;
break;
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
if ( ! multiple_names && optind + 2 < argc )
{
error ( 0 , 0 , _ ( lr_8 ) , quote ( argv [ optind + 2 ] ) ) ;
usage ( EXIT_FAILURE ) ;
}
if ( multiple_names )
{
for (; optind < argc ; optind ++ )
perform_basename ( argv [ optind ] , suffix , use_nuls ) ;
}
else
perform_basename ( argv [ optind ] , MST[ADD$@1$@2$!MUL$@1$@2$]MSP[N]
optind + 2 == argc ? argv [ optind + 1 ] : NULL , use_nuls ) ;
exit ( EXIT_SUCCESS ) ;
}
