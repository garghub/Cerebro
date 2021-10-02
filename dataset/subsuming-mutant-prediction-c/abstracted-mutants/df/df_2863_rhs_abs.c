static char *
fn_1 ( char * vr_1 )
{
char * vr_2 = vr_1 ;
while ( * vr_2 )
{
if ( iscntrl ( fn_2 ( * vr_2 ) ) )
* vr_2 = '?' ;
vr_2 ++ ;
}
return vr_1 ;
}
static void
fn_3 ( void )
{
vl_1 ++ ;
vl_2 = fn_4 ( vl_2 , vl_1 , sizeof ( char * ) ) ;
vl_2 [ vl_1 - 1 ] = fn_5 ( vl_3 , sizeof ( char * ) ) ;
}
static void
fn_6 ( void )
{
tp_1 vr_3 ;
for ( vr_3 = 0 ; vr_3 < vl_1 ; vr_3 ++ )
{
tp_1 vr_4 ;
for ( vr_4 = 0 ; vr_4 < vl_3 ; vr_4 ++ )
{
char * vr_1 = vl_2 [ vr_3 ] [ vr_4 ] ;
if ( vr_4 != 0 )
putchar ( ' ' ) ;
int vr_5 = 0 ;
if ( vr_4 == vl_3 - 1 )
vr_5 = vl_4 ;
tp_1 vr_6 = vr_7 [ vr_4 ] -> vr_6 ;
vr_1 = fn_7 ( vr_1 , & vr_6 , vr_7 [ vr_4 ] -> vl_5 , vr_5 ) ;
fputs ( vr_1 ? vr_1 : vl_2 [ vr_3 ] [ vr_4 ] , stdout ) ;
free ( vr_1 ) ;
fn_8 ( free ( vl_2 [ vr_3 ] [ vr_4 ] ) ) ;
}
putchar ( '\n' ) ;
fn_8 ( free ( vl_2 [ vr_3 ] ) ) ;
}
fn_8 ( free ( vl_2 ) ) ;
}
static void
fn_9 ( int vr_8 , const char * vr_9 )
{
vl_3 ++ ;
vr_7 = fn_4 ( vr_7 , vl_3 , sizeof ( struct vl_6 * ) ) ;
vr_7 [ vl_3 - 1 ] = & vr_10 [ vr_8 ] ;
if ( vr_9 != NULL )
vr_7 [ vl_3 - 1 ] -> vl_7 = vr_9 ;
if ( vr_10 [ vr_8 ] . vl_8 )
assert ( ! lr_1 ) ;
vr_10 [ vr_8 ] . vl_8 = true ;
}
static void
fn_10 ( char const * vr_11 )
{
char * vr_12 = fn_11 ( vr_11 ) ;
char * vr_13 = vr_12 ;
do
{
char * vr_14 = strchr ( vr_13 , ',' ) ;
if ( vr_14 )
* vr_14 ++ = 0 ;
tp_2 vr_15 = - 1 ;
unsigned int vr_16 ;
for ( vr_16 = 0 ; vr_16 < fn_12 ( vr_10 ) ; vr_16 ++ )
{
if ( fn_13 ( vr_10 [ vr_16 ] . vr_11 , vr_13 ) )
{
vr_15 = vr_16 ;
break;
}
}
if ( vr_15 == - 1 )
{
error ( 0 , 0 , _ ( lr_2 ) , fn_14 ( vr_13 ) ) ;
fn_15 ( vl_9 ) ;
}
if ( vr_10 [ vr_15 ] . vl_8 )
{
error ( 0 , 0 , _ ( lr_3 ) ,
fn_14 ( vr_10 [ vr_15 ] . vr_11 ) ) ;
fn_15 ( vl_9 ) ;
}
switch ( vr_15 )
{
case vl_10 :
case vl_11 :
case vl_12 :
case vl_13 :
case vl_14 :
case vl_15 :
case vl_16 :
case vl_17 :
case vl_18 :
case vl_19 :
fn_9 ( vr_15 , NULL ) ;
break;
case vl_20 :
fn_9 ( vr_15 , fn_16 ( lr_4 ) ) ;
break;
case vl_21 :
fn_9 ( vr_15 , fn_16 ( lr_5 ) ) ;
break;
default:
assert ( ! lr_6 ) ;
}
vr_13 = vr_14 ;
}
while ( vr_13 );
free ( vr_12 ) ;
}
static void
fn_17 ( void )
{
switch ( vl_22 )
{
case vl_23 :
fn_9 ( vl_10 , NULL ) ;
if ( vl_24 )
fn_9 ( vl_11 , NULL ) ;
fn_9 ( vl_20 , NULL ) ;
fn_9 ( vl_12 , NULL ) ;
fn_9 ( vl_21 , NULL ) ;
fn_9 ( vl_13 , NULL ) ;
fn_9 ( vl_18 , NULL ) ;
break;
case vl_25 :
fn_9 ( vl_10 , NULL ) ;
if ( vl_24 )
fn_9 ( vl_11 , NULL ) ;
fn_9 ( vl_20 , fn_16 ( lr_4 ) ) ;
fn_9 ( vl_12 , NULL ) ;
fn_9 ( vl_21 , fn_16 ( lr_5 ) ) ;
fn_9 ( vl_13 , NULL ) ;
fn_9 ( vl_18 , NULL ) ;
break;
case vl_26 :
fn_9 ( vl_10 , NULL ) ;
if ( vl_24 )
fn_9 ( vl_11 , NULL ) ;
fn_9 ( vl_14 , NULL ) ;
fn_9 ( vl_15 , NULL ) ;
fn_9 ( vl_16 , NULL ) ;
fn_9 ( vl_17 , NULL ) ;
fn_9 ( vl_18 , NULL ) ;
break;
case vl_27 :
fn_9 ( vl_10 , NULL ) ;
if ( vl_24 )
fn_9 ( vl_11 , NULL ) ;
fn_9 ( vl_20 , NULL ) ;
fn_9 ( vl_12 , NULL ) ;
fn_9 ( vl_21 , NULL ) ;
fn_9 ( vl_13 , fn_16 ( lr_7 ) ) ;
fn_9 ( vl_18 , NULL ) ;
break;
case vl_28 :
if ( ! vl_3 )
{
fn_10 ( vl_29 ) ;
}
break;
default:
assert ( ! lr_8 ) ;
}
}
static void
fn_18 ( void )
{
tp_1 vr_4 ;
fn_3 () ;
for ( vr_4 = 0 ; vr_4 < vl_3 ; vr_4 ++ )
{
char * vr_1 = NULL ;
char const * vr_17 = _ ( vr_7 [ vr_4 ] -> vl_7 ) ;
if ( vr_7 [ vr_4 ] -> vr_15 == vl_20
&& ( vl_22 == vl_23
|| ( vl_22 == vl_28
&& ! ( vl_30 & vl_31 ) ) ) )
{
char vr_18 [ vl_32 + 1 ] ;
int vr_19 = ( vl_33
| vl_31 | vl_34
| ( vl_30
& ( vl_35 | vl_36 | vl_37 ) ) ) ;
tp_3 vr_20 = vl_38 ;
tp_3 vr_21 = vl_38 ;
bool vr_22 ;
bool vr_23 ;
do
{
vr_22 = vr_20 % 1000 == 0 ; vr_20 /= 1000 ;
vr_23 = vr_21 % 1024 == 0 ; vr_21 /= 1024 ;
}
while ( vr_22 & vr_23 );
if ( vr_22 < vr_23 )
vr_19 |= vl_36 ;
if ( vr_23 < vr_22 )
vr_19 &= ~ vl_36 ;
if ( ! ( vr_19 & vl_36 ) )
vr_19 |= vl_37 ;
char * vr_24 = fn_19 ( vl_38 , vr_18 , vr_19 , 1 , 1 ) ;
vr_17 = _ ( lr_9 ) ;
if ( fn_20 ( & vr_1 , _ ( lr_10 ) , vr_24 , vr_17 ) == - 1 )
vr_1 = NULL ;
}
else if ( vl_22 == vl_27 && vr_7 [ vr_4 ] -> vr_15 == vl_20 )
{
char vr_18 [ fn_21 ( tp_3 ) ] ;
char * vr_24 = fn_22 ( vl_38 , vr_18 ) ;
if ( fn_20 ( & vr_1 , _ ( lr_10 ) , vr_24 , vr_17 ) == - 1 )
vr_1 = NULL ;
}
else
vr_1 = fn_23 ( vr_17 ) ;
if ( ! vr_1 )
fn_24 () ;
fn_1 ( vr_1 ) ;
vl_2 [ vl_1 - 1 ] [ vr_4 ] = vr_1 ;
vr_7 [ vr_4 ] -> vr_6 = fn_25 ( vr_7 [ vr_4 ] -> vr_6 , fn_26 ( vr_1 , 0 ) ) ;
}
}
static bool tp_4
fn_27 ( const char * vr_25 )
{
const struct vr_26 * vr_27 ;
if ( vl_39 == NULL || vr_25 == NULL )
return true ;
for ( vr_27 = vl_39 ; vr_27 ; vr_27 = vr_27 -> vr_28 )
if ( fn_13 ( vr_25 , vr_27 -> vr_29 ) )
return true ;
return false ;
}
static bool tp_4
fn_28 ( const char * vr_25 )
{
const struct vr_26 * vr_27 ;
if ( vl_40 == NULL || vr_25 == NULL )
return false ;
for ( vr_27 = vl_40 ; vr_27 ; vr_27 = vr_27 -> vr_28 )
if ( fn_13 ( vr_25 , vr_27 -> vr_29 ) )
return true ;
return false ;
}
static void
fn_29 ( void )
{
struct vr_30 * vr_31 ;
struct vr_32 * vr_33 = NULL ;
for ( vr_31 = vl_41 ; vr_31 ; )
{
struct vr_34 vr_18 ;
struct vr_32 * vr_32 ;
struct vr_30 * vr_35 = NULL ;
if ( - 1 == vr_34 ( vr_31 -> vr_36 , & vr_18 ) )
{
vr_18 . vr_37 = vr_31 -> vr_38 ;
}
else
{
if ( strchr ( vr_31 -> vr_39 , '/' ) )
{
for ( vr_32 = vr_33 ; vr_32 ; vr_32 = vr_32 -> vr_40 )
if ( vr_32 -> vr_41 == vr_18 . vr_37 )
break;
if ( vr_32 )
{
vr_35 = vr_31 ;
if ( ! strchr ( vr_32 -> vr_31 -> vr_39 , '/' )
|| ( strlen ( vr_32 -> vr_31 -> vr_36 )
> strlen ( vr_31 -> vr_36 ) ) )
{
vr_35 = vr_32 -> vr_31 ;
vr_32 -> vr_31 = vr_31 ;
}
}
}
}
if ( vr_35 )
{
vr_31 = vr_31 -> vr_42 ;
fn_30 ( vr_35 ) ;
}
else
{
vr_32 = xmalloc ( sizeof *vr_32 ) ;
vr_32 -> vr_31 = vr_31 ;
vr_32 -> vr_41 = vr_18 . vr_37 ;
vr_32 -> vr_40 = vr_33 ;
vr_33 = vr_32 ;
vr_31 = vr_31 -> vr_42 ;
}
}
vl_41 = NULL ;
while ( vr_33 )
{
vr_31 = vr_33 -> vr_31 ;
vr_31 -> vr_42 = vl_41 ;
vl_41 = vr_31 ;
struct vr_32 * vr_32 = vr_33 -> vr_40 ;
free ( vr_33 ) ;
vr_33 = vr_32 ;
}
}
static bool
fn_31 ( tp_3 vr_43 )
{
return vr_43 < vl_42 - 1 ;
}
static char const *
fn_32 ( bool vr_44 , tp_3 vr_43 , char * vr_18 ,
tp_3 vr_45 , tp_3 vr_46 )
{
if ( ! fn_31 ( vr_43 ) && ! vr_44 )
return lr_11 ;
else
{
char * vr_2 = fn_19 ( vr_44 ? - vr_43 : vr_43 , vr_18 + vr_44 ,
vl_30 , vr_45 , vr_46 ) ;
if ( vr_44 )
* -- vr_2 = '-' ;
return vr_2 ;
}
}
static void
fn_33 ( tp_3 * vr_47 , bool * vr_48 ,
tp_3 vr_49 , bool vr_50 )
{
if ( fn_34 ( * vr_48 , vr_50 ) )
{
* vr_47 += vr_49 ;
return;
}
if ( * vr_48 )
* vr_47 = - * vr_47 ;
if ( vr_50 )
vr_49 = - vr_49 ;
if ( vr_49 < * vr_47 )
* vr_47 -= vr_49 ;
else
{
* vr_47 = vr_49 - * vr_47 ;
* vr_48 = vr_50 ;
}
if ( * vr_48 )
* vr_47 = - * vr_47 ;
}
static bool tp_4
fn_35 ( char const * vr_13 )
{
tp_1 vr_51 = strlen ( vr_13 ) ;
return ( 36 < vr_51
&& strspn ( vr_13 + vr_51 - 36 , lr_12 ) == 36 ) ;
}
static void
fn_36 ( struct vr_52 * vr_53 ,
struct vr_52 * vr_54 ,
const struct vr_55 * vr_56 )
{
vr_54 -> vr_45 = vr_54 -> vr_46 = 1 ;
vr_54 -> vr_57 = vr_56 -> vr_58 ;
vr_54 -> vr_59 = vr_54 -> vr_60 = vr_56 -> vr_61 ;
vr_54 -> vr_62 = false ;
vr_54 -> vl_8 = vl_42 ;
vr_54 -> vr_63 = false ;
if ( fn_31 ( vr_54 -> vr_57 ) && fn_31 ( vr_54 -> vr_60 ) )
{
vr_54 -> vl_8 = vr_54 -> vr_57 - vr_54 -> vr_60 ;
vr_54 -> vr_63 = ( vr_54 -> vr_57 < vr_54 -> vr_60 ) ;
}
vr_53 -> vr_45 = vr_56 -> vr_64 ;
vr_53 -> vr_46 = vl_38 ;
vr_53 -> vr_57 = vr_56 -> vr_65 ;
vr_53 -> vr_59 = vr_56 -> vr_66 ;
vr_53 -> vr_60 = vr_56 -> vr_67 ;
vr_53 -> vr_62 = ( vr_56 -> vr_68
&& fn_31 ( vr_56 -> vr_66 ) ) ;
vr_53 -> vl_8 = vl_42 ;
vr_53 -> vr_63 = false ;
if ( fn_31 ( vr_53 -> vr_57 ) && fn_31 ( vr_53 -> vr_60 ) )
{
vr_53 -> vl_8 = vr_53 -> vr_57 - vr_53 -> vr_60 ;
vr_53 -> vr_63 = ( vr_53 -> vr_57 < vr_53 -> vr_60 ) ;
}
}
static void
fn_37 ( struct vr_52 * vr_53 , struct vr_52 * vr_54 )
{
if ( fn_31 ( vr_54 -> vr_57 ) )
vr_69 . vr_58 += vr_54 -> vr_57 ;
if ( fn_31 ( vr_54 -> vr_59 ) )
vr_69 . vr_61 += vr_54 -> vr_59 ;
if ( fn_31 ( vr_53 -> vr_57 ) )
vr_69 . vr_65 += vr_53 -> vr_45 * vr_53 -> vr_57 ;
if ( fn_31 ( vr_53 -> vr_60 ) )
vr_69 . vr_67 += vr_53 -> vr_45 * vr_53 -> vr_60 ;
if ( fn_31 ( vr_53 -> vr_59 ) )
fn_33 ( & vr_69 . vr_66 ,
& vr_69 . vr_68 ,
vr_53 -> vr_45 * vr_53 -> vr_59 ,
vr_53 -> vr_62 ) ;
}
static void
fn_38 ( char const * vr_70 , char const * vr_71 , char const * vr_72 ,
char const * vr_73 , char const * vr_25 ,
bool vr_74 , bool vr_75 ,
const struct vr_55 * vr_76 ,
bool vr_77 )
{
if ( vr_75 && vl_43 )
return;
if ( vr_74 && ! vl_44 && ! vl_45 )
return;
if ( ! fn_27 ( vr_25 ) || fn_28 ( vr_25 ) )
return;
if ( ! vr_73 )
vr_73 = vr_71 ? vr_71 : vr_70 ;
struct vr_55 vr_56 ;
if ( vr_76 )
vr_56 = * vr_76 ;
else if ( fn_39 ( vr_73 , vr_70 , & vr_56 ) )
{
error ( 0 , vl_46 , lr_13 , fn_14 ( vr_73 ) ) ;
vl_47 = vl_9 ;
return;
}
if ( vr_56 . vr_65 == 0 && ! vl_44 && ! vl_45 )
return;
if ( ! vr_76 )
vl_48 = true ;
fn_3 () ;
if ( ! vr_70 )
vr_70 = lr_11 ;
if ( ! vr_72 )
vr_72 = lr_11 ;
char * vr_78 = fn_11 ( vr_70 ) ;
char * vr_79 ;
if ( vr_77
&& fn_35 ( vr_78 )
&& ( vr_79 = fn_40 ( vr_78 , vl_49 ) ) )
{
free ( vr_78 ) ;
vr_78 = vr_79 ;
}
if ( ! vr_25 )
vr_25 = lr_11 ;
struct vr_52 vr_80 ;
struct vr_52 vr_81 ;
fn_36 ( & vr_80 , & vr_81 , & vr_56 ) ;
if ( vl_50 && ! vr_76 )
fn_37 ( & vr_80 , & vr_81 ) ;
tp_1 vr_4 ;
for ( vr_4 = 0 ; vr_4 < vl_3 ; vr_4 ++ )
{
char vr_18 [ vl_32 + 2 ] ;
char * vr_1 ;
struct vr_52 * vr_82 ;
switch ( vr_7 [ vr_4 ] -> vl_51 )
{
case vl_52 :
vr_82 = & vr_80 ;
break;
case vl_53 :
vr_82 = & vr_81 ;
break;
case vl_54 :
vr_82 = NULL ;
break;
default:
assert ( ! lr_14 ) ;
}
switch ( vr_7 [ vr_4 ] -> vr_15 )
{
case vl_10 :
vr_1 = fn_11 ( vr_78 ) ;
break;
case vl_11 :
vr_1 = fn_11 ( vr_25 ) ;
break;
case vl_20 :
case vl_14 :
vr_1 = fn_11 ( fn_32 ( false , vr_82 -> vr_57 , vr_18 ,
vr_82 -> vr_45 , vr_82 -> vr_46 ) ) ;
break;
case vl_12 :
case vl_15 :
vr_1 = fn_11 ( fn_32 ( vr_82 -> vr_63 , vr_82 -> vl_8 , vr_18 ,
vr_82 -> vr_45 , vr_82 -> vr_46 ) ) ;
break;
case vl_21 :
case vl_16 :
vr_1 = fn_11 ( fn_32 ( vr_82 -> vr_62 , vr_82 -> vr_59 , vr_18 ,
vr_82 -> vr_45 , vr_82 -> vr_46 ) ) ;
break;
case vl_13 :
case vl_17 :
{
double vr_83 = - 1 ;
if ( ! fn_31 ( vr_82 -> vl_8 ) || ! fn_31 ( vr_82 -> vr_59 ) )
;
else if ( ! vr_82 -> vr_63
&& vr_82 -> vl_8 <= fn_41 ( tp_3 ) / 100
&& vr_82 -> vl_8 + vr_82 -> vr_59 != 0
&& ( vr_82 -> vl_8 + vr_82 -> vr_59 < vr_82 -> vl_8 )
== vr_82 -> vr_62 )
{
tp_3 vr_84 = vr_82 -> vl_8 * 100 ;
tp_3 vr_85 = vr_82 -> vl_8 + vr_82 -> vr_59 ;
vr_83 = vr_84 / vr_85 + ( vr_84 % vr_85 != 0 ) ;
}
else
{
double vr_86 = vr_82 -> vr_63 ? - ( double ) - vr_82 -> vl_8 : vr_82 -> vl_8 ;
double vr_87 = vr_82 -> vr_62
? - ( double ) - vr_82 -> vr_59 : vr_82 -> vr_59 ;
double vr_85 = vr_86 + vr_87 ;
if ( vr_85 )
{
long int vr_88 = vr_83 = vr_86 * 100 / vr_85 ;
double vr_89 = vr_88 ;
if ( vr_89 - 1 < vr_83 && vr_83 <= vr_89 + 1 )
vr_83 = vr_89 + ( vr_89 < vr_83 ) ;
}
}
if ( 0 <= vr_83 )
{
if ( fn_20 ( & vr_1 , lr_15 , vr_83 ) == - 1 )
vr_1 = NULL ;
}
else
vr_1 = fn_23 ( lr_11 ) ;
if ( ! vr_1 )
fn_24 () ;
break;
}
case vl_19 :
vr_1 = fn_11 ( vr_72 ) ;
break;
case vl_18 :
#ifdef vr_90
if ( fn_42 ( vr_71 , lr_16 ) == 0 )
vr_71 += 5 ;
else if ( fn_42 ( vr_71 , lr_17 ) == 0 )
vr_71 += 8 ;
#endif
vr_1 = fn_11 ( vr_71 ) ;
break;
default:
assert ( ! lr_18 ) ;
}
if ( ! vr_1 )
assert ( ! lr_19 ) ;
fn_1 ( vr_1 ) ;
vr_7 [ vr_4 ] -> vr_6 = fn_25 ( vr_7 [ vr_4 ] -> vr_6 , fn_26 ( vr_1 , 0 ) ) ;
vl_2 [ vl_1 - 1 ] [ vr_4 ] = vr_1 ;
}
free ( vr_78 ) ;
}
static bool
fn_43 ( char const * vr_70 )
{
struct vr_30 const * vr_31 ;
struct vr_30 const * vr_91 = NULL ;
char const * vr_72 = vr_70 ;
char * vr_92 = fn_44 ( vr_70 ) ;
if ( vr_92 && vr_92 [ 0 ] == '/' )
vr_70 = vr_92 ;
tp_1 vr_93 = vl_55 ;
for ( vr_31 = vl_41 ; vr_31 ; vr_31 = vr_31 -> vr_42 )
{
if ( fn_13 ( vr_70 , vr_31 -> vr_39 ) )
{
tp_1 vr_51 = strlen ( vr_31 -> vr_36 ) ;
if ( vr_51 < vr_93 )
{
vr_91 = vr_31 ;
if ( vr_51 == 1 )
break;
else
vr_93 = vr_51 ;
}
}
}
free ( vr_92 ) ;
if ( vr_91 )
{
fn_38 ( vr_91 -> vr_39 , vr_91 -> vr_36 , vr_72 , NULL ,
vr_91 -> vr_94 , vr_91 -> vr_74 ,
vr_91 -> vr_75 , NULL , false ) ;
return true ;
}
return false ;
}
static void
fn_45 ( const char * vr_95 , const struct vr_34 * vr_96 )
{
struct vr_34 vr_97 ;
struct vr_30 * vr_31 ;
struct vr_30 const * vr_91 = NULL ;
char * vr_92 = fn_44 ( vr_95 ) ;
if ( vr_92 && vr_92 [ 0 ] == '/' )
{
tp_1 vr_98 = strlen ( vr_92 ) ;
tp_1 vr_93 = 0 ;
for ( vr_31 = vl_41 ; vr_31 ; vr_31 = vr_31 -> vr_42 )
{
if ( ! fn_13 ( vr_31 -> vr_94 , lr_20 )
&& ( ! vr_91 || vr_91 -> vr_74 || ! vr_31 -> vr_74 ) )
{
tp_1 vr_51 = strlen ( vr_31 -> vr_36 ) ;
if ( vr_93 <= vr_51 && vr_51 <= vr_98
&& ( vr_51 == 1
|| ( ( vr_51 == vr_98 || vr_92 [ vr_51 ] == '/' )
&& fn_46 ( vr_31 -> vr_36 , vr_92 , vr_51 ) ) ) )
{
vr_91 = vr_31 ;
vr_93 = vr_51 ;
}
}
}
}
free ( vr_92 ) ;
if ( vr_91
&& ( vr_34 ( vr_91 -> vr_36 , & vr_97 ) != 0
|| vr_97 . vr_37 != vr_96 -> vr_37 ) )
vr_91 = NULL ;
if ( ! vr_91 )
for ( vr_31 = vl_41 ; vr_31 ; vr_31 = vr_31 -> vr_42 )
{
if ( vr_31 -> vr_38 == ( vl_56 ) - 1 )
{
if ( vr_34 ( vr_31 -> vr_36 , & vr_97 ) == 0 )
vr_31 -> vr_38 = vr_97 . vr_37 ;
else
{
if ( vl_46 == vl_57 )
{
error ( 0 , vl_46 , lr_13 , fn_14 ( vr_31 -> vr_36 ) ) ;
vl_47 = vl_9 ;
}
vr_31 -> vr_38 = ( vl_56 ) - 2 ;
}
}
if ( vr_96 -> vr_37 == vr_31 -> vr_38
&& ! fn_13 ( vr_31 -> vr_94 , lr_20 )
&& ( ! vr_91 || vr_91 -> vr_74 || ! vr_31 -> vr_74 ) )
{
if ( vr_34 ( vr_31 -> vr_36 , & vr_97 ) != 0
|| vr_97 . vr_37 != vr_31 -> vr_38 )
vr_31 -> vr_38 = ( vl_56 ) - 2 ;
else
vr_91 = vr_31 ;
}
}
if ( vr_91 )
fn_38 ( vr_91 -> vr_39 , vr_91 -> vr_36 , vr_95 , vr_95 ,
vr_91 -> vr_94 , vr_91 -> vr_74 , vr_91 -> vr_75 ,
NULL , false ) ;
else
{
char * vr_99 = fn_47 ( vr_95 , vr_96 ) ;
if ( vr_99 )
{
fn_38 ( NULL , vr_99 , vr_95 , NULL , NULL , false , false , NULL , false ) ;
free ( vr_99 ) ;
}
}
}
static void
fn_48 ( char const * vr_100 , struct vr_34 const * vr_96 )
{
if ( ( fn_49 ( vr_96 -> vr_101 ) || fn_50 ( vr_96 -> vr_101 ) )
&& fn_43 ( vr_100 ) )
return;
fn_45 ( vr_100 , vr_96 ) ;
}
static void
fn_51 ( void )
{
struct vr_30 * vr_31 ;
if ( ! vl_44 )
fn_29 () ;
for ( vr_31 = vl_41 ; vr_31 ; vr_31 = vr_31 -> vr_42 )
fn_38 ( vr_31 -> vr_39 , vr_31 -> vr_36 , NULL , NULL , vr_31 -> vr_94 ,
vr_31 -> vr_74 , vr_31 -> vr_75 , NULL , true ) ;
}
static void
fn_52 ( const char * vr_25 )
{
struct vr_26 * vr_27 ;
vr_27 = xmalloc ( sizeof *vr_27 ) ;
vr_27 -> vr_29 = ( char * ) vr_25 ;
vr_27 -> vr_28 = vl_39 ;
vl_39 = vr_27 ;
}
static void
fn_53 ( const char * vr_25 )
{
struct vr_26 * vr_27 ;
vr_27 = xmalloc ( sizeof *vr_27 ) ;
vr_27 -> vr_29 = ( char * ) vr_25 ;
vr_27 -> vr_28 = vl_40 ;
vl_40 = vr_27 ;
}
void
fn_15 ( int vr_102 )
{
if ( vr_102 != vl_58 )
fn_54 () ;
else
{
printf ( _ ( lr_21 ) , vl_59 ) ;
fputs ( _ ( lr_22 ) , stdout ) ;
fn_55 () ;
fputs ( _ ( lr_23 ) , stdout ) ;
fputs ( _ ( lr_24 ) , stdout ) ;
fputs ( _ ( lr_25 ) , stdout ) ;
fputs ( vl_60 , stdout ) ;
fputs ( vl_61 , stdout ) ;
fn_56 ( lr_26 ) ;
fn_57 () ;
fputs ( _ ( lr_27 ) , stdout ) ;
fn_58 () ;
}
exit ( vr_102 ) ;
}
int
main ( int vr_103 , char * * vr_104 )
{
struct vr_34 * tp_5 fn_8 ( = 0 ) ;
fn_59 ( & vr_103 , & vr_104 ) ;
fn_60 ( vr_104 [ 0 ] ) ;
setlocale ( vl_62 , lr_28 ) ;
fn_61 ( vl_63 , vl_64 ) ;
fn_62 ( vl_63 ) ;
atexit ( vl_65 ) ;
vl_39 = NULL ;
vl_40 = NULL ;
vl_44 = false ;
vl_45 = false ;
vl_30 = - 1 ;
vl_24 = false ;
vl_48 = false ;
vl_47 = vl_58 ;
vl_50 = false ;
vr_69 . vr_64 = 1 ;
bool vr_105 = false ;
const char * vr_106 = _ ( lr_29 ) ;
while ( true )
{
int vr_107 = - 1 ;
int vr_9 = fn_63 ( vr_103 , vr_104 , lr_30 , vl_66 ,
& vr_107 ) ;
if ( vr_9 == - 1 )
break;
switch ( vr_9 )
{
case 'a' :
vl_44 = true ;
break;
case 'B' :
{
enum vr_108 vr_109 = fn_64 ( vl_67 , & vl_30 ,
& vl_38 ) ;
if ( vr_109 != vl_68 )
fn_65 ( vr_109 , vr_107 , vr_9 , vl_66 , vl_67 ) ;
}
break;
case 'i' :
if ( vl_22 == vl_28 )
{
error ( 0 , 0 , vr_106 , lr_31 , lr_32 ) ;
fn_15 ( vl_9 ) ;
}
vl_22 = vl_26 ;
break;
case 'h' :
vl_30 = vl_31 | vl_34 | vl_36 ;
vl_38 = 1 ;
break;
case 'H' :
vl_30 = vl_31 | vl_34 ;
vl_38 = 1 ;
break;
case 'k' :
vl_30 = 0 ;
vl_38 = 1024 ;
break;
case 'l' :
vl_43 = true ;
break;
case 'm' :
vl_30 = 0 ;
vl_38 = 1024 * 1024 ;
break;
case 'T' :
if ( vl_22 == vl_28 )
{
error ( 0 , 0 , vr_106 , lr_33 , lr_32 ) ;
fn_15 ( vl_9 ) ;
}
vl_24 = true ;
break;
case 'P' :
if ( vl_22 == vl_28 )
{
error ( 0 , 0 , vr_106 , lr_34 , lr_32 ) ;
fn_15 ( vl_9 ) ;
}
vr_105 = true ;
break;
case vl_69 :
vl_70 = true ;
break;
case vl_71 :
vl_70 = false ;
break;
case 'F' :
case 't' :
fn_52 ( vl_67 ) ;
break;
case 'v' :
break;
case 'x' :
fn_53 ( vl_67 ) ;
break;
case vl_72 :
if ( vl_22 == vl_26 )
{
error ( 0 , 0 , vr_106 , lr_31 , lr_32 ) ;
fn_15 ( vl_9 ) ;
}
if ( vr_105 && vl_22 == vl_23 )
{
error ( 0 , 0 , vr_106 , lr_34 , lr_32 ) ;
fn_15 ( vl_9 ) ;
}
if ( vl_24 )
{
error ( 0 , 0 , vr_106 , lr_33 , lr_32 ) ;
fn_15 ( vl_9 ) ;
}
vl_22 = vl_28 ;
if ( vl_67 )
fn_10 ( vl_67 ) ;
break;
case vl_73 :
vl_50 = true ;
break;
vl_74 ;
fn_66 ( vl_75 , vl_76 ) ;
default:
fn_15 ( vl_9 ) ;
}
}
if ( vl_30 == - 1 )
{
if ( vr_105 )
{
vl_30 = 0 ;
vl_38 = ( getenv ( lr_35 ) ? 512 : 1024 ) ;
}
else
fn_64 ( getenv ( lr_36 ) ,
& vl_30 , & vl_38 ) ;
}
if ( vl_22 == vl_26 || vl_22 == vl_28 )
;
else if ( vl_30 & vl_31 )
vl_22 = vl_25 ;
else if ( vr_105 )
vl_22 = vl_27 ;
{
bool vr_110 = false ;
struct vr_26 * vr_111 ;
for ( vr_111 = vl_39 ; vr_111 ; vr_111 = vr_111 -> vr_28 )
{
struct vr_26 * vr_112 ;
for ( vr_112 = vl_40 ; vr_112 ; vr_112 = vr_112 -> vr_28 )
{
if ( fn_13 ( vr_111 -> vr_29 , vr_112 -> vr_29 ) )
{
error ( 0 , 0 ,
_ ( lr_37 ) ,
fn_14 ( vr_111 -> vr_29 ) ) ;
vr_110 = true ;
break;
}
}
}
if ( vr_110 )
exit ( vl_9 ) ;
}
if ( vl_77 < vr_103 )
{
int vr_16 ;
tp_5 = fn_5 ( vr_103 - vl_77 , sizeof *tp_5 ) ;
for ( vr_16 = vl_77 ; vr_16 < vr_103 ; ++ vr_16 )
{
int vr_113 = fn_67 ( vr_104 [ vr_16 ] , vl_78 | vl_79 ) ;
if ( ( vr_113 < 0 || fn_68 ( vr_113 , & tp_5 [ vr_16 - vl_77 ] ) )
&& vr_34 ( vr_104 [ vr_16 ] , & tp_5 [ vr_16 - vl_77 ] ) )
{
error ( 0 , vl_46 , lr_13 , fn_14 ( vr_104 [ vr_16 ] ) ) ;
vl_47 = vl_9 ;
vr_104 [ vr_16 ] = NULL ;
}
if ( 0 <= vr_113 )
fn_69 ( vr_113 ) ;
}
}
vl_41 =
fn_70 ( ( vl_39 != NULL
|| vl_40 != NULL
|| vl_24
|| vr_10 [ vl_11 ] . vl_8
|| vl_43 ) ) ;
if ( vl_41 == NULL )
{
int vr_102 = 0 ;
if ( ! ( vl_77 < vr_103 )
|| ( vl_44
|| vl_43
|| vl_39 != NULL
|| vl_40 != NULL ) )
{
vr_102 = vl_9 ;
}
const char * vr_114 = ( vr_102 == 0 ? _ ( lr_38 ) : lr_28 ) ;
error ( vr_102 , vl_46 , lr_39 , vr_114 ,
_ ( lr_40 ) ) ;
}
if ( vl_70 )
fn_71 () ;
fn_17 () ;
fn_18 () ;
if ( vl_77 < vr_103 )
{
int vr_16 ;
vl_45 = true ;
for ( vr_16 = vl_77 ; vr_16 < vr_103 ; ++ vr_16 )
if ( vr_104 [ vr_16 ] )
fn_48 ( vr_104 [ vr_16 ] , & tp_5 [ vr_16 - vl_77 ] ) ; MST[P!PRIGHTINC$P$]MSP[N]
}
else
fn_51 () ;
if ( vl_48 )
{
if ( vl_50 )
fn_38 ( lr_41 ,
( vr_10 [ vl_10 ] . vl_8 ? lr_11 : lr_41 ) ,
NULL , NULL , NULL , false , false , & vr_69 , false ) ;
fn_6 () ;
}
else
{
if ( vl_47 == vl_58 )
error ( vl_9 , 0 , _ ( lr_42 ) ) ;
}
fn_8 ( free ( vr_7 ) ) ;
exit ( vl_47 ) ;
}
