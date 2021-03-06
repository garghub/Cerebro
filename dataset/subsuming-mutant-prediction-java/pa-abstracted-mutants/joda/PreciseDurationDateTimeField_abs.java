public boolean isLenient () {
return false ;
}
public long set ( long instant , int value ) {
FieldUtils . verifyValueBounds ( this , value , getMinimumValue () ,
getMaximumValueForSet ( instant , value ) ) ;
return instant + ( value - get ( instant ) ) * iUnitMillis ;
}
public long roundFloor ( long instant ) {
if ( instant >= 0 ) {
return instant - instant % iUnitMillis ;
} else {
instant += 1 ;
return instant - instant % iUnitMillis - iUnitMillis ;
}
}
public long roundCeiling ( long instant ) {
if ( instant > 0 ) {
instant -= 1 ;
return instant - instant % iUnitMillis + iUnitMillis ;
} else {
return instant - instant % iUnitMillis ;
}
}
public long remainder ( long instant ) {
if ( instant >= 0 ) {
return instant % iUnitMillis ;
} else {
return ( instant + 1 ) % iUnitMillis + iUnitMillis - 1 ;
}
}
public DurationField getDurationField () {
return iUnitField ;
}
public int getMinimumValue () {
return 0 ;
}
public final long getUnitMillis () {
return iUnitMillis ;
}
protected int getMaximumValueForSet ( long instant , int value ) {
return getMaximumValue ( instant ) ;
}
