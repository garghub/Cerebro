public static DateTimeField getInstance ( DateTimeField field ) {
if ( field == null ) {
return null ;
}
if ( field instanceof LenientDateTimeField ) {
field = ( ( LenientDateTimeField ) field ) . getWrappedField () ;
}
if ( ! field . isLenient () ) {
return field ;
}
return new StrictDateTimeField ( field ) ;
}
public final boolean isLenient () {
return false ;
}
public long set ( long instant , int value ) {
FieldUtils . verifyValueBounds
( this , value , getMinimumValue ( instant ) , getMaximumValue ( instant ) ) ;
return super . set ( instant , value ) ;
}
