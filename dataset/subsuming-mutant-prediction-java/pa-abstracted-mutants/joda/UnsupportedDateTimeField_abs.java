public static synchronized UnsupportedDateTimeField getInstance (
DateTimeFieldType type , DurationField durationField ) {
UnsupportedDateTimeField field ;
if ( cCache == null ) {
cCache = new HashMap < DateTimeFieldType , UnsupportedDateTimeField > ( 7 ) ;
field = null ;
} else {
field = cCache . get ( type ) ;
if ( field != null && field . getDurationField () != durationField ) {
field = null ;
}
}
if ( field == null ) {
field = new UnsupportedDateTimeField ( type , durationField ) ;
cCache . put ( type , field ) ;
}
return field ;
}
public DateTimeFieldType getType () {
return iType ;
}
public String getName () {
return iType . getName () ;
}
public boolean isSupported () {
return false ;
}
public boolean isLenient () {
return false ;
}
public int get ( long instant ) {
throw unsupported () ;
}
public String getAsText ( long instant , Locale locale ) {
throw unsupported () ;
}
public String getAsText ( long instant ) {
throw unsupported () ;
}
public String getAsText ( ReadablePartial partial , int fieldValue , Locale locale ) {
throw unsupported () ;
}
public String getAsText ( ReadablePartial partial , Locale locale ) {
throw unsupported () ;
}
public String getAsText ( int fieldValue , Locale locale ) {
throw unsupported () ;
}
public String getAsShortText ( long instant , Locale locale ) {
throw unsupported () ;
}
public String getAsShortText ( long instant ) {
throw unsupported () ;
}
public String getAsShortText ( ReadablePartial partial , int fieldValue , Locale locale ) {
throw unsupported () ;
}
public String getAsShortText ( ReadablePartial partial , Locale locale ) {
throw unsupported () ;
}
public String getAsShortText ( int fieldValue , Locale locale ) {
throw unsupported () ;
}
public long add ( long instant , int value ) {
return getDurationField () . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return getDurationField () . add ( instant , value ) ;
}
public int [] add ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
throw unsupported () ;
}
public int [] addWrapPartial ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
throw unsupported () ;
}
public long addWrapField ( long instant , int value ) {
throw unsupported () ;
}
public int [] addWrapField ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
throw unsupported () ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return getDurationField () . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return getDurationField () . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public long set ( long instant , int value ) {
throw unsupported () ;
}
public int [] set ( ReadablePartial instant , int fieldIndex , int [] values , int newValue ) {
throw unsupported () ;
}
public long set ( long instant , String text , Locale locale ) {
throw unsupported () ;
}
public long set ( long instant , String text ) {
throw unsupported () ;
}
public int [] set ( ReadablePartial instant , int fieldIndex , int [] values , String text , Locale locale ) {
throw unsupported () ;
}
public DurationField getDurationField () {
return iDurationField ;
}
public DurationField getRangeDurationField () {
return null ;
}
public boolean isLeap ( long instant ) {
throw unsupported () ;
}
public int getLeapAmount ( long instant ) {
throw unsupported () ;
}
public DurationField getLeapDurationField () {
return null ;
}
public int getMinimumValue () {
throw unsupported () ;
}
public int getMinimumValue ( long instant ) {
throw unsupported () ;
}
public int getMinimumValue ( ReadablePartial instant ) {
throw unsupported () ;
}
public int getMinimumValue ( ReadablePartial instant , int [] values ) {
throw unsupported () ;
}
public int getMaximumValue () {
throw unsupported () ;
}
public int getMaximumValue ( long instant ) {
throw unsupported () ;
}
public int getMaximumValue ( ReadablePartial instant ) {
throw unsupported () ;
}
public int getMaximumValue ( ReadablePartial instant , int [] values ) {
throw unsupported () ;
}
public int getMaximumTextLength ( Locale locale ) {
throw unsupported () ;
}
public int getMaximumShortTextLength ( Locale locale ) {
throw unsupported () ;
}
public long roundFloor ( long instant ) {
throw unsupported () ;
}
public long roundCeiling ( long instant ) {
throw unsupported () ;
}
public long roundHalfFloor ( long instant ) {
throw unsupported () ;
}
public long roundHalfCeiling ( long instant ) {
throw unsupported () ;
}
public long roundHalfEven ( long instant ) {
throw unsupported () ;
}
public long remainder ( long instant ) {
throw unsupported () ;
}
public String toString () {
return lr_1 ;
}
private Object readResolve () {
return getInstance ( iType , iDurationField ) ;
}
private UnsupportedOperationException unsupported () {
return new UnsupportedOperationException ( iType + lr_2 ) ;
}
