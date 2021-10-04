public int getValue ( long duration ) {
return getWrappedField () . getValue ( duration ) / iScalar ;
}
public long getValueAsLong ( long duration ) {
return getWrappedField () . getValueAsLong ( duration ) / iScalar ;
}
public int getValue ( long duration , long instant ) {
return getWrappedField () . getValue ( duration , instant ) / iScalar ;
}
public long getValueAsLong ( long duration , long instant ) {
return getWrappedField () . getValueAsLong ( duration , instant ) / iScalar ;
}
public long getMillis ( int value ) {
long scaled = ( ( long ) value ) * ( ( long ) iScalar ) ;
return getWrappedField () . getMillis ( scaled ) ;
}
public long getMillis ( long value ) {
long scaled = FieldUtils . safeMultiply ( value , iScalar ) ;
return getWrappedField () . getMillis ( scaled ) ;
}
public long getMillis ( int value , long instant ) {
long scaled = ( ( long ) value ) * ( ( long ) iScalar ) ;
return getWrappedField () . getMillis ( scaled , instant ) ;
}
public long getMillis ( long value , long instant ) {
long scaled = FieldUtils . safeMultiply ( value , iScalar ) ;
return getWrappedField () . getMillis ( scaled , instant ) ;
}
public long add ( long instant , int value ) {
long scaled = ( ( long ) value ) * ( ( long ) iScalar ) ;
return getWrappedField () . add ( instant , scaled ) ;
}
public long add ( long instant , long value ) {
long scaled = FieldUtils . safeMultiply ( value , iScalar ) ;
return getWrappedField () . add ( instant , scaled ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return getWrappedField () . getDifference ( minuendInstant , subtrahendInstant ) / iScalar ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return getWrappedField () . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) / iScalar ;
}
public long getUnitMillis () {
return getWrappedField () . getUnitMillis () * iScalar ;
}
public int getScalar () {
return iScalar ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
} else if ( obj instanceof ScaledDurationField ) {
ScaledDurationField other = ( ScaledDurationField ) obj ;
return ( getWrappedField () . equals ( other . getWrappedField () ) ) &&
( getType () == other . getType () ) &&
( iScalar == other . iScalar ) ;
}
return false ;
}
public int hashCode () {
long scalar = iScalar ;
int hash = (int) ( scalar ^ ( scalar >>> 32 ) ) ;
hash += getType () . hashCode () ;
hash += getWrappedField () . hashCode () ;
return hash ;
}
