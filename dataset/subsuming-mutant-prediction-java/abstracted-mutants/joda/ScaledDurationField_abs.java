public int fn_1 ( long vr_1 ) {
return fn_2 () . fn_1 ( vr_1 ) / vl_1 ;
}
public long fn_3 ( long vr_1 ) {
return fn_2 () . fn_3 ( vr_1 ) / vl_1 ;
}
public int fn_1 ( long vr_1 , long vr_2 ) {
return fn_2 () . fn_1 ( vr_1 , vr_2 ) / vl_1 ;
}
public long fn_3 ( long vr_1 , long vr_2 ) {
return fn_2 () . fn_3 ( vr_1 , vr_2 ) / vl_1 ;
}
public long fn_4 ( int vr_3 ) {
long vr_4 = ( ( long ) vr_3 ) * ( ( long ) vl_1 ) ;
return fn_2 () . fn_4 ( vr_4 ) ;
}
public long fn_4 ( long vr_3 ) {
long vr_4 = vr_5 . vr_6 ( vr_3 , vl_1 ) ;
return fn_2 () . fn_4 ( vr_4 ) ;
}
public long fn_4 ( int vr_3 , long vr_2 ) {
long vr_4 = ( ( long ) vr_3 ) * ( ( long ) vl_1 ) ;
return fn_2 () . fn_4 ( vr_4 , vr_2 ) ;
}
public long fn_4 ( long vr_3 , long vr_2 ) {
long vr_4 = vr_5 . vr_6 ( vr_3 , vl_1 ) ;
return fn_2 () . fn_4 ( vr_4 , vr_2 ) ;
}
public long add ( long vr_2 , int vr_3 ) {
long vr_4 = ( ( long ) vr_3 ) * ( ( long ) vl_1 ) ;
return fn_2 () . add ( vr_2 , vr_4 ) ;
}
public long add ( long vr_2 , long vr_3 ) {
long vr_4 = vr_5 . vr_6 ( vr_3 , vl_1 ) ;
return fn_2 () . add ( vr_2 , vr_4 ) ;
}
public int fn_5 ( long vr_7 , long vr_8 ) {
return fn_2 () . fn_5 ( vr_7 , vr_8 ) / vl_1 ;
}
public long fn_6 ( long vr_7 , long vr_8 ) {
return fn_2 () . fn_6 ( vr_7 , vr_8 ) / vl_1 ;
}
public long fn_7 () {
return fn_2 () . fn_7 () * vl_1 ;
}
public int fn_8 () {
return vl_1 ;
}
public boolean equals ( Object vr_9 ) {
if ( this == vr_9 ) {
return true ;
} else if ( vr_9 instanceof vl_2 ) {
vl_2 vr_10 = ( vl_2 ) vr_9 ;
return ( fn_2 () . equals ( vr_10 . fn_2 () ) ) &&
( getType () == vr_10 . getType () ) &&
( vl_1 == vr_10 . vl_1 ) ;
}
return false ;
}
public int fn_9 () {
long vr_11 = vl_1 ;
int vr_12 = (int) ( vr_11 ^ ( vr_11 >>> 32 ) ) ;
vr_12 += getType () . fn_9 () ;
vr_12 += fn_2 () . fn_9 () ;
return vr_12 ;
}
