@Override
public Object encode ( final Object source ) throws EncoderException {
if ( ! ( source instanceof String ) ) {
throw new EncoderException ( lr_1 ) ;
}
return this . encode ( ( String ) source ) ;
}
public boolean isEncodeEqual ( final String str1 , final String str2 ) throws EncoderException {
return this . encode ( str1 ) . equals ( this . encode ( str2 ) ) ;
}
