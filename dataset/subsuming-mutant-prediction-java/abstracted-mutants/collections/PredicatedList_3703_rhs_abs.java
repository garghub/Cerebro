public static < vt_1 > vr_1 < vt_1 > fn_1 ( final List < vt_1 > list , final vr_2 < ? super vt_1 > vr_3 ) {
return new vr_1 <> ( list , vr_3 ) ;
}
@Override
protected List < vt_2 > fn_2 () {
return ( List < vt_2 > ) super . fn_2 () ;
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
public vt_2 get ( final int vr_4 ) {
return fn_2 () . get ( vr_4 ) ;
}
@Override
public int indexOf ( final Object object ) {
return fn_2 () . indexOf ( object ) ;
}
@Override
public int fn_4 ( final Object object ) {
return fn_2 () . fn_4 ( object ) ;
}
@Override
public vt_2 remove ( final int vr_4 ) {
return fn_2 () . remove ( vr_4 ) ;
}
@Override
public void add ( final int vr_4 , final vt_2 object ) {
fn_5 ( object ) ;
fn_2 () . add ( vr_4 , object ) ;
}
@Override
public boolean fn_6 ( final int vr_4 , final Collection < ? extends vt_2 > vr_5 ) {
for ( final vt_2 vr_6 : vr_5 ) {
fn_5 ( vr_6 ) ;
}
return fn_2 () . fn_6 ( vr_4 , vr_5 ) ;
}
@Override
public vr_7 < vt_2 > fn_7 () {
return fn_7 ( 0 ) ;
}
@Override
public vr_7 < vt_2 > fn_7 ( final int vr_8 ) {
return new fn_8 ( fn_2 () . fn_7 ( vr_8 ) ) ;
}
@Override
public vt_2 fn_9 ( final int vr_4 , final vt_2 object ) {
fn_5 ( object ) ;
return fn_2 () . fn_9 ( vr_4 , object ) ;
}
@Override
public List < vt_2 > fn_10 ( final int vr_9 , final int vr_10 ) {
final List < vt_2 > vr_11 = fn_2 () . fn_10 ( vr_9 , vr_10 ) ;
return new vr_1 <> ( vr_11 , vr_3 ) ;
}
@Override
public void add ( final vt_2 object ) {
fn_5 ( object ) ;
fn_11 () . add ( object ) ;
}
@Override
public void fn_9 ( final vt_2 object ) {
fn_5 ( object ) ;
fn_11 () . fn_9 ( object ) ; MST[NonVoidMethodCallMutator]MSP[S]
}
