static void fn_1 ( tp_1 vr_1 ) { ( void ) vr_1 ; }
static void fn_2 ( tp_1 vr_1 , unsigned long int vr_2 ) { vr_1 [ 0 ] = vr_2 ; }
static int
fn_3 ( tp_1 vr_1 , char * vr_3 , int vr_4 )
{
return fn_4 ( vr_3 , NULL , vr_4 , vr_1 , NULL ) == vl_1 ? 0 : - 1 ;
}
static void
fn_5 ( tp_1 vr_5 , tp_1 vr_6 , tp_1 vr_7 )
{
tp_2 vr_8 = vr_6 [ 0 ] ;
tp_2 vr_9 = vr_7 [ 0 ] ;
tp_2 vr_10 = vr_8 + vr_9 ;
if ( ( vr_10 < vr_8 ) != ( vr_9 < 0 ) )
fn_6 ( '+' ) ;
vr_5 [ 0 ] = vr_10 ;
}
static void
fn_7 ( tp_1 vr_5 , tp_1 vr_6 , tp_1 vr_7 )
{
tp_2 vr_8 = vr_6 [ 0 ] ;
tp_2 vr_9 = vr_7 [ 0 ] ;
tp_2 vr_10 = vr_8 - vr_9 ;
if ( ( vr_8 < vr_10 ) != ( vr_9 < 0 ) )
fn_6 ( '-' ) ;
vr_5 [ 0 ] = vr_10 ;
}
static void
fn_8 ( tp_1 vr_5 , tp_1 vr_6 , tp_1 vr_7 )
{
tp_2 vr_8 = vr_6 [ 0 ] ;
tp_2 vr_9 = vr_7 [ 0 ] ;
tp_2 vr_10 = vr_8 * vr_9 ;
if ( ! ( vr_8 == 0 || vr_9 == 0
|| ( ( vr_10 < 0 ) == ( ( vr_8 < 0 ) ^ ( vr_9 < 0 ) ) && vr_10 / vr_8 == vr_9 ) ) )
fn_6 ( '*' ) ;
vr_5 [ 0 ] = vr_10 ;
}
static void
fn_9 ( tp_1 vr_5 , tp_1 vr_6 , tp_1 vr_7 )
{
tp_2 vr_8 = vr_6 [ 0 ] ;
tp_2 vr_9 = vr_7 [ 0 ] ;
if ( vr_8 < - vl_2 && vr_9 == - 1 )
fn_6 ( '/' ) ;
vr_5 [ 0 ] = vr_8 / vr_9 ;
}
static void
fn_10 ( tp_1 vr_5 , tp_1 vr_6 , tp_1 vr_7 )
{
tp_2 vr_8 = vr_6 [ 0 ] ;
tp_2 vr_9 = vr_7 [ 0 ] ;
vr_5 [ 0 ] = vr_8 < - vl_2 && vr_9 == - 1 ? 0 : vr_8 % vr_9 ;
}
static char *
fn_11 ( char const * vr_11 , int vr_4 , tp_1 vr_1 )
{
( void ) vr_11 ; ( void ) vr_4 ;
char vr_12 [ fn_12 ( tp_2 ) ] ;
return fn_13 ( fn_14 ( vr_1 [ 0 ] , vr_12 ) ) ;
}
static int
fn_15 ( tp_1 vr_1 )
{
return vr_1 [ 0 ] < 0 ? - 1 : 0 < vr_1 [ 0 ] ;
}
static int
fn_16 ( tp_1 vr_1 )
{
return 0 <= vr_1 [ 0 ] && vr_1 [ 0 ] <= vl_3 ;
}
static unsigned long int
fn_17 ( tp_1 vr_1 )
{
return vr_1 [ 0 ] ;
}
static int
fn_18 ( tp_3 * vr_13 , int vr_4 , tp_1 vr_1 )
{
( void ) vr_4 ;
char vr_12 [ fn_12 ( tp_2 ) ] ;
return fputs ( fn_14 ( vr_1 [ 0 ] , vr_12 ) , vr_13 ) != vl_4 ;
}
void
fn_19 ( int vr_14 )
{
if ( vr_14 != vl_5 )
fn_20 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_6 , vl_6 ) ;
putchar ( '\n' ) ;
fputs ( vl_7 , stdout ) ;
fputs ( vl_8 , stdout ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( _ ( lr_9 ) , stdout ) ;
fn_21 () ;
}
exit ( vr_14 ) ;
}
static void
fn_22 ( void )
{
error ( vl_9 , 0 , _ ( lr_10 ) ) ;
}
static void
fn_6 ( char vr_15 )
{
error ( vl_10 , vl_11 , lr_11 , vr_15 ) ;
abort () ;
}
int
main ( int vr_16 , char * * vr_17 )
{
tp_4 * vr_18 ;
fn_23 ( & vr_16 , & vr_17 ) ;
fn_24 ( vr_17 [ 0 ] ) ;
setlocale ( vl_12 , lr_12 ) ;
fn_25 ( vl_13 , vl_14 ) ;
fn_26 ( vl_13 ) ;
fn_27 ( vl_10 ) ;
atexit ( vl_15 ) ;
fn_28 ( vr_16 , vr_17 , vl_16 , vl_17 , vl_18 ,
fn_19 , vl_19 , ( char const * ) NULL ) ;
unsigned int vr_19 = vr_16 ;
if ( 1 < vr_19 && fn_29 ( vr_17 [ 1 ] , lr_13 ) )
{
-- vr_19 ;
++ vr_17 ;
}
if ( vr_19 <= 1 ) MST[LE$@1$@2$!BITXOR$@1$@2$]MSP[]
{
error ( 0 , 0 , _ ( lr_14 ) ) ;
fn_19 ( vl_9 ) ;
}
args = vr_17 + 1 ;
vr_18 = fn_30 ( true ) ;
if ( ! fn_31 () )
fn_22 () ;
fn_32 ( vr_18 ) ;
exit ( null ( vr_18 ) ) ;
}
static tp_4 *
fn_33 ( unsigned long int vr_2 )
{
tp_4 * vr_18 = xmalloc ( sizeof *vr_18 ) ;
vr_18 -> type = integer ;
fn_2 ( vr_18 -> vr_20 . vr_2 , vr_2 ) ;
return vr_18 ;
}
static tp_4 *
fn_34 ( char const * vr_3 )
{
tp_4 * vr_18 = xmalloc ( sizeof *vr_18 ) ;
vr_18 -> type = string ;
vr_18 -> vr_20 . vr_3 = fn_13 ( vr_3 ) ;
return vr_18 ;
}
static void
fn_35 ( tp_4 * vr_18 )
{
if ( vr_18 -> type == string )
free ( vr_18 -> vr_20 . vr_3 ) ;
else
fn_1 ( vr_18 -> vr_20 . vr_2 ) ;
free ( vr_18 ) ;
}
static void
fn_32 ( tp_4 * vr_18 )
{
switch ( vr_18 -> type )
{
case integer :
fn_18 ( stdout , 10 , vr_18 -> vr_20 . vr_2 ) ;
putchar ( '\n' ) ;
break;
case string :
puts ( vr_18 -> vr_20 . vr_3 ) ;
break;
default:
abort () ;
}
}
static bool tp_5
null ( tp_4 * vr_18 )
{
switch ( vr_18 -> type )
{
case integer :
return fn_15 ( vr_18 -> vr_20 . vr_2 ) == 0 ;
case string :
{
char const * vr_21 = vr_18 -> vr_20 . vr_3 ;
if ( * vr_21 == '\0' )
return true ;
vr_21 += ( * vr_21 == '-' ) ;
do
{
if ( * vr_21 != '0' )
return false ;
}
while ( * ++ vr_21 );
return true ;
}
default:
abort () ;
}
}
static bool tp_5
fn_36 ( char const * vr_21 )
{
vr_21 += ( * vr_21 == '-' ) ;
do
if ( ! ISDIGIT ( * vr_21 ) )
return false ;
while ( * ++ vr_21 );
return true ;
}
static void
tostring ( tp_4 * vr_18 )
{
switch ( vr_18 -> type )
{
case integer :
{
char * vr_3 = fn_11 ( NULL , 10 , vr_18 -> vr_20 . vr_2 ) ;
fn_1 ( vr_18 -> vr_20 . vr_2 ) ;
vr_18 -> vr_20 . vr_3 = vr_3 ;
vr_18 -> type = string ;
}
break;
case string :
break;
default:
abort () ;
}
}
static bool
fn_37 ( tp_4 * vr_18 )
{
switch ( vr_18 -> type )
{
case integer :
return true ;
case string :
{
char * vr_3 = vr_18 -> vr_20 . vr_3 ;
if ( ! fn_36 ( vr_3 ) )
return false ;
if ( fn_3 ( vr_18 -> vr_20 . vr_2 , vr_3 , 10 ) != 0 && ! vl_20 )
error ( vl_10 , vl_11 , lr_15 , vr_3 ) ;
free ( vr_3 ) ;
vr_18 -> type = integer ;
return true ;
}
default:
abort () ;
}
}
static tp_6
fn_38 ( tp_1 vr_2 )
{
if ( fn_15 ( vr_2 ) < 0 )
return vl_21 ;
if ( fn_16 ( vr_2 ) )
{
unsigned long int vr_22 = fn_17 ( vr_2 ) ;
if ( vr_22 < vl_21 )
return vr_22 ;
}
return vl_21 - 1 ;
}
static bool
fn_39 ( char const * vr_11 )
{
if ( * args == NULL )
return false ;
else
{
bool vr_5 = fn_29 ( * args , vr_11 ) ;
args += vr_5 ;
return vr_5 ;
}
}
static bool
fn_31 ( void )
{
return * args == 0 ;
}
static void
fn_40 ( tp_7 )
char * tp_7 ;
{
char * * vr_8 ;
printf ( lr_16 , tp_7 ) ;
for ( vr_8 = args ; * vr_8 ; vr_8 ++ )
printf ( lr_17 , * vr_8 ) ;
putchar ( '\n' ) ;
}
static tp_4 *
fn_41 ( tp_4 * vr_23 , tp_4 * vr_24 )
{
tp_4 * vr_18 vr_25 ( = NULL ) ;
const char * vr_26 ;
struct vr_27 vr_28 ;
char vr_29 [ vl_22 + 1 ] ;
struct vr_30 vr_31 ;
tp_8 vr_32 ;
tostring ( vr_23 ) ;
tostring ( vr_24 ) ;
vr_31 . vr_33 = 0 ;
vr_31 . vr_34 = NULL ;
vr_31 . vr_35 = NULL ;
vr_28 . vr_36 = NULL ;
vr_28 . vr_37 = 0 ;
vr_28 . vr_29 = vr_29 ;
vr_28 . vr_38 = NULL ;
vl_23 =
vl_24 & ~ vl_25 & ~ vl_26 ;
vr_26 = fn_42 ( vr_24 -> vr_20 . vr_3 , strlen ( vr_24 -> vr_20 . vr_3 ) , & vr_28 ) ;
if ( vr_26 )
error ( vl_9 , 0 , lr_15 , vr_26 ) ;
vr_28 . vr_39 = 0 ;
vr_32 = fn_43 ( & vr_28 , vr_23 -> vr_20 . vr_3 , strlen ( vr_23 -> vr_20 . vr_3 ) , 0 , & vr_31 ) ;
if ( 0 <= vr_32 )
{
if ( vr_28 . vr_40 > 0 )
{
vr_23 -> vr_20 . vr_3 [ vr_31 . vr_35 [ 1 ] ] = '\0' ;
vr_18 = fn_34 ( vr_23 -> vr_20 . vr_3 + vr_31 . vr_34 [ 1 ] ) ;
}
else
vr_18 = fn_33 ( vr_32 ) ;
}
else if ( vr_32 == - 1 )
{
if ( vr_28 . vr_40 > 0 )
vr_18 = fn_34 ( lr_12 ) ;
else
vr_18 = fn_33 ( 0 ) ;
}
else
error ( vl_10 ,
( vr_32 == - 2 ? vl_27 : vl_28 ) ,
_ ( lr_18 ) ) ;
if ( 0 < vr_31 . vr_33 )
{
free ( vr_31 . vr_34 ) ;
free ( vr_31 . vr_35 ) ;
}
vr_28 . vr_29 = NULL ;
regfree ( & vr_28 ) ;
return vr_18 ;
}
static tp_4 *
fn_44 ( bool vr_41 )
{
tp_4 * vr_18 ;
#ifdef vr_42
fn_40 ( lr_19 ) ;
#endif
if ( fn_31 () )
fn_22 () ;
if ( fn_39 ( lr_20 ) )
{
vr_18 = fn_30 ( vr_41 ) ;
if ( ! fn_39 ( lr_21 ) )
fn_22 () ;
return vr_18 ;
}
if ( fn_39 ( lr_21 ) )
fn_22 () ;
return fn_34 ( * args ++ ) ;
}
static tp_4 *
fn_45 ( bool vr_41 )
{
tp_4 * vr_43 ;
tp_4 * vr_5 ;
tp_4 * vr_18 ;
tp_4 * vr_44 ;
tp_4 * vr_45 ;
#ifdef vr_42
fn_40 ( lr_22 ) ;
#endif
if ( fn_39 ( lr_23 ) )
{
if ( fn_31 () )
fn_22 () ;
return fn_34 ( * args ++ ) ;
}
else if ( fn_39 ( lr_24 ) )
{
vr_5 = fn_45 ( vr_41 ) ;
tostring ( vr_5 ) ;
vr_18 = fn_33 ( strlen ( vr_5 -> vr_20 . vr_3 ) ) ;
fn_35 ( vr_5 ) ;
return vr_18 ;
}
else if ( fn_39 ( lr_25 ) )
{
vr_43 = fn_45 ( vr_41 ) ;
vr_5 = fn_45 ( vr_41 ) ;
if ( vr_41 )
{
vr_18 = fn_41 ( vr_43 , vr_5 ) ;
fn_35 ( vr_43 ) ;
}
else
vr_18 = vr_43 ;
fn_35 ( vr_5 ) ;
return vr_18 ;
}
else if ( fn_39 ( lr_26 ) )
{
tp_6 vr_46 ;
vr_43 = fn_45 ( vr_41 ) ;
vr_5 = fn_45 ( vr_41 ) ;
tostring ( vr_43 ) ;
tostring ( vr_5 ) ;
vr_46 = strcspn ( vr_43 -> vr_20 . vr_3 , vr_5 -> vr_20 . vr_3 ) ;
vr_18 = fn_33 ( vr_43 -> vr_20 . vr_3 [ vr_46 ] ? vr_46 + 1 : 0 ) ;
fn_35 ( vr_43 ) ;
fn_35 ( vr_5 ) ;
return vr_18 ;
}
else if ( fn_39 ( lr_27 ) )
{
tp_6 vr_47 ;
vr_43 = fn_45 ( vr_41 ) ;
vr_44 = fn_45 ( vr_41 ) ;
vr_45 = fn_45 ( vr_41 ) ;
tostring ( vr_43 ) ;
vr_47 = strlen ( vr_43 -> vr_20 . vr_3 ) ;
if ( ! fn_37 ( vr_44 ) || ! fn_37 ( vr_45 ) )
vr_18 = fn_34 ( lr_12 ) ;
else
{
tp_6 vr_46 = fn_38 ( vr_44 -> vr_20 . vr_2 ) ;
tp_6 vr_48 = fn_38 ( vr_45 -> vr_20 . vr_2 ) ;
if ( vr_47 < vr_46 || vr_46 == 0 || vr_48 == 0 || vr_48 == vl_21 )
vr_18 = fn_34 ( lr_12 ) ;
else
{
tp_6 vr_49 = fn_46 ( vr_48 , vr_47 - vr_46 + 1 ) ;
char * vr_50 ;
vr_18 = xmalloc ( sizeof *vr_18 ) ;
vr_18 -> type = string ;
vr_18 -> vr_20 . vr_3 = xmalloc ( vr_49 + 1 ) ;
vr_50 = fn_47 ( vr_18 -> vr_20 . vr_3 , vr_43 -> vr_20 . vr_3 + vr_46 - 1 , vr_49 ) ;
* vr_50 = '\0' ;
}
}
fn_35 ( vr_43 ) ;
fn_35 ( vr_44 ) ;
fn_35 ( vr_45 ) ;
return vr_18 ;
}
else
return fn_44 ( vr_41 ) ;
}
static tp_4 *
fn_48 ( bool vr_41 )
{
tp_4 * vr_43 ;
tp_4 * vr_5 ;
tp_4 * vr_18 ;
#ifdef vr_42
fn_40 ( lr_28 ) ;
#endif
vr_43 = fn_45 ( vr_41 ) ;
while ( 1 )
{
if ( fn_39 ( lr_29 ) )
{
vr_5 = fn_45 ( vr_41 ) ;
if ( vr_41 )
{
vr_18 = fn_41 ( vr_43 , vr_5 ) ;
fn_35 ( vr_43 ) ;
vr_43 = vr_18 ;
}
fn_35 ( vr_5 ) ;
}
else
return vr_43 ;
}
}
static tp_4 *
fn_49 ( bool vr_41 )
{
tp_4 * vr_43 ;
tp_4 * vr_5 ;
enum { vr_51 , vr_52 , vr_53 } tp_7 ;
#ifdef vr_42
fn_40 ( lr_30 ) ;
#endif
vr_43 = fn_48 ( vr_41 ) ;
while ( 1 )
{
if ( fn_39 ( lr_31 ) )
tp_7 = vr_51 ;
else if ( fn_39 ( lr_32 ) )
tp_7 = vr_52 ;
else if ( fn_39 ( lr_33 ) )
tp_7 = vr_53 ;
else
return vr_43 ;
vr_5 = fn_48 ( vr_41 ) ;
if ( vr_41 )
{
if ( ! fn_37 ( vr_43 ) || ! fn_37 ( vr_5 ) )
error ( vl_9 , 0 , _ ( lr_34 ) ) ;
if ( tp_7 != vr_51 && fn_15 ( vr_5 -> vr_20 . vr_2 ) == 0 )
error ( vl_9 , 0 , _ ( lr_35 ) ) ;
( ( tp_7 == vr_51 ? fn_8
: tp_7 == vr_52 ? fn_9
: fn_10 )
( vr_43 -> vr_20 . vr_2 , vr_43 -> vr_20 . vr_2 , vr_5 -> vr_20 . vr_2 ) ) ;
}
fn_35 ( vr_5 ) ;
}
}
static tp_4 *
fn_50 ( bool vr_41 )
{
tp_4 * vr_43 ;
tp_4 * vr_5 ;
enum { vr_54 , vr_55 } tp_7 ;
#ifdef vr_42
fn_40 ( lr_36 ) ;
#endif
vr_43 = fn_49 ( vr_41 ) ;
while ( 1 )
{
if ( fn_39 ( lr_23 ) )
tp_7 = vr_54 ;
else if ( fn_39 ( lr_37 ) )
tp_7 = vr_55 ;
else
return vr_43 ;
vr_5 = fn_49 ( vr_41 ) ;
if ( vr_41 )
{
if ( ! fn_37 ( vr_43 ) || ! fn_37 ( vr_5 ) )
error ( vl_9 , 0 , _ ( lr_34 ) ) ;
( tp_7 == vr_54 ? fn_5 : fn_7 ) ( vr_43 -> vr_20 . vr_2 , vr_43 -> vr_20 . vr_2 , vr_5 -> vr_20 . vr_2 ) ;
}
fn_35 ( vr_5 ) ;
}
}
static tp_4 *
fn_51 ( bool vr_41 )
{
tp_4 * vr_43 ;
#ifdef vr_42
fn_40 ( lr_38 ) ;
#endif
vr_43 = fn_50 ( vr_41 ) ;
while ( 1 )
{
tp_4 * vr_5 ;
enum
{
vr_56 , vr_57 , vr_58 , vr_59 , vr_60 , vr_61
} tp_7 ;
bool vr_10 = false ;
if ( fn_39 ( lr_39 ) )
tp_7 = vr_56 ;
else if ( fn_39 ( lr_40 ) )
tp_7 = vr_57 ;
else if ( fn_39 ( lr_41 ) || fn_39 ( lr_42 ) )
tp_7 = vr_58 ;
else if ( fn_39 ( lr_43 ) )
tp_7 = vr_59 ;
else if ( fn_39 ( lr_44 ) )
tp_7 = vr_60 ;
else if ( fn_39 ( lr_45 ) )
tp_7 = vr_61 ;
else
return vr_43 ;
vr_5 = fn_50 ( vr_41 ) ;
if ( vr_41 )
{
int vr_62 ;
tostring ( vr_43 ) ;
tostring ( vr_5 ) ;
if ( fn_36 ( vr_43 -> vr_20 . vr_3 ) && fn_36 ( vr_5 -> vr_20 . vr_3 ) )
vr_62 = fn_52 ( vr_43 -> vr_20 . vr_3 , vr_5 -> vr_20 . vr_3 ) ;
else
{
vl_27 = 0 ;
vr_62 = strcoll ( vr_43 -> vr_20 . vr_3 , vr_5 -> vr_20 . vr_3 ) ;
if ( vl_27 )
{
error ( 0 , vl_27 , _ ( lr_46 ) ) ;
error ( 0 , 0 , _ ( lr_47 ) ) ;
error ( vl_9 , 0 ,
_ ( lr_48 ) ,
fn_53 ( 0 , vl_29 , vr_43 -> vr_20 . vr_3 ) ,
fn_53 ( 1 , vl_29 , vr_5 -> vr_20 . vr_3 ) ) ;
}
}
switch ( tp_7 )
{
case vr_56 : vr_10 = ( vr_62 < 0 ) ; break;
case vr_57 : vr_10 = ( vr_62 <= 0 ) ; break;
case vr_58 : vr_10 = ( vr_62 == 0 ) ; break;
case vr_59 : vr_10 = ( vr_62 != 0 ) ; break;
case vr_60 : vr_10 = ( vr_62 >= 0 ) ; break;
case vr_61 : vr_10 = ( vr_62 > 0 ) ; break;
default: abort () ;
}
}
fn_35 ( vr_43 ) ;
fn_35 ( vr_5 ) ;
vr_43 = fn_33 ( vr_10 ) ;
}
}
static tp_4 *
fn_54 ( bool vr_41 )
{
tp_4 * vr_43 ;
tp_4 * vr_5 ;
#ifdef vr_42
fn_40 ( lr_49 ) ;
#endif
vr_43 = fn_51 ( vr_41 ) ;
while ( 1 )
{
if ( fn_39 ( lr_50 ) )
{
vr_5 = fn_51 ( vr_41 && ! null ( vr_43 ) ) ;
if ( null ( vr_43 ) || null ( vr_5 ) )
{
fn_35 ( vr_43 ) ;
fn_35 ( vr_5 ) ;
vr_43 = fn_33 ( 0 ) ;
}
else
fn_35 ( vr_5 ) ;
}
else
return vr_43 ;
}
}
static tp_4 *
fn_30 ( bool vr_41 )
{
tp_4 * vr_43 ;
tp_4 * vr_5 ;
#ifdef vr_42
fn_40 ( lr_51 ) ;
#endif
vr_43 = fn_54 ( vr_41 ) ;
while ( 1 )
{
if ( fn_39 ( lr_52 ) )
{
vr_5 = fn_54 ( vr_41 && null ( vr_43 ) ) ;
if ( null ( vr_43 ) )
{
fn_35 ( vr_43 ) ;
vr_43 = vr_5 ;
if ( null ( vr_43 ) )
{
fn_35 ( vr_43 ) ;
vr_43 = fn_33 ( 0 ) ;
}
}
else
fn_35 ( vr_5 ) ;
}
else
return vr_43 ;
}
}
