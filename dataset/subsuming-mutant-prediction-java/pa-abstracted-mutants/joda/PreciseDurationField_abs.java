public final boolean isPrecise () {
return true ;
}
public final long getUnitMillis () {
return iUnitMillis ;
}
public long getValueAsLong ( long duration , long instant ) {
return duration / iUnitMillis ;
}
public long getMillis ( int value , long instant ) {
return value * iUnitMillis ;
}
public long getMillis ( long value , long instant ) {
return FieldUtils . safeMultiply ( value , iUnitMillis ) ;
}
public long add ( long instant , int value ) {
long addition = value * iUnitMillis ;
return FieldUtils . safeAdd ( instant , addition ) ;
}
public long add ( long instant , long value ) {
long addition = FieldUtils . safeMultiply ( value , iUnitMillis ) ;
return FieldUtils . safeAdd ( instant , addition ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
long difference = FieldUtils . safeSubtract ( minuendInstant , subtrahendInstant ) ;
return difference / iUnitMillis ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
} else if ( obj instanceof PreciseDurationField ) {
PreciseDurationField other = ( PreciseDurationField ) obj ;
return ( getType () == other . getType () ) && ( iUnitMillis == other . iUnitMillis ) ;
}
return false ;
}
public int hashCode () {
long millis = iUnitMillis ;
int hash = (int) ( millis ^ ( millis >>> 32 ) ) ;
hash += getType () . hashCode () ;
return hash ;
}
