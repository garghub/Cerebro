@FromString
public static Duration parse ( String str ) {
return new Duration ( str ) ;
}
public static Duration standardDays ( long days ) {
if ( days == 0 ) {
return ZERO ;
}
return new Duration ( FieldUtils . safeMultiply ( days , DateTimeConstants . MILLIS_PER_DAY ) ) ;
}
public static Duration standardHours ( long hours ) {
if ( hours == 0 ) {
return ZERO ;
}
return new Duration ( FieldUtils . safeMultiply ( hours , DateTimeConstants . MILLIS_PER_HOUR ) ) ;
}
public static Duration standardMinutes ( long minutes ) {
if ( minutes == 0 ) {
return ZERO ;
}
return new Duration ( FieldUtils . safeMultiply ( minutes , DateTimeConstants . MILLIS_PER_MINUTE ) ) ;
}
public static Duration standardSeconds ( long seconds ) {
if ( seconds == 0 ) {
return ZERO ;
}
return new Duration ( FieldUtils . safeMultiply ( seconds , DateTimeConstants . MILLIS_PER_SECOND ) ) ;
}
public static Duration millis ( long millis ) {
if ( millis == 0 ) {
return ZERO ;
}
return new Duration ( millis ) ;
}
public long getStandardDays () {
return getMillis () / DateTimeConstants . MILLIS_PER_DAY ;
}
public long getStandardHours () {
return getMillis () / DateTimeConstants . MILLIS_PER_HOUR ;
}
public long getStandardMinutes () {
return getMillis () / DateTimeConstants . MILLIS_PER_MINUTE ;
}
public long getStandardSeconds () {
return getMillis () / DateTimeConstants . MILLIS_PER_SECOND ;
}
public Duration toDuration () {
return this ;
}
public Days toStandardDays () {
long days = getStandardDays () ;
return Days . days ( FieldUtils . safeToInt ( days ) ) ;
}
public Hours toStandardHours () {
long hours = getStandardHours () ;
return Hours . hours ( FieldUtils . safeToInt ( hours ) ) ;
}
public Minutes toStandardMinutes () {
long minutes = getStandardMinutes () ;
return Minutes . minutes ( FieldUtils . safeToInt ( minutes ) ) ;
}
public Seconds toStandardSeconds () {
long seconds = getStandardSeconds () ;
return Seconds . seconds ( FieldUtils . safeToInt ( seconds ) ) ;
}
public Duration withMillis ( long duration ) {
if ( duration == getMillis () ) {
return this ;
}
return new Duration ( duration ) ;
}
public Duration withDurationAdded ( long durationToAdd , int scalar ) {
if ( durationToAdd == 0 || scalar == 0 ) {
return this ;
}
long add = FieldUtils . safeMultiply ( durationToAdd , scalar ) ;
long duration = FieldUtils . safeAdd ( getMillis () , add ) ;
return new Duration ( duration ) ;
}
public Duration withDurationAdded ( ReadableDuration durationToAdd , int scalar ) {
if ( durationToAdd == null || scalar == 0 ) {
return this ;
}
return withDurationAdded ( durationToAdd . getMillis () , scalar ) ;
}
public Duration plus ( long amount ) {
return withDurationAdded ( amount , 1 ) ;
}
public Duration plus ( ReadableDuration amount ) {
if ( amount == null ) {
return this ;
}
return withDurationAdded ( amount . getMillis () , 1 ) ;
}
public Duration minus ( long amount ) {
return withDurationAdded ( amount , - 1 ) ;
}
public Duration minus ( ReadableDuration amount ) {
if ( amount == null ) {
return this ;
}
return withDurationAdded ( amount . getMillis () , - 1 ) ;
}
public Duration multipliedBy ( long multiplicand ) {
if ( multiplicand == 1 ) {
return this ;
}
return new Duration ( FieldUtils . safeMultiply ( getMillis () , multiplicand ) ) ;
}
public Duration dividedBy ( long divisor ) {
if ( divisor == 1 ) {
return this ;
}
return new Duration ( FieldUtils . safeDivide ( getMillis () , divisor ) ) ;
}
public Duration dividedBy ( long divisor , RoundingMode roundingMode ) {
if ( divisor == 1 ) {
return this ;
}
return new Duration ( FieldUtils . safeDivide ( getMillis () , divisor , roundingMode ) ) ;
}
public Duration negated () {
if ( getMillis () == Long . MIN_VALUE ) {
throw new ArithmeticException ( lr_1 ) ;
}
return new Duration ( - getMillis () ) ;
}
public Duration abs () {
if ( getMillis () < 0 ) {
return negated () ;
}
return this ;
}
