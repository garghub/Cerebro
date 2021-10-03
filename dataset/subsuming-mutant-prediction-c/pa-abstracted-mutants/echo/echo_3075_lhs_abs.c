void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) , program_name , program_name ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( DEFAULT_ECHO_TO_XPG
? N_ ( lr_3 )
: N_ ( lr_4 ) ) ,
stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
printf ( USAGE_BUILTIN_WARNING , PROGRAM_NAME ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static int
hextobin ( unsigned char c )
{
switch ( c )
{
default: return c - '0' ;
case 'a' : case 'A' : return 10 ;
case 'b' : case 'B' : return 11 ;
case 'c' : case 'C' : return 12 ;
case 'd' : case 'D' : return 13 ;
case 'e' : case 'E' : return 14 ;
case 'f' : case 'F' : return 15 ;
}
}
int
main ( int argc , char * * argv )
{
bool display_return = true ;
bool allow_options =
( ! getenv ( lr_8 )
|| ( ! DEFAULT_ECHO_TO_XPG && 1 < argc && STREQ ( argv [ 1 ] , lr_9 ) ) ) ;
bool do_v9 = DEFAULT_ECHO_TO_XPG ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_10 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
if ( allow_options && argc == 2 )
{
if ( STREQ ( argv [ 1 ] , lr_11 ) )
usage ( EXIT_SUCCESS ) ;
if ( STREQ ( argv [ 1 ] , lr_12 ) )
{
version_etc ( stdout , PROGRAM_NAME , PACKAGE_NAME , Version , AUTHORS ,
( char * ) NULL ) ;
exit ( EXIT_SUCCESS ) ;
}
}
-- argc ;
++ argv ;
if ( allow_options )
while ( argc > 0 && * argv [ 0 ] == '-' )
{
char const * temp = argv [ 0 ] + 1 ;
size_t i ;
for ( i = 0 ; temp [ i ] ; i ++ )
switch ( temp [ i ] )
{
case 'e' : case 'E' : case 'n' :
break;
default:
goto just_echo;
}
if ( i == 0 )
goto just_echo;
while ( * temp )
switch ( * temp ++ )
{
case 'e' :
do_v9 = true ;
break;
case 'E' :
do_v9 = false ;
break;
case 'n' :
display_return = false ;
break;
}
argc -- ;
argv ++ ;
}
just_echo:
if ( do_v9 )
{
while ( argc > 0 )
{
char const * s = argv [ 0 ] ;
unsigned char c ;
while ( ( c = * s ++ ) )
{
if ( c == '\\' && * s )
{
switch ( c = * s ++ )
{
case 'a' : c = '\a' ; break;
case 'b' : c = '\b' ; break;
case 'c' : exit ( EXIT_SUCCESS ) ;
case 'e' : c = '\x1B' ; break;
case 'f' : c = '\f' ; break;
case 'n' : c = '\n' ; break;
case 'r' : c = '\r' ; break;
case 't' : c = '\t' ; break;
case 'v' : c = '\v' ; break;
case 'x' :
{
unsigned char ch = * s ;
if ( ! isxdigit ( ch ) )
goto not_an_escape;
s ++ ;
c = hextobin ( ch ) ;
ch = * s ;
if ( isxdigit ( ch ) )
{
s ++ ;
c = c * 16 + hextobin ( ch ) ;
}
}
break;
case '0' :
c = 0 ;
if ( ! ( '0' <= * s && * s <= '7' ) )
break;
c = * s ++ ;
case '1' : case '2' : case '3' :
case '4' : case '5' : case '6' : case '7' :
c -= '0' ;
if ( '0' <= * s && * s <= '7' )
c = c * 8 + ( * s ++ - '0' ) ;
if ( '0' <= * s && * s <= '7' )
c = c * 8 + ( * s ++ - '0' ) ;
break;
case '\\' : break;
not_an_escape:
default: putchar ( '\\' ) ; break;
}
}
putchar ( c ) ;
}
argc -- ;
argv ++ ;
if ( argc > 0 )
putchar ( ' ' ) ;
}
}
else
{
while ( argc > 0 )
{
fputs ( argv [ 0 ] , stdout ) ;
argc -- ;
argv ++ ; MST[P!PLEFTINC$P$]MSP[]
if ( argc > 0 )
putchar ( ' ' ) ;
}
}
if ( display_return )
putchar ( '\n' ) ;
exit ( EXIT_SUCCESS ) ;
}
