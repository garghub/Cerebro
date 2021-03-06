public static Months months ( int months ) {
switch ( months ) {
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
case 8 :
return EIGHT ;
case 9 :
return NINE ;
case 10 :
return TEN ;
case 11 :
return ELEVEN ;
case 12 :
return TWELVE ;
case Integer . MAX_VALUE :
return MAX_VALUE ;
case Integer . MIN_VALUE :
return MIN_VALUE ;
default:
return new Months ( months ) ;
}
}
public static Months monthsBetween ( ReadableInstant start , ReadableInstant end ) {
int amount = BaseSingleFieldPeriod . between ( start , end , DurationFieldType . months () ) ;
return Months . months ( amount ) ;
}
public static Months monthsBetween ( ReadablePartial start , ReadablePartial end ) {
if ( start instanceof LocalDate && end instanceof LocalDate ) {
Chronology chrono = DateTimeUtils . getChronology ( start . getChronology () ) ;
int months = chrono . months () . getDifference (
( ( LocalDate ) end ) . getLocalMillis () , ( ( LocalDate ) start ) . getLocalMillis () ) ;
return Months . months ( months ) ;
}
int amount = BaseSingleFieldPeriod . between ( start , end , ZERO ) ;
return Months . months ( amount ) ;
}
public static Months monthsIn ( ReadableInterval interval ) {
if ( interval == null ) {
return Months . ZERO ;
}
int amount = BaseSingleFieldPeriod . between ( interval . getStart () , interval . getEnd () , DurationFieldType . months () ) ;
return Months . months ( amount ) ;
}
@FromString
public static Months parseMonths ( String periodStr ) {
if ( periodStr == null ) {
return Months . ZERO ;
}
Period p = PARSER . parsePeriod ( periodStr ) ;
return Months . months ( p . getMonths () ) ;
}
private Object readResolve () {
return Months . months ( getValue () ) ;
}
public DurationFieldType getFieldType () {
return DurationFieldType . months () ;
}
public PeriodType getPeriodType () {
return PeriodType . months () ;
}
public int getMonths () {
return getValue () ;
}
public Months plus ( int months ) {
if ( months == 0 ) {
return this ;
}
return Months . months ( FieldUtils . safeAdd ( getValue () , months ) ) ;
}
public Months plus ( Months months ) {
if ( months == null ) {
return this ;
}
return plus ( months . getValue () ) ;
}
public Months minus ( int months ) {
return plus ( FieldUtils . safeNegate ( months ) ) ;
}
public Months minus ( Months months ) {
if ( months == null ) {
return this ;
}
return minus ( months . getValue () ) ;
}
public Months multipliedBy ( int scalar ) {
return Months . months ( FieldUtils . safeMultiply ( getValue () , scalar ) ) ;
}
public Months dividedBy ( int divisor ) {
if ( divisor == 1 ) {
return this ;
}
return Months . months ( getValue () / divisor ) ;
}
public Months negated () {
return Months . months ( FieldUtils . safeNegate ( getValue () ) ) ;
}
public boolean isGreaterThan ( Months other ) {
if ( other == null ) {
return getValue () > 0 ;
}
return getValue () > other . getValue () ;
}
public boolean isLessThan ( Months other ) {
if ( other == null ) {
return getValue () < 0 ;
}
return getValue () < other . getValue () ;
}
@ToString
public String toString () {
return lr_1 + String . valueOf ( getValue () ) + lr_2 ;
}
