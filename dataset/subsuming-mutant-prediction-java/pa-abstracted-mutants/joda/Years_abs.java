public static Years years ( int years ) {
switch ( years ) {
case 0 :
return ZERO ;
case 1 :
return ONE ;
case 2 :
return TWO ;
case 3 :
return THREE ;
case Integer . MAX_VALUE :
return MAX_VALUE ;
case Integer . MIN_VALUE :
return MIN_VALUE ;
default:
return new Years ( years ) ;
}
}
public static Years yearsBetween ( ReadableInstant start , ReadableInstant end ) {
int amount = BaseSingleFieldPeriod . between ( start , end , DurationFieldType . years () ) ;
return Years . years ( amount ) ;
}
public static Years yearsBetween ( ReadablePartial start , ReadablePartial end ) {
if ( start instanceof LocalDate && end instanceof LocalDate ) {
Chronology chrono = DateTimeUtils . getChronology ( start . getChronology () ) ;
int years = chrono . years () . getDifference (
( ( LocalDate ) end ) . getLocalMillis () , ( ( LocalDate ) start ) . getLocalMillis () ) ;
return Years . years ( years ) ;
}
int amount = BaseSingleFieldPeriod . between ( start , end , ZERO ) ;
return Years . years ( amount ) ;
}
public static Years yearsIn ( ReadableInterval interval ) {
if ( interval == null ) {
return Years . ZERO ;
}
int amount = BaseSingleFieldPeriod . between ( interval . getStart () , interval . getEnd () , DurationFieldType . years () ) ;
return Years . years ( amount ) ;
}
@FromString
public static Years parseYears ( String periodStr ) {
if ( periodStr == null ) {
return Years . ZERO ;
}
Period p = PARSER . parsePeriod ( periodStr ) ;
return Years . years ( p . getYears () ) ;
}
private Object readResolve () {
return Years . years ( getValue () ) ;
}
public DurationFieldType getFieldType () {
return DurationFieldType . years () ;
}
public PeriodType getPeriodType () {
return PeriodType . years () ;
}
public int getYears () {
return getValue () ;
}
public Years plus ( int years ) {
if ( years == 0 ) {
return this ;
}
return Years . years ( FieldUtils . safeAdd ( getValue () , years ) ) ;
}
public Years plus ( Years years ) {
if ( years == null ) {
return this ;
}
return plus ( years . getValue () ) ;
}
public Years minus ( int years ) {
return plus ( FieldUtils . safeNegate ( years ) ) ;
}
public Years minus ( Years years ) {
if ( years == null ) {
return this ;
}
return minus ( years . getValue () ) ;
}
public Years multipliedBy ( int scalar ) {
return Years . years ( FieldUtils . safeMultiply ( getValue () , scalar ) ) ;
}
public Years dividedBy ( int divisor ) {
if ( divisor == 1 ) {
return this ;
}
return Years . years ( getValue () / divisor ) ;
}
public Years negated () {
return Years . years ( FieldUtils . safeNegate ( getValue () ) ) ;
}
public boolean isGreaterThan ( Years other ) {
if ( other == null ) {
return getValue () > 0 ;
}
return getValue () > other . getValue () ;
}
public boolean isLessThan ( Years other ) {
if ( other == null ) {
return getValue () < 0 ;
}
return getValue () < other . getValue () ;
}
@ToString
public String toString () {
return lr_1 + String . valueOf ( getValue () ) + lr_2 ;
}
