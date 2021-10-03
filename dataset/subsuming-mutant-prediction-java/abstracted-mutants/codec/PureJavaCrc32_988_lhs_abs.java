@Override
public long fn_1 () {
return ( ~ vl_1 ) & 0xffffffffL ;
}
@Override
public void fn_2 () {
fn_3 () ;
}
private void fn_3 () {
vl_1 = 0xffffffff ;
}
@Override
public void fn_4 ( final byte [] vr_1 , final int vr_2 , final int vr_3 ) {
int vr_4 = vl_1 ;
final int vr_5 = vr_3 & 0x7 ;
int vr_6 = vr_2 ;
for( final int vr_7 = vr_2 + vr_3 - vr_5 ; vr_6 < vr_7 ; vr_6 += 8 ) {
final int vr_8 = vr_4 ^
( ( ( ( vr_1 [ vr_6 ] << 24 ) >>> 24 ) + ( ( vr_1 [ vr_6 + 1 ] << 24 ) >>> 16 ) ) +
( ( ( vr_1 [ vr_6 + 2 ] << 24 ) >>> 8 ) + ( vr_1 [ vr_6 + 3 ] << 24 ) ) ) ;
vr_4 = ( ( vr_9 [ ( ( vr_8 << 24 ) >>> 24 ) + 0x700 ] ^ vr_9 [ ( ( vr_8 << 16 ) >>> 24 ) + 0x600 ] ) ^ MST[rv.AOR1Mutator]MSP[]
( vr_9 [ ( ( vr_8 << 8 ) >>> 24 ) + 0x500 ] ^ vr_9 [ ( vr_8 >>> 24 ) + 0x400 ] ) ) ^
( ( vr_9 [ ( ( vr_1 [ vr_6 + 4 ] << 24 ) >>> 24 ) + 0x300 ] ^ vr_9 [ ( ( vr_1 [ vr_6 + 5 ] << 24 ) >>> 24 ) + 0x200 ] ) ^
( vr_9 [ ( ( vr_1 [ vr_6 + 6 ] << 24 ) >>> 24 ) + 0x100 ] ^ vr_9 [ ( ( vr_1 [ vr_6 + 7 ] << 24 ) >>> 24 ) ] ) ) ;
}
switch( vr_5 ) {
case 7 : vr_4 = ( vr_4 >>> 8 ) ^ vr_9 [ ( ( vr_4 ^ vr_1 [ vr_6 ++ ] ) << 24 ) >>> 24 ] ;
case 6 : vr_4 = ( vr_4 >>> 8 ) ^ vr_9 [ ( ( vr_4 ^ vr_1 [ vr_6 ++ ] ) << 24 ) >>> 24 ] ;
case 5 : vr_4 = ( vr_4 >>> 8 ) ^ vr_9 [ ( ( vr_4 ^ vr_1 [ vr_6 ++ ] ) << 24 ) >>> 24 ] ;
case 4 : vr_4 = ( vr_4 >>> 8 ) ^ vr_9 [ ( ( vr_4 ^ vr_1 [ vr_6 ++ ] ) << 24 ) >>> 24 ] ;
case 3 : vr_4 = ( vr_4 >>> 8 ) ^ vr_9 [ ( ( vr_4 ^ vr_1 [ vr_6 ++ ] ) << 24 ) >>> 24 ] ;
case 2 : vr_4 = ( vr_4 >>> 8 ) ^ vr_9 [ ( ( vr_4 ^ vr_1 [ vr_6 ++ ] ) << 24 ) >>> 24 ] ;
case 1 : vr_4 = ( vr_4 >>> 8 ) ^ vr_9 [ ( ( vr_4 ^ vr_1 [ vr_6 ++ ] ) << 24 ) >>> 24 ] ;
default:
}
vl_1 = vr_4 ;
}
@Override
final public void fn_4 ( final int vr_1 ) {
vl_1 = ( vl_1 >>> 8 ) ^ vr_9 [ ( ( ( vl_1 ^ vr_1 ) << 24 ) >>> 24 ) ] ;
}
