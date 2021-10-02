void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) , vl_2 ) ;
if ( vl_3 == vl_4 )
{
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
}
else
{
fputs ( _ ( lr_4 ) , stdout ) ;
}
fputs ( vl_5 , stdout ) ;
fputs ( vl_6 , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static void
fn_4 ( char const * vr_2 )
{
static bool vr_3 ;
if ( vr_3 )
putchar ( ' ' ) ;
vr_3 = true ;
fputs ( vr_2 , stdout ) ;
}
static int
fn_5 ( int vr_4 , char * * vr_5 )
{
int vr_6 ;
unsigned int vr_7 = 0 ;
if ( vl_3 == vl_7 )
{
while ( ( vr_6 = fn_6 ( vr_4 , vr_5 , lr_5 ,
vl_8 , NULL ) ) != - 1 )
{
switch ( vr_6 )
{
vl_9 ;
fn_7 ( vl_10 , vl_11 ) ;
default:
fn_1 ( vl_12 ) ;
}
}
vr_7 = vl_13 ;
}
else
{
while ( ( vr_6 = fn_6 ( vr_4 , vr_5 , lr_6 ,
vl_14 , NULL ) ) != - 1 )
{
switch ( vr_6 )
{
case 'a' :
vr_7 = vl_15 ;
break;
case 's' :
vr_7 |= vl_16 ;
break;
case 'n' :
vr_7 |= vl_17 ;
break;
case 'r' :
vr_7 |= vl_18 ;
break;
case 'v' :
vr_7 |= vl_19 ;
break;
case 'm' :
vr_7 |= vl_13 ;
break;
case 'p' :
vr_7 |= vl_20 ;
break;
case 'i' :
vr_7 |= vl_21 ;
break;
case 'o' :
vr_7 |= vl_22 ;
break;
vl_9 ;
fn_7 ( vl_10 , vl_23 ) ;
default:
fn_1 ( vl_12 ) ;
}
}
}
if ( vr_4 != vl_24 )
{
error ( 0 , 0 , _ ( lr_7 ) , fn_8 ( vr_5 [ vl_24 ] ) ) ;
fn_1 ( vl_12 ) ;
}
return vr_7 ;
}
int
main ( int vr_4 , char * * vr_5 )
{
static char const vr_8 [] = lr_8 ;
unsigned int vr_7 = 0 ;
fn_9 ( & vr_4 , & vr_5 ) ;
fn_10 ( vr_5 [ 0 ] ) ;
setlocale ( vl_25 , lr_5 ) ;
fn_11 ( vl_26 , vl_27 ) ;
fn_12 ( vl_26 ) ;
atexit ( vl_28 ) ;
vr_7 = fn_5 ( vr_4 , vr_5 ) ;
if ( vr_7 == 0 )
vr_7 = vl_16 ;
if ( vr_7
& ( vl_16 | vl_17 | vl_18
| vl_19 | vl_13 ) )
{
struct vr_9 vr_10 ;
if ( fn_13 ( & vr_10 ) == - 1 )
error ( vl_12 , vl_29 , _ ( lr_9 ) ) ;
if ( vr_7 & vl_16 )
fn_4 ( vr_10 . vr_11 ) ;
if ( vr_7 & vl_17 )
fn_4 ( vr_10 . vr_12 ) ;
if ( vr_7 & vl_18 )
fn_4 ( vr_10 . vr_13 ) ;
if ( vr_7 & vl_19 )
fn_4 ( vr_10 . vr_14 ) ;
if ( vr_7 & vl_13 )
fn_4 ( vr_10 . vr_15 ) ;
}
if ( vr_7 & vl_20 ) MST[BITAND$@1$@2$!GT$@2$@1$]MSP[]
{
char const * vr_2 = vr_8 ;
#if vl_30 && vl_31 vl_32
{
static char vr_16 [ 257 ] ;
if ( 0 <= fn_14 ( vl_32 , vr_16 , sizeof vr_16 ) )
vr_2 = vr_16 ;
}
#endif
#ifdef vr_17
if ( vr_2 == vr_8 )
{
static char vr_16 [ 257 ] ;
tp_1 vr_18 = sizeof vr_16 ;
static int vr_19 [] = { vl_33 , vr_17 } ;
if ( fn_15 ( vr_19 , 2 , vr_16 , & vr_18 , 0 , 0 ) >= 0 )
vr_2 = vr_16 ;
# ifdef vr_20
if ( vr_2 == vr_8 )
{
tp_2 vr_21 ;
tp_1 vr_18 = sizeof vr_21 ;
tp_3 const * vr_22 ;
if ( fn_16 ( lr_10 , & vr_21 , & vr_18 , NULL , 0 ) == 0
&& ( vr_22 = fn_17 ( vr_21 ,
vl_34 ) )
!= NULL )
vr_2 = vr_22 -> vr_10 ;
if ( vr_21 == vl_35
&& fn_18 ( vr_2 , lr_11 ) == 0 )
vr_2 = lr_12 ;
}
# endif
}
#endif
if ( ! ( vr_7 == vl_15 && vr_2 == vr_8 ) )
fn_4 ( vr_2 ) ;
}
if ( vr_7 & vl_21 )
{
char const * vr_2 = vr_8 ;
#if vl_30 && vl_31 vl_36
{
static char vr_23 [ 257 ] ;
if ( 0 <= fn_14 ( vl_36 ,
vr_23 , sizeof vr_23 ) )
vr_2 = vr_23 ;
}
#endif
#ifdef vr_24
if ( vr_2 == vr_8 )
{
static char vr_23 [ 257 ] ;
tp_1 vr_18 = sizeof vr_23 ;
static int vr_19 [] = { vl_33 , vr_24 } ;
if ( fn_15 ( vr_19 , 2 , vr_23 , & vr_18 , 0 , 0 ) >= 0 )
vr_2 = vr_23 ;
}
#endif
if ( ! ( vr_7 == vl_15 && vr_2 == vr_8 ) )
fn_4 ( vr_2 ) ;
}
if ( vr_7 & vl_22 )
fn_4 ( vl_37 ) ;
putchar ( '\n' ) ;
exit ( vl_1 ) ;
}
