void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
printf ( vl_5 , vl_6 ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static void
fn_4 ( struct vr_2 * vr_3 )
{
free ( vr_3 -> vr_4 ) ;
free ( vr_3 ) ;
}
static struct vr_2 *
fn_5 ( void )
{
struct vr_2 * vr_3 = xmalloc ( sizeof *vr_3 ) ;
vr_3 -> vr_5 = fn_6 ( 2 * vl_7 , 32 * 1024 ) ;
vr_3 -> vr_4 = xmalloc ( vr_3 -> vr_5 ) ;
vr_3 -> vr_6 = vr_3 -> vr_4 + ( vr_3 -> vr_5 - 1 ) ;
vr_3 -> vr_6 [ 0 ] = '\0' ;
return vr_3 ;
}
static void
fn_7 ( struct vr_2 * vr_3 , char const * vr_7 , tp_1 vr_8 )
{
tp_1 vr_9 = vr_3 -> vr_6 - vr_3 -> vr_4 ;
if ( vr_9 < 1 + vr_8 )
{
tp_1 vr_10 = vr_3 -> vr_5 + 1 + vr_8 ;
char * vr_11 = fn_8 ( 2 , vr_10 ) ;
tp_1 vr_12 = vr_3 -> vr_5 - vr_9 ;
vr_3 -> vr_6 = vr_11 + 2 * vr_10 - vr_12 ;
memcpy ( vr_3 -> vr_6 , vr_3 -> vr_4 + vr_9 , vr_12 ) ;
free ( vr_3 -> vr_4 ) ;
vr_3 -> vr_4 = vr_11 ;
vr_3 -> vr_5 = 2 * vr_10 ;
}
vr_3 -> vr_6 -= 1 + vr_8 ;
vr_3 -> vr_6 [ 0 ] = '/' ;
memcpy ( vr_3 -> vr_6 + 1 , vr_7 , vr_8 ) ;
}
static char *
fn_9 ( tp_1 vr_13 )
{
char * vr_4 = fn_8 ( 3 , vr_13 ) ;
char * vr_3 = vr_4 ;
tp_1 vr_14 ;
for ( vr_14 = 0 ; vr_14 < vr_13 ; vr_14 ++ )
{
memcpy ( vr_3 , lr_4 , 3 ) ;
vr_3 += 3 ;
}
vr_3 [ - 1 ] = '\0' ;
return vr_4 ;
}
static void
fn_10 ( struct vr_15 * vr_16 , struct vr_2 * vr_2 ,
tp_1 vr_17 )
{
tp_2 * vr_18 ;
int vr_19 ;
struct vr_15 vr_20 ;
bool vr_21 ;
bool vr_22 ;
vr_18 = fn_11 ( lr_5 ) ;
if ( vr_18 == NULL )
error ( vl_8 , vl_9 , _ ( lr_6 ) ,
fn_12 ( fn_9 ( vr_17 ) ) ) ;
vr_19 = fn_13 ( vr_18 ) ;
if ( ( 0 <= vr_19 ? fn_14 ( vr_19 ) : fn_15 ( lr_5 ) ) < 0 )
error ( vl_8 , vl_9 , _ ( lr_7 ) ,
fn_12 ( fn_9 ( vr_17 ) ) ) ;
if ( ( 0 <= vr_19 ? fn_16 ( vr_19 , & vr_20 ) : vr_15 ( lr_8 , & vr_20 ) ) < 0 )
error ( vl_8 , vl_9 , _ ( lr_9 ) ,
fn_12 ( fn_9 ( vr_17 ) ) ) ;
vr_21 = ( vr_20 . vr_23 != vr_16 -> vr_23 ) ;
vr_22 = false ;
while ( 1 )
{
struct vr_24 const * vr_25 ;
struct vr_15 vr_26 ;
tp_3 vr_27 ;
vl_9 = 0 ;
if ( ( vr_25 = fn_17 ( vr_18 ) ) == NULL )
{
if ( vl_9 )
{
int vr_28 = vl_9 ;
fn_18 ( vr_18 ) ;
vl_9 = vr_28 ;
vr_18 = NULL ;
}
break;
}
vr_27 = fn_19 ( vr_25 ) ;
if ( vr_27 == vl_10 || vr_21 )
{
if ( fn_20 ( vr_25 -> vr_29 , & vr_26 ) < 0 )
{
continue;
}
vr_27 = vr_26 . vr_30 ;
}
if ( vr_27 != vr_16 -> vr_30 )
continue;
if ( ! vr_21 || vr_26 . vr_23 == vr_16 -> vr_23 )
{
fn_7 ( vr_2 , vr_25 -> vr_29 , fn_21 ( vr_25 ) ) ;
vr_22 = true ;
break;
}
}
if ( vr_18 == NULL || fn_18 ( vr_18 ) != 0 )
{
error ( vl_8 , vl_9 , _ ( lr_10 ) ,
fn_12 ( fn_9 ( vr_17 ) ) ) ;
}
if ( ! vr_22 )
error ( vl_8 , 0 ,
_ ( lr_11 ) ,
fn_12 ( fn_9 ( vr_17 ) ) ) ;
* vr_16 = vr_20 ;
}
static void
fn_22 ( struct vr_2 * vr_2 )
{
tp_1 vr_31 = 1 ;
struct vr_32 vr_33 ;
struct vr_32 * vr_34 = fn_23 ( & vr_33 ) ;
struct vr_15 vr_16 ;
if ( vr_34 == NULL )
error ( vl_8 , vl_9 , _ ( lr_12 ) ,
fn_12 ( lr_13 ) ) ;
if ( vr_15 ( lr_8 , & vr_16 ) < 0 )
error ( vl_8 , vl_9 , _ ( lr_9 ) , fn_12 ( lr_8 ) ) ;
while ( 1 )
{
if ( fn_24 ( vr_16 , * vr_34 ) )
break;
fn_10 ( & vr_16 , vr_2 , vr_31 ++ ) ;
}
if ( vr_2 -> vr_6 [ 0 ] == '\0' )
fn_7 ( vr_2 , lr_14 , 0 ) ;
}
static char *
fn_25 ( void )
{
struct vr_15 vr_35 ;
struct vr_15 vr_36 ;
char * vr_37 = getenv ( lr_15 ) ;
char * vr_3 ;
if ( ! vr_37 || vr_37 [ 0 ] != '/' )
return NULL ;
vr_3 = vr_37 ;
while ( ( vr_3 = strstr ( vr_3 , lr_16 ) ) )
{
if ( ! vr_3 [ 2 ] || vr_3 [ 2 ] == '/'
|| ( vr_3 [ 2 ] == '.' && ( ! vr_3 [ 3 ] || vr_3 [ 3 ] == '/' ) ) )
return NULL ;
vr_3 ++ ;
}
if ( vr_15 ( vr_37 , & vr_35 ) == 0 && vr_15 ( lr_8 , & vr_36 ) == 0 && fn_24 ( vr_35 , vr_36 ) )
return vr_37 ;
return NULL ;
}
int
main ( int vr_38 , char * * vr_39 )
{
char * vr_37 ;
bool vr_40 = ( getenv ( lr_17 ) != NULL ) ;
fn_26 ( & vr_38 , & vr_39 ) ;
fn_27 ( vr_39 [ 0 ] ) ;
setlocale ( vl_11 , lr_14 ) ;
fn_28 ( vl_12 , vl_13 ) ;
fn_29 ( vl_12 ) ;
atexit ( vl_14 ) ;
while ( 1 )
{
int vr_41 = fn_30 ( vr_38 , vr_39 , lr_18 , vl_15 , NULL ) ;
if ( vr_41 == - 1 ) MST[EQ$@1$@2$!ABS$@1$]MSP[]
break;
switch ( vr_41 )
{
case 'L' :
vr_40 = true ;
break;
case 'P' :
vr_40 = false ;
break;
vl_16 ;
fn_31 ( vl_6 , vl_17 ) ;
default:
fn_1 ( vl_8 ) ;
}
}
if ( vl_18 < vr_38 )
error ( 0 , 0 , _ ( lr_19 ) ) ;
if ( vr_40 )
{
vr_37 = fn_25 () ;
if ( vr_37 )
{
puts ( vr_37 ) ;
exit ( vl_1 ) ;
}
}
vr_37 = fn_32 () ;
if ( vr_37 != NULL )
{
puts ( vr_37 ) ;
free ( vr_37 ) ;
}
else
{
struct vr_2 * vr_2 = fn_5 () ;
fn_22 ( vr_2 ) ;
puts ( vr_2 -> vr_6 ) ;
fn_4 ( vr_2 ) ;
}
exit ( vl_1 ) ;
}
