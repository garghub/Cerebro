public static final byte [] encodeUrl ( BitSet urlsafe , final byte [] bytes ) {
if ( bytes == null ) {
return null ;
}
if ( urlsafe == null ) {
urlsafe = WWW_FORM_URL_SAFE ;
}
final ByteArrayOutputStream buffer = new ByteArrayOutputStream () ;
for ( final byte c : bytes ) {
int b = c ;
if ( b < 0 ) {
b = 256 + b ;
}
if ( urlsafe . get ( b ) ) {
if ( b == ' ' ) {
b = '+' ;
}
buffer . write ( b ) ;
} else {
buffer . write ( ESCAPE_CHAR ) ;
final char hex1 = Utils . hexDigit ( b >> 4 ) ;
final char hex2 = Utils . hexDigit ( b ) ;
buffer . write ( hex1 ) ;
buffer . write ( hex2 ) ;
}
}
return buffer . toByteArray () ;
}
public static final byte [] decodeUrl ( final byte [] bytes ) throws DecoderException {
if ( bytes == null ) {
return null ;
}
final ByteArrayOutputStream buffer = new ByteArrayOutputStream () ;
for ( int i = 0 ; i < bytes . length ; i ++ ) {
final int b = bytes [ i ] ;
if ( b == '+' ) {
buffer . write ( ' ' ) ;
} else if ( b == ESCAPE_CHAR ) {
try {
final int u = Utils . digit16 ( bytes [ ++ i ] ) ;
final int l = Utils . digit16 ( bytes [ ++ i ] ) ;
buffer . write ( (char) ( ( u << 4 ) + l ) ) ;
} catch ( final ArrayIndexOutOfBoundsException e ) {
throw new DecoderException ( lr_1 , e ) ;
}
} else {
buffer . write ( b ) ;
}
}
return buffer . toByteArray () ;
}
@Override
public byte [] encode ( final byte [] bytes ) {
return encodeUrl ( WWW_FORM_URL_SAFE , bytes ) ;
}
@Override
public byte [] decode ( final byte [] bytes ) throws DecoderException {
return decodeUrl ( bytes ) ;
}
public String encode ( final String str , final String charsetName ) throws UnsupportedEncodingException {
if ( str == null ) {
return null ;
}
return StringUtils . newStringUsAscii ( encode ( str . getBytes ( charsetName ) ) ) ;
}
@Override
public String encode ( final String str ) throws EncoderException {
if ( str == null ) {
return null ;
}
try {
return encode ( str , getDefaultCharset () ) ;
} catch ( final UnsupportedEncodingException e ) {
throw new EncoderException ( e . getMessage () , e ) ;
}
}
public String decode ( final String str , final String charsetName )
throws DecoderException , UnsupportedEncodingException {
if ( str == null ) {
return null ;
}
return new String ( decode ( StringUtils . getBytesUsAscii ( str ) ) , charsetName ) ;
}
@Override
public String decode ( final String str ) throws DecoderException {
if ( str == null ) {
return null ;
}
try {
return decode ( str , getDefaultCharset () ) ;
} catch ( final UnsupportedEncodingException e ) {
throw new DecoderException ( e . getMessage () , e ) ;
}
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
throw new EncoderException ( lr_2 + obj . getClass () . getName () + lr_3 ) ;
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
throw new DecoderException ( lr_2 + obj . getClass () . getName () + lr_4 ) ;
}
}
public String getDefaultCharset () {
return this . charset ;
}
@Deprecated
public String getEncoding () {
return this . charset ;
}
