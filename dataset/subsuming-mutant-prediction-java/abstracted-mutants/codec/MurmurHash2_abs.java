public static int fn_1 ( final byte [] vr_1 , final int length , final int vr_2 ) {
int vr_3 = vr_2 ^ length ;
final int vr_4 = length >> 2 ;
for ( int vr_5 = 0 ; vr_5 < vr_4 ; vr_5 ++ ) {
final int vr_6 = ( vr_5 << 2 ) ;
int vr_7 = fn_2 ( vr_1 , vr_6 ) ;
vr_7 *= vl_1 ;
vr_7 ^= vr_7 >>> vl_2 ;
vr_7 *= vl_1 ;
vr_3 *= vl_1 ;
vr_3 ^= vr_7 ;
}
final int vr_6 = ( vr_4 << 2 ) ;
switch ( length - vr_6 ) {
case 3 :
vr_3 ^= ( vr_1 [ vr_6 + 2 ] & 0xff ) << 16 ;
case 2 :
vr_3 ^= ( vr_1 [ vr_6 + 1 ] & 0xff ) << 8 ;
case 1 :
vr_3 ^= ( vr_1 [ vr_6 ] & 0xff ) ;
vr_3 *= vl_1 ;
}
vr_3 ^= vr_3 >>> 13 ;
vr_3 *= vl_1 ;
vr_3 ^= vr_3 >>> 15 ;
return vr_3 ;
}
public static int fn_1 ( final byte [] vr_1 , final int length ) {
return fn_1 ( vr_1 , length , 0x9747b28c ) ;
}
public static int fn_1 ( final String vr_8 ) {
final byte [] vr_9 = vr_10 . vr_11 ( vr_8 ) ;
return fn_1 ( vr_9 , vr_9 . length ) ;
}
public static int fn_1 ( final String vr_8 , final int vr_12 , final int length ) {
return fn_1 ( vr_8 . vr_13 ( vr_12 , vr_12 + length ) ) ;
}
public static long fn_3 ( final byte [] vr_1 , final int length , final int vr_2 ) {
long vr_3 = ( vr_2 & 0xffffffffL ) ^ ( length * vl_3 ) ;
final int vr_4 = length >> 3 ;
for ( int vr_5 = 0 ; vr_5 < vr_4 ; vr_5 ++ ) {
final int vr_6 = ( vr_5 << 3 ) ;
long vr_7 = fn_4 ( vr_1 , vr_6 ) ;
vr_7 *= vl_3 ;
vr_7 ^= vr_7 >>> vl_4 ;
vr_7 *= vl_3 ;
vr_3 ^= vr_7 ;
vr_3 *= vl_3 ;
}
final int vr_6 = ( vr_4 << 3 ) ;
switch ( length - vr_6 ) {
case 7 :
vr_3 ^= ( ( long ) vr_1 [ vr_6 + 6 ] & 0xff ) << 48 ;
case 6 :
vr_3 ^= ( ( long ) vr_1 [ vr_6 + 5 ] & 0xff ) << 40 ;
case 5 :
vr_3 ^= ( ( long ) vr_1 [ vr_6 + 4 ] & 0xff ) << 32 ;
case 4 :
vr_3 ^= ( ( long ) vr_1 [ vr_6 + 3 ] & 0xff ) << 24 ;
case 3 :
vr_3 ^= ( ( long ) vr_1 [ vr_6 + 2 ] & 0xff ) << 16 ;
case 2 :
vr_3 ^= ( ( long ) vr_1 [ vr_6 + 1 ] & 0xff ) << 8 ;
case 1 :
vr_3 ^= ( ( long ) vr_1 [ vr_6 ] & 0xff ) ;
vr_3 *= vl_3 ;
}
vr_3 ^= vr_3 >>> vl_4 ;
vr_3 *= vl_3 ;
vr_3 ^= vr_3 >>> vl_4 ;
return vr_3 ;
}
public static long fn_3 ( final byte [] vr_1 , final int length ) {
return fn_3 ( vr_1 , length , 0xe17a1465 ) ;
}
public static long fn_3 ( final String vr_8 ) {
final byte [] vr_9 = vr_10 . vr_11 ( vr_8 ) ;
return fn_3 ( vr_9 , vr_9 . length ) ;
}
public static long fn_3 ( final String vr_8 , final int vr_12 , final int length ) {
return fn_3 ( vr_8 . vr_13 ( vr_12 , vr_12 + length ) ) ;
}
private static int fn_2 ( final byte [] vr_1 , final int vr_6 ) {
return ( ( vr_1 [ vr_6 ] & 0xff ) ) |
( ( vr_1 [ vr_6 + 1 ] & 0xff ) << 8 ) |
( ( vr_1 [ vr_6 + 2 ] & 0xff ) << 16 ) |
( ( vr_1 [ vr_6 + 3 ] & 0xff ) << 24 ) ;
}
private static long fn_4 ( final byte [] vr_1 , final int vr_6 ) {
return ( ( ( long ) vr_1 [ vr_6 ] & 0xff ) ) |
( ( ( long ) vr_1 [ vr_6 + 1 ] & 0xff ) << 8 ) |
( ( ( long ) vr_1 [ vr_6 + 2 ] & 0xff ) << 16 ) |
( ( ( long ) vr_1 [ vr_6 + 3 ] & 0xff ) << 24 ) |
( ( ( long ) vr_1 [ vr_6 + 4 ] & 0xff ) << 32 ) |
( ( ( long ) vr_1 [ vr_6 + 5 ] & 0xff ) << 40 ) |
( ( ( long ) vr_1 [ vr_6 + 6 ] & 0xff ) << 48 ) |
( ( ( long ) vr_1 [ vr_6 + 7 ] & 0xff ) << 56 ) ;
}
