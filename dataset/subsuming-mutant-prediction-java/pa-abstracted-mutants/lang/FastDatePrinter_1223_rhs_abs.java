private void init () {
final List < Rule > rulesList = parsePattern () ;
mRules = rulesList . toArray ( new Rule [ rulesList . size () ] ) ;
int len = 0 ;
for ( int i = mRules . length ; -- i >= 0 ; ) {
len += mRules [ i ] . estimateLength () ;
}
mMaxLengthEstimate = len ;
}
protected List < Rule > parsePattern () {
final DateFormatSymbols symbols = new DateFormatSymbols ( mLocale ) ;
final List < Rule > rules = new ArrayList < Rule > () ;
final String [] ERAs = symbols . getEras () ;
final String [] months = symbols . getMonths () ;
final String [] shortMonths = symbols . getShortMonths () ;
final String [] weekdays = symbols . getWeekdays () ;
final String [] shortWeekdays = symbols . getShortWeekdays () ;
final String [] AmPmStrings = symbols . getAmPmStrings () ;
final int length = mPattern . length () ;
final int [] indexRef = new int [ 1 ] ;
for ( int i = 0 ; i < length ; i ++ ) {
indexRef [ 0 ] = i ;
final String token = parseToken ( mPattern , indexRef ) ;
i = indexRef [ 0 ] ;
final int tokenLen = token . length () ;
if ( tokenLen == 0 ) {
break;
}
Rule rule ;
final char c = token . charAt ( 0 ) ;
switch ( c ) {
case 'G' :
rule = new TextField ( Calendar . ERA , ERAs ) ;
break;
case 'y' :
if ( tokenLen == 2 ) {
rule = TwoDigitYearField . INSTANCE ;
} else {
rule = selectNumberRule ( Calendar . YEAR , tokenLen < 4 ? 4 : tokenLen ) ;
}
break;
case 'M' :
if ( tokenLen >= 4 ) {
rule = new TextField ( Calendar . MONTH , months ) ;
} else if ( tokenLen == 3 ) {
rule = new TextField ( Calendar . MONTH , shortMonths ) ;
} else if ( tokenLen == 2 ) {
rule = TwoDigitMonthField . INSTANCE ;
} else {
rule = UnpaddedMonthField . INSTANCE ;
}
break;
case 'd' :
rule = selectNumberRule ( Calendar . DAY_OF_MONTH , tokenLen ) ;
break;
case 'h' :
rule = new TwelveHourField ( selectNumberRule ( Calendar . HOUR , tokenLen ) ) ;
break;
case 'H' :
rule = selectNumberRule ( Calendar . HOUR_OF_DAY , tokenLen ) ;
break;
case 'm' :
rule = selectNumberRule ( Calendar . MINUTE , tokenLen ) ;
break;
case 's' :
rule = selectNumberRule ( Calendar . SECOND , tokenLen ) ;
break;
case 'S' :
rule = selectNumberRule ( Calendar . MILLISECOND , tokenLen ) ;
break;
case 'E' :
rule = new TextField ( Calendar . DAY_OF_WEEK , tokenLen < 4 ? shortWeekdays : weekdays ) ;
break;
case 'u' :
rule = new DayInWeekField ( selectNumberRule ( Calendar . DAY_OF_WEEK , tokenLen ) ) ;
break;
case 'D' :
rule = selectNumberRule ( Calendar . DAY_OF_YEAR , tokenLen ) ;
break;
case 'F' :
rule = selectNumberRule ( Calendar . DAY_OF_WEEK_IN_MONTH , tokenLen ) ;
break;
case 'w' :
rule = selectNumberRule ( Calendar . WEEK_OF_YEAR , tokenLen ) ;
break;
case 'W' :
rule = selectNumberRule ( Calendar . WEEK_OF_MONTH , tokenLen ) ;
break;
case 'a' :
rule = new TextField ( Calendar . AM_PM , AmPmStrings ) ;
break;
case 'k' :
rule = new TwentyFourHourField ( selectNumberRule ( Calendar . HOUR_OF_DAY , tokenLen ) ) ;
break;
case 'K' :
rule = selectNumberRule ( Calendar . HOUR , tokenLen ) ;
break;
case 'X' :
rule = Iso8601_Rule . getRule ( tokenLen ) ;
break;
case 'z' :
if ( tokenLen >= 4 ) {
rule = new TimeZoneNameRule ( mTimeZone , mLocale , TimeZone . LONG ) ;
} else {
rule = new TimeZoneNameRule ( mTimeZone , mLocale , TimeZone . SHORT ) ;
}
break;
case 'Z' :
if ( tokenLen == 1 ) {
rule = TimeZoneNumberRule . INSTANCE_NO_COLON ;
} else if ( tokenLen == 2 ) {
rule = Iso8601_Rule . ISO8601_HOURS_COLON_MINUTES ;
} else {
rule = TimeZoneNumberRule . INSTANCE_COLON ;
}
break;
case '\'' :
final String sub = token . substring ( 1 ) ;
if ( sub . length () == 1 ) {
rule = new CharacterLiteral ( sub . charAt ( 0 ) ) ;
} else {
rule = new StringLiteral ( sub ) ;
}
break;
default:
throw new IllegalArgumentException ( lr_1 + token ) ;
}
rules . add ( rule ) ;
}
return rules ;
}
protected String parseToken ( final String pattern , final int [] indexRef ) {
final StringBuilder buf = new StringBuilder () ;
int i = indexRef [ 0 ] ;
final int length = pattern . length () ;
char c = pattern . charAt ( i ) ;
if ( c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ) {
buf . append ( c ) ;
while ( i + 1 < length ) {
final char peek = pattern . charAt ( i + 1 ) ;
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
protected NumberRule selectNumberRule ( final int field , final int padding ) {
switch ( padding ) {
case 1 :
return new UnpaddedNumberField ( field ) ;
case 2 :
return new TwoDigitNumberField ( field ) ;
default:
return new PaddedNumberField ( field , padding ) ;
}
}
@Deprecated
@Override
public StringBuffer format ( final Object obj , final StringBuffer toAppendTo , final FieldPosition pos ) {
if ( obj instanceof Date ) {
return format ( ( Date ) obj , toAppendTo ) ;
} else if ( obj instanceof Calendar ) {
return format ( ( Calendar ) obj , toAppendTo ) ;
} else if ( obj instanceof Long ) {
return format ( ( ( Long ) obj ) . longValue () , toAppendTo ) ;
} else {
throw new IllegalArgumentException ( lr_2 +
( obj == null ? lr_3 : obj . getClass () . getName () ) ) ;
}
}
String format ( Object obj ) {
if ( obj instanceof Date ) {
return format ( ( Date ) obj ) ;
} else if ( obj instanceof Calendar ) {
return format ( ( Calendar ) obj ) ;
} else if ( obj instanceof Long ) {
return format ( ( ( Long ) obj ) . longValue () ) ;
} else {
throw new IllegalArgumentException ( lr_2 +
( obj == null ? lr_3 : obj . getClass () . getName () ) ) ;
}
}
@Override
public String format ( final long millis ) {
final Calendar c = newCalendar () ;
c . setTimeInMillis ( millis ) ;
return applyRulesToString ( c ) ;
}
private String applyRulesToString ( final Calendar c ) {
return applyRules ( c , new StringBuilder ( mMaxLengthEstimate ) ) . toString () ;
}
private GregorianCalendar newCalendar () {
return new GregorianCalendar ( mTimeZone , mLocale ) ;
}
@Override
public String format ( final Date date ) {
final Calendar c = newCalendar () ;
c . setTime ( date ) ;
return applyRulesToString ( c ) ;
}
@Override
public String format ( final Calendar calendar ) {
return format ( calendar , new StringBuilder ( mMaxLengthEstimate ) ) . toString () ;
}
@Override
public StringBuffer format ( final long millis , final StringBuffer buf ) {
return format ( new Date ( millis ) , buf ) ;
}
@Override
public StringBuffer format ( final Date date , final StringBuffer buf ) {
final Calendar c = newCalendar () ;
c . setTime ( date ) ;
return applyRules ( c , buf ) ;
}
@Override
public StringBuffer format ( final Calendar calendar , final StringBuffer buf ) {
return format ( calendar . getTime () , buf ) ;
}
@Override
public < B extends Appendable > B format ( final long millis , final B buf ) {
return format ( new Date ( millis ) , buf ) ;
}
@Override
public < B extends Appendable > B format ( final Date date , final B buf ) {
final Calendar c = newCalendar () ;
c . setTime ( date ) ;
return applyRules ( c , buf ) ;
}
@Override
public < B extends Appendable > B format ( final Calendar calendar , final B buf ) {
return format ( calendar . getTime () , buf ) ;
}
protected < B extends Appendable > B applyRules ( final Calendar calendar , final B buf ) {
try {
for ( final Rule rule : mRules ) {
rule . appendTo ( buf , calendar ) ;
}
} catch ( IOException ioe ) {
ExceptionUtils . rethrow ( ioe ) ;
}
return buf ;
}
@Override
public String getPattern () {
return mPattern ;
}
@Override
public TimeZone getTimeZone () {
return mTimeZone ;
}
@Override
public Locale getLocale () {
return mLocale ;
}
public int getMaxLengthEstimate () {
return mMaxLengthEstimate ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof FastDatePrinter == false ) {
return false ;
}
final FastDatePrinter other = ( FastDatePrinter ) obj ;
return mPattern . equals ( other . mPattern )
&& mTimeZone . equals ( other . mTimeZone )
&& mLocale . equals ( other . mLocale ) ;
}
@Override
public int hashCode () {
return mPattern . hashCode () + 13 * ( mTimeZone . hashCode () + 13 * mLocale . hashCode () ) ;
}
@Override
public String toString () {
return lr_4 + mPattern + lr_5 + mLocale + lr_5 + mTimeZone . getID () + lr_6 ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
init () ;
}
private static void appendDigits ( final Appendable buffer , final int value ) throws IOException {
buffer . append ( (char)( value / 10 + '0' ) ) ;
buffer . append ( (char)( value % 10 + '0' ) ) ;
}
private static void appendFullDigits ( final Appendable buffer , int value , int minFieldWidth ) throws IOException {
char [] work = new char [ MAX_DIGITS ] ;
int digit = 0 ;
while( value != 0 ) {
work [ digit ++ ] = (char)( value % 10 + '0' ) ;
value = value / 10 ;
}
while( digit < minFieldWidth ) {
buffer . append ( '0' ) ;
-- minFieldWidth ;
}
while( -- digit >= 0 ) {
buffer . append ( work [ digit ] ) ;
}
}
@Override
public int estimateLength () {
return 1 ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
buffer . append ( mValue ) ;
}
@Override
public int estimateLength () {
return mValue . length () ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
buffer . append ( mValue ) ;
}
@Override
public int estimateLength () {
int max = 0 ;
for ( int i = mValues . length ; -- i >= 0 ; ) {
final int len = mValues [ i ] . length () ;
if ( len > max ) {
max = len ;
}
}
return max ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
buffer . append ( mValues [ calendar . get ( mField ) ] ) ;
}
@Override
public int estimateLength () {
return 4 ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
appendTo ( buffer , calendar . get ( mField ) ) ;
}
@Override
public final void appendTo ( final Appendable buffer , final int value ) throws IOException {
if ( value < 10 ) {
buffer . append ( (char)( value + '0' ) ) ;
} else if ( value < 100 ) {
appendDigits ( buffer , value ) ;
} else {
appendFullDigits ( buffer , value , 1 ) ;
}
}
@Override
public int estimateLength () {
return 2 ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
appendTo ( buffer , calendar . get ( Calendar . MONTH ) + 1 ) ;
}
@Override
public final void appendTo ( final Appendable buffer , final int value ) throws IOException {
if ( value < 10 ) {
buffer . append ( (char)( value + '0' ) ) ;
} else {
appendDigits ( buffer , value ) ;
}
}
@Override
public int estimateLength () {
return mSize ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
appendTo ( buffer , calendar . get ( mField ) ) ;
}
@Override
public final void appendTo ( final Appendable buffer , int value ) throws IOException {
appendFullDigits ( buffer , value , mSize ) ;
}
@Override
public int estimateLength () {
return 2 ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
appendTo ( buffer , calendar . get ( mField ) ) ;
}
@Override
public final void appendTo ( final Appendable buffer , final int value ) throws IOException {
if ( value < 100 ) {
appendDigits ( buffer , value ) ;
} else {
appendFullDigits ( buffer , value , 2 ) ;
}
}
@Override
public int estimateLength () {
return 2 ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
appendTo ( buffer , calendar . get ( Calendar . YEAR ) % 100 ) ;
}
@Override
public final void appendTo ( final Appendable buffer , final int value ) throws IOException {
appendDigits ( buffer , value ) ;
}
@Override
public int estimateLength () {
return 2 ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
appendTo ( buffer , calendar . get ( Calendar . MONTH ) + 1 ) ;
}
@Override
public final void appendTo ( final Appendable buffer , final int value ) throws IOException {
appendDigits ( buffer , value ) ;
}
@Override
public int estimateLength () {
return mRule . estimateLength () ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
int value = calendar . get ( Calendar . HOUR ) ;
if ( value == 0 ) {
value = calendar . getLeastMaximum ( Calendar . HOUR ) + 1 ;
}
mRule . appendTo ( buffer , value ) ;
}
@Override
public void appendTo ( final Appendable buffer , final int value ) throws IOException {
mRule . appendTo ( buffer , value ) ;
}
@Override
public int estimateLength () {
return mRule . estimateLength () ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
int value = calendar . get ( Calendar . HOUR_OF_DAY ) ;
if ( value == 0 ) {
value = calendar . getMaximum ( Calendar . HOUR_OF_DAY ) + 1 ;
}
mRule . appendTo ( buffer , value ) ;
}
@Override
public void appendTo ( final Appendable buffer , final int value ) throws IOException {
mRule . appendTo ( buffer , value ) ;
}
@Override
public int estimateLength () {
return mRule . estimateLength () ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
int value = calendar . get ( Calendar . DAY_OF_WEEK ) ;
mRule . appendTo ( buffer , value != Calendar . SUNDAY ? value - 1 : 7 ) ;
}
@Override
public void appendTo ( final Appendable buffer , final int value ) throws IOException {
mRule . appendTo ( buffer , value ) ;
}
static String getTimeZoneDisplay ( final TimeZone tz , final boolean daylight , final int style , final Locale locale ) { MST[ReturnValsMutator]MSP[N]
final TimeZoneDisplayKey key = new TimeZoneDisplayKey ( tz , daylight , style , locale ) ;
String value = cTimeZoneDisplayCache . get ( key ) ;
if ( value == null ) {
value = tz . getDisplayName ( daylight , style , locale ) ;
final String prior = cTimeZoneDisplayCache . putIfAbsent ( key , value ) ;
if ( prior != null ) {
value = prior ;
}
}
return value ;
}
@Override
public int estimateLength () {
return Math . max ( mStandard . length () , mDaylight . length () ) ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
final TimeZone zone = calendar . getTimeZone () ;
if ( calendar . get ( Calendar . DST_OFFSET ) != 0 ) {
buffer . append ( getTimeZoneDisplay ( zone , true , mStyle , mLocale ) ) ;
} else {
buffer . append ( getTimeZoneDisplay ( zone , false , mStyle , mLocale ) ) ;
}
}
@Override
public int estimateLength () {
return 5 ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
int offset = calendar . get ( Calendar . ZONE_OFFSET ) + calendar . get ( Calendar . DST_OFFSET ) ;
if ( offset < 0 ) {
buffer . append ( '-' ) ;
offset = - offset ;
} else {
buffer . append ( '+' ) ;
}
final int hours = offset / ( 60 * 60 * 1000 ) ;
appendDigits ( buffer , hours ) ;
if ( mColon ) {
buffer . append ( ':' ) ;
}
final int minutes = offset / ( 60 * 1000 ) - 60 * hours ;
appendDigits ( buffer , minutes ) ;
}
static Iso8601_Rule getRule ( int tokenLen ) {
switch( tokenLen ) {
case 1 :
return Iso8601_Rule . ISO8601_HOURS ;
case 2 :
return Iso8601_Rule . ISO8601_HOURS_MINUTES ;
case 3 :
return Iso8601_Rule . ISO8601_HOURS_COLON_MINUTES ;
default:
throw new IllegalArgumentException ( lr_7 ) ;
}
}
@Override
public int estimateLength () {
return length ;
}
@Override
public void appendTo ( final Appendable buffer , final Calendar calendar ) throws IOException {
int offset = calendar . get ( Calendar . ZONE_OFFSET ) + calendar . get ( Calendar . DST_OFFSET ) ;
if ( offset == 0 ) {
buffer . append ( lr_8 ) ;
return;
}
if ( offset < 0 ) {
buffer . append ( '-' ) ;
offset = - offset ;
} else {
buffer . append ( '+' ) ;
}
final int hours = offset / ( 60 * 60 * 1000 ) ;
appendDigits ( buffer , hours ) ;
if ( length < 5 ) {
return;
}
if ( length == 6 ) {
buffer . append ( ':' ) ;
}
final int minutes = offset / ( 60 * 1000 ) - 60 * hours ;
appendDigits ( buffer , minutes ) ;
}
@Override
public int hashCode () {
return ( mStyle * 31 + mLocale . hashCode () ) * 31 + mTimeZone . hashCode () ;
}
@Override
public boolean equals ( final Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof TimeZoneDisplayKey ) {
final TimeZoneDisplayKey other = ( TimeZoneDisplayKey ) obj ;
return
mTimeZone . equals ( other . mTimeZone ) &&
mStyle == other . mStyle &&
mLocale . equals ( other . mLocale ) ;
}
return false ;
}
