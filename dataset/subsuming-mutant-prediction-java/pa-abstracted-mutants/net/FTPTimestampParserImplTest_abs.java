public void testParseTimestamp () {
final Calendar cal = Calendar . getInstance () ;
cal . add ( Calendar . HOUR_OF_DAY , 1 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
cal . set ( Calendar . MILLISECOND , 0 ) ;
final Date anHourFromNow = cal . getTime () ;
final FTPTimestampParserImpl parser = new FTPTimestampParserImpl () ;
final SimpleDateFormat sdf =
new SimpleDateFormat ( parser . getRecentDateFormatString () ) ;
final String fmtTime = sdf . format ( anHourFromNow ) ;
try {
final Calendar parsed = parser . parseTimestamp ( fmtTime ) ;
assertEquals ( lr_1 , 1 , cal . get ( Calendar . YEAR ) - parsed . get ( Calendar . YEAR ) ) ;
} catch ( final ParseException e ) {
fail ( lr_2 ) ;
}
}
public void testParseTimestampWithSlop () {
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . SECOND , 0 ) ;
cal . set ( Calendar . MILLISECOND , 0 ) ;
final Calendar caltemp = ( Calendar ) cal . clone () ;
caltemp . add ( Calendar . HOUR_OF_DAY , 1 ) ;
final Date anHourFromNow = caltemp . getTime () ;
caltemp . add ( Calendar . DAY_OF_MONTH , 1 ) ;
final Date anHourFromNowTomorrow = caltemp . getTime () ;
final FTPTimestampParserImpl parser = new FTPTimestampParserImpl () ;
parser . setLenientFutureDates ( true ) ;
final SimpleDateFormat sdf =
new SimpleDateFormat ( parser . getRecentDateFormatString () ) ;
try {
String fmtTime = sdf . format ( anHourFromNow ) ;
Calendar parsed = parser . parseTimestamp ( fmtTime ) ;
assertEquals ( lr_3 , 0 , cal . get ( Calendar . YEAR ) - parsed . get ( Calendar . YEAR ) ) ;
fmtTime = sdf . format ( anHourFromNowTomorrow ) ;
parsed = parser . parseTimestamp ( fmtTime ) ;
assertEquals ( lr_4 , 1 , cal . get ( Calendar . YEAR ) - parsed . get ( Calendar . YEAR ) ) ;
} catch ( final ParseException e ) {
fail ( lr_2 ) ;
}
}
public void testNET444 () throws Exception {
final FTPTimestampParserImpl parser = new FTPTimestampParserImpl () ;
parser . setLenientFutureDates ( true ) ;
final SimpleDateFormat sdf = new SimpleDateFormat ( parser . getRecentDateFormatString () ) ;
final GregorianCalendar now = new GregorianCalendar ( 2012 , Calendar . FEBRUARY , 28 , 12 , 0 ) ;
final GregorianCalendar nowplus1 = new GregorianCalendar ( 2012 , Calendar . FEBRUARY , 28 , 13 , 0 ) ;
final String future1 = sdf . format ( nowplus1 . getTime () ) ;
final Calendar parsed1 = parser . parseTimestamp ( future1 , now ) ;
assertEquals ( nowplus1 . get ( Calendar . YEAR ) , parsed1 . get ( Calendar . YEAR ) ) ;
final GregorianCalendar nowplus25 = new GregorianCalendar ( 2012 , Calendar . FEBRUARY , 29 , 13 , 0 ) ;
final String future25 = sdf . format ( nowplus25 . getTime () ) ;
final Calendar parsed25 = parser . parseTimestamp ( future25 , now ) ;
assertEquals ( nowplus25 . get ( Calendar . YEAR ) - 1 , parsed25 . get ( Calendar . YEAR ) ) ;
}
public void testParseTimestampAcrossTimeZones () {
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . SECOND , 0 ) ;
cal . set ( Calendar . MILLISECOND , 0 ) ;
cal . add ( Calendar . HOUR_OF_DAY , 1 ) ;
final Date anHourFromNow = cal . getTime () ;
cal . add ( Calendar . HOUR_OF_DAY , 2 ) ;
final Date threeHoursFromNow = cal . getTime () ;
cal . add ( Calendar . HOUR_OF_DAY , - 2 ) ;
final FTPTimestampParserImpl parser = new FTPTimestampParserImpl () ;
final FTPClientConfig config =
new FTPClientConfig ( FTPClientConfig . SYST_UNIX ) ;
config . setDefaultDateFormatStr ( FTPTimestampParser . DEFAULT_SDF ) ;
config . setRecentDateFormatStr ( FTPTimestampParser . DEFAULT_RECENT_SDF ) ;
config . setServerTimeZoneId ( lr_5 ) ;
config . setLenientFutureDates ( false ) ;
parser . configure ( config ) ;
final SimpleDateFormat sdf = ( SimpleDateFormat )
parser . getRecentDateFormat () . clone () ;
final TimeZone tzla = TimeZone . getTimeZone ( lr_6 ) ;
sdf . setTimeZone ( tzla ) ;
final String fmtTimePlusOneHour = sdf . format ( anHourFromNow ) ;
final String fmtTimePlusThreeHours = sdf . format ( threeHoursFromNow ) ;
try {
final Calendar parsed = parser . parseTimestamp ( fmtTimePlusOneHour ) ;
assertEquals ( lr_7 ,
TWO_HOURS_OF_MILLISECONDS ,
cal . getTime () . getTime () - parsed . getTime () . getTime () ) ;
} catch ( final ParseException e ) {
fail ( lr_8 + fmtTimePlusOneHour ) ;
}
try {
final Calendar parsed = parser . parseTimestamp ( fmtTimePlusThreeHours ) ;
assertEquals ( lr_9 ,
1 , cal . get ( Calendar . YEAR ) - parsed . get ( Calendar . YEAR ) ) ;
} catch ( final ParseException e ) {
fail ( lr_2 + fmtTimePlusThreeHours ) ;
}
}
public void testParser () {
final Locale locale = Locale . getDefault () ;
try {
Locale . setDefault ( Locale . ENGLISH ) ;
final FTPTimestampParserImpl parser = new FTPTimestampParserImpl () ;
try {
parser . parseTimestamp ( lr_10 ) ;
} catch ( final ParseException e ) {
fail ( lr_11 ) ;
}
try {
final Calendar c = parser . parseTimestamp ( lr_12 ) ;
fail ( lr_13 + c . getTime () . toString () ) ;
} catch ( final ParseException e ) {
}
final FTPClientConfig config = new FTPClientConfig () ;
config . setDefaultDateFormatStr ( lr_14 ) ;
config . setRecentDateFormatStr ( lr_15 ) ;
config . setServerLanguageCode ( lr_16 ) ;
parser . configure ( config ) ;
try {
parser . parseTimestamp ( lr_17 ) ;
fail ( lr_18 ) ;
} catch ( final ParseException e ) {
}
try {
parser . parseTimestamp ( lr_19 ) ;
} catch ( final ParseException e ) {
fail ( lr_20 ) ;
}
try {
parser . parseTimestamp ( lr_21 ) ;
fail ( lr_22 ) ;
} catch ( final ParseException e ) {
}
try {
parser . parseTimestamp ( lr_23 ) ;
fail ( lr_24 ) ;
} catch ( final ParseException e ) {
}
try {
parser . parseTimestamp ( lr_25 ) ;
fail ( lr_26 ) ;
} catch ( final ParseException e ) {
}
try {
parser . parseTimestamp ( lr_27 ) ;
fail ( lr_28 ) ;
} catch ( final ParseException e ) {
}
try {
parser . parseTimestamp ( lr_29 ) ;
} catch ( final ParseException e ) {
fail ( lr_30 ) ;
}
} finally {
Locale . setDefault ( locale ) ;
}
}
private void checkShortParse ( final String msg , final Calendar serverTime , final Calendar input ) throws ParseException {
checkShortParse ( msg , serverTime , input , false ) ;
checkShortParse ( msg , serverTime , input , true ) ;
}
private void checkShortParse ( final String msg , final Calendar serverTime , final Calendar input , final Calendar expected ) throws ParseException {
checkShortParse ( msg , serverTime , input , expected , false ) ;
checkShortParse ( msg , serverTime , input , expected , true ) ;
}
private void checkShortParse ( final String msg , final Calendar servertime , final Calendar input , final boolean lenient ) throws ParseException {
checkShortParse ( msg , servertime , input , input , lenient ) ;
}
private void checkShortParse ( final String msg , final Calendar servertime , final Calendar input , final Calendar expected , final boolean lenient )
throws ParseException {
final FTPTimestampParserImpl parser = new FTPTimestampParserImpl () ;
parser . setLenientFutureDates ( lenient ) ;
final SimpleDateFormat shortFormat = parser . getRecentDateFormat () ;
final String shortDate = shortFormat . format ( input . getTime () ) ;
final Calendar output = parser . parseTimestamp ( shortDate , servertime ) ;
final int outyear = output . get ( Calendar . YEAR ) ;
final int outdom = output . get ( Calendar . DAY_OF_MONTH ) ;
final int outmon = output . get ( Calendar . MONTH ) ;
final int inyear = expected . get ( Calendar . YEAR ) ;
final int indom = expected . get ( Calendar . DAY_OF_MONTH ) ;
final int inmon = expected . get ( Calendar . MONTH ) ;
if ( indom != outdom || inmon != outmon || inyear != outyear ) {
final Format longFormat = new SimpleDateFormat ( lr_31 ) ;
fail ( lr_32 + msg + lr_33 + longFormat . format ( servertime . getTime () )
+ lr_34 + shortDate + ( lenient ? lr_35 : lr_36 )
+ lr_37 + shortFormat . toPattern ()
+ lr_38 + longFormat . format ( output . getTime () )
+ lr_39 + longFormat . format ( expected . getTime () ) ) ;
}
}
public void testParseShortPastDates1 () throws Exception {
final GregorianCalendar now = new GregorianCalendar ( 2001 , Calendar . MAY , 30 , 12 , 0 ) ;
checkShortParse ( lr_40 , now , now ) ;
final GregorianCalendar target = ( GregorianCalendar ) now . clone () ;
target . add ( Calendar . WEEK_OF_YEAR , - 1 ) ;
checkShortParse ( lr_41 , now , target ) ;
target . add ( Calendar . WEEK_OF_YEAR , - 12 ) ;
checkShortParse ( lr_42 , now , target ) ;
target . add ( Calendar . WEEK_OF_YEAR , - 13 ) ;
checkShortParse ( lr_43 , now , target ) ;
}
public void testParseShortPastDates2 () throws Exception {
final GregorianCalendar now = new GregorianCalendar ( 2004 , Calendar . AUGUST , 1 , 12 , 0 ) ;
checkShortParse ( lr_44 , now , now ) ;
final GregorianCalendar target = ( GregorianCalendar ) now . clone () ;
target . add ( Calendar . WEEK_OF_YEAR , - 1 ) ;
checkShortParse ( lr_45 , now , target ) ;
target . add ( Calendar . WEEK_OF_YEAR , - 12 ) ;
checkShortParse ( lr_46 , now , target ) ;
target . add ( Calendar . WEEK_OF_YEAR , - 13 ) ;
checkShortParse ( lr_47 , now , target ) ;
}
public void testParseShortFutureDates1 () throws Exception {
final GregorianCalendar now = new GregorianCalendar ( 2001 , Calendar . MAY , 30 , 12 , 0 ) ;
checkShortParse ( lr_40 , now , now ) ;
final GregorianCalendar target = ( GregorianCalendar ) now . clone () ;
target . add ( Calendar . DAY_OF_MONTH , 1 ) ;
checkShortParse ( lr_48 , now , target , true ) ;
try {
checkShortParse ( lr_48 , now , target , false ) ;
fail ( lr_49 ) ;
} catch ( final AssertionFailedError pe ) {
if ( pe . getMessage () . startsWith ( lr_49 ) ) {
throw pe ;
}
}
target . add ( Calendar . WEEK_OF_YEAR , 1 ) ;
}
public void testParseShortFutureDates2 () throws Exception {
final GregorianCalendar now = new GregorianCalendar ( 2004 , Calendar . AUGUST , 1 , 12 , 0 ) ;
checkShortParse ( lr_44 , now , now ) ;
final GregorianCalendar target = ( GregorianCalendar ) now . clone () ;
target . add ( Calendar . DAY_OF_MONTH , 1 ) ;
checkShortParse ( lr_50 , now , target , true ) ;
try {
checkShortParse ( lr_50 , now , target , false ) ;
fail ( lr_49 ) ;
} catch ( final AssertionFailedError pe ) {
if ( pe . getMessage () . startsWith ( lr_49 ) ) {
throw pe ;
}
}
}
public void testFeb29IfLeapYear () throws Exception {
final GregorianCalendar now = new GregorianCalendar () ;
final int thisYear = now . get ( Calendar . YEAR ) ;
final GregorianCalendar target = new GregorianCalendar ( thisYear , Calendar . FEBRUARY , 29 ) ;
if ( now . isLeapYear ( thisYear )
&& now . after ( target )
&& now . before ( new GregorianCalendar ( thisYear , Calendar . AUGUST , 29 ) )
) {
checkShortParse ( lr_51 , now , target ) ;
} else {
System . out . println ( lr_52 ) ;
}
}
public void testFeb29LeapYear () throws Exception {
final int year = 2000 ;
final GregorianCalendar now = new GregorianCalendar ( year , Calendar . APRIL , 1 , 12 , 0 ) ;
checkShortParse ( lr_53 , now , new GregorianCalendar ( year , Calendar . FEBRUARY , 29 ) ) ;
}
public void testFeb29LeapYear2 () throws Exception {
final int year = 2000 ;
final GregorianCalendar now = new GregorianCalendar ( year , Calendar . MARCH , 1 , 12 , 0 ) ;
checkShortParse ( lr_53 , now , new GregorianCalendar ( year , Calendar . FEBRUARY , 29 ) ) ;
}
public void testFeb29LeapYear3 () throws Exception {
final int year = 2000 ;
final GregorianCalendar now = new GregorianCalendar ( year , Calendar . FEBRUARY , 29 , 12 , 0 ) ;
checkShortParse ( lr_53 , now , new GregorianCalendar ( year , Calendar . FEBRUARY , 29 ) ) ;
}
public void testFeb29LeapYear4 () throws Exception {
final int year = 2000 ;
final GregorianCalendar now = new GregorianCalendar ( year , Calendar . FEBRUARY , 28 , 12 , 0 ) ;
checkShortParse ( lr_53 , now , new GregorianCalendar ( year , Calendar . FEBRUARY , 29 ) , true ) ;
}
public void testFeb29NonLeapYear () {
final GregorianCalendar server = new GregorianCalendar ( 1999 , Calendar . APRIL , 1 , 12 , 0 ) ;
final GregorianCalendar input = new GregorianCalendar ( 2000 , Calendar . FEBRUARY , 29 ) ;
final GregorianCalendar expected = new GregorianCalendar ( 1999 , Calendar . FEBRUARY , 29 ) ;
try {
checkShortParse ( lr_54 , server , input , expected , true ) ;
fail ( lr_55 ) ;
} catch ( final ParseException pe ) {
}
try {
checkShortParse ( lr_54 , server , input , expected , false ) ;
fail ( lr_55 ) ;
} catch ( final ParseException pe ) {
}
}
public void DISABLEDtestNET446 () throws Exception {
final GregorianCalendar server = new GregorianCalendar ( 2001 , Calendar . JANUARY , 1 , 12 , 0 ) ;
final GregorianCalendar input = new GregorianCalendar ( 2000 , Calendar . FEBRUARY , 29 ) ;
final GregorianCalendar expected = new GregorianCalendar ( 2000 , Calendar . FEBRUARY , 29 ) ;
checkShortParse ( lr_53 , server , input , expected ) ;
}
public void testParseDec31Lenient () throws Exception {
final GregorianCalendar now = new GregorianCalendar ( 2007 , Calendar . DECEMBER , 30 , 12 , 0 ) ;
checkShortParse ( lr_56 , now , now ) ;
final GregorianCalendar target = ( GregorianCalendar ) now . clone () ;
target . add ( Calendar . DAY_OF_YEAR , + 1 ) ;
checkShortParse ( lr_57 , now , target , true ) ;
}
public void testParseJan01Lenient () throws Exception {
final GregorianCalendar now = new GregorianCalendar ( 2007 , Calendar . DECEMBER , 31 , 12 , 0 ) ;
checkShortParse ( lr_57 , now , now ) ;
final GregorianCalendar target = ( GregorianCalendar ) now . clone () ;
target . add ( Calendar . DAY_OF_YEAR , + 1 ) ;
checkShortParse ( lr_58 , now , target , true ) ;
}
public void testParseJan01 () throws Exception {
final GregorianCalendar now = new GregorianCalendar ( 2007 , Calendar . JANUARY , 1 , 12 , 0 ) ;
checkShortParse ( lr_59 , now , now ) ;
final GregorianCalendar target = new GregorianCalendar ( 2006 , Calendar . DECEMBER , 31 , 12 , 0 ) ;
checkShortParse ( lr_60 , now , target , true ) ;
checkShortParse ( lr_60 , now , target , false ) ;
}
