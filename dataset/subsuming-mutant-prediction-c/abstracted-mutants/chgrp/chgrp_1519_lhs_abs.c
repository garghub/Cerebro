static tp_1
fn_1 ( const char * vr_1 )
{
tp_1 vr_2 = - 1 ;
if ( * vr_1 )
{
struct vr_3 * vr_4 = fn_2 ( vr_1 ) ;
if ( vr_4 )
vr_2 = vr_4 -> vr_5 ;
else
{
unsigned long int vr_6 ;
if ( ! ( fn_3 ( vr_1 , NULL , 10 , & vr_6 , lr_1 ) == vl_1 MST[EQ$@1$@2$!LT$@2$@1$]MSP[]
&& vr_6 <= vl_2 ) )
error ( vl_3 , 0 , _ ( lr_2 ) , fn_4 ( vr_1 ) ) ;
vr_2 = vr_6 ;
}
fn_5 () ;
}
return vr_2 ;
}
void
fn_6 ( int vr_7 )
{
if ( vr_7 != vl_4 )
fn_7 () ;
else
{
printf ( _ ( lr_3 ) ,
vl_5 , vl_5 ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fputs ( _ ( lr_10 ) , stdout ) ;
fputs ( _ ( lr_11 ) , stdout ) ;
fputs ( vl_6 , stdout ) ;
fputs ( vl_7 , stdout ) ;
printf ( _ ( lr_12 ) ,
vl_5 , vl_5 ) ;
fn_8 () ;
}
exit ( vr_7 ) ;
}
int
main ( int vr_8 , char * * vr_9 )
{
bool vr_10 = false ;
tp_1 vr_2 ;
int vr_11 = vl_8 ;
int vr_12 = - 1 ;
struct vr_13 vr_14 ;
bool vr_15 ;
int vr_16 ;
fn_9 ( & vr_8 , & vr_9 ) ;
fn_10 ( vr_9 [ 0 ] ) ;
setlocale ( vl_9 , lr_1 ) ;
fn_11 ( vl_10 , vl_11 ) ;
fn_12 ( vl_10 ) ;
atexit ( vl_12 ) ;
fn_13 ( & vr_14 ) ;
while ( ( vr_16 = fn_14 ( vr_8 , vr_9 , lr_13 , vl_13 , NULL ) )
!= - 1 )
{
switch ( vr_16 )
{
case 'H' :
vr_11 = vl_14 | vl_8 ;
break;
case 'L' :
vr_11 = vl_15 ;
break;
case 'P' :
vr_11 = vl_8 ;
break;
case 'h' :
vr_12 = 0 ;
break;
case vl_16 :
vr_12 = 1 ;
break;
case vl_17 :
vr_10 = false ;
break;
case vl_18 :
vr_10 = true ;
break;
case vl_19 :
vl_20 = vl_21 ;
break;
case 'R' :
vr_14 . vr_17 = true ;
break;
case 'c' :
vr_14 . vr_18 = vl_22 ;
break;
case 'f' :
vr_14 . vr_19 = true ;
break;
case 'v' :
vr_14 . vr_18 = vl_23 ;
break;
vl_24 ;
fn_15 ( vl_25 , vl_26 ) ;
default:
fn_6 ( vl_3 ) ;
}
}
if ( vr_14 . vr_17 )
{
if ( vr_11 == vl_8 )
{
if ( vr_12 == 1 )
error ( vl_3 , 0 ,
_ ( lr_14 ) ) ;
vr_12 = 0 ;
}
}
else
{
vr_11 = vl_8 ;
}
vr_14 . vr_20 = ( vr_12 != 0 ) ;
if ( vr_8 - vl_27 < ( vl_20 ? 1 : 2 ) )
{
if ( vr_8 <= vl_27 )
error ( 0 , 0 , _ ( lr_15 ) ) ;
else
error ( 0 , 0 , _ ( lr_16 ) , fn_4 ( vr_9 [ vr_8 - 1 ] ) ) ;
fn_6 ( vl_3 ) ;
}
if ( vl_20 )
{
struct vr_21 vr_22 ;
if ( vr_21 ( vl_20 , & vr_22 ) )
error ( vl_3 , vl_28 , _ ( lr_17 ) ,
fn_4 ( vl_20 ) ) ;
vr_2 = vr_22 . vr_23 ;
vr_14 . vr_24 = fn_16 ( vr_22 . vr_23 ) ;
}
else
{
char * vr_24 = vr_9 [ vl_27 ++ ] ;
vr_14 . vr_24 = ( * vr_24 ? vr_24 : NULL ) ;
vr_2 = fn_1 ( vr_24 ) ;
}
if ( vr_14 . vr_17 && vr_10 )
{
static struct vr_25 vr_26 ;
vr_14 . vr_27 = fn_17 ( & vr_26 ) ;
if ( vr_14 . vr_27 == NULL )
error ( vl_3 , vl_28 , _ ( lr_17 ) ,
fn_4 ( lr_18 ) ) ;
}
vr_11 |= vl_29 ;
vr_15 = fn_18 ( vr_9 + vl_27 , vr_11 ,
( vl_30 ) - 1 , vr_2 ,
( vl_30 ) - 1 , ( tp_1 ) - 1 , & vr_14 ) ;
fn_19 ( & vr_14 ) ;
exit ( vr_15 ? vl_4 : vl_3 ) ;
}
