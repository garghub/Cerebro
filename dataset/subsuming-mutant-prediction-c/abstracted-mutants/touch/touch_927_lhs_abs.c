static void
fn_1 ( struct vr_1 * vr_2 ,
char const * vr_3 , struct vr_1 const * vr_4 )
{
if ( ! fn_2 ( vr_2 , vr_3 , vr_4 ) )
error ( vl_1 , 0 , _ ( lr_1 ) , fn_3 ( vr_3 ) ) ;
}
static bool
fn_4 ( const char * vr_5 )
{
bool vr_6 ;
int vr_7 = - 1 ;
int vr_8 = 0 ;
struct vr_1 const * vr_9 = vl_2 ;
if ( fn_5 ( vr_5 , lr_2 ) )
vr_7 = vl_3 ;
else if ( ! ( vl_4 || vl_5 ) )
{
vr_7 = fn_6 ( vl_6 , vr_5 ,
vl_7 | vl_8 | vl_9 | vl_10 , vl_11 ) ;
if ( vr_7 == - 1 && vl_12 != vl_13 && vl_12 != vl_14 && vl_12 != vl_15 )
vr_8 = vl_12 ;
}
if ( vl_16 != ( vl_17 | vl_18 ) )
{
if ( vl_16 == vl_18 )
vl_2 [ 0 ] . vl_19 = vl_20 ;
else
{
assert ( vl_16 == vl_17 ) ;
vl_2 [ 1 ] . vl_19 = vl_20 ;
}
}
if ( vl_21 )
{
vr_9 = NULL ;
}
vr_6 = ( fn_7 ( vr_7 , vl_22 , ( vr_7 == vl_3 ? NULL : vr_5 ) , vr_9 ,
( vl_5 && vr_7 == - 1 ) ? vl_23 : 0 )
== 0 ) ;
if ( vr_7 == vl_6 )
{
if ( fn_8 ( vl_6 ) != 0 )
{
error ( 0 , vl_12 , _ ( lr_3 ) , fn_3 ( vr_5 ) ) ;
return false ;
}
}
else if ( vr_7 == vl_3 )
{
if ( ! vr_6 && vl_12 == vl_24 && vl_4 )
return true ;
}
if ( ! vr_6 )
{
if ( vr_8 )
{
error ( 0 , vr_8 , _ ( lr_4 ) , fn_3 ( vr_5 ) ) ;
}
else
{
if ( vl_4 && vl_12 == vl_25 )
return true ;
error ( 0 , vl_12 , _ ( lr_5 ) , fn_3 ( vr_5 ) ) ;
}
return false ;
}
return true ;
}
void
fn_9 ( int vr_10 )
{
if ( vr_10 != vl_26 )
fn_10 () ;
else
{
printf ( _ ( lr_6 ) , vl_27 ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fn_11 () ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fputs ( _ ( lr_10 ) , stdout ) ;
fputs ( vl_28 , stdout ) ;
fputs ( vl_29 , stdout ) ;
fputs ( _ ( lr_11 ) , stdout ) ;
fn_12 () ;
}
exit ( vr_10 ) ;
}
int
main ( int vr_11 , char * * vr_12 )
{
int vr_13 ;
bool vr_14 = false ;
bool vr_6 = true ;
char const * vr_3 = NULL ;
fn_13 ( & vr_11 , & vr_12 ) ;
fn_14 ( vr_12 [ 0 ] ) ;
setlocale ( vl_30 , lr_12 ) ;
fn_15 ( vl_31 , vl_32 ) ;
fn_16 ( vl_31 ) ;
atexit ( vl_33 ) ;
vl_16 = 0 ;
vl_4 = vl_34 = false ;
while ( ( vr_13 = fn_17 ( vr_11 , vr_12 , lr_13 , vl_35 , NULL ) ) != - 1 )
{
switch ( vr_13 )
{
case 'a' :
vl_16 |= vl_17 ;
break;
case 'c' :
vl_4 = true ;
break;
case 'd' :
vr_3 = vl_36 ;
break;
case 'f' :
break;
case 'h' :
vl_5 = true ;
break;
case 'm' :
vl_16 |= vl_18 ;
break;
case 'r' :
vl_34 = true ;
vl_37 = vl_36 ;
break;
case 't' :
if ( ! fn_18 ( & vl_2 [ 0 ] . vl_38 , vl_36 ,
vl_39 | vl_40 | vl_41 ) )
error ( vl_1 , 0 , _ ( lr_1 ) ,
fn_3 ( vl_36 ) ) ;
vl_2 [ 0 ] . vl_19 = 0 ;
vl_2 [ 1 ] = vl_2 [ 0 ] ;
vr_14 = true ;
break;
case vl_42 :
vl_16 |= fn_19 ( lr_14 , vl_36 ,
vl_43 , vl_44 ) ;
break;
vl_45 ;
fn_20 ( vl_46 , vl_47 ) ;
default:
fn_9 ( vl_1 ) ;
}
}
if ( vl_16 == 0 )
vl_16 = vl_17 | vl_18 ;
if ( vr_14 && ( vl_34 || vr_3 ) )
{
error ( 0 , 0 , _ ( lr_15 ) ) ;
fn_9 ( vl_1 ) ;
}
if ( vl_34 )
{
struct vr_15 vr_16 ;
if ( vl_5 ? fn_21 ( vl_37 , & vr_16 )
: vr_15 ( vl_37 , & vr_16 ) )
error ( vl_1 , vl_12 ,
_ ( lr_16 ) , fn_3 ( vl_37 ) ) ;
vl_2 [ 0 ] = fn_22 ( & vr_16 ) ; MST[STMT!TRAPSTMT]MSP[]
vl_2 [ 1 ] = fn_23 ( & vr_16 ) ;
vr_14 = true ;
if ( vr_3 )
{
if ( vl_16 & vl_17 )
fn_1 ( & vl_2 [ 0 ] , vr_3 , & vl_2 [ 0 ] ) ;
if ( vl_16 & vl_18 )
fn_1 ( & vl_2 [ 1 ] , vr_3 , & vl_2 [ 1 ] ) ;
}
}
else
{
if ( vr_3 )
{
struct vr_1 vr_4 ;
fn_24 ( & vr_4 ) ;
fn_1 ( & vl_2 [ 0 ] , vr_3 , & vr_4 ) ;
vl_2 [ 1 ] = vl_2 [ 0 ] ;
vr_14 = true ;
if ( vl_16 == ( vl_17 | vl_18 )
&& vl_2 [ 0 ] . vl_38 == vr_4 . vl_38
&& vl_2 [ 0 ] . vl_19 == vr_4 . vl_19 )
{
struct vr_1 vr_17 , vr_18 ;
vr_17 . vl_38 = vr_4 . vl_38 ^ 1 ;
vr_17 . vl_19 = vr_4 . vl_19 ;
fn_1 ( & vr_18 , vr_3 , & vr_17 ) ;
if ( vr_18 . vl_38 == vr_17 . vl_38
&& vr_18 . vl_19 == vr_17 . vl_19 )
vr_14 = false ;
}
}
}
if ( ! vr_14 && 2 <= vr_11 - vl_48 && fn_25 () < 200112
&& fn_18 ( & vl_2 [ 0 ] . vl_38 , vr_12 [ vl_48 ] ,
vl_49 | vl_50 ) )
{
vl_2 [ 0 ] . vl_19 = 0 ;
vl_2 [ 1 ] = vl_2 [ 0 ] ;
vr_14 = true ;
if ( ! getenv ( lr_17 ) )
{
struct vr_19 const * vr_19 = localtime ( & vl_2 [ 0 ] . vl_38 ) ;
if ( vr_19 )
error ( 0 , 0 ,
_ ( lr_18
lr_19 ) ,
vr_12 [ vl_48 ] ,
vr_19 -> vr_20 + 1900L , vr_19 -> vr_21 + 1 , vr_19 -> vr_22 ,
vr_19 -> vr_23 , vr_19 -> vr_24 , vr_19 -> vr_25 ) ;
}
vl_48 ++ ;
}
if ( ! vr_14 )
{
if ( vl_16 == ( vl_17 | vl_18 ) )
vl_21 = true ;
else
vl_2 [ 1 ] . vl_19 = vl_2 [ 0 ] . vl_19 = vl_51 ;
}
if ( vl_48 == vr_11 )
{
error ( 0 , 0 , _ ( lr_20 ) ) ;
fn_9 ( vl_1 ) ;
}
for (; vl_48 < vr_11 ; ++ vl_48 )
vr_6 &= fn_4 ( vr_12 [ vl_48 ] ) ;
exit ( vr_6 ? vl_26 : vl_1 ) ;
}
