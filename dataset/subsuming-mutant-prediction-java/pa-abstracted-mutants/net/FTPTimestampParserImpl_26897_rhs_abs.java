private static int getEntry ( final SimpleDateFormat dateFormat ) {
if ( dateFormat == null ) {
return 0 ;
}
final String FORMAT_CHARS = lr_1 ;
final String pattern = dateFormat . toPattern () ;
for( final char ch : FORMAT_CHARS . toCharArray () ) {
if ( pattern . indexOf ( ch ) != - 1 ) {
switch( ch ) {
case 'S' :
return indexOf ( Calendar . MILLISECOND ) ;
case 's' :
return indexOf ( Calendar . SECOND ) ;
case 'm' :
return indexOf ( Calendar . MINUTE ) ;
case 'H' :
return indexOf ( Calendar . HOUR_OF_DAY ) ;
case 'd' :
return indexOf ( Calendar . DAY_OF_MONTH ) ;
case 'M' :
return indexOf ( Calendar . MONTH ) ;
}
}
}
return 0 ;
}
private static int indexOf ( final int calendarUnit ) {
int i ;
for( i = 0 ; i < CALENDAR_UNITS . length ; i ++ ) {
if ( calendarUnit == CALENDAR_UNITS [ i ] ) {
return i ;
}
}
return 0 ;
}
private static void setPrecision ( final int index , final Calendar working ) {
if ( index <= 0 ) {
return;
}
final int field = CALENDAR_UNITS [ index - 1 ] ;
final int value = working . get ( field ) ;
if ( value != 0 ) {
} else {
working . clear ( field ) ;
}
}
@Override
public Calendar parseTimestamp ( final String timestampStr ) throws ParseException {
final Calendar now = Calendar . getInstance () ;
return parseTimestamp ( timestampStr , now ) ;
}
public Calendar parseTimestamp ( final String timestampStr , final Calendar serverTime ) throws ParseException {
final Calendar working = ( Calendar ) serverTime . clone () ;
working . setTimeZone ( getServerTimeZone () ) ;
Date parsed = null ;
if ( recentDateFormat != null ) {
final Calendar now = ( Calendar ) serverTime . clone () ;
now . setTimeZone ( this . getServerTimeZone () ) ;
if ( lenientFutureDates ) {
now . add ( Calendar . DAY_OF_MONTH , 1 ) ;
}
final String year = Integer . toString ( now . get ( Calendar . YEAR ) ) ;
final String timeStampStrPlusYear = timestampStr + lr_2 + year ;
final SimpleDateFormat hackFormatter = new SimpleDateFormat ( recentDateFormat . toPattern () + lr_3 ,
recentDateFormat . getDateFormatSymbols () ) ; MST[rv.CRCR3Mutator]MSP[N]
hackFormatter . setLenient ( false ) ;
hackFormatter . setTimeZone ( recentDateFormat . getTimeZone () ) ;
final ParsePosition pp = new ParsePosition ( 0 ) ;
parsed = hackFormatter . parse ( timeStampStrPlusYear , pp ) ;
if ( parsed != null && pp . getIndex () == timeStampStrPlusYear . length () ) {
working . setTime ( parsed ) ;
if ( working . after ( now ) ) {
working . add ( Calendar . YEAR , - 1 ) ;
}
setPrecision ( recentDateSmallestUnitIndex , working ) ;
return working ;
}
}
final ParsePosition pp = new ParsePosition ( 0 ) ;
parsed = defaultDateFormat . parse ( timestampStr , pp ) ;
if ( parsed != null && pp . getIndex () == timestampStr . length () ) {
working . setTime ( parsed ) ;
} else {
throw new ParseException (
lr_4 + timestampStr + lr_5
+ serverTime . getTime () . toString () ,
pp . getErrorIndex () ) ;
}
setPrecision ( defaultDateSmallestUnitIndex , working ) ;
return working ;
}
public SimpleDateFormat getDefaultDateFormat () {
return defaultDateFormat ;
}
public String getDefaultDateFormatString () {
return defaultDateFormat . toPattern () ;
}
private void setDefaultDateFormat ( final String format , final DateFormatSymbols dfs ) {
if ( format != null ) {
if ( dfs != null ) {
this . defaultDateFormat = new SimpleDateFormat ( format , dfs ) ;
} else {
this . defaultDateFormat = new SimpleDateFormat ( format ) ;
}
this . defaultDateFormat . setLenient ( false ) ;
} else {
this . defaultDateFormat = null ;
}
this . defaultDateSmallestUnitIndex = getEntry ( this . defaultDateFormat ) ;
}
public SimpleDateFormat getRecentDateFormat () {
return recentDateFormat ;
}
public String getRecentDateFormatString () {
return recentDateFormat . toPattern () ;
}
private void setRecentDateFormat ( final String format , final DateFormatSymbols dfs ) {
if ( format != null ) {
if ( dfs != null ) {
this . recentDateFormat = new SimpleDateFormat ( format , dfs ) ;
} else {
this . recentDateFormat = new SimpleDateFormat ( format ) ;
}
this . recentDateFormat . setLenient ( false ) ;
} else {
this . recentDateFormat = null ;
}
this . recentDateSmallestUnitIndex = getEntry ( this . recentDateFormat ) ;
}
public String [] getShortMonths () {
return defaultDateFormat . getDateFormatSymbols () . getShortMonths () ;
}
public TimeZone getServerTimeZone () {
return this . defaultDateFormat . getTimeZone () ;
}
private void setServerTimeZone ( final String serverTimeZoneId ) {
TimeZone serverTimeZone = TimeZone . getDefault () ;
if ( serverTimeZoneId != null ) {
serverTimeZone = TimeZone . getTimeZone ( serverTimeZoneId ) ;
}
this . defaultDateFormat . setTimeZone ( serverTimeZone ) ;
if ( this . recentDateFormat != null ) {
this . recentDateFormat . setTimeZone ( serverTimeZone ) ;
}
}
@Override
public void configure ( final FTPClientConfig config ) {
DateFormatSymbols dfs = null ;
final String languageCode = config . getServerLanguageCode () ;
final String shortmonths = config . getShortMonthNames () ;
if ( shortmonths != null ) {
dfs = FTPClientConfig . getDateFormatSymbols ( shortmonths ) ;
} else if ( languageCode != null ) {
dfs = FTPClientConfig . lookupDateFormatSymbols ( languageCode ) ;
} else {
dfs = FTPClientConfig . lookupDateFormatSymbols ( lr_6 ) ;
}
final String recentFormatString = config . getRecentDateFormatStr () ;
setRecentDateFormat ( recentFormatString , dfs ) ;
final String defaultFormatString = config . getDefaultDateFormatStr () ;
if ( defaultFormatString == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
setDefaultDateFormat ( defaultFormatString , dfs ) ;
setServerTimeZone ( config . getServerTimeZoneId () ) ;
this . lenientFutureDates = config . isLenientFutureDates () ;
}
boolean isLenientFutureDates () {
return lenientFutureDates ;
}
void setLenientFutureDates ( final boolean lenientFutureDates ) {
this . lenientFutureDates = lenientFutureDates ;
}
