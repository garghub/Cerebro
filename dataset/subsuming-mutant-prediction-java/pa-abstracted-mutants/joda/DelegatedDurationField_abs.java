public final DurationField getWrappedField () {
return iField ;
}
public DurationFieldType getType () {
return iType ;
}
public String getName () {
return iType . getName () ;
}
public boolean isSupported () {
return iField . isSupported () ;
}
public boolean isPrecise () {
return iField . isPrecise () ;
}
public int getValue ( long duration ) {
return iField . getValue ( duration ) ;
}
public long getValueAsLong ( long duration ) {
return iField . getValueAsLong ( duration ) ;
}
public int getValue ( long duration , long instant ) {
return iField . getValue ( duration , instant ) ;
}
public long getValueAsLong ( long duration , long instant ) {
return iField . getValueAsLong ( duration , instant ) ;
}
public long getMillis ( int value ) {
return iField . getMillis ( value ) ;
}
public long getMillis ( long value ) {
return iField . getMillis ( value ) ;
}
public long getMillis ( int value , long instant ) {
return iField . getMillis ( value , instant ) ;
}
public long getMillis ( long value , long instant ) {
return iField . getMillis ( value , instant ) ;
}
public long add ( long instant , int value ) {
return iField . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return iField . add ( instant , value ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return iField . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return iField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public long getUnitMillis () {
return iField . getUnitMillis () ;
}
public int compareTo ( DurationField durationField ) {
return iField . compareTo ( durationField ) ;
}
public boolean equals ( Object obj ) {
if ( obj instanceof DelegatedDurationField ) {
return iField . equals ( ( ( DelegatedDurationField ) obj ) . iField ) ;
}
return false ;
}
public int hashCode () {
return iField . hashCode () ^ iType . hashCode () ;
}
public String toString () {
return ( iType == null ) ? iField . toString () :
( lr_1 + iType + ']' ) ;
}
