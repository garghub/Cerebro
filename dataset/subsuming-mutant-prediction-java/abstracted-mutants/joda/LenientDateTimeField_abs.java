public static tp_1 fn_1 ( tp_1 vr_1 , tp_2 vr_2 ) {
if ( vr_1 == null ) {
return null ;
}
if ( vr_1 instanceof vl_1 ) {
vr_1 = ( ( vl_1 ) vr_1 ) . fn_2 () ;
}
if ( vr_1 . vr_3 () ) {
return vr_1 ;
}
return new fn_3 ( vr_1 , vr_2 ) ;
}
public final boolean vr_3 () {
return true ;
}
public long fn_4 ( long vr_4 , int vr_5 ) {
long vr_6 = vr_7 . vr_8 () . fn_5 ( vr_4 ) ;
long vr_9 = vr_10 . vr_11 ( vr_5 , get ( vr_4 ) ) ;
vr_6 = getType () . fn_6 ( vr_7 . vr_12 () ) . add ( vr_6 , vr_9 ) ;
return vr_7 . vr_8 () . fn_7 ( vr_6 , false , vr_4 ) ;
}
