public static int hash32 ( final byte [] data , final int length , final int seed ) {
int h = seed ^ length ;
final int nblocks = length >> 2 ;
for ( int i = 0 ; i < nblocks ; i ++ ) {
final int index = ( i << 2 ) ;
int k = getLittleEndianInt ( data , index ) ;
k *= M32 ;
k ^= k >>> R32 ;
k *= M32 ;
h *= M32 ;
h ^= k ;
}
final int index = ( nblocks << 2 ) ;
switch ( length - index ) {
case 3 :
h ^= ( data [ index + 2 ] & 0xff ) << 16 ;
case 2 :
h ^= ( data [ index + 1 ] & 0xff ) << 8 ;
case 1 :
h ^= ( data [ index ] & 0xff ) ;
h *= M32 ;
}
h ^= h >>> 13 ;
h *= M32 ;
h ^= h >>> 15 ;
return h ;
}
public static int hash32 ( final byte [] data , final int length ) {
return hash32 ( data , length , 0x9747b28c ) ;
}
public static int hash32 ( final String text ) {
final byte [] bytes = StringUtils . getBytesUtf8 ( text ) ;
return hash32 ( bytes , bytes . length ) ;
}
public static int hash32 ( final String text , final int from , final int length ) {
return hash32 ( text . substring ( from , from + length ) ) ;
}
public static long hash64 ( final byte [] data , final int length , final int seed ) {
long h = ( seed & 0xffffffffL ) ^ ( length * M64 ) ;
final int nblocks = length >> 3 ;
for ( int i = 0 ; i < nblocks ; i ++ ) {
final int index = ( i << 3 ) ;
long k = getLittleEndianLong ( data , index ) ;
k *= M64 ;
k ^= k >>> R64 ;
k *= M64 ;
h ^= k ;
h *= M64 ;
}
final int index = ( nblocks << 3 ) ;
switch ( length - index ) {
case 7 :
h ^= ( ( long ) data [ index + 6 ] & 0xff ) << 48 ;
case 6 :
h ^= ( ( long ) data [ index + 5 ] & 0xff ) << 40 ;
case 5 :
h ^= ( ( long ) data [ index + 4 ] & 0xff ) << 32 ;
case 4 :
h ^= ( ( long ) data [ index + 3 ] & 0xff ) << 24 ;
case 3 :
h ^= ( ( long ) data [ index + 2 ] & 0xff ) << 16 ;
case 2 :
h ^= ( ( long ) data [ index + 1 ] & 0xff ) << 8 ;
case 1 :
h ^= ( ( long ) data [ index ] & 0xff ) ;
h *= M64 ;
}
h ^= h >>> R64 ;
h *= M64 ;
h ^= h >>> R64 ;
return h ;
}
public static long hash64 ( final byte [] data , final int length ) {
return hash64 ( data , length , 0xe17a1465 ) ;
}
public static long hash64 ( final String text ) {
final byte [] bytes = StringUtils . getBytesUtf8 ( text ) ;
return hash64 ( bytes , bytes . length ) ;
}
public static long hash64 ( final String text , final int from , final int length ) {
return hash64 ( text . substring ( from , from + length ) ) ;
}
private static int getLittleEndianInt ( final byte [] data , final int index ) {
return ( ( data [ index ] & 0xff ) ) |
( ( data [ index + 1 ] & 0xff ) << 8 ) |
( ( data [ index + 2 ] & 0xff ) << 16 ) |
( ( data [ index + 3 ] & 0xff ) << 24 ) ;
}
private static long getLittleEndianLong ( final byte [] data , final int index ) {
return ( ( ( long ) data [ index ] & 0xff ) ) |
( ( ( long ) data [ index + 1 ] & 0xff ) << 8 ) |
( ( ( long ) data [ index + 2 ] & 0xff ) << 16 ) |
( ( ( long ) data [ index + 3 ] & 0xff ) << 24 ) |
( ( ( long ) data [ index + 4 ] & 0xff ) << 32 ) |
( ( ( long ) data [ index + 5 ] & 0xff ) << 40 ) |
( ( ( long ) data [ index + 6 ] & 0xff ) << 48 ) |
( ( ( long ) data [ index + 7 ] & 0xff ) << 56 ) ;
}
