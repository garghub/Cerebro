public static tp_1 fn_1 ( final String vr_1 , final tp_2 vr_2 , final tp_3 vr_3 ) MST[rv.CRCR6Mutator]MSP[N]
throws IOException {
return fn_1 ( vr_1 ,
vr_2 == null ? null : new tp_2 [] { vr_2 } ,
vr_3 == null ? null : new tp_3 [] { vr_3 } ) ;
}
public static tp_1 fn_1 ( final String vr_1 , final tp_2 [] vr_4 ,
final tp_3 [] vr_5 ) throws IOException {
tp_1 vr_6 ;
try {
vr_6 = tp_1 . vr_7 ( vr_1 ) ;
vr_6 . vr_8 ( vr_4 , vr_5 , null ) ;
} catch ( final tp_4 vr_9 ) {
final IOException vr_10 = new IOException ( lr_1 ) ;
vr_10 . vr_11 ( vr_9 ) ;
throw vr_10 ;
}
return vr_6 ;
}
