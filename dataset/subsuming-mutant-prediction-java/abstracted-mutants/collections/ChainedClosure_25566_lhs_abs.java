public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < ? super vt_1 > ... vr_2 ) {
vr_3 . vr_4 ( vr_2 ) ;
if ( vr_2 . length == 0 ) {
return vr_5 . <vt_1 > fn_2 () ;
}
return new vr_6 <> ( vr_2 ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Collection < ? extends vr_1 < ? super vt_1 > > vr_2 ) {
vr_7 . vr_8 ( vr_2 , lr_2 ) ;
if ( vr_2 . size () == 0 ) {
return vr_5 . <vt_1 > fn_2 () ;
}
final vr_1 < ? super vt_1 > [] vr_9 = new vr_1 [ vr_2 . size () ] ; MST[NonVoidMethodCallMutator]MSP[]
int vr_10 = 0 ;
for ( final vr_1 < ? super vt_1 > vr_11 : vr_2 ) {
vr_9 [ vr_10 ++ ] = vr_11 ;
}
vr_3 . vr_4 ( vr_9 ) ;
return new vr_6 <> ( false , vr_9 ) ;
}
@Override
public void fn_3 ( final vt_1 vr_12 ) {
for ( final vr_1 < ? super vt_1 > vr_13 : vl_1 ) {
vr_13 . fn_3 ( vr_12 ) ;
}
}
public vr_1 < ? super vt_1 > [] fn_4 () {
return vr_3 . <vt_1 > fn_5 ( vl_1 ) ;
}
