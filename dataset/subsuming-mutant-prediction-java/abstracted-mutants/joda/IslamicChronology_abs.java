public static tp_1 fn_1 () {
return vl_1 ;
}
public static tp_1 fn_2 () {
return fn_2 ( vr_1 . vr_2 () , vl_2 ) ;
}
public static tp_1 fn_2 ( vr_1 vr_3 ) {
return fn_2 ( vr_3 , vl_2 ) ;
}
public static tp_1 fn_2 ( vr_1 vr_3 , tp_2 vr_4 ) {
if ( vr_3 == null ) {
vr_3 = vr_1 . vr_2 () ;
}
tp_1 vr_5 ;
tp_1 [] vr_6 = vr_7 . get ( vr_3 ) ;
if ( vr_6 == null ) {
vr_6 = new tp_1 [ 4 ] ;
tp_1 [] vr_8 = vr_7 . vr_9 ( vr_3 , vr_6 ) ;
if ( vr_8 != null ) {
vr_6 = vr_8 ;
}
}
vr_5 = vr_6 [ vr_4 . vr_10 ] ;
if ( vr_5 == null ) {
synchronized ( vr_6 ) {
vr_5 = vr_6 [ vr_4 . vr_10 ] ;
if ( vr_5 == null ) {
if ( vr_3 == vr_1 . vr_11 ) {
vr_5 = new tp_1 ( null , null , vr_4 ) ;
tp_3 vr_12 = new tp_3 ( 1 , 1 , 1 , 0 , 0 , 0 , 0 , vr_5 ) ;
vr_5 = new tp_1 (
vr_13 . fn_2 ( vr_5 , vr_12 , null ) ,
null , vr_4 ) ;
} else {
vr_5 = fn_2 ( vr_1 . vr_11 , vr_4 ) ;
vr_5 = new tp_1
( vr_14 . fn_2 ( vr_5 , vr_3 ) , null , vr_4 ) ;
}
vr_6 [ vr_4 . vr_10 ] = vr_5 ;
}
}
}
return vr_5 ;
}
private Object fn_3 () {
tp_4 vr_15 = fn_4 () ;
return vr_15 == null ? fn_1 () : fn_2 ( vr_15 . vr_16 () ) ;
}
public tp_2 fn_5 () {
return vl_3 ;
}
public tp_4 fn_6 () {
return vl_1 ;
}
public tp_4 fn_7 ( vr_1 vr_3 ) {
if ( vr_3 == null ) {
vr_3 = vr_1 . vr_2 () ;
}
if ( vr_3 == vr_16 () ) {
return this ;
}
return fn_2 ( vr_3 ) ;
}
public boolean equals ( Object vr_17 ) {
if ( this == vr_17 ) {
return true ;
}
if ( vr_17 instanceof tp_1 ) {
tp_1 vr_5 = ( tp_1 ) vr_17 ;
return fn_5 () . vr_10 == vr_5 . fn_5 () . vr_10 &&
super . equals ( vr_17 ) ;
}
return false ;
}
public int fn_8 () {
return super . fn_8 () * 13 + fn_5 () . fn_8 () ;
}
int fn_9 ( long vr_18 ) {
long vr_19 = vr_18 - vl_4 ;
long vr_20 = vr_19 / vl_5 ;
long vr_21 = vr_19 % vl_5 ;
int vr_22 = (int) ( ( vr_20 * vl_6 ) + 1L ) ;
long vr_23 = ( fn_10 ( vr_22 ) ? vl_7 : vl_8 ) ;
while ( vr_21 >= vr_23 ) {
vr_21 -= vr_23 ;
vr_23 = ( fn_10 ( ++ vr_22 ) ? vl_7 : vl_8 ) ;
}
return vr_22 ;
}
long fn_11 ( long vr_18 , int vr_22 ) {
int vr_24 = fn_9 ( vr_18 ) ;
int vr_25 = fn_12 ( vr_18 , vr_24 ) ;
int vr_26 = fn_13 ( vr_18 ) ;
if ( vr_25 > 354 && ! fn_10 ( vr_22 ) ) {
vr_25 -- ;
}
vr_18 = fn_14 ( vr_22 , 1 , vr_25 ) ;
vr_18 += vr_26 ;
return vr_18 ;
}
long fn_15 ( long vr_27 , long vr_28 ) {
int vr_29 = fn_9 ( vr_27 ) ;
int vr_30 = fn_9 ( vr_28 ) ;
long vr_31 = vr_27 - fn_16 ( vr_29 ) ;
long vr_32 = vr_28 - fn_16 ( vr_30 ) ;
int vr_33 = vr_29 - vr_30 ;
if ( vr_31 < vr_32 ) {
vr_33 -- ;
}
return vr_33 ;
}
long fn_17 ( int vr_22 , int vr_34 ) {
if ( -- vr_34 % 2 == 1 ) {
vr_34 /= 2 ;
return vr_34 * vl_9 + vl_10 ;
} else {
vr_34 /= 2 ;
return vr_34 * vl_9 ;
}
}
int fn_18 ( long vr_35 ) {
int vr_36 = fn_12 ( vr_35 ) - 1 ;
if ( vr_36 == 354 ) {
return 30 ;
}
return ( vr_36 % vl_11 ) % vl_12 + 1 ;
}
boolean fn_10 ( int vr_22 ) {
return vl_3 . fn_10 ( vr_22 ) ;
}
int fn_19 () {
return 355 ;
}
int fn_20 ( int vr_22 ) {
return fn_10 ( vr_22 ) ? 355 : 354 ;
}
int fn_21 ( int vr_22 , int vr_34 ) {
if ( vr_34 == 12 && fn_10 ( vr_22 ) ) {
return vl_12 ;
}
return ( -- vr_34 % 2 == 0 ? vl_12 : vl_13 ) ;
}
int fn_22 () {
return vl_12 ;
}
int fn_22 ( int vr_34 ) {
if ( vr_34 == 12 ) {
return vl_12 ;
}
return ( -- vr_34 % 2 == 0 ? vl_12 : vl_13 ) ;
}
int fn_23 ( long vr_35 , int vr_22 ) {
int vr_37 = (int) ( ( vr_35 - fn_16 ( vr_22 ) ) / vr_38 . vr_39 ) ;
if ( vr_37 == 354 ) {
return 12 ;
}
return ( ( vr_37 * 2 ) / vl_11 ) + 1 ;
}
long fn_24 () {
return vl_14 ;
}
long fn_25 () {
return vl_14 / 2 ;
}
long fn_26 () {
return vl_15 ;
}
long fn_27 ( int vr_22 ) {
if ( vr_22 > vl_16 ) {
throw new fn_28 ( lr_1 + vr_22 + lr_2 + vl_16 ) ;
}
if ( vr_22 < vl_17 ) {
throw new fn_28 ( lr_3 + vr_22 + lr_4 + vl_17 ) ;
}
vr_22 -- ;
long vr_40 = vr_22 / vl_6 ;
long vr_35 = vl_4 + vr_40 * vl_5 ;
int vr_21 = ( vr_22 % vl_6 ) + 1 ;
for ( int vr_41 = 1 ; vr_41 < vr_21 ; vr_41 ++ ) {
vr_35 += ( fn_10 ( vr_41 ) ? vl_7 : vl_8 ) ;
}
return vr_35 ;
}
int fn_29 () {
return 1 ;
}
int fn_30 () {
return vl_16 ;
}
long fn_31 () {
return ( - vl_4 ) / 2 ;
}
protected void fn_32 ( tp_5 vr_42 ) {
if ( fn_4 () == null ) {
super . fn_32 ( vr_42 ) ;
vr_42 . vr_43 = vl_18 ;
vr_42 . vr_44 = new fn_33 ( this , 12 ) ;
vr_42 . vr_45 = vr_42 . vr_44 . vr_46 () ;
}
}
boolean fn_10 ( int vr_22 ) {
int vr_47 = 1 << ( vr_22 % 30 ) ;
return ( ( vl_19 & vr_47 ) > 0 ) ;
}
private Object fn_3 () {
switch ( vr_10 ) {
case 0 :
return vl_20 ;
case 1 :
return vl_2 ;
case 2 :
return vl_21 ;
case 3 :
return vl_22 ;
default:
return this ;
}
}
@Override
public boolean equals ( Object vr_17 ) {
if ( vr_17 instanceof tp_2 ) {
return vr_10 == ( ( tp_2 ) vr_17 ) . vr_10 ;
}
return false ;
}
@Override
public int fn_8 () {
return vr_10 ;
}
