void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
fputs ( _ ( lr_2 ) ,
stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
int vr_4 ;
bool vr_5 = true ;
tp_1 vr_6 , vr_7 ;
tp_2 vr_8 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ; MST[C!ADD$C$1$]MSP[N]
setlocale ( vl_5 , lr_3 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
atexit ( vl_8 ) ;
while ( ( vr_4 = fn_8 ( vr_2 , vr_3 , lr_3 , vl_9 , NULL ) ) != - 1 )
{
switch ( vr_4 )
{
vl_10 ;
fn_9 ( vl_11 , vl_12 ) ;
default:
fn_1 ( vl_13 ) ;
}
}
if ( vl_14 == vr_2 )
{
tp_2 vr_9 = - 1 ;
tp_1 vr_10 = - 1 ;
vl_15 = 0 ;
vr_8 = fn_10 () ;
if ( vr_8 == vr_9 && vl_15 )
error ( vl_13 , vl_15 , _ ( lr_4 ) ) ;
vl_15 = 0 ;
vr_7 = fn_11 () ;
if ( vr_7 == vr_10 && vl_15 )
error ( vl_13 , vl_15 , _ ( lr_5 ) ) ;
vl_15 = 0 ;
vr_6 = fn_12 () ;
if ( vr_6 == vr_10 && vl_15 )
error ( vl_13 , vl_15 , _ ( lr_6 ) ) ;
if ( ! fn_13 ( NULL , vr_8 , vr_6 , vr_7 , true , ' ' ) )
vr_5 = false ;
putchar ( '\n' ) ;
}
else
{
while ( vl_14 < vr_2 )
{
struct vr_11 * vr_12 = fn_14 ( vr_3 [ vl_14 ] ) ;
if ( vr_12 == NULL )
error ( vl_13 , 0 , _ ( lr_7 ) , vr_3 [ vl_14 ] ) ;
vr_8 = vr_12 -> vr_13 ;
vr_6 = vr_7 = vr_12 -> vr_14 ;
printf ( lr_8 , vr_3 [ vl_14 ] ) ;
if ( ! fn_13 ( vr_3 [ vl_14 ++ ] , vr_8 , vr_6 , vr_7 , true , ' ' ) )
vr_5 = false ;
putchar ( '\n' ) ;
}
}
exit ( vr_5 ? vl_1 : vl_13 ) ;
}
