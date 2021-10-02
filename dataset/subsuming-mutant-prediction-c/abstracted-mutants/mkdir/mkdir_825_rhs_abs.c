void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fn_3 () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_4 () ;
}
exit ( vr_1 ) ;
}
static void
fn_5 ( char const * vr_2 , void * vr_3 )
{
struct vr_4 const * vr_5 = vr_3 ;
if ( vr_5 -> vr_6 )
fn_6 ( stdout , vr_5 -> vr_6 , fn_7 ( vr_2 ) ) ;
}
static int
fn_8 ( char const * vr_2 , char const * vr_7 , void * vr_3 )
{
struct vr_4 const * vr_5 = vr_3 ;
if ( vr_5 -> vr_8 && fn_9 ( vr_2 , vl_5 ) < 0
&& ! fn_10 ( vl_6 ) )
error ( 0 , vl_6 , _ ( lr_4 ) ,
fn_7 ( vr_2 ) ) ;
tp_1 vr_9 = vl_7 | vl_8 ;
bool vr_10 = ( vr_5 -> vr_11 & vr_9 ) != 0 ;
if ( vr_10 )
fn_11 ( vr_5 -> vr_11 & ~ vr_9 ) ;
int vr_12 = fn_12 ( vr_7 , vl_9 ) ;
if ( vr_10 )
{
int vr_13 = vl_6 ;
fn_11 ( vr_5 -> vr_11 ) ;
vl_6 = vr_13 ;
}
if ( vr_12 == 0 )
{
vr_12 = ( vr_5 -> vr_11 & vl_10 ) != 0 ;
fn_5 ( vr_2 , vr_3 ) ;
}
return vr_12 ;
}
static int
fn_13 ( char * vr_2 , struct vr_14 * vr_15 , void * vr_3 )
{
struct vr_4 const * vr_5 = vr_3 ;
bool vr_16 = false ;
if ( vr_5 -> vr_8 )
{
if ( ! vr_5 -> vr_17 )
vr_16 = true ;
else
{
char * vr_18 = fn_14 ( vr_2 ) ;
struct vr_19 vr_20 ;
if ( fn_15 ( vr_18 , lr_5 ) MST[EQ$@1$@2$!BITXOR$@1$@2$]MSP[N]
|| ( vr_19 ( vr_18 , & vr_20 ) == 0 && fn_16 ( vr_20 . vr_21 ) ) )
vr_16 = true ;
free ( vr_18 ) ;
}
if ( vr_16 && fn_9 ( vr_2 , vl_5 ) < 0
&& ! fn_10 ( vl_6 ) )
error ( 0 , vl_6 , _ ( lr_4 ) ,
fn_7 ( vr_2 ) ) ;
}
int vr_22 = ( fn_17 ( vr_2 , vr_15 , vr_5 -> vr_17 , vr_3 ,
vr_5 -> vr_23 , fn_5 ,
vr_5 -> vr_24 , ( vl_11 ) - 1 , ( vl_12 ) - 1 , true )
? vl_1
: vl_13 ) ;
if ( vr_22 == vl_1 && vr_5 -> vr_8 && ! vr_16 )
{
if ( ! fn_18 ( fn_19 ( vr_2 ) , false , false )
&& ! fn_10 ( vl_6 ) )
error ( 0 , vl_6 , _ ( lr_6 ) ,
fn_7 ( vr_2 ) ) ;
}
return vr_22 ;
}
int
main ( int vr_25 , char * * vr_26 )
{
const char * vr_27 = NULL ;
int vr_28 ;
tp_2 vr_29 = NULL ;
struct vr_4 vr_3 ;
vr_3 . vr_17 = NULL ;
vr_3 . vr_23 = vl_9 ;
vr_3 . vr_24 = 0 ;
vr_3 . vr_6 = NULL ;
vr_3 . vr_8 = false ;
fn_20 ( & vr_25 , & vr_26 ) ;
fn_21 ( vr_26 [ 0 ] ) ;
setlocale ( vl_14 , lr_7 ) ;
fn_22 ( vl_15 , vl_16 ) ;
fn_23 ( vl_15 ) ;
atexit ( vl_17 ) ;
while ( ( vr_28 = fn_24 ( vr_25 , vr_26 , lr_8 , vl_18 , NULL ) ) != - 1 )
{
switch ( vr_28 )
{
case 'p' :
vr_3 . vr_17 = fn_8 ;
break;
case 'm' :
vr_27 = vl_19 ;
break;
case 'v' :
vr_3 . vr_6 = _ ( lr_9 ) ;
break;
case 'Z' :
if ( fn_25 () )
{
vr_29 = vl_19 ;
}
else if ( fn_26 () > 0 )
{
if ( vl_19 )
vr_29 = vl_19 ;
else
vr_3 . vr_8 = true ;
}
else if ( vl_19 )
{
error ( 0 , 0 ,
_ ( lr_10
lr_11 ) ) ;
}
break;
vl_20 ;
fn_27 ( vl_21 , vl_22 ) ;
default:
fn_1 ( vl_13 ) ;
}
}
if ( vl_23 == vr_25 )
{
error ( 0 , 0 , _ ( lr_12 ) ) ;
fn_1 ( vl_13 ) ;
}
if ( vr_29 )
{
int vr_22 = 0 ;
if ( fn_25 () )
vr_22 = fn_28 ( vr_29 ) ;
else
vr_22 = fn_29 ( vr_29 ) ;
if ( vr_22 < 0 )
error ( vl_13 , vl_6 ,
_ ( lr_13 ) ,
fn_7 ( vr_29 ) ) ;
}
if ( vr_3 . vr_17 || vr_27 )
{
tp_1 vr_11 = fn_11 ( 0 ) ;
fn_11 ( vr_11 ) ;
vr_3 . vr_11 = vr_11 ;
if ( vr_27 )
{
struct vr_30 * vr_31 = fn_30 ( vr_27 ) ;
if ( ! vr_31 )
error ( vl_13 , 0 , _ ( lr_14 ) ,
fn_7 ( vr_27 ) ) ;
vr_3 . vr_23 = fn_31 ( vl_9 , true , vr_11 , vr_31 ,
& vr_3 . vr_24 ) ;
free ( vr_31 ) ;
}
else
vr_3 . vr_23 = vl_9 ;
}
exit ( fn_32 ( vr_25 - vl_23 , vr_26 + vl_23 ,
fn_13 , & vr_3 ) ) ;
}
