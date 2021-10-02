void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 ) ;
fputs ( _ ( lr_2 ) , stdout ) ;
fputs ( _ ( lr_3 ) , stdout ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( vl_3 , stdout ) ;
fputs ( vl_4 , stdout ) ;
fputs ( _ ( lr_6 ) , stdout ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static void
fn_4 ( struct line * line , char * vr_2 , tp_1 vr_3 )
{
if ( line -> vr_4 >= line -> vr_5 )
{
line -> vr_6 = fn_5 ( line -> vr_6 , & line -> vr_5 ) ;
}
line -> vr_6 [ line -> vr_4 ] . vl_5 = vr_2 ;
line -> vr_6 [ line -> vr_4 ] . vr_3 = vr_3 ;
++ ( line -> vr_4 ) ;
}
static void
fn_6 ( struct line * line )
{
char * vr_7 = line -> vr_8 . vr_9 ;
char const * vr_10 = vr_7 + line -> vr_8 . vr_11 - 1 ;
if ( vr_7 == vr_10 )
return;
if ( 0 <= vl_6 && vl_6 != '\n' )
{
char * vr_12 ;
for (; ( vr_12 = memchr ( vr_7 , vl_6 , vr_10 - vr_7 ) ) != NULL ; vr_7 = vr_12 + 1 )
fn_4 ( line , vr_7 , vr_12 - vr_7 ) ;
}
else if ( vl_6 < 0 )
{
while ( fn_7 ( fn_8 ( * vr_7 ) ) )
if ( ++ vr_7 == vr_10 )
return;
do
{
char * vr_12 ;
for ( vr_12 = vr_7 + 1 ; vr_12 != vr_10 && ! fn_7 ( fn_8 ( * vr_12 ) ) ; vr_12 ++ )
continue;
fn_4 ( line , vr_7 , vr_12 - vr_7 ) ;
if ( vr_12 == vr_10 )
return;
for ( vr_7 = vr_12 + 1 ; vr_7 != vr_10 && fn_7 ( fn_8 ( * vr_7 ) ) ; vr_7 ++ )
continue;
}
while ( vr_7 != vr_10 );
}
fn_4 ( line , vr_7 , vr_10 - vr_7 ) ;
}
static void
fn_9 ( struct line * line )
{
if ( line == NULL )
return;
free ( line -> vr_6 ) ;
line -> vr_6 = NULL ;
free ( line -> vr_8 . vr_9 ) ;
line -> vr_8 . vr_9 = NULL ;
}
static int
fn_10 ( struct line const * vr_13 , struct line const * vr_14 ,
tp_1 vr_15 , tp_1 vr_16 )
{
char * vr_17 ;
char * vr_18 ;
tp_1 vr_19 ;
tp_1 vr_20 ;
int vr_21 ;
if ( vr_15 < vr_13 -> vr_4 )
{
vr_17 = vr_13 -> vr_6 [ vr_15 ] . vl_5 ;
vr_19 = vr_13 -> vr_6 [ vr_15 ] . vr_3 ;
}
else
{
vr_17 = NULL ;
vr_19 = 0 ;
}
if ( vr_16 < vr_14 -> vr_4 )
{
vr_18 = vr_14 -> vr_6 [ vr_16 ] . vl_5 ;
vr_20 = vr_14 -> vr_6 [ vr_16 ] . vr_3 ;
}
else
{
vr_18 = NULL ;
vr_20 = 0 ;
}
if ( vr_19 == 0 )
return vr_20 == 0 ? 0 : - 1 ;
if ( vr_20 == 0 )
return 1 ;
if ( vl_7 )
{
vr_21 = fn_11 ( vr_17 , vr_18 , fn_12 ( vr_19 , vr_20 ) ) ;
}
else
{
if ( vl_8 )
return fn_13 ( vr_17 , vr_19 , vr_18 , vr_20 ) ;
vr_21 = memcmp ( vr_17 , vr_18 , fn_12 ( vr_19 , vr_20 ) ) ;
}
if ( vr_21 )
return vr_21 ;
return vr_19 < vr_20 ? - 1 : vr_19 != vr_20 ;
}
static void
fn_14 ( const struct line * vr_22 ,
const struct line * vr_23 ,
int vr_24 )
{
if ( vl_9 != vl_10
&& ( ( vl_9 == vl_11 ) || vl_12 ) )
{
if ( ! vr_25 [ vr_24 - 1 ] )
{
tp_1 vr_26 = vr_24 == 1 ? vl_13 : vl_14 ;
if ( fn_10 ( vr_22 , vr_23 , vr_26 , vr_26 ) > 0 )
{
tp_1 vr_3 = vr_23 -> vr_8 . vr_11 ;
if ( 0 < vr_3 && vr_23 -> vr_8 . vr_9 [ vr_3 - 1 ] == '\n' )
-- vr_3 ;
vr_3 = fn_12 ( vl_15 , vr_3 ) ;
error ( ( vl_9 == vl_11
? vl_16 : 0 ) ,
0 , _ ( lr_7 vl_17 lr_8 ) ,
vr_27 [ vr_24 - 1 ] , vr_28 [ vr_24 - 1 ] ,
( int ) vr_3 , vr_23 -> vr_8 . vr_9 ) ;
vr_25 [ vr_24 - 1 ] = true ;
}
}
}
}
static inline void
fn_15 ( struct line * line )
{
line -> vr_4 = 0 ;
}
static struct line *
fn_16 ( struct line * * vr_29 )
{
struct line * line = fn_17 ( 1 , sizeof *line ) ;
* vr_29 = line ;
return line ;
}
static bool
fn_18 ( tp_2 * vr_30 , struct line * * vr_29 , int vr_31 )
{
struct line * line = * vr_29 ;
if ( line == vr_32 [ vr_31 - 1 ] )
{
fn_19 ( line , vr_33 [ vr_31 - 1 ] ) ;
* vr_29 = line ;
}
if ( line )
fn_15 ( line ) ;
else
line = fn_16 ( vr_29 ) ;
if ( ! fn_20 ( & line -> vr_8 , vr_30 , vl_18 ) )
{
if ( ferror ( vr_30 ) )
error ( vl_16 , vl_19 , _ ( lr_9 ) ) ;
fn_9 ( line ) ;
return false ;
}
++ vr_28 [ vr_31 - 1 ] ;
fn_6 ( line ) ;
if ( vr_32 [ vr_31 - 1 ] )
fn_14 ( vr_32 [ vr_31 - 1 ] , line , vr_31 ) ;
vr_32 [ vr_31 - 1 ] = line ;
return true ;
}
static void
fn_21 ( void )
{
tp_1 vr_34 ;
for ( vr_34 = 0 ; vr_34 < fn_22 ( vr_33 ) ; vr_34 ++ )
{
if ( vr_33 [ vr_34 ] )
{
fn_9 ( vr_33 [ vr_34 ] ) ;
free ( vr_33 [ vr_34 ] ) ;
}
}
}
static void
fn_23 ( struct vr_35 * vr_35 )
{
vr_35 -> vr_36 = 0 ;
vr_35 -> vr_37 = 0 ;
vr_35 -> vr_38 = NULL ;
}
static bool
fn_24 ( tp_2 * vr_30 , struct vr_35 * vr_35 , int vr_39 )
{
if ( vr_35 -> vr_36 == vr_35 -> vr_37 )
{
tp_1 vr_34 ;
vr_35 -> vr_38 = fn_5 ( vr_35 -> vr_38 , & vr_35 -> vr_37 ) ;
for ( vr_34 = vr_35 -> vr_36 ; vr_34 < vr_35 -> vr_37 ; vr_34 ++ )
vr_35 -> vr_38 [ vr_34 ] = NULL ;
}
if ( fn_18 ( vr_30 , & vr_35 -> vr_38 [ vr_35 -> vr_36 ] , vr_39 ) )
{
++ vr_35 -> vr_36 ;
return true ;
}
return false ;
}
static bool
fn_25 ( tp_2 * vr_30 , struct vr_35 * vr_35 , bool vr_40 , int vr_39 )
{
if ( vr_40 )
vr_35 -> vr_36 = 0 ;
return fn_24 ( vr_30 , vr_35 , vr_39 ) ;
}
static void
fn_26 ( struct vr_35 * vr_35 )
{
tp_1 vr_34 ;
for ( vr_34 = 0 ; vr_34 < vr_35 -> vr_37 ; vr_34 ++ )
{
fn_9 ( vr_35 -> vr_38 [ vr_34 ] ) ;
free ( vr_35 -> vr_38 [ vr_34 ] ) ;
}
free ( vr_35 -> vr_38 ) ;
}
static void
fn_27 ( tp_1 vr_41 , struct line const * line )
{
tp_1 vr_3 ;
if ( vr_41 < line -> vr_4 )
{
vr_3 = line -> vr_6 [ vr_41 ] . vr_3 ;
if ( vr_3 )
fwrite ( line -> vr_6 [ vr_41 ] . vl_5 , 1 , vr_3 , stdout ) ;
else if ( vl_20 )
fputs ( vl_20 , stdout ) ;
}
else if ( vl_20 )
fputs ( vl_20 , stdout ) ;
}
static void
fn_28 ( struct line const * line , tp_1 vr_26 , tp_1 vr_42 )
{
tp_1 vr_34 ;
tp_1 vr_4 = vl_21 ? vr_42 : line -> vr_4 ;
char vr_43 = vl_6 < 0 ? ' ' : vl_6 ;
for ( vr_34 = 0 ; vr_34 < vr_26 && vr_34 < vr_4 ; ++ vr_34 )
{
putchar ( vr_43 ) ;
fn_27 ( vr_34 , line ) ;
}
for ( vr_34 = vr_26 + 1 ; vr_34 < vr_4 ; ++ vr_34 )
{
putchar ( vr_43 ) ;
fn_27 ( vr_34 , line ) ;
}
}
static void
fn_29 ( struct line const * vr_13 , struct line const * vr_14 )
{
const struct vr_44 * vr_44 ;
char vr_43 = vl_6 < 0 ? ' ' : vl_6 ;
tp_1 vr_2 ;
struct line const * line ;
vr_44 = vr_45 . vr_46 ;
if ( vr_44 )
{
const struct vr_44 * vr_47 ;
vr_47 = vr_44 ;
while ( 1 )
{
if ( vr_47 -> vr_48 == 0 )
{
if ( vr_13 == & vl_22 )
{
line = vr_14 ;
vr_2 = vl_14 ;
}
else
{
line = vr_13 ;
vr_2 = vl_13 ;
}
}
else
{
line = ( vr_47 -> vr_48 == 1 ? vr_13 : vr_14 ) ;
vr_2 = vr_47 -> vr_2 ;
}
fn_27 ( vr_2 , line ) ;
vr_47 = vr_47 -> vr_46 ;
if ( vr_47 == NULL )
break;
putchar ( vr_43 ) ;
}
putchar ( vl_18 ) ;
}
else
{
if ( vr_13 == & vl_22 )
{
line = vr_14 ;
vr_2 = vl_14 ;
}
else
{
line = vr_13 ;
vr_2 = vl_13 ;
}
fn_27 ( vr_2 , line ) ;
fn_28 ( vr_13 , vl_13 , vl_23 ) ;
fn_28 ( vr_14 , vl_14 , vl_24 ) ;
putchar ( vl_18 ) ;
}
}
static void
fn_30 ( tp_2 * vr_49 , tp_2 * vr_50 )
{
struct vr_35 vr_51 , vr_52 ;
int vr_21 ;
bool vr_53 , vr_54 ;
fn_31 ( vr_49 , vl_25 ) ;
fn_31 ( vr_50 , vl_25 ) ;
fn_23 ( & vr_51 ) ;
fn_24 ( vr_49 , & vr_51 , 1 ) ;
fn_23 ( & vr_52 ) ;
fn_24 ( vr_50 , & vr_52 , 2 ) ;
if ( vl_21 )
{
vl_23 = vr_51 . vr_36 ? vr_51 . vr_38 [ 0 ] -> vr_4 : 0 ;
vl_24 = vr_52 . vr_36 ? vr_52 . vr_38 [ 0 ] -> vr_4 : 0 ;
}
if ( vl_26 && ( vr_51 . vr_36 || vr_52 . vr_36 ) )
{
struct line const * vr_55 = vr_51 . vr_36 ? vr_51 . vr_38 [ 0 ] : & vl_22 ;
struct line const * vr_56 = vr_52 . vr_36 ? vr_52 . vr_38 [ 0 ] : & vl_22 ;
fn_29 ( vr_55 , vr_56 ) ;
vr_32 [ 0 ] = NULL ;
vr_32 [ 1 ] = NULL ;
if ( vr_51 . vr_36 )
fn_25 ( vr_49 , & vr_51 , true , 1 ) ;
if ( vr_52 . vr_36 )
fn_25 ( vr_50 , & vr_52 , true , 2 ) ;
}
while ( vr_51 . vr_36 && vr_52 . vr_36 )
{
tp_1 vr_34 ;
vr_21 = fn_10 ( vr_51 . vr_38 [ 0 ] , vr_52 . vr_38 [ 0 ] ,
vl_13 , vl_14 ) ;
if ( vr_21 < 0 )
{
if ( vl_27 )
fn_29 ( vr_51 . vr_38 [ 0 ] , & vl_22 ) ;
fn_25 ( vr_49 , & vr_51 , true , 1 ) ;
vl_12 = true ;
continue;
}
if ( vr_21 > 0 )
{
if ( vl_28 )
fn_29 ( & vl_22 , vr_52 . vr_38 [ 0 ] ) ;
fn_25 ( vr_50 , & vr_52 , true , 2 ) ;
vl_12 = true ;
continue;
}
vr_53 = false ;
do
if ( ! fn_25 ( vr_49 , & vr_51 , false , 1 ) )
{
vr_53 = true ;
++ vr_51 . vr_36 ;
break;
}
while ( ! fn_10 ( vr_51 . vr_38 [ vr_51 . vr_36 - 1 ] , vr_52 . vr_38 [ 0 ] ,
vl_13 , vl_14 ) );
vr_54 = false ;
do
if ( ! fn_25 ( vr_50 , & vr_52 , false , 2 ) )
{
vr_54 = true ;
++ vr_52 . vr_36 ;
break;
}
while ( ! fn_10 ( vr_51 . vr_38 [ 0 ] , vr_52 . vr_38 [ vr_52 . vr_36 - 1 ] ,
vl_13 , vl_14 ) );
if ( vl_29 )
{
for ( vr_34 = 0 ; vr_34 < vr_51 . vr_36 - 1 ; ++ vr_34 )
{
tp_1 vr_57 ;
for ( vr_57 = 0 ; vr_57 < vr_52 . vr_36 - 1 ; ++ vr_57 )
fn_29 ( vr_51 . vr_38 [ vr_34 ] , vr_52 . vr_38 [ vr_57 ] ) ;
}
}
if ( ! vr_53 )
{
fn_19 ( vr_51 . vr_38 [ 0 ] , vr_51 . vr_38 [ vr_51 . vr_36 - 1 ] ) ;
vr_51 . vr_36 = 1 ;
}
else
vr_51 . vr_36 = 0 ;
if ( ! vr_54 )
{
fn_19 ( vr_52 . vr_38 [ 0 ] , vr_52 . vr_38 [ vr_52 . vr_36 - 1 ] ) ;
vr_52 . vr_36 = 1 ;
}
else
vr_52 . vr_36 = 0 ;
}
struct line * line = NULL ;
bool vr_58 = false ;
if ( vl_9 != vl_10
&& ! ( vr_25 [ 0 ] && vr_25 [ 1 ] ) )
vr_58 = true ;
if ( ( vl_27 || vr_58 ) && vr_51 . vr_36 )
{
if ( vl_27 )
fn_29 ( vr_51 . vr_38 [ 0 ] , & vl_22 ) ;
if ( vr_52 . vr_36 )
vl_12 = true ;
while ( fn_18 ( vr_49 , & line , 1 ) )
{
if ( vl_27 )
fn_29 ( line , & vl_22 ) ;
if ( vr_25 [ 0 ] && ! vl_27 )
break;
}
}
if ( ( vl_28 || vr_58 ) && vr_52 . vr_36 )
{
if ( vl_28 )
fn_29 ( & vl_22 , vr_52 . vr_38 [ 0 ] ) ;
if ( vr_51 . vr_36 )
vl_12 = true ;
while ( fn_18 ( vr_50 , & line , 2 ) )
{
if ( vl_28 )
fn_29 ( & vl_22 , line ) ;
if ( vr_25 [ 1 ] && ! vl_28 )
break;
}
}
fn_9 ( line ) ;
free ( line ) ;
fn_26 ( & vr_51 ) ;
fn_26 ( & vr_52 ) ;
}
static void
fn_32 ( int vr_48 , tp_1 vr_2 )
{
struct vr_44 * vr_47 ;
assert ( vr_48 == 0 || vr_48 == 1 || vr_48 == 2 ) ;
assert ( vr_48 != 0 || vr_2 == 0 ) ;
vr_47 = xmalloc ( sizeof *vr_47 ) ;
vr_47 -> vr_48 = vr_48 ;
vr_47 -> vr_2 = vr_2 ;
vr_47 -> vr_46 = NULL ;
vr_59 -> vr_46 = vr_47 ;
vr_59 = vr_47 ;
}
static tp_1
fn_33 ( char const * vr_60 )
{
tp_1 vr_61 ;
unsigned long int vr_62 ;
fn_34 ( vl_30 <= vl_31 ) ;
tp_3 vr_63 = fn_35 ( vr_60 , NULL , 10 , & vr_62 , lr_10 ) ;
if ( vr_63 == vl_32 || ( vr_63 == vl_33 && vl_30 < vr_62 ) )
vr_62 = vl_30 ;
else if ( vr_63 != vl_33 || vr_62 == 0 )
error ( vl_16 , 0 , _ ( lr_11 ) , fn_36 ( vr_60 ) ) ;
vr_61 = vr_62 - 1 ;
return vr_61 ;
}
static void
fn_37 ( const char * vr_64 , int * vr_65 , tp_1 * vr_66 )
{
switch ( vr_64 [ 0 ] )
{
case '0' :
if ( vr_64 [ 1 ] )
{
error ( vl_16 , 0 , _ ( lr_12 ) , fn_36 ( vr_64 ) ) ;
}
* vr_65 = 0 ;
* vr_66 = 0 ;
break;
case '1' :
case '2' :
if ( vr_64 [ 1 ] != '.' )
error ( vl_16 , 0 , _ ( lr_12 ) , fn_36 ( vr_64 ) ) ;
* vr_65 = vr_64 [ 0 ] - '0' ;
* vr_66 = fn_33 ( vr_64 + 2 ) ;
break;
default:
error ( vl_16 , 0 ,
_ ( lr_13 ) , fn_36 ( vr_64 ) ) ;
abort () ;
break;
}
}
static void
fn_38 ( char * vr_60 )
{
char * vr_67 = vr_60 ;
do
{
int vr_65 ;
tp_1 vr_66 ;
char const * vr_68 = vr_67 ;
vr_67 = strpbrk ( vr_67 , lr_14 ) ;
if ( vr_67 )
* vr_67 ++ = '\0' ;
fn_37 ( vr_68 , & vr_65 , & vr_66 ) ;
fn_32 ( vr_65 , vr_66 ) ;
}
while ( vr_67 );
}
static void
fn_39 ( tp_1 * vr_69 , tp_1 vr_62 )
{
if ( * vr_69 != vl_30 && * vr_69 != vr_62 )
{
unsigned long int vr_70 = * vr_69 + 1 ;
unsigned long int vr_71 = vr_62 + 1 ;
error ( vl_16 , 0 , _ ( lr_15 ) ,
vr_70 , vr_71 ) ;
}
* vr_69 = vr_62 ;
}
static void
fn_40 ( char * vr_72 , char * vr_73 [ 2 ] ,
int vr_74 [ 2 ] , int vr_75 [ 2 ] , int * vr_76 ,
int * vr_77 , int * vr_78 )
{
int vr_41 = * vr_76 ;
if ( vr_41 == 2 )
{
bool vr_79 = ( vr_74 [ 0 ] == vl_34 ) ;
char * vr_80 = vr_73 [ vr_79 ] ;
switch ( vr_74 [ vr_79 ] )
{
case vl_34 :
error ( 0 , 0 , _ ( lr_16 ) , fn_36 ( vr_72 ) ) ;
fn_1 ( vl_16 ) ;
case vl_35 :
vr_75 [ 0 ] -- ;
fn_39 ( & vl_13 , fn_33 ( vr_80 ) ) ;
break;
case vl_36 :
vr_75 [ 1 ] -- ;
fn_39 ( & vl_14 , fn_33 ( vr_80 ) ) ;
break;
case vl_37 :
fn_38 ( vr_80 ) ;
break;
}
if ( ! vr_79 )
{
vr_74 [ 0 ] = vr_74 [ 1 ] ;
vr_73 [ 0 ] = vr_73 [ 1 ] ;
}
vr_41 = 1 ;
}
vr_74 [ vr_41 ] = * vr_77 ;
vr_73 [ vr_41 ] = vr_72 ;
* vr_76 = vr_41 + 1 ;
if ( * vr_77 == vl_37 )
* vr_78 = vl_37 ;
}
int
main ( int vr_81 , char * * vr_82 )
{
int vr_78 ;
int vr_77 = vl_34 ;
int vr_74 [ 2 ] ;
int vr_75 [ 2 ] = { 0 , 0 } ;
tp_2 * vr_49 , * vr_50 ;
int vr_83 ;
int vr_76 = 0 ;
int vr_34 ;
fn_41 ( & vr_81 , & vr_82 ) ;
fn_42 ( vr_82 [ 0 ] ) ;
setlocale ( vl_38 , lr_10 ) ;
fn_43 ( vl_39 , vl_40 ) ;
fn_44 ( vl_39 ) ;
vl_8 = fn_45 ( vl_41 ) ;
atexit ( vl_42 ) ;
atexit ( fn_21 ) ;
vl_29 = true ;
vl_12 = false ;
vr_25 [ 0 ] = vr_25 [ 1 ] = false ;
vl_9 = vl_43 ;
while ( ( vr_83 = fn_46 ( vr_81 , vr_82 , lr_17 ,
vl_44 , NULL ) )
!= - 1 )
{
vr_78 = vl_34 ;
switch ( vr_83 )
{
case 'v' :
vl_29 = false ;
case 'a' :
{
unsigned long int vr_62 ;
if ( fn_35 ( vl_45 , NULL , 10 , & vr_62 , lr_10 ) != vl_33
|| ( vr_62 != 1 && vr_62 != 2 ) )
error ( vl_16 , 0 ,
_ ( lr_11 ) , fn_36 ( vl_45 ) ) ;
if ( vr_62 == 1 )
vl_27 = true ;
else
vl_28 = true ;
}
break;
case 'e' :
if ( vl_20 && ! fn_47 ( vl_20 , vl_45 ) )
error ( vl_16 , 0 ,
_ ( lr_18 ) ) ;
vl_20 = vl_45 ;
break;
case 'i' :
vl_7 = true ;
break;
case '1' :
fn_39 ( & vl_13 , fn_33 ( vl_45 ) ) ;
break;
case '2' :
fn_39 ( & vl_14 , fn_33 ( vl_45 ) ) ;
break;
case 'j' :
if ( ( vl_45 [ 0 ] == '1' || vl_45 [ 0 ] == '2' ) && ! vl_45 [ 1 ]
&& vl_45 == vr_82 [ vl_46 - 1 ] + 2 )
{
bool vr_84 = ( vl_45 [ 0 ] == '2' ) ;
vr_75 [ vr_84 ] ++ ;
vr_78 = vl_35 + vr_84 ;
}
else
{
fn_39 ( & vl_13 , fn_33 ( vl_45 ) ) ;
fn_39 ( & vl_14 , vl_13 ) ;
}
break;
case 'o' :
if ( fn_47 ( vl_45 , lr_19 ) )
vl_21 = true ;
else
{
fn_38 ( vl_45 ) ;
vr_78 = vl_37 ;
}
break;
case 't' :
{
unsigned char vr_85 = vl_45 [ 0 ] ;
if ( ! vr_85 )
vr_85 = '\n' ;
else if ( vl_45 [ 1 ] )
{
if ( fn_47 ( vl_45 , lr_20 ) )
vr_85 = '\0' ;
else
error ( vl_16 , 0 , _ ( lr_21 ) ,
fn_36 ( vl_45 ) ) ;
}
if ( 0 <= vl_6 && vl_6 != vr_85 )
error ( vl_16 , 0 , _ ( lr_22 ) ) ;
vl_6 = vr_85 ;
}
break;
case 'z' :
vl_18 = 0 ;
break;
case vl_47 :
vl_9 = vl_10 ;
break;
case vl_48 :
vl_9 = vl_11 ;
break;
case 1 :
fn_40 ( vl_45 , vr_27 , vr_74 , vr_75 ,
& vr_76 , & vr_77 , & vr_78 ) ;
break;
case vl_49 :
vl_26 = true ;
break;
vl_50 ;
fn_48 ( vl_51 , vl_52 ) ;
default:
fn_1 ( vl_16 ) ;
}
vr_77 = vr_78 ;
}
vr_77 = vl_34 ;
while ( vl_46 < vr_81 )
fn_40 ( vr_82 [ vl_46 ++ ] , vr_27 , vr_74 , vr_75 ,
& vr_76 , & vr_77 , & vr_78 ) ;
if ( vr_76 != 2 )
{
if ( vr_76 == 0 ) MST[EQ$@1$@2$!MOD$@1$@2$]MSP[]
error ( 0 , 0 , _ ( lr_23 ) ) ;
else
error ( 0 , 0 , _ ( lr_24 ) , fn_36 ( vr_82 [ vr_81 - 1 ] ) ) ;
fn_1 ( vl_16 ) ;
}
for ( vr_34 = 0 ; vr_34 < 2 ; vr_34 ++ )
if ( vr_75 [ vr_34 ] != 0 )
{
fn_39 ( & vl_13 , vr_34 ) ;
fn_39 ( & vl_14 , vr_34 ) ;
}
if ( vl_13 == vl_30 )
vl_13 = 0 ;
if ( vl_14 == vl_30 )
vl_14 = 0 ;
vr_49 = fn_47 ( vr_27 [ 0 ] , lr_25 ) ? vl_53 : fopen ( vr_27 [ 0 ] , lr_26 ) ;
if ( ! vr_49 )
error ( vl_16 , vl_19 , lr_27 , vr_27 [ 0 ] ) ;
vr_50 = fn_47 ( vr_27 [ 1 ] , lr_25 ) ? vl_53 : fopen ( vr_27 [ 1 ] , lr_26 ) ;
if ( ! vr_50 )
error ( vl_16 , vl_19 , lr_27 , vr_27 [ 1 ] ) ;
if ( vr_49 == vr_50 )
error ( vl_16 , vl_19 , _ ( lr_28 ) ) ;
fn_30 ( vr_49 , vr_50 ) ;
if ( fclose ( vr_49 ) != 0 )
error ( vl_16 , vl_19 , lr_27 , vr_27 [ 0 ] ) ;
if ( fclose ( vr_50 ) != 0 )
error ( vl_16 , vl_19 , lr_27 , vr_27 [ 1 ] ) ;
if ( vr_25 [ 0 ] || vr_25 [ 1 ] )
exit ( vl_16 ) ;
else
exit ( vl_1 ) ;
}
