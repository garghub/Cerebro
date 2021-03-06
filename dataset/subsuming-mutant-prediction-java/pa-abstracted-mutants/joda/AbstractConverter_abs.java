public long getInstantMillis ( Object object , Chronology chrono ) {
return DateTimeUtils . currentTimeMillis () ;
}
public Chronology getChronology ( Object object , DateTimeZone zone ) {
return ISOChronology . getInstance ( zone ) ;
}
public Chronology getChronology ( Object object , Chronology chrono ) {
return DateTimeUtils . getChronology ( chrono ) ;
}
public int [] getPartialValues ( ReadablePartial fieldSource , Object object , Chronology chrono ) {
long instant = getInstantMillis ( object , chrono ) ;
return chrono . get ( fieldSource , instant ) ;
}
public int [] getPartialValues ( ReadablePartial fieldSource ,
Object object , Chronology chrono , DateTimeFormatter parser ) {
return getPartialValues ( fieldSource , object , chrono ) ;
}
public PeriodType getPeriodType ( Object object ) {
return PeriodType . standard () ;
}
public boolean isReadableInterval ( Object object , Chronology chrono ) {
return false ;
}
public String toString () {
return lr_1 + ( getSupportedType () == null ? lr_2 : getSupportedType () . getName () ) + lr_3 ;
}
