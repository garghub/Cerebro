public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
protected vr_2 < vt_1 > fn_2 () {
return ( vr_2 < vt_1 > ) fn_3 () ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
synchronized ( vl_1 ) {
return fn_2 () . equals ( object ) ;
}
}
@Override
public int fn_4 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_4 () ;
}
}
@Override
public boolean add ( final vt_1 object , final int vr_4 ) {
synchronized ( vl_1 ) {
return fn_2 () . add ( object , vr_4 ) ;
}
}
@Override
public boolean remove ( final Object object , final int vr_4 ) {
synchronized ( vl_1 ) {
return fn_2 () . remove ( object , vr_4 ) ;
}
}
@Override
public vr_5 < vt_1 > fn_5 () {
synchronized ( vl_1 ) {
final vr_5 < vt_1 > vr_6 = fn_2 () . fn_5 () ;
return new fn_6 ( vr_6 , vl_1 ) ;
}
}
@Override
public int fn_7 ( final Object object ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_7 ( object ) ; MST[NonVoidMethodCallMutator]MSP[]
}
}
