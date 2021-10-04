public Chronology getChronology ( Object object , DateTimeZone zone ) {
Chronology chrono = ( ( ReadableInstant ) object ) . getChronology () ;
if ( chrono == null ) {
return ISOChronology . getInstance ( zone ) ;
}
DateTimeZone chronoZone = chrono . getZone () ;
if ( chronoZone != zone ) {
chrono = chrono . withZone ( zone ) ;
if ( chrono == null ) {
return ISOChronology . getInstance ( zone ) ;
}
}
return chrono ;
}
public Chronology getChronology ( Object object , Chronology chrono ) {
if ( chrono == null ) {
chrono = ( ( ReadableInstant ) object ) . getChronology () ;
chrono = DateTimeUtils . getChronology ( chrono ) ;
}
return chrono ;
}
public long getInstantMillis ( Object object , Chronology chrono ) {
return ( ( ReadableInstant ) object ) . getMillis () ;
}
public Class < ? > getSupportedType () {
return ReadableInstant . class ;
}
