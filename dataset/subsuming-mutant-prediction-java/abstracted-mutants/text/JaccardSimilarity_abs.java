@Override
public Double fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return vr_3 . vr_4 ( fn_2 ( vr_1 , vr_2 ) * 100d ) / 100d ;
}
private Double fn_2 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
final vr_5 < String > vr_6 = new vr_7 <> () ;
final vr_5 < String > vr_8 = new vr_7 <> () ;
boolean vr_9 = false ;
final int vr_10 = vr_1 . length () ;
final int vr_11 = vr_2 . length () ;
if ( vr_10 == 0 || vr_11 == 0 ) {
return 0d ;
}
for ( int vr_12 = 0 ; vr_12 < vr_10 ; vr_12 ++ ) {
vr_8 . add ( String . valueOf ( vr_1 . charAt ( vr_12 ) ) ) ;
for ( int vr_13 = 0 ; vr_13 < vr_11 ; vr_13 ++ ) {
if ( ! vr_9 ) {
vr_8 . add ( String . valueOf ( vr_2 . charAt ( vr_13 ) ) ) ;
}
if ( vr_1 . charAt ( vr_12 ) == vr_2 . charAt ( vr_13 ) ) {
vr_6 . add ( String . valueOf ( vr_1 . charAt ( vr_12 ) ) ) ;
}
}
vr_9 = true ;
}
return Double . valueOf ( vr_6 . size () ) / Double . valueOf ( vr_8 . size () ) ;
}
