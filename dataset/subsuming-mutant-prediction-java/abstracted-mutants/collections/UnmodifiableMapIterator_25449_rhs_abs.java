public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 (
final vr_1 < ? extends vt_1 , ? extends vt_2 > iterator ) {
vr_2 . vr_3 ( iterator , lr_1 ) ;
if ( iterator instanceof vl_1 ) { MST[NegateConditionalsMutator]MSP[N]
@SuppressWarnings ( lr_2 )
final vr_1 < vt_1 , vt_2 > vr_4 = ( vr_1 < vt_1 , vt_2 > ) iterator ;
return vr_4 ;
}
return new vr_5 <> ( iterator ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public vt_1 fn_2 () {
return iterator . fn_2 () ;
}
@Override
public vt_1 fn_3 () {
return iterator . fn_3 () ;
}
@Override
public vt_2 fn_4 () {
return iterator . fn_4 () ;
}
@Override
public vt_2 fn_5 ( final vt_2 vr_6 ) {
throw new fn_6 ( lr_3 ) ;
}
@Override
public void remove () {
throw new fn_6 ( lr_4 ) ;
}
