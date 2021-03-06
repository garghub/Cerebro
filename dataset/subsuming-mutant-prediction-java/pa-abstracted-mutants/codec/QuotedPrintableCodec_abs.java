private static final int encodeQuotedPrintable ( final int b , final ByteArrayOutputStream buffer ) {
buffer . write ( ESCAPE_CHAR ) ;
final char hex1 = Utils . hexDigit ( b >> 4 ) ;
final char hex2 = Utils . hexDigit ( b ) ;
buffer . write ( hex1 ) ;
buffer . write ( hex2 ) ;
return 3 ;
}
private static int getUnsignedOctet ( final int index , final byte [] bytes ) {
int b = bytes [ index ] ;
if ( b < 0 ) {
b = 256 + b ;
}
return b ;
}
private static int encodeByte ( final int b , final boolean encode ,
final ByteArrayOutputStream buffer ) {
if ( encode ) {
return encodeQuotedPrintable ( b , buffer ) ;
}
buffer . write ( b ) ;
return 1 ;
}
private static boolean isWhitespace ( final int b ) {
return b == SPACE || b == TAB ;
}
public static final byte [] encodeQuotedPrintable ( final BitSet printable , final byte [] bytes ) {
return encodeQuotedPrintable ( printable , bytes , false ) ;
}
public static final byte [] encodeQuotedPrintable ( BitSet printable , final byte [] bytes , final boolean strict ) {
if ( bytes == null ) {
return null ;
}
if ( printable == null ) {
printable = PRINTABLE_CHARS ;
}
final ByteArrayOutputStream buffer = new ByteArrayOutputStream () ;
if ( strict ) {
int pos = 1 ;
for ( int i = 0 ; i < bytes . length - 3 ; i ++ ) {
final int b = getUnsignedOctet ( i , bytes ) ;
if ( pos < SAFE_LENGTH ) {
pos += encodeByte ( b , ! printable . get ( b ) , buffer ) ;
} else {
encodeByte ( b , ! printable . get ( b ) || isWhitespace ( b ) , buffer ) ;
buffer . write ( ESCAPE_CHAR ) ;
buffer . write ( CR ) ;
buffer . write ( LF ) ;
pos = 1 ;
}
}
int b = getUnsignedOctet ( bytes . length - 3 , bytes ) ;
boolean encode = ! printable . get ( b ) || ( isWhitespace ( b ) && pos > SAFE_LENGTH - 5 ) ;
pos += encodeByte ( b , encode , buffer ) ;
if ( pos > SAFE_LENGTH - 2 ) {
buffer . write ( ESCAPE_CHAR ) ;
buffer . write ( CR ) ;
buffer . write ( LF ) ;
}
for ( int i = bytes . length - 2 ; i < bytes . length ; i ++ ) {
b = getUnsignedOctet ( i , bytes ) ;
encode = ! printable . get ( b ) || ( i > bytes . length - 2 && isWhitespace ( b ) ) ;
encodeByte ( b , encode , buffer ) ;
}
} else {
for ( final byte c : bytes ) {
int b = c ;
if ( b < 0 ) {
b = 256 + b ;
}
if ( printable . get ( b ) ) {
buffer . write ( b ) ;
} else {
encodeQuotedPrintable ( b , buffer ) ;
}
}
}
return buffer . toByteArray () ;
}
public static final byte [] decodeQuotedPrintable ( final byte [] bytes ) throws DecoderException {
if ( bytes == null ) {
return null ;
}
final ByteArrayOutputStream buffer = new ByteArrayOutputStream () ;
for ( int i = 0 ; i < bytes . length ; i ++ ) {
final int b = bytes [ i ] ;
if ( b == ESCAPE_CHAR ) {
try {
if ( bytes [ ++ i ] == CR ) {
continue;
}
final int u = Utils . digit16 ( bytes [ i ] ) ;
final int l = Utils . digit16 ( bytes [ ++ i ] ) ;
buffer . write ( (char) ( ( u << 4 ) + l ) ) ;
} catch ( final ArrayIndexOutOfBoundsException e ) {
throw new DecoderException ( lr_1 , e ) ;
}
} else if ( b != CR && b != LF ) {
buffer . write ( b ) ;
}
}
return buffer . toByteArray () ;
}
@Override
public byte [] encode ( final byte [] bytes ) {
return encodeQuotedPrintable ( PRINTABLE_CHARS , bytes , strict ) ;
}
@Override
public byte [] decode ( final byte [] bytes ) throws DecoderException {
return decodeQuotedPrintable ( bytes ) ;
}
@Override
public String encode ( final String sourceStr ) throws EncoderException {
return this . encode ( sourceStr , getCharset () ) ;
}
public String decode ( final String sourceStr , final Charset sourceCharset ) throws DecoderException {
if ( sourceStr == null ) {
return null ;
}
return new String ( this . decode ( StringUtils . getBytesUsAscii ( sourceStr ) ) , sourceCharset ) ;
}
public String decode ( final String sourceStr , final String sourceCharset )
throws DecoderException , UnsupportedEncodingException {
if ( sourceStr == null ) {
return null ;
}
return new String ( decode ( StringUtils . getBytesUsAscii ( sourceStr ) ) , sourceCharset ) ;
}
@Override
public String decode ( final String sourceStr ) throws DecoderException {
return this . decode ( sourceStr , this . getCharset () ) ;
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( obj == null ) {
return null ;
} else if ( obj instanceof byte [] ) {
return encode ( ( byte [] ) obj ) ;
} else if ( obj instanceof String ) {
return encode ( ( String ) obj ) ;
} else {
throw new EncoderException ( lr_2 +
obj . getClass () . getName () +
lr_3 ) ;
}
}
@Override
public Object decode ( final Object obj ) throws DecoderException {
if ( obj == null ) {
return null ;
} else if ( obj instanceof byte [] ) {
return decode ( ( byte [] ) obj ) ;
} else if ( obj instanceof String ) {
return decode ( ( String ) obj ) ;
} else {
throw new DecoderException ( lr_2 +
obj . getClass () . getName () +
lr_4 ) ;
}
}
public Charset getCharset () {
return this . charset ;
}
public String getDefaultCharset () {
return this . charset . name () ;
}
public String encode ( final String sourceStr , final Charset sourceCharset ) {
if ( sourceStr == null ) {
return null ;
}
return StringUtils . newStringUsAscii ( this . encode ( sourceStr . getBytes ( sourceCharset ) ) ) ;
}
public String encode ( final String sourceStr , final String sourceCharset ) throws UnsupportedEncodingException {
if ( sourceStr == null ) {
return null ;
}
return StringUtils . newStringUsAscii ( encode ( sourceStr . getBytes ( sourceCharset ) ) ) ;
}
