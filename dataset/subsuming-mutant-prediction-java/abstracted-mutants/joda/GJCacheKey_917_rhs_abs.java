@Override
public int fn_1 () {
final int vr_1 = 31 ;
int vr_2 = 1 ;
vr_2 = vr_1 * vr_2 + ( ( vl_1 == null ) ? 0 : vl_1 . fn_1 () ) ;
vr_2 = vr_1 * vr_2 + vl_2 ;
vr_2 = vr_1 * vr_2 + ( ( vl_3 == null ) ? 0 : vl_3 . fn_1 () ) ;
return vr_2 ;
}
@Override
public boolean equals ( Object vr_3 ) {
if ( this == vr_3 ) {
return true ; MST[rv.CRCR6Mutator]MSP[S]
}
if ( vr_3 == null ) {
return false ;
}
if ( ! ( vr_3 instanceof vl_4 ) ) {
return false ;
}
vl_4 vr_4 = ( vl_4 ) vr_3 ;
if ( vl_1 == null ) {
if ( vr_4 . vl_1 != null ) {
return false ;
}
} else if ( ! vl_1 . equals ( vr_4 . vl_1 ) ) {
return false ;
}
if ( vl_2 != vr_4 . vl_2 ) {
return false ;
}
if ( vl_3 == null ) {
if ( vr_4 . vl_3 != null ) {
return false ;
}
} else if ( ! vl_3 . equals ( vr_4 . vl_3 ) ) {
return false ;
}
return true ;
}
