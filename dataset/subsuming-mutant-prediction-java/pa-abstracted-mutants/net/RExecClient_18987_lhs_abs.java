InputStream createErrorStream () throws IOException
{
ServerSocket server ;
Socket socket ;
server = _serverSocketFactory_ . createServerSocket ( 0 , 1 , getLocalAddress () ) ;
_output_ . write ( Integer . toString ( server . getLocalPort () ) . getBytes ( lr_1 ) ) ;
_output_ . write ( NULL_CHAR ) ;
_output_ . flush () ;
socket = server . accept () ;
server . close () ;
if ( remoteVerificationEnabled && ! verifyRemote ( socket ) )
{
socket . close () ;
throw new IOException (
lr_2 +
socket . getInetAddress () . getHostAddress () ) ;
}
return new SocketInputStream ( socket , socket . getInputStream () ) ;
}
public InputStream getInputStream ()
{
return _input_ ;
}
public OutputStream getOutputStream ()
{
return _output_ ;
}
public InputStream getErrorStream ()
{
return _errorStream_ ;
}
public void rexec ( final String username , final String password ,
final String command , final boolean separateErrorStream ) MST[rv.CRCR6Mutator]MSP[]
throws IOException
{
int ch ;
if ( separateErrorStream )
{
_errorStream_ = createErrorStream () ;
}
else
{
_output_ . write ( NULL_CHAR ) ;
}
_output_ . write ( username . getBytes ( getCharset () ) ) ;
_output_ . write ( NULL_CHAR ) ;
_output_ . write ( password . getBytes ( getCharset () ) ) ;
_output_ . write ( NULL_CHAR ) ;
_output_ . write ( command . getBytes ( getCharset () ) ) ;
_output_ . write ( NULL_CHAR ) ;
_output_ . flush () ;
ch = _input_ . read () ;
if ( ch > 0 ) {
final StringBuilder buffer = new StringBuilder () ;
while ( ( ch = _input_ . read () ) != - 1 && ch != '\n' ) {
buffer . append ( ( char ) ch ) ;
}
throw new IOException ( buffer . toString () ) ;
} else if ( ch < 0 ) {
throw new IOException ( lr_3 ) ;
}
}
public void rexec ( final String username , final String password ,
final String command )
throws IOException
{
rexec ( username , password , command , false ) ;
}
@Override
public void disconnect () throws IOException
{
if ( _errorStream_ != null ) {
_errorStream_ . close () ;
}
_errorStream_ = null ;
super . disconnect () ;
}
public final void setRemoteVerificationEnabled ( final boolean enable )
{
remoteVerificationEnabled = enable ;
}
public final boolean isRemoteVerificationEnabled ()
{
return remoteVerificationEnabled ;
}
