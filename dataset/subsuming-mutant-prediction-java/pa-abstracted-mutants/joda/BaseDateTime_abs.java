private void adjustForMinMax () {
if ( iMillis == Long . MIN_VALUE || iMillis == Long . MAX_VALUE ) {
iChronology = iChronology . withUTC () ;
}
}
protected Chronology checkChronology ( Chronology chronology ) {
return DateTimeUtils . getChronology ( chronology ) ;
}
protected long checkInstant ( long instant , Chronology chronology ) {
return instant ;
}
public long getMillis () {
return iMillis ;
}
public Chronology getChronology () {
return iChronology ;
}
protected void setMillis ( long instant ) {
iMillis = checkInstant ( instant , iChronology ) ;
}
protected void setChronology ( Chronology chronology ) {
iChronology = checkChronology ( chronology ) ;
}
