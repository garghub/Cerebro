public static tp_1 fn_1 () {
if ( vl_1 ) {
return vl_2 ;
}
if ( vl_3 ) {
return tp_1 . vr_1 ;
}
if ( vl_4 ) {
return tp_1 . vr_2 ;
}
return vl_5 ;
}
private static boolean fn_2 ( final String vr_3 ) {
return fn_3 ( vl_6 , vr_3 ) ;
}
private static String fn_4 ( final String vr_4 ) {
try {
return System . getProperty ( vr_4 ) ;
} catch ( final tp_2 vr_5 ) {
System . vr_6 . println ( lr_1 + vr_4
+ lr_2 ) ;
return null ;
}
}
private static boolean fn_3 ( final String vr_7 , final String vr_3 ) {
if ( vr_7 == null ) {
return false ;
}
return vr_7 . vr_8 ( vr_9 . vr_10 ) . fn_5 ( vr_3 . vr_8 ( vr_9 . vr_10 ) ) ;
}
public char [] fn_6 () {
return this . vr_11 . vr_12 () ;
}
public int fn_7 () {
return vl_7 ;
}
public int fn_8 () {
return vl_8 ;
}
public String [] fn_9 () {
return vr_13 . vr_12 () ;
}
public boolean fn_10 () {
return vl_9 ;
}
public boolean fn_11 () {
return vl_10 ;
}
private boolean fn_12 ( final char vr_14 ) {
return vr_15 . vr_16 ( vr_11 , vr_14 ) >= 0 ;
}
public boolean fn_13 ( final tp_3 vr_17 ) {
if ( vr_17 == null || vr_17 . length () == 0 || vr_17 . length () > vl_7 ) {
return false ;
}
if ( fn_14 ( vr_17 ) ) {
return false ;
}
for ( int vr_18 = 0 ; vr_18 < vr_17 . length () ; vr_18 ++ ) {
if ( fn_12 ( vr_17 . charAt ( vr_18 ) ) ) {
return false ;
}
}
return true ;
}
public boolean fn_14 ( final tp_3 vr_17 ) {
return vr_15 . vr_16 ( vr_13 , vr_17 ) >= 0 ;
}
public String fn_15 ( final String vr_17 , final char vr_19 ) {
if ( fn_12 ( vr_19 ) ) {
throw new IllegalArgumentException (
String . vr_20 ( lr_3 ,
vr_19 == '\0' ? lr_4 : vr_19 , fn_16 () , vr_15 . toString ( vr_11 ) ) ) ;
}
final String vr_21 = vr_17 . length () > vl_7 ? vr_17 . vr_22 ( 0 , vl_7 )
: vr_17 ;
boolean vr_23 = false ;
final char [] vr_24 = vr_21 . vr_25 () ;
for ( int vr_18 = 0 ; vr_18 < vr_24 . length ; vr_18 ++ ) {
if ( fn_12 ( vr_24 [ vr_18 ] ) ) {
vr_24 [ vr_18 ] = vr_19 ;
vr_23 = true ;
}
}
return vr_23 ? String . valueOf ( vr_24 ) : vr_21 ;
}
