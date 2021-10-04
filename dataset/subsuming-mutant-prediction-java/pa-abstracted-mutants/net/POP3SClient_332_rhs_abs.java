@Override MST[rv.ABSMutator]MSP[N]
protected void _connectAction_ () throws IOException
{
if ( isImplicit ) {
performSSLNegotiation () ;
}
super . _connectAction_ () ;
}
private void initSSLContext () throws IOException
{
if ( context == null )
{
context = SSLContextUtils . createSSLContext ( protocol , getKeyManager () , getTrustManager () ) ;
}
}
private void performSSLNegotiation () throws IOException
{
initSSLContext () ;
final SSLSocketFactory ssf = context . getSocketFactory () ;
final String host = _hostname_ != null ? _hostname_ : getRemoteAddress () . getHostAddress () ;
final int port = getRemotePort () ;
final SSLSocket socket =
( SSLSocket ) ssf . createSocket ( _socket_ , host , port , true ) ;
socket . setEnableSessionCreation ( true ) ;
socket . setUseClientMode ( true ) ;
if ( tlsEndpointChecking ) {
SSLSocketUtils . enableEndpointNameVerification ( socket ) ;
}
if ( protocols != null ) {
socket . setEnabledProtocols ( protocols ) ;
}
if ( suites != null ) {
socket . setEnabledCipherSuites ( suites ) ;
}
socket . startHandshake () ;
_socket_ = socket ;
_input_ = socket . getInputStream () ;
_output_ = socket . getOutputStream () ;
reader = new CRLFLineReader ( new InputStreamReader ( _input_ , _DEFAULT_ENCODING ) ) ;
writer = new BufferedWriter ( new OutputStreamWriter ( _output_ , _DEFAULT_ENCODING ) ) ;
if ( hostnameVerifier != null && ! hostnameVerifier . verify ( host , socket . getSession () ) ) {
throw new SSLHandshakeException ( lr_1 ) ;
}
}
private KeyManager getKeyManager ()
{
return keyManager ;
}
public void setKeyManager ( final KeyManager newKeyManager )
{
keyManager = newKeyManager ;
}
public void setEnabledCipherSuites ( final String [] cipherSuites )
{
suites = new String [ cipherSuites . length ] ;
System . arraycopy ( cipherSuites , 0 , suites , 0 , cipherSuites . length ) ;
}
public String [] getEnabledCipherSuites ()
{
if ( _socket_ instanceof SSLSocket )
{
return ( ( SSLSocket ) _socket_ ) . getEnabledCipherSuites () ;
}
return null ;
}
public void setEnabledProtocols ( final String [] protocolVersions )
{
protocols = new String [ protocolVersions . length ] ;
System . arraycopy ( protocolVersions , 0 , protocols , 0 , protocolVersions . length ) ;
}
public String [] getEnabledProtocols ()
{
if ( _socket_ instanceof SSLSocket )
{
return ( ( SSLSocket ) _socket_ ) . getEnabledProtocols () ;
}
return null ;
}
public boolean execTLS () throws SSLException , IOException
{
if ( sendCommand ( lr_2 ) != POP3Reply . OK )
{
return false ;
}
performSSLNegotiation () ;
return true ;
}
public TrustManager getTrustManager ()
{
return trustManager ;
}
public void setTrustManager ( final TrustManager newTrustManager )
{
trustManager = newTrustManager ;
}
public HostnameVerifier getHostnameVerifier ()
{
return hostnameVerifier ;
}
public void setHostnameVerifier ( final HostnameVerifier newHostnameVerifier )
{
hostnameVerifier = newHostnameVerifier ;
}
public boolean isEndpointCheckingEnabled ()
{
return tlsEndpointChecking ;
}
public void setEndpointCheckingEnabled ( final boolean enable )
{
tlsEndpointChecking = enable ;
}
