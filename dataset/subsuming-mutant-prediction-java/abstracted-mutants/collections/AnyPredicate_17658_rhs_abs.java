@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < ? super vt_1 > ... vr_2 ) {
vr_3 . vr_4 ( vr_2 ) ;
if ( vr_2 . length == 0 ) {
return vr_5 . <vt_1 > fn_2 () ;
}
if ( vr_2 . length == 1 ) {
return ( vr_1 < vt_1 > ) vr_2 [ 0 ] ;
}
return new vr_6 <> ( vr_3 . vr_7 ( vr_2 ) ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Collection < ? extends vr_1 < ? super vt_1 > > vr_2 ) {
final vr_1 < ? super vt_1 > [] vr_8 = vr_3 . vr_4 ( vr_2 ) ;
if ( vr_8 . length == 0 ) {
return vr_5 . <vt_1 > fn_2 () ;
}
if ( vr_8 . length == 1 ) { MST[rv.CRCR4Mutator]MSP[S]
return ( vr_1 < vt_1 > ) vr_8 [ 0 ] ;
}
return new vr_6 <> ( vr_8 ) ;
}
@Override
public boolean fn_3 ( final vt_1 object ) {
for ( final vr_1 < ? super vt_1 > vr_9 : vl_1 ) {
if ( vr_9 . fn_3 ( object ) ) {
return true ;
}
}
return false ;
}
