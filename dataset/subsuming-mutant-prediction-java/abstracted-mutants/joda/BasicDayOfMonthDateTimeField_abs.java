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
return vr_2 . vr_5 ( vr_1 ) ;
}
public int fn_3 ( tp_2 vr_6 ) {
if ( vr_6 . vr_7 ( vr_8 . vr_9 () ) ) {
int vr_10 = vr_6 . get ( vr_8 . vr_9 () ) ;
if ( vr_6 . vr_7 ( vr_8 . vr_11 () ) ) {
int vr_11 = vr_6 . get ( vr_8 . vr_11 () ) ;
return vr_2 . vr_12 ( vr_11 , vr_10 ) ;
}
return vr_2 . vr_5 ( vr_10 ) ;
}
return fn_3 () ;
}
public int fn_3 ( tp_2 vr_6 , int [] vr_13 ) {
int size = vr_6 . size () ;
for ( int vr_14 = 0 ; vr_14 < size ; vr_14 ++ ) {
if ( vr_6 . vr_15 ( vr_14 ) == vr_8 . vr_9 () ) {
int vr_10 = vr_13 [ vr_14 ] ;
for ( int vr_16 = 0 ; vr_16 < size ; vr_16 ++ ) {
if ( vr_6 . vr_15 ( vr_16 ) == vr_8 . vr_11 () ) {
int vr_11 = vr_13 [ vr_16 ] ;
return vr_2 . vr_12 ( vr_11 , vr_10 ) ;
}
}
return vr_2 . vr_5 ( vr_10 ) ;
}
}
return fn_3 () ;
}
protected int fn_4 ( long vr_1 , int vr_17 ) {
return vr_2 . vr_18 ( vr_1 , vr_17 ) ;
}
@Override
public boolean fn_5 ( long vr_1 ) {
return vr_2 . vr_19 ( vr_1 ) ;
}
private Object fn_6 () {
return vr_2 . vr_20 () ;
}
