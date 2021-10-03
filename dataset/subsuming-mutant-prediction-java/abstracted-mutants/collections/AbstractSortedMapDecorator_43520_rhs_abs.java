@Override
protected vr_1 < vt_1 , vt_2 > fn_1 () {
return ( vr_1 < vt_1 , vt_2 > ) super . fn_1 () ;
}
@Override
public vr_2 < ? super vt_1 > fn_2 () {
return fn_1 () . fn_2 () ; MST[NullReturnValsMutator]MSP[S]
}
@Override
public vt_1 fn_3 () {
return fn_1 () . fn_3 () ;
}
@Override
public vt_1 fn_4 () {
return fn_1 () . fn_4 () ;
}
@Override
public vr_1 < vt_1 , vt_2 > fn_5 ( final vt_1 vr_3 , final vt_1 vr_4 ) {
return fn_1 () . fn_5 ( vr_3 , vr_4 ) ;
}
@Override
public vr_1 < vt_1 , vt_2 > fn_6 ( final vt_1 vr_4 ) {
return fn_1 () . fn_6 ( vr_4 ) ;
}
@Override
public vr_1 < vt_1 , vt_2 > fn_7 ( final vt_1 vr_3 ) {
return fn_1 () . fn_7 ( vr_3 ) ;
}
@Override
public vt_1 fn_8 ( final vt_1 vr_5 ) {
final vr_1 < vt_1 , vt_2 > fn_6 = fn_6 ( vr_5 ) ;
return fn_6 . isEmpty () ? null : fn_6 . fn_4 () ;
}
@Override
public vt_1 fn_9 ( final vt_1 vr_5 ) {
final Iterator < vt_1 > vr_6 = fn_7 ( vr_5 ) . fn_10 () . iterator () ;
vr_6 . vr_7 () ;
return vr_6 . hasNext () ? vr_6 . vr_7 () : null ;
}
@Override
public vr_8 < vt_1 , vt_2 > fn_11 () {
return new vr_9 <> ( fn_12 () ) ;
}
@Override
public synchronized void fn_13 () {
super . fn_13 () ;
iterator = new vr_10 <> ( iterator ) ;
}
@Override
public boolean fn_14 () {
return ( ( vr_11 < vr_12 . vr_13 < vt_1 , vt_2 > > ) iterator ) . fn_14 () ;
}
@Override
public vt_1 fn_15 () {
vl_1 = ( ( vr_11 < vr_12 . vr_13 < vt_1 , vt_2 > > ) iterator ) . fn_15 () ;
return fn_16 () ;
}
