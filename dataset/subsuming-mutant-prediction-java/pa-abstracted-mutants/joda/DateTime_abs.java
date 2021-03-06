public static DateTime now () {
return new DateTime () ;
}
public static DateTime now ( DateTimeZone zone ) {
if ( zone == null ) {
throw new NullPointerException ( lr_1 ) ;
}
return new DateTime ( zone ) ;
}
public static DateTime now ( Chronology chronology ) {
if ( chronology == null ) {
throw new NullPointerException ( lr_2 ) ;
}
return new DateTime ( chronology ) ;
}
@FromString
public static DateTime parse ( String str ) {
return parse ( str , ISODateTimeFormat . dateTimeParser () . withOffsetParsed () ) ;
}
public static DateTime parse ( String str , DateTimeFormatter formatter ) {
return formatter . parseDateTime ( str ) ;
}
public DateTime toDateTime () {
return this ;
}
public DateTime toDateTimeISO () {
if ( getChronology () == ISOChronology . getInstance () ) {
return this ;
}
return super . toDateTimeISO () ;
}
public DateTime toDateTime ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
if ( getZone () == zone ) {
return this ;
}
return super . toDateTime ( zone ) ;
}
public DateTime toDateTime ( Chronology chronology ) {
chronology = DateTimeUtils . getChronology ( chronology ) ;
if ( getChronology () == chronology ) {
return this ;
}
return super . toDateTime ( chronology ) ;
}
public DateTime withMillis ( long newMillis ) {
return ( newMillis == getMillis () ? this : new DateTime ( newMillis , getChronology () ) ) ;
}
public DateTime withChronology ( Chronology newChronology ) {
newChronology = DateTimeUtils . getChronology ( newChronology ) ;
return ( newChronology == getChronology () ? this : new DateTime ( getMillis () , newChronology ) ) ;
}
public DateTime withZone ( DateTimeZone newZone ) {
return withChronology ( getChronology () . withZone ( newZone ) ) ;
}
public DateTime withZoneRetainFields ( DateTimeZone newZone ) {
newZone = DateTimeUtils . getZone ( newZone ) ;
DateTimeZone originalZone = DateTimeUtils . getZone ( getZone () ) ;
if ( newZone == originalZone ) {
return this ;
}
long millis = originalZone . getMillisKeepLocal ( newZone , getMillis () ) ;
return new DateTime ( millis , getChronology () . withZone ( newZone ) ) ;
}
public DateTime withEarlierOffsetAtOverlap () {
long newMillis = getZone () . adjustOffset ( getMillis () , false ) ;
return withMillis ( newMillis ) ;
}
public DateTime withLaterOffsetAtOverlap () {
long newMillis = getZone () . adjustOffset ( getMillis () , true ) ;
return withMillis ( newMillis ) ;
}
public DateTime withDate ( int year , int monthOfYear , int dayOfMonth ) {
Chronology chrono = getChronology () ;
long localInstant = chrono . withUTC () . getDateTimeMillis ( year , monthOfYear , dayOfMonth , getMillisOfDay () ) ;
return withMillis ( chrono . getZone () . convertLocalToUTC ( localInstant , false , getMillis () ) ) ;
}
public DateTime withDate ( LocalDate date ) {
return withDate (
date . getYear () , date . getMonthOfYear () , date . getDayOfMonth () ) ;
}
public DateTime withTime ( int hourOfDay , int minuteOfHour , int secondOfMinute , int millisOfSecond ) {
Chronology chrono = getChronology () ;
long localInstant = chrono . withUTC () . getDateTimeMillis (
getYear () , getMonthOfYear () , getDayOfMonth () , hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
return withMillis ( chrono . getZone () . convertLocalToUTC ( localInstant , false , getMillis () ) ) ;
}
public DateTime withTime ( LocalTime time ) {
return withTime (
time . getHourOfDay () , time . getMinuteOfHour () , time . getSecondOfMinute () , time . getMillisOfSecond () ) ;
}
public DateTime withTimeAtStartOfDay () {
return toLocalDate () . toDateTimeAtStartOfDay ( getZone () ) ;
}
public DateTime withFields ( ReadablePartial partial ) {
if ( partial == null ) {
return this ;
}
return withMillis ( getChronology () . set ( partial , getMillis () ) ) ;
}
public DateTime withField ( DateTimeFieldType fieldType , int value ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
long instant = fieldType . getField ( getChronology () ) . set ( getMillis () , value ) ;
return withMillis ( instant ) ;
}
public DateTime withFieldAdded ( DurationFieldType fieldType , int amount ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( amount == 0 ) {
return this ;
}
long instant = fieldType . getField ( getChronology () ) . add ( getMillis () , amount ) ;
return withMillis ( instant ) ;
}
public DateTime withDurationAdded ( long durationToAdd , int scalar ) {
if ( durationToAdd == 0 || scalar == 0 ) {
return this ;
}
long instant = getChronology () . add ( getMillis () , durationToAdd , scalar ) ;
return withMillis ( instant ) ;
}
public DateTime withDurationAdded ( ReadableDuration durationToAdd , int scalar ) {
if ( durationToAdd == null || scalar == 0 ) {
return this ;
}
return withDurationAdded ( durationToAdd . getMillis () , scalar ) ;
}
public DateTime withPeriodAdded ( ReadablePeriod period , int scalar ) {
if ( period == null || scalar == 0 ) {
return this ;
}
long instant = getChronology () . add ( period , getMillis () , scalar ) ;
return withMillis ( instant ) ;
}
public DateTime plus ( long duration ) {
return withDurationAdded ( duration , 1 ) ;
}
public DateTime plus ( ReadableDuration duration ) {
return withDurationAdded ( duration , 1 ) ;
}
public DateTime plus ( ReadablePeriod period ) {
return withPeriodAdded ( period , 1 ) ;
}
public DateTime plusYears ( int years ) {
if ( years == 0 ) {
return this ;
}
long instant = getChronology () . years () . add ( getMillis () , years ) ;
return withMillis ( instant ) ;
}
public DateTime plusMonths ( int months ) {
if ( months == 0 ) {
return this ;
}
long instant = getChronology () . months () . add ( getMillis () , months ) ;
return withMillis ( instant ) ;
}
public DateTime plusWeeks ( int weeks ) {
if ( weeks == 0 ) {
return this ;
}
long instant = getChronology () . weeks () . add ( getMillis () , weeks ) ;
return withMillis ( instant ) ;
}
public DateTime plusDays ( int days ) {
if ( days == 0 ) {
return this ;
}
long instant = getChronology () . days () . add ( getMillis () , days ) ;
return withMillis ( instant ) ;
}
public DateTime plusHours ( int hours ) {
if ( hours == 0 ) {
return this ;
}
long instant = getChronology () . hours () . add ( getMillis () , hours ) ;
return withMillis ( instant ) ;
}
public DateTime plusMinutes ( int minutes ) {
if ( minutes == 0 ) {
return this ;
}
long instant = getChronology () . minutes () . add ( getMillis () , minutes ) ;
return withMillis ( instant ) ;
}
public DateTime plusSeconds ( int seconds ) {
if ( seconds == 0 ) {
return this ;
}
long instant = getChronology () . seconds () . add ( getMillis () , seconds ) ;
return withMillis ( instant ) ;
}
public DateTime plusMillis ( int millis ) {
if ( millis == 0 ) {
return this ;
}
long instant = getChronology () . millis () . add ( getMillis () , millis ) ;
return withMillis ( instant ) ;
}
public DateTime minus ( long duration ) {
return withDurationAdded ( duration , - 1 ) ;
}
public DateTime minus ( ReadableDuration duration ) {
return withDurationAdded ( duration , - 1 ) ;
}
public DateTime minus ( ReadablePeriod period ) {
return withPeriodAdded ( period , - 1 ) ;
}
public DateTime minusYears ( int years ) {
if ( years == 0 ) {
return this ;
}
long instant = getChronology () . years () . subtract ( getMillis () , years ) ;
return withMillis ( instant ) ;
}
public DateTime minusMonths ( int months ) {
if ( months == 0 ) {
return this ;
}
long instant = getChronology () . months () . subtract ( getMillis () , months ) ;
return withMillis ( instant ) ;
}
public DateTime minusWeeks ( int weeks ) {
if ( weeks == 0 ) {
return this ;
}
long instant = getChronology () . weeks () . subtract ( getMillis () , weeks ) ;
return withMillis ( instant ) ;
}
public DateTime minusDays ( int days ) {
if ( days == 0 ) {
return this ;
}
long instant = getChronology () . days () . subtract ( getMillis () , days ) ;
return withMillis ( instant ) ;
}
public DateTime minusHours ( int hours ) {
if ( hours == 0 ) {
return this ;
}
long instant = getChronology () . hours () . subtract ( getMillis () , hours ) ;
return withMillis ( instant ) ;
}
public DateTime minusMinutes ( int minutes ) {
if ( minutes == 0 ) {
return this ;
}
long instant = getChronology () . minutes () . subtract ( getMillis () , minutes ) ;
return withMillis ( instant ) ;
}
public DateTime minusSeconds ( int seconds ) {
if ( seconds == 0 ) {
return this ;
}
long instant = getChronology () . seconds () . subtract ( getMillis () , seconds ) ;
return withMillis ( instant ) ;
}
public DateTime minusMillis ( int millis ) {
if ( millis == 0 ) {
return this ;
}
long instant = getChronology () . millis () . subtract ( getMillis () , millis ) ;
return withMillis ( instant ) ;
}
public Property property ( DateTimeFieldType type ) {
if ( type == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
DateTimeField field = type . getField ( getChronology () ) ;
if ( field . isSupported () == false ) {
throw new IllegalArgumentException ( lr_5 + type + lr_6 ) ;
}
return new Property ( this , field ) ;
}
@Deprecated
public DateMidnight toDateMidnight () {
return new DateMidnight ( getMillis () , getChronology () ) ;
}
@Deprecated
public YearMonthDay toYearMonthDay () {
return new YearMonthDay ( getMillis () , getChronology () ) ;
}
@Deprecated
public TimeOfDay toTimeOfDay () {
return new TimeOfDay ( getMillis () , getChronology () ) ;
}
public LocalDateTime toLocalDateTime () {
return new LocalDateTime ( getMillis () , getChronology () ) ;
}
public LocalDate toLocalDate () {
return new LocalDate ( getMillis () , getChronology () ) ;
}
public LocalTime toLocalTime () {
return new LocalTime ( getMillis () , getChronology () ) ;
}
public DateTime withEra ( int era ) {
return withMillis ( getChronology () . era () . set ( getMillis () , era ) ) ;
}
public DateTime withCenturyOfEra ( int centuryOfEra ) {
return withMillis ( getChronology () . centuryOfEra () . set ( getMillis () , centuryOfEra ) ) ;
}
public DateTime withYearOfEra ( int yearOfEra ) {
return withMillis ( getChronology () . yearOfEra () . set ( getMillis () , yearOfEra ) ) ;
}
public DateTime withYearOfCentury ( int yearOfCentury ) {
return withMillis ( getChronology () . yearOfCentury () . set ( getMillis () , yearOfCentury ) ) ;
}
public DateTime withYear ( int year ) {
return withMillis ( getChronology () . year () . set ( getMillis () , year ) ) ;
}
public DateTime withWeekyear ( int weekyear ) {
return withMillis ( getChronology () . weekyear () . set ( getMillis () , weekyear ) ) ;
}
public DateTime withMonthOfYear ( int monthOfYear ) {
return withMillis ( getChronology () . monthOfYear () . set ( getMillis () , monthOfYear ) ) ;
}
public DateTime withWeekOfWeekyear ( int weekOfWeekyear ) {
return withMillis ( getChronology () . weekOfWeekyear () . set ( getMillis () , weekOfWeekyear ) ) ;
}
public DateTime withDayOfYear ( int dayOfYear ) {
return withMillis ( getChronology () . dayOfYear () . set ( getMillis () , dayOfYear ) ) ;
}
public DateTime withDayOfMonth ( int dayOfMonth ) {
return withMillis ( getChronology () . dayOfMonth () . set ( getMillis () , dayOfMonth ) ) ;
}
public DateTime withDayOfWeek ( int dayOfWeek ) {
return withMillis ( getChronology () . dayOfWeek () . set ( getMillis () , dayOfWeek ) ) ;
}
public DateTime withHourOfDay ( int hour ) {
return withMillis ( getChronology () . hourOfDay () . set ( getMillis () , hour ) ) ;
}
public DateTime withMinuteOfHour ( int minute ) {
return withMillis ( getChronology () . minuteOfHour () . set ( getMillis () , minute ) ) ;
}
public DateTime withSecondOfMinute ( int second ) {
return withMillis ( getChronology () . secondOfMinute () . set ( getMillis () , second ) ) ;
}
public DateTime withMillisOfSecond ( int millis ) {
return withMillis ( getChronology () . millisOfSecond () . set ( getMillis () , millis ) ) ;
}
public DateTime withMillisOfDay ( int millis ) {
return withMillis ( getChronology () . millisOfDay () . set ( getMillis () , millis ) ) ;
}
public Property era () {
return new Property ( this , getChronology () . era () ) ;
}
public Property centuryOfEra () {
return new Property ( this , getChronology () . centuryOfEra () ) ;
}
public Property yearOfCentury () {
return new Property ( this , getChronology () . yearOfCentury () ) ;
}
public Property yearOfEra () {
return new Property ( this , getChronology () . yearOfEra () ) ;
}
public Property year () {
return new Property ( this , getChronology () . year () ) ;
}
public Property weekyear () {
return new Property ( this , getChronology () . weekyear () ) ;
}
public Property monthOfYear () {
return new Property ( this , getChronology () . monthOfYear () ) ;
}
public Property weekOfWeekyear () {
return new Property ( this , getChronology () . weekOfWeekyear () ) ;
}
public Property dayOfYear () {
return new Property ( this , getChronology () . dayOfYear () ) ;
}
public Property dayOfMonth () {
return new Property ( this , getChronology () . dayOfMonth () ) ;
}
public Property dayOfWeek () {
return new Property ( this , getChronology () . dayOfWeek () ) ;
}
public Property hourOfDay () {
return new Property ( this , getChronology () . hourOfDay () ) ;
}
public Property minuteOfDay () {
return new Property ( this , getChronology () . minuteOfDay () ) ;
}
public Property minuteOfHour () {
return new Property ( this , getChronology () . minuteOfHour () ) ;
}
public Property secondOfDay () {
return new Property ( this , getChronology () . secondOfDay () ) ;
}
public Property secondOfMinute () {
return new Property ( this , getChronology () . secondOfMinute () ) ;
}
public Property millisOfDay () {
return new Property ( this , getChronology () . millisOfDay () ) ;
}
public Property millisOfSecond () {
return new Property ( this , getChronology () . millisOfSecond () ) ;
}
private void writeObject ( ObjectOutputStream oos ) throws IOException {
oos . writeObject ( iInstant ) ;
oos . writeObject ( iField . getType () ) ;
}
private void readObject ( ObjectInputStream oos ) throws IOException , ClassNotFoundException {
iInstant = ( DateTime ) oos . readObject () ;
DateTimeFieldType type = ( DateTimeFieldType ) oos . readObject () ;
iField = type . getField ( iInstant . getChronology () ) ;
}
public DateTimeField getField () {
return iField ;
}
protected long getMillis () {
return iInstant . getMillis () ;
}
protected Chronology getChronology () {
return iInstant . getChronology () ;
}
public DateTime getDateTime () {
return iInstant ;
}
public DateTime addToCopy ( int value ) {
return iInstant . withMillis ( iField . add ( iInstant . getMillis () , value ) ) ;
}
public DateTime addToCopy ( long value ) {
return iInstant . withMillis ( iField . add ( iInstant . getMillis () , value ) ) ;
}
public DateTime addWrapFieldToCopy ( int value ) {
return iInstant . withMillis ( iField . addWrapField ( iInstant . getMillis () , value ) ) ;
}
public DateTime setCopy ( int value ) {
return iInstant . withMillis ( iField . set ( iInstant . getMillis () , value ) ) ;
}
public DateTime setCopy ( String text , Locale locale ) {
return iInstant . withMillis ( iField . set ( iInstant . getMillis () , text , locale ) ) ;
}
public DateTime setCopy ( String text ) {
return setCopy ( text , null ) ;
}
public DateTime withMaximumValue () {
try {
return setCopy ( getMaximumValue () ) ;
} catch ( RuntimeException ex ) {
if ( IllegalInstantException . isIllegalInstant ( ex ) ) {
long beforeGap = getChronology () . getZone () . previousTransition ( getMillis () + DateTimeConstants . MILLIS_PER_DAY ) ;
return new DateTime ( beforeGap , getChronology () ) ;
}
throw ex ;
}
}
public DateTime withMinimumValue () {
try {
return setCopy ( getMinimumValue () ) ;
} catch ( RuntimeException ex ) {
if ( IllegalInstantException . isIllegalInstant ( ex ) ) {
long afterGap = getChronology () . getZone () . nextTransition ( getMillis () - DateTimeConstants . MILLIS_PER_DAY ) ;
return new DateTime ( afterGap , getChronology () ) ;
}
throw ex ;
}
}
public DateTime roundFloorCopy () {
return iInstant . withMillis ( iField . roundFloor ( iInstant . getMillis () ) ) ;
}
public DateTime roundCeilingCopy () {
return iInstant . withMillis ( iField . roundCeiling ( iInstant . getMillis () ) ) ;
}
public DateTime roundHalfFloorCopy () {
return iInstant . withMillis ( iField . roundHalfFloor ( iInstant . getMillis () ) ) ;
}
public DateTime roundHalfCeilingCopy () {
return iInstant . withMillis ( iField . roundHalfCeiling ( iInstant . getMillis () ) ) ;
}
public DateTime roundHalfEvenCopy () {
return iInstant . withMillis ( iField . roundHalfEven ( iInstant . getMillis () ) ) ;
}
