static inline void
fn_1 ( char const * vr_1 , ... )
{
if ( vl_1 )
{
tp_1 vr_2 ;
va_start ( vr_2 , vr_1 ) ;
vfprintf ( vl_2 , vr_1 , vr_2 ) ;
va_end ( vr_2 ) ;
}
}
static inline int
fn_2 ( enum vr_3 vr_4 )
{
switch ( vr_4 )
{
case vl_3 :
case vl_4 :
return 1024 ;
case vl_5 :
case vl_6 :
case vl_7 :
default:
return 1000 ;
}
}
static inline int
fn_3 ( const char vr_5 )
{
static const char * vr_6 = lr_1 ;
return ( strchr ( vr_6 , vr_5 ) != NULL ) ;
}
static inline int
fn_4 ( const char vr_5 )
{
switch ( vr_5 )
{
case 'K' :
return 1 ;
case 'M' :
return 2 ;
case 'G' :
return 3 ;
case 'T' :
return 4 ;
case 'P' :
return 5 ;
case 'E' :
return 6 ;
case 'Z' :
return 7 ;
case 'Y' :
return 8 ;
default:
return 0 ;
}
}
static inline const char *
fn_5 ( unsigned int vr_7 )
{
switch ( vr_7 )
{
case 0 :
return lr_2 ;
case 1 :
return lr_3 ;
case 2 :
return lr_4 ;
case 3 :
return lr_5 ;
case 4 :
return lr_6 ;
case 5 :
return lr_7 ;
case 6 :
return lr_8 ;
case 7 :
return lr_9 ;
case 8 :
return lr_10 ;
default:
return lr_11 ;
}
}
static long double
fn_6 ( long double vr_8 , unsigned int vr_9 )
{
long double vr_10 = vr_8 ;
if ( vr_9 == 0 )
return 1 ;
while ( -- vr_9 )
vr_10 *= vr_8 ;
return vr_10 ;
}
static inline long double
fn_7 ( long double vr_11 )
{
return vr_11 < 0 ? - vr_11 : vr_11 ;
}
static long double
fn_8 ( long double vr_11 , unsigned int vr_8 , unsigned int * vr_9 )
{
unsigned int vr_7 = 0 ;
if ( vr_11 >= - vl_8 && vr_11 <= vl_8 )
{
while ( fn_7 ( vr_11 ) >= vr_8 )
{
++ vr_7 ;
vr_11 /= vr_8 ;
}
}
if ( vr_9 )
* vr_9 = vr_7 ;
return vr_11 ;
}
static inline tp_2
fn_9 ( long double vr_11 )
{
tp_2 vr_12 = vr_11 ;
if ( vr_12 < vr_11 )
vr_12 ++ ;
return vr_12 ;
}
static inline tp_2
fn_10 ( long double vr_11 )
{
return - fn_9 ( - vr_11 ) ;
}
static inline tp_2
fn_11 ( long double vr_11 )
{
return vr_11 < 0 ? fn_10 ( vr_11 ) : fn_9 ( vr_11 ) ;
}
static inline tp_2
fn_12 ( long double vr_11 )
{
return vr_11 ;
}
static inline tp_2
fn_13 ( long double vr_11 )
{
return vr_11 < 0 ? vr_11 - 0.5 : vr_11 + 0.5 ;
}
static inline tp_2
fn_14 ( long double vr_11 , enum vr_13 vr_14 )
{
switch ( vr_14 )
{
case vl_9 :
return fn_9 ( vr_11 ) ;
case vl_10 :
return fn_10 ( vr_11 ) ;
case vl_11 :
return fn_11 ( vr_11 ) ;
case vl_12 :
return fn_12 ( vr_11 ) ;
case vl_13 :
return fn_13 ( vr_11 ) ;
default:
return 0 ;
}
}
static enum vr_15
fn_15 ( const char * vr_16 ,
char * * vr_17 , long double * vr_18 , bool * vr_19 )
{
enum vr_15 vr_20 = vl_14 ;
long double vr_11 = 0 ;
unsigned int vr_21 = 0 ;
if ( * vr_16 == '-' )
{
vr_16 ++ ;
* vr_19 = true ;
}
else
* vr_19 = false ;
* vr_17 = ( char * ) vr_16 ;
while ( * vr_17 && isdigit ( * * vr_17 ) )
{
int vr_22 = ( * * vr_17 ) - '0' ;
if ( vr_22 < 0 || vr_22 > 9 )
return vl_15 ;
if ( vr_21 > vl_16 )
vr_20 = vl_17 ;
++ vr_21 ;
if ( vr_21 > vl_18 )
return vl_19 ;
vr_11 *= 10 ;
vr_11 += vr_22 ;
++ ( * vr_17 ) ;
}
if ( vr_21 == 0 )
return vl_15 ;
if ( * vr_19 )
vr_11 = - vr_11 ;
if ( vr_18 )
* vr_18 = vr_11 ;
return vr_20 ;
}
static enum vr_15
fn_16 ( const char * vr_16 ,
char * * vr_17 ,
long double * vr_18 ,
tp_3 * vr_23 )
{
bool vr_19 ;
enum vr_15 vr_20 = vl_14 ;
if ( vr_23 )
* vr_23 = 0 ;
vr_20 = fn_15 ( vr_16 , vr_17 , vr_18 , & vr_19 ) ;
if ( vr_20 != vl_14 && vr_20 != vl_17 )
return vr_20 ;
if ( fn_17 ( * vr_17 , vl_20 , vl_21 ) )
{
char * vr_24 ;
long double vr_25 = 0 ;
bool vr_26 ;
( * vr_17 ) += vl_21 ;
enum vr_15 vr_27 =
fn_15 ( * vr_17 , & vr_24 , & vr_25 , & vr_26 ) ;
if ( vr_27 != vl_14 && vr_27 != vl_17 )
return vr_27 ;
if ( vr_27 == vl_17 )
vr_20 = vr_27 ;
if ( vr_26 )
return vl_15 ;
tp_3 vr_28 = vr_24 - * vr_17 ;
vr_25 = ( ( long double ) vr_25 ) / fn_6 ( 10 , vr_28 ) ;
if ( vr_18 )
{
if ( vr_19 )
* vr_18 -= vr_25 ;
else
* vr_18 += vr_25 ;
}
if ( vr_23 )
* vr_23 = vr_28 ;
* vr_17 = vr_24 ;
}
return vr_20 ;
}
static enum vr_15
fn_18 ( const char * vr_16 ,
char * * vr_17 , long double * vr_18 , tp_3 * vr_23 ,
enum vr_3 vr_29 )
{
int vr_7 = 0 ;
int vr_30 = fn_2 ( vr_29 ) ;
fn_1 ( lr_12
lr_13 ,
fn_19 ( 0 , vr_16 ) , fn_19 ( 1 , vl_20 ) ) ;
enum vr_15 vr_20 =
fn_16 ( vr_16 , vr_17 , vr_18 , vr_23 ) ;
if ( vr_20 != vl_14 && vr_20 != vl_17 )
return vr_20 ;
fn_1 ( lr_14
lr_15 , * vr_18 , ( int ) * vr_23 ) ;
if ( * * vr_17 != '\0' )
{
while ( fn_20 ( * * vr_17 ) )
( * vr_17 ) ++ ;
if ( ! fn_3 ( * * vr_17 ) )
return vl_22 ;
if ( vr_29 == vl_5 )
return vl_23 ;
vr_7 = fn_4 ( * * vr_17 ) ;
( * vr_17 ) ++ ;
if ( vr_29 == vl_6 && * * vr_17 == 'i' )
{
vr_30 = 1024 ;
( * vr_17 ) ++ ;
fn_1 ( lr_16 ,
vr_30 ) ;
}
* vr_23 = 0 ;
}
if ( vr_29 == vl_4 )
{
if ( * * vr_17 == 'i' )
( * vr_17 ) ++ ;
else
return vl_24 ;
}
long double vr_31 = fn_6 ( vr_30 , vr_7 ) ;
fn_1 ( lr_17 , vr_30 , vr_7 , vr_31 ) ;
( * vr_18 ) = ( * vr_18 ) * vr_31 ;
fn_1 ( lr_18 , * vr_18 , * vr_18 ) ;
return vr_20 ;
}
static void
fn_21 ( enum vr_15 vr_32 , char const * vr_16 )
{
char const * vr_33 = NULL ;
switch ( vr_32 )
{
case vl_17 :
case vl_14 :
abort () ;
case vl_19 :
vr_33 = fn_22 ( lr_19 ) ;
break;
case vl_15 :
vr_33 = fn_22 ( lr_20 ) ;
break;
case vl_23 :
vr_33 = fn_22 ( lr_21 ) ;
break;
case vl_22 :
vr_33 = fn_22 ( lr_22 ) ;
break;
case vl_24 :
vr_33 = fn_22 ( lr_23 ) ;
break;
}
if ( vl_25 != vl_26 )
error ( vl_27 , 0 , fn_23 ( vr_33 ) , fn_24 ( vr_16 ) ) ;
}
static void
fn_25 ( long double vr_11 , int vr_23 ,
char * vr_34 , tp_3 vr_35 ,
enum vr_3 vr_4 , int vr_36 , enum vr_13 vr_37 )
{
fn_1 ( lr_24 ) ;
if ( vr_4 == vl_5 )
{
vr_11 *= fn_6 ( 10 , vr_23 ) ;
vr_11 = fn_14 ( vr_11 , vr_37 ) ;
vr_11 /= fn_6 ( 10 , vr_23 ) ;
fn_1 ( ( vr_36 ) ?
lr_25 :
lr_26 , vr_23 , vr_11 ) ;
int vr_38 = snprintf ( vr_34 , vr_35 , ( vr_36 ) ? lr_27 : lr_28 ,
vr_23 , vr_11 ) ;
if ( vr_38 < 0 || vr_38 >= ( int ) vr_35 )
error ( vl_28 , 0 ,
_ ( lr_29 ) , vr_11 ) ;
return;
}
double vr_30 = fn_2 ( vr_4 ) ;
unsigned int vr_7 = 0 ;
vr_11 = fn_8 ( vr_11 , vr_30 , & vr_7 ) ;
fn_1 ( lr_30 , vr_11 , vr_30 , vr_7 ) ;
int vr_39 = 0 ;
if ( fn_7 ( vr_11 ) < 10 )
{
vr_39 = 1 ;
vr_11 *= 10 ;
}
vr_11 = fn_14 ( vr_11 , vr_37 ) ;
if ( fn_7 ( vr_11 ) >= vr_30 )
{
vr_11 /= vr_30 ;
vr_7 ++ ;
}
if ( vr_39 )
vr_11 /= 10 ;
int vr_40 = ( vr_11 != 0 ) && ( fn_7 ( vr_11 ) < 10 ) && ( vr_7 > 0 ) ;
fn_1 ( lr_31 , vr_11 , vr_30 , vr_7 ) ;
snprintf ( vr_34 , vr_35 , ( vr_40 ) ? lr_32 : lr_33 ,
vr_11 , fn_5 ( vr_7 ) ) ;
if ( vr_4 == vl_4 && vr_7 > 0 )
strncat ( vr_34 , lr_34 , vr_35 - strlen ( vr_34 ) - 1 ) ;
fn_1 ( lr_35 , fn_24 ( vr_34 ) ) ;
return;
}
static tp_4
fn_26 ( const char * vr_41 )
{
tp_5 vr_42 ;
char * vr_43 = NULL ;
tp_4 vr_44 ;
vr_42 = fn_27 ( vr_41 , & vr_43 , 10 , & vr_44 , lr_1 ) ;
if ( vr_42 != vl_29 || * vr_43 || vr_44 == 0 )
error ( vl_28 , 0 , _ ( lr_36 ) , fn_24 ( vr_41 ) ) ;
return vr_44 ;
}
static void
fn_28 ( tp_3 vr_45 )
{
if ( vl_30 > vr_45 )
return;
vl_30 = vr_45 + 1 ;
vl_31 = realloc ( vl_31 , vl_30 ) ;
if ( ! vl_31 )
error ( vl_28 , 0 , _ ( lr_37 ) ,
vl_30 ) ;
}
void
fn_29 ( int vr_46 )
{
if ( vr_46 != vl_32 )
fn_30 () ;
else
{
printf ( _ ( lr_38 ) , vl_33 ) ;
fputs ( _ ( lr_39 ) , stdout ) ;
fn_31 () ;
fputs ( _ ( lr_40 ) , stdout ) ;
fputs ( _ ( lr_41 ) , stdout ) ;
fputs ( _ ( lr_42 ) , stdout ) ;
fputs ( _ ( lr_43 ) , stdout ) ;
fputs ( _ ( lr_44 ) , stdout ) ;
fputs ( _ ( lr_45 ) , stdout ) ;
fputs ( _ ( lr_46 ) , stdout ) ;
fputs ( _ ( lr_47 ) , stdout ) ;
fputs ( _ ( lr_48 ) , stdout ) ;
fputs ( _ ( lr_49 ) , stdout ) ;
fputs ( _ ( lr_50 ) , stdout ) ;
fputs ( _ ( lr_51 ) , stdout ) ;
fputs ( _ ( lr_52 ) , stdout ) ;
fputs ( _ ( lr_53 ) , stdout ) ;
fputs ( vl_34 , stdout ) ;
fputs ( vl_35 , stdout ) ;
fputs ( _ ( lr_54 ) , stdout ) ;
fputs ( _ ( lr_55 ) , stdout ) ;
fputs ( _ ( lr_56 ) , stdout ) ;
fputs ( _ ( lr_57 ) , stdout ) ;
fputs ( _ ( lr_58 ) , stdout ) ;
fputs ( _ ( lr_59 ) , stdout ) ;
fputs ( _ ( lr_60 ) , stdout ) ;
printf ( _ ( lr_61 ) , vl_33 ) ;
printf ( _ ( lr_62 ) ,
vl_33 , vl_33 , vl_33 ,
vl_33 , vl_33 , vl_33 ,
vl_33 , vl_33 , vl_33 ) ;
fn_32 () ;
}
exit ( vr_46 ) ;
}
static void
fn_33 ( char const * vr_1 )
{
tp_3 vr_38 ;
tp_3 vr_47 = 0 ;
tp_3 vr_48 ;
long int vr_49 = 0 ;
char * vr_17 = NULL ;
for ( vr_38 = 0 ; ! ( vr_1 [ vr_38 ] == '%' && vr_1 [ vr_38 + 1 ] != '%' ) ; vr_38 += ( vr_1 [ vr_38 ] == '%' ) + 1 )
{
if ( ! vr_1 [ vr_38 ] )
error ( vl_28 , 0 ,
_ ( lr_63 ) , fn_24 ( vr_1 ) ) ;
vr_47 ++ ;
}
vr_38 ++ ;
vr_38 += strspn ( vr_1 + vr_38 , lr_64 ) ;
if ( vr_1 [ vr_38 ] == '\'' )
{
vl_36 = 1 ;
vr_38 ++ ;
}
vr_38 += strspn ( vr_1 + vr_38 , lr_64 ) ;
vl_37 = 0 ;
vr_49 = strtol ( vr_1 + vr_38 , & vr_17 , 10 ) ;
if ( vl_37 == vl_38 )
error ( vl_28 , 0 ,
_ ( lr_65 ) , fn_24 ( vr_1 ) ) ;
if ( vr_17 != ( vr_1 + vr_38 ) && vr_49 != 0 )
{
if ( vr_49 < 0 )
{
vl_39 = vl_40 ;
vl_41 = - vr_49 ;
}
else
{
vl_41 = vr_49 ;
}
}
vr_38 = vr_17 - vr_1 ;
if ( vr_1 [ vr_38 ] == '\0' )
error ( vl_28 , 0 , _ ( lr_66 ) , fn_24 ( vr_1 ) ) ;
if ( vr_1 [ vr_38 ] != 'f' )
error ( vl_28 , 0 , _ ( lr_67
lr_68 ) ,
fn_24 ( vr_1 ) ) ;
vr_38 ++ ;
vr_48 = vr_38 ;
for (; vr_1 [ vr_38 ] != '\0' ; vr_38 += ( vr_1 [ vr_38 ] == '%' ) + 1 )
if ( vr_1 [ vr_38 ] == '%' && vr_1 [ vr_38 + 1 ] != '%' )
error ( vl_28 , 0 , _ ( lr_69 ) ,
fn_24 ( vr_1 ) ) ;
if ( vr_47 )
{
vl_42 = fn_34 ( vr_1 , vr_47 ) ;
if ( ! vl_42 )
error ( vl_28 , 0 , _ ( lr_37 ) ,
vr_47 + 1 ) ;
}
if ( vr_1 [ vr_48 ] != '\0' )
{
vl_43 = fn_35 ( vr_1 + vr_48 ) ;
if ( ! vl_43 )
error ( vl_28 , 0 , _ ( lr_37 ) ,
strlen ( vr_1 + vr_48 ) ) ;
}
fn_1 ( lr_70
lr_71
lr_72 ,
fn_19 ( 0 , vr_1 ) , ( vl_36 ) ? lr_73 : lr_74 ,
vl_41 ,
( vl_39 == vl_40 ) ? lr_75 : lr_76 ,
fn_19 ( 1 , vl_42 ? vl_42 : lr_2 ) ,
fn_19 ( 2 , vl_43 ? vl_43 : lr_2 ) ) ;
}
static enum vr_15
fn_36 ( const char * vr_50 , long double * vr_18 ,
tp_3 * vr_23 )
{
char * vr_51 = NULL ;
enum vr_15 vr_20 =
fn_18 ( vr_50 , & vr_51 , vr_18 , vr_23 , vl_44 ) ;
if ( vr_20 != vl_14 && vr_20 != vl_17 )
{
fn_21 ( vr_20 , vr_50 ) ;
return vr_20 ;
}
if ( vr_51 && * vr_51 != '\0' )
{
if ( vl_25 != vl_26 )
error ( vl_27 , 0 , _ ( lr_77 ) ,
fn_19 ( 0 , vr_50 ) , fn_19 ( 1 , vr_51 ) ) ;
vr_20 = vl_22 ;
}
return vr_20 ;
}
static int
fn_37 ( const long double vr_11 , tp_3 vr_23 )
{
char vr_34 [ 128 ] ;
unsigned int vr_9 ;
fn_8 ( vr_11 , 10 , & vr_9 ) ;
if ( vl_45 == vl_5 && vr_9 > vl_16 )
{
if ( vl_25 != vl_26 )
error ( vl_27 , 0 , _ ( lr_78
lr_79 ) , vr_11 ) ;
return 0 ;
}
if ( vr_9 > vl_18 - 1 )
{
if ( vl_25 != vl_26 )
error ( vl_27 , 0 , _ ( lr_78
lr_80 ) , vr_11 ) ;
return 0 ;
}
fn_25 ( vr_11 , vr_23 , vr_34 , sizeof ( vr_34 ) , vl_45 , vl_36 ,
vl_46 ) ;
if ( vl_47 )
strncat ( vr_34 , vl_47 , sizeof ( vr_34 ) - strlen ( vr_34 ) - 1 ) ;
fn_1 ( lr_81 ,
vr_11 , fn_24 ( vr_34 ) ) ;
if ( vl_41 && strlen ( vr_34 ) < vl_41 )
{
tp_3 vr_52 = vl_41 ;
fn_38 ( vr_34 , vl_31 , vl_30 , & vr_52 ,
vl_39 , vl_48 ) ;
fn_1 ( lr_82 , fn_24 ( vl_31 ) ) ;
}
else
{
fn_28 ( strlen ( vr_34 ) + 1 ) ;
strcpy ( vl_31 , vr_34 ) ;
}
return 1 ;
}
static void
fn_39 ( void )
{
if ( vl_42 )
fputs ( vl_42 , stdout ) ;
fputs ( vl_31 , stdout ) ;
if ( vl_43 )
fputs ( vl_43 , stdout ) ;
}
static int
fn_40 ( char * vr_53 , long double * vr_10 , tp_3 * vr_23 )
{
if ( vl_47 && strlen ( vr_53 ) > strlen ( vl_47 ) )
{
char * vr_54 = vr_53 + strlen ( vr_53 ) - strlen ( vl_47 ) ;
if ( fn_41 ( vl_47 , vr_54 ) )
{
* vr_54 = '\0' ;
fn_1 ( lr_83 , fn_24 ( vl_47 ) ) ;
}
else
fn_1 ( lr_84 ) ;
}
char * vr_55 = vr_53 ;
while ( * vr_55 && fn_20 ( * vr_55 ) )
++ vr_55 ;
const unsigned int vr_56 = vr_53 - vr_55 ;
if ( vl_49 )
{
if ( vr_56 > 0 || vl_50 > 1 )
{
vl_41 = strlen ( vr_53 ) ;
fn_28 ( vl_41 ) ;
}
else
{
vl_41 = 0 ;
}
fn_1 ( lr_85 , vl_41 ) ;
}
long double vr_11 = 0 ;
enum vr_15 vr_20 = fn_36 ( vr_55 , & vr_11 , vr_23 ) ;
if ( vr_20 == vl_17 && vl_51 )
error ( 0 , 0 , _ ( lr_86 ) ,
fn_24 ( vr_55 ) ) ;
if ( vl_52 != 1 || vl_53 != 1 )
vr_11 = ( vr_11 * vl_52 ) / vl_53 ;
* vr_10 = vr_11 ;
return ( vr_20 == vl_14 || vr_20 == vl_17 ) ;
}
static inline char * tp_6
fn_42 ( char * vr_34 , int vr_57 )
{
char * vr_51 = vr_34 ;
if ( vl_54 != vl_55 )
{
if ( * vr_51 == vl_54 )
vr_57 -- ;
while ( * vr_51 && vr_57 -- )
{
while ( * vr_51 && * vr_51 == vl_54 )
++ vr_51 ;
while ( * vr_51 && * vr_51 != vl_54 )
++ vr_51 ;
}
}
else
while ( * vr_51 && vr_57 -- )
{
while ( * vr_51 && fn_20 ( * vr_51 ) )
++ vr_51 ;
while ( * vr_51 && ! fn_20 ( * vr_51 ) )
++ vr_51 ;
}
return vr_51 ;
}
static void
fn_43 ( char * line , int vr_58 ,
char * * vr_59 , char * * vr_60 , char * * vr_61 )
{
char * vr_51 = line ;
* vr_59 = NULL ;
* vr_60 = NULL ;
* vr_61 = NULL ;
fn_1 ( lr_87 ,
fn_24 ( line ) , vr_58 ) ;
if ( vl_50 > 1 )
{
* vr_59 = line ;
vr_51 = fn_42 ( line , vl_50 - 1 ) ;
if ( * vr_51 == '\0' )
{
fn_1 ( lr_88 , fn_24 ( * vr_59 ) ) ;
return;
}
* vr_51 = '\0' ;
++ vr_51 ;
}
* vr_60 = vr_51 ;
* vr_61 = fn_42 ( * vr_60 , 1 ) ;
if ( * * vr_61 )
{
* * vr_61 = '\0' ;
++ ( * vr_61 ) ;
}
else
* vr_61 = NULL ;
fn_1 ( lr_89 ,
fn_19 ( 0 , * vr_59 ? * vr_59 : lr_2 ) ,
fn_19 ( 1 , * vr_60 ) ,
fn_19 ( 2 , * vr_61 ? * vr_61 : lr_2 ) ) ;
}
static int
fn_44 ( char * line , bool vr_62 )
{
char * vr_63 , * vr_64 , * vr_5 ;
long double vr_11 = 0 ;
tp_3 vr_23 = 0 ;
int vr_65 = 0 ;
fn_43 ( line , vl_50 , & vr_63 , & vr_64 , & vr_5 ) ;
if ( ! vr_64 )
if ( vl_25 != vl_26 )
error ( vl_27 , 0 , _ ( lr_90
lr_91 ) ,
vl_50 ) ;
if ( vr_64 )
{
vr_65 = fn_40 ( vr_64 , & vr_11 , & vr_23 ) ;
if ( vr_65 )
vr_65 = fn_37 ( vr_11 , vr_23 ) ;
}
if ( vr_63 )
fputs ( vr_63 , stdout ) ;
if ( vr_63 && vr_64 )
fputc ( ( vl_54 == vl_55 ) ? ' ' : vl_54 , stdout ) ;
if ( vr_65 )
{
fn_39 () ;
}
else
{
if ( vr_64 )
fputs ( vr_64 , stdout ) ;
}
if ( vr_5 )
{
fputc ( ( vl_54 == vl_55 ) ? ' ' : vl_54 , stdout ) ;
fputs ( vr_5 , stdout ) ;
}
if ( vr_62 )
putchar ( '\n' ) ;
return vr_65 ;
}
int
main ( int vr_66 , char * * vr_67 )
{
int vr_68 = 1 ;
fn_45 ( & vr_66 , & vr_67 ) ;
fn_46 ( vr_67 [ 0 ] ) ;
setlocale ( vl_56 , lr_2 ) ;
fn_47 ( vl_57 , vl_58 ) ;
fn_48 ( vl_57 ) ;
vl_20 = nl_langinfo ( vl_59 ) ;
if ( vl_20 == NULL || strlen ( vl_20 ) == 0 )
vl_20 = lr_92 ;
vl_21 = strlen ( vl_20 ) ;
atexit ( vl_60 ) ;
while ( true )
{
int vr_69 = fn_49 ( vr_66 , vr_67 , lr_93 , vl_61 , NULL ) ;
if ( vr_69 == - 1 )
break;
switch ( vr_69 )
{
case vl_62 :
vl_44 = fn_50 ( lr_94 , vl_63 ,
vl_64 , vl_65 ) ;
break;
case vl_66 :
vl_52 = fn_26 ( vl_63 ) ;
break;
case vl_67 :
vl_45 =
fn_50 ( lr_95 , vl_63 , vl_68 , vl_69 ) ;
break;
case vl_70 :
vl_53 = fn_26 ( vl_63 ) ;
break;
case vl_71 :
vl_46 = fn_50 ( lr_96 , vl_63 , vl_72 , vl_73 ) ;
break;
case vl_74 :
vl_36 = 1 ;
break;
case vl_75 :
if ( fn_51 ( vl_63 , NULL , 10 , & vl_41 , lr_2 ) != vl_29
|| vl_41 == 0 )
error ( vl_28 , 0 , _ ( lr_97 ) ,
fn_24 ( vl_63 ) ) ;
if ( vl_41 < 0 )
{
vl_39 = vl_40 ;
vl_41 = - vl_41 ;
}
break;
case vl_76 :
if ( fn_51 ( vl_63 , NULL , 10 , & vl_50 , lr_2 ) != vl_29
|| vl_50 <= 0 )
error ( vl_28 , 0 , _ ( lr_98 ) ,
fn_24 ( vl_63 ) ) ;
break;
case 'd' :
if ( vl_63 [ 0 ] != '\0' && vl_63 [ 1 ] != '\0' )
error ( vl_28 , 0 ,
_ ( lr_99 ) ) ;
vl_54 = vl_63 [ 0 ] ;
break;
case vl_77 :
vl_47 = vl_63 ;
break;
case vl_78 :
vl_51 = true ;
break;
case vl_79 :
vl_1 = true ;
vl_51 = true ;
break;
case vl_80 :
if ( vl_63 )
{
if ( fn_27 ( vl_63 , NULL , 10 , & vl_81 , lr_2 ) != vl_29
|| vl_81 == 0 )
error ( vl_28 , 0 , _ ( lr_100 ) ,
fn_24 ( vl_63 ) ) ;
}
else
{
vl_81 = 1 ;
}
break;
case vl_82 :
vl_83 = vl_63 ;
break;
case vl_84 :
vl_25 = fn_50 ( lr_101 , vl_63 , vl_85 , vl_86 ) ;
break;
vl_87 ;
fn_52 ( vl_88 , vl_89 ) ;
default:
fn_29 ( vl_28 ) ;
}
}
if ( vl_83 != NULL && vl_36 )
error ( vl_28 , 0 , _ ( lr_102 ) ) ;
if ( vl_83 != NULL && vl_41 > 0 )
error ( vl_28 , 0 , _ ( lr_103 ) ) ;
if ( vl_51 && vl_44 == vl_5 && vl_45 == vl_5
&& ! vl_36 && ( vl_41 == 0 ) && ( vl_83 == NULL ) )
error ( 0 , 0 , _ ( lr_104 ) ) ;
if ( vl_83 )
fn_33 ( vl_83 ) ;
if ( vl_36 )
{
if ( vl_45 != vl_5 )
error ( vl_28 , 0 , _ ( lr_105 ) ) ;
if ( vl_51 && ( strlen ( nl_langinfo ( vl_90 ) ) == 0 ) )
error ( 0 , 0 , _ ( lr_106 ) ) ;
}
fn_28 ( vl_41 ) ; MST[@!ABS$@$]MSP[N]
vl_49 = ( vl_41 == 0 && vl_54 == vl_55 ) ;
if ( vl_25 != vl_91 )
vl_27 = 0 ;
if ( vr_66 > vl_92 )
{
if ( vl_51 && vl_81 )
error ( 0 , 0 , _ ( lr_107 ) ) ;
for (; vl_92 < vr_66 ; vl_92 ++ )
vr_68 &= fn_44 ( vr_67 [ vl_92 ] , true ) ;
}
else
{
char * line = NULL ;
tp_3 vr_70 = 0 ;
tp_7 vr_71 ;
while ( vl_81 -- && fn_53 ( & line , & vr_70 , vl_93 ) > 0 )
fputs ( line , stdout ) ;
while ( ( vr_71 = fn_53 ( & line , & vr_70 , vl_93 ) ) > 0 )
{
bool vr_62 = line [ vr_71 - 1 ] == '\n' ;
if ( vr_62 )
line [ vr_71 - 1 ] = '\0' ;
vr_68 &= fn_44 ( line , vr_62 ) ;
}
fn_54 ( free ( line ) ) ;
if ( ferror ( vl_93 ) )
error ( 0 , vl_37 , _ ( lr_108 ) ) ;
}
free ( vl_31 ) ;
free ( vl_42 ) ;
free ( vl_43 ) ;
if ( vl_51 && ! vr_68 )
error ( 0 , 0 , _ ( lr_109 ) ) ;
int vr_72 = vl_32 ;
if ( ! vr_68 && vl_25 != vl_94 && vl_25 != vl_26 )
vr_72 = vl_95 ;
exit ( vr_72 ) ;
}
