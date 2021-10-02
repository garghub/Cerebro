static int
fn_1 ( tp_1 tp_2 vr_1 , tp_3 const * tp_4 vr_1 )
{
return 0 ;
}
static int
fn_2 ( char const * vr_2 )
{
tp_5 * vr_3 = NULL ;
tp_1 vr_4 = 0 ;
tp_1 vr_5 = 0 ;
char * vr_6 = fn_3 ( vr_2 ) ;
char const * vr_7 ;
int vr_8 = 0 ;
for ( vr_7 = strtok ( vr_6 , lr_1 ) ; vr_7 ; vr_7 = strtok ( NULL , lr_1 ) )
{
struct vr_9 * vr_10 ;
unsigned long int vr_11 ;
if ( fn_4 ( vr_7 , NULL , 10 , & vr_11 , lr_2 ) == vl_1 && vr_11 <= vl_2 )
vr_10 = fn_5 ( vr_11 ) ;
else
{
vr_10 = fn_6 ( vr_7 ) ;
if ( vr_10 != NULL )
vr_11 = vr_10 -> vr_12 ;
}
if ( vr_10 == NULL )
{
error ( 0 , vl_3 , _ ( lr_3 ) , fn_7 ( vr_7 ) ) ;
vr_8 = - 1 ;
continue;
}
if ( vr_5 == vr_4 )
vr_3 = fn_8 ( vr_3 , & vr_4 ) ;
vr_3 [ vr_5 ++ ] = vr_11 ;
}
if ( vr_8 == 0 && vr_5 == 0 )
{
error ( 0 , 0 , _ ( lr_4 ) , fn_7 ( vr_2 ) ) ;
vr_8 = - 1 ;
}
if ( vr_8 == 0 )
{
vr_8 = fn_1 ( vr_5 , vr_3 ) ;
if ( vr_8 )
error ( 0 , vl_3 , _ ( lr_5 ) ) ;
}
free ( vr_6 ) ;
free ( vr_3 ) ;
return vr_8 ;
}
void
fn_9 ( int vr_13 )
{
if ( vr_13 != vl_4 )
fn_10 () ;
else
{
printf ( _ ( lr_6 ) , vl_5 , vl_5 ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( vl_6 , stdout ) ;
fputs ( vl_7 , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fn_11 () ;
}
exit ( vr_13 ) ;
}
int
main ( int vr_14 , char * * vr_15 )
{
int vr_16 ;
char const * vr_17 = NULL ;
char const * vr_2 = NULL ;
fn_12 ( & vr_14 , & vr_15 ) ;
fn_13 ( vr_15 [ 0 ] ) ;
setlocale ( vl_8 , lr_2 ) ;
fn_14 ( vl_9 , vl_10 ) ;
fn_15 ( vl_9 ) ;
fn_16 ( vl_11 ) ;
atexit ( vl_12 ) ;
while ( ( vr_16 = fn_17 ( vr_14 , vr_15 , lr_10 , vl_13 , NULL ) ) != - 1 )
{
switch ( vr_16 )
{
case vl_14 :
vr_17 = vl_15 ;
break;
case vl_16 :
vr_2 = vl_15 ;
break;
vl_17 ;
fn_18 ( vl_18 , vl_19 ) ;
default:
fn_9 ( vl_11 ) ;
}
}
if ( vr_14 <= vl_20 )
{
error ( 0 , 0 , _ ( lr_11 ) ) ;
fn_9 ( vl_11 ) ;
}
if ( fn_19 ( vr_15 [ vl_20 ] ) != 0 )
error ( vl_11 , vl_3 , _ ( lr_12 ) ,
vr_15 [ vl_20 ] ) ;
if ( fn_20 ( lr_13 ) )
error ( vl_11 , vl_3 , _ ( lr_14 ) ) ;
if ( vr_14 == vl_20 + 1 )
{
char * vr_18 = getenv ( lr_15 ) ;
if ( vr_18 == NULL )
vr_18 = fn_21 ( lr_16 ) ;
vr_15 [ 0 ] = vr_18 ;
vr_15 [ 1 ] = fn_21 ( lr_17 ) ;
vr_15 [ 2 ] = NULL ;
}
else
{
vr_15 += vl_20 + 1 ;
}
bool vr_19 = false ;
if ( vr_17 )
{
tp_6 vr_20 = - 1 ;
tp_3 vr_21 = - 1 ;
char const * vr_22 = fn_22 ( vr_17 , & vr_20 , & vr_21 , NULL , NULL ) ;
if ( vr_22 )
error ( vl_11 , vl_3 , lr_18 , vr_22 ) ;
if ( vr_2 && fn_2 ( vr_2 ) )
vr_19 = true ;
if ( vr_21 != ( tp_3 ) - 1 && fn_23 ( vr_21 ) )
{
error ( 0 , vl_3 , _ ( lr_19 ) ) ;
vr_19 = true ;
}
if ( vr_20 != ( tp_6 ) - 1 && fn_24 ( vr_20 ) )
{
error ( 0 , vl_3 , _ ( lr_20 ) ) ;
vr_19 = true ;
}
}
else
{
if ( vr_2 && fn_2 ( vr_2 ) )
vr_19 = true ;
}
if ( vr_19 )
exit ( vl_11 ) ;
fn_25 ( vr_15 [ 0 ] , vr_15 ) ;
{
int vr_23 = ( vl_3 == vl_21 ? vl_22 : vl_23 ) ; MST[EQ$@1$@2$!SUB$@1$@2$]MSP[]
error ( 0 , vl_3 , _ ( lr_21 ) , fn_7 ( vr_15 [ 0 ] ) ) ;
exit ( vr_23 ) ;
}
}
