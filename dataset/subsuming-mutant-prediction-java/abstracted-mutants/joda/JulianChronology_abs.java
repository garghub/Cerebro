static int fn_1 ( int vr_1 ) {
if ( vr_1 <= 0 ) {
if ( vr_1 == 0 ) {
throw new fn_2
( vr_2 . vr_1 () , Integer . valueOf ( vr_1 ) , null , null ) ;
}
vr_1 ++ ;
}
return vr_1 ;
}
public static tp_1 fn_3 () {
return vl_1 ;
}
public static tp_1 fn_4 () {
return fn_4 ( vr_3 . vr_4 () , 4 ) ;
}
public static tp_1 fn_4 ( vr_3 vr_5 ) {
return fn_4 ( vr_5 , 4 ) ;
}
public static tp_1 fn_4 ( vr_3 vr_5 , int vr_6 ) {
if ( vr_5 == null ) {
vr_5 = vr_3 . vr_4 () ;
}
tp_1 vr_7 ;
tp_1 [] vr_8 = vr_9 . get ( vr_5 ) ;
if ( vr_8 == null ) {
vr_8 = new tp_1 [ 7 ] ;
tp_1 [] vr_10 = vr_9 . vr_11 ( vr_5 , vr_8 ) ;
if ( vr_10 != null ) {
vr_8 = vr_10 ;
}
}
try {
vr_7 = vr_8 [ vr_6 - 1 ] ;
} catch ( tp_2 vr_12 ) {
throw new IllegalArgumentException
( lr_1 + vr_6 ) ;
}
if ( vr_7 == null ) {
synchronized ( vr_8 ) {
vr_7 = vr_8 [ vr_6 - 1 ] ;
if ( vr_7 == null ) {
if ( vr_5 == vr_3 . vr_13 ) {
vr_7 = new tp_1 ( null , null , vr_6 ) ;
} else {
vr_7 = fn_4 ( vr_3 . vr_13 , vr_6 ) ;
vr_7 = new tp_1
( vr_14 . fn_4 ( vr_7 , vr_5 ) , null , vr_6 ) ;
}
vr_8 [ vr_6 - 1 ] = vr_7 ;
}
}
}
return vr_7 ;
}
private Object fn_5 () {
tp_3 vr_15 = fn_6 () ;
int vr_16 = fn_7 () ;
vr_16 = ( vr_16 == 0 ? 4 : vr_16 ) ;
return vr_15 == null ?
fn_4 ( vr_3 . vr_13 , vr_16 ) :
fn_4 ( vr_15 . vr_17 () , vr_16 ) ;
}
public tp_3 fn_8 () {
return vl_1 ;
}
public tp_3 fn_9 ( vr_3 vr_5 ) {
if ( vr_5 == null ) {
vr_5 = vr_3 . vr_4 () ;
}
if ( vr_5 == vr_17 () ) {
return this ;
}
return fn_4 ( vr_5 ) ;
}
long fn_10 ( int vr_1 , int vr_18 , int vr_19 )
throws IllegalArgumentException
{
return super . fn_10 ( fn_1 ( vr_1 ) , vr_18 , vr_19 ) ;
}
boolean fn_11 ( int vr_1 ) {
return ( vr_1 & 3 ) == 0 ;
}
long fn_12 ( int vr_1 ) {
int vr_20 = vr_1 - 1968 ;
int vr_21 ;
if ( vr_20 <= 0 ) {
vr_21 = ( vr_20 + 3 ) >> 2 ;
} else {
vr_21 = vr_20 >> 2 ;
if ( ! fn_11 ( vr_1 ) ) {
vr_21 ++ ;
}
}
long vr_22 = ( vr_20 * 365L + vr_21 ) * ( long ) vr_23 . vr_24 ;
return vr_22 - ( 366L + 352 ) * vr_23 . vr_24 ;
}
int fn_13 () {
return vl_2 ;
}
int fn_14 () {
return vl_3 ;
}
long fn_15 () {
return vl_4 ;
}
long fn_16 () {
return vl_4 / 2 ;
}
long fn_17 () {
return vl_5 ;
}
long fn_18 () {
return ( 1969L * vl_4 + 352L * vr_23 . vr_24 ) / 2 ;
}
protected void fn_19 ( tp_4 vr_25 ) {
if ( fn_6 () == null ) {
super . fn_19 ( vr_25 ) ;
vr_25 . vr_1 = new fn_20 ( this , vr_25 . vr_1 ) ;
vr_25 . vr_26 = new fn_20 ( this , vr_25 . vr_26 ) ;
}
}
