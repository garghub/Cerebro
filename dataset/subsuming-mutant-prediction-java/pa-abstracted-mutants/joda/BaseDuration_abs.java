public long getMillis () {
return iMillis ;
}
protected void setMillis ( long duration ) {
iMillis = duration ;
}
public Period toPeriod ( PeriodType type ) {
return new Period ( getMillis () , type ) ;
}
public Period toPeriod ( Chronology chrono ) {
return new Period ( getMillis () , chrono ) ;
}
public Period toPeriod ( PeriodType type , Chronology chrono ) {
return new Period ( getMillis () , type , chrono ) ;
}
public Period toPeriodFrom ( ReadableInstant startInstant ) {
return new Period ( startInstant , this ) ;
}
public Period toPeriodFrom ( ReadableInstant startInstant , PeriodType type ) {
return new Period ( startInstant , this , type ) ;
}
public Period toPeriodTo ( ReadableInstant endInstant ) {
return new Period ( this , endInstant ) ;
}
public Period toPeriodTo ( ReadableInstant endInstant , PeriodType type ) {
return new Period ( this , endInstant , type ) ;
}
public Interval toIntervalFrom ( ReadableInstant startInstant ) {
return new Interval ( startInstant , this ) ;
}
public Interval toIntervalTo ( ReadableInstant endInstant ) {
return new Interval ( this , endInstant ) ;
}
