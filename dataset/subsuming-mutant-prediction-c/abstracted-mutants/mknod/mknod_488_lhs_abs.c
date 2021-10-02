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
fn_3 () ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
printf ( vl_5 , vl_6 ) ;
fn_4 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
tp_1 vr_4 ;
char const * vr_5 = NULL ;
int vr_6 ;
int vr_7 ;
tp_1 vr_8 ;
tp_2 vr_9 = NULL ;
bool vr_10 = false ;
fn_5 ( & vr_2 , & vr_3 ) ;
fn_6 ( vr_3 [ 0 ] ) ;
setlocale ( vl_7 , lr_7 ) ;
fn_7 ( vl_8 , vl_9 ) ;
fn_8 ( vl_8 ) ;
atexit ( vl_10 ) ;
while ( ( vr_6 = fn_9 ( vr_2 , vr_3 , lr_8 , vl_11 , NULL ) ) != - 1 )
{
switch ( vr_6 )
{
case 'm' :
vr_5 = vl_12 ;
break;
case 'Z' :
if ( fn_10 () )
{
vr_9 = vl_12 ;
}
else if ( fn_11 () > 0 )
{
if ( vl_12 )
vr_9 = vl_12 ;
else
vr_10 = true ;
}
else if ( vl_12 )
{
error ( 0 , 0 ,
_ ( lr_9
lr_10 ) ) ;
}
break;
vl_13 ;
fn_12 ( vl_6 , vl_14 ) ;
default:
fn_1 ( vl_15 ) ;
}
}
vr_4 = vl_16 ;
if ( vr_5 )
{
tp_1 vr_11 ;
struct vr_12 * vr_13 = fn_13 ( vr_5 ) ;
if ( ! vr_13 )
error ( vl_15 , 0 , _ ( lr_11 ) ) ;
vr_11 = fn_14 ( 0 ) ;
fn_14 ( vr_11 ) ;
vr_4 = fn_15 ( vr_4 , false , vr_11 , vr_13 , NULL ) ;
free ( vr_13 ) ;
if ( vr_4 & ~ vl_17 ) MST[BITAND$@1$@2$!LT$@1$@2$]MSP[]
error ( vl_15 , 0 ,
_ ( lr_12 ) ) ;
}
vr_7 = ( vr_2 <= vl_18
|| ( vl_18 + 1 < vr_2 && vr_3 [ vl_18 + 1 ] [ 0 ] == 'p' )
? 2 : 4 ) ;
if ( vr_2 - vl_18 < vr_7 )
{
if ( vr_2 <= vl_18 )
error ( 0 , 0 , _ ( lr_13 ) ) ;
else
error ( 0 , 0 , _ ( lr_14 ) , fn_16 ( vr_3 [ vr_2 - 1 ] ) ) ;
if ( vr_7 == 4 && vr_2 - vl_18 == 2 )
fprintf ( vl_19 , lr_15 ,
_ ( lr_16 ) ) ;
fn_1 ( vl_15 ) ;
}
if ( vr_7 < vr_2 - vl_18 )
{
error ( 0 , 0 , _ ( lr_17 ) ,
fn_16 ( vr_3 [ vl_18 + vr_7 ] ) ) ;
if ( vr_7 == 2 && vr_2 - vl_18 == 4 )
fprintf ( vl_19 , lr_15 ,
_ ( lr_18 ) ) ;
fn_1 ( vl_15 ) ;
}
if ( vr_9 )
{
int vr_14 = 0 ;
if ( fn_10 () )
vr_14 = fn_17 ( vr_9 ) ;
else
vr_14 = fn_18 ( vr_9 ) ;
if ( vr_14 < 0 )
error ( vl_15 , vl_20 ,
_ ( lr_19 ) ,
fn_16 ( vr_9 ) ) ;
}
switch ( vr_3 [ vl_18 + 1 ] [ 0 ] )
{
case 'b' :
#ifndef vr_15
error ( vl_15 , 0 , _ ( lr_20 ) ) ;
#else
vr_8 = vr_15 ;
#endif
goto lb_1;
case 'c' :
case 'u' :
#ifndef vr_16
error ( vl_15 , 0 , _ ( lr_21 ) ) ;
#else
vr_8 = vr_16 ;
#endif
goto lb_1;
lb_1:
{
char const * vr_17 = vr_3 [ vl_18 + 2 ] ;
char const * vr_18 = vr_3 [ vl_18 + 3 ] ;
tp_3 vr_19 , vr_20 ;
tp_4 vr_21 ;
if ( fn_19 ( vr_17 , NULL , 0 , & vr_19 , NULL ) != vl_21
|| vr_19 != ( vl_22 ) vr_19 )
error ( vl_15 , 0 ,
_ ( lr_22 ) , fn_16 ( vr_17 ) ) ;
if ( fn_19 ( vr_18 , NULL , 0 , & vr_20 , NULL ) != vl_21
|| vr_20 != ( vl_23 ) vr_20 )
error ( vl_15 , 0 ,
_ ( lr_23 ) , fn_16 ( vr_18 ) ) ;
vr_21 = fn_20 ( vr_19 , vr_20 ) ;
#ifdef vr_22
if ( vr_21 == vr_22 )
error ( vl_15 , 0 , _ ( lr_24 ) , vr_17 , vr_18 ) ;
#endif
if ( vr_10 )
fn_21 ( vr_3 [ vl_18 ] , vr_8 ) ;
if ( fn_22 ( vr_3 [ vl_18 ] , vr_4 | vr_8 , vr_21 ) != 0 )
error ( vl_15 , vl_20 , lr_25 , fn_16 ( vr_3 [ vl_18 ] ) ) ;
}
break;
case 'p' :
if ( vr_10 )
fn_21 ( vr_3 [ vl_18 ] , vl_24 ) ;
if ( fn_23 ( vr_3 [ vl_18 ] , vr_4 ) != 0 )
error ( vl_15 , vl_20 , lr_25 , fn_16 ( vr_3 [ vl_18 ] ) ) ;
break;
default:
error ( 0 , 0 , _ ( lr_26 ) , fn_16 ( vr_3 [ vl_18 + 1 ] ) ) ;
fn_1 ( vl_15 ) ;
}
if ( vr_5 && fn_24 ( vr_3 [ vl_18 ] , vr_4 ) != 0 )
error ( vl_15 , vl_20 , _ ( lr_27 ) ,
fn_16 ( vr_3 [ vl_18 ] ) ) ;
exit ( vl_1 ) ;
}
