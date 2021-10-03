public static boolean equals ( final tp_1 vr_1 , final tp_1 vr_2 ) {
if ( vr_1 == vr_2 ) {
return true ;
}
if ( vr_1 == null || vr_2 == null ) {
return false ;
}
if ( vr_1 instanceof String && vr_2 instanceof String ) {
return vr_1 . equals ( vr_2 ) ;
}
return vr_1 . length () == vr_2 . length () && vr_3 . vr_4 ( vr_1 , false , 0 , vr_2 , 0 , vr_1 . length () ) ; MST[rv.CRCR5Mutator]MSP[N]
}
private static tp_2 fn_1 ( final String string , final tp_3 vr_5 ) {
if ( string == null ) {
return null ;
}
return tp_2 . vr_6 ( string . vr_7 ( vr_5 ) ) ;
}
public static tp_2 fn_2 ( final String string ) {
return fn_1 ( string , vr_8 . vr_9 ) ;
}
private static byte [] vr_7 ( final String string , final tp_3 vr_5 ) {
if ( string == null ) {
return null ;
}
return string . vr_7 ( vr_5 ) ;
}
public static byte [] fn_3 ( final String string ) {
return vr_7 ( string , vr_8 . vr_10 ) ;
}
public static byte [] fn_4 ( final String string , final String vr_11 ) {
if ( string == null ) {
return null ;
}
try {
return string . vr_7 ( vr_11 ) ;
} catch ( final tp_4 vr_12 ) {
throw vr_13 . vr_14 ( vr_11 , vr_12 ) ;
}
}
public static byte [] fn_5 ( final String string ) {
return vr_7 ( string , vr_8 . vr_15 ) ;
}
public static byte [] fn_6 ( final String string ) {
return vr_7 ( string , vr_8 . vr_16 ) ;
}
public static byte [] fn_7 ( final String string ) {
return vr_7 ( string , vr_8 . vr_17 ) ;
}
public static byte [] fn_8 ( final String string ) {
return vr_7 ( string , vr_8 . vr_18 ) ;
}
public static byte [] fn_9 ( final String string ) {
return vr_7 ( string , vr_8 . vr_9 ) ;
}
private static tp_5 vr_14 ( final String vr_11 ,
final tp_4 vr_12 ) {
return new tp_5 ( vr_11 + lr_1 + vr_12 ) ;
}
private static String fn_10 ( final byte [] vr_19 , final tp_3 vr_5 ) {
return vr_19 == null ? null : new String ( vr_19 , vr_5 ) ;
}
public static String fn_10 ( final byte [] vr_19 , final String vr_11 ) {
if ( vr_19 == null ) {
return null ;
}
try {
return new String ( vr_19 , vr_11 ) ;
} catch ( final tp_4 vr_12 ) {
throw vr_13 . vr_14 ( vr_11 , vr_12 ) ;
}
}
public static String fn_11 ( final byte [] vr_19 ) {
return fn_10 ( vr_19 , vr_8 . vr_10 ) ;
}
public static String fn_12 ( final byte [] vr_19 ) {
return fn_10 ( vr_19 , vr_8 . vr_15 ) ;
}
public static String fn_13 ( final byte [] vr_19 ) {
return fn_10 ( vr_19 , vr_8 . vr_16 ) ;
}
public static String fn_14 ( final byte [] vr_19 ) {
return fn_10 ( vr_19 , vr_8 . vr_17 ) ;
}
public static String fn_15 ( final byte [] vr_19 ) {
return fn_10 ( vr_19 , vr_8 . vr_18 ) ;
}
public static String fn_16 ( final byte [] vr_19 ) {
return fn_10 ( vr_19 , vr_8 . vr_9 ) ;
}
