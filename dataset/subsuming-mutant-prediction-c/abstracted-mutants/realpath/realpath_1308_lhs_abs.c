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
fn_3 () ;
}
exit ( vr_1 ) ;
}
static char *
fn_4 ( const char * vr_2 , int vr_3 )
{
char * vr_4 = fn_5 ( vr_2 , vr_3 ) ;
if ( vl_5 && vr_4 )
{
vr_3 &= ~ vl_6 ;
char * vr_5 = fn_5 ( vr_4 , vr_3 ) ;
free ( vr_4 ) ;
return vr_5 ;
}
return vr_4 ;
}
static bool tp_1
fn_6 ( const char * vr_6 , const char * vr_7 )
{
vr_6 ++ ;
vr_7 ++ ;
if ( ! * vr_6 )
return * vr_7 != '/' ;
if ( * vr_6 == '/' && ! vr_6 [ 1 ] )
return * vr_7 == '/' ;
while ( * vr_6 && * vr_7 )
{
if ( * vr_6 != * vr_7 )
break;
vr_6 ++ ;
vr_7 ++ ;
}
return ( ! * vr_6 && ( * vr_7 == '/' || ! * vr_7 ) ) ;
}
static bool
fn_7 ( const char * vr_7 )
{
struct vr_8 vr_9 ;
if ( vr_8 ( vr_7 , & vr_9 ) != 0 )
error ( vl_7 , vl_8 , _ ( lr_4 ) , fn_8 ( vr_7 ) ) ;
return fn_9 ( vr_9 . vr_10 ) ;
}
static bool
fn_10 ( const char * vr_2 , int vr_3 )
{
char * vr_4 = fn_4 ( vr_2 , vr_3 ) ;
if ( ! vr_4 )
{
if ( vl_9 )
error ( 0 , vl_8 , lr_5 , fn_8 ( vr_2 ) ) ;
return false ;
}
if ( ! vl_10
|| ( vl_11 && ! fn_6 ( vl_11 , vr_4 ) )
|| ( vl_10 && ! fn_11 ( vr_4 , vl_10 , NULL , 0 ) ) )
fputs ( vr_4 , stdout ) ;
putchar ( vl_12 ? '\0' : '\n' ) ;
free ( vr_4 ) ;
return true ;
}
int
main ( int vr_11 , char * * vr_12 )
{
bool vr_13 = true ;
int vr_3 = vl_13 ;
const char * vr_14 = NULL ;
const char * vr_15 = NULL ;
fn_12 ( & vr_11 , & vr_12 ) ;
fn_13 ( vr_12 [ 0 ] ) ;
setlocale ( vl_14 , lr_6 ) ;
fn_14 ( vl_15 , vl_16 ) ;
fn_15 ( vl_15 ) ;
atexit ( vl_17 ) ;
while ( 1 )
{
int vr_16 = fn_16 ( vr_11 , vr_12 , lr_7 , vl_18 , NULL ) ;
if ( vr_16 == - 1 )
break;
switch ( vr_16 )
{
case 'e' :
vr_3 &= ~ vl_19 ;
vr_3 |= vl_20 ;
break;
case 'm' :
vr_3 &= ~ vl_19 ;
vr_3 |= vl_21 ;
break;
case 'L' :
vr_3 |= vl_6 ;
vl_5 = true ;
break;
case 's' :
vr_3 |= vl_6 ;
vl_5 = false ;
break;
case 'P' :
vr_3 &= ~ vl_6 ;
vl_5 = false ;
break;
case 'q' :
vl_9 = false ;
break;
case 'z' :
vl_12 = true ;
break;
case vl_22 :
vr_14 = vl_23 ;
break;
case vl_24 :
vr_15 = vl_23 ;
break;
vl_25 ;
fn_17 ( vl_26 , vl_27 ) ;
default:
fn_1 ( vl_7 ) ;
}
}
if ( vl_28 >= vr_11 )
{
error ( 0 , 0 , _ ( lr_8 ) ) ;
fn_1 ( vl_7 ) ;
}
if ( vr_15 && ! vr_14 )
vr_14 = vr_15 ;
bool vr_17 = ( vr_3 & vl_19 ) == vl_20 ;
if ( vr_14 )
{
vl_10 = fn_4 ( vr_14 , vr_3 ) ;
if ( ! vl_10 )
error ( vl_7 , vl_8 , lr_5 , fn_8 ( vr_14 ) ) ;
if ( vr_17 && ! fn_7 ( vl_10 ) )
error ( vl_7 , vl_29 , lr_5 , fn_8 ( vr_14 ) ) ;
}
if ( vr_15 == vr_14 )
vl_11 = vl_10 ;
else if ( vr_15 )
{
char * vr_18 = fn_4 ( vr_15 , vr_3 ) ;
if ( ! vr_18 )
error ( vl_7 , vl_8 , lr_5 , fn_8 ( vr_15 ) ) ;
if ( vr_17 && ! fn_7 ( vr_18 ) )
error ( vl_7 , vl_29 , lr_5 , fn_8 ( vr_15 ) ) ;
if ( fn_6 ( vr_18 , vl_10 ) )
vl_11 = vr_18 ;
else
{
free ( vr_18 ) ;
vl_11 = vl_10 ;
vl_10 = NULL ;
}
}
for (; vl_28 < vr_11 ; ++ vl_28 )
vr_13 &= fn_10 ( vr_12 [ vl_28 ] , vr_3 ) ;
exit ( vr_13 ? vl_1 : vl_7 ) ; MST[C!ADD$C$1$]MSP[]
}
