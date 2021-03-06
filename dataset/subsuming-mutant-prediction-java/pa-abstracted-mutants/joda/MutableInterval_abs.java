public static MutableInterval parse ( String str ) {
return new MutableInterval ( str ) ;
}
public void setInterval ( long startInstant , long endInstant ) {
super . setInterval ( startInstant , endInstant , getChronology () ) ;
}
public void setInterval ( ReadableInterval interval ) {
if ( interval == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
long startMillis = interval . getStartMillis () ;
long endMillis = interval . getEndMillis () ;
Chronology chrono = interval . getChronology () ;
super . setInterval ( startMillis , endMillis , chrono ) ;
}
public void setInterval ( ReadableInstant start , ReadableInstant end ) {
if ( start == null && end == null ) {
long now = DateTimeUtils . currentTimeMillis () ;
setInterval ( now , now ) ;
} else {
long startMillis = DateTimeUtils . getInstantMillis ( start ) ;
long endMillis = DateTimeUtils . getInstantMillis ( end ) ;
Chronology chrono = DateTimeUtils . getInstantChronology ( start ) ;
super . setInterval ( startMillis , endMillis , chrono ) ;
}
}
public void setChronology ( Chronology chrono ) {
super . setInterval ( getStartMillis () , getEndMillis () , chrono ) ;
}
public void setStartMillis ( long startInstant ) {
super . setInterval ( startInstant , getEndMillis () , getChronology () ) ;
}
public void setStart ( ReadableInstant start ) {
long startMillis = DateTimeUtils . getInstantMillis ( start ) ;
super . setInterval ( startMillis , getEndMillis () , getChronology () ) ;
}
public void setEndMillis ( long endInstant ) {
super . setInterval ( getStartMillis () , endInstant , getChronology () ) ;
}
public void setEnd ( ReadableInstant end ) {
long endMillis = DateTimeUtils . getInstantMillis ( end ) ;
super . setInterval ( getStartMillis () , endMillis , getChronology () ) ;
}
public void setDurationAfterStart ( long duration ) {
setEndMillis ( FieldUtils . safeAdd ( getStartMillis () , duration ) ) ;
}
public void setDurationBeforeEnd ( long duration ) {
setStartMillis ( FieldUtils . safeAdd ( getEndMillis () , - duration ) ) ;
}
public void setDurationAfterStart ( ReadableDuration duration ) {
long durationMillis = DateTimeUtils . getDurationMillis ( duration ) ;
setEndMillis ( FieldUtils . safeAdd ( getStartMillis () , durationMillis ) ) ;
}
public void setDurationBeforeEnd ( ReadableDuration duration ) {
long durationMillis = DateTimeUtils . getDurationMillis ( duration ) ;
setStartMillis ( FieldUtils . safeAdd ( getEndMillis () , - durationMillis ) ) ;
}
public void setPeriodAfterStart ( ReadablePeriod period ) {
if ( period == null ) {
setEndMillis ( getStartMillis () ) ;
} else {
setEndMillis ( getChronology () . add ( period , getStartMillis () , 1 ) ) ;
}
}
public void setPeriodBeforeEnd ( ReadablePeriod period ) {
if ( period == null ) {
setStartMillis ( getEndMillis () ) ;
} else {
setStartMillis ( getChronology () . add ( period , getEndMillis () , - 1 ) ) ;
}
}
public MutableInterval copy () {
return ( MutableInterval ) clone () ;
}
public Object clone () {
try {
return super . clone () ;
} catch ( CloneNotSupportedException ex ) {
throw new InternalError ( lr_2 ) ;
}
}
