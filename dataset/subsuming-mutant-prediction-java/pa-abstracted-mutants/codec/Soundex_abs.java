private boolean hasMarker ( final char [] mapping ) {
for( final char ch : mapping ) {
if ( ch == SILENT_MARKER ) {
return true ;
}
}
return false ;
}
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
@Deprecated
public int getMaxLength () {
return this . maxLength ;
}
private char map ( final char ch ) {
final int index = ch - 'A' ;
if ( index < 0 || index >= this . soundexMapping . length ) {
throw new IllegalArgumentException ( lr_2 + ch + lr_3 + index + lr_4 ) ;
}
return this . soundexMapping [ index ] ;
}
@Deprecated
public void setMaxLength ( final int maxLength ) {
this . maxLength = maxLength ;
}
public String soundex ( String str ) {
if ( str == null ) {
return null ;
}
str = SoundexUtils . clean ( str ) ;
if ( str . length () == 0 ) {
return str ;
}
final char out [] = { '0' , '0' , '0' , '0' } ;
int count = 0 ;
final char first = str . charAt ( 0 ) ;
out [ count ++ ] = first ;
char lastDigit = map ( first ) ;
for( int i = 1 ; i < str . length () && count < out . length ; i ++ ) {
final char ch = str . charAt ( i ) ;
if ( ( this . specialCaseHW ) && ( ch == 'H' || ch == 'W' ) ) {
continue;
}
final char digit = map ( ch ) ;
if ( digit == SILENT_MARKER ) {
continue;
}
if ( digit != '0' && digit != lastDigit ) {
out [ count ++ ] = digit ;
}
lastDigit = digit ;
}
return new String ( out ) ;
}
