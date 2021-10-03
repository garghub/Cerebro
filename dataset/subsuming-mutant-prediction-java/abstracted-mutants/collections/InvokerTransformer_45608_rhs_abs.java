public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final String vr_2 ) {
return new vr_3 <> ( vr_4 . vr_5 ( vr_2 , lr_1 ) ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final String vr_2 , final Class < ? > [] vr_6 ,
final Object [] args ) {
vr_4 . vr_5 ( vr_2 , lr_1 ) ;
if ( ( ( vr_6 == null ) && ( args != null ) )
|| ( ( vr_6 != null ) && ( args == null ) )
|| ( ( vr_6 != null ) && ( args != null ) && ( vr_6 . length != args . length ) ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( vr_6 == null || vr_6 . length == 0 ) {
return new vr_3 <> ( vr_2 ) ;
}
return new vr_3 <> ( vr_2 , vr_6 , args ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public vt_2 fn_2 ( final Object vr_7 ) {
if ( vr_7 == null ) { MST[NegateConditionalsMutator]MSP[N]
return null ;
}
try {
final Class < ? > vr_8 = vr_7 . getClass () ;
final tp_1 vr_9 = vr_8 . vr_10 ( vl_1 , vl_2 ) ;
return ( vt_2 ) vr_9 . vr_11 ( vr_7 , vl_3 ) ;
} catch ( final tp_2 vr_12 ) {
throw new fn_3 ( lr_4 + vl_1 + lr_5 +
vr_7 . getClass () + lr_6 ) ;
} catch ( final tp_3 vr_12 ) {
throw new fn_3 ( lr_4 + vl_1 + lr_5 +
vr_7 . getClass () + lr_7 ) ;
} catch ( final tp_4 vr_12 ) {
throw new fn_3 ( lr_4 + vl_1 + lr_5 +
vr_7 . getClass () + lr_8 , vr_12 ) ;
}
}
