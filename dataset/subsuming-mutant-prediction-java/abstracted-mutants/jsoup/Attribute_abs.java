public String fn_1 () {
return vl_1 ;
}
public void fn_2 ( String vl_1 ) {
vr_1 . vr_2 ( vl_1 ) ;
vl_1 = vl_1 . trim () ;
vr_1 . vr_3 ( vl_1 ) ;
if ( vl_2 != null ) {
int vr_4 = vl_2 . vr_5 ( this . vl_1 ) ;
if ( vr_4 != vr_6 . vr_7 )
vl_2 . vr_8 [ vr_4 ] = vl_1 ;
}
this . vl_1 = vl_1 ;
}
public String fn_3 () {
return vr_6 . vr_9 ( vl_3 ) ;
}
public boolean fn_4 () {
return vl_3 != null ;
}
public String fn_5 ( String vl_3 ) {
String vr_10 = this . vl_3 ;
if ( vl_2 != null ) {
vr_10 = vl_2 . get ( this . vl_1 ) ;
int vr_4 = vl_2 . vr_5 ( this . vl_1 ) ;
if ( vr_4 != vr_6 . vr_7 )
vl_2 . vr_11 [ vr_4 ] = vl_3 ;
}
this . vl_3 = vl_3 ;
return vr_6 . vr_9 ( vr_10 ) ;
}
public String fn_6 () {
StringBuilder vr_12 = vr_13 . vr_14 () ;
try {
fn_6 ( vr_12 , ( new fn_7 ( lr_1 ) ) . fn_8 () ) ;
} catch( IOException exception ) {
throw new fn_9 ( exception ) ;
}
return vr_13 . vr_15 ( vr_12 ) ;
}
protected static void fn_6 ( String vl_1 , String vl_3 , tp_1 vr_16 , fn_7 . vr_17 out ) throws IOException {
vr_16 . append ( vl_1 ) ;
if ( ! fn_10 ( vl_1 , vl_3 , out ) ) {
vr_16 . append ( lr_2 ) ;
vr_18 . vr_19 ( vr_16 , vr_6 . vr_9 ( vl_3 ) , out , true , false , false ) ;
vr_16 . append ( '"' ) ;
}
}
protected void fn_6 ( tp_1 vr_16 , fn_7 . vr_17 out ) throws IOException {
fn_6 ( vl_1 , vl_3 , vr_16 , out ) ;
}
@Override
public String toString () {
return fn_6 () ;
}
public static tp_2 fn_11 ( String vr_20 , String vr_21 ) {
String vr_22 = vr_18 . vr_23 ( vr_21 , true ) ;
return new tp_2 ( vr_20 , vr_22 , null ) ;
}
protected boolean fn_12 () {
return fn_12 ( vl_1 ) ;
}
protected static boolean fn_12 ( String vl_1 ) {
return vl_1 . vr_24 ( vr_6 . vr_25 ) && vl_1 . length () > vr_6 . vr_25 . length () ;
}
protected final boolean fn_10 ( fn_7 . vr_17 out ) {
return fn_10 ( vl_1 , vl_3 , out ) ;
}
protected static boolean fn_10 ( final String vl_1 , final String vl_3 , final fn_7 . vr_17 out ) {
return (
out . vr_26 () == fn_7 . vr_17 . vr_27 . fn_6 &&
( vl_3 == null || ( lr_1 . equals ( vl_3 ) || vl_3 . equalsIgnoreCase ( vl_1 ) ) && tp_2 . vr_28 ( vl_1 ) ) ) ;
}
protected static boolean vr_28 ( final String vl_1 ) {
return vr_29 . vr_30 ( vl_4 , vl_1 ) >= 0 ;
}
@Override
public boolean equals ( Object vr_31 ) {
if ( this == vr_31 ) return true ;
if ( vr_31 == null || getClass () != vr_31 . getClass () ) return false ;
tp_2 vr_32 = ( tp_2 ) vr_31 ;
if ( vl_1 != null ? ! vl_1 . equals ( vr_32 . vl_1 ) : vr_32 . vl_1 != null ) return false ;
return vl_3 != null ? vl_3 . equals ( vr_32 . vl_3 ) : vr_32 . vl_3 == null ;
}
@Override
public int fn_13 () {
int vr_33 = vl_1 != null ? vl_1 . fn_13 () : 0 ;
vr_33 = 31 * vr_33 + ( vl_3 != null ? vl_3 . fn_13 () : 0 ) ;
return vr_33 ;
}
@Override
public tp_2 fn_14 () {
try {
return ( tp_2 ) super . fn_14 () ;
} catch ( tp_3 vr_34 ) {
throw new fn_15 ( vr_34 ) ;
}
}
