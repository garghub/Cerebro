public int get ( long instant ) {
int value = getWrappedField () . get ( instant ) ;
if ( value == 0 ) {
value = getMaximumValue () ;
}
return value ;
}
public long add ( long instant , int value ) {
return getWrappedField () . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return getWrappedField () . add ( instant , value ) ;
}
public long addWrapField ( long instant , int value ) {
return getWrappedField () . addWrapField ( instant , value ) ;
}
public int [] addWrapField ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
return getWrappedField () . addWrapField ( instant , fieldIndex , values , valueToAdd ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return getWrappedField () . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return getWrappedField () . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public long set ( long instant , int value ) {
int max = getMaximumValue () ;
FieldUtils . verifyValueBounds ( this , value , 1 , max ) ;
if ( value == max ) {
value = 0 ;
}
return getWrappedField () . set ( instant , value ) ;
}
public boolean isLeap ( long instant ) {
return getWrappedField () . isLeap ( instant ) ;
}
public int getLeapAmount ( long instant ) {
return getWrappedField () . getLeapAmount ( instant ) ;
}
public DurationField getLeapDurationField () {
return getWrappedField () . getLeapDurationField () ;
}
public int getMinimumValue () {
return 1 ;
}
public int getMinimumValue ( long instant ) {
return 1 ;
}
public int getMinimumValue ( ReadablePartial instant ) {
return 1 ;
}
public int getMinimumValue ( ReadablePartial instant , int [] values ) {
return 1 ;
}
public int getMaximumValue () {
return getWrappedField () . getMaximumValue () + 1 ;
}
public int getMaximumValue ( long instant ) {
return getWrappedField () . getMaximumValue ( instant ) + 1 ;
}
public int getMaximumValue ( ReadablePartial instant ) {
return getWrappedField () . getMaximumValue ( instant ) + 1 ;
}
public int getMaximumValue ( ReadablePartial instant , int [] values ) {
return getWrappedField () . getMaximumValue ( instant , values ) + 1 ;
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
