public int difference ( final String s1 , final String s2 ) throws EncoderException {
return SoundexUtils . difference ( this , s1 , s2 ) ;
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( ! ( obj instanceof String ) ) {
throw new EncoderException ( lr_1 ) ;
}
return soundex ( ( String ) obj ) ;
}
@Override
public String encode ( final String str ) {
return soundex ( str ) ;
}
char getMappingCode ( final char c ) {
if ( ! Character . isLetter ( c ) ) {
return 0 ;
}
return this . soundexMapping [ Character . toUpperCase ( c ) - 'A' ] ;
}
public String soundex ( String str ) {
if ( str == null ) {
return null ;
}
str = SoundexUtils . clean ( str ) ;
if ( str . length () == 0 ) {
return str ;
}
final StringBuilder sBuf = new StringBuilder () ;
sBuf . append ( str . charAt ( 0 ) ) ;
char last , current ;
last = '*' ;
for ( int i = 0 ; i < str . length () ; i ++ ) {
current = getMappingCode ( str . charAt ( i ) ) ;
if ( current == last ) {
continue;
} else if ( current != 0 ) {
sBuf . append ( current ) ;
}
last = current ;
}
return sBuf . toString () ;
}
