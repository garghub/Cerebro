public void open () throws SocketException
{
_socket_ = _socketFactory_ . createDatagramSocket () ;
_socket_ . setSoTimeout ( _timeout_ ) ;
_isOpen_ = true ;
}
public void open ( final int port ) throws SocketException
{
_socket_ = _socketFactory_ . createDatagramSocket ( port ) ;
_socket_ . setSoTimeout ( _timeout_ ) ;
_isOpen_ = true ;
}
public void open ( final int port , final InetAddress laddr ) throws SocketException
{
_socket_ = _socketFactory_ . createDatagramSocket ( port , laddr ) ;
_socket_ . setSoTimeout ( _timeout_ ) ;
_isOpen_ = true ;
}
public void close ()
{
if ( _socket_ != null ) {
_socket_ . close () ;
}
_socket_ = null ;
_isOpen_ = false ;
}
public boolean isOpen ()
{
return _isOpen_ ;
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
public int getSoTimeout () throws SocketException
{
return _socket_ . getSoTimeout () ;
}
public int getLocalPort ()
{
return _socket_ . getLocalPort () ;
}
public InetAddress getLocalAddress ()
{
return _socket_ . getLocalAddress () ;
}
public void setDatagramSocketFactory ( final DatagramSocketFactory factory )
{
if ( factory == null ) {
_socketFactory_ = DEFAULT_SOCKET_FACTORY ;
} else {
_socketFactory_ = factory ;
}
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
