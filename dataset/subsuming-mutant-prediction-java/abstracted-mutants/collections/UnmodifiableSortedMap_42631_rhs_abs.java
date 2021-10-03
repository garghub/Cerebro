public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_1 < vt_1 , ? extends vt_2 > vr_2 ) {
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
public void clear () {
throw new fn_4 () ;
}
@Override
public vt_2 fn_5 ( final vt_1 vr_9 , final vt_2 vr_10 ) {
throw new fn_4 () ;
}
@Override
public void fn_6 ( final vr_8 < ? extends vt_1 , ? extends vt_2 > vr_11 ) {
throw new fn_4 () ;
}
@Override
public vt_2 remove ( final Object vr_9 ) {
throw new fn_4 () ;
}
@Override
public vr_12 < vr_8 . vr_13 < vt_1 , vt_2 > > fn_7 () {
return vr_14 . vr_15 ( super . fn_7 () ) ;
}
@Override
public vr_12 < vt_1 > fn_8 () {
return vr_16 . vr_17 ( super . fn_8 () ) ;
}
@Override
public Collection < vt_2 > fn_9 () {
return vr_18 . vr_19 ( super . fn_9 () ) ;
}
@Override
public vt_1 fn_10 () {
return fn_11 () . fn_10 () ;
}
@Override
public vt_1 fn_12 () {
return fn_11 () . fn_12 () ;
}
@Override
public vr_20 < ? super vt_1 > fn_13 () {
return fn_11 () . fn_13 () ;
}
@Override
public vr_1 < vt_1 , vt_2 > fn_14 ( final vt_1 vr_21 , final vt_1 vr_22 ) {
return new vr_4 <> ( fn_11 () . fn_14 ( vr_21 , vr_22 ) ) ;
}
@Override
public vr_1 < vt_1 , vt_2 > fn_15 ( final vt_1 vr_22 ) {
return new vr_4 <> ( fn_11 () . fn_15 ( vr_22 ) ) ; MST[experimental.NakedReceiverMutator]MSP[N]
}
@Override
public vr_1 < vt_1 , vt_2 > fn_16 ( final vt_1 vr_21 ) {
return new vr_4 <> ( fn_11 () . fn_16 ( vr_21 ) ) ;
}
