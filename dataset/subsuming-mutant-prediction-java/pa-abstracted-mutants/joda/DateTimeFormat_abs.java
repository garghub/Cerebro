public static DateTimeFormatter forPattern ( String pattern ) {
return createFormatterForPattern ( pattern ) ;
}
public static DateTimeFormatter forStyle ( String style ) {
return createFormatterForStyle ( style ) ;
}
public static String patternForStyle ( String style , Locale locale ) {
DateTimeFormatter formatter = createFormatterForStyle ( style ) ;
if ( locale == null ) {
locale = Locale . getDefault () ;
}
return ( ( StyleFormatter ) formatter . getPrinter0 () ) . getPattern ( locale ) ;
}
public static DateTimeFormatter shortDate () {
return createFormatterForStyleIndex ( SHORT , NONE ) ;
}
public static DateTimeFormatter shortTime () {
return createFormatterForStyleIndex ( NONE , SHORT ) ;
}
public static DateTimeFormatter shortDateTime () {
return createFormatterForStyleIndex ( SHORT , SHORT ) ;
}
public static DateTimeFormatter mediumDate () {
return createFormatterForStyleIndex ( MEDIUM , NONE ) ;
}
public static DateTimeFormatter mediumTime () {
return createFormatterForStyleIndex ( NONE , MEDIUM ) ;
}
public static DateTimeFormatter mediumDateTime () {
return createFormatterForStyleIndex ( MEDIUM , MEDIUM ) ;
}
public static DateTimeFormatter longDate () {
return createFormatterForStyleIndex ( LONG , NONE ) ;
}
public static DateTimeFormatter longTime () {
return createFormatterForStyleIndex ( NONE , LONG ) ;
}
public static DateTimeFormatter longDateTime () {
return createFormatterForStyleIndex ( LONG , LONG ) ;
}
public static DateTimeFormatter fullDate () {
return createFormatterForStyleIndex ( FULL , NONE ) ;
}
public static DateTimeFormatter fullTime () {
return createFormatterForStyleIndex ( NONE , FULL ) ;
}
public static DateTimeFormatter fullDateTime () {
return createFormatterForStyleIndex ( FULL , FULL ) ;
}
static void appendPatternTo ( DateTimeFormatterBuilder builder , String pattern ) {
parsePatternTo ( builder , pattern ) ;
}
private static void parsePatternTo ( DateTimeFormatterBuilder builder , String pattern ) {
int length = pattern . length () ;
int [] indexRef = new int [ 1 ] ;
for ( int i = 0 ; i < length ; i ++ ) {
indexRef [ 0 ] = i ;
String token = parseToken ( pattern , indexRef ) ;
i = indexRef [ 0 ] ;
int tokenLen = token . length () ;
if ( tokenLen == 0 ) {
break;
}
char c = token . charAt ( 0 ) ;
switch ( c ) {
case 'G' :
builder . appendEraText () ;
break;
case 'C' :
builder . appendCenturyOfEra ( tokenLen , tokenLen ) ;
break;
case 'x' :
case 'y' :
case 'Y' :
if ( tokenLen == 2 ) {
boolean lenientParse = true ;
if ( i + 1 < length ) {
indexRef [ 0 ] ++ ;
if ( isNumericToken ( parseToken ( pattern , indexRef ) ) ) {
lenientParse = false ;
}
indexRef [ 0 ] -- ;
}
switch ( c ) {
case 'x' :
builder . appendTwoDigitWeekyear
( new DateTime () . getWeekyear () - 30 , lenientParse ) ;
break;
case 'y' :
case 'Y' :
default:
builder . appendTwoDigitYear ( new DateTime () . getYear () - 30 , lenientParse ) ;
break;
}
} else {
int maxDigits = 9 ;
if ( i + 1 < length ) {
indexRef [ 0 ] ++ ;
if ( isNumericToken ( parseToken ( pattern , indexRef ) ) ) {
maxDigits = tokenLen ;
}
indexRef [ 0 ] -- ;
}
switch ( c ) {
case 'x' :
builder . appendWeekyear ( tokenLen , maxDigits ) ;
break;
case 'y' :
builder . appendYear ( tokenLen , maxDigits ) ;
break;
case 'Y' :
builder . appendYearOfEra ( tokenLen , maxDigits ) ;
break;
}
}
break;
case 'M' :
if ( tokenLen >= 3 ) {
if ( tokenLen >= 4 ) {
builder . appendMonthOfYearText () ;
} else {
builder . appendMonthOfYearShortText () ;
}
} else {
builder . appendMonthOfYear ( tokenLen ) ;
}
break;
case 'd' :
builder . appendDayOfMonth ( tokenLen ) ;
break;
case 'a' :
builder . appendHalfdayOfDayText () ;
break;
case 'h' :
builder . appendClockhourOfHalfday ( tokenLen ) ;
break;
case 'H' :
builder . appendHourOfDay ( tokenLen ) ;
break;
case 'k' :
builder . appendClockhourOfDay ( tokenLen ) ;
break;
case 'K' :
builder . appendHourOfHalfday ( tokenLen ) ;
break;
case 'm' :
builder . appendMinuteOfHour ( tokenLen ) ;
break;
case 's' :
builder . appendSecondOfMinute ( tokenLen ) ;
break;
case 'S' :
builder . appendFractionOfSecond ( tokenLen , tokenLen ) ;
break;
case 'e' :
builder . appendDayOfWeek ( tokenLen ) ;
break;
case 'E' :
if ( tokenLen >= 4 ) {
builder . appendDayOfWeekText () ;
} else {
builder . appendDayOfWeekShortText () ;
}
break;
case 'D' :
builder . appendDayOfYear ( tokenLen ) ;
break;
case 'w' :
builder . appendWeekOfWeekyear ( tokenLen ) ;
break;
case 'z' :
if ( tokenLen >= 4 ) {
builder . appendTimeZoneName () ;
} else {
builder . appendTimeZoneShortName ( null ) ;
}
break;
case 'Z' :
if ( tokenLen == 1 ) {
builder . appendTimeZoneOffset ( null , lr_1 , false , 2 , 2 ) ;
} else if ( tokenLen == 2 ) {
builder . appendTimeZoneOffset ( null , lr_1 , true , 2 , 2 ) ;
} else {
builder . appendTimeZoneId () ;
}
break;
case '\'' :
String sub = token . substring ( 1 ) ;
if ( sub . length () == 1 ) {
builder . appendLiteral ( sub . charAt ( 0 ) ) ;
} else {
builder . appendLiteral ( new String ( sub ) ) ;
}
break;
default:
throw new IllegalArgumentException
( lr_2 + token ) ;
}
}
}
private static String parseToken ( String pattern , int [] indexRef ) {
StringBuilder buf = new StringBuilder () ;
int i = indexRef [ 0 ] ;
int length = pattern . length () ;
char c = pattern . charAt ( i ) ;
if ( c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ) {
buf . append ( c ) ;
while ( i + 1 < length ) {
char peek = pattern . charAt ( i + 1 ) ;
if ( peek == c ) {
buf . append ( c ) ;
i ++ ;
} else {
break;
}
}
} else {
buf . append ( '\'' ) ;
boolean inLiteral = false ;
for (; i < length ; i ++ ) {
c = pattern . charAt ( i ) ;
if ( c == '\'' ) {
if ( i + 1 < length && pattern . charAt ( i + 1 ) == '\'' ) {
i ++ ;
buf . append ( c ) ;
} else {
inLiteral = ! inLiteral ;
}
} else if ( ! inLiteral &&
( c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ) ) {
i -- ;
break;
} else {
buf . append ( c ) ;
}
}
}
indexRef [ 0 ] = i ;
return buf . toString () ;
}
private static boolean isNumericToken ( String token ) {
int tokenLen = token . length () ;
if ( tokenLen > 0 ) {
char c = token . charAt ( 0 ) ;
switch ( c ) {
case 'c' :
case 'C' :
case 'x' :
case 'y' :
case 'Y' :
case 'd' :
case 'h' :
case 'H' :
case 'm' :
case 's' :
case 'S' :
case 'e' :
case 'D' :
case 'F' :
case 'w' :
case 'W' :
case 'k' :
case 'K' :
return true ;
case 'M' :
if ( tokenLen <= 2 ) {
return true ;
}
}
}
return false ;
}
private static DateTimeFormatter createFormatterForPattern ( String pattern ) {
if ( pattern == null || pattern . length () == 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
DateTimeFormatter formatter = cPatternCache . get ( pattern ) ;
if ( formatter == null ) {
DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder () ;
parsePatternTo ( builder , pattern ) ;
formatter = builder . toFormatter () ;
if ( cPatternCache . size () < PATTERN_CACHE_SIZE ) {
DateTimeFormatter oldFormatter = cPatternCache . putIfAbsent ( pattern , formatter ) ;
if ( oldFormatter != null ) {
formatter = oldFormatter ;
}
}
}
return formatter ;
}
private static DateTimeFormatter createFormatterForStyle ( String style ) {
if ( style == null || style . length () != 2 ) {
throw new IllegalArgumentException ( lr_4 + style ) ;
}
int dateStyle = selectStyle ( style . charAt ( 0 ) ) ;
int timeStyle = selectStyle ( style . charAt ( 1 ) ) ;
if ( dateStyle == NONE && timeStyle == NONE ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
return createFormatterForStyleIndex ( dateStyle , timeStyle ) ;
}
private static DateTimeFormatter createFormatterForStyleIndex ( int dateStyle , int timeStyle ) {
int index = ( ( dateStyle << 2 ) + dateStyle ) + timeStyle ;
if ( index >= cStyleCache . length () ) {
return createDateTimeFormatter ( dateStyle , timeStyle ) ;
}
DateTimeFormatter f = cStyleCache . get ( index ) ;
if ( f == null ) {
f = createDateTimeFormatter ( dateStyle , timeStyle ) ;
if ( cStyleCache . compareAndSet ( index , null , f ) == false ) {
f = cStyleCache . get ( index ) ;
}
}
return f ;
}
private static DateTimeFormatter createDateTimeFormatter ( int dateStyle , int timeStyle ) {
int type = DATETIME ;
if ( dateStyle == NONE ) {
type = TIME ;
} else if ( timeStyle == NONE ) {
type = DATE ;
}
StyleFormatter llf = new StyleFormatter ( dateStyle , timeStyle , type ) ;
return new DateTimeFormatter ( llf , llf ) ;
}
private static int selectStyle ( char ch ) {
switch ( ch ) {
case 'S' :
return SHORT ;
case 'M' :
return MEDIUM ;
case 'L' :
return LONG ;
case 'F' :
return FULL ;
case '-' :
return NONE ;
default:
throw new IllegalArgumentException ( lr_6 + ch ) ;
}
}
public int estimatePrintedLength () {
return 40 ;
}
public void printTo (
Appendable appenadble , long instant , Chronology chrono ,
int displayOffset , DateTimeZone displayZone , Locale locale ) throws IOException {
InternalPrinter p = getFormatter ( locale ) . getPrinter0 () ;
p . printTo ( appenadble , instant , chrono , displayOffset , displayZone , locale ) ;
}
public void printTo ( Appendable appendable , ReadablePartial partial , Locale locale ) throws IOException {
InternalPrinter p = getFormatter ( locale ) . getPrinter0 () ;
p . printTo ( appendable , partial , locale ) ;
}
public int estimateParsedLength () {
return 40 ;
}
public int parseInto ( DateTimeParserBucket bucket , CharSequence text , int position ) {
InternalParser p = getFormatter ( bucket . getLocale () ) . getParser0 () ;
return p . parseInto ( bucket , text , position ) ;
}
private DateTimeFormatter getFormatter ( Locale locale ) {
locale = ( locale == null ? Locale . getDefault () : locale ) ;
StyleFormatterCacheKey key = new StyleFormatterCacheKey ( iType , iDateStyle , iTimeStyle , locale ) ;
DateTimeFormatter f = cCache . get ( key ) ;
if ( f == null ) {
f = DateTimeFormat . forPattern ( getPattern ( locale ) ) ;
DateTimeFormatter oldFormatter = cCache . putIfAbsent ( key , f ) ;
if ( oldFormatter != null ) {
f = oldFormatter ;
}
}
return f ;
}
String getPattern ( Locale locale ) {
DateFormat f = null ;
switch ( iType ) {
case DATE :
f = DateFormat . getDateInstance ( iDateStyle , locale ) ;
break;
case TIME :
f = DateFormat . getTimeInstance ( iTimeStyle , locale ) ;
break;
case DATETIME :
f = DateFormat . getDateTimeInstance ( iDateStyle , iTimeStyle , locale ) ;
break;
}
if ( f instanceof SimpleDateFormat == false ) {
throw new IllegalArgumentException ( lr_7 + locale ) ;
}
return ( ( SimpleDateFormat ) f ) . toPattern () ;
}
@Override
public int hashCode () {
final int prime = 31 ;
int result = 1 ;
result = prime * result + combinedTypeAndStyle ;
result = prime * result + ( ( locale == null ) ? 0 : locale . hashCode () ) ;
return result ;
}
@Override
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj == null ) {
return false ;
}
if ( ! ( obj instanceof StyleFormatterCacheKey ) ) {
return false ;
}
StyleFormatterCacheKey other = ( StyleFormatterCacheKey ) obj ;
if ( combinedTypeAndStyle != other . combinedTypeAndStyle ) {
return false ;
}
if ( locale == null ) {
if ( other . locale != null ) {
return false ;
}
} else if ( ! locale . equals ( other . locale ) ) {
return false ;
}
return true ;
}
