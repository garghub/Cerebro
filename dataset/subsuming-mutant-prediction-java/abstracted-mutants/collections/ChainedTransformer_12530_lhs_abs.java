public static < vt_1 > vr_1 < vt_1 , vt_1 > fn_1 ( final vr_1 < ? super vt_1 , ? extends vt_1 > ... vr_2 ) {
vr_3 . vr_4 ( vr_2 ) ;
if ( vr_2 . length == 0 ) {
return vr_5 . <vt_1 > fn_2 () ;
}
return new vr_6 <> ( vr_2 ) ;
}
public static < vt_1 > vr_1 < vt_1 , vt_1 > fn_1 (
final Collection < ? extends vr_1 < ? super vt_1 , ? extends vt_1 > > vr_2 ) {
vr_7 . vr_8 ( vr_2 , lr_1 ) ;
if ( vr_2 . size () == 0 ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
return vr_5 . <vt_1 > fn_2 () ;
}
final vr_1 < vt_1 , vt_1 > [] vr_9 = vr_2 . toArray ( new vr_1 [ vr_2 . size () ] ) ;
vr_3 . vr_4 ( vr_9 ) ;
return new vr_6 <> ( false , vr_9 ) ;
}
@Override
public vt_1 fn_3 ( vt_1 object ) {
for ( final vr_1 < ? super vt_1 , ? extends vt_1 > vr_10 : vl_1 ) {
object = vr_10 . fn_3 ( object ) ;
}
return object ;
}
public vr_1 < ? super vt_1 , ? extends vt_1 > [] fn_4 () {
return vr_3 . <vt_1 , vt_1 > fn_5 ( vl_1 ) ;
}
