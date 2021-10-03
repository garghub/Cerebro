void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ; MST[STMT!DELSTMT]MSP[S]
else
{
printf ( _ ( lr_1 ) ,
program_name , program_name ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static bool
apply_suffix ( double * x , char suffix_char )
{
int multiplier ;
switch ( suffix_char )
{
case 0 :
case 's' :
multiplier = 1 ;
break;
case 'm' :
multiplier = 60 ;
break;
case 'h' :
multiplier = 60 * 60 ;
break;
case 'd' :
multiplier = 60 * 60 * 24 ;
break;
default:
return false ;
}
* x *= multiplier ;
return true ;
}
int
main ( int argc , char * * argv )
{
int i ;
double seconds = 0.0 ;
bool ok = true ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_2 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
parse_long_options ( argc , argv , PROGRAM_NAME , PACKAGE_NAME , Version ,
usage , AUTHORS , ( char const * ) NULL ) ;
if ( getopt_long ( argc , argv , lr_2 , NULL , NULL ) != - 1 )
usage ( EXIT_FAILURE ) ;
if ( argc == 1 )
{
error ( 0 , 0 , _ ( lr_3 ) ) ;
usage ( EXIT_FAILURE ) ;
}
for ( i = optind ; i < argc ; i ++ )
{
double s ;
const char * p ;
if ( ! xstrtod ( argv [ i ] , & p , & s , c_strtod )
|| ! ( 0 <= s )
|| ( * p && * ( p + 1 ) )
|| ! apply_suffix ( & s , * p ) )
{
error ( 0 , 0 , _ ( lr_4 ) , quote ( argv [ i ] ) ) ;
ok = false ;
}
seconds += s ;
}
if ( ! ok )
usage ( EXIT_FAILURE ) ;
if ( xnanosleep ( seconds ) )
error ( EXIT_FAILURE , errno , _ ( lr_5 ) ) ;
exit ( EXIT_SUCCESS ) ;
}
