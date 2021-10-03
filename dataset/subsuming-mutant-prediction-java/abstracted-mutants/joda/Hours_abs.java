public static tp_1 fn_1 ( int fn_1 ) {
switch ( fn_1 ) {
case 0 :
return vl_1 ;
case 1 :
return vl_2 ;
case 2 :
return vl_3 ;
case 3 :
return vl_4 ;
case 4 :
return vl_5 ;
case 5 :
return vl_6 ;
case 6 :
return vl_7 ;
case 7 :
return vl_8 ;
case 8 :
return vl_9 ;
case Integer . vr_1 :
return vr_1 ;
case Integer . vr_2 :
return vr_2 ;
default:
return new tp_1 ( fn_1 ) ;
}
}
public static tp_1 fn_2 ( tp_2 vr_3 , tp_2 vr_4 ) {
int vr_5 = vr_6 . vr_7 ( vr_3 , vr_4 , vr_8 . fn_1 () ) ;
return tp_1 . fn_1 ( vr_5 ) ;
}
public static tp_1 fn_2 ( tp_3 vr_3 , tp_3 vr_4 ) {
if ( vr_3 instanceof LocalTime && vr_4 instanceof LocalTime ) {
tp_4 vr_9 = vr_10 . vr_11 ( vr_3 . vr_11 () ) ;
int fn_1 = vr_9 . fn_1 () . fn_3 (
( ( LocalTime ) vr_4 ) . fn_4 () , ( ( LocalTime ) vr_3 ) . fn_4 () ) ;
return tp_1 . fn_1 ( fn_1 ) ;
}
int vr_5 = vr_6 . vr_7 ( vr_3 , vr_4 , vl_1 ) ;
return tp_1 . fn_1 ( vr_5 ) ;
}
public static tp_1 fn_5 ( tp_5 vr_12 ) {
if ( vr_12 == null ) {
return tp_1 . vl_1 ;
}
int vr_5 = vr_6 . vr_7 ( vr_12 . vr_13 () , vr_12 . vr_14 () , vr_8 . fn_1 () ) ;
return tp_1 . fn_1 ( vr_5 ) ;
}
public static tp_1 fn_6 ( tp_6 vr_15 ) {
int vr_5 = vr_6 . vr_16 ( vr_15 , vr_17 . vr_18 ) ;
return tp_1 . fn_1 ( vr_5 ) ;
}
@df_1
public static tp_1 fn_7 ( String vr_19 ) {
if ( vr_19 == null ) {
return tp_1 . vl_1 ;
}
tp_7 vr_20 = vr_21 . vr_22 ( vr_19 ) ;
return tp_1 . fn_1 ( vr_20 . vr_23 () ) ;
}
private Object fn_8 () {
return tp_1 . fn_1 ( fn_9 () ) ;
}
public vr_8 fn_10 () {
return vr_8 . fn_1 () ;
}
public tp_8 fn_11 () {
return tp_8 . fn_1 () ;
}
public tp_9 fn_12 () {
return tp_9 . vr_24 ( fn_9 () / vr_17 . vr_25 ) ;
}
public tp_10 fn_13 () {
return tp_10 . vr_26 ( fn_9 () / vr_17 . vr_27 ) ;
}
public tp_11 fn_14 () {
return tp_11 . vr_28 ( vr_29 . vr_30 ( fn_9 () , vr_17 . vr_31 ) ) ;
}
public tp_12 fn_15 () {
return tp_12 . vr_32 ( vr_29 . vr_30 ( fn_9 () , vr_17 . vr_33 ) ) ;
}
public tp_13 fn_16 () {
long fn_1 = fn_9 () ;
return new tp_13 ( fn_1 * vr_17 . vr_18 ) ;
}
public int vr_23 () {
return fn_9 () ;
}
public tp_1 fn_17 ( int fn_1 ) {
if ( fn_1 == 0 ) {
return this ;
}
return tp_1 . fn_1 ( vr_29 . vr_34 ( fn_9 () , fn_1 ) ) ;
}
public tp_1 fn_17 ( tp_1 fn_1 ) {
if ( fn_1 == null ) {
return this ;
}
return fn_17 ( fn_1 . fn_9 () ) ;
}
public tp_1 fn_18 ( int fn_1 ) {
return fn_17 ( vr_29 . vr_35 ( fn_1 ) ) ;
}
public tp_1 fn_18 ( tp_1 fn_1 ) {
if ( fn_1 == null ) {
return this ;
}
return fn_18 ( fn_1 . fn_9 () ) ;
}
public tp_1 fn_19 ( int vr_36 ) {
return tp_1 . fn_1 ( vr_29 . vr_30 ( fn_9 () , vr_36 ) ) ;
}
public tp_1 fn_20 ( int vr_37 ) {
if ( vr_37 == 1 ) {
return this ;
}
return tp_1 . fn_1 ( fn_9 () / vr_37 ) ;
}
public tp_1 fn_21 () {
return tp_1 . fn_1 ( vr_29 . vr_35 ( fn_9 () ) ) ;
}
public boolean fn_22 ( tp_1 vr_38 ) {
if ( vr_38 == null ) {
return fn_9 () > 0 ;
}
return fn_9 () > vr_38 . fn_9 () ;
}
public boolean fn_23 ( tp_1 vr_38 ) {
if ( vr_38 == null ) {
return fn_9 () < 0 ;
}
return fn_9 () < vr_38 . fn_9 () ;
}
@ToString
public String toString () {
return lr_1 + String . valueOf ( fn_9 () ) + lr_2 ;
}
