public static Instant now () {
return new Instant () ;
}
public static Instant ofEpochMilli ( long epochMilli ) {
return new Instant ( epochMilli ) ;
}
public static Instant ofEpochSecond ( long epochSecond ) {
return new Instant ( FieldUtils . safeMultiply ( epochSecond , 1000 ) ) ;
}
@FromString
public static Instant parse ( String str ) {
return parse ( str , ISODateTimeFormat . dateTimeParser () ) ;
}
public static Instant parse ( String str , DateTimeFormatter formatter ) {
return formatter . parseDateTime ( str ) . toInstant () ;
}
public Instant toInstant () {
return this ;
}
public Instant withMillis ( long newMillis ) {
return ( newMillis == iMillis ? this : new Instant ( newMillis ) ) ;
}
public Instant withDurationAdded ( long durationToAdd , int scalar ) {
if ( durationToAdd == 0 || scalar == 0 ) {
return this ;
}
long instant = getChronology () . add ( getMillis () , durationToAdd , scalar ) ;
return withMillis ( instant ) ;
}
public Instant withDurationAdded ( ReadableDuration durationToAdd , int scalar ) {
if ( durationToAdd == null || scalar == 0 ) {
return this ;
}
return withDurationAdded ( durationToAdd . getMillis () , scalar ) ;
}
public Instant plus ( long duration ) {
return withDurationAdded ( duration , 1 ) ;
}
public Instant plus ( ReadableDuration duration ) {
return withDurationAdded ( duration , 1 ) ;
}
public Instant minus ( long duration ) {
return withDurationAdded ( duration , - 1 ) ;
}
public Instant minus ( ReadableDuration duration ) {
return withDurationAdded ( duration , - 1 ) ;
}
public long getMillis () {
return iMillis ;
}
public Chronology getChronology () {
return ISOChronology . getInstanceUTC () ;
}
public DateTime toDateTime () {
return new DateTime ( getMillis () , ISOChronology . getInstance () ) ;
}
@Deprecated
public DateTime toDateTimeISO () {
return toDateTime () ;
}
public MutableDateTime toMutableDateTime () {
return new MutableDateTime ( getMillis () , ISOChronology . getInstance () ) ;
}
@Deprecated
public MutableDateTime toMutableDateTimeISO () {
return toMutableDateTime () ;
}
