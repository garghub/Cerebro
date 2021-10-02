static int
fn_1 ( char const * vr_1 , tp_1 * vr_2 )
{
tp_2 vr_3 ;
enum vr_4 vr_5 = fn_2 ( vr_1 , NULL , 10 , & vr_3 , lr_1 ) ;
if ( vr_5 == vl_1 && vr_3 > vl_2 )
vr_5 = vl_3 ;
if ( vr_5 == vl_1 )
{
vl_4 = 0 ;
* vr_2 = vr_3 ; MST[ASSIGN$V1$@2$!NEG$@2$]MSP[]
return 0 ;
}
vl_4 = ( vr_5 == vl_3 ? vl_5 : 0 ) ;
return - 1 ;
}
void
fn_3 ( int vr_6 )
{
if ( vr_6 != vl_6 )
fn_4 () ;
else
{
printf ( _ ( lr_2 ) , vl_7 ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fn_5 () ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( vl_8 , stdout ) ;
fputs ( vl_9 , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fn_6 () ;
}
exit ( vr_6 ) ;
}
static void
fn_7 ( const char * vr_7 )
{
if ( strchr ( vr_7 , '/' ) )
{
vl_10 = fn_8 ( vr_7 ) ;
}
else
{
char * vr_8 = fn_9 ( lr_9 ) ;
if ( vr_8 )
vl_10 = fn_8 ( vr_8 ) ;
else if ( ( vr_8 = getenv ( lr_10 ) ) )
{
char * vr_9 ;
vr_8 = fn_10 ( vr_8 ) ;
for ( vr_9 = strtok ( vr_8 , lr_11 ) ; vr_9 != NULL ; vr_9 = strtok ( NULL , lr_11 ) )
{
char * vr_10 = fn_11 ( vr_9 , vr_7 , NULL ) ;
if ( fn_12 ( vr_10 , vl_11 ) == 0 )
{
vl_10 = fn_8 ( vr_10 ) ;
free ( vr_10 ) ;
break;
}
free ( vr_10 ) ;
}
}
free ( vr_8 ) ;
}
}
static int
fn_13 ( int vr_11 )
{
int vr_12 = - 1 ;
switch ( vr_11 )
{
case 'e' :
vr_12 = vl_12 ;
break;
case 'i' :
vr_12 = vl_13 ;
break;
case 'o' :
vr_12 = vl_14 ;
break;
}
return vr_12 ;
}
static void
fn_14 ( void )
{
int vr_12 ;
char * vr_13 = getenv ( lr_12 ) ;
char * vr_14 ;
char const * const vr_15 [] = {
vl_10 ,
vl_15 ,
NULL
} ;
char const * const * vr_8 = vr_15 ;
char * vr_16 ;
while ( true )
{
struct vr_17 vr_18 ;
if ( ! * * vr_8 )
{
vr_16 = fn_10 ( vl_16 ) ;
break;
}
vr_12 = fn_15 ( & vr_16 , lr_13 , * vr_8 , vl_16 ) ;
if ( vr_12 < 0 )
fn_16 () ;
if ( vr_17 ( vr_16 , & vr_18 ) == 0 )
break;
free ( vr_16 ) ;
++ vr_8 ;
if ( ! * vr_8 )
error ( vl_17 , 0 , _ ( lr_14 ) , fn_17 ( vl_16 ) ) ;
}
if ( vr_13 )
vr_12 = fn_15 ( & vr_14 , lr_15 , vr_13 , vr_16 ) ;
else
vr_12 = fn_15 ( & vr_14 , lr_16 , vr_16 ) ;
if ( vr_12 < 0 )
fn_16 () ;
free ( vr_16 ) ;
vr_12 = putenv ( vr_14 ) ;
if ( vr_12 != 0 )
{
error ( vl_17 , vl_4 ,
_ ( lr_17 ) ,
fn_17 ( vr_14 ) ) ;
}
}
static bool
fn_18 ( void )
{
bool vr_19 = false ;
tp_1 vr_20 ;
for ( vr_20 = 0 ; vr_20 < fn_19 ( vl_18 ) ; vr_20 ++ )
{
if ( vl_18 [ vr_20 ] . vl_19 )
{
char * vr_21 ;
int vr_12 ;
if ( * vl_18 [ vr_20 ] . vl_19 == 'L' )
vr_12 = fn_15 ( & vr_21 , lr_18 , lr_19 ,
toupper ( vl_18 [ vr_20 ] . vl_20 ) ) ;
else
vr_12 = fn_15 ( & vr_21 , lr_20 vl_21 , lr_19 ,
toupper ( vl_18 [ vr_20 ] . vl_20 ) ,
( tp_2 ) vl_18 [ vr_20 ] . vr_2 ) ;
if ( vr_12 < 0 )
fn_16 () ;
if ( putenv ( vr_21 ) != 0 )
{
error ( vl_17 , vl_4 ,
_ ( lr_17 ) ,
fn_17 ( vr_21 ) ) ;
}
vr_19 = true ;
}
}
return vr_19 ;
}
int
main ( int vr_22 , char * * vr_23 )
{
int vr_11 ;
fn_20 ( & vr_22 , & vr_23 ) ;
fn_21 ( vr_23 [ 0 ] ) ;
setlocale ( vl_22 , lr_21 ) ;
fn_22 ( vl_23 , vl_24 ) ;
fn_23 ( vl_23 ) ;
fn_24 ( vl_17 ) ;
atexit ( vl_25 ) ;
while ( ( vr_11 = fn_25 ( vr_22 , vr_23 , lr_22 , vl_26 , NULL ) ) != - 1 )
{
int vr_24 ;
switch ( vr_11 )
{
case 'e' :
case 'i' :
case 'o' :
vr_24 = fn_13 ( vr_11 ) ;
assert ( 0 <= vr_24 && vr_24 < fn_19 ( vl_18 ) ) ;
vl_18 [ vr_24 ] . vl_20 = vr_11 ;
while ( fn_26 ( * vl_19 ) )
vl_19 ++ ;
vl_18 [ vr_24 ] . vl_19 = vl_19 ;
if ( vr_11 == 'i' && * vl_19 == 'L' )
{
error ( 0 , 0 , _ ( lr_23 ) ) ;
fn_3 ( vl_17 ) ;
}
if ( ! fn_27 ( vl_19 , lr_24 )
&& fn_1 ( vl_19 , & vl_18 [ vr_24 ] . vr_2 ) == - 1 )
error ( vl_17 , vl_4 , _ ( lr_25 ) , fn_17 ( vl_19 ) ) ;
break;
vl_27 ;
fn_28 ( vl_28 , vl_29 ) ;
default:
fn_3 ( vl_17 ) ;
}
}
vr_23 += vl_30 ;
vr_22 -= vl_30 ;
if ( vr_22 < 1 )
{
error ( 0 , 0 , _ ( lr_26 ) ) ;
fn_3 ( vl_17 ) ;
}
if ( ! fn_18 () )
{
error ( 0 , 0 , _ ( lr_27 ) ) ;
fn_3 ( vl_17 ) ;
}
fn_7 ( vl_7 ) ;
if ( ! vl_10 )
vl_10 = fn_10 ( vl_31 ) ;
fn_14 () ;
free ( vl_10 ) ;
fn_29 ( * vr_23 , vr_23 ) ;
{
int vr_25 = ( vl_4 == vl_32 ? vl_33 : vl_34 ) ;
error ( 0 , vl_4 , _ ( lr_28 ) , fn_17 ( vr_23 [ 0 ] ) ) ;
exit ( vr_25 ) ;
}
}
