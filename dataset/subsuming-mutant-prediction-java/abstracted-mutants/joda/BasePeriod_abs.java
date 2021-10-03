public int fn_1 ( int vr_1 ) {
return 0 ;
}
public tp_1 fn_2 () {
return tp_1 . time () ;
}
protected tp_1 fn_3 ( tp_1 type ) {
return vr_2 . fn_2 ( type ) ;
}
public tp_1 fn_2 () {
return vl_1 ;
}
public int fn_1 ( int vr_1 ) {
return vr_3 [ vr_1 ] ;
}
public tp_2 fn_4 ( tp_3 vr_4 ) {
long vr_5 = vr_2 . vr_6 ( vr_4 ) ;
tp_4 vr_7 = vr_2 . vr_8 ( vr_4 ) ;
long vr_9 = vr_7 . add ( this , vr_5 , 1 ) ;
return new tp_2 ( vr_5 , vr_9 ) ;
}
public tp_2 fn_5 ( tp_3 vr_10 ) {
long vr_9 = vr_2 . vr_6 ( vr_10 ) ;
tp_4 vr_7 = vr_2 . vr_8 ( vr_10 ) ;
long vr_5 = vr_7 . add ( this , vr_9 , - 1 ) ;
return new tp_2 ( vr_5 , vr_9 ) ;
}
private void fn_6 ( tp_5 type , int [] vr_11 , int vr_12 ) {
int vr_1 = indexOf ( type ) ;
if ( vr_1 == - 1 ) {
if ( vr_12 != 0 ) {
throw new IllegalArgumentException (
lr_1 + type . vr_13 () + lr_2 ) ;
}
} else {
vr_11 [ vr_1 ] = vr_12 ;
}
}
protected void fn_7 ( tp_6 vr_14 ) {
if ( vr_14 == null ) {
fn_8 ( new int [ size () ] ) ;
} else {
fn_9 ( vr_14 ) ;
}
}
private void fn_9 ( tp_6 vr_14 ) {
int [] vr_15 = new int [ size () ] ;
for ( int vr_16 = 0 , vr_17 = vr_14 . size () ; vr_16 < vr_17 ; vr_16 ++ ) {
tp_5 type = vr_14 . vr_18 ( vr_16 ) ;
int vr_19 = vr_14 . fn_1 ( vr_16 ) ;
fn_6 ( type , vr_15 , vr_19 ) ;
}
fn_8 ( vr_15 ) ;
}
protected void fn_7 ( int vr_20 , int vr_21 , int vr_22 , int vr_23 ,
int vr_24 , int vr_25 , int vr_26 , int vr_27 ) {
int [] vr_15 = fn_9 ( vr_20 , vr_21 , vr_22 , vr_23 , vr_24 , vr_25 , vr_26 , vr_27 ) ;
fn_8 ( vr_15 ) ;
}
private int [] fn_9 ( int vr_20 , int vr_21 , int vr_22 , int vr_23 ,
int vr_24 , int vr_25 , int vr_26 , int vr_27 ) {
int [] vr_15 = new int [ size () ] ;
fn_6 ( tp_5 . vr_20 () , vr_15 , vr_20 ) ;
fn_6 ( tp_5 . vr_21 () , vr_15 , vr_21 ) ;
fn_6 ( tp_5 . vr_22 () , vr_15 , vr_22 ) ;
fn_6 ( tp_5 . vr_23 () , vr_15 , vr_23 ) ;
fn_6 ( tp_5 . vr_24 () , vr_15 , vr_24 ) ;
fn_6 ( tp_5 . vr_25 () , vr_15 , vr_25 ) ;
fn_6 ( tp_5 . vr_26 () , vr_15 , vr_26 ) ;
fn_6 ( tp_5 . vr_27 () , vr_15 , vr_27 ) ;
return vr_15 ;
}
protected void fn_10 ( tp_5 vr_28 , int vr_19 ) {
fn_11 ( vr_3 , vr_28 , vr_19 ) ;
}
protected void fn_11 ( int [] vr_11 , tp_5 vr_28 , int vr_19 ) {
int vr_1 = indexOf ( vr_28 ) ;
if ( vr_1 == - 1 ) {
if ( vr_19 != 0 || vr_28 == null ) {
throw new IllegalArgumentException (
lr_1 + vr_28 + lr_2 ) ;
}
} else {
vr_11 [ vr_1 ] = vr_19 ;
}
}
protected void fn_12 ( tp_5 vr_28 , int vr_19 ) {
fn_13 ( vr_3 , vr_28 , vr_19 ) ;
}
protected void fn_13 ( int [] vr_11 , tp_5 vr_28 , int vr_19 ) {
int vr_1 = indexOf ( vr_28 ) ;
if ( vr_1 == - 1 ) {
if ( vr_19 != 0 || vr_28 == null ) {
throw new IllegalArgumentException (
lr_1 + vr_28 + lr_2 ) ;
}
} else {
vr_11 [ vr_1 ] = vr_29 . vr_30 ( vr_11 [ vr_1 ] , vr_19 ) ;
}
}
protected void fn_14 ( tp_6 vr_14 ) {
if ( vr_14 != null ) {
fn_8 ( fn_15 ( getValues () , vr_14 ) ) ;
}
}
protected int [] fn_15 ( int [] vr_11 , tp_6 vr_14 ) {
for ( int vr_16 = 0 , vr_17 = vr_14 . size () ; vr_16 < vr_17 ; vr_16 ++ ) {
tp_5 type = vr_14 . vr_18 ( vr_16 ) ;
int vr_19 = vr_14 . fn_1 ( vr_16 ) ;
fn_6 ( type , vr_11 , vr_19 ) ;
}
return vr_11 ;
}
protected void fn_16 ( tp_6 vr_14 ) {
if ( vr_14 != null ) {
fn_8 ( fn_17 ( getValues () , vr_14 ) ) ;
}
}
protected int [] fn_17 ( int [] vr_11 , tp_6 vr_14 ) {
for ( int vr_16 = 0 , vr_17 = vr_14 . size () ; vr_16 < vr_17 ; vr_16 ++ ) {
tp_5 type = vr_14 . vr_18 ( vr_16 ) ;
int vr_19 = vr_14 . fn_1 ( vr_16 ) ;
if ( vr_19 != 0 ) {
int vr_1 = indexOf ( type ) ;
if ( vr_1 == - 1 ) {
throw new IllegalArgumentException (
lr_1 + type . vr_13 () + lr_2 ) ;
} else {
vr_11 [ vr_1 ] = vr_29 . vr_30 ( fn_1 ( vr_1 ) , vr_19 ) ;
}
}
}
return vr_11 ;
}
protected void fn_18 ( int vr_1 , int vr_19 ) {
vr_3 [ vr_1 ] = vr_19 ;
}
protected void fn_8 ( int [] vr_11 ) {
System . vr_31 ( vr_11 , 0 , vr_3 , 0 , vr_3 . length ) ;
}
