void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 ) MST[NEQ$@1$@2$!LE$@1$@2$]MSP[N]
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
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_3 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
atexit ( vl_8 ) ;
fn_8 ( vr_2 , vr_3 , vl_9 , vl_6 , vl_10 ,
fn_1 , vl_11 , ( char const * ) NULL ) ;
if ( fn_9 ( vr_2 , vr_3 , lr_3 , NULL , NULL ) != - 1 )
fn_1 ( vl_12 ) ;
if ( vl_13 < vr_2 )
error ( 0 , 0 , _ ( lr_4 ) ) ;
fn_10 () ;
exit ( vl_1 ) ;
}
