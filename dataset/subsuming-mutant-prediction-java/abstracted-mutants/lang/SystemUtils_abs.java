public static tp_1 fn_1 () {
return new tp_1 ( System . getProperty ( vl_1 ) ) ;
}
public static tp_1 fn_2 () {
return new tp_1 ( System . getProperty ( vl_2 ) ) ;
}
private static boolean fn_3 ( final String vr_1 ) {
return fn_4 ( vl_3 , vr_1 ) ;
}
private static boolean fn_5 ( final String vr_2 , final String vr_3 ) {
return fn_6 ( vl_4 , vl_5 , vr_2 , vr_3 ) ;
}
private static boolean fn_7 ( final String vr_2 ) {
return fn_8 ( vl_4 , vr_2 ) ;
}
private static String fn_9 ( final String vr_4 ) {
try {
return System . getProperty ( vr_4 ) ;
} catch ( final tp_2 vr_5 ) {
System . vr_6 . println ( lr_1 + vr_4
+ lr_2 ) ;
return null ;
}
}
public static tp_1 fn_10 () {
return new tp_1 ( System . getProperty ( vl_6 ) ) ;
}
public static tp_1 fn_11 () {
return new tp_1 ( System . getProperty ( vl_7 ) ) ;
}
public static boolean fn_12 () {
return vl_8 != null ? vl_8 . equals ( Boolean . TRUE . toString () ) : false ;
}
public static boolean fn_13 ( final tp_3 vr_7 ) {
return vr_8 . vr_9 ( vr_7 ) ;
}
static boolean fn_4 ( final String vr_10 , final String vr_1 ) {
if ( vr_10 == null ) {
return false ;
}
return vr_10 . vr_11 ( vr_1 ) ;
}
static boolean fn_6 ( final String vr_12 , final String vr_13 , final String vr_2 , final String vr_3 ) {
if ( vr_12 == null || vr_13 == null ) {
return false ;
}
return fn_8 ( vr_12 , vr_2 ) && fn_14 ( vr_13 , vr_3 ) ;
}
static boolean fn_8 ( final String vr_12 , final String vr_2 ) {
if ( vr_12 == null ) {
return false ;
}
return vr_12 . vr_11 ( vr_2 ) ;
}
static boolean fn_14 ( final String vr_13 , final String vr_3 ) {
if ( vr_14 . isEmpty ( vr_13 ) ) {
return false ;
}
String [] vr_15 = vr_3 . vr_16 ( lr_3 ) ;
String [] vr_17 = vr_13 . vr_16 ( lr_3 ) ;
for ( int vr_18 = 0 ; vr_18 < vr_19 . vr_20 ( vr_15 . length , vr_17 . length ) ; vr_18 ++ ) {
if ( ! vr_15 [ vr_18 ] . equals ( vr_17 [ vr_18 ] ) ) {
return false ;
}
}
return true ;
}
