@Override
public tp_1 fn_1 () {
if ( vl_1 != null ) {
return vl_1 ;
}
return super . fn_1 () ;
}
public int get ( long vr_1 ) {
int vr_2 = fn_2 () . get ( vr_1 ) ;
if ( vr_2 >= 0 ) {
return vr_2 / vl_2 ;
} else {
return ( ( vr_2 + 1 ) / vl_2 ) - 1 ;
}
}
public long add ( long vr_1 , int vr_3 ) {
return fn_2 () . add ( vr_1 , vr_3 * vl_2 ) ;
}
public long add ( long vr_1 , long vr_3 ) {
return fn_2 () . add ( vr_1 , vr_3 * vl_2 ) ;
}
public long fn_3 ( long vr_1 , int vr_3 ) {
return fn_4 ( vr_1 , vr_4 . vr_5 ( get ( vr_1 ) , vr_3 , vl_3 , vl_4 ) ) ;
}
public int fn_5 ( long vr_6 , long vr_7 ) {
return fn_2 () . fn_5 ( vr_6 , vr_7 ) / vl_2 ;
}
public long fn_6 ( long vr_6 , long vr_7 ) {
return fn_2 () . fn_6 ( vr_6 , vr_7 ) / vl_2 ;
}
public long fn_4 ( long vr_1 , int vr_2 ) {
vr_4 . vr_8 ( this , vr_2 , vl_3 , vl_4 ) ;
int vr_9 = fn_7 ( fn_2 () . get ( vr_1 ) ) ;
return fn_2 () . fn_4 ( vr_1 , vr_2 * vl_2 + vr_9 ) ;
}
public tp_1 fn_8 () {
return vl_5 ;
}
public int fn_9 () {
return vl_3 ;
}
public int fn_10 () {
return vl_4 ;
}
public long fn_11 ( long vr_1 ) {
tp_2 vr_10 = fn_2 () ;
return vr_10 . fn_11 ( vr_10 . fn_4 ( vr_1 , get ( vr_1 ) * vl_2 ) ) ;
}
public long vr_9 ( long vr_1 ) {
return fn_4 ( vr_1 , get ( fn_2 () . vr_9 ( vr_1 ) ) ) ;
}
public int fn_12 () {
return vl_2 ;
}
private int fn_7 ( int vr_2 ) {
if ( vr_2 >= 0 ) {
return vr_2 % vl_2 ;
} else {
return ( vl_2 - 1 ) + ( ( vr_2 + 1 ) % vl_2 ) ;
}
}
