void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
bool vr_4 ;
int vr_5 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_4 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
atexit ( vl_8 ) ;
vl_9 = false ;
vl_10 = false ;
while ( ( vr_5 = fn_8 ( vr_2 , vr_3 , lr_5 , vl_11 , NULL ) ) != - 1 )
{
switch ( vr_5 )
{
case 'a' :
vl_9 = true ;
break;
case 'i' :
vl_10 = true ;
break;
vl_12 ;
fn_9 ( vl_13 , vl_14 ) ;
default:
fn_1 ( vl_15 ) ;
}
}
if ( vl_10 )
signal ( vl_16 , vl_17 ) ;
vr_4 = fn_10 ( vr_2 - vl_18 , ( const char * * ) & vr_3 [ vl_18 ] ) ;
if ( fn_11 ( vl_19 ) != 0 )
error ( vl_15 , vl_20 , _ ( lr_6 ) ) ;
exit ( vr_4 ? vl_1 : vl_15 ) ;
}
static bool
fn_10 ( int vr_6 , const char * * vr_7 )
{
tp_1 * * vr_8 ;
char vr_9 [ vl_21 ] ;
tp_2 vr_10 ;
int vr_11 ;
bool vr_4 = true ;
char const * vr_12 =
( vl_22
? ( vl_9 ? lr_7 : lr_8 )
: ( vl_9 ? lr_9 : lr_10 ) ) ;
vr_8 = fn_12 ( vr_6 + 1 , sizeof *vr_8 ) ;
for ( vr_11 = vr_6 ; vr_11 >= 1 ; vr_11 -- )
vr_7 [ vr_11 ] = vr_7 [ vr_11 - 1 ] ;
if ( vl_22 && ! fn_13 ( vl_19 ) )
fn_14 ( NULL , lr_11 , vl_23 ) ;
if ( vl_22 && ! fn_13 ( vl_24 ) )
fn_14 ( NULL , lr_8 , stdout ) ;
fn_15 ( vl_23 , vl_25 ) ;
vr_8 [ 0 ] = stdout ;
vr_7 [ 0 ] = _ ( lr_12 ) ;
setvbuf ( stdout , NULL , vl_26 , 0 ) ;
for ( vr_11 = 1 ; vr_11 <= vr_6 ; vr_11 ++ )
{
vr_8 [ vr_11 ] = ( fn_16 ( vr_7 [ vr_11 ] , lr_13 )
? stdout
: fopen ( vr_7 [ vr_11 ] , vr_12 ) ) ;
if ( vr_8 [ vr_11 ] == NULL )
{
error ( 0 , vl_20 , lr_14 , vr_7 [ vr_11 ] ) ;
vr_4 = false ;
}
else
setvbuf ( vr_8 [ vr_11 ] , NULL , vl_26 , 0 ) ;
}
while ( 1 )
{
vr_10 = fn_17 ( 0 , vr_9 , sizeof vr_9 ) ;
if ( vr_10 < 0 && vl_20 == vl_27 )
continue;
if ( vr_10 <= 0 )
break;
for ( vr_11 = 0 ; vr_11 <= vr_6 ; vr_11 ++ )
if ( vr_8 [ vr_11 ]
&& fwrite ( vr_9 , vr_10 , 1 , vr_8 [ vr_11 ] ) != 1 )
{
error ( 0 , vl_20 , lr_14 , vr_7 [ vr_11 ] ) ;
vr_8 [ vr_11 ] = NULL ;
vr_4 = false ;
}
}
if ( vr_10 == - 1 )
{
error ( 0 , vl_20 , _ ( lr_15 ) ) ;
vr_4 = false ;
}
for ( vr_11 = 1 ; vr_11 <= vr_6 ; vr_11 ++ )
if ( ! fn_16 ( vr_7 [ vr_11 ] , lr_13 )
&& vr_8 [ vr_11 ] && fclose ( vr_8 [ vr_11 ] ) != 0 )
{
error ( 0 , vl_20 , lr_14 , vr_7 [ vr_11 ] ) ; MST[P!PLEFTDEC$P$]MSP[]
vr_4 = false ;
}
free ( vr_8 ) ;
return vr_4 ;
}
