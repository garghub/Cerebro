extern void
fn_1 ( struct vr_1 * vr_2 )
{
vr_2 -> vr_3 = vl_1 ;
vr_2 -> vr_4 = NULL ;
vr_2 -> vr_5 = true ;
vr_2 -> vr_6 = false ;
vr_2 -> vr_7 = false ;
vr_2 -> vr_8 = NULL ;
vr_2 -> vr_9 = NULL ;
}
extern void
fn_2 ( struct vr_1 * vr_2 vr_10 )
{
}
extern char *
fn_3 ( tp_1 vr_11 )
{
char vr_12 [ fn_4 ( vl_2 ) ] ;
struct vr_13 * vr_14 = fn_5 ( vr_11 ) ;
return fn_6 ( vr_14 ? vr_14 -> vr_15
: fn_7 ( tp_1 ) ? fn_8 ( vr_11 , vr_12 )
: fn_9 ( vr_11 , vr_12 ) ) ;
}
extern char *
fn_10 ( tp_2 vr_16 )
{
char vr_12 [ fn_4 ( vl_2 ) ] ;
struct vr_17 * vr_18 = fn_11 ( vr_16 ) ;
return fn_6 ( vr_18 ? vr_18 -> vr_19
: fn_7 ( tp_2 ) ? fn_8 ( vr_16 , vr_12 )
: fn_9 ( vr_16 , vr_12 ) ) ;
}
static char *
fn_12 ( char const * vr_20 , char const * vr_13 )
{
char * vr_21 = NULL ;
if ( vr_20 )
{
if ( vr_13 )
{
vr_21 = xmalloc ( strlen ( vr_20 ) + 1 + strlen ( vr_13 ) + 1 ) ;
fn_13 ( fn_13 ( fn_13 ( vr_21 , vr_20 ) , lr_1 ) , vr_13 ) ;
}
else
{
vr_21 = fn_6 ( vr_20 ) ;
}
}
else if ( vr_13 )
{
vr_21 = fn_6 ( vr_13 ) ;
}
return vr_21 ;
}
static void
fn_14 ( const char * vr_22 , enum vr_23 vr_24 ,
char const * vr_25 , char const * vr_26 ,
char const * vr_20 , char const * vr_13 )
{
const char * vr_27 ;
char * vr_28 ;
char * vr_21 ;
if ( vr_24 == vl_3 )
{
printf ( _ ( lr_2 ) ,
fn_15 ( vr_22 ) ) ;
return;
}
vr_21 = fn_12 ( vr_20 , vr_13 ) ;
vr_28 = fn_12 ( vr_20 ? vr_25 : NULL , vr_13 ? vr_26 : NULL ) ;
switch ( vr_24 )
{
case vl_4 :
vr_27 = ( vr_20 ? _ ( lr_3 )
: vr_13 ? _ ( lr_4 )
: _ ( lr_5 ) ) ;
break;
case vl_5 :
if ( vr_28 )
{
vr_27 = ( vr_20 ? _ ( lr_6 )
: vr_13 ? _ ( lr_7 )
: _ ( lr_8 ) ) ;
}
else
{
vr_27 = ( vr_20 ? _ ( lr_9 )
: vr_13 ? _ ( lr_10 )
: _ ( lr_8 ) ) ;
free ( vr_28 ) ;
vr_28 = vr_21 ;
vr_21 = NULL ;
}
break;
case vl_6 :
vr_27 = ( vr_20 ? _ ( lr_11 )
: vr_13 ? _ ( lr_12 )
: _ ( lr_13 ) ) ;
break;
default:
abort () ;
}
printf ( vr_27 , fn_15 ( vr_22 ) , vr_28 , vr_21 ) ;
free ( vr_28 ) ;
free ( vr_21 ) ;
}
static enum vr_29
fn_16 ( int vr_30 , char const * vr_22 ,
struct vr_31 const * vr_32 ,
tp_2 vr_16 , tp_1 vr_11 ,
tp_2 vr_33 , tp_1 vr_34 )
{
enum vr_29 vr_35 = vl_7 ;
struct vr_31 vr_36 ;
int vr_37 = vl_8 | vl_9 ;
int vr_38 ;
if ( vr_33 == ( tp_2 ) - 1 && vr_34 == ( tp_1 ) - 1 )
return vl_10 ;
if ( ! fn_17 ( vr_32 -> vr_39 ) )
{
if ( fn_18 ( vr_32 -> vr_39 ) )
vr_37 |= vl_11 ;
else
return vl_10 ;
}
vr_38 = fn_19 ( vr_30 , vr_22 , vl_12 | vr_37 ) ;
if ( ! ( 0 <= vr_38
|| ( vl_13 == vl_14 && fn_17 ( vr_32 -> vr_39 )
&& 0 <= ( vr_38 = fn_19 ( vr_30 , vr_22 , vl_15 | vr_37 ) ) ) ) )
return ( vl_13 == vl_14 ? vl_10 : vl_16 ) ;
if ( fn_20 ( vr_38 , & vr_36 ) != 0 )
vr_35 = vl_16 ;
else if ( ! fn_21 ( * vr_32 , vr_36 ) )
vr_35 = vl_17 ;
else if ( ( vr_33 == ( tp_2 ) - 1 || vr_33 == vr_36 . vr_40 )
&& ( vr_34 == ( tp_1 ) - 1 || vr_34 == vr_36 . vr_41 ) )
{
if ( fn_22 ( vr_38 , vr_16 , vr_11 ) == 0 )
{
vr_35 = ( fn_23 ( vr_38 ) == 0
? vl_7 : vl_16 ) ;
return vr_35 ;
}
else
{
vr_35 = vl_16 ;
}
}
int vr_42 = vl_13 ;
fn_23 ( vr_38 ) ;
vl_13 = vr_42 ;
return vr_35 ;
}
static bool
fn_24 ( tp_3 * vr_43 , tp_4 * vr_44 ,
tp_2 vr_16 , tp_1 vr_11 ,
tp_2 vr_33 , tp_1 vr_34 ,
struct vr_1 const * vr_2 )
{
char const * vr_45 = vr_44 -> vr_46 ;
char const * vr_22 = vr_44 -> vr_47 ;
struct vr_31 const * vr_48 ;
struct vr_31 vr_49 ;
bool vr_50 = true ;
bool vr_51 ;
bool vr_52 = true ;
switch ( vr_44 -> vr_53 )
{
case vl_18 :
if ( vr_2 -> vr_6 )
{
if ( fn_25 ( vr_2 -> vr_4 , vr_44 -> vr_54 ) )
{
fn_26 ( vr_45 ) ;
fn_27 ( vr_43 , vr_44 , vl_19 ) ;
fn_28 ( fn_29 ( vr_43 ) ) ;
return false ;
}
return true ;
}
break;
case vl_20 :
if ( ! vr_2 -> vr_6 )
return true ;
break;
case vl_21 :
if ( vr_44 -> vr_55 == 0 && vr_44 -> vr_56 == 0 )
{
vr_44 -> vr_56 = 1 ;
fn_27 ( vr_43 , vr_44 , vl_22 ) ;
return true ;
}
if ( ! vr_2 -> vr_7 )
error ( 0 , vr_44 -> vr_57 , _ ( lr_14 ) ,
fn_15 ( vr_45 ) ) ;
vr_50 = false ;
break;
case vl_23 :
if ( ! vr_2 -> vr_7 )
error ( 0 , vr_44 -> vr_57 , lr_15 , fn_15 ( vr_45 ) ) ;
vr_50 = false ;
break;
case vl_24 :
if ( ! vr_2 -> vr_7 )
error ( 0 , vr_44 -> vr_57 , _ ( lr_16 ) ,
fn_15 ( vr_45 ) ) ;
vr_50 = false ;
break;
case vl_25 :
if ( fn_30 ( vr_43 , vr_44 ) )
{
fn_31 ( vr_45 ) ;
return false ;
}
break;
default:
break;
}
if ( ! vr_50 )
{
vr_51 = false ;
vr_48 = NULL ;
}
else if ( vr_33 == ( tp_2 ) - 1 && vr_34 == ( tp_1 ) - 1
&& vr_2 -> vr_3 == vl_1
&& ! vr_2 -> vr_4
&& ! vr_2 -> vr_5 )
{
vr_51 = true ;
vr_48 = vr_44 -> vr_54 ;
}
else
{
vr_48 = vr_44 -> vr_54 ;
if ( vr_2 -> vr_5 && fn_32 ( vr_48 -> vr_39 ) )
{
if ( fn_33 ( vr_43 -> vr_58 , vr_22 , & vr_49 , 0 ) != 0 )
{
if ( ! vr_2 -> vr_7 )
error ( 0 , vl_13 , _ ( lr_17 ) ,
fn_15 ( vr_45 ) ) ;
vr_50 = false ;
}
vr_48 = & vr_49 ;
}
vr_51 = ( vr_50
&& ( vr_33 == ( tp_2 ) - 1
|| vr_33 == vr_48 -> vr_40 )
&& ( vr_34 == ( tp_1 ) - 1
|| vr_34 == vr_48 -> vr_41 ) ) ;
}
if ( vr_50
&& fn_34 ( vr_44 )
&& fn_25 ( vr_2 -> vr_4 , vr_48 ) )
{
fn_26 ( vr_45 ) ;
return false ;
}
if ( vr_51 )
{
if ( ! vr_2 -> vr_5 )
{
vr_50 = ( fn_35 ( vr_43 -> vr_58 , vr_22 , vr_16 , vr_11 ) == 0 ) ;
if ( ! vr_50 && vl_13 == vl_26 )
{
vr_50 = true ;
vr_52 = false ;
}
}
else
{
enum vr_29 vr_59
= fn_16 ( vr_43 -> vr_58 , vr_22 , vr_48 , vr_16 , vr_11 ,
vr_33 , vr_34 ) ;
switch ( vr_59 )
{
case vl_7 :
break;
case vl_10 :
vr_50 = ( fn_36 ( vr_43 -> vr_58 , vr_22 , vr_16 , vr_11 ) == 0 ) ;
break;
case vl_16 :
vr_50 = false ;
break;
case vl_17 :
case vl_27 :
vr_51 = false ;
vr_50 = false ;
break;
default:
abort () ;
}
}
if ( vr_51 && ! vr_50 && ! vr_2 -> vr_7 )
error ( 0 , vl_13 , ( vr_16 != ( tp_2 ) - 1
? _ ( lr_18 )
: _ ( lr_19 ) ) ,
fn_15 ( vr_45 ) ) ;
}
if ( vr_2 -> vr_3 != vl_1 )
{
bool vr_24 =
( ( vr_51 && vr_50 && vr_52 )
&& ! ( ( vr_16 == ( tp_2 ) - 1 || vr_16 == vr_48 -> vr_40 )
&& ( vr_11 == ( tp_1 ) - 1 || vr_11 == vr_48 -> vr_41 ) ) ) ;
if ( vr_24 || vr_2 -> vr_3 == vl_28 )
{
enum vr_23 vr_60 =
( ! vr_50 ? vl_5
: ! vr_52 ? vl_3
: ! vr_24 ? vl_6
: vl_4 ) ;
char * vr_61 = vr_48 ? fn_10 ( vr_48 -> vr_40 ) : NULL ;
char * vr_62 = vr_48 ? fn_3 ( vr_48 -> vr_41 ) : NULL ;
fn_14 ( vr_45 , vr_60 ,
vr_61 , vr_62 ,
vr_2 -> vr_8 , vr_2 -> vr_9 ) ;
free ( vr_61 ) ;
free ( vr_62 ) ;
}
}
if ( ! vr_2 -> vr_6 )
fn_27 ( vr_43 , vr_44 , vl_19 ) ;
return vr_50 ;
}
extern bool
fn_37 ( char * * vr_63 , int vr_64 ,
tp_2 vr_16 , tp_1 vr_11 ,
tp_2 vr_33 , tp_1 vr_34 ,
struct vr_1 const * vr_2 )
{
bool vr_50 = true ;
int vr_65 = ( ( vr_33 != ( tp_2 ) - 1 || vr_34 != ( tp_1 ) - 1
|| vr_2 -> vr_5
|| vr_2 -> vr_3 != vl_1 )
? 0
: vl_29 ) ;
tp_3 * vr_43 = fn_38 ( vr_63 , vr_64 | vr_65 , NULL ) ;
while ( 1 )
{
tp_4 * vr_44 ;
vr_44 = fn_29 ( vr_43 ) ;
if ( vr_44 == NULL )
{
if ( vl_13 != 0 )
{
if ( ! vr_2 -> vr_7 )
error ( 0 , vl_13 , _ ( lr_20 ) ) ;
vr_50 = false ;
}
break;
}
vr_50 &= fn_24 ( vr_43 , vr_44 , vr_16 , vr_11 , MST[NEQ$@1$@2$!LE$@1$@2$]MSP[]
vr_33 , vr_34 , vr_2 ) ;
}
if ( fn_39 ( vr_43 ) != 0 )
{
error ( 0 , vl_13 , _ ( lr_21 ) ) ;
vr_50 = false ;
}
return vr_50 ;
}
