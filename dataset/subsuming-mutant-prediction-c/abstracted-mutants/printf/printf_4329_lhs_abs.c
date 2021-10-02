void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
printf ( vl_5 , vl_6 ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static void
fn_4 ( const char * vr_2 , const char * vr_3 )
{
if ( vl_7 )
{
error ( 0 , vl_7 , lr_7 , vr_2 ) ;
vl_8 = vl_9 ;
}
else if ( * vr_3 )
{
if ( vr_2 == vr_3 )
error ( 0 , 0 , _ ( lr_8 ) , vr_2 ) ;
else
error ( 0 , 0 , _ ( lr_9 ) , vr_2 ) ;
vl_8 = vl_9 ;
}
}
static void
fn_5 ( char vr_4 )
{
switch ( vr_4 )
{
case 'a' :
putchar ( '\a' ) ;
break;
case 'b' :
putchar ( '\b' ) ;
break;
case 'c' :
exit ( vl_1 ) ;
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
putchar ( vr_4 ) ;
break;
}
}
static int
fn_6 ( const char * vr_5 , bool vr_6 )
{
const char * vr_7 = vr_5 + 1 ;
int vr_8 = 0 ;
int vr_9 ;
if ( * vr_7 == 'x' )
{
for ( vr_9 = 0 , ++ vr_7 ;
vr_9 < 2 && isxdigit ( fn_7 ( * vr_7 ) ) ;
++ vr_9 , ++ vr_7 )
vr_8 = vr_8 * 16 + fn_8 ( * vr_7 ) ;
if ( vr_9 == 0 )
error ( vl_9 , 0 , _ ( lr_10 ) ) ;
putchar ( vr_8 ) ;
}
else if ( fn_9 ( * vr_7 ) )
{
for ( vr_9 = 0 , vr_7 += vr_6 && * vr_7 == '0' ;
vr_9 < 3 && fn_9 ( * vr_7 ) ;
++ vr_9 , ++ vr_7 )
vr_8 = vr_8 * 8 + fn_10 ( * vr_7 ) ;
putchar ( vr_8 ) ;
}
else if ( * vr_7 && strchr ( lr_11 , * vr_7 ) )
fn_5 ( * vr_7 ++ ) ;
else if ( * vr_7 == 'u' || * vr_7 == 'U' )
{
char vr_10 = * vr_7 ;
unsigned int vr_11 ;
vr_11 = 0 ;
for ( vr_9 = ( vr_10 == 'u' ? 4 : 8 ) , ++ vr_7 ;
vr_9 > 0 ;
-- vr_9 , ++ vr_7 )
{
if ( ! isxdigit ( fn_7 ( * vr_7 ) ) )
error ( vl_9 , 0 , _ ( lr_10 ) ) ;
vr_11 = vr_11 * 16 + fn_8 ( * vr_7 ) ;
}
if ( ( vr_11 <= 0x9f
&& vr_11 != 0x24 && vr_11 != 0x40 && vr_11 != 0x60 )
|| ( vr_11 >= 0xd800 && vr_11 <= 0xdfff ) )
error ( vl_9 , 0 , _ ( lr_12 ) ,
vr_10 , ( vr_10 == 'u' ? 4 : 8 ) , vr_11 ) ;
fn_11 ( stdout , vr_11 , 0 ) ;
}
else
{
putchar ( '\\' ) ;
if ( * vr_7 )
{
putchar ( * vr_7 ) ;
vr_7 ++ ;
}
}
return vr_7 - vr_5 - 1 ;
}
static void
fn_12 ( const char * vr_12 )
{
for (; * vr_12 ; vr_12 ++ )
if ( * vr_12 == '\\' )
vr_12 += fn_6 ( vr_12 , true ) ;
else
putchar ( * vr_12 ) ;
}
static void
fn_13 ( const char * vr_13 , tp_1 vr_14 , char vr_15 ,
bool vr_16 , int vr_17 ,
bool vr_18 , int vr_19 ,
char const * vr_20 )
{
char * vr_7 ;
{
char * vr_21 ;
char const * vr_22 ;
tp_1 vr_23 ;
switch ( vr_15 )
{
case 'd' : case 'i' : case 'o' : case 'u' : case 'x' : case 'X' :
vr_22 = vl_10 ;
vr_23 = sizeof vl_10 - 2 ;
break;
case 'a' : case 'e' : case 'f' : case 'g' :
case 'A' : case 'E' : case 'F' : case 'G' :
vr_22 = lr_13 ;
vr_23 = 1 ;
break;
default:
vr_22 = vr_13 ;
vr_23 = 0 ;
break;
}
vr_7 = xmalloc ( vr_14 + vr_23 + 2 ) ;
vr_21 = fn_14 ( vr_7 , vr_13 , vr_14 ) ;
vr_21 = fn_14 ( vr_21 , vr_22 , vr_23 ) ;
* vr_21 ++ = vr_15 ;
* vr_21 = '\0' ;
}
switch ( vr_15 )
{
case 'd' :
case 'i' :
{
tp_2 vr_24 = fn_15 ( vr_20 ) ;
if ( ! vr_16 )
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_24 ) ;
else
fn_16 ( vr_7 , vr_19 , vr_24 ) ;
}
else
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_17 , vr_24 ) ;
else
fn_16 ( vr_7 , vr_17 , vr_19 , vr_24 ) ;
}
}
break;
case 'o' :
case 'u' :
case 'x' :
case 'X' :
{
tp_3 vr_24 = fn_17 ( vr_20 ) ;
if ( ! vr_16 )
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_24 ) ;
else
fn_16 ( vr_7 , vr_19 , vr_24 ) ;
}
else
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_17 , vr_24 ) ;
else
fn_16 ( vr_7 , vr_17 , vr_19 , vr_24 ) ;
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
long double vr_24 = fn_18 ( vr_20 ) ;
if ( ! vr_16 )
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_24 ) ;
else
fn_16 ( vr_7 , vr_19 , vr_24 ) ;
}
else
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_17 , vr_24 ) ;
else
fn_16 ( vr_7 , vr_17 , vr_19 , vr_24 ) ;
}
}
break;
case 'c' :
if ( ! vr_16 )
fn_16 ( vr_7 , * vr_20 ) ;
else
fn_16 ( vr_7 , vr_17 , * vr_20 ) ;
break;
case 's' :
if ( ! vr_16 )
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_20 ) ;
else
fn_16 ( vr_7 , vr_19 , vr_20 ) ;
}
else
{
if ( ! vr_18 )
fn_16 ( vr_7 , vr_17 , vr_20 ) ;
else
fn_16 ( vr_7 , vr_17 , vr_19 , vr_20 ) ;
}
break;
}
free ( vr_7 ) ;
}
static int
fn_19 ( const char * vr_25 , int vr_26 , char * * vr_27 )
{
int vr_28 = vr_26 ;
const char * vr_29 ;
const char * vr_30 ;
tp_1 vr_31 ;
bool vr_16 ;
int vr_17 = 0 ;
bool vr_18 ;
int vr_19 = 0 ;
char vr_32 [ vl_11 + 1 ] ;
for ( vr_29 = vr_25 ; * vr_29 ; ++ vr_29 )
{
switch ( * vr_29 )
{
case '%' :
vr_30 = vr_29 ++ ;
vr_31 = 1 ;
vr_16 = vr_18 = false ;
if ( * vr_29 == '%' )
{
putchar ( '%' ) ;
break;
}
if ( * vr_29 == 'b' )
{
if ( vr_26 > 0 )
{
fn_12 ( * vr_27 ) ;
++ vr_27 ;
-- vr_26 ;
}
break;
}
memset ( vr_32 , 0 , sizeof vr_32 ) ;
vr_32 [ 'a' ] = vr_32 [ 'A' ] = vr_32 [ 'c' ] = vr_32 [ 'd' ] = vr_32 [ 'e' ] = vr_32 [ 'E' ] =
vr_32 [ 'f' ] = vr_32 [ 'F' ] = vr_32 [ 'g' ] = vr_32 [ 'G' ] = vr_32 [ 'i' ] = vr_32 [ 'o' ] =
vr_32 [ 's' ] = vr_32 [ 'u' ] = vr_32 [ 'x' ] = vr_32 [ 'X' ] = 1 ;
for (; ; vr_29 ++ , vr_31 ++ )
switch ( * vr_29 )
{
#if ( vl_12 == 2 && 2 <= vl_13 ) || 3 <= vl_12
case 'I' :
#endif
case '\'' :
vr_32 [ 'a' ] = vr_32 [ 'A' ] = vr_32 [ 'c' ] = vr_32 [ 'e' ] = vr_32 [ 'E' ] =
vr_32 [ 'o' ] = vr_32 [ 's' ] = vr_32 [ 'x' ] = vr_32 [ 'X' ] = 0 ;
break;
case '-' : case '+' : case ' ' :
break;
case '#' :
vr_32 [ 'c' ] = vr_32 [ 'd' ] = vr_32 [ 'i' ] = vr_32 [ 's' ] = vr_32 [ 'u' ] = 0 ;
break;
case '0' :
vr_32 [ 'c' ] = vr_32 [ 's' ] = 0 ;
break;
default:
goto lb_1;
}
lb_1:
if ( * vr_29 == '*' )
{
++ vr_29 ;
++ vr_31 ;
if ( vr_26 > 0 )
{
tp_2 vr_33 = fn_15 ( * vr_27 ) ;
if ( vl_14 <= vr_33 && vr_33 <= vl_15 )
vr_17 = vr_33 ;
else
error ( vl_9 , 0 , _ ( lr_14 ) ,
* vr_27 ) ;
++ vr_27 ;
-- vr_26 ;
}
else
vr_17 = 0 ;
vr_16 = true ;
}
else
while ( ISDIGIT ( * vr_29 ) )
{
++ vr_29 ;
++ vr_31 ;
}
if ( * vr_29 == '.' )
{
++ vr_29 ;
++ vr_31 ;
vr_32 [ 'c' ] = 0 ;
if ( * vr_29 == '*' )
{
++ vr_29 ;
++ vr_31 ;
if ( vr_26 > 0 )
{
tp_2 vr_34 = fn_15 ( * vr_27 ) ;
if ( vr_34 < 0 )
{
vr_19 = - 1 ;
}
else if ( vl_15 < vr_34 )
error ( vl_9 , 0 , _ ( lr_15 ) ,
* vr_27 ) ;
else
vr_19 = vr_34 ;
++ vr_27 ;
-- vr_26 ;
}
else
vr_19 = 0 ;
vr_18 = true ;
}
else
while ( ISDIGIT ( * vr_29 ) )
{
++ vr_29 ;
++ vr_31 ;
}
}
while ( * vr_29 == 'l' || * vr_29 == 'L' || * vr_29 == 'h'
|| * vr_29 == 'j' || * vr_29 == 't' || * vr_29 == 'z' )
++ vr_29 ;
{
unsigned char vr_15 = * vr_29 ;
if ( ! vr_32 [ vr_15 ] )
error ( vl_9 , 0 ,
_ ( lr_16 ) ,
(int) ( vr_29 + 1 - vr_30 ) , vr_30 ) ;
}
fn_13 ( vr_30 , vr_31 , * vr_29 ,
vr_16 , vr_17 ,
vr_18 , vr_19 ,
( vr_26 <= 0 ? lr_17 : ( vr_26 -- , * vr_27 ++ ) ) ) ;
break;
case '\\' :
vr_29 += fn_6 ( vr_29 , false ) ;
break;
default:
putchar ( * vr_29 ) ;
}
}
return vr_28 - vr_26 ; MST[SUB$@1$@2$!GT$@1$@2$]MSP[]
}
int
main ( int vr_26 , char * * vr_27 )
{
char * vr_25 ;
int vr_35 ;
fn_20 ( & vr_26 , & vr_27 ) ;
fn_21 ( vr_27 [ 0 ] ) ;
setlocale ( vl_16 , lr_17 ) ;
fn_22 ( vl_17 , vl_18 ) ;
fn_23 ( vl_17 ) ;
atexit ( vl_19 ) ;
vl_8 = vl_1 ;
vl_20 = ( getenv ( lr_18 ) != NULL ) ;
if ( vr_26 == 2 )
{
if ( fn_24 ( vr_27 [ 1 ] , lr_19 ) )
fn_1 ( vl_1 ) ;
if ( fn_24 ( vr_27 [ 1 ] , lr_20 ) )
{
fn_25 ( stdout , vl_6 , vl_21 , vl_22 , vl_23 ,
( char * ) NULL ) ;
exit ( vl_1 ) ;
}
}
if ( 1 < vr_26 && fn_24 ( vr_27 [ 1 ] , lr_21 ) )
{
-- vr_26 ;
++ vr_27 ;
}
if ( vr_26 <= 1 )
{
error ( 0 , 0 , _ ( lr_22 ) ) ;
fn_1 ( vl_9 ) ;
}
vr_25 = vr_27 [ 1 ] ;
vr_26 -= 2 ;
vr_27 += 2 ;
do
{
vr_35 = fn_19 ( vr_25 , vr_26 , vr_27 ) ;
vr_26 -= vr_35 ;
vr_27 += vr_35 ;
}
while ( vr_35 > 0 && vr_26 > 0 );
if ( vr_26 > 0 )
error ( 0 , 0 ,
_ ( lr_23 ) ,
fn_26 ( vr_27 [ 0 ] ) ) ;
exit ( vl_8 ) ;
}
