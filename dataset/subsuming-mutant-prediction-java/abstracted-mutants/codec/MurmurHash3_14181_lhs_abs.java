public static int fn_1 ( final long vr_1 , final long vr_2 ) {
return fn_1 ( vr_1 , vr_2 , vl_1 ) ;
}
public static int fn_1 ( final long vr_1 , final long vr_2 , final int vr_3 ) {
int vr_4 = vr_3 ;
final long vr_5 = Long . vr_6 ( vr_1 ) ;
final long vr_7 = Long . vr_6 ( vr_2 ) ;
vr_4 = fn_2 ( ( int ) vr_5 , vr_4 ) ;
vr_4 = fn_2 ( (int) ( vr_5 >>> 32 ) , vr_4 ) ;
vr_4 = fn_2 ( (int) ( vr_7 ) , vr_4 ) ;
vr_4 = fn_2 ( (int) ( vr_7 >>> 32 ) , vr_4 ) ;
vr_4 ^= vl_2 * 2 ;
return fn_3 ( vr_4 ) ;
}
public static int fn_1 ( final long vr_8 ) {
return fn_1 ( vr_8 , vl_1 ) ;
}
public static int fn_1 ( final long vr_8 , final int vr_3 ) {
int vr_4 = vr_3 ;
final long vr_5 = Long . vr_6 ( vr_8 ) ;
vr_4 = fn_2 ( ( int ) vr_5 , vr_4 ) ;
vr_4 = fn_2 ( (int) ( vr_5 >>> 32 ) , vr_4 ) ;
vr_4 ^= vl_2 ;
return fn_3 ( vr_4 ) ;
}
@Deprecated
public static int fn_1 ( final byte [] vr_8 ) {
return fn_1 ( vr_8 , 0 , vr_8 . length , vl_1 ) ;
}
@Deprecated
public static int fn_1 ( final String vr_8 ) {
final byte [] vr_9 = vr_10 . vr_11 ( vr_8 ) ;
return fn_1 ( vr_9 , 0 , vr_9 . length , vl_1 ) ;
}
@Deprecated
public static int fn_1 ( final byte [] vr_8 , final int length ) {
return fn_1 ( vr_8 , length , vl_1 ) ;
}
@Deprecated
public static int fn_1 ( final byte [] vr_8 , final int length , final int vr_3 ) {
return fn_1 ( vr_8 , 0 , length , vr_3 ) ;
}
@Deprecated
public static int fn_1 ( final byte [] vr_8 , final int vr_12 , final int length , final int vr_3 ) {
int vr_4 = vr_3 ;
final int vr_13 = length >> 2 ;
for ( int vr_14 = 0 ; vr_14 < vr_13 ; vr_14 ++ ) {
final int vr_15 = vr_12 + ( vr_14 << 2 ) ;
final int vr_16 = fn_4 ( vr_8 , vr_15 ) ;
vr_4 = fn_2 ( vr_16 , vr_4 ) ;
}
final int vr_15 = vr_12 + ( vr_13 << 2 ) ;
int vr_17 = 0 ;
switch ( vr_12 + length - vr_15 ) {
case 3 :
vr_17 ^= vr_8 [ vr_15 + 2 ] << 16 ;
case 2 :
vr_17 ^= vr_8 [ vr_15 + 1 ] << 8 ;
case 1 :
vr_17 ^= vr_8 [ vr_15 ] ;
vr_17 *= vl_3 ;
vr_17 = Integer . vr_18 ( vr_17 , vl_4 ) ;
vr_17 *= vl_5 ;
vr_4 ^= vr_17 ;
}
vr_4 ^= length ;
return fn_3 ( vr_4 ) ;
}
public static int fn_5 ( final byte [] vr_8 ) {
return fn_5 ( vr_8 , 0 , vr_8 . length , 0 ) ;
}
public static int fn_5 ( final byte [] vr_8 , final int vr_12 , final int length , final int vr_3 ) {
int vr_4 = vr_3 ;
final int vr_13 = length >> 2 ;
for ( int vr_14 = 0 ; vr_14 < vr_13 ; vr_14 ++ ) {
final int vr_15 = vr_12 + ( vr_14 << 2 ) ;
final int vr_16 = fn_4 ( vr_8 , vr_15 ) ;
vr_4 = fn_2 ( vr_16 , vr_4 ) ;
}
final int vr_15 = vr_12 + ( vr_13 << 2 ) ;
int vr_17 = 0 ;
switch ( vr_12 + length - vr_15 ) {
case 3 :
vr_17 ^= ( vr_8 [ vr_15 + 2 ] & 0xff ) << 16 ;
case 2 :
vr_17 ^= ( vr_8 [ vr_15 + 1 ] & 0xff ) << 8 ;
case 1 :
vr_17 ^= ( vr_8 [ vr_15 ] & 0xff ) ;
vr_17 *= vl_3 ;
vr_17 = Integer . vr_18 ( vr_17 , vl_4 ) ;
vr_17 *= vl_5 ;
vr_4 ^= vr_17 ;
}
vr_4 ^= length ;
return fn_3 ( vr_4 ) ;
}
@Deprecated
public static long fn_6 ( final long vr_8 ) {
long vr_4 = vl_1 ;
long vr_16 = Long . vr_6 ( vr_8 ) ;
final int length = vl_2 ;
vr_16 *= vl_6 ;
vr_16 = Long . vr_18 ( vr_16 , vl_7 ) ;
vr_16 *= vl_8 ;
vr_4 ^= vr_16 ;
vr_4 = Long . vr_18 ( vr_4 , vl_9 ) * vl_10 + vl_11 ;
vr_4 ^= length ;
vr_4 = fn_7 ( vr_4 ) ;
return vr_4 ;
}
@Deprecated
public static long fn_6 ( final int vr_8 ) {
long vr_17 = Integer . vr_6 ( vr_8 ) & ( - 1L >>> 32 ) ;
final int length = vl_12 ;
long vr_4 = vl_1 ;
vr_17 *= vl_6 ;
vr_17 = Long . vr_18 ( vr_17 , vl_7 ) ;
vr_17 *= vl_8 ;
vr_4 ^= vr_17 ;
vr_4 ^= length ;
vr_4 = fn_7 ( vr_4 ) ;
return vr_4 ;
}
@Deprecated
public static long fn_6 ( final short vr_8 ) {
long vr_4 = vl_1 ;
long vr_17 = 0 ;
vr_17 ^= ( ( long ) vr_8 & 0xff ) << 8 ;
vr_17 ^= ( (long) ( ( vr_8 & 0xFF00 ) >> 8 ) & 0xff ) ;
vr_17 *= vl_6 ;
vr_17 = Long . vr_18 ( vr_17 , vl_7 ) ;
vr_17 *= vl_8 ;
vr_4 ^= vr_17 ;
vr_4 ^= vl_13 ;
vr_4 = fn_7 ( vr_4 ) ;
return vr_4 ;
}
@Deprecated
public static long fn_6 ( final byte [] vr_8 ) {
return fn_6 ( vr_8 , 0 , vr_8 . length , vl_1 ) ;
}
@Deprecated
public static long fn_6 ( final byte [] vr_8 , final int vr_12 , final int length ) {
return fn_6 ( vr_8 , vr_12 , length , vl_1 ) ;
}
@Deprecated
public static long fn_6 ( final byte [] vr_8 , final int vr_12 , final int length , final int vr_3 ) {
long vr_4 = vr_3 ;
final int vr_13 = length >> 3 ;
for ( int vr_14 = 0 ; vr_14 < vr_13 ; vr_14 ++ ) {
final int vr_15 = vr_12 + ( vr_14 << 3 ) ;
long vr_16 = fn_8 ( vr_8 , vr_15 ) ;
vr_16 *= vl_6 ;
vr_16 = Long . vr_18 ( vr_16 , vl_7 ) ;
vr_16 *= vl_8 ;
vr_4 ^= vr_16 ;
vr_4 = Long . vr_18 ( vr_4 , vl_9 ) * vl_10 + vl_11 ;
}
long vr_17 = 0 ;
final int vr_15 = vr_12 + ( vr_13 << 3 ) ;
switch ( vr_12 + length - vr_15 ) {
case 7 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 6 ] & 0xff ) << 48 ;
case 6 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 5 ] & 0xff ) << 40 ;
case 5 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 4 ] & 0xff ) << 32 ;
case 4 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 3 ] & 0xff ) << 24 ;
case 3 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 2 ] & 0xff ) << 16 ;
case 2 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 1 ] & 0xff ) << 8 ;
case 1 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 ] & 0xff ) ;
vr_17 *= vl_6 ;
vr_17 = Long . vr_18 ( vr_17 , vl_7 ) ;
vr_17 *= vl_8 ;
vr_4 ^= vr_17 ;
}
vr_4 ^= length ;
vr_4 = fn_7 ( vr_4 ) ;
return vr_4 ;
}
public static long [] fn_9 ( final byte [] vr_8 ) {
return fn_9 ( vr_8 , 0 , vr_8 . length , vl_1 ) ;
}
public static long [] fn_10 ( final byte [] vr_8 ) {
return fn_10 ( vr_8 , 0 , vr_8 . length , 0 ) ;
}
@Deprecated
public static long [] fn_9 ( final String vr_8 ) {
final byte [] vr_9 = vr_10 . vr_11 ( vr_8 ) ;
return fn_9 ( vr_9 , 0 , vr_9 . length , vl_1 ) ;
}
@Deprecated
public static long [] fn_9 ( final byte [] vr_8 , final int vr_12 , final int length , final int vr_3 ) {
return fn_11 ( vr_8 , vr_12 , length , vr_3 ) ;
}
public static long [] fn_10 ( final byte [] vr_8 , final int vr_12 , final int length , final int vr_3 ) {
return fn_11 ( vr_8 , vr_12 , length , vr_3 & 0xffffffffL ) ;
}
private static long [] fn_11 ( final byte [] vr_8 , final int vr_12 , final int length , final long vr_3 ) {
long vr_19 = vr_3 ;
long vr_20 = vr_3 ;
final int vr_13 = length >> 4 ;
for ( int vr_14 = 0 ; vr_14 < vr_13 ; vr_14 ++ ) {
final int vr_15 = vr_12 + ( vr_14 << 4 ) ;
long vr_17 = fn_8 ( vr_8 , vr_15 ) ;
long vr_21 = fn_8 ( vr_8 , vr_15 + 8 ) ;
vr_17 *= vl_6 ;
vr_17 = Long . vr_18 ( vr_17 , vl_7 ) ;
vr_17 *= vl_8 ;
vr_19 ^= vr_17 ;
vr_19 = Long . vr_18 ( vr_19 , vl_9 ) ;
vr_19 += vr_20 ;
vr_19 = vr_19 * vl_10 + vl_11 ;
vr_21 *= vl_8 ;
vr_21 = Long . vr_18 ( vr_21 , vl_14 ) ;
vr_21 *= vl_6 ;
vr_20 ^= vr_21 ;
vr_20 = Long . vr_18 ( vr_20 , vl_7 ) ;
vr_20 += vr_19 ;
vr_20 = vr_20 * vl_10 + vl_15 ;
}
long vr_17 = 0 ;
long vr_21 = 0 ;
final int vr_15 = vr_12 + ( vr_13 << 4 ) ;
switch ( vr_12 + length - vr_15 ) {
case 15 :
vr_21 ^= ( ( long ) vr_8 [ vr_15 + 14 ] & 0xff ) << 48 ;
case 14 :
vr_21 ^= ( ( long ) vr_8 [ vr_15 + 13 ] & 0xff ) << 40 ;
case 13 :
vr_21 ^= ( ( long ) vr_8 [ vr_15 + 12 ] & 0xff ) << 32 ;
case 12 :
vr_21 ^= ( ( long ) vr_8 [ vr_15 + 11 ] & 0xff ) << 24 ;
case 11 :
vr_21 ^= ( ( long ) vr_8 [ vr_15 + 10 ] & 0xff ) << 16 ;
case 10 :
vr_21 ^= ( ( long ) vr_8 [ vr_15 + 9 ] & 0xff ) << 8 ;
case 9 :
vr_21 ^= vr_8 [ vr_15 + 8 ] & 0xff ;
vr_21 *= vl_8 ;
vr_21 = Long . vr_18 ( vr_21 , vl_14 ) ;
vr_21 *= vl_6 ;
vr_20 ^= vr_21 ;
case 8 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 7 ] & 0xff ) << 56 ;
case 7 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 6 ] & 0xff ) << 48 ;
case 6 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 5 ] & 0xff ) << 40 ;
case 5 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 4 ] & 0xff ) << 32 ;
case 4 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 3 ] & 0xff ) << 24 ;
case 3 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 2 ] & 0xff ) << 16 ;
case 2 :
vr_17 ^= ( ( long ) vr_8 [ vr_15 + 1 ] & 0xff ) << 8 ;
case 1 :
vr_17 ^= vr_8 [ vr_15 ] & 0xff ;
vr_17 *= vl_6 ;
vr_17 = Long . vr_18 ( vr_17 , vl_7 ) ;
vr_17 *= vl_8 ;
vr_19 ^= vr_17 ;
}
vr_19 ^= length ;
vr_20 ^= length ;
vr_19 += vr_20 ;
vr_20 += vr_19 ;
vr_19 = fn_7 ( vr_19 ) ;
vr_20 = fn_7 ( vr_20 ) ;
vr_19 += vr_20 ;
vr_20 += vr_19 ;
return new long [] { vr_19 , vr_20 } ;
}
private static long fn_8 ( final byte [] vr_8 , final int vr_15 ) {
return ( ( ( long ) vr_8 [ vr_15 ] & 0xff ) ) |
( ( ( long ) vr_8 [ vr_15 + 1 ] & 0xff ) << 8 ) |
( ( ( long ) vr_8 [ vr_15 + 2 ] & 0xff ) << 16 ) |
( ( ( long ) vr_8 [ vr_15 + 3 ] & 0xff ) << 24 ) |
( ( ( long ) vr_8 [ vr_15 + 4 ] & 0xff ) << 32 ) |
( ( ( long ) vr_8 [ vr_15 + 5 ] & 0xff ) << 40 ) |
( ( ( long ) vr_8 [ vr_15 + 6 ] & 0xff ) << 48 ) |
( ( ( long ) vr_8 [ vr_15 + 7 ] & 0xff ) << 56 ) ;
}
private static int fn_4 ( final byte [] vr_8 , final int vr_15 ) {
return ( ( vr_8 [ vr_15 ] & 0xff ) ) |
( ( vr_8 [ vr_15 + 1 ] & 0xff ) << 8 ) |
( ( vr_8 [ vr_15 + 2 ] & 0xff ) << 16 ) |
( ( vr_8 [ vr_15 + 3 ] & 0xff ) << 24 ) ;
}
private static int fn_2 ( int vr_16 , int vr_4 ) {
vr_16 *= vl_3 ;
vr_16 = Integer . vr_18 ( vr_16 , vl_4 ) ;
vr_16 *= vl_5 ;
vr_4 ^= vr_16 ;
return Integer . vr_18 ( vr_4 , vl_16 ) * vl_17 + vl_18 ;
}
private static int fn_3 ( int vr_4 ) {
vr_4 ^= ( vr_4 >>> 16 ) ;
vr_4 *= 0x85ebca6b ;
vr_4 ^= ( vr_4 >>> 13 ) ;
vr_4 *= 0xc2b2ae35 ;
vr_4 ^= ( vr_4 >>> 16 ) ;
return vr_4 ;
}
private static long fn_7 ( long vr_4 ) {
vr_4 ^= ( vr_4 >>> 33 ) ;
vr_4 *= 0xff51afd7ed558ccdL ;
vr_4 ^= ( vr_4 >>> 33 ) ;
vr_4 *= 0xc4ceb9fe1a85ec53L ;
vr_4 ^= ( vr_4 >>> 33 ) ;
return vr_4 ;
}
public final void fn_12 ( final int vr_3 ) {
vl_19 = vl_20 = 0 ;
this . vr_4 = vr_3 ;
}
public final void add ( final byte [] vr_8 , final int vr_12 , final int length ) {
if ( length <= 0 ) {
return;
}
vl_20 += length ;
if ( vl_19 + length - vl_21 < 0 ) {
System . vr_22 ( vr_8 , vr_12 , vl_22 , vl_19 , length ) ;
vl_19 += length ;
return;
}
int vr_23 ;
int vr_24 ;
if ( vl_19 > 0 ) {
int vr_16 = - 1 ;
switch ( vl_19 ) {
case 1 :
vr_16 = fn_13 ( vl_22 [ 0 ] , vr_8 [ vr_12 ] , vr_8 [ vr_12 + 1 ] , vr_8 [ vr_12 + 2 ] ) ;
break;
case 2 :
vr_16 = fn_13 ( vl_22 [ 0 ] , vl_22 [ 1 ] , vr_8 [ vr_12 ] , vr_8 [ vr_12 + 1 ] ) ;
break;
case 3 :
vr_16 = fn_13 ( vl_22 [ 0 ] , vl_22 [ 1 ] , vl_22 [ 2 ] , vr_8 [ vr_12 ] ) ;
break;
default:
throw new fn_14 ( lr_1 + vl_19 ) ;
}
vr_4 = fn_2 ( vr_16 , vr_4 ) ;
final int vr_25 = vl_21 - vl_19 ;
vr_23 = vr_12 + vr_25 ;
vr_24 = length - vr_25 ;
} else {
vr_23 = vr_12 ;
vr_24 = length ;
}
final int vr_13 = vr_24 >> 2 ;
for ( int vr_14 = 0 ; vr_14 < vr_13 ; vr_14 ++ ) {
final int vr_15 = vr_23 + ( vr_14 << 2 ) ;
final int vr_16 = fn_4 ( vr_8 , vr_15 ) ;
vr_4 = fn_2 ( vr_16 , vr_4 ) ;
}
final int vr_25 = ( vr_13 << 2 ) ;
vl_19 = vr_24 - vr_25 ;
if ( vl_19 != 0 ) {
System . vr_22 ( vr_8 , vr_23 + vr_25 , vl_22 , 0 , vl_19 ) ;
}
}
public final int fn_15 () {
return fn_16 ( vr_4 , vl_19 , vl_22 , vl_20 ) ;
}
int fn_16 ( final int vr_4 , final int vl_19 , final byte [] vl_22 , final int vl_20 ) {
int vr_26 = vr_4 ;
int vr_17 = 0 ;
switch ( vl_19 ) {
case 3 :
vr_17 ^= ( vl_22 [ 2 ] & 0xff ) << 16 ;
case 2 :
vr_17 ^= ( vl_22 [ 1 ] & 0xff ) << 8 ;
case 1 :
vr_17 ^= ( vl_22 [ 0 ] & 0xff ) ; MST[rv.CRCR1Mutator]MSP[]
vr_17 *= vl_3 ;
vr_17 = Integer . vr_18 ( vr_17 , vl_4 ) ;
vr_17 *= vl_5 ;
vr_26 ^= vr_17 ;
}
vr_26 ^= vl_20 ;
return fn_3 ( vr_26 ) ;
}
private static int fn_13 ( final byte vr_27 , final byte vr_28 , final byte vr_29 , final byte vr_30 ) {
return ( vr_27 & 0xff ) | ( ( vr_28 & 0xff ) << 8 ) | ( ( vr_29 & 0xff ) << 16 ) | ( ( vr_30 & 0xff ) << 24 ) ;
}
@Override
@Deprecated
int fn_16 ( final int vr_4 , final int vl_19 , final byte [] vl_22 , final int vl_20 ) {
int vr_26 = vr_4 ;
int vr_17 = 0 ;
switch ( vl_19 ) {
case 3 :
vr_17 ^= vl_22 [ 2 ] << 16 ;
case 2 :
vr_17 ^= vl_22 [ 1 ] << 8 ;
case 1 :
vr_17 ^= vl_22 [ 0 ] ;
vr_17 *= vl_3 ;
vr_17 = Integer . vr_18 ( vr_17 , vl_4 ) ;
vr_17 *= vl_5 ;
vr_26 ^= vr_17 ;
}
vr_26 ^= vl_20 ;
return fn_3 ( vr_26 ) ;
}
