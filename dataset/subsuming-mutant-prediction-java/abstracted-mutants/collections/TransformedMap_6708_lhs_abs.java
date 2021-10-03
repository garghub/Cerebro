public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ,
final vr_4 < ? super vt_2 , ? extends vt_2 > vr_6 ) {
return new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_2 ( final vr_2 < vt_1 , vt_2 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ,
final vr_4 < ? super vt_2 , ? extends vt_2 > vr_6 ) {
final vr_1 < vt_1 , vt_2 > vr_7 = new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
if ( vr_3 . size () > 0 ) {
final vr_2 < vt_1 , vt_2 > vr_8 = vr_7 . vr_9 ( vr_3 ) ;
vr_7 . clear () ;
vr_7 . vr_7 () . fn_3 ( vr_8 ) ;
}
return vr_7 ;
}
private void fn_4 ( final tp_1 out ) throws IOException {
out . vr_10 () ;
out . fn_4 ( vr_3 ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_5 ( final tp_2 vr_11 ) throws IOException , vl_1 {
vr_11 . vr_12 () ;
vr_3 = ( vr_2 < vt_1 , vt_2 > ) vr_11 . fn_5 () ;
}
protected vt_1 fn_6 ( final vt_1 object ) {
if ( vr_5 == null ) {
return object ;
}
return vr_5 . vr_13 ( object ) ;
}
protected vt_2 fn_7 ( final vt_2 object ) {
if ( vr_6 == null ) {
return object ;
}
return vr_6 . vr_13 ( object ) ;
}
@SuppressWarnings ( lr_1 )
protected vr_2 < vt_1 , vt_2 > vr_9 ( final vr_2 < ? extends vt_1 , ? extends vt_2 > vr_3 ) {
if ( vr_3 . isEmpty () ) {
return ( vr_2 < vt_1 , vt_2 > ) vr_3 ;
}
final vr_2 < vt_1 , vt_2 > vr_14 = new vr_15 <> ( vr_3 . size () ) ;
for ( final vr_2 . vr_16 < ? extends vt_1 , ? extends vt_2 > vr_17 : vr_3 . vr_18 () ) {
vr_14 . vr_19 ( fn_6 ( vr_17 . vr_20 () ) , fn_7 ( vr_17 . vr_21 () ) ) ;
}
return vr_14 ;
}
@Override
protected vt_2 fn_8 ( final vt_2 vr_22 ) {
return vr_6 . vr_13 ( vr_22 ) ;
}
@Override
protected boolean fn_9 () {
return vr_6 != null ;
}
@Override
public vt_2 vr_19 ( vt_1 vr_23 , vt_2 vr_22 ) {
vr_23 = fn_6 ( vr_23 ) ;
vr_22 = fn_7 ( vr_22 ) ;
return vr_7 () . vr_19 ( vr_23 , vr_22 ) ; MST[ReturnValsMutator]MSP[]
}
@Override
public void fn_3 ( vr_2 < ? extends vt_1 , ? extends vt_2 > vr_24 ) {
vr_24 = vr_9 ( vr_24 ) ;
vr_7 () . fn_3 ( vr_24 ) ;
}
