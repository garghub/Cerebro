@Override
public void checkClientTrusted ( final X509Certificate [] certificates , final String authType )
{
return;
}
@Override
public void checkServerTrusted ( final X509Certificate [] certificates , final String authType ) throws CertificateException
{
for ( final X509Certificate certificate : certificates )
{
certificate . checkValidity () ;
}
}
@Override
public X509Certificate [] getAcceptedIssuers ()
{
return EMPTY_X509CERTIFICATE_ARRAY ;
}
