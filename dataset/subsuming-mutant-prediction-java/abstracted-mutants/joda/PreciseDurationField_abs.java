public final boolean fn_1 () {
return true ;
}
public final long fn_2 () {
return vl_1 ;
}
public long fn_3 ( long vr_1 , long vr_2 ) {
return vr_1 / vl_1 ;
}
public long fn_4 ( int vr_3 , long vr_2 ) {
return vr_3 * vl_1 ;
}
public long fn_4 ( long vr_3 , long vr_2 ) {
return vr_4 . vr_5 ( vr_3 , vl_1 ) ;
}
public long add ( long vr_2 , int vr_3 ) {
long vr_6 = vr_3 * vl_1 ;
return vr_4 . vr_7 ( vr_2 , vr_6 ) ;
}
public long add ( long vr_2 , long vr_3 ) {
long vr_6 = vr_4 . vr_5 ( vr_3 , vl_1 ) ;
return vr_4 . vr_7 ( vr_2 , vr_6 ) ;
}
public long fn_5 ( long vr_8 , long vr_9 ) {
long vr_10 = vr_4 . vr_11 ( vr_8 , vr_9 ) ;
return vr_10 / vl_1 ;
}
public boolean equals ( Object vr_12 ) {
if ( this == vr_12 ) {
return true ;
} else if ( vr_12 instanceof vl_2 ) {
vl_2 vr_13 = ( vl_2 ) vr_12 ;
return ( getType () == vr_13 . getType () ) && ( vl_1 == vr_13 . vl_1 ) ;
}
return false ;
}
public int fn_6 () {
long vr_14 = vl_1 ;
int vr_15 = (int) ( vr_14 ^ ( vr_14 >>> 32 ) ) ;
vr_15 += getType () . fn_6 () ;
return vr_15 ;
}
