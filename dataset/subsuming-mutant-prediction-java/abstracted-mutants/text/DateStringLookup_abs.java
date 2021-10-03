private String fn_1 ( final long vr_1 , final String vr_2 ) {
tp_1 vr_3 = null ;
if ( vr_2 != null ) {
try {
vr_3 = tp_1 . vr_4 ( vr_2 ) ;
} catch ( final Exception vr_5 ) {
throw vr_6 . vr_2 ( vr_5 , lr_1 , vr_2 ) ;
}
}
if ( vr_3 == null ) {
vr_3 = tp_1 . vr_4 () ;
}
return vr_3 . vr_2 ( new fn_2 ( vr_1 ) ) ;
}
@Override
public String fn_3 ( final String vr_7 ) {
return fn_1 ( System . vr_8 () , vr_7 ) ;
}
