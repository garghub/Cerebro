public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < ? super vt_1 > ... vr_2 ) {
fn_2 ( vr_2 ) ;
if ( vr_2 . length == 0 ) {
return fn_3 () ;
}
if ( vr_2 . length == 1 ) {
return fn_4 ( vr_2 [ 0 ] ) ;
}
return new vr_3 <> ( vr_4 . vr_5 ( vr_2 ) ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Collection < ? extends vr_1 < ? super vt_1 > > vr_2 ) {
final vr_1 < ? super vt_1 > [] vr_6 = fn_2 ( vr_2 ) ;
if ( vr_6 . length == 0 ) {
return fn_3 () ;
}
if ( vr_6 . length == 1 ) {
return fn_4 ( vr_6 [ 0 ] ) ; MST[NonVoidMethodCallMutator]MSP[N]
}
return new vr_3 <> ( vr_6 ) ;
}
@Override
public boolean fn_5 ( final vt_1 object ) {
for ( final vr_1 < ? super vt_1 > vr_7 : vl_1 ) {
if ( ! vr_7 . fn_5 ( object ) ) {
return false ;
}
}
return true ;
}
