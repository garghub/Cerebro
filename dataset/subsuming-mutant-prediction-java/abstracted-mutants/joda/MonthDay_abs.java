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
return fn_3 ( vr_3 , vl_1 ) ;
}
public static tp_1 fn_3 ( String vr_3 , tp_4 vr_4 ) {
tp_5 vr_5 = vr_4 . vr_6 ( vr_3 ) ;
return new tp_1 ( vr_5 . vr_7 () , vr_5 . vr_8 () ) ;
}
public static tp_1 fn_4 ( tp_6 vr_9 ) {
if ( vr_9 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new tp_1 ( vr_9 . get ( tp_6 . vr_10 ) + 1 , vr_9 . get ( tp_6 . vr_11 ) ) ;
}
@SuppressWarnings ( lr_4 )
public static tp_1 fn_5 ( tp_7 vr_5 ) {
if ( vr_5 == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
return new tp_1 ( vr_5 . vr_12 () + 1 , vr_5 . vr_13 () ) ;
}
private Object fn_6 () {
if ( tp_2 . vr_14 . equals ( fn_7 () . fn_8 () ) == false ) {
return new tp_1 ( this , fn_7 () . fn_9 () ) ;
}
return this ;
}
public int size () {
return 2 ;
}
protected tp_8 fn_10 ( int vr_15 , tp_3 vr_16 ) {
switch ( vr_15 ) {
case vl_2 :
return vr_16 . vr_17 () ;
case vr_11 :
return vr_16 . vr_18 () ;
default:
throw new fn_11 ( lr_6 + vr_15 ) ;
}
}
public tp_9 fn_12 ( int vr_15 ) {
return vr_19 [ vr_15 ] ;
}
public tp_9 [] fn_13 () {
return ( tp_9 [] ) vr_19 . vr_20 () ;
}
public tp_1 fn_14 ( tp_3 vr_21 ) {
vr_21 = vr_22 . fn_7 ( vr_21 ) ;
vr_21 = vr_21 . fn_9 () ;
if ( vr_21 == fn_7 () ) {
return this ;
} else {
tp_1 vr_23 = new tp_1 ( this , vr_21 ) ;
vr_21 . vr_24 ( vr_23 , getValues () ) ;
return vr_23 ;
}
}
public tp_1 fn_15 ( tp_9 vr_25 , int vr_26 ) {
int vr_15 = fn_16 ( vr_25 ) ;
if ( vr_26 == fn_17 ( vr_15 ) ) {
return this ;
}
int [] vr_27 = getValues () ;
vr_27 = fn_10 ( vr_15 ) . fn_18 ( this , vr_15 , vr_27 , vr_26 ) ;
return new tp_1 ( this , vr_27 ) ;
}
public tp_1 fn_19 ( tp_10 vr_25 , int vr_28 ) {
int vr_15 = fn_16 ( vr_25 ) ;
if ( vr_28 == 0 ) {
return this ;
}
int [] vr_27 = getValues () ;
vr_27 = fn_10 ( vr_15 ) . add ( this , vr_15 , vr_27 , vr_28 ) ;
return new tp_1 ( this , vr_27 ) ;
}
public tp_1 fn_20 ( tp_11 vr_29 , int vr_30 ) {
if ( vr_29 == null || vr_30 == 0 ) {
return this ;
}
int [] vr_27 = getValues () ;
for ( int vr_31 = 0 ; vr_31 < vr_29 . size () ; vr_31 ++ ) {
tp_10 vr_25 = vr_29 . fn_12 ( vr_31 ) ;
int vr_15 = indexOf ( vr_25 ) ;
if ( vr_15 >= 0 ) {
vr_27 = fn_10 ( vr_15 ) . add ( this , vr_15 , vr_27 ,
vr_32 . vr_33 ( vr_29 . fn_17 ( vr_31 ) , vr_30 ) ) ;
}
}
return new tp_1 ( this , vr_27 ) ;
}
public tp_1 fn_21 ( tp_11 vr_29 ) {
return fn_20 ( vr_29 , 1 ) ;
}
public tp_1 fn_22 ( int vr_34 ) {
return fn_19 ( tp_10 . vr_34 () , vr_34 ) ;
}
public tp_1 fn_23 ( int vr_35 ) {
return fn_19 ( tp_10 . vr_35 () , vr_35 ) ;
}
public tp_1 fn_24 ( tp_11 vr_29 ) {
return fn_20 ( vr_29 , - 1 ) ;
}
public tp_1 fn_25 ( int vr_34 ) {
return fn_19 ( tp_10 . vr_34 () , vr_32 . vr_36 ( vr_34 ) ) ;
}
public tp_1 fn_26 ( int vr_35 ) {
return fn_19 ( tp_10 . vr_35 () , vr_32 . vr_36 ( vr_35 ) ) ;
}
public tp_5 fn_27 ( int vr_37 ) {
return new tp_5 ( vr_37 , vr_7 () , vr_8 () , fn_7 () ) ;
}
public int vr_7 () {
return fn_17 ( vl_2 ) ;
}
public int vr_8 () {
return fn_17 ( vr_11 ) ;
}
public tp_1 fn_28 ( int vr_17 ) {
int [] vr_27 = getValues () ;
vr_27 = fn_7 () . vr_17 () . fn_18 ( this , vl_2 , vr_27 , vr_17 ) ;
return new tp_1 ( this , vr_27 ) ;
}
public tp_1 fn_29 ( int vr_18 ) {
int [] vr_27 = getValues () ;
vr_27 = fn_7 () . vr_18 () . fn_18 ( this , vr_11 , vr_27 , vr_18 ) ;
return new tp_1 ( this , vr_27 ) ;
}
public tp_12 fn_30 ( tp_9 type ) {
return new tp_12 ( this , fn_16 ( type ) ) ;
}
public tp_12 vr_17 () {
return new tp_12 ( this , vl_2 ) ;
}
public tp_12 vr_18 () {
return new tp_12 ( this , vr_11 ) ;
}
@ToString
public String toString () {
List < tp_9 > vr_38 = new ArrayList < tp_9 > () ;
vr_38 . add ( tp_9 . vr_17 () ) ;
vr_38 . add ( tp_9 . vr_18 () ) ;
return vr_39 . vr_40 ( vr_38 , true , true ) . fn_31 ( this ) ;
}
public String toString ( String vr_41 ) {
if ( vr_41 == null ) {
return toString () ;
}
return vr_42 . vr_43 ( vr_41 ) . fn_31 ( this ) ;
}
public String toString ( String vr_41 , tp_13 vr_44 ) throws IllegalArgumentException {
if ( vr_41 == null ) {
return toString () ;
}
return vr_42 . vr_43 ( vr_41 ) . fn_32 ( vr_44 ) . fn_31 ( this ) ;
}
public tp_8 fn_10 () {
return vr_45 . fn_10 ( vl_3 ) ;
}
protected tp_14 fn_33 () {
return vr_45 ;
}
public tp_1 fn_34 () {
return vr_45 ;
}
public int get () {
return vr_45 . fn_17 ( vl_3 ) ;
}
public tp_1 fn_35 ( int vr_46 ) {
int [] vr_27 = vr_45 . getValues () ;
vr_27 = fn_10 () . add ( vr_45 , vl_3 , vr_27 , vr_46 ) ;
return new tp_1 ( vr_45 , vr_27 ) ;
}
public tp_1 fn_36 ( int vr_46 ) {
int [] vr_27 = vr_45 . getValues () ;
vr_27 = fn_10 () . fn_37 ( vr_45 , vl_3 , vr_27 , vr_46 ) ;
return new tp_1 ( vr_45 , vr_27 ) ;
}
public tp_1 fn_38 ( int vr_26 ) {
int [] vr_27 = vr_45 . getValues () ;
vr_27 = fn_10 () . fn_18 ( vr_45 , vl_3 , vr_27 , vr_26 ) ;
return new tp_1 ( vr_45 , vr_27 ) ;
}
public tp_1 fn_38 ( String vr_47 , tp_13 vr_44 ) {
int [] vr_27 = vr_45 . getValues () ;
vr_27 = fn_10 () . fn_18 ( vr_45 , vl_3 , vr_27 , vr_47 , vr_44 ) ;
return new tp_1 ( vr_45 , vr_27 ) ;
}
public tp_1 fn_38 ( String vr_47 ) {
return fn_38 ( vr_47 , null ) ;
}
