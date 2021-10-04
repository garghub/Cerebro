public static DateTimeField getInstance ( DateTimeField field , Chronology base ) {
if ( field == null ) {
return null ;
}
if ( field instanceof StrictDateTimeField ) {
field = ( ( StrictDateTimeField ) field ) . getWrappedField () ;
}
if ( field . isLenient () ) {
return field ;
}
return new LenientDateTimeField ( field , base ) ;
}
public final boolean isLenient () {
return true ;
}
public long set ( long instant , int value ) {
long localInstant = iBase . getZone () . convertUTCToLocal ( instant ) ;
long difference = FieldUtils . safeSubtract ( value , get ( instant ) ) ;
localInstant = getType () . getField ( iBase . withUTC () ) . add ( localInstant , difference ) ;
return iBase . getZone () . convertLocalToUTC ( localInstant , false , instant ) ;
}
