public static byte [] decodeHex ( final char [] data ) throws DecoderException {
final byte [] out = new byte [ data . length >> 1 ] ;
decodeHex ( data , out , 0 ) ;
return out ;
}
public static int decodeHex ( final char [] data , final byte [] out , final int outOffset ) throws DecoderException {
final int len = data . length ;
if ( ( len & 0x01 ) != 0 ) {
throw new DecoderException ( lr_1 ) ;
}
final int outLen = len >> 1 ;
if ( out . length - outOffset < outLen ) {
throw new DecoderException ( lr_2 ) ;
}
for ( int i = outOffset , j = 0 ; j < len ; i ++ ) { MST[rv.ROR2Mutator]MSP[]
int f = toDigit ( data [ j ] , j ) << 4 ;
j ++ ;
f = f | toDigit ( data [ j ] , j ) ;
j ++ ;
out [ i ] = (byte) ( f & 0xFF ) ;
}
return outLen ;
}
public static byte [] decodeHex ( final String data ) throws DecoderException {
return decodeHex ( data . toCharArray () ) ;
}
public static char [] encodeHex ( final byte [] data ) {
return encodeHex ( data , true ) ;
}
public static char [] encodeHex ( final byte [] data , final boolean toLowerCase ) {
return encodeHex ( data , toLowerCase ? DIGITS_LOWER : DIGITS_UPPER ) ;
}
protected static char [] encodeHex ( final byte [] data , final char [] toDigits ) {
final int l = data . length ;
final char [] out = new char [ l << 1 ] ;
encodeHex ( data , 0 , data . length , toDigits , out , 0 ) ;
return out ;
}
public static char [] encodeHex ( final byte [] data , final int dataOffset , final int dataLen ,
final boolean toLowerCase ) {
final char [] out = new char [ dataLen << 1 ] ;
encodeHex ( data , dataOffset , dataLen , toLowerCase ? DIGITS_LOWER : DIGITS_UPPER , out , 0 ) ;
return out ;
}
public static void encodeHex ( final byte [] data , final int dataOffset , final int dataLen ,
final boolean toLowerCase , final char [] out , final int outOffset ) {
encodeHex ( data , dataOffset , dataLen , toLowerCase ? DIGITS_LOWER : DIGITS_UPPER , out , outOffset ) ;
}
private static void encodeHex ( final byte [] data , final int dataOffset , final int dataLen , final char [] toDigits ,
final char [] out , final int outOffset ) {
for ( int i = dataOffset , j = outOffset ; i < dataOffset + dataLen ; i ++ ) {
out [ j ++ ] = toDigits [ ( 0xF0 & data [ i ] ) >>> 4 ] ;
out [ j ++ ] = toDigits [ 0x0F & data [ i ] ] ;
}
}
public static char [] encodeHex ( final ByteBuffer data ) {
return encodeHex ( data , true ) ;
}
public static char [] encodeHex ( final ByteBuffer data , final boolean toLowerCase ) {
return encodeHex ( data , toLowerCase ? DIGITS_LOWER : DIGITS_UPPER ) ;
}
protected static char [] encodeHex ( final ByteBuffer byteBuffer , final char [] toDigits ) {
return encodeHex ( toByteArray ( byteBuffer ) , toDigits ) ;
}
public static String encodeHexString ( final byte [] data ) {
return new String ( encodeHex ( data ) ) ;
}
public static String encodeHexString ( final byte [] data , final boolean toLowerCase ) {
return new String ( encodeHex ( data , toLowerCase ) ) ;
}
public static String encodeHexString ( final ByteBuffer data ) {
return new String ( encodeHex ( data ) ) ;
}
public static String encodeHexString ( final ByteBuffer data , final boolean toLowerCase ) {
return new String ( encodeHex ( data , toLowerCase ) ) ;
}
private static byte [] toByteArray ( final ByteBuffer byteBuffer ) {
final int remaining = byteBuffer . remaining () ;
if ( byteBuffer . hasArray () ) {
final byte [] byteArray = byteBuffer . array () ;
if ( remaining == byteArray . length ) {
byteBuffer . position ( remaining ) ;
return byteArray ;
}
}
final byte [] byteArray = new byte [ remaining ] ;
byteBuffer . get ( byteArray ) ;
return byteArray ;
}
protected static int toDigit ( final char ch , final int index ) throws DecoderException {
final int digit = Character . digit ( ch , 16 ) ;
if ( digit == - 1 ) {
throw new DecoderException ( lr_3 + ch + lr_4 + index ) ;
}
return digit ;
}
@Override
public byte [] decode ( final byte [] array ) throws DecoderException {
return decodeHex ( new String ( array , getCharset () ) . toCharArray () ) ;
}
public byte [] decode ( final ByteBuffer buffer ) throws DecoderException {
return decodeHex ( new String ( toByteArray ( buffer ) , getCharset () ) . toCharArray () ) ;
}
@Override
public Object decode ( final Object object ) throws DecoderException {
if ( object instanceof String ) {
return decode ( ( ( String ) object ) . toCharArray () ) ;
} else if ( object instanceof byte [] ) {
return decode ( ( byte [] ) object ) ;
} else if ( object instanceof ByteBuffer ) {
return decode ( ( ByteBuffer ) object ) ;
} else {
try {
return decodeHex ( ( char [] ) object ) ;
} catch ( final ClassCastException e ) {
throw new DecoderException ( e . getMessage () , e ) ;
}
}
}
@Override
public byte [] encode ( final byte [] array ) {
return encodeHexString ( array ) . getBytes ( this . getCharset () ) ;
}
public byte [] encode ( final ByteBuffer array ) {
return encodeHexString ( array ) . getBytes ( this . getCharset () ) ;
}
@Override
public Object encode ( final Object object ) throws EncoderException {
byte [] byteArray ;
if ( object instanceof String ) {
byteArray = ( ( String ) object ) . getBytes ( this . getCharset () ) ;
} else if ( object instanceof ByteBuffer ) {
byteArray = toByteArray ( ( ByteBuffer ) object ) ;
} else {
try {
byteArray = ( byte [] ) object ;
} catch ( final ClassCastException e ) {
throw new EncoderException ( e . getMessage () , e ) ;
}
}
return encodeHex ( byteArray ) ;
}
public Charset getCharset () {
return this . charset ;
}
public String getCharsetName () {
return this . charset . name () ;
}
@Override
public String toString () {
return super . toString () + lr_5 + this . charset + lr_6 ;
}
