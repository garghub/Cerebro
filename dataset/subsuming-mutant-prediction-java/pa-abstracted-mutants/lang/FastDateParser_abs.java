private void init ( final Calendar definingCalendar ) {
patterns = new ArrayList < StrategyAndWidth > () ;
StrategyParser fm = new StrategyParser ( pattern , definingCalendar ) ;
for(; ; ) {
StrategyAndWidth field = fm . getNextStrategy () ;
if( field == null ) {
break;
}
patterns . add ( field ) ;
}
}
int getMaxWidth ( ListIterator < StrategyAndWidth > lt ) {
if( ! strategy . isNumber () || ! lt . hasNext () ) {
return 0 ;
}
Strategy nextStrategy = lt . next () . strategy ;
lt . previous () ;
return nextStrategy . isNumber () ? width : 0 ;
}
StrategyAndWidth getNextStrategy () {
if( currentIdx >= pattern . length () ) {
return null ;
}
char c = pattern . charAt ( currentIdx ) ;
if( isFormatLetter ( c ) ) {
return letterPattern ( c ) ;
}
else {
return literal () ;
}
}
private StrategyAndWidth letterPattern ( char c ) {
int begin = currentIdx ;
while( ++ currentIdx < pattern . length () ) {
if( pattern . charAt ( currentIdx ) != c ) {
break;
}
}
int width = currentIdx - begin ;
return new StrategyAndWidth ( getStrategy ( c , width , definingCalendar ) , width ) ;
}
private StrategyAndWidth literal () {
boolean activeQuote = false ;
StringBuilder sb = new StringBuilder () ;
while( currentIdx < pattern . length () ) {
char c = pattern . charAt ( currentIdx ) ;
if( ! activeQuote && isFormatLetter ( c ) ) {
break;
}
else if( c == '\'' ) {
if( ++ currentIdx == pattern . length () || pattern . charAt ( currentIdx ) != '\'' ) {
activeQuote = ! activeQuote ;
continue;
}
}
++ currentIdx ;
sb . append ( c ) ;
}
if( activeQuote ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
String formatField = sb . toString () ;
return new StrategyAndWidth ( new CopyQuotedStrategy ( formatField ) , formatField . length () ) ;
}
private static boolean isFormatLetter ( char c ) {
return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ;
}
@Override
public String getPattern () {
return pattern ;
}
@Override
public TimeZone getTimeZone () {
return timeZone ;
}
@Override
public Locale getLocale () {
return locale ;
}
@Override
public boolean equals ( final Object obj ) {
if ( ! ( obj instanceof FastDateParser ) ) {
return false ;
}
final FastDateParser other = ( FastDateParser ) obj ;
return pattern . equals ( other . pattern )
&& timeZone . equals ( other . timeZone )
&& locale . equals ( other . locale ) ;
}
@Override
public int hashCode () {
return pattern . hashCode () + 13 * ( timeZone . hashCode () + 13 * locale . hashCode () ) ;
}
@Override
public String toString () {
return lr_2 + pattern + lr_3 + locale + lr_3 + timeZone . getID () + lr_4 ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
final Calendar definingCalendar = Calendar . getInstance ( timeZone , locale ) ;
init ( definingCalendar ) ;
}
@Override
public Object parseObject ( final String source ) throws ParseException {
return parse ( source ) ;
}
@Override
public Date parse ( final String source ) throws ParseException {
ParsePosition pp = new ParsePosition ( 0 ) ;
final Date date = parse ( source , pp ) ;
if( date == null ) {
if ( locale . equals ( JAPANESE_IMPERIAL ) ) {
throw new ParseException (
lr_5 + locale + lr_6 +
lr_7 + source , pp . getErrorIndex () ) ;
}
throw new ParseException ( lr_8 + source , pp . getErrorIndex () ) ;
}
return date ;
}
@Override
public Object parseObject ( final String source , final ParsePosition pos ) {
return parse ( source , pos ) ;
}
@Override
public Date parse ( final String source , final ParsePosition pos ) {
final Calendar cal = Calendar . getInstance ( timeZone , locale ) ;
cal . clear () ;
return parse ( source , pos , cal ) ? cal . getTime () : null ;
}
public boolean parse ( final String source , final ParsePosition pos , final Calendar calendar ) {
ListIterator < StrategyAndWidth > lt = patterns . listIterator () ;
while( lt . hasNext () ) {
StrategyAndWidth pattern = lt . next () ;
int maxWidth = pattern . getMaxWidth ( lt ) ;
if( ! pattern . strategy . parse ( this , calendar , source , pos , maxWidth ) ) {
return false ;
}
}
return true ;
}
private static StringBuilder simpleQuote ( final StringBuilder sb , final String value ) {
for( int i = 0 ; i < value . length () ; ++ i ) {
char c = value . charAt ( i ) ;
switch( c ) {
case '\\' :
case '^' :
case '$' :
case '.' :
case '|' :
case '?' :
case '*' :
case '+' :
case '(' :
case ')' :
case '[' :
case '{' :
sb . append ( '\\' ) ;
default:
sb . append ( c ) ;
}
}
return sb ;
}
@Override
public int compare ( Map . Entry < String , Integer > left , Map . Entry < String , Integer > right ) {
int v = left . getValue () - right . getValue () ;
if( v != 0 ) {
return v ;
}
return right . getKey () . compareToIgnoreCase ( left . getKey () ) ;
}
private static void appendDisplayNames ( Calendar cal , Locale locale , int field ,
StringBuilder regex , Map < String , Integer > values ) {
Set < Entry < String , Integer > > displayNames = cal . getDisplayNames ( field , Calendar . ALL_STYLES , locale ) . entrySet () ;
TreeSet < Map . Entry < String , Integer > > sort = new TreeSet < Map . Entry < String , Integer > > ( ALTERNATIVES_ORDERING ) ;
sort . addAll ( displayNames ) ;
for ( Map . Entry < String , Integer > entry : sort ) {
String symbol = entry . getKey () ;
if ( symbol . length () > 0 ) {
if ( values . put ( symbol . toLowerCase ( locale ) , entry . getValue () ) == null ) {
simpleQuote ( regex , symbol ) . append ( '|' ) ;
}
}
}
}
private int adjustYear ( final int twoDigitYear ) {
final int trial = century + twoDigitYear ;
return twoDigitYear >= startYear ? trial : trial + 100 ;
}
boolean isNumber () {
return false ;
}
void createPattern ( StringBuilder regex ) {
createPattern ( regex . toString () ) ;
}
void createPattern ( String regex ) {
this . pattern = Pattern . compile ( regex ) ;
}
@Override
boolean isNumber () {
return false ;
}
@Override
boolean parse ( FastDateParser parser , Calendar calendar , String source , ParsePosition pos , int maxWidth ) {
Matcher matcher = pattern . matcher ( source . substring ( pos . getIndex () ) ) ;
if( ! matcher . lookingAt () ) {
pos . setErrorIndex ( pos . getIndex () ) ;
return false ;
}
pos . setIndex ( pos . getIndex () + matcher . end ( 1 ) ) ;
setCalendar ( parser , calendar , matcher . group ( 1 ) ) ;
return true ;
}
private Strategy getStrategy ( char f , int width , final Calendar definingCalendar ) {
switch( f ) {
default:
throw new IllegalArgumentException ( lr_9 + f + lr_10 ) ;
case 'D' :
return DAY_OF_YEAR_STRATEGY ;
case 'E' :
return getLocaleSpecificStrategy ( Calendar . DAY_OF_WEEK , definingCalendar ) ;
case 'F' :
return DAY_OF_WEEK_IN_MONTH_STRATEGY ;
case 'G' :
return getLocaleSpecificStrategy ( Calendar . ERA , definingCalendar ) ;
case 'H' :
return HOUR_OF_DAY_STRATEGY ;
case 'K' :
return HOUR_STRATEGY ;
case 'M' :
return width >= 3 ? getLocaleSpecificStrategy ( Calendar . MONTH , definingCalendar ) : NUMBER_MONTH_STRATEGY ;
case 'S' :
return MILLISECOND_STRATEGY ;
case 'W' :
return WEEK_OF_MONTH_STRATEGY ;
case 'a' :
return getLocaleSpecificStrategy ( Calendar . AM_PM , definingCalendar ) ;
case 'd' :
return DAY_OF_MONTH_STRATEGY ;
case 'h' :
return HOUR12_STRATEGY ;
case 'k' :
return HOUR24_OF_DAY_STRATEGY ;
case 'm' :
return MINUTE_STRATEGY ;
case 's' :
return SECOND_STRATEGY ;
case 'u' :
return DAY_OF_WEEK_STRATEGY ;
case 'w' :
return WEEK_OF_YEAR_STRATEGY ;
case 'y' :
return width > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY ;
case 'X' :
return ISO8601TimeZoneStrategy . getStrategy ( width ) ;
case 'Z' :
if ( width == 2 ) {
return ISO8601TimeZoneStrategy . ISO_8601_3_STRATEGY ;
}
case 'z' :
return getLocaleSpecificStrategy ( Calendar . ZONE_OFFSET , definingCalendar ) ;
}
}
private static ConcurrentMap < Locale , Strategy > getCache ( final int field ) {
synchronized( caches ) {
if( caches [ field ] == null ) {
caches [ field ] = new ConcurrentHashMap < Locale , Strategy > ( 3 ) ;
}
return caches [ field ] ;
}
}
private Strategy getLocaleSpecificStrategy ( final int field , final Calendar definingCalendar ) {
final ConcurrentMap < Locale , Strategy > cache = getCache ( field ) ;
Strategy strategy = cache . get ( locale ) ;
if( strategy == null ) {
strategy = field == Calendar . ZONE_OFFSET
? new TimeZoneStrategy ( definingCalendar , locale )
: new CaseInsensitiveTextStrategy ( field , definingCalendar , locale ) ;
final Strategy inCache = cache . putIfAbsent ( locale , strategy ) ;
if( inCache != null ) {
return inCache ;
}
}
return strategy ;
}
@Override
boolean isNumber () {
return false ;
}
@Override
boolean parse ( FastDateParser parser , Calendar calendar , String source , ParsePosition pos , int maxWidth ) {
for ( int idx = 0 ; idx < formatField . length () ; ++ idx ) {
int sIdx = idx + pos . getIndex () ;
if ( sIdx == source . length () ) {
pos . setErrorIndex ( sIdx ) ;
return false ;
}
if ( formatField . charAt ( idx ) != source . charAt ( sIdx ) ) {
pos . setErrorIndex ( sIdx ) ;
return false ;
}
}
pos . setIndex ( formatField . length () + pos . getIndex () ) ;
return true ;
}
@Override
void setCalendar ( FastDateParser parser , Calendar cal , String value ) {
final Integer iVal = lKeyValues . get ( value . toLowerCase ( locale ) ) ;
cal . set ( field , iVal . intValue () ) ;
}
@Override
boolean isNumber () {
return true ;
}
@Override
boolean parse ( FastDateParser parser , Calendar calendar , String source , ParsePosition pos , int maxWidth ) {
int idx = pos . getIndex () ;
int last = source . length () ;
if ( maxWidth == 0 ) {
for (; idx < last ; ++ idx ) {
char c = source . charAt ( idx ) ;
if ( ! Character . isWhitespace ( c ) ) {
break;
}
}
pos . setIndex ( idx ) ;
} else {
int end = idx + maxWidth ;
if ( last > end ) {
last = end ;
}
}
for (; idx < last ; ++ idx ) {
char c = source . charAt ( idx ) ;
if ( ! Character . isDigit ( c ) ) {
break;
}
}
if ( pos . getIndex () == idx ) {
pos . setErrorIndex ( idx ) ;
return false ;
}
int value = Integer . parseInt ( source . substring ( pos . getIndex () , idx ) ) ;
pos . setIndex ( idx ) ;
calendar . set ( field , modify ( parser , value ) ) ;
return true ;
}
int modify ( FastDateParser parser , final int iValue ) {
return iValue ;
}
@Override
int modify ( FastDateParser parser , final int iValue ) {
return iValue < 100 ? parser . adjustYear ( iValue ) : iValue ;
}
@Override
void setCalendar ( final FastDateParser parser , final Calendar cal , final String value ) {
TimeZone tz ;
if( value . charAt ( 0 ) == '+' || value . charAt ( 0 ) == '-' ) {
tz = TimeZone . getTimeZone ( lr_11 + value ) ;
}
else if( value . regionMatches ( true , 0 , lr_11 , 0 , 3 ) ) {
tz = TimeZone . getTimeZone ( value . toUpperCase () ) ;
}
else {
tz = tzNames . get ( value . toLowerCase ( locale ) ) ;
}
cal . setTimeZone ( tz ) ;
}
@Override
void setCalendar ( FastDateParser parser , Calendar cal , String value ) {
if ( value . equals ( lr_12 ) ) {
cal . setTimeZone ( TimeZone . getTimeZone ( lr_13 ) ) ;
} else {
cal . setTimeZone ( TimeZone . getTimeZone ( lr_11 + value ) ) ;
}
}
static Strategy getStrategy ( int tokenLen ) {
switch( tokenLen ) {
case 1 :
return ISO_8601_1_STRATEGY ;
case 2 :
return ISO_8601_2_STRATEGY ;
case 3 :
return ISO_8601_3_STRATEGY ;
default:
throw new IllegalArgumentException ( lr_14 ) ;
}
}
@Override
int modify ( FastDateParser parser , final int iValue ) {
return iValue - 1 ;
}
@Override
int modify ( FastDateParser parser , final int iValue ) {
return iValue != 7 ? iValue + 1 : Calendar . SUNDAY ;
}
@Override
int modify ( FastDateParser parser , final int iValue ) {
return iValue == 24 ? 0 : iValue ;
}
@Override
int modify ( FastDateParser parser , final int iValue ) {
return iValue == 12 ? 0 : iValue ;
}
