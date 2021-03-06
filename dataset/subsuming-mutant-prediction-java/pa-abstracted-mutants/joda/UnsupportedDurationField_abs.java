public static synchronized UnsupportedDurationField getInstance ( DurationFieldType type ) {
UnsupportedDurationField field ;
if ( cCache == null ) {
cCache = new HashMap < DurationFieldType , UnsupportedDurationField > ( 7 ) ;
field = null ;
} else {
field = cCache . get ( type ) ;
}
if ( field == null ) {
field = new UnsupportedDurationField ( type ) ;
cCache . put ( type , field ) ;
}
return field ;
}
public final DurationFieldType getType () {
return iType ;
}
public String getName () {
return iType . getName () ;
}
public boolean isSupported () {
return false ;
}
public boolean isPrecise () {
return true ;
}
public int getValue ( long duration ) {
throw unsupported () ;
}
public long getValueAsLong ( long duration ) {
throw unsupported () ;
}
public int getValue ( long duration , long instant ) {
throw unsupported () ;
}
public long getValueAsLong ( long duration , long instant ) {
throw unsupported () ;
}
public long getMillis ( int value ) {
throw unsupported () ;
}
public long getMillis ( long value ) {
throw unsupported () ;
}
public long getMillis ( int value , long instant ) {
throw unsupported () ;
}
public long getMillis ( long value , long instant ) {
throw unsupported () ;
}
public long add ( long instant , int value ) {
throw unsupported () ;
}
public long add ( long instant , long value ) {
throw unsupported () ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
throw unsupported () ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
throw unsupported () ;
}
public long getUnitMillis () {
return 0 ;
}
public int compareTo ( DurationField durationField ) {
return 0 ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
} else if ( obj instanceof UnsupportedDurationField ) {
UnsupportedDurationField other = ( UnsupportedDurationField ) obj ;
if ( other . getName () == null ) {
return ( getName () == null ) ;
}
return ( other . getName () . equals ( getName () ) ) ;
}
return false ;
}
public int hashCode () {
return getName () . hashCode () ;
}
public String toString () {
return lr_1 + getName () + ']' ;
}
private Object readResolve () {
return getInstance ( iType ) ;
}
private UnsupportedOperationException unsupported () {
return new UnsupportedOperationException ( iType + lr_2 ) ;
}
