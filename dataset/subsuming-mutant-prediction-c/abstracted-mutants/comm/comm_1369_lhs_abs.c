void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
printf ( _ ( lr_8 ) ,
vl_2 , vl_2 ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static void
fn_4 ( struct vr_2 const * line , tp_1 * vr_3 , int vr_4 )
{
switch ( vr_4 )
{
case 1 :
if ( ! vl_5 )
return;
break;
case 2 :
if ( ! vl_6 )
return;
if ( vl_5 )
fputs ( vl_7 , vr_3 ) ;
break;
case 3 :
if ( ! vl_8 )
return;
if ( vl_5 )
fputs ( vl_7 , vr_3 ) ;
if ( vl_6 )
fputs ( vl_7 , vr_3 ) ;
break;
}
fwrite ( line -> vr_5 , sizeof ( char ) , line -> vr_6 , vr_3 ) ;
}
static void
fn_5 ( struct vr_2 const * vr_7 ,
struct vr_2 const * vr_8 ,
int vr_9 )
{
if ( vl_9 != vl_10
&& ( ( vl_9 == vl_11 ) || vl_12 ) )
{
if ( ! vr_10 [ vr_9 - 1 ] )
{
int vr_11 ;
if ( vl_13 )
vr_11 = fn_6 ( vr_7 -> vr_5 , vr_7 -> vr_6 - 1 ,
vr_8 -> vr_5 , vr_8 -> vr_6 - 1 ) ;
else
vr_11 = fn_7 ( vr_7 -> vr_5 , vr_7 -> vr_6 - 1 ,
vr_8 -> vr_5 , vr_8 -> vr_6 - 1 ) ;
if ( 0 < vr_11 )
{
error ( ( vl_9 == vl_11
? vl_14 : 0 ) ,
0 , _ ( lr_9 ) , vr_9 ) ;
vr_10 [ vr_9 - 1 ] = true ;
}
}
}
}
static void
fn_8 ( char * * vr_12 )
{
struct vr_2 vr_13 [ 2 ] [ 4 ] ;
struct vr_2 * vr_14 [ 2 ] ;
struct vr_2 * vr_15 [ 2 ] [ 4 ] ;
int vr_16 [ 2 ] [ 3 ] ;
tp_1 * vr_17 [ 2 ] ;
int vr_18 , vr_19 ;
for ( vr_18 = 0 ; vr_18 < 2 ; vr_18 ++ )
{
for ( vr_19 = 0 ; vr_19 < 4 ; vr_19 ++ )
{
fn_9 ( & vr_13 [ vr_18 ] [ vr_19 ] ) ;
vr_15 [ vr_18 ] [ vr_19 ] = & vr_13 [ vr_18 ] [ vr_19 ] ;
}
vr_16 [ vr_18 ] [ 0 ] = 0 ;
vr_16 [ vr_18 ] [ 1 ] = 0 ;
vr_16 [ vr_18 ] [ 2 ] = 0 ;
vr_17 [ vr_18 ] = ( fn_10 ( vr_12 [ vr_18 ] , lr_10 ) ? vl_15 : fopen ( vr_12 [ vr_18 ] , lr_11 ) ) ;
if ( ! vr_17 [ vr_18 ] )
error ( vl_14 , vl_16 , lr_12 , vr_12 [ vr_18 ] ) ; MST[PADD_DEREF$P1$@2$!PDEREF_LEFTINC$P1$]MSP[]
fn_11 ( vr_17 [ vr_18 ] , vl_17 ) ;
vr_14 [ vr_18 ] = fn_12 ( vr_15 [ vr_18 ] [ vr_16 [ vr_18 ] [ 0 ] ] , vr_17 [ vr_18 ] ) ;
if ( ferror ( vr_17 [ vr_18 ] ) )
error ( vl_14 , vl_16 , lr_12 , vr_12 [ vr_18 ] ) ;
}
while ( vr_14 [ 0 ] || vr_14 [ 1 ] )
{
int vr_11 ;
bool vr_20 [ 2 ] = { false , false } ;
if ( ! vr_14 [ 0 ] )
vr_11 = 1 ;
else if ( ! vr_14 [ 1 ] )
vr_11 = - 1 ;
else
{
if ( vl_13 )
vr_11 = fn_6 ( vr_14 [ 0 ] -> vr_5 , vr_14 [ 0 ] -> vr_6 - 1 ,
vr_14 [ 1 ] -> vr_5 , vr_14 [ 1 ] -> vr_6 - 1 ) ;
else
{
tp_2 vr_21 = fn_13 ( vr_14 [ 0 ] -> vr_6 , vr_14 [ 1 ] -> vr_6 ) - 1 ;
vr_11 = memcmp ( vr_14 [ 0 ] -> vr_5 , vr_14 [ 1 ] -> vr_5 , vr_21 ) ;
if ( vr_11 == 0 )
vr_11 = ( vr_14 [ 0 ] -> vr_6 < vr_14 [ 1 ] -> vr_6
? - 1
: vr_14 [ 0 ] -> vr_6 != vr_14 [ 1 ] -> vr_6 ) ;
}
}
if ( vr_11 == 0 )
fn_4 ( vr_14 [ 1 ] , stdout , 3 ) ;
else
{
vl_12 = true ;
if ( vr_11 <= 0 )
fn_4 ( vr_14 [ 0 ] , stdout , 1 ) ;
else
fn_4 ( vr_14 [ 1 ] , stdout , 2 ) ;
}
if ( 0 <= vr_11 )
vr_20 [ 1 ] = true ;
if ( vr_11 <= 0 )
vr_20 [ 0 ] = true ;
for ( vr_18 = 0 ; vr_18 < 2 ; vr_18 ++ )
if ( vr_20 [ vr_18 ] )
{
vr_16 [ vr_18 ] [ 2 ] = vr_16 [ vr_18 ] [ 1 ] ;
vr_16 [ vr_18 ] [ 1 ] = vr_16 [ vr_18 ] [ 0 ] ;
vr_16 [ vr_18 ] [ 0 ] = ( vr_16 [ vr_18 ] [ 0 ] + 1 ) & 0x03 ;
vr_14 [ vr_18 ] = fn_12 ( vr_15 [ vr_18 ] [ vr_16 [ vr_18 ] [ 0 ] ] , vr_17 [ vr_18 ] ) ;
if ( vr_14 [ vr_18 ] )
fn_5 ( vr_15 [ vr_18 ] [ vr_16 [ vr_18 ] [ 1 ] ] , vr_14 [ vr_18 ] , vr_18 + 1 ) ;
else if ( vr_15 [ vr_18 ] [ vr_16 [ vr_18 ] [ 2 ] ] -> vr_5 )
fn_5 ( vr_15 [ vr_18 ] [ vr_16 [ vr_18 ] [ 2 ] ] ,
vr_15 [ vr_18 ] [ vr_16 [ vr_18 ] [ 1 ] ] , vr_18 + 1 ) ;
if ( ferror ( vr_17 [ vr_18 ] ) )
error ( vl_14 , vl_16 , lr_12 , vr_12 [ vr_18 ] ) ;
vr_20 [ vr_18 ] = false ;
}
}
for ( vr_18 = 0 ; vr_18 < 2 ; vr_18 ++ )
if ( fclose ( vr_17 [ vr_18 ] ) != 0 )
error ( vl_14 , vl_16 , lr_12 , vr_12 [ vr_18 ] ) ;
}
int
main ( int vr_22 , char * * vr_23 )
{
int vr_24 ;
fn_14 ( & vr_22 , & vr_23 ) ;
fn_15 ( vr_23 [ 0 ] ) ;
setlocale ( vl_18 , lr_13 ) ;
fn_16 ( vl_19 , vl_20 ) ;
fn_17 ( vl_19 ) ;
vl_13 = fn_18 ( vl_21 ) ;
atexit ( vl_22 ) ;
vl_5 = true ;
vl_6 = true ;
vl_8 = true ;
vl_12 = false ;
vr_10 [ 0 ] = vr_10 [ 1 ] = false ;
vl_9 = vl_23 ;
while ( ( vr_24 = fn_19 ( vr_22 , vr_23 , lr_14 , vl_24 , NULL ) ) != - 1 )
switch ( vr_24 )
{
case '1' :
vl_5 = false ;
break;
case '2' :
vl_6 = false ;
break;
case '3' :
vl_8 = false ;
break;
case vl_25 :
vl_9 = vl_10 ;
break;
case vl_26 :
vl_9 = vl_11 ;
break;
case vl_27 :
if ( vl_7 && ! fn_10 ( vl_7 , vl_28 ) )
error ( vl_14 , 0 , _ ( lr_15 ) ) ;
vl_7 = vl_28 ;
if ( ! * vl_7 )
{
error ( vl_14 , 0 , _ ( lr_16 ) ,
fn_20 ( lr_17 ) ) ;
}
break;
vl_29 ;
fn_21 ( vl_30 , vl_31 ) ;
default:
fn_1 ( vl_14 ) ;
}
if ( vr_22 - vl_32 < 2 )
{
if ( vr_22 <= vl_32 )
error ( 0 , 0 , _ ( lr_18 ) ) ;
else
error ( 0 , 0 , _ ( lr_19 ) , fn_20 ( vr_23 [ vr_22 - 1 ] ) ) ;
fn_1 ( vl_14 ) ;
}
if ( 2 < vr_22 - vl_32 )
{
error ( 0 , 0 , _ ( lr_20 ) , fn_20 ( vr_23 [ vl_32 + 2 ] ) ) ;
fn_1 ( vl_14 ) ;
}
if ( ! vl_7 )
vl_7 = lr_21 ;
fn_8 ( vr_23 + vl_32 ) ;
if ( vr_10 [ 0 ] || vr_10 [ 1 ] )
exit ( vl_14 ) ;
else
exit ( vl_1 ) ;
}
