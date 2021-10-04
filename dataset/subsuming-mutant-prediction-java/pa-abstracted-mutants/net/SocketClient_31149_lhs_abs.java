protected void _connectAction_ () throws IOException
{
_socket_ . setSoTimeout ( _timeout_ ) ;
_input_ = _socket_ . getInputStream () ;
_output_ = _socket_ . getOutputStream () ;
}
public void connect ( final InetAddress host , final int port )
throws SocketException , IOException
{
_hostname_ = null ;
_connect ( host , port , null , - 1 ) ;
}
public void connect ( final String hostname , final int port )
throws SocketException , IOException
{
_hostname_ = hostname ;
_connect ( InetAddress . getByName ( hostname ) , port , null , - 1 ) ;
}
public void connect ( final InetAddress host , final int port ,
final InetAddress localAddr , final int localPort )
throws SocketException , IOException
{
_hostname_ = null ;
_connect ( host , port , localAddr , localPort ) ;
}
private void _connect ( final InetAddress host , final int port , final InetAddress localAddr , final int localPort )
throws SocketException , IOException
{
_socket_ = _socketFactory_ . createSocket () ;
if ( receiveBufferSize != - 1 ) {
_socket_ . setReceiveBufferSize ( receiveBufferSize ) ;
}
if ( sendBufferSize != - 1 ) {
_socket_ . setSendBufferSize ( sendBufferSize ) ;
}
if ( localAddr != null ) {
_socket_ . bind ( new InetSocketAddress ( localAddr , localPort ) ) ;
}
_socket_ . connect ( new InetSocketAddress ( host , port ) , connectTimeout ) ;
_connectAction_ () ;
}
public void connect ( final String hostname , final int port ,
final InetAddress localAddr , final int localPort )
throws SocketException , IOException
{
_hostname_ = hostname ;
_connect ( InetAddress . getByName ( hostname ) , port , localAddr , localPort ) ;
}
public void connect ( final InetAddress host ) throws SocketException , IOException
{
_hostname_ = null ;
connect ( host , _defaultPort_ ) ;
}
public void connect ( final String hostname ) throws SocketException , IOException
{
connect ( hostname , _defaultPort_ ) ;
}
public void disconnect () throws IOException
{
closeQuietly ( _socket_ ) ;
closeQuietly ( _input_ ) ;
closeQuietly ( _output_ ) ;
_socket_ = null ;
_hostname_ = null ;
_input_ = null ;
_output_ = null ;
}
private void closeQuietly ( final Socket socket ) {
if ( socket != null ) {
try {
socket . close () ;
} catch ( final IOException e ) {
}
}
}
private void closeQuietly ( final Closeable close ) {
if ( close != null ) {
try {
close . close () ;
} catch ( final IOException e ) {
}
}
}
public boolean isConnected ()
{
if ( _socket_ == null ) {
return false ;
}
return _socket_ . isConnected () ;
}
@SuppressWarnings ( lr_1 )
public boolean isAvailable () {
if ( isConnected () ) {
try
{
if ( _socket_ . getInetAddress () == null ) {
return false ;
}
if ( _socket_ . getPort () == 0 ) {
return false ;
}
if ( _socket_ . getRemoteSocketAddress () == null ) {
return false ;
}
if ( _socket_ . isClosed () ) {
return false ;
}
if ( _socket_ . isInputShutdown () ) {
return false ;
}
if ( _socket_ . isOutputShutdown () ) {
return false ;
}
_socket_ . getInputStream () ;
_socket_ . getOutputStream () ;
}
catch ( final IOException ioex )
{
return false ;
}
return true ;
}
return false ;
}
public void setDefaultPort ( final int port )
{
_defaultPort_ = port ;
}
public int getDefaultPort ()
{
return _defaultPort_ ;
}
public void setDefaultTimeout ( final int timeout )
{
_timeout_ = timeout ;
}
public int getDefaultTimeout ()
{
return _timeout_ ;
}
public void setSoTimeout ( final int timeout ) throws SocketException
{
_socket_ . setSoTimeout ( timeout ) ;
}
public void setSendBufferSize ( final int size ) throws SocketException {
sendBufferSize = size ;
}
protected int getSendBufferSize () {
return sendBufferSize ;
}
public void setReceiveBufferSize ( final int size ) throws SocketException {
receiveBufferSize = size ;
}
protected int getReceiveBufferSize () {
return receiveBufferSize ;
}
public int getSoTimeout () throws SocketException
{
return _socket_ . getSoTimeout () ;
}
public void setTcpNoDelay ( final boolean on ) throws SocketException
{
_socket_ . setTcpNoDelay ( on ) ;
}
public boolean getTcpNoDelay () throws SocketException
{
return _socket_ . getTcpNoDelay () ;
}
public void setKeepAlive ( final boolean keepAlive ) throws SocketException {
_socket_ . setKeepAlive ( keepAlive ) ;
}
public boolean getKeepAlive () throws SocketException {
return _socket_ . getKeepAlive () ;
}
public void setSoLinger ( final boolean on , final int val ) throws SocketException
{
_socket_ . setSoLinger ( on , val ) ;
}
public int getSoLinger () throws SocketException
{
return _socket_ . getSoLinger () ;
}
public int getLocalPort ()
{
return _socket_ . getLocalPort () ;
}
public InetAddress getLocalAddress ()
{
return _socket_ . getLocalAddress () ;
}
public int getRemotePort ()
{
return _socket_ . getPort () ;
}
public InetAddress getRemoteAddress ()
{
return _socket_ . getInetAddress () ;
}
public boolean verifyRemote ( final Socket socket )
{
InetAddress host1 , host2 ;
host1 = socket . getInetAddress () ;
host2 = getRemoteAddress () ;
return host1 . equals ( host2 ) ;
}
public void setSocketFactory ( final SocketFactory factory )
{
if ( factory == null ) {
_socketFactory_ = DEFAULT_SOCKET_FACTORY ;
} else {
_socketFactory_ = factory ;
}
connProxy = null ; MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
}
public void setServerSocketFactory ( final ServerSocketFactory factory ) {
if ( factory == null ) {
_serverSocketFactory_ = DEFAULT_SERVER_SOCKET_FACTORY ;
} else {
_serverSocketFactory_ = factory ;
}
}
public void setConnectTimeout ( final int connectTimeout ) {
this . connectTimeout = connectTimeout ;
}
public int getConnectTimeout () {
return connectTimeout ;
}
public ServerSocketFactory getServerSocketFactory () {
return _serverSocketFactory_ ;
}
public void addProtocolCommandListener ( final ProtocolCommandListener listener ) {
getCommandSupport () . addProtocolCommandListener ( listener ) ;
}
public void removeProtocolCommandListener ( final ProtocolCommandListener listener ) {
getCommandSupport () . removeProtocolCommandListener ( listener ) ;
}
protected void fireReplyReceived ( final int replyCode , final String reply ) {
if ( getCommandSupport () . getListenerCount () > 0 ) {
getCommandSupport () . fireReplyReceived ( replyCode , reply ) ;
}
}
protected void fireCommandSent ( final String command , final String message ) {
if ( getCommandSupport () . getListenerCount () > 0 ) {
getCommandSupport () . fireCommandSent ( command , message ) ;
}
}
protected void createCommandSupport () {
commandSupport = new ProtocolCommandSupport ( this ) ;
}
protected ProtocolCommandSupport getCommandSupport () {
return commandSupport ;
}
public void setProxy ( final Proxy proxy ) {
setSocketFactory ( new DefaultSocketFactory ( proxy ) ) ;
connProxy = proxy ;
}
public Proxy getProxy () {
return connProxy ;
}
@Deprecated
public String getCharsetName () {
return charset . name () ;
}
public Charset getCharset () {
return charset ;
}
public void setCharset ( final Charset charset ) {
this . charset = charset ;
}
