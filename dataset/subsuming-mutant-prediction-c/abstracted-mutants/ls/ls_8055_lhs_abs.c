static void
fn_1 ( tp_1 vr_1 , tp_2 vr_2 )
{
void * vr_3 ;
struct vr_4 * vr_5 ;
int vr_6 = sizeof *vr_5 ;
fn_2 ( & vl_1 , vr_6 ) ;
vr_3 = fn_3 ( & vl_1 ) ;
vr_5 = vr_3 ;
vr_5 -- ;
vr_5 -> vr_7 = vr_1 ;
vr_5 -> vr_8 = vr_2 ;
}
static struct vr_4
fn_4 ( void )
{
void * vr_3 ;
struct vr_4 * vr_5 ;
int vr_6 = sizeof *vr_5 ;
assert ( vr_6 <= fn_5 ( & vl_1 ) ) ;
fn_2 ( & vl_1 , - vr_6 ) ;
vr_3 = fn_3 ( & vl_1 ) ;
vr_5 = vr_3 ;
return * vr_5 ;
}
static void
fn_6 ( const char * vr_9 , struct vr_10 * vr_11 )
{
tp_3 vr_12 ;
vr_12 = fn_5 ( vr_11 ) / sizeof ( vl_2 ) ;
if ( vr_12 > 0 )
{
tp_3 vr_13 ;
tp_3 * vr_14 ;
vr_14 = ( tp_3 * ) fn_7 ( vr_11 ) ;
fputs ( vr_9 , stdout ) ;
for ( vr_13 = 0 ; vr_13 < vr_12 ; vr_13 ++ )
printf ( lr_1 , ( unsigned long int ) vr_14 [ vr_13 ] ) ;
putchar ( '\n' ) ;
}
}
static tp_3
fn_8 ( void )
{
#ifdef vr_15
vl_3 = vl_4 ;
tp_3 vr_16 ;
do
{
vr_16 = vl_3 ;
vl_3 = 0 ;
int vr_13 ;
for ( vr_13 = 0 ; vr_13 < 12 ; vr_13 ++ )
{
tp_3 vr_17 = vr_16 ;
tp_3 vr_18 = fn_9 ( nl_langinfo ( vl_5 + vr_13 ) ,
vr_19 [ vr_13 ] , sizeof ( vr_19 [ vr_13 ] ) ,
& vr_17 , vl_6 , 0 ) ;
if ( vr_18 == ( tp_3 ) - 1 || vr_18 >= sizeof ( vr_19 [ vr_13 ] ) )
{
vl_3 = 0 ;
return vl_3 ;
}
vl_3 = fn_10 ( vl_3 , vr_17 ) ;
}
}
while ( vr_16 > vl_3 );
#endif
return vl_3 ;
}
static tp_3
fn_11 ( void const * vr_20 , tp_3 vr_21 )
{
struct vr_4 const * vr_22 = vr_20 ;
return ( vl_7 ) vr_22 -> vr_8 % vr_21 ;
}
static bool
fn_12 ( void const * vr_20 , void const * vr_23 )
{
struct vr_4 const * vr_24 = vr_20 ;
struct vr_4 const * vr_25 = vr_23 ;
return fn_13 ( * vr_24 , * vr_25 ) ? true : false ;
}
static void
fn_14 ( void * vr_20 )
{
free ( vr_20 ) ;
}
static bool
fn_15 ( tp_1 vr_1 , tp_2 vr_2 )
{
struct vr_4 * vr_26 ;
struct vr_4 * vr_27 ;
bool vr_28 ;
vr_26 = xmalloc ( sizeof *vr_26 ) ;
vr_26 -> vr_8 = vr_2 ;
vr_26 -> vr_7 = vr_1 ;
vr_27 = fn_16 ( vl_8 , vr_26 ) ;
if ( vr_27 == NULL )
{
fn_17 () ;
}
vr_28 = ( vr_27 != vr_26 ) ;
if ( vr_28 )
{
free ( vr_26 ) ;
}
return vr_28 ;
}
static void
fn_18 ( struct vr_29 * vr_22 )
{
free ( vr_22 -> vr_30 ) ;
free ( vr_22 -> vr_31 ) ;
free ( vr_22 ) ;
}
static bool
fn_19 ( enum vr_32 type )
{
tp_3 vr_33 = vr_34 [ type ] . vr_33 ;
char const * vr_35 = vr_34 [ type ] . string ;
return ! ( vr_33 == 0
|| ( vr_33 == 1 && fn_20 ( vr_35 , lr_2 ) == 0 )
|| ( vr_33 == 2 && fn_20 ( vr_35 , lr_3 ) == 0 ) ) ;
}
static void
fn_21 ( void )
{
fn_22 ( & vr_34 [ vl_9 ] ) ;
fn_22 ( & vr_34 [ vl_10 ] ) ;
}
static void
fn_23 ( void )
{
if ( vl_11 && fn_19 ( vl_12 ) )
{
fn_22 ( & vr_34 [ vl_9 ] ) ;
fn_22 ( & vr_34 [ vl_12 ] ) ;
fn_22 ( & vr_34 [ vl_10 ] ) ;
}
}
static void
fn_24 ( int vr_36 )
{
if ( ! vl_13 )
signal ( vr_36 , vl_14 ) ;
if ( ! vl_15 )
vl_15 = vr_36 ;
}
static void
fn_25 ( int vr_36 )
{
if ( ! vl_13 )
signal ( vr_36 , fn_25 ) ;
if ( ! vl_15 )
vl_16 ++ ;
}
static void
fn_26 ( void )
{
while ( vl_15 || vl_16 )
{
int vr_36 ;
int vr_37 ;
tp_4 vr_38 ;
if ( vl_17 )
fn_21 () ;
fflush ( stdout ) ;
fn_27 ( vl_18 , & vl_19 , & vr_38 ) ;
vr_36 = vl_15 ;
vr_37 = vl_16 ;
if ( vr_37 )
{
vl_16 = vr_37 - 1 ;
vr_36 = vl_20 ;
}
else
signal ( vr_36 , vl_21 ) ;
raise ( vr_36 ) ;
fn_27 ( vl_22 , & vr_38 , NULL ) ;
}
}
int
main ( int vr_39 , char * * vr_40 )
{
int vr_13 ;
struct vr_29 * vr_41 ;
int vr_42 ;
static int const vr_36 [] =
{
vl_23 ,
vl_24 , vl_25 , vl_26 , vl_27 , vl_28 , vl_29 ,
#ifdef vr_43
vr_43 ,
#endif
#ifdef vr_44
vr_44 ,
#endif
#ifdef vr_45
vr_45 ,
#endif
#ifdef vr_46
vr_46 ,
#endif
#ifdef vr_47
vr_47 ,
#endif
} ;
enum { vr_48 = mc_1 (sig) };
#if ! vl_13
bool vr_49 [ vr_48 ] ;
#endif
fn_28 ( & vr_39 , & vr_40 ) ;
fn_29 ( vr_40 [ 0 ] ) ;
setlocale ( vl_30 , lr_4 ) ;
fn_30 ( vl_31 , vl_32 ) ;
fn_31 ( vl_31 ) ;
fn_32 ( vl_33 ) ;
atexit ( vl_34 ) ;
assert ( mc_1 ( vr_34 ) + 1
== mc_1 ( vl_35 ) ) ;
vl_36 = vl_37 ;
vl_38 = true ;
vl_39 = NULL ;
vr_50 . vr_51 = fn_33 ( vl_40 ) ;
vr_50 . vr_52 = - 1 ;
vr_13 = fn_34 ( vr_39 , vr_40 ) ;
if ( vl_11 )
fn_35 () ;
if ( vl_11 )
{
if ( fn_19 ( vl_41 )
|| ( fn_19 ( vl_42 ) && vl_43 )
|| ( fn_19 ( vl_44 ) && vl_45 == vl_46 ) )
vl_47 = true ;
if ( 0 <= fn_36 ( vl_48 ) )
{
int vr_53 ;
#if vl_13
struct vr_54 vr_55 ;
fn_37 ( & vl_19 ) ;
for ( vr_53 = 0 ; vr_53 < vr_48 ; vr_53 ++ )
{
vr_54 ( vr_36 [ vr_53 ] , NULL , & vr_55 ) ;
if ( vr_55 . vr_56 != vl_14 )
fn_38 ( & vl_19 , vr_36 [ vr_53 ] ) ;
}
vr_55 . vr_57 = vl_19 ;
vr_55 . vr_58 = vl_49 ;
for ( vr_53 = 0 ; vr_53 < vr_48 ; vr_53 ++ )
if ( fn_39 ( & vl_19 , vr_36 [ vr_53 ] ) )
{
vr_55 . vr_56 = vr_36 [ vr_53 ] == vl_23 ? fn_25 : fn_24 ;
vr_54 ( vr_36 [ vr_53 ] , & vr_55 , NULL ) ;
}
#else
for ( vr_53 = 0 ; vr_53 < vr_48 ; vr_53 ++ )
{
vr_49 [ vr_53 ] = ( signal ( vr_36 [ vr_53 ] , vl_14 ) != vl_14 ) ;
if ( vr_49 [ vr_53 ] )
{
signal ( vr_36 [ vr_53 ] , vr_36 [ vr_53 ] == vl_23 ? fn_25 : fn_24 ) ;
fn_40 ( vr_36 [ vr_53 ] , 0 ) ;
}
}
#endif
}
}
if ( vl_50 == vl_51 )
vl_50 = ( ( vl_52
|| vl_53 == vl_54
|| vl_45 == vl_46 )
? vl_55
: vl_56 ) ;
if ( vl_57 )
{
vl_8 = fn_41 ( vl_58 , NULL ,
fn_11 ,
fn_12 ,
fn_14 ) ;
if ( vl_8 == NULL )
fn_17 () ;
fn_42 ( & vl_1 ) ;
}
vl_59 = vl_60 == vl_61 || vl_60 == vl_62
|| vl_45 == vl_46
|| vl_63
|| vl_64 ;
vl_65 = ( ! vl_59
&& ( vl_57
|| vl_11
|| vl_53 != vl_66
|| vl_67 ) ) ;
if ( vl_68 )
{
fn_42 ( & vl_69 ) ;
fn_42 ( & vl_70 ) ;
}
vl_71 = 100 ;
vl_72 = fn_43 ( vl_71 , sizeof *vl_72 ) ;
vl_73 = 0 ;
fn_44 () ;
vr_42 = vr_39 - vr_13 ;
if ( vr_42 <= 0 )
{
if ( vl_52 )
fn_45 ( lr_5 , vl_74 , vl_75 , true , lr_4 ) ;
else
fn_46 ( lr_5 , NULL , true ) ;
}
else
do
fn_45 ( vr_40 [ vr_13 ++ ] , vl_76 , vl_75 , true , lr_4 ) ;
while ( vr_13 < vr_39 );
if ( vl_73 )
{
fn_47 () ;
if ( ! vl_52 )
fn_48 ( NULL , true ) ;
}
if ( vl_73 )
{
fn_49 () ;
if ( vl_39 )
fn_50 ( '\n' ) ;
}
else if ( vr_42 <= 1 && vl_39 && vl_39 -> vr_59 == 0 )
vl_38 = false ;
while ( vl_39 )
{
vr_41 = vl_39 ;
vl_39 = vl_39 -> vr_59 ;
if ( vl_77 )
{
if ( vr_41 -> vr_30 == NULL )
{
struct vr_4 vr_5 = fn_4 () ;
struct vr_4 * vr_60 = fn_51 ( vl_8 , & vr_5 ) ;
assert ( vr_60 ) ;
fn_14 ( vr_60 ) ;
fn_18 ( vr_41 ) ;
continue;
}
}
fn_52 ( vr_41 -> vr_30 , vr_41 -> vr_31 ,
vr_41 -> vr_61 ) ;
fn_18 ( vr_41 ) ;
vl_38 = true ;
}
if ( vl_11 )
{
int vr_53 ;
if ( vl_17 )
{
if ( ! ( vr_34 [ vl_9 ] . vr_33 == 2
&& memcmp ( vr_34 [ vl_9 ] . string , lr_6 , 2 ) == 0
&& vr_34 [ vl_10 ] . vr_33 == 1
&& vr_34 [ vl_10 ] . string [ 0 ] == 'm' ) )
fn_21 () ;
}
fflush ( stdout ) ;
#if vl_13
for ( vr_53 = 0 ; vr_53 < vr_48 ; vr_53 ++ )
if ( fn_39 ( & vl_19 , vr_36 [ vr_53 ] ) )
signal ( vr_36 [ vr_53 ] , vl_21 ) ;
#else
for ( vr_53 = 0 ; vr_53 < vr_48 ; vr_53 ++ )
if ( vr_49 [ vr_53 ] )
signal ( vr_36 [ vr_53 ] , vl_21 ) ;
#endif
for ( vr_53 = vl_16 ; vr_53 ; vr_53 -- )
raise ( vl_20 ) ;
vr_53 = vl_15 ;
if ( vr_53 )
raise ( vr_53 ) ;
}
if ( vl_68 )
{
fn_6 ( lr_7 , & vl_69 ) ;
fn_6 ( lr_8 , & vl_70 ) ;
printf ( lr_9 ,
vr_62 [ fn_53 ( vl_78 ) ] ) ;
}
if ( vl_77 )
{
assert ( fn_54 ( vl_8 ) == 0 ) ;
fn_55 ( vl_8 ) ;
}
exit ( vl_36 ) ;
}
static int
fn_34 ( int vr_39 , char * * vr_40 )
{
char * vr_63 = NULL ;
bool vr_64 = false ;
bool vr_65 = false ;
vl_79 = false ;
switch ( vl_80 )
{
case vl_81 :
vl_45 = vl_82 ;
fn_56 ( NULL , vl_83 ) ;
break;
case vl_84 :
vl_45 = vl_46 ;
fn_56 ( NULL , vl_83 ) ;
break;
case vl_85 :
if ( fn_57 ( vl_48 ) )
{
vl_45 = vl_82 ;
vl_79 = true ;
}
else
{
vl_45 = vl_86 ;
vl_79 = false ;
}
break;
default:
abort () ;
}
vl_87 = vl_88 ;
vl_60 = vl_89 ;
vl_90 = false ;
vl_91 = false ;
vl_64 = false ;
vl_53 = vl_66 ;
vl_92 = false ;
vl_50 = vl_51 ;
vl_57 = false ;
vl_52 = false ;
vl_93 = vl_94 ;
vl_95 = NULL ;
vl_96 = NULL ;
vl_63 = false ;
{
char const * vr_66 = getenv ( lr_10 ) ;
if ( vr_66 )
{
int vr_13 = fn_58 ( vr_66 , vr_62 , vl_97 ) ;
if ( 0 <= vr_13 )
fn_56 ( NULL , vl_97 [ vr_13 ] ) ;
else
error ( 0 , 0 ,
_ ( lr_11 ) ,
fn_59 ( vr_66 ) ) ;
}
}
vl_98 = 80 ;
{
char const * vr_22 = getenv ( lr_12 ) ;
if ( vr_22 && * vr_22 )
{
unsigned long int vr_67 ;
if ( fn_60 ( vr_22 , NULL , 0 , & vr_67 , NULL ) == vl_99
&& 0 < vr_67 && vr_67 <= vl_100 )
{
vl_98 = vr_67 ;
}
else
{
error ( 0 , 0 ,
_ ( lr_13 ) ,
fn_59 ( vr_22 ) ) ;
}
}
}
#ifdef vr_68
{
struct vr_69 vr_70 ;
if ( fn_61 ( vl_48 , vr_68 , & vr_70 ) != - 1
&& 0 < vr_70 . vr_71 && vr_70 . vr_71 == ( tp_3 ) vr_70 . vr_71 )
vl_98 = vr_70 . vr_71 ;
}
#endif
{
char const * vr_22 = getenv ( lr_14 ) ;
vl_101 = 8 ;
if ( vr_22 )
{
unsigned long int vr_67 ;
if ( fn_60 ( vr_22 , NULL , 0 , & vr_67 , NULL ) == vl_99
&& vr_67 <= vl_100 )
{
vl_101 = vr_67 ;
}
else
{
error ( 0 , 0 ,
_ ( lr_15 ) ,
fn_59 ( vr_22 ) ) ;
}
}
}
while ( true )
{
int vr_72 = - 1 ;
int vr_73 = fn_62 ( vr_39 , vr_40 ,
lr_16 ,
vl_102 , & vr_72 ) ;
if ( vr_73 == - 1 )
break;
switch ( vr_73 )
{
case 'a' :
vl_93 = vl_103 ;
break;
case 'b' :
fn_56 ( NULL , vl_83 ) ;
break;
case 'c' :
vl_87 = vl_104 ;
break;
case 'd' :
vl_52 = true ;
break;
case 'f' :
vl_93 = vl_103 ;
vl_60 = vl_105 ;
vr_64 = true ;
if ( vl_45 == vl_46 )
vl_45 = ( fn_57 ( vl_48 ) ? vl_82 : vl_86 ) ;
vl_64 = false ;
vl_11 = false ;
break;
case vl_106 :
vl_53 = vl_107 ;
break;
case 'g' :
vl_45 = vl_46 ;
vl_108 = false ;
break;
case 'h' :
vl_109 = vl_110 =
vl_111 | vl_112 | vl_113 ;
vl_114 = vl_115 = 1 ;
break;
case 'i' :
vl_92 = true ;
break;
case 'k' :
vr_65 = true ;
break;
case 'l' :
vl_45 = vl_46 ;
break;
case 'm' :
vl_45 = vl_116 ;
break;
case 'n' :
vl_91 = true ;
vl_45 = vl_46 ;
break;
case 'o' :
vl_45 = vl_46 ;
vl_117 = false ;
break;
case 'p' :
vl_53 = vl_118 ;
break;
case 'q' :
vl_79 = true ;
break;
case 'r' :
vl_90 = true ;
break;
case 's' :
vl_64 = true ;
break;
case 't' :
vl_60 = vl_61 ;
vr_64 = true ;
break;
case 'u' :
vl_87 = vl_119 ;
break;
case 'v' :
vl_60 = vl_120 ;
vr_64 = true ;
break;
case 'w' :
{
unsigned long int vr_67 ;
if ( fn_60 ( vl_121 , NULL , 0 , & vr_67 , NULL ) != vl_99
|| ! ( 0 < vr_67 && vr_67 <= vl_100 ) )
error ( vl_33 , 0 , _ ( lr_17 ) ,
fn_59 ( vl_121 ) ) ;
vl_98 = vr_67 ;
break;
}
case 'x' :
vl_45 = vl_122 ;
break;
case 'A' :
if ( vl_93 == vl_94 )
vl_93 = vl_123 ;
break;
case 'B' :
fn_63 ( lr_18 ) ;
fn_63 ( lr_19 ) ;
break;
case 'C' :
vl_45 = vl_82 ;
break;
case 'D' :
vl_68 = true ;
break;
case 'F' :
vl_53 = vl_54 ;
break;
case 'G' :
vl_117 = false ;
break;
case 'H' :
vl_50 = vl_124 ;
break;
case vl_125 :
vl_50 = vl_56 ;
break;
case 'I' :
fn_63 ( vl_121 ) ;
break;
case 'L' :
vl_50 = vl_126 ;
break;
case 'N' :
fn_56 ( NULL , vl_127 ) ;
break;
case 'Q' :
fn_56 ( NULL , vl_128 ) ;
break;
case 'R' :
vl_57 = true ;
break;
case 'S' :
vl_60 = vl_62 ;
vr_64 = true ;
break;
case 'T' :
{
unsigned long int vr_67 ;
if ( fn_60 ( vl_121 , NULL , 0 , & vr_67 , NULL ) != vl_99
|| vl_100 < vr_67 )
error ( vl_33 , 0 , _ ( lr_20 ) ,
fn_59 ( vl_121 ) ) ;
vl_101 = vr_67 ;
break;
}
case 'U' :
vl_60 = vl_105 ;
vr_64 = true ;
break;
case 'X' :
vl_60 = vl_129 ;
vr_64 = true ;
break;
case '1' :
if ( vl_45 != vl_46 )
vl_45 = vl_86 ;
break;
case vl_130 :
vl_131 = true ;
break;
case vl_132 :
{
struct vr_74 * vr_75 = xmalloc ( sizeof *vr_75 ) ;
vr_75 -> vr_76 = vl_121 ;
vr_75 -> vr_59 = vl_96 ;
vl_96 = vr_75 ;
}
break;
case vl_133 :
vl_60 = fn_64 ( lr_21 , vl_121 , vl_134 , vl_135 ) ;
vr_64 = true ;
break;
case vl_136 :
vl_67 = true ;
break;
case vl_137 :
vl_87 = fn_64 ( lr_22 , vl_121 , vl_138 , vl_139 ) ;
break;
case vl_140 :
vl_45 = fn_64 ( lr_23 , vl_121 , vl_141 , vl_142 ) ;
break;
case vl_143 :
vl_45 = vl_46 ;
vr_63 = fn_65 ( lr_24 ) ;
break;
case vl_144 :
{
int vr_13 ;
if ( vl_121 )
vr_13 = fn_64 ( lr_25 , vl_121 , vl_145 , vl_146 ) ;
else
vr_13 = vl_147 ;
vl_11 = ( vr_13 == vl_147
|| ( vr_13 == vl_148
&& fn_57 ( vl_48 ) ) ) ;
if ( vl_11 )
{
vl_101 = 0 ;
}
break;
}
case vl_149 :
vl_53 = fn_64 ( lr_26 , vl_121 ,
vl_150 ,
vl_151 ) ;
break;
case vl_152 :
fn_56 ( NULL ,
fn_64 ( lr_27 , vl_121 ,
vr_62 ,
vl_97 ) ) ;
break;
case vl_153 :
vr_63 = vl_121 ;
break;
case vl_154 :
vl_79 = false ;
break;
case vl_155 :
{
enum vr_77 vr_78 = fn_66 ( vl_121 , & vl_110 ,
& vl_115 ) ;
if ( vr_78 != vl_99 )
fn_67 ( vr_78 , vr_72 , 0 , vl_102 , vl_121 ) ;
vl_109 = vl_110 ;
vl_114 = vl_115 ;
}
break;
case vl_156 :
vl_109 = vl_110 =
vl_111 | vl_112 ;
vl_114 = vl_115 = 1 ;
break;
case 'Z' :
vl_63 = true ;
break;
vl_157 ;
fn_68 ( vl_158 , vl_159 ) ;
default:
fn_69 ( vl_33 ) ;
}
}
if ( ! vl_115 )
{
char const * vr_79 = getenv ( lr_28 ) ;
fn_66 ( vr_79 ,
& vl_110 , & vl_115 ) ;
if ( vr_79 || getenv ( lr_29 ) )
{
vl_109 = vl_110 ;
vl_114 = vl_115 ;
}
if ( vr_65 )
{
vl_110 = 0 ;
vl_115 = 1024 ;
}
}
vl_160 = fn_10 ( 1 , vl_98 / vl_161 ) ; MST[DIV$@1$@2$!NEG$@2$]MSP[]
vl_78 = fn_70 ( NULL ) ;
if ( fn_53 ( vl_78 ) == vl_83 )
fn_71 ( vl_78 , ' ' , 1 ) ;
if ( vl_107 <= vl_53 )
{
char const * vr_22 ;
for ( vr_22 = & lr_30 [ vl_53 - vl_107 ] ; * vr_22 ; vr_22 ++ )
fn_71 ( vl_78 , * vr_22 , 1 ) ;
}
vl_162 = fn_70 ( NULL ) ;
fn_71 ( vl_162 , ':' , 1 ) ;
if ( vl_68 && vl_45 != vl_46 )
vl_68 = false ;
if ( ( vl_87 == vl_104 || vl_87 == vl_119 )
&& ! vr_64 && vl_45 != vl_46 )
{
vl_60 = vl_61 ;
}
if ( vl_45 == vl_46 )
{
char * vr_80 = vr_63 ;
static char const vr_81 [] = lr_31 ;
if ( ! vr_80 )
if ( ! ( vr_80 = getenv ( lr_32 ) ) )
vr_80 = fn_65 ( lr_33 ) ;
while ( fn_72 ( vr_80 , vr_81 , sizeof vr_81 - 1 ) )
{
if ( ! fn_73 ( vl_163 ) )
return vl_164 ;
vr_80 += sizeof vr_81 - 1 ;
}
if ( * vr_80 == '+' )
{
char * vr_82 = vr_80 + 1 ;
char * vr_83 = strchr ( vr_82 , '\n' ) ;
if ( ! vr_83 )
vr_83 = vr_82 ;
else
{
if ( strchr ( vr_83 + 1 , '\n' ) )
error ( vl_33 , 0 , _ ( lr_34 ) ,
fn_74 ( vr_82 ) ) ;
* vr_83 ++ = '\0' ;
}
vr_84 [ 0 ] = vr_82 ;
vr_84 [ 1 ] = vr_83 ;
}
else
{
tp_5 vr_85 = fn_75 ( vr_80 , vl_165 ,
( char const * ) vl_166 ,
sizeof ( * vl_166 ) ) ;
if ( vr_85 < 0 )
{
fn_76 ( lr_35 , vr_80 , vr_85 ) ;
fputs ( _ ( lr_36 ) , vl_167 ) ;
char const * const * vr_22 = vl_165 ;
while ( * vr_22 )
fprintf ( vl_167 , lr_37 , * vr_22 ++ ) ;
fputs ( _ ( lr_38
lr_39 ) , vl_167 ) ;
fn_69 ( vl_33 ) ;
}
switch ( vr_85 )
{
case vl_168 :
vr_84 [ 0 ] = vr_84 [ 1 ] =
lr_40 ;
break;
case vl_169 :
vr_84 [ 0 ] = vr_84 [ 1 ] = lr_41 ;
break;
case vl_170 :
vr_84 [ 0 ] = lr_42 ;
vr_84 [ 1 ] = lr_43 ;
break;
case vl_171 :
if ( fn_73 ( vl_163 ) )
{
int vr_13 ;
for ( vr_13 = 0 ; vr_13 < 2 ; vr_13 ++ )
vr_84 [ vr_13 ] =
fn_77 ( NULL , vr_84 [ vr_13 ] , vl_163 ) ;
}
}
}
if ( strstr ( vr_84 [ 0 ] , lr_44 )
|| strstr ( vr_84 [ 1 ] , lr_44 ) )
if ( ! fn_8 () )
error ( 0 , 0 , _ ( lr_45 ) ) ;
}
return vl_164 ;
}
static bool
fn_78 ( char * * vr_86 , const char * * vr_87 , bool vr_88 ,
tp_3 * vr_89 )
{
char vr_90 ;
tp_3 vr_91 ;
enum {
vr_92 , vr_93 , vr_94 , vr_95 , vr_96 , vr_97 , vr_98
} vr_99 ;
const char * vr_22 ;
char * vr_100 ;
vr_22 = * vr_87 ;
vr_100 = * vr_86 ;
vr_91 = 0 ;
vr_90 = 0 ;
vr_99 = vr_92 ;
while ( vr_99 < vr_97 )
{
switch ( vr_99 )
{
case vr_92 :
switch ( * vr_22 )
{
case ':' :
case '\0' :
vr_99 = vr_97 ;
break;
case '\\' :
vr_99 = vr_93 ;
++ vr_22 ;
break;
case '^' :
vr_99 = vr_96 ;
++ vr_22 ;
break;
case '=' :
if ( vr_88 )
{
vr_99 = vr_97 ;
break;
}
default:
* ( vr_100 ++ ) = * ( vr_22 ++ ) ;
++ vr_91 ;
break;
}
break;
case vr_93 :
switch ( * vr_22 )
{
case '0' :
case '1' :
case '2' :
case '3' :
case '4' :
case '5' :
case '6' :
case '7' :
vr_99 = vr_94 ;
vr_90 = * vr_22 - '0' ;
break;
case 'x' :
case 'X' :
vr_99 = vr_95 ;
vr_90 = 0 ;
break;
case 'a' :
vr_90 = '\a' ;
break;
case 'b' :
vr_90 = '\b' ;
break;
case 'e' :
vr_90 = 27 ;
break;
case 'f' :
vr_90 = '\f' ;
break;
case 'n' :
vr_90 = '\n' ;
break;
case 'r' :
vr_90 = '\r' ;
break;
case 't' :
vr_90 = '\t' ;
break;
case 'v' :
vr_90 = '\v' ;
break;
case '?' :
vr_90 = 127 ;
break;
case '_' :
vr_90 = ' ' ;
break;
case '\0' :
vr_99 = vr_98 ;
break;
default:
vr_90 = * vr_22 ;
break;
}
if ( vr_99 == vr_93 )
{
* ( vr_100 ++ ) = vr_90 ;
++ vr_91 ;
vr_99 = vr_92 ;
}
++ vr_22 ;
break;
case vr_94 :
if ( * vr_22 < '0' || * vr_22 > '7' )
{
* ( vr_100 ++ ) = vr_90 ;
++ vr_91 ;
vr_99 = vr_92 ;
}
else
vr_90 = ( vr_90 << 3 ) + ( * ( vr_22 ++ ) - '0' ) ;
break;
case vr_95 :
switch ( * vr_22 )
{
case '0' :
case '1' :
case '2' :
case '3' :
case '4' :
case '5' :
case '6' :
case '7' :
case '8' :
case '9' :
vr_90 = ( vr_90 << 4 ) + ( * ( vr_22 ++ ) - '0' ) ;
break;
case 'a' :
case 'b' :
case 'c' :
case 'd' :
case 'e' :
case 'f' :
vr_90 = ( vr_90 << 4 ) + ( * ( vr_22 ++ ) - 'a' ) + 10 ;
break;
case 'A' :
case 'B' :
case 'C' :
case 'D' :
case 'E' :
case 'F' :
vr_90 = ( vr_90 << 4 ) + ( * ( vr_22 ++ ) - 'A' ) + 10 ;
break;
default:
* ( vr_100 ++ ) = vr_90 ;
++ vr_91 ;
vr_99 = vr_92 ;
break;
}
break;
case vr_96 :
vr_99 = vr_92 ;
if ( * vr_22 >= '@' && * vr_22 <= '~' )
{
* ( vr_100 ++ ) = * ( vr_22 ++ ) & 037 ;
++ vr_91 ;
}
else if ( * vr_22 == '?' )
{
* ( vr_100 ++ ) = 127 ;
++ vr_91 ;
}
else
vr_99 = vr_98 ;
break;
default:
abort () ;
}
}
* vr_86 = vr_100 ;
* vr_87 = vr_22 ;
* vr_89 = vr_91 ;
return vr_99 != vr_98 ;
}
static void
fn_35 ( void )
{
const char * vr_22 ;
char * vr_101 ;
int vr_102 ;
char vr_103 [ 3 ] ;
struct vr_104 * vr_105 ;
if ( ( vr_22 = getenv ( lr_46 ) ) == NULL || * vr_22 == '\0' )
return;
vr_105 = NULL ;
strcpy ( vr_103 , lr_47 ) ;
vr_101 = vl_172 = fn_79 ( vr_22 ) ;
enum vr_106 vr_99 = vl_173 ;
while ( true )
{
switch ( vr_99 )
{
case vl_173 :
switch ( * vr_22 )
{
case ':' :
++ vr_22 ;
break;
case '*' :
vr_105 = xmalloc ( sizeof *vr_105 ) ;
vr_105 -> vr_59 = vl_174 ;
vl_174 = vr_105 ;
++ vr_22 ;
vr_105 -> vr_105 . string = vr_101 ;
vr_99 = ( fn_78 ( & vr_101 , & vr_22 , true , & vr_105 -> vr_105 . vr_33 )
? vl_175 : vl_176 ) ;
break;
case '\0' :
vr_99 = vl_177 ;
goto lb_1;
default:
vr_103 [ 0 ] = * ( vr_22 ++ ) ;
vr_99 = vl_178 ;
break;
}
break;
case vl_178 :
if ( * vr_22 )
{
vr_103 [ 1 ] = * ( vr_22 ++ ) ;
vr_99 = vl_179 ;
}
else
vr_99 = vl_176 ;
break;
case vl_179 :
vr_99 = vl_176 ;
if ( * ( vr_22 ++ ) == '=' )
{
for ( vr_102 = 0 ; vl_35 [ vr_102 ] != NULL ; ++ vr_102 )
{
if ( fn_80 ( vr_103 , vl_35 [ vr_102 ] ) )
{
vr_34 [ vr_102 ] . string = vr_101 ;
vr_99 = ( fn_78 ( & vr_101 , & vr_22 , false ,
& vr_34 [ vr_102 ] . vr_33 )
? vl_173 : vl_176 ) ;
break;
}
}
if ( vr_99 == vl_176 )
error ( 0 , 0 , _ ( lr_48 ) , fn_59 ( vr_103 ) ) ;
}
break;
case vl_175 :
if ( * ( vr_22 ++ ) == '=' )
{
vr_105 -> vr_107 . string = vr_101 ;
vr_99 = ( fn_78 ( & vr_101 , & vr_22 , false , & vr_105 -> vr_107 . vr_33 )
? vl_173 : vl_176 ) ;
}
else
vr_99 = vl_176 ;
break;
case vl_176 :
goto lb_1;
default:
abort () ;
}
}
lb_1:
if ( vr_99 == vl_176 )
{
struct vr_104 * vr_78 ;
struct vr_104 * vr_108 ;
error ( 0 , 0 ,
_ ( lr_49 ) ) ;
free ( vl_172 ) ;
for ( vr_78 = vl_174 ; vr_78 != NULL ; )
{
vr_108 = vr_78 ;
vr_78 = vr_78 -> vr_59 ;
free ( vr_108 ) ;
}
vl_11 = false ;
}
if ( vr_34 [ vl_180 ] . vr_33 == 6
&& ! fn_20 ( vr_34 [ vl_180 ] . string , lr_50 ) )
vl_43 = true ;
}
static void
fn_81 ( bool vr_109 )
{
if ( vr_109 )
vl_36 = vl_33 ;
else if ( vl_36 == vl_37 )
vl_36 = vl_181 ;
}
static void
fn_82 ( bool vr_109 , char const * vr_110 , char const * vr_111 )
{
error ( 0 , vl_182 , vr_110 , fn_83 ( vr_111 ) ) ;
fn_81 ( vr_109 ) ;
}
static void
fn_46 ( char const * vr_30 , char const * vr_31 , bool vr_61 )
{
struct vr_29 * vr_112 = xmalloc ( sizeof *vr_112 ) ;
vr_112 -> vr_31 = vr_31 ? fn_79 ( vr_31 ) : NULL ;
vr_112 -> vr_30 = vr_30 ? fn_79 ( vr_30 ) : NULL ;
vr_112 -> vr_61 = vr_61 ;
vr_112 -> vr_59 = vl_39 ;
vl_39 = vr_112 ;
}
static void
fn_52 ( char const * vr_30 , char const * vr_31 , bool vr_61 )
{
tp_6 * vr_113 ;
struct vr_114 * vr_59 ;
vl_7 vr_115 = 0 ;
static bool vr_116 = true ;
vl_182 = 0 ;
vr_113 = fn_84 ( vr_30 ) ;
if ( ! vr_113 )
{
fn_82 ( vr_61 , _ ( lr_51 ) , vr_30 ) ;
return;
}
if ( vl_77 )
{
struct vr_117 vr_118 ;
int vr_119 = fn_85 ( vr_113 ) ;
if ( ( 0 <= vr_119
? fn_86 ( vr_119 , & vr_118 )
: vr_117 ( vr_30 , & vr_118 ) ) < 0 )
{
fn_82 ( vr_61 ,
_ ( lr_52 ) , vr_30 ) ;
fn_87 ( vr_113 ) ;
return;
}
if ( fn_15 ( vr_118 . vr_7 , vr_118 . vr_8 ) )
{
error ( 0 , 0 , _ ( lr_53 ) ,
fn_83 ( vr_30 ) ) ;
fn_87 ( vr_113 ) ;
fn_81 ( true ) ;
return;
}
fn_1 ( vr_118 . vr_7 , vr_118 . vr_8 ) ;
}
if ( vl_57 || vl_38 )
{
if ( ! vr_116 )
fn_50 ( '\n' ) ;
vr_116 = false ;
fn_88 () ;
fn_89 ( & vl_70 ) ;
vl_2 += fn_90 ( stdout , vr_31 ? vr_31 : vr_30 ,
vl_162 , NULL ) ;
fn_89 ( & vl_70 ) ;
fn_91 ( lr_54 , stdout ) ;
}
fn_44 () ;
while ( 1 )
{
vl_182 = 0 ;
vr_59 = fn_92 ( vr_113 ) ;
if ( vr_59 )
{
if ( ! fn_93 ( vr_59 -> vr_120 ) )
{
enum vr_121 type = vl_76 ;
#if vl_183
switch ( vr_59 -> vr_122 )
{
case vl_184 : type = vl_185 ; break;
case vl_186 : type = vl_187 ; break;
case vl_188 : type = vl_74 ; break;
case vl_189 : type = vl_190 ; break;
case vl_191 : type = vl_192 ; break;
case vl_193 : type = vl_194 ; break;
case vl_195 : type = vl_196 ; break;
# ifdef vr_123
case vr_123 : type = vl_197 ; break;
# endif
}
#endif
vr_115 += fn_45 ( vr_59 -> vr_120 , type ,
fn_94 ( vr_59 ) ,
false , vr_30 ) ;
if ( vl_45 == vl_86 && vl_60 == vl_105
&& ! vl_64 && ! vl_57 )
{
fn_47 () ;
fn_49 () ;
fn_44 () ;
}
}
}
else if ( vl_182 != 0 )
{
fn_82 ( vr_61 , _ ( lr_55 ) , vr_30 ) ;
if ( vl_182 != vl_198 )
break;
}
else
break;
fn_26 () ;
}
if ( fn_87 ( vr_113 ) != 0 )
{
fn_82 ( vr_61 , _ ( lr_56 ) , vr_30 ) ;
}
fn_47 () ;
if ( vl_57 )
fn_48 ( vr_30 , false ) ;
if ( vl_45 == vl_46 || vl_64 )
{
const char * vr_22 ;
char vr_101 [ vl_199 + 1 ] ;
fn_88 () ;
vr_22 = _ ( lr_57 ) ;
fn_95 ( vr_22 , stdout , strlen ( vr_22 ) ) ;
fn_50 ( ' ' ) ;
vr_22 = fn_96 ( vr_115 , vr_101 , vl_110 ,
vl_200 , vl_115 ) ;
fn_95 ( vr_22 , stdout , strlen ( vr_22 ) ) ;
fn_50 ( '\n' ) ;
}
if ( vl_73 )
fn_49 () ;
}
static void
fn_63 ( const char * vr_76 )
{
struct vr_74 * vr_124 ;
vr_124 = xmalloc ( sizeof *vr_124 ) ;
vr_124 -> vr_76 = vr_76 ;
vr_124 -> vr_59 = vl_95 ;
vl_95 = vr_124 ;
}
static bool
fn_97 ( struct vr_74 const * vr_125 , char const * vr_111 )
{
struct vr_74 const * vr_22 ;
for ( vr_22 = vr_125 ; vr_22 ; vr_22 = vr_22 -> vr_59 )
if ( fn_98 ( vr_22 -> vr_76 , vr_111 , vl_201 ) == 0 )
return true ;
return false ;
}
static bool
fn_93 ( char const * vr_30 )
{
return ( ( vl_93 != vl_103
&& vr_30 [ 0 ] == '.'
&& ( vl_93 == vl_94 || ! vr_30 [ 1 + ( vr_30 [ 1 ] == '.' ) ] ) )
|| ( vl_93 == vl_94
&& fn_97 ( vl_96 , vr_30 ) )
|| fn_97 ( vl_95 , vr_30 ) ) ;
}
static vl_7
fn_99 ( tp_7 vr_126 )
{
return vr_126 + ( vr_126 < 0 ) * ( ( vl_7 ) vl_202 - vl_203 + 1 ) ;
}
static bool
fn_100 ( char const * vr_30 )
{
char * vr_127 ;
bool vr_128 ;
tp_8 vr_129 = fn_101 ( vr_30 ) ;
if ( vr_129 == NULL )
return false ;
vr_127 = fn_102 ( vr_129 , NULL ) ;
fn_103 ( vr_129 ) ;
if ( ! vr_127 )
return false ;
vr_128 = ! ! * vr_127 ;
fn_103 ( vr_127 ) ;
return vr_128 ;
}
static bool
fn_100 ( char const * vr_30 vr_130 )
{
vl_182 = vl_204 ;
return false ;
}
static void
fn_104 ( struct vr_131 * vr_132 )
{
free ( vr_132 -> vr_30 ) ;
free ( vr_132 -> vr_133 ) ;
if ( vr_132 -> vr_134 != vl_205 )
{
if ( fn_105 () )
free ( vr_132 -> vr_134 ) ;
else
fn_106 ( vr_132 -> vr_134 ) ;
}
}
static void
fn_44 ( void )
{
tp_3 vr_13 ;
for ( vr_13 = 0 ; vr_13 < vl_73 ; vr_13 ++ )
{
struct vr_131 * vr_132 = vr_135 [ vr_13 ] ;
fn_104 ( vr_132 ) ;
}
vl_73 = 0 ;
vl_206 = false ;
vl_207 = 0 ;
vl_208 = 0 ;
vl_209 = 0 ;
vl_210 = 0 ;
vl_211 = 0 ;
vl_212 = 0 ;
vl_213 = 0 ;
vl_214 = 0 ;
vl_215 = 0 ;
vl_216 = 0 ;
}
static bool
fn_107 ( int vr_136 )
{
return ( vr_136 == vl_217
|| vr_136 == vl_218
|| vr_136 == vl_204
|| vr_136 == vl_219 ) ;
}
static int
fn_108 ( char const * vr_111 , struct vr_131 * vr_132 , bool vr_137 )
{
static tp_1 vr_138 ;
if ( vr_132 -> vr_117 . vr_7 == vr_138 )
{
vl_182 = vl_204 ;
return - 1 ;
}
int vr_139 = 0 ;
#ifdef vr_140
if ( fn_105 () )
vr_139 = fn_109 ( vr_111 , lr_58 , vr_137 ,
& vr_132 -> vr_134 ) ;
else
#endif
vr_139 = ( vr_137
? fn_110 ( vr_111 , & vr_132 -> vr_134 )
: fn_111 ( vr_111 , & vr_132 -> vr_134 ) ) ;
if ( vr_139 < 0 && fn_107 ( vl_182 ) )
vr_138 = vr_132 -> vr_117 . vr_7 ;
return vr_139 ;
}
static int
fn_112 ( char const * vr_111 , struct vr_131 * vr_132 )
{
static tp_1 vr_138 ;
if ( vr_132 -> vr_117 . vr_7 == vr_138 )
{
vl_182 = vl_204 ;
return 0 ;
}
vl_182 = 0 ;
int vr_141 = fn_113 ( vr_111 , & vr_132 -> vr_117 ) ;
if ( vr_141 <= 0 && fn_107 ( vl_182 ) )
vr_138 = vr_132 -> vr_117 . vr_7 ;
return vr_141 ;
}
static bool
fn_114 ( char const * vr_111 , struct vr_131 * vr_132 )
{
static tp_1 vr_138 ;
if ( vr_132 -> vr_117 . vr_7 == vr_138 )
{
vl_182 = vl_204 ;
return 0 ;
}
bool vr_25 = fn_100 ( vr_111 ) ;
if ( ! vr_25 && fn_107 ( vl_182 ) )
vr_138 = vr_132 -> vr_117 . vr_7 ;
return vr_25 ;
}
static vl_7
fn_45 ( char const * vr_30 , enum vr_121 type , tp_2 vr_142 ,
bool vr_61 , char const * vr_143 )
{
vl_7 vr_144 = 0 ;
struct vr_131 * vr_132 ;
assert ( ! vr_61 || vr_142 == vl_75 ) ;
if ( vl_73 == vl_71 )
{
vl_72 = fn_115 ( vl_72 , vl_71 , 2 * sizeof *vl_72 ) ;
vl_71 *= 2 ;
}
vr_132 = & vl_72 [ vl_73 ] ;
memset ( vr_132 , '\0' , sizeof *vr_132 ) ;
vr_132 -> vr_117 . vr_8 = vr_142 ;
vr_132 -> vr_121 = type ;
if ( vr_61
|| vl_59
|| ( type == vl_74 && vl_11
&& ( fn_19 ( vl_220 )
|| fn_19 ( vl_221 )
|| fn_19 ( vl_222 ) ) )
|| ( ( vl_92 || vl_65 )
&& ( type == vl_192 || type == vl_76 )
&& ( vl_50 == vl_126
|| ( vr_61 && vl_50 != vl_55 )
|| vl_43 || vl_47 ) )
|| ( vl_92 && vr_142 == vl_75 )
|| ( vl_65
&& ( type == vl_76 || vr_61
|| ( type == vl_194 && ( vl_53 == vl_54
|| ( vl_11
&& ( fn_19 ( vl_42 )
|| fn_19 ( vl_223 )
|| fn_19 ( vl_224 )
|| fn_19 ( vl_225 ) ) )
) ) ) ) )
{
char * vr_145 ;
bool vr_146 ;
int vr_136 ;
if ( vr_30 [ 0 ] == '/' || vr_143 [ 0 ] == 0 )
vr_145 = ( char * ) vr_30 ;
else
{
vr_145 = fn_116 ( strlen ( vr_30 ) + strlen ( vr_143 ) + 2 ) ;
fn_117 ( vr_145 , vr_143 , vr_30 ) ;
}
switch ( vl_50 )
{
case vl_126 :
vr_136 = vr_117 ( vr_145 , & vr_132 -> vr_117 ) ;
vr_146 = true ;
break;
case vl_124 :
case vl_56 :
if ( vr_61 )
{
bool vr_147 ;
vr_136 = vr_117 ( vr_145 , & vr_132 -> vr_117 ) ;
vr_146 = true ;
if ( vl_50 == vl_124 )
break;
vr_147 = ( vr_136 < 0
? vl_182 == vl_226
: ! fn_118 ( vr_132 -> vr_117 . vr_148 ) ) ;
if ( ! vr_147 )
break;
}
default:
vr_136 = fn_119 ( vr_145 , & vr_132 -> vr_117 ) ;
vr_146 = false ;
break;
}
if ( vr_136 != 0 )
{
fn_82 ( vr_61 ,
_ ( lr_59 ) , vr_145 ) ;
if ( vr_61 )
return 0 ;
vr_132 -> vr_30 = fn_79 ( vr_30 ) ;
vl_73 ++ ;
return 0 ;
}
vr_132 -> vr_149 = true ;
if ( ( type == vl_194 || fn_120 ( vr_132 -> vr_117 . vr_148 ) )
&& vl_11 && fn_19 ( vl_225 ) )
vr_132 -> fn_100 = fn_114 ( vr_145 , vr_132 ) ;
if ( vl_45 == vl_46 || vl_63 )
{
bool vr_150 = false ;
bool vr_151 = false ;
int vr_152 = fn_108 ( vr_145 , vr_132 , vr_146 ) ;
vr_136 = ( vr_152 < 0 ) ;
if ( vr_136 == 0 )
{
if ( fn_105 () )
vr_150 = ! fn_80 ( lr_60 , vr_132 -> vr_134 ) ;
else
vr_150 = ! fn_80 ( lr_61 , vr_132 -> vr_134 ) ;
}
else
{
vr_132 -> vr_134 = vl_205 ;
if ( vl_182 == vl_204 || vl_182 == vl_219 || vl_182 == vl_227 )
vr_136 = 0 ;
}
if ( vr_136 == 0 && vl_45 == vl_46 )
{
int vr_141 = fn_112 ( vr_145 , vr_132 ) ;
vr_136 = ( vr_141 < 0 ) ;
vr_151 = ( 0 < vr_141 ) ;
}
vr_132 -> vr_153 = ( ! vr_150 && ! vr_151
? vl_228
: ( vr_150 && ! vr_151
? vl_229
: vl_230 ) ) ;
vl_206 |= vr_132 -> vr_153 != vl_228 ;
if ( vr_136 )
error ( 0 , vl_182 , lr_62 , fn_83 ( vr_145 ) ) ;
}
if ( fn_121 ( vr_132 -> vr_117 . vr_148 )
&& ( vl_45 == vl_46 || vl_47 ) )
{
struct vr_117 vr_154 ;
fn_122 ( vr_145 , vr_132 , vr_61 ) ;
char * vr_133 = fn_123 ( vr_145 , vr_132 -> vr_133 ) ;
if ( vr_133
&& ( vl_107 <= vl_53 || vl_47 )
&& vr_117 ( vr_133 , & vr_154 ) == 0 )
{
vr_132 -> vr_155 = true ;
if ( ! vr_61 || vl_45 == vl_46
|| ! fn_118 ( vr_154 . vr_148 ) )
{
vr_132 -> vr_156 = vr_154 . vr_148 ;
}
}
free ( vr_133 ) ;
}
if ( fn_121 ( vr_132 -> vr_117 . vr_148 ) )
vr_132 -> vr_121 = vl_192 ;
else if ( fn_118 ( vr_132 -> vr_117 . vr_148 ) )
{
if ( vr_61 && ! vl_52 )
vr_132 -> vr_121 = vl_231 ;
else
vr_132 -> vr_121 = vl_74 ;
}
else
vr_132 -> vr_121 = vl_194 ;
vr_144 = fn_124 ( vr_132 -> vr_117 ) ;
if ( vl_45 == vl_46 || vl_64 )
{
char vr_101 [ vl_199 + 1 ] ;
int vr_33 = fn_125 ( fn_96 ( vr_144 , vr_101 , vl_110 ,
vl_200 , vl_115 ) ,
0 ) ;
if ( vl_208 < vr_33 )
vl_208 = vr_33 ;
}
if ( vl_45 == vl_46 )
{
if ( vl_108 )
{
int vr_33 = fn_126 ( vr_132 -> vr_117 . vr_157 ) ;
if ( vl_210 < vr_33 )
vl_210 = vr_33 ;
}
if ( vl_117 )
{
int vr_33 = fn_127 ( vr_132 -> vr_117 . vr_158 ) ;
if ( vl_211 < vr_33 )
vl_211 = vr_33 ;
}
if ( vl_131 )
{
int vr_33 = fn_126 ( vr_132 -> vr_117 . vr_159 ) ;
if ( vl_212 < vr_33 )
vl_212 = vr_33 ;
}
}
if ( vl_63 )
{
int vr_33 = strlen ( vr_132 -> vr_134 ) ;
if ( vl_213 < vr_33 )
vl_213 = vr_33 ;
}
if ( vl_45 == vl_46 )
{
char vr_25 [ fn_128 ( vl_7 ) ] ;
int vr_160 = strlen ( fn_129 ( vr_132 -> vr_117 . vr_161 , vr_25 ) ) ;
if ( vl_209 < vr_160 )
vl_209 = vr_160 ;
if ( fn_130 ( vr_132 -> vr_117 . vr_148 ) || fn_131 ( vr_132 -> vr_117 . vr_148 ) )
{
char vr_101 [ fn_128 ( vl_7 ) ] ;
int vr_33 = strlen ( fn_129 ( fn_132 ( vr_132 -> vr_117 . vr_162 ) , vr_101 ) ) ;
if ( vl_214 < vr_33 )
vl_214 = vr_33 ;
vr_33 = strlen ( fn_129 ( fn_133 ( vr_132 -> vr_117 . vr_162 ) , vr_101 ) ) ;
if ( vl_215 < vr_33 )
vl_215 = vr_33 ;
vr_33 = vl_214 + 2 + vl_215 ;
if ( vl_216 < vr_33 )
vl_216 = vr_33 ;
}
else
{
char vr_101 [ vl_199 + 1 ] ;
vl_7 vr_126 = fn_99 ( vr_132 -> vr_117 . vr_163 ) ;
int vr_33 = fn_125 ( fn_96 ( vr_126 , vr_101 ,
vl_109 ,
1 , vl_114 ) ,
0 ) ;
if ( vl_216 < vr_33 )
vl_216 = vr_33 ;
}
}
}
if ( vl_92 )
{
char vr_101 [ fn_128 ( vl_7 ) ] ;
int vr_33 = strlen ( fn_129 ( vr_132 -> vr_117 . vr_8 , vr_101 ) ) ;
if ( vl_207 < vr_33 )
vl_207 = vr_33 ;
}
vr_132 -> vr_30 = fn_79 ( vr_30 ) ;
vl_73 ++ ;
return vr_144 ;
}
static bool
fn_134 ( const struct vr_131 * vr_132 )
{
return vr_132 -> vr_121 == vl_74 || vr_132 -> vr_121 == vl_231 ;
}
static void
fn_122 ( char const * vr_164 , struct vr_131 * vr_132 , bool vr_61 )
{
vr_132 -> vr_133 = fn_135 ( vr_164 , vr_132 -> vr_117 . vr_163 ) ;
if ( vr_132 -> vr_133 == NULL )
fn_82 ( vr_61 , _ ( lr_63 ) ,
vr_164 ) ;
}
static char *
fn_123 ( char const * vr_30 , char const * vr_133 )
{
if ( ! vr_133 )
return NULL ;
if ( fn_136 ( vr_133 ) )
return fn_79 ( vr_133 ) ;
tp_3 vr_165 = fn_137 ( vr_30 ) ;
if ( vr_165 == 0 )
return fn_79 ( vr_133 ) ;
char * vr_22 = xmalloc ( vr_165 + 1 + strlen ( vr_133 ) + 1 ) ;
if ( ! fn_138 ( vr_30 [ vr_165 - 1 ] ) )
++ vr_165 ;
fn_139 ( fn_140 ( vr_22 , vr_30 , vr_165 ) , vr_133 ) ;
return vr_22 ;
}
static bool
fn_141 ( const char * vr_30 )
{
char const * vr_166 = fn_142 ( vr_30 ) ;
return fn_143 ( vr_166 ) ;
}
static void
fn_48 ( char const * vr_143 , bool vr_61 )
{
tp_3 vr_13 ;
tp_3 vr_53 ;
bool vr_167 = ( vr_143 != NULL ) ;
if ( vr_143 && vl_77 )
{
fn_46 ( NULL , vr_143 , false ) ;
}
for ( vr_13 = vl_73 ; vr_13 -- != 0 ; )
{
struct vr_131 * vr_132 = vr_135 [ vr_13 ] ;
if ( fn_134 ( vr_132 )
&& ( ! vr_167
|| ! fn_141 ( vr_132 -> vr_30 ) ) )
{
if ( ! vr_143 || vr_132 -> vr_30 [ 0 ] == '/' )
fn_46 ( vr_132 -> vr_30 , vr_132 -> vr_133 , vr_61 ) ;
else
{
char * vr_30 = fn_144 ( vr_143 , vr_132 -> vr_30 , NULL ) ;
fn_46 ( vr_30 , vr_132 -> vr_133 , vr_61 ) ;
free ( vr_30 ) ;
}
if ( vr_132 -> vr_121 == vl_231 )
fn_104 ( vr_132 ) ;
}
}
for ( vr_13 = 0 , vr_53 = 0 ; vr_13 < vl_73 ; vr_13 ++ )
{
struct vr_131 * vr_132 = vr_135 [ vr_13 ] ;
vr_135 [ vr_53 ] = vr_132 ;
vr_53 += ( vr_132 -> vr_121 != vl_231 ) ;
}
vl_73 = vr_53 ;
}
static int
fn_145 ( char const * vr_24 , char const * vr_25 )
{
int vr_168 ;
vl_182 = 0 ;
vr_168 = strcoll ( vr_24 , vr_25 ) ;
if ( vl_182 )
{
error ( 0 , vl_182 , _ ( lr_64 ) ,
fn_146 ( 0 , vr_24 ) , fn_146 ( 1 , vr_25 ) ) ;
fn_81 ( false ) ;
longjmp ( vl_232 , 1 ) ;
}
return vr_168 ;
}
static inline int
fn_147 ( struct vr_131 const * vr_24 , struct vr_131 const * vr_25 ,
int (* fn_148) ( char const * , char const * ) )
{
int vr_168 = fn_149 ( fn_150 ( & vr_25 -> vr_117 ) ,
fn_150 ( & vr_24 -> vr_117 ) ) ;
return vr_168 ? vr_168 : fn_148 ( vr_24 -> vr_30 , vr_25 -> vr_30 ) ;
}
static inline int
fn_151 ( struct vr_131 const * vr_24 , struct vr_131 const * vr_25 ,
int (* fn_148) ( char const * , char const * ) )
{
int vr_168 = fn_149 ( fn_152 ( & vr_25 -> vr_117 ) ,
fn_152 ( & vr_24 -> vr_117 ) ) ;
return vr_168 ? vr_168 : fn_148 ( vr_24 -> vr_30 , vr_25 -> vr_30 ) ;
}
static inline int
fn_153 ( struct vr_131 const * vr_24 , struct vr_131 const * vr_25 ,
int (* fn_148) ( char const * , char const * ) )
{
int vr_168 = fn_149 ( fn_154 ( & vr_25 -> vr_117 ) ,
fn_154 ( & vr_24 -> vr_117 ) ) ;
return vr_168 ? vr_168 : fn_148 ( vr_24 -> vr_30 , vr_25 -> vr_30 ) ;
}
static inline int
fn_155 ( struct vr_131 const * vr_24 , struct vr_131 const * vr_25 ,
int (* fn_148) ( char const * , char const * ) )
{
int vr_168 = fn_156 ( vr_25 -> vr_117 . vr_163 , vr_24 -> vr_117 . vr_163 ) ;
return vr_168 ? vr_168 : fn_148 ( vr_24 -> vr_30 , vr_25 -> vr_30 ) ;
}
static inline int
fn_157 ( struct vr_131 const * vr_24 , struct vr_131 const * vr_25 ,
int (* fn_148) ( char const * , char const * ) )
{
return fn_148 ( vr_24 -> vr_30 , vr_25 -> vr_30 ) ;
}
static inline int
fn_158 ( struct vr_131 const * vr_24 , struct vr_131 const * vr_25 ,
int (* fn_148) ( char const * , char const * ) )
{
char const * vr_169 = strrchr ( vr_24 -> vr_30 , '.' ) ;
char const * vr_170 = strrchr ( vr_25 -> vr_30 , '.' ) ;
int vr_168 = fn_148 ( vr_169 ? vr_169 : lr_4 , vr_170 ? vr_170 : lr_4 ) ;
return vr_168 ? vr_168 : fn_148 ( vr_24 -> vr_30 , vr_25 -> vr_30 ) ;
}
static inline int
fn_159 ( struct vr_131 const * vr_24 , struct vr_131 const * vr_25 )
{
return fn_160 ( vr_24 -> vr_30 , vr_25 -> vr_30 ) ;
}
static int fn_161 ( tp_9 vr_24 , tp_9 vr_25 )
{ return fn_159 ( vr_24 , vr_25 ) ; }
static int fn_162 ( tp_9 vr_24 , tp_9 vr_25 )
{ return fn_159 ( vr_25 , vr_24 ) ; }
static int fn_163 ( tp_9 vr_24 , tp_9 vr_25 )
{ fn_164 ( vr_24 , vr_25 ) ; return fn_159 ( vr_24 , vr_25 ) ; }
static int fn_165 ( tp_9 vr_24 , tp_9 vr_25 )
{ fn_164 ( vr_24 , vr_25 ) ; return fn_159 ( vr_25 , vr_24 ) ; }
static void
fn_166 ( void )
{
tp_3 vr_13 ;
for ( vr_13 = 0 ; vr_13 < vl_73 ; vr_13 ++ )
vr_135 [ vr_13 ] = & vl_72 [ vr_13 ] ;
}
static void
fn_47 ( void )
{
bool vr_171 ;
if ( vl_233 < vl_73 + vl_73 / 2 )
{
free ( vr_135 ) ;
vr_135 = fn_43 ( vl_73 , 3 * sizeof *vr_135 ) ;
vl_233 = 3 * vl_73 ;
}
fn_166 () ;
if ( vl_60 == vl_105 )
return;
if ( ! setjmp ( vl_232 ) )
vr_171 = false ;
else
{
vr_171 = true ;
assert ( vl_60 != vl_120 ) ;
fn_166 () ;
}
fn_167 ( ( void const * * ) vr_135 , vl_73 ,
vr_172 [ vl_60 + ( vl_60 == vl_61 ? vl_87 : 0 ) ]
[ vr_171 ] [ vl_90 ]
[ vl_67 ] ) ;
}
static void
fn_49 ( void )
{
tp_3 vr_13 ;
switch ( vl_45 )
{
case vl_86 :
for ( vr_13 = 0 ; vr_13 < vl_73 ; vr_13 ++ )
{
fn_168 ( vr_135 [ vr_13 ] , 0 ) ;
putchar ( '\n' ) ;
}
break;
case vl_82 :
fn_169 () ;
break;
case vl_122 :
fn_170 () ;
break;
case vl_116 :
fn_171 () ;
break;
case vl_46 :
for ( vr_13 = 0 ; vr_13 < vl_73 ; vr_13 ++ )
{
fn_23 () ;
fn_172 ( vr_135 [ vr_13 ] ) ;
fn_50 ( '\n' ) ;
}
break;
}
}
static tp_3
fn_173 ( char * vr_101 , tp_3 vr_126 , char const * vr_173 , struct vr_174 const * vr_174 ,
int vr_175 , int vr_176 )
{
const char * vr_177 = vr_173 ;
char vr_178 [ sizeof ( vr_19 [ 0 ] ) + 100 ] ;
const char * vr_179 ;
if ( vl_3 && ( vr_179 = strstr ( vr_173 , lr_44 ) ) )
{
if ( strlen ( vr_173 ) < ( sizeof ( vr_178 ) - sizeof ( vr_19 [ 0 ] ) + 2 ) )
{
char * vr_180 = vr_178 ;
vr_177 = vr_178 ;
vr_180 = fn_174 ( vr_180 , vr_173 , vr_179 - vr_173 ) ;
vr_180 = fn_139 ( vr_180 , vr_19 [ vr_174 -> vr_181 ] ) ;
strcpy ( vr_180 , vr_179 + 2 ) ;
}
}
tp_3 vr_182 = fn_175 ( vr_101 , vr_126 , vr_177 , vr_174 , vr_175 , vr_176 ) ;
return vr_182 ;
}
static int
fn_176 ( void )
{
static int vr_17 = - 1 ;
if ( vr_17 < 0 )
{
vl_40 vr_183 = 0 ;
struct vr_174 const * vr_174 = localtime ( & vr_183 ) ;
char vr_101 [ vl_234 + 1 ] ;
if ( vr_174 )
{
tp_3 vr_33 =
fn_173 ( vr_101 , sizeof vr_101 , vr_84 [ 0 ] , vr_174 , 0 , 0 ) ;
if ( vr_33 != 0 )
vr_17 = fn_177 ( vr_101 , vr_33 , 0 ) ;
}
if ( vr_17 < 0 )
vr_17 = 0 ;
}
return vr_17 ;
}
static void
fn_178 ( char const * vr_30 , unsigned long int vr_184 , int vr_17 )
{
tp_3 vr_33 ;
if ( vr_30 )
{
int vr_185 = vr_17 - fn_125 ( vr_30 , 0 ) ;
int vr_186 = fn_10 ( 0 , vr_185 ) ;
fputs ( vr_30 , stdout ) ;
vr_33 = strlen ( vr_30 ) + vr_186 ;
do
putchar ( ' ' ) ;
while ( vr_186 -- );
}
else
{
printf ( lr_65 , vr_17 , vr_184 ) ;
vr_33 = vr_17 ;
}
vl_2 += vr_33 + 1 ;
}
static void
fn_179 ( tp_10 vr_187 , int vr_17 , bool vr_149 )
{
fn_178 ( ! vr_149 ? lr_66 :
( vl_91 ? NULL : fn_180 ( vr_187 ) ) , vr_187 , vr_17 ) ;
}
static void
fn_181 ( tp_11 vr_188 , int vr_17 , bool vr_149 )
{
fn_178 ( ! vr_149 ? lr_66 :
( vl_91 ? NULL : fn_182 ( vr_188 ) ) , vr_188 , vr_17 ) ;
}
static int
fn_183 ( char const * vr_30 , unsigned long int vr_184 )
{
if ( vr_30 )
{
int vr_33 = fn_125 ( vr_30 , 0 ) ;
return fn_10 ( 0 , vr_33 ) ;
}
else
{
char vr_101 [ fn_128 ( vr_184 ) ] ;
sprintf ( vr_101 , lr_67 , vr_184 ) ;
return strlen ( vr_101 ) ;
}
}
static int
fn_126 ( tp_10 vr_187 )
{
return fn_183 ( vl_91 ? NULL : fn_180 ( vr_187 ) , vr_187 ) ;
}
static int
fn_127 ( tp_11 vr_188 )
{
return fn_183 ( vl_91 ? NULL : fn_182 ( vr_188 ) , vr_188 ) ;
}
static char *
fn_184 ( char * vr_101 , tp_3 vr_189 , const struct vr_131 * vr_132 )
{
assert ( fn_128 ( vl_7 ) <= vr_189 ) ;
return ( vr_132 -> vr_149 && vr_132 -> vr_117 . vr_8 != vl_75
? fn_129 ( vr_132 -> vr_117 . vr_8 , vr_101 )
: ( char * ) lr_66 ) ;
}
static void
fn_172 ( const struct vr_131 * vr_132 )
{
char vr_190 [ 12 ] ;
char vr_101
[ vl_199 + 1
+ vl_199 + 1
+ sizeof ( vr_190 ) - 1 + 1
+ fn_128 ( vl_7 )
+ vl_199 + 2
+ vl_199 + 1
+ vl_234 + 1
] ;
tp_3 vr_35 ;
char * vr_22 ;
struct vr_191 vr_192 ;
struct vr_174 * vr_193 ;
if ( vr_132 -> vr_149 )
fn_185 ( & vr_132 -> vr_117 , vr_190 ) ;
else
{
vr_190 [ 0 ] = vr_194 [ vr_132 -> vr_121 ] ;
memset ( vr_190 + 1 , '?' , 10 ) ;
vr_190 [ 11 ] = '\0' ;
}
if ( ! vl_206 )
vr_190 [ 10 ] = '\0' ;
else if ( vr_132 -> vr_153 == vl_229 )
vr_190 [ 10 ] = '.' ;
else if ( vr_132 -> vr_153 == vl_230 )
vr_190 [ 10 ] = '+' ;
switch ( vl_87 )
{
case vl_104 :
vr_192 = fn_150 ( & vr_132 -> vr_117 ) ;
break;
case vl_88 :
vr_192 = fn_152 ( & vr_132 -> vr_117 ) ;
break;
case vl_119 :
vr_192 = fn_154 ( & vr_132 -> vr_117 ) ;
break;
default:
abort () ;
}
vr_22 = vr_101 ;
if ( vl_92 )
{
char vr_195 [ fn_128 ( vl_7 ) ] ;
sprintf ( vr_22 , lr_68 , vl_207 ,
fn_184 ( vr_195 , sizeof vr_195 , vr_132 ) ) ;
vr_22 += strlen ( vr_22 ) ;
}
if ( vl_64 )
{
char vr_195 [ vl_199 + 1 ] ;
char const * vr_144 =
( ! vr_132 -> vr_149
? lr_66
: fn_96 ( fn_124 ( vr_132 -> vr_117 ) , vr_195 , vl_110 ,
vl_200 , vl_115 ) ) ;
int vr_186 ;
for ( vr_186 = vl_208 - fn_125 ( vr_144 , 0 ) ; 0 < vr_186 ; vr_186 -- )
* vr_22 ++ = ' ' ;
while ( ( * vr_22 ++ = * vr_144 ++ ) )
continue;
vr_22 [ - 1 ] = ' ' ;
}
{
char vr_195 [ fn_128 ( vl_7 ) ] ;
sprintf ( vr_22 , lr_69 , vr_190 , vl_209 ,
! vr_132 -> vr_149 ? lr_66 : fn_129 ( vr_132 -> vr_117 . vr_161 , vr_195 ) ) ;
}
vr_22 += strlen ( vr_22 ) ;
fn_88 () ;
if ( vl_108 || vl_117 || vl_131 || vl_63 )
{
fn_95 ( vr_101 , stdout , vr_22 - vr_101 ) ;
if ( vl_108 )
fn_179 ( vr_132 -> vr_117 . vr_157 , vl_210 , vr_132 -> vr_149 ) ;
if ( vl_117 )
fn_181 ( vr_132 -> vr_117 . vr_158 , vl_211 , vr_132 -> vr_149 ) ;
if ( vl_131 )
fn_179 ( vr_132 -> vr_117 . vr_159 , vl_212 , vr_132 -> vr_149 ) ;
if ( vl_63 )
fn_178 ( vr_132 -> vr_134 , 0 , vl_213 ) ;
vr_22 = vr_101 ;
}
if ( vr_132 -> vr_149
&& ( fn_130 ( vr_132 -> vr_117 . vr_148 ) || fn_131 ( vr_132 -> vr_117 . vr_148 ) ) )
{
char vr_196 [ fn_128 ( vl_7 ) ] ;
char vr_197 [ fn_128 ( vl_7 ) ] ;
int vr_198 = ( vl_216
- ( vl_214 + 2
+ vl_215 ) ) ;
sprintf ( vr_22 , lr_70 ,
vl_214 + fn_10 ( 0 , vr_198 ) ,
fn_129 ( fn_132 ( vr_132 -> vr_117 . vr_162 ) , vr_196 ) ,
vl_215 ,
fn_129 ( fn_133 ( vr_132 -> vr_117 . vr_162 ) , vr_197 ) ) ;
vr_22 += vl_216 + 1 ;
}
else
{
char vr_195 [ vl_199 + 1 ] ;
char const * vr_126 =
( ! vr_132 -> vr_149
? lr_66
: fn_96 ( fn_99 ( vr_132 -> vr_117 . vr_163 ) ,
vr_195 , vl_109 , 1 ,
vl_114 ) ) ;
int vr_186 ;
for ( vr_186 = vl_216 - fn_125 ( vr_126 , 0 ) ; 0 < vr_186 ; vr_186 -- )
* vr_22 ++ = ' ' ;
while ( ( * vr_22 ++ = * vr_126 ++ ) )
continue;
vr_22 [ - 1 ] = ' ' ;
}
vr_193 = localtime ( & vr_192 . vr_51 ) ;
vr_35 = 0 ;
* vr_22 = '\1' ;
if ( vr_132 -> vr_149 && vr_193 )
{
struct vr_191 vr_199 ;
bool vr_200 ;
char const * vr_173 ;
if ( fn_149 ( vr_50 , vr_192 ) < 0 )
{
fn_186 ( & vr_50 ) ;
}
vr_199 . vr_51 = vr_50 . vr_51 - 31556952 / 2 ;
vr_199 . vr_52 = vr_50 . vr_52 ;
vr_200 = ( fn_149 ( vr_199 , vr_192 ) < 0
&& ( fn_149 ( vr_192 , vr_50 ) < 0 ) ) ;
vr_173 = vr_84 [ vr_200 ] ;
vr_35 = fn_173 ( vr_22 , vl_234 + 1 , vr_173 ,
vr_193 , 0 , vr_192 . vr_52 ) ;
}
if ( vr_35 || ! * vr_22 )
{
vr_22 += vr_35 ;
* vr_22 ++ = ' ' ;
* vr_22 = '\0' ;
}
else
{
char vr_195 [ fn_128 ( vl_235 ) ] ;
sprintf ( vr_22 , lr_68 , fn_176 () ,
( ! vr_132 -> vr_149
? lr_66
: fn_187 ( vr_192 . vr_51 , vr_195 ) ) ) ;
vr_22 += strlen ( vr_22 ) ;
}
fn_95 ( vr_101 , stdout , vr_22 - vr_101 ) ;
tp_3 vr_201 = fn_188 ( vr_132 , false , & vl_69 , vr_22 - vr_101 ) ;
if ( vr_132 -> vr_121 == vl_192 )
{
if ( vr_132 -> vr_133 )
{
fn_91 ( lr_71 , stdout ) ;
fn_188 ( vr_132 , true , NULL , ( vr_22 - vr_101 ) + vr_201 + 4 ) ;
if ( vl_53 != vl_66 )
fn_189 ( true , vr_132 -> vr_156 , vl_76 ) ;
}
}
else if ( vl_53 != vl_66 )
fn_189 ( vr_132 -> vr_149 , vr_132 -> vr_117 . vr_148 , vr_132 -> vr_121 ) ;
}
static tp_3
fn_90 ( tp_12 * vr_202 , const char * vr_30 , struct vr_203 const * vr_204 ,
tp_3 * vr_17 )
{
char vr_205 [ vl_236 ] ;
tp_3 vr_33 = fn_190 ( vr_205 , sizeof vr_205 , vr_30 , - 1 , vr_204 ) ;
char * vr_101 ;
tp_3 tp_13 vr_206 ( = 0 ) ;
if ( vr_33 < sizeof vr_205 )
vr_101 = vr_205 ;
else
{
vr_101 = fn_116 ( vr_33 + 1 ) ;
fn_190 ( vr_101 , vr_33 + 1 , vr_30 , - 1 , vr_204 ) ;
}
if ( vl_79 )
{
if ( vl_237 > 1 )
{
char const * vr_22 = vr_101 ;
char const * vr_207 = vr_101 + vr_33 ;
char * vr_100 = vr_101 ;
tp_13 = 0 ;
while ( vr_22 < vr_207 )
switch ( * vr_22 )
{
case ' ' : case '!' : case '"' : case '#' : case '%' :
case '&' : case '\'' : case '(' : case ')' : case '*' :
case '+' : case ',' : case '-' : case '.' : case '/' :
case '0' : case '1' : case '2' : case '3' : case '4' :
case '5' : case '6' : case '7' : case '8' : case '9' :
case ':' : case ';' : case '<' : case '=' : case '>' :
case '?' :
case 'A' : case 'B' : case 'C' : case 'D' : case 'E' :
case 'F' : case 'G' : case 'H' : case 'I' : case 'J' :
case 'K' : case 'L' : case 'M' : case 'N' : case 'O' :
case 'P' : case 'Q' : case 'R' : case 'S' : case 'T' :
case 'U' : case 'V' : case 'W' : case 'X' : case 'Y' :
case 'Z' :
case '[' : case '\\' : case ']' : case '^' : case '_' :
case 'a' : case 'b' : case 'c' : case 'd' : case 'e' :
case 'f' : case 'g' : case 'h' : case 'i' : case 'j' :
case 'k' : case 'l' : case 'm' : case 'n' : case 'o' :
case 'p' : case 'q' : case 'r' : case 's' : case 't' :
case 'u' : case 'v' : case 'w' : case 'x' : case 'y' :
case 'z' : case '{' : case '|' : case '}' : case '~' :
* vr_100 ++ = * vr_22 ++ ;
tp_13 += 1 ;
break;
default:
{
tp_14 vr_208 = { 0 , } ;
do
{
tp_15 vr_209 ;
tp_3 vr_210 ;
int vr_201 ;
vr_210 = mbrtowc ( & vr_209 , vr_22 , vr_207 - vr_22 , & vr_208 ) ;
if ( vr_210 == ( tp_3 ) - 1 )
{
vr_22 ++ ;
* vr_100 ++ = '?' ;
tp_13 += 1 ;
break;
}
if ( vr_210 == ( tp_3 ) - 2 )
{
vr_22 = vr_207 ;
* vr_100 ++ = '?' ;
tp_13 += 1 ;
break;
}
if ( vr_210 == 0 )
vr_210 = 1 ;
vr_201 = wcwidth ( vr_209 ) ;
if ( vr_201 >= 0 )
{
for (; vr_210 > 0 ; -- vr_210 )
* vr_100 ++ = * vr_22 ++ ;
tp_13 += vr_201 ;
}
else
{
vr_22 += vr_210 ;
* vr_100 ++ = '?' ;
tp_13 += 1 ;
}
}
while ( ! mbsinit ( & vr_208 ) );
}
break;
}
vr_33 = vr_100 - vr_101 ;
}
else
{
char * vr_22 = vr_101 ;
char const * vr_207 = vr_101 + vr_33 ;
while ( vr_22 < vr_207 )
{
if ( ! isprint ( fn_191 ( * vr_22 ) ) )
* vr_22 = '?' ;
vr_22 ++ ;
}
tp_13 = vr_33 ;
}
}
else if ( vr_17 != NULL )
{
if ( vl_237 > 1 )
tp_13 = fn_177 ( vr_101 , vr_33 , 0 ) ;
else
{
char const * vr_22 = vr_101 ;
char const * vr_207 = vr_101 + vr_33 ;
tp_13 = 0 ;
while ( vr_22 < vr_207 )
{
if ( isprint ( fn_191 ( * vr_22 ) ) )
tp_13 ++ ;
vr_22 ++ ;
}
}
}
if ( vr_202 != NULL )
fwrite ( vr_101 , 1 , vr_33 , vr_202 ) ;
if ( vr_17 != NULL )
* vr_17 = tp_13 ;
return vr_33 ;
}
static tp_3
fn_188 ( const struct vr_131 * vr_132 ,
bool vr_211 ,
struct vr_10 * vr_212 ,
tp_3 vr_213 )
{
const char * vr_30 = vr_211 ? vr_132 -> vr_133 : vr_132 -> vr_30 ;
bool vr_214
= ( vl_11
&& ( fn_192 ( vr_132 , vr_211 )
|| fn_19 ( vl_12 ) ) ) ;
if ( vr_212 )
fn_89 ( vr_212 ) ;
tp_3 vr_17 = fn_90 ( stdout , vr_30 , vl_78 , NULL ) ;
vl_2 += vr_17 ;
if ( vr_212 )
fn_89 ( vr_212 ) ;
fn_26 () ;
if ( vr_214 )
{
fn_193 () ;
if ( vr_213 / vl_98 != ( vr_213 + vr_17 - 1 ) / vl_98 )
fn_22 ( & vr_34 [ vl_238 ] ) ;
}
return vr_17 ;
}
static void
fn_193 ( void )
{
if ( vr_34 [ vl_239 ] . string != NULL )
fn_22 ( & vr_34 [ vl_239 ] ) ;
else
{
fn_22 ( & vr_34 [ vl_9 ] ) ;
fn_22 ( & vr_34 [ vl_240 ] ) ;
fn_22 ( & vr_34 [ vl_10 ] ) ;
}
}
static tp_3
fn_168 ( const struct vr_131 * vr_132 , tp_3 vr_213 )
{
char vr_101 [ fn_10 ( vl_199 + 1 , fn_128 ( vl_7 ) ) ] ;
fn_23 () ;
if ( vl_92 )
printf ( lr_68 , vl_45 == vl_116 ? 0 : vl_207 ,
fn_184 ( vr_101 , sizeof vr_101 , vr_132 ) ) ;
if ( vl_64 )
printf ( lr_68 , vl_45 == vl_116 ? 0 : vl_208 ,
! vr_132 -> vr_149 ? lr_66
: fn_96 ( fn_124 ( vr_132 -> vr_117 ) , vr_101 , vl_110 ,
vl_200 , vl_115 ) ) ;
if ( vl_63 )
printf ( lr_68 , vl_45 == vl_116 ? 0 : vl_213 , vr_132 -> vr_134 ) ;
tp_3 vr_17 = fn_188 ( vr_132 , false , NULL , vr_213 ) ;
if ( vl_53 != vl_66 )
vr_17 += fn_189 ( vr_132 -> vr_149 , vr_132 -> vr_117 . vr_148 , vr_132 -> vr_121 ) ;
return vr_17 ;
}
static char
fn_194 ( bool vr_149 , tp_16 vr_215 , enum vr_121 type )
{
char vr_73 ;
if ( vr_149 ? fn_120 ( vr_215 ) : type == vl_194 )
{
if ( vr_149 && vl_53 == vl_54 && ( vr_215 & vl_241 ) )
vr_73 = '*' ;
else
vr_73 = 0 ;
}
else
{
if ( vr_149 ? fn_118 ( vr_215 ) : type == vl_74 || type == vl_231 )
vr_73 = '/' ;
else if ( vl_53 == vl_118 )
vr_73 = 0 ;
else if ( vr_149 ? fn_121 ( vr_215 ) : type == vl_192 )
vr_73 = '@' ;
else if ( vr_149 ? fn_195 ( vr_215 ) : type == vl_190 )
vr_73 = '|' ;
else if ( vr_149 ? fn_196 ( vr_215 ) : type == vl_196 )
vr_73 = '=' ;
else if ( vr_149 && fn_197 ( vr_215 ) )
vr_73 = '>' ;
else
vr_73 = 0 ;
}
return vr_73 ;
}
static bool
fn_189 ( bool vr_149 , tp_16 vr_215 , enum vr_121 type )
{
char vr_73 = fn_194 ( vr_149 , vr_215 , type ) ;
if ( vr_73 )
fn_50 ( vr_73 ) ;
return ! ! vr_73 ;
}
static bool
fn_192 ( const struct vr_131 * vr_132 , bool vr_211 )
{
enum vr_32 type ;
struct vr_104 * vr_105 ;
tp_3 vr_33 ;
const char * vr_30 ;
tp_16 vr_215 ;
int vr_155 ;
if ( vr_211 )
{
vr_30 = vr_132 -> vr_133 ;
vr_215 = vr_132 -> vr_156 ;
vr_155 = vr_132 -> vr_155 ? 0 : - 1 ;
}
else
{
vr_30 = vr_132 -> vr_30 ;
vr_215 = fn_198 ( vr_132 ) ;
vr_155 = vr_132 -> vr_155 ;
}
if ( vr_155 == - 1 && fn_19 ( vl_44 ) )
type = vl_44 ;
else if ( ! vr_132 -> vr_149 )
{
static enum vr_32 vr_216 [] = vl_242 ;
type = vr_216 [ vr_132 -> vr_121 ] ;
}
else
{
if ( fn_120 ( vr_215 ) )
{
type = vl_243 ;
if ( ( vr_215 & vl_244 ) != 0 && fn_19 ( vl_223 ) )
type = vl_223 ;
else if ( ( vr_215 & vl_245 ) != 0 && fn_19 ( vl_224 ) )
type = vl_224 ;
else if ( fn_19 ( vl_225 ) && vr_132 -> fn_100 )
type = vl_225 ;
else if ( ( vr_215 & vl_241 ) != 0 && fn_19 ( vl_42 ) )
type = vl_42 ;
else if ( ( 1 < vr_132 -> vr_117 . vr_161 ) && fn_19 ( vl_246 ) )
type = vl_246 ;
}
else if ( fn_118 ( vr_215 ) )
{
type = vl_247 ;
if ( ( vr_215 & vl_248 ) && ( vr_215 & vl_249 )
&& fn_19 ( vl_222 ) )
type = vl_222 ;
else if ( ( vr_215 & vl_249 ) != 0 && fn_19 ( vl_220 ) )
type = vl_220 ;
else if ( ( vr_215 & vl_248 ) != 0 && fn_19 ( vl_221 ) )
type = vl_221 ;
}
else if ( fn_121 ( vr_215 ) )
type = vl_180 ;
else if ( fn_195 ( vr_215 ) )
type = vl_250 ;
else if ( fn_196 ( vr_215 ) )
type = vl_251 ;
else if ( fn_131 ( vr_215 ) )
type = vl_252 ;
else if ( fn_130 ( vr_215 ) )
type = vl_253 ;
else if ( fn_197 ( vr_215 ) )
type = vl_254 ;
else
{
type = vl_41 ;
}
}
vr_105 = NULL ;
if ( type == vl_243 )
{
vr_33 = strlen ( vr_30 ) ;
vr_30 += vr_33 ;
for ( vr_105 = vl_174 ; vr_105 != NULL ; vr_105 = vr_105 -> vr_59 )
{
if ( vr_105 -> vr_105 . vr_33 <= vr_33
&& fn_72 ( vr_30 - vr_105 -> vr_105 . vr_33 , vr_105 -> vr_105 . string ,
vr_105 -> vr_105 . vr_33 ) )
break;
}
}
if ( type == vl_180 && ! vr_155 )
{
if ( vl_43 || fn_19 ( vl_41 ) )
type = vl_41 ;
}
{
const struct vr_217 * const vr_35
= vr_105 ? & ( vr_105 -> vr_107 ) : & vr_34 [ type ] ;
if ( vr_35 -> string != NULL )
{
if ( fn_19 ( vl_12 ) )
fn_21 () ;
fn_22 ( & vr_34 [ vl_9 ] ) ;
fn_22 ( vr_35 ) ;
fn_22 ( & vr_34 [ vl_10 ] ) ;
return true ;
}
else
return false ;
}
}
static void
fn_22 ( const struct vr_217 * vr_218 )
{
if ( ! vl_17 )
{
vl_17 = true ;
fn_193 () ;
}
fwrite ( vr_218 -> string , vr_218 -> vr_33 , 1 , stdout ) ;
}
static tp_3
fn_199 ( const struct vr_131 * vr_132 )
{
tp_3 vr_33 = 0 ;
tp_3 vr_219 ;
char vr_101 [ fn_10 ( vl_199 + 1 , fn_128 ( vl_7 ) ) ] ;
if ( vl_92 )
vr_33 += 1 + ( vl_45 == vl_116
? strlen ( fn_129 ( vr_132 -> vr_117 . vr_8 , vr_101 ) )
: vl_207 ) ;
if ( vl_64 )
vr_33 += 1 + ( vl_45 == vl_116
? strlen ( ! vr_132 -> vr_149 ? lr_66
: fn_96 ( fn_124 ( vr_132 -> vr_117 ) , vr_101 ,
vl_110 , vl_200 ,
vl_115 ) )
: vl_208 ) ;
if ( vl_63 )
vr_33 += 1 + ( vl_45 == vl_116 ? strlen ( vr_132 -> vr_134 ) : vl_213 ) ;
fn_90 ( NULL , vr_132 -> vr_30 , vl_78 , & vr_219 ) ;
vr_33 += vr_219 ;
if ( vl_53 != vl_66 )
{
char vr_73 = fn_194 ( vr_132 -> vr_149 , vr_132 -> vr_117 . vr_148 , vr_132 -> vr_121 ) ;
vr_33 += ( vr_73 != 0 ) ;
}
return vr_33 ;
}
static void
fn_169 ( void )
{
tp_3 vr_220 ;
tp_3 vr_221 = fn_200 ( true ) ;
struct vr_222 const * vr_223 = & vr_222 [ vr_221 - 1 ] ;
tp_3 vr_224 = vl_73 / vr_221 + ( vl_73 % vr_221 != 0 ) ;
for ( vr_220 = 0 ; vr_220 < vr_224 ; vr_220 ++ )
{
tp_3 vr_225 = 0 ;
tp_3 vr_226 = vr_220 ;
tp_3 vr_14 = 0 ;
while ( 1 )
{
struct vr_131 const * vr_132 = vr_135 [ vr_226 ] ;
tp_3 vr_227 = fn_199 ( vr_132 ) ;
tp_3 vr_228 = vr_223 -> vr_229 [ vr_225 ++ ] ;
fn_168 ( vr_132 , vr_14 ) ;
vr_226 += vr_224 ;
if ( vr_226 >= vl_73 )
break;
fn_201 ( vr_14 + vr_227 , vr_14 + vr_228 ) ;
vr_14 += vr_228 ;
}
putchar ( '\n' ) ;
}
}
static void
fn_170 ( void )
{
tp_3 vr_226 ;
tp_3 vr_14 = 0 ;
tp_3 vr_221 = fn_200 ( false ) ;
struct vr_222 const * vr_223 = & vr_222 [ vr_221 - 1 ] ;
struct vr_131 const * vr_132 = vr_135 [ 0 ] ;
tp_3 vr_227 = fn_199 ( vr_132 ) ;
tp_3 vr_228 = vr_223 -> vr_229 [ 0 ] ;
fn_168 ( vr_132 , 0 ) ;
for ( vr_226 = 1 ; vr_226 < vl_73 ; ++ vr_226 )
{
tp_3 vr_225 = vr_226 % vr_221 ;
if ( vr_225 == 0 )
{
putchar ( '\n' ) ;
vr_14 = 0 ;
}
else
{
fn_201 ( vr_14 + vr_227 , vr_14 + vr_228 ) ;
vr_14 += vr_228 ;
}
vr_132 = vr_135 [ vr_226 ] ;
fn_168 ( vr_132 , vr_14 ) ;
vr_227 = fn_199 ( vr_132 ) ;
vr_228 = vr_223 -> vr_229 [ vr_225 ] ;
}
putchar ( '\n' ) ;
}
static void
fn_171 ( void )
{
tp_3 vr_226 ;
tp_3 vr_14 = 0 ;
for ( vr_226 = 0 ; vr_226 < vl_73 ; vr_226 ++ )
{
struct vr_131 const * vr_132 = vr_135 [ vr_226 ] ;
tp_3 vr_33 = fn_199 ( vr_132 ) ;
if ( vr_226 != 0 )
{
char vr_230 ;
if ( vr_14 + vr_33 + 2 < vl_98 )
{
vr_14 += 2 ;
vr_230 = ' ' ;
}
else
{
vr_14 = 0 ;
vr_230 = '\n' ;
}
putchar ( ',' ) ;
putchar ( vr_230 ) ;
}
fn_168 ( vr_132 , vr_14 ) ;
vr_14 += vr_33 ;
}
putchar ( '\n' ) ;
}
static void
fn_201 ( tp_3 vr_231 , tp_3 vr_232 )
{
while ( vr_231 < vr_232 )
{
if ( vl_101 != 0 && vr_232 / vl_101 > ( vr_231 + 1 ) / vl_101 )
{
putchar ( '\t' ) ;
vr_231 += vl_101 - vr_231 % vl_101 ;
}
else
{
putchar ( ' ' ) ;
vr_231 ++ ;
}
}
}
static void
fn_117 ( char * vr_86 , const char * vr_143 , const char * vr_30 )
{
const char * vr_233 = vr_143 ;
if ( vr_143 [ 0 ] != '.' || vr_143 [ 1 ] != 0 )
{
while ( * vr_233 )
* vr_86 ++ = * vr_233 ++ ;
if ( vr_233 > vr_143 && vr_233 [ - 1 ] != '/' )
* vr_86 ++ = '/' ;
}
while ( * vr_30 )
* vr_86 ++ = * vr_30 ++ ;
* vr_86 = 0 ;
}
static void
fn_202 ( void )
{
tp_3 vr_13 ;
tp_3 vr_234 = fn_203 ( vl_160 , vl_73 ) ;
static tp_3 vr_235 ;
if ( vr_235 < vr_234 )
{
tp_3 vr_236 ;
tp_3 * vr_22 ;
if ( vr_234 < vl_160 / 2 )
{
vr_222 = fn_115 ( vr_222 , vr_234 ,
2 * sizeof *vr_222 ) ;
vr_236 = 2 * vr_234 ;
}
else
{
vr_222 = fn_115 ( vr_222 , vl_160 , sizeof *vr_222 ) ;
vr_236 = vl_160 ;
}
{
tp_3 vr_237 = vr_236 - vr_235 ;
tp_3 vr_35 = vr_235 + 1 + vr_236 ;
tp_3 vr_238 = vr_35 * vr_237 ;
if ( vr_35 < vr_236 || vr_238 / vr_237 != vr_35 )
fn_17 () ;
vr_22 = fn_43 ( vr_238 / 2 , sizeof *vr_22 ) ;
}
for ( vr_13 = vr_235 ; vr_13 < vr_236 ; vr_13 ++ )
{
vr_222 [ vr_13 ] . vr_229 = vr_22 ;
vr_22 += vr_13 + 1 ;
}
vr_235 = vr_236 ;
}
for ( vr_13 = 0 ; vr_13 < vr_234 ; ++ vr_13 )
{
tp_3 vr_53 ;
vr_222 [ vr_13 ] . vl_255 = true ;
vr_222 [ vr_13 ] . vl_256 = ( vr_13 + 1 ) * vl_161 ;
for ( vr_53 = 0 ; vr_53 <= vr_13 ; ++ vr_53 )
vr_222 [ vr_13 ] . vr_229 [ vr_53 ] = vl_161 ;
}
}
static tp_3
fn_200 ( bool vr_239 )
{
tp_3 vr_226 ;
tp_3 vr_221 ;
tp_3 vr_234 = fn_203 ( vl_160 , vl_73 ) ;
fn_202 () ;
for ( vr_226 = 0 ; vr_226 < vl_73 ; ++ vr_226 )
{
struct vr_131 const * vr_132 = vr_135 [ vr_226 ] ;
tp_3 vr_227 = fn_199 ( vr_132 ) ;
tp_3 vr_13 ;
for ( vr_13 = 0 ; vr_13 < vr_234 ; ++ vr_13 )
{
if ( vr_222 [ vr_13 ] . vl_255 )
{
tp_3 vr_240 = ( vr_239
? vr_226 / ( ( vl_73 + vr_13 ) / ( vr_13 + 1 ) )
: vr_226 % ( vr_13 + 1 ) ) ;
tp_3 vr_241 = vr_227 + ( vr_240 == vr_13 ? 0 : 2 ) ;
if ( vr_222 [ vr_13 ] . vr_229 [ vr_240 ] < vr_241 )
{
vr_222 [ vr_13 ] . vl_256 += ( vr_241
- vr_222 [ vr_13 ] . vr_229 [ vr_240 ] ) ;
vr_222 [ vr_13 ] . vr_229 [ vr_240 ] = vr_241 ;
vr_222 [ vr_13 ] . vl_255 = ( vr_222 [ vr_13 ] . vl_256
< vl_98 ) ;
}
}
}
}
for ( vr_221 = vr_234 ; 1 < vr_221 ; -- vr_221 )
{
if ( vr_222 [ vr_221 - 1 ] . vl_255 )
break;
}
return vr_221 ;
}
void
fn_69 ( int vr_242 )
{
if ( vr_242 != vl_37 )
fn_204 () ;
else
{
printf ( _ ( lr_72 ) , vl_257 ) ;
fputs ( _ ( lr_73 ) , stdout ) ;
fn_205 () ;
fputs ( _ ( lr_74 ) , stdout ) ;
fputs ( _ ( lr_75 ) , stdout ) ;
fputs ( _ ( lr_76 ) , stdout ) ;
fputs ( _ ( lr_77 ) , stdout ) ;
fputs ( _ ( lr_78 ) , stdout ) ;
fputs ( _ ( lr_79 ) , stdout ) ;
fputs ( _ ( lr_80 ) , stdout ) ;
fputs ( _ ( lr_81 ) , stdout ) ;
fputs ( _ ( lr_82 ) , stdout ) ;
fputs ( _ ( lr_83 ) , stdout ) ;
fputs ( _ ( lr_84 ) , stdout ) ;
fputs ( _ ( lr_85 ) , stdout ) ;
fputs ( _ ( lr_86 ) , stdout ) ;
fputs ( _ ( lr_87 ) , stdout ) ;
fputs ( _ ( lr_88 ) , stdout ) ;
fputs ( _ ( lr_89 ) , stdout ) ;
fputs ( _ ( lr_90 ) , stdout ) ;
fputs ( _ ( lr_91 ) , stdout ) ;
fputs ( vl_258 , stdout ) ;
fputs ( vl_259 , stdout ) ;
fn_206 () ;
fputs ( _ ( lr_92 ) , stdout ) ;
fputs ( _ ( lr_93 ) , stdout ) ;
fn_207 () ;
}
exit ( vr_242 ) ;
}
