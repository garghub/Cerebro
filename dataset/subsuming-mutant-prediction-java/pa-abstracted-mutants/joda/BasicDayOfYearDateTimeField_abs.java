public int get ( long instant ) {
return iChronology . getDayOfYear ( instant ) ;
}
public DurationField getRangeDurationField () {
return iChronology . years () ;
}
public int getMinimumValue () {
return 1 ;
}
public int getMaximumValue () {
return iChronology . getDaysInYearMax () ;
}
public int getMaximumValue ( long instant ) {
int year = iChronology . getYear ( instant ) ;
return iChronology . getDaysInYear ( year ) ;
}
public int getMaximumValue ( ReadablePartial partial ) {
if ( partial . isSupported ( DateTimeFieldType . year () ) ) {
int year = partial . get ( DateTimeFieldType . year () ) ;
return iChronology . getDaysInYear ( year ) ;
}
return iChronology . getDaysInYearMax () ;
}
public int getMaximumValue ( ReadablePartial partial , int [] values ) {
int size = partial . size () ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( partial . getFieldType ( i ) == DateTimeFieldType . year () ) {
int year = values [ i ] ;
return iChronology . getDaysInYear ( year ) ;
}
}
return iChronology . getDaysInYearMax () ;
}
protected int getMaximumValueForSet ( long instant , int value ) {
int maxLessOne = iChronology . getDaysInYearMax () - 1 ;
return ( value > maxLessOne || value < 1 ) ? getMaximumValue ( instant ) : maxLessOne ;
}
@Override
public boolean isLeap ( long instant ) {
return iChronology . isLeapDay ( instant ) ;
}
private Object readResolve () {
return iChronology . dayOfYear () ;
}
