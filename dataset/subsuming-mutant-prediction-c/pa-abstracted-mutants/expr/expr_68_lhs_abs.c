static void mpz_clear ( mpz_t z ) { ( void ) z ; }
static void mpz_init_set_ui ( mpz_t z , unsigned long int i ) { z [ 0 ] = i ; }
static int
mpz_init_set_str ( mpz_t z , char * s , int base )
{
return xstrtoimax ( s , NULL , base , z , NULL ) == LONGINT_OK ? 0 : - 1 ;
}
static void
mpz_add ( mpz_t r , mpz_t a0 , mpz_t b0 )
{
intmax_t a = a0 [ 0 ] ;
intmax_t b = b0 [ 0 ] ;
intmax_t val = a + b ;
if ( ( val < a ) != ( b < 0 ) )
integer_overflow ( '+' ) ;
r [ 0 ] = val ;
}
static void
mpz_sub ( mpz_t r , mpz_t a0 , mpz_t b0 )
{
intmax_t a = a0 [ 0 ] ;
intmax_t b = b0 [ 0 ] ;
intmax_t val = a - b ;
if ( ( a < val ) != ( b < 0 ) )
integer_overflow ( '-' ) ;
r [ 0 ] = val ;
}
static void
mpz_mul ( mpz_t r , mpz_t a0 , mpz_t b0 )
{
intmax_t a = a0 [ 0 ] ;
intmax_t b = b0 [ 0 ] ;
intmax_t val = a * b ;
if ( ! ( a == 0 || b == 0
|| ( ( val < 0 ) == ( ( a < 0 ) ^ ( b < 0 ) ) && val / a == b ) ) )
integer_overflow ( '*' ) ;
r [ 0 ] = val ;
}
static void
mpz_tdiv_q ( mpz_t r , mpz_t a0 , mpz_t b0 )
{
intmax_t a = a0 [ 0 ] ;
intmax_t b = b0 [ 0 ] ;
if ( a < - INTMAX_MAX && b == - 1 )
integer_overflow ( '/' ) ;
r [ 0 ] = a / b ;
}
static void
mpz_tdiv_r ( mpz_t r , mpz_t a0 , mpz_t b0 )
{
intmax_t a = a0 [ 0 ] ;
intmax_t b = b0 [ 0 ] ;
r [ 0 ] = a < - INTMAX_MAX && b == - 1 ? 0 : a % b ;
}
static char *
mpz_get_str ( char const * str , int base , mpz_t z )
{
( void ) str ; ( void ) base ;
char buf [ INT_BUFSIZE_BOUND ( intmax_t ) ] ;
return xstrdup ( imaxtostr ( z [ 0 ] , buf ) ) ;
}
static int
mpz_sgn ( mpz_t z )
{
return z [ 0 ] < 0 ? - 1 : 0 < z [ 0 ] ;
}
static int
mpz_fits_ulong_p ( mpz_t z )
{
return 0 <= z [ 0 ] && z [ 0 ] <= ULONG_MAX ;
}
static unsigned long int
mpz_get_ui ( mpz_t z )
{
return z [ 0 ] ;
}
static int
mpz_out_str ( FILE * stream , int base , mpz_t z )
{
( void ) base ;
char buf [ INT_BUFSIZE_BOUND ( intmax_t ) ] ;
return fputs ( imaxtostr ( z [ 0 ] , buf ) , stream ) != EOF ;
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_1 ) ,
program_name , program_name ) ;
putchar ( '\n' ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static void
syntax_error ( void )
{
error ( EXPR_INVALID , 0 , _ ( lr_10 ) ) ;
}
static void
integer_overflow ( char op )
{
error ( EXPR_FAILURE , ERANGE , lr_11 , op ) ;
abort () ;
}
int
main ( int argc , char * * argv )
{
VALUE * v ;
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_12 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
initialize_exit_failure ( EXPR_FAILURE ) ;
atexit ( close_stdout ) ;
parse_long_options ( argc , argv , PROGRAM_NAME , PACKAGE_NAME , VERSION , MST[P!PLEFTINC$P$]MSP[]
usage , AUTHORS , ( char const * ) NULL ) ;
unsigned int u_argc = argc ;
if ( 1 < u_argc && STREQ ( argv [ 1 ] , lr_13 ) )
{
-- u_argc ;
++ argv ;
}
if ( u_argc <= 1 )
{
error ( 0 , 0 , _ ( lr_14 ) ) ;
usage ( EXPR_INVALID ) ;
}
args = argv + 1 ;
v = eval ( true ) ;
if ( ! nomoreargs () )
syntax_error () ;
printv ( v ) ;
exit ( null ( v ) ) ;
}
static VALUE *
int_value ( unsigned long int i )
{
VALUE * v = xmalloc ( sizeof *v ) ;
v -> type = integer ;
mpz_init_set_ui ( v -> u . i , i ) ;
return v ;
}
static VALUE *
str_value ( char const * s )
{
VALUE * v = xmalloc ( sizeof *v ) ;
v -> type = string ;
v -> u . s = xstrdup ( s ) ;
return v ;
}
static void
freev ( VALUE * v )
{
if ( v -> type == string )
free ( v -> u . s ) ;
else
mpz_clear ( v -> u . i ) ;
free ( v ) ;
}
static void
printv ( VALUE * v )
{
switch ( v -> type )
{
case integer :
mpz_out_str ( stdout , 10 , v -> u . i ) ;
putchar ( '\n' ) ;
break;
case string :
puts ( v -> u . s ) ;
break;
default:
abort () ;
}
}
static bool _GL_ATTRIBUTE_PURE
null ( VALUE * v )
{
switch ( v -> type )
{
case integer :
return mpz_sgn ( v -> u . i ) == 0 ;
case string :
{
char const * cp = v -> u . s ;
if ( * cp == '\0' )
return true ;
cp += ( * cp == '-' ) ;
do
{
if ( * cp != '0' )
return false ;
}
while ( * ++ cp );
return true ;
}
default:
abort () ;
}
}
static bool _GL_ATTRIBUTE_PURE
looks_like_integer ( char const * cp )
{
cp += ( * cp == '-' ) ;
do
if ( ! ISDIGIT ( * cp ) )
return false ;
while ( * ++ cp );
return true ;
}
static void
tostring ( VALUE * v )
{
switch ( v -> type )
{
case integer :
{
char * s = mpz_get_str ( NULL , 10 , v -> u . i ) ;
mpz_clear ( v -> u . i ) ;
v -> u . s = s ;
v -> type = string ;
}
break;
case string :
break;
default:
abort () ;
}
}
static bool
toarith ( VALUE * v )
{
switch ( v -> type )
{
case integer :
return true ;
case string :
{
char * s = v -> u . s ;
if ( ! looks_like_integer ( s ) )
return false ;
if ( mpz_init_set_str ( v -> u . i , s , 10 ) != 0 && ! HAVE_GMP )
error ( EXPR_FAILURE , ERANGE , lr_15 , s ) ;
free ( s ) ;
v -> type = integer ;
return true ;
}
default:
abort () ;
}
}
static size_t
getsize ( mpz_t i )
{
if ( mpz_sgn ( i ) < 0 )
return SIZE_MAX ;
if ( mpz_fits_ulong_p ( i ) )
{
unsigned long int ul = mpz_get_ui ( i ) ;
if ( ul < SIZE_MAX )
return ul ;
}
return SIZE_MAX - 1 ;
}
static bool
nextarg ( char const * str )
{
if ( * args == NULL )
return false ;
else
{
bool r = STREQ ( * args , str ) ;
args += r ;
return r ;
}
}
static bool
nomoreargs ( void )
{
return * args == 0 ;
}
static void
trace ( fxn )
char * fxn ;
{
char * * a ;
printf ( lr_16 , fxn ) ;
for ( a = args ; * a ; a ++ )
printf ( lr_17 , * a ) ;
putchar ( '\n' ) ;
}
static VALUE *
docolon ( VALUE * sv , VALUE * pv )
{
VALUE * v IF_LINT ( = NULL ) ;
const char * errmsg ;
struct re_pattern_buffer re_buffer ;
char fastmap [ UCHAR_MAX + 1 ] ;
struct re_registers re_regs ;
regoff_t matchlen ;
tostring ( sv ) ;
tostring ( pv ) ;
re_regs . num_regs = 0 ;
re_regs . start = NULL ;
re_regs . end = NULL ;
re_buffer . buffer = NULL ;
re_buffer . allocated = 0 ;
re_buffer . fastmap = fastmap ;
re_buffer . translate = NULL ;
re_syntax_options =
RE_SYNTAX_POSIX_BASIC & ~ RE_CONTEXT_INVALID_DUP & ~ RE_NO_EMPTY_RANGES ;
errmsg = re_compile_pattern ( pv -> u . s , strlen ( pv -> u . s ) , & re_buffer ) ;
if ( errmsg )
error ( EXPR_INVALID , 0 , lr_15 , errmsg ) ;
re_buffer . newline_anchor = 0 ;
matchlen = re_match ( & re_buffer , sv -> u . s , strlen ( sv -> u . s ) , 0 , & re_regs ) ;
if ( 0 <= matchlen )
{
if ( re_buffer . re_nsub > 0 )
{
sv -> u . s [ re_regs . end [ 1 ] ] = '\0' ;
v = str_value ( sv -> u . s + re_regs . start [ 1 ] ) ;
}
else
v = int_value ( matchlen ) ;
}
else if ( matchlen == - 1 )
{
if ( re_buffer . re_nsub > 0 )
v = str_value ( lr_12 ) ;
else
v = int_value ( 0 ) ;
}
else
error ( EXPR_FAILURE ,
( matchlen == - 2 ? errno : EOVERFLOW ) ,
_ ( lr_18 ) ) ;
if ( 0 < re_regs . num_regs )
{
free ( re_regs . start ) ;
free ( re_regs . end ) ;
}
re_buffer . fastmap = NULL ;
regfree ( & re_buffer ) ;
return v ;
}
static VALUE *
eval7 ( bool evaluate )
{
VALUE * v ;
#ifdef EVAL_TRACE
trace ( lr_19 ) ;
#endif
if ( nomoreargs () )
syntax_error () ;
if ( nextarg ( lr_20 ) )
{
v = eval ( evaluate ) ;
if ( ! nextarg ( lr_21 ) )
syntax_error () ;
return v ;
}
if ( nextarg ( lr_21 ) )
syntax_error () ;
return str_value ( * args ++ ) ;
}
static VALUE *
eval6 ( bool evaluate )
{
VALUE * l ;
VALUE * r ;
VALUE * v ;
VALUE * i1 ;
VALUE * i2 ;
#ifdef EVAL_TRACE
trace ( lr_22 ) ;
#endif
if ( nextarg ( lr_23 ) )
{
if ( nomoreargs () )
syntax_error () ;
return str_value ( * args ++ ) ;
}
else if ( nextarg ( lr_24 ) )
{
r = eval6 ( evaluate ) ;
tostring ( r ) ;
v = int_value ( strlen ( r -> u . s ) ) ;
freev ( r ) ;
return v ;
}
else if ( nextarg ( lr_25 ) )
{
l = eval6 ( evaluate ) ;
r = eval6 ( evaluate ) ;
if ( evaluate )
{
v = docolon ( l , r ) ;
freev ( l ) ;
}
else
v = l ;
freev ( r ) ;
return v ;
}
else if ( nextarg ( lr_26 ) )
{
size_t pos ;
l = eval6 ( evaluate ) ;
r = eval6 ( evaluate ) ;
tostring ( l ) ;
tostring ( r ) ;
pos = strcspn ( l -> u . s , r -> u . s ) ;
v = int_value ( l -> u . s [ pos ] ? pos + 1 : 0 ) ;
freev ( l ) ;
freev ( r ) ;
return v ;
}
else if ( nextarg ( lr_27 ) )
{
size_t llen ;
l = eval6 ( evaluate ) ;
i1 = eval6 ( evaluate ) ;
i2 = eval6 ( evaluate ) ;
tostring ( l ) ;
llen = strlen ( l -> u . s ) ;
if ( ! toarith ( i1 ) || ! toarith ( i2 ) )
v = str_value ( lr_12 ) ;
else
{
size_t pos = getsize ( i1 -> u . i ) ;
size_t len = getsize ( i2 -> u . i ) ;
if ( llen < pos || pos == 0 || len == 0 || len == SIZE_MAX )
v = str_value ( lr_12 ) ;
else
{
size_t vlen = MIN ( len , llen - pos + 1 ) ;
char * vlim ;
v = xmalloc ( sizeof *v ) ;
v -> type = string ;
v -> u . s = xmalloc ( vlen + 1 ) ;
vlim = mempcpy ( v -> u . s , l -> u . s + pos - 1 , vlen ) ;
* vlim = '\0' ;
}
}
freev ( l ) ;
freev ( i1 ) ;
freev ( i2 ) ;
return v ;
}
else
return eval7 ( evaluate ) ;
}
static VALUE *
eval5 ( bool evaluate )
{
VALUE * l ;
VALUE * r ;
VALUE * v ;
#ifdef EVAL_TRACE
trace ( lr_28 ) ;
#endif
l = eval6 ( evaluate ) ;
while ( 1 )
{
if ( nextarg ( lr_29 ) )
{
r = eval6 ( evaluate ) ;
if ( evaluate )
{
v = docolon ( l , r ) ;
freev ( l ) ;
l = v ;
}
freev ( r ) ;
}
else
return l ;
}
}
static VALUE *
eval4 ( bool evaluate )
{
VALUE * l ;
VALUE * r ;
enum { multiply , divide , mod } fxn ;
#ifdef EVAL_TRACE
trace ( lr_30 ) ;
#endif
l = eval5 ( evaluate ) ;
while ( 1 )
{
if ( nextarg ( lr_31 ) )
fxn = multiply ;
else if ( nextarg ( lr_32 ) )
fxn = divide ;
else if ( nextarg ( lr_33 ) )
fxn = mod ;
else
return l ;
r = eval5 ( evaluate ) ;
if ( evaluate )
{
if ( ! toarith ( l ) || ! toarith ( r ) )
error ( EXPR_INVALID , 0 , _ ( lr_34 ) ) ;
if ( fxn != multiply && mpz_sgn ( r -> u . i ) == 0 )
error ( EXPR_INVALID , 0 , _ ( lr_35 ) ) ;
( ( fxn == multiply ? mpz_mul
: fxn == divide ? mpz_tdiv_q
: mpz_tdiv_r )
( l -> u . i , l -> u . i , r -> u . i ) ) ;
}
freev ( r ) ;
}
}
static VALUE *
eval3 ( bool evaluate )
{
VALUE * l ;
VALUE * r ;
enum { plus , minus } fxn ;
#ifdef EVAL_TRACE
trace ( lr_36 ) ;
#endif
l = eval4 ( evaluate ) ;
while ( 1 )
{
if ( nextarg ( lr_23 ) )
fxn = plus ;
else if ( nextarg ( lr_37 ) )
fxn = minus ;
else
return l ;
r = eval4 ( evaluate ) ;
if ( evaluate )
{
if ( ! toarith ( l ) || ! toarith ( r ) )
error ( EXPR_INVALID , 0 , _ ( lr_34 ) ) ;
( fxn == plus ? mpz_add : mpz_sub ) ( l -> u . i , l -> u . i , r -> u . i ) ;
}
freev ( r ) ;
}
}
static VALUE *
eval2 ( bool evaluate )
{
VALUE * l ;
#ifdef EVAL_TRACE
trace ( lr_38 ) ;
#endif
l = eval3 ( evaluate ) ;
while ( 1 )
{
VALUE * r ;
enum
{
less_than , less_equal , equal , not_equal , greater_equal , greater_than
} fxn ;
bool val = false ;
if ( nextarg ( lr_39 ) )
fxn = less_than ;
else if ( nextarg ( lr_40 ) )
fxn = less_equal ;
else if ( nextarg ( lr_41 ) || nextarg ( lr_42 ) )
fxn = equal ;
else if ( nextarg ( lr_43 ) )
fxn = not_equal ;
else if ( nextarg ( lr_44 ) )
fxn = greater_equal ;
else if ( nextarg ( lr_45 ) )
fxn = greater_than ;
else
return l ;
r = eval3 ( evaluate ) ;
if ( evaluate )
{
int cmp ;
tostring ( l ) ;
tostring ( r ) ;
if ( looks_like_integer ( l -> u . s ) && looks_like_integer ( r -> u . s ) )
cmp = strintcmp ( l -> u . s , r -> u . s ) ;
else
{
errno = 0 ;
cmp = strcoll ( l -> u . s , r -> u . s ) ;
if ( errno )
{
error ( 0 , errno , _ ( lr_46 ) ) ;
error ( 0 , 0 , _ ( lr_47 ) ) ;
error ( EXPR_INVALID , 0 ,
_ ( lr_48 ) ,
quotearg_n_style ( 0 , locale_quoting_style , l -> u . s ) ,
quotearg_n_style ( 1 , locale_quoting_style , r -> u . s ) ) ;
}
}
switch ( fxn )
{
case less_than : val = ( cmp < 0 ) ; break;
case less_equal : val = ( cmp <= 0 ) ; break;
case equal : val = ( cmp == 0 ) ; break;
case not_equal : val = ( cmp != 0 ) ; break;
case greater_equal : val = ( cmp >= 0 ) ; break;
case greater_than : val = ( cmp > 0 ) ; break;
default: abort () ;
}
}
freev ( l ) ;
freev ( r ) ;
l = int_value ( val ) ;
}
}
static VALUE *
eval1 ( bool evaluate )
{
VALUE * l ;
VALUE * r ;
#ifdef EVAL_TRACE
trace ( lr_49 ) ;
#endif
l = eval2 ( evaluate ) ;
while ( 1 )
{
if ( nextarg ( lr_50 ) )
{
r = eval2 ( evaluate && ! null ( l ) ) ;
if ( null ( l ) || null ( r ) )
{
freev ( l ) ;
freev ( r ) ;
l = int_value ( 0 ) ;
}
else
freev ( r ) ;
}
else
return l ;
}
}
static VALUE *
eval ( bool evaluate )
{
VALUE * l ;
VALUE * r ;
#ifdef EVAL_TRACE
trace ( lr_51 ) ;
#endif
l = eval1 ( evaluate ) ;
while ( 1 )
{
if ( nextarg ( lr_52 ) )
{
r = eval1 ( evaluate && null ( l ) ) ;
if ( null ( l ) )
{
freev ( l ) ;
l = r ;
if ( null ( l ) )
{
freev ( l ) ;
l = int_value ( 0 ) ;
}
}
else
freev ( r ) ;
}
else
return l ;
}
}
