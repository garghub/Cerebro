@Override
public void fn_1 () {
fn_2 () ;
vl_1 = 0 ;
vl_2 = 0 ;
vl_3 = false ;
}
@Override
public void fn_3 ( final int vr_1 ) {
vr_2 [ 0 ] = (byte) ( vr_1 & 0xff ) ;
fn_3 ( vr_2 , 0 , 1 ) ;
}
@Override
public void fn_3 ( final byte [] vr_1 , int vr_3 , final int vr_4 ) {
if ( vr_4 <= 0 ) {
return;
}
vl_1 += vr_4 ;
final int vr_5 = vr_3 + vr_4 ;
if ( vl_2 + vr_4 - vl_4 < 0 ) {
System . vr_6 ( vr_1 , vr_3 , vl_5 , vl_2 , vr_4 ) ;
vl_2 += vr_4 ;
return;
}
if ( vl_2 > 0 ) {
final int size = vl_4 - vl_2 ;
System . vr_6 ( vr_1 , vr_3 , vl_5 , vl_2 , size ) ;
fn_4 ( vl_5 , 0 ) ;
vr_3 += size ;
}
final int vr_7 = vr_5 - vl_4 ;
while ( vr_3 <= vr_7 ) {
fn_4 ( vr_1 , vr_3 ) ;
vr_3 += vl_4 ;
}
if ( vr_3 < vr_5 ) {
vl_2 = vr_5 - vr_3 ;
System . vr_6 ( vr_1 , vr_3 , vl_5 , 0 , vl_2 ) ;
} else {
vl_2 = 0 ;
}
}
@Override
public long fn_5 () {
int vr_8 ;
if ( vl_3 ) {
vr_8 =
fn_6 ( vr_9 [ 0 ] , 1 ) +
fn_6 ( vr_9 [ 1 ] , 7 ) +
fn_6 ( vr_9 [ 2 ] , 12 ) +
fn_6 ( vr_9 [ 3 ] , 18 ) ;
} else {
vr_8 = vr_9 [ 2 ] + vl_6 ;
}
vr_8 += vl_1 ;
int vr_10 = 0 ;
final int vr_7 = vl_2 - 4 ;
for (; vr_10 <= vr_7 ; vr_10 += 4 ) {
vr_8 = fn_6 ( vr_8 + fn_7 ( vl_5 , vr_10 ) * vl_7 , 17 ) * vl_8 ;
}
while ( vr_10 < vl_2 ) {
vr_8 = fn_6 ( vr_8 + ( vl_5 [ vr_10 ++ ] & 0xff ) * vl_6 , 11 ) * vl_9 ;
}
vr_8 ^= vr_8 >>> 15 ;
vr_8 *= vl_10 ;
vr_8 ^= vr_8 >>> 13 ;
vr_8 *= vl_7 ;
vr_8 ^= vr_8 >>> 16 ;
return vr_8 & 0xffffffffL ;
}
private static int fn_7 ( final byte [] vl_5 , final int vr_10 ) {
return ( ( vl_5 [ vr_10 ] & 0xff ) ) |
( ( vl_5 [ vr_10 + 1 ] & 0xff ) << 8 ) |
( ( vl_5 [ vr_10 + 2 ] & 0xff ) << 16 ) |
( ( vl_5 [ vr_10 + 3 ] & 0xff ) << 24 ) ;
}
private void fn_2 () {
vr_9 [ 0 ] = vl_11 + vl_9 + vl_10 ;
vr_9 [ 1 ] = vl_11 + vl_10 ;
vr_9 [ 2 ] = vl_11 ;
vr_9 [ 3 ] = vl_11 - vl_9 ;
}
private void fn_4 ( final byte [] vr_1 , final int vr_11 ) {
int vr_12 = vr_9 [ 0 ] ;
int vr_13 = vr_9 [ 1 ] ;
int vr_14 = vr_9 [ 2 ] ;
int vr_15 = vr_9 [ 3 ] ;
vr_12 = fn_6 ( vr_12 + fn_7 ( vr_1 , vr_11 ) * vl_10 , vl_12 ) * vl_9 ;
vr_13 = fn_6 ( vr_13 + fn_7 ( vr_1 , vr_11 + 4 ) * vl_10 , vl_12 ) * vl_9 ;
vr_14 = fn_6 ( vr_14 + fn_7 ( vr_1 , vr_11 + 8 ) * vl_10 , vl_12 ) * vl_9 ;
vr_15 = fn_6 ( vr_15 + fn_7 ( vr_1 , vr_11 + 12 ) * vl_10 , vl_12 ) * vl_9 ;
vr_9 [ 0 ] = vr_12 ;
vr_9 [ 1 ] = vr_13 ;
vr_9 [ 2 ] = vr_14 ;
vr_9 [ 3 ] = vr_15 ;
vl_3 = true ;
}
