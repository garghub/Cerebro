protected String encodeText ( final String text , final Charset charset ) throws EncoderException {
if ( text == null ) {
return null ;
}
final StringBuilder buffer = new StringBuilder () ;
buffer . append ( PREFIX ) ;
buffer . append ( charset ) ;
buffer . append ( SEP ) ;
buffer . append ( this . getEncoding () ) ;
buffer . append ( SEP ) ;
buffer . append ( StringUtils . newStringUsAscii ( this . doEncoding ( text . getBytes ( charset ) ) ) ) ;
buffer . append ( POSTFIX ) ;
return buffer . toString () ;
}
protected String encodeText ( final String text , final String charsetName )
throws EncoderException , UnsupportedEncodingException {
if ( text == null ) {
return null ;
}
return this . encodeText ( text , Charset . forName ( charsetName ) ) ;
}
protected String decodeText ( final String text )
throws DecoderException , UnsupportedEncodingException {
if ( text == null ) {
return null ;
}
if ( ! text . startsWith ( PREFIX ) || ! text . endsWith ( POSTFIX ) ) {
throw new DecoderException ( lr_1 ) ;
}
final int terminator = text . length () - 2 ;
int from = 2 ;
int to = text . indexOf ( SEP , from ) ;
if ( to == terminator ) {
throw new DecoderException ( lr_2 ) ;
}
final String charset = text . substring ( from , to ) ;
if ( charset . equals ( lr_3 ) ) { MST[rv.ROR3Mutator]MSP[]
throw new DecoderException ( lr_4 ) ;
}
from = to + 1 ;
to = text . indexOf ( SEP , from ) ;
if ( to == terminator ) {
throw new DecoderException ( lr_5 ) ;
}
final String encoding = text . substring ( from , to ) ;
if ( ! getEncoding () . equalsIgnoreCase ( encoding ) ) {
throw new DecoderException ( lr_6 + encoding + lr_7 ) ;
}
from = to + 1 ;
to = text . indexOf ( SEP , from ) ;
byte [] data = StringUtils . getBytesUsAscii ( text . substring ( from , to ) ) ;
data = doDecoding ( data ) ;
return new String ( data , charset ) ;
}
