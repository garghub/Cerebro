public static String fn_1 ( final String vr_1 ) {
return vr_1 != null ? vr_1 . vr_2 ( vr_3 . vr_4 ) : lr_1 ; MST[NegateConditionalsMutator]MSP[N]
}
public static String fn_2 ( final String vr_1 ) {
return fn_1 ( vr_1 ) . trim () ;
}
public static String fn_2 ( final String vr_1 , boolean vr_5 ) {
return vr_5 ? fn_1 ( vr_1 ) : fn_2 ( vr_1 ) ;
}
