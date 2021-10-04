@Override
public DurationField getRangeDurationField () {
if ( iRangeDurationField != null ) {
return iRangeDurationField ;
}
return super . getRangeDurationField () ;
}
public int get ( long instant ) {
int value = getWrappedField () . get ( instant ) ;
if ( value >= 0 ) {
return value / iDivisor ;
} else {
return ( ( value + 1 ) / iDivisor ) - 1 ;
}
}
public long add ( long instant , int amount ) {
return getWrappedField () . add ( instant , amount * iDivisor ) ;
}
public long add ( long instant , long amount ) {
return getWrappedField () . add ( instant , amount * iDivisor ) ;
}
public long addWrapField ( long instant , int amount ) {
return set ( instant , FieldUtils . getWrappedValue ( get ( instant ) , amount , iMin , iMax ) ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return getWrappedField () . getDifference ( minuendInstant , subtrahendInstant ) / iDivisor ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return getWrappedField () . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) / iDivisor ;
}
public long set ( long instant , int value ) {
FieldUtils . verifyValueBounds ( this , value , iMin , iMax ) ;
int remainder = getRemainder ( getWrappedField () . get ( instant ) ) ;
return getWrappedField () . set ( instant , value * iDivisor + remainder ) ;
}
public DurationField getDurationField () {
return iDurationField ;
}
public int getMinimumValue () {
return iMin ;
}
public int getMaximumValue () {
return iMax ;
}
public long roundFloor ( long instant ) {
DateTimeField field = getWrappedField () ;
return field . roundFloor ( field . set ( instant , get ( instant ) * iDivisor ) ) ;
}
public long remainder ( long instant ) {
return set ( instant , get ( getWrappedField () . remainder ( instant ) ) ) ;
}
public int getDivisor () {
return iDivisor ;
}
private int getRemainder ( int value ) {
if ( value >= 0 ) {
return value % iDivisor ;
} else {
return ( iDivisor - 1 ) + ( ( value + 1 ) % iDivisor ) ;
}
}
