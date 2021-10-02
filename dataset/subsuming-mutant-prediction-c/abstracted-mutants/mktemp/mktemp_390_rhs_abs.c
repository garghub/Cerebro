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
fputs ( lr_4 , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static tp_1
fn_4 ( const char * vr_2 , tp_1 vr_3 )
{
tp_1 vr_4 = 0 ;
for ( ; vr_3 && vr_2 [ vr_3 - 1 ] == 'X' ; vr_3 -- )
++ vr_4 ;
return vr_4 ;
}
static int
fn_5 ( char * vr_5 , tp_1 vr_6 , tp_1 vr_7 , bool vr_8 )
{
return fn_6 ( vr_5 , vr_6 , 0 , vr_8 ? vl_5 : vl_6 ,
vr_7 ) ;
}
static int
fn_7 ( char * vr_5 , tp_1 vr_6 , tp_1 vr_7 , bool vr_8 )
{
return fn_6 ( vr_5 , vr_6 , 0 , vr_8 ? vl_5 : vl_7 ,
vr_7 ) ;
}
static void
fn_8 ( void )
{
if ( ! vl_8 )
fn_9 () ;
else if ( fn_10 ( vl_9 ) != 0 )
fn_11 ( vl_10 ) ;
}
int
main ( int vr_9 , char * * vr_10 )
{
char const * vr_11 ;
char const * vr_12 = NULL ;
bool vr_13 = false ;
int vr_14 ;
unsigned int vr_15 ;
char * vr_16 ;
char * vr_17 = NULL ;
bool vr_18 = false ;
bool vr_19 = false ;
bool vr_20 = false ;
bool vr_8 = false ;
int vr_1 = vl_1 ;
tp_1 vr_21 ;
tp_1 vr_22 ;
char * vr_23 ;
fn_12 ( & vr_9 , & vr_10 ) ;
fn_13 ( vr_10 [ 0 ] ) ;
setlocale ( vl_11 , lr_9 ) ;
fn_14 ( vl_12 , vl_13 ) ;
fn_15 ( vl_12 ) ;
atexit ( fn_8 ) ;
while ( ( vr_14 = fn_16 ( vr_9 , vr_10 , lr_10 , vl_14 , NULL ) ) != - 1 )
{
switch ( vr_14 )
{
case 'd' :
vr_20 = true ;
break;
case 'p' :
vr_12 = vl_15 ;
vr_18 = true ;
break;
case 'q' :
vr_13 = true ;
break;
case 't' :
vr_18 = true ; MST[STMT!TRAPSTMT]MSP[N]
vr_19 = true ;
break;
case 'u' :
vr_8 = true ;
break;
case vl_16 :
vr_17 = vl_15 ;
break;
vl_17 ;
case 'V' :
fn_17 ( vl_18 , vl_19 ) ;
default:
fn_1 ( vl_10 ) ;
}
}
vr_15 = vr_9 - vl_20 ;
if ( 2 <= vr_15 )
{
error ( 0 , 0 , _ ( lr_11 ) ) ;
fn_1 ( vl_10 ) ;
}
if ( vr_15 == 0 )
{
vr_18 = true ;
vr_16 = ( char * ) vl_21 ;
}
else
{
vr_16 = vr_10 [ vl_20 ] ;
}
if ( vr_17 )
{
tp_1 vr_3 = strlen ( vr_16 ) ;
if ( ! vr_3 || vr_16 [ vr_3 - 1 ] != 'X' )
{
error ( vl_10 , 0 ,
_ ( lr_12 ) ,
fn_18 ( vr_16 ) ) ;
}
vr_22 = strlen ( vr_17 ) ;
vr_23 = fn_19 ( vr_3 + vr_22 + 1 ) ;
memcpy ( vr_23 , vr_16 , vr_3 ) ;
memcpy ( vr_23 + vr_3 , vr_17 , vr_22 + 1 ) ;
vr_16 = vr_23 ;
vr_17 = vr_23 + vr_3 ;
}
else
{
vr_16 = fn_20 ( vr_16 ) ;
vr_17 = strrchr ( vr_16 , 'X' ) ;
if ( ! vr_17 )
vr_17 = strchr ( vr_16 , '\0' ) ;
else
vr_17 ++ ;
vr_22 = strlen ( vr_17 ) ;
}
if ( vr_22 && fn_21 ( vr_17 ) != vr_17 )
{
error ( vl_10 , 0 ,
_ ( lr_13 ) ,
fn_18 ( vr_17 ) ) ;
}
vr_21 = fn_4 ( vr_16 , vr_17 - vr_16 ) ;
if ( vr_21 < 3 )
error ( vl_10 , 0 , _ ( lr_14 ) , fn_18 ( vr_16 ) ) ;
if ( vr_18 )
{
if ( vr_19 )
{
char * vr_24 = getenv ( lr_15 ) ;
if ( vr_24 && * vr_24 )
vr_11 = vr_24 ;
else if ( vr_12 && * vr_12 )
vr_11 = vr_12 ;
else
vr_11 = lr_16 ;
if ( fn_21 ( vr_16 ) != vr_16 )
error ( vl_10 , 0 ,
_ ( lr_17 ) ,
fn_18 ( vr_16 ) ) ;
}
else
{
if ( vr_12 && * vr_12 )
vr_11 = vr_12 ;
else
{
char * vr_24 = getenv ( lr_15 ) ;
vr_11 = ( vr_24 && * vr_24 ? vr_24 : lr_16 ) ;
}
if ( fn_22 ( vr_16 ) )
error ( vl_10 , 0 ,
_ ( lr_18
lr_19 ) ,
fn_18 ( vr_16 ) ) ;
}
vr_23 = fn_23 ( vr_11 , vr_16 , NULL ) ;
free ( vr_16 ) ;
vr_16 = vr_23 ;
}
vr_23 = fn_20 ( vr_16 ) ;
if ( vr_20 )
{
int vr_25 = fn_7 ( vr_23 , vr_22 , vr_21 , vr_8 ) ;
if ( vr_25 != 0 )
{
if ( ! vr_13 )
error ( 0 , vl_22 , _ ( lr_20 ) ,
fn_18 ( vr_16 ) ) ;
vr_1 = vl_10 ;
}
}
else
{
int vr_26 = fn_5 ( vr_23 , vr_22 , vr_21 , vr_8 ) ;
if ( vr_26 < 0 || ( ! vr_8 && fn_24 ( vr_26 ) != 0 ) )
{
if ( ! vr_13 )
error ( 0 , vl_22 , _ ( lr_21 ) ,
fn_18 ( vr_16 ) ) ;
vr_1 = vl_10 ;
}
}
if ( vr_1 == vl_1 )
{
puts ( vr_23 ) ;
if ( ! vr_8 && ( ( vl_8 = true ) , fn_10 ( stdout ) != 0 ) )
{
int vr_27 = vl_22 ;
remove ( vr_23 ) ;
if ( ! vr_13 )
error ( 0 , vr_27 , _ ( lr_22 ) ) ;
vr_1 = vl_10 ;
}
}
#ifdef vr_28
free ( vr_23 ) ;
free ( vr_16 ) ;
#endif
exit ( vr_1 ) ;
}
