private static boolean isVowel ( final char c ) {
return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ;
}
private static char [] transcodeRemaining ( final char prev , final char curr , final char next , final char aNext ) {
if ( curr == 'E' && next == 'V' ) {
return CHARS_AF ;
}
if ( isVowel ( curr ) ) {
return CHARS_A ;
}
if ( curr == 'Q' ) {
return CHARS_G ;
} else if ( curr == 'Z' ) {
return CHARS_S ;
} else if ( curr == 'M' ) {
return CHARS_N ;
}
if ( curr == 'K' ) {
if ( next == 'N' ) {
return CHARS_NN ;
}
return CHARS_C ;
}
if ( curr == 'S' && next == 'C' && aNext == 'H' ) {
return CHARS_SSS ;
}
if ( curr == 'P' && next == 'H' ) {
return CHARS_FF ;
}
if ( curr == 'H' && ( ! isVowel ( prev ) || ! isVowel ( next ) ) ) {
return new char [] { prev } ;
}
if ( curr == 'W' && isVowel ( prev ) ) { MST[rv.ROR3Mutator]MSP[N]
return new char [] { prev } ;
}
return new char [] { curr } ;
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( ! ( obj instanceof String ) ) {
throw new EncoderException ( lr_1 ) ;
}
return this . nysiis ( ( String ) obj ) ;
}
@Override
public String encode ( final String str ) {
return this . nysiis ( str ) ;
}
public boolean isStrict () {
return this . strict ;
}
public String nysiis ( String str ) {
if ( str == null ) {
return null ;
}
str = SoundexUtils . clean ( str ) ;
if ( str . length () == 0 ) {
return str ;
}
str = PAT_MAC . matcher ( str ) . replaceFirst ( lr_2 ) ;
str = PAT_KN . matcher ( str ) . replaceFirst ( lr_3 ) ;
str = PAT_K . matcher ( str ) . replaceFirst ( lr_4 ) ;
str = PAT_PH_PF . matcher ( str ) . replaceFirst ( lr_5 ) ;
str = PAT_SCH . matcher ( str ) . replaceFirst ( lr_6 ) ;
str = PAT_EE_IE . matcher ( str ) . replaceFirst ( lr_7 ) ;
str = PAT_DT_ETC . matcher ( str ) . replaceFirst ( lr_8 ) ;
final StringBuilder key = new StringBuilder ( str . length () ) ;
key . append ( str . charAt ( 0 ) ) ;
final char [] chars = str . toCharArray () ;
final int len = chars . length ;
for ( int i = 1 ; i < len ; i ++ ) {
final char next = i < len - 1 ? chars [ i + 1 ] : SPACE ;
final char aNext = i < len - 2 ? chars [ i + 2 ] : SPACE ;
final char [] transcoded = transcodeRemaining ( chars [ i - 1 ] , chars [ i ] , next , aNext ) ;
System . arraycopy ( transcoded , 0 , chars , i , transcoded . length ) ;
if ( chars [ i ] != chars [ i - 1 ] ) {
key . append ( chars [ i ] ) ;
}
}
if ( key . length () > 1 ) {
char lastChar = key . charAt ( key . length () - 1 ) ;
if ( lastChar == 'S' ) {
key . deleteCharAt ( key . length () - 1 ) ;
lastChar = key . charAt ( key . length () - 1 ) ;
}
if ( key . length () > 2 ) {
final char last2Char = key . charAt ( key . length () - 2 ) ;
if ( last2Char == 'A' && lastChar == 'Y' ) {
key . deleteCharAt ( key . length () - 2 ) ;
}
}
if ( lastChar == 'A' ) {
key . deleteCharAt ( key . length () - 1 ) ;
}
}
final String string = key . toString () ;
return this . isStrict () ? string . substring ( 0 , Math . min ( TRUE_LENGTH , string . length () ) ) : string ;
}
