public static String crypt ( final byte [] original ) {
return crypt ( original , null ) ;
}
public static String crypt ( final byte [] original , String salt ) {
if ( salt == null ) {
final ThreadLocalRandom randomGenerator = ThreadLocalRandom . current () ;
final int numSaltChars = SALT_CHARS . length ;
salt = lr_1 + SALT_CHARS [ randomGenerator . nextInt ( numSaltChars ) ] +
SALT_CHARS [ randomGenerator . nextInt ( numSaltChars ) ] ;
} else if ( ! salt . matches ( lr_2 + B64 . B64T_STRING + lr_3 ) ) {
throw new IllegalArgumentException ( lr_4 + salt ) ;
}
final StringBuilder buffer = new StringBuilder ( lr_5 ) ;
final char charZero = salt . charAt ( 0 ) ;
final char charOne = salt . charAt ( 1 ) ;
buffer . setCharAt ( 0 , charZero ) ;
buffer . setCharAt ( 1 , charOne ) ;
final int eSwap0 = CON_SALT [ charZero ] ;
final int eSwap1 = CON_SALT [ charOne ] << 4 ;
final byte key [] = new byte [ 8 ] ;
for ( int i = 0 ; i < key . length ; i ++ ) {
key [ i ] = 0 ;
}
for ( int i = 0 ; i < key . length && i < original . length ; i ++ ) {
final int iChar = original [ i ] ;
key [ i ] = (byte) ( iChar << 1 ) ;
}
final int schedule [] = desSetKey ( key ) ;
final int out [] = body ( schedule , eSwap0 , eSwap1 ) ;
final byte b [] = new byte [ 9 ] ;
intToFourBytes ( out [ 0 ] , b , 0 ) ;
intToFourBytes ( out [ 1 ] , b , 4 ) ;
b [ 8 ] = 0 ;
int i = 2 ;
int y = 0 ;
int u = 128 ;
for (; i < 13 ; i ++ ) {
int j = 0 ;
int c = 0 ;
for (; j < 6 ; j ++ ) {
c <<= 1 ;
if ( ( b [ y ] & u ) != 0 ) {
c |= 0x1 ;
}
u >>>= 1 ;
if ( u == 0 ) {
y ++ ;
u = 128 ;
}
buffer . setCharAt ( i , ( char ) COV2CHAR [ c ] ) ;
}
}
return buffer . toString () ;
}
public static String crypt ( final String original ) {
return crypt ( original . getBytes ( StandardCharsets . UTF_8 ) ) ;
}
public static String crypt ( final String original , final String salt ) {
return crypt ( original . getBytes ( StandardCharsets . UTF_8 ) , salt ) ;
}
private static int [] body ( final int schedule [] , final int eSwap0 , final int eSwap1 ) {
int left = 0 ;
int right = 0 ;
int t = 0 ;
for ( int j = 0 ; j < 25 ; j ++ ) {
for ( int i = 0 ; i < 32 ; i += 4 ) {
left = dEncrypt ( left , right , i , eSwap0 , eSwap1 , schedule ) ;
right = dEncrypt ( right , left , i + 2 , eSwap0 , eSwap1 , schedule ) ;
}
t = left ;
left = right ;
right = t ;
}
t = right ;
right = left >>> 1 | left << 31 ;
left = t >>> 1 | t << 31 ;
final int results [] = new int [ 2 ] ;
permOp ( right , left , 1 , 0x55555555 , results ) ;
right = results [ 0 ] ;
left = results [ 1 ] ;
permOp ( left , right , 8 , 0xff00ff , results ) ;
left = results [ 0 ] ;
right = results [ 1 ] ;
permOp ( right , left , 2 , 0x33333333 , results ) ;
right = results [ 0 ] ;
left = results [ 1 ] ;
permOp ( left , right , 16 , 65535 , results ) ;
left = results [ 0 ] ;
right = results [ 1 ] ;
permOp ( right , left , 4 , 0xf0f0f0f , results ) ;
right = results [ 0 ] ;
left = results [ 1 ] ;
final int out [] = new int [ 2 ] ;
out [ 0 ] = left ;
out [ 1 ] = right ;
return out ;
}
private static int byteToUnsigned ( final byte b ) {
final int value = b ;
return value < 0 ? value + 256 : value ;
}
private static int dEncrypt ( int el , final int r , final int s , final int e0 , final int e1 , final int sArr [] ) {
int v = r ^ r >>> 16 ;
int u = v & e0 ;
v &= e1 ;
u = u ^ u << 16 ^ r ^ sArr [ s ] ;
int t = v ^ v << 16 ^ r ^ sArr [ s + 1 ] ;
t = t >>> 4 | t << 28 ;
el ^= SPTRANS [ 1 ] [ t & 0x3f ] | SPTRANS [ 3 ] [ t >>> 8 & 0x3f ] | SPTRANS [ 5 ] [ t >>> 16 & 0x3f ] |
SPTRANS [ 7 ] [ t >>> 24 & 0x3f ] | SPTRANS [ 0 ] [ u & 0x3f ] | SPTRANS [ 2 ] [ u >>> 8 & 0x3f ] |
SPTRANS [ 4 ] [ u >>> 16 & 0x3f ] | SPTRANS [ 6 ] [ u >>> 24 & 0x3f ] ;
return el ;
}
private static int [] desSetKey ( final byte key [] ) {
final int schedule [] = new int [ 32 ] ;
int c = fourBytesToInt ( key , 0 ) ;
int d = fourBytesToInt ( key , 4 ) ;
final int results [] = new int [ 2 ] ;
permOp ( d , c , 4 , 0xf0f0f0f , results ) ;
d = results [ 0 ] ;
c = results [ 1 ] ;
c = hPermOp ( c , - 2 , 0xcccc0000 ) ;
d = hPermOp ( d , - 2 , 0xcccc0000 ) ;
permOp ( d , c , 1 , 0x55555555 , results ) ;
d = results [ 0 ] ;
c = results [ 1 ] ;
permOp ( c , d , 8 , 0xff00ff , results ) ;
c = results [ 0 ] ;
d = results [ 1 ] ;
permOp ( d , c , 1 , 0x55555555 , results ) ;
d = results [ 0 ] ;
c = results [ 1 ] ;
d = ( d & 0xff ) << 16 | d & 0xff00 | ( d & 0xff0000 ) >>> 16 | ( c & 0xf0000000 ) >>> 4 ;
c &= 0xfffffff ;
int j = 0 ;
for ( int i = 0 ; i < 16 ; i ++ ) {
if ( SHIFT2 [ i ] ) {
c = c >>> 2 | c << 26 ;
d = d >>> 2 | d << 26 ;
} else {
c = c >>> 1 | c << 27 ;
d = d >>> 1 | d << 27 ;
}
c &= 0xfffffff ;
d &= 0xfffffff ;
int s = SKB [ 0 ] [ c & 0x3f ] | SKB [ 1 ] [ c >>> 6 & 0x3 | c >>> 7 & 0x3c ] |
SKB [ 2 ] [ c >>> 13 & 0xf | c >>> 14 & 0x30 ] |
SKB [ 3 ] [ c >>> 20 & 0x1 | c >>> 21 & 0x6 | c >>> 22 & 0x38 ] ;
final int t = SKB [ 4 ] [ d & 0x3f ] | SKB [ 5 ] [ d >>> 7 & 0x3 | d >>> 8 & 0x3c ] | SKB [ 6 ] [ d >>> 15 & 0x3f ] |
SKB [ 7 ] [ d >>> 21 & 0xf | d >>> 22 & 0x30 ] ;
schedule [ j ++ ] = ( t << 16 | s & 0xffff ) ;
s = s >>> 16 | t & 0xffff0000 ;
s = s << 4 | s >>> 28 ;
schedule [ j ++ ] = s ;
}
return schedule ;
}
private static int fourBytesToInt ( final byte b [] , int offset ) {
int value = byteToUnsigned ( b [ offset ++ ] ) ;
value |= byteToUnsigned ( b [ offset ++ ] ) << 8 ;
value |= byteToUnsigned ( b [ offset ++ ] ) << 16 ;
value |= byteToUnsigned ( b [ offset ++ ] ) << 24 ;
return value ;
}
private static int hPermOp ( int a , final int n , final int m ) {
final int t = ( a << 16 - n ^ a ) & m ;
a = a ^ t ^ t >>> 16 - n ;
return a ;
}
private static void intToFourBytes ( final int iValue , final byte b [] , int offset ) {
b [ offset ++ ] = (byte) ( iValue & 0xff ) ;
b [ offset ++ ] = (byte) ( iValue >>> 8 & 0xff ) ; MST[MathMutator]MSP[N]
b [ offset ++ ] = (byte) ( iValue >>> 16 & 0xff ) ;
b [ offset ++ ] = (byte) ( iValue >>> 24 & 0xff ) ;
}
private static void permOp ( int a , int b , final int n , final int m , final int results [] ) {
final int t = ( a >>> n ^ b ) & m ;
a ^= t << n ;
b ^= t ;
results [ 0 ] = a ;
results [ 1 ] = b ;
}
