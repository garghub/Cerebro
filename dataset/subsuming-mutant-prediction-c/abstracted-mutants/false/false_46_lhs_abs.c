void
fn_1 ( int vr_1 )
{
printf ( _ ( lr_1 ) ,
vl_1 , vl_1 ) ;
printf ( lr_2 ,
_ ( vl_2 == vl_3
? fn_2 ( lr_3 )
: fn_2 ( lr_4 ) ) ) ;
fputs ( vl_4 , stdout ) ;
fputs ( vl_5 , stdout ) ;
printf ( vl_6 , vl_7 ) ;
fn_3 () ;
exit ( vr_1 ) ; MST[STMT!DELSTMT]MSP[]
}
int
main ( int vr_2 , char * * vr_3 )
{
if ( vr_2 == 2 )
{
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_8 , lr_5 ) ;
fn_6 ( vl_9 , vl_10 ) ;
fn_7 ( vl_9 ) ;
atexit ( vl_11 ) ;
if ( fn_8 ( vr_3 [ 1 ] , lr_6 ) )
fn_1 ( vl_2 ) ;
if ( fn_8 ( vr_3 [ 1 ] , lr_7 ) )
fn_9 ( stdout , vl_7 , vl_12 , vl_13 , vl_14 ,
( char * ) NULL ) ;
}
exit ( vl_2 ) ;
}
