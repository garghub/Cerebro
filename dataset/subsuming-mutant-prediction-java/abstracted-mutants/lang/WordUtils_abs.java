public static String fn_1 ( final String vr_1 , final int vr_2 ) {
return fn_1 ( vr_1 , vr_2 , null , false ) ;
}
public static String fn_1 ( final String vr_1 , int vr_2 , String vr_3 , final boolean vr_4 ) {
if ( vr_1 == null ) {
return null ;
}
if ( vr_3 == null ) {
vr_3 = vr_5 . vr_6 ;
}
if ( vr_2 < 1 ) {
vr_2 = 1 ;
}
final int vr_7 = vr_1 . length () ;
int vr_8 = 0 ;
final StringBuilder vr_9 = new StringBuilder ( vr_7 + 32 ) ;
while ( vr_8 < vr_7 ) {
if ( vr_1 . charAt ( vr_8 ) == ' ' ) {
vr_8 ++ ;
continue;
}
if( vr_7 - vr_8 <= vr_2 ) {
break;
}
int vr_10 = vr_1 . vr_11 ( ' ' , vr_2 + vr_8 ) ;
if ( vr_10 >= vr_8 ) {
vr_9 . append ( vr_1 . vr_12 ( vr_8 , vr_10 ) ) ;
vr_9 . append ( vr_3 ) ;
vr_8 = vr_10 + 1 ;
} else {
if ( vr_4 ) {
vr_9 . append ( vr_1 . vr_12 ( vr_8 , vr_2 + vr_8 ) ) ;
vr_9 . append ( vr_3 ) ;
vr_8 += vr_2 ;
} else {
vr_10 = vr_1 . indexOf ( ' ' , vr_2 + vr_8 ) ;
if ( vr_10 >= 0 ) {
vr_9 . append ( vr_1 . vr_12 ( vr_8 , vr_10 ) ) ;
vr_9 . append ( vr_3 ) ;
vr_8 = vr_10 + 1 ;
} else {
vr_9 . append ( vr_1 . vr_12 ( vr_8 ) ) ;
vr_8 = vr_7 ;
}
}
}
}
vr_9 . append ( vr_1 . vr_12 ( vr_8 ) ) ;
return vr_9 . toString () ;
}
public static String fn_2 ( final String vr_1 ) {
return fn_2 ( vr_1 , null ) ;
}
public static String fn_2 ( final String vr_1 , final char ... vr_13 ) {
final int vr_14 = vr_13 == null ? - 1 : vr_13 . length ;
if ( vr_15 . isEmpty ( vr_1 ) || vr_14 == 0 ) {
return vr_1 ;
}
final char [] vr_16 = vr_1 . vr_17 () ;
boolean vr_18 = true ;
for ( int vr_19 = 0 ; vr_19 < vr_16 . length ; vr_19 ++ ) {
final char vr_20 = vr_16 [ vr_19 ] ;
if ( fn_3 ( vr_20 , vr_13 ) ) {
vr_18 = true ;
} else if ( vr_18 ) {
vr_16 [ vr_19 ] = vr_21 . vr_22 ( vr_20 ) ;
vr_18 = false ;
}
}
return new String ( vr_16 ) ;
}
public static String fn_4 ( final String vr_1 ) {
return fn_4 ( vr_1 , null ) ;
}
public static String fn_4 ( String vr_1 , final char ... vr_13 ) {
final int vr_14 = vr_13 == null ? - 1 : vr_13 . length ;
if ( vr_15 . isEmpty ( vr_1 ) || vr_14 == 0 ) {
return vr_1 ;
}
vr_1 = vr_1 . vr_23 () ;
return fn_2 ( vr_1 , vr_13 ) ;
}
public static String fn_5 ( final String vr_1 ) {
return fn_5 ( vr_1 , null ) ;
}
public static String fn_5 ( final String vr_1 , final char ... vr_13 ) {
final int vr_14 = vr_13 == null ? - 1 : vr_13 . length ;
if ( vr_15 . isEmpty ( vr_1 ) || vr_14 == 0 ) {
return vr_1 ;
}
final char [] vr_16 = vr_1 . vr_17 () ;
boolean vr_24 = true ;
for ( int vr_19 = 0 ; vr_19 < vr_16 . length ; vr_19 ++ ) {
final char vr_20 = vr_16 [ vr_19 ] ;
if ( fn_3 ( vr_20 , vr_13 ) ) {
vr_24 = true ;
} else if ( vr_24 ) {
vr_16 [ vr_19 ] = vr_21 . vr_23 ( vr_20 ) ;
vr_24 = false ;
}
}
return new String ( vr_16 ) ;
}
public static String fn_6 ( final String vr_1 ) {
if ( vr_15 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
final char [] vr_16 = vr_1 . vr_17 () ;
boolean vr_25 = true ;
for ( int vr_19 = 0 ; vr_19 < vr_16 . length ; vr_19 ++ ) {
final char vr_20 = vr_16 [ vr_19 ] ;
if ( vr_21 . vr_26 ( vr_20 ) ) {
vr_16 [ vr_19 ] = vr_21 . vr_23 ( vr_20 ) ;
vr_25 = false ;
} else if ( vr_21 . vr_27 ( vr_20 ) ) {
vr_16 [ vr_19 ] = vr_21 . vr_23 ( vr_20 ) ;
vr_25 = false ;
} else if ( vr_21 . vr_28 ( vr_20 ) ) {
if ( vr_25 ) {
vr_16 [ vr_19 ] = vr_21 . vr_22 ( vr_20 ) ;
vr_25 = false ;
} else {
vr_16 [ vr_19 ] = vr_21 . vr_29 ( vr_20 ) ;
}
} else {
vr_25 = vr_21 . vr_30 ( vr_20 ) ;
}
}
return new String ( vr_16 ) ;
}
public static String fn_7 ( final String vr_1 ) {
return fn_7 ( vr_1 , null ) ;
}
public static String fn_7 ( final String vr_1 , final char ... vr_13 ) {
if ( vr_15 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
if ( vr_13 != null && vr_13 . length == 0 ) {
return lr_1 ;
}
final int strLen = vr_1 . length () ;
final char [] vr_31 = new char [ strLen / 2 + 1 ] ;
int vr_32 = 0 ;
boolean vr_33 = true ;
for ( int vr_19 = 0 ; vr_19 < strLen ; vr_19 ++ ) {
final char vr_20 = vr_1 . charAt ( vr_19 ) ;
if ( fn_3 ( vr_20 , vr_13 ) ) {
vr_33 = true ;
} else if ( vr_33 ) {
vr_31 [ vr_32 ++ ] = vr_20 ;
vr_33 = false ;
} else {
continue;
}
}
return new String ( vr_31 , 0 , vr_32 ) ;
}
public static boolean fn_8 ( tp_1 vr_34 , tp_1 ... vr_35 ) {
if ( vr_15 . isEmpty ( vr_34 ) || vr_36 . isEmpty ( vr_35 ) ) {
return false ;
}
for ( tp_1 vr_37 : vr_35 ) {
if ( vr_15 . vr_38 ( vr_37 ) ) {
return false ;
}
tp_2 vr_39 = tp_2 . vr_40 ( lr_2 + vr_37 + lr_3 ) ;
if ( ! vr_39 . vr_41 ( vr_34 ) . fn_9 () ) {
return false ;
}
}
return true ;
}
private static boolean fn_3 ( final char vr_20 , final char [] vr_13 ) {
if ( vr_13 == null ) {
return vr_21 . vr_30 ( vr_20 ) ;
}
for ( final char vr_42 : vr_13 ) {
if ( vr_20 == vr_42 ) {
return true ;
}
}
return false ;
}
