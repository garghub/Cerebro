public tp_1 fn_1 ( final Type ... vr_1 ) {
this . vr_2 = vr_1 ;
return this ;
}
public tp_1 fn_2 ( final Type ... vr_1 ) {
this . vr_3 = vr_1 ;
return this ;
}
@Override
public tp_2 fn_3 () {
return new fn_4 ( vr_2 , vr_3 ) ;
}
@Override
public Type fn_5 () {
return vl_1 ;
}
@Override
public String toString () {
return vr_4 . toString ( this ) ;
}
@Override
public boolean equals ( final Object vr_5 ) {
return vr_5 == this || vr_5 instanceof vl_2 && vr_4 . equals ( this , ( vl_2 ) vr_5 ) ;
}
@Override
public int fn_6 () {
int vr_6 = 67 << 4 ;
vr_6 |= vl_1 . fn_6 () ;
return vr_6 ;
}
@Override
public Type fn_7 () {
return vl_3 ;
}
@Override
public Type fn_8 () {
return vl_4 ;
}
@Override
public Type [] fn_9 () {
return vr_7 . vr_8 () ;
}
@Override
public String toString () {
return vr_4 . toString ( this ) ;
}
@Override
public boolean equals ( final Object vr_5 ) {
return vr_5 == this || vr_5 instanceof vl_5 && vr_4 . equals ( this , ( ( vl_5 ) vr_5 ) ) ;
}
@SuppressWarnings ( lr_1 )
@Override
public int fn_6 () {
int vr_6 = 71 << 4 ;
vr_6 |= vl_3 . fn_6 () ;
vr_6 <<= 4 ;
vr_6 |= vr_9 . fn_6 ( vl_4 ) ;
vr_6 <<= 8 ;
vr_6 |= vr_10 . fn_6 ( vr_7 ) ;
return vr_6 ;
}
@Override
public Type [] fn_10 () {
return vr_2 . vr_8 () ;
}
@Override
public Type [] fn_11 () {
return vr_3 . vr_8 () ;
}
@Override
public String toString () {
return vr_4 . toString ( this ) ;
}
@Override
public boolean equals ( final Object vr_5 ) {
return vr_5 == this || vr_5 instanceof tp_2 && vr_4 . equals ( this , ( tp_2 ) vr_5 ) ;
}
@Override
public int fn_6 () {
int vr_6 = 73 << 8 ;
vr_6 |= vr_10 . fn_6 ( vr_2 ) ;
vr_6 <<= 8 ;
vr_6 |= vr_10 . fn_6 ( vr_3 ) ;
return vr_6 ;
}
public static boolean fn_12 ( final Type type , final Type vr_11 ) {
return fn_12 ( type , vr_11 , null ) ;
}
private static boolean fn_12 ( final Type type , final Type vr_11 ,
final vr_12 < vr_13 < ? > , Type > vr_14 ) {
if ( vr_11 == null || vr_11 instanceof Class < ? > ) {
return fn_12 ( type , ( Class < ? > ) vr_11 ) ;
}
if ( vr_11 instanceof vl_5 ) {
return fn_12 ( type , ( vl_5 ) vr_11 , vr_14 ) ;
}
if ( vr_11 instanceof vl_2 ) {
return fn_12 ( type , ( vl_2 ) vr_11 , vr_14 ) ;
}
if ( vr_11 instanceof tp_2 ) {
return fn_12 ( type , ( tp_2 ) vr_11 , vr_14 ) ;
}
if ( vr_11 instanceof vr_13 < ? > ) {
return fn_12 ( type , ( vr_13 < ? > ) vr_11 , vr_14 ) ;
}
throw new fn_13 ( lr_2 + vr_11 ) ;
}
private static boolean fn_12 ( final Type type , final Class < ? > vr_15 ) {
if ( type == null ) {
return vr_15 == null || ! vr_15 . vr_16 () ;
}
if ( vr_15 == null ) {
return false ;
}
if ( vr_15 . equals ( type ) ) {
return true ;
}
if ( type instanceof Class < ? > ) {
return vr_17 . fn_12 ( ( Class < ? > ) type , vr_15 ) ;
}
if ( type instanceof vl_5 ) {
return fn_12 ( fn_7 ( ( vl_5 ) type ) , vr_15 ) ;
}
if ( type instanceof vr_13 < ? > ) {
for ( final Type vl_6 : ( ( vr_13 < ? > ) type ) . fn_14 () ) {
if ( fn_12 ( vl_6 , vr_15 ) ) {
return true ;
}
}
return false ;
}
private static boolean fn_12 ( final Type type , final vl_5 vr_18 ,
final vr_12 < vr_13 < ? > , Type > vr_14 ) {
if ( type == null ) {
return true ;
}
if ( vr_18 == null ) {
return false ;
}
if ( vr_18 . equals ( type ) ) {
return true ;
}
final Class < ? > vr_15 = fn_7 ( vr_18 ) ;
final vr_12 < vr_13 < ? > , Type > vr_19 = fn_15 ( type , vr_15 , null ) ;
if ( vr_19 == null ) {
return false ;
}
if ( vr_19 . isEmpty () ) {
return true ;
}
final vr_12 < vr_13 < ? > , Type > vr_20 = fn_15 ( vr_18 ,
vr_15 , vr_14 ) ;
for ( final vr_13 < ? > vr_21 : vr_20 . vr_22 () ) {
final Type vr_23 = fn_16 ( vr_21 , vr_20 ) ;
final Type vr_24 = fn_16 ( vr_21 , vr_19 ) ;
if ( vr_24 != null
&& ! vr_23 . equals ( vr_24 )
&& ! ( vr_23 instanceof tp_2 && fn_12 ( vr_24 , vr_23 ,
vr_14 ) ) ) {
return false ;
}
}
return true ;
}
private static Type fn_16 ( vr_13 < ? > vr_21 , final vr_12 < vr_13 < ? > , Type > vr_14 ) {
Type vr_6 ;
do {
vr_6 = vr_14 . get ( vr_21 ) ;
if ( vr_6 instanceof vr_13 < ? > && ! vr_6 . equals ( vr_21 ) ) {
vr_21 = ( vr_13 < ? > ) vr_6 ;
continue;
}
break;
} while ( true );
return vr_6 ;
}
private static boolean fn_12 ( final Type type , final vl_2 vr_25 ,
final vr_12 < vr_13 < ? > , Type > vr_14 ) {
if ( type == null ) {
return true ;
}
if ( vr_25 == null ) {
return false ;
}
if ( vr_25 . equals ( type ) ) {
return true ;
}
final Type vr_26 = vr_25 . fn_5 () ;
if ( type instanceof Class < ? > ) {
final Class < ? > vr_27 = ( Class < ? > ) type ;
return vr_27 . vr_28 ()
&& fn_12 ( vr_27 . vr_29 () , vr_26 , vr_14 ) ;
}
if ( type instanceof vl_2 ) {
return fn_12 ( ( ( vl_2 ) type ) . fn_5 () ,
vr_26 , vr_14 ) ;
}
if ( type instanceof tp_2 ) {
for ( final Type vl_6 : fn_17 ( ( tp_2 ) type ) ) {
if ( fn_12 ( vl_6 , vr_25 ) ) {
return true ;
}
}
return false ;
}
if ( type instanceof vr_13 < ? > ) {
for ( final Type vl_6 : fn_18 ( ( vr_13 < ? > ) type ) ) {
if ( fn_12 ( vl_6 , vr_25 ) ) {
return true ;
}
}
return false ;
}
static boolean fn_12 ( final Type type , final tp_2 vr_30 ,
final vr_12 < vr_13 < ? > , Type > vr_14 ) {
if ( type == null ) {
return true ;
}
if ( vr_30 == null ) {
return false ;
}
if ( vr_30 . equals ( type ) ) {
return true ;
}
final Type [] vr_31 = fn_17 ( vr_30 ) ;
final Type [] vr_32 = fn_19 ( vr_30 ) ;
if ( type instanceof tp_2 ) {
final tp_2 vr_33 = ( tp_2 ) type ;
final Type [] vr_2 = fn_17 ( vr_33 ) ;
final Type [] vr_3 = fn_19 ( vr_33 ) ;
for ( Type vr_34 : vr_31 ) {
vr_34 = fn_20 ( vr_34 , vr_14 ) ;
for ( final Type vl_6 : vr_2 ) {
if ( ! fn_12 ( vl_6 , vr_34 , vr_14 ) ) {
return false ;
}
}
}
for ( Type vr_34 : vr_32 ) {
vr_34 = fn_20 ( vr_34 , vr_14 ) ;
for ( final Type vl_6 : vr_3 ) {
if ( ! fn_12 ( vr_34 , vl_6 , vr_14 ) ) {
return false ;
}
}
}
return true ;
}
for ( final Type vr_34 : vr_31 ) {
if ( ! fn_12 ( type , fn_20 ( vr_34 , vr_14 ) ,
vr_14 ) ) {
return false ;
}
}
for ( final Type vr_34 : vr_32 ) {
if ( ! fn_12 ( fn_20 ( vr_34 , vr_14 ) , type ,
vr_14 ) ) {
return false ;
}
}
return true ;
}
private static boolean fn_12 ( final Type type , final vr_13 < ? > vr_35 ,
final vr_12 < vr_13 < ? > , Type > vr_14 ) {
if ( type == null ) {
return true ;
}
if ( vr_35 == null ) {
return false ;
}
if ( vr_35 . equals ( type ) ) {
return true ;
}
if ( type instanceof vr_13 < ? > ) {
final Type [] vr_1 = fn_18 ( ( vr_13 < ? > ) type ) ;
for ( final Type vl_6 : vr_1 ) {
if ( fn_12 ( vl_6 , vr_35 , vr_14 ) ) {
return true ;
}
}
}
static Type fn_20 ( final Type type , final vr_12 < vr_13 < ? > , Type > vr_14 ) {
if ( type instanceof vr_13 < ? > && vr_14 != null ) {
final Type vr_36 = vr_14 . get ( type ) ;
if ( vr_36 == null ) {
throw new IllegalArgumentException ( lr_3
+ type ) ;
}
return vr_36 ;
}
static vr_12 < vr_13 < ? > , Type > fn_15 ( final vl_5 type ) {
return fn_15 ( type , fn_7 ( type ) , null ) ;
}
public static vr_12 < vr_13 < ? > , Type > fn_15 ( final Type type , final Class < ? > vr_15 ) {
return fn_15 ( type , vr_15 , null ) ;
}
private static vr_12 < vr_13 < ? > , Type > fn_15 ( final Type type , final Class < ? > vr_15 ,
final vr_12 < vr_13 < ? > , Type > vr_37 ) {
if ( type instanceof Class < ? > ) {
return fn_15 ( ( Class < ? > ) type , vr_15 , vr_37 ) ;
}
if ( type instanceof vl_5 ) {
return fn_15 ( ( vl_5 ) type , vr_15 , vr_37 ) ;
}
if ( type instanceof vl_2 ) {
return fn_15 ( ( ( vl_2 ) type ) . fn_5 () , vr_15
. vr_28 () ? vr_15 . vr_29 () : vr_15 , vr_37 ) ;
}
if ( type instanceof tp_2 ) {
for ( final Type vl_6 : fn_17 ( ( tp_2 ) type ) ) {
if ( fn_12 ( vl_6 , vr_15 ) ) {
return fn_15 ( vl_6 , vr_15 , vr_37 ) ;
}
}
return null ;
}
if ( type instanceof vr_13 < ? > ) {
for ( final Type vl_6 : fn_18 ( ( vr_13 < ? > ) type ) ) {
if ( fn_12 ( vl_6 , vr_15 ) ) {
return fn_15 ( vl_6 , vr_15 , vr_37 ) ;
}
}
return null ;
}
static vr_12 < vr_13 < ? > , Type > fn_15 (
final vl_5 vr_38 , final Class < ? > vr_15 ,
final vr_12 < vr_13 < ? > , Type > vr_37 ) {
final Class < ? > vr_27 = fn_7 ( vr_38 ) ;
if ( ! fn_12 ( vr_27 , vr_15 ) ) {
return null ;
}
final Type vr_39 = vr_38 . fn_8 () ;
vr_12 < vr_13 < ? > , Type > vr_14 ;
if ( vr_39 instanceof vl_5 ) {
final vl_5 vr_40 = ( vl_5 ) vr_39 ;
vr_14 = fn_15 ( vr_40 ,
fn_7 ( vr_40 ) , vr_37 ) ;
} else {
vr_14 = vr_37 == null ? new vr_41 < vr_13 < ? > , Type > ()
: new vr_41 < vr_13 < ? > , Type > ( vr_37 ) ;
}
final Type [] vr_42 = vr_38 . fn_9 () ;
final vr_13 < ? > [] vr_43 = vr_27 . vr_44 () ;
for ( int vr_45 = 0 ; vr_45 < vr_43 . length ; vr_45 ++ ) {
final Type vr_46 = vr_42 [ vr_45 ] ;
vr_14 . vr_47 ( vr_43 [ vr_45 ] , vr_14 . vr_48 ( vr_46 ) ? vr_14
. get ( vr_46 ) : vr_46 ) ;
}
if ( vr_15 . equals ( vr_27 ) ) {
return vr_14 ;
}
return fn_15 ( fn_21 ( vr_27 , vr_15 ) , vr_15 , vr_14 ) ;
}
private static vr_12 < vr_13 < ? > , Type > fn_15 ( Class < ? > vr_27 , final Class < ? > vr_15 ,
final vr_12 < vr_13 < ? > , Type > vr_37 ) {
if ( ! fn_12 ( vr_27 , vr_15 ) ) {
return null ;
}
if ( vr_27 . vr_16 () ) {
if ( vr_15 . vr_16 () ) {
return new vr_41 < vr_13 < ? > , Type > () ;
}
vr_27 = vr_17 . vr_49 ( vr_27 ) ;
}
final vr_41 < vr_13 < ? > , Type > vr_14 = vr_37 == null ? new vr_41 < vr_13 < ? > , Type > ()
: new vr_41 < vr_13 < ? > , Type > ( vr_37 ) ;
if ( vr_15 . equals ( vr_27 ) ) {
return vr_14 ;
}
return fn_15 ( fn_21 ( vr_27 , vr_15 ) , vr_15 , vr_14 ) ;
}
public static vr_12 < vr_13 < ? > , Type > fn_22 ( final Class < ? > vr_27 ,
final vl_5 vr_50 ) {
vr_51 . vr_52 ( vr_27 , lr_4 ) ;
vr_51 . vr_52 ( vr_50 , lr_5 ) ;
final Class < ? > vr_53 = fn_7 ( vr_50 ) ;
if ( ! fn_12 ( vr_27 , vr_53 ) ) {
return null ;
}
if ( vr_27 . equals ( vr_53 ) ) {
return fn_15 ( vr_50 , vr_53 , null ) ;
}
final Type vr_54 = fn_21 ( vr_27 , vr_53 ) ;
if ( vr_54 instanceof Class < ? > ) {
return fn_22 ( ( Class < ? > ) vr_54 , vr_50 ) ;
}
final vl_5 vr_55 = ( vl_5 ) vr_54 ;
final Class < ? > vr_56 = fn_7 ( vr_55 ) ;
final vr_12 < vr_13 < ? > , Type > vr_14 = fn_22 ( vr_56 , vr_50 ) ;
fn_23 ( vr_27 , vr_55 , vr_14 ) ;
return vr_14 ;
}
private static < vt_1 > void fn_23 ( final Class < vt_1 > vr_27 ,
final vl_5 vr_38 , final vr_12 < vr_13 < ? > , Type > vr_14 ) {
final Type vr_39 = vr_38 . fn_8 () ;
if ( vr_39 instanceof vl_5 ) {
fn_23 ( vr_27 , ( vl_5 ) vr_39 , vr_14 ) ;
}
final Type [] vr_42 = vr_38 . fn_9 () ;
final vr_13 < ? > [] vr_57 = fn_7 ( vr_38 ) . vr_44 () ;
final List < vr_13 < Class < vt_1 > > > vr_58 = vr_10 . vr_59 ( vr_27
. vr_44 () ) ;
for ( int vr_45 = 0 ; vr_45 < vr_42 . length ; vr_45 ++ ) {
final vr_13 < ? > vr_60 = vr_57 [ vr_45 ] ;
final Type vr_46 = vr_42 [ vr_45 ] ;
if ( vr_58 . contains ( vr_46 )
&& vr_14 . vr_48 ( vr_60 ) ) {
vr_14 . vr_47 ( ( vr_13 < ? > ) vr_46 , vr_14 . get ( vr_60 ) ) ;
}
}
}
private static Type fn_21 ( final Class < ? > vr_27 , final Class < ? > vr_53 ) {
if ( vr_53 . vr_61 () ) {
final Type [] vr_62 = vr_27 . vr_63 () ;
Type vr_64 = null ;
for ( final Type vr_54 : vr_62 ) {
Class < ? > vr_56 = null ;
if ( vr_54 instanceof vl_5 ) {
vr_56 = fn_7 ( ( vl_5 ) vr_54 ) ;
} else if ( vr_54 instanceof Class < ? > ) {
vr_56 = ( Class < ? > ) vr_54 ;
} else {
throw new fn_13 ( lr_6
+ lr_7 + vr_54 ) ;
}
if ( fn_12 ( vr_56 , vr_53 )
&& fn_12 ( vr_64 , ( Type ) vr_56 ) ) {
vr_64 = vr_54 ;
}
}
if ( vr_64 != null ) {
return vr_64 ;
}
}
return vr_27 . vr_65 () ;
}
public static boolean fn_24 ( final Object vr_66 , final Type type ) {
if ( type == null ) {
return false ;
}
return vr_66 == null ? ! ( type instanceof Class < ? > ) || ! ( ( Class < ? > ) type ) . vr_16 ()
: fn_12 ( vr_66 . getClass () , type , null ) ;
}
public static Type [] fn_25 ( final Type [] vr_1 ) {
vr_51 . vr_52 ( vr_1 , lr_8 ) ;
if ( vr_1 . length < 2 ) {
return vr_1 ;
}
final vr_67 < Type > vr_68 = new vr_69 < Type > ( vr_1 . length ) ;
for ( final Type vr_70 : vr_1 ) {
boolean vr_71 = false ;
for ( final Type vr_72 : vr_1 ) {
if ( vr_70 != vr_72 && fn_12 ( vr_72 , vr_70 , null ) ) {
vr_71 = true ;
break;
}
}
if ( ! vr_71 ) {
vr_68 . add ( vr_70 ) ;
}
}
return vr_68 . toArray ( new Type [ vr_68 . size () ] ) ;
}
public static Type [] fn_18 ( final vr_13 < ? > vr_73 ) {
vr_51 . vr_52 ( vr_73 , lr_9 ) ;
final Type [] vr_1 = vr_73 . fn_14 () ;
return vr_1 . length == 0 ? new Type [] { Object . class } : fn_25 ( vr_1 ) ;
}
public static Type [] fn_17 ( final tp_2 vr_33 ) {
vr_51 . vr_52 ( vr_33 , lr_10 ) ;
final Type [] vr_1 = vr_33 . fn_10 () ;
return vr_1 . length == 0 ? new Type [] { Object . class } : fn_25 ( vr_1 ) ;
}
public static Type [] fn_19 ( final tp_2 vr_33 ) {
vr_51 . vr_52 ( vr_33 , lr_10 ) ;
final Type [] vr_1 = vr_33 . fn_11 () ;
return vr_1 . length == 0 ? new Type [] { null } : vr_1 ;
}
public static boolean fn_26 ( final vr_12 < vr_13 < ? > , Type > vr_14 ) {
vr_51 . vr_52 ( vr_14 , lr_11 ) ;
for ( final vr_12 . vr_74 < vr_13 < ? > , Type > vr_75 : vr_14 . vr_76 () ) {
final vr_13 < ? > vr_60 = vr_75 . vr_77 () ;
final Type type = vr_75 . vr_78 () ;
for ( final Type vl_6 : fn_18 ( vr_60 ) ) {
if ( ! fn_12 ( type , fn_20 ( vl_6 , vr_14 ) ,
vr_14 ) ) {
return false ;
}
}
}
return true ;
}
private static Class < ? > fn_7 ( final vl_5 vr_38 ) {
final Type vr_79 = vr_38 . fn_7 () ;
if ( ! ( vr_79 instanceof Class < ? > ) ) {
throw new fn_13 ( lr_12 + vr_79 ) ;
}
return ( Class < ? > ) vr_79 ;
}
public static Class < ? > fn_7 ( final Type type , final Type vr_80 ) {
if ( type instanceof Class < ? > ) {
return ( Class < ? > ) type ;
}
if ( type instanceof vl_5 ) {
return fn_7 ( ( vl_5 ) type ) ;
}
if ( type instanceof vr_13 < ? > ) {
if ( vr_80 == null ) {
return null ;
}
final Object vr_81 = ( ( vr_13 < ? > ) type ) . fn_27 () ;
if ( ! ( vr_81 instanceof Class < ? > ) ) {
return null ;
}
final vr_12 < vr_13 < ? > , Type > vr_14 = fn_15 ( vr_80 ,
( Class < ? > ) vr_81 ) ;
if ( vr_14 == null ) {
return null ;
}
final Type vr_82 = vr_14 . get ( type ) ;
if ( vr_82 == null ) {
return null ;
}
return fn_7 ( vr_82 , vr_80 ) ;
}
static boolean fn_28 ( final Type type ) {
return type instanceof vl_2 || type instanceof Class < ? > && ( ( Class < ? > ) type ) . vr_28 () ;
}
public static Type fn_29 ( final Type type ) {
if ( type instanceof Class < ? > ) {
final Class < ? > vr_83 = ( Class < ? > ) type ;
return vr_83 . vr_28 () ? vr_83 . vr_29 () : null ;
}
if ( type instanceof vl_2 ) {
return ( ( vl_2 ) type ) . fn_5 () ;
}
return null ;
}
public static Type fn_30 ( vr_12 < vr_13 < ? > , Type > vr_7 , final Type type ) {
if ( vr_7 == null ) {
vr_7 = vr_84 . < vr_13 < ? > , Type > fn_31 () ;
}
if ( fn_32 ( type ) ) {
if ( type instanceof vr_13 < ? > ) {
return fn_30 ( vr_7 , vr_7 . get ( type ) ) ;
}
if ( type instanceof vl_5 ) {
final vl_5 vr_85 = ( vl_5 ) type ;
final vr_12 < vr_13 < ? > , Type > vr_86 ;
if ( vr_85 . fn_8 () == null ) {
vr_86 = vr_7 ;
} else {
vr_86 = new vr_41 < vr_13 < ? > , Type > ( vr_7 ) ;
vr_86 . vr_87 ( vr_4 . fn_15 ( vr_85 ) ) ;
}
final Type [] args = vr_85 . fn_9 () ;
for ( int vr_45 = 0 ; vr_45 < args . length ; vr_45 ++ ) {
final Type vr_88 = fn_30 ( vr_86 , args [ vr_45 ] ) ;
if ( vr_88 != null ) {
args [ vr_45 ] = vr_88 ;
}
}
return fn_33 ( vr_85 . fn_8 () , ( Class < ? > ) vr_85 . fn_7 () , args ) ;
}
if ( type instanceof tp_2 ) {
final tp_2 vr_89 = ( tp_2 ) type ;
return vr_33 () . fn_1 ( fn_34 ( vr_7 , vr_89 . fn_10 () ) )
. fn_2 ( fn_34 ( vr_7 , vr_89 . fn_11 () ) ) . fn_3 () ;
}
}
return type ;
}
private static Type [] fn_34 ( final vr_12 < vr_13 < ? > , Type > vr_7 , final Type [] vr_1 ) {
Type [] vr_6 = vr_1 ;
int vr_45 = 0 ;
for (; vr_45 < vr_6 . length ; vr_45 ++ ) {
final Type vr_88 = fn_30 ( vr_7 , vr_6 [ vr_45 ] ) ;
if ( vr_88 == null ) {
vr_6 = vr_90 . remove ( vr_6 , vr_45 -- ) ;
} else {
vr_6 [ vr_45 ] = vr_88 ;
}
}
return vr_6 ;
}
public static boolean fn_32 ( final Type type ) {
if ( type instanceof vr_13 < ? > ) {
return true ;
}
if ( type instanceof Class < ? > ) {
return ( ( Class < ? > ) type ) . vr_44 () . length > 0 ;
}
if ( type instanceof vl_5 ) {
for ( final Type vr_91 : ( ( vl_5 ) type ) . fn_9 () ) {
if ( fn_32 ( vr_91 ) ) {
return true ;
}
}
return false ;
}
if ( type instanceof tp_2 ) {
final tp_2 vr_89 = ( tp_2 ) type ;
return fn_32 ( vr_4 . fn_19 ( vr_89 ) [ 0 ] )
|| fn_32 ( vr_4 . fn_17 ( vr_89 ) [ 0 ] ) ;
}
return false ;
}
public static final vl_5 fn_35 ( final Class < ? > vl_3 , final Type ... vr_7 ) {
return fn_33 ( null , vl_3 , vr_7 ) ;
}
public static final vl_5 fn_35 ( final Class < ? > vl_3 ,
final vr_12 < vr_13 < ? > , Type > vr_92 ) {
vr_51 . vr_52 ( vl_3 , lr_13 ) ;
vr_51 . vr_52 ( vr_92 , lr_14 ) ;
return fn_33 ( null , vl_3 , fn_36 ( vr_92 , vl_3 . vr_44 () ) ) ;
}
public static final vl_5 fn_33 ( final Type vr_93 , final Class < ? > vl_3 ,
final Type ... vr_7 ) {
vr_51 . vr_52 ( vl_3 , lr_13 ) ;
final Type vl_4 ;
if ( vl_3 . vr_94 () == null ) {
vr_51 . vr_95 ( vr_93 == null , lr_15 , vl_3 ) ;
vl_4 = null ;
} else if ( vr_93 == null ) {
vl_4 = vl_3 . vr_94 () ; MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
} else {
vr_51 . vr_95 ( vr_4 . fn_12 ( vr_93 , vl_3 . vr_94 () ) ,
lr_16 , vr_93 , vl_3 ) ;
vl_4 = vr_93 ;
}
vr_51 . vr_96 ( vr_7 , lr_17 ) ;
vr_51 . vr_95 ( vl_3 . vr_44 () . length == vr_7 . length ,
lr_18 , vl_3 . vr_44 () . length ,
vr_7 . length ) ;
return new fn_37 ( vl_3 , vl_4 , vr_7 ) ;
}
public static final vl_5 fn_33 ( final Type vr_93 , final Class < ? > vl_3 ,
final vr_12 < vr_13 < ? > , Type > vr_92 ) {
vr_51 . vr_52 ( vl_3 , lr_13 ) ;
vr_51 . vr_52 ( vr_92 , lr_14 ) ;
return fn_33 ( vr_93 , vl_3 , fn_36 ( vr_92 , vl_3 . vr_44 () ) ) ;
}
private static Type [] fn_36 ( final vr_12 < vr_13 < ? > , Type > vr_97 , final vr_13 < ? > [] vr_98 ) {
final Type [] vr_6 = new Type [ vr_98 . length ] ;
int vr_99 = 0 ;
for ( final vr_13 < ? > vr_21 : vr_98 ) {
vr_51 . vr_95 ( vr_97 . vr_48 ( vr_21 ) , lr_19 , toString ( vr_21 ) ) ;
vr_6 [ vr_99 ++ ] = vr_97 . get ( vr_21 ) ;
}
return vr_6 ;
}
public static tp_1 vr_33 () {
return new tp_1 () ;
}
public static vl_2 fn_38 ( final Type vl_1 ) {
return new fn_39 ( vr_51 . vr_52 ( vl_1 , lr_20 ) ) ;
}
@SuppressWarnings ( lr_1 )
public static boolean equals ( final Type vr_100 , final Type vr_101 ) {
if ( vr_9 . equals ( vr_100 , vr_101 ) ) {
return true ;
}
if ( vr_100 instanceof vl_5 ) {
return equals ( ( vl_5 ) vr_100 , vr_101 ) ;
}
if ( vr_100 instanceof vl_2 ) {
return equals ( ( vl_2 ) vr_100 , vr_101 ) ;
}
if ( vr_100 instanceof tp_2 ) {
return equals ( ( tp_2 ) vr_100 , vr_101 ) ;
}
return false ;
}
private static boolean equals ( final vl_5 vr_85 , final Type vr_102 ) {
if ( vr_102 instanceof vl_5 ) {
final vl_5 vr_103 = ( vl_5 ) vr_102 ;
if ( equals ( vr_85 . fn_7 () , vr_103 . fn_7 () ) && equals ( vr_85 . fn_8 () , vr_103 . fn_8 () ) ) {
return equals ( vr_85 . fn_9 () , vr_103 . fn_9 () ) ;
}
}
return false ;
}
private static boolean equals ( final vl_2 vr_104 , final Type vr_102 ) {
return vr_102 instanceof vl_2
&& equals ( vr_104 . fn_5 () , ( ( vl_2 ) vr_102 ) . fn_5 () ) ;
}
private static boolean equals ( final tp_2 vr_105 , final Type vr_102 ) {
if ( vr_102 instanceof tp_2 ) {
final tp_2 vr_103 = ( tp_2 ) vr_102 ;
return equals ( fn_19 ( vr_105 ) , fn_19 ( vr_103 ) )
&& equals ( fn_17 ( vr_105 ) , fn_17 ( vr_103 ) ) ;
}
return false ;
}
private static boolean equals ( final Type [] vr_100 , final Type [] vr_101 ) {
if ( vr_100 . length == vr_101 . length ) {
for ( int vr_45 = 0 ; vr_45 < vr_100 . length ; vr_45 ++ ) {
if ( ! equals ( vr_100 [ vr_45 ] , vr_101 [ vr_45 ] ) ) {
return false ;
}
}
return true ;
}
return false ;
}
public static String toString ( final Type type ) {
vr_51 . vr_52 ( type ) ;
if ( type instanceof Class < ? > ) {
return fn_40 ( ( Class < ? > ) type ) ;
}
if ( type instanceof vl_5 ) {
return fn_41 ( ( vl_5 ) type ) ;
}
if ( type instanceof tp_2 ) {
return fn_42 ( ( tp_2 ) type ) ;
}
if ( type instanceof vr_13 < ? > ) {
return fn_43 ( ( vr_13 < ? > ) type ) ;
}
if ( type instanceof vl_2 ) {
return fn_44 ( ( vl_2 ) type ) ;
}
throw new IllegalArgumentException ( vr_9 . vr_106 ( type ) ) ;
}
public static String fn_45 ( final vr_13 < ? > vr_21 ) {
vr_51 . vr_52 ( vr_21 , lr_21 ) ;
final StringBuilder vr_107 = new StringBuilder () ;
final tp_3 vr_108 = ( ( vr_13 < ? > ) vr_21 ) . fn_27 () ;
if ( vr_108 instanceof Class < ? > ) {
Class < ? > vr_109 = ( Class < ? > ) vr_108 ;
while ( true ) {
if ( vr_109 . vr_94 () == null ) {
vr_107 . vr_110 ( 0 , vr_109 . vr_111 () ) ;
break;
}
vr_107 . vr_110 ( 0 , vr_109 . vr_112 () ) . vr_110 ( 0 , '.' ) ;
vr_109 = vr_109 . vr_94 () ;
}
}
@Override
public Type getType () {
return type ;
}
public static < vt_1 > vr_113 < vt_1 > fn_46 ( final Class < vt_1 > type ) {
return vr_4 . <vt_1 > fn_46 ( ( Type ) type ) ;
}
private static String fn_40 ( final Class < ? > vr_109 ) {
final StringBuilder vr_107 = new StringBuilder () ;
if ( vr_109 . vr_94 () != null ) {
vr_107 . append ( fn_40 ( vr_109 . vr_94 () ) ) . append ( '.' ) . append ( vr_109 . vr_112 () ) ;
} else {
vr_107 . append ( vr_109 . vr_111 () ) ;
}
if ( vr_109 . vr_44 () . length > 0 ) {
vr_107 . append ( '<' ) ;
fn_47 ( vr_107 , lr_22 , vr_109 . vr_44 () ) ;
vr_107 . append ( '>' ) ;
}
return vr_107 . toString () ;
}
private static String fn_43 ( final vr_13 < ? > vr_114 ) {
final StringBuilder vr_107 = new StringBuilder ( vr_114 . vr_111 () ) ;
final Type [] vr_1 = vr_114 . fn_14 () ;
if ( vr_1 . length > 0 && ! ( vr_1 . length == 1 && Object . class . equals ( vr_1 [ 0 ] ) ) ) {
vr_107 . append ( lr_23 ) ;
fn_47 ( vr_107 , lr_24 , vr_114 . fn_14 () ) ;
}
return vr_107 . toString () ;
}
private static String fn_41 ( final vl_5 vr_85 ) {
final StringBuilder vr_107 = new StringBuilder () ;
final Type vl_4 = vr_85 . fn_8 () ;
final Class < ? > vl_3 = ( Class < ? > ) vr_85 . fn_7 () ;
final Type [] vr_7 = vr_85 . fn_9 () ;
if ( vl_4 == null ) {
vr_107 . append ( vl_3 . vr_111 () ) ;
} else {
if ( vl_4 instanceof Class < ? > ) {
vr_107 . append ( ( ( Class < ? > ) vl_4 ) . vr_111 () ) ;
} else {
vr_107 . append ( vl_4 . toString () ) ;
}
vr_107 . append ( '.' ) . append ( vl_3 . vr_112 () ) ;
}
fn_47 ( vr_107 . append ( '<' ) , lr_22 , vr_7 ) . append ( '>' ) ;
return vr_107 . toString () ;
}
private static String fn_42 ( final tp_2 vr_105 ) {
final StringBuilder vr_107 = new StringBuilder () . append ( '?' ) ;
final Type [] vr_3 = vr_105 . fn_11 () ;
final Type [] vr_2 = vr_105 . fn_10 () ;
if ( vr_3 . length > 1 || vr_3 . length == 1 && vr_3 [ 0 ] != null ) {
fn_47 ( vr_107 . append ( lr_25 ) , lr_24 , vr_3 ) ;
} else if ( vr_2 . length > 1 || vr_2 . length == 1 && ! Object . class . equals ( vr_2 [ 0 ] ) ) {
fn_47 ( vr_107 . append ( lr_23 ) , lr_24 , vr_2 ) ;
}
return vr_107 . toString () ;
}
private static String fn_44 ( final vl_2 vr_115 ) {
return String . vr_116 ( lr_26 , toString ( vr_115 . fn_5 () ) ) ;
}
private static StringBuilder fn_47 ( final StringBuilder vr_107 , final String vr_117 , final Type ... vr_68 ) {
vr_51 . vr_118 ( vr_51 . vr_96 ( vr_68 ) ) ;
if ( vr_68 . length > 0 ) {
vr_107 . append ( toString ( vr_68 [ 0 ] ) ) ;
for ( int vr_45 = 1 ; vr_45 < vr_68 . length ; vr_45 ++ ) {
vr_107 . append ( vr_117 ) . append ( toString ( vr_68 [ vr_45 ] ) ) ;
}
}
return vr_107 ;
}
