public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , vt_2 > vr_3 ,
final vr_4 < ? super vt_1 > vr_5 ,
final vr_4 < ? super vt_2 > vr_6 ) {
return new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
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
protected void fn_4 ( final vt_1 vr_10 , final vt_2 vr_11 ) {
if ( vr_5 != null && vr_5 . vr_12 ( vr_10 ) == false ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( vr_6 != null && vr_6 . vr_12 ( vr_11 ) == false ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
@Override
protected vt_2 fn_5 ( final vt_2 vr_11 ) {
if ( vr_6 . vr_12 ( vr_11 ) == false ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
return vr_11 ;
}
@Override
protected boolean fn_6 () {
return vr_6 != null ;
}
@Override
public vt_2 fn_7 ( final vt_1 vr_10 , final vt_2 vr_11 ) {
fn_4 ( vr_10 , vr_11 ) ;
return vr_3 . fn_7 ( vr_10 , vr_11 ) ;
}
@Override
public void fn_8 ( final vr_2 < ? extends vt_1 , ? extends vt_2 > vr_13 ) {
for ( final vr_2 . vr_14 < ? extends vt_1 , ? extends vt_2 > vr_15 : vr_13 . vr_16 () ) {
fn_4 ( vr_15 . vr_17 () , vr_15 . vr_18 () ) ; MST[VoidMethodCallMutator]MSP[S]
}
super . fn_8 ( vr_13 ) ;
}
