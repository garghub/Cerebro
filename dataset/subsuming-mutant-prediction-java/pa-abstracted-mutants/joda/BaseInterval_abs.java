public Chronology getChronology () {
return iChronology ;
}
public long getStartMillis () {
return iStartMillis ;
}
public long getEndMillis () {
return iEndMillis ;
}
protected void setInterval ( long startInstant , long endInstant , Chronology chrono ) {
checkInterval ( startInstant , endInstant ) ;
iStartMillis = startInstant ;
iEndMillis = endInstant ;
iChronology = DateTimeUtils . getChronology ( chrono ) ;
}
