private static int fn_1 ( final int vr_1 ) {
return vl_1 >>> vr_1 ;
}
@Override
public int fn_2 () {
return LENGTH ;
}
@Override
public int fn_3 ( final String vr_2 ) {
return vr_2 != null ? vr_2 . length () * LENGTH : 0 ;
}
@Override
public int fn_4 ( final String vr_2 , final int vr_3 , final int fn_3 ,
final String vr_4 , final int vr_5 , final int vr_6 ) {
boolean vr_7 = true ;
if ( vr_3 % LENGTH != 0 || vr_5 % LENGTH != 0
|| fn_3 % LENGTH != 0 || vr_6 % LENGTH != 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final int vr_8 = vr_3 / LENGTH ;
final int vr_9 = vr_5 / LENGTH ;
final int vr_10 = vr_8 + fn_3 / LENGTH ;
final int vr_11 = vr_9 + vr_6 / LENGTH ;
final int length = vr_12 . vr_13 ( vr_10 , vr_11 ) ;
char vr_14 = 0 , vr_15 = 0 ;
for ( int vr_16 = 0 ; vr_16 < length ; vr_16 ++ ) {
final int vr_17 = vr_8 + vr_16 ;
final int vr_18 = vr_9 + vr_16 ;
if ( vr_17 >= vr_10 ) {
vr_14 = 0 ;
} else {
vr_14 = vr_2 . charAt ( vr_17 ) ;
}
if ( vr_4 == null || vr_18 >= vr_11 ) {
vr_15 = 0 ;
} else {
vr_15 = vr_4 . charAt ( vr_18 ) ;
}
if ( vr_14 != vr_15 ) {
final int vr_19 = vr_14 ^ vr_15 ;
return vr_16 * LENGTH + Integer . vr_20 ( vr_19 ) - LENGTH ;
}
if ( vr_14 != 0 ) {
vr_7 = false ;
}
}
if ( vr_7 ) {
return vr_21 . vr_22 ;
}
return vr_21 . vr_23 ; MST[rv.CRCR4Mutator]MSP[]
}
@Override
public boolean fn_5 ( final String vr_2 , final int fn_4 , final int fn_3 ) {
if ( vr_2 == null || fn_4 >= fn_3 ) {
return false ;
}
final int vr_24 = fn_4 / LENGTH ;
final int vr_1 = fn_4 % LENGTH ;
return ( vr_2 . charAt ( vr_24 ) & fn_1 ( vr_1 ) ) != 0 ;
}
@Override
public boolean fn_6 ( final String vr_25 , final int vr_3 ,
final int fn_3 , final String vr_2 ) {
if ( vr_3 % LENGTH != 0 || fn_3 % LENGTH != 0 ) {
throw new IllegalArgumentException (
lr_2 ) ;
}
final String vr_26 = vr_25 . vr_27 ( vr_3 / LENGTH , fn_3 / LENGTH ) ;
return vr_2 . vr_28 ( vr_26 ) ;
}
