public static < vt_1 , vt_2 , vt_3 , vt_4 > vr_1 < vt_1 , vt_2 , vt_3 , vt_4 > fn_1 ( final vr_2 < vt_2 , vt_4 > vr_3 ,
final vr_4 < ? super vt_1 , ? extends vt_2 > vr_5 ,
final vr_4 < ? super vt_3 , ? extends vt_4 > vr_6 ) {
return new vr_1 <> ( vr_3 , vr_5 , vr_6 ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_7 () ;
out . fn_2 ( fn_3 () ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_4 ( final tp_2 vr_8 ) throws IOException , vl_1 {
vr_8 . vr_9 () ;
vr_3 = ( vr_2 < vt_2 , vt_4 > ) vr_8 . fn_4 () ; MST[experimental.MemberVariableMutator]MSP[S]
}
protected vt_2 fn_5 ( final vt_1 object ) {
return vr_5 . vr_10 ( object ) ;
}
protected vt_4 fn_6 ( final vt_3 object ) {
return vr_6 . vr_10 ( object ) ;
}
@SuppressWarnings ( lr_1 )
protected vr_2 < vt_2 , vt_4 > fn_7 ( final vr_2 < ? extends vt_1 , ? extends vt_3 > vr_3 ) {
if ( vr_3 . isEmpty () ) {
return ( vr_2 < vt_2 , vt_4 > ) vr_3 ;
}
final vr_2 < vt_2 , vt_4 > vr_11 = new vr_12 <> ( vr_3 . size () ) ;
for ( final vr_2 . vr_13 < ? extends vt_1 , ? extends vt_3 > vr_14 : vr_3 . vr_15 () ) {
vr_11 . vr_16 ( fn_5 ( vr_14 . vr_17 () ) , fn_6 ( vr_14 . vr_18 () ) ) ;
}
return vr_11 ;
}
protected vt_4 fn_8 ( final vt_3 vr_19 ) {
return vr_6 . vr_10 ( vr_19 ) ;
}
@Override
public vt_4 vr_16 ( final vt_1 vr_20 , final vt_3 vr_19 ) {
return fn_3 () . vr_16 ( fn_5 ( vr_20 ) , fn_6 ( vr_19 ) ) ;
}
@Override
public void fn_9 ( final vr_2 < ? extends vt_1 , ? extends vt_3 > vr_21 ) {
fn_3 () . fn_9 ( fn_7 ( vr_21 ) ) ;
}
@Override
public void clear () {
fn_3 () . clear () ;
}
