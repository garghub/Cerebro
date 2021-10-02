void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( vl_3
? fn_3 ( lr_3 )
: fn_3 ( lr_4 ) ) ,
stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( vl_5 , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
printf ( vl_6 , vl_7 ) ;
fn_4 () ;
}
exit ( vr_1 ) ;
}
static int
fn_5 ( unsigned char vr_2 )
{
switch ( vr_2 )
{
default: return vr_2 - '0' ;
case 'a' : case 'A' : return 10 ;
case 'b' : case 'B' : return 11 ;
case 'c' : case 'C' : return 12 ;
case 'd' : case 'D' : return 13 ;
case 'e' : case 'E' : return 14 ;
case 'f' : case 'F' : return 15 ;
}
}
int
main ( int vr_3 , char * * vr_4 )
{
bool vr_5 = true ;
bool vr_6 =
( ! getenv ( lr_8 )
|| ( ! vl_3 && 1 < vr_3 && fn_6 ( vr_4 [ 1 ] , lr_9 ) ) ) ;
bool vr_7 = vl_3 ;
fn_7 ( & vr_3 , & vr_4 ) ;
fn_8 ( vr_4 [ 0 ] ) ;
setlocale ( vl_8 , lr_10 ) ;
fn_9 ( vl_9 , vl_10 ) ;
fn_10 ( vl_9 ) ;
atexit ( vl_11 ) ;
if ( vr_6 && vr_3 == 2 )
{
if ( fn_6 ( vr_4 [ 1 ] , lr_11 ) )
fn_1 ( vl_1 ) ;
if ( fn_6 ( vr_4 [ 1 ] , lr_12 ) )
{
fn_11 ( stdout , vl_7 , vl_12 , vl_13 , vl_14 ,
( char * ) NULL ) ;
exit ( vl_1 ) ;
}
}
-- vr_3 ;
++ vr_4 ;
if ( vr_6 )
while ( vr_3 > 0 && * vr_4 [ 0 ] == '-' )
{
char const * vr_8 = vr_4 [ 0 ] + 1 ;
tp_1 vr_9 ;
for ( vr_9 = 0 ; vr_8 [ vr_9 ] ; vr_9 ++ )
switch ( vr_8 [ vr_9 ] )
{
case 'e' : case 'E' : case 'n' :
break;
default:
goto lb_1;
}
if ( vr_9 == 0 )
goto lb_1;
while ( * vr_8 )
switch ( * vr_8 ++ )
{
case 'e' :
vr_7 = true ;
break;
case 'E' :
vr_7 = false ;
break;
case 'n' :
vr_5 = false ;
break;
}
vr_3 -- ;
vr_4 ++ ;
}
lb_1:
if ( vr_7 )
{
while ( vr_3 > 0 )
{
char const * vr_10 = vr_4 [ 0 ] ;
unsigned char vr_2 ;
while ( ( vr_2 = * vr_10 ++ ) )
{
if ( vr_2 == '\\' && * vr_10 )
{
switch ( vr_2 = * vr_10 ++ )
{
case 'a' : vr_2 = '\a' ; break;
case 'b' : vr_2 = '\b' ; break;
case 'c' : exit ( vl_1 ) ;
case 'e' : vr_2 = '\x1B' ; break;
case 'f' : vr_2 = '\f' ; break;
case 'n' : vr_2 = '\n' ; break;
case 'r' : vr_2 = '\r' ; break;
case 't' : vr_2 = '\t' ; break;
case 'v' : vr_2 = '\v' ; break;
case 'x' :
{
unsigned char vr_11 = * vr_10 ;
if ( ! isxdigit ( vr_11 ) )
goto lb_2;
vr_10 ++ ;
vr_2 = fn_5 ( vr_11 ) ;
vr_11 = * vr_10 ;
if ( isxdigit ( vr_11 ) )
{
vr_10 ++ ;
vr_2 = vr_2 * 16 + fn_5 ( vr_11 ) ;
}
}
break;
case '0' :
vr_2 = 0 ;
if ( ! ( '0' <= * vr_10 && * vr_10 <= '7' ) )
break;
vr_2 = * vr_10 ++ ;
case '1' : case '2' : case '3' :
case '4' : case '5' : case '6' : case '7' :
vr_2 -= '0' ;
if ( '0' <= * vr_10 && * vr_10 <= '7' )
vr_2 = vr_2 * 8 + ( * vr_10 ++ - '0' ) ;
if ( '0' <= * vr_10 && * vr_10 <= '7' )
vr_2 = vr_2 * 8 + ( * vr_10 ++ - '0' ) ;
break;
case '\\' : break;
lb_2:
default: putchar ( '\\' ) ; break;
}
}
putchar ( vr_2 ) ;
}
vr_3 -- ; MST[@!ABS$@$]MSP[]
vr_4 ++ ;
if ( vr_3 > 0 )
putchar ( ' ' ) ;
}
}
else
{
while ( vr_3 > 0 )
{
fputs ( vr_4 [ 0 ] , stdout ) ;
vr_3 -- ;
vr_4 ++ ;
if ( vr_3 > 0 )
putchar ( ' ' ) ;
}
}
if ( vr_5 )
putchar ( '\n' ) ;
exit ( vl_1 ) ;
}
