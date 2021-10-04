@Override
@Deprecated
protected Socket _openDataConnection_ ( final int command , final String arg )
throws IOException {
return super . _openDataConnection_ ( command , arg ) ;
}
@Override
protected Socket _openDataConnection_ ( final String command , final String arg )
throws IOException {
if ( getDataConnectionMode () != PASSIVE_LOCAL_DATA_CONNECTION_MODE ) { MST[rv.UOI3Mutator]MSP[]
throw new IllegalStateException ( lr_1 ) ;
}
final boolean isInet6Address = getRemoteAddress () instanceof Inet6Address ;
String passiveHost = null ;
final boolean attemptEPSV = isUseEPSVwithIPv4 () || isInet6Address ;
if ( attemptEPSV && epsv () == FTPReply . ENTERING_EPSV_MODE ) {
_parseExtendedPassiveModeReply ( _replyLines . get ( 0 ) ) ;
passiveHost = this . tunnelHost ;
} else {
if ( isInet6Address ) {
return null ;
}
if ( pasv () != FTPReply . ENTERING_PASSIVE_MODE ) {
return null ;
}
_parsePassiveModeReply ( _replyLines . get ( 0 ) ) ;
passiveHost = this . getPassiveHost () ;
}
final Socket socket = _socketFactory_ . createSocket ( proxyHost , proxyPort ) ;
final InputStream is = socket . getInputStream () ;
final OutputStream os = socket . getOutputStream () ;
tunnelHandshake ( passiveHost , this . getPassivePort () , is , os ) ;
if ( getRestartOffset () > 0 && ! restart ( getRestartOffset () ) ) {
socket . close () ;
return null ;
}
if ( ! FTPReply . isPositivePreliminary ( sendCommand ( command , arg ) ) ) {
socket . close () ;
return null ;
}
return socket ;
}
@Override
public void connect ( final String host , final int port ) throws SocketException , IOException {
_socket_ = _socketFactory_ . createSocket ( proxyHost , proxyPort ) ;
_input_ = _socket_ . getInputStream () ;
_output_ = _socket_ . getOutputStream () ;
Reader socketIsReader ;
try {
socketIsReader = tunnelHandshake ( host , port , _input_ , _output_ ) ;
}
catch ( final Exception e ) {
final IOException ioe = new IOException ( lr_2 + host + lr_3 + port ) ;
ioe . initCause ( e ) ;
throw ioe ;
}
super . _connectAction_ ( socketIsReader ) ;
}
private BufferedReader tunnelHandshake ( final String host , final int port , final InputStream input ,
final OutputStream output ) throws IOException , UnsupportedEncodingException {
final String connectString = lr_4 + host + lr_5 + port + lr_6 ;
final String hostString = lr_7 + host + lr_5 + port ;
this . tunnelHost = host ;
output . write ( connectString . getBytes ( charset ) ) ;
output . write ( CRLF ) ;
output . write ( hostString . getBytes ( charset ) ) ;
output . write ( CRLF ) ;
if ( proxyUsername != null && proxyPassword != null ) {
final String auth = proxyUsername + lr_5 + proxyPassword ;
final String header = lr_8 + base64 . encodeToString ( auth . getBytes ( charset ) ) ;
output . write ( header . getBytes ( charset ) ) ;
}
output . write ( CRLF ) ;
final List < String > response = new ArrayList <> () ;
final BufferedReader reader = new BufferedReader ( new InputStreamReader ( input , getCharset () ) ) ;
for ( String line = reader . readLine () ; line != null && line . length () > 0 ; line = reader . readLine () ) {
response . add ( line ) ;
}
final int size = response . size () ;
if ( size == 0 ) {
throw new IOException ( lr_9 ) ;
}
String code = null ;
final String resp = response . get ( 0 ) ;
if ( resp . startsWith ( lr_10 ) && resp . length () >= 12 ) {
code = resp . substring ( 9 , 12 ) ;
} else {
throw new IOException ( lr_11 + resp ) ;
}
if ( ! lr_12 . equals ( code ) ) {
final StringBuilder msg = new StringBuilder () ;
msg . append ( lr_13 ) ;
msg . append ( lr_14 ) ;
for ( final String line : response ) {
msg . append ( line ) ;
msg . append ( lr_15 ) ;
}
throw new IOException ( msg . toString () ) ;
}
return reader ;
}
