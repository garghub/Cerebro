static int
fn_1 ( char const * vr_1 , tp_1 * vr_2 )
{
enum vr_3 vr_4 ;
tp_2 vr_5 ;
vr_4 = fn_2 ( vr_1 , NULL , 10 , & vr_5 , lr_1 ) ;
if ( vr_4 == vl_1
&& ! ( vl_2 <= vr_5 && vr_5 <= vl_3 ) )
vr_4 = vl_4 ;
if ( vr_4 == vl_1 )
{
vl_5 = 0 ;
* vr_2 = vr_5 ;
return 0 ;
}
vl_5 = ( vr_4 == vl_4 ? vl_6 : 0 ) ;
return - 1 ;
}
void
fn_3 ( int vr_6 )
{
if ( vr_6 != vl_7 )
fn_4 () ;
else
{
printf ( _ ( lr_2 ) , vl_8 ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fn_5 () ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( vl_9 , stdout ) ;
fputs ( vl_10 , stdout ) ;
fn_6 () ;
fputs ( _ ( lr_7 ) , stdout ) ;
fn_7 () ;
}
exit ( vr_6 ) ;
}
static bool
fn_8 ( int vr_7 , char const * vr_8 , tp_1 vr_9 , tp_1 vr_10 ,
tp_3 vr_11 )
{
struct vr_12 vr_13 ;
tp_1 vr_14 ;
if ( ( vl_11 || ( vr_11 && vr_10 < 0 ) ) && fn_9 ( vr_7 , & vr_13 ) != 0 )
{
error ( 0 , vl_5 , _ ( lr_8 ) , fn_10 ( vr_8 ) ) ;
return false ;
}
if ( vl_11 )
{
tp_1 const vr_15 = fn_11 ( vr_13 ) ;
if ( vr_9 < vl_2 / vr_15 || vr_9 > vl_3 / vr_15 )
{
error ( 0 , 0 ,
_ ( lr_9 vl_12
lr_10 vl_12 lr_11 ) ,
( tp_2 ) vr_9 , ( tp_2 ) vr_15 ,
fn_10 ( vr_8 ) ) ;
return false ;
}
vr_9 *= vr_15 ;
}
if ( vr_11 )
{
tp_4 vr_16 ;
if ( 0 <= vr_10 )
vr_16 = vr_10 ;
else
{
tp_1 vr_17 ;
if ( fn_12 ( & vr_13 ) )
{
vr_17 = vr_13 . vr_18 ;
if ( vr_17 < 0 )
{
error ( 0 , 0 , _ ( lr_12 ) ,
fn_10 ( vr_8 ) ) ;
return false ;
}
}
else
{
vr_17 = fn_13 ( vr_7 , 0 , vl_13 ) ;
if ( vr_17 < 0 )
{
error ( 0 , vl_5 , _ ( lr_13 ) ,
fn_10 ( vr_8 ) ) ;
return false ;
}
}
vr_16 = vr_17 ;
}
if ( vr_11 == vl_14 )
vr_14 = fn_14 ( vr_16 , ( tp_4 ) vr_9 ) ;
else if ( vr_11 == vl_15 )
vr_14 = fn_15 ( vr_16 , ( tp_4 ) vr_9 ) ;
else if ( vr_11 == vl_16 )
vr_14 = ( vr_16 / vr_9 ) * vr_9 ;
else if ( vr_11 == vl_17 )
{
tp_4 const vr_19 = ( ( vr_16 + vr_9 - 1 ) / vr_9 ) * vr_9 ;
if ( vr_19 > vl_3 )
{
error ( 0 , 0 , _ ( lr_14 ) ,
fn_10 ( vr_8 ) ) ;
return false ;
}
vr_14 = vr_19 ;
}
else
{
if ( vr_9 > vl_3 - ( tp_1 ) vr_16 )
{
error ( 0 , 0 , _ ( lr_15 ) ,
fn_10 ( vr_8 ) ) ;
return false ;
}
vr_14 = vr_16 + vr_9 ;
}
}
else
vr_14 = vr_9 ;
if ( vr_14 < 0 )
vr_14 = 0 ;
if ( fn_16 ( vr_7 , vr_14 ) == - 1 )
{
error ( 0 , vl_5 ,
_ ( lr_16 vl_12 lr_17 ) , fn_10 ( vr_8 ) ,
( tp_2 ) vr_14 ) ;
return false ;
}
return true ;
}
int
main ( int vr_20 , char * * vr_21 )
{
bool vr_22 = false ;
bool vr_23 = false ;
tp_1 vr_2 vr_24 ( = 0 ) ;
tp_1 vr_10 = - 1 ;
tp_3 vr_11 = vl_18 ;
int vr_25 , vr_7 = - 1 , vr_26 ;
char const * vr_8 ;
fn_17 ( & vr_20 , & vr_21 ) ;
fn_18 ( vr_21 [ 0 ] ) ;
setlocale ( vl_19 , lr_18 ) ;
fn_19 ( vl_20 , vl_21 ) ;
fn_20 ( vl_20 ) ;
atexit ( vl_22 ) ;
while ( ( vr_25 = fn_21 ( vr_20 , vr_21 , lr_19 , vl_23 , NULL ) ) != - 1 )
{
switch ( vr_25 )
{
case 'c' :
vl_24 = true ;
break;
case 'o' :
vl_11 = true ;
break;
case 'r' :
vl_25 = vl_26 ;
break;
case 's' :
while ( isspace ( fn_22 ( * vl_26 ) ) )
vl_26 ++ ;
switch ( * vl_26 )
{
case '<' :
vr_11 = vl_15 ;
vl_26 ++ ;
break;
case '>' :
vr_11 = vl_14 ;
vl_26 ++ ;
break;
case '/' :
vr_11 = vl_16 ;
vl_26 ++ ;
break;
case '%' :
vr_11 = vl_17 ;
vl_26 ++ ;
break;
}
while ( isspace ( fn_22 ( * vl_26 ) ) ) MST[PADD$P1$@2$!PLEFTINC$P1$]MSP[N]
vl_26 ++ ;
if ( * vl_26 == '+' || * vl_26 == '-' )
{
if ( vr_11 )
{
error ( 0 , 0 , _ ( lr_20 ) ) ;
fn_3 ( vl_27 ) ;
}
vr_11 = vl_28 ;
}
if ( fn_1 ( vl_26 , & vr_2 ) == - 1 )
error ( vl_27 , vl_5 , _ ( lr_21 ) ,
fn_10 ( vl_26 ) ) ;
if ( ( vr_11 == vl_17 || vr_11 == vl_16 ) && vr_2 == 0 )
error ( vl_27 , 0 , _ ( lr_22 ) ) ;
vr_22 = true ;
break;
vl_29 ;
fn_23 ( vl_30 , vl_31 ) ;
default:
fn_3 ( vl_27 ) ;
}
}
vr_21 += vl_32 ;
vr_20 -= vl_32 ;
if ( ! vl_25 && ! vr_22 )
{
error ( 0 , 0 , _ ( lr_23 ) ,
fn_24 ( 0 , lr_24 ) , fn_24 ( 1 , lr_25 ) ) ;
fn_3 ( vl_27 ) ;
}
if ( vl_25 && vr_22 && ! vr_11 )
{
error ( 0 , 0 , _ ( lr_26 ) ,
fn_24 ( 0 , lr_24 ) , fn_24 ( 1 , lr_25 ) ) ;
fn_3 ( vl_27 ) ;
}
if ( vl_11 && ! vr_22 )
{
error ( 0 , 0 , _ ( lr_27 ) ,
fn_24 ( 0 , lr_28 ) , fn_24 ( 1 , lr_24 ) ) ;
fn_3 ( vl_27 ) ;
}
if ( vr_20 < 1 )
{
error ( 0 , 0 , _ ( lr_29 ) ) ;
fn_3 ( vl_27 ) ;
}
if ( vl_25 )
{
struct vr_12 vr_13 ;
tp_1 vr_17 = - 1 ;
if ( vr_12 ( vl_25 , & vr_13 ) != 0 )
error ( vl_27 , vl_5 , _ ( lr_30 ) , fn_10 ( vl_25 ) ) ;
if ( fn_12 ( & vr_13 ) )
vr_17 = vr_13 . vr_18 ;
else
{
int vr_27 = fn_25 ( vl_25 , vl_33 ) ;
if ( 0 <= vr_27 )
{
tp_1 vr_28 = fn_13 ( vr_27 , 0 , vl_13 ) ;
int vr_29 = vl_5 ;
fn_26 ( vr_27 ) ;
if ( 0 <= vr_28 )
vr_17 = vr_28 ;
else
{
vl_5 = vr_29 ;
}
}
}
if ( vr_17 < 0 )
error ( vl_27 , vl_5 , _ ( lr_13 ) ,
fn_10 ( vl_25 ) ) ;
if ( ! vr_22 )
vr_2 = vr_17 ;
else
vr_10 = vr_17 ;
}
vr_26 = vl_34 | ( vl_24 ? 0 : vl_35 ) | vl_36 ;
while ( ( vr_8 = * vr_21 ++ ) != NULL )
{
if ( ( vr_7 = fn_25 ( vr_8 , vr_26 , vl_37 ) ) == - 1 )
{
if ( ! ( vl_24 && vl_5 == vl_38 ) )
{
error ( 0 , vl_5 , _ ( lr_31 ) ,
fn_10 ( vr_8 ) ) ;
vr_23 = true ;
}
continue;
}
if ( vr_7 != - 1 )
{
vr_23 |= ! fn_8 ( vr_7 , vr_8 , vr_2 , vr_10 , vr_11 ) ;
if ( fn_26 ( vr_7 ) != 0 )
{
error ( 0 , vl_5 , _ ( lr_32 ) , fn_10 ( vr_8 ) ) ;
vr_23 = true ;
}
}
}
return vr_23 ? vl_27 : vl_7 ;
}
