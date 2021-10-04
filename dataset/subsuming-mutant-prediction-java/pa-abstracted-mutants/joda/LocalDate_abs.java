public static LocalDate now () {
return new LocalDate () ;
}
public static LocalDate now ( DateTimeZone zone ) {
if ( zone == null ) {
throw new NullPointerException ( lr_1 ) ;
}
return new LocalDate ( zone ) ;
}
public static LocalDate now ( Chronology chronology ) {
if ( chronology == null ) {
throw new NullPointerException ( lr_2 ) ;
}
return new LocalDate ( chronology ) ;
}
@FromString
public static LocalDate parse ( String str ) {
return parse ( str , ISODateTimeFormat . localDateParser () ) ;
}
public static LocalDate parse ( String str , DateTimeFormatter formatter ) {
return formatter . parseLocalDate ( str ) ;
}
public static LocalDate fromCalendarFields ( Calendar calendar ) {
if ( calendar == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
int era = calendar . get ( Calendar . ERA ) ;
int yearOfEra = calendar . get ( Calendar . YEAR ) ;
return new LocalDate (
( era == GregorianCalendar . AD ? yearOfEra : 1 - yearOfEra ) ,
calendar . get ( Calendar . MONTH ) + 1 ,
calendar . get ( Calendar . DAY_OF_MONTH )
) ;
}
@SuppressWarnings ( lr_4 )
public static LocalDate fromDateFields ( Date date ) {
if ( date == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
if ( date . getTime () < 0 ) {
GregorianCalendar cal = new GregorianCalendar () ;
cal . setTime ( date ) ;
return fromCalendarFields ( cal ) ;
}
return new LocalDate (
date . getYear () + 1900 ,
date . getMonth () + 1 ,
date . getDate ()
) ;
}
private Object readResolve () {
if ( iChronology == null ) {
return new LocalDate ( iLocalMillis , ISOChronology . getInstanceUTC () ) ;
}
if ( DateTimeZone . UTC . equals ( iChronology . getZone () ) == false ) {
return new LocalDate ( iLocalMillis , iChronology . withUTC () ) ;
}
return this ;
}
public int size () {
return 3 ;
}
protected DateTimeField getField ( int index , Chronology chrono ) {
switch ( index ) {
case YEAR :
return chrono . year () ;
case MONTH_OF_YEAR :
return chrono . monthOfYear () ;
case DAY_OF_MONTH :
return chrono . dayOfMonth () ;
default:
throw new IndexOutOfBoundsException ( lr_6 + index ) ;
}
}
public int getValue ( int index ) {
switch ( index ) {
case YEAR :
return getChronology () . year () . get ( getLocalMillis () ) ;
case MONTH_OF_YEAR :
return getChronology () . monthOfYear () . get ( getLocalMillis () ) ;
case DAY_OF_MONTH :
return getChronology () . dayOfMonth () . get ( getLocalMillis () ) ;
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
DurationFieldType durType = type . getDurationType () ;
if ( DATE_DURATION_TYPES . contains ( durType ) ||
durType . getField ( getChronology () ) . getUnitMillis () >=
getChronology () . days () . getUnitMillis () ) {
return type . getField ( getChronology () ) . isSupported () ;
}
return false ;
}
public boolean isSupported ( DurationFieldType type ) {
if ( type == null ) {
return false ;
}
DurationField field = type . getField ( getChronology () ) ;
if ( DATE_DURATION_TYPES . contains ( type ) ||
field . getUnitMillis () >= getChronology () . days () . getUnitMillis () ) {
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
if ( partial instanceof LocalDate ) {
LocalDate other = ( LocalDate ) partial ;
if ( iChronology . equals ( other . iChronology ) ) {
return iLocalMillis == other . iLocalMillis ;
}
}
return super . equals ( partial ) ;
}
public int hashCode () {
int hash = iHash ;
if ( hash == 0 ) {
hash = iHash = super . hashCode () ;
}
return hash ;
}
public int compareTo ( ReadablePartial partial ) {
if ( this == partial ) {
return 0 ;
}
if ( partial instanceof LocalDate ) {
LocalDate other = ( LocalDate ) partial ;
if ( iChronology . equals ( other . iChronology ) ) {
return ( iLocalMillis < other . iLocalMillis ? - 1 :
( iLocalMillis == other . iLocalMillis ? 0 : 1 ) ) ;
}
}
return super . compareTo ( partial ) ;
}
public DateTime toDateTimeAtStartOfDay () {
return toDateTimeAtStartOfDay ( null ) ;
}
public DateTime toDateTimeAtStartOfDay ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
Chronology chrono = getChronology () . withZone ( zone ) ;
long localMillis = getLocalMillis () + 6L * DateTimeConstants . MILLIS_PER_HOUR ;
long instant = zone . convertLocalToUTC ( localMillis , false ) ;
instant = chrono . dayOfMonth () . roundFloor ( instant ) ;
return new DateTime ( instant , chrono ) . withEarlierOffsetAtOverlap () ;
}
@Deprecated
public DateTime toDateTimeAtMidnight () {
return toDateTimeAtMidnight ( null ) ;
}
@Deprecated
public DateTime toDateTimeAtMidnight ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
Chronology chrono = getChronology () . withZone ( zone ) ;
return new DateTime ( getYear () , getMonthOfYear () , getDayOfMonth () , 0 , 0 , 0 , 0 , chrono ) ;
}
public DateTime toDateTimeAtCurrentTime () {
return toDateTimeAtCurrentTime ( null ) ;
}
public DateTime toDateTimeAtCurrentTime ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
Chronology chrono = getChronology () . withZone ( zone ) ;
long instantMillis = DateTimeUtils . currentTimeMillis () ;
long resolved = chrono . set ( this , instantMillis ) ;
return new DateTime ( resolved , chrono ) ;
}
@Deprecated
public DateMidnight toDateMidnight () {
return toDateMidnight ( null ) ;
}
@Deprecated
public DateMidnight toDateMidnight ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
Chronology chrono = getChronology () . withZone ( zone ) ;
return new DateMidnight ( getYear () , getMonthOfYear () , getDayOfMonth () , chrono ) ;
}
public LocalDateTime toLocalDateTime ( LocalTime time ) {
if ( time == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( getChronology () != time . getChronology () ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
long localMillis = getLocalMillis () + time . getLocalMillis () ;
return new LocalDateTime ( localMillis , getChronology () ) ;
}
public DateTime toDateTime ( LocalTime time ) {
return toDateTime ( time , null ) ;
}
public DateTime toDateTime ( LocalTime time , DateTimeZone zone ) {
if ( time == null ) {
return toDateTimeAtCurrentTime ( zone ) ;
}
if ( getChronology () != time . getChronology () ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
Chronology chrono = getChronology () . withZone ( zone ) ;
return new DateTime (
getYear () , getMonthOfYear () , getDayOfMonth () ,
time . getHourOfDay () , time . getMinuteOfHour () ,
time . getSecondOfMinute () , time . getMillisOfSecond () , chrono ) ;
}
public Interval toInterval () {
return toInterval ( null ) ;
}
public Interval toInterval ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
DateTime start = toDateTimeAtStartOfDay ( zone ) ;
DateTime end = plusDays ( 1 ) . toDateTimeAtStartOfDay ( zone ) ;
return new Interval ( start , end ) ;
}
@SuppressWarnings ( lr_4 )
public Date toDate () {
int dom = getDayOfMonth () ;
Date date = new Date ( getYear () - 1900 , getMonthOfYear () - 1 , dom ) ;
LocalDate check = LocalDate . fromDateFields ( date ) ;
if ( check . isBefore ( this ) ) {
while ( check . equals ( this ) == false ) {
date . setTime ( date . getTime () + 3600000 ) ;
check = LocalDate . fromDateFields ( date ) ;
}
while ( date . getDate () == dom ) {
date . setTime ( date . getTime () - 1000 ) ;
}
date . setTime ( date . getTime () + 1000 ) ;
} else if ( check . equals ( this ) ) {
Date earlier = new Date ( date . getTime () - TimeZone . getDefault () . getDSTSavings () ) ;
if ( earlier . getDate () == dom ) {
date = earlier ;
}
}
return date ;
}
LocalDate withLocalMillis ( long newMillis ) {
newMillis = iChronology . dayOfMonth () . roundFloor ( newMillis ) ;
return ( newMillis == getLocalMillis () ? this : new LocalDate ( newMillis , getChronology () ) ) ;
}
public LocalDate withFields ( ReadablePartial partial ) {
if ( partial == null ) {
return this ;
}
return withLocalMillis ( getChronology () . set ( partial , getLocalMillis () ) ) ;
}
public LocalDate withField ( DateTimeFieldType fieldType , int value ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
if ( isSupported ( fieldType ) == false ) {
throw new IllegalArgumentException ( lr_8 + fieldType + lr_9 ) ;
}
long instant = fieldType . getField ( getChronology () ) . set ( getLocalMillis () , value ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate withFieldAdded ( DurationFieldType fieldType , int amount ) {
if ( fieldType == null ) {
throw new IllegalArgumentException ( lr_12 ) ;
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
public LocalDate withPeriodAdded ( ReadablePeriod period , int scalar ) {
if ( period == null || scalar == 0 ) {
return this ;
}
long instant = getLocalMillis () ;
Chronology chrono = getChronology () ;
for ( int i = 0 ; i < period . size () ; i ++ ) {
long value = FieldUtils . safeMultiply ( period . getValue ( i ) , scalar ) ;
DurationFieldType type = period . getFieldType ( i ) ;
if ( isSupported ( type ) ) {
instant = type . getField ( chrono ) . add ( instant , value ) ;
}
}
return withLocalMillis ( instant ) ;
}
public LocalDate plus ( ReadablePeriod period ) {
return withPeriodAdded ( period , 1 ) ;
}
public LocalDate plusYears ( int years ) {
if ( years == 0 ) {
return this ;
}
long instant = getChronology () . years () . add ( getLocalMillis () , years ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate plusMonths ( int months ) {
if ( months == 0 ) {
return this ;
}
long instant = getChronology () . months () . add ( getLocalMillis () , months ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate plusWeeks ( int weeks ) {
if ( weeks == 0 ) {
return this ;
}
long instant = getChronology () . weeks () . add ( getLocalMillis () , weeks ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate plusDays ( int days ) {
if ( days == 0 ) {
return this ;
}
long instant = getChronology () . days () . add ( getLocalMillis () , days ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate minus ( ReadablePeriod period ) {
return withPeriodAdded ( period , - 1 ) ;
}
public LocalDate minusYears ( int years ) {
if ( years == 0 ) {
return this ;
}
long instant = getChronology () . years () . subtract ( getLocalMillis () , years ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate minusMonths ( int months ) {
if ( months == 0 ) {
return this ;
}
long instant = getChronology () . months () . subtract ( getLocalMillis () , months ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate minusWeeks ( int weeks ) {
if ( weeks == 0 ) {
return this ;
}
long instant = getChronology () . weeks () . subtract ( getLocalMillis () , weeks ) ;
return withLocalMillis ( instant ) ;
}
public LocalDate minusDays ( int days ) {
if ( days == 0 ) {
return this ;
}
long instant = getChronology () . days () . subtract ( getLocalMillis () , days ) ;
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
public int getEra () {
return getChronology () . era () . get ( getLocalMillis () ) ;
}
public int getCenturyOfEra () {
return getChronology () . centuryOfEra () . get ( getLocalMillis () ) ;
}
public int getYearOfEra () {
return getChronology () . yearOfEra () . get ( getLocalMillis () ) ;
}
public int getYearOfCentury () {
return getChronology () . yearOfCentury () . get ( getLocalMillis () ) ;
}
public int getYear () {
return getChronology () . year () . get ( getLocalMillis () ) ;
}
public int getWeekyear () {
return getChronology () . weekyear () . get ( getLocalMillis () ) ;
}
public int getMonthOfYear () {
return getChronology () . monthOfYear () . get ( getLocalMillis () ) ;
}
public int getWeekOfWeekyear () {
return getChronology () . weekOfWeekyear () . get ( getLocalMillis () ) ;
}
public int getDayOfYear () {
return getChronology () . dayOfYear () . get ( getLocalMillis () ) ;
}
public int getDayOfMonth () {
return getChronology () . dayOfMonth () . get ( getLocalMillis () ) ;
}
public int getDayOfWeek () {
return getChronology () . dayOfWeek () . get ( getLocalMillis () ) ;
}
public LocalDate withEra ( int era ) {
return withLocalMillis ( getChronology () . era () . set ( getLocalMillis () , era ) ) ;
}
public LocalDate withCenturyOfEra ( int centuryOfEra ) {
return withLocalMillis ( getChronology () . centuryOfEra () . set ( getLocalMillis () , centuryOfEra ) ) ;
}
public LocalDate withYearOfEra ( int yearOfEra ) {
return withLocalMillis ( getChronology () . yearOfEra () . set ( getLocalMillis () , yearOfEra ) ) ;
}
public LocalDate withYearOfCentury ( int yearOfCentury ) {
return withLocalMillis ( getChronology () . yearOfCentury () . set ( getLocalMillis () , yearOfCentury ) ) ;
}
public LocalDate withYear ( int year ) {
return withLocalMillis ( getChronology () . year () . set ( getLocalMillis () , year ) ) ;
}
public LocalDate withWeekyear ( int weekyear ) {
return withLocalMillis ( getChronology () . weekyear () . set ( getLocalMillis () , weekyear ) ) ;
}
public LocalDate withMonthOfYear ( int monthOfYear ) {
return withLocalMillis ( getChronology () . monthOfYear () . set ( getLocalMillis () , monthOfYear ) ) ;
}
public LocalDate withWeekOfWeekyear ( int weekOfWeekyear ) {
return withLocalMillis ( getChronology () . weekOfWeekyear () . set ( getLocalMillis () , weekOfWeekyear ) ) ;
}
public LocalDate withDayOfYear ( int dayOfYear ) {
return withLocalMillis ( getChronology () . dayOfYear () . set ( getLocalMillis () , dayOfYear ) ) ;
}
public LocalDate withDayOfMonth ( int dayOfMonth ) {
return withLocalMillis ( getChronology () . dayOfMonth () . set ( getLocalMillis () , dayOfMonth ) ) ;
}
public LocalDate withDayOfWeek ( int dayOfWeek ) {
return withLocalMillis ( getChronology () . dayOfWeek () . set ( getLocalMillis () , dayOfWeek ) ) ;
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
@ToString
public String toString () {
return ISODateTimeFormat . date () . print ( this ) ;
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
iInstant = ( LocalDate ) oos . readObject () ;
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
public LocalDate getLocalDate () {
return iInstant ;
}
public LocalDate addToCopy ( int value ) {
return iInstant . withLocalMillis ( iField . add ( iInstant . getLocalMillis () , value ) ) ;
}
public LocalDate addWrapFieldToCopy ( int value ) {
return iInstant . withLocalMillis ( iField . addWrapField ( iInstant . getLocalMillis () , value ) ) ;
}
public LocalDate setCopy ( int value ) {
return iInstant . withLocalMillis ( iField . set ( iInstant . getLocalMillis () , value ) ) ;
}
public LocalDate setCopy ( String text , Locale locale ) {
return iInstant . withLocalMillis ( iField . set ( iInstant . getLocalMillis () , text , locale ) ) ;
}
public LocalDate setCopy ( String text ) {
return setCopy ( text , null ) ;
}
public LocalDate withMaximumValue () {
return setCopy ( getMaximumValue () ) ;
}
public LocalDate withMinimumValue () {
return setCopy ( getMinimumValue () ) ;
}
public LocalDate roundFloorCopy () {
return iInstant . withLocalMillis ( iField . roundFloor ( iInstant . getLocalMillis () ) ) ;
}
public LocalDate roundCeilingCopy () {
return iInstant . withLocalMillis ( iField . roundCeiling ( iInstant . getLocalMillis () ) ) ;
}
public LocalDate roundHalfFloorCopy () {
return iInstant . withLocalMillis ( iField . roundHalfFloor ( iInstant . getLocalMillis () ) ) ;
}
public LocalDate roundHalfCeilingCopy () {
return iInstant . withLocalMillis ( iField . roundHalfCeiling ( iInstant . getLocalMillis () ) ) ;
}
public LocalDate roundHalfEvenCopy () {
return iInstant . withLocalMillis ( iField . roundHalfEven ( iInstant . getLocalMillis () ) ) ;
}
