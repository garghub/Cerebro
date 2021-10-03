public static tp_1 fn_1 ( tp_2 vr_1 ) {
if ( vr_1 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return new tp_1 (
vr_1 . get ( tp_2 . vr_2 ) ,
vr_1 . get ( tp_2 . vr_3 ) ,
vr_1 . get ( tp_2 . vr_4 ) ,
vr_1 . get ( tp_2 . vr_5 )
) ;
}
public static tp_1 fn_2 ( tp_3 vr_6 ) {
if ( vr_6 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return new tp_1 (
vr_6 . vr_7 () ,
vr_6 . vr_8 () ,
vr_6 . vr_9 () ,
( ( (int) ( vr_6 . vr_10 () % 1000 ) ) + 1000 ) % 1000
) ;
}
public static tp_1 fn_3 ( long vr_11 ) {
return fn_3 ( vr_11 , null ) ;
}
public static tp_1 fn_3 ( long vr_11 , tp_4 vr_12 ) {
vr_12 = vr_13 . vr_14 ( vr_12 ) ;
vr_12 = vr_12 . vr_15 () ;
return new tp_1 ( vr_11 , vr_12 ) ;
}
public int size () {
return 4 ;
}
protected tp_5 fn_4 ( int vr_16 , tp_4 vr_12 ) {
switch ( vr_16 ) {
case vr_2 :
return vr_12 . vr_17 () ;
case vl_1 :
return vr_12 . vr_18 () ;
case vl_2 :
return vr_12 . vr_19 () ;
case vl_3 :
return vr_12 . vr_20 () ;
default:
throw new fn_5 ( lr_3 + vr_16 ) ;
}
}
public tp_6 fn_6 ( int vr_16 ) {
return vr_21 [ vr_16 ] ;
}
public tp_6 [] fn_7 () {
return ( tp_6 [] ) vr_21 . vr_22 () ;
}
public tp_1 fn_8 ( tp_4 vr_23 ) {
vr_23 = vr_13 . vr_14 ( vr_23 ) ;
vr_23 = vr_23 . vr_15 () ;
if ( vr_23 == vr_14 () ) {
return this ;
} else {
tp_1 vr_24 = new tp_1 ( this , vr_23 ) ;
vr_23 . vr_25 ( vr_24 , getValues () ) ;
return vr_24 ;
}
}
public tp_1 fn_9 ( tp_6 vr_26 , int vr_27 ) {
int vr_16 = fn_10 ( vr_26 ) ;
if ( vr_27 == fn_11 ( vr_16 ) ) {
return this ;
}
int [] vr_28 = getValues () ;
vr_28 = fn_4 ( vr_16 ) . fn_12 ( this , vr_16 , vr_28 , vr_27 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_13 ( tp_7 vr_26 , int vr_29 ) {
int vr_16 = fn_10 ( vr_26 ) ;
if ( vr_29 == 0 ) {
return this ;
}
int [] vr_28 = getValues () ;
vr_28 = fn_4 ( vr_16 ) . fn_14 ( this , vr_16 , vr_28 , vr_29 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_15 ( tp_8 vr_30 , int vr_31 ) {
if ( vr_30 == null || vr_31 == 0 ) {
return this ;
}
int [] vr_28 = getValues () ;
for ( int vr_32 = 0 ; vr_32 < vr_30 . size () ; vr_32 ++ ) {
tp_7 vr_26 = vr_30 . fn_6 ( vr_32 ) ;
int vr_16 = indexOf ( vr_26 ) ;
if ( vr_16 >= 0 ) {
vr_28 = fn_4 ( vr_16 ) . fn_14 ( this , vr_16 , vr_28 ,
vr_33 . vr_34 ( vr_30 . fn_11 ( vr_32 ) , vr_31 ) ) ;
}
}
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_16 ( tp_8 vr_30 ) {
return fn_15 ( vr_30 , 1 ) ;
}
public tp_1 fn_17 ( int vr_35 ) {
return fn_13 ( tp_7 . vr_35 () , vr_35 ) ;
}
public tp_1 fn_18 ( int vr_36 ) {
return fn_13 ( tp_7 . vr_36 () , vr_36 ) ;
}
public tp_1 fn_19 ( int vr_37 ) {
return fn_13 ( tp_7 . vr_37 () , vr_37 ) ;
}
public tp_1 fn_20 ( int vr_38 ) {
return fn_13 ( tp_7 . vr_38 () , vr_38 ) ;
}
public tp_1 fn_21 ( tp_8 vr_30 ) {
return fn_15 ( vr_30 , - 1 ) ;
}
public tp_1 fn_22 ( int vr_35 ) {
return fn_13 ( tp_7 . vr_35 () , vr_33 . vr_39 ( vr_35 ) ) ;
}
public tp_1 fn_23 ( int vr_36 ) {
return fn_13 ( tp_7 . vr_36 () , vr_33 . vr_39 ( vr_36 ) ) ;
}
public tp_1 fn_24 ( int vr_37 ) {
return fn_13 ( tp_7 . vr_37 () , vr_33 . vr_39 ( vr_37 ) ) ;
}
public tp_1 fn_25 ( int vr_38 ) {
return fn_13 ( tp_7 . vr_38 () , vr_33 . vr_39 ( vr_38 ) ) ;
}
public tp_9 fn_26 ( tp_6 type ) {
return new tp_9 ( this , fn_10 ( type ) ) ;
}
public LocalTime fn_27 () {
return new LocalTime ( fn_28 () , fn_29 () ,
fn_30 () , fn_31 () , vr_14 () ) ;
}
public tp_10 fn_32 () {
return fn_32 ( null ) ;
}
public tp_10 fn_32 ( tp_11 vr_40 ) {
tp_4 vr_12 = vr_14 () . fn_33 ( vr_40 ) ;
long vr_41 = vr_13 . vr_42 () ;
long vr_43 = vr_12 . fn_12 ( this , vr_41 ) ;
return new tp_10 ( vr_43 , vr_12 ) ;
}
public int fn_28 () {
return fn_11 ( vr_2 ) ;
}
public int fn_29 () {
return fn_11 ( vl_1 ) ;
}
public int fn_30 () {
return fn_11 ( vl_2 ) ;
}
public int fn_31 () {
return fn_11 ( vl_3 ) ;
}
public tp_1 fn_34 ( int vr_44 ) {
int [] vr_28 = getValues () ;
vr_28 = vr_14 () . vr_17 () . fn_12 ( this , vr_2 , vr_28 , vr_44 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_35 ( int vr_45 ) {
int [] vr_28 = getValues () ;
vr_28 = vr_14 () . vr_18 () . fn_12 ( this , vl_1 , vr_28 , vr_45 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_36 ( int vr_46 ) {
int [] vr_28 = getValues () ;
vr_28 = vr_14 () . vr_19 () . fn_12 ( this , vl_2 , vr_28 , vr_46 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_37 ( int vr_38 ) {
int [] vr_28 = getValues () ;
vr_28 = vr_14 () . vr_20 () . fn_12 ( this , vl_3 , vr_28 , vr_38 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_9 vr_17 () {
return new tp_9 ( this , vr_2 ) ;
}
public tp_9 vr_18 () {
return new tp_9 ( this , vl_1 ) ;
}
public tp_9 vr_19 () {
return new tp_9 ( this , vl_2 ) ;
}
public tp_9 vr_20 () {
return new tp_9 ( this , vl_3 ) ;
}
public String toString () {
return vr_47 . vr_48 () . fn_38 ( this ) ;
}
public tp_5 fn_4 () {
return vr_49 . fn_4 ( vl_4 ) ;
}
protected tp_12 fn_39 () {
return vr_49 ;
}
public tp_1 fn_40 () {
return vr_49 ;
}
public int get () {
return vr_49 . fn_11 ( vl_4 ) ;
}
public tp_1 fn_41 ( int vr_50 ) {
int [] vr_28 = vr_49 . getValues () ;
vr_28 = fn_4 () . fn_14 ( vr_49 , vl_4 , vr_28 , vr_50 ) ;
return new tp_1 ( vr_49 , vr_28 ) ;
}
public tp_1 fn_42 ( int vr_50 ) {
int [] vr_28 = vr_49 . getValues () ;
vr_28 = fn_4 () . add ( vr_49 , vl_4 , vr_28 , vr_50 ) ;
return new tp_1 ( vr_49 , vr_28 ) ;
}
public tp_1 fn_43 ( int vr_50 ) {
int [] vr_28 = vr_49 . getValues () ;
vr_28 = fn_4 () . fn_44 ( vr_49 , vl_4 , vr_28 , vr_50 ) ;
return new tp_1 ( vr_49 , vr_28 ) ;
}
public tp_1 fn_45 ( int vr_27 ) {
int [] vr_28 = vr_49 . getValues () ;
vr_28 = fn_4 () . fn_12 ( vr_49 , vl_4 , vr_28 , vr_27 ) ;
return new tp_1 ( vr_49 , vr_28 ) ;
}
public tp_1 fn_45 ( String vr_51 , tp_13 vr_52 ) {
int [] vr_28 = vr_49 . getValues () ;
vr_28 = fn_4 () . fn_12 ( vr_49 , vl_4 , vr_28 , vr_51 , vr_52 ) ;
return new tp_1 ( vr_49 , vr_28 ) ;
}
public tp_1 fn_45 ( String vr_51 ) {
return fn_45 ( vr_51 , null ) ;
}
public tp_1 fn_46 () {
return fn_45 ( fn_47 () ) ;
}
public tp_1 fn_48 () {
return fn_45 ( fn_49 () ) ;
}
