public String caverphone ( final String source ) {
return this . encoder . encode ( source ) ;
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( ! ( obj instanceof String ) ) {
throw new EncoderException ( lr_1 ) ;
}
return this . caverphone ( ( String ) obj ) ;
}
@Override
public String encode ( final String str ) {
return this . caverphone ( str ) ;
}
public boolean isCaverphoneEqual ( final String str1 , final String str2 ) {
return this . caverphone ( str1 ) . equals ( this . caverphone ( str2 ) ) ;
}
