public int get ( long instant ) {
int value = getWrappedField () . get ( instant ) ;
if ( value >= 0 ) {
return value % iDivisor ;
} else {
return ( iDivisor - 1 ) + ( ( value + 1 ) % iDivisor ) ;
}
}
public long addWrapField ( long instant , int amount ) {
return set ( instant , FieldUtils . getWrappedValue ( get ( instant ) , amount , 0 , iDivisor - 1 ) ) ;
}
public long set ( long instant , int value ) {
FieldUtils . verifyValueBounds ( this , value , 0 , iDivisor - 1 ) ;
int divided = getDivided ( getWrappedField () . get ( instant ) ) ;
return getWrappedField () . set ( instant , divided * iDivisor + value ) ;
}
@Override
public DurationField getDurationField () {
return iDurationField ;
}
public DurationField getRangeDurationField () {
return iRangeField ;
}
public int getMinimumValue () {
return 0 ;
}
public int getMaximumValue () {
return iDivisor - 1 ;
}
public long roundFloor ( long instant ) {
return getWrappedField () . roundFloor ( instant ) ;
}
public long roundCeiling ( long instant ) {
return getWrappedField () . roundCeiling ( instant ) ;
}
public long roundHalfFloor ( long instant ) {
return getWrappedField () . roundHalfFloor ( instant ) ;
}
public long roundHalfCeiling ( long instant ) {
return getWrappedField () . roundHalfCeiling ( instant ) ;
}
public long roundHalfEven ( long instant ) {
return getWrappedField () . roundHalfEven ( instant ) ;
}
public long remainder ( long instant ) {
return getWrappedField () . remainder ( instant ) ;
}
public int getDivisor () {
return iDivisor ;
}
private int getDivided ( int value ) {
if ( value >= 0 ) {
return value / iDivisor ;
} else {
return ( ( value + 1 ) / iDivisor ) - 1 ;
}
}
