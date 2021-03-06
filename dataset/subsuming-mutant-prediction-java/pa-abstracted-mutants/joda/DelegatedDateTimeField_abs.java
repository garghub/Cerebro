public final DateTimeField getWrappedField () {
return iField ;
}
public DateTimeFieldType getType () {
return iType ;
}
public String getName () {
return iType . getName () ;
}
public boolean isSupported () {
return iField . isSupported () ;
}
public boolean isLenient () {
return iField . isLenient () ;
}
public int get ( long instant ) {
return iField . get ( instant ) ;
}
public String getAsText ( long instant , Locale locale ) {
return iField . getAsText ( instant , locale ) ;
}
public String getAsText ( long instant ) {
return iField . getAsText ( instant ) ;
}
public String getAsText ( ReadablePartial partial , int fieldValue , Locale locale ) {
return iField . getAsText ( partial , fieldValue , locale ) ;
}
public String getAsText ( ReadablePartial partial , Locale locale ) {
return iField . getAsText ( partial , locale ) ;
}
public String getAsText ( int fieldValue , Locale locale ) {
return iField . getAsText ( fieldValue , locale ) ;
}
public String getAsShortText ( long instant , Locale locale ) {
return iField . getAsShortText ( instant , locale ) ;
}
public String getAsShortText ( long instant ) {
return iField . getAsShortText ( instant ) ;
}
public String getAsShortText ( ReadablePartial partial , int fieldValue , Locale locale ) {
return iField . getAsShortText ( partial , fieldValue , locale ) ;
}
public String getAsShortText ( ReadablePartial partial , Locale locale ) {
return iField . getAsShortText ( partial , locale ) ;
}
public String getAsShortText ( int fieldValue , Locale locale ) {
return iField . getAsShortText ( fieldValue , locale ) ;
}
public long add ( long instant , int value ) {
return iField . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return iField . add ( instant , value ) ;
}
public int [] add ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
return iField . add ( instant , fieldIndex , values , valueToAdd ) ;
}
public int [] addWrapPartial ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
return iField . addWrapPartial ( instant , fieldIndex , values , valueToAdd ) ;
}
public long addWrapField ( long instant , int value ) {
return iField . addWrapField ( instant , value ) ;
}
public int [] addWrapField ( ReadablePartial instant , int fieldIndex , int [] values , int valueToAdd ) {
return iField . addWrapField ( instant , fieldIndex , values , valueToAdd ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return iField . getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return iField . getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
public long set ( long instant , int value ) {
return iField . set ( instant , value ) ;
}
public long set ( long instant , String text , Locale locale ) {
return iField . set ( instant , text , locale ) ;
}
public long set ( long instant , String text ) {
return iField . set ( instant , text ) ;
}
public int [] set ( ReadablePartial instant , int fieldIndex , int [] values , int newValue ) {
return iField . set ( instant , fieldIndex , values , newValue ) ;
}
public int [] set ( ReadablePartial instant , int fieldIndex , int [] values , String text , Locale locale ) {
return iField . set ( instant , fieldIndex , values , text , locale ) ;
}
public DurationField getDurationField () {
return iField . getDurationField () ;
}
public DurationField getRangeDurationField () {
if ( iRangeDurationField != null ) {
return iRangeDurationField ;
}
return iField . getRangeDurationField () ;
}
public boolean isLeap ( long instant ) {
return iField . isLeap ( instant ) ;
}
public int getLeapAmount ( long instant ) {
return iField . getLeapAmount ( instant ) ;
}
public DurationField getLeapDurationField () {
return iField . getLeapDurationField () ;
}
public int getMinimumValue () {
return iField . getMinimumValue () ;
}
public int getMinimumValue ( long instant ) {
return iField . getMinimumValue ( instant ) ;
}
public int getMinimumValue ( ReadablePartial instant ) {
return iField . getMinimumValue ( instant ) ;
}
public int getMinimumValue ( ReadablePartial instant , int [] values ) {
return iField . getMinimumValue ( instant , values ) ;
}
public int getMaximumValue () {
return iField . getMaximumValue () ;
}
public int getMaximumValue ( long instant ) {
return iField . getMaximumValue ( instant ) ;
}
public int getMaximumValue ( ReadablePartial instant ) {
return iField . getMaximumValue ( instant ) ;
}
public int getMaximumValue ( ReadablePartial instant , int [] values ) {
return iField . getMaximumValue ( instant , values ) ;
}
public int getMaximumTextLength ( Locale locale ) {
return iField . getMaximumTextLength ( locale ) ;
}
public int getMaximumShortTextLength ( Locale locale ) {
return iField . getMaximumShortTextLength ( locale ) ;
}
public long roundFloor ( long instant ) {
return iField . roundFloor ( instant ) ;
}
public long roundCeiling ( long instant ) {
return iField . roundCeiling ( instant ) ;
}
public long roundHalfFloor ( long instant ) {
return iField . roundHalfFloor ( instant ) ;
}
public long roundHalfCeiling ( long instant ) {
return iField . roundHalfCeiling ( instant ) ;
}
public long roundHalfEven ( long instant ) {
return iField . roundHalfEven ( instant ) ;
}
public long remainder ( long instant ) {
return iField . remainder ( instant ) ;
}
public String toString () {
return ( lr_1 + getName () + ']' ) ;
}
