public static tp_1 fn_1 () {
return new tp_1 () ;
}
public static tp_1 fn_2 ( long vr_1 ) {
return new tp_1 ( vr_1 ) ;
}
public static tp_1 fn_3 ( long vr_2 ) {
return new tp_1 ( vr_3 . vr_4 ( vr_2 , 1000 ) ) ;
}
@df_1
public static tp_1 fn_4 ( String vr_5 ) {
return fn_4 ( vr_5 , vr_6 . vr_7 () ) ;
}
public static tp_1 fn_4 ( String vr_5 , tp_2 vr_8 ) {
return vr_8 . vr_9 ( vr_5 ) . fn_5 () ;
}
public tp_1 fn_5 () {
return this ;
}
public tp_1 fn_6 ( long vr_10 ) {
return ( vr_10 == vl_1 ? this : new tp_1 ( vr_10 ) ) ;
}
public tp_1 fn_7 ( long vr_11 , int vr_12 ) {
if ( vr_11 == 0 || vr_12 == 0 ) {
return this ;
}
long vr_13 = fn_8 () . add ( fn_9 () , vr_11 , vr_12 ) ;
return fn_6 ( vr_13 ) ;
}
public tp_1 fn_7 ( tp_3 vr_11 , int vr_12 ) {
if ( vr_11 == null || vr_12 == 0 ) {
return this ;
}
return fn_7 ( vr_11 . fn_9 () , vr_12 ) ;
}
public tp_1 fn_10 ( long vr_14 ) {
return fn_7 ( vr_14 , 1 ) ;
}
public tp_1 fn_10 ( tp_3 vr_14 ) {
return fn_7 ( vr_14 , 1 ) ;
}
public tp_1 fn_11 ( long vr_14 ) {
return fn_7 ( vr_14 , - 1 ) ;
}
public tp_1 fn_11 ( tp_3 vr_14 ) {
return fn_7 ( vr_14 , - 1 ) ;
}
public long fn_9 () {
return vl_1 ;
}
public tp_4 fn_8 () {
return vr_15 . vr_16 () ;
}
public tp_5 fn_12 () {
return new tp_5 ( fn_9 () , vr_15 . vr_17 () ) ;
}
@Deprecated
public tp_5 fn_13 () {
return fn_12 () ;
}
public tp_6 fn_14 () {
return new tp_6 ( fn_9 () , vr_15 . vr_17 () ) ;
}
@Deprecated
public tp_6 fn_15 () {
return fn_14 () ;
}
