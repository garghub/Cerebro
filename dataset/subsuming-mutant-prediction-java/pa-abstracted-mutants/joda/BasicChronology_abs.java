public DateTimeZone getZone () {
Chronology base ;
if ( ( base = getBase () ) != null ) {
return base . getZone () ;
}
return DateTimeZone . UTC ;
}
@Override
public long getDateTimeMillis (
int year , int monthOfYear , int dayOfMonth , int millisOfDay )
throws IllegalArgumentException {
Chronology base ;
if ( ( base = getBase () ) != null ) {
return base . getDateTimeMillis ( year , monthOfYear , dayOfMonth , millisOfDay ) ;
}
FieldUtils . verifyValueBounds
( DateTimeFieldType . millisOfDay () , millisOfDay , 0 , DateTimeConstants . MILLIS_PER_DAY - 1 ) ;
return getDateTimeMillis0 ( year , monthOfYear , dayOfMonth , millisOfDay ) ;
}
@Override
public long getDateTimeMillis (
int year , int monthOfYear , int dayOfMonth ,
int hourOfDay , int minuteOfHour , int secondOfMinute , int millisOfSecond )
throws IllegalArgumentException {
Chronology base ;
if ( ( base = getBase () ) != null ) {
return base . getDateTimeMillis ( year , monthOfYear , dayOfMonth ,
hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
}
FieldUtils . verifyValueBounds ( DateTimeFieldType . hourOfDay () , hourOfDay , 0 , 23 ) ;
FieldUtils . verifyValueBounds ( DateTimeFieldType . minuteOfHour () , minuteOfHour , 0 , 59 ) ;
FieldUtils . verifyValueBounds ( DateTimeFieldType . secondOfMinute () , secondOfMinute , 0 , 59 ) ;
FieldUtils . verifyValueBounds ( DateTimeFieldType . millisOfSecond () , millisOfSecond , 0 , 999 ) ;
long millisOfDay = hourOfDay * DateTimeConstants . MILLIS_PER_HOUR
+ minuteOfHour * DateTimeConstants . MILLIS_PER_MINUTE
+ secondOfMinute * DateTimeConstants . MILLIS_PER_SECOND
+ millisOfSecond ;
return getDateTimeMillis0 ( year , monthOfYear , dayOfMonth , ( int ) millisOfDay ) ;
}
private long getDateTimeMillis0 ( int year , int monthOfYear , int dayOfMonth , int millisOfDay ) {
long dayInstant = getDateMidnightMillis ( year , monthOfYear , dayOfMonth ) ;
if ( dayInstant == Long . MIN_VALUE ) {
dayInstant = getDateMidnightMillis ( year , monthOfYear , dayOfMonth + 1 ) ;
millisOfDay = millisOfDay - 86400000 ;
}
long result = dayInstant + millisOfDay ;
if ( result < 0 && dayInstant > 0 ) {
return Long . MAX_VALUE ;
} else if ( result > 0 && dayInstant < 0 ) {
return Long . MIN_VALUE ;
}
return result ;
}
public int getMinimumDaysInFirstWeek () {
return iMinDaysInFirstWeek ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj != null && getClass () == obj . getClass () ) {
BasicChronology chrono = ( BasicChronology ) obj ;
return getMinimumDaysInFirstWeek () == chrono . getMinimumDaysInFirstWeek () &&
getZone () . equals ( chrono . getZone () ) ;
}
return false ;
}
public int hashCode () {
return getClass () . getName () . hashCode () * 11 + getZone () . hashCode () + getMinimumDaysInFirstWeek () ;
}
public String toString () {
StringBuilder sb = new StringBuilder ( 60 ) ;
String name = getClass () . getName () ;
int index = name . lastIndexOf ( '.' ) ;
if ( index >= 0 ) {
name = name . substring ( index + 1 ) ;
}
sb . append ( name ) ;
sb . append ( '[' ) ;
DateTimeZone zone = getZone () ;
if ( zone != null ) {
sb . append ( zone . getID () ) ;
}
if ( getMinimumDaysInFirstWeek () != 4 ) {
sb . append ( lr_1 ) ;
sb . append ( getMinimumDaysInFirstWeek () ) ;
}
sb . append ( ']' ) ;
return sb . toString () ;
}
protected void assemble ( Fields fields ) {
fields . millis = cMillisField ;
fields . seconds = cSecondsField ;
fields . minutes = cMinutesField ;
fields . hours = cHoursField ;
fields . halfdays = cHalfdaysField ;
fields . days = cDaysField ;
fields . weeks = cWeeksField ;
fields . millisOfSecond = cMillisOfSecondField ;
fields . millisOfDay = cMillisOfDayField ;
fields . secondOfMinute = cSecondOfMinuteField ;
fields . secondOfDay = cSecondOfDayField ;
fields . minuteOfHour = cMinuteOfHourField ;
fields . minuteOfDay = cMinuteOfDayField ;
fields . hourOfDay = cHourOfDayField ;
fields . hourOfHalfday = cHourOfHalfdayField ;
fields . clockhourOfDay = cClockhourOfDayField ;
fields . clockhourOfHalfday = cClockhourOfHalfdayField ;
fields . halfdayOfDay = cHalfdayOfDayField ;
fields . year = new BasicYearDateTimeField ( this ) ;
fields . yearOfEra = new GJYearOfEraDateTimeField ( fields . year , this ) ;
DateTimeField field = new OffsetDateTimeField (
fields . yearOfEra , 99 ) ;
fields . centuryOfEra = new DividedDateTimeField (
field , DateTimeFieldType . centuryOfEra () , 100 ) ;
fields . centuries = fields . centuryOfEra . getDurationField () ;
field = new RemainderDateTimeField (
( DividedDateTimeField ) fields . centuryOfEra ) ;
fields . yearOfCentury = new OffsetDateTimeField (
field , DateTimeFieldType . yearOfCentury () , 1 ) ;
fields . era = new GJEraDateTimeField ( this ) ;
fields . dayOfWeek = new GJDayOfWeekDateTimeField ( this , fields . days ) ;
fields . dayOfMonth = new BasicDayOfMonthDateTimeField ( this , fields . days ) ;
fields . dayOfYear = new BasicDayOfYearDateTimeField ( this , fields . days ) ;
fields . monthOfYear = new GJMonthOfYearDateTimeField ( this ) ;
fields . weekyear = new BasicWeekyearDateTimeField ( this ) ;
fields . weekOfWeekyear = new BasicWeekOfWeekyearDateTimeField ( this , fields . weeks ) ;
field = new RemainderDateTimeField (
fields . weekyear , fields . centuries , DateTimeFieldType . weekyearOfCentury () , 100 ) ;
fields . weekyearOfCentury = new OffsetDateTimeField (
field , DateTimeFieldType . weekyearOfCentury () , 1 ) ;
fields . years = fields . year . getDurationField () ;
fields . months = fields . monthOfYear . getDurationField () ;
fields . weekyears = fields . weekyear . getDurationField () ;
}
int getDaysInYearMax () {
return 366 ;
}
int getDaysInYear ( int year ) {
return isLeapYear ( year ) ? 366 : 365 ;
}
int getWeeksInYear ( int year ) {
long firstWeekMillis1 = getFirstWeekOfYearMillis ( year ) ;
long firstWeekMillis2 = getFirstWeekOfYearMillis ( year + 1 ) ;
return (int) ( ( firstWeekMillis2 - firstWeekMillis1 ) / DateTimeConstants . MILLIS_PER_WEEK ) ;
}
long getFirstWeekOfYearMillis ( int year ) {
long jan1millis = getYearMillis ( year ) ;
int jan1dayOfWeek = getDayOfWeek ( jan1millis ) ;
if ( jan1dayOfWeek > ( 8 - iMinDaysInFirstWeek ) ) {
return jan1millis + ( 8 - jan1dayOfWeek )
* ( long ) DateTimeConstants . MILLIS_PER_DAY ;
} else {
return jan1millis - ( jan1dayOfWeek - 1 )
* ( long ) DateTimeConstants . MILLIS_PER_DAY ;
}
}
long getYearMillis ( int year ) {
return getYearInfo ( year ) . iFirstDayMillis ;
}
long getYearMonthMillis ( int year , int month ) {
long millis = getYearMillis ( year ) ;
millis += getTotalMillisByYearMonth ( year , month ) ;
return millis ;
}
long getYearMonthDayMillis ( int year , int month , int dayOfMonth ) {
long millis = getYearMillis ( year ) ;
millis += getTotalMillisByYearMonth ( year , month ) ;
return millis + ( dayOfMonth - 1 ) * ( long ) DateTimeConstants . MILLIS_PER_DAY ;
}
int getYear ( long instant ) {
long unitMillis = getAverageMillisPerYearDividedByTwo () ;
long i2 = ( instant >> 1 ) + getApproxMillisAtEpochDividedByTwo () ;
if ( i2 < 0 ) {
i2 = i2 - unitMillis + 1 ;
}
int year = (int) ( i2 / unitMillis ) ;
long yearStart = getYearMillis ( year ) ;
long diff = instant - yearStart ;
if ( diff < 0 ) {
year -- ;
} else if ( diff >= DateTimeConstants . MILLIS_PER_DAY * 365L ) {
long oneYear ;
if ( isLeapYear ( year ) ) {
oneYear = DateTimeConstants . MILLIS_PER_DAY * 366L ;
} else {
oneYear = DateTimeConstants . MILLIS_PER_DAY * 365L ;
}
yearStart += oneYear ;
if ( yearStart <= instant ) {
year ++ ;
}
}
return year ;
}
int getMonthOfYear ( long millis ) {
return getMonthOfYear ( millis , getYear ( millis ) ) ;
}
int getDayOfMonth ( long millis ) {
int year = getYear ( millis ) ;
int month = getMonthOfYear ( millis , year ) ;
return getDayOfMonth ( millis , year , month ) ;
}
int getDayOfMonth ( long millis , int year ) {
int month = getMonthOfYear ( millis , year ) ;
return getDayOfMonth ( millis , year , month ) ;
}
int getDayOfMonth ( long millis , int year , int month ) {
long dateMillis = getYearMillis ( year ) ;
dateMillis += getTotalMillisByYearMonth ( year , month ) ;
return (int) ( ( millis - dateMillis ) / DateTimeConstants . MILLIS_PER_DAY ) + 1 ;
}
int getDayOfYear ( long instant ) {
return getDayOfYear ( instant , getYear ( instant ) ) ;
}
int getDayOfYear ( long instant , int year ) {
long yearStart = getYearMillis ( year ) ;
return (int) ( ( instant - yearStart ) / DateTimeConstants . MILLIS_PER_DAY ) + 1 ;
}
int getWeekyear ( long instant ) {
int year = getYear ( instant ) ;
int week = getWeekOfWeekyear ( instant , year ) ;
if ( week == 1 ) {
return getYear ( instant + DateTimeConstants . MILLIS_PER_WEEK ) ;
} else if ( week > 51 ) {
return getYear ( instant - ( 2 * DateTimeConstants . MILLIS_PER_WEEK ) ) ;
} else {
return year ;
}
}
int getWeekOfWeekyear ( long instant ) {
return getWeekOfWeekyear ( instant , getYear ( instant ) ) ;
}
int getWeekOfWeekyear ( long instant , int year ) {
long firstWeekMillis1 = getFirstWeekOfYearMillis ( year ) ;
if ( instant < firstWeekMillis1 ) {
return getWeeksInYear ( year - 1 ) ;
}
long firstWeekMillis2 = getFirstWeekOfYearMillis ( year + 1 ) ;
if ( instant >= firstWeekMillis2 ) {
return 1 ;
}
return (int) ( ( instant - firstWeekMillis1 ) / DateTimeConstants . MILLIS_PER_WEEK ) + 1 ;
}
int getDayOfWeek ( long instant ) {
long daysSince19700101 ;
if ( instant >= 0 ) {
daysSince19700101 = instant / DateTimeConstants . MILLIS_PER_DAY ;
} else {
daysSince19700101 = ( instant - ( DateTimeConstants . MILLIS_PER_DAY - 1 ) )
/ DateTimeConstants . MILLIS_PER_DAY ;
if ( daysSince19700101 < - 3 ) {
return 7 + (int) ( ( daysSince19700101 + 4 ) % 7 ) ;
}
}
return 1 + (int) ( ( daysSince19700101 + 3 ) % 7 ) ;
}
int getMillisOfDay ( long instant ) {
if ( instant >= 0 ) {
return (int) ( instant % DateTimeConstants . MILLIS_PER_DAY ) ;
} else {
return ( DateTimeConstants . MILLIS_PER_DAY - 1 )
+ (int) ( ( instant + 1 ) % DateTimeConstants . MILLIS_PER_DAY ) ;
}
}
int getDaysInMonthMax () {
return 31 ;
}
int getDaysInMonthMax ( long instant ) {
int thisYear = getYear ( instant ) ;
int thisMonth = getMonthOfYear ( instant , thisYear ) ;
return getDaysInYearMonth ( thisYear , thisMonth ) ;
}
int getDaysInMonthMaxForSet ( long instant , int value ) {
return getDaysInMonthMax ( instant ) ;
}
long getDateMidnightMillis ( int year , int monthOfYear , int dayOfMonth ) {
FieldUtils . verifyValueBounds ( DateTimeFieldType . year () , year , getMinYear () - 1 , getMaxYear () + 1 ) ;
FieldUtils . verifyValueBounds ( DateTimeFieldType . monthOfYear () , monthOfYear , 1 , getMaxMonth ( year ) ) ;
int upperBound = getDaysInYearMonth ( year , monthOfYear ) ;
if ( ( dayOfMonth < 1 ) || ( dayOfMonth > upperBound ) ) {
throw new IllegalFieldValueException (
DateTimeFieldType . dayOfMonth () ,
Integer . valueOf ( dayOfMonth ) ,
Integer . valueOf ( 1 ) ,
Integer . valueOf ( upperBound ) ,
lr_2 + year + lr_3 + monthOfYear ) ;
}
long instant = getYearMonthDayMillis ( year , monthOfYear , dayOfMonth ) ;
if ( instant < 0 && year == getMaxYear () + 1 ) {
return Long . MAX_VALUE ;
} else if ( instant > 0 && year == getMinYear () - 1 ) {
return Long . MIN_VALUE ;
}
return instant ;
}
boolean isLeapDay ( long instant ) {
return false ;
}
int getMaxMonth ( int year ) {
return getMaxMonth () ;
}
int getMaxMonth () {
return 12 ;
}
private YearInfo getYearInfo ( int year ) {
YearInfo info = iYearInfoCache [ year & CACHE_MASK ] ;
if ( info == null || info . iYear != year ) {
info = new YearInfo ( year , calculateFirstDayOfYearMillis ( year ) ) ;
iYearInfoCache [ year & CACHE_MASK ] = info ;
}
return info ;
}
public String getAsText ( int fieldValue , Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . halfdayValueToText ( fieldValue ) ;
}
public long set ( long millis , String text , Locale locale ) {
return set ( millis , GJLocaleSymbols . forLocale ( locale ) . halfdayTextToValue ( text ) ) ;
}
public int getMaximumTextLength ( Locale locale ) {
return GJLocaleSymbols . forLocale ( locale ) . getHalfdayMaxTextLength () ;
}
