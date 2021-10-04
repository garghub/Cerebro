public static TimeOfDay fromCalendarFields ( Calendar calendar ) {
if ( calendar == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return new TimeOfDay (
calendar . get ( Calendar . HOUR_OF_DAY ) ,
calendar . get ( Calendar . MINUTE ) ,
calendar . get ( Calendar . SECOND ) ,
calendar . get ( Calendar . MILLISECOND )
) ;
}
public static TimeOfDay fromDateFields ( Date date ) {
if ( date == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return new TimeOfDay (
date . getHours () ,
date . getMinutes () ,
date . getSeconds () ,
( ( (int) ( date . getTime () % 1000 ) ) + 1000 ) % 1000
) ;
}
public static TimeOfDay fromMillisOfDay ( long millisOfDay ) {
return fromMillisOfDay ( millisOfDay , null ) ;
}
public static TimeOfDay fromMillisOfDay ( long millisOfDay , Chronology chrono ) {
chrono = DateTimeUtils . getChronology ( chrono ) ;
chrono = chrono . withUTC () ;
return new TimeOfDay ( millisOfDay , chrono ) ;
}
public int size () {
return 4 ;
}
protected DateTimeField getField ( int index , Chronology chrono ) {
switch ( index ) {
case HOUR_OF_DAY :
return chrono . hourOfDay () ;
case MINUTE_OF_HOUR :
return chrono . minuteOfHour () ;
case SECOND_OF_MINUTE :
return chrono . secondOfMinute () ;
case MILLIS_OF_SECOND :
return chrono . millisOfSecond () ;
default:
throw new IndexOutOfBoundsException ( lr_3 + index ) ;
}
}
public DateTimeFieldType getFieldType ( int index ) {
return FIELD_TYPES [ index ] ;
}
public DateTimeFieldType [] getFieldTypes () {
return ( DateTimeFieldType [] ) FIELD_TYPES . clone () ;
}
public TimeOfDay withChronologyRetainFields ( Chronology newChronology ) {
newChronology = DateTimeUtils . getChronology ( newChronology ) ;
newChronology = newChronology . withUTC () ;
if ( newChronology == getChronology () ) {
return this ;
} else {
TimeOfDay newTimeOfDay = new TimeOfDay ( this , newChronology ) ;
newChronology . validate ( newTimeOfDay , getValues () ) ;
return newTimeOfDay ;
}
}
public TimeOfDay withField ( DateTimeFieldType fieldType , int value ) {
int index = indexOfSupported ( fieldType ) ;
if ( value == getValue ( index ) ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . set ( this , index , newValues , value ) ;
return new TimeOfDay ( this , newValues ) ;
}
public TimeOfDay withFieldAdded ( DurationFieldType fieldType , int amount ) {
int index = indexOfSupported ( fieldType ) ;
if ( amount == 0 ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . addWrapPartial ( this , index , newValues , amount ) ;
return new TimeOfDay ( this , newValues ) ;
}
public TimeOfDay withPeriodAdded ( ReadablePeriod period , int scalar ) {
if ( period == null || scalar == 0 ) {
return this ;
}
int [] newValues = getValues () ;
for ( int i = 0 ; i < period . size () ; i ++ ) {
DurationFieldType fieldType = period . getFieldType ( i ) ;
int index = indexOf ( fieldType ) ;
if ( index >= 0 ) {
newValues = getField ( index ) . addWrapPartial ( this , index , newValues ,
FieldUtils . safeMultiply ( period . getValue ( i ) , scalar ) ) ;
}
}
return new TimeOfDay ( this , newValues ) ;
}
public TimeOfDay plus ( ReadablePeriod period ) {
return withPeriodAdded ( period , 1 ) ;
}
public TimeOfDay plusHours ( int hours ) {
return withFieldAdded ( DurationFieldType . hours () , hours ) ;
}
public TimeOfDay plusMinutes ( int minutes ) {
return withFieldAdded ( DurationFieldType . minutes () , minutes ) ;
}
public TimeOfDay plusSeconds ( int seconds ) {
return withFieldAdded ( DurationFieldType . seconds () , seconds ) ;
}
public TimeOfDay plusMillis ( int millis ) {
return withFieldAdded ( DurationFieldType . millis () , millis ) ;
}
public TimeOfDay minus ( ReadablePeriod period ) {
return withPeriodAdded ( period , - 1 ) ;
}
public TimeOfDay minusHours ( int hours ) {
return withFieldAdded ( DurationFieldType . hours () , FieldUtils . safeNegate ( hours ) ) ;
}
public TimeOfDay minusMinutes ( int minutes ) {
return withFieldAdded ( DurationFieldType . minutes () , FieldUtils . safeNegate ( minutes ) ) ;
}
public TimeOfDay minusSeconds ( int seconds ) {
return withFieldAdded ( DurationFieldType . seconds () , FieldUtils . safeNegate ( seconds ) ) ;
}
public TimeOfDay minusMillis ( int millis ) {
return withFieldAdded ( DurationFieldType . millis () , FieldUtils . safeNegate ( millis ) ) ;
}
public Property property ( DateTimeFieldType type ) {
return new Property ( this , indexOfSupported ( type ) ) ;
}
public LocalTime toLocalTime () {
return new LocalTime ( getHourOfDay () , getMinuteOfHour () ,
getSecondOfMinute () , getMillisOfSecond () , getChronology () ) ;
}
public DateTime toDateTimeToday () {
return toDateTimeToday ( null ) ;
}
public DateTime toDateTimeToday ( DateTimeZone zone ) {
Chronology chrono = getChronology () . withZone ( zone ) ;
long instantMillis = DateTimeUtils . currentTimeMillis () ;
long resolved = chrono . set ( this , instantMillis ) ;
return new DateTime ( resolved , chrono ) ;
}
public int getHourOfDay () {
return getValue ( HOUR_OF_DAY ) ;
}
public int getMinuteOfHour () {
return getValue ( MINUTE_OF_HOUR ) ;
}
public int getSecondOfMinute () {
return getValue ( SECOND_OF_MINUTE ) ;
}
public int getMillisOfSecond () {
return getValue ( MILLIS_OF_SECOND ) ;
}
public TimeOfDay withHourOfDay ( int hour ) {
int [] newValues = getValues () ;
newValues = getChronology () . hourOfDay () . set ( this , HOUR_OF_DAY , newValues , hour ) ;
return new TimeOfDay ( this , newValues ) ;
}
public TimeOfDay withMinuteOfHour ( int minute ) {
int [] newValues = getValues () ;
newValues = getChronology () . minuteOfHour () . set ( this , MINUTE_OF_HOUR , newValues , minute ) ;
return new TimeOfDay ( this , newValues ) ;
}
public TimeOfDay withSecondOfMinute ( int second ) {
int [] newValues = getValues () ;
newValues = getChronology () . secondOfMinute () . set ( this , SECOND_OF_MINUTE , newValues , second ) ;
return new TimeOfDay ( this , newValues ) ;
}
public TimeOfDay withMillisOfSecond ( int millis ) {
int [] newValues = getValues () ;
newValues = getChronology () . millisOfSecond () . set ( this , MILLIS_OF_SECOND , newValues , millis ) ;
return new TimeOfDay ( this , newValues ) ;
}
public Property hourOfDay () {
return new Property ( this , HOUR_OF_DAY ) ;
}
public Property minuteOfHour () {
return new Property ( this , MINUTE_OF_HOUR ) ;
}
public Property secondOfMinute () {
return new Property ( this , SECOND_OF_MINUTE ) ;
}
public Property millisOfSecond () {
return new Property ( this , MILLIS_OF_SECOND ) ;
}
public String toString () {
return ISODateTimeFormat . tTime () . print ( this ) ;
}
public DateTimeField getField () {
return iTimeOfDay . getField ( iFieldIndex ) ;
}
protected ReadablePartial getReadablePartial () {
return iTimeOfDay ;
}
public TimeOfDay getTimeOfDay () {
return iTimeOfDay ;
}
public int get () {
return iTimeOfDay . getValue ( iFieldIndex ) ;
}
public TimeOfDay addToCopy ( int valueToAdd ) {
int [] newValues = iTimeOfDay . getValues () ;
newValues = getField () . addWrapPartial ( iTimeOfDay , iFieldIndex , newValues , valueToAdd ) ;
return new TimeOfDay ( iTimeOfDay , newValues ) ;
}
public TimeOfDay addNoWrapToCopy ( int valueToAdd ) {
int [] newValues = iTimeOfDay . getValues () ;
newValues = getField () . add ( iTimeOfDay , iFieldIndex , newValues , valueToAdd ) ;
return new TimeOfDay ( iTimeOfDay , newValues ) ;
}
public TimeOfDay addWrapFieldToCopy ( int valueToAdd ) {
int [] newValues = iTimeOfDay . getValues () ;
newValues = getField () . addWrapField ( iTimeOfDay , iFieldIndex , newValues , valueToAdd ) ;
return new TimeOfDay ( iTimeOfDay , newValues ) ;
}
public TimeOfDay setCopy ( int value ) {
int [] newValues = iTimeOfDay . getValues () ;
newValues = getField () . set ( iTimeOfDay , iFieldIndex , newValues , value ) ;
return new TimeOfDay ( iTimeOfDay , newValues ) ;
}
public TimeOfDay setCopy ( String text , Locale locale ) {
int [] newValues = iTimeOfDay . getValues () ;
newValues = getField () . set ( iTimeOfDay , iFieldIndex , newValues , text , locale ) ;
return new TimeOfDay ( iTimeOfDay , newValues ) ;
}
public TimeOfDay setCopy ( String text ) {
return setCopy ( text , null ) ;
}
public TimeOfDay withMaximumValue () {
return setCopy ( getMaximumValue () ) ;
}
public TimeOfDay withMinimumValue () {
return setCopy ( getMinimumValue () ) ;
}
