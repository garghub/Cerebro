public int get ( long instant ) {
if ( instant >= 0 ) {
return (int) ( ( instant / getUnitMillis () ) % iRange ) ;
} else {
return iRange - 1 + (int) ( ( ( instant + 1 ) / getUnitMillis () ) % iRange ) ;
}
}
public long addWrapField ( long instant , int amount ) {
int thisValue = get ( instant ) ;
int wrappedValue = FieldUtils . getWrappedValue
( thisValue , amount , getMinimumValue () , getMaximumValue () ) ;
return instant + ( wrappedValue - thisValue ) * getUnitMillis () ;
}
public long set ( long instant , int value ) {
FieldUtils . verifyValueBounds ( this , value , getMinimumValue () , getMaximumValue () ) ;
return instant + ( value - get ( instant ) ) * iUnitMillis ;
}
public DurationField getRangeDurationField () {
return iRangeField ;
}
public int getMaximumValue () {
return iRange - 1 ;
}
public int getRange () {
return iRange ;
}
