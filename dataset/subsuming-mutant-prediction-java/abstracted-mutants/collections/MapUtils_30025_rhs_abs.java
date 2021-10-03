private static < vt_1 , vt_2 > vt_2 fn_1 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_4 < vr_1 < ? super vt_1 , ? > , vt_1 , vt_2 > vr_5 , final vr_6 < vt_1 , vt_2 > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vr_5 , vr_7 , null ) ;
}
private static < vt_1 , vt_2 > vt_2 fn_1 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_4 < vr_1 < ? super vt_1 , ? > , vt_1 , vt_2 > vr_5 , final vr_6 < vt_1 , vt_2 > vr_7 ,
final vt_2 vr_8 ) {
vt_2 vr_9 = vr_2 != null && vr_5 != null ? vr_5 . vr_10 ( vr_2 , vr_3 ) : null ;
if ( vr_9 == null ) {
vr_9 = vr_7 != null ? vr_7 . vr_10 ( vr_3 ) : null ;
}
return vr_9 != null ? vr_9 : vr_8 ;
}
private static < vt_1 , vt_2 > vt_2 fn_2 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_4 < vr_1 < ? super vt_1 , ? > , vt_1 , vt_2 > vr_5 , final vt_2 vr_8 ) {
final vt_2 vr_9 = vr_2 != null && vr_5 != null ? vr_5 . vr_10 ( vr_2 , vr_3 ) : null ;
return vr_9 == null ? vr_8 : vr_9 ;
}
public static void fn_3 ( final tp_1 out , final Object vr_11 , final vr_1 < ? , ? > vr_2 ) {
fn_4 ( out , vr_11 , vr_2 , new vr_12 < vr_1 < ? , ? > > () , true ) ;
}
public static < vt_1 , vt_3 > vr_1 < vt_1 , vt_3 > fn_5 ( final vr_1 < vt_1 , vt_3 > vr_2 ) {
return vr_2 == null ? vr_13 . <vt_1 , vt_3 > fn_6 () : vr_2 ;
}
public static < vt_1 , vt_3 > vr_14 < vt_1 , vt_3 > fn_7 ( final vr_1 < vt_1 , vt_3 > vr_2 ) {
return vr_15 . fn_7 ( vr_2 ) ;
}
public static < vt_1 , vt_3 > vr_16 < vt_1 , vt_3 > fn_8 ( final vr_16 < vt_1 , vt_3 > vr_2 ) {
return vr_17 . fn_8 ( vr_2 ) ;
}
public static < vt_1 > Boolean fn_9 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
final Object vr_18 = vr_2 . get ( vr_3 ) ;
if ( vr_18 != null ) {
if ( vr_18 instanceof Boolean ) {
return ( Boolean ) vr_18 ;
}
if ( vr_18 instanceof String ) {
return Boolean . valueOf ( ( String ) vr_18 ) ;
}
if ( vr_18 instanceof vl_1 ) {
final vl_1 vr_19 = ( vl_1 ) vr_18 ;
return vr_19 . vr_20 () != 0 ? Boolean . TRUE : Boolean . FALSE ;
}
}
}
return null ;
}
public static < vt_1 > Boolean fn_9 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final Boolean vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_9 , vr_8 ) ;
}
public static < vt_1 > Boolean fn_9 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Boolean > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_9 , vr_7 ) ;
}
public static < vt_1 > boolean fn_10 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
return Boolean . TRUE . equals ( fn_9 ( vr_2 , vr_3 ) ) ;
}
public static < vt_1 > boolean fn_10 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final boolean vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_9 , vr_8 ) . fn_11 () ;
}
public static < vt_1 > boolean fn_10 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Boolean > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_9 , vr_7 , false ) . fn_11 () ;
}
public static < vt_1 > Byte fn_12 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
final vl_1 vr_18 = fn_13 ( vr_2 , vr_3 ) ;
if ( vr_18 == null ) {
return null ;
}
if ( vr_18 instanceof Byte ) {
return ( Byte ) vr_18 ;
}
return Byte . valueOf ( vr_18 . vr_21 () ) ;
}
public static < vt_1 > Byte fn_12 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final Byte vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_12 , vr_8 ) ;
}
public static < vt_1 > Byte fn_12 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final vr_6 < vt_1 , Byte > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_12 , vr_7 ) ;
}
public static < vt_1 > byte fn_14 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_12 , 0 ) . vr_21 () ;
}
public static < vt_1 > byte fn_14 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final byte vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_12 , vr_8 ) . vr_21 () ;
}
public static < vt_1 > byte fn_14 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Byte > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_12 , vr_7 , ( byte ) 0 ) . vr_21 () ;
}
public static < vt_1 > Double fn_15 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
final vl_1 vr_18 = fn_13 ( vr_2 , vr_3 ) ;
if ( vr_18 == null ) {
return null ;
}
if ( vr_18 instanceof Double ) {
return ( Double ) vr_18 ;
}
return Double . valueOf ( vr_18 . vr_22 () ) ;
}
public static < vt_1 > Double fn_15 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final Double vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_15 , vr_8 ) ;
}
public static < vt_1 > Double fn_15 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Double > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_15 , vr_7 ) ;
}
public static < vt_1 > double fn_16 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_15 , 0d ) . vr_22 () ;
}
public static < vt_1 > double fn_16 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final double vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_15 , vr_8 ) . vr_22 () ;
}
public static < vt_1 > double fn_16 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Double > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_15 , vr_7 , 0d ) . vr_22 () ;
}
public static < vt_1 > Float fn_17 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
final vl_1 vr_18 = fn_13 ( vr_2 , vr_3 ) ;
if ( vr_18 == null ) {
return null ;
}
if ( vr_18 instanceof Float ) {
return ( Float ) vr_18 ;
}
return Float . valueOf ( vr_18 . vr_23 () ) ;
}
public static < vt_1 > Float fn_17 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final Float vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_17 , vr_8 ) ;
}
public static < vt_1 > Float fn_17 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Float > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_17 , vr_7 ) ;
}
public static < vt_1 > float fn_18 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_17 , 0f ) . vr_23 () ;
}
public static < vt_1 > float fn_18 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final float vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_17 , vr_8 ) . vr_23 () ;
}
public static < vt_1 > float fn_18 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Float > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_17 , vr_7 , 0f ) . vr_23 () ;
}
public static < vt_1 > Integer fn_19 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
final vl_1 vr_18 = fn_13 ( vr_2 , vr_3 ) ;
if ( vr_18 == null ) {
return null ;
}
if ( vr_18 instanceof Integer ) {
return ( Integer ) vr_18 ;
}
return Integer . valueOf ( vr_18 . vr_20 () ) ;
}
public static < vt_1 > Integer fn_19 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Integer > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_19 , vr_7 ) ;
}
public static < vt_1 > Integer fn_19 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final Integer vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_19 , vr_8 ) ;
}
public static < vt_1 > int fn_20 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_19 , 0 ) . vr_20 () ;
}
public static < vt_1 > int fn_20 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Integer > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_19 , vr_7 , 0 ) . vr_21 () ;
}
public static < vt_1 > int fn_20 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final int vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_19 , vr_8 ) . vr_20 () ; MST[NonVoidMethodCallMutator]MSP[S]
}
public static < vt_1 > Long fn_21 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
final vl_1 vr_18 = fn_13 ( vr_2 , vr_3 ) ;
if ( vr_18 == null ) {
return null ;
}
if ( vr_18 instanceof Long ) {
return ( Long ) vr_18 ;
}
return Long . valueOf ( vr_18 . vr_24 () ) ;
}
public static < vt_1 > Long fn_21 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final vr_6 < vt_1 , Long > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_21 , vr_7 ) ;
}
public static < vt_1 > Long fn_21 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final Long vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_21 , vr_8 ) ;
}
public static < vt_1 > long fn_22 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_21 , 0L ) . vr_24 () ;
}
public static < vt_1 > long fn_22 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Long > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_21 , vr_7 , 0L ) . vr_21 () ;
}
public static < vt_1 > long fn_22 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final long vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_21 , vr_8 ) . vr_24 () ;
}
public static < vt_1 > vr_1 < ? , ? > fn_23 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
final Object vr_18 = vr_2 . get ( vr_3 ) ;
if ( vr_18 != null && vr_18 instanceof vr_1 ) {
return ( vr_1 < ? , ? > ) vr_18 ;
}
}
return null ;
}
public static < vt_1 > vr_1 < ? , ? > fn_23 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , vr_1 < ? , ? > > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_23 , vr_7 ) ;
}
public static < vt_1 > vr_1 < ? , ? > fn_23 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final vr_1 < ? , ? > vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_23 , vr_8 ) ;
}
public static < vt_1 > vl_1 fn_13 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
final Object vr_18 = vr_2 . get ( vr_3 ) ;
if ( vr_18 != null ) {
if ( vr_18 instanceof vl_1 ) {
return ( vl_1 ) vr_18 ;
}
if ( vr_18 instanceof String ) {
try {
final String vr_25 = ( String ) vr_18 ;
return vr_26 . vr_27 () . fn_24 ( vr_25 ) ;
} catch ( final ParseException vr_28 ) {
}
}
}
}
return null ;
}
public static < vt_1 > vl_1 fn_13 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , vl_1 > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_13 , vr_7 ) ;
}
public static < vt_1 > vl_1 fn_13 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final vl_1 vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_13 , vr_8 ) ;
}
public static < vt_1 , vt_3 > vt_3 fn_25 ( final vr_1 < ? super vt_1 , vt_3 > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
return vr_2 . get ( vr_3 ) ;
}
return null ;
}
public static < vt_1 , vt_3 > vt_3 fn_25 ( final vr_1 < vt_1 , vt_3 > vr_2 , final vt_1 vr_3 , final vt_3 vr_8 ) {
if ( vr_2 != null ) {
final vt_3 vr_18 = vr_2 . get ( vr_3 ) ;
if ( vr_18 != null ) {
return vr_18 ;
}
}
return vr_8 ;
}
public static < vt_1 > Short fn_26 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
final vl_1 vr_18 = fn_13 ( vr_2 , vr_3 ) ;
if ( vr_18 == null ) {
return null ;
}
if ( vr_18 instanceof Short ) {
return ( Short ) vr_18 ;
}
return Short . valueOf ( vr_18 . vr_29 () ) ;
}
public static < vt_1 > Short fn_26 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Short > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_26 , vr_7 ) ;
}
public static < vt_1 > Short fn_26 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final Short vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_26 , vr_8 ) ;
}
public static < vt_1 > short fn_27 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_26 , 0 ) . vr_29 () ;
}
public static < vt_1 > short fn_27 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , Short > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_26 , vr_7 , ( short ) 0 ) . vr_29 () ;
}
public static < vt_1 > short fn_27 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final short vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_26 , vr_8 ) . vr_29 () ;
}
public static < vt_1 > String fn_28 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ) {
if ( vr_2 != null ) {
final Object vr_18 = vr_2 . get ( vr_3 ) ;
if ( vr_18 != null ) {
return vr_18 . toString () ;
}
}
return null ;
}
public static < vt_1 > String fn_28 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 ,
final vr_6 < vt_1 , String > vr_7 ) {
return fn_1 ( vr_2 , vr_3 , vl_2 :: fn_28 , vr_7 ) ;
}
public static < vt_1 > String fn_28 ( final vr_1 < ? super vt_1 , ? > vr_2 , final vt_1 vr_3 , final String vr_8 ) {
return fn_2 ( vr_2 , vr_3 , vl_2 :: fn_28 , vr_8 ) ;
}
public static < vt_1 , vt_3 > vr_1 < vt_3 , vt_1 > fn_29 ( final vr_1 < vt_1 , vt_3 > vr_2 ) {
final vr_1 < vt_3 , vt_1 > out = new vr_30 <> ( vr_2 . size () ) ;
for ( final vr_31 < vt_1 , vt_3 > vr_32 : vr_2 . vr_33 () ) {
out . vr_34 ( vr_32 . vr_35 () , vr_32 . vr_36 () ) ;
}
return out ;
}
public static boolean isEmpty ( final vr_1 < ? , ? > vr_2 ) {
return vr_2 == null || vr_2 . isEmpty () ;
}
public static boolean fn_30 ( final vr_1 < ? , ? > vr_2 ) {
return ! vl_2 . isEmpty ( vr_2 ) ;
}
public static < vt_1 , vt_3 > vr_14 < vt_1 , vt_3 > fn_31 ( final vr_1 < vt_1 , vt_3 > vr_2 ) {
vr_37 . vr_38 ( vr_2 , lr_1 ) ;
return vr_2 instanceof vr_14 ? ( vr_14 < vt_1 , vt_3 > ) vr_2 : new vr_39 < vt_1 , vt_3 > ( vr_2 ) {
} ;
}
public static < vt_1 , vt_3 > vr_40 < vt_1 , vt_3 > fn_32 ( final vr_16 < vt_1 , vt_3 > vr_41 ) {
vr_37 . vr_38 ( vr_41 , lr_2 ) ;
return vr_41 instanceof vr_40 ? ( vr_40 < vt_1 , vt_3 > ) vr_41
: new vr_42 < vt_1 , vt_3 > ( vr_41 ) {
} ;
}
public static < vt_1 , vt_3 > vr_14 < vt_1 , vt_3 > fn_33 ( final vr_1 < vt_1 , vt_3 > vr_2 , final vr_43 < ? extends vt_3 > vr_44 ) {
return vr_45 . fn_33 ( vr_2 , vr_44 ) ;
}
public static < vt_1 , vt_3 > vr_14 < vt_1 , vt_3 > fn_33 ( final vr_1 < vt_1 , vt_3 > vr_2 ,
final vr_46 < ? super vt_1 , ? extends vt_3 > vr_47 ) {
return vr_45 . fn_33 ( vr_2 , vr_47 ) ;
}
public static < vt_1 , vt_3 > vr_16 < vt_1 , vt_3 > fn_34 ( final vr_16 < vt_1 , vt_3 > vr_2 , final vr_43 < ? extends vt_3 > vr_44 ) {
return vr_48 . fn_34 ( vr_2 , vr_44 ) ;
}
public static < vt_1 , vt_3 > vr_16 < vt_1 , vt_3 > fn_34 ( final vr_16 < vt_1 , vt_3 > vr_2 ,
final vr_46 < ? super vt_1 , ? extends vt_3 > vr_47 ) {
return vr_48 . fn_34 ( vr_2 , vr_47 ) ;
}
@Deprecated
public static < vt_1 , vt_3 > vr_49 < vt_1 , vt_3 > fn_35 ( final vr_1 < vt_1 , ? super Collection < vt_3 > > vr_2 ) {
return vr_49 . <vt_1 , vt_3 > fn_35 ( vr_2 ) ;
}
@Deprecated
public static < vt_1 , vt_3 , vt_4 extends Collection < vt_3 > > vr_49 < vt_1 , vt_3 > fn_35 ( final vr_1 < vt_1 , vt_4 > vr_2 ,
final Class < vt_4 > vr_50 ) {
return vr_49 . fn_35 ( vr_2 , vr_50 ) ;
}
@Deprecated
public static < vt_1 , vt_3 , vt_4 extends Collection < vt_3 > > vr_49 < vt_1 , vt_3 > fn_35 ( final vr_1 < vt_1 , vt_4 > vr_2 ,
final vr_43 < vt_4 > vr_51 ) {
return vr_49 . fn_35 ( vr_2 , vr_51 ) ;
}
public static < vt_1 , vt_3 > vr_52 < vt_1 , vt_3 > fn_36 ( final vr_1 < vt_1 , vt_3 > vr_2 ) {
return vr_53 . vr_54 ( vr_2 ) ;
}
public static < vt_1 , vt_3 , vt_5 > void fn_37 ( final vr_1 < vt_1 , vt_3 > vr_2 , final vr_55 < ? extends vt_5 > vr_56 ,
final vr_46 < vt_5 , vt_1 > vr_57 , final vr_46 < vt_5 , vt_3 > vr_58 ) {
final Iterator < ? extends vt_5 > vr_59 = vr_56 . iterator () ;
while ( vr_59 . hasNext () ) {
final vt_5 vr_60 = vr_59 . vr_61 () ;
vr_2 . vr_34 ( vr_57 . vr_62 ( vr_60 ) , vr_58 . vr_62 ( vr_60 ) ) ;
}
}
public static < vt_1 , vt_3 > void fn_37 ( final vr_1 < vt_1 , vt_3 > vr_2 , final vr_55 < ? extends vt_3 > vr_56 ,
final vr_46 < vt_3 , vt_1 > vr_57 ) {
fn_37 ( vr_2 , vr_56 , vr_57 , vr_63 . <vt_3 > fn_38 () ) ;
}
public static < vt_1 , vt_3 , vt_5 > void fn_37 ( final vr_64 < vt_1 , vt_3 > vr_2 , final vr_55 < ? extends vt_5 > vr_56 ,
final vr_46 < vt_5 , vt_1 > vr_57 , final vr_46 < vt_5 , vt_3 > vr_58 ) {
final Iterator < ? extends vt_5 > vr_59 = vr_56 . iterator () ;
while ( vr_59 . hasNext () ) {
final vt_5 vr_60 = vr_59 . vr_61 () ;
vr_2 . vr_34 ( vr_57 . vr_62 ( vr_60 ) , vr_58 . vr_62 ( vr_60 ) ) ;
}
}
public static < vt_1 , vt_3 > void fn_37 ( final vr_64 < vt_1 , vt_3 > vr_2 , final vr_55 < ? extends vt_3 > vr_56 ,
final vr_46 < vt_3 , vt_1 > vr_57 ) {
fn_37 ( vr_2 , vr_56 , vr_57 , vr_63 . <vt_3 > fn_38 () ) ;
}
public static < vt_1 , vt_3 > vr_14 < vt_1 , vt_3 > fn_39 ( final vr_1 < vt_1 , vt_3 > vr_2 , final vr_65 < ? super vt_1 > vr_66 ,
final vr_65 < ? super vt_3 > vr_67 ) {
return vr_68 . fn_39 ( vr_2 , vr_66 , vr_67 ) ;
}
public static < vt_1 , vt_3 > vr_16 < vt_1 , vt_3 > fn_40 ( final vr_16 < vt_1 , vt_3 > vr_2 ,
final vr_65 < ? super vt_1 > vr_66 , final vr_65 < ? super vt_3 > vr_67 ) {
return vr_69 . fn_40 ( vr_2 , vr_66 , vr_67 ) ;
}
private static void fn_41 ( final tp_1 out , final int vr_70 ) {
for ( int vr_71 = 0 ; vr_71 < vr_70 ; vr_71 ++ ) {
out . vr_72 ( vl_3 ) ;
}
}
@SuppressWarnings ( lr_3 )
public static < vt_1 , vt_3 > vr_1 < vt_1 , vt_3 > fn_42 ( final vr_1 < vt_1 , vt_3 > vr_2 , final Object [] array ) {
vr_37 . vr_38 ( vr_2 , lr_1 ) ;
if ( array == null || array . length == 0 ) {
return vr_2 ;
}
final Object vr_73 = array [ 0 ] ;
if ( vr_73 instanceof vr_1 . vr_31 ) {
for ( final Object vr_74 : array ) {
final vr_1 . vr_31 < vt_1 , vt_3 > vr_32 = ( vr_1 . vr_31 < vt_1 , vt_3 > ) vr_74 ;
vr_2 . vr_34 ( vr_32 . vr_36 () , vr_32 . vr_35 () ) ;
}
} else if ( vr_73 instanceof vl_4 ) {
for ( final Object vr_74 : array ) {
final vl_4 < vt_1 , vt_3 > vr_75 = ( vl_4 < vt_1 , vt_3 > ) vr_74 ;
vr_2 . vr_34 ( vr_75 . vr_36 () , vr_75 . vr_35 () ) ;
}
} else if ( vr_73 instanceof Object [] ) {
for ( int vr_71 = 0 ; vr_71 < array . length ; vr_71 ++ ) {
final Object [] vr_76 = ( Object [] ) array [ vr_71 ] ;
if ( vr_76 == null || vr_76 . length < 2 ) {
throw new IllegalArgumentException ( lr_4 + vr_71 ) ;
}
vr_2 . vr_34 ( ( vt_1 ) vr_76 [ 0 ] , ( vt_3 ) vr_76 [ 1 ] ) ;
}
} else {
for ( int vr_71 = 0 ; vr_71 < array . length - 1 ; ) {
vr_2 . vr_34 ( ( vt_1 ) array [ vr_71 ++ ] , ( vt_3 ) array [ vr_71 ++ ] ) ;
}
}
return vr_2 ;
}
public static < vt_1 > void fn_43 ( final vr_1 < ? super vt_1 , Object > vr_2 , final vt_1 vr_3 , final Object vr_9 )
throws vl_5 {
vr_2 . vr_34 ( vr_3 , vr_9 == null ? lr_5 : vr_9 ) ;
}
public static int size ( final vr_1 < ? , ? > vr_2 ) {
return vr_2 == null ? 0 : vr_2 . size () ;
}
public static < vt_1 , vt_3 > vr_1 < vt_1 , vt_3 > fn_44 ( final vr_1 < vt_1 , vt_3 > vr_2 ) {
return vr_13 . fn_44 ( vr_2 ) ;
}
public static < vt_1 , vt_3 > vr_16 < vt_1 , vt_3 > fn_45 ( final vr_16 < vt_1 , vt_3 > vr_2 ) {
return vr_13 . fn_45 ( vr_2 ) ;
}
public static vr_1 < String , Object > fn_46 ( final tp_2 vr_77 ) {
final Enumeration < String > enumeration = vr_77 . vr_78 () ;
final vr_1 < String , Object > vr_2 = new vr_30 <> () ;
while ( enumeration . vr_79 () ) {
final String vr_3 = enumeration . nextElement () ;
final Object vr_9 = vr_77 . fn_25 ( vr_3 ) ;
vr_2 . vr_34 ( vr_3 , vr_9 ) ;
}
return vr_2 ;
}
public static < vt_1 , vt_3 > Properties fn_47 ( final vr_1 < vt_1 , vt_3 > vr_2 ) {
final Properties vr_18 = new Properties () ;
if ( vr_2 != null ) {
for ( final vr_31 < vt_1 , vt_3 > vr_80 : vr_2 . vr_33 () ) {
final vr_1 . vr_31 < ? , ? > vr_32 = vr_80 ;
final Object vr_3 = vr_32 . vr_36 () ;
final Object vr_9 = vr_32 . vr_35 () ;
vr_18 . vr_34 ( vr_3 , vr_9 ) ;
}
}
return vr_18 ;
}
public static < vt_1 , vt_3 > vr_14 < vt_1 , vt_3 > fn_48 ( final vr_1 < vt_1 , vt_3 > vr_2 ,
final vr_46 < ? super vt_1 , ? extends vt_1 > vr_57 ,
final vr_46 < ? super vt_3 , ? extends vt_3 > vr_58 ) {
return vr_81 . vr_82 ( vr_2 , vr_57 , vr_58 ) ;
}
public static < vt_1 , vt_3 > vr_16 < vt_1 , vt_3 > fn_49 ( final vr_16 < vt_1 , vt_3 > vr_2 ,
final vr_46 < ? super vt_1 , ? extends vt_1 > vr_57 ,
final vr_46 < ? super vt_3 , ? extends vt_3 > vr_58 ) {
return vr_83 . vr_84 ( vr_2 , vr_57 , vr_58 ) ;
}
public static < vt_1 , vt_3 > vr_1 < vt_1 , vt_3 > fn_50 ( final vr_1 < ? extends vt_1 , ? extends vt_3 > vr_2 ) {
return vr_85 . fn_50 ( vr_2 ) ;
}
public static < vt_1 , vt_3 > vr_16 < vt_1 , vt_3 > fn_51 ( final vr_16 < vt_1 , ? extends vt_3 > vr_2 ) {
return vr_86 . fn_51 ( vr_2 ) ;
}
public static void fn_52 ( final tp_1 out , final Object vr_11 , final vr_1 < ? , ? > vr_2 ) {
fn_4 ( out , vr_11 , vr_2 , new vr_12 < vr_1 < ? , ? > > () , false ) ;
}
private static void fn_4 ( final tp_1 out , final Object vr_11 , final vr_1 < ? , ? > vr_2 ,
final vr_87 < vr_1 < ? , ? > > vr_88 , final boolean vr_89 ) {
fn_41 ( out , vr_88 . size () ) ;
if ( vr_2 == null ) {
if ( vr_11 != null ) {
out . vr_72 ( vr_11 ) ;
out . vr_72 ( lr_6 ) ;
}
out . println ( lr_7 ) ;
return;
}
if ( vr_11 != null ) {
out . vr_72 ( vr_11 ) ;
out . println ( lr_6 ) ;
}
fn_41 ( out , vr_88 . size () ) ;
out . println ( lr_8 ) ;
vr_88 . vr_90 ( vr_2 ) ;
for ( final vr_1 . vr_31 < ? , ? > vr_32 : vr_2 . vr_33 () ) {
final Object vr_91 = vr_32 . vr_36 () ;
final Object vr_92 = vr_32 . vr_35 () ;
if ( vr_92 instanceof vr_1 && ! vr_88 . contains ( vr_92 ) ) {
fn_4 ( out , vr_91 == null ? lr_7 : vr_91 , ( vr_1 < ? , ? > ) vr_92 , vr_88 , vr_89 ) ;
} else {
fn_41 ( out , vr_88 . size () ) ;
out . vr_72 ( vr_91 ) ;
out . vr_72 ( lr_6 ) ;
final int vr_93 = vr_94 . indexOf ( vr_88 , vr_95 . vr_96 ( vr_92 ) ) ;
if ( vr_93 == - 1 ) {
out . vr_72 ( vr_92 ) ;
} else if ( vr_88 . size () - 1 == vr_93 ) {
out . vr_72 ( lr_9 ) ;
} else {
out . vr_72 ( lr_10 + ( vr_88 . size () - 1 - vr_93 - 1 ) + lr_11 ) ;
}
if ( vr_89 && vr_92 != null ) {
out . vr_72 ( ' ' ) ;
out . println ( vr_92 . getClass () . fn_53 () ) ;
} else {
out . println () ;
}
}
}
vr_88 . vr_97 () ;
fn_41 ( out , vr_88 . size () ) ;
out . println ( vr_89 ? lr_12 + vr_2 . getClass () . fn_53 () : lr_13 ) ;
}
