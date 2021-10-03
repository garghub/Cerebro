static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_2 < String , vt_1 > vr_3 ) {
return new vr_1 <> ( vr_3 ) ;
}
vr_2 < String , vt_2 > fn_2 () {
return vr_3 ;
}
@Override
public String fn_3 ( final String vr_4 ) {
if ( vr_3 == null ) {
return null ;
}
final vt_2 vr_5 ;
try {
vr_5 = vr_3 . get ( vr_4 ) ;
} catch ( final tp_1 vr_6 ) {
return null ;
}
return vr_5 != null ? vr_5 . toString () : null ;
}
@Override
public String toString () {
return getClass () . fn_4 () + lr_1 + vr_3 + lr_2 ;
}
