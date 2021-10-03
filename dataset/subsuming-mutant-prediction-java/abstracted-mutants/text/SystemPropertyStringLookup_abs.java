@Override
public String fn_1 ( final String vr_1 ) {
try {
return System . getProperty ( vr_1 ) ;
} catch ( final tp_1 | tp_2 | IllegalArgumentException vr_2 ) {
return null ;
}
}
