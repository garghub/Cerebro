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
return fn_3 ( vr_3 , vr_4 . vr_5 () . fn_4 () ) ;
}
public static tp_1 fn_3 ( String vr_3 , tp_4 vr_6 ) {
return vr_6 . vr_7 ( vr_3 ) . fn_5 () ;
}
protected long fn_6 ( long vr_8 , tp_3 vr_2 ) {
return vr_2 . vr_9 () . fn_7 ( vr_8 ) ;
}
public tp_1 fn_8 ( long vr_10 ) {
tp_3 vr_11 = fn_9 () ;
vr_10 = fn_6 ( vr_10 , vr_11 ) ;
return ( vr_10 == fn_10 () ? this : new tp_1 ( vr_10 , vr_11 ) ) ;
}
public tp_1 fn_11 ( tp_3 vr_12 ) {
return ( vr_12 == fn_9 () ? this : new tp_1 ( fn_10 () , vr_12 ) ) ;
}
public tp_1 fn_12 ( tp_2 vr_13 ) {
vr_13 = vr_14 . vr_15 ( vr_13 ) ;
tp_2 vr_16 = vr_14 . vr_15 ( vr_15 () ) ;
if ( vr_13 == vr_16 ) {
return this ;
}
long vr_17 = vr_16 . vr_18 ( vr_13 , fn_10 () ) ;
return new tp_1 ( vr_17 , fn_9 () . fn_13 ( vr_13 ) ) ;
}
public tp_1 fn_14 ( tp_5 vr_19 ) {
if ( vr_19 == null ) {
return this ;
}
return fn_8 ( fn_9 () . fn_15 ( vr_19 , fn_10 () ) ) ;
}
public tp_1 fn_16 ( tp_6 vr_20 , int vr_21 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
long vr_8 = vr_20 . vr_22 ( fn_9 () ) . fn_15 ( fn_10 () , vr_21 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_17 ( tp_7 vr_20 , int vr_23 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( vr_23 == 0 ) {
return this ;
}
long vr_8 = vr_20 . vr_22 ( fn_9 () ) . add ( fn_10 () , vr_23 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_18 ( long vr_24 , int vr_25 ) {
if ( vr_24 == 0 || vr_25 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . add ( fn_10 () , vr_24 , vr_25 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_18 ( tp_8 vr_24 , int vr_25 ) {
if ( vr_24 == null || vr_25 == 0 ) {
return this ;
}
return fn_18 ( vr_24 . fn_10 () , vr_25 ) ;
}
public tp_1 fn_19 ( tp_9 vr_26 , int vr_25 ) {
if ( vr_26 == null || vr_25 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . add ( vr_26 , fn_10 () , vr_25 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_20 ( long vr_27 ) {
return fn_18 ( vr_27 , 1 ) ;
}
public tp_1 fn_20 ( tp_8 vr_27 ) {
return fn_18 ( vr_27 , 1 ) ;
}
public tp_1 fn_20 ( tp_9 vr_26 ) {
return fn_19 ( vr_26 , 1 ) ;
}
public tp_1 fn_21 ( int vr_28 ) {
if ( vr_28 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_28 () . add ( fn_10 () , vr_28 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_22 ( int vr_29 ) {
if ( vr_29 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_29 () . add ( fn_10 () , vr_29 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_23 ( int vr_30 ) {
if ( vr_30 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_30 () . add ( fn_10 () , vr_30 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_24 ( int vr_31 ) {
if ( vr_31 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_31 () . add ( fn_10 () , vr_31 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_25 ( long vr_27 ) {
return fn_18 ( vr_27 , - 1 ) ;
}
public tp_1 fn_25 ( tp_8 vr_27 ) {
return fn_18 ( vr_27 , - 1 ) ;
}
public tp_1 fn_25 ( tp_9 vr_26 ) {
return fn_19 ( vr_26 , - 1 ) ;
}
public tp_1 fn_26 ( int vr_28 ) {
if ( vr_28 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_28 () . fn_27 ( fn_10 () , vr_28 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_28 ( int vr_29 ) {
if ( vr_29 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_29 () . fn_27 ( fn_10 () , vr_29 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_29 ( int vr_30 ) {
if ( vr_30 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_30 () . fn_27 ( fn_10 () , vr_30 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_1 fn_30 ( int vr_31 ) {
if ( vr_31 == 0 ) {
return this ;
}
long vr_8 = fn_9 () . vr_31 () . fn_27 ( fn_10 () , vr_31 ) ;
return fn_8 ( vr_8 ) ;
}
public tp_10 fn_31 ( tp_6 type ) {
if ( type == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
tp_11 vr_32 = type . vr_22 ( fn_9 () ) ;
if ( vr_32 . vr_33 () == false ) {
throw new IllegalArgumentException ( lr_5 + type + lr_6 ) ;
}
return new tp_10 ( this , vr_32 ) ;
}
@Deprecated
public tp_12 fn_32 () {
return new tp_12 ( fn_10 () , fn_9 () ) ;
}
public tp_13 fn_33 () {
return new tp_13 ( fn_10 () , fn_9 () ) ;
}
public tp_14 fn_34 () {
tp_3 vr_11 = fn_9 () ;
long vr_34 = fn_10 () ;
long vr_35 = tp_7 . vr_31 () . vr_22 ( vr_11 ) . add ( vr_34 , 1 ) ;
return new tp_14 ( vr_34 , vr_35 , vr_11 ) ;
}
public tp_1 fn_35 ( int vr_36 ) {
return fn_8 ( fn_9 () . vr_36 () . fn_15 ( fn_10 () , vr_36 ) ) ;
}
public tp_1 fn_36 ( int vr_37 ) {
return fn_8 ( fn_9 () . vr_37 () . fn_15 ( fn_10 () , vr_37 ) ) ;
}
public tp_1 fn_37 ( int vr_38 ) {
return fn_8 ( fn_9 () . vr_38 () . fn_15 ( fn_10 () , vr_38 ) ) ;
}
public tp_1 fn_38 ( int vr_39 ) {
return fn_8 ( fn_9 () . vr_39 () . fn_15 ( fn_10 () , vr_39 ) ) ;
}
public tp_1 fn_39 ( int vr_40 ) {
return fn_8 ( fn_9 () . vr_40 () . fn_15 ( fn_10 () , vr_40 ) ) ;
}
public tp_1 fn_40 ( int vr_41 ) {
return fn_8 ( fn_9 () . vr_41 () . fn_15 ( fn_10 () , vr_41 ) ) ;
}
public tp_1 fn_41 ( int vr_42 ) {
return fn_8 ( fn_9 () . vr_42 () . fn_15 ( fn_10 () , vr_42 ) ) ;
}
public tp_1 fn_42 ( int vr_43 ) {
return fn_8 ( fn_9 () . vr_43 () . fn_15 ( fn_10 () , vr_43 ) ) ;
}
public tp_1 fn_43 ( int vr_44 ) {
return fn_8 ( fn_9 () . vr_44 () . fn_15 ( fn_10 () , vr_44 ) ) ;
}
public tp_1 fn_44 ( int vr_9 ) {
return fn_8 ( fn_9 () . vr_9 () . fn_15 ( fn_10 () , vr_9 ) ) ;
}
public tp_1 fn_45 ( int vr_45 ) {
return fn_8 ( fn_9 () . vr_45 () . fn_15 ( fn_10 () , vr_45 ) ) ;
}
public tp_10 vr_36 () {
return new tp_10 ( this , fn_9 () . vr_36 () ) ;
}
public tp_10 vr_37 () {
return new tp_10 ( this , fn_9 () . vr_37 () ) ;
}
public tp_10 vr_39 () {
return new tp_10 ( this , fn_9 () . vr_39 () ) ;
}
public tp_10 vr_38 () {
return new tp_10 ( this , fn_9 () . vr_38 () ) ;
}
public tp_10 vr_40 () {
return new tp_10 ( this , fn_9 () . vr_40 () ) ;
}
public tp_10 vr_41 () {
return new tp_10 ( this , fn_9 () . vr_41 () ) ;
}
public tp_10 vr_42 () {
return new tp_10 ( this , fn_9 () . vr_42 () ) ;
}
public tp_10 vr_43 () {
return new tp_10 ( this , fn_9 () . vr_43 () ) ;
}
public tp_10 vr_44 () {
return new tp_10 ( this , fn_9 () . vr_44 () ) ;
}
public tp_10 vr_9 () {
return new tp_10 ( this , fn_9 () . vr_9 () ) ;
}
public tp_10 vr_45 () {
return new tp_10 ( this , fn_9 () . vr_45 () ) ;
}
private void fn_46 ( tp_15 vr_46 ) throws IOException {
vr_46 . fn_46 ( vl_1 ) ;
vr_46 . fn_46 ( vr_47 . getType () ) ;
}
private void fn_47 ( tp_16 vr_46 ) throws IOException , vl_2 {
vl_1 = ( tp_1 ) vr_46 . fn_47 () ;
tp_6 type = ( tp_6 ) vr_46 . fn_47 () ;
vr_47 = type . vr_22 ( vl_1 . fn_9 () ) ;
}
public tp_11 vr_22 () {
return vr_47 ;
}
protected long fn_10 () {
return vl_1 . fn_10 () ;
}
protected tp_3 fn_9 () {
return vl_1 . fn_9 () ;
}
public tp_1 fn_48 () {
return vl_1 ;
}
public tp_1 fn_49 ( int vr_21 ) {
return vl_1 . fn_8 ( vr_47 . add ( vl_1 . fn_10 () , vr_21 ) ) ;
}
public tp_1 fn_49 ( long vr_21 ) {
return vl_1 . fn_8 ( vr_47 . add ( vl_1 . fn_10 () , vr_21 ) ) ;
}
public tp_1 fn_50 ( int vr_21 ) {
return vl_1 . fn_8 ( vr_47 . vr_48 ( vl_1 . fn_10 () , vr_21 ) ) ;
}
public tp_1 fn_51 ( int vr_21 ) {
return vl_1 . fn_8 ( vr_47 . fn_15 ( vl_1 . fn_10 () , vr_21 ) ) ;
}
public tp_1 fn_51 ( String vr_49 , tp_17 vr_50 ) {
return vl_1 . fn_8 ( vr_47 . fn_15 ( vl_1 . fn_10 () , vr_49 , vr_50 ) ) ;
}
public tp_1 fn_51 ( String vr_49 ) {
return fn_51 ( vr_49 , null ) ;
}
public tp_1 fn_52 () {
return fn_51 ( fn_53 () ) ;
}
public tp_1 fn_54 () {
return fn_51 ( fn_55 () ) ;
}
public tp_1 fn_56 () {
return vl_1 . fn_8 ( vr_47 . fn_7 ( vl_1 . fn_10 () ) ) ;
}
public tp_1 fn_57 () {
return vl_1 . fn_8 ( vr_47 . vr_51 ( vl_1 . fn_10 () ) ) ;
}
public tp_1 fn_58 () {
return vl_1 . fn_8 ( vr_47 . vr_52 ( vl_1 . fn_10 () ) ) ;
}
public tp_1 fn_59 () {
return vl_1 . fn_8 ( vr_47 . vr_53 ( vl_1 . fn_10 () ) ) ;
}
public tp_1 fn_60 () {
return vl_1 . fn_8 ( vr_47 . vr_54 ( vl_1 . fn_10 () ) ) ;
}
