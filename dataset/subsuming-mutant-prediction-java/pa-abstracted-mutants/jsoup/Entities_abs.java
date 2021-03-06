int codepointForName ( final String name ) {
int index = Arrays . binarySearch ( nameKeys , name ) ;
return index >= 0 ? codeVals [ index ] : empty ;
}
String nameForCodepoint ( final int codepoint ) {
final int index = Arrays . binarySearch ( codeKeys , codepoint ) ;
if ( index >= 0 ) {
return ( index < nameVals . length - 1 && codeKeys [ index + 1 ] == codepoint ) ?
nameVals [ index + 1 ] : nameVals [ index ] ;
}
return emptyName ;
}
private int size () {
return nameKeys . length ;
}
public static boolean isNamedEntity ( final String name ) {
return extended . codepointForName ( name ) != empty ;
}
public static boolean isBaseNamedEntity ( final String name ) {
return base . codepointForName ( name ) != empty ;
}
public static String getByName ( String name ) {
String val = multipoints . get ( name ) ;
if ( val != null )
return val ;
int codepoint = extended . codepointForName ( name ) ;
if ( codepoint != empty )
return new String ( new int [] { codepoint } , 0 , 1 ) ;
return emptyName ;
}
public static int codepointsForName ( final String name , final int [] codepoints ) {
String val = multipoints . get ( name ) ;
if ( val != null ) {
codepoints [ 0 ] = val . codePointAt ( 0 ) ;
codepoints [ 1 ] = val . codePointAt ( 1 ) ;
return 2 ;
}
int codepoint = extended . codepointForName ( name ) ;
if ( codepoint != empty ) {
codepoints [ 0 ] = codepoint ;
return 1 ;
}
return 0 ;
}
public static String escape ( String string , Document . OutputSettings out ) {
if ( string == null )
return lr_1 ;
StringBuilder accum = StringUtil . borrowBuilder () ;
try {
escape ( accum , string , out , false , false , false ) ;
} catch ( IOException e ) {
throw new SerializationException ( e ) ;
}
return StringUtil . releaseBuilder ( accum ) ;
}
public static String escape ( String string ) {
return escape ( string , DefaultOutput ) ;
}
static void escape ( Appendable accum , String string , Document . OutputSettings out ,
boolean inAttribute , boolean normaliseWhite , boolean stripLeadingWhite ) throws IOException {
boolean lastWasWhite = false ;
boolean reachedNonWhite = false ;
final EscapeMode escapeMode = out . escapeMode () ;
final CharsetEncoder encoder = out . encoder () ;
final CoreCharset coreCharset = out . coreCharset ;
final int length = string . length () ;
int codePoint ;
for ( int offset = 0 ; offset < length ; offset += Character . charCount ( codePoint ) ) {
codePoint = string . codePointAt ( offset ) ;
if ( normaliseWhite ) {
if ( StringUtil . isWhitespace ( codePoint ) ) {
if ( ( stripLeadingWhite && ! reachedNonWhite ) || lastWasWhite )
continue;
accum . append ( ' ' ) ;
lastWasWhite = true ;
continue;
} else {
lastWasWhite = false ;
reachedNonWhite = true ;
}
}
if ( codePoint < Character . MIN_SUPPLEMENTARY_CODE_POINT ) {
final char c = ( char ) codePoint ;
switch ( c ) {
case '&' :
accum . append ( lr_2 ) ;
break;
case 0xA0 :
if ( escapeMode != EscapeMode . xhtml )
accum . append ( lr_3 ) ;
else
accum . append ( lr_4 ) ;
break;
case '<' :
if ( ! inAttribute || escapeMode == EscapeMode . xhtml )
accum . append ( lr_5 ) ;
else
accum . append ( c ) ;
break;
case '>' :
if ( ! inAttribute )
accum . append ( lr_6 ) ;
else
accum . append ( c ) ;
break;
case '"' :
if ( inAttribute )
accum . append ( lr_7 ) ;
else
accum . append ( c ) ;
break;
default:
if ( canEncode ( coreCharset , c , encoder ) )
accum . append ( c ) ;
else
appendEncoded ( accum , escapeMode , codePoint ) ;
}
} else {
final String c = new String ( Character . toChars ( codePoint ) ) ;
if ( encoder . canEncode ( c ) )
accum . append ( c ) ;
else
appendEncoded ( accum , escapeMode , codePoint ) ;
}
}
}
private static void appendEncoded ( Appendable accum , EscapeMode escapeMode , int codePoint ) throws IOException {
final String name = escapeMode . nameForCodepoint ( codePoint ) ;
if ( ! emptyName . equals ( name ) )
accum . append ( '&' ) . append ( name ) . append ( ';' ) ;
else
accum . append ( lr_8 ) . append ( Integer . toHexString ( codePoint ) ) . append ( ';' ) ;
}
public static String unescape ( String string ) {
return unescape ( string , false ) ;
}
static String unescape ( String string , boolean strict ) {
return Parser . unescapeEntities ( string , strict ) ;
}
private static boolean canEncode ( final CoreCharset charset , final char c , final CharsetEncoder fallback ) {
switch ( charset ) {
case ascii :
return c < 0x80 ;
case utf :
return true ;
default:
return fallback . canEncode ( c ) ;
}
}
static CoreCharset byName ( final String name ) {
if ( name . equals ( lr_9 ) )
return ascii ;
if ( name . startsWith ( lr_10 ) )
return utf ;
return fallback ;
}
private static void load ( EscapeMode e , String pointsData , int size ) {
e . nameKeys = new String [ size ] ;
e . codeVals = new int [ size ] ;
e . codeKeys = new int [ size ] ;
e . nameVals = new String [ size ] ;
int i = 0 ;
CharacterReader reader = new CharacterReader ( pointsData ) ;
while ( ! reader . isEmpty () ) {
final String name = reader . consumeTo ( '=' ) ;
reader . advance () ;
final int cp1 = Integer . parseInt ( reader . consumeToAny ( codeDelims ) , codepointRadix ) ;
final char codeDelim = reader . current () ;
reader . advance () ;
final int cp2 ;
if ( codeDelim == ',' ) {
cp2 = Integer . parseInt ( reader . consumeTo ( ';' ) , codepointRadix ) ;
reader . advance () ;
} else {
cp2 = empty ;
}
final String indexS = reader . consumeTo ( '&' ) ;
final int index = Integer . parseInt ( indexS , codepointRadix ) ;
reader . advance () ;
e . nameKeys [ i ] = name ;
e . codeVals [ i ] = cp1 ;
e . codeKeys [ index ] = cp1 ;
e . nameVals [ index ] = name ;
if ( cp2 != empty ) {
multipoints . put ( name , new String ( new int [] { cp1 , cp2 } , 0 , 2 ) ) ;
}
i ++ ;
}
Validate . isTrue ( i == size , lr_11 ) ;
}
