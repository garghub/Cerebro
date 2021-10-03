public long fn_1 ( Object object ) {
return ( ( vl_1 ) object ) . fn_2 () ;
}
public void fn_3 ( tp_1 vr_1 , Object object , tp_2 vr_2 ) {
vl_1 vr_3 = ( vl_1 ) object ;
vr_2 = vr_4 . vr_5 ( vr_2 ) ;
long vr_6 = vr_3 . fn_2 () ;
int [] vr_7 = vr_2 . get ( vr_1 , vr_6 ) ;
for ( int vr_8 = 0 ; vr_8 < vr_7 . length ; vr_8 ++ ) {
vr_1 . vr_9 ( vr_8 , vr_7 [ vr_8 ] ) ;
}
}
public Class < ? > fn_4 () {
return vl_1 . class ;
}
