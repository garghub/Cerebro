public static String fn_1 ( final Object object , final String vr_1 ) {
if ( object == null ) {
return vr_1 ;
}
return fn_1 ( object . getClass () ) ;
}
public static String fn_1 ( final Class < ? > vr_2 ) {
if ( vr_2 == null ) {
return vr_3 . vr_4 ;
}
return fn_1 ( vr_2 . vr_5 () ) ;
}
public static String fn_1 ( String vr_6 ) {
if ( vr_3 . isEmpty ( vr_6 ) ) {
return vr_3 . vr_4 ;
}
final StringBuilder vr_7 = new StringBuilder () ;
if ( vr_6 . vr_8 ( lr_1 ) ) {
while ( vr_6 . charAt ( 0 ) == '[' ) {
vr_6 = vr_6 . vr_9 ( 1 ) ;
vr_7 . append ( lr_2 ) ;
}
if ( vr_6 . charAt ( 0 ) == 'L' && vr_6 . charAt ( vr_6 . length () - 1 ) == ';' ) {
vr_6 = vr_6 . vr_9 ( 1 , vr_6 . length () - 1 ) ;
}
if ( vr_10 . vr_11 ( vr_6 ) ) {
vr_6 = vr_10 . get ( vr_6 ) ;
}
}
final int vr_12 = vr_6 . vr_13 ( vl_1 ) ;
final int vr_14 = vr_6 . indexOf (
vl_2 , vr_12 == - 1 ? 0 : vr_12 + 1 ) ;
String out = vr_6 . vr_9 ( vr_12 + 1 ) ;
if ( vr_14 != - 1 ) {
out = out . vr_15 ( vl_2 , vl_1 ) ;
}
return out + vr_7 ;
}
public static String fn_2 ( final Class < ? > vr_2 ) {
if ( vr_2 == null ) {
return vr_3 . vr_4 ;
}
return vr_2 . fn_2 () ;
}
public static String fn_2 ( final Object object , final String vr_1 ) {
if ( object == null ) {
return vr_1 ;
}
return fn_2 ( object . getClass () ) ;
}
public static String fn_3 ( final Object object , final String vr_1 ) {
if ( object == null ) {
return vr_1 ;
}
return fn_3 ( object . getClass () ) ;
}
public static String fn_3 ( final Class < ? > vr_2 ) {
if ( vr_2 == null ) {
return vr_3 . vr_4 ;
}
return fn_3 ( vr_2 . vr_5 () ) ;
}
public static String fn_3 ( String vr_6 ) {
if ( vr_3 . isEmpty ( vr_6 ) ) {
return vr_3 . vr_4 ;
}
while ( vr_6 . charAt ( 0 ) == '[' ) {
vr_6 = vr_6 . vr_9 ( 1 ) ;
}
if ( vr_6 . charAt ( 0 ) == 'L' && vr_6 . charAt ( vr_6 . length () - 1 ) == ';' ) {
vr_6 = vr_6 . vr_9 ( 1 ) ;
}
final int vr_16 = vr_6 . vr_13 ( vl_1 ) ;
if ( vr_16 == - 1 ) {
return vr_3 . vr_4 ;
}
return vr_6 . vr_9 ( 0 , vr_16 ) ;
}
public static String fn_4 ( final Class < ? > vr_2 , int vr_17 ) {
if ( vr_2 == null ) {
return vr_3 . vr_4 ;
}
return fn_4 ( vr_2 . vr_5 () , vr_17 ) ;
}
public static String fn_4 ( String vr_6 , int vr_17 ) {
if ( vr_17 <= 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( vr_6 == null ) {
return vr_3 . vr_4 ;
}
int vr_18 = vr_17 ;
int vr_19 = vr_3 . vr_20 ( vr_6 , '.' ) ;
String [] vr_21 = new String [ vr_19 + 1 ] ;
int vr_22 = vr_6 . length () - 1 ;
for ( int vr_23 = vr_19 ; vr_23 >= 0 ; vr_23 -- ) {
int vr_24 = vr_6 . vr_13 ( '.' , vr_22 ) ;
String vr_25 = vr_6 . vr_9 ( vr_24 + 1 , vr_22 + 1 ) ;
vr_18 -= vr_25 . length () ;
if ( vr_23 > 0 ) {
vr_18 -- ;
}
if ( vr_23 == vr_19 ) {
vr_21 [ vr_23 ] = vr_25 ;
} else {
if ( vr_18 > 0 ) {
vr_21 [ vr_23 ] = vr_25 ;
} else {
vr_21 [ vr_23 ] = vr_25 . vr_9 ( 0 , 1 ) ;
}
}
vr_22 = vr_24 - 1 ;
}
return vr_3 . vr_26 ( vr_21 , '.' ) ;
}
public static List < Class < ? > > fn_5 ( final Class < ? > vr_2 ) {
if ( vr_2 == null ) {
return null ;
}
final List < Class < ? > > vr_27 = new ArrayList < Class < ? > > () ;
Class < ? > vr_28 = vr_2 . vr_29 () ;
while ( vr_28 != null ) {
vr_27 . add ( vr_28 ) ;
vr_28 = vr_28 . vr_29 () ;
}
return vr_27 ;
}
public static List < Class < ? > > fn_6 ( final Class < ? > vr_2 ) {
if ( vr_2 == null ) {
return null ;
}
final vr_30 < Class < ? > > vr_31 = new vr_30 < Class < ? > > () ;
fn_6 ( vr_2 , vr_31 ) ;
return new ArrayList < Class < ? > > ( vr_31 ) ;
}
private static void fn_6 ( Class < ? > vr_2 , final vr_32 < Class < ? > > vr_31 ) {
while ( vr_2 != null ) {
final Class < ? > [] vr_33 = vr_2 . vr_34 () ;
for ( final Class < ? > vr_16 : vr_33 ) {
if ( vr_31 . add ( vr_16 ) ) {
fn_6 ( vr_16 , vr_31 ) ;
}
}
vr_2 = vr_2 . vr_29 () ;
}
}
public static List < Class < ? > > fn_7 ( final List < String > vr_35 ) {
if ( vr_35 == null ) {
return null ;
}
final List < Class < ? > > vr_27 = new ArrayList < Class < ? > > ( vr_35 . size () ) ;
for ( final String vr_6 : vr_35 ) {
try {
vr_27 . add ( Class . vr_36 ( vr_6 ) ) ;
} catch ( final Exception vr_37 ) {
vr_27 . add ( null ) ;
}
}
return vr_27 ;
}
public static List < String > fn_8 ( final List < Class < ? > > vr_27 ) {
if ( vr_27 == null ) {
return null ;
}
final List < String > vr_35 = new ArrayList < String > ( vr_27 . size () ) ;
for ( final Class < ? > vr_2 : vr_27 ) {
if ( vr_2 == null ) {
vr_35 . add ( null ) ;
} else {
vr_35 . add ( vr_2 . vr_5 () ) ;
}
}
return vr_35 ;
}
public static boolean fn_9 ( final Class < ? > [] vr_38 , final Class < ? > ... vr_39 ) {
return fn_9 ( vr_38 , vr_39 , vr_40 . vr_41 ( vr_42 . vr_43 ) ) ;
}
public static boolean fn_9 ( Class < ? > [] vr_38 , Class < ? > [] vr_39 , final boolean vr_44 ) {
if ( vr_45 . vr_46 ( vr_38 , vr_39 ) == false ) {
return false ;
}
if ( vr_38 == null ) {
vr_38 = vr_45 . vr_47 ;
}
if ( vr_39 == null ) {
vr_39 = vr_45 . vr_47 ;
}
for ( int vr_16 = 0 ; vr_16 < vr_38 . length ; vr_16 ++ ) {
if ( fn_9 ( vr_38 [ vr_16 ] , vr_39 [ vr_16 ] , vr_44 ) == false ) {
return false ;
}
}
return true ;
}
public static boolean fn_10 ( final Class < ? > type ) {
if ( type == null ) {
return false ;
}
return type . vr_48 () || fn_11 ( type ) ;
}
public static boolean fn_11 ( final Class < ? > type ) {
return vr_49 . vr_11 ( type ) ;
}
public static boolean fn_9 ( final Class < ? > vr_2 , final Class < ? > vr_50 ) {
return fn_9 ( vr_2 , vr_50 , vr_40 . vr_41 ( vr_42 . vr_43 ) ) ;
}
public static boolean fn_9 ( Class < ? > vr_2 , final Class < ? > vr_50 , final boolean vr_44 ) {
if ( vr_50 == null ) {
return false ;
}
if ( vr_2 == null ) {
return ! vr_50 . vr_48 () ;
}
if ( vr_44 ) {
if ( vr_2 . vr_48 () && ! vr_50 . vr_48 () ) {
vr_2 = fn_12 ( vr_2 ) ;
if ( vr_2 == null ) {
return false ;
}
}
if ( vr_50 . vr_48 () && ! vr_2 . vr_48 () ) {
vr_2 = fn_13 ( vr_2 ) ;
if ( vr_2 == null ) {
return false ;
}
}
}
if ( vr_2 . equals ( vr_50 ) ) {
return true ;
}
if ( vr_2 . vr_48 () ) {
if ( vr_50 . vr_48 () == false ) {
return false ;
}
if ( Integer . TYPE . equals ( vr_2 ) ) {
return Long . TYPE . equals ( vr_50 )
|| Float . TYPE . equals ( vr_50 )
|| Double . TYPE . equals ( vr_50 ) ;
}
if ( Long . TYPE . equals ( vr_2 ) ) {
return Float . TYPE . equals ( vr_50 )
|| Double . TYPE . equals ( vr_50 ) ;
}
if ( Boolean . TYPE . equals ( vr_2 ) ) {
return false ;
}
if ( Double . TYPE . equals ( vr_2 ) ) {
return false ;
}
if ( Float . TYPE . equals ( vr_2 ) ) {
return Double . TYPE . equals ( vr_50 ) ;
}
if ( vr_51 . TYPE . equals ( vr_2 ) ) {
return Integer . TYPE . equals ( vr_50 )
|| Long . TYPE . equals ( vr_50 )
|| Float . TYPE . equals ( vr_50 )
|| Double . TYPE . equals ( vr_50 ) ;
}
if ( Short . TYPE . equals ( vr_2 ) ) {
return Integer . TYPE . equals ( vr_50 )
|| Long . TYPE . equals ( vr_50 )
|| Float . TYPE . equals ( vr_50 )
|| Double . TYPE . equals ( vr_50 ) ;
}
if ( Byte . TYPE . equals ( vr_2 ) ) {
return Short . TYPE . equals ( vr_50 )
|| Integer . TYPE . equals ( vr_50 )
|| Long . TYPE . equals ( vr_50 )
|| Float . TYPE . equals ( vr_50 )
|| Double . TYPE . equals ( vr_50 ) ;
}
return false ;
}
return vr_50 . vr_52 ( vr_2 ) ;
}
public static Class < ? > fn_12 ( final Class < ? > vr_2 ) {
Class < ? > vr_53 = vr_2 ;
if ( vr_2 != null && vr_2 . vr_48 () ) {
vr_53 = vr_54 . get ( vr_2 ) ;
}
return vr_53 ;
}
public static Class < ? > [] fn_14 ( final Class < ? > ... vr_27 ) {
if ( vr_27 == null ) {
return null ;
}
if ( vr_27 . length == 0 ) {
return vr_27 ;
}
final Class < ? > [] vr_55 = new Class [ vr_27 . length ] ;
for ( int vr_16 = 0 ; vr_16 < vr_27 . length ; vr_16 ++ ) {
vr_55 [ vr_16 ] = fn_12 ( vr_27 [ vr_16 ] ) ;
}
return vr_55 ;
}
public static Class < ? > fn_13 ( final Class < ? > vr_2 ) {
return vr_49 . get ( vr_2 ) ;
}
public static Class < ? > [] fn_15 ( final Class < ? > ... vr_27 ) {
if ( vr_27 == null ) {
return null ;
}
if ( vr_27 . length == 0 ) {
return vr_27 ;
}
final Class < ? > [] vr_55 = new Class [ vr_27 . length ] ;
for ( int vr_16 = 0 ; vr_16 < vr_27 . length ; vr_16 ++ ) {
vr_55 [ vr_16 ] = fn_13 ( vr_27 [ vr_16 ] ) ;
}
return vr_55 ;
}
public static boolean fn_16 ( final Class < ? > vr_2 ) {
return vr_2 != null && vr_2 . vr_56 () != null ;
}
public static Class < ? > getClass (
final tp_1 vr_57 , final String vr_6 , final boolean vr_58 ) throws vl_3 {
try {
Class < ? > vr_59 ;
if ( vr_60 . vr_11 ( vr_6 ) ) {
final String vr_61 = lr_1 + vr_60 . get ( vr_6 ) ;
vr_59 = Class . vr_36 ( vr_61 , vr_58 , vr_57 ) . fn_17 () ;
} else {
vr_59 = Class . vr_36 ( fn_18 ( vr_6 ) , vr_58 , vr_57 ) ;
}
return vr_59 ;
} catch ( final vl_3 vr_37 ) {
final int vr_62 = vr_6 . vr_13 ( vl_1 ) ;
if ( vr_62 != - 1 ) {
try {
return getClass ( vr_57 , vr_6 . vr_9 ( 0 , vr_62 ) +
vl_2 + vr_6 . vr_9 ( vr_62 + 1 ) ,
vr_58 ) ;
} catch ( final vl_3 vr_63 ) {
}
}
throw vr_37 ;
}
}
public static Class < ? > getClass ( final tp_1 vr_57 , final String vr_6 ) throws vl_3 {
return getClass ( vr_57 , vr_6 , true ) ;
}
public static Class < ? > getClass ( final String vr_6 ) throws vl_3 {
return getClass ( vr_6 , true ) ;
}
public static Class < ? > getClass ( final String vr_6 , final boolean vr_58 ) throws vl_3 {
final tp_1 vr_64 = vr_65 . vr_66 () . fn_19 () ;
final tp_1 vr_67 = vr_64 == null ? vr_68 . class . vr_69 () : vr_64 ;
return getClass ( vr_67 , vr_6 , vr_58 ) ;
}
public static tp_2 fn_20 ( final Class < ? > vr_2 , final String vr_70 , final Class < ? > ... vr_71 )
throws vl_4 , vl_5 {
final tp_2 vr_72 = vr_2 . vr_73 ( vr_70 , vr_71 ) ;
if ( vr_74 . vr_75 ( vr_72 . vr_76 () . fn_21 () ) ) {
return vr_72 ;
}
final List < Class < ? > > vr_77 = new ArrayList < Class < ? > > () ;
vr_77 . vr_78 ( fn_6 ( vr_2 ) ) ;
vr_77 . vr_78 ( fn_5 ( vr_2 ) ) ;
for ( final Class < ? > vr_79 : vr_77 ) {
if ( ! vr_74 . vr_75 ( vr_79 . fn_21 () ) ) {
continue;
}
tp_2 vr_80 ;
try {
vr_80 = vr_79 . vr_73 ( vr_70 , vr_71 ) ;
} catch ( final vl_5 vr_37 ) {
continue;
}
if ( vr_74 . vr_75 ( vr_80 . vr_76 () . fn_21 () ) ) {
return vr_80 ;
}
}
throw new vl_5 ( lr_4 +
vr_70 + lr_5 + vr_45 . toString ( vr_71 ) ) ;
}
private static String fn_18 ( String vr_6 ) {
vr_6 = vr_3 . vr_81 ( vr_6 ) ;
if ( vr_6 == null ) {
throw new fn_22 ( lr_6 ) ;
} else if ( vr_6 . vr_82 ( lr_2 ) ) {
final StringBuilder vr_83 = new StringBuilder () ;
while ( vr_6 . vr_82 ( lr_2 ) ) {
vr_6 = vr_6 . vr_9 ( 0 , vr_6 . length () - 2 ) ;
vr_83 . append ( lr_1 ) ;
}
final String vr_84 = vr_60 . get ( vr_6 ) ;
if ( vr_84 != null ) {
vr_83 . append ( vr_84 ) ;
} else {
vr_83 . append ( lr_7 ) . append ( vr_6 ) . append ( lr_8 ) ;
}
vr_6 = vr_83 . toString () ;
}
return vr_6 ;
}
public static Class < ? > [] vr_50 ( final Object ... array ) {
if ( array == null ) {
return null ;
} else if ( array . length == 0 ) {
return vr_45 . vr_47 ;
}
final Class < ? > [] vr_27 = new Class [ array . length ] ;
for ( int vr_16 = 0 ; vr_16 < array . length ; vr_16 ++ ) {
vr_27 [ vr_16 ] = array [ vr_16 ] == null ? null : array [ vr_16 ] . getClass () ;
}
return vr_27 ;
}
public static String fn_23 ( final Object object , final String vr_1 ) {
if ( object == null ) {
return vr_1 ;
}
return fn_23 ( object . getClass () . vr_5 () ) ;
}
public static String fn_23 ( final Class < ? > vr_2 ) {
if ( vr_2 == null ) {
return vr_3 . vr_4 ;
}
return fn_23 ( vr_2 . vr_5 () ) ;
}
public static String fn_23 ( final String vr_85 ) {
return vr_68 . fn_1 ( fn_24 ( vr_85 ) ) ;
}
public static String fn_25 ( final Object object , final String vr_1 ) {
if ( object == null ) {
return vr_1 ;
}
return fn_25 ( object . getClass () . vr_5 () ) ;
}
public static String fn_25 ( final Class < ? > vr_2 ) {
if ( vr_2 == null ) {
return vr_3 . vr_4 ;
}
return fn_25 ( vr_2 . vr_5 () ) ;
}
public static String fn_25 ( final String vr_85 ) {
return vr_68 . fn_3 ( fn_24 ( vr_85 ) ) ;
}
private static String fn_24 ( String vr_6 ) {
vr_6 = vr_3 . vr_81 ( vr_6 ) ;
if ( vr_6 == null ) {
return null ;
}
int vr_86 = 0 ;
while ( vr_6 . vr_8 ( lr_1 ) ) {
vr_86 ++ ;
vr_6 = vr_6 . vr_9 ( 1 ) ;
}
if ( vr_86 < 1 ) {
return vr_6 ;
}
if ( vr_6 . vr_8 ( lr_7 ) ) {
vr_6 = vr_6 . vr_9 (
1 ,
vr_6 . vr_82 ( lr_8 )
? vr_6 . length () - 1
: vr_6 . length () ) ;
} else {
if ( vr_6 . length () > 0 ) {
vr_6 = vr_10 . get ( vr_6 . vr_9 ( 0 , 1 ) ) ;
}
}
final StringBuilder vr_87 = new StringBuilder ( vr_6 ) ;
for ( int vr_16 = 0 ; vr_16 < vr_86 ; vr_16 ++ ) {
vr_87 . append ( lr_2 ) ;
}
return vr_87 . toString () ;
}
public static vr_88 < Class < ? > > fn_26 ( final Class < ? > type ) {
return fn_26 ( type , vr_89 . vr_90 ) ;
}
@Override
public boolean hasNext () {
return vr_91 . vr_92 () != null ;
}
@Override
public Class < ? > vr_91 () {
final Class < ? > vr_93 = vr_91 . vr_92 () ;
vr_91 . vr_94 ( vr_93 . vr_29 () ) ;
return vr_93 ;
}
@Override
public void remove () {
throw new fn_27 () ;
}
@Override
public boolean hasNext () {
return vr_33 . hasNext () || vr_95 . hasNext () ;
}
@Override
public Class < ? > vr_91 () {
if ( vr_33 . hasNext () ) {
final Class < ? > vr_96 = vr_33 . vr_91 () ;
vr_97 . add ( vr_96 ) ;
return vr_96 ;
}
final Class < ? > vr_98 = vr_95 . vr_91 () ;
final vr_99 < Class < ? > > vr_100 = new vr_30 < Class < ? > > () ;
fn_28 ( vr_100 , vr_98 ) ;
vr_33 = vr_100 . iterator () ;
return vr_98 ;
}
private void fn_28 ( final vr_99 < Class < ? > > vr_101 , final Class < ? > vr_102 ) {
for ( final Class < ? > vr_103 : vr_102 . vr_34 () ) {
if ( ! vr_97 . contains ( vr_103 ) ) {
vr_101 . add ( vr_103 ) ;
}
fn_28 ( vr_101 , vr_103 ) ;
}
}
@Override
public void remove () {
throw new fn_27 () ;
}
