static void
fn_1 ( tp_1 vr_1 , const tp_2 * vr_2 )
{
tp_1 vr_3 = 0 ;
tp_3 vr_4 = 0 ;
tp_3 vr_5 ;
tp_3 vr_6 = 0 ;
long int vr_7 ;
int vr_8 ;
int vr_9 ;
struct vr_10 * vr_11 ;
double vr_12 [ 3 ] ;
int vr_13 ;
#ifdef vr_14
tp_4 * vr_15 ;
vr_15 = fopen ( lr_1 , lr_2 ) ;
if ( vr_15 != NULL )
{
char vr_16 [ vl_1 ] ;
char * vr_17 = fgets ( vr_16 , vl_1 , vr_15 ) ;
if ( vr_17 == vr_16 )
{
char * vr_18 ;
double vr_19 = fn_2 ( vr_16 , & vr_18 ) ;
if ( vr_16 != vr_18 )
vr_6 = ( 0 <= vr_19 && vr_19 < fn_3 ( tp_3 )
? vr_19 : - 1 ) ;
}
fclose ( vr_15 ) ;
}
#endif
#if vl_2 && vl_3 vl_4 && vl_3 vl_5
{
static int vr_20 [ 2 ] = { vl_4 , vl_5 } ;
struct vr_21 vr_22 ;
tp_1 vr_23 = sizeof vr_22 ;
if ( fn_4 ( vr_20 , 2 , & vr_22 , & vr_23 , NULL , 0 ) >= 0 )
vr_4 = vr_22 . vr_24 ;
}
#endif
#if vl_6
{
tp_5 vr_25 ;
fn_5 ( & vr_25 ) ;
vr_4 = vr_25 . vr_4 / 1000000 ;
}
#endif
#if vl_7 || vl_8
while ( vr_1 -- )
{
vr_3 += fn_6 ( vr_2 ) ;
if ( fn_7 ( vr_2 ) )
vr_4 = fn_8 ( vr_2 ) ;
++ vr_2 ;
}
#else
( void ) vr_1 ;
( void ) vr_2 ;
#endif
vr_5 = time ( NULL ) ;
#if vl_3 vr_14
if ( vr_6 == 0 )
#endif
{
if ( vr_4 == 0 )
error ( vl_9 , vl_10 , _ ( lr_3 ) ) ;
vr_6 = vr_5 - vr_4 ;
}
vr_7 = vr_6 / 86400 ;
vr_8 = ( vr_6 - ( vr_7 * 86400 ) ) / 3600 ;
vr_9 = ( vr_6 - ( vr_7 * 86400 ) - ( vr_8 * 3600 ) ) / 60 ;
vr_11 = localtime ( & vr_5 ) ;
if ( vr_11 )
fn_9 ( stdout , _ ( lr_4 ) , vr_11 , 0 , 0 ) ;
else
printf ( _ ( lr_5 ) ) ;
if ( vr_6 == ( tp_3 ) - 1 )
printf ( _ ( lr_6 ) ) ;
else
{
if ( 0 < vr_7 )
printf ( fn_10 ( lr_7 ,
lr_8 ,
fn_11 ( vr_7 ) ) ,
vr_7 , vr_8 , vr_9 ) ;
else
printf ( _ ( lr_9 ) , vr_8 , vr_9 ) ;
}
printf ( fn_10 ( lr_10 , lr_11 , fn_11 ( vr_3 ) ) ,
( unsigned long int ) vr_3 ) ;
vr_13 = fn_12 ( vr_12 , 3 ) ;
if ( vr_13 == - 1 )
putchar ( '\n' ) ;
else
{
if ( vr_13 > 0 )
printf ( _ ( lr_12 ) , vr_12 [ 0 ] ) ;
if ( vr_13 > 1 )
printf ( lr_13 , vr_12 [ 1 ] ) ;
if ( vr_13 > 2 )
printf ( lr_13 , vr_12 [ 2 ] ) ;
if ( vr_13 > 0 )
putchar ( '\n' ) ; MST[STMT!DELSTMT]MSP[N]
}
}
static void
vr_6 ( const char * vr_26 , int vr_27 )
{
tp_1 vr_28 ;
tp_2 * vr_29 = NULL ;
#if vl_7 || vl_8
if ( fn_13 ( vr_26 , & vr_28 , & vr_29 , vr_27 ) != 0 )
error ( vl_9 , vl_10 , lr_14 , vr_26 ) ;
#endif
fn_1 ( vr_28 , vr_29 ) ;
fn_14 ( free ( vr_29 ) ) ;
}
void
fn_15 ( int vr_30 )
{
if ( vr_30 != vl_11 )
fn_16 () ;
else
{
printf ( _ ( lr_15 ) , vl_12 ) ;
printf ( _ ( lr_16 ) ) ;
#ifdef vr_31
printf ( _ ( lr_17 ) ) ;
#else
printf ( _ ( lr_18 ) ) ;
#endif
printf ( _ ( lr_19 ) ,
vl_13 , vl_14 ) ;
fputs ( vl_15 , stdout ) ;
fputs ( vl_16 , stdout ) ;
fn_17 () ;
}
exit ( vr_30 ) ;
}
int
main ( int vr_32 , char * * vr_33 )
{
fn_18 ( & vr_32 , & vr_33 ) ;
fn_19 ( vr_33 [ 0 ] ) ;
setlocale ( vl_17 , lr_20 ) ;
fn_20 ( vl_18 , vl_19 ) ;
fn_21 ( vl_18 ) ;
atexit ( vl_20 ) ;
fn_22 ( vr_32 , vr_33 , vl_21 , vl_22 , vl_23 ,
fn_15 , vl_24 , ( char const * ) NULL ) ;
if ( fn_23 ( vr_32 , vr_33 , lr_20 , NULL , NULL ) != - 1 )
fn_15 ( vl_9 ) ;
switch ( vr_32 - vl_25 )
{
case 0 :
vr_6 ( vl_13 , vl_26 ) ;
break;
case 1 :
vr_6 ( vr_33 [ vl_25 ] , 0 ) ;
break;
default:
error ( 0 , 0 , _ ( lr_21 ) , fn_24 ( vr_33 [ vl_25 + 1 ] ) ) ;
fn_15 ( vl_9 ) ;
}
exit ( vl_11 ) ;
}
