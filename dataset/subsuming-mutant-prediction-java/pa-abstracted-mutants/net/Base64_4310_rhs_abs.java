public boolean isUrlSafe () {
return this . encodeTable == URL_SAFE_ENCODE_TABLE ;
}
boolean hasData () {
return this . buffer != null ;
}
int avail () {
return buffer != null ? pos - readPos : 0 ;
}
private void resizeBuffer () {
if ( buffer == null ) {
buffer = new byte [ DEFAULT_BUFFER_SIZE ] ;
pos = 0 ;
readPos = 0 ;
} else {
final byte [] b = new byte [ buffer . length * DEFAULT_BUFFER_RESIZE_FACTOR ] ;
System . arraycopy ( buffer , 0 , b , 0 , buffer . length ) ;
buffer = b ;
}
}
int readResults ( final byte [] b , final int bPos , final int bAvail ) {
if ( buffer != null ) {
final int len = Math . min ( avail () , bAvail ) ;
if ( buffer != b ) {
System . arraycopy ( buffer , readPos , b , bPos , len ) ;
readPos += len ;
if ( readPos >= pos ) {
buffer = null ;
}
} else {
buffer = null ;
}
return len ;
}
return eof ? - 1 : 0 ;
}
void setInitialBuffer ( final byte [] out , final int outPos , final int outAvail ) { MST[rv.UOI2Mutator]MSP[S]
if ( out != null && out . length == outAvail ) {
buffer = out ;
pos = outPos ;
readPos = outPos ;
}
}
void encode ( final byte [] in , int inPos , final int inAvail ) {
if ( eof ) {
return;
}
if ( inAvail < 0 ) {
eof = true ;
if ( buffer == null || buffer . length - pos < encodeSize ) {
resizeBuffer () ;
}
switch ( modulus ) {
case 1 :
buffer [ pos ++ ] = encodeTable [ ( x >> 2 ) & MASK_6BITS ] ;
buffer [ pos ++ ] = encodeTable [ ( x << 4 ) & MASK_6BITS ] ;
if ( encodeTable == STANDARD_ENCODE_TABLE ) {
buffer [ pos ++ ] = PAD ;
buffer [ pos ++ ] = PAD ;
}
break;
case 2 :
buffer [ pos ++ ] = encodeTable [ ( x >> 10 ) & MASK_6BITS ] ;
buffer [ pos ++ ] = encodeTable [ ( x >> 4 ) & MASK_6BITS ] ;
buffer [ pos ++ ] = encodeTable [ ( x << 2 ) & MASK_6BITS ] ;
if ( encodeTable == STANDARD_ENCODE_TABLE ) {
buffer [ pos ++ ] = PAD ;
}
break;
default:
break;
}
if ( lineLength > 0 && pos > 0 ) {
System . arraycopy ( lineSeparator , 0 , buffer , pos , lineSeparator . length ) ;
pos += lineSeparator . length ;
}
} else {
for ( int i = 0 ; i < inAvail ; i ++ ) {
if ( buffer == null || buffer . length - pos < encodeSize ) {
resizeBuffer () ;
}
modulus = ( ++ modulus ) % 3 ;
int b = in [ inPos ++ ] ;
if ( b < 0 ) {
b += 256 ;
}
x = ( x << 8 ) + b ;
if ( 0 == modulus ) {
buffer [ pos ++ ] = encodeTable [ ( x >> 18 ) & MASK_6BITS ] ;
buffer [ pos ++ ] = encodeTable [ ( x >> 12 ) & MASK_6BITS ] ;
buffer [ pos ++ ] = encodeTable [ ( x >> 6 ) & MASK_6BITS ] ;
buffer [ pos ++ ] = encodeTable [ x & MASK_6BITS ] ;
currentLinePos += 4 ;
if ( lineLength > 0 && lineLength <= currentLinePos ) {
System . arraycopy ( lineSeparator , 0 , buffer , pos , lineSeparator . length ) ;
pos += lineSeparator . length ;
currentLinePos = 0 ;
}
}
}
}
}
void decode ( final byte [] in , int inPos , final int inAvail ) {
if ( eof ) {
return;
}
if ( inAvail < 0 ) {
eof = true ;
}
for ( int i = 0 ; i < inAvail ; i ++ ) {
if ( buffer == null || buffer . length - pos < decodeSize ) {
resizeBuffer () ;
}
final byte b = in [ inPos ++ ] ;
if ( b == PAD ) {
eof = true ;
break;
}
if ( b >= 0 && b < DECODE_TABLE . length ) {
final int result = DECODE_TABLE [ b ] ;
if ( result >= 0 ) {
modulus = ( ++ modulus ) % 4 ;
x = ( x << 6 ) + result ;
if ( modulus == 0 ) {
buffer [ pos ++ ] = (byte) ( ( x >> 16 ) & MASK_8BITS ) ;
buffer [ pos ++ ] = (byte) ( ( x >> 8 ) & MASK_8BITS ) ;
buffer [ pos ++ ] = (byte) ( x & MASK_8BITS ) ;
}
}
}
}
if ( eof && modulus != 0 ) {
x = x << 6 ;
switch ( modulus ) {
case 2 :
x = x << 6 ;
buffer [ pos ++ ] = (byte) ( ( x >> 16 ) & MASK_8BITS ) ;
break;
case 3 :
buffer [ pos ++ ] = (byte) ( ( x >> 16 ) & MASK_8BITS ) ;
buffer [ pos ++ ] = (byte) ( ( x >> 8 ) & MASK_8BITS ) ;
break;
default:
break;
}
}
}
public static boolean isBase64 ( final byte octet ) {
return octet == PAD || ( octet >= 0 && octet < DECODE_TABLE . length && DECODE_TABLE [ octet ] != - 1 ) ;
}
public static boolean isArrayByteBase64 ( final byte [] arrayOctet ) {
for ( final byte element : arrayOctet ) {
if ( ! isBase64 ( element ) && ! isWhiteSpace ( element ) ) {
return false ;
}
}
return true ;
}
private static boolean containsBase64Byte ( final byte [] arrayOctet ) {
for ( final byte element : arrayOctet )
{
if ( isBase64 ( element ) ) {
return true ;
}
}
return false ;
}
public static byte [] encodeBase64 ( final byte [] binaryData ) {
return encodeBase64 ( binaryData , false ) ;
}
public static String encodeBase64String ( final byte [] binaryData ) {
return newStringUtf8 ( encodeBase64 ( binaryData , true ) ) ;
}
public static String encodeBase64StringUnChunked ( final byte [] binaryData ) {
return newStringUtf8 ( encodeBase64 ( binaryData , false ) ) ;
}
public static String encodeBase64String ( final byte [] binaryData , final boolean useChunking ) {
return newStringUtf8 ( encodeBase64 ( binaryData , useChunking ) ) ;
}
public static byte [] encodeBase64URLSafe ( final byte [] binaryData ) {
return encodeBase64 ( binaryData , false , true ) ;
}
public static String encodeBase64URLSafeString ( final byte [] binaryData ) {
return newStringUtf8 ( encodeBase64 ( binaryData , false , true ) ) ;
}
public static byte [] encodeBase64Chunked ( final byte [] binaryData ) {
return encodeBase64 ( binaryData , true ) ;
}
public byte [] decode ( final String pArray ) {
return decode ( getBytesUtf8 ( pArray ) ) ;
}
private byte [] getBytesUtf8 ( final String pArray ) {
try {
return pArray . getBytes ( lr_1 ) ;
} catch ( final UnsupportedEncodingException e ) {
throw new RuntimeException ( e ) ;
}
}
public byte [] decode ( final byte [] pArray ) {
reset () ;
if ( pArray == null || pArray . length == 0 ) {
return pArray ;
}
final long len = ( pArray . length * 3 ) / 4 ;
final byte [] buf = new byte [ ( int ) len ] ;
setInitialBuffer ( buf , 0 , buf . length ) ;
decode ( pArray , 0 , pArray . length ) ;
decode ( pArray , 0 , - 1 ) ;
final byte [] result = new byte [ pos ] ;
readResults ( result , 0 , result . length ) ;
return result ;
}
public static byte [] encodeBase64 ( final byte [] binaryData , final boolean isChunked ) {
return encodeBase64 ( binaryData , isChunked , false ) ;
}
public static byte [] encodeBase64 ( final byte [] binaryData , final boolean isChunked , final boolean urlSafe ) {
return encodeBase64 ( binaryData , isChunked , urlSafe , Integer . MAX_VALUE ) ;
}
public static byte [] encodeBase64 ( final byte [] binaryData , final boolean isChunked , final boolean urlSafe ,
final int maxResultSize ) {
if ( binaryData == null || binaryData . length == 0 ) {
return binaryData ;
}
final long len = getEncodeLength ( binaryData , isChunked ? CHUNK_SIZE : 0 ,
isChunked ? CHUNK_SEPARATOR : EMPTY_BYTE_ARRAY ) ;
if ( len > maxResultSize ) {
throw new IllegalArgumentException ( lr_2 + len
+ lr_3 + maxResultSize ) ;
}
final Base64 b64 = isChunked ? new Base64 ( urlSafe ) : new Base64 ( 0 , CHUNK_SEPARATOR , urlSafe ) ;
return b64 . encode ( binaryData ) ;
}
public static byte [] decodeBase64 ( final String base64String ) {
return new Base64 () . decode ( base64String ) ;
}
public static byte [] decodeBase64 ( final byte [] base64Data ) {
return new Base64 () . decode ( base64Data ) ;
}
private static boolean isWhiteSpace ( final byte byteToCheck ) {
switch ( byteToCheck ) {
case ' ' :
case '\n' :
case '\r' :
case '\t' :
return true ;
default :
return false ;
}
}
public String encodeToString ( final byte [] pArray ) {
return newStringUtf8 ( encode ( pArray ) ) ;
}
private static String newStringUtf8 ( final byte [] encode ) {
String str = null ;
try {
str = new String ( encode , lr_1 ) ;
} catch ( final UnsupportedEncodingException ue ) {
throw new RuntimeException ( ue ) ;
}
return str ;
}
public byte [] encode ( final byte [] pArray ) {
reset () ;
if ( pArray == null || pArray . length == 0 ) {
return pArray ;
}
final long len = getEncodeLength ( pArray , lineLength , lineSeparator ) ;
byte [] buf = new byte [ ( int ) len ] ;
setInitialBuffer ( buf , 0 , buf . length ) ;
encode ( pArray , 0 , pArray . length ) ;
encode ( pArray , 0 , - 1 ) ;
if ( buffer != buf ) {
readResults ( buf , 0 , buf . length ) ;
}
if ( isUrlSafe () && pos < buf . length ) {
final byte [] smallerBuf = new byte [ pos ] ;
System . arraycopy ( buf , 0 , smallerBuf , 0 , pos ) ;
buf = smallerBuf ;
}
return buf ;
}
private static long getEncodeLength ( final byte [] pArray , int chunkSize , final byte [] chunkSeparator ) {
chunkSize = ( chunkSize / 4 ) * 4 ;
long len = ( pArray . length * 4 ) / 3 ;
final long mod = len % 4 ;
if ( mod != 0 ) {
len += 4 - mod ;
}
if ( chunkSize > 0 ) {
final boolean lenChunksPerfectly = len % chunkSize == 0 ;
len += ( len / chunkSize ) * chunkSeparator . length ;
if ( ! lenChunksPerfectly ) {
len += chunkSeparator . length ;
}
}
return len ;
}
public static BigInteger decodeInteger ( final byte [] pArray ) {
return new BigInteger ( 1 , decodeBase64 ( pArray ) ) ;
}
public static byte [] encodeInteger ( final BigInteger bigInt ) {
if ( bigInt == null ) {
throw new NullPointerException ( lr_4 ) ;
}
return encodeBase64 ( toIntegerBytes ( bigInt ) , false ) ;
}
static byte [] toIntegerBytes ( final BigInteger bigInt ) {
int bitlen = bigInt . bitLength () ;
bitlen = ( ( bitlen + 7 ) >> 3 ) << 3 ;
final byte [] bigBytes = bigInt . toByteArray () ;
if ( ( ( bigInt . bitLength () % 8 ) != 0 ) && ( ( ( bigInt . bitLength () / 8 ) + 1 ) == ( bitlen / 8 ) ) ) {
return bigBytes ;
}
int startSrc = 0 ;
int len = bigBytes . length ;
if ( ( bigInt . bitLength () % 8 ) == 0 ) {
startSrc = 1 ;
len -- ;
}
final int startDst = bitlen / 8 - len ;
final byte [] resizedBytes = new byte [ bitlen / 8 ] ;
System . arraycopy ( bigBytes , startSrc , resizedBytes , startDst , len ) ;
return resizedBytes ;
}
private void reset () {
buffer = null ;
pos = 0 ;
readPos = 0 ;
currentLinePos = 0 ;
modulus = 0 ;
eof = false ;
}
int getLineLength () {
return lineLength ;
}
byte [] getLineSeparator () {
return lineSeparator . clone () ;
}
