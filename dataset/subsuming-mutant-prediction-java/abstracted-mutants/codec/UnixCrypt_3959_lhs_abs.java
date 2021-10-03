public static String fn_1 ( final byte [] vr_1 ) {
return fn_1 ( vr_1 , null ) ;
}
public static String fn_1 ( final byte [] vr_1 , String vr_2 ) {
if ( vr_2 == null ) {
final tp_1 vr_3 = tp_1 . vr_4 () ;
final int vr_5 = vr_6 . length ;
vr_2 = lr_1 + vr_6 [ vr_3 . vr_7 ( vr_5 ) ] +
vr_6 [ vr_3 . vr_7 ( vr_5 ) ] ;
} else if ( ! vr_2 . vr_8 ( lr_2 + vr_9 . vr_10 + lr_3 ) ) {
throw new IllegalArgumentException ( lr_4 + vr_2 ) ;
}
final StringBuilder vr_11 = new StringBuilder ( lr_5 ) ;
final char vr_12 = vr_2 . charAt ( 0 ) ;
final char vr_13 = vr_2 . charAt ( 1 ) ;
vr_11 . vr_14 ( 0 , vr_12 ) ;
vr_11 . vr_14 ( 1 , vr_13 ) ;
final int vr_15 = vr_16 [ vr_12 ] ;
final int vr_17 = vr_16 [ vr_13 ] << 4 ;
final byte vr_18 [] = new byte [ 8 ] ;
for ( int vr_19 = 0 ; vr_19 < vr_18 . length ; vr_19 ++ ) {
vr_18 [ vr_19 ] = 0 ;
}
for ( int vr_19 = 0 ; vr_19 < vr_18 . length && vr_19 < vr_1 . length ; vr_19 ++ ) {
final int vr_20 = vr_1 [ vr_19 ] ;
vr_18 [ vr_19 ] = (byte) ( vr_20 << 1 ) ;
}
final int vr_21 [] = fn_2 ( vr_18 ) ;
final int out [] = fn_3 ( vr_21 , vr_15 , vr_17 ) ;
final byte vr_22 [] = new byte [ 9 ] ;
fn_4 ( out [ 0 ] , vr_22 , 0 ) ;
fn_4 ( out [ 1 ] , vr_22 , 4 ) ;
vr_22 [ 8 ] = 0 ;
int vr_19 = 2 ;
int vr_23 = 0 ;
int vr_24 = 128 ;
for (; vr_19 < 13 ; vr_19 ++ ) {
int vr_25 = 0 ;
int vr_26 = 0 ;
for (; vr_25 < 6 ; vr_25 ++ ) {
vr_26 <<= 1 ; MST[InlineConstantMutator]MSP[]
if ( ( vr_22 [ vr_23 ] & vr_24 ) != 0 ) {
vr_26 |= 0x1 ;
}
vr_24 >>>= 1 ;
if ( vr_24 == 0 ) {
vr_23 ++ ;
vr_24 = 128 ;
}
vr_11 . vr_14 ( vr_19 , ( char ) vr_27 [ vr_26 ] ) ;
}
}
return vr_11 . toString () ;
}
public static String fn_1 ( final String vr_1 ) {
return fn_1 ( vr_1 . vr_28 ( vr_29 . vr_30 ) ) ;
}
public static String fn_1 ( final String vr_1 , final String vr_2 ) {
return fn_1 ( vr_1 . vr_28 ( vr_29 . vr_30 ) , vr_2 ) ;
}
private static int [] fn_3 ( final int vr_21 [] , final int vr_15 , final int vr_17 ) {
int vr_31 = 0 ;
int vr_32 = 0 ;
int vr_33 = 0 ;
for ( int vr_25 = 0 ; vr_25 < 25 ; vr_25 ++ ) {
for ( int vr_19 = 0 ; vr_19 < 32 ; vr_19 += 4 ) {
vr_31 = fn_5 ( vr_31 , vr_32 , vr_19 , vr_15 , vr_17 , vr_21 ) ;
vr_32 = fn_5 ( vr_32 , vr_31 , vr_19 + 2 , vr_15 , vr_17 , vr_21 ) ;
}
vr_33 = vr_31 ;
vr_31 = vr_32 ;
vr_32 = vr_33 ;
}
vr_33 = vr_32 ;
vr_32 = vr_31 >>> 1 | vr_31 << 31 ;
vr_31 = vr_33 >>> 1 | vr_33 << 31 ;
final int vr_34 [] = new int [ 2 ] ;
fn_6 ( vr_32 , vr_31 , 1 , 0x55555555 , vr_34 ) ;
vr_32 = vr_34 [ 0 ] ;
vr_31 = vr_34 [ 1 ] ;
fn_6 ( vr_31 , vr_32 , 8 , 0xff00ff , vr_34 ) ;
vr_31 = vr_34 [ 0 ] ;
vr_32 = vr_34 [ 1 ] ;
fn_6 ( vr_32 , vr_31 , 2 , 0x33333333 , vr_34 ) ;
vr_32 = vr_34 [ 0 ] ;
vr_31 = vr_34 [ 1 ] ;
fn_6 ( vr_31 , vr_32 , 16 , 65535 , vr_34 ) ;
vr_31 = vr_34 [ 0 ] ;
vr_32 = vr_34 [ 1 ] ;
fn_6 ( vr_32 , vr_31 , 4 , 0xf0f0f0f , vr_34 ) ;
vr_32 = vr_34 [ 0 ] ;
vr_31 = vr_34 [ 1 ] ;
final int out [] = new int [ 2 ] ;
out [ 0 ] = vr_31 ;
out [ 1 ] = vr_32 ;
return out ;
}
private static int fn_7 ( final byte vr_22 ) {
final int vr_35 = vr_22 ;
return vr_35 < 0 ? vr_35 + 256 : vr_35 ;
}
private static int fn_5 ( int vr_36 , final int vr_37 , final int vr_38 , final int vr_39 , final int vr_40 , final int vr_41 [] ) {
int vr_42 = vr_37 ^ vr_37 >>> 16 ;
int vr_24 = vr_42 & vr_39 ;
vr_42 &= vr_40 ;
vr_24 = vr_24 ^ vr_24 << 16 ^ vr_37 ^ vr_41 [ vr_38 ] ;
int vr_33 = vr_42 ^ vr_42 << 16 ^ vr_37 ^ vr_41 [ vr_38 + 1 ] ;
vr_33 = vr_33 >>> 4 | vr_33 << 28 ;
vr_36 ^= vr_43 [ 1 ] [ vr_33 & 0x3f ] | vr_43 [ 3 ] [ vr_33 >>> 8 & 0x3f ] | vr_43 [ 5 ] [ vr_33 >>> 16 & 0x3f ] |
vr_43 [ 7 ] [ vr_33 >>> 24 & 0x3f ] | vr_43 [ 0 ] [ vr_24 & 0x3f ] | vr_43 [ 2 ] [ vr_24 >>> 8 & 0x3f ] |
vr_43 [ 4 ] [ vr_24 >>> 16 & 0x3f ] | vr_43 [ 6 ] [ vr_24 >>> 24 & 0x3f ] ;
return vr_36 ;
}
private static int [] fn_2 ( final byte vr_18 [] ) {
final int vr_21 [] = new int [ 32 ] ;
int vr_26 = fn_8 ( vr_18 , 0 ) ;
int vr_44 = fn_8 ( vr_18 , 4 ) ;
final int vr_34 [] = new int [ 2 ] ;
fn_6 ( vr_44 , vr_26 , 4 , 0xf0f0f0f , vr_34 ) ;
vr_44 = vr_34 [ 0 ] ;
vr_26 = vr_34 [ 1 ] ;
vr_26 = fn_9 ( vr_26 , - 2 , 0xcccc0000 ) ;
vr_44 = fn_9 ( vr_44 , - 2 , 0xcccc0000 ) ;
fn_6 ( vr_44 , vr_26 , 1 , 0x55555555 , vr_34 ) ;
vr_44 = vr_34 [ 0 ] ;
vr_26 = vr_34 [ 1 ] ;
fn_6 ( vr_26 , vr_44 , 8 , 0xff00ff , vr_34 ) ;
vr_26 = vr_34 [ 0 ] ;
vr_44 = vr_34 [ 1 ] ;
fn_6 ( vr_44 , vr_26 , 1 , 0x55555555 , vr_34 ) ;
vr_44 = vr_34 [ 0 ] ;
vr_26 = vr_34 [ 1 ] ;
vr_44 = ( vr_44 & 0xff ) << 16 | vr_44 & 0xff00 | ( vr_44 & 0xff0000 ) >>> 16 | ( vr_26 & 0xf0000000 ) >>> 4 ;
vr_26 &= 0xfffffff ;
int vr_25 = 0 ;
for ( int vr_19 = 0 ; vr_19 < 16 ; vr_19 ++ ) {
if ( vr_45 [ vr_19 ] ) {
vr_26 = vr_26 >>> 2 | vr_26 << 26 ;
vr_44 = vr_44 >>> 2 | vr_44 << 26 ;
} else {
vr_26 = vr_26 >>> 1 | vr_26 << 27 ;
vr_44 = vr_44 >>> 1 | vr_44 << 27 ;
}
vr_26 &= 0xfffffff ;
vr_44 &= 0xfffffff ;
int vr_38 = vr_46 [ 0 ] [ vr_26 & 0x3f ] | vr_46 [ 1 ] [ vr_26 >>> 6 & 0x3 | vr_26 >>> 7 & 0x3c ] |
vr_46 [ 2 ] [ vr_26 >>> 13 & 0xf | vr_26 >>> 14 & 0x30 ] |
vr_46 [ 3 ] [ vr_26 >>> 20 & 0x1 | vr_26 >>> 21 & 0x6 | vr_26 >>> 22 & 0x38 ] ;
final int vr_33 = vr_46 [ 4 ] [ vr_44 & 0x3f ] | vr_46 [ 5 ] [ vr_44 >>> 7 & 0x3 | vr_44 >>> 8 & 0x3c ] | vr_46 [ 6 ] [ vr_44 >>> 15 & 0x3f ] |
vr_46 [ 7 ] [ vr_44 >>> 21 & 0xf | vr_44 >>> 22 & 0x30 ] ;
vr_21 [ vr_25 ++ ] = ( vr_33 << 16 | vr_38 & 0xffff ) ;
vr_38 = vr_38 >>> 16 | vr_33 & 0xffff0000 ;
vr_38 = vr_38 << 4 | vr_38 >>> 28 ;
vr_21 [ vr_25 ++ ] = vr_38 ;
}
return vr_21 ;
}
private static int fn_8 ( final byte vr_22 [] , int vr_47 ) {
int vr_35 = fn_7 ( vr_22 [ vr_47 ++ ] ) ;
vr_35 |= fn_7 ( vr_22 [ vr_47 ++ ] ) << 8 ;
vr_35 |= fn_7 ( vr_22 [ vr_47 ++ ] ) << 16 ;
vr_35 |= fn_7 ( vr_22 [ vr_47 ++ ] ) << 24 ;
return vr_35 ;
}
private static int fn_9 ( int vr_48 , final int vr_49 , final int vr_50 ) {
final int vr_33 = ( vr_48 << 16 - vr_49 ^ vr_48 ) & vr_50 ;
vr_48 = vr_48 ^ vr_33 ^ vr_33 >>> 16 - vr_49 ;
return vr_48 ;
}
private static void fn_4 ( final int vr_51 , final byte vr_22 [] , int vr_47 ) {
vr_22 [ vr_47 ++ ] = (byte) ( vr_51 & 0xff ) ;
vr_22 [ vr_47 ++ ] = (byte) ( vr_51 >>> 8 & 0xff ) ;
vr_22 [ vr_47 ++ ] = (byte) ( vr_51 >>> 16 & 0xff ) ;
vr_22 [ vr_47 ++ ] = (byte) ( vr_51 >>> 24 & 0xff ) ;
}
private static void fn_6 ( int vr_48 , int vr_22 , final int vr_49 , final int vr_50 , final int vr_34 [] ) {
final int vr_33 = ( vr_48 >>> vr_49 ^ vr_22 ) & vr_50 ;
vr_48 ^= vr_33 << vr_49 ;
vr_22 ^= vr_33 ;
vr_34 [ 0 ] = vr_48 ;
vr_34 [ 1 ] = vr_22 ;
}
