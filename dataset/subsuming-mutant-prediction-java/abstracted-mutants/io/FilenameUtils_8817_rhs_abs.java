static boolean fn_1 () {
return vl_1 == vl_2 ;
}
private static boolean fn_2 ( final char vr_1 ) {
return vr_1 == vl_3 || vr_1 == vl_2 ;
}
public static String fn_3 ( final String vr_2 ) {
return fn_4 ( vr_2 , vl_1 , true ) ;
}
public static String fn_3 ( final String vr_2 , final boolean vr_3 ) {
final char vr_4 = vr_3 ? vl_3 : vl_2 ;
return fn_4 ( vr_2 , vr_4 , true ) ;
}
public static String fn_5 ( final String vr_2 ) {
return fn_4 ( vr_2 , vl_1 , false ) ;
}
public static String fn_5 ( final String vr_2 , final boolean vr_3 ) {
final char vr_4 = vr_3 ? vl_3 : vl_2 ;
return fn_4 ( vr_2 , vr_4 , false ) ;
}
private static String fn_4 ( final String vr_2 , final char vr_4 , final boolean vr_5 ) {
if ( vr_2 == null ) {
return null ;
}
fn_6 ( vr_2 ) ;
int size = vr_2 . length () ;
if ( size == 0 ) {
return vr_2 ;
}
final int vr_6 = fn_7 ( vr_2 ) ;
if ( vr_6 < 0 ) {
return null ;
}
final char [] array = new char [ size + 2 ] ;
vr_2 . vr_7 ( 0 , vr_2 . length () , array , 0 ) ;
final char vr_8 = vr_4 == vl_1 ? vl_4 : vl_1 ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
if ( array [ vr_9 ] == vr_8 ) {
array [ vr_9 ] = vr_4 ;
}
}
boolean vr_10 = true ;
if ( array [ size - 1 ] != vr_4 ) {
array [ size ++ ] = vr_4 ;
vr_10 = false ;
}
for ( int vr_9 = vr_6 + 1 ; vr_9 < size ; vr_9 ++ ) {
if ( array [ vr_9 ] == vr_4 && array [ vr_9 - 1 ] == vr_4 ) {
System . vr_11 ( array , vr_9 , array , vr_9 - 1 , size - vr_9 ) ;
size -- ;
vr_9 -- ;
}
}
for ( int vr_9 = vr_6 + 1 ; vr_9 < size ; vr_9 ++ ) {
if ( array [ vr_9 ] == vr_4 && array [ vr_9 - 1 ] == '.' &&
( vr_9 == vr_6 + 1 || array [ vr_9 - 2 ] == vr_4 ) ) {
if ( vr_9 == size - 1 ) {
vr_10 = true ;
}
System . vr_11 ( array , vr_9 + 1 , array , vr_9 - 1 , size - vr_9 ) ;
size -= 2 ;
vr_9 -- ;
}
}
lb_1:
for ( int vr_9 = vr_6 + 2 ; vr_9 < size ; vr_9 ++ ) {
if ( array [ vr_9 ] == vr_4 && array [ vr_9 - 1 ] == '.' && array [ vr_9 - 2 ] == '.' &&
( vr_9 == vr_6 + 2 || array [ vr_9 - 3 ] == vr_4 ) ) {
if ( vr_9 == vr_6 + 2 ) {
return null ;
}
if ( vr_9 == size - 1 ) {
vr_10 = true ;
}
int vr_12 ;
for ( vr_12 = vr_9 - 4 ; vr_12 >= vr_6 ; vr_12 -- ) {
if ( array [ vr_12 ] == vr_4 ) {
System . vr_11 ( array , vr_9 + 1 , array , vr_12 + 1 , size - vr_9 ) ;
size -= vr_9 - vr_12 ;
vr_9 = vr_12 + 1 ;
continue lb_1;
}
}
System . vr_11 ( array , vr_9 + 1 , array , vr_6 , size - vr_9 ) ;
size -= vr_9 + 1 - vr_6 ;
vr_9 = vr_6 + 1 ;
}
}
if ( size <= 0 ) {
return vl_5 ;
}
if ( size <= vr_6 ) {
return new String ( array , 0 , size ) ;
}
if ( vr_10 && vr_5 ) {
return new String ( array , 0 , size ) ;
}
return new String ( array , 0 , size - 1 ) ;
}
public static String fn_8 ( final String vr_13 , final String vr_14 ) {
final int vr_6 = fn_7 ( vr_14 ) ;
if ( vr_6 < 0 ) {
return null ;
}
if ( vr_6 > 0 ) {
return fn_3 ( vr_14 ) ;
}
if ( vr_13 == null ) {
return null ;
}
final int vr_15 = vr_13 . length () ;
if ( vr_15 == 0 ) {
return fn_3 ( vr_14 ) ;
}
final char vr_1 = vr_13 . charAt ( vr_15 - 1 ) ;
if ( fn_2 ( vr_1 ) ) {
return fn_3 ( vr_13 + vr_14 ) ;
}
return fn_3 ( vr_13 + '/' + vr_14 ) ;
}
public static boolean fn_9 ( final String vr_16 , final String vr_17 )
throws IOException {
if ( vr_16 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_17 == null ) {
return false ;
}
if ( vr_18 . SYSTEM . vr_19 ( vr_16 , vr_17 ) ) {
return false ;
}
return vr_18 . SYSTEM . vr_20 ( vr_17 , vr_16 ) ;
}
public static String fn_10 ( final String vr_21 ) {
if ( vr_21 == null || vr_21 . indexOf ( vl_2 ) == vl_6 ) {
return vr_21 ;
}
return vr_21 . vr_22 ( vl_2 , vl_3 ) ;
}
public static String fn_11 ( final String vr_21 ) {
if ( vr_21 == null || vr_21 . indexOf ( vl_3 ) == vl_6 ) {
return vr_21 ;
}
return vr_21 . vr_22 ( vl_3 , vl_2 ) ;
}
public static String fn_12 ( final String vr_21 ) {
if ( vr_21 == null ) {
return null ;
}
return fn_1 () ? fn_11 ( vr_21 ) : fn_10 ( vr_21 ) ;
}
public static int fn_7 ( final String vr_2 ) {
if ( vr_2 == null ) {
return vl_6 ;
}
final int vr_15 = vr_2 . length () ;
if ( vr_15 == 0 ) {
return 0 ;
}
char vr_23 = vr_2 . charAt ( 0 ) ;
if ( vr_23 == ':' ) {
return vl_6 ;
}
if ( vr_15 == 1 ) {
if ( vr_23 == '~' ) {
return 2 ;
}
return fn_2 ( vr_23 ) ? 1 : 0 ;
}
if ( vr_23 == '~' ) {
int vr_24 = vr_2 . indexOf ( vl_3 , 1 ) ; MST[rv.CRCR2Mutator]MSP[N]
int vr_25 = vr_2 . indexOf ( vl_2 , 1 ) ;
if ( vr_24 == vl_6 && vr_25 == vl_6 ) {
return vr_15 + 1 ;
}
vr_24 = vr_24 == vl_6 ? vr_25 : vr_24 ;
vr_25 = vr_25 == vl_6 ? vr_24 : vr_25 ;
return vr_26 . vr_27 ( vr_24 , vr_25 ) + 1 ;
}
final char vr_28 = vr_2 . charAt ( 1 ) ;
if ( vr_28 == ':' ) {
vr_23 = vr_29 . vr_30 ( vr_23 ) ;
if ( vr_23 >= 'A' && vr_23 <= 'Z' ) {
if ( vr_15 == 2 || fn_2 ( vr_2 . charAt ( 2 ) ) == false ) {
return 2 ;
}
return 3 ;
} else if ( vr_23 == vl_3 ) {
return 1 ;
}
return vl_6 ;
} else if ( fn_2 ( vr_23 ) && fn_2 ( vr_28 ) ) {
int vr_24 = vr_2 . indexOf ( vl_3 , 2 ) ;
int vr_25 = vr_2 . indexOf ( vl_2 , 2 ) ;
if ( vr_24 == vl_6 && vr_25 == vl_6 || vr_24 == 2 || vr_25 == 2 ) {
return vl_6 ;
}
vr_24 = vr_24 == vl_6 ? vr_25 : vr_24 ;
vr_25 = vr_25 == vl_6 ? vr_24 : vr_25 ;
final int vr_31 = vr_26 . vr_27 ( vr_24 , vr_25 ) + 1 ;
final String vr_32 = vr_2 . vr_33 ( 2 , vr_31 - 1 ) ;
return fn_13 ( vr_32 ) ? vr_31 : vl_6 ;
} else {
return fn_2 ( vr_23 ) ? 1 : 0 ;
}
}
public static int fn_14 ( final String vr_2 ) {
if ( vr_2 == null ) {
return vl_6 ;
}
final int vr_34 = vr_2 . vr_35 ( vl_3 ) ;
final int vr_36 = vr_2 . vr_35 ( vl_2 ) ;
return vr_26 . vr_37 ( vr_34 , vr_36 ) ;
}
public static int fn_15 ( final String vr_2 ) throws IllegalArgumentException {
if ( vr_2 == null ) {
return vl_6 ;
}
if ( fn_1 () ) {
final int vr_38 = vr_2 . indexOf ( ':' , fn_16 ( vr_2 ) ) ;
if ( vr_38 != - 1 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
final int vr_39 = vr_2 . vr_35 ( vl_7 ) ;
final int vr_40 = fn_14 ( vr_2 ) ;
return vr_40 > vr_39 ? vl_6 : vr_39 ;
}
public static String fn_17 ( final String vr_2 ) {
if ( vr_2 == null ) {
return null ;
}
final int vr_15 = fn_7 ( vr_2 ) ;
if ( vr_15 < 0 ) {
return null ;
}
if ( vr_15 > vr_2 . length () ) {
fn_6 ( vr_2 + vl_3 ) ;
return vr_2 + vl_3 ;
}
final String vr_21 = vr_2 . vr_33 ( 0 , vr_15 ) ;
fn_6 ( vr_21 ) ;
return vr_21 ;
}
public static String fn_18 ( final String vr_2 ) {
return fn_19 ( vr_2 , 1 ) ;
}
public static String fn_20 ( final String vr_2 ) {
return fn_19 ( vr_2 , 0 ) ;
}
private static String fn_19 ( final String vr_2 , final int vr_41 ) {
if ( vr_2 == null ) {
return null ;
}
final int vr_6 = fn_7 ( vr_2 ) ;
if ( vr_6 < 0 ) {
return null ;
}
final int vr_42 = fn_14 ( vr_2 ) ;
final int vr_43 = vr_42 + vr_41 ;
if ( vr_6 >= vr_2 . length () || vr_42 < 0 || vr_6 >= vr_43 ) {
return vl_5 ;
}
final String vr_21 = vr_2 . vr_33 ( vr_6 , vr_43 ) ;
fn_6 ( vr_21 ) ;
return vr_21 ;
}
public static String fn_21 ( final String vr_2 ) {
return fn_22 ( vr_2 , true ) ;
}
public static String fn_23 ( final String vr_2 ) {
return fn_22 ( vr_2 , false ) ;
}
private static String fn_22 ( final String vr_2 , final boolean vr_44 ) {
if ( vr_2 == null ) {
return null ;
}
final int vr_6 = fn_7 ( vr_2 ) ;
if ( vr_6 < 0 ) {
return null ;
}
if ( vr_6 >= vr_2 . length () ) {
if ( vr_44 ) {
return fn_17 ( vr_2 ) ;
}
return vr_2 ;
}
final int vr_42 = fn_14 ( vr_2 ) ;
if ( vr_42 < 0 ) {
return vr_2 . vr_33 ( 0 , vr_6 ) ;
}
int vr_45 = vr_42 + ( vr_44 ? 1 : 0 ) ;
if ( vr_45 == 0 ) {
vr_45 ++ ;
}
return vr_2 . vr_33 ( 0 , vr_45 ) ;
}
public static String fn_24 ( final String vr_2 ) {
if ( vr_2 == null ) {
return null ;
}
fn_6 ( vr_2 ) ;
final int vr_42 = fn_14 ( vr_2 ) ;
return vr_2 . vr_33 ( vr_42 + 1 ) ;
}
private static void fn_6 ( final String vr_21 ) {
final int vr_15 = vr_21 . length () ;
for ( int vr_9 = 0 ; vr_9 < vr_15 ; vr_9 ++ ) {
if ( vr_21 . charAt ( vr_9 ) == 0 ) {
throw new IllegalArgumentException ( lr_3 +
lr_4 ) ;
}
}
}
public static String fn_25 ( final String vr_2 ) {
return fn_26 ( fn_24 ( vr_2 ) ) ;
}
public static String fn_27 ( final String vr_2 ) throws IllegalArgumentException {
if ( vr_2 == null ) {
return null ;
}
final int vr_42 = fn_15 ( vr_2 ) ;
if ( vr_42 == vl_6 ) {
return vl_5 ;
}
return vr_2 . vr_33 ( vr_42 + 1 ) ;
}
private static int fn_16 ( final String vr_2 ) {
final int vr_46 = vr_2 . vr_35 ( vl_1 ) ;
final int vr_47 = vr_2 . vr_35 ( vl_4 ) ;
if ( vr_46 == - 1 ) {
if ( vr_47 == - 1 ) {
return 0 ;
}
return vr_47 + 1 ;
}
if ( vr_47 == - 1 ) {
return vr_46 + 1 ;
}
return vr_26 . vr_37 ( vr_46 , vr_47 ) + 1 ;
}
public static String fn_26 ( final String vr_2 ) {
if ( vr_2 == null ) {
return null ;
}
fn_6 ( vr_2 ) ;
final int vr_42 = fn_15 ( vr_2 ) ;
if ( vr_42 == vl_6 ) {
return vr_2 ;
}
return vr_2 . vr_33 ( 0 , vr_42 ) ;
}
public static boolean equals ( final String vr_48 , final String vr_49 ) {
return equals ( vr_48 , vr_49 , false , vr_18 . vr_50 ) ;
}
public static boolean fn_28 ( final String vr_48 , final String vr_49 ) {
return equals ( vr_48 , vr_49 , false , vr_18 . SYSTEM ) ;
}
public static boolean fn_29 ( final String vr_48 , final String vr_49 ) {
return equals ( vr_48 , vr_49 , true , vr_18 . vr_50 ) ;
}
public static boolean fn_30 ( final String vr_48 , final String vr_49 ) {
return equals ( vr_48 , vr_49 , true , vr_18 . SYSTEM ) ;
}
public static boolean equals (
String vr_48 , String vr_49 ,
final boolean vr_51 , vr_18 vr_52 ) {
if ( vr_48 == null || vr_49 == null ) {
return vr_48 == null && vr_49 == null ;
}
if ( vr_51 ) {
vr_48 = fn_3 ( vr_48 ) ;
vr_49 = fn_3 ( vr_49 ) ;
if ( vr_48 == null || vr_49 == null ) {
throw new fn_31 (
lr_5 ) ;
}
}
if ( vr_52 == null ) {
vr_52 = vr_18 . vr_50 ;
}
return vr_52 . vr_19 ( vr_48 , vr_49 ) ;
}
public static boolean fn_32 ( final String vr_2 , final String vr_53 ) {
if ( vr_2 == null ) {
return false ;
}
fn_6 ( vr_2 ) ;
if ( vr_53 == null || vr_53 . isEmpty () ) {
return fn_15 ( vr_2 ) == vl_6 ;
}
final String vr_54 = fn_27 ( vr_2 ) ;
return vr_54 . equals ( vr_53 ) ;
}
public static boolean fn_32 ( final String vr_2 , final String ... vr_55 ) {
if ( vr_2 == null ) {
return false ;
}
fn_6 ( vr_2 ) ;
if ( vr_55 == null || vr_55 . length == 0 ) {
return fn_15 ( vr_2 ) == vl_6 ;
}
final String vr_54 = fn_27 ( vr_2 ) ;
for ( final String vr_53 : vr_55 ) {
if ( vr_54 . equals ( vr_53 ) ) {
return true ;
}
}
return false ;
}
public static boolean fn_32 ( final String vr_2 , final Collection < String > vr_55 ) {
if ( vr_2 == null ) {
return false ;
}
fn_6 ( vr_2 ) ;
if ( vr_55 == null || vr_55 . isEmpty () ) {
return fn_15 ( vr_2 ) == vl_6 ;
}
final String vr_54 = fn_27 ( vr_2 ) ;
for ( final String vr_53 : vr_55 ) {
if ( vr_54 . equals ( vr_53 ) ) {
return true ;
}
}
return false ;
}
public static boolean fn_33 ( final String vr_2 , final String vr_56 ) {
return fn_33 ( vr_2 , vr_56 , vr_18 . vr_50 ) ;
}
public static boolean fn_34 ( final String vr_2 , final String vr_56 ) {
return fn_33 ( vr_2 , vr_56 , vr_18 . SYSTEM ) ;
}
public static boolean fn_33 ( final String vr_2 , final String vr_56 , vr_18 vr_52 ) {
if ( vr_2 == null && vr_56 == null ) {
return true ;
}
if ( vr_2 == null || vr_56 == null ) {
return false ;
}
if ( vr_52 == null ) {
vr_52 = vr_18 . vr_50 ;
}
final String [] vr_57 = fn_35 ( vr_56 ) ;
boolean vr_58 = false ;
int vr_59 = 0 ;
int vr_60 = 0 ;
final vr_61 < int [] > vr_62 = new vr_61 <> () ;
do {
if ( vr_62 . size () > 0 ) {
final int [] array = vr_62 . vr_63 () ;
vr_60 = array [ 0 ] ;
vr_59 = array [ 1 ] ;
vr_58 = true ;
}
while ( vr_60 < vr_57 . length ) {
if ( vr_57 [ vr_60 ] . equals ( lr_6 ) ) {
vr_59 ++ ;
if ( vr_59 > vr_2 . length () ) {
break;
}
vr_58 = false ;
} else if ( vr_57 [ vr_60 ] . equals ( lr_7 ) ) {
vr_58 = true ;
if ( vr_60 == vr_57 . length - 1 ) {
vr_59 = vr_2 . length () ;
}
} else {
if ( vr_58 ) {
vr_59 = vr_52 . vr_64 ( vr_2 , vr_59 , vr_57 [ vr_60 ] ) ;
if ( vr_59 == vl_6 ) {
break;
}
final int vr_65 = vr_52 . vr_64 ( vr_2 , vr_59 + 1 , vr_57 [ vr_60 ] ) ;
if ( vr_65 >= 0 ) {
vr_62 . vr_66 ( new int [] { vr_60 , vr_65 } ) ;
}
} else {
if ( ! vr_52 . vr_67 ( vr_2 , vr_59 , vr_57 [ vr_60 ] ) ) {
break;
}
}
vr_59 += vr_57 [ vr_60 ] . length () ;
vr_58 = false ;
}
vr_60 ++ ;
}
if ( vr_60 == vr_57 . length && vr_59 == vr_2 . length () ) {
return true ;
}
} while ( vr_62 . size () > 0 );
return false ;
}
static String [] fn_35 ( final String vr_68 ) {
if ( vr_68 . indexOf ( '?' ) == vl_6 && vr_68 . indexOf ( '*' ) == vl_6 ) {
return new String [] { vr_68 } ;
}
final char [] array = vr_68 . vr_69 () ;
final ArrayList < String > list = new ArrayList <> () ;
final StringBuilder vr_70 = new StringBuilder () ;
char vr_71 = 0 ;
for ( final char vr_1 : array ) {
if ( vr_1 == '?' || vr_1 == '*' ) {
if ( vr_70 . length () != 0 ) {
list . add ( vr_70 . toString () ) ;
vr_70 . vr_72 ( 0 ) ;
}
if ( vr_1 == '?' ) {
list . add ( lr_6 ) ;
} else if ( vr_71 != '*' ) {
list . add ( lr_7 ) ;
}
} else {
vr_70 . append ( vr_1 ) ;
}
vr_71 = vr_1 ;
}
if ( vr_70 . length () != 0 ) {
list . add ( vr_70 . toString () ) ;
}
return list . toArray ( new String [ list . size () ] ) ;
}
private static boolean fn_13 ( final String vr_73 ) {
return fn_36 ( vr_73 ) || fn_37 ( vr_73 ) ;
}
private static boolean fn_38 ( final String vr_73 ) {
final tp_1 vr_74 = vr_75 . vr_76 ( vr_73 ) ;
if ( ! vr_74 . vr_77 () || vr_74 . vr_78 () != 4 ) {
return false ;
}
for ( int vr_9 = 1 ; vr_9 <= 4 ; vr_9 ++ ) {
final String vr_79 = vr_74 . vr_80 ( vr_9 ) ;
final int vr_81 = Integer . vr_82 ( vr_79 ) ;
if ( vr_81 > vl_8 ) {
return false ;
}
if ( vr_79 . length () > 1 && vr_79 . vr_83 ( lr_8 ) ) {
return false ;
}
}
return true ;
}
private static boolean fn_36 ( final String vr_84 ) {
final boolean vr_85 = vr_84 . contains ( lr_9 ) ;
if ( vr_85 && ( vr_84 . indexOf ( lr_9 ) != vr_84 . vr_35 ( lr_9 ) ) ) {
return false ;
}
if ( ( vr_84 . vr_83 ( lr_10 ) && ! vr_84 . vr_83 ( lr_9 ) )
|| ( vr_84 . vr_86 ( lr_10 ) && ! vr_84 . vr_86 ( lr_9 ) ) ) {
return false ;
}
String [] vr_87 = vr_84 . vr_88 ( lr_10 ) ;
if ( vr_85 ) {
final List < String > vr_89 = new ArrayList <> ( vr_90 . vr_91 ( vr_87 ) ) ;
if ( vr_84 . vr_86 ( lr_9 ) ) {
vr_89 . add ( lr_11 ) ;
} else if ( vr_84 . vr_83 ( lr_9 ) && ! vr_89 . isEmpty () ) {
vr_89 . remove ( 0 ) ;
}
vr_87 = vr_89 . toArray ( new String [ vr_89 . size () ] ) ;
}
if ( vr_87 . length > vl_9 ) {
return false ;
}
int vr_92 = 0 ;
int vr_93 = 0 ;
for ( int vr_42 = 0 ; vr_42 < vr_87 . length ; vr_42 ++ ) {
final String vr_94 = vr_87 [ vr_42 ] ;
if ( vr_94 . length () == 0 ) {
vr_93 ++ ;
if ( vr_93 > 1 ) {
return false ;
}
} else {
vr_93 = 0 ;
if ( vr_42 == vr_87 . length - 1 && vr_94 . contains ( lr_12 ) ) {
if ( ! fn_38 ( vr_94 ) ) {
return false ;
}
vr_92 += 2 ;
continue;
}
if ( vr_94 . length () > vl_10 ) {
return false ;
}
int vr_95 = 0 ;
try {
vr_95 = Integer . vr_82 ( vr_94 , vl_11 ) ;
} catch ( final tp_2 vr_96 ) {
return false ;
}
if ( vr_95 < 0 || vr_95 > vl_12 ) {
return false ;
}
}
vr_92 ++ ;
}
if ( vr_92 > vl_9 || ( vr_92 < vl_9 && ! vr_85 ) ) {
return false ;
}
return true ;
}
private static boolean fn_37 ( final String vr_73 ) {
final String [] vr_97 = vr_73 . vr_88 ( lr_13 , - 1 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_97 . length ; vr_9 ++ ) {
if ( vr_97 [ vr_9 ] . length () == 0 ) {
return vr_9 == vr_97 . length - 1 ;
}
if ( ! vr_98 . vr_76 ( vr_97 [ vr_9 ] ) . vr_77 () ) {
return false ;
}
}
return true ;
}
