public static int toInt ( final String str ) {
return toInt ( str , 0 ) ;
}
public static int toInt ( final String str , final int defaultValue ) {
if( str == null ) {
return defaultValue ;
}
try {
return Integer . parseInt ( str ) ;
} catch ( final NumberFormatException nfe ) {
return defaultValue ;
}
}
public static long toLong ( final String str ) {
return toLong ( str , 0L ) ;
}
public static long toLong ( final String str , final long defaultValue ) {
if ( str == null ) {
return defaultValue ;
}
try {
return Long . parseLong ( str ) ;
} catch ( final NumberFormatException nfe ) {
return defaultValue ;
}
}
public static float toFloat ( final String str ) {
return toFloat ( str , 0.0f ) ;
}
public static float toFloat ( final String str , final float defaultValue ) {
if ( str == null ) {
return defaultValue ;
}
try {
return Float . parseFloat ( str ) ;
} catch ( final NumberFormatException nfe ) {
return defaultValue ;
}
}
public static double toDouble ( final String str ) {
return toDouble ( str , 0.0d ) ;
}
public static double toDouble ( final String str , final double defaultValue ) {
if ( str == null ) {
return defaultValue ;
}
try {
return Double . parseDouble ( str ) ;
} catch ( final NumberFormatException nfe ) {
return defaultValue ;
}
}
public static byte toByte ( final String str ) {
return toByte ( str , ( byte ) 0 ) ;
}
public static byte toByte ( final String str , final byte defaultValue ) {
if( str == null ) {
return defaultValue ;
}
try {
return Byte . parseByte ( str ) ;
} catch ( final NumberFormatException nfe ) {
return defaultValue ;
}
}
public static short toShort ( final String str ) {
return toShort ( str , ( short ) 0 ) ;
}
public static short toShort ( final String str , final short defaultValue ) {
if( str == null ) {
return defaultValue ;
}
try {
return Short . parseShort ( str ) ;
} catch ( final NumberFormatException nfe ) {
return defaultValue ;
}
}
public static Number createNumber ( final String str ) throws NumberFormatException {
if ( str == null ) {
return null ;
}
if ( StringUtils . isBlank ( str ) ) {
throw new NumberFormatException ( lr_1 ) ;
}
final String [] hex_prefixes = { lr_2 , lr_3 , lr_4 , lr_5 , lr_6 , lr_7 } ;
int pfxLen = 0 ;
for( final String pfx : hex_prefixes ) {
if ( str . startsWith ( pfx ) ) {
pfxLen += pfx . length () ;
break;
}
}
if ( pfxLen > 0 ) {
char firstSigDigit = 0 ;
for( int i = pfxLen ; i < str . length () ; i ++ ) {
firstSigDigit = str . charAt ( i ) ;
if ( firstSigDigit == '0' ) {
pfxLen ++ ;
} else {
break;
}
}
final int hexDigits = str . length () - pfxLen ;
if ( hexDigits > 16 || ( hexDigits == 16 && firstSigDigit > '7' ) ) {
return createBigInteger ( str ) ;
}
if ( hexDigits > 8 || ( hexDigits == 8 && firstSigDigit > '7' ) ) {
return createLong ( str ) ;
}
return createInteger ( str ) ;
}
final char lastChar = str . charAt ( str . length () - 1 ) ;
String mant ;
String dec ;
String exp ;
final int decPos = str . indexOf ( '.' ) ;
final int expPos = str . indexOf ( 'e' ) + str . indexOf ( 'E' ) + 1 ;
int numDecimals = 0 ;
if ( decPos > - 1 ) {
if ( expPos > - 1 ) {
if ( expPos < decPos || expPos > str . length () ) {
throw new NumberFormatException ( str + lr_8 ) ;
}
dec = str . substring ( decPos + 1 , expPos ) ;
} else {
dec = str . substring ( decPos + 1 ) ;
}
mant = getMantissa ( str , decPos ) ;
numDecimals = dec . length () ;
} else {
if ( expPos > - 1 ) {
if ( expPos > str . length () ) {
throw new NumberFormatException ( str + lr_8 ) ;
}
mant = getMantissa ( str , expPos ) ;
} else {
mant = getMantissa ( str ) ;
}
dec = null ;
}
if ( ! Character . isDigit ( lastChar ) && lastChar != '.' ) {
if ( expPos > - 1 && expPos < str . length () - 1 ) {
exp = str . substring ( expPos + 1 , str . length () - 1 ) ;
} else {
exp = null ;
}
final String numeric = str . substring ( 0 , str . length () - 1 ) ;
final boolean allZeros = isAllZeros ( mant ) && isAllZeros ( exp ) ;
switch ( lastChar ) {
case 'l' :
case 'L' :
if ( dec == null
&& exp == null
&& ( numeric . charAt ( 0 ) == '-' && isDigits ( numeric . substring ( 1 ) ) || isDigits ( numeric ) ) ) {
try {
return createLong ( numeric ) ;
} catch ( final NumberFormatException nfe ) {
}
return createBigInteger ( numeric ) ;
}
throw new NumberFormatException ( str + lr_8 ) ;
case 'f' :
case 'F' :
try {
final Float f = NumberUtils . createFloat ( numeric ) ;
if ( ! ( f . isInfinite () || ( f . floatValue () == 0.0F && ! allZeros ) ) ) {
return f ;
}
} catch ( final NumberFormatException nfe ) {
}
case 'd' :
case 'D' :
try {
final Double d = NumberUtils . createDouble ( numeric ) ;
if ( ! ( d . isInfinite () || ( d . floatValue () == 0.0D && ! allZeros ) ) ) {
return d ;
}
} catch ( final NumberFormatException nfe ) {
}
try {
return createBigDecimal ( numeric ) ;
} catch ( final NumberFormatException e ) {
}
default :
throw new NumberFormatException ( str + lr_8 ) ;
}
}
if ( expPos > - 1 && expPos < str . length () - 1 ) {
exp = str . substring ( expPos + 1 , str . length () ) ;
} else {
exp = null ;
}
if ( dec == null && exp == null ) {
try {
return createInteger ( str ) ;
} catch ( final NumberFormatException nfe ) {
}
try {
return createLong ( str ) ;
} catch ( final NumberFormatException nfe ) {
}
return createBigInteger ( str ) ;
}
final boolean allZeros = isAllZeros ( mant ) && isAllZeros ( exp ) ;
try {
if( numDecimals <= 7 ) {
final Float f = createFloat ( str ) ;
if ( ! ( f . isInfinite () || ( f . floatValue () == 0.0F && ! allZeros ) ) ) {
return f ;
}
}
} catch ( final NumberFormatException nfe ) {
}
try {
if( numDecimals <= 16 ) {
final Double d = createDouble ( str ) ;
if ( ! ( d . isInfinite () || ( d . doubleValue () == 0.0D && ! allZeros ) ) ) {
return d ;
}
}
} catch ( final NumberFormatException nfe ) {
}
return createBigDecimal ( str ) ;
}
private static String getMantissa ( final String str ) {
return getMantissa ( str , str . length () ) ;
}
private static String getMantissa ( final String str , final int stopPos ) {
final char firstChar = str . charAt ( 0 ) ;
final boolean hasSign = ( firstChar == '-' || firstChar == '+' ) ;
return hasSign ? str . substring ( 1 , stopPos ) : str . substring ( 0 , stopPos ) ;
}
private static boolean isAllZeros ( final String str ) {
if ( str == null ) {
return true ;
}
for ( int i = str . length () - 1 ; i >= 0 ; i -- ) {
if ( str . charAt ( i ) != '0' ) {
return false ;
}
}
return str . length () > 0 ;
}
public static Float createFloat ( final String str ) {
if ( str == null ) {
return null ;
}
return Float . valueOf ( str ) ;
}
public static Double createDouble ( final String str ) {
if ( str == null ) {
return null ;
}
return Double . valueOf ( str ) ;
}
public static Integer createInteger ( final String str ) {
if ( str == null ) {
return null ;
}
return Integer . decode ( str ) ;
}
public static Long createLong ( final String str ) {
if ( str == null ) {
return null ;
}
return Long . decode ( str ) ;
}
public static BigInteger createBigInteger ( final String str ) {
if ( str == null ) {
return null ;
}
int pos = 0 ;
int radix = 10 ;
boolean negate = false ;
if ( str . startsWith ( lr_9 ) ) {
negate = true ;
pos = 1 ;
}
if ( str . startsWith ( lr_2 , pos ) || str . startsWith ( lr_3 , pos ) ) {
radix = 16 ;
pos += 2 ;
} else if ( str . startsWith ( lr_6 , pos ) ) {
radix = 16 ;
pos ++ ;
} else if ( str . startsWith ( lr_10 , pos ) && str . length () > pos + 1 ) {
radix = 8 ;
pos ++ ;
}
final BigInteger value = new BigInteger ( str . substring ( pos ) , radix ) ;
return negate ? value . negate () : value ;
}
public static BigDecimal createBigDecimal ( final String str ) {
if ( str == null ) {
return null ;
}
if ( StringUtils . isBlank ( str ) ) {
throw new NumberFormatException ( lr_1 ) ;
}
if ( str . trim () . startsWith ( lr_11 ) ) {
throw new NumberFormatException ( str + lr_8 ) ;
}
return new BigDecimal ( str ) ;
}
public static long min ( final long ... array ) {
validateArray ( array ) ;
long min = array [ 0 ] ;
for ( int i = 1 ; i < array . length ; i ++ ) {
if ( array [ i ] < min ) {
min = array [ i ] ;
}
}
return min ;
}
public static int min ( final int ... array ) {
validateArray ( array ) ;
int min = array [ 0 ] ;
for ( int j = 1 ; j < array . length ; j ++ ) {
if ( array [ j ] < min ) {
min = array [ j ] ;
}
}
return min ;
}
public static short min ( final short ... array ) {
validateArray ( array ) ;
short min = array [ 0 ] ;
for ( int i = 1 ; i < array . length ; i ++ ) {
if ( array [ i ] < min ) {
min = array [ i ] ;
}
}
return min ;
}
public static byte min ( final byte ... array ) {
validateArray ( array ) ;
byte min = array [ 0 ] ;
for ( int i = 1 ; i < array . length ; i ++ ) {
if ( array [ i ] < min ) {
min = array [ i ] ;
}
}
return min ;
}
public static double min ( final double ... array ) {
validateArray ( array ) ; MST[rv.ABSMutator]MSP[S]
double min = array [ 0 ] ;
for ( int i = 1 ; i < array . length ; i ++ ) {
if ( Double . isNaN ( array [ i ] ) ) {
return Double . NaN ;
}
if ( array [ i ] < min ) {
min = array [ i ] ;
}
}
return min ;
}
public static float min ( final float ... array ) {
validateArray ( array ) ;
float min = array [ 0 ] ;
for ( int i = 1 ; i < array . length ; i ++ ) {
if ( Float . isNaN ( array [ i ] ) ) {
return Float . NaN ;
}
if ( array [ i ] < min ) {
min = array [ i ] ;
}
}
return min ;
}
public static long max ( final long ... array ) {
validateArray ( array ) ;
long max = array [ 0 ] ;
for ( int j = 1 ; j < array . length ; j ++ ) {
if ( array [ j ] > max ) {
max = array [ j ] ;
}
}
return max ;
}
public static int max ( final int ... array ) {
validateArray ( array ) ;
int max = array [ 0 ] ;
for ( int j = 1 ; j < array . length ; j ++ ) {
if ( array [ j ] > max ) {
max = array [ j ] ;
}
}
return max ;
}
public static short max ( final short ... array ) {
validateArray ( array ) ;
short max = array [ 0 ] ;
for ( int i = 1 ; i < array . length ; i ++ ) {
if ( array [ i ] > max ) {
max = array [ i ] ;
}
}
return max ;
}
public static byte max ( final byte ... array ) {
validateArray ( array ) ;
byte max = array [ 0 ] ;
for ( int i = 1 ; i < array . length ; i ++ ) {
if ( array [ i ] > max ) {
max = array [ i ] ;
}
}
return max ;
}
public static double max ( final double ... array ) {
validateArray ( array ) ;
double max = array [ 0 ] ;
for ( int j = 1 ; j < array . length ; j ++ ) {
if ( Double . isNaN ( array [ j ] ) ) {
return Double . NaN ;
}
if ( array [ j ] > max ) {
max = array [ j ] ;
}
}
return max ;
}
public static float max ( final float ... array ) {
validateArray ( array ) ;
float max = array [ 0 ] ;
for ( int j = 1 ; j < array . length ; j ++ ) {
if ( Float . isNaN ( array [ j ] ) ) {
return Float . NaN ;
}
if ( array [ j ] > max ) {
max = array [ j ] ;
}
}
return max ;
}
private static void validateArray ( final Object array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
Validate . isTrue ( Array . getLength ( array ) != 0 , lr_13 ) ;
}
public static long min ( long a , final long b , final long c ) {
if ( b < a ) {
a = b ;
}
if ( c < a ) {
a = c ;
}
return a ;
}
public static int min ( int a , final int b , final int c ) {
if ( b < a ) {
a = b ;
}
if ( c < a ) {
a = c ;
}
return a ;
}
public static short min ( short a , final short b , final short c ) {
if ( b < a ) {
a = b ;
}
if ( c < a ) {
a = c ;
}
return a ;
}
public static byte min ( byte a , final byte b , final byte c ) {
if ( b < a ) {
a = b ;
}
if ( c < a ) {
a = c ;
}
return a ;
}
public static double min ( final double a , final double b , final double c ) {
return Math . min ( Math . min ( a , b ) , c ) ;
}
public static float min ( final float a , final float b , final float c ) {
return Math . min ( Math . min ( a , b ) , c ) ;
}
public static long max ( long a , final long b , final long c ) {
if ( b > a ) {
a = b ;
}
if ( c > a ) {
a = c ;
}
return a ;
}
public static int max ( int a , final int b , final int c ) {
if ( b > a ) {
a = b ;
}
if ( c > a ) {
a = c ;
}
return a ;
}
public static short max ( short a , final short b , final short c ) {
if ( b > a ) {
a = b ;
}
if ( c > a ) {
a = c ;
}
return a ;
}
public static byte max ( byte a , final byte b , final byte c ) {
if ( b > a ) {
a = b ;
}
if ( c > a ) {
a = c ;
}
return a ;
}
public static double max ( final double a , final double b , final double c ) {
return Math . max ( Math . max ( a , b ) , c ) ;
}
public static float max ( final float a , final float b , final float c ) {
return Math . max ( Math . max ( a , b ) , c ) ;
}
public static boolean isDigits ( final String str ) {
return StringUtils . isNumeric ( str ) ;
}
public static boolean isNumber ( final String str ) {
if ( StringUtils . isEmpty ( str ) ) {
return false ;
}
final char [] chars = str . toCharArray () ;
int sz = chars . length ;
boolean hasExp = false ;
boolean hasDecPoint = false ;
boolean allowSigns = false ;
boolean foundDigit = false ;
final int start = ( chars [ 0 ] == '-' ) ? 1 : 0 ;
if ( sz > start + 1 && chars [ start ] == '0' ) {
if (
( chars [ start + 1 ] == 'x' ) ||
( chars [ start + 1 ] == 'X' )
) {
int i = start + 2 ;
if ( i == sz ) {
return false ;
}
for (; i < chars . length ; i ++ ) {
if ( ( chars [ i ] < '0' || chars [ i ] > '9' )
&& ( chars [ i ] < 'a' || chars [ i ] > 'f' )
&& ( chars [ i ] < 'A' || chars [ i ] > 'F' ) ) {
return false ;
}
}
return true ;
} else if ( Character . isDigit ( chars [ start + 1 ] ) ) {
int i = start + 1 ;
for (; i < chars . length ; i ++ ) {
if ( chars [ i ] < '0' || chars [ i ] > '7' ) {
return false ;
}
}
return true ;
}
}
sz -- ;
int i = start ;
while ( i < sz || ( i < sz + 1 && allowSigns && ! foundDigit ) ) {
if ( chars [ i ] >= '0' && chars [ i ] <= '9' ) {
foundDigit = true ;
allowSigns = false ;
} else if ( chars [ i ] == '.' ) {
if ( hasDecPoint || hasExp ) {
return false ;
}
hasDecPoint = true ;
} else if ( chars [ i ] == 'e' || chars [ i ] == 'E' ) {
if ( hasExp ) {
return false ;
}
if ( ! foundDigit ) {
return false ;
}
hasExp = true ;
allowSigns = true ;
} else if ( chars [ i ] == '+' || chars [ i ] == '-' ) {
if ( ! allowSigns ) {
return false ;
}
allowSigns = false ;
foundDigit = false ;
} else {
return false ;
}
i ++ ;
}
if ( i < chars . length ) {
if ( chars [ i ] >= '0' && chars [ i ] <= '9' ) {
return true ;
}
if ( chars [ i ] == 'e' || chars [ i ] == 'E' ) {
return false ;
}
if ( chars [ i ] == '.' ) {
if ( hasDecPoint || hasExp ) {
return false ;
}
return foundDigit ;
}
if ( ! allowSigns
&& ( chars [ i ] == 'd'
|| chars [ i ] == 'D'
|| chars [ i ] == 'f'
|| chars [ i ] == 'F' ) ) {
return foundDigit ;
}
if ( chars [ i ] == 'l'
|| chars [ i ] == 'L' ) {
return foundDigit && ! hasExp && ! hasDecPoint ;
}
return false ;
}
return ! allowSigns && foundDigit ;
}
public static boolean isParsable ( final String str ) {
if( StringUtils . endsWith ( str , lr_14 ) ) {
return false ;
}
if( StringUtils . startsWith ( str , lr_9 ) ) {
return isDigits ( StringUtils . replaceOnce ( str . substring ( 1 ) , lr_14 , StringUtils . EMPTY ) ) ;
} else {
return isDigits ( StringUtils . replaceOnce ( str , lr_14 , StringUtils . EMPTY ) ) ;
}
}
public static int compare ( int x , int y ) {
if ( x == y ) {
return 0 ;
}
if ( x < y ) {
return - 1 ;
} else {
return 1 ;
}
}
public static int compare ( long x , long y ) {
if ( x == y ) {
return 0 ;
}
if ( x < y ) {
return - 1 ;
} else {
return 1 ;
}
}
public static int compare ( short x , short y ) {
if ( x == y ) {
return 0 ;
}
if ( x < y ) {
return - 1 ;
} else {
return 1 ;
}
}
public static int compare ( byte x , byte y ) {
return x - y ;
}
