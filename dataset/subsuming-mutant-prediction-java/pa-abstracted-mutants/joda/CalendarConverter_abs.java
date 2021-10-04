public Chronology getChronology ( Object object , Chronology chrono ) {
if ( chrono != null ) {
return chrono ;
}
Calendar cal = ( Calendar ) object ;
DateTimeZone zone = null ;
try {
zone = DateTimeZone . forTimeZone ( cal . getTimeZone () ) ;
} catch ( IllegalArgumentException ex ) {
zone = DateTimeZone . getDefault () ;
}
return getChronology ( cal , zone ) ;
}
public Chronology getChronology ( Object object , DateTimeZone zone ) {
if ( object . getClass () . getName () . endsWith ( lr_1 ) ) {
return BuddhistChronology . getInstance ( zone ) ;
} else if ( object instanceof GregorianCalendar ) {
GregorianCalendar gc = ( GregorianCalendar ) object ;
long cutover = gc . getGregorianChange () . getTime () ;
if ( cutover == Long . MIN_VALUE ) {
return GregorianChronology . getInstance ( zone ) ;
} else if ( cutover == Long . MAX_VALUE ) {
return JulianChronology . getInstance ( zone ) ;
} else {
return GJChronology . getInstance ( zone , cutover , 4 ) ;
}
} else {
return ISOChronology . getInstance ( zone ) ;
}
}
public long getInstantMillis ( Object object , Chronology chrono ) {
Calendar calendar = ( Calendar ) object ;
return calendar . getTime () . getTime () ;
}
public Class < ? > getSupportedType () {
return Calendar . class ;
}
