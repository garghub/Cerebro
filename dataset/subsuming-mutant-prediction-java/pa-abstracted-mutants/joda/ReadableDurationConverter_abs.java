public long getDurationMillis ( Object object ) {
return ( ( ReadableDuration ) object ) . getMillis () ;
}
public void setInto ( ReadWritablePeriod writablePeriod , Object object , Chronology chrono ) {
ReadableDuration dur = ( ReadableDuration ) object ;
chrono = DateTimeUtils . getChronology ( chrono ) ;
long duration = dur . getMillis () ;
int [] values = chrono . get ( writablePeriod , duration ) ;
for ( int i = 0 ; i < values . length ; i ++ ) {
writablePeriod . setValue ( i , values [ i ] ) ;
}
}
public Class < ? > getSupportedType () {
return ReadableDuration . class ;
}
