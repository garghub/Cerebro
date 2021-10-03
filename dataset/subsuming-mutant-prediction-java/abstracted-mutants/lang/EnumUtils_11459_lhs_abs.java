public static < vt_1 extends Enum < vt_1 > > vr_1 < String , vt_1 > fn_1 ( final Class < vt_1 > vr_2 ) {
final vr_1 < String , vt_1 > vr_3 = new vr_4 < String , vt_1 > () ;
for ( final vt_1 vr_5 : vr_2 . vr_6 () ) {
vr_3 . vr_7 ( vr_5 . vr_8 () , vr_5 ) ;
}
return vr_3 ;
}
public static < vt_1 extends Enum < vt_1 > > List < vt_1 > fn_2 ( final Class < vt_1 > vr_2 ) {
return new ArrayList < vt_1 > ( vr_9 . vr_10 ( vr_2 . vr_6 () ) ) ;
}
public static < vt_1 extends Enum < vt_1 > > boolean fn_3 ( final Class < vt_1 > vr_2 , final String vr_11 ) {
if ( vr_11 == null ) {
return false ;
}
try {
Enum . valueOf ( vr_2 , vr_11 ) ;
return true ;
} catch ( final IllegalArgumentException vr_12 ) {
return false ;
}
}
public static < vt_1 extends Enum < vt_1 > > vt_1 fn_4 ( final Class < vt_1 > vr_2 , final String vr_11 ) {
if ( vr_11 == null ) {
return null ;
}
try {
return Enum . valueOf ( vr_2 , vr_11 ) ;
} catch ( final IllegalArgumentException vr_12 ) {
return null ;
}
}
public static < vt_1 extends Enum < vt_1 > > long fn_5 ( final Class < vt_1 > vr_2 , final vr_13 < ? extends vt_1 > vr_14 ) {
fn_6 ( vr_2 ) ;
vr_15 . vr_16 ( vr_14 ) ;
long vr_17 = 0 ;
for ( final vt_1 vr_18 : vr_14 ) { MST[NonVoidMethodCallMutator]MSP[]
vr_15 . vr_19 ( vr_18 != null , vl_1 ) ;
vr_17 |= 1L << vr_18 . vr_20 () ;
}
return vr_17 ;
}
public static < vt_1 extends Enum < vt_1 > > long [] fn_7 ( final Class < vt_1 > vr_2 , final vr_13 < ? extends vt_1 > vr_14 ) {
fn_8 ( vr_2 ) ;
vr_15 . vr_16 ( vr_14 ) ;
final vr_21 < vt_1 > vr_22 = vr_21 . vr_23 ( vr_2 ) ;
for ( final vt_1 vr_18 : vr_14 ) {
vr_15 . vr_19 ( vr_18 != null , vl_1 ) ;
vr_22 . add ( vr_18 ) ;
}
final long [] vr_24 = new long [ ( vr_2 . vr_6 () . length - 1 ) / Long . SIZE + 1 ] ;
for ( final vt_1 vr_25 : vr_22 ) {
vr_24 [ vr_25 . vr_20 () / Long . SIZE ] |= 1L << ( vr_25 . vr_20 () % Long . SIZE ) ;
}
vr_26 . vr_27 ( vr_24 ) ;
return vr_24 ;
}
public static < vt_1 extends Enum < vt_1 > > long fn_5 ( final Class < vt_1 > vr_2 , final vt_1 ... vr_14 ) {
vr_15 . vr_28 ( vr_14 ) ;
return fn_5 ( vr_2 , vr_9 . <vt_1 > vr_10 ( vr_14 ) ) ;
}
public static < vt_1 extends Enum < vt_1 > > long [] fn_7 ( final Class < vt_1 > vr_2 , final vt_1 ... vr_14 ) {
fn_8 ( vr_2 ) ;
vr_15 . vr_28 ( vr_14 ) ;
final vr_21 < vt_1 > vr_22 = vr_21 . vr_23 ( vr_2 ) ;
vr_29 . vr_30 ( vr_22 , vr_14 ) ;
final long [] vr_24 = new long [ ( vr_2 . vr_6 () . length - 1 ) / Long . SIZE + 1 ] ;
for ( final vt_1 vr_25 : vr_22 ) {
vr_24 [ vr_25 . vr_20 () / Long . SIZE ] |= 1L << ( vr_25 . vr_20 () % Long . SIZE ) ;
}
vr_26 . vr_27 ( vr_24 ) ;
return vr_24 ;
}
public static < vt_1 extends Enum < vt_1 > > vr_21 < vt_1 > fn_9 ( final Class < vt_1 > vr_2 , final long vr_25 ) {
fn_6 ( vr_2 ) . vr_6 () ;
return fn_10 ( vr_2 , vr_25 ) ;
}
public static < vt_1 extends Enum < vt_1 > > vr_21 < vt_1 > fn_10 ( final Class < vt_1 > vr_2 , final long ... vr_14 ) {
final vr_21 < vt_1 > vr_31 = vr_21 . vr_23 ( fn_8 ( vr_2 ) ) ;
final long [] vr_32 = vr_26 . vr_33 ( vr_15 . vr_16 ( vr_14 ) ) ;
vr_26 . vr_27 ( vr_32 ) ;
for ( final vt_1 vr_18 : vr_2 . vr_6 () ) {
final int vr_34 = vr_18 . vr_20 () / Long . SIZE ;
if ( vr_34 < vr_32 . length && ( vr_32 [ vr_34 ] & 1L << ( vr_18 . vr_20 () % Long . SIZE ) ) != 0 ) {
vr_31 . add ( vr_18 ) ;
}
}
return vr_31 ;
}
private static < vt_1 extends Enum < vt_1 > > Class < vt_1 > fn_6 ( final Class < vt_1 > vr_2 ) {
final vt_1 [] vr_35 = fn_8 ( vr_2 ) . vr_6 () ;
vr_15 . vr_19 ( vr_35 . length <= Long . SIZE , vl_2 ,
Integer . valueOf ( vr_35 . length ) , vr_2 . vr_36 () , Integer . valueOf ( Long . SIZE ) ) ;
return vr_2 ;
}
private static < vt_1 extends Enum < vt_1 > > Class < vt_1 > fn_8 ( final Class < vt_1 > vr_2 ) {
vr_15 . vr_16 ( vr_2 , vl_3 ) ;
vr_15 . vr_19 ( vr_2 . vr_37 () , vl_4 , vr_2 ) ;
return vr_2 ;
}
