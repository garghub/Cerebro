public int get ( long instant ) {
return iChronology . getDayOfMonth ( instant ) ;
}
public DurationField getRangeDurationField () {
return iChronology . months () ;
}
public int getMinimumValue () {
return 1 ;
}
public int getMaximumValue () {
return iChronology . getDaysInMonthMax () ;
}
public int getMaximumValue ( long instant ) {
return iChronology . getDaysInMonthMax ( instant ) ;
}
public int getMaximumValue ( ReadablePartial partial ) {
if ( partial . isSupported ( DateTimeFieldType . monthOfYear () ) ) {
int month = partial . get ( DateTimeFieldType . monthOfYear () ) ;
if ( partial . isSupported ( DateTimeFieldType . year () ) ) {
int year = partial . get ( DateTimeFieldType . year () ) ;
return iChronology . getDaysInYearMonth ( year , month ) ;
}
return iChronology . getDaysInMonthMax ( month ) ;
}
return getMaximumValue () ;
}
public int getMaximumValue ( ReadablePartial partial , int [] values ) {
int size = partial . size () ;
for ( int i = 0 ; i < size ; i ++ ) {
if ( partial . getFieldType ( i ) == DateTimeFieldType . monthOfYear () ) {
int month = values [ i ] ;
for ( int j = 0 ; j < size ; j ++ ) {
if ( partial . getFieldType ( j ) == DateTimeFieldType . year () ) {
int year = values [ j ] ;
return iChronology . getDaysInYearMonth ( year , month ) ;
}
}
return iChronology . getDaysInMonthMax ( month ) ;
}
}
return getMaximumValue () ;
}
protected int getMaximumValueForSet ( long instant , int value ) {
return iChronology . getDaysInMonthMaxForSet ( instant , value ) ;
}
@Override
public boolean isLeap ( long instant ) {
return iChronology . isLeapDay ( instant ) ;
}
private Object readResolve () {
return iChronology . dayOfMonth () ;
}
