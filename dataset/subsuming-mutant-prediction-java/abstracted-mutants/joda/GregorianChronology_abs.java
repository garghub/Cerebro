public static tp_1 fn_1 () {
return vl_1 ;
}
public static tp_1 fn_2 () {
return fn_2 ( vr_1 . vr_2 () , 4 ) ;
}
public static tp_1 fn_2 ( vr_1 vr_3 ) {
return fn_2 ( vr_3 , 4 ) ;
}
public static tp_1 fn_2 ( vr_1 vr_3 , int vr_4 ) {
if ( vr_3 == null ) {
vr_3 = vr_1 . vr_2 () ;
}
tp_1 vr_5 ;
tp_1 [] vr_6 = vr_7 . get ( vr_3 ) ;
if ( vr_6 == null ) {
vr_6 = new tp_1 [ 7 ] ;
tp_1 [] vr_8 = vr_7 . vr_9 ( vr_3 , vr_6 ) ;
if ( vr_8 != null ) {
vr_6 = vr_8 ;
}
}
try {
vr_5 = vr_6 [ vr_4 - 1 ] ;
} catch ( tp_2 vr_10 ) {
throw new IllegalArgumentException
( lr_1 + vr_4 ) ;
}
if ( vr_5 == null ) {
synchronized ( vr_6 ) {
vr_5 = vr_6 [ vr_4 - 1 ] ;
if ( vr_5 == null ) {
if ( vr_3 == vr_1 . vr_11 ) {
vr_5 = new tp_1 ( null , null , vr_4 ) ;
} else {
vr_5 = fn_2 ( vr_1 . vr_11 , vr_4 ) ;
vr_5 = new tp_1
( vr_12 . fn_2 ( vr_5 , vr_3 ) , null , vr_4 ) ;
}
vr_6 [ vr_4 - 1 ] = vr_5 ;
}
}
}
return vr_5 ;
}
private Object fn_3 () {
tp_3 vr_13 = fn_4 () ;
int vr_14 = fn_5 () ;
vr_14 = ( vr_14 == 0 ? 4 : vr_14 ) ;
return vr_13 == null ?
fn_2 ( vr_1 . vr_11 , vr_14 ) :
fn_2 ( vr_13 . vr_15 () , vr_14 ) ;
}
public tp_3 fn_6 () {
return vl_1 ;
}
public tp_3 fn_7 ( vr_1 vr_3 ) {
if ( vr_3 == null ) {
vr_3 = vr_1 . vr_2 () ;
}
if ( vr_3 == vr_15 () ) {
return this ;
}
return fn_2 ( vr_3 ) ;
}
protected void fn_8 ( tp_4 vr_16 ) {
if ( fn_4 () == null ) {
super . fn_8 ( vr_16 ) ;
}
}
boolean fn_9 ( int vr_17 ) {
return ( ( vr_17 & 3 ) == 0 ) && ( ( vr_17 % 100 ) != 0 || ( vr_17 % 400 ) == 0 ) ;
}
long fn_10 ( int vr_17 ) {
int vr_18 = vr_17 / 100 ;
if ( vr_17 < 0 ) {
vr_18 = ( ( vr_17 + 3 ) >> 2 ) - vr_18 + ( ( vr_18 + 3 ) >> 2 ) - 1 ;
} else {
vr_18 = ( vr_17 >> 2 ) - vr_18 + ( vr_18 >> 2 ) ;
if ( fn_9 ( vr_17 ) ) {
vr_18 -- ;
}
}
return ( vr_17 * 365L + ( vr_18 - vl_2 ) ) * vr_19 . vr_20 ;
}
int fn_11 () {
return vl_3 ;
}
int fn_12 () {
return vl_4 ;
}
long fn_13 () {
return vl_5 ;
}
long fn_14 () {
return vl_5 / 2 ;
}
long fn_15 () {
return vl_6 ;
}
long fn_16 () {
return ( 1970L * vl_5 ) / 2 ;
}
