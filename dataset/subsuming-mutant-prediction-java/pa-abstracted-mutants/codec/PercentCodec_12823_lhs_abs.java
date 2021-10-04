private void insertAlwaysEncodeChars ( final byte [] alwaysEncodeCharsArray ) {
if ( alwaysEncodeCharsArray != null ) {
for ( final byte b : alwaysEncodeCharsArray ) {
insertAlwaysEncodeChar ( b ) ;
}
}
insertAlwaysEncodeChar ( ESCAPE_CHAR ) ;
}
private void insertAlwaysEncodeChar ( final byte b ) {
this . alwaysEncodeChars . set ( b ) ;
if ( b < alwaysEncodeCharsMin ) {
alwaysEncodeCharsMin = b ;
}
if ( b > alwaysEncodeCharsMax ) {
alwaysEncodeCharsMax = b ;
}
}
@Override
public byte [] encode ( final byte [] bytes ) throws EncoderException {
if ( bytes == null ) {
return null ;
}
final int expectedEncodingBytes = expectedEncodingBytes ( bytes ) ;
final boolean willEncode = expectedEncodingBytes != bytes . length ;
if ( willEncode || ( plusForSpace && containsSpace ( bytes ) ) ) {
return doEncode ( bytes , expectedEncodingBytes , willEncode ) ;
}
return bytes ;
}
private byte [] doEncode ( final byte [] bytes , final int expectedLength , final boolean willEncode ) {
final ByteBuffer buffer = ByteBuffer . allocate ( expectedLength ) ;
for ( final byte b : bytes ) {
if ( willEncode && canEncode ( b ) ) {
byte bb = b ;
if ( bb < 0 ) {
bb = (byte) ( 256 + bb ) ;
}
final char hex1 = Utils . hexDigit ( bb >> 4 ) ;
final char hex2 = Utils . hexDigit ( bb ) ;
buffer . put ( ESCAPE_CHAR ) ;
buffer . put ( ( byte ) hex1 ) ;
buffer . put ( ( byte ) hex2 ) ;
} else {
if ( plusForSpace && b == ' ' ) {
buffer . put ( ( byte ) '+' ) ;
} else {
buffer . put ( b ) ;
}
}
}
return buffer . array () ;
}
private int expectedEncodingBytes ( final byte [] bytes ) {
int byteCount = 0 ;
for ( final byte b : bytes ) {
byteCount += canEncode ( b ) ? 3 : 1 ;
}
return byteCount ;
}
private boolean containsSpace ( final byte [] bytes ) {
for ( final byte b : bytes ) {
if ( b == ' ' ) {
return true ;
}
}
return false ;
}
private boolean canEncode ( final byte c ) {
return ! isAsciiChar ( c ) || ( inAlwaysEncodeCharsRange ( c ) && alwaysEncodeChars . get ( c ) ) ;
}
private boolean inAlwaysEncodeCharsRange ( final byte c ) {
return c >= alwaysEncodeCharsMin && c <= alwaysEncodeCharsMax ;
}
private boolean isAsciiChar ( final byte c ) {
return c >= 0 ;
}
@Override
public byte [] decode ( final byte [] bytes ) throws DecoderException {
if ( bytes == null ) {
return null ;
}
final ByteBuffer buffer = ByteBuffer . allocate ( expectedDecodingBytes ( bytes ) ) ;
for ( int i = 0 ; i < bytes . length ; i ++ ) {
final byte b = bytes [ i ] ;
if ( b == ESCAPE_CHAR ) {
try {
final int u = Utils . digit16 ( bytes [ ++ i ] ) ;
final int l = Utils . digit16 ( bytes [ ++ i ] ) ;
buffer . put ( (byte) ( ( u << 4 ) + l ) ) ;
} catch ( final ArrayIndexOutOfBoundsException e ) {
throw new DecoderException ( lr_1 , e ) ;
}
} else {
if ( plusForSpace && b == '+' ) {
buffer . put ( ( byte ) ' ' ) ;
} else {
buffer . put ( b ) ;
}
}
}
return buffer . array () ;
}
private int expectedDecodingBytes ( final byte [] bytes ) {
int byteCount = 0 ;
for ( int i = 0 ; i < bytes . length ; ) {
final byte b = bytes [ i ] ;
i += b == ESCAPE_CHAR ? 3 : 1 ;
byteCount ++ ;
}
return byteCount ; MST[rv.UOI2Mutator]MSP[]
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( obj == null ) {
return null ;
} else if ( obj instanceof byte [] ) {
return encode ( ( byte [] ) obj ) ;
} else {
throw new EncoderException ( lr_2 + obj . getClass () . getName () + lr_3 ) ;
}
}
@Override
public Object decode ( final Object obj ) throws DecoderException {
if ( obj == null ) {
return null ;
} else if ( obj instanceof byte [] ) {
return decode ( ( byte [] ) obj ) ;
} else {
throw new DecoderException ( lr_2 + obj . getClass () . getName () + lr_4 ) ;
}
}
