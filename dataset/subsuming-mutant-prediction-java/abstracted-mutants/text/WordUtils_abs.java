public static String fn_1 ( final String vr_1 , final int vr_2 ) {
return fn_1 ( vr_1 , vr_2 , null , false ) ;
}
public static String fn_1 ( final String vr_1 ,
final int vr_2 ,
final String vr_3 ,
final boolean vr_4 ) {
return fn_1 ( vr_1 , vr_2 , vr_3 , vr_4 , lr_1 ) ;
}
public static String fn_1 ( final String vr_1 ,
int vr_2 ,
String vr_3 ,
final boolean vr_4 ,
String vr_5 ) {
if ( vr_1 == null ) {
return null ;
}
if ( vr_3 == null ) {
vr_3 = System . vr_6 () ;
}
if ( vr_2 < 1 ) {
vr_2 = 1 ;
}
if ( vr_7 . vr_8 ( vr_5 ) ) {
vr_5 = lr_1 ;
}
final tp_1 vr_9 = tp_1 . vr_10 ( vr_5 ) ;
final int vr_11 = vr_1 . length () ;
int vr_12 = 0 ;
final StringBuilder vr_13 = new StringBuilder ( vr_11 + 32 ) ;
while ( vr_12 < vr_11 ) {
int vr_14 = - 1 ;
tp_2 vr_15 = vr_9 . vr_15 ( vr_1 . vr_16 ( vr_12 , vr_17
. vr_18 ( vr_12 + vr_2 + 1 , vr_11 ) ) ) ;
if ( vr_15 . vr_19 () ) {
if ( vr_15 . vr_20 () == 0 ) {
vr_12 += vr_15 . vr_21 () ;
continue;
}
vr_14 = vr_15 . vr_20 () + vr_12 ;
}
if ( vr_11 - vr_12 <= vr_2 ) {
break;
}
while ( vr_15 . vr_19 () ) {
vr_14 = vr_15 . vr_20 () + vr_12 ;
}
if ( vr_14 >= vr_12 ) {
vr_13 . append ( vr_1 , vr_12 , vr_14 ) ;
vr_13 . append ( vr_3 ) ;
vr_12 = vr_14 + 1 ;
} else {
if ( vr_4 ) {
vr_13 . append ( vr_1 , vr_12 , vr_2 + vr_12 ) ;
vr_13 . append ( vr_3 ) ;
vr_12 += vr_2 ;
} else {
vr_15 = vr_9 . vr_15 ( vr_1 . vr_16 ( vr_12 + vr_2 ) ) ;
if ( vr_15 . vr_19 () ) {
vr_14 = vr_15 . vr_20 () + vr_12 + vr_2 ;
}
if ( vr_14 >= 0 ) {
vr_13 . append ( vr_1 , vr_12 , vr_14 ) ;
vr_13 . append ( vr_3 ) ;
vr_12 = vr_14 + 1 ;
} else {
vr_13 . append ( vr_1 , vr_12 , vr_1 . length () ) ;
vr_12 = vr_11 ;
}
}
}
}
vr_13 . append ( vr_1 , vr_12 , vr_1 . length () ) ;
return vr_13 . toString () ;
}
public static String fn_2 ( final String vr_1 ) {
return fn_2 ( vr_1 , null ) ;
}
public static String fn_2 ( final String vr_1 , final char ... vr_22 ) {
if ( vr_7 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
final vr_23 < Integer > vr_24 = fn_3 ( vr_22 ) ;
final int strLen = vr_1 . length () ;
final int [] vr_25 = new int [ strLen ] ;
int vr_26 = 0 ;
boolean vr_27 = true ;
for ( int vr_28 = 0 ; vr_28 < strLen ; ) {
final int vr_29 = vr_1 . vr_30 ( vr_28 ) ;
if ( vr_24 . contains ( vr_29 ) ) {
vr_27 = true ;
vr_25 [ vr_26 ++ ] = vr_29 ;
vr_28 += vr_31 . vr_32 ( vr_29 ) ;
} else if ( vr_27 ) {
final int vr_33 = vr_31 . vr_34 ( vr_29 ) ;
vr_25 [ vr_26 ++ ] = vr_33 ;
vr_28 += vr_31 . vr_32 ( vr_33 ) ;
vr_27 = false ;
} else {
vr_25 [ vr_26 ++ ] = vr_29 ;
vr_28 += vr_31 . vr_32 ( vr_29 ) ;
}
}
return new String ( vr_25 , 0 , vr_26 ) ;
}
public static String fn_4 ( final String vr_1 ) {
return fn_4 ( vr_1 , null ) ;
}
public static String fn_4 ( String vr_1 , final char ... vr_22 ) {
if ( vr_7 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
vr_1 = vr_1 . vr_35 () ;
return fn_2 ( vr_1 , vr_22 ) ;
}
public static String fn_5 ( final String vr_1 ) {
return fn_5 ( vr_1 , null ) ;
}
public static String fn_5 ( final String vr_1 , final char ... vr_22 ) {
if ( vr_7 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
final vr_23 < Integer > vr_24 = fn_3 ( vr_22 ) ;
final int strLen = vr_1 . length () ;
final int [] vr_25 = new int [ strLen ] ;
int vr_26 = 0 ;
boolean vr_36 = true ;
for ( int vr_28 = 0 ; vr_28 < strLen ; ) {
final int vr_29 = vr_1 . vr_30 ( vr_28 ) ;
if ( vr_24 . contains ( vr_29 ) ) {
vr_36 = true ;
vr_25 [ vr_26 ++ ] = vr_29 ;
vr_28 += vr_31 . vr_32 ( vr_29 ) ;
} else if ( vr_36 ) {
final int vr_33 = vr_31 . vr_35 ( vr_29 ) ;
vr_25 [ vr_26 ++ ] = vr_33 ;
vr_28 += vr_31 . vr_32 ( vr_33 ) ;
vr_36 = false ;
} else {
vr_25 [ vr_26 ++ ] = vr_29 ;
vr_28 += vr_31 . vr_32 ( vr_29 ) ;
}
}
return new String ( vr_25 , 0 , vr_26 ) ;
}
public static String fn_6 ( final String vr_1 ) {
if ( vr_7 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
final int strLen = vr_1 . length () ;
final int [] vr_25 = new int [ strLen ] ;
int vr_26 = 0 ;
boolean vr_37 = true ;
for ( int vr_28 = 0 ; vr_28 < strLen ; ) {
final int vr_38 = vr_1 . vr_30 ( vr_28 ) ;
final int vr_39 ;
if ( vr_31 . vr_40 ( vr_38 ) || vr_31 . vr_41 ( vr_38 ) ) {
vr_39 = vr_31 . vr_35 ( vr_38 ) ;
vr_37 = false ;
} else if ( vr_31 . vr_42 ( vr_38 ) ) {
if ( vr_37 ) {
vr_39 = vr_31 . vr_34 ( vr_38 ) ;
vr_37 = false ;
} else {
vr_39 = vr_31 . vr_43 ( vr_38 ) ;
}
} else {
vr_37 = vr_31 . vr_44 ( vr_38 ) ;
vr_39 = vr_38 ;
}
vr_25 [ vr_26 ++ ] = vr_39 ;
vr_28 += vr_31 . vr_32 ( vr_39 ) ;
}
return new String ( vr_25 , 0 , vr_26 ) ;
}
public static String fn_7 ( final String vr_1 ) {
return fn_7 ( vr_1 , null ) ;
}
public static String fn_7 ( final String vr_1 , final char ... vr_22 ) {
if ( vr_7 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
if ( vr_22 != null && vr_22 . length == 0 ) {
return lr_2 ;
}
final vr_23 < Integer > vr_24 = fn_3 ( vr_22 ) ;
final int strLen = vr_1 . length () ;
final int [] vr_25 = new int [ strLen / 2 + 1 ] ;
int vr_45 = 0 ;
boolean vr_46 = true ;
for ( int vr_47 = 0 ; vr_47 < strLen ; ) {
final int vr_29 = vr_1 . vr_30 ( vr_47 ) ;
if ( vr_24 . contains ( vr_29 ) || ( vr_22 == null && vr_31 . vr_44 ( vr_29 ) ) ) {
vr_46 = true ;
} else if ( vr_46 ) {
vr_25 [ vr_45 ++ ] = vr_29 ;
vr_46 = false ;
}
vr_47 += vr_31 . vr_32 ( vr_29 ) ;
}
return new String ( vr_25 , 0 , vr_45 ) ;
}
public static boolean fn_8 ( final tp_3 vr_48 , final tp_3 ... vr_49 ) {
if ( vr_7 . isEmpty ( vr_48 ) || vr_50 . isEmpty ( vr_49 ) ) {
return false ;
}
for ( final tp_3 vr_51 : vr_49 ) {
if ( vr_7 . vr_8 ( vr_51 ) ) {
return false ;
}
final tp_1 vr_52 = tp_1 . vr_10 ( lr_3 + vr_51 + lr_4 ) ;
if ( ! vr_52 . vr_15 ( vr_48 ) . fn_9 () ) {
return false ;
}
}
return true ;
}
@Deprecated
public static boolean fn_10 ( final char vr_53 , final char [] vr_22 ) {
if ( vr_22 == null ) {
return vr_31 . vr_44 ( vr_53 ) ;
}
for ( final char vr_54 : vr_22 ) {
if ( vr_53 == vr_54 ) {
return true ;
}
}
return false ;
}
@Deprecated
public static boolean fn_10 ( final int vr_29 , final char [] vr_22 ) {
if ( vr_22 == null ) {
return vr_31 . vr_44 ( vr_29 ) ;
}
for ( int vr_28 = 0 ; vr_28 < vr_22 . length ; vr_28 ++ ) {
final int vr_55 = vr_31 . vr_30 ( vr_22 , vr_28 ) ;
if ( vr_55 == vr_29 ) {
return true ;
}
}
return false ;
}
public static String fn_11 ( final String vr_1 , int vr_56 , int vr_57 , final String vr_58 ) {
vr_59 . vr_60 ( vr_57 >= - 1 , lr_5 ) ;
vr_59 . vr_60 ( vr_57 >= vr_56 || vr_57 == - 1 , lr_6 ) ;
if ( vr_7 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
if ( vr_56 > vr_1 . length () ) {
vr_56 = vr_1 . length () ;
}
if ( vr_57 == - 1 || vr_57 > vr_1 . length () ) {
vr_57 = vr_1 . length () ;
}
final StringBuilder vr_61 = new StringBuilder () ;
final int vr_28 = vr_7 . indexOf ( vr_1 , lr_1 , vr_56 ) ;
if ( vr_28 == - 1 ) {
vr_61 . append ( vr_1 , 0 , vr_57 ) ;
if ( vr_57 != vr_1 . length () ) {
vr_61 . append ( vr_7 . vr_62 ( vr_58 ) ) ;
}
} else if ( vr_28 > vr_57 ) {
vr_61 . append ( vr_1 , 0 , vr_57 ) ;
vr_61 . append ( vr_7 . vr_62 ( vr_58 ) ) ;
} else {
vr_61 . append ( vr_1 , 0 , vr_28 ) ;
vr_61 . append ( vr_7 . vr_62 ( vr_58 ) ) ;
}
return vr_61 . toString () ;
}
private static vr_23 < Integer > fn_3 ( final char [] vr_22 ) {
final vr_23 < Integer > vr_63 = new vr_64 <> () ;
if ( vr_22 == null || vr_22 . length == 0 ) {
if ( vr_22 == null ) {
vr_63 . add ( vr_31 . vr_30 ( new char [] { ' ' } , 0 ) ) ;
}
return vr_63 ;
}
for ( int vr_28 = 0 ; vr_28 < vr_22 . length ; vr_28 ++ ) {
vr_63 . add ( vr_31 . vr_30 ( vr_22 , vr_28 ) ) ;
}
return vr_63 ;
}
