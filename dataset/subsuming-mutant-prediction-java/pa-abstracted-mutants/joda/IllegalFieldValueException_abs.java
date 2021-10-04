private static String createMessage ( String fieldName , Number value ,
Number lowerBound , Number upperBound , String explain ) {
StringBuilder buf = new StringBuilder ()
. append ( lr_1 ) . append ( value ) . append ( lr_2 ) . append ( fieldName ) . append ( ' ' ) ;
if ( lowerBound == null ) {
if ( upperBound == null ) {
buf . append ( lr_3 ) ;
} else {
buf . append ( lr_4 ) . append ( upperBound ) ;
}
} else if ( upperBound == null ) {
buf . append ( lr_5 ) . append ( lowerBound ) ;
} else {
buf . append ( lr_6 )
. append ( lowerBound )
. append ( ',' )
. append ( upperBound )
. append ( ']' ) ;
}
if ( explain != null ) {
buf . append ( lr_7 ) . append ( explain ) ;
}
return buf . toString () ;
}
private static String createMessage ( String fieldName , String value ) {
StringBuffer buf = new StringBuffer () . append ( lr_1 ) ;
if ( value == null ) {
buf . append ( lr_8 ) ;
} else {
buf . append ( '"' ) ;
buf . append ( value ) ;
buf . append ( '"' ) ;
}
buf . append ( lr_2 ) . append ( fieldName ) . append ( ' ' ) . append ( lr_3 ) ;
return buf . toString () ;
}
public DateTimeFieldType getDateTimeFieldType () {
return iDateTimeFieldType ;
}
public DurationFieldType getDurationFieldType () {
return iDurationFieldType ;
}
public String getFieldName () {
return iFieldName ;
}
public Number getIllegalNumberValue () {
return iNumberValue ;
}
public String getIllegalStringValue () {
return iStringValue ;
}
public String getIllegalValueAsString () {
String value = iStringValue ;
if ( value == null ) {
value = String . valueOf ( iNumberValue ) ;
}
return value ;
}
public Number getLowerBound () {
return iLowerBound ;
}
public Number getUpperBound () {
return iUpperBound ;
}
public String getMessage () {
return iMessage ;
}
public void prependMessage ( String message ) {
if ( iMessage == null ) {
iMessage = message ;
} else if ( message != null ) {
iMessage = message + lr_7 + iMessage ;
}
}
