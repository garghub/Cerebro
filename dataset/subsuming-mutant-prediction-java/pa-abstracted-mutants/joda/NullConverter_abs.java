public long getDurationMillis ( Object object ) {
return 0L ;
}
public void setInto ( ReadWritablePeriod duration , Object object , Chronology chrono ) {
duration . setPeriod ( ( Period ) null ) ;
}
public void setInto ( ReadWritableInterval writableInterval , Object object , Chronology chrono ) {
writableInterval . setChronology ( chrono ) ;
long now = DateTimeUtils . currentTimeMillis () ;
writableInterval . setInterval ( now , now ) ;
}
public Class < ? > getSupportedType () {
return null ;
}
