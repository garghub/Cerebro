private static String createMessage ( long instantLocal , String zoneId ) {
String localDateTime = DateTimeFormat . forPattern ( lr_1 ) . print ( new Instant ( instantLocal ) ) ;
String zone = ( zoneId != null ? lr_2 + zoneId + lr_3 : lr_4 ) ;
return lr_5 + localDateTime + zone ;
}
public static boolean isIllegalInstant ( Throwable ex ) {
if ( ex instanceof IllegalInstantException ) {
return true ;
}
while ( ex . getCause () != null && ex . getCause () != ex ) {
return isIllegalInstant ( ex . getCause () ) ;
}
return false ;
}
