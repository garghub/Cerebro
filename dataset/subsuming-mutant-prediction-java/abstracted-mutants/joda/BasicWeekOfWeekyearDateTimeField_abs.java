public int get ( long vr_1 ) {
return vr_2 . vr_3 ( vr_1 ) ;
}
public tp_1 fn_1 () {
return vr_2 . vr_4 () ;
}
public long fn_2 ( long vr_1 ) {
return super . fn_2 ( vr_1 + 3 * vr_5 . vr_6 )
- 3 * vr_5 . vr_6 ;
}
public long fn_3 ( long vr_1 ) {
return super . fn_3 ( vr_1 + 3 * vr_5 . vr_6 )
- 3 * vr_5 . vr_6 ;
}
public long fn_4 ( long vr_1 ) {
return super . fn_4 ( vr_1 + 3 * vr_5 . vr_6 ) ;
}
public int fn_5 () {
return 1 ;
}
public int fn_6 () {
return 53 ;
}
public int fn_6 ( long vr_1 ) {
int vr_7 = vr_2 . vr_8 ( vr_1 ) ;
return vr_2 . vr_9 ( vr_7 ) ;
}
public int fn_6 ( tp_2 vr_10 ) {
if ( vr_10 . vr_11 ( vr_12 . vr_7 () ) ) {
int vr_7 = vr_10 . get ( vr_12 . vr_7 () ) ;
return vr_2 . vr_9 ( vr_7 ) ;
}
return 53 ;
}
public int fn_6 ( tp_2 vr_10 , int [] vr_13 ) {
int size = vr_10 . size () ;
for ( int vr_14 = 0 ; vr_14 < size ; vr_14 ++ ) {
if ( vr_10 . vr_15 ( vr_14 ) == vr_12 . vr_7 () ) {
int vr_7 = vr_13 [ vr_14 ] ;
return vr_2 . vr_9 ( vr_7 ) ;
}
}
return 53 ;
}
protected int fn_7 ( long vr_1 , int vr_16 ) {
return vr_16 > 52 ? fn_6 ( vr_1 ) : 52 ;
}
private Object fn_8 () {
return vr_2 . vr_17 () ;
}
