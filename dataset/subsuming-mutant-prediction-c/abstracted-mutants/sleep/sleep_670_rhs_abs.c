void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 , vl_2 ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static bool
fn_4 ( double * vr_2 , char vr_3 )
{
int vr_4 ;
switch ( vr_3 )
{
case 0 :
case 's' :
vr_4 = 1 ;
break;
case 'm' :
vr_4 = 60 ;
break;
case 'h' :
vr_4 = 60 * 60 ;
break;
case 'd' :
vr_4 = 60 * 60 * 24 ;
break;
default:
return false ;
}
* vr_2 *= vr_4 ;
return true ;
}
int
main ( int vr_5 , char * * vr_6 )
{
int vr_7 ;
double vr_8 = 0.0 ;
bool vr_9 = true ;
fn_5 ( & vr_5 , & vr_6 ) ;
fn_6 ( vr_6 [ 0 ] ) ;
setlocale ( vl_5 , lr_2 ) ;
fn_7 ( vl_6 , vl_7 ) ;
fn_8 ( vl_6 ) ;
atexit ( vl_8 ) ;
fn_9 ( vr_5 , vr_6 , vl_9 , vl_10 , vl_11 ,
fn_1 , vl_12 , ( char const * ) NULL ) ;
if ( fn_10 ( vr_5 , vr_6 , lr_2 , NULL , NULL ) != - 1 )
fn_1 ( vl_13 ) ;
if ( vr_5 == 1 )
{
error ( 0 , 0 , _ ( lr_3 ) ) ;
fn_1 ( vl_13 ) ;
}
for ( vr_7 = vl_14 ; vr_7 < vr_5 ; vr_7 ++ ) MST[STMT!DELSTMT]MSP[N]
{
double vr_10 ;
const char * vr_11 ;
if ( ! fn_11 ( vr_6 [ vr_7 ] , & vr_11 , & vr_10 , vl_15 )
|| ! ( 0 <= vr_10 )
|| ( * vr_11 && * ( vr_11 + 1 ) )
|| ! fn_4 ( & vr_10 , * vr_11 ) )
{
error ( 0 , 0 , _ ( lr_4 ) , fn_12 ( vr_6 [ vr_7 ] ) ) ;
vr_9 = false ;
}
vr_8 += vr_10 ;
}
if ( ! vr_9 )
fn_1 ( vl_13 ) ;
if ( fn_13 ( vr_8 ) )
error ( vl_13 , vl_16 , _ ( lr_5 ) ) ;
exit ( vl_1 ) ;
}
