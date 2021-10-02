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
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_4 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
tp_1 vr_4 ;
char const * vr_5 = NULL ;
int vr_6 = vl_1 ;
int vr_7 ;
tp_2 vr_8 = NULL ;
bool vr_9 = false ;
fn_5 ( & vr_2 , & vr_3 ) ;
fn_6 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_5 ) ;
fn_7 ( vl_6 , vl_7 ) ;
fn_8 ( vl_6 ) ;
atexit ( vl_8 ) ;
while ( ( vr_7 = fn_9 ( vr_2 , vr_3 , lr_6 , vl_9 , NULL ) ) != - 1 )
{
switch ( vr_7 )
{
case 'm' :
vr_5 = vl_10 ;
break;
case 'Z' :
if ( fn_10 () )
{
vr_8 = vl_10 ;
}
else if ( fn_11 () > 0 )
{
if ( vl_10 )
vr_8 = vl_10 ;
else
vr_9 = true ;
}
else if ( vl_10 )
{
error ( 0 , 0 ,
_ ( lr_7
lr_8 ) ) ;
}
break;
vl_11 ;
fn_12 ( vl_12 , vl_13 ) ;
default:
fn_1 ( vl_14 ) ;
}
}
if ( vl_15 == vr_2 )
{
error ( 0 , 0 , _ ( lr_9 ) ) ;
fn_1 ( vl_14 ) ;
}
if ( vr_8 ) MST[@!ABS$@$]MSP[]
{
int vr_10 = 0 ;
if ( fn_10 () )
vr_10 = fn_13 ( vr_8 ) ;
else
vr_10 = fn_14 ( vr_8 ) ;
if ( vr_10 < 0 )
error ( vl_14 , vl_16 ,
_ ( lr_10 ) ,
fn_15 ( vr_8 ) ) ;
}
vr_4 = vl_17 ;
if ( vr_5 )
{
tp_1 vr_11 ;
struct vr_12 * vr_13 = fn_16 ( vr_5 ) ;
if ( ! vr_13 )
error ( vl_14 , 0 , _ ( lr_11 ) ) ;
vr_11 = fn_17 ( 0 ) ;
fn_17 ( vr_11 ) ;
vr_4 = fn_18 ( vr_4 , false , vr_11 , vr_13 , NULL ) ;
free ( vr_13 ) ;
if ( vr_4 & ~ vl_18 )
error ( vl_14 , 0 ,
_ ( lr_12 ) ) ;
}
for (; vl_15 < vr_2 ; ++ vl_15 )
{
if ( vr_9 )
fn_19 ( vr_3 [ vl_15 ] , vl_19 ) ;
if ( fn_20 ( vr_3 [ vl_15 ] , vr_4 ) != 0 )
{
error ( 0 , vl_16 , _ ( lr_13 ) , fn_15 ( vr_3 [ vl_15 ] ) ) ;
vr_6 = vl_14 ;
}
else if ( vr_5 && fn_21 ( vr_3 [ vl_15 ] , vr_4 ) != 0 )
{
error ( 0 , vl_16 , _ ( lr_14 ) ,
fn_15 ( vr_3 [ vl_15 ] ) ) ;
vr_6 = vl_14 ;
}
}
exit ( vr_6 ) ;
}
