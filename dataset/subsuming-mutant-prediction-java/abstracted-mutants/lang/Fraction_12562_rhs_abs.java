public static tp_1 fn_1 ( int vr_1 , int vr_2 ) {
if ( vr_2 == 0 ) {
throw new fn_2 ( lr_1 ) ;
}
if ( vr_2 < 0 ) {
if ( vr_1 == Integer . vr_3 || vr_2 == Integer . vr_3 ) {
throw new fn_2 ( lr_2 ) ;
}
vr_1 = - vr_1 ;
vr_2 = - vr_2 ;
}
return new tp_1 ( vr_1 , vr_2 ) ;
}
public static tp_1 fn_1 ( final int vr_4 , final int vr_1 , final int vr_2 ) {
if ( vr_2 == 0 ) {
throw new fn_2 ( lr_1 ) ;
}
if ( vr_2 < 0 ) {
throw new fn_2 ( lr_3 ) ;
}
if ( vr_1 < 0 ) {
throw new fn_2 ( lr_4 ) ;
}
long vr_5 ;
if ( vr_4 < 0 ) {
vr_5 = vr_4 * ( long ) vr_2 - vr_1 ;
} else {
vr_5 = vr_4 * ( long ) vr_2 + vr_1 ;
}
if ( vr_5 < Integer . vr_3 || vr_5 > Integer . vr_6 ) {
throw new fn_2 ( lr_5 ) ;
}
return new tp_1 ( ( int ) vr_5 , vr_2 ) ;
}
public static tp_1 fn_3 ( int vr_1 , int vr_2 ) {
if ( vr_2 == 0 ) {
throw new fn_2 ( lr_1 ) ;
}
if ( vr_1 == 0 ) {
return vl_1 ;
}
if ( vr_2 == Integer . vr_3 && ( vr_1 & 1 ) == 0 ) {
vr_1 /= 2 ;
vr_2 /= 2 ;
}
if ( vr_2 < 0 ) {
if ( vr_1 == Integer . vr_3 || vr_2 == Integer . vr_3 ) {
throw new fn_2 ( lr_2 ) ;
}
vr_1 = - vr_1 ;
vr_2 = - vr_2 ;
}
final int vr_7 = fn_4 ( vr_1 , vr_2 ) ;
vr_1 /= vr_7 ;
vr_2 /= vr_7 ;
return new tp_1 ( vr_1 , vr_2 ) ;
}
public static tp_1 fn_1 ( double vr_8 ) {
final int vr_9 = vr_8 < 0 ? - 1 : 1 ;
vr_8 = vr_10 . abs ( vr_8 ) ;
if ( vr_8 > Integer . vr_6 || Double . vr_11 ( vr_8 ) ) {
throw new fn_2 ( lr_6 ) ;
}
final int vr_12 = ( int ) vr_8 ;
vr_8 -= vr_12 ;
int vr_13 = 0 ;
int vr_14 = 1 ;
int vr_15 = 1 ;
int vr_16 = 0 ;
int vr_17 = 0 ;
int vr_18 = 0 ;
int vr_19 = ( int ) vr_8 ;
int vr_20 = 0 ;
double vr_21 = 1 ;
double vr_22 = 0 ;
double y1 = vr_8 - vr_19 ;
double vr_23 = 0 ;
double vr_24 , vr_25 = Double . vr_6 ;
double vr_26 ;
int vr_27 = 1 ;
do {
vr_24 = vr_25 ;
vr_20 = (int) ( vr_21 / y1 ) ;
vr_22 = y1 ;
vr_23 = vr_21 - vr_20 * y1 ;
vr_17 = vr_19 * vr_15 + vr_13 ;
vr_18 = vr_19 * vr_16 + vr_14 ;
vr_26 = ( double ) vr_17 / ( double ) vr_18 ;
vr_25 = vr_10 . abs ( vr_8 - vr_26 ) ;
vr_19 = vr_20 ;
vr_21 = vr_22 ;
y1 = vr_23 ;
vr_13 = vr_15 ;
vr_14 = vr_16 ;
vr_15 = vr_17 ;
vr_16 = vr_18 ;
vr_27 ++ ;
} while ( vr_24 > vr_25 && vr_18 <= 10000 && vr_18 > 0 && vr_27 < 25 );
if ( vr_27 == 25 ) {
throw new fn_2 ( lr_7 ) ;
}
return fn_3 ( ( vr_13 + vr_12 * vr_14 ) * vr_9 , vr_14 ) ;
}
public static tp_1 fn_1 ( String vr_28 ) {
if ( vr_28 == null ) {
throw new IllegalArgumentException ( lr_8 ) ;
}
int vr_29 = vr_28 . indexOf ( '.' ) ;
if ( vr_29 >= 0 ) {
return fn_1 ( Double . vr_30 ( vr_28 ) ) ;
}
vr_29 = vr_28 . indexOf ( ' ' ) ;
if ( vr_29 > 0 ) {
final int vr_4 = Integer . vr_31 ( vr_28 . vr_32 ( 0 , vr_29 ) ) ;
vr_28 = vr_28 . vr_32 ( vr_29 + 1 ) ;
vr_29 = vr_28 . indexOf ( '/' ) ;
if ( vr_29 < 0 ) {
throw new fn_5 ( lr_9 ) ;
}
final int vr_33 = Integer . vr_31 ( vr_28 . vr_32 ( 0 , vr_29 ) ) ;
final int vr_34 = Integer . vr_31 ( vr_28 . vr_32 ( vr_29 + 1 ) ) ;
return fn_1 ( vr_4 , vr_33 , vr_34 ) ;
}
vr_29 = vr_28 . indexOf ( '/' ) ;
if ( vr_29 < 0 ) {
return fn_1 ( Integer . vr_31 ( vr_28 ) , 1 ) ;
}
final int vr_33 = Integer . vr_31 ( vr_28 . vr_32 ( 0 , vr_29 ) ) ;
final int vr_34 = Integer . vr_31 ( vr_28 . vr_32 ( vr_29 + 1 ) ) ;
return fn_1 ( vr_33 , vr_34 ) ;
}
public int fn_6 () {
return vr_1 ;
}
public int fn_7 () {
return vr_2 ;
}
public int fn_8 () {
return vr_10 . abs ( vr_1 % vr_2 ) ;
}
public int fn_9 () {
return vr_1 / vr_2 ;
}
@Override
public int fn_10 () {
return vr_1 / vr_2 ;
}
@Override
public long fn_11 () {
return ( long ) vr_1 / vr_2 ;
}
@Override
public float fn_12 () {
return ( float ) vr_1 / ( float ) vr_2 ;
}
@Override
public double fn_13 () {
return ( double ) vr_1 / ( double ) vr_2 ;
}
public tp_1 fn_14 () {
if ( vr_1 == 0 ) {
return equals ( vl_1 ) ? this : vl_1 ;
}
final int vr_7 = fn_4 ( vr_10 . abs ( vr_1 ) , vr_2 ) ;
if ( vr_7 == 1 ) {
return this ;
}
return tp_1 . fn_1 ( vr_1 / vr_7 , vr_2 / vr_7 ) ;
}
public tp_1 fn_15 () {
if ( vr_1 == 0 ) {
throw new fn_2 ( lr_10 ) ;
}
if ( vr_1 == Integer . vr_3 ) {
throw new fn_2 ( lr_11 ) ;
}
if ( vr_1 < 0 ) {
return new tp_1 ( - vr_2 , - vr_1 ) ;
}
return new tp_1 ( vr_2 , vr_1 ) ;
}
public tp_1 fn_16 () {
if ( vr_1 == Integer . vr_3 ) {
throw new fn_2 ( lr_12 ) ;
}
return new tp_1 ( - vr_1 , vr_2 ) ;
}
public tp_1 abs () {
if ( vr_1 >= 0 ) {
return this ;
}
return fn_16 () ;
}
public tp_1 pow ( final int vr_35 ) {
if ( vr_35 == 1 ) {
return this ;
} else if ( vr_35 == 0 ) {
return vl_2 ;
} else if ( vr_35 < 0 ) {
if ( vr_35 == Integer . vr_3 ) {
return this . fn_15 () . pow ( 2 ) . pow ( - ( vr_35 / 2 ) ) ;
}
return this . fn_15 () . pow ( - vr_35 ) ;
} else {
final tp_1 vr_36 = this . vr_37 ( this ) ;
if ( vr_35 % 2 == 0 ) {
return vr_36 . pow ( vr_35 / 2 ) ;
}
return vr_36 . pow ( vr_35 / 2 ) . vr_37 ( this ) ;
}
}
private static int fn_4 ( int vr_38 , int vr_39 ) {
if ( vr_38 == 0 || vr_39 == 0 ) {
if ( vr_38 == Integer . vr_3 || vr_39 == Integer . vr_3 ) {
throw new fn_2 ( lr_13 ) ;
}
return vr_10 . abs ( vr_38 ) + vr_10 . abs ( vr_39 ) ;
}
if ( vr_10 . abs ( vr_38 ) == 1 || vr_10 . abs ( vr_39 ) == 1 ) {
return 1 ;
}
if ( vr_38 > 0 ) {
vr_38 = - vr_38 ;
}
if ( vr_39 > 0 ) {
vr_39 = - vr_39 ;
}
int vr_40 = 0 ;
while ( ( vr_38 & 1 ) == 0 && ( vr_39 & 1 ) == 0 && vr_40 < 31 ) {
vr_38 /= 2 ;
vr_39 /= 2 ;
vr_40 ++ ;
}
if ( vr_40 == 31 ) {
throw new fn_2 ( lr_13 ) ;
}
int vr_41 = ( vr_38 & 1 ) == 1 ? vr_39 : - ( vr_38 / 2 ) ;
do { MST[rv.OBBN2Mutator]MSP[N]
while ( ( vr_41 & 1 ) == 0 ) {
vr_41 /= 2 ;
}
if ( vr_41 > 0 ) {
vr_38 = - vr_41 ;
} else {
vr_39 = vr_41 ;
}
vr_41 = ( vr_39 - vr_38 ) / 2 ;
} while ( vr_41 != 0 );
return - vr_38 * ( 1 << vr_40 ) ;
}
private static int fn_17 ( final int vr_42 , final int vr_43 ) {
final long vr_44 = ( long ) vr_42 * ( long ) vr_43 ;
if ( vr_44 < Integer . vr_3 || vr_44 > Integer . vr_6 ) {
throw new fn_2 ( lr_14 ) ;
}
return ( int ) vr_44 ;
}
private static int fn_18 ( final int vr_42 , final int vr_43 ) {
final long vr_44 = ( long ) vr_42 * ( long ) vr_43 ;
if ( vr_44 > Integer . vr_6 ) {
throw new fn_2 ( lr_15 ) ;
}
return ( int ) vr_44 ;
}
private static int fn_19 ( final int vr_42 , final int vr_43 ) {
final long vr_45 = ( long ) vr_42 + ( long ) vr_43 ;
if ( vr_45 < Integer . vr_3 || vr_45 > Integer . vr_6 ) {
throw new fn_2 ( lr_16 ) ;
}
return ( int ) vr_45 ;
}
private static int fn_20 ( final int vr_42 , final int vr_43 ) {
final long vr_45 = ( long ) vr_42 - ( long ) vr_43 ;
if ( vr_45 < Integer . vr_3 || vr_45 > Integer . vr_6 ) {
throw new fn_2 ( lr_16 ) ;
}
return ( int ) vr_45 ;
}
public tp_1 add ( final tp_1 vr_26 ) {
return fn_21 ( vr_26 , true ) ;
}
public tp_1 fn_22 ( final tp_1 vr_26 ) {
return fn_21 ( vr_26 , false ) ;
}
private tp_1 fn_21 ( final tp_1 vr_26 , final boolean vr_46 ) {
if ( vr_26 == null ) {
throw new IllegalArgumentException ( lr_17 ) ;
}
if ( vr_1 == 0 ) {
return vr_46 ? vr_26 : vr_26 . fn_16 () ;
}
if ( vr_26 . vr_1 == 0 ) {
return this ;
}
final int vr_47 = fn_4 ( vr_2 , vr_26 . vr_2 ) ;
if ( vr_47 == 1 ) {
final int vr_48 = fn_17 ( vr_1 , vr_26 . vr_2 ) ;
final int vr_49 = fn_17 ( vr_26 . vr_1 , vr_2 ) ;
return new tp_1 ( vr_46 ? fn_19 ( vr_48 , vr_49 ) : fn_20 ( vr_48 , vr_49 ) , fn_18 ( vr_2 ,
vr_26 . vr_2 ) ) ;
}
final tp_2 vr_48 = tp_2 . valueOf ( vr_1 ) . fn_23 ( tp_2 . valueOf ( vr_26 . vr_2 / vr_47 ) ) ;
final tp_2 vr_49 = tp_2 . valueOf ( vr_26 . vr_1 ) . fn_23 ( tp_2 . valueOf ( vr_2 / vr_47 ) ) ;
final tp_2 vr_41 = vr_46 ? vr_48 . add ( vr_49 ) : vr_48 . fn_22 ( vr_49 ) ;
final int vr_50 = vr_41 . vr_51 ( tp_2 . valueOf ( vr_47 ) ) . fn_10 () ;
final int vr_52 = vr_50 == 0 ? vr_47 : fn_4 ( vr_50 , vr_47 ) ;
final tp_2 vr_53 = vr_41 . vr_54 ( tp_2 . valueOf ( vr_52 ) ) ;
if ( vr_53 . vr_55 () > 31 ) {
throw new fn_2 ( lr_18 ) ;
}
return new tp_1 ( vr_53 . fn_10 () , fn_18 ( vr_2 / vr_47 , vr_26 . vr_2 / vr_52 ) ) ;
}
public tp_1 vr_37 ( final tp_1 vr_26 ) {
if ( vr_26 == null ) {
throw new IllegalArgumentException ( lr_17 ) ;
}
if ( vr_1 == 0 || vr_26 . vr_1 == 0 ) {
return vl_1 ;
}
final int vr_47 = fn_4 ( vr_1 , vr_26 . vr_2 ) ;
final int vr_52 = fn_4 ( vr_26 . vr_1 , vr_2 ) ;
return fn_3 ( fn_17 ( vr_1 / vr_47 , vr_26 . vr_1 / vr_52 ) ,
fn_18 ( vr_2 / vr_52 , vr_26 . vr_2 / vr_47 ) ) ;
}
public tp_1 fn_24 ( final tp_1 vr_26 ) {
if ( vr_26 == null ) {
throw new IllegalArgumentException ( lr_17 ) ;
}
if ( vr_26 . vr_1 == 0 ) {
throw new fn_2 ( lr_19 ) ;
}
return vr_37 ( vr_26 . fn_15 () ) ;
}
@Override
public boolean equals ( final Object vr_56 ) {
if ( vr_56 == this ) {
return true ;
}
if ( vr_56 instanceof tp_1 == false ) {
return false ;
}
final tp_1 vr_57 = ( tp_1 ) vr_56 ;
return fn_6 () == vr_57 . fn_6 () && fn_7 () == vr_57 . fn_7 () ;
}
@Override
public int fn_25 () {
if ( fn_25 == 0 ) {
fn_25 = 37 * ( 37 * 17 + fn_6 () ) + fn_7 () ;
}
return fn_25 ;
}
@Override
public int fn_26 ( final tp_1 vr_57 ) {
if ( this == vr_57 ) {
return 0 ;
}
if ( vr_1 == vr_57 . vr_1 && vr_2 == vr_57 . vr_2 ) {
return 0 ;
}
final long vr_58 = ( long ) vr_1 * ( long ) vr_57 . vr_2 ;
final long vr_59 = ( long ) vr_57 . vr_1 * ( long ) vr_2 ;
if ( vr_58 == vr_59 ) {
return 0 ;
} else if ( vr_58 < vr_59 ) {
return - 1 ;
} else {
return 1 ;
}
}
@Override
public String toString () {
if ( toString == null ) {
toString = fn_6 () + lr_20 + fn_7 () ;
}
return toString ;
}
public String fn_27 () {
if ( fn_27 == null ) {
if ( vr_1 == 0 ) {
fn_27 = lr_21 ;
} else if ( vr_1 == vr_2 ) {
fn_27 = lr_22 ;
} else if ( vr_1 == - 1 * vr_2 ) {
fn_27 = lr_23 ;
} else if ( ( vr_1 > 0 ? - vr_1 : vr_1 ) < - vr_2 ) {
final int vr_60 = fn_8 () ;
if ( vr_60 == 0 ) {
fn_27 = Integer . toString ( fn_9 () ) ;
} else {
fn_27 = fn_9 () + lr_24 + vr_60 + lr_20 + fn_7 () ;
}
} else {
fn_27 = fn_6 () + lr_20 + fn_7 () ;
}
}
return fn_27 ;
}
