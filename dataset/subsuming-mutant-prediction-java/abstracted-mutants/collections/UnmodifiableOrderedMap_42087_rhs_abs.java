public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_1 < ? extends vt_1 , ? extends vt_2 > vr_2 ) {
if ( vr_2 instanceof vl_1 ) {
@SuppressWarnings ( lr_1 )
final vr_1 < vt_1 , vt_2 > vr_3 = ( vr_1 < vt_1 , vt_2 > ) vr_2 ;
return vr_3 ;
}
return new vr_4 <> ( vr_2 ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_5 () ;
out . fn_2 ( vr_2 ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_3 ( final tp_2 vr_6 ) throws IOException , vl_2 {
vr_6 . vr_7 () ;
vr_2 = ( vr_8 < vt_1 , vt_2 > ) vr_6 . fn_3 () ;
}
@Override
public vr_9 < vt_1 , vt_2 > fn_4 () {
final vr_9 < vt_1 , vt_2 > vr_10 = fn_5 () . fn_4 () ;
return vr_11 . vr_12 ( vr_10 ) ;
}
@Override
public void clear () {
throw new fn_6 () ;
}
@Override
public vt_2 fn_7 ( final vt_1 vr_13 , final vt_2 vr_14 ) {
throw new fn_6 () ;
}
@Override
public void fn_8 ( final vr_8 < ? extends vt_1 , ? extends vt_2 > vr_15 ) {
throw new fn_6 () ;
}
@Override
public vt_2 remove ( final Object vr_13 ) {
throw new fn_6 () ;
}
@Override
public vr_16 < vr_8 . vr_17 < vt_1 , vt_2 > > fn_9 () {
final vr_16 < vr_8 . vr_17 < vt_1 , vt_2 > > vr_18 = super . fn_9 () ;
return vr_19 . vr_20 ( vr_18 ) ;
}
@Override
public vr_16 < vt_1 > fn_10 () {
final vr_16 < vt_1 > vr_18 = super . fn_10 () ;
return vr_21 . vr_22 ( vr_18 ) ;
}
@Override
public Collection < vt_2 > fn_11 () {
final Collection < vt_2 > vr_23 = super . fn_11 () ;
return vr_24 . vr_25 ( vr_23 ) ; MST[ArgumentPropagationMutator]MSP[N]
}
