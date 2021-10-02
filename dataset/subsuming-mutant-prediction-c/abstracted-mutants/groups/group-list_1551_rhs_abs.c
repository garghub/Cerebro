extern bool
fn_1 ( const char * vr_1 ,
tp_1 vr_2 , tp_2 vr_3 , tp_2 vr_4 ,
bool vr_5 , char vr_6 )
{
bool vr_7 = true ;
struct vr_8 * vr_9 = NULL ;
if ( vr_1 )
{
vr_9 = fn_2 ( vr_2 ) ;
if ( vr_9 == NULL )
vr_7 = false ;
}
if ( ! fn_3 ( vr_3 , vr_5 ) )
vr_7 = false ;
if ( vr_4 != vr_3 )
{
putchar ( vr_6 ) ;
if ( ! fn_3 ( vr_4 , vr_5 ) )
vr_7 = false ;
}
{
tp_2 * vr_10 ;
int vr_11 ;
int vr_12 = fn_4 ( vr_1 , ( vr_9 ? vr_9 -> vr_13 : vr_4 ) , & vr_10 ) ;
if ( vr_12 < 0 )
{
if ( vr_1 )
{
error ( 0 , vl_1 , _ ( lr_1 ) ,
fn_5 ( vr_1 ) ) ;
}
else
{
error ( 0 , vl_1 , _ ( lr_2 ) ) ;
}
return false ;
}
for ( vr_11 = 0 ; vr_11 < vr_12 ; vr_11 ++ )
if ( vr_10 [ vr_11 ] != vr_3 && vr_10 [ vr_11 ] != vr_4 ) MST[NEQ$@1$@2$!NEG$@2$]MSP[N]
{
putchar ( vr_6 ) ;
if ( ! fn_3 ( vr_10 [ vr_11 ] , vr_5 ) )
vr_7 = false ;
}
free ( vr_10 ) ;
}
return vr_7 ;
}
static char *
fn_6 ( tp_2 const * vr_14 )
{
static char vr_15 [ fn_7 ( vl_2 ) ] ;
return fn_8 ( * vr_14 , vr_15 ) ;
}
extern bool
fn_3 ( tp_2 vr_14 , bool vr_16 )
{
struct vr_17 * vr_18 = NULL ;
bool vr_7 = true ;
if ( vr_16 )
{
vr_18 = fn_9 ( vr_14 ) ;
if ( vr_18 == NULL )
{
error ( 0 , 0 , _ ( lr_3 ) ,
( unsigned long int ) vr_14 ) ;
vr_7 = false ;
}
}
char * vr_19 = vr_18 ? vr_18 -> vr_20 : fn_10 ( vr_14 ) ;
fputs ( vr_19 , stdout ) ;
return vr_7 ;
}
