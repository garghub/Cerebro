void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 , vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static void
fn_4 ( tp_1 vr_2 ,
tp_1 vr_3 ,
tp_1 vr_4 ,
tp_1 vr_5 ,
tp_1 vr_6 ,
const char * vr_7 )
{
static char const vr_8 [] = lr_4 ;
char const * vr_9 = vr_8 + 1 ;
char vr_10 [ fn_5 ( tp_1 ) ] ;
if ( vl_5 )
{
printf ( vr_9 , vl_6 , fn_6 ( vr_2 , vr_10 ) ) ;
vr_9 = vr_8 ;
}
if ( vl_7 )
{
printf ( vr_9 , vl_6 , fn_6 ( vr_3 , vr_10 ) ) ;
vr_9 = vr_8 ;
}
if ( vl_8 )
{
printf ( vr_9 , vl_6 , fn_6 ( vr_4 , vr_10 ) ) ;
vr_9 = vr_8 ;
}
if ( vl_9 )
{
printf ( vr_9 , vl_6 , fn_6 ( vr_5 , vr_10 ) ) ;
vr_9 = vr_8 ;
}
if ( vl_10 )
{
printf ( vr_9 , vl_6 , fn_6 ( vr_6 , vr_10 ) ) ;
}
if ( vr_7 )
printf ( lr_5 , vr_7 ) ;
putchar ( '\n' ) ;
}
static bool
fn_7 ( int vr_11 , char const * vr_12 , struct vr_13 * vr_13 )
{
bool vr_14 = true ;
char vr_10 [ vl_11 + 1 ] ;
tp_2 vr_15 ;
tp_1 vr_2 , vr_3 , vr_4 , vr_5 , vr_6 ;
bool vr_16 , vr_17 , vr_18 ;
char const * vr_7 = vr_12 ? vr_12 : _ ( lr_6 ) ;
vr_2 = vr_3 = vr_4 = vr_5 = vr_6 = 0 ;
#if vl_12 > 1
if ( vl_13 > 1 )
{
vr_16 = vl_9 ;
vr_17 = vl_8 ;
}
else
#endif
{
vr_16 = vl_9 || vl_8 ;
vr_17 = false ;
}
vr_18 = vl_7 || vl_10 ;
if ( ! vr_16 || vr_17 || vl_5 || vr_18 )
fn_8 ( vr_11 , 0 , 0 , vl_14 ) ;
if ( vr_16 && ! vr_17 && ! vl_5 && ! vr_18 )
{
tp_3 vr_19 , vr_20 ;
if ( 0 < vr_13 -> vr_21 )
vr_13 -> vr_21 = fn_9 ( vr_11 , & vr_13 -> vr_22 ) ;
if ( ! vr_13 -> vr_21 && fn_10 ( vr_13 -> vr_22 . vr_23 )
&& ( vr_19 = fn_11 ( vr_11 , 0 , vl_15 ) ) != - 1
&& ( vr_20 = fn_11 ( vr_11 , 0 , vl_16 ) ) != - 1 )
{
vr_5 = vr_20 < vr_19 ? 0 : vr_20 - vr_19 ;
}
else
{
fn_8 ( vr_11 , 0 , 0 , vl_14 ) ;
while ( ( vr_15 = fn_12 ( vr_11 , vr_10 , vl_11 ) ) > 0 )
{
if ( vr_15 == vl_17 )
{
error ( 0 , vl_18 , lr_7 , vr_7 ) ;
vr_14 = false ;
break;
}
vr_5 += vr_15 ;
}
}
}
else if ( ! vr_17 && ! vr_18 )
{
while ( ( vr_15 = fn_12 ( vr_11 , vr_10 , vl_11 ) ) > 0 )
{
char * vr_24 = vr_10 ;
if ( vr_15 == vl_17 )
{
error ( 0 , vl_18 , lr_7 , vr_7 ) ;
vr_14 = false ;
break;
}
while ( ( vr_24 = memchr ( vr_24 , '\n' , ( vr_10 + vr_15 ) - vr_24 ) ) )
{
++ vr_24 ;
++ vr_2 ;
}
vr_5 += vr_15 ;
}
}
#if vl_12 > 1
# define mc_1 1
else if ( vl_13 > 1 )
{
bool vr_25 = false ;
tp_1 vr_26 = 0 ;
tp_4 vr_27 = { 0 , } ;
bool vr_28 = false ;
# if mc_1
tp_2 vr_29 = 0 ;
# else
const tp_2 vr_29 = 0 ;
# endif
while ( ( vr_15 = fn_12 ( vr_11 , vr_10 + vr_29 , vl_11 - vr_29 ) ) > 0 )
{
const char * vr_24 ;
# if mc_1
tp_4 vr_30 ;
# endif
if ( vr_15 == vl_17 )
{
error ( 0 , vl_18 , lr_7 , vr_7 ) ;
vr_14 = false ;
break;
}
vr_5 += vr_15 ;
vr_24 = vr_10 ;
vr_15 += vr_29 ;
do
{
tp_5 vr_31 ;
tp_2 vr_32 ;
if ( ! vr_28 && fn_13 ( * vr_24 ) )
{
vr_32 = 1 ;
vr_31 = * vr_24 ;
}
else
{
vr_28 = true ;
# if mc_1
vr_30 = vr_27 ;
# endif
vr_32 = mbrtowc ( & vr_31 , vr_24 , vr_15 , & vr_27 ) ;
if ( vr_32 == ( tp_2 ) - 2 )
{
# if mc_1
vr_27 = vr_30 ;
# endif
break;
}
if ( vr_32 == ( tp_2 ) - 1 )
{
vr_24 ++ ;
vr_15 -- ;
continue;
}
if ( mbsinit ( & vr_27 ) )
vr_28 = false ;
if ( vr_32 == 0 )
{
vr_31 = 0 ;
vr_32 = 1 ;
}
}
vr_24 += vr_32 ;
vr_15 -= vr_32 ;
vr_4 ++ ;
switch ( vr_31 )
{
case '\n' :
vr_2 ++ ;
case '\r' :
case '\f' :
if ( vr_26 > vr_6 )
vr_6 = vr_26 ;
vr_26 = 0 ;
goto lb_1;
case '\t' :
vr_26 += 8 - ( vr_26 % 8 ) ;
goto lb_1;
case ' ' :
vr_26 ++ ;
case '\v' :
lb_1:
vr_3 += vr_25 ;
vr_25 = false ;
break;
default:
if ( iswprint ( vr_31 ) )
{
int vr_33 = wcwidth ( vr_31 ) ;
if ( vr_33 > 0 )
vr_26 += vr_33 ;
if ( iswspace ( vr_31 ) )
goto lb_1;
vr_25 = true ;
}
break;
}
}
while ( vr_15 > 0 );
# if mc_1
if ( vr_15 > 0 )
{
if ( vr_15 == vl_11 )
{
vr_24 ++ ;
vr_15 -- ;
}
memmove ( vr_10 , vr_24 , vr_15 ) ;
}
vr_29 = vr_15 ;
# endif
}
if ( vr_26 > vr_6 )
vr_6 = vr_26 ;
vr_3 += vr_25 ;
}
#endif
else
{
bool vr_25 = false ;
tp_1 vr_26 = 0 ;
while ( ( vr_15 = fn_12 ( vr_11 , vr_10 , vl_11 ) ) > 0 )
{
const char * vr_24 = vr_10 ;
if ( vr_15 == vl_17 )
{
error ( 0 , vl_18 , lr_7 , vr_7 ) ;
vr_14 = false ;
break;
}
vr_5 += vr_15 ;
do
{
switch ( * vr_24 ++ )
{
case '\n' :
vr_2 ++ ;
case '\r' :
case '\f' :
if ( vr_26 > vr_6 )
vr_6 = vr_26 ;
vr_26 = 0 ;
goto lb_2;
case '\t' :
vr_26 += 8 - ( vr_26 % 8 ) ;
goto lb_2;
case ' ' :
vr_26 ++ ;
case '\v' :
lb_2:
vr_3 += vr_25 ;
vr_25 = false ;
break;
default:
if ( isprint ( fn_14 ( vr_24 [ - 1 ] ) ) )
{
vr_26 ++ ;
if ( isspace ( fn_14 ( vr_24 [ - 1 ] ) ) )
goto lb_2;
vr_25 = true ;
}
break;
}
}
while ( -- vr_15 );
}
if ( vr_26 > vr_6 )
vr_6 = vr_26 ;
vr_3 += vr_25 ;
}
if ( vr_17 < vl_8 )
vr_4 = vr_5 ;
fn_4 ( vr_2 , vr_3 , vr_4 , vr_5 , vr_6 , vr_12 ) ;
vl_19 += vr_2 ;
vl_20 += vr_3 ;
vl_21 += vr_4 ;
vl_22 += vr_5 ;
if ( vr_6 > vl_23 )
vl_23 = vr_6 ;
return vr_14 ;
}
static bool
fn_15 ( char const * vr_7 , struct vr_13 * vr_13 )
{
if ( ! vr_7 || fn_16 ( vr_7 , lr_8 ) )
{
vl_24 = true ;
if ( vl_25 && ! fn_17 ( vl_26 ) )
fn_18 ( NULL , lr_9 , vl_27 ) ;
return fn_7 ( vl_26 , vr_7 , vr_13 ) ;
}
else
{
int vr_11 = fn_19 ( vr_7 , vl_28 | vl_25 ) ;
if ( vr_11 == - 1 )
{
error ( 0 , vl_18 , lr_7 , vr_7 ) ;
return false ;
}
else
{
bool vr_14 = fn_7 ( vr_11 , vr_7 , vr_13 ) ;
if ( fn_20 ( vr_11 ) != 0 )
{
error ( 0 , vl_18 , lr_7 , vr_7 ) ;
return false ;
}
return vr_14 ;
}
}
}
static struct vr_13 *
fn_21 ( int vr_34 , char * const * vr_7 )
{
struct vr_13 * vr_13 = fn_22 ( vr_34 ? vr_34 : 1 , sizeof *vr_13 ) ;
if ( vr_34 == 0
|| ( vr_34 == 1
&& ( ( vl_5 + vl_7 + vl_8
+ vl_9 + vl_10 )
== 1 ) ) )
vr_13 [ 0 ] . vr_21 = 1 ;
else
{
int vr_35 ;
for ( vr_35 = 0 ; vr_35 < vr_34 ; vr_35 ++ )
vr_13 [ vr_35 ] . vr_21 = ( ! vr_7 [ vr_35 ] || fn_16 ( vr_7 [ vr_35 ] , lr_8 )
? fn_9 ( vl_26 , & vr_13 [ vr_35 ] . vr_22 )
: fn_23 ( vr_7 [ vr_35 ] , & vr_13 [ vr_35 ] . vr_22 ) ) ;
}
return vr_13 ;
}
static int tp_6
fn_24 ( int vr_34 , struct vr_13 const * vr_13 )
{
int vr_33 = 1 ;
if ( 0 < vr_34 && vr_13 [ 0 ] . vr_21 <= 0 )
{
int vr_36 = 1 ;
tp_1 vr_37 = 0 ;
int vr_35 ;
for ( vr_35 = 0 ; vr_35 < vr_34 ; vr_35 ++ )
if ( ! vr_13 [ vr_35 ] . vr_21 )
{
if ( fn_10 ( vr_13 [ vr_35 ] . vr_22 . vr_23 ) )
vr_37 += vr_13 [ vr_35 ] . vr_22 . vr_38 ;
else
vr_36 = 7 ;
}
for (; 10 <= vr_37 ; vr_37 /= 10 ) MST[C!ADD$C$1$]MSP[S]
vr_33 ++ ;
if ( vr_33 < vr_36 )
vr_33 = vr_36 ;
}
return vr_33 ;
}
int
main ( int vr_39 , char * * vr_40 )
{
bool vr_14 ;
int vr_41 ;
int vr_34 ;
char * * vr_42 ;
char * vr_43 = NULL ;
struct vr_13 * vr_13 ;
struct vr_44 vr_45 ;
fn_25 ( & vr_39 , & vr_40 ) ;
fn_26 ( vr_40 [ 0 ] ) ;
setlocale ( vl_29 , lr_10 ) ;
fn_27 ( vl_30 , vl_31 ) ;
fn_28 ( vl_30 ) ;
atexit ( vl_32 ) ;
setvbuf ( stdout , NULL , vl_33 , 0 ) ;
vl_5 = vl_7 = vl_8 = vl_9 = false ;
vl_10 = false ;
vl_19 = vl_20 = vl_21 = vl_22 = vl_23 = 0 ;
while ( ( vr_41 = fn_29 ( vr_39 , vr_40 , lr_11 , vl_34 , NULL ) ) != - 1 )
switch ( vr_41 )
{
case 'c' :
vl_9 = true ;
break;
case 'm' :
vl_8 = true ;
break;
case 'l' :
vl_5 = true ;
break;
case 'w' :
vl_7 = true ;
break;
case 'L' :
vl_10 = true ;
break;
case vl_35 :
vr_43 = vl_36 ;
break;
vl_37 ;
fn_30 ( vl_38 , vl_39 ) ;
default:
fn_1 ( vl_40 ) ;
}
if ( ! ( vl_5 || vl_7 || vl_8 || vl_9
|| vl_10 ) )
vl_5 = vl_7 = vl_9 = true ;
bool vr_46 = false ;
struct vr_47 * vr_48 ;
if ( vr_43 )
{
tp_7 * vr_49 ;
if ( vl_41 < vr_39 )
{
error ( 0 , 0 , _ ( lr_12 ) , fn_31 ( vr_40 [ vl_41 ] ) ) ;
fprintf ( vl_42 , lr_13 ,
_ ( lr_14 ) ) ;
fn_1 ( vl_40 ) ;
}
if ( fn_16 ( vr_43 , lr_8 ) )
vr_49 = vl_27 ;
else
{
vr_49 = fopen ( vr_43 , lr_15 ) ;
if ( vr_49 == NULL )
error ( vl_40 , vl_18 , _ ( lr_16 ) ,
fn_31 ( vr_43 ) ) ;
}
struct fn_23 vr_22 ;
if ( fn_9 ( fileno ( vr_49 ) , & vr_22 ) == 0
&& fn_10 ( vr_22 . vr_23 )
&& vr_22 . vr_38 <= fn_32 ( 10 * 1024 * 1024 , fn_33 () / 2 ) )
{
vr_46 = true ;
fn_34 ( & vr_45 ) ;
if ( ! fn_35 ( vr_49 , & vr_45 ) || fclose ( vr_49 ) != 0 )
error ( vl_40 , 0 , _ ( lr_17 ) ,
fn_31 ( vr_43 ) ) ;
vr_42 = vr_45 . vr_45 ;
vr_34 = vr_45 . vr_50 ;
vr_48 = fn_36 ( vr_42 ) ;
}
else
{
vr_42 = NULL ;
vr_34 = 0 ;
vr_48 = fn_37 ( vr_49 ) ;
}
}
else
{
static char * vr_51 [] = { NULL } ;
vr_42 = ( vl_41 < vr_39 ? vr_40 + vl_41 : vr_51 ) ;
vr_34 = ( vl_41 < vr_39 ? vr_39 - vl_41 : 1 ) ;
vr_48 = fn_36 ( vr_42 ) ;
}
if ( ! vr_48 )
fn_38 () ;
vr_13 = fn_21 ( vr_34 , vr_42 ) ;
vl_6 = fn_24 ( vr_34 , vr_13 ) ;
int vr_35 ;
vr_14 = true ;
for ( vr_35 = 0 ; ; vr_35 ++ )
{
bool vr_52 = false ;
enum vr_53 vr_54 ;
char * vr_55 = fn_39 ( vr_48 , & vr_54 ) ;
if ( ! vr_55 )
{
switch ( vr_54 )
{
case vl_43 :
goto lb_3;
case vl_44 :
error ( 0 , vl_18 , _ ( lr_18 ) ,
fn_40 ( vr_43 ) ) ;
vr_14 = false ;
goto lb_3;
case vl_45 :
fn_38 () ;
default:
assert ( ! lr_19 ) ;
}
}
if ( vr_43 && fn_16 ( vr_43 , lr_8 ) && fn_16 ( vr_55 , lr_8 ) )
{
error ( 0 , 0 , _ ( lr_20
lr_21 ) ,
fn_31 ( vr_55 ) ) ;
vr_52 = true ;
}
if ( ! vr_55 [ 0 ] )
{
if ( vr_43 == NULL )
error ( 0 , 0 , lr_7 , _ ( lr_22 ) ) ;
else
{
unsigned long int vr_56 = fn_41 ( vr_48 ) ;
error ( 0 , 0 , lr_23 , fn_40 ( vr_43 ) ,
vr_56 , _ ( lr_22 ) ) ;
}
vr_52 = true ;
}
if ( vr_52 )
vr_14 = false ;
else
vr_14 &= fn_15 ( vr_55 , & vr_13 [ vr_34 ? vr_35 : 0 ] ) ;
}
lb_3:
if ( vr_14 && ! vr_43 && fn_41 ( vr_48 ) == 0 )
vr_14 &= fn_15 ( NULL , & vr_13 [ 0 ] ) ;
if ( vr_46 )
fn_42 ( & vr_45 ) ;
if ( 1 < fn_41 ( vr_48 ) )
fn_4 ( vl_19 , vl_20 , vl_21 , vl_22 ,
vl_23 , _ ( lr_24 ) ) ;
fn_43 ( vr_48 ) ;
free ( vr_13 ) ;
if ( vl_24 && fn_20 ( vl_26 ) != 0 )
error ( vl_40 , vl_18 , lr_8 ) ;
exit ( vr_14 ? vl_1 : vl_40 ) ;
}
