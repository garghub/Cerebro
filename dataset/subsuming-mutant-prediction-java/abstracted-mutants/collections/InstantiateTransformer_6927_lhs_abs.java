public static < vt_1 > vr_1 < Class < ? extends vt_1 > , vt_1 > fn_1 () {
return vl_1 ;
}
public static < vt_1 > vr_1 < Class < ? extends vt_1 > , vt_1 > fn_1 ( final Class < ? > [] vr_2 ,
final Object [] args ) {
if ( ( ( vr_2 == null ) && ( args != null ) ) MST[rv.ROR2Mutator]MSP[]
|| ( ( vr_2 != null ) && ( args == null ) )
|| ( ( vr_2 != null ) && ( args != null ) && ( vr_2 . length != args . length ) ) ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_2 == null || vr_2 . length == 0 ) {
return new vr_3 <> () ;
}
return new vr_3 <> ( vr_2 , args ) ;
}
@Override
public vt_1 fn_2 ( final Class < ? extends vt_1 > vr_4 ) {
try {
if ( vr_4 == null ) {
throw new fn_3 (
lr_2 ) ;
}
final vr_5 < ? extends vt_1 > vr_6 = vr_4 . vr_7 ( vl_2 ) ;
return vr_6 . vr_8 ( vl_3 ) ;
} catch ( final tp_1 vr_9 ) {
throw new fn_3 ( lr_3 ) ;
} catch ( final tp_2 vr_9 ) {
throw new fn_3 ( lr_4 , vr_9 ) ;
} catch ( final tp_3 vr_9 ) {
throw new fn_3 ( lr_5 , vr_9 ) ;
} catch ( final tp_4 vr_9 ) {
throw new fn_3 ( lr_6 , vr_9 ) ;
}
}
