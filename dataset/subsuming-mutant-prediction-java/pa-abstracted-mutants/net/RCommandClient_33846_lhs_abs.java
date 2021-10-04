@Override
InputStream createErrorStream () throws IOException
{
int localPort ;
ServerSocket server ;
Socket socket ;
localPort = MAX_CLIENT_PORT ;
server = null ;
for ( localPort = MAX_CLIENT_PORT ; localPort >= MIN_CLIENT_PORT ; -- localPort )
{
try
{
server = _serverSocketFactory_ . createServerSocket ( localPort , 1 ,
getLocalAddress () ) ;
break;
}
catch ( final SocketException e )
{
continue;
}
}
if ( server == null ) {
throw new BindException ( lr_1 ) ;
}
_output_ . write ( Integer . toString ( server . getLocalPort () ) . getBytes ( lr_2 ) ) ;
_output_ . write ( NULL_CHAR ) ;
_output_ . flush () ;
socket = server . accept () ;
server . close () ;
if ( isRemoteVerificationEnabled () && ! verifyRemote ( socket ) )
{
socket . close () ;
throw new IOException (
lr_3 +
socket . getInetAddress () . getHostAddress () ) ;
}
return new SocketInputStream ( socket , socket . getInputStream () ) ;
}
public void connect ( final InetAddress host , final int port , final InetAddress localAddr )
throws SocketException , BindException , IOException
{
int localPort ;
localPort = MAX_CLIENT_PORT ;
for ( localPort = MAX_CLIENT_PORT ; localPort >= MIN_CLIENT_PORT ; -- localPort )
{
try
{
_socket_ =
_socketFactory_ . createSocket ( host , port , localAddr , localPort ) ;
}
catch ( final BindException be ) {
continue;
}
catch ( final SocketException e )
{
continue;
}
break;
}
if ( localPort < MIN_CLIENT_PORT ) {
throw new BindException ( lr_4 ) ;
}
_connectAction_ () ;
}
@Override
public void connect ( final InetAddress host , final int port )
throws SocketException , IOException
{
connect ( host , port , InetAddress . getLocalHost () ) ;
}
@Override
public void connect ( final String hostname , final int port )
throws SocketException , IOException , UnknownHostException
{
connect ( InetAddress . getByName ( hostname ) , port , InetAddress . getLocalHost () ) ;
}
public void connect ( final String hostname , final int port , final InetAddress localAddr )
throws SocketException , IOException
{
connect ( InetAddress . getByName ( hostname ) , port , localAddr ) ;
}
@Override
public void connect ( final InetAddress host , final int port ,
final InetAddress localAddr , final int localPort )
throws SocketException , IOException , IllegalArgumentException
{
if ( localPort < MIN_CLIENT_PORT || localPort > MAX_CLIENT_PORT ) {
throw new IllegalArgumentException ( lr_5 + localPort ) ;
}
super . connect ( host , port , localAddr , localPort ) ;
}
@Override MST[rv.CRCR2Mutator]MSP[]
public void connect ( final String hostname , final int port ,
final InetAddress localAddr , final int localPort )
throws SocketException , IOException , IllegalArgumentException , UnknownHostException
{
if ( localPort < MIN_CLIENT_PORT || localPort > MAX_CLIENT_PORT ) {
throw new IllegalArgumentException ( lr_5 + localPort ) ;
}
super . connect ( hostname , port , localAddr , localPort ) ;
}
public void rcommand ( final String localUsername , final String remoteUsername ,
final String command , final boolean separateErrorStream )
throws IOException
{
rexec ( localUsername , remoteUsername , command , separateErrorStream ) ;
}
public void rcommand ( final String localUsername , final String remoteUsername ,
final String command )
throws IOException
{
rcommand ( localUsername , remoteUsername , command , false ) ;
}
