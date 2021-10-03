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
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
printf ( USAGE_BUILTIN_WARNING , PROGRAM_NAME ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
verify_numeric ( const char * s , const char * end )
{
if ( errno )
{
error ( 0 , errno , lr_7 , s ) ;
exit_status = EXIT_FAILURE ;
}
else if ( * end )
{
if ( s == end )
error ( 0 , 0 , _ ( lr_8 ) , s ) ;
else
error ( 0 , 0 , _ ( lr_9 ) , s ) ;
exit_status = EXIT_FAILURE ;
}
}
static void
print_esc_char ( char c )
{
switch ( c )
{
case 'a' :
putchar ( '\a' ) ;
break;
case 'b' :
putchar ( '\b' ) ;
break;
case 'c' :
exit ( EXIT_SUCCESS ) ;
break;
case 'e' :
putchar ( '\x1B' ) ;
break;
case 'f' :
putchar ( '\f' ) ;
break;
case 'n' :
putchar ( '\n' ) ;
break;
case 'r' :
putchar ( '\r' ) ;
break;
case 't' :
putchar ( '\t' ) ;
break;
case 'v' :
putchar ( '\v' ) ;
break;
default:
putchar ( c ) ;
break;
}
}
static int
print_esc ( const char * escstart , bool octal_0 )
{
const char * p = escstart + 1 ;
int esc_value = 0 ;
int esc_length ;
if ( * p == 'x' )
{
for ( esc_length = 0 , ++ p ;
esc_length < 2 && isxdigit ( to_uchar ( * p ) ) ;
++ esc_length , ++ p )
esc_value = esc_value * 16 + hextobin ( * p ) ;
if ( esc_length == 0 )
error ( EXIT_FAILURE , 0 , _ ( lr_10 ) ) ;
putchar ( esc_value ) ;
}
else if ( isodigit ( * p ) )
{
for ( esc_length = 0 , p += octal_0 && * p == '0' ;
esc_length < 3 && isodigit ( * p ) ;
++ esc_length , ++ p )
esc_value = esc_value * 8 + octtobin ( * p ) ;
putchar ( esc_value ) ;
}
else if ( * p && strchr ( lr_11 , * p ) )
print_esc_char ( * p ++ ) ;
else if ( * p == 'u' || * p == 'U' )
{
char esc_char = * p ;
unsigned int uni_value ;
uni_value = 0 ;
for ( esc_length = ( esc_char == 'u' ? 4 : 8 ) , ++ p ;
esc_length > 0 ;
-- esc_length , ++ p )
{
if ( ! isxdigit ( to_uchar ( * p ) ) )
error ( EXIT_FAILURE , 0 , _ ( lr_10 ) ) ;
uni_value = uni_value * 16 + hextobin ( * p ) ;
}
if ( ( uni_value <= 0x9f
&& uni_value != 0x24 && uni_value != 0x40 && uni_value != 0x60 )
|| ( uni_value >= 0xd800 && uni_value <= 0xdfff ) )
error ( EXIT_FAILURE , 0 , _ ( lr_12 ) ,
esc_char , ( esc_char == 'u' ? 4 : 8 ) , uni_value ) ;
print_unicode_char ( stdout , uni_value , 0 ) ;
}
else
{
putchar ( '\\' ) ;
if ( * p )
{
putchar ( * p ) ;
p ++ ;
}
}
return p - escstart - 1 ;
}
static void
print_esc_string ( const char * str )
{
for (; * str ; str ++ )
if ( * str == '\\' )
str += print_esc ( str , true ) ;
else
putchar ( * str ) ;
}
static void
print_direc ( const char * start , size_t length , char conversion ,
bool have_field_width , int field_width ,
bool have_precision , int precision ,
char const * argument )
{
char * p ;
{
char * q ;
char const * length_modifier ;
size_t length_modifier_len ;
switch ( conversion )
{
case 'd' : case 'i' : case 'o' : case 'u' : case 'x' : case 'X' :
length_modifier = PRIdMAX ;
length_modifier_len = sizeof PRIdMAX - 2 ;
break;
case 'a' : case 'e' : case 'f' : case 'g' :
case 'A' : case 'E' : case 'F' : case 'G' :
length_modifier = lr_13 ;
length_modifier_len = 1 ;
break;
default:
length_modifier = start ;
length_modifier_len = 0 ;
break;
}
p = xmalloc ( length + length_modifier_len + 2 ) ;
q = mempcpy ( p , start , length ) ;
q = mempcpy ( q , length_modifier , length_modifier_len ) ;
* q ++ = conversion ;
* q = '\0' ;
}
switch ( conversion )
{
case 'd' :
case 'i' :
{
intmax_t arg = vstrtoimax ( argument ) ;
if ( ! have_field_width )
{
if ( ! have_precision )
xprintf ( p , arg ) ;
else
xprintf ( p , precision , arg ) ;
}
else
{
if ( ! have_precision )
xprintf ( p , field_width , arg ) ;
else
xprintf ( p , field_width , precision , arg ) ;
}
}
break;
case 'o' :
case 'u' :
case 'x' :
case 'X' :
{
uintmax_t arg = vstrtoumax ( argument ) ;
if ( ! have_field_width )
{
if ( ! have_precision )
xprintf ( p , arg ) ;
else
xprintf ( p , precision , arg ) ;
}
else
{
if ( ! have_precision )
xprintf ( p , field_width , arg ) ;
else
xprintf ( p , field_width , precision , arg ) ;
}
}
break;
case 'a' :
case 'A' :
case 'e' :
case 'E' :
case 'f' :
case 'F' :
case 'g' :
case 'G' :
{
long double arg = vstrtold ( argument ) ;
if ( ! have_field_width )
{
if ( ! have_precision )
xprintf ( p , arg ) ;
else
xprintf ( p , precision , arg ) ;
}
else
{
if ( ! have_precision )
xprintf ( p , field_width , arg ) ;
else
xprintf ( p , field_width , precision , arg ) ;
}
}
break;
case 'c' :
if ( ! have_field_width )
xprintf ( p , * argument ) ;
else
xprintf ( p , field_width , * argument ) ;
break;
case 's' :
if ( ! have_field_width )
{
if ( ! have_precision )
xprintf ( p , argument ) ;
else
xprintf ( p , precision , argument ) ;
}
else
{
if ( ! have_precision )
xprintf ( p , field_width , argument ) ;
else
xprintf ( p , field_width , precision , argument ) ;
}
break;
}
free ( p ) ;
}
static int
print_formatted ( const char * format , int argc , char * * argv )
{
int save_argc = argc ;
const char * f ;
const char * direc_start ;
size_t direc_length ;
bool have_field_width ;
int field_width = 0 ;
bool have_precision ;
int precision = 0 ;
char ok [ UCHAR_MAX + 1 ] ;
for ( f = format ; * f ; ++ f )
{
switch ( * f )
{
case '%' :
direc_start = f ++ ;
direc_length = 1 ;
have_field_width = have_precision = false ;
if ( * f == '%' )
{
putchar ( '%' ) ;
break;
}
if ( * f == 'b' )
{
if ( argc > 0 )
{
print_esc_string ( * argv ) ;
++ argv ;
-- argc ;
}
break;
}
memset ( ok , 0 , sizeof ok ) ;
ok [ 'a' ] = ok [ 'A' ] = ok [ 'c' ] = ok [ 'd' ] = ok [ 'e' ] = ok [ 'E' ] =
ok [ 'f' ] = ok [ 'F' ] = ok [ 'g' ] = ok [ 'G' ] = ok [ 'i' ] = ok [ 'o' ] =
ok [ 's' ] = ok [ 'u' ] = ok [ 'x' ] = ok [ 'X' ] = 1 ;
for (; ; f ++ , direc_length ++ )
switch ( * f )
{
#if ( __GLIBC__ == 2 && 2 <= __GLIBC_MINOR__ ) || 3 <= __GLIBC__
case 'I' :
#endif
case '\'' :
ok [ 'a' ] = ok [ 'A' ] = ok [ 'c' ] = ok [ 'e' ] = ok [ 'E' ] =
ok [ 'o' ] = ok [ 's' ] = ok [ 'x' ] = ok [ 'X' ] = 0 ;
break;
case '-' : case '+' : case ' ' :
break;
case '#' :
ok [ 'c' ] = ok [ 'd' ] = ok [ 'i' ] = ok [ 's' ] = ok [ 'u' ] = 0 ;
break;
case '0' :
ok [ 'c' ] = ok [ 's' ] = 0 ;
break;
default:
goto no_more_flag_characters;
}
no_more_flag_characters:
if ( * f == '*' )
{
++ f ;
++ direc_length ;
if ( argc > 0 )
{
intmax_t width = vstrtoimax ( * argv ) ;
if ( INT_MIN <= width && width <= INT_MAX )
field_width = width ;
else
error ( EXIT_FAILURE , 0 , _ ( lr_14 ) ,
* argv ) ;
++ argv ;
-- argc ;
}
else
field_width = 0 ;
have_field_width = true ;
}
else
while ( ISDIGIT ( * f ) )
{
++ f ;
++ direc_length ;
}
if ( * f == '.' )
{
++ f ;
++ direc_length ;
ok [ 'c' ] = 0 ;
if ( * f == '*' ) MST[EQ$@1$@2$!BITOR$@1$@2$]MSP[N]
{
++ f ;
++ direc_length ;
if ( argc > 0 )
{
intmax_t prec = vstrtoimax ( * argv ) ;
if ( prec < 0 )
{
precision = - 1 ;
}
else if ( INT_MAX < prec )
error ( EXIT_FAILURE , 0 , _ ( lr_15 ) ,
* argv ) ;
else
precision = prec ;
++ argv ;
-- argc ;
}
else
precision = 0 ;
have_precision = true ;
}
else
while ( ISDIGIT ( * f ) )
{
++ f ;
++ direc_length ;
}
}
while ( * f == 'l' || * f == 'L' || * f == 'h'
|| * f == 'j' || * f == 't' || * f == 'z' )
++ f ;
{
unsigned char conversion = * f ;
if ( ! ok [ conversion ] )
error ( EXIT_FAILURE , 0 ,
_ ( lr_16 ) ,
(int) ( f + 1 - direc_start ) , direc_start ) ;
}
print_direc ( direc_start , direc_length , * f ,
have_field_width , field_width ,
have_precision , precision ,
( argc <= 0 ? lr_17 : ( argc -- , * argv ++ ) ) ) ;
break;
case '\\' :
f += print_esc ( f , false ) ;
break;
default:
putchar ( * f ) ;
}
}
return save_argc - argc ;
}
int
main ( int argc , char * * argv )
{
char * format ;
int args_used ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_17 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
exit_status = EXIT_SUCCESS ;
posixly_correct = ( getenv ( lr_18 ) != NULL ) ;
if ( argc == 2 )
{
if ( STREQ ( argv [ 1 ] , lr_19 ) )
usage ( EXIT_SUCCESS ) ;
if ( STREQ ( argv [ 1 ] , lr_20 ) )
{
version_etc ( stdout , PROGRAM_NAME , PACKAGE_NAME , Version , AUTHORS ,
( char * ) NULL ) ;
exit ( EXIT_SUCCESS ) ;
}
}
if ( 1 < argc && STREQ ( argv [ 1 ] , lr_21 ) )
{
-- argc ;
++ argv ;
}
if ( argc <= 1 )
{
error ( 0 , 0 , _ ( lr_22 ) ) ;
usage ( EXIT_FAILURE ) ;
}
format = argv [ 1 ] ;
argc -= 2 ;
argv += 2 ;
do
{
args_used = print_formatted ( format , argc , argv ) ;
argc -= args_used ;
argv += args_used ;
}
while ( args_used > 0 && argc > 0 );
if ( argc > 0 )
error ( 0 , 0 ,
_ ( lr_23 ) ,
quote ( argv [ 0 ] ) ) ;
exit ( exit_status ) ;
}
