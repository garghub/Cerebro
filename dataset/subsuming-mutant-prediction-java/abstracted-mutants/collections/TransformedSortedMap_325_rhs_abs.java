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
if ( vr_3 . size () > 0 ) {
final vr_8 < vt_1 , vt_2 > vr_9 = vr_7 . vr_10 ( vr_3 ) ;
vr_7 . clear () ;
vr_7 . vr_7 () . fn_3 ( vr_9 ) ;
}
return vr_7 ;
}
protected vr_2 < vt_1 , vt_2 > fn_4 () {
return ( vr_2 < vt_1 , vt_2 > ) vr_3 ;
}
@Override
public vt_1 fn_5 () {
return fn_4 () . fn_5 () ;
}
@Override
public vt_1 fn_6 () {
return fn_4 () . fn_6 () ;
}
@Override
public vr_11 < ? super vt_1 > fn_7 () {
return fn_4 () . fn_7 () ; MST[NonVoidMethodCallMutator]MSP[S]
}
@Override
public vr_2 < vt_1 , vt_2 > fn_8 ( final vt_1 vr_12 , final vt_1 vr_13 ) {
final vr_2 < vt_1 , vt_2 > vr_3 = fn_4 () . fn_8 ( vr_12 , vr_13 ) ;
return new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
}
@Override
public vr_2 < vt_1 , vt_2 > fn_9 ( final vt_1 vr_13 ) {
final vr_2 < vt_1 , vt_2 > vr_3 = fn_4 () . fn_9 ( vr_13 ) ;
return new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
}
@Override
public vr_2 < vt_1 , vt_2 > fn_10 ( final vt_1 vr_12 ) {
final vr_2 < vt_1 , vt_2 > vr_3 = fn_4 () . fn_10 ( vr_12 ) ;
return new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
}
