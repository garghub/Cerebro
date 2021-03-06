@Override
public void checkClientTrusted ( final X509Certificate [] certificates , final String authType )
{
return;
}
@Override
public void checkServerTrusted ( final X509Certificate [] certificates , final String authType )
throws CertificateException
{
if ( checkServerValidity ) {
for ( final X509Certificate certificate : certificates )
{
certificate . checkValidity () ;
}
}
}
@Override
public X509Certificate [] getAcceptedIssuers ()
{
return EMPTY_X509CERTIFICATE_ARRAY ;
}
public static X509TrustManager getAcceptAllTrustManager () {
return ACCEPT_ALL ;
}
public static X509TrustManager getValidateServerCertificateTrustManager () {
return CHECK_SERVER_VALIDITY ;
}
public static X509TrustManager getDefaultTrustManager ( final KeyStore keyStore ) throws GeneralSecurityException {
final String defaultAlgorithm = TrustManagerFactory . getDefaultAlgorithm () ;
final TrustManagerFactory instance = TrustManagerFactory . getInstance ( defaultAlgorithm ) ;
instance . init ( keyStore ) ;
return ( X509TrustManager ) instance . getTrustManagers () [ 0 ] ;
}
