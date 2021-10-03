public long fn_1 ( Object object ) {
return ( ( ( vl_1 ) object ) ) . fn_2 () ;
}
public void fn_3 ( tp_1 vr_1 , Object object , tp_2 vr_2 ) {
vl_1 vr_3 = ( vl_1 ) object ;
vr_2 = ( vr_2 != null ? vr_2 : vr_4 . vr_5 ( vr_3 ) ) ;
long vr_6 = vr_3 . vr_7 () ;
long vr_8 = vr_3 . vr_9 () ;
int [] vr_10 = vr_2 . get ( vr_1 , vr_6 , vr_8 ) ;
for ( int vr_11 = 0 ; vr_11 < vr_10 . length ; vr_11 ++ ) {
vr_1 . vr_12 ( vr_11 , vr_10 [ vr_11 ] ) ;
}
}
public boolean fn_4 ( Object object , tp_2 vr_2 ) {
return true ;
}
public void fn_3 ( tp_3 vr_13 , Object object , tp_2 vr_2 ) {
vl_1 vr_14 = ( vl_1 ) object ;
vr_13 . vr_15 ( vr_14 ) ;
if ( vr_2 != null ) {
vr_13 . vr_16 ( vr_2 ) ;
} else {
vr_13 . vr_16 ( vr_14 . vr_17 () ) ;
}
}
public Class < ? > fn_5 () {
return vl_1 . class ;
}
