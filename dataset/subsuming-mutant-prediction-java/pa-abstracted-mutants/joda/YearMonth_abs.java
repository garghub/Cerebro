public static YearMonth now () {
return new YearMonth () ;
}
public static YearMonth now ( DateTimeZone zone ) {
if ( zone == null ) {
throw new NullPointerException ( lr_1 ) ;
}
return new YearMonth ( zone ) ;
}
public static YearMonth now ( Chronology chronology ) {
if ( chronology == null ) {
throw new NullPointerException ( lr_2 ) ;
}
return new YearMonth ( chronology ) ;
}
@FromString
public static YearMonth parse ( String str ) {
return parse ( str , ISODateTimeFormat . localDateParser () ) ;
}
public static YearMonth parse ( String str , DateTimeFormatter formatter ) {
LocalDate date = formatter . parseLocalDate ( str ) ;
return new YearMonth ( date . getYear () , date . getMonthOfYear () ) ;
}
public static YearMonth fromCalendarFields ( Calendar calendar ) {
if ( calendar == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new YearMonth ( calendar . get ( Calendar . YEAR ) , calendar . get ( Calendar . MONTH ) + 1 ) ;
}
@SuppressWarnings ( lr_4 )
public static YearMonth fromDateFields ( Date date ) {
if ( date == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
return new YearMonth ( date . getYear () + 1900 , date . getMonth () + 1 ) ;
}
private Object readResolve () {
if ( DateTimeZone . UTC . equals ( getChronology () . getZone () ) == false ) {
return new YearMonth ( this , getChronology () . withUTC () ) ;
}
return this ;
}
public int size () {
return 2 ;
}
protected DateTimeField getField ( int index , Chronology chrono ) {
switch ( index ) {
case YEAR :
return chrono . year () ;
case MONTH_OF_YEAR :
return chrono . monthOfYear () ;
default:
throw new IndexOutOfBoundsException ( lr_6 + index ) ;
}
}
public DateTimeFieldType getFieldType ( int index ) {
return FIELD_TYPES [ index ] ;
}
public DateTimeFieldType [] getFieldTypes () {
return ( DateTimeFieldType [] ) FIELD_TYPES . clone () ;
}
public YearMonth withChronologyRetainFields ( Chronology newChronology ) {
newChronology = DateTimeUtils . getChronology ( newChronology ) ;
newChronology = newChronology . withUTC () ;
if ( newChronology == getChronology () ) {
return this ;
} else {
YearMonth newYearMonth = new YearMonth ( this , newChronology ) ;
newChronology . validate ( newYearMonth , getValues () ) ;
return newYearMonth ;
}
}
public YearMonth withField ( DateTimeFieldType fieldType , int value ) {
int index = indexOfSupported ( fieldType ) ;
if ( value == getValue ( index ) ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . set ( this , index , newValues , value ) ;
return new YearMonth ( this , newValues ) ;
}
public YearMonth withFieldAdded ( DurationFieldType fieldType , int amount ) {
int index = indexOfSupported ( fieldType ) ;
if ( amount == 0 ) {
return this ;
}
int [] newValues = getValues () ;
newValues = getField ( index ) . add ( this , index , newValues , amount ) ;
return new YearMonth ( this , newValues ) ;
}
public YearMonth withPeriodAdded ( ReadablePeriod period , int scalar ) {
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
return new YearMonth ( this , newValues ) ;
}
public YearMonth plus ( ReadablePeriod period ) {
return withPeriodAdded ( period , 1 ) ;
}
public YearMonth plusYears ( int years ) {
return withFieldAdded ( DurationFieldType . years () , years ) ;
}
public YearMonth plusMonths ( int months ) {
return withFieldAdded ( DurationFieldType . months () , months ) ;
}
public YearMonth minus ( ReadablePeriod period ) {
return withPeriodAdded ( period , - 1 ) ;
}
public YearMonth minusYears ( int years ) {
return withFieldAdded ( DurationFieldType . years () , FieldUtils . safeNegate ( years ) ) ;
}
public YearMonth minusMonths ( int months ) {
return withFieldAdded ( DurationFieldType . months () , FieldUtils . safeNegate ( months ) ) ;
}
public LocalDate toLocalDate ( int dayOfMonth ) {
return new LocalDate ( getYear () , getMonthOfYear () , dayOfMonth , getChronology () ) ;
}
public Interval toInterval () {
return toInterval ( null ) ;
}
public Interval toInterval ( DateTimeZone zone ) {
zone = DateTimeUtils . getZone ( zone ) ;
DateTime start = toLocalDate ( 1 ) . toDateTimeAtStartOfDay ( zone ) ;
DateTime end = plusMonths ( 1 ) . toLocalDate ( 1 ) . toDateTimeAtStartOfDay ( zone ) ;
return new Interval ( start , end ) ;
}
public int getYear () {
return getValue ( YEAR ) ;
}
public int getMonthOfYear () {
return getValue ( MONTH_OF_YEAR ) ;
}
public YearMonth withYear ( int year ) {
int [] newValues = getValues () ;
newValues = getChronology () . year () . set ( this , YEAR , newValues , year ) ;
return new YearMonth ( this , newValues ) ;
}
public YearMonth withMonthOfYear ( int monthOfYear ) {
int [] newValues = getValues () ;
newValues = getChronology () . monthOfYear () . set ( this , MONTH_OF_YEAR , newValues , monthOfYear ) ;
return new YearMonth ( this , newValues ) ;
}
public Property property ( DateTimeFieldType type ) {
return new Property ( this , indexOfSupported ( type ) ) ;
}
public Property year () {
return new Property ( this , YEAR ) ;
}
public Property monthOfYear () {
return new Property ( this , MONTH_OF_YEAR ) ;
}
@ToString
public String toString () {
return ISODateTimeFormat . yearMonth () . print ( this ) ;
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
public DateTimeField getField () {
return iBase . getField ( iFieldIndex ) ;
}
protected ReadablePartial getReadablePartial () {
return iBase ;
}
public YearMonth getYearMonth () {
return iBase ;
}
public int get () {
return iBase . getValue ( iFieldIndex ) ;
}
public YearMonth addToCopy ( int valueToAdd ) {
int [] newValues = iBase . getValues () ;
newValues = getField () . add ( iBase , iFieldIndex , newValues , valueToAdd ) ;
return new YearMonth ( iBase , newValues ) ;
}
public YearMonth addWrapFieldToCopy ( int valueToAdd ) {
int [] newValues = iBase . getValues () ;
newValues = getField () . addWrapField ( iBase , iFieldIndex , newValues , valueToAdd ) ;
return new YearMonth ( iBase , newValues ) ;
}
public YearMonth setCopy ( int value ) {
int [] newValues = iBase . getValues () ;
newValues = getField () . set ( iBase , iFieldIndex , newValues , value ) ;
return new YearMonth ( iBase , newValues ) ;
}
public YearMonth setCopy ( String text , Locale locale ) {
int [] newValues = iBase . getValues () ;
newValues = getField () . set ( iBase , iFieldIndex , newValues , text , locale ) ;
return new YearMonth ( iBase , newValues ) ;
}
public YearMonth setCopy ( String text ) {
return setCopy ( text , null ) ;
}
