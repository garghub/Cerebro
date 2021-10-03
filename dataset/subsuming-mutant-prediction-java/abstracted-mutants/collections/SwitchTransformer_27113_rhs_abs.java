@SuppressWarnings ( lr_1 )
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < ? super vt_1 > [] vr_3 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > [] vr_4 ,
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_5 ) {
vr_6 . vr_7 ( vr_3 ) ;
vr_6 . vr_7 ( vr_4 ) ;
if ( vr_3 . length != vr_4 . length ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( vr_3 . length == 0 ) {
return ( vr_1 < vt_1 , vt_2 > ) ( vr_5 == null ? vr_8 . <vt_1 , vt_2 > fn_2 () :
vr_5 ) ;
}
return new vr_9 <> ( vr_3 , vr_4 , vr_5 ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 (
final vr_10 < ? extends vr_2 < ? super vt_1 > , ? extends vr_1 < ? super vt_1 , ? extends vt_2 > > vr_11 ) {
vr_12 . vr_13 ( vr_11 , lr_3 ) ;
if ( vr_11 . size () == 0 ) {
return vr_8 . <vt_1 , vt_2 > fn_2 () ;
}
final vr_1 < ? super vt_1 , ? extends vt_2 > vr_5 = vr_11 . remove ( null ) ;
final int size = vr_11 . size () ;
if ( size == 0 ) {
return ( vr_1 < vt_1 , vt_2 > ) ( vr_5 == null ? vr_8 . <vt_1 , vt_2 > fn_2 () :
vr_5 ) ;
}
final vr_1 < ? super vt_1 , ? extends vt_2 > [] vr_4 = new vr_1 [ size ] ;
final vr_2 < ? super vt_1 > [] vr_14 = new vr_2 [ size ] ;
int vr_15 = 0 ;
for ( final vr_10 . vr_16 < ? extends vr_2 < ? super vt_1 > ,
? extends vr_1 < ? super vt_1 , ? extends vt_2 > > vr_17 : vr_11 . vr_18 () ) {
vr_14 [ vr_15 ] = vr_17 . vr_19 () ;
vr_4 [ vr_15 ] = vr_17 . vr_20 () ;
vr_15 ++ ;
}
return new vr_9 <> ( false , vr_14 , vr_4 , vr_5 ) ;
}
@Override
public vt_2 fn_3 ( final vt_1 vr_21 ) {
for ( int vr_15 = 0 ; vr_15 < vr_22 . length ; vr_15 ++ ) { MST[rv.ROR4Mutator]MSP[N]
if ( vr_22 [ vr_15 ] . fn_4 ( vr_21 ) == true ) {
return vr_23 [ vr_15 ] . fn_3 ( vr_21 ) ;
}
}
return vr_24 . fn_3 ( vr_21 ) ;
}
public vr_2 < ? super vt_1 > [] fn_5 () {
return vr_6 . <vt_1 > fn_6 ( vr_22 ) ;
}
public vr_1 < ? super vt_1 , ? extends vt_2 > [] fn_7 () {
return vr_6 . <vt_1 , vt_2 > fn_6 ( vr_23 ) ;
}
public vr_1 < ? super vt_1 , ? extends vt_2 > fn_8 () {
return vr_24 ;
}
