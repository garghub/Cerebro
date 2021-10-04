public static Days days ( int days ) {
switch ( days ) {
case 0 :
return ZERO ;
case 1 :
return ONE ;
case 2 :
return TWO ;
case 3 :
return THREE ;
case 4 :
return FOUR ;
case 5 :
return FIVE ;
case 6 :
return SIX ;
case 7 :
return SEVEN ;
case Integer . MAX_VALUE :
return MAX_VALUE ;
case Integer . MIN_VALUE :
return MIN_VALUE ;
default:
return new Days ( days ) ;
}
}
public static Days daysBetween ( ReadableInstant start , ReadableInstant end ) {
int amount = BaseSingleFieldPeriod . between ( start , end , DurationFieldType . days () ) ;
return Days . days ( amount ) ;
}
public static Days daysBetween ( ReadablePartial start , ReadablePartial end ) {
if ( start instanceof LocalDate && end instanceof LocalDate ) {
Chronology chrono = DateTimeUtils . getChronology ( start . getChronology () ) ;
int days = chrono . days () . getDifference (
( ( LocalDate ) end ) . getLocalMillis () , ( ( LocalDate ) start ) . getLocalMillis () ) ;
return Days . days ( days ) ;
}
int amount = BaseSingleFieldPeriod . between ( start , end , ZERO ) ;
return Days . days ( amount ) ;
}
public static Days daysIn ( ReadableInterval interval ) {
if ( interval == null ) {
return Days . ZERO ;
}
int amount = BaseSingleFieldPeriod . between ( interval . getStart () , interval . getEnd () , DurationFieldType . days () ) ;
return Days . days ( amount ) ;
}
public static Days standardDaysIn ( ReadablePeriod period ) {
int amount = BaseSingleFieldPeriod . standardPeriodIn ( period , DateTimeConstants . MILLIS_PER_DAY ) ;
return Days . days ( amount ) ;
}
@FromString
public static Days parseDays ( String periodStr ) {
if ( periodStr == null ) {
return Days . ZERO ;
}
Period p = PARSER . parsePeriod ( periodStr ) ;
return Days . days ( p . getDays () ) ;
}
private Object readResolve () {
return Days . days ( getValue () ) ;
}
public DurationFieldType getFieldType () {
return DurationFieldType . days () ;
}
public PeriodType getPeriodType () {
return PeriodType . days () ;
}
public Weeks toStandardWeeks () {
return Weeks . weeks ( getValue () / DateTimeConstants . DAYS_PER_WEEK ) ;
}
public Hours toStandardHours () {
return Hours . hours ( FieldUtils . safeMultiply ( getValue () , DateTimeConstants . HOURS_PER_DAY ) ) ;
}
public Minutes toStandardMinutes () {
return Minutes . minutes ( FieldUtils . safeMultiply ( getValue () , DateTimeConstants . MINUTES_PER_DAY ) ) ;
}
public Seconds toStandardSeconds () {
return Seconds . seconds ( FieldUtils . safeMultiply ( getValue () , DateTimeConstants . SECONDS_PER_DAY ) ) ;
}
public Duration toStandardDuration () {
long days = getValue () ;
return new Duration ( days * DateTimeConstants . MILLIS_PER_DAY ) ;
}
public int getDays () {
return getValue () ;
}
public Days plus ( int days ) {
if ( days == 0 ) {
return this ;
}
return Days . days ( FieldUtils . safeAdd ( getValue () , days ) ) ;
}
public Days plus ( Days days ) {
if ( days == null ) {
return this ;
}
return plus ( days . getValue () ) ;
}
public Days minus ( int days ) {
return plus ( FieldUtils . safeNegate ( days ) ) ;
}
public Days minus ( Days days ) {
if ( days == null ) {
return this ;
}
return minus ( days . getValue () ) ;
}
public Days multipliedBy ( int scalar ) {
return Days . days ( FieldUtils . safeMultiply ( getValue () , scalar ) ) ;
}
public Days dividedBy ( int divisor ) {
if ( divisor == 1 ) {
return this ;
}
return Days . days ( getValue () / divisor ) ;
}
public Days negated () {
return Days . days ( FieldUtils . safeNegate ( getValue () ) ) ;
}
public boolean isGreaterThan ( Days other ) {
if ( other == null ) {
return getValue () > 0 ;
}
return getValue () > other . getValue () ;
}
public boolean isLessThan ( Days other ) {
if ( other == null ) {
return getValue () < 0 ;
}
return getValue () < other . getValue () ;
}
@ToString
public String toString () {
return lr_1 + String . valueOf ( getValue () ) + lr_2 ;
}
