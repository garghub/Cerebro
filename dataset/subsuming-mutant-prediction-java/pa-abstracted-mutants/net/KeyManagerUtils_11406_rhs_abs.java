public static KeyManager createClientKeyManager ( final KeyStore ks , final String keyAlias , final String keyPass )
throws GeneralSecurityException
{
final ClientKeyStore cks = new ClientKeyStore ( ks , keyAlias != null ? keyAlias : findAlias ( ks ) , keyPass ) ;
return new X509KeyManager ( cks ) ;
}
public static KeyManager createClientKeyManager (
final String storeType , final File storePath , final String storePass , final String keyAlias , final String keyPass )
throws IOException , GeneralSecurityException
{
final KeyStore ks = loadStore ( storeType , storePath , storePass ) ;
return createClientKeyManager ( ks , keyAlias , keyPass ) ;
}
public static KeyManager createClientKeyManager ( final File storePath , final String storePass , final String keyAlias )
throws IOException , GeneralSecurityException
{
return createClientKeyManager ( DEFAULT_STORE_TYPE , storePath , storePass , keyAlias , storePass ) ;
}
public static KeyManager createClientKeyManager ( final File storePath , final String storePass )
throws IOException , GeneralSecurityException
{
return createClientKeyManager ( DEFAULT_STORE_TYPE , storePath , storePass , null , storePass ) ;
}
private static KeyStore loadStore ( final String storeType , final File storePath , final String storePass )
throws KeyStoreException , IOException , GeneralSecurityException {
final KeyStore ks = KeyStore . getInstance ( storeType ) ;
FileInputStream stream = null ;
try { MST[ConstructorCallMutator]MSP[S]
stream = new FileInputStream ( storePath ) ;
ks . load ( stream , storePass . toCharArray () ) ;
} finally {
Util . closeQuietly ( stream ) ;
}
return ks ;
}
private static String findAlias ( final KeyStore ks ) throws KeyStoreException {
final Enumeration < String > e = ks . aliases () ;
while( e . hasMoreElements () ) {
final String entry = e . nextElement () ;
if ( ks . isKeyEntry ( entry ) ) {
return entry ;
}
}
throw new KeyStoreException ( lr_1 ) ;
}
final X509Certificate [] getCertificateChain () {
return this . certChain ;
}
final PrivateKey getPrivateKey () {
return this . key ;
}
final String getAlias () {
return this . keyAlias ;
}
@Override
public String chooseClientAlias ( final String [] keyType , final Principal [] issuers ,
final Socket socket ) {
return keyStore . getAlias () ;
}
@Override
public X509Certificate [] getCertificateChain ( final String alias ) {
return keyStore . getCertificateChain () ;
}
@Override
public String [] getClientAliases ( final String keyType , final Principal [] issuers ) {
return new String [] { keyStore . getAlias () } ;
}
@Override
public PrivateKey getPrivateKey ( final String alias ) {
return keyStore . getPrivateKey () ;
}
@Override
public String [] getServerAliases ( final String keyType , final Principal [] issuers ) {
return null ;
}
@Override
public String chooseServerAlias ( final String keyType , final Principal [] issuers , final Socket socket ) {
return null ;
}
