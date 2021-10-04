@Override
protected String getEncoding () {
return lr_1 ;
}
@Override
protected byte [] doEncoding ( final byte [] bytes ) {
if ( bytes == null ) {
return null ;
}
final byte [] data = QuotedPrintableCodec . encodeQuotedPrintable ( PRINTABLE_CHARS , bytes ) ;
if ( this . encodeBlanks ) {
for ( int i = 0 ; i < data . length ; i ++ ) {
if ( data [ i ] == SPACE ) {
data [ i ] = UNDERSCORE ;
}
}
}
return data ;
}
@Override
protected byte [] doDecoding ( final byte [] bytes ) throws DecoderException {
if ( bytes == null ) {
return null ;
}
boolean hasUnderscores = false ;
for ( final byte b : bytes ) {
if ( b == UNDERSCORE ) {
hasUnderscores = true ;
break;
}
}
if ( hasUnderscores ) {
final byte [] tmp = new byte [ bytes . length ] ;
for ( int i = 0 ; i < bytes . length ; i ++ ) {
final byte b = bytes [ i ] ;
if ( b != UNDERSCORE ) {
tmp [ i ] = b ;
} else {
tmp [ i ] = SPACE ;
}
}
return QuotedPrintableCodec . decodeQuotedPrintable ( tmp ) ;
}
return QuotedPrintableCodec . decodeQuotedPrintable ( bytes ) ;
}
public String encode ( final String sourceStr , final Charset sourceCharset ) throws EncoderException {
if ( sourceStr == null ) {
return null ;
}
return encodeText ( sourceStr , sourceCharset ) ;
}
public String encode ( final String sourceStr , final String sourceCharset ) throws EncoderException {
if ( sourceStr == null ) {
return null ;
}
try {
return encodeText ( sourceStr , sourceCharset ) ;
} catch ( final UnsupportedEncodingException e ) {
throw new EncoderException ( e . getMessage () , e ) ;
}
}
@Override
public String encode ( final String sourceStr ) throws EncoderException {
if ( sourceStr == null ) {
return null ;
}
return encode ( sourceStr , getCharset () ) ;
}
@Override
public String decode ( final String str ) throws DecoderException {
if ( str == null ) {
return null ;
}
try {
return decodeText ( str ) ;
} catch ( final UnsupportedEncodingException e ) {
throw new DecoderException ( e . getMessage () , e ) ;
}
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( obj == null ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
return null ;
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
public boolean isEncodeBlanks () {
return this . encodeBlanks ;
}
public void setEncodeBlanks ( final boolean b ) {
this . encodeBlanks = b ;
}
