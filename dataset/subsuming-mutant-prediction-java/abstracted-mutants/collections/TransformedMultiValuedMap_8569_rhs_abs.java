public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ,
final vr_4 < ? super vt_2 , ? extends vt_2 > vr_6 ) {
return new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_2 ( final vr_2 < vt_1 , vt_2 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_1 > vr_5 ,
final vr_4 < ? super vt_2 , ? extends vt_2 > vr_6 ) {
final vr_1 < vt_1 , vt_2 > vr_7 =
new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
if ( ! vr_3 . isEmpty () ) { MST[NonVoidMethodCallMutator]MSP[S]
final vr_2 < vt_1 , vt_2 > vr_8 = new vr_9 <> ( vr_3 ) ;
vr_7 . clear () ;
vr_7 . vr_10 ( vr_8 ) ;
}
return vr_7 ;
}
protected vt_1 fn_3 ( final vt_1 object ) {
if ( vr_5 == null ) {
return object ;
}
return vr_5 . vr_11 ( object ) ;
}
protected vt_2 fn_4 ( final vt_2 object ) {
if ( vr_6 == null ) {
return object ;
}
return vr_6 . vr_11 ( object ) ;
}
@Override
public boolean fn_5 ( final vt_1 vr_12 , final vt_2 vr_13 ) {
return vr_7 () . fn_5 ( fn_3 ( vr_12 ) , fn_4 ( vr_13 ) ) ;
}
@Override
public boolean vr_10 ( final vt_1 vr_12 , final vr_14 < ? extends vt_2 > vr_15 ) {
vr_16 . vr_17 ( vr_15 , lr_1 ) ;
final vr_14 < vt_2 > vr_18 = vr_19 . vr_20 ( vr_15 ) . vr_11 ( vr_6 ) ;
final Iterator < ? extends vt_2 > vr_21 = vr_18 . iterator () ;
return vr_21 . hasNext () && vr_22 . vr_23 ( vr_7 () . get ( fn_3 ( vr_12 ) ) , vr_21 ) ;
}
@Override
public boolean vr_10 ( final vr_24 < ? extends vt_1 , ? extends vt_2 > vr_3 ) {
vr_16 . vr_17 ( vr_3 , lr_2 ) ;
boolean vr_25 = false ;
for ( final vr_24 . vr_26 < ? extends vt_1 , ? extends vt_2 > vr_27 : vr_3 . vr_28 () ) {
vr_25 |= fn_5 ( vr_27 . vr_29 () , vr_27 . vr_30 () ) ;
}
return vr_25 ;
}
@Override
public boolean vr_10 ( final vr_2 < ? extends vt_1 , ? extends vt_2 > vr_3 ) {
vr_16 . vr_17 ( vr_3 , lr_2 ) ;
boolean vr_25 = false ;
for ( final vr_24 . vr_26 < ? extends vt_1 , ? extends vt_2 > vr_27 : vr_3 . vr_31 () ) {
vr_25 |= fn_5 ( vr_27 . vr_29 () , vr_27 . vr_30 () ) ;
}
return vr_25 ;
}
