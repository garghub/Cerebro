public static vr_1 < ? > fn_1 () {
return vl_1 ;
}
public static vr_1 < String > fn_2 () {
return vl_2 ;
}
public static < vt_1 > vr_1 < vt_1 > fn_3 ( final vr_2 < String , vt_1 > vr_3 ) {
return new vr_4 < vt_1 > ( vr_3 ) ;
}
@Override
public String fn_4 ( final String vr_5 ) {
if ( vr_3 == null ) {
return null ;
}
final Object vr_6 = vr_3 . get ( vr_5 ) ;
if ( vr_6 == null ) {
return null ;
}
return vr_6 . toString () ;
}
@Override
public String fn_4 ( String vr_5 ) {
if ( vr_5 . length () > 0 ) {
try {
return System . getProperty ( vr_5 ) ;
} catch ( tp_1 vr_7 ) {
}
}
return null ;
}
