public static vr_1 [] fn_1 ( final tp_1 fn_1 , final vr_1 ... vr_2 ) {
if ( fn_1 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_2 == null ) {
return new vr_1 [ 0 ] ;
}
final List < vr_1 > vr_3 = new ArrayList <> () ;
for ( final vr_1 vr_4 : vr_2 ) {
if ( vr_4 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( fn_1 . vr_5 ( vr_4 ) ) {
vr_3 . add ( vr_4 ) ;
}
}
return vr_3 . toArray ( new vr_1 [ vr_3 . size () ] ) ;
}
public static vr_1 [] fn_1 ( final tp_1 fn_1 , final vr_6 < vr_1 > vr_2 ) {
final List < vr_1 > vr_3 = fn_2 ( fn_1 , vr_2 ) ;
return vr_3 . toArray ( new vr_1 [ vr_3 . size () ] ) ;
}
public static List < vr_1 > fn_2 ( final tp_1 fn_1 , final vr_6 < vr_1 > vr_2 ) {
return fn_1 ( fn_1 , vr_2 , new ArrayList < vr_1 > () ) ;
}
public static List < vr_1 > fn_2 ( final tp_1 fn_1 , final vr_1 ... vr_2 ) {
final vr_1 [] vr_3 = fn_1 ( fn_1 , vr_2 ) ;
return vr_7 . vr_8 ( vr_3 ) ;
}
public static vr_9 < vr_1 > fn_3 ( final tp_1 fn_1 , final vr_1 ... vr_2 ) {
final vr_1 [] vr_3 = fn_1 ( fn_1 , vr_2 ) ;
return new vr_10 <> ( vr_7 . vr_8 ( vr_3 ) ) ;
}
public static vr_9 < vr_1 > fn_3 ( final tp_1 fn_1 , final vr_6 < vr_1 > vr_2 ) {
return fn_1 ( fn_1 , vr_2 , new vr_10 < vr_1 > () ) ;
}
private static < vt_1 extends Collection < vr_1 > > vt_1 fn_1 ( final tp_1 fn_1 ,
final vr_6 < vr_1 > vr_2 , final vt_1 vr_3 ) {
if ( fn_1 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_2 != null ) {
for ( final vr_1 vr_4 : vr_2 ) {
if ( vr_4 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( fn_1 . vr_5 ( vr_4 ) ) {
vr_3 . add ( vr_4 ) ;
}
}
}
return vr_3 ;
}
public static tp_1 fn_4 ( final String vr_11 ) {
return new fn_5 ( vr_11 ) ;
}
public static tp_1 fn_4 ( final String vr_11 , final tp_2 vr_12 ) {
return new fn_5 ( vr_11 , vr_12 ) ;
}
public static tp_1 fn_6 ( final String vr_13 ) {
return new fn_7 ( vr_13 ) ;
}
public static tp_1 fn_6 ( final String vr_13 , final tp_2 vr_12 ) {
return new fn_7 ( vr_13 , vr_12 ) ;
}
public static tp_1 fn_8 ( final String vr_14 ) {
return new fn_9 ( vr_14 ) ;
}
public static tp_1 fn_8 ( final String vr_14 , final tp_2 vr_12 ) {
return new fn_9 ( vr_14 , vr_12 ) ;
}
public static tp_1 fn_10 () {
return vr_15 . vr_16 ;
}
public static tp_1 fn_11 () {
return vr_17 . vr_18 ;
}
@Deprecated
public static tp_1 fn_12 ( final tp_1 vr_19 , final tp_1 vr_20 ) {
return new fn_13 ( vr_19 , vr_20 ) ;
}
@Deprecated
public static tp_1 fn_14 ( final tp_1 vr_19 , final tp_1 vr_20 ) {
return new fn_15 ( vr_19 , vr_20 ) ;
}
public static tp_1 fn_16 ( final tp_1 ... vr_21 ) {
return new fn_13 ( fn_17 ( vr_21 ) ) ;
}
public static tp_1 fn_18 ( final tp_1 ... vr_21 ) {
return new fn_15 ( fn_17 ( vr_21 ) ) ;
}
public static List < tp_1 > fn_17 ( final tp_1 ... vr_21 ) {
if ( vr_21 == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
final List < tp_1 > list = new ArrayList <> ( vr_21 . length ) ;
for ( int vr_22 = 0 ; vr_22 < vr_21 . length ; vr_22 ++ ) {
if ( vr_21 [ vr_22 ] == null ) {
throw new IllegalArgumentException ( lr_5 + vr_22 + lr_6 ) ;
}
list . add ( vr_21 [ vr_22 ] ) ;
}
return list ;
}
public static tp_1 fn_19 ( final tp_1 fn_1 ) {
return new fn_20 ( fn_1 ) ;
}
public static tp_1 fn_21 () {
return vr_23 . TRUE ;
}
public static tp_1 fn_22 () {
return vr_24 . FALSE ;
}
public static tp_1 fn_23 ( final tp_3 fn_1 ) {
return new fn_24 ( fn_1 ) ; MST[ConstructorCallMutator]MSP[]
}
public static tp_1 fn_23 ( final tp_4 fn_1 ) {
return new fn_24 ( fn_1 ) ;
}
public static tp_1 fn_25 ( final long vr_25 ) {
return new fn_26 ( vr_25 ) ;
}
public static tp_1 fn_25 ( final long vr_25 , final boolean vr_26 ) {
return new fn_26 ( vr_25 , vr_26 ) ;
}
public static tp_1 fn_25 ( final tp_5 vr_27 ) {
return new fn_26 ( vr_27 ) ;
}
public static tp_1 fn_25 ( final tp_5 vr_27 , final boolean vr_26 ) {
return new fn_26 ( vr_27 , vr_26 ) ;
}
public static tp_1 fn_25 ( final vr_1 vr_28 ) {
return new fn_26 ( vr_28 ) ;
}
public static tp_1 fn_25 ( final vr_1 vr_28 , final boolean vr_26 ) {
return new fn_26 ( vr_28 , vr_26 ) ;
}
public static tp_1 fn_27 ( final long vr_29 ) {
return new fn_28 ( vr_29 ) ;
}
public static tp_1 fn_27 ( final long vr_29 , final boolean vr_30 ) {
return new fn_28 ( vr_29 , vr_30 ) ;
}
public static tp_1 fn_29 ( final long vr_31 , final long vr_32 ) {
final tp_1 vr_33 = new fn_28 ( vr_31 , true ) ;
final tp_1 vr_34 = new fn_28 ( vr_32 + 1L , false ) ;
return new fn_13 ( vr_33 , vr_34 ) ;
}
public static tp_1 fn_30 ( final String vr_35 ) {
return new fn_31 ( vr_35 ) ;
}
public static tp_1 fn_30 ( final String vr_35 , final long vr_36 ) {
return new fn_31 ( vr_35 , vr_36 ) ;
}
public static tp_1 fn_30 ( final byte [] vr_35 ) {
return new fn_31 ( vr_35 ) ;
}
public static tp_1 fn_30 ( final byte [] vr_35 , final long vr_36 ) {
return new fn_31 ( vr_35 , vr_36 ) ;
}
public static tp_1 fn_32 ( final tp_1 fn_1 ) {
return fn_1 == null ? vl_1 : fn_16 ( fn_1 , vl_1 ) ;
}
public static tp_1 fn_33 ( final tp_1 fn_1 ) {
return fn_1 == null ? vl_2 : fn_16 ( fn_1 , vl_2 ) ;
}
public static tp_1 fn_34 ( final tp_1 fn_1 ) {
if ( fn_1 == null ) {
return vr_15 . vr_16 ;
}
return new fn_13 ( vr_15 . vr_16 , fn_1 ) ;
}
public static tp_1 fn_35 ( final tp_1 fn_1 ) {
if ( fn_1 == null ) {
return vr_17 . vr_18 ;
}
return new fn_13 ( vr_17 . vr_18 , fn_1 ) ;
}
