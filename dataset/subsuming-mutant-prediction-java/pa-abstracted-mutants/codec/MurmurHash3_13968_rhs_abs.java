public static int hash32 ( final long data1 , final long data2 ) {
return hash32 ( data1 , data2 , DEFAULT_SEED ) ;
}
public static int hash32 ( final long data1 , final long data2 , final int seed ) {
int hash = seed ;
final long r0 = Long . reverseBytes ( data1 ) ;
final long r1 = Long . reverseBytes ( data2 ) ;
hash = mix32 ( ( int ) r0 , hash ) ;
hash = mix32 ( (int) ( r0 >>> 32 ) , hash ) ;
hash = mix32 ( (int) ( r1 ) , hash ) ;
hash = mix32 ( (int) ( r1 >>> 32 ) , hash ) ;
hash ^= LONG_BYTES * 2 ;
return fmix32 ( hash ) ;
}
public static int hash32 ( final long data ) {
return hash32 ( data , DEFAULT_SEED ) ;
}
public static int hash32 ( final long data , final int seed ) {
int hash = seed ;
final long r0 = Long . reverseBytes ( data ) ;
hash = mix32 ( ( int ) r0 , hash ) ;
hash = mix32 ( (int) ( r0 >>> 32 ) , hash ) ;
hash ^= LONG_BYTES ;
return fmix32 ( hash ) ;
}
@Deprecated
public static int hash32 ( final byte [] data ) {
return hash32 ( data , 0 , data . length , DEFAULT_SEED ) ;
}
@Deprecated
public static int hash32 ( final String data ) {
final byte [] bytes = StringUtils . getBytesUtf8 ( data ) ;
return hash32 ( bytes , 0 , bytes . length , DEFAULT_SEED ) ;
}
@Deprecated
public static int hash32 ( final byte [] data , final int length ) {
return hash32 ( data , length , DEFAULT_SEED ) ;
}
@Deprecated
public static int hash32 ( final byte [] data , final int length , final int seed ) {
return hash32 ( data , 0 , length , seed ) ;
}
@Deprecated
public static int hash32 ( final byte [] data , final int offset , final int length , final int seed ) {
int hash = seed ;
final int nblocks = length >> 2 ;
for ( int i = 0 ; i < nblocks ; i ++ ) {
final int index = offset + ( i << 2 ) ;
final int k = getLittleEndianInt ( data , index ) ;
hash = mix32 ( k , hash ) ;
}
final int index = offset + ( nblocks << 2 ) ;
int k1 = 0 ;
switch ( offset + length - index ) {
case 3 :
k1 ^= data [ index + 2 ] << 16 ;
case 2 :
k1 ^= data [ index + 1 ] << 8 ;
case 1 :
k1 ^= data [ index ] ;
k1 *= C1_32 ;
k1 = Integer . rotateLeft ( k1 , R1_32 ) ;
k1 *= C2_32 ;
hash ^= k1 ;
}
hash ^= length ;
return fmix32 ( hash ) ;
}
public static int hash32x86 ( final byte [] data ) {
return hash32x86 ( data , 0 , data . length , 0 ) ;
}
public static int hash32x86 ( final byte [] data , final int offset , final int length , final int seed ) {
int hash = seed ;
final int nblocks = length >> 2 ;
for ( int i = 0 ; i < nblocks ; i ++ ) {
final int index = offset + ( i << 2 ) ;
final int k = getLittleEndianInt ( data , index ) ;
hash = mix32 ( k , hash ) ;
}
final int index = offset + ( nblocks << 2 ) ;
int k1 = 0 ;
switch ( offset + length - index ) {
case 3 :
k1 ^= ( data [ index + 2 ] & 0xff ) << 16 ;
case 2 :
k1 ^= ( data [ index + 1 ] & 0xff ) << 8 ;
case 1 :
k1 ^= ( data [ index ] & 0xff ) ;
k1 *= C1_32 ;
k1 = Integer . rotateLeft ( k1 , R1_32 ) ;
k1 *= C2_32 ;
hash ^= k1 ;
}
hash ^= length ;
return fmix32 ( hash ) ;
}
@Deprecated
public static long hash64 ( final long data ) {
long hash = DEFAULT_SEED ;
long k = Long . reverseBytes ( data ) ;
final int length = LONG_BYTES ;
k *= C1 ;
k = Long . rotateLeft ( k , R1 ) ;
k *= C2 ;
hash ^= k ;
hash = Long . rotateLeft ( hash , R2 ) * M + N1 ;
hash ^= length ;
hash = fmix64 ( hash ) ;
return hash ;
}
@Deprecated
public static long hash64 ( final int data ) {
long k1 = Integer . reverseBytes ( data ) & ( - 1L >>> 32 ) ;
final int length = INTEGER_BYTES ;
long hash = DEFAULT_SEED ;
k1 *= C1 ;
k1 = Long . rotateLeft ( k1 , R1 ) ;
k1 *= C2 ;
hash ^= k1 ;
hash ^= length ;
hash = fmix64 ( hash ) ;
return hash ;
}
@Deprecated
public static long hash64 ( final short data ) {
long hash = DEFAULT_SEED ;
long k1 = 0 ;
k1 ^= ( ( long ) data & 0xff ) << 8 ;
k1 ^= ( (long) ( ( data & 0xFF00 ) >> 8 ) & 0xff ) ;
k1 *= C1 ;
k1 = Long . rotateLeft ( k1 , R1 ) ;
k1 *= C2 ;
hash ^= k1 ;
hash ^= SHORT_BYTES ;
hash = fmix64 ( hash ) ;
return hash ;
}
@Deprecated
public static long hash64 ( final byte [] data ) {
return hash64 ( data , 0 , data . length , DEFAULT_SEED ) ;
}
@Deprecated
public static long hash64 ( final byte [] data , final int offset , final int length ) {
return hash64 ( data , offset , length , DEFAULT_SEED ) ;
}
@Deprecated
public static long hash64 ( final byte [] data , final int offset , final int length , final int seed ) {
long hash = seed ;
final int nblocks = length >> 3 ;
for ( int i = 0 ; i < nblocks ; i ++ ) {
final int index = offset + ( i << 3 ) ;
long k = getLittleEndianLong ( data , index ) ;
k *= C1 ;
k = Long . rotateLeft ( k , R1 ) ;
k *= C2 ;
hash ^= k ;
hash = Long . rotateLeft ( hash , R2 ) * M + N1 ;
}
long k1 = 0 ;
final int index = offset + ( nblocks << 3 ) ;
switch ( offset + length - index ) {
case 7 :
k1 ^= ( ( long ) data [ index + 6 ] & 0xff ) << 48 ;
case 6 :
k1 ^= ( ( long ) data [ index + 5 ] & 0xff ) << 40 ;
case 5 :
k1 ^= ( ( long ) data [ index + 4 ] & 0xff ) << 32 ;
case 4 :
k1 ^= ( ( long ) data [ index + 3 ] & 0xff ) << 24 ;
case 3 :
k1 ^= ( ( long ) data [ index + 2 ] & 0xff ) << 16 ;
case 2 :
k1 ^= ( ( long ) data [ index + 1 ] & 0xff ) << 8 ;
case 1 :
k1 ^= ( ( long ) data [ index ] & 0xff ) ;
k1 *= C1 ;
k1 = Long . rotateLeft ( k1 , R1 ) ;
k1 *= C2 ;
hash ^= k1 ;
}
hash ^= length ;
hash = fmix64 ( hash ) ;
return hash ;
}
public static long [] hash128 ( final byte [] data ) {
return hash128 ( data , 0 , data . length , DEFAULT_SEED ) ;
}
public static long [] hash128x64 ( final byte [] data ) {
return hash128x64 ( data , 0 , data . length , 0 ) ;
}
@Deprecated
public static long [] hash128 ( final String data ) {
final byte [] bytes = StringUtils . getBytesUtf8 ( data ) ;
return hash128 ( bytes , 0 , bytes . length , DEFAULT_SEED ) ;
}
@Deprecated
public static long [] hash128 ( final byte [] data , final int offset , final int length , final int seed ) {
return hash128x64Internal ( data , offset , length , seed ) ;
}
public static long [] hash128x64 ( final byte [] data , final int offset , final int length , final int seed ) {
return hash128x64Internal ( data , offset , length , seed & 0xffffffffL ) ;
}
private static long [] hash128x64Internal ( final byte [] data , final int offset , final int length , final long seed ) {
long h1 = seed ;
long h2 = seed ;
final int nblocks = length >> 4 ;
for ( int i = 0 ; i < nblocks ; i ++ ) {
final int index = offset + ( i << 4 ) ;
long k1 = getLittleEndianLong ( data , index ) ;
long k2 = getLittleEndianLong ( data , index + 8 ) ;
k1 *= C1 ;
k1 = Long . rotateLeft ( k1 , R1 ) ;
k1 *= C2 ;
h1 ^= k1 ;
h1 = Long . rotateLeft ( h1 , R2 ) ;
h1 += h2 ;
h1 = h1 * M + N1 ;
k2 *= C2 ;
k2 = Long . rotateLeft ( k2 , R3 ) ;
k2 *= C1 ;
h2 ^= k2 ;
h2 = Long . rotateLeft ( h2 , R1 ) ;
h2 += h1 ;
h2 = h2 * M + N2 ;
}
long k1 = 0 ;
long k2 = 0 ;
final int index = offset + ( nblocks << 4 ) ;
switch ( offset + length - index ) {
case 15 :
k2 ^= ( ( long ) data [ index + 14 ] & 0xff ) << 48 ;
case 14 :
k2 ^= ( ( long ) data [ index + 13 ] & 0xff ) << 40 ;
case 13 :
k2 ^= ( ( long ) data [ index + 12 ] & 0xff ) << 32 ;
case 12 :
k2 ^= ( ( long ) data [ index + 11 ] & 0xff ) << 24 ;
case 11 :
k2 ^= ( ( long ) data [ index + 10 ] & 0xff ) << 16 ;
case 10 :
k2 ^= ( ( long ) data [ index + 9 ] & 0xff ) << 8 ;
case 9 :
k2 ^= data [ index + 8 ] & 0xff ;
k2 *= C2 ;
k2 = Long . rotateLeft ( k2 , R3 ) ;
k2 *= C1 ;
h2 ^= k2 ;
case 8 :
k1 ^= ( ( long ) data [ index + 7 ] & 0xff ) << 56 ;
case 7 :
k1 ^= ( ( long ) data [ index + 6 ] & 0xff ) << 48 ;
case 6 :
k1 ^= ( ( long ) data [ index + 5 ] & 0xff ) << 40 ;
case 5 :
k1 ^= ( ( long ) data [ index + 4 ] & 0xff ) << 32 ;
case 4 :
k1 ^= ( ( long ) data [ index + 3 ] & 0xff ) << 24 ;
case 3 :
k1 ^= ( ( long ) data [ index + 2 ] & 0xff ) << 16 ;
case 2 :
k1 ^= ( ( long ) data [ index + 1 ] & 0xff ) << 8 ;
case 1 :
k1 ^= data [ index ] & 0xff ;
k1 *= C1 ;
k1 = Long . rotateLeft ( k1 , R1 ) ;
k1 *= C2 ;
h1 ^= k1 ;
}
h1 ^= length ;
h2 ^= length ;
h1 += h2 ;
h2 += h1 ;
h1 = fmix64 ( h1 ) ;
h2 = fmix64 ( h2 ) ;
h1 += h2 ;
h2 += h1 ;
return new long [] { h1 , h2 } ;
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
private static int getLittleEndianInt ( final byte [] data , final int index ) {
return ( ( data [ index ] & 0xff ) ) |
( ( data [ index + 1 ] & 0xff ) << 8 ) |
( ( data [ index + 2 ] & 0xff ) << 16 ) |
( ( data [ index + 3 ] & 0xff ) << 24 ) ;
}
private static int mix32 ( int k , int hash ) {
k *= C1_32 ;
k = Integer . rotateLeft ( k , R1_32 ) ;
k *= C2_32 ;
hash ^= k ;
return Integer . rotateLeft ( hash , R2_32 ) * M_32 + N_32 ;
}
private static int fmix32 ( int hash ) {
hash ^= ( hash >>> 16 ) ;
hash *= 0x85ebca6b ;
hash ^= ( hash >>> 13 ) ;
hash *= 0xc2b2ae35 ;
hash ^= ( hash >>> 16 ) ;
return hash ;
}
private static long fmix64 ( long hash ) {
hash ^= ( hash >>> 33 ) ;
hash *= 0xff51afd7ed558ccdL ;
hash ^= ( hash >>> 33 ) ;
hash *= 0xc4ceb9fe1a85ec53L ;
hash ^= ( hash >>> 33 ) ;
return hash ;
}
public final void start ( final int seed ) {
unprocessedLength = totalLen = 0 ;
this . hash = seed ;
}
public final void add ( final byte [] data , final int offset , final int length ) {
if ( length <= 0 ) {
return;
}
totalLen += length ;
if ( unprocessedLength + length - BLOCK_SIZE < 0 ) {
System . arraycopy ( data , offset , unprocessed , unprocessedLength , length ) ;
unprocessedLength += length ;
return;
}
int newOffset ;
int newLength ;
if ( unprocessedLength > 0 ) {
int k = - 1 ;
switch ( unprocessedLength ) {
case 1 :
k = orBytes ( unprocessed [ 0 ] , data [ offset ] , data [ offset + 1 ] , data [ offset + 2 ] ) ;
break;
case 2 :
k = orBytes ( unprocessed [ 0 ] , unprocessed [ 1 ] , data [ offset ] , data [ offset + 1 ] ) ;
break;
case 3 :
k = orBytes ( unprocessed [ 0 ] , unprocessed [ 1 ] , unprocessed [ 2 ] , data [ offset ] ) ;
break;
default:
throw new IllegalStateException ( lr_1 + unprocessedLength ) ;
}
hash = mix32 ( k , hash ) ; MST[rv.UOI4Mutator]MSP[N]
final int consumed = BLOCK_SIZE - unprocessedLength ;
newOffset = offset + consumed ;
newLength = length - consumed ;
} else {
newOffset = offset ;
newLength = length ;
}
final int nblocks = newLength >> 2 ;
for ( int i = 0 ; i < nblocks ; i ++ ) {
final int index = newOffset + ( i << 2 ) ;
final int k = getLittleEndianInt ( data , index ) ;
hash = mix32 ( k , hash ) ;
}
final int consumed = ( nblocks << 2 ) ;
unprocessedLength = newLength - consumed ;
if ( unprocessedLength != 0 ) {
System . arraycopy ( data , newOffset + consumed , unprocessed , 0 , unprocessedLength ) ;
}
}
public final int end () {
return finalise ( hash , unprocessedLength , unprocessed , totalLen ) ;
}
int finalise ( final int hash , final int unprocessedLength , final byte [] unprocessed , final int totalLen ) {
int result = hash ;
int k1 = 0 ;
switch ( unprocessedLength ) {
case 3 :
k1 ^= ( unprocessed [ 2 ] & 0xff ) << 16 ;
case 2 :
k1 ^= ( unprocessed [ 1 ] & 0xff ) << 8 ;
case 1 :
k1 ^= ( unprocessed [ 0 ] & 0xff ) ;
k1 *= C1_32 ;
k1 = Integer . rotateLeft ( k1 , R1_32 ) ;
k1 *= C2_32 ;
result ^= k1 ;
}
result ^= totalLen ;
return fmix32 ( result ) ;
}
private static int orBytes ( final byte b1 , final byte b2 , final byte b3 , final byte b4 ) {
return ( b1 & 0xff ) | ( ( b2 & 0xff ) << 8 ) | ( ( b3 & 0xff ) << 16 ) | ( ( b4 & 0xff ) << 24 ) ;
}
@Override
@Deprecated
int finalise ( final int hash , final int unprocessedLength , final byte [] unprocessed , final int totalLen ) {
int result = hash ;
int k1 = 0 ;
switch ( unprocessedLength ) {
case 3 :
k1 ^= unprocessed [ 2 ] << 16 ;
case 2 :
k1 ^= unprocessed [ 1 ] << 8 ;
case 1 :
k1 ^= unprocessed [ 0 ] ;
k1 *= C1_32 ;
k1 = Integer . rotateLeft ( k1 , R1_32 ) ;
k1 *= C2_32 ;
result ^= k1 ;
}
result ^= totalLen ;
return fmix32 ( result ) ;
}
