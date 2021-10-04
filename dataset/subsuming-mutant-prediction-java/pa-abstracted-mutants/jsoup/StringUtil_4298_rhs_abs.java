public static String join ( Collection strings , String sep ) {
return join ( strings . iterator () , sep ) ;
}
public static String join ( Iterator strings , String sep ) {
if ( ! strings . hasNext () )
return lr_1 ;
String start = strings . next () . toString () ;
if ( ! strings . hasNext () )
return start ;
StringBuilder sb = StringUtil . borrowBuilder () . append ( start ) ;
while ( strings . hasNext () ) {
sb . append ( sep ) ;
sb . append ( strings . next () ) ;
}
return StringUtil . releaseBuilder ( sb ) ;
}
public static String join ( String [] strings , String sep ) {
return join ( Arrays . asList ( strings ) , sep ) ;
}
public static String padding ( int width ) {
if ( width < 0 )
throw new IllegalArgumentException ( lr_2 ) ;
if ( width < padding . length )
return padding [ width ] ;
char [] out = new char [ width ] ;
for ( int i = 0 ; i < width ; i ++ )
out [ i ] = ' ' ;
return String . valueOf ( out ) ;
}
public static boolean isBlank ( String string ) {
if ( string == null || string . length () == 0 )
return true ;
int l = string . length () ;
for ( int i = 0 ; i < l ; i ++ ) {
if ( ! StringUtil . isWhitespace ( string . codePointAt ( i ) ) )
return false ;
}
return true ;
}
public static boolean isNumeric ( String string ) {
if ( string == null || string . length () == 0 )
return false ;
int l = string . length () ;
for ( int i = 0 ; i < l ; i ++ ) {
if ( ! Character . isDigit ( string . codePointAt ( i ) ) )
return false ;
}
return true ;
}
public static boolean isWhitespace ( int c ) {
return c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r' ;
}
public static boolean isActuallyWhitespace ( int c ) {
return c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == 160 ;
}
public static boolean isInvisibleChar ( int c ) {
return c == 8203 || c == 173 ;
}
public static String normaliseWhitespace ( String string ) {
StringBuilder sb = StringUtil . borrowBuilder () ;
appendNormalisedWhitespace ( sb , string , false ) ;
return StringUtil . releaseBuilder ( sb ) ;
}
public static void appendNormalisedWhitespace ( StringBuilder accum , String string , boolean stripLeading ) {
boolean lastWasWhite = false ;
boolean reachedNonWhite = false ;
int len = string . length () ;
int c ;
for ( int i = 0 ; i < len ; i += Character . charCount ( c ) ) {
c = string . codePointAt ( i ) ;
if ( isActuallyWhitespace ( c ) ) {
if ( ( stripLeading && ! reachedNonWhite ) || lastWasWhite )
continue;
accum . append ( ' ' ) ;
lastWasWhite = true ;
}
else if ( ! isInvisibleChar ( c ) ) {
accum . appendCodePoint ( c ) ; MST[NonVoidMethodCallMutator]MSP[N]
lastWasWhite = false ;
reachedNonWhite = true ;
}
}
}
public static boolean in ( final String needle , final String ... haystack ) {
final int len = haystack . length ;
for ( int i = 0 ; i < len ; i ++ ) {
if ( haystack [ i ] . equals ( needle ) )
return true ;
}
return false ;
}
public static boolean inSorted ( String needle , String [] haystack ) {
return Arrays . binarySearch ( haystack , needle ) >= 0 ;
}
public static URL resolve ( URL base , String relUrl ) throws MalformedURLException {
if ( relUrl . startsWith ( lr_3 ) )
relUrl = base . getPath () + relUrl ;
if ( relUrl . indexOf ( '.' ) == 0 && base . getFile () . indexOf ( '/' ) != 0 ) {
base = new URL ( base . getProtocol () , base . getHost () , base . getPort () , lr_4 + base . getFile () ) ;
}
return new URL ( base , relUrl ) ;
}
public static String resolve ( final String baseUrl , final String relUrl ) {
URL base ;
try {
try {
base = new URL ( baseUrl ) ;
} catch ( MalformedURLException e ) {
URL abs = new URL ( relUrl ) ;
return abs . toExternalForm () ;
}
return resolve ( base , relUrl ) . toExternalForm () ;
} catch ( MalformedURLException e ) {
return lr_1 ;
}
}
public static StringBuilder borrowBuilder () {
synchronized ( builders ) {
return builders . empty () ?
new StringBuilder ( MaxCachedBuilderSize ) :
builders . pop () ;
}
}
public static String releaseBuilder ( StringBuilder sb ) {
Validate . notNull ( sb ) ;
String string = sb . toString () ;
if ( sb . length () > MaxCachedBuilderSize )
sb = new StringBuilder ( MaxCachedBuilderSize ) ;
else
sb . delete ( 0 , sb . length () ) ;
synchronized ( builders ) {
builders . push ( sb ) ;
while ( builders . size () > MaxIdleBuilders ) {
builders . pop () ;
}
}
return string ;
}
