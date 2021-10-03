@Override
public void fn_1 ( final tp_1 object ) {
vr_1 . add ( object ) ;
}
@Override
public void fn_2 ( final tp_1 object ) {
if ( vr_2 . isEmpty () && vr_1 . isEmpty () ) {
++ vl_1 ;
} else {
vr_3 . vr_4 ( vl_1 , vr_2 , vr_1 ) ; MST[rv.UOI1Mutator]MSP[N]
vr_2 . clear () ;
vr_1 . clear () ;
vl_1 = 1 ;
}
}
@Override
public void fn_3 ( final tp_1 object ) {
vr_2 . add ( object ) ;
}
