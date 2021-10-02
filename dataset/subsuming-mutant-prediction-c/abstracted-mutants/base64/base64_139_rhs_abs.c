void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
fn_3 () ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) ,
stdout ) ;
fn_4 () ;
}
exit ( vr_1 ) ;
}
static void
fn_5 ( const char * vr_2 , tp_1 vr_3 ,
tp_2 vr_4 , tp_1 * vr_5 , tp_3 * vr_6 )
{
tp_1 vr_7 ;
if ( vr_4 == 0 )
{
if ( fwrite ( vr_2 , 1 , vr_3 , stdout ) < vr_3 )
error ( vl_5 , vl_6 , _ ( lr_5 ) ) ;
}
else
for ( vr_7 = 0 ; vr_7 < vr_3 ; )
{
tp_2 vr_8 = vr_4 - * vr_5 ;
tp_1 vr_9 = fn_6 ( vr_8 , vl_7 ) ;
vr_9 = fn_6 ( vr_9 , vr_3 - vr_7 ) ;
if ( vr_9 == 0 )
{
if ( fputc ( '\n' , vr_6 ) == vl_8 )
error ( vl_5 , vl_6 , _ ( lr_5 ) ) ;
* vr_5 = 0 ;
}
else
{
if ( fwrite ( vr_2 + vr_7 , 1 , vr_9 , stdout ) < vr_9 )
error ( vl_5 , vl_6 , _ ( lr_5 ) ) ;
* vr_5 += vr_9 ;
vr_7 += vr_9 ;
}
}
}
static void
fn_7 ( tp_3 * vr_10 , tp_3 * vr_6 , tp_2 vr_4 )
{
tp_1 vr_5 = 0 ;
char vr_11 [ vl_9 ] ;
char vr_12 [ vl_10 ] ;
tp_1 vr_13 ;
do
{
tp_1 vr_14 ;
vr_13 = 0 ;
do
{
vr_14 = fread ( vr_11 + vr_13 , 1 , vl_9 - vr_13 , vr_10 ) ;
vr_13 += vr_14 ;
}
while ( ! feof ( vr_10 ) && ! ferror ( vr_10 ) && vr_13 < vl_9 );
if ( vr_13 > 0 )
{
fn_8 ( vr_11 , vr_13 , vr_12 , fn_9 ( vr_13 ) ) ;
fn_5 ( vr_12 , fn_9 ( vr_13 ) , vr_4 ,
& vr_5 , vr_6 ) ;
}
}
while ( ! feof ( vr_10 ) && ! ferror ( vr_10 ) && vr_13 == vl_9 );
if ( vr_4 && vr_5 > 0 && fputc ( '\n' , vr_6 ) == vl_8 )
error ( vl_5 , vl_6 , _ ( lr_5 ) ) ;
if ( ferror ( vr_10 ) )
error ( vl_5 , vl_6 , _ ( lr_6 ) ) ;
}
static void
fn_10 ( tp_3 * vr_10 , tp_3 * vr_6 , bool vr_15 )
{
char vr_11 [ vl_11 ] ;
char vr_12 [ vl_12 ] ;
tp_1 vr_13 ;
struct vr_16 vr_17 ;
fn_11 ( & vr_17 ) ;
do
{
bool vr_18 ;
tp_1 vr_14 ;
unsigned int vr_19 ;
vr_13 = 0 ;
do
{
vr_14 = fread ( vr_11 + vr_13 , 1 , vl_11 - vr_13 , vr_10 ) ;
if ( vr_15 )
{
tp_1 vr_20 ;
for ( vr_20 = 0 ; vr_14 > 0 && vr_20 < vr_14 ; )
if ( fn_12 ( vr_11 [ vr_13 + vr_20 ] ) || vr_11 [ vr_13 + vr_20 ] == '=' )
vr_20 ++ ;
else
memmove ( vr_11 + vr_13 + vr_20 , vr_11 + vr_13 + vr_20 + 1 , -- vr_14 - vr_20 ) ;
}
vr_13 += vr_14 ;
if ( ferror ( vr_10 ) )
error ( vl_5 , vl_6 , _ ( lr_6 ) ) ;
}
while ( vr_13 < vl_11 && ! feof ( vr_10 ) );
for ( vr_19 = 0 ; vr_19 < 1 + ! ! feof ( vr_10 ) ; vr_19 ++ )
{
if ( vr_19 == 1 && vr_17 . vr_20 == 0 )
break;
vr_14 = vl_12 ;
vr_18 = fn_13 ( & vr_17 , vr_11 , ( vr_19 == 0 ? vr_13 : 0 ) , vr_12 , & vr_14 ) ;
if ( fwrite ( vr_12 , 1 , vr_14 , vr_6 ) < vr_14 )
error ( vl_5 , vl_6 , _ ( lr_5 ) ) ;
if ( ! vr_18 )
error ( vl_5 , 0 , _ ( lr_7 ) ) ;
}
}
while ( ! feof ( vr_10 ) );
}
int
main ( int vr_21 , char * * vr_22 )
{
int vr_23 ;
tp_3 * vr_24 ;
const char * vr_25 ;
bool vr_26 = false ;
bool vr_15 = false ;
tp_2 vr_4 = 76 ;
fn_14 ( & vr_21 , & vr_22 ) ;
fn_15 ( vr_22 [ 0 ] ) ;
setlocale ( vl_13 , lr_8 ) ;
fn_16 ( vl_14 , vl_15 ) ;
fn_17 ( vl_14 ) ;
atexit ( vl_16 ) ;
while ( ( vr_23 = fn_18 ( vr_21 , vr_22 , lr_9 , vl_17 , NULL ) ) != - 1 ) MST[NEQ$@1$@2$!SUB$@2$@1$]MSP[N]
switch ( vr_23 )
{
case 'd' :
vr_26 = true ;
break;
case 'w' :
if ( fn_19 ( vl_18 , NULL , 0 , & vr_4 , NULL ) != vl_19 )
error ( vl_5 , 0 , _ ( lr_10 ) ,
fn_20 ( vl_18 ) ) ;
break;
case 'i' :
vr_15 = true ;
break;
vl_20 ;
fn_21 ( vl_21 , vl_22 ) ;
default:
fn_1 ( vl_5 ) ;
break;
}
if ( vr_21 - vl_23 > 1 )
{
error ( 0 , 0 , _ ( lr_11 ) , fn_22 ( vr_22 [ vl_23 ] ) ) ;
fn_1 ( vl_5 ) ;
}
if ( vl_23 < vr_21 )
vr_25 = vr_22 [ vl_23 ] ;
else
vr_25 = lr_12 ;
if ( fn_23 ( vr_25 , lr_12 ) )
{
if ( vl_24 )
fn_24 ( NULL , lr_13 , vl_25 ) ;
vr_24 = vl_25 ;
}
else
{
vr_24 = fopen ( vr_25 , lr_13 ) ;
if ( vr_24 == NULL )
error ( vl_5 , vl_6 , lr_14 , vr_25 ) ;
}
fn_25 ( vr_24 , vl_26 ) ;
if ( vr_26 )
fn_10 ( vr_24 , stdout , vr_15 ) ;
else
fn_7 ( vr_24 , stdout , vr_4 ) ;
if ( fclose ( vr_24 ) == vl_8 )
{
if ( fn_23 ( vr_25 , lr_12 ) )
error ( vl_5 , vl_6 , _ ( lr_15 ) ) ;
else
error ( vl_5 , vl_6 , lr_14 , vr_25 ) ;
}
exit ( vl_1 ) ;
}
