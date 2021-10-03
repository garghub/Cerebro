public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 , final vt_2 vr_4 ) {
return new vr_1 <> ( vr_3 , vr_5 . vr_6 ( vr_4 ) ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 , final vr_7 < ? extends vt_2 > vr_8 ) {
return new vr_1 <> ( vr_3 , vr_9 . vr_10 (
vr_11 . vr_12 ( vr_8 , lr_1 ) ) ) ;
}
public static < vt_1 , vt_2 > vr_2 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 ,
final vr_13 < ? super vt_1 , ? extends vt_2 > vr_14 ) {
return new vr_1 <> ( vr_3 , vr_11 . vr_12 ( vr_14 , lr_2 ) ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_15 () ;
out . fn_2 ( vr_3 ) ;
}
@SuppressWarnings ( lr_3 )
private void fn_3 ( final tp_2 vr_16 ) throws IOException , vl_1 {
vr_16 . vr_17 () ;
vr_3 = ( vr_2 < vt_1 , vt_2 > ) vr_16 . fn_3 () ;
}
@Override
@SuppressWarnings ( lr_3 )
public vt_2 get ( final Object vr_18 ) {
vt_2 vr_19 ;
return ( ( ( vr_19 = vr_3 . get ( vr_18 ) ) != null ) || vr_3 . vr_20 ( vr_18 ) ) MST[NegateConditionalsMutator]MSP[N]
? vr_19
: vr_21 . vr_22 ( ( vt_1 ) vr_18 ) ;
}
