static tp_1 fn_1 ( tp_2 vr_1 ) {
if ( vr_1 instanceof vl_1 ) {
return ( ( vl_1 ) vr_1 ) . fn_2 () ;
}
if ( vr_1 instanceof tp_1 ) {
return ( tp_1 ) vr_1 ;
}
if ( vr_1 == null ) {
return null ;
}
return new fn_3 ( vr_1 ) ;
}
public int fn_4 () {
return vr_1 . fn_4 () ;
}
public int fn_5 ( tp_3 vr_2 , tp_4 vr_3 , int vr_4 ) {
return vr_1 . fn_5 ( vr_2 , vr_3 , vr_4 ) ;
}
public int fn_5 ( tp_3 vr_2 , String vr_3 , int vr_4 ) {
return vr_1 . fn_5 ( vr_2 , vr_3 , vr_4 ) ;
}
@Override
public boolean equals ( Object vr_5 ) {
if ( vr_5 == this ) {
return true ;
}
if ( vr_5 instanceof fn_3 ) {
fn_3 vr_6 = ( fn_3 ) vr_5 ;
return vr_1 . equals ( vr_6 . vr_1 ) ;
}
return false ;
}
