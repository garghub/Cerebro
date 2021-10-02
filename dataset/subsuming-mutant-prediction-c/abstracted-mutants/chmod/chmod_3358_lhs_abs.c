static bool
fn_1 ( char const * vr_1 , tp_1 vr_2 , tp_1 vr_3 )
{
if ( vr_3 & ( vl_1 | vl_2 | vl_3 ) )
{
struct vr_4 vr_5 ;
if ( vr_4 ( vr_1 , & vr_5 ) != 0 )
{
if ( ! vl_4 )
error ( 0 , vl_5 , _ ( lr_1 ) , fn_2 ( vr_1 ) ) ;
return false ;
}
vr_3 = vr_5 . vr_6 ;
}
return ( ( vr_2 ^ vr_3 ) & vl_6 ) != 0 ;
}
static void
fn_3 ( const char * vr_1 , tp_1 vr_2 , tp_1 vr_7 ,
enum vr_8 vr_9 )
{
char vr_10 [ 12 ] ;
char vr_11 [ 12 ] ;
const char * vr_12 ;
if ( vr_9 == vl_7 )
{
printf ( _ ( lr_2 ) ,
fn_2 ( vr_1 ) ) ;
return;
}
fn_4 ( vr_7 , vr_10 ) ;
vr_10 [ 10 ] = '\0' ;
fn_4 ( vr_2 , vr_11 ) ;
vr_11 [ 10 ] = '\0' ;
switch ( vr_9 )
{
case vl_8 :
vr_12 = _ ( lr_3 ) ;
break;
case vl_9 :
vr_12 = _ ( lr_4 ) ;
break;
case vl_10 :
vr_12 = _ ( lr_5 ) ;
printf ( vr_12 , fn_2 ( vr_1 ) ,
(unsigned long int) ( vr_7 & vl_6 ) , & vr_10 [ 1 ] ) ;
return;
default:
abort () ;
}
printf ( vr_12 , fn_2 ( vr_1 ) ,
(unsigned long int) ( vr_2 & vl_6 ) , & vr_11 [ 1 ] ,
(unsigned long int) ( vr_7 & vl_6 ) , & vr_10 [ 1 ] ) ;
}
static bool
fn_5 ( tp_2 * vr_13 , tp_3 * vr_14 )
{
char const * vr_15 = vr_14 -> vr_16 ;
char const * vr_1 = vr_14 -> vr_17 ;
const struct vr_4 * vr_18 = vr_14 -> vr_19 ;
tp_1 vr_2 vr_20 ( = 0 ) ;
tp_1 vr_3 vr_20 ( = 0 ) ;
bool vr_21 = true ;
bool vr_22 = false ;
switch ( vr_14 -> vr_23 )
{
case vl_11 :
return true ;
case vl_12 :
if ( vr_14 -> vr_24 == 0 && vr_14 -> vr_25 == 0 )
{
vr_14 -> vr_25 = 1 ;
fn_6 ( vr_13 , vr_14 , vl_13 ) ;
return true ;
}
if ( ! vl_4 )
error ( 0 , vr_14 -> vr_26 , _ ( lr_6 ) ,
fn_2 ( vr_15 ) ) ;
vr_21 = false ;
break;
case vl_14 :
if ( ! vl_4 )
error ( 0 , vr_14 -> vr_26 , lr_7 , fn_2 ( vr_15 ) ) ;
vr_21 = false ;
break;
case vl_15 :
if ( ! vl_4 )
error ( 0 , vr_14 -> vr_26 , _ ( lr_8 ) ,
fn_2 ( vr_15 ) ) ;
vr_21 = false ;
break;
case vl_16 :
if ( ! vl_4 )
error ( 0 , 0 , _ ( lr_9 ) ,
fn_2 ( vr_15 ) ) ;
vr_21 = false ;
break;
case vl_17 :
if ( fn_7 ( vr_13 , vr_14 ) )
{
fn_8 ( vr_15 ) ;
return false ;
}
break;
default:
break;
}
if ( vr_21 && fn_9 ( vl_18 , vr_18 ) )
{
fn_10 ( vr_15 ) ;
fn_6 ( vr_13 , vr_14 , vl_19 ) ;
fn_11 ( fn_12 ( vr_13 ) ) ;
return false ;
}
if ( vr_21 )
{
vr_2 = vr_18 -> vr_6 ;
vr_3 = fn_13 ( vr_2 , fn_14 ( vr_2 ) != 0 , vl_20 ,
vl_21 , NULL ) ;
if ( ! fn_15 ( vr_2 ) )
{
if ( fn_16 ( vr_13 -> vr_27 , vr_1 , vr_3 ) == 0 )
vr_22 = true ;
else
{
if ( ! vl_4 )
error ( 0 , vl_5 , _ ( lr_10 ) ,
fn_2 ( vr_15 ) ) ;
vr_21 = false ;
}
}
}
if ( vl_22 != vl_23 )
{
bool vr_9 = ( vr_22
&& fn_1 ( vr_1 , vr_2 , vr_3 ) ) ;
if ( vr_9 || vl_22 == vl_24 )
{
enum vr_8 vr_28 =
( ! vr_21 ? vl_9
: ! vr_22 ? vl_7
: ! vr_9 ? vl_10
: vl_8 ) ;
fn_3 ( vr_15 , vr_2 , vr_3 , vr_28 ) ;
}
}
if ( vr_22 && vl_25 )
{
tp_1 vr_29 =
fn_13 ( vr_2 , fn_14 ( vr_2 ) != 0 , 0 , vl_21 , NULL ) ;
if ( vr_3 & ~ vr_29 ) MST[BITAND$@1$@2$!BITXOR$@1$@2$]MSP[]
{
char vr_30 [ 12 ] ;
char vr_31 [ 12 ] ;
fn_4 ( vr_3 , vr_30 ) ;
fn_4 ( vr_29 , vr_31 ) ;
vr_30 [ 10 ] = vr_31 [ 10 ] = '\0' ;
error ( 0 , 0 ,
_ ( lr_11 ) ,
fn_17 ( vr_15 ) ,
vr_30 + 1 , vr_31 + 1 ) ;
vr_21 = false ;
}
}
if ( ! vl_26 )
fn_6 ( vr_13 , vr_14 , vl_19 ) ;
return vr_21 ;
}
static bool
fn_18 ( char * * vr_32 , int vr_33 )
{
bool vr_21 = true ;
tp_2 * vr_13 = fn_19 ( vr_32 , vr_33 , NULL ) ;
while ( 1 )
{
tp_3 * vr_14 ;
vr_14 = fn_12 ( vr_13 ) ;
if ( vr_14 == NULL )
{
if ( vl_5 != 0 )
{
if ( ! vl_4 )
error ( 0 , vl_5 , _ ( lr_12 ) ) ;
vr_21 = false ;
}
break;
}
vr_21 &= fn_5 ( vr_13 , vr_14 ) ;
}
if ( fn_20 ( vr_13 ) != 0 )
{
error ( 0 , vl_5 , _ ( lr_13 ) ) ;
vr_21 = false ;
}
return vr_21 ;
}
void
fn_21 ( int vr_34 )
{
if ( vr_34 != vl_27 )
fn_22 () ;
else
{
printf ( _ ( lr_14 ) ,
vl_28 , vl_28 , vl_28 ) ;
fputs ( _ ( lr_15 ) , stdout ) ;
fputs ( _ ( lr_16 ) , stdout ) ;
fputs ( _ ( lr_17 ) , stdout ) ;
fputs ( _ ( lr_18 ) , stdout ) ;
fputs ( _ ( lr_19 ) , stdout ) ;
fputs ( vl_29 , stdout ) ;
fputs ( vl_30 , stdout ) ;
fputs ( _ ( lr_20 ) , stdout ) ;
fn_23 () ;
}
exit ( vr_34 ) ;
}
int
main ( int vr_35 , char * * vr_36 )
{
char * vr_7 = NULL ;
tp_4 vr_37 = 0 ;
tp_4 vr_38 = 0 ;
bool vr_21 ;
bool vr_39 = false ;
char const * vr_40 = NULL ;
int vr_41 ;
fn_24 ( & vr_35 , & vr_36 ) ;
fn_25 ( vr_36 [ 0 ] ) ;
setlocale ( vl_31 , lr_21 ) ;
fn_26 ( vl_32 , vl_33 ) ;
fn_27 ( vl_32 ) ;
atexit ( vl_34 ) ;
vl_26 = vl_4 = vl_25 = false ;
while ( ( vr_41 = fn_28 ( vr_35 , vr_36 ,
( lr_22
lr_23 ) ,
vl_35 , NULL ) )
!= - 1 )
{
switch ( vr_41 )
{
case 'r' :
case 'w' :
case 'x' :
case 'X' :
case 's' :
case 't' :
case 'u' :
case 'g' :
case 'o' :
case 'a' :
case ',' :
case '+' :
case '=' :
case '0' : case '1' : case '2' : case '3' :
case '4' : case '5' : case '6' : case '7' :
{
char const * vr_42 = vr_36 [ vl_36 - 1 ] ;
tp_4 vr_43 = strlen ( vr_42 ) ;
tp_4 vr_44 = vr_37 + ! ! vr_37 ;
tp_4 vr_45 = vr_44 + vr_43 ;
if ( vr_38 <= vr_45 )
{
vr_38 = vr_45 + 1 ;
vr_7 = fn_29 ( vr_7 , & vr_38 ) ;
}
vr_7 [ vr_37 ] = ',' ;
memcpy ( vr_7 + vr_44 , vr_42 , vr_43 + 1 ) ;
vr_37 = vr_45 ;
vl_25 = true ;
}
break;
case vl_37 :
vr_39 = false ;
break;
case vl_38 :
vr_39 = true ;
break;
case vl_39 :
vr_40 = vl_40 ;
break;
case 'R' :
vl_26 = true ;
break;
case 'c' :
vl_22 = vl_41 ;
break;
case 'f' :
vl_4 = true ;
break;
case 'v' :
vl_22 = vl_24 ;
break;
vl_42 ;
fn_30 ( vl_43 , vl_44 ) ;
default:
fn_21 ( vl_45 ) ;
}
}
if ( vr_40 )
{
if ( vr_7 )
{
error ( 0 , 0 , _ ( lr_24 ) ) ;
fn_21 ( vl_45 ) ;
}
}
else
{
if ( ! vr_7 )
vr_7 = vr_36 [ vl_36 ++ ] ;
}
if ( vl_36 >= vr_35 )
{
if ( ! vr_7 || vr_7 != vr_36 [ vl_36 - 1 ] )
error ( 0 , 0 , _ ( lr_25 ) ) ;
else
error ( 0 , 0 , _ ( lr_26 ) , fn_2 ( vr_36 [ vr_35 - 1 ] ) ) ;
fn_21 ( vl_45 ) ;
}
if ( vr_40 )
{
vl_21 = fn_31 ( vr_40 ) ;
if ( ! vl_21 )
error ( vl_45 , vl_5 , _ ( lr_27 ) ,
fn_2 ( vr_40 ) ) ;
}
else
{
vl_21 = fn_32 ( vr_7 ) ;
if ( ! vl_21 )
{
error ( 0 , 0 , _ ( lr_28 ) , fn_2 ( vr_7 ) ) ;
fn_21 ( vl_45 ) ;
}
vl_20 = fn_33 ( 0 ) ;
}
if ( vl_26 && vr_39 )
{
static struct vr_46 vr_47 ;
vl_18 = fn_34 ( & vr_47 ) ;
if ( vl_18 == NULL )
error ( vl_45 , vl_5 , _ ( lr_27 ) ,
fn_2 ( lr_29 ) ) ;
}
else
{
vl_18 = NULL ;
}
vr_21 = fn_18 ( vr_36 + vl_36 ,
vl_46 | vl_47 | vl_48 ) ;
exit ( vr_21 ? vl_27 : vl_45 ) ;
}
