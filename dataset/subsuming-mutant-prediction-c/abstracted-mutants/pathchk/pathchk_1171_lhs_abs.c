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
fn_3 () ;
}
exit ( vr_1 ) ;
}
int
main ( int vr_2 , char * * vr_3 )
{
bool vr_4 = true ;
bool vr_5 = false ;
bool vr_6 = false ;
int vr_7 ;
fn_4 ( & vr_2 , & vr_3 ) ;
fn_5 ( vr_3 [ 0 ] ) ;
setlocale ( vl_5 , lr_3 ) ;
fn_6 ( vl_6 , vl_7 ) ;
fn_7 ( vl_6 ) ;
atexit ( vl_8 ) ;
while ( ( vr_7 = fn_8 ( vr_2 , vr_3 , lr_4 , vl_9 , NULL ) ) != - 1 )
{
switch ( vr_7 )
{
case vl_10 :
vr_5 = true ;
vr_6 = true ;
break;
case 'p' :
vr_5 = true ;
break;
case 'P' :
vr_6 = true ;
break;
vl_11 ;
fn_9 ( vl_12 , vl_13 ) ;
default:
fn_1 ( vl_14 ) ;
}
}
if ( vl_15 == vr_2 )
{
error ( 0 , 0 , _ ( lr_5 ) ) ;
fn_1 ( vl_14 ) ;
}
for (; vl_15 < vr_2 ; ++ vl_15 )
vr_4 &= fn_10 ( vr_3 [ vl_15 ] ,
vr_5 , vr_6 ) ;
exit ( vr_4 ? vl_1 : vl_14 ) ;
}
static bool
fn_11 ( char const * vr_8 )
{
char const * vr_9 ;
for ( vr_9 = vr_8 ; ( vr_9 = strchr ( vr_9 , '-' ) ) ; vr_9 ++ )
if ( vr_9 == vr_8 || vr_9 [ - 1 ] == '/' )
{
error ( 0 , 0 , _ ( lr_6 ) ,
fn_12 ( vr_8 ) ) ;
return false ;
}
return true ;
}
static bool
fn_13 ( char const * vr_8 , tp_1 vr_10 )
{
tp_1 vr_11 = strspn ( vr_8 ,
( lr_7
lr_8
lr_9
lr_10 ) ) ;
char const * vr_12 = vr_8 + vr_11 ;
if ( * vr_12 )
{
tp_2 vr_13 = { 0 , } ;
tp_1 vr_14 = mbrlen ( vr_12 , vr_10 - vr_11 , & vr_13 ) ;
error ( 0 , 0 ,
_ ( lr_11 ) ,
fn_14 ( 1 , vl_16 , vr_12 ,
( vr_14 <= vl_17 ? vr_14 : 1 ) ) ,
fn_15 ( 0 , vr_8 ) ) ;
return false ;
}
return true ;
}
static char * tp_3
fn_16 ( char * vr_15 )
{
while ( * vr_15 == '/' )
vr_15 ++ ;
return vr_15 ;
}
static tp_1 tp_3
fn_17 ( char const * vr_15 )
{
tp_1 vr_16 ;
for ( vr_16 = 1 ; vr_15 [ vr_16 ] != '/' && vr_15 [ vr_16 ] ; vr_16 ++ )
continue;
return vr_16 ;
}
static bool
fn_10 ( char * vr_8 , bool vr_5 ,
bool vr_6 )
{
tp_1 vr_10 = strlen ( vr_8 ) ;
char * vr_17 ;
bool vr_18 ;
bool vr_19 = false ;
if ( vr_6 && ! fn_11 ( vr_8 ) )
return false ;
if ( ( vr_5 || vr_6 )
&& vr_10 == 0 )
{
error ( 0 , 0 , _ ( lr_12 ) ) ;
return false ;
}
if ( vr_5 )
{
if ( ! fn_13 ( vr_8 , vr_10 ) )
return false ;
}
else
{
struct vr_20 vr_21 ;
if ( fn_18 ( vr_8 , & vr_21 ) == 0 )
vr_19 = true ;
else if ( vl_18 != vl_19 || vr_10 == 0 )
{
error ( 0 , vl_18 , lr_13 , vr_8 ) ;
return false ;
}
}
if ( vr_5
|| ( ! vr_19 && vl_20 <= vr_10 ) )
{
tp_1 vr_22 ;
if ( vr_5 )
vr_22 = vl_21 ;
else
{
long int vr_23 ;
char const * vr_24 = ( * vr_8 == '/' ? lr_7 : lr_14 ) ;
vl_18 = 0 ;
vr_23 = fn_19 ( vr_24 , vl_22 ) ;
if ( vr_23 < 0 && vl_18 != 0 ) MST[LT$@1$@2$!DIV$@1$@2$]MSP[]
{
error ( 0 , vl_18 ,
_ ( lr_15 ) ,
vr_24 ) ;
return false ;
}
vr_22 = fn_20 ( vr_23 , vl_23 ) ;
}
if ( vr_22 <= vr_10 )
{
unsigned long int vr_16 = vr_10 ;
unsigned long int vr_25 = vr_22 - 1 ;
error ( 0 , 0 , _ ( lr_16 ) ,
vr_25 , vr_16 , fn_12 ( vr_8 ) ) ;
return false ;
}
}
vr_18 = vr_5 ;
if ( ! vr_18 && ! vr_19 )
{
for ( vr_17 = vr_8 ; * ( vr_17 = fn_16 ( vr_17 ) ) ; )
{
tp_1 vr_26 = fn_17 ( vr_17 ) ;
if ( vl_24 < vr_26 )
{
vr_18 = true ;
break;
}
vr_17 += vr_26 ;
}
}
if ( vr_18 )
{
tp_1 vr_27 = vl_24 ;
tp_1 vr_28 = ( vr_5 ? vl_25 : 0 ) ;
for ( vr_17 = vr_8 ; * ( vr_17 = fn_16 ( vr_17 ) ) ; )
{
tp_1 vr_26 ;
if ( vr_28 )
vr_27 = vr_28 ;
else
{
long int vr_16 ;
char const * vr_24 = ( vr_17 == vr_8 ? lr_14 : vr_8 ) ;
char vr_29 = * vr_17 ;
vl_18 = 0 ;
* vr_17 = '\0' ;
vr_16 = fn_19 ( vr_24 , vl_26 ) ;
* vr_17 = vr_29 ;
if ( 0 <= vr_16 )
vr_27 = fn_20 ( vr_16 , vl_23 ) ;
else
switch ( vl_18 )
{
case 0 :
vr_27 = vl_27 ;
break;
case vl_19 :
vr_28 = vr_27 ;
break;
default:
* vr_17 = '\0' ;
error ( 0 , vl_18 , lr_13 , vr_24 ) ;
* vr_17 = vr_29 ;
return false ;
}
}
vr_26 = fn_17 ( vr_17 ) ;
if ( vr_27 < vr_26 )
{
unsigned long int vr_16 = vr_26 ;
unsigned long int vr_25 = vr_27 ;
char vr_29 = vr_17 [ vr_16 ] ;
vr_17 [ vr_16 ] = '\0' ;
error ( 0 , 0 ,
_ ( lr_17
lr_18 ) ,
vr_25 , vr_16 , fn_12 ( vr_17 ) ) ;
vr_17 [ vr_16 ] = vr_29 ;
return false ;
}
vr_17 += vr_26 ;
}
}
return true ;
}
