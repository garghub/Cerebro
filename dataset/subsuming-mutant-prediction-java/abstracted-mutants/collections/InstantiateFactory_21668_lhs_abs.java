public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Class < vt_1 > vr_2 ,
final Class < ? > [] vr_3 ,
final Object [] args ) {
vr_4 . vr_5 ( vr_2 , lr_1 ) ;
if ( vr_3 == null && args != null
|| vr_3 != null && args == null
|| vr_3 != null && args != null && vr_3 . length != args . length ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( vr_3 == null || vr_3 . length == 0 ) {
return new vr_6 <> ( vr_2 ) ;
}
return new vr_6 <> ( vr_2 , vr_3 , args ) ; MST[ReturnValsMutator]MSP[]
}
private void fn_2 () {
try {
vl_1 = vr_7 . vr_8 ( vl_2 ) ;
} catch ( final tp_1 vr_9 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
@Override
public vt_1 fn_3 () {
if ( vl_1 == null ) {
fn_2 () ;
}
try {
return vl_1 . vr_10 ( vl_3 ) ;
} catch ( final tp_2 vr_9 ) {
throw new fn_4 ( lr_4 , vr_9 ) ;
} catch ( final tp_3 vr_9 ) {
throw new fn_4 ( lr_5 , vr_9 ) ;
} catch ( final tp_4 vr_9 ) {
throw new fn_4 ( lr_6 , vr_9 ) ;
}
}
