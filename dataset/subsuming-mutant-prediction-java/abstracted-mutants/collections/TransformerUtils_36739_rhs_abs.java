public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 () {
return vr_2 . fn_1 () ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_2 () {
return vr_3 . fn_2 () ;
}
public static < vt_3 > vr_1 < vt_3 , vt_3 > fn_3 () {
return vr_4 . fn_3 () ;
}
public static < vt_3 > vr_1 < vt_3 , vt_3 > fn_4 () {
return vr_5 . fn_4 () ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_5 ( final vt_2 vr_6 ) {
return vr_3 . fn_5 ( vr_6 ) ;
}
public static < vt_3 > vr_1 < vt_3 , vt_3 > fn_6 ( final vr_7 < ? super vt_3 > vr_8 ) {
return vr_9 . vr_10 ( vr_8 ) ;
}
public static < vt_3 > vr_1 < vt_3 , Boolean > fn_6 ( final vr_11 < ? super vt_3 > vr_12 ) {
return vr_13 . vr_14 ( vr_12 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_6 ( final vr_15 < ? extends vt_2 > vr_16 ) {
return vr_17 . vr_18 ( vr_16 ) ;
}
public static < vt_3 > vr_1 < vt_3 , vt_3 > fn_7 (
final vr_1 < ? super vt_3 , ? extends vt_3 > ... vr_19 ) {
return vr_20 . fn_7 ( vr_19 ) ;
}
public static < vt_3 > vr_1 < vt_3 , vt_3 > fn_7 (
final Collection < ? extends vr_1 < ? super vt_3 , ? extends vt_3 > > vr_19 ) {
return vr_20 . fn_7 ( vr_19 ) ;
}
public static < vt_3 > vr_1 < vt_3 , vt_3 > fn_8 ( final vr_11 < ? super vt_3 > vr_12 ,
final vr_1 < ? super vt_3 , ? extends vt_3 > vr_21 ) {
return vr_22 . fn_8 ( vr_12 , vr_21 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_8 ( final vr_11 < ? super vt_1 > vr_12 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_21 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_23 ) {
return vr_22 . fn_8 ( vr_12 , vr_21 , vr_23 ) ;
}
@SuppressWarnings ( lr_1 )
@Deprecated
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_9 ( final vr_11 < ? super vt_1 > vr_12 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_21 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_23 ) {
return vr_24 . fn_9 ( new vr_11 [] { vr_12 } ,
new vr_1 [] { vr_21 } , vr_23 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_9 ( final vr_11 < ? super vt_1 > [] vr_25 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > [] vr_19 ) {
return vr_24 . fn_9 ( vr_25 , vr_19 , null ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_9 ( final vr_11 < ? super vt_1 > [] vr_25 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > [] vr_19 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_26 ) {
return vr_24 . fn_9 ( vr_25 , vr_19 , vr_26 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_9 (
final vr_27 < vr_11 < vt_1 > , vr_1 < vt_1 , vt_2 > > vr_28 ) {
return vr_24 . fn_9 ( vr_28 ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_10 (
final vr_27 < vt_1 , vr_1 < vt_1 , vt_2 > > vr_29 ) {
vr_30 . vr_31 ( vr_29 , lr_2 ) ;
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_32 = vr_29 . remove ( null ) ;
final int size = vr_29 . size () ;
final vr_1 < ? super vt_1 , ? extends vt_2 > [] vr_33 = new vr_1 [ size ] ;
final vr_11 < vt_1 > [] vr_34 = new vr_11 [ size ] ; MST[rv.UOI4Mutator]MSP[N]
int vr_35 = 0 ;
for ( final vr_27 . vr_36 < vt_1 , vr_1 < vt_1 , vt_2 > > vr_37 : vr_29 . vr_38 () ) {
vr_34 [ vr_35 ] = vr_39 . <vt_1 > fn_11 ( vr_37 . vr_40 () ) ;
vr_33 [ vr_35 ++ ] = vr_37 . vr_41 () ;
}
return vr_42 . fn_9 ( vr_34 , vr_33 , vr_32 ) ;
}
public static < vt_3 > vr_1 < Class < ? extends vt_3 > , vt_3 > fn_12 () {
return vr_43 . fn_12 () ;
}
public static < vt_3 > vr_1 < Class < ? extends vt_3 > , vt_3 > fn_12 (
final Class < ? > [] vr_44 , final Object [] args ) {
return vr_43 . fn_12 ( vr_44 , args ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_13 ( final vr_27 < ? super vt_1 , ? extends vt_2 > vr_45 ) {
return vr_46 . fn_13 ( vr_45 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_14 ( final String vr_47 ) {
return vr_48 . fn_14 ( vr_47 , null , null ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_14 ( final String vr_47 , final Class < ? > [] vr_44 ,
final Object [] args ) {
return vr_48 . fn_14 ( vr_47 , vr_44 , args ) ;
}
public static < vt_3 > vr_1 < vt_3 , String > fn_15 () {
return vr_49 . fn_15 () ;
}
