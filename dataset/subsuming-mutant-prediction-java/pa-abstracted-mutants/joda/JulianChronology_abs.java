static int adjustYearForSet ( int year ) {
if ( year <= 0 ) {
if ( year == 0 ) {
throw new IllegalFieldValueException
( DateTimeFieldType . year () , Integer . valueOf ( year ) , null , null ) ;
}
year ++ ;
}
return year ;
}
public static JulianChronology getInstanceUTC () {
return INSTANCE_UTC ;
}
public static JulianChronology getInstance () {
return getInstance ( DateTimeZone . getDefault () , 4 ) ;
}
public static JulianChronology getInstance ( DateTimeZone zone ) {
return getInstance ( zone , 4 ) ;
}
public static JulianChronology getInstance ( DateTimeZone zone , int minDaysInFirstWeek ) {
if ( zone == null ) {
zone = DateTimeZone . getDefault () ;
}
JulianChronology chrono ;
JulianChronology [] chronos = cCache . get ( zone ) ;
if ( chronos == null ) {
chronos = new JulianChronology [ 7 ] ;
JulianChronology [] oldChronos = cCache . putIfAbsent ( zone , chronos ) ;
if ( oldChronos != null ) {
chronos = oldChronos ;
}
}
try {
chrono = chronos [ minDaysInFirstWeek - 1 ] ;
} catch ( ArrayIndexOutOfBoundsException e ) {
throw new IllegalArgumentException
( lr_1 + minDaysInFirstWeek ) ;
}
if ( chrono == null ) {
synchronized ( chronos ) {
chrono = chronos [ minDaysInFirstWeek - 1 ] ;
if ( chrono == null ) {
if ( zone == DateTimeZone . UTC ) {
chrono = new JulianChronology ( null , null , minDaysInFirstWeek ) ;
} else {
chrono = getInstance ( DateTimeZone . UTC , minDaysInFirstWeek ) ;
chrono = new JulianChronology
( ZonedChronology . getInstance ( chrono , zone ) , null , minDaysInFirstWeek ) ;
}
chronos [ minDaysInFirstWeek - 1 ] = chrono ;
}
}
}
return chrono ;
}
private Object readResolve () {
Chronology base = getBase () ;
int minDays = getMinimumDaysInFirstWeek () ;
minDays = ( minDays == 0 ? 4 : minDays ) ;
return base == null ?
getInstance ( DateTimeZone . UTC , minDays ) :
getInstance ( base . getZone () , minDays ) ;
}
public Chronology withUTC () {
return INSTANCE_UTC ;
}
public Chronology withZone ( DateTimeZone zone ) {
if ( zone == null ) {
zone = DateTimeZone . getDefault () ;
}
if ( zone == getZone () ) {
return this ;
}
return getInstance ( zone ) ;
}
long getDateMidnightMillis ( int year , int monthOfYear , int dayOfMonth )
throws IllegalArgumentException
{
return super . getDateMidnightMillis ( adjustYearForSet ( year ) , monthOfYear , dayOfMonth ) ;
}
boolean isLeapYear ( int year ) {
return ( year & 3 ) == 0 ;
}
long calculateFirstDayOfYearMillis ( int year ) {
int relativeYear = year - 1968 ;
int leapYears ;
if ( relativeYear <= 0 ) {
leapYears = ( relativeYear + 3 ) >> 2 ;
} else {
leapYears = relativeYear >> 2 ;
if ( ! isLeapYear ( year ) ) {
leapYears ++ ;
}
}
long millis = ( relativeYear * 365L + leapYears ) * ( long ) DateTimeConstants . MILLIS_PER_DAY ;
return millis - ( 366L + 352 ) * DateTimeConstants . MILLIS_PER_DAY ;
}
int getMinYear () {
return MIN_YEAR ;
}
int getMaxYear () {
return MAX_YEAR ;
}
long getAverageMillisPerYear () {
return MILLIS_PER_YEAR ;
}
long getAverageMillisPerYearDividedByTwo () {
return MILLIS_PER_YEAR / 2 ;
}
long getAverageMillisPerMonth () {
return MILLIS_PER_MONTH ;
}
long getApproxMillisAtEpochDividedByTwo () {
return ( 1969L * MILLIS_PER_YEAR + 352L * DateTimeConstants . MILLIS_PER_DAY ) / 2 ;
}
protected void assemble ( Fields fields ) {
if ( getBase () == null ) {
super . assemble ( fields ) ;
fields . year = new SkipDateTimeField ( this , fields . year ) ;
fields . weekyear = new SkipDateTimeField ( this , fields . weekyear ) ;
}
}
