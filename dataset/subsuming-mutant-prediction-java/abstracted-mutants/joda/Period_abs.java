@df_1
public static tp_1 fn_1 ( String vr_1 ) {
return fn_1 ( vr_1 , vr_2 . vr_3 () ) ;
}
public static tp_1 fn_1 ( String vr_1 , tp_2 vr_4 ) {
return vr_4 . vr_5 ( vr_1 ) ;
}
public static tp_1 fn_2 ( int fn_2 ) {
return new tp_1 ( new int [] { fn_2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_3 ( int fn_3 ) {
return new tp_1 ( new int [] { 0 , fn_3 , 0 , 0 , 0 , 0 , 0 , 0 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_4 ( int fn_4 ) {
return new tp_1 ( new int [] { 0 , 0 , fn_4 , 0 , 0 , 0 , 0 , 0 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_5 ( int fn_5 ) {
return new tp_1 ( new int [] { 0 , 0 , 0 , fn_5 , 0 , 0 , 0 , 0 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_6 ( int fn_6 ) {
return new tp_1 ( new int [] { 0 , 0 , 0 , 0 , fn_6 , 0 , 0 , 0 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_7 ( int fn_7 ) {
return new tp_1 ( new int [] { 0 , 0 , 0 , 0 , 0 , fn_7 , 0 , 0 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_8 ( int fn_8 ) {
return new tp_1 ( new int [] { 0 , 0 , 0 , 0 , 0 , 0 , fn_8 , 0 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_9 ( int fn_9 ) {
return new tp_1 ( new int [] { 0 , 0 , 0 , 0 , 0 , 0 , 0 , fn_9 } , vr_6 . vr_3 () ) ;
}
public static tp_1 fn_10 ( tp_3 vr_7 , tp_3 vr_8 ) {
if ( vr_7 == null || vr_8 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_7 . size () != vr_8 . size () ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
vr_9 [] vr_10 = new vr_9 [ vr_7 . size () ] ;
int [] vr_11 = new int [ vr_7 . size () ] ;
for ( int vr_12 = 0 , vr_13 = vr_7 . size () ; vr_12 < vr_13 ; vr_12 ++ ) {
if ( vr_7 . vr_14 ( vr_12 ) != vr_8 . vr_14 ( vr_12 ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
vr_10 [ vr_12 ] = vr_7 . vr_14 ( vr_12 ) . fn_11 () ;
if ( vr_12 > 0 && vr_10 [ vr_12 - 1 ] == vr_10 [ vr_12 ] ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
vr_11 [ vr_12 ] = vr_8 . vr_15 ( vr_12 ) - vr_7 . vr_15 ( vr_12 ) ;
}
return new tp_1 ( vr_11 , vr_6 . vr_16 ( vr_10 ) ) ;
}
public tp_1 fn_12 () {
return this ;
}
public int fn_13 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_17 ) ;
}
public int fn_16 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_18 ) ;
}
public int fn_17 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_19 ) ;
}
public int fn_18 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_20 ) ;
}
public int fn_19 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_21 ) ;
}
public int fn_20 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_22 ) ;
}
public int fn_21 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_23 ) ;
}
public int fn_22 () {
return fn_14 () . fn_15 ( this , vr_6 . vr_24 ) ;
}
public tp_1 fn_23 ( vr_6 type ) {
type = vr_25 . fn_14 ( type ) ;
if ( type . equals ( fn_14 () ) ) {
return this ;
}
return new tp_1 ( this , type ) ;
}
public tp_1 fn_24 ( tp_4 vr_26 ) {
if ( vr_26 == null ) {
return this ;
}
int [] vr_27 = getValues () ;
vr_27 = super . vr_28 ( vr_27 , vr_26 ) ;
return new tp_1 ( vr_27 , fn_14 () ) ;
}
public tp_1 fn_25 ( vr_9 vr_29 , int vr_30 ) {
if ( vr_29 == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
int [] vr_27 = getValues () ;
super . vr_31 ( vr_27 , vr_29 , vr_30 ) ;
return new tp_1 ( vr_27 , fn_14 () ) ;
}
public tp_1 fn_26 ( vr_9 vr_29 , int vr_30 ) {
if ( vr_29 == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
if ( vr_30 == 0 ) {
return this ;
}
int [] vr_27 = getValues () ;
super . vr_32 ( vr_27 , vr_29 , vr_30 ) ;
return new tp_1 ( vr_27 , fn_14 () ) ;
}
public tp_1 fn_27 ( int fn_2 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_17 , vr_11 , fn_2 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_29 ( int fn_3 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_18 , vr_11 , fn_3 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_30 ( int fn_4 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_19 , vr_11 , fn_4 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_31 ( int fn_5 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_20 , vr_11 , fn_5 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_32 ( int fn_6 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_21 , vr_11 , fn_6 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_33 ( int fn_7 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_22 , vr_11 , fn_7 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_34 ( int fn_8 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_23 , vr_11 , fn_8 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_35 ( int fn_9 ) {
int [] vr_11 = getValues () ;
fn_14 () . fn_28 ( this , vr_6 . vr_24 , vr_11 , fn_9 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_36 ( tp_4 vr_26 ) {
if ( vr_26 == null ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_17 , vr_11 , vr_26 . get ( vr_9 . vr_33 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_18 , vr_11 , vr_26 . get ( vr_9 . vr_34 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_19 , vr_11 , vr_26 . get ( vr_9 . vr_35 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_20 , vr_11 , vr_26 . get ( vr_9 . vr_36 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_21 , vr_11 , vr_26 . get ( vr_9 . vr_37 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_22 , vr_11 , vr_26 . get ( vr_9 . vr_38 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_23 , vr_11 , vr_26 . get ( vr_9 . vr_39 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_24 , vr_11 , vr_26 . get ( vr_9 . vr_40 ) ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_38 ( int fn_2 ) {
if ( fn_2 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_17 , vr_11 , fn_2 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_39 ( int fn_3 ) {
if ( fn_3 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_18 , vr_11 , fn_3 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_40 ( int fn_4 ) {
if ( fn_4 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_19 , vr_11 , fn_4 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_41 ( int fn_5 ) {
if ( fn_5 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_20 , vr_11 , fn_5 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_42 ( int fn_6 ) {
if ( fn_6 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_21 , vr_11 , fn_6 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_43 ( int fn_7 ) {
if ( fn_7 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_22 , vr_11 , fn_7 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_44 ( int fn_8 ) {
if ( fn_8 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_23 , vr_11 , fn_8 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_45 ( int fn_9 ) {
if ( fn_9 == 0 ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_24 , vr_11 , fn_9 ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_46 ( tp_4 vr_26 ) {
if ( vr_26 == null ) {
return this ;
}
int [] vr_11 = getValues () ;
fn_14 () . fn_37 ( this , vr_6 . vr_17 , vr_11 , - vr_26 . get ( vr_9 . vr_33 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_18 , vr_11 , - vr_26 . get ( vr_9 . vr_34 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_19 , vr_11 , - vr_26 . get ( vr_9 . vr_35 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_20 , vr_11 , - vr_26 . get ( vr_9 . vr_36 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_21 , vr_11 , - vr_26 . get ( vr_9 . vr_37 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_22 , vr_11 , - vr_26 . get ( vr_9 . vr_38 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_23 , vr_11 , - vr_26 . get ( vr_9 . vr_39 ) ) ;
fn_14 () . fn_37 ( this , vr_6 . vr_24 , vr_11 , - vr_26 . get ( vr_9 . vr_40 ) ) ;
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_47 ( int fn_2 ) {
return fn_38 ( - fn_2 ) ;
}
public tp_1 fn_48 ( int fn_3 ) {
return fn_39 ( - fn_3 ) ;
}
public tp_1 fn_49 ( int fn_4 ) {
return fn_40 ( - fn_4 ) ;
}
public tp_1 fn_50 ( int fn_5 ) {
return fn_41 ( - fn_5 ) ;
}
public tp_1 fn_51 ( int fn_6 ) {
return fn_42 ( - fn_6 ) ;
}
public tp_1 fn_52 ( int fn_7 ) {
return fn_43 ( - fn_7 ) ;
}
public tp_1 fn_53 ( int fn_8 ) {
return fn_44 ( - fn_8 ) ;
}
public tp_1 fn_54 ( int fn_9 ) {
return fn_45 ( - fn_9 ) ;
}
public tp_1 fn_55 ( int vr_41 ) {
if ( this == vl_1 || vr_41 == 1 ) {
return this ;
}
int [] vr_11 = getValues () ;
for ( int vr_12 = 0 ; vr_12 < vr_11 . length ; vr_12 ++ ) {
vr_11 [ vr_12 ] = vr_42 . vr_43 ( vr_11 [ vr_12 ] , vr_41 ) ;
}
return new tp_1 ( vr_11 , fn_14 () ) ;
}
public tp_1 fn_56 () {
return fn_55 ( - 1 ) ;
}
public tp_5 fn_57 () {
fn_58 ( lr_5 ) ;
long fn_9 = fn_22 () ;
fn_9 += ( ( long ) fn_21 () ) * vr_44 . vr_45 ;
fn_9 += ( ( long ) fn_20 () ) * vr_44 . vr_46 ;
fn_9 += ( ( long ) fn_19 () ) * vr_44 . vr_47 ;
fn_9 += ( ( long ) fn_18 () ) * vr_44 . vr_48 ;
long fn_4 = ( ( long ) fn_17 () ) + fn_9 / vr_44 . vr_49 ;
return tp_5 . fn_4 ( vr_42 . vr_50 ( fn_4 ) ) ;
}
public tp_6 fn_59 () {
fn_58 ( lr_6 ) ;
long fn_9 = fn_22 () ;
fn_9 += ( ( long ) fn_21 () ) * vr_44 . vr_45 ;
fn_9 += ( ( long ) fn_20 () ) * vr_44 . vr_46 ;
fn_9 += ( ( long ) fn_19 () ) * vr_44 . vr_47 ;
long fn_5 = fn_9 / vr_44 . vr_48 ;
fn_5 = vr_42 . vr_51 ( fn_5 , fn_18 () ) ;
fn_5 = vr_42 . vr_51 ( fn_5 , ( ( long ) fn_17 () ) * ( ( long ) vr_44 . vr_52 ) ) ;
return tp_6 . fn_5 ( vr_42 . vr_50 ( fn_5 ) ) ;
}
public tp_7 fn_60 () {
fn_58 ( lr_7 ) ;
long fn_9 = fn_22 () ;
fn_9 += ( ( long ) fn_21 () ) * vr_44 . vr_45 ;
fn_9 += ( ( long ) fn_20 () ) * vr_44 . vr_46 ;
long fn_6 = fn_9 / vr_44 . vr_47 ;
fn_6 = vr_42 . vr_51 ( fn_6 , fn_19 () ) ;
fn_6 = vr_42 . vr_51 ( fn_6 , ( ( long ) fn_18 () ) * ( ( long ) vr_44 . vr_53 ) ) ;
fn_6 = vr_42 . vr_51 ( fn_6 , ( ( long ) fn_17 () ) * ( ( long ) vr_44 . vr_54 ) ) ;
return tp_7 . fn_6 ( vr_42 . vr_50 ( fn_6 ) ) ;
}
public tp_8 fn_61 () {
fn_58 ( lr_8 ) ;
long fn_9 = fn_22 () ;
fn_9 += ( ( long ) fn_21 () ) * vr_44 . vr_45 ;
long fn_7 = fn_9 / vr_44 . vr_46 ;
fn_7 = vr_42 . vr_51 ( fn_7 , fn_20 () ) ;
fn_7 = vr_42 . vr_51 ( fn_7 , ( ( long ) fn_19 () ) * ( ( long ) vr_44 . vr_55 ) ) ;
fn_7 = vr_42 . vr_51 ( fn_7 , ( ( long ) fn_18 () ) * ( ( long ) vr_44 . vr_56 ) ) ;
fn_7 = vr_42 . vr_51 ( fn_7 , ( ( long ) fn_17 () ) * ( ( long ) vr_44 . vr_57 ) ) ;
return tp_8 . fn_7 ( vr_42 . vr_50 ( fn_7 ) ) ;
}
public tp_9 fn_62 () {
fn_58 ( lr_9 ) ;
long fn_8 = fn_22 () / vr_44 . vr_45 ;
fn_8 = vr_42 . vr_51 ( fn_8 , fn_21 () ) ;
fn_8 = vr_42 . vr_51 ( fn_8 , ( ( long ) fn_20 () ) * ( ( long ) vr_44 . vr_58 ) ) ;
fn_8 = vr_42 . vr_51 ( fn_8 , ( ( long ) fn_19 () ) * ( ( long ) vr_44 . vr_59 ) ) ;
fn_8 = vr_42 . vr_51 ( fn_8 , ( ( long ) fn_18 () ) * ( ( long ) vr_44 . vr_60 ) ) ;
fn_8 = vr_42 . vr_51 ( fn_8 , ( ( long ) fn_17 () ) * ( ( long ) vr_44 . vr_61 ) ) ;
return tp_9 . fn_8 ( vr_42 . vr_50 ( fn_8 ) ) ;
}
public tp_10 fn_63 () {
fn_58 ( lr_10 ) ;
long fn_9 = fn_22 () ;
fn_9 += ( ( ( long ) fn_21 () ) * ( ( long ) vr_44 . vr_45 ) ) ;
fn_9 += ( ( ( long ) fn_20 () ) * ( ( long ) vr_44 . vr_46 ) ) ;
fn_9 += ( ( ( long ) fn_19 () ) * ( ( long ) vr_44 . vr_47 ) ) ;
fn_9 += ( ( ( long ) fn_18 () ) * ( ( long ) vr_44 . vr_48 ) ) ;
fn_9 += ( ( ( long ) fn_17 () ) * ( ( long ) vr_44 . vr_49 ) ) ;
return new tp_10 ( fn_9 ) ;
}
private void fn_58 ( String vr_62 ) {
if ( fn_16 () != 0 ) {
throw new fn_64 ( lr_11 + vr_62 + lr_12 ) ;
}
if ( fn_13 () != 0 ) {
throw new fn_64 ( lr_11 + vr_62 + lr_13 ) ;
}
}
public tp_1 fn_65 () {
return fn_65 ( vr_6 . vr_3 () ) ;
}
public tp_1 fn_65 ( vr_6 type ) {
type = vr_25 . fn_14 ( type ) ;
long fn_9 = fn_22 () ;
fn_9 += ( ( ( long ) fn_21 () ) * ( ( long ) vr_44 . vr_45 ) ) ;
fn_9 += ( ( ( long ) fn_20 () ) * ( ( long ) vr_44 . vr_46 ) ) ;
fn_9 += ( ( ( long ) fn_19 () ) * ( ( long ) vr_44 . vr_47 ) ) ;
fn_9 += ( ( ( long ) fn_18 () ) * ( ( long ) vr_44 . vr_48 ) ) ;
fn_9 += ( ( ( long ) fn_17 () ) * ( ( long ) vr_44 . vr_49 ) ) ;
tp_1 vr_63 = new tp_1 ( fn_9 , type , vr_64 . vr_65 () ) ;
int fn_2 = fn_13 () ;
int fn_3 = fn_16 () ;
if ( fn_2 != 0 || fn_3 != 0 ) {
long vr_66 = fn_2 * 12L + fn_3 ;
if ( type . vr_67 ( vr_9 . vr_33 ) ) {
int vr_68 = vr_42 . vr_50 ( vr_66 / 12 ) ;
vr_63 = vr_63 . fn_27 ( vr_68 ) ;
vr_66 = vr_66 - ( vr_68 * 12 ) ;
}
if ( type . vr_67 ( vr_9 . vr_34 ) ) {
int vr_69 = vr_42 . vr_50 ( vr_66 ) ;
vr_63 = vr_63 . fn_29 ( vr_69 ) ;
vr_66 = vr_66 - vr_69 ;
}
if ( vr_66 != 0 ) {
throw new fn_64 ( lr_14 + toString () ) ;
}
}
return vr_63 ;
}
