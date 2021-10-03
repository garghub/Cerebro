public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vt_1 object ) {
if ( object == null ) {
return vr_2 . vr_3 () ;
}
return new vr_4 <> ( object ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vt_1 object , final vr_5 < vt_1 > vr_6 ) {
if ( object == null ) {
return vr_2 . vr_3 () ;
}
return new vr_4 <> ( object , vr_6 ) ;
}
@Override
public boolean fn_2 ( final vt_1 object ) {
if ( vr_6 != null ) {
return vr_6 . vr_7 ( vl_1 , object ) ;
}
return vl_1 . equals ( object ) ; MST[NonVoidMethodCallMutator]MSP[S]
}
public Object fn_3 () {
return vl_1 ;
}
