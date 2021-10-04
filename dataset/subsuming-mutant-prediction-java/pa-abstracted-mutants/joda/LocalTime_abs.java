public static LocalTime now () {
return new LocalTime () ;
}
public static LocalTime now ( DateTimeZone zone ) {
if ( zone == null ) {
throw new NullPointerException ( lr_1 ) ;
}
return new LocalTime ( zone ) ;
}
public static LocalTime now ( Chronology chronology ) {
if ( chronology == null ) {
throw new NullPointerException ( lr_2 ) ;
}
return new LocalTime ( chronology ) ;
}
@FromString
public static LocalTime parse ( String str ) {
return parse ( str , ISODateTimeFormat . localTimeParser () ) ;
}
public static LocalTime parse ( String str , DateTimeFormatter formatter ) {
return formatter . parseLocalTime ( str ) ;
}
public static LocalTime fromMillisOfDay ( long millisOfDay ) {
return fromMillisOfDay ( millisOfDay , null ) ;
}
public static LocalTime fromMillisOfDay ( long millisOfDay , Chronology chrono ) {
chrono = DateTimeUtils . getChronology ( chrono ) . withUTC () ;
return new LocalTime ( millisOfDay , chrono ) ;
}
public static LocalTime fromCalendarFields ( Calendar calendar ) {
if ( calendar == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new LocalTime (
calendar . get ( Calendar . HOUR_OF_DAY ) ,
calendar . get ( Calendar . MINUTE ) ,
calendar . get ( Calendar . SECOND ) ,
calendar . get ( Calendar . MILLISECOND )
) ;
}
@SuppressWarnings ( lr_4 )
public static LocalTime fromDateFields ( Date date ) {
if ( date == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
return new LocalTime (
date . getHours () ,
date . getMinutes () ,
date . getSeconds () ,
( ( (int) ( date . getTime () % 1000 ) ) + 1000 ) % 1000
) ;
}
private Object readResolve () {
if ( iChronology == null ) {
return new LocalTime ( iLocalMillis , ISOChronology . getInstanceUTC () ) ;
}
if ( DateTimeZone . UTC . equals ( iChronology . getZone () ) == false ) {
return new LocalTime ( iLocalMillis , iChronology . withUTC () ) ;
}
return this ;
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
throw new IndexOutOfBoundsException ( lr_6 + index ) ;
}
}
public int getValue ( int index ) {
switch ( index ) {
case HOUR_OF_DAY :
return getChronology () . hourOfDay () . get ( getLocalMillis () ) ;
case MINUTE_OF_HOUR :
return getChronology () . minuteOfHour () . get ( getLocalMillis () ) ;
case SECOND_OF_MINUTE :
return getChronology () . secondOfMinute () . get ( getLocalMillis () ) ;
case MILLIS_OF_SECOND :
return getChronology () . millisOfSecond () . get ( getLocalMillis () ) ;
default:
throw new IndexOutOfBoundsException ( lr_6 + index ) ;
}
}
public int get ( DateTimeFieldType fieldType ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
if ( isSupported ( fieldType ) == false ) {
throw new IllegalArgumentException ( lr_8 + fieldType + lr_9 ) ;
}
return fieldType . getField ( getChronology () ) . get ( getLocalMillis () ) ;
}
public boolean isSupported ( DateTimeFieldType type ) {
if ( type == null ) {
return false ;
}
if ( isSupported ( type . getDurationType () ) == false ) {
return false ;
}
DurationFieldType range = type . getRangeDurationType () ;
return ( isSupported ( range ) || range == DurationFieldType . days () ) ;
}
public boolean isSupported ( DurationFieldType type ) {
if ( type == null ) {
return false ;
}
DurationField field = type . getField ( getChronology () ) ;
if ( TIME_DURATION_TYPES . contains ( type ) ||
field . getUnitMillis () < getChronology () . days () . getUnitMillis () ) {
return field . isSupported () ;
}
return false ;
}
protected long getLocalMillis () {
return iLocalMillis ;
}
public Chronology getChronology () {
return iChronology ;
}
public boolean equals ( Object partial ) {
if ( this == partial ) {
return true ;
}
if ( partial instanceof LocalTime ) {
LocalTime other = ( LocalTime ) partial ;
if ( iChronology . equals ( other . iChronology ) ) {
return iLocalMillis == other . iLocalMillis ;
}
}
return super . equals ( partial ) ;
}
public int compareTo ( ReadablePartial partial ) {
if ( this == partial ) {
return 0 ;
}
if ( partial instanceof LocalTime ) {
LocalTime other = ( LocalTime ) partial ;
if ( iChronology . equals ( other . iChronology ) ) {
return ( iLocalMillis < other . iLocalMillis ? - 1 :
( iLocalMillis == other . iLocalMillis ? 0 : 1 ) ) ;
}
}
return super . compareTo ( partial ) ;
}
LocalTime withLocalMillis ( long newMillis ) {
return ( newMillis == getLocalMillis () ? this : new LocalTime ( newMillis , getChronology () ) ) ;
}
public LocalTime withFields ( ReadablePartial partial ) {
if ( partial == null ) {
return this ;
}
return withLocalMillis ( getChronology () . set ( partial , getLocalMillis () ) ) ;
}
public LocalTime withField ( DateTimeFieldType fieldType , int value ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( isSupported ( fieldType ) == false ) {
throw new IllegalArgumentException ( lr_8 + fieldType + lr_9 ) ;
}
long instant = fieldType . getField ( getChronology () ) . set ( getLocalMillis () , value ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime withFieldAdded ( DurationFieldType fieldType , int amount ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( isSupported ( fieldType ) == false ) {
throw new IllegalArgumentException ( lr_8 + fieldType + lr_9 ) ;
}
if ( amount == 0 ) {
return this ;
}
long instant = fieldType . getField ( getChronology () ) . add ( getLocalMillis () , amount ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime withPeriodAdded ( ReadablePeriod period , int scalar ) {
if ( period == null || scalar == 0 ) {
return this ;
}
long instant = getChronology () . add ( period , getLocalMillis () , scalar ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime plus ( ReadablePeriod period ) {
return withPeriodAdded ( period , 1 ) ;
}
public LocalTime plusHours ( int hours ) {
if ( hours == 0 ) {
return this ;
}
long instant = getChronology () . hours () . add ( getLocalMillis () , hours ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime plusMinutes ( int minutes ) {
if ( minutes == 0 ) {
return this ;
}
long instant = getChronology () . minutes () . add ( getLocalMillis () , minutes ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime plusSeconds ( int seconds ) {
if ( seconds == 0 ) {
return this ;
}
long instant = getChronology () . seconds () . add ( getLocalMillis () , seconds ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime plusMillis ( int millis ) {
if ( millis == 0 ) {
return this ;
}
long instant = getChronology () . millis () . add ( getLocalMillis () , millis ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime minus ( ReadablePeriod period ) {
return withPeriodAdded ( period , - 1 ) ;
}
public LocalTime minusHours ( int hours ) {
if ( hours == 0 ) {
return this ;
}
long instant = getChronology () . hours () . subtract ( getLocalMillis () , hours ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime minusMinutes ( int minutes ) {
if ( minutes == 0 ) {
return this ;
}
long instant = getChronology () . minutes () . subtract ( getLocalMillis () , minutes ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime minusSeconds ( int seconds ) {
if ( seconds == 0 ) {
return this ;
}
long instant = getChronology () . seconds () . subtract ( getLocalMillis () , seconds ) ;
return withLocalMillis ( instant ) ;
}
public LocalTime minusMillis ( int millis ) {
if ( millis == 0 ) {
return this ;
}
long instant = getChronology () . millis () . subtract ( getLocalMillis () , millis ) ;
return withLocalMillis ( instant ) ;
}
public Property property ( DateTimeFieldType fieldType ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
if ( isSupported ( fieldType ) == false ) {
throw new IllegalArgumentException ( lr_8 + fieldType + lr_9 ) ;
}
return new Property ( this , fieldType . getField ( getChronology () ) ) ;
}
public int getHourOfDay () {
return getChronology () . hourOfDay () . get ( getLocalMillis () ) ;
}
public int getMinuteOfHour () {
return getChronology () . minuteOfHour () . get ( getLocalMillis () ) ;
}
public int getSecondOfMinute () {
return getChronology () . secondOfMinute () . get ( getLocalMillis () ) ;
}
public int getMillisOfSecond () {
return getChronology () . millisOfSecond () . get ( getLocalMillis () ) ;
}
public int getMillisOfDay () {
return getChronology () . millisOfDay () . get ( getLocalMillis () ) ;
}
public LocalTime withHourOfDay ( int hour ) {
return withLocalMillis ( getChronology () . hourOfDay () . set ( getLocalMillis () , hour ) ) ;
}
public LocalTime withMinuteOfHour ( int minute ) {
return withLocalMillis ( getChronology () . minuteOfHour () . set ( getLocalMillis () , minute ) ) ;
}
public LocalTime withSecondOfMinute ( int second ) {
return withLocalMillis ( getChronology () . secondOfMinute () . set ( getLocalMillis () , second ) ) ;
}
public LocalTime withMillisOfSecond ( int millis ) {
return withLocalMillis ( getChronology () . millisOfSecond () . set ( getLocalMillis () , millis ) ) ;
}
public LocalTime withMillisOfDay ( int millis ) {
return withLocalMillis ( getChronology () . millisOfDay () . set ( getLocalMillis () , millis ) ) ;
}
public Property hourOfDay () {
return new Property ( this , getChronology () . hourOfDay () ) ;
}
public Property minuteOfHour () {
return new Property ( this , getChronology () . minuteOfHour () ) ;
}
public Property secondOfMinute () {
return new Property ( this , getChronology () . secondOfMinute () ) ;
}
public Property millisOfSecond () {
return new Property ( this , getChronology () . millisOfSecond () ) ;
}
public Property millisOfDay () {
return new Property ( this , getChronology () . millisOfDay () ) ;
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
@ToString
public String toString () {
return ISODateTimeFormat . time () . print ( this ) ;
}
public String toString ( String pattern ) {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . print ( this ) ;
}
public String toString ( String pattern , Locale locale ) throws IllegalArgumentException {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . withLocale ( locale ) . print ( this ) ;
}
private void writeObject ( ObjectOutputStream oos ) throws IOException {
oos . writeObject ( iInstant ) ;
oos . writeObject ( iField . getType () ) ;
}
private void readObject ( ObjectInputStream oos ) throws IOException , ClassNotFoundException {
iInstant = ( LocalTime ) oos . readObject () ;
DateTimeFieldType type = ( DateTimeFieldType ) oos . readObject () ;
iField = type . getField ( iInstant . getChronology () ) ;
}
public DateTimeField getField () {
return iField ;
}
protected long getMillis () {
return iInstant . getLocalMillis () ;
}
protected Chronology getChronology () {
return iInstant . getChronology () ;
}
public LocalTime getLocalTime () {
return iInstant ;
}
public LocalTime addCopy ( int value ) {
return iInstant . withLocalMillis ( iField . add ( iInstant . getLocalMillis () , value ) ) ;
}
public LocalTime addCopy ( long value ) {
return iInstant . withLocalMillis ( iField . add ( iInstant . getLocalMillis () , value ) ) ;
}
public LocalTime addNoWrapToCopy ( int value ) {
long millis = iField . add ( iInstant . getLocalMillis () , value ) ;
long rounded = iInstant . getChronology () . millisOfDay () . get ( millis ) ;
if ( rounded != millis ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
return iInstant . withLocalMillis ( millis ) ;
}
public LocalTime addWrapFieldToCopy ( int value ) {
return iInstant . withLocalMillis ( iField . addWrapField ( iInstant . getLocalMillis () , value ) ) ;
}
public LocalTime setCopy ( int value ) {
return iInstant . withLocalMillis ( iField . set ( iInstant . getLocalMillis () , value ) ) ;
}
public LocalTime setCopy ( String text , Locale locale ) {
return iInstant . withLocalMillis ( iField . set ( iInstant . getLocalMillis () , text , locale ) ) ;
}
public LocalTime setCopy ( String text ) {
return setCopy ( text , null ) ;
}
public LocalTime withMaximumValue () {
return setCopy ( getMaximumValue () ) ;
}
public LocalTime withMinimumValue () {
return setCopy ( getMinimumValue () ) ;
}
public LocalTime roundFloorCopy () {
return iInstant . withLocalMillis ( iField . roundFloor ( iInstant . getLocalMillis () ) ) ;
}
public LocalTime roundCeilingCopy () {
return iInstant . withLocalMillis ( iField . roundCeiling ( iInstant . getLocalMillis () ) ) ;
}
public LocalTime roundHalfFloorCopy () {
return iInstant . withLocalMillis ( iField . roundHalfFloor ( iInstant . getLocalMillis () ) ) ;
}
public LocalTime roundHalfCeilingCopy () {
return iInstant . withLocalMillis ( iField . roundHalfCeiling ( iInstant . getLocalMillis () ) ) ;
}
public LocalTime roundHalfEvenCopy () {
return iInstant . withLocalMillis ( iField . roundHalfEven ( iInstant . getLocalMillis () ) ) ;
}
