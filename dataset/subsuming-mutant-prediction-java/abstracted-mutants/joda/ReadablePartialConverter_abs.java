public tp_1 fn_1 ( Object object , tp_2 vr_1 ) {
return fn_1 ( object , ( tp_1 ) null ) . fn_2 ( vr_1 ) ;
}
public tp_1 fn_1 ( Object object , tp_1 vr_2 ) {
if ( vr_2 == null ) {
vr_2 = ( ( vl_1 ) object ) . fn_1 () ;
vr_2 = vr_3 . fn_1 ( vr_2 ) ;
}
return vr_2 ;
}
public int [] fn_3 ( vl_1 vr_4 , Object object , tp_1 vr_2 ) {
vl_1 vr_5 = ( vl_1 ) object ;
int size = vr_4 . size () ;
int [] vr_6 = new int [ size ] ;
for ( int vr_7 = 0 ; vr_7 < size ; vr_7 ++ ) {
vr_6 [ vr_7 ] = vr_5 . get ( vr_4 . vr_8 ( vr_7 ) ) ;
}
vr_2 . vr_9 ( vr_4 , vr_6 ) ;
return vr_6 ;
}
public Class < ? > fn_4 () {
return vl_1 . class ;
}
