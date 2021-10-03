public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 () {
return vl_1 ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_2 ( final vt_2 vr_2 ) {
if ( vr_2 == null ) {
return fn_1 () ;
}
return new vr_3 <> ( vr_2 ) ;
}
@Override
public vt_2 fn_3 ( final vt_1 vr_4 ) {
return vl_2 ;
}
public vt_2 fn_4 () {
return vl_2 ;
}
@Override
public boolean equals ( final Object vr_5 ) {
if ( vr_5 == this ) {
return true ;
}
if ( vr_5 instanceof vr_3 == false ) {
return false ;
}
final Object vr_6 = ( ( vr_3 < ? , ? > ) vr_5 ) . fn_4 () ;
return vr_6 == fn_4 () || vr_6 != null && vr_6 . equals ( fn_4 () ) ; MST[rv.CRCR6Mutator]MSP[S]
}
@Override
public int fn_5 () {
int vr_7 = lr_1 . fn_5 () << 2 ;
if ( fn_4 () != null ) {
vr_7 |= fn_4 () . fn_5 () ;
}
return vr_7 ;
}
