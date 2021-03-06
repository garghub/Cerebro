public int get ( long instant ) {
return super . get ( instant ) + iOffset ;
}
public long add ( long instant , int amount ) {
instant = super . add ( instant , amount ) ;
FieldUtils . verifyValueBounds ( this , get ( instant ) , iMin , iMax ) ;
return instant ;
}
public long add ( long instant , long amount ) {
instant = super . add ( instant , amount ) ;
FieldUtils . verifyValueBounds ( this , get ( instant ) , iMin , iMax ) ;
return instant ;
}
public long addWrapField ( long instant , int amount ) {
return set ( instant , FieldUtils . getWrappedValue ( get ( instant ) , amount , iMin , iMax ) ) ;
}
public long set ( long instant , int value ) {
FieldUtils . verifyValueBounds ( this , value , iMin , iMax ) ;
return super . set ( instant , value - iOffset ) ;
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
return iMin ;
}
public int getMaximumValue () {
return iMax ;
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
public int getOffset () {
return iOffset ;
}
