void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
printf ( _ ( lr_4 ) ,
vl_2 , vl_2 , vl_2 ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
static char const vr_4 = '.' ;
bool vr_5 = false ;
char const * vr_6 ;
tp_1 vr_7 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_5 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
atexit ( vl_8 ) ;
while ( true )
{
int vr_8 = fn_8 ( vr_2 , vr_3 , lr_6 , vl_9 , NULL ) ;
if ( vr_8 == - 1 )
break;
switch ( vr_8 )
{
case 'z' :
vr_5 = true ;
break;
vl_10 ;
fn_9 ( vl_11 , vl_12 ) ;
default:
fn_1 ( vl_13 ) ;
}
}
if ( vr_2 < vl_14 + 1 )
{
error ( 0 , 0 , _ ( lr_7 ) ) ;
fn_1 ( vl_13 ) ;
}
for (; vl_14 < vr_2 ; vl_14 ++ ) MST[STMT!TRAPSTMT]MSP[N]
{
vr_6 = vr_3 [ vl_14 ] ;
vr_7 = fn_10 ( vr_6 ) ;
if ( ! vr_7 )
{
vr_6 = & vr_4 ;
vr_7 = 1 ;
}
fwrite ( vr_6 , 1 , vr_7 , stdout ) ;
putchar ( vr_5 ? '\0' : '\n' ) ;
}
exit ( vl_1 ) ;
}
