public static StrMatcher commaMatcher () {
return COMMA_MATCHER ;
}
public static StrMatcher tabMatcher () {
return TAB_MATCHER ;
}
public static StrMatcher spaceMatcher () {
return SPACE_MATCHER ;
}
public static StrMatcher splitMatcher () {
return SPLIT_MATCHER ;
}
public static StrMatcher trimMatcher () {
return TRIM_MATCHER ;
}
public static StrMatcher singleQuoteMatcher () {
return SINGLE_QUOTE_MATCHER ;
}
public static StrMatcher doubleQuoteMatcher () {
return DOUBLE_QUOTE_MATCHER ;
}
public static StrMatcher quoteMatcher () {
return QUOTE_MATCHER ;
}
public static StrMatcher noneMatcher () {
return NONE_MATCHER ;
}
public static StrMatcher charMatcher ( final char ch ) {
return new CharMatcher ( ch ) ;
}
public static StrMatcher charSetMatcher ( final char ... chars ) {
if ( chars == null || chars . length == 0 ) {
return NONE_MATCHER ;
}
if ( chars . length == 1 ) {
return new CharMatcher ( chars [ 0 ] ) ;
}
return new CharSetMatcher ( chars ) ;
}
public static StrMatcher charSetMatcher ( final String chars ) {
if ( StringUtils . isEmpty ( chars ) ) {
return NONE_MATCHER ;
}
if ( chars . length () == 1 ) {
return new CharMatcher ( chars . charAt ( 0 ) ) ;
}
return new CharSetMatcher ( chars . toCharArray () ) ;
}
public static StrMatcher stringMatcher ( final String str ) {
if ( StringUtils . isEmpty ( str ) ) {
return NONE_MATCHER ;
}
return new StringMatcher ( str ) ;
}
public int isMatch ( final char [] buffer , final int pos ) {
return isMatch ( buffer , pos , 0 , buffer . length ) ;
}
@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return Arrays . binarySearch ( chars , buffer [ pos ] ) >= 0 ? 1 : 0 ;
}
@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return ch == buffer [ pos ] ? 1 : 0 ;
}
@Override
public int isMatch ( final char [] buffer , int pos , final int bufferStart , final int bufferEnd ) {
final int len = chars . length ;
if ( pos + len > bufferEnd ) {
return 0 ;
}
for ( int i = 0 ; i < chars . length ; i ++ , pos ++ ) {
if ( chars [ i ] != buffer [ pos ] ) {
return 0 ;
}
}
return len ;
}
@Override
public String toString () {
return super . toString () + ' ' + Arrays . toString ( chars ) ;
}
@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return 0 ;
}
@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return buffer [ pos ] <= 32 ? 1 : 0 ;
}
