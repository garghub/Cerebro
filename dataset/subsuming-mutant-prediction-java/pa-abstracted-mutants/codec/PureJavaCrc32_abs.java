@Override
public long getValue () {
return ( ~ crc ) & 0xffffffffL ;
}
@Override
public void reset () {
_reset () ;
}
private void _reset () {
crc = 0xffffffff ;
}
@Override
public void update ( final byte [] b , final int offset , final int len ) {
int localCrc = crc ;
final int remainder = len & 0x7 ;
int i = offset ;
for( final int end = offset + len - remainder ; i < end ; i += 8 ) {
final int x = localCrc ^
( ( ( ( b [ i ] << 24 ) >>> 24 ) + ( ( b [ i + 1 ] << 24 ) >>> 16 ) ) +
( ( ( b [ i + 2 ] << 24 ) >>> 8 ) + ( b [ i + 3 ] << 24 ) ) ) ;
localCrc = ( ( T [ ( ( x << 24 ) >>> 24 ) + 0x700 ] ^ T [ ( ( x << 16 ) >>> 24 ) + 0x600 ] ) ^
( T [ ( ( x << 8 ) >>> 24 ) + 0x500 ] ^ T [ ( x >>> 24 ) + 0x400 ] ) ) ^
( ( T [ ( ( b [ i + 4 ] << 24 ) >>> 24 ) + 0x300 ] ^ T [ ( ( b [ i + 5 ] << 24 ) >>> 24 ) + 0x200 ] ) ^
( T [ ( ( b [ i + 6 ] << 24 ) >>> 24 ) + 0x100 ] ^ T [ ( ( b [ i + 7 ] << 24 ) >>> 24 ) ] ) ) ;
}
switch( remainder ) {
case 7 : localCrc = ( localCrc >>> 8 ) ^ T [ ( ( localCrc ^ b [ i ++ ] ) << 24 ) >>> 24 ] ;
case 6 : localCrc = ( localCrc >>> 8 ) ^ T [ ( ( localCrc ^ b [ i ++ ] ) << 24 ) >>> 24 ] ;
case 5 : localCrc = ( localCrc >>> 8 ) ^ T [ ( ( localCrc ^ b [ i ++ ] ) << 24 ) >>> 24 ] ;
case 4 : localCrc = ( localCrc >>> 8 ) ^ T [ ( ( localCrc ^ b [ i ++ ] ) << 24 ) >>> 24 ] ;
case 3 : localCrc = ( localCrc >>> 8 ) ^ T [ ( ( localCrc ^ b [ i ++ ] ) << 24 ) >>> 24 ] ;
case 2 : localCrc = ( localCrc >>> 8 ) ^ T [ ( ( localCrc ^ b [ i ++ ] ) << 24 ) >>> 24 ] ;
case 1 : localCrc = ( localCrc >>> 8 ) ^ T [ ( ( localCrc ^ b [ i ++ ] ) << 24 ) >>> 24 ] ;
default:
}
crc = localCrc ;
}
@Override
final public void update ( final int b ) {
crc = ( crc >>> 8 ) ^ T [ ( ( ( crc ^ b ) << 24 ) >>> 24 ) ] ;
}
