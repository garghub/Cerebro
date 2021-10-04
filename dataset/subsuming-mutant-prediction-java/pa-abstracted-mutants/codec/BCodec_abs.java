public boolean isStrictDecoding () {
return decodingPolicy == CodecPolicy . STRICT ;
}
@Override
protected String getEncoding () {
return lr_1 ;
}
@Override
protected byte [] doEncoding ( final byte [] bytes ) {
if ( bytes == null ) {
return null ;
}
return Base64 . encodeBase64 ( bytes ) ;
}
@Override
protected byte [] doDecoding ( final byte [] bytes ) {
if ( bytes == null ) {
return null ;
}
return new Base64 ( 0 , BaseNCodec . getChunkSeparator () , false , decodingPolicy ) . decode ( bytes ) ;
}
public String encode ( final String strSource , final Charset sourceCharset ) throws EncoderException {
if ( strSource == null ) {
return null ;
}
return encodeText ( strSource , sourceCharset ) ;
}
public String encode ( final String strSource , final String sourceCharset ) throws EncoderException {
if ( strSource == null ) {
return null ;
}
try {
return this . encodeText ( strSource , sourceCharset ) ;
} catch ( final UnsupportedEncodingException e ) {
throw new EncoderException ( e . getMessage () , e ) ;
}
}
@Override
public String encode ( final String strSource ) throws EncoderException {
if ( strSource == null ) {
return null ;
}
return encode ( strSource , this . getCharset () ) ;
}
@Override
public String decode ( final String value ) throws DecoderException {
if ( value == null ) {
return null ;
}
try {
return this . decodeText ( value ) ;
} catch ( final UnsupportedEncodingException | IllegalArgumentException e ) {
throw new DecoderException ( e . getMessage () , e ) ;
}
}
@Override
public Object encode ( final Object value ) throws EncoderException {
if ( value == null ) {
return null ;
} else if ( value instanceof String ) {
return encode ( ( String ) value ) ;
} else {
throw new EncoderException ( lr_2 +
value . getClass () . getName () +
lr_3 ) ;
}
}
@Override
public Object decode ( final Object value ) throws DecoderException {
if ( value == null ) {
return null ;
} else if ( value instanceof String ) {
return decode ( ( String ) value ) ;
} else {
throw new DecoderException ( lr_2 +
value . getClass () . getName () +
lr_4 ) ;
}
}
public Charset getCharset () {
return this . charset ;
}
public String getDefaultCharset () {
return this . charset . name () ;
}
