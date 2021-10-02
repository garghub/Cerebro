static int
fn_1 ( tp_1 vr_1 , tp_2 * vr_2 )
{
bool vr_3 = true ;
tp_2 vr_4 = fn_2 ( vr_1 ) ;
if ( ! vr_4 )
{
error ( 0 , vl_1 , _ ( lr_1 ) ,
fn_3 ( vr_1 ) ) ;
return 1 ;
}
#define mc_1 ( tp_3 , tp_4 ) \
do \
{ \
if (specified_ ## comp \
&& context_ ## comp ## _set ((C), specified_ ## comp)) \
{ \
error (0, errno, \
_("failed to set %s security context component to %s"), \
#comp, quote (specified_ ## comp)); \
ok = false; \
} \
} \
while (0)
mc_1 ( vr_4 , vl_2 ) ;
mc_1 ( vr_4 , vl_3 ) ;
mc_1 ( vr_4 , vl_4 ) ;
mc_1 ( vr_4 , type ) ;
if ( ! vr_3 )
{
int vr_5 = vl_1 ;
fn_4 ( vr_4 ) ;
vl_1 = vr_5 ;
return 1 ;
}
* vr_2 = vr_4 ;
return 0 ;
}
static int
fn_5 ( int vr_6 , char const * vr_7 )
{
tp_1 vr_8 = NULL ;
tp_2 vr_1 ;
tp_1 vr_9 ;
int vr_10 = 0 ;
if ( vl_5 == NULL )
{
int vr_11 = ( vl_6
? fn_6 ( vr_6 , vr_7 , & vr_8 )
: fn_7 ( vr_6 , vr_7 , & vr_8 ) ) ;
if ( vr_11 < 0 && vl_1 != vl_7 )
{
error ( 0 , vl_1 , _ ( lr_2 ) ,
fn_8 ( vr_7 ) ) ;
return 1 ;
}
if ( vr_8 == NULL )
{
error ( 0 , 0 , _ ( lr_3 ) ,
fn_8 ( vr_7 ) ) ;
return 1 ;
}
if ( fn_1 ( vr_8 , & vr_1 ) )
return 1 ;
}
else
{
vr_1 = fn_2 ( vl_5 ) ;
if ( ! vr_1 )
abort () ;
}
vr_9 = fn_9 ( vr_1 ) ;
if ( vr_8 == NULL || ! fn_10 ( vr_9 , vr_8 ) )
{
int vr_12 = ( vl_6
? fn_11 ( vr_6 , vr_7 , vr_9 )
: fn_12 ( vr_6 , vr_7 , vr_9 ) ) ;
if ( vr_12 )
{
vr_10 = 1 ;
error ( 0 , vl_1 , _ ( lr_4 ) ,
fn_13 ( 0 , vr_7 ) , fn_13 ( 1 , vr_9 ) ) ;
}
}
fn_4 ( vr_1 ) ;
fn_14 ( vr_8 ) ;
return vr_10 ;
}
static bool
fn_15 ( tp_5 * vr_13 , tp_6 * vr_14 )
{
char const * vr_15 = vr_14 -> vr_16 ;
char const * vr_7 = vr_14 -> vr_17 ;
const struct vr_18 * vr_19 = vr_14 -> vr_20 ;
bool vr_3 = true ;
switch ( vr_14 -> vr_21 )
{
case vl_8 :
if ( vl_9 )
{
if ( fn_16 ( vl_10 , vr_14 -> vr_20 ) )
{
fn_17 ( vr_15 ) ;
fn_18 ( vr_13 , vr_14 , vl_11 ) ;
fn_19 ( fn_20 ( vr_13 ) ) ;
return false ;
}
return true ;
}
break;
case vl_12 :
if ( ! vl_9 )
return true ;
break;
case vl_13 :
if ( vr_14 -> vr_22 == 0 && vr_14 -> vr_23 == 0 )
{
vr_14 -> vr_23 = 1 ;
fn_18 ( vr_13 , vr_14 , vl_14 ) ;
return true ;
}
error ( 0 , vr_14 -> vr_24 , _ ( lr_5 ) , fn_8 ( vr_15 ) ) ;
vr_3 = false ;
break;
case vl_15 :
error ( 0 , vr_14 -> vr_24 , lr_6 , fn_8 ( vr_15 ) ) ;
vr_3 = false ;
break;
case vl_16 :
error ( 0 , vr_14 -> vr_24 , _ ( lr_7 ) ,
fn_8 ( vr_15 ) ) ;
vr_3 = false ;
break;
case vl_17 :
if ( fn_21 ( vr_13 , vr_14 ) )
{
fn_22 ( vr_15 ) ;
return false ;
}
break;
default:
break;
}
if ( vr_14 -> vr_21 == vl_12
&& vr_3 && fn_16 ( vl_10 , vr_19 ) )
{
fn_17 ( vr_15 ) ;
vr_3 = false ;
}
if ( vr_3 )
{
if ( vl_18 )
printf ( _ ( lr_8 ) ,
fn_8 ( vr_15 ) ) ;
if ( fn_5 ( vr_13 -> vr_25 , vr_7 ) != 0 )
vr_3 = false ;
}
if ( ! vl_9 )
fn_18 ( vr_13 , vr_14 , vl_11 ) ;
return vr_3 ;
}
static bool
fn_23 ( char * * vr_26 , int vr_27 )
{
bool vr_3 = true ;
tp_5 * vr_13 = fn_24 ( vr_26 , vr_27 , NULL ) ;
while ( 1 )
{
tp_6 * vr_14 ;
vr_14 = fn_20 ( vr_13 ) ;
if ( vr_14 == NULL )
{
if ( vl_1 != 0 )
{
error ( 0 , vl_1 , _ ( lr_9 ) ) ;
vr_3 = false ;
}
break;
}
vr_3 &= fn_15 ( vr_13 , vr_14 ) ;
}
if ( fn_25 ( vr_13 ) != 0 )
{
error ( 0 , vl_1 , _ ( lr_10 ) ) ;
vr_3 = false ;
}
return vr_3 ;
}
void
fn_26 ( int vr_11 )
{
if ( vr_11 != vl_19 )
fn_27 () ;
else
{
printf ( _ ( lr_11 ) ,
vl_20 , vl_20 , vl_20 ) ;
fputs ( _ ( lr_12 ) , stdout ) ;
fn_28 () ;
fputs ( _ ( lr_13 ) , stdout ) ;
fputs ( _ ( lr_14 ) , stdout ) ;
fputs ( _ ( lr_15 ) , stdout ) ;
fputs ( _ ( lr_16 ) , stdout ) ;
fputs ( _ ( lr_17 ) , stdout ) ;
fputs ( _ ( lr_18 ) , stdout ) ;
fputs ( _ ( lr_19 ) , stdout ) ;
fputs ( vl_21 , stdout ) ;
fputs ( vl_22 , stdout ) ;
fn_29 () ;
}
exit ( vr_11 ) ;
}
int
main ( int vr_28 , char * * vr_29 )
{
tp_1 vr_30 = NULL ;
int vr_27 = vl_23 ;
int vr_31 = - 1 ;
bool vr_3 ;
bool vr_32 = false ;
bool vr_33 = false ;
char * vr_34 = NULL ;
int vr_35 ;
fn_30 ( & vr_28 , & vr_29 ) ;
fn_31 ( vr_29 [ 0 ] ) ;
setlocale ( vl_24 , lr_20 ) ;
fn_32 ( vl_25 , vl_26 ) ;
fn_33 ( vl_25 ) ;
atexit ( vl_27 ) ;
while ( ( vr_35 = fn_34 ( vr_28 , vr_29 , lr_21 , vl_28 , NULL ) )
!= - 1 )
{
switch ( vr_35 )
{
case 'H' :
vr_27 = vl_29 | vl_23 ;
break;
case 'L' :
vr_27 = vl_30 ;
break;
case 'P' :
vr_27 = vl_23 ;
break;
case 'h' :
vr_31 = 0 ;
break;
case vl_31 :
vr_31 = 1 ;
break;
case vl_32 :
vr_32 = false ;
break;
case vl_33 :
vr_32 = true ;
break;
case vl_34 :
vr_34 = vl_35 ;
break;
case 'R' :
vl_9 = true ;
break;
case 'f' :
break;
case 'v' :
vl_18 = true ;
break;
case 'u' :
vl_36 = vl_35 ;
vr_33 = true ;
break;
case 'r' :
vl_37 = vl_35 ;
vr_33 = true ;
break;
case 't' :
vl_38 = vl_35 ;
vr_33 = true ;
break;
case 'l' :
vl_39 = vl_35 ;
vr_33 = true ;
break;
vl_40 ;
fn_35 ( vl_41 , vl_42 ) ;
default:
fn_26 ( vl_43 ) ;
}
}
if ( vl_9 )
{
if ( vr_27 == vl_23 )
{
if ( vr_31 == 1 )
error ( vl_43 , 0 ,
_ ( lr_22 ) ) ;
vl_6 = false ;
}
else
{
if ( vr_31 == 0 )
error ( vl_43 , 0 , _ ( lr_23 ) ) ;
vl_6 = true ;
}
}
else
{
vr_27 = vl_23 ;
vl_6 = ( vr_31 != 0 ) ; MST[NEQ$@1$@2$!LE$@1$@2$]MSP[S]
}
if ( vr_28 - vl_44 < ( vr_34 || vr_33 ? 1 : 2 ) )
{
if ( vr_28 <= vl_44 )
error ( 0 , 0 , _ ( lr_24 ) ) ;
else
error ( 0 , 0 , _ ( lr_25 ) , fn_8 ( vr_29 [ vr_28 - 1 ] ) ) ;
fn_26 ( vl_43 ) ;
}
if ( vr_34 )
{
if ( fn_36 ( vr_34 , & vr_30 ) < 0 )
error ( vl_43 , vl_1 , _ ( lr_2 ) ,
fn_8 ( vr_34 ) ) ;
vl_5 = vr_30 ;
}
else if ( vr_33 )
{
vl_5 = NULL ;
}
else
{
tp_2 vr_1 ;
vl_5 = vr_29 [ vl_44 ++ ] ;
vr_1 = fn_2 ( vl_5 ) ;
if ( ! vr_1 )
error ( vl_43 , 0 , _ ( lr_26 ) ,
fn_3 ( vl_5 ) ) ;
fn_4 ( vr_1 ) ;
}
if ( vr_34 && vr_33 )
{
error ( 0 , 0 , _ ( lr_27 ) ) ;
fn_26 ( vl_43 ) ;
}
if ( vl_9 && vr_32 )
{
static struct vr_36 vr_37 ;
vl_10 = fn_37 ( & vr_37 ) ;
if ( vl_10 == NULL )
error ( vl_43 , vl_1 , _ ( lr_28 ) ,
fn_8 ( lr_29 ) ) ;
}
else
{
vl_10 = NULL ;
}
vr_3 = fn_23 ( vr_29 + vl_44 , vr_27 | vl_45 ) ;
exit ( vr_3 ? vl_19 : vl_43 ) ;
}
