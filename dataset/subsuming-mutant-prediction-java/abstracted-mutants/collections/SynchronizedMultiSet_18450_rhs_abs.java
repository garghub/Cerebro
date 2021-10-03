public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < vt_1 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
@Override
protected vr_2 < vt_1 > fn_2 () {
return ( vr_2 < vt_1 > ) super . fn_2 () ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
synchronized ( vl_1 ) {
return fn_2 () . equals ( object ) ; MST[BooleanFalseReturnValsMutator]MSP[S]
}
}
@Override
public int fn_3 () {
synchronized ( vl_1 ) {
return fn_2 () . fn_3 () ;
}
}
@Override
public int add ( final vt_1 object , final int vr_4 ) {
synchronized ( vl_1 ) {
return fn_2 () . add ( object , vr_4 ) ;
}
}
@Override
public int remove ( final Object object , final int vr_4 ) {
synchronized ( vl_1 ) {
return fn_2 () . remove ( object , vr_4 ) ;
}
}
@Override
public int fn_4 ( final Object object ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_4 ( object ) ;
}
}
@Override
public int fn_5 ( final vt_1 object , final int vr_4 ) {
synchronized ( vl_1 ) {
return fn_2 () . fn_5 ( object , vr_4 ) ;
}
}
@Override
public vr_5 < vt_1 > fn_6 () {
synchronized ( vl_1 ) {
final vr_5 < vt_1 > vr_6 = fn_2 () . fn_6 () ;
return new vr_7 <> ( vr_6 , vl_1 ) ;
}
}
@Override
public vr_5 < vr_8 < vt_1 > > fn_7 () {
synchronized ( vl_1 ) {
final vr_5 < vr_2 . vr_8 < vt_1 > > vr_6 = fn_2 () . fn_7 () ;
return new vr_7 <> ( vr_6 , vl_1 ) ;
}
}
