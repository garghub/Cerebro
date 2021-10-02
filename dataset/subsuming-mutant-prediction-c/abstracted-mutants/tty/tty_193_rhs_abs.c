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
char * vr_4 ;
int vr_5 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_3 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
fn_8 ( vl_8 ) ;
atexit ( vl_9 ) ;
vl_10 = false ;
while ( ( vr_5 = fn_9 ( vr_2 , vr_3 , lr_4 , vl_11 , NULL ) ) != - 1 ) MST[ASSIGN$V1$@2$!LT$@2$V1$]MSP[N]
{
switch ( vr_5 )
{
case 's' :
vl_10 = true ;
break;
vl_12 ;
fn_10 ( vl_13 , vl_14 ) ;
default:
fn_1 ( vl_15 ) ;
}
}
if ( vl_16 < vr_2 )
error ( 0 , 0 , _ ( lr_5 ) , fn_11 ( vr_3 [ vl_16 ] ) ) ;
vr_4 = fn_12 ( vl_17 ) ;
if ( ! vl_10 )
{
if ( vr_4 )
puts ( vr_4 ) ;
else
puts ( _ ( lr_6 ) ) ;
}
exit ( fn_13 ( vl_17 ) ? vl_1 : vl_18 ) ;
}
