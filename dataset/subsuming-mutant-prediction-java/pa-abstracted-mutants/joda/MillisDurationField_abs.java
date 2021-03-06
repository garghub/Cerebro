public DurationFieldType getType () {
return DurationFieldType . millis () ;
}
public String getName () {
return lr_1 ;
}
public boolean isSupported () {
return true ;
}
public final boolean isPrecise () {
return true ;
}
public final long getUnitMillis () {
return 1 ;
}
public int getValue ( long duration ) {
return FieldUtils . safeToInt ( duration ) ;
}
public long getValueAsLong ( long duration ) {
return duration ;
}
public int getValue ( long duration , long instant ) {
return FieldUtils . safeToInt ( duration ) ;
}
public long getValueAsLong ( long duration , long instant ) {
return duration ;
}
public long getMillis ( int value ) {
return value ;
}
public long getMillis ( long value ) {
return value ;
}
public long getMillis ( int value , long instant ) {
return value ;
}
public long getMillis ( long value , long instant ) {
return value ;
}
public long add ( long instant , int value ) {
return FieldUtils . safeAdd ( instant , value ) ;
}
public long add ( long instant , long value ) {
return FieldUtils . safeAdd ( instant , value ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return FieldUtils . safeToInt ( FieldUtils . safeSubtract ( minuendInstant , subtrahendInstant ) ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return FieldUtils . safeSubtract ( minuendInstant , subtrahendInstant ) ;
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
public boolean equals ( Object obj ) {
if ( obj instanceof MillisDurationField ) {
return getUnitMillis () == ( ( MillisDurationField ) obj ) . getUnitMillis () ;
}
return false ;
}
public int hashCode () {
return ( int ) getUnitMillis () ;
}
public String toString () {
return lr_2 ;
}
private Object readResolve () {
return INSTANCE ;
}
