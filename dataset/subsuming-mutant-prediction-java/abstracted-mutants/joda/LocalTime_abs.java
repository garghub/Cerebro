public static LocalTime fn_1 () {
return new LocalTime () ;
}
public static LocalTime fn_1 ( tp_1 vr_1 ) {
if ( vr_1 == null ) {
throw new fn_2 ( lr_1 ) ;
}
return new LocalTime ( vr_1 ) ;
}
public static LocalTime fn_1 ( tp_2 vr_2 ) {
if ( vr_2 == null ) {
throw new fn_2 ( lr_2 ) ;
}
return new LocalTime ( vr_2 ) ;
}
@df_1
public static LocalTime fn_3 ( String vr_3 ) {
return fn_3 ( vr_3 , vr_4 . vr_5 () ) ;
}
public static LocalTime fn_3 ( String vr_3 , tp_3 vr_6 ) {
return vr_6 . vr_7 ( vr_3 ) ;
}
public static LocalTime fn_4 ( long vr_8 ) {
return fn_4 ( vr_8 , null ) ;
}
public static LocalTime fn_4 ( long vr_8 , tp_2 vr_9 ) {
vr_9 = vr_10 . vr_11 ( vr_9 ) . fn_5 () ;
return new LocalTime ( vr_8 , vr_9 ) ;
}
public static LocalTime fn_6 ( tp_4 vr_12 ) {
if ( vr_12 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new LocalTime (
vr_12 . get ( tp_4 . vr_13 ) ,
vr_12 . get ( tp_4 . vr_14 ) ,
vr_12 . get ( tp_4 . vr_15 ) ,
vr_12 . get ( tp_4 . vr_16 )
) ;
}
@SuppressWarnings ( lr_4 )
public static LocalTime fn_7 ( tp_5 vr_17 ) {
if ( vr_17 == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
return new LocalTime (
vr_17 . vr_18 () ,
vr_17 . vr_19 () ,
vr_17 . vr_20 () ,
( ( (int) ( vr_17 . vr_21 () % 1000 ) ) + 1000 ) % 1000
) ;
}
private Object fn_8 () {
if ( vl_1 == null ) {
return new LocalTime ( vl_2 , vr_22 . vr_23 () ) ;
}
if ( tp_1 . vr_24 . equals ( vl_1 . vr_25 () ) == false ) {
return new LocalTime ( vl_2 , vl_1 . fn_5 () ) ;
}
return this ;
}
public int size () {
return 4 ;
}
protected tp_6 fn_9 ( int vr_26 , tp_2 vr_9 ) {
switch ( vr_26 ) {
case vr_13 :
return vr_9 . vr_27 () ;
case vl_3 :
return vr_9 . vr_28 () ;
case vl_4 :
return vr_9 . vr_29 () ;
case vl_5 :
return vr_9 . vr_30 () ;
default:
throw new fn_10 ( lr_6 + vr_26 ) ;
}
}
public int fn_11 ( int vr_26 ) {
switch ( vr_26 ) {
case vr_13 :
return vr_11 () . vr_27 () . get ( fn_12 () ) ;
case vl_3 :
return vr_11 () . vr_28 () . get ( fn_12 () ) ;
case vl_4 :
return vr_11 () . vr_29 () . get ( fn_12 () ) ;
case vl_5 :
return vr_11 () . vr_30 () . get ( fn_12 () ) ;
default:
throw new fn_10 ( lr_6 + vr_26 ) ;
}
}
public int get ( tp_7 vr_31 ) {
if ( vr_31 == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
if ( fn_13 ( vr_31 ) == false ) {
throw new IllegalArgumentException ( lr_8 + vr_31 + lr_9 ) ;
}
return vr_31 . fn_9 ( vr_11 () ) . get ( fn_12 () ) ;
}
public boolean fn_13 ( tp_7 type ) {
if ( type == null ) {
return false ;
}
if ( fn_13 ( type . vr_32 () ) == false ) {
return false ;
}
tp_8 vr_33 = type . vr_34 () ;
return ( fn_13 ( vr_33 ) || vr_33 == tp_8 . vr_35 () ) ;
}
public boolean fn_13 ( tp_8 type ) {
if ( type == null ) {
return false ;
}
tp_9 vr_36 = type . fn_9 ( vr_11 () ) ;
if ( vr_37 . contains ( type ) ||
vr_36 . vr_38 () < vr_11 () . vr_35 () . vr_38 () ) {
return vr_36 . fn_13 () ;
}
return false ;
}
protected long fn_12 () {
return vl_2 ;
}
public tp_2 vr_11 () {
return vl_1 ;
}
public boolean equals ( Object vr_39 ) {
if ( this == vr_39 ) {
return true ;
}
if ( vr_39 instanceof LocalTime ) {
LocalTime vr_40 = ( LocalTime ) vr_39 ;
if ( vl_1 . equals ( vr_40 . vl_1 ) ) {
return vl_2 == vr_40 . vl_2 ;
}
}
return super . equals ( vr_39 ) ;
}
public int fn_14 ( tp_10 vr_39 ) {
if ( this == vr_39 ) {
return 0 ;
}
if ( vr_39 instanceof LocalTime ) {
LocalTime vr_40 = ( LocalTime ) vr_39 ;
if ( vl_1 . equals ( vr_40 . vl_1 ) ) {
return ( vl_2 < vr_40 . vl_2 ? - 1 :
( vl_2 == vr_40 . vl_2 ? 0 : 1 ) ) ;
}
}
return super . fn_14 ( vr_39 ) ;
}
LocalTime fn_15 ( long vr_41 ) {
return ( vr_41 == fn_12 () ? this : new LocalTime ( vr_41 , vr_11 () ) ) ;
}
public LocalTime fn_16 ( tp_10 vr_39 ) {
if ( vr_39 == null ) {
return this ;
}
return fn_15 ( vr_11 () . fn_17 ( vr_39 , fn_12 () ) ) ;
}
public LocalTime fn_18 ( tp_7 vr_31 , int vr_42 ) {
if ( vr_31 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( fn_13 ( vr_31 ) == false ) {
throw new IllegalArgumentException ( lr_8 + vr_31 + lr_9 ) ;
}
long vr_43 = vr_31 . fn_9 ( vr_11 () ) . fn_17 ( fn_12 () , vr_42 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_19 ( tp_8 vr_31 , int vr_44 ) {
if ( vr_31 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( fn_13 ( vr_31 ) == false ) {
throw new IllegalArgumentException ( lr_8 + vr_31 + lr_9 ) ;
}
if ( vr_44 == 0 ) {
return this ;
}
long vr_43 = vr_31 . fn_9 ( vr_11 () ) . add ( fn_12 () , vr_44 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_20 ( tp_11 vr_45 , int vr_46 ) {
if ( vr_45 == null || vr_46 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . add ( vr_45 , fn_12 () , vr_46 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_21 ( tp_11 vr_45 ) {
return fn_20 ( vr_45 , 1 ) ;
}
public LocalTime fn_22 ( int vr_47 ) {
if ( vr_47 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_47 () . add ( fn_12 () , vr_47 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_23 ( int vr_48 ) {
if ( vr_48 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_48 () . add ( fn_12 () , vr_48 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_24 ( int vr_49 ) {
if ( vr_49 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_49 () . add ( fn_12 () , vr_49 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_25 ( int vr_50 ) {
if ( vr_50 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_50 () . add ( fn_12 () , vr_50 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_26 ( tp_11 vr_45 ) {
return fn_20 ( vr_45 , - 1 ) ;
}
public LocalTime fn_27 ( int vr_47 ) {
if ( vr_47 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_47 () . fn_28 ( fn_12 () , vr_47 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_29 ( int vr_48 ) {
if ( vr_48 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_48 () . fn_28 ( fn_12 () , vr_48 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_30 ( int vr_49 ) {
if ( vr_49 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_49 () . fn_28 ( fn_12 () , vr_49 ) ;
return fn_15 ( vr_43 ) ;
}
public LocalTime fn_31 ( int vr_50 ) {
if ( vr_50 == 0 ) {
return this ;
}
long vr_43 = vr_11 () . vr_50 () . fn_28 ( fn_12 () , vr_50 ) ;
return fn_15 ( vr_43 ) ;
}
public tp_12 fn_32 ( tp_7 vr_31 ) {
if ( vr_31 == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
if ( fn_13 ( vr_31 ) == false ) {
throw new IllegalArgumentException ( lr_8 + vr_31 + lr_9 ) ;
}
return new tp_12 ( this , vr_31 . fn_9 ( vr_11 () ) ) ;
}
public int fn_33 () {
return vr_11 () . vr_27 () . get ( fn_12 () ) ;
}
public int fn_34 () {
return vr_11 () . vr_28 () . get ( fn_12 () ) ;
}
public int fn_35 () {
return vr_11 () . vr_29 () . get ( fn_12 () ) ;
}
public int fn_36 () {
return vr_11 () . vr_30 () . get ( fn_12 () ) ;
}
public int fn_37 () {
return vr_11 () . vr_8 () . get ( fn_12 () ) ;
}
public LocalTime fn_38 ( int vr_51 ) {
return fn_15 ( vr_11 () . vr_27 () . fn_17 ( fn_12 () , vr_51 ) ) ;
}
public LocalTime fn_39 ( int vr_52 ) {
return fn_15 ( vr_11 () . vr_28 () . fn_17 ( fn_12 () , vr_52 ) ) ;
}
public LocalTime fn_40 ( int vr_53 ) {
return fn_15 ( vr_11 () . vr_29 () . fn_17 ( fn_12 () , vr_53 ) ) ;
}
public LocalTime fn_41 ( int vr_50 ) {
return fn_15 ( vr_11 () . vr_30 () . fn_17 ( fn_12 () , vr_50 ) ) ;
}
public LocalTime fn_42 ( int vr_50 ) {
return fn_15 ( vr_11 () . vr_8 () . fn_17 ( fn_12 () , vr_50 ) ) ;
}
public tp_12 vr_27 () {
return new tp_12 ( this , vr_11 () . vr_27 () ) ;
}
public tp_12 vr_28 () {
return new tp_12 ( this , vr_11 () . vr_28 () ) ;
}
public tp_12 vr_29 () {
return new tp_12 ( this , vr_11 () . vr_29 () ) ;
}
public tp_12 vr_30 () {
return new tp_12 ( this , vr_11 () . vr_30 () ) ;
}
public tp_12 vr_8 () {
return new tp_12 ( this , vr_11 () . vr_8 () ) ;
}
public tp_13 fn_43 () {
return fn_43 ( null ) ;
}
public tp_13 fn_43 ( tp_1 vr_1 ) {
tp_2 vr_9 = vr_11 () . fn_44 ( vr_1 ) ;
long vr_54 = vr_10 . vr_55 () ;
long vr_56 = vr_9 . fn_17 ( this , vr_54 ) ;
return new tp_13 ( vr_56 , vr_9 ) ;
}
@ToString
public String toString () {
return vr_4 . time () . fn_45 ( this ) ;
}
public String toString ( String vr_57 ) {
if ( vr_57 == null ) {
return toString () ;
}
return vr_58 . vr_59 ( vr_57 ) . fn_45 ( this ) ;
}
public String toString ( String vr_57 , tp_14 vr_60 ) throws IllegalArgumentException {
if ( vr_57 == null ) {
return toString () ;
}
return vr_58 . vr_59 ( vr_57 ) . fn_46 ( vr_60 ) . fn_45 ( this ) ;
}
private void fn_47 ( tp_15 vr_61 ) throws IOException {
vr_61 . fn_47 ( vl_6 ) ;
vr_61 . fn_47 ( vr_62 . getType () ) ;
}
private void fn_48 ( tp_16 vr_61 ) throws IOException , vl_7 {
vl_6 = ( LocalTime ) vr_61 . fn_48 () ;
tp_7 type = ( tp_7 ) vr_61 . fn_48 () ;
vr_62 = type . fn_9 ( vl_6 . vr_11 () ) ;
}
public tp_6 fn_9 () {
return vr_62 ;
}
protected long fn_49 () {
return vl_6 . fn_12 () ;
}
protected tp_2 vr_11 () {
return vl_6 . vr_11 () ;
}
public LocalTime fn_50 () {
return vl_6 ;
}
public LocalTime fn_51 ( int vr_42 ) {
return vl_6 . fn_15 ( vr_62 . add ( vl_6 . fn_12 () , vr_42 ) ) ;
}
public LocalTime fn_51 ( long vr_42 ) {
return vl_6 . fn_15 ( vr_62 . add ( vl_6 . fn_12 () , vr_42 ) ) ;
}
public LocalTime fn_52 ( int vr_42 ) {
long vr_50 = vr_62 . add ( vl_6 . fn_12 () , vr_42 ) ;
long vr_63 = vl_6 . vr_11 () . vr_8 () . get ( vr_50 ) ;
if ( vr_63 != vr_50 ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
return vl_6 . fn_15 ( vr_50 ) ;
}
public LocalTime fn_53 ( int vr_42 ) {
return vl_6 . fn_15 ( vr_62 . vr_64 ( vl_6 . fn_12 () , vr_42 ) ) ;
}
public LocalTime fn_54 ( int vr_42 ) {
return vl_6 . fn_15 ( vr_62 . fn_17 ( vl_6 . fn_12 () , vr_42 ) ) ;
}
public LocalTime fn_54 ( String vr_65 , tp_14 vr_60 ) {
return vl_6 . fn_15 ( vr_62 . fn_17 ( vl_6 . fn_12 () , vr_65 , vr_60 ) ) ;
}
public LocalTime fn_54 ( String vr_65 ) {
return fn_54 ( vr_65 , null ) ;
}
public LocalTime fn_55 () {
return fn_54 ( fn_56 () ) ;
}
public LocalTime fn_57 () {
return fn_54 ( fn_58 () ) ;
}
public LocalTime fn_59 () {
return vl_6 . fn_15 ( vr_62 . vr_66 ( vl_6 . fn_12 () ) ) ;
}
public LocalTime fn_60 () {
return vl_6 . fn_15 ( vr_62 . vr_67 ( vl_6 . fn_12 () ) ) ;
}
public LocalTime fn_61 () {
return vl_6 . fn_15 ( vr_62 . vr_68 ( vl_6 . fn_12 () ) ) ;
}
public LocalTime fn_62 () {
return vl_6 . fn_15 ( vr_62 . vr_69 ( vl_6 . fn_12 () ) ) ;
}
public LocalTime fn_63 () {
return vl_6 . fn_15 ( vr_62 . vr_70 ( vl_6 . fn_12 () ) ) ;
}
