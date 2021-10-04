public static MutableDateTime now () {
return new MutableDateTime () ;
}
public static MutableDateTime now ( DateTimeZone zone ) {
if ( zone == null ) {
throw new NullPointerException ( lr_1 ) ;
}
return new MutableDateTime ( zone ) ;
}
public static MutableDateTime now ( Chronology chronology ) {
if ( chronology == null ) {
throw new NullPointerException ( lr_2 ) ;
}
return new MutableDateTime ( chronology ) ;
}
@FromString
public static MutableDateTime parse ( String str ) {
return parse ( str , ISODateTimeFormat . dateTimeParser () . withOffsetParsed () ) ;
}
public static MutableDateTime parse ( String str , DateTimeFormatter formatter ) {
return formatter . parseDateTime ( str ) . toMutableDateTime () ;
}
public DateTimeField getRoundingField () {
return iRoundingField ;
}
public int getRoundingMode () {
return iRoundingMode ;
}
public void setRounding ( DateTimeField field ) {
setRounding ( field , MutableDateTime . ROUND_FLOOR ) ;
}
public void setRounding ( DateTimeField field , int mode ) {
if ( field != null && ( mode < ROUND_NONE || mode > ROUND_HALF_EVEN ) ) {
throw new IllegalArgumentException ( lr_3 + mode ) ;
}
iRoundingField = ( mode == ROUND_NONE ? null : field ) ;
iRoundingMode = ( field == null ? ROUND_NONE : mode ) ;
setMillis ( getMillis () ) ;
}
public void setMillis ( long instant ) {
switch ( iRoundingMode ) {
case ROUND_NONE :
break;
case ROUND_FLOOR :
instant = iRoundingField . roundFloor ( instant ) ;
break;
case ROUND_CEILING :
instant = iRoundingField . roundCeiling ( instant ) ;
break;
case ROUND_HALF_FLOOR :
instant = iRoundingField . roundHalfFloor ( instant ) ;
break;
case ROUND_HALF_CEILING :
instant = iRoundingField . roundHalfCeiling ( instant ) ;
break;
case ROUND_HALF_EVEN :
instant = iRoundingField . roundHalfEven ( instant ) ;
break;
}
super . setMillis ( instant ) ;
}
public void setMillis ( ReadableInstant instant ) {
long instantMillis = DateTimeUtils . getInstantMillis ( instant ) ;
setMillis ( instantMillis ) ;
}
public void add ( long duration ) {
setMillis ( FieldUtils . safeAdd ( getMillis () , duration ) ) ;
}
public void add ( ReadableDuration duration ) {
add ( duration , 1 ) ;
}
public void add ( ReadableDuration duration , int scalar ) {
if ( duration != null ) {
add ( FieldUtils . safeMultiply ( duration . getMillis () , scalar ) ) ;
}
}
public void add ( ReadablePeriod period ) {
add ( period , 1 ) ;
}
public void add ( ReadablePeriod period , int scalar ) {
if ( period != null ) {
setMillis ( getChronology () . add ( period , getMillis () , scalar ) ) ;
}
}
public void setChronology ( Chronology chronology ) {
super . setChronology ( chronology ) ;
}
public void setZone ( DateTimeZone newZone ) {
newZone = DateTimeUtils . getZone ( newZone ) ;
Chronology chrono = getChronology () ;
if ( chrono . getZone () != newZone ) {
setChronology ( chrono . withZone ( newZone ) ) ;
}
}
public void setZoneRetainFields ( DateTimeZone newZone ) {
newZone = DateTimeUtils . getZone ( newZone ) ;
DateTimeZone originalZone = DateTimeUtils . getZone ( getZone () ) ;
if ( newZone == originalZone ) {
return;
}
long millis = originalZone . getMillisKeepLocal ( newZone , getMillis () ) ;
setChronology ( getChronology () . withZone ( newZone ) ) ;
setMillis ( millis ) ;
}
public void set ( DateTimeFieldType type , int value ) {
if ( type == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
setMillis ( type . getField ( getChronology () ) . set ( getMillis () , value ) ) ;
}
public void add ( DurationFieldType type , int amount ) {
if ( type == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
if ( amount != 0 ) {
setMillis ( type . getField ( getChronology () ) . add ( getMillis () , amount ) ) ;
}
}
public void setYear ( final int year ) {
setMillis ( getChronology () . year () . set ( getMillis () , year ) ) ;
}
public void addYears ( final int years ) {
if ( years != 0 ) {
setMillis ( getChronology () . years () . add ( getMillis () , years ) ) ;
}
}
public void setWeekyear ( final int weekyear ) {
setMillis ( getChronology () . weekyear () . set ( getMillis () , weekyear ) ) ;
}
public void addWeekyears ( final int weekyears ) {
if ( weekyears != 0 ) {
setMillis ( getChronology () . weekyears () . add ( getMillis () , weekyears ) ) ;
}
}
public void setMonthOfYear ( final int monthOfYear ) {
setMillis ( getChronology () . monthOfYear () . set ( getMillis () , monthOfYear ) ) ;
}
public void addMonths ( final int months ) {
if ( months != 0 ) {
setMillis ( getChronology () . months () . add ( getMillis () , months ) ) ;
}
}
public void setWeekOfWeekyear ( final int weekOfWeekyear ) {
setMillis ( getChronology () . weekOfWeekyear () . set ( getMillis () , weekOfWeekyear ) ) ;
}
public void addWeeks ( final int weeks ) {
if ( weeks != 0 ) {
setMillis ( getChronology () . weeks () . add ( getMillis () , weeks ) ) ;
}
}
public void setDayOfYear ( final int dayOfYear ) {
setMillis ( getChronology () . dayOfYear () . set ( getMillis () , dayOfYear ) ) ;
}
public void setDayOfMonth ( final int dayOfMonth ) {
setMillis ( getChronology () . dayOfMonth () . set ( getMillis () , dayOfMonth ) ) ;
}
public void setDayOfWeek ( final int dayOfWeek ) {
setMillis ( getChronology () . dayOfWeek () . set ( getMillis () , dayOfWeek ) ) ;
}
public void addDays ( final int days ) {
if ( days != 0 ) {
setMillis ( getChronology () . days () . add ( getMillis () , days ) ) ;
}
}
public void setHourOfDay ( final int hourOfDay ) {
setMillis ( getChronology () . hourOfDay () . set ( getMillis () , hourOfDay ) ) ;
}
public void addHours ( final int hours ) {
if ( hours != 0 ) {
setMillis ( getChronology () . hours () . add ( getMillis () , hours ) ) ;
}
}
public void setMinuteOfDay ( final int minuteOfDay ) {
setMillis ( getChronology () . minuteOfDay () . set ( getMillis () , minuteOfDay ) ) ;
}
public void setMinuteOfHour ( final int minuteOfHour ) {
setMillis ( getChronology () . minuteOfHour () . set ( getMillis () , minuteOfHour ) ) ;
}
public void addMinutes ( final int minutes ) {
if ( minutes != 0 ) {
setMillis ( getChronology () . minutes () . add ( getMillis () , minutes ) ) ;
}
}
public void setSecondOfDay ( final int secondOfDay ) {
setMillis ( getChronology () . secondOfDay () . set ( getMillis () , secondOfDay ) ) ;
}
public void setSecondOfMinute ( final int secondOfMinute ) {
setMillis ( getChronology () . secondOfMinute () . set ( getMillis () , secondOfMinute ) ) ;
}
public void addSeconds ( final int seconds ) {
if ( seconds != 0 ) {
setMillis ( getChronology () . seconds () . add ( getMillis () , seconds ) ) ;
}
}
public void setMillisOfDay ( final int millisOfDay ) {
setMillis ( getChronology () . millisOfDay () . set ( getMillis () , millisOfDay ) ) ;
}
public void setMillisOfSecond ( final int millisOfSecond ) {
setMillis ( getChronology () . millisOfSecond () . set ( getMillis () , millisOfSecond ) ) ;
}
public void addMillis ( final int millis ) {
if ( millis != 0 ) {
setMillis ( getChronology () . millis () . add ( getMillis () , millis ) ) ;
}
}
public void setDate ( final long instant ) {
setMillis ( getChronology () . millisOfDay () . set ( instant , getMillisOfDay () ) ) ;
}
public void setDate ( final ReadableInstant instant ) {
long instantMillis = DateTimeUtils . getInstantMillis ( instant ) ;
if ( instant instanceof ReadableDateTime ) {
ReadableDateTime rdt = ( ReadableDateTime ) instant ;
Chronology instantChrono = DateTimeUtils . getChronology ( rdt . getChronology () ) ;
DateTimeZone zone = instantChrono . getZone () ;
if ( zone != null ) {
instantMillis = zone . getMillisKeepLocal ( getZone () , instantMillis ) ;
}
}
setDate ( instantMillis ) ;
}
public void setDate (
final int year ,
final int monthOfYear ,
final int dayOfMonth ) {
Chronology c = getChronology () ;
long instantMidnight = c . getDateTimeMillis ( year , monthOfYear , dayOfMonth , 0 ) ;
setDate ( instantMidnight ) ;
}
public void setTime ( final long millis ) {
int millisOfDay = ISOChronology . getInstanceUTC () . millisOfDay () . get ( millis ) ;
setMillis ( getChronology () . millisOfDay () . set ( getMillis () , millisOfDay ) ) ;
}
public void setTime ( final ReadableInstant instant ) {
long instantMillis = DateTimeUtils . getInstantMillis ( instant ) ;
Chronology instantChrono = DateTimeUtils . getInstantChronology ( instant ) ;
DateTimeZone zone = instantChrono . getZone () ;
if ( zone != null ) {
instantMillis = zone . getMillisKeepLocal ( DateTimeZone . UTC , instantMillis ) ;
}
setTime ( instantMillis ) ;
}
public void setTime (
final int hour ,
final int minuteOfHour ,
final int secondOfMinute ,
final int millisOfSecond ) {
long instant = getChronology () . getDateTimeMillis (
getMillis () , hour , minuteOfHour , secondOfMinute , millisOfSecond ) ;
setMillis ( instant ) ;
}
public void setDateTime (
final int year ,
final int monthOfYear ,
final int dayOfMonth ,
final int hourOfDay ,
final int minuteOfHour ,
final int secondOfMinute ,
final int millisOfSecond ) {
long instant = getChronology () . getDateTimeMillis (
year , monthOfYear , dayOfMonth , hourOfDay , minuteOfHour , secondOfMinute , millisOfSecond ) ;
setMillis ( instant ) ;
}
public Property property ( DateTimeFieldType type ) {
if ( type == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
DateTimeField field = type . getField ( getChronology () ) ;
if ( field . isSupported () == false ) {
throw new IllegalArgumentException ( lr_6 + type + lr_7 ) ;
}
return new Property ( this , field ) ;
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
public MutableDateTime copy () {
return ( MutableDateTime ) clone () ;
}
public Object clone () {
try {
return super . clone () ;
} catch ( CloneNotSupportedException ex ) {
throw new InternalError ( lr_8 ) ;
}
}
private void writeObject ( ObjectOutputStream oos ) throws IOException {
oos . writeObject ( iInstant ) ;
oos . writeObject ( iField . getType () ) ;
}
private void readObject ( ObjectInputStream oos ) throws IOException , ClassNotFoundException {
iInstant = ( MutableDateTime ) oos . readObject () ;
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
public MutableDateTime getMutableDateTime () {
return iInstant ;
}
public MutableDateTime add ( int value ) {
iInstant . setMillis ( getField () . add ( iInstant . getMillis () , value ) ) ;
return iInstant ;
}
public MutableDateTime add ( long value ) {
iInstant . setMillis ( getField () . add ( iInstant . getMillis () , value ) ) ;
return iInstant ;
}
public MutableDateTime addWrapField ( int value ) {
iInstant . setMillis ( getField () . addWrapField ( iInstant . getMillis () , value ) ) ;
return iInstant ;
}
public MutableDateTime set ( int value ) {
iInstant . setMillis ( getField () . set ( iInstant . getMillis () , value ) ) ;
return iInstant ;
}
public MutableDateTime set ( String text , Locale locale ) {
iInstant . setMillis ( getField () . set ( iInstant . getMillis () , text , locale ) ) ;
return iInstant ;
}
public MutableDateTime set ( String text ) {
set ( text , null ) ;
return iInstant ;
}
public MutableDateTime roundFloor () {
iInstant . setMillis ( getField () . roundFloor ( iInstant . getMillis () ) ) ;
return iInstant ;
}
public MutableDateTime roundCeiling () {
iInstant . setMillis ( getField () . roundCeiling ( iInstant . getMillis () ) ) ;
return iInstant ;
}
public MutableDateTime roundHalfFloor () {
iInstant . setMillis ( getField () . roundHalfFloor ( iInstant . getMillis () ) ) ;
return iInstant ;
}
public MutableDateTime roundHalfCeiling () {
iInstant . setMillis ( getField () . roundHalfCeiling ( iInstant . getMillis () ) ) ;
return iInstant ;
}
public MutableDateTime roundHalfEven () {
iInstant . setMillis ( getField () . roundHalfEven ( iInstant . getMillis () ) ) ;
return iInstant ;
}
