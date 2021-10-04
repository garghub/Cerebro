public void setAuthValue ( final String auth ) {
this . auth = auth ;
}
public String getAuthValue () {
return this . auth ;
}
@Override
protected void _connectAction_ () throws IOException {
if ( isImplicit ) {
sslNegotiation () ;
}
super . _connectAction_ () ;
if ( ! isImplicit ) {
execAUTH () ;
sslNegotiation () ;
}
}
protected void execAUTH () throws SSLException , IOException {
final int replyCode = sendCommand ( CMD_AUTH , auth ) ;
if ( FTPReply . SECURITY_MECHANISM_IS_OK == replyCode ) {
} else if ( FTPReply . SECURITY_DATA_EXCHANGE_COMPLETE != replyCode ) {
throw new SSLException ( getReplyString () ) ;
}
}
private void initSslContext () throws IOException {
if ( context == null ) {
context = SSLContextUtils . createSSLContext ( protocol , getKeyManager () , getTrustManager () ) ;
}
}
protected void sslNegotiation () throws IOException {
plainSocket = _socket_ ;
initSslContext () ;
final SSLSocket socket = ( SSLSocket ) createSSLSocket ( _socket_ ) ;
socket . setEnableSessionCreation ( isCreation ) ;
socket . setUseClientMode ( isClientMode ) ;
if ( isClientMode ) {
if ( tlsEndpointChecking ) {
SSLSocketUtils . enableEndpointNameVerification ( socket ) ;
}
} else {
socket . setNeedClientAuth ( isNeedClientAuth ) ;
socket . setWantClientAuth ( isWantClientAuth ) ;
}
if ( protocols != null ) {
socket . setEnabledProtocols ( protocols ) ;
}
if ( suites != null ) {
socket . setEnabledCipherSuites ( suites ) ;
}
socket . startHandshake () ;
_socket_ = socket ;
_controlInput_ = new BufferedReader ( new InputStreamReader (
socket . getInputStream () , getControlEncoding () ) ) ;
_controlOutput_ = new BufferedWriter ( new OutputStreamWriter (
socket . getOutputStream () , getControlEncoding () ) ) ;
if ( isClientMode ) {
if ( hostnameVerifier != null &&
! hostnameVerifier . verify ( _hostname_ , socket . getSession () ) ) {
throw new SSLHandshakeException ( lr_1 ) ;
}
}
}
private KeyManager getKeyManager () {
return keyManager ;
}
public void setKeyManager ( final KeyManager keyManager ) {
this . keyManager = keyManager ;
}
public void setEnabledSessionCreation ( final boolean isCreation ) {
this . isCreation = isCreation ;
}
public boolean getEnableSessionCreation () {
if ( _socket_ instanceof SSLSocket ) {
return ( ( SSLSocket ) _socket_ ) . getEnableSessionCreation () ;
}
return false ;
}
public void setNeedClientAuth ( final boolean isNeedClientAuth ) {
this . isNeedClientAuth = isNeedClientAuth ;
}
public boolean getNeedClientAuth () {
if ( _socket_ instanceof SSLSocket ) {
return ( ( SSLSocket ) _socket_ ) . getNeedClientAuth () ;
}
return false ;
}
public void setWantClientAuth ( final boolean isWantClientAuth ) { MST[BooleanTrueReturnValsMutator]MSP[]
this . isWantClientAuth = isWantClientAuth ;
}
public boolean getWantClientAuth () {
if ( _socket_ instanceof SSLSocket ) {
return ( ( SSLSocket ) _socket_ ) . getWantClientAuth () ;
}
return false ;
}
public void setUseClientMode ( final boolean isClientMode ) {
this . isClientMode = isClientMode ;
}
public boolean getUseClientMode () {
if ( _socket_ instanceof SSLSocket ) {
return ( ( SSLSocket ) _socket_ ) . getUseClientMode () ;
}
return false ;
}
public void setEnabledCipherSuites ( final String [] cipherSuites ) {
suites = new String [ cipherSuites . length ] ;
System . arraycopy ( cipherSuites , 0 , suites , 0 , cipherSuites . length ) ;
}
public String [] getEnabledCipherSuites () {
if ( _socket_ instanceof SSLSocket ) {
return ( ( SSLSocket ) _socket_ ) . getEnabledCipherSuites () ;
}
return null ;
}
public void setEnabledProtocols ( final String [] protocolVersions ) {
protocols = new String [ protocolVersions . length ] ;
System . arraycopy ( protocolVersions , 0 , protocols , 0 , protocolVersions . length ) ;
}
public String [] getEnabledProtocols () {
if ( _socket_ instanceof SSLSocket ) {
return ( ( SSLSocket ) _socket_ ) . getEnabledProtocols () ;
}
return null ;
}
public void execPBSZ ( final long pbsz ) throws SSLException , IOException {
if ( pbsz < 0 || 4294967295L < pbsz ) {
throw new IllegalArgumentException () ;
}
final int status = sendCommand ( CMD_PBSZ , String . valueOf ( pbsz ) ) ;
if ( FTPReply . COMMAND_OK != status ) {
throw new SSLException ( getReplyString () ) ;
}
}
public long parsePBSZ ( final long pbsz ) throws SSLException , IOException {
execPBSZ ( pbsz ) ;
long minvalue = pbsz ;
final String remainder = extractPrefixedData ( lr_2 , getReplyString () ) ;
if ( remainder != null ) {
final long replysz = Long . parseLong ( remainder ) ;
if ( replysz < minvalue ) {
minvalue = replysz ;
}
}
return minvalue ;
}
public void execPROT ( String prot ) throws SSLException , IOException {
if ( prot == null ) {
prot = DEFAULT_PROT ;
}
if ( ! checkPROTValue ( prot ) ) {
throw new IllegalArgumentException () ;
}
if ( FTPReply . COMMAND_OK != sendCommand ( CMD_PROT , prot ) ) {
throw new SSLException ( getReplyString () ) ;
}
if ( DEFAULT_PROT . equals ( prot ) ) {
setSocketFactory ( null ) ;
setServerSocketFactory ( null ) ;
} else {
setSocketFactory ( new FTPSSocketFactory ( context ) ) ;
setServerSocketFactory ( new FTPSServerSocketFactory ( context ) ) ;
initSslContext () ;
}
}
private boolean checkPROTValue ( final String prot ) {
for ( final String element : PROT_COMMAND_VALUE )
{
if ( element . equals ( prot ) ) {
return true ;
}
}
return false ;
}
@Override
public int sendCommand ( final String command , final String args ) throws IOException {
final int repCode = super . sendCommand ( command , args ) ;
if ( CMD_CCC . equals ( command ) ) {
if ( FTPReply . COMMAND_OK == repCode ) {
_socket_ . close () ;
_socket_ = plainSocket ;
_controlInput_ = new BufferedReader (
new InputStreamReader (
_socket_ . getInputStream () , getControlEncoding () ) ) ;
_controlOutput_ = new BufferedWriter (
new OutputStreamWriter (
_socket_ . getOutputStream () , getControlEncoding () ) ) ;
} else {
throw new SSLException ( getReplyString () ) ;
}
}
return repCode ;
}
@Override
@Deprecated
protected Socket _openDataConnection_ ( final int command , final String arg )
throws IOException {
return _openDataConnection_ ( FTPCommand . getCommand ( command ) , arg ) ;
}
@Override
protected Socket _openDataConnection_ ( final String command , final String arg )
throws IOException {
final Socket socket = super . _openDataConnection_ ( command , arg ) ;
_prepareDataSocket_ ( socket ) ;
if ( socket instanceof SSLSocket ) {
final SSLSocket sslSocket = ( SSLSocket ) socket ;
sslSocket . setUseClientMode ( isClientMode ) ;
sslSocket . setEnableSessionCreation ( isCreation ) ;
if ( ! isClientMode ) {
sslSocket . setNeedClientAuth ( isNeedClientAuth ) ;
sslSocket . setWantClientAuth ( isWantClientAuth ) ;
}
if ( suites != null ) {
sslSocket . setEnabledCipherSuites ( suites ) ;
}
if ( protocols != null ) {
sslSocket . setEnabledProtocols ( protocols ) ;
}
sslSocket . startHandshake () ;
}
return socket ;
}
protected void _prepareDataSocket_ ( final Socket socket )
throws IOException {
}
public TrustManager getTrustManager () {
return trustManager ;
}
public void setTrustManager ( final TrustManager trustManager ) {
this . trustManager = trustManager ;
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
@Override
public void disconnect () throws IOException
{
super . disconnect () ;
if ( plainSocket != null ) {
plainSocket . close () ;
}
setSocketFactory ( null ) ;
setServerSocketFactory ( null ) ;
}
public int execAUTH ( final String mechanism ) throws IOException
{
return sendCommand ( CMD_AUTH , mechanism ) ;
}
public int execADAT ( final byte [] data ) throws IOException
{
if ( data != null )
{
return sendCommand ( CMD_ADAT , Base64 . encodeBase64StringUnChunked ( data ) ) ;
}
return sendCommand ( CMD_ADAT ) ;
}
public int execCCC () throws IOException
{
final int repCode = sendCommand ( CMD_CCC ) ;
return repCode ;
}
public int execMIC ( final byte [] data ) throws IOException
{
if ( data != null )
{
return sendCommand ( CMD_MIC , Base64 . encodeBase64StringUnChunked ( data ) ) ;
}
return sendCommand ( CMD_MIC , lr_3 ) ;
}
public int execCONF ( final byte [] data ) throws IOException
{
if ( data != null )
{
return sendCommand ( CMD_CONF , Base64 . encodeBase64StringUnChunked ( data ) ) ;
}
return sendCommand ( CMD_CONF , lr_3 ) ;
}
public int execENC ( final byte [] data ) throws IOException
{
if ( data != null )
{
return sendCommand ( CMD_ENC , Base64 . encodeBase64StringUnChunked ( data ) ) ;
}
return sendCommand ( CMD_ENC , lr_3 ) ;
}
public byte [] parseADATReply ( final String reply )
{
if ( reply == null ) {
return null ;
}
return Base64 . decodeBase64 ( extractPrefixedData ( lr_4 , reply ) ) ;
}
private String extractPrefixedData ( final String prefix , final String reply ) {
final int idx = reply . indexOf ( prefix ) ;
if ( idx == - 1 ) {
return null ;
}
return reply . substring ( idx + prefix . length () ) . trim () ;
}
private Socket createSSLSocket ( final Socket socket ) throws IOException {
if ( socket != null ) {
final SSLSocketFactory f = context . getSocketFactory () ;
return f . createSocket ( socket , _hostname_ , socket . getPort () , false ) ;
}
return null ;
}
