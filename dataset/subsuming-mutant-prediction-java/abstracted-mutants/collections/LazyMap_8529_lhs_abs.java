public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 , final vr_4 < ? extends vt_2 > vr_5 ) {
return new vr_1 <> ( vr_3 , vr_5 ) ;
}
public static < vt_2 , vt_1 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 , final vr_6 < ? super vt_1 , ? extends vt_2 > vr_5 ) {
return new vr_1 <> ( vr_3 , vr_5 ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_7 () ;
out . fn_2 ( vr_3 ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_3 ( final tp_2 vr_8 ) throws IOException , vl_1 {
vr_8 . vr_9 () ;
vr_3 = ( vr_2 < vt_1 , vt_2 > ) vr_8 . fn_3 () ;
}
@Override
public vt_2 get ( final Object vr_10 ) {
if ( vr_3 . vr_11 ( vr_10 ) == false ) { MST[rv.ROR4Mutator]MSP[]
@SuppressWarnings ( lr_1 )
final vt_1 vr_12 = ( vt_1 ) vr_10 ;
final vt_2 vr_13 = vr_5 . vr_14 ( vr_12 ) ;
vr_3 . vr_15 ( vr_12 , vr_13 ) ;
return vr_13 ;
}
return vr_3 . get ( vr_10 ) ;
}
