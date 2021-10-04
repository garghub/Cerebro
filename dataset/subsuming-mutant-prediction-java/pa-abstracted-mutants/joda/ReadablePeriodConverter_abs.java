public void setInto ( ReadWritablePeriod duration , Object object , Chronology chrono ) {
duration . setPeriod ( ( ReadablePeriod ) object ) ;
}
public PeriodType getPeriodType ( Object object ) {
ReadablePeriod period = ( ReadablePeriod ) object ;
return period . getPeriodType () ;
}
public Class < ? > getSupportedType () {
return ReadablePeriod . class ;
}
