public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 , final vr_4 < ? super vt_1 > vr_5 ) {
return new vr_1 <> ( vr_3 , vr_5 ) ;
}
@Override
protected vr_2 < vt_1 > fn_2 () {
return ( vr_2 < vt_1 > ) super . fn_2 () ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || fn_2 () . equals ( object ) ;
}
@Override
public int fn_3 () {
return fn_2 () . fn_3 () ;
}
@Override
public boolean add ( final vt_1 object , final int vr_6 ) {
fn_4 ( object ) ;
return fn_2 () . add ( object , vr_6 ) ;
}
@Override
public boolean remove ( final Object object , final int vr_6 ) {
return fn_2 () . remove ( object , vr_6 ) ;
}
@Override
public vr_7 < vt_1 > fn_5 () {
return fn_2 () . fn_5 () ; MST[NonVoidMethodCallMutator]MSP[S]
}
@Override
public int fn_6 ( final Object object ) {
return fn_2 () . fn_6 ( object ) ;
}
