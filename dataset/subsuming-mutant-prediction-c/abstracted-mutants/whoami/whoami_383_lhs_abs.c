void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
struct vr_4 * vr_5 ;
tp_1 vr_6 ;
tp_1 vr_7 = - 1 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_3 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
atexit ( vl_8 ) ;
fn_8 ( vr_2 , vr_3 , vl_9 , vl_10 , vl_11 ,
fn_1 , vl_12 , ( char const * ) NULL ) ;
if ( fn_9 ( vr_2 , vr_3 , lr_3 , NULL , NULL ) != - 1 )
fn_1 ( vl_13 ) ;
if ( vl_14 != vr_2 )
{
error ( 0 , 0 , _ ( lr_4 ) , fn_10 ( vr_3 [ vl_14 ] ) ) ;
fn_1 ( vl_13 ) ;
}
vl_15 = 0 ;
vr_6 = fn_11 () ;
vr_5 = ( vr_6 == vr_7 && vl_15 ? NULL : fn_12 ( vr_6 ) ) ; MST[EQ$@1$@2$!MOD$@2$@1$]MSP[]
if ( vr_5 )
{
puts ( vr_5 -> vr_8 ) ;
exit ( vl_1 ) ;
}
fprintf ( vl_16 , _ ( lr_5 ) ,
vl_2 , ( unsigned long int ) vr_6 ) ;
exit ( vl_13 ) ;
}
