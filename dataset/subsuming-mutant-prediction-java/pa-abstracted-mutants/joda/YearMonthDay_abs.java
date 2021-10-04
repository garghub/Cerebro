public static YearMonthDay fromCalendarFields ( Calendar calendar ) {
if ( calendar == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return new YearMonthDay (
calendar . get ( Calendar . YEAR ) ,
calendar . get ( Calendar . MONTH ) + 1 ,
calendar . get ( Calendar . DAY_OF_MONTH )
) ;
}
public static YearMonthDay fromDateFields ( Date date ) {
if ( date == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return new YearMonthDay (
date . getYear () + 1900 ,
date . getMonth () + 1 ,
date . getDate ()
) ;
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
throw new IndexOutOfBoundsException ( lr_3 + index ) ;
}
}
public DateTimeFieldType getFieldType ( int index ) {
return FIELD_TYPES [ index ] ;
}
public DateTimeFieldType [] getFieldTypes () {
return ( DateTimeFieldType [] ) FIELD_TYPES . clone () ;
}
public YearMonthDay withChronologyRetainFields ( Chronology newChronology ) {
newChronology = DateTimeUtils . getChronology ( newChronology ) ;
newChronology = newChronology . withUTC () ;
if ( newChronology == getChronology () ) {
return this ;
} else {
YearMonthDay newYearMonthDay = new YearMonthDay ( this , newChronology ) ;
newChronology . validate ( newYearMonthDay , getValues () ) ;
return newYearMonthDay ;
}
}
public YearMonthDay withField ( DateTimeFieldType fieldType , int value ) {
int index = indexOfSupported ( fieldType ) ;
if ( value == getValue ( index ) ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . set ( this , index , newValues , value ) ;
return new YearMonthDay ( this , newValues ) ;
}
public YearMonthDay withFieldAdded ( DurationFieldType fieldType , int amount ) {
int index = indexOfSupported ( fieldType ) ;
if ( amount == 0 ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . add ( this , index , newValues , amount ) ;
return new YearMonthDay ( this , newValues ) ;
}
public YearMonthDay withPeriodAdded ( ReadablePeriod period , int scalar ) {
if ( period == null || scalar == 0 ) {
return this ;
}
int [] newValues = getValues () ;
for ( int i = 0 ; i < period . size () ; i ++ ) {
DurationFieldType fieldType = period . getFieldType ( i ) ;
int index = indexOf ( fieldType ) ;
if ( index >= 0 ) {
newValues = getField ( index ) . add ( this , index , newValues ,
FieldUtils . safeMultiply ( period . getValue ( i ) , scalar ) ) ;
}
}
return new YearMonthDay ( this , newValues ) ;
}
public YearMonthDay plus ( ReadablePeriod period ) {
return withPeriodAdded ( period , 1 ) ;
}
public YearMonthDay plusYears ( int years ) {
return withFieldAdded ( DurationFieldType . years () , years ) ;
}
public YearMonthDay plusMonths ( int months ) {
return withFieldAdded ( DurationFieldType . months () , months ) ;
}
public YearMonthDay plusDays ( int days ) {
return withFieldAdded ( DurationFieldType . days () , days ) ;
}
public YearMonthDay minus ( ReadablePeriod period ) {
return withPeriodAdded ( period , - 1 ) ;
}
public YearMonthDay minusYears ( int years ) {
return withFieldAdded ( DurationFieldType . years () , FieldUtils . safeNegate ( years ) ) ;
}
public YearMonthDay minusMonths ( int months ) {
return withFieldAdded ( DurationFieldType . months () , FieldUtils . safeNegate ( months ) ) ;
}
public YearMonthDay minusDays ( int days ) {
return withFieldAdded ( DurationFieldType . days () , FieldUtils . safeNegate ( days ) ) ;
}
public Property property ( DateTimeFieldType type ) {
return new Property ( this , indexOfSupported ( type ) ) ;
}
public LocalDate toLocalDate () {
return new LocalDate ( getYear () , getMonthOfYear () , getDayOfMonth () , getChronology () ) ;
}
public DateTime toDateTimeAtMidnight () {
return toDateTimeAtMidnight ( null ) ;
}
public DateTime toDateTimeAtMidnight ( DateTimeZone zone ) {
Chronology chrono = getChronology () . withZone ( zone ) ;
return new DateTime ( getYear () , getMonthOfYear () , getDayOfMonth () , 0 , 0 , 0 , 0 , chrono ) ;
}
public DateTime toDateTimeAtCurrentTime () {
return toDateTimeAtCurrentTime ( null ) ;
}
public DateTime toDateTimeAtCurrentTime ( DateTimeZone zone ) {
Chronology chrono = getChronology () . withZone ( zone ) ;
long instantMillis = DateTimeUtils . currentTimeMillis () ;
long resolved = chrono . set ( this , instantMillis ) ;
return new DateTime ( resolved , chrono ) ;
}
public DateMidnight toDateMidnight () {
return toDateMidnight ( null ) ;
}
public DateMidnight toDateMidnight ( DateTimeZone zone ) {
Chronology chrono = getChronology () . withZone ( zone ) ;
return new DateMidnight ( getYear () , getMonthOfYear () , getDayOfMonth () , chrono ) ;
}
public DateTime toDateTime ( TimeOfDay time ) {
return toDateTime ( time , null ) ;
}
public DateTime toDateTime ( TimeOfDay time , DateTimeZone zone ) {
Chronology chrono = getChronology () . withZone ( zone ) ;
long instant = DateTimeUtils . currentTimeMillis () ;
instant = chrono . set ( this , instant ) ;
if ( time != null ) {
instant = chrono . set ( time , instant ) ;
}
return new DateTime ( instant , chrono ) ;
}
public Interval toInterval () {
return toInterval ( null ) ;
}
public Interval toInterval ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
return toDateMidnight ( zone ) . toInterval () ;
}
public int getYear () {
return getValue ( YEAR ) ;
}
public int getMonthOfYear () {
return getValue ( MONTH_OF_YEAR ) ;
}
public int getDayOfMonth () {
return getValue ( DAY_OF_MONTH ) ;
}
public YearMonthDay withYear ( int year ) {
int [] newValues = getValues () ;
newValues = getChronology () . year () . set ( this , YEAR , newValues , year ) ;
return new YearMonthDay ( this , newValues ) ;
}
public YearMonthDay withMonthOfYear ( int monthOfYear ) {
int [] newValues = getValues () ;
newValues = getChronology () . monthOfYear () . set ( this , MONTH_OF_YEAR , newValues , monthOfYear ) ;
return new YearMonthDay ( this , newValues ) ;
}
public YearMonthDay withDayOfMonth ( int dayOfMonth ) {
int [] newValues = getValues () ;
newValues = getChronology () . dayOfMonth () . set ( this , DAY_OF_MONTH , newValues , dayOfMonth ) ;
return new YearMonthDay ( this , newValues ) ;
}
public Property year () {
return new Property ( this , YEAR ) ;
}
public Property monthOfYear () {
return new Property ( this , MONTH_OF_YEAR ) ;
}
public Property dayOfMonth () {
return new Property ( this , DAY_OF_MONTH ) ;
}
public String toString () {
return ISODateTimeFormat . yearMonthDay () . print ( this ) ;
}
public DateTimeField getField () {
return iYearMonthDay . getField ( iFieldIndex ) ;
}
protected ReadablePartial getReadablePartial () {
return iYearMonthDay ;
}
public YearMonthDay getYearMonthDay () {
return iYearMonthDay ;
}
public int get () {
return iYearMonthDay . getValue ( iFieldIndex ) ;
}
public YearMonthDay addToCopy ( int valueToAdd ) {
int [] newValues = iYearMonthDay . getValues () ;
newValues = getField () . add ( iYearMonthDay , iFieldIndex , newValues , valueToAdd ) ;
return new YearMonthDay ( iYearMonthDay , newValues ) ;
}
public YearMonthDay addWrapFieldToCopy ( int valueToAdd ) {
int [] newValues = iYearMonthDay . getValues () ;
newValues = getField () . addWrapField ( iYearMonthDay , iFieldIndex , newValues , valueToAdd ) ;
return new YearMonthDay ( iYearMonthDay , newValues ) ;
}
public YearMonthDay setCopy ( int value ) {
int [] newValues = iYearMonthDay . getValues () ;
newValues = getField () . set ( iYearMonthDay , iFieldIndex , newValues , value ) ;
return new YearMonthDay ( iYearMonthDay , newValues ) ;
}
public YearMonthDay setCopy ( String text , Locale locale ) {
int [] newValues = iYearMonthDay . getValues () ;
newValues = getField () . set ( iYearMonthDay , iFieldIndex , newValues , text , locale ) ;
return new YearMonthDay ( iYearMonthDay , newValues ) ;
}
public YearMonthDay setCopy ( String text ) {
return setCopy ( text , null ) ;
}
public YearMonthDay withMaximumValue () {
return setCopy ( getMaximumValue () ) ;
}
public YearMonthDay withMinimumValue () {
return setCopy ( getMinimumValue () ) ;
}
