public int get ( long vr_1 ) {
return vr_2 . vr_3 ( vr_1 ) ;
}
public tp_1 fn_1 () {
return vr_2 . vr_4 () ;
}
public int fn_2 () {
return 1 ;
}
public int fn_3 () {
return vr_2 . vr_5 () ;
}
public int fn_3 ( long vr_1 ) {
int vr_6 = vr_2 . vr_7 ( vr_1 ) ;
return vr_2 . vr_8 ( vr_6 ) ;
}
public int fn_3 ( tp_2 vr_9 ) {
if ( vr_9 . vr_10 ( vr_11 . vr_6 () ) ) {
int vr_6 = vr_9 . get ( vr_11 . vr_6 () ) ;
return vr_2 . vr_8 ( vr_6 ) ;
}
return vr_2 . vr_5 () ;
}
public int fn_3 ( tp_2 vr_9 , int [] vr_12 ) {
int size = vr_9 . size () ;
for ( int vr_13 = 0 ; vr_13 < size ; vr_13 ++ ) {
if ( vr_9 . vr_14 ( vr_13 ) == vr_11 . vr_6 () ) {
int vr_6 = vr_12 [ vr_13 ] ;
return vr_2 . vr_8 ( vr_6 ) ;
}
}
return vr_2 . vr_5 () ;
}
protected int fn_4 ( long vr_1 , int vr_15 ) {
int vr_16 = vr_2 . vr_5 () - 1 ;
return ( vr_15 > vr_16 || vr_15 < 1 ) ? fn_3 ( vr_1 ) : vr_16 ;
}
@Override
public boolean fn_5 ( long vr_1 ) {
return vr_2 . vr_17 ( vr_1 ) ;
}
private Object fn_6 () {
return vr_2 . vr_18 () ;
}
