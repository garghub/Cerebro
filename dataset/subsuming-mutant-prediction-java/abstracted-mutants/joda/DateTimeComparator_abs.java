public static tp_1 fn_1 () {
return vl_1 ;
}
public static tp_1 fn_1 ( tp_2 vr_1 ) {
return fn_1 ( vr_1 , null ) ;
}
public static tp_1 fn_1 ( tp_2 vr_1 , tp_2 vr_2 ) {
if ( vr_1 == null && vr_2 == null ) {
return vl_1 ;
}
if ( vr_1 == tp_2 . vr_3 () && vr_2 == null ) {
return vl_2 ;
}
if ( vr_1 == null && vr_2 == tp_2 . vr_3 () ) {
return vl_3 ;
}
return new tp_1 ( vr_1 , vr_2 ) ;
}
public static tp_1 fn_2 () {
return vl_2 ;
}
public static tp_1 fn_3 () {
return vl_3 ;
}
public tp_2 fn_4 () {
return vl_4 ;
}
public tp_2 fn_5 () {
return vl_5 ;
}
public int fn_6 ( Object vr_4 , Object vr_5 ) {
tp_3 vr_6 = vr_7 . fn_1 () . fn_7 ( vr_4 ) ;
tp_4 vr_8 = vr_6 . vr_9 ( vr_4 , ( tp_4 ) null ) ;
long vr_10 = vr_6 . vr_11 ( vr_4 , vr_8 ) ;
if ( vr_4 == vr_5 ) {
return 0 ;
}
vr_6 = vr_7 . fn_1 () . fn_7 ( vr_5 ) ;
tp_4 vr_12 = vr_6 . vr_9 ( vr_5 , ( tp_4 ) null ) ;
long vr_13 = vr_6 . vr_11 ( vr_5 , vr_12 ) ;
if ( vl_4 != null ) {
vr_10 = vl_4 . vr_14 ( vr_8 ) . fn_8 ( vr_10 ) ;
vr_13 = vl_4 . vr_14 ( vr_12 ) . fn_8 ( vr_13 ) ;
}
if ( vl_5 != null ) {
vr_10 = vl_5 . vr_14 ( vr_8 ) . fn_9 ( vr_10 ) ;
vr_13 = vl_5 . vr_14 ( vr_12 ) . fn_9 ( vr_13 ) ;
}
if ( vr_10 < vr_13 ) {
return - 1 ;
} else if ( vr_10 > vr_13 ) {
return 1 ;
} else {
return 0 ;
}
}
private Object fn_10 () {
return fn_1 ( vl_4 , vl_5 ) ;
}
public boolean equals ( Object object ) {
if ( object instanceof tp_1 ) {
tp_1 vr_15 = ( tp_1 ) object ;
return ( vl_4 == vr_15 . fn_4 () ||
( vl_4 != null && vl_4 . equals ( vr_15 . fn_4 () ) ) ) &&
( vl_5 == vr_15 . fn_5 () ||
( vl_5 != null && vl_5 . equals ( vr_15 . fn_5 () ) ) ) ;
}
return false ;
}
public int fn_11 () {
return ( vl_4 == null ? 0 : vl_4 . fn_11 () ) +
( 123 * ( vl_5 == null ? 0 : vl_5 . fn_11 () ) ) ;
}
public String toString () {
if ( vl_4 == vl_5 ) {
return lr_1
+ ( vl_4 == null ? lr_2 : vl_4 . vr_16 () )
+ lr_3 ;
} else {
return lr_1
+ ( vl_4 == null ? lr_2 : vl_4 . vr_16 () )
+ lr_4
+ ( vl_5 == null ? lr_2 : vl_5 . vr_16 () )
+ lr_3 ;
}
}
