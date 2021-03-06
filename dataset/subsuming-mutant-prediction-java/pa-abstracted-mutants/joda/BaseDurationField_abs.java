public final DurationFieldType getType () {
return iType ;
}
public final String getName () {
return iType . getName () ;
}
public final boolean isSupported () {
return true ;
}
public int getValue ( long duration ) {
return FieldUtils . safeToInt ( getValueAsLong ( duration ) ) ;
}
public long getValueAsLong ( long duration ) {
return duration / getUnitMillis () ;
}
public int getValue ( long duration , long instant ) {
return FieldUtils . safeToInt ( getValueAsLong ( duration , instant ) ) ;
}
public long getMillis ( int value ) {
return value * getUnitMillis () ;
}
public long getMillis ( long value ) {
return FieldUtils . safeMultiply ( value , getUnitMillis () ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return FieldUtils . safeToInt ( getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ) ;
}
public int compareTo ( DurationField otherField ) {
long otherMillis = otherField . getUnitMillis () ;
long thisMillis = getUnitMillis () ;
if ( thisMillis == otherMillis ) {
return 0 ;
}
if ( thisMillis < otherMillis ) {
return - 1 ;
} else {
return 1 ;
}
}
public String toString () {
return lr_1 + getName () + ']' ;
}
