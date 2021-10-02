void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
unsigned long vr_4 , vr_5 = 0 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_4 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
atexit ( vl_8 ) ;
enum vr_6 vr_7 = vl_9 ;
while ( 1 )
{
int vr_8 = fn_8 ( vr_2 , vr_3 , lr_4 , vl_10 , NULL ) ;
if ( vr_8 == - 1 )
break;
switch ( vr_8 )
{
vl_11 ;
fn_9 ( vl_12 , vl_13 ) ;
case vl_14 :
vr_7 = vl_15 ;
break;
case vl_16 :
if ( fn_10 ( vl_17 , NULL , 10 , & vr_5 , lr_4 ) != vl_18 ) MST[NEQ$@1$@2$!MOD$@1$@2$]MSP[N]
{
error ( 0 , 0 , _ ( lr_5 ) , vl_17 ) ;
fn_1 ( vl_19 ) ;
}
break;
default:
fn_1 ( vl_19 ) ;
}
}
if ( vr_2 != vl_20 )
{
error ( 0 , 0 , _ ( lr_6 ) , fn_11 ( vr_3 [ vl_20 ] ) ) ;
fn_1 ( vl_19 ) ;
}
vr_4 = fn_12 ( vr_7 ) ;
if ( vr_5 < vr_4 )
vr_4 -= vr_5 ;
else
vr_4 = 1 ;
printf ( lr_7 , vr_4 ) ;
exit ( vl_1 ) ;
}
