public static tp_1 fn_1 () {
return vl_1 ;
}
public static tp_1 fn_2 () {
return fn_2 ( vr_1 . vr_2 () ) ;
}
public static tp_1 fn_2 ( vr_1 vr_3 ) {
if ( vr_3 == null ) {
vr_3 = vr_1 . vr_2 () ;
}
tp_1 vr_4 = vr_5 . get ( vr_3 ) ;
if ( vr_4 == null ) {
vr_4 = new tp_1 ( vr_6 . fn_2 ( vl_1 , vr_3 ) ) ;
tp_1 vr_7 = vr_5 . vr_8 ( vr_3 , vr_4 ) ;
if ( vr_7 != null ) {
vr_4 = vr_7 ;
}
}
return vr_4 ;
}
public tp_2 fn_3 () {
return vl_1 ;
}
public tp_2 fn_4 ( vr_1 vr_3 ) {
if ( vr_3 == null ) {
vr_3 = vr_1 . vr_2 () ;
}
if ( vr_3 == fn_5 () ) {
return this ;
}
return fn_2 ( vr_3 ) ;
}
public String toString () {
String vr_9 = lr_1 ;
vr_1 vr_3 = fn_5 () ;
if ( vr_3 != null ) {
vr_9 = vr_9 + '[' + vr_3 . vr_10 () + ']' ;
}
return vr_9 ;
}
protected void fn_6 ( tp_3 vr_11 ) {
if ( fn_7 () . fn_5 () == vr_1 . vr_12 ) {
vr_11 . vr_13 = new fn_8 (
vr_14 . vr_15 , vr_16 . vr_13 () , 100 ) ;
vr_11 . vr_17 = vr_11 . vr_13 . vr_18 () ;
vr_11 . vr_19 = new fn_9 (
( fn_8 ) vr_11 . vr_13 , vr_16 . vr_19 () ) ;
vr_11 . vr_20 = new fn_9 (
( fn_8 ) vr_11 . vr_13 , vr_11 . vr_21 , vr_16 . vr_20 () ) ;
}
}
public boolean equals ( Object vr_22 ) {
if ( this == vr_22 ) {
return true ;
}
if ( vr_22 instanceof tp_1 ) {
tp_1 vr_4 = ( tp_1 ) vr_22 ;
return fn_5 () . equals ( vr_4 . fn_5 () ) ;
}
return false ;
}
public int fn_10 () {
return lr_2 . fn_10 () * 11 + fn_5 () . fn_10 () ;
}
private Object fn_11 () {
return new fn_12 ( fn_5 () ) ;
}
private Object fn_13 () {
return tp_1 . fn_2 ( vl_2 ) ;
}
private void fn_14 ( tp_4 out ) throws IOException {
out . fn_14 ( vl_2 ) ;
}
private void fn_15 ( tp_5 vr_23 )
throws IOException , vl_3
{
vl_2 = ( vr_1 ) vr_23 . fn_15 () ;
}
