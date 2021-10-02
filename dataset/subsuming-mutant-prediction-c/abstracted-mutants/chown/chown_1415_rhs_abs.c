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
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fputs ( _ ( lr_10 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_11 ) , stdout ) ;
printf ( _ ( lr_12 ) ,
vl_2 , vl_2 , vl_2 ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
bool vr_4 = false ;
tp_1 vr_5 = - 1 ;
tp_2 vr_6 = - 1 ;
tp_1 vr_7 = - 1 ;
tp_2 vr_8 = - 1 ;
int vr_9 = vl_5 ;
int vr_10 = - 1 ;
struct vr_11 vr_12 ;
bool vr_13 ;
int vr_14 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_6 , lr_13 ) ;
fn_6 ( vl_7 , vl_8 ) ;
fn_7 ( vl_7 ) ;
atexit ( vl_9 ) ;
fn_8 ( & vr_12 ) ;
while ( ( vr_14 = fn_9 ( vr_2 , vr_3 , lr_14 , vl_10 , NULL ) )
!= - 1 )
{
switch ( vr_14 )
{
case 'H' :
vr_9 = vl_11 | vl_5 ;
break;
case 'L' :
vr_9 = vl_12 ;
break;
case 'P' :
vr_9 = vl_5 ;
break;
case 'h' :
vr_10 = 0 ;
break;
case vl_13 :
vr_10 = 1 ;
break;
case vl_14 :
vr_4 = false ;
break;
case vl_15 :
vr_4 = true ;
break;
case vl_16 :
vl_17 = vl_18 ;
break;
case vl_19 :
{
const char * vr_15 = fn_10 ( vl_18 ,
& vr_7 , & vr_8 ,
NULL , NULL ) ;
if ( vr_15 )
error ( vl_20 , 0 , lr_15 , vr_15 , fn_11 ( vl_18 ) ) ;
break;
}
case 'R' :
vr_12 . vr_16 = true ;
break;
case 'c' :
vr_12 . vr_17 = vl_21 ;
break;
case 'f' :
vr_12 . vr_18 = true ;
break;
case 'v' :
vr_12 . vr_17 = vl_22 ;
break;
vl_23 ;
fn_12 ( vl_24 , vl_25 ) ;
default:
fn_1 ( vl_20 ) ;
}
}
if ( vr_12 . vr_16 )
{
if ( vr_9 == vl_5 )
{
if ( vr_10 == 1 )
error ( vl_20 , 0 ,
_ ( lr_16 ) ) ;
vr_10 = 0 ;
}
}
else
{
vr_9 = vl_5 ;
}
vr_12 . vr_19 = ( vr_10 != 0 ) ;
if ( vr_2 - vl_26 < ( vl_17 ? 1 : 2 ) )
{
if ( vr_2 <= vl_26 )
error ( 0 , 0 , _ ( lr_17 ) ) ;
else
error ( 0 , 0 , _ ( lr_18 ) , fn_11 ( vr_3 [ vr_2 - 1 ] ) ) ;
fn_1 ( vl_20 ) ;
}
if ( vl_17 )
{
struct vr_20 vr_21 ;
if ( vr_20 ( vl_17 , & vr_21 ) )
error ( vl_20 , vl_27 , _ ( lr_19 ) ,
fn_11 ( vl_17 ) ) ;
vr_5 = vr_21 . vr_22 ;
vr_6 = vr_21 . vr_23 ;
vr_12 . vr_24 = fn_13 ( vr_21 . vr_22 ) ;
vr_12 . vr_25 = fn_14 ( vr_21 . vr_23 ) ;
}
else
{
const char * vr_15 = fn_10 ( vr_3 [ vl_26 ] , & vr_5 , & vr_6 ,
& vr_12 . vr_24 , & vr_12 . vr_25 ) ;
if ( vr_15 )
error ( vl_20 , 0 , lr_15 , vr_15 , fn_11 ( vr_3 [ vl_26 ] ) ) ;
if ( ! vr_12 . vr_24 && vr_12 . vr_25 )
vr_12 . vr_24 = fn_15 ( lr_13 ) ;
vl_26 ++ ;
}
if ( vr_12 . vr_16 && vr_4 )
{
static struct vr_26 vr_27 ;
vr_12 . vr_28 = fn_16 ( & vr_27 ) ;
if ( vr_12 . vr_28 == NULL )
error ( vl_20 , vl_27 , _ ( lr_19 ) ,
fn_11 ( lr_20 ) ) ;
} MST[STMT!TRAPSTMT]MSP[N]
vr_9 |= vl_28 ;
vr_13 = fn_17 ( vr_3 + vl_26 , vr_9 ,
vr_5 , vr_6 ,
vr_7 , vr_8 , & vr_12 ) ;
fn_18 ( & vr_12 ) ;
exit ( vr_13 ? vl_1 : vl_20 ) ;
}
