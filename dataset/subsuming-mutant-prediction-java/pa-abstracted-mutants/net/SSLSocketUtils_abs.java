public static boolean enableEndpointNameVerification ( final SSLSocket socket ) {
try {
final Class < ? > cls = Class . forName ( lr_1 ) ;
final Method setEndpointIdentificationAlgorithm = cls
. getDeclaredMethod ( lr_2 , String . class ) ;
final Method getSSLParameters = SSLSocket . class . getDeclaredMethod ( lr_3 ) ;
final Method setSSLParameters = SSLSocket . class . getDeclaredMethod ( lr_4 , cls ) ;
if ( setEndpointIdentificationAlgorithm != null && getSSLParameters != null && setSSLParameters != null ) {
final Object sslParams = getSSLParameters . invoke ( socket ) ;
if ( sslParams != null ) {
setEndpointIdentificationAlgorithm . invoke ( sslParams , lr_5 ) ;
setSSLParameters . invoke ( socket , sslParams ) ;
return true ;
}
}
} catch ( final SecurityException e ) {
} catch ( final ClassNotFoundException e ) {
} catch ( final NoSuchMethodException e ) {
} catch ( final IllegalArgumentException e ) {
} catch ( final IllegalAccessException e ) {
} catch ( final InvocationTargetException e ) {
}
return false ;
}
