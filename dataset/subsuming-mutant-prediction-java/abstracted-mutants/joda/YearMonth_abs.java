public static tp_1 fn_1 () {
return new tp_1 () ;
}
public static tp_1 fn_1 ( tp_2 vr_1 ) {
if ( vr_1 == null ) {
throw new fn_2 ( lr_1 ) ;
}
return new tp_1 ( vr_1 ) ;
}
public static tp_1 fn_1 ( tp_3 vr_2 ) {
if ( vr_2 == null ) {
throw new fn_2 ( lr_2 ) ;
}
return new tp_1 ( vr_2 ) ;
}
@df_1
public static tp_1 fn_3 ( String vr_3 ) {
return fn_3 ( vr_3 , vr_4 . vr_5 () ) ;
}
public static tp_1 fn_3 ( String vr_3 , tp_4 vr_6 ) {
tp_5 vr_7 = vr_6 . vr_8 ( vr_3 ) ;
return new tp_1 ( vr_7 . vr_9 () , vr_7 . vr_10 () ) ;
}
public static tp_1 fn_4 ( tp_6 vr_11 ) {
if ( vr_11 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new tp_1 ( vr_11 . get ( tp_6 . vr_12 ) , vr_11 . get ( tp_6 . vr_13 ) + 1 ) ;
}
@SuppressWarnings ( lr_4 )
public static tp_1 fn_5 ( tp_7 vr_7 ) {
if ( vr_7 == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
return new tp_1 ( vr_7 . vr_9 () + 1900 , vr_7 . vr_14 () + 1 ) ;
}
private Object fn_6 () {
if ( tp_2 . vr_15 . equals ( fn_7 () . fn_8 () ) == false ) {
return new tp_1 ( this , fn_7 () . fn_9 () ) ;
}
return this ;
}
public int size () {
return 2 ;
}
protected tp_8 fn_10 ( int vr_16 , tp_3 vr_17 ) {
switch ( vr_16 ) {
case vr_12 :
return vr_17 . vr_18 () ;
case vl_1 :
return vr_17 . vr_19 () ;
default:
throw new fn_11 ( lr_6 + vr_16 ) ;
}
}
public tp_9 fn_12 ( int vr_16 ) {
return vr_20 [ vr_16 ] ;
}
public tp_9 [] fn_13 () {
return ( tp_9 [] ) vr_20 . vr_21 () ;
}
public tp_1 fn_14 ( tp_3 vr_22 ) {
vr_22 = vr_23 . fn_7 ( vr_22 ) ;
vr_22 = vr_22 . fn_9 () ;
if ( vr_22 == fn_7 () ) {
return this ;
} else {
tp_1 vr_24 = new tp_1 ( this , vr_22 ) ;
vr_22 . vr_25 ( vr_24 , getValues () ) ;
return vr_24 ;
}
}
public tp_1 fn_15 ( tp_9 vr_26 , int vr_27 ) {
int vr_16 = fn_16 ( vr_26 ) ;
if ( vr_27 == fn_17 ( vr_16 ) ) {
return this ;
}
int [] vr_28 = getValues () ;
vr_28 = fn_10 ( vr_16 ) . fn_18 ( this , vr_16 , vr_28 , vr_27 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_19 ( tp_10 vr_26 , int vr_29 ) {
int vr_16 = fn_16 ( vr_26 ) ;
if ( vr_29 == 0 ) {
return this ;
}
int [] vr_28 = getValues () ;
vr_28 = fn_10 ( vr_16 ) . add ( this , vr_16 , vr_28 , vr_29 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_20 ( tp_11 vr_30 , int vr_31 ) {
if ( vr_30 == null || vr_31 == 0 ) {
return this ;
}
int [] vr_28 = getValues () ;
for ( int vr_32 = 0 ; vr_32 < vr_30 . size () ; vr_32 ++ ) {
tp_10 vr_26 = vr_30 . fn_12 ( vr_32 ) ;
int vr_16 = indexOf ( vr_26 ) ;
if ( vr_16 >= 0 ) {
vr_28 = fn_10 ( vr_16 ) . add ( this , vr_16 , vr_28 ,
vr_33 . vr_34 ( vr_30 . fn_17 ( vr_32 ) , vr_31 ) ) ;
}
}
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_21 ( tp_11 vr_30 ) {
return fn_20 ( vr_30 , 1 ) ;
}
public tp_1 fn_22 ( int vr_35 ) {
return fn_19 ( tp_10 . vr_35 () , vr_35 ) ;
}
public tp_1 fn_23 ( int vr_36 ) {
return fn_19 ( tp_10 . vr_36 () , vr_36 ) ;
}
public tp_1 fn_24 ( tp_11 vr_30 ) {
return fn_20 ( vr_30 , - 1 ) ;
}
public tp_1 fn_25 ( int vr_35 ) {
return fn_19 ( tp_10 . vr_35 () , vr_33 . vr_37 ( vr_35 ) ) ;
}
public tp_1 fn_26 ( int vr_36 ) {
return fn_19 ( tp_10 . vr_36 () , vr_33 . vr_37 ( vr_36 ) ) ;
}
public tp_5 fn_27 ( int vr_38 ) {
return new tp_5 ( vr_9 () , vr_10 () , vr_38 , fn_7 () ) ;
}
public tp_12 fn_28 () {
return fn_28 ( null ) ;
}
public tp_12 fn_28 ( tp_2 vr_1 ) {
vr_1 = vr_23 . fn_8 ( vr_1 ) ;
tp_13 vr_39 = fn_27 ( 1 ) . fn_29 ( vr_1 ) ;
tp_13 vr_40 = fn_23 ( 1 ) . fn_27 ( 1 ) . fn_29 ( vr_1 ) ;
return new tp_12 ( vr_39 , vr_40 ) ;
}
public int vr_9 () {
return fn_17 ( vr_12 ) ;
}
public int vr_10 () {
return fn_17 ( vl_1 ) ;
}
public tp_1 fn_30 ( int vr_18 ) {
int [] vr_28 = getValues () ;
vr_28 = fn_7 () . vr_18 () . fn_18 ( this , vr_12 , vr_28 , vr_18 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_1 fn_31 ( int vr_19 ) {
int [] vr_28 = getValues () ;
vr_28 = fn_7 () . vr_19 () . fn_18 ( this , vl_1 , vr_28 , vr_19 ) ;
return new tp_1 ( this , vr_28 ) ;
}
public tp_14 fn_32 ( tp_9 type ) {
return new tp_14 ( this , fn_16 ( type ) ) ;
}
public tp_14 vr_18 () {
return new tp_14 ( this , vr_12 ) ;
}
public tp_14 vr_19 () {
return new tp_14 ( this , vl_1 ) ;
}
@ToString
public String toString () {
return vr_4 . vr_41 () . fn_33 ( this ) ;
}
public String toString ( String vr_42 ) {
if ( vr_42 == null ) {
return toString () ;
}
return vr_43 . vr_44 ( vr_42 ) . fn_33 ( this ) ;
}
public String toString ( String vr_42 , tp_15 vr_45 ) throws IllegalArgumentException {
if ( vr_42 == null ) {
return toString () ;
}
return vr_43 . vr_44 ( vr_42 ) . fn_34 ( vr_45 ) . fn_33 ( this ) ;
}
public tp_8 fn_10 () {
return vr_46 . fn_10 ( vl_2 ) ;
}
protected tp_16 fn_35 () {
return vr_46 ;
}
public tp_1 fn_36 () {
return vr_46 ;
}
public int get () {
return vr_46 . fn_17 ( vl_2 ) ;
}
public tp_1 fn_37 ( int vr_47 ) {
int [] vr_28 = vr_46 . getValues () ;
vr_28 = fn_10 () . add ( vr_46 , vl_2 , vr_28 , vr_47 ) ;
return new tp_1 ( vr_46 , vr_28 ) ;
}
public tp_1 fn_38 ( int vr_47 ) {
int [] vr_28 = vr_46 . getValues () ;
vr_28 = fn_10 () . fn_39 ( vr_46 , vl_2 , vr_28 , vr_47 ) ;
return new tp_1 ( vr_46 , vr_28 ) ;
}
public tp_1 fn_40 ( int vr_27 ) {
int [] vr_28 = vr_46 . getValues () ;
vr_28 = fn_10 () . fn_18 ( vr_46 , vl_2 , vr_28 , vr_27 ) ;
return new tp_1 ( vr_46 , vr_28 ) ;
}
public tp_1 fn_40 ( String vr_48 , tp_15 vr_45 ) {
int [] vr_28 = vr_46 . getValues () ;
vr_28 = fn_10 () . fn_18 ( vr_46 , vl_2 , vr_28 , vr_48 , vr_45 ) ;
return new tp_1 ( vr_46 , vr_28 ) ;
}
public tp_1 fn_40 ( String vr_48 ) {
return fn_40 ( vr_48 , null ) ;
}
