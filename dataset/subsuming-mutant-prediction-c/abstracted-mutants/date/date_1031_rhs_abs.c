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
fn_3 () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fputs ( _ ( lr_10 ) , stdout ) ;
fputs ( _ ( lr_11 ) , stdout ) ;
fputs ( _ ( lr_12 ) , stdout ) ;
fputs ( _ ( lr_13 ) , stdout ) ;
fputs ( _ ( lr_14 ) , stdout ) ;
fputs ( _ ( lr_15 ) , stdout ) ;
fputs ( _ ( lr_16 ) , stdout ) ;
fputs ( _ ( lr_17 ) , stdout ) ;
fputs ( _ ( lr_18 ) , stdout ) ;
fputs ( _ ( lr_19 ) , stdout ) ;
fn_4 () ;
}
exit ( vr_1 ) ;
}
static bool
fn_5 ( const char * vr_2 , const char * vr_3 )
{
bool vr_4 ;
tp_1 * vr_5 ;
char * line ;
tp_2 vr_6 ;
struct vr_7 vr_8 ;
if ( fn_6 ( vr_2 , lr_20 ) )
{
vr_2 = _ ( lr_21 ) ;
vr_5 = vl_5 ;
}
else
{
vr_5 = fopen ( vr_2 , lr_22 ) ;
if ( vr_5 == NULL )
{
error ( vl_6 , vl_7 , lr_23 , fn_7 ( vr_2 ) ) ;
}
}
line = NULL ;
vr_6 = 0 ;
vr_4 = true ;
while ( 1 )
{
tp_3 vr_9 = fn_8 ( & line , & vr_6 , vr_5 ) ;
if ( vr_9 < 0 )
{
break;
}
if ( ! fn_9 ( & vr_8 , line , NULL ) )
{
if ( line [ vr_9 - 1 ] == '\n' )
line [ vr_9 - 1 ] = '\0' ;
error ( 0 , 0 , _ ( lr_24 ) , fn_7 ( line ) ) ;
vr_4 = false ;
}
else
{
vr_4 &= fn_10 ( vr_3 , vr_8 ) ;
}
}
if ( fclose ( vr_5 ) == vl_8 )
error ( vl_6 , vl_7 , lr_23 , fn_7 ( vr_2 ) ) ;
free ( line ) ;
return vr_4 ;
}
int
main ( int vr_10 , char * * vr_11 )
{
int vr_12 ;
const char * vr_13 = NULL ;
const char * vr_14 = NULL ;
struct vr_7 vr_8 ;
bool vr_15 = false ;
char const * vr_3 = NULL ;
char * vr_16 = NULL ;
char * vr_17 = NULL ;
struct vr_18 vr_19 ;
bool vr_4 ;
int vr_20 ;
fn_11 ( & vr_10 , & vr_11 ) ;
fn_12 ( vr_11 [ 0 ] ) ;
setlocale ( vl_9 , lr_25 ) ;
fn_13 ( vl_10 , vl_11 ) ;
fn_14 ( vl_10 ) ;
atexit ( vl_12 ) ;
while ( ( vr_12 = fn_15 ( vr_10 , vr_11 , vl_13 , vl_14 , NULL ) )
!= - 1 )
{
char const * vr_21 = NULL ;
switch ( vr_12 )
{
case 'd' :
vr_13 = vl_15 ;
break;
case 'f' :
vr_16 = vl_15 ;
break;
case vl_16 :
{
static char const vr_22 [] [ 32 ] =
{
lr_26 ,
lr_27 ,
lr_28
} ;
enum vr_23 vr_24 =
fn_16 ( lr_29 , vl_15 ,
vl_17 + 2 , vl_18 + 2 ) ;
vr_21 = vr_22 [ vr_24 ] ;
break;
}
case 'I' :
{
static char const vr_25 [] [ 32 ] =
{
lr_26 ,
lr_30 ,
lr_31 ,
lr_32 ,
lr_33
} ;
enum vr_23 vr_24 =
( vl_15
? fn_16 ( lr_34 , vl_15 , vl_17 , vl_18 )
: vl_19 ) ;
vr_21 = vr_25 [ vr_24 ] ;
break;
}
case 'r' :
vr_17 = vl_15 ;
break;
case 'R' :
vr_21 = vl_20 ;
break;
case 's' :
vr_14 = vl_15 ;
vr_15 = true ;
break;
case 'u' :
if ( putenv ( fn_17 ( lr_35 ) ) != 0 )
fn_18 () ;
vl_21 ;
break;
vl_22 ;
fn_19 ( vl_23 , vl_24 ) ;
default:
fn_1 ( vl_6 ) ;
}
if ( vr_21 )
{
if ( vr_3 )
error ( vl_6 , 0 , _ ( lr_36 ) ) ;
vr_3 = vr_21 ;
}
}
vr_20 = ( ( vr_13 ? 1 : 0 )
+ ( vr_16 ? 1 : 0 )
+ ( vr_17 ? 1 : 0 ) ) ;
if ( vr_20 > 1 )
{
error ( 0 , 0 ,
_ ( lr_37 ) ) ;
fn_1 ( vl_6 ) ;
}
if ( vr_15 && vr_20 )
{
error ( 0 , 0 ,
_ ( lr_38 ) ) ;
fn_1 ( vl_6 ) ;
}
if ( vl_25 < vr_10 )
{
if ( vl_25 + 1 < vr_10 )
{
error ( 0 , 0 , _ ( lr_39 ) , fn_7 ( vr_11 [ vl_25 + 1 ] ) ) ;
fn_1 ( vl_6 ) ;
}
if ( vr_11 [ vl_25 ] [ 0 ] == '+' ) MST[EQ$@1$@2$!ADD$@1$@2$]MSP[N]
{
if ( vr_3 )
error ( vl_6 , 0 , _ ( lr_36 ) ) ;
vr_3 = vr_11 [ vl_25 ++ ] + 1 ;
}
else if ( vr_15 || vr_20 )
{
error ( 0 , 0 ,
_ ( lr_40
lr_41
lr_42 ) ,
fn_7 ( vr_11 [ vl_25 ] ) ) ;
fn_1 ( vl_6 ) ;
}
}
if ( ! vr_3 )
{
vr_3 = fn_20 () ;
if ( ! * vr_3 )
{
vr_3 = lr_43 ;
}
}
if ( vr_16 != NULL )
vr_4 = fn_5 ( vr_16 , vr_3 ) ;
else
{
bool vr_26 = true ;
vr_4 = true ;
if ( ! vr_20 && ! vr_15 )
{
if ( vl_25 < vr_10 )
{
vr_15 = true ;
vr_13 = vr_11 [ vl_25 ] ;
vr_26 = fn_21 ( & vr_8 . vr_27 ,
vr_13 ,
( vl_26
| vl_27 | vl_28 ) ) ;
vr_8 . vr_28 = 0 ;
}
else
{
fn_22 ( & vr_8 ) ;
}
}
else
{
if ( vr_17 != NULL )
{
if ( vr_18 ( vr_17 , & vr_19 ) != 0 )
error ( vl_6 , vl_7 , lr_23 , vr_17 ) ;
vr_8 = fn_23 ( & vr_19 ) ;
}
else
{
if ( vr_14 )
vr_13 = vr_14 ;
vr_26 = fn_9 ( & vr_8 , vr_13 , NULL ) ;
}
}
if ( ! vr_26 )
error ( vl_6 , 0 , _ ( lr_24 ) , fn_7 ( vr_13 ) ) ;
if ( vr_15 )
{
if ( fn_24 ( & vr_8 ) != 0 )
{
error ( 0 , vl_7 , _ ( lr_44 ) ) ;
vr_4 = false ;
}
}
vr_4 &= fn_10 ( vr_3 , vr_8 ) ;
}
exit ( vr_4 ? vl_1 : vl_6 ) ;
}
static bool
fn_10 ( const char * vr_3 , struct vr_7 vr_8 )
{
struct vr_29 * vr_29 ;
vr_29 = localtime ( & vr_8 . vr_27 ) ;
if ( ! vr_29 )
{
char vr_30 [ fn_25 ( vl_29 ) ] ;
error ( 0 , 0 , _ ( lr_45 ) , fn_26 ( vr_8 . vr_27 , vr_30 ) ) ;
return false ;
}
if ( vr_3 == vl_20 )
setlocale ( vl_30 , lr_46 ) ;
fn_27 ( stdout , vr_3 , vr_29 , 0 , vr_8 . vr_28 ) ;
fputc ( '\n' , stdout ) ;
if ( vr_3 == vl_20 )
setlocale ( vl_30 , lr_25 ) ;
return true ;
}
