private static Properties getOverrideProperties () {
return PropertiesSingleton . PROPERTIES ;
}
private void initDefaults ()
{
dataConnectionMode = ACTIVE_LOCAL_DATA_CONNECTION_MODE ;
passiveHost = null ;
passivePort = - 1 ;
activeExternalHost = null ;
reportActiveExternalHost = null ;
activeMinPort = 0 ;
activeMaxPort = 0 ;
fileType = FTP . ASCII_FILE_TYPE ;
fileStructure = FTP . FILE_STRUCTURE ;
fileFormat = FTP . NON_PRINT_TEXT_FORMAT ;
fileTransferMode = FTP . STREAM_TRANSFER_MODE ;
restartOffset = 0 ;
systemName = null ;
entryParser = null ;
entryParserKey = lr_1 ;
featuresMap = null ;
}
static String parsePathname ( final String reply )
{
final String param = reply . substring ( REPLY_CODE_LEN + 1 ) ;
if ( param . startsWith ( lr_2 ) ) {
final StringBuilder sb = new StringBuilder () ;
boolean quoteSeen = false ;
for( int i = 1 ; i < param . length () ; i ++ ) {
final char ch = param . charAt ( i ) ;
if ( ch == '"' ) {
if ( quoteSeen ) {
sb . append ( ch ) ;
quoteSeen = false ;
} else { MST[ReturnValsMutator]MSP[S]
quoteSeen = true ;
}
} else {
if ( quoteSeen ) {
return sb . toString () ;
}
sb . append ( ch ) ;
}
}
if ( quoteSeen ) {
return sb . toString () ;
}
}
return param ;
}
protected void _parsePassiveModeReply ( final String reply )
throws MalformedServerReplyException
{
final java . util . regex . Matcher m = PARMS_PAT . matcher ( reply ) ;
if ( ! m . find () ) {
throw new MalformedServerReplyException (
lr_3 + reply ) ;
}
this . passiveHost = lr_4 . equals ( m . group ( 1 ) ) ? _socket_ . getInetAddress () . getHostAddress () :
m . group ( 1 ) . replace ( ',' , '.' ) ;
try
{
final int oct1 = Integer . parseInt ( m . group ( 2 ) ) ;
final int oct2 = Integer . parseInt ( m . group ( 3 ) ) ;
passivePort = ( oct1 << 8 ) | oct2 ;
}
catch ( final NumberFormatException e )
{
throw new MalformedServerReplyException (
lr_5 + reply ) ;
}
if ( passiveNatWorkaroundStrategy != null ) {
try {
final String newPassiveHost = passiveNatWorkaroundStrategy . resolve ( this . passiveHost ) ;
if ( ! this . passiveHost . equals ( newPassiveHost ) ) {
fireReplyReceived ( 0 ,
lr_6 + this . passiveHost + lr_7 + newPassiveHost + lr_8 ) ;
this . passiveHost = newPassiveHost ;
}
} catch ( final UnknownHostException e ) {
throw new MalformedServerReplyException (
lr_3 + reply ) ;
}
}
}
protected void _parseExtendedPassiveModeReply ( String reply )
throws MalformedServerReplyException
{
reply = reply . substring ( reply . indexOf ( '(' ) + 1 ,
reply . indexOf ( ')' ) ) . trim () ;
char delim1 , delim2 , delim3 , delim4 ;
delim1 = reply . charAt ( 0 ) ;
delim2 = reply . charAt ( 1 ) ;
delim3 = reply . charAt ( 2 ) ;
delim4 = reply . charAt ( reply . length () - 1 ) ;
if ( ! ( delim1 == delim2 ) || ! ( delim2 == delim3 )
|| ! ( delim3 == delim4 ) ) {
throw new MalformedServerReplyException (
lr_9 + reply ) ;
}
int port ;
try
{
port = Integer . parseInt ( reply . substring ( 3 , reply . length () - 1 ) ) ;
}
catch ( final NumberFormatException e )
{
throw new MalformedServerReplyException (
lr_9 + reply ) ;
}
this . passiveHost = getRemoteAddress () . getHostAddress () ;
this . passivePort = port ;
}
private boolean storeFile ( final FTPCmd command , final String remote , final InputStream local )
throws IOException
{
return _storeFile ( command . getCommand () , remote , local ) ;
}
protected boolean _storeFile ( final String command , final String remote , final InputStream local )
throws IOException
{
final Socket socket = _openDataConnection_ ( command , remote ) ;
if ( socket == null ) {
return false ;
}
final OutputStream output ;
if ( fileType == ASCII_FILE_TYPE ) {
output = new ToNetASCIIOutputStream ( getBufferedOutputStream ( socket . getOutputStream () ) ) ;
} else {
output = getBufferedOutputStream ( socket . getOutputStream () ) ;
}
CSL csl = null ;
if ( controlKeepAliveTimeout > 0 ) {
csl = new CSL ( this , controlKeepAliveTimeout , controlKeepAliveReplyTimeout ) ;
}
try
{
Util . copyStream ( local , output , getBufferSize () ,
CopyStreamEvent . UNKNOWN_STREAM_SIZE , mergeListeners ( csl ) ,
false ) ;
output . close () ;
socket . close () ;
return completePendingCommand () ;
}
catch ( final IOException e )
{
Util . closeQuietly ( output ) ;
Util . closeQuietly ( socket ) ;
throw e ;
} finally {
if ( csl != null ) {
cslDebug = csl . cleanUp () ;
}
}
}
private OutputStream storeFileStream ( final FTPCmd command , final String remote )
throws IOException
{
return _storeFileStream ( command . getCommand () , remote ) ;
}
protected OutputStream _storeFileStream ( final String command , final String remote )
throws IOException
{
final Socket socket = _openDataConnection_ ( command , remote ) ;
if ( socket == null ) {
return null ;
}
final OutputStream output ;
if ( fileType == ASCII_FILE_TYPE ) {
output = new ToNetASCIIOutputStream ( getBufferedOutputStream ( socket . getOutputStream () ) ) ;
} else {
output = socket . getOutputStream () ;
}
return new org . apache . commons . net . io . SocketOutputStream ( socket , output ) ;
}
@Deprecated
protected Socket _openDataConnection_ ( final int command , final String arg )
throws IOException
{
return _openDataConnection_ ( FTPCommand . getCommand ( command ) , arg ) ;
}
protected Socket _openDataConnection_ ( final FTPCmd command , final String arg )
throws IOException
{
return _openDataConnection_ ( command . getCommand () , arg ) ;
}
protected Socket _openDataConnection_ ( final String command , final String arg )
throws IOException
{
if ( dataConnectionMode != ACTIVE_LOCAL_DATA_CONNECTION_MODE &&
dataConnectionMode != PASSIVE_LOCAL_DATA_CONNECTION_MODE ) {
return null ;
}
final boolean isInet6Address = getRemoteAddress () instanceof Inet6Address ;
Socket socket ;
if ( dataConnectionMode == ACTIVE_LOCAL_DATA_CONNECTION_MODE )
{
try ( final ServerSocket server = _serverSocketFactory_ . createServerSocket ( getActivePort () , 1 , getHostAddress () ) ) {
if ( isInet6Address ) {
if ( ! FTPReply . isPositiveCompletion ( eprt ( getReportHostAddress () , server . getLocalPort () ) ) ) {
return null ;
}
} else {
if ( ! FTPReply . isPositiveCompletion ( port ( getReportHostAddress () , server . getLocalPort () ) ) ) {
return null ;
}
}
if ( ( restartOffset > 0 ) && ! restart ( restartOffset ) ) {
return null ;
}
if ( ! FTPReply . isPositivePreliminary ( sendCommand ( command , arg ) ) ) {
return null ;
}
if ( dataTimeout >= 0 ) {
server . setSoTimeout ( dataTimeout ) ;
}
socket = server . accept () ;
if ( dataTimeout >= 0 ) {
socket . setSoTimeout ( dataTimeout ) ;
}
if ( receiveDataSocketBufferSize > 0 ) {
socket . setReceiveBufferSize ( receiveDataSocketBufferSize ) ;
}
if ( sendDataSocketBufferSize > 0 ) {
socket . setSendBufferSize ( sendDataSocketBufferSize ) ;
}
}
}
else
{
final boolean attemptEPSV = isUseEPSVwithIPv4 () || isInet6Address ;
if ( attemptEPSV && epsv () == FTPReply . ENTERING_EPSV_MODE )
{
_parseExtendedPassiveModeReply ( _replyLines . get ( 0 ) ) ;
}
else
{
if ( isInet6Address ) {
return null ;
}
if ( pasv () != FTPReply . ENTERING_PASSIVE_MODE ) {
return null ;
}
_parsePassiveModeReply ( _replyLines . get ( 0 ) ) ;
}
socket = _socketFactory_ . createSocket () ;
if ( receiveDataSocketBufferSize > 0 ) {
socket . setReceiveBufferSize ( receiveDataSocketBufferSize ) ;
}
if ( sendDataSocketBufferSize > 0 ) {
socket . setSendBufferSize ( sendDataSocketBufferSize ) ;
}
if ( passiveLocalHost != null ) {
socket . bind ( new InetSocketAddress ( passiveLocalHost , 0 ) ) ;
}
if ( dataTimeout >= 0 ) {
socket . setSoTimeout ( dataTimeout ) ;
}
socket . connect ( new InetSocketAddress ( passiveHost , passivePort ) , connectTimeout ) ;
if ( ( restartOffset > 0 ) && ! restart ( restartOffset ) )
{
socket . close () ;
return null ;
}
if ( ! FTPReply . isPositivePreliminary ( sendCommand ( command , arg ) ) )
{
socket . close () ;
return null ;
}
}
if ( remoteVerificationEnabled && ! verifyRemote ( socket ) )
{
final InetAddress socketHost = socket . getInetAddress () ;
socket . close () ;
throw new IOException (
lr_10 + socketHost . getHostAddress () +
lr_11 + getRemoteAddress () . getHostAddress () ) ;
}
return socket ;
}
@Override
protected void _connectAction_ () throws IOException
{
_connectAction_ ( null ) ;
}
@Override
protected void _connectAction_ ( final Reader socketIsReader ) throws IOException
{
super . _connectAction_ ( socketIsReader ) ;
initDefaults () ;
if ( autodetectEncoding )
{
final ArrayList < String > oldReplyLines = new ArrayList <> ( _replyLines ) ;
final int oldReplyCode = _replyCode ;
if ( hasFeature ( lr_12 ) || hasFeature ( lr_13 ) )
{
setControlEncoding ( lr_13 ) ;
_controlInput_ =
new CRLFLineReader ( new InputStreamReader ( _input_ , getControlEncoding () ) ) ;
_controlOutput_ =
new BufferedWriter ( new OutputStreamWriter ( _output_ , getControlEncoding () ) ) ;
}
_replyLines . clear () ;
_replyLines . addAll ( oldReplyLines ) ;
_replyCode = oldReplyCode ;
_newReplyString = true ;
}
}
public void setDataTimeout ( final int timeout )
{
dataTimeout = timeout ;
}
public void setParserFactory ( final FTPFileEntryParserFactory parserFactory ) {
this . parserFactory = parserFactory ;
}
@Override
public void disconnect () throws IOException
{
super . disconnect () ;
initDefaults () ;
}
public void setRemoteVerificationEnabled ( final boolean enable )
{
remoteVerificationEnabled = enable ;
}
public boolean isRemoteVerificationEnabled ()
{
return remoteVerificationEnabled ;
}
public boolean login ( final String username , final String password ) throws IOException
{
user ( username ) ;
if ( FTPReply . isPositiveCompletion ( _replyCode ) ) {
return true ;
}
if ( ! FTPReply . isPositiveIntermediate ( _replyCode ) ) {
return false ;
}
return FTPReply . isPositiveCompletion ( pass ( password ) ) ;
}
public boolean login ( final String username , final String password , final String account )
throws IOException
{
user ( username ) ;
if ( FTPReply . isPositiveCompletion ( _replyCode ) ) {
return true ;
}
if ( ! FTPReply . isPositiveIntermediate ( _replyCode ) ) {
return false ;
}
pass ( password ) ;
if ( FTPReply . isPositiveCompletion ( _replyCode ) ) {
return true ;
}
if ( ! FTPReply . isPositiveIntermediate ( _replyCode ) ) {
return false ;
}
return FTPReply . isPositiveCompletion ( acct ( account ) ) ;
}
public boolean logout () throws IOException
{
return FTPReply . isPositiveCompletion ( quit () ) ;
}
public boolean changeWorkingDirectory ( final String pathname ) throws IOException
{
return FTPReply . isPositiveCompletion ( cwd ( pathname ) ) ;
}
public boolean changeToParentDirectory () throws IOException
{
return FTPReply . isPositiveCompletion ( cdup () ) ;
}
public boolean structureMount ( final String pathname ) throws IOException
{
return FTPReply . isPositiveCompletion ( smnt ( pathname ) ) ;
}
public boolean reinitialize () throws IOException
{
rein () ;
if ( FTPReply . isPositiveCompletion ( _replyCode ) ||
( FTPReply . isPositivePreliminary ( _replyCode ) &&
FTPReply . isPositiveCompletion ( getReply () ) ) )
{
initDefaults () ;
return true ;
}
return false ;
}
public void enterLocalActiveMode ()
{
dataConnectionMode = ACTIVE_LOCAL_DATA_CONNECTION_MODE ;
passiveHost = null ;
passivePort = - 1 ;
}
public void enterLocalPassiveMode ()
{
dataConnectionMode = PASSIVE_LOCAL_DATA_CONNECTION_MODE ;
passiveHost = null ;
passivePort = - 1 ;
}
public boolean enterRemoteActiveMode ( final InetAddress host , final int port )
throws IOException
{
if ( FTPReply . isPositiveCompletion ( port ( host , port ) ) )
{
dataConnectionMode = ACTIVE_REMOTE_DATA_CONNECTION_MODE ;
passiveHost = null ;
passivePort = - 1 ;
return true ;
}
return false ;
}
public boolean enterRemotePassiveMode () throws IOException
{
if ( pasv () != FTPReply . ENTERING_PASSIVE_MODE ) {
return false ;
}
dataConnectionMode = PASSIVE_REMOTE_DATA_CONNECTION_MODE ;
_parsePassiveModeReply ( _replyLines . get ( 0 ) ) ;
return true ;
}
public String getPassiveHost ()
{
return passiveHost ;
}
public int getPassivePort ()
{
return passivePort ;
}
public int getDataConnectionMode ()
{
return dataConnectionMode ;
}
private int getActivePort ()
{
if ( activeMinPort > 0 && activeMaxPort >= activeMinPort )
{
if ( activeMaxPort == activeMinPort ) {
return activeMaxPort ;
}
return random . nextInt ( activeMaxPort - activeMinPort + 1 ) + activeMinPort ;
}
return 0 ;
}
private InetAddress getHostAddress ()
{
if ( activeExternalHost != null )
{
return activeExternalHost ;
}
return getLocalAddress () ;
}
private InetAddress getReportHostAddress () {
if ( reportActiveExternalHost != null ) {
return reportActiveExternalHost ;
}
return getHostAddress () ;
}
public void setActivePortRange ( final int minPort , final int maxPort )
{
this . activeMinPort = minPort ;
this . activeMaxPort = maxPort ;
}
public void setActiveExternalIPAddress ( final String ipAddress ) throws UnknownHostException
{
this . activeExternalHost = InetAddress . getByName ( ipAddress ) ;
}
public void setPassiveLocalIPAddress ( final String ipAddress ) throws UnknownHostException
{
this . passiveLocalHost = InetAddress . getByName ( ipAddress ) ;
}
public void setPassiveLocalIPAddress ( final InetAddress inetAddress )
{
this . passiveLocalHost = inetAddress ;
}
public InetAddress getPassiveLocalIPAddress ()
{
return this . passiveLocalHost ;
}
public void setReportActiveExternalIPAddress ( final String ipAddress ) throws UnknownHostException
{
this . reportActiveExternalHost = InetAddress . getByName ( ipAddress ) ;
}
public boolean setFileType ( final int fileType ) throws IOException
{
if ( FTPReply . isPositiveCompletion ( type ( fileType ) ) )
{
this . fileType = fileType ;
this . fileFormat = FTP . NON_PRINT_TEXT_FORMAT ;
return true ;
}
return false ;
}
public boolean setFileType ( final int fileType , final int formatOrByteSize )
throws IOException
{
if ( FTPReply . isPositiveCompletion ( type ( fileType , formatOrByteSize ) ) )
{
this . fileType = fileType ;
this . fileFormat = formatOrByteSize ;
return true ;
}
return false ;
}
public boolean setFileStructure ( final int structure ) throws IOException
{
if ( FTPReply . isPositiveCompletion ( stru ( structure ) ) )
{
fileStructure = structure ;
return true ;
}
return false ;
}
public boolean setFileTransferMode ( final int mode ) throws IOException
{
if ( FTPReply . isPositiveCompletion ( mode ( mode ) ) )
{
fileTransferMode = mode ;
return true ;
}
return false ;
}
public boolean remoteRetrieve ( final String fileName ) throws IOException
{
if ( dataConnectionMode == ACTIVE_REMOTE_DATA_CONNECTION_MODE ||
dataConnectionMode == PASSIVE_REMOTE_DATA_CONNECTION_MODE ) {
return FTPReply . isPositivePreliminary ( retr ( fileName ) ) ;
}
return false ;
}
public boolean remoteStore ( final String fileName ) throws IOException
{
if ( dataConnectionMode == ACTIVE_REMOTE_DATA_CONNECTION_MODE ||
dataConnectionMode == PASSIVE_REMOTE_DATA_CONNECTION_MODE ) {
return FTPReply . isPositivePreliminary ( stor ( fileName ) ) ;
}
return false ;
}
public boolean remoteStoreUnique ( final String fileName ) throws IOException
{
if ( dataConnectionMode == ACTIVE_REMOTE_DATA_CONNECTION_MODE ||
dataConnectionMode == PASSIVE_REMOTE_DATA_CONNECTION_MODE ) {
return FTPReply . isPositivePreliminary ( stou ( fileName ) ) ;
}
return false ;
}
public boolean remoteStoreUnique () throws IOException
{
if ( dataConnectionMode == ACTIVE_REMOTE_DATA_CONNECTION_MODE ||
dataConnectionMode == PASSIVE_REMOTE_DATA_CONNECTION_MODE ) {
return FTPReply . isPositivePreliminary ( stou () ) ;
}
return false ;
}
public boolean remoteAppend ( final String fileName ) throws IOException
{
if ( dataConnectionMode == ACTIVE_REMOTE_DATA_CONNECTION_MODE ||
dataConnectionMode == PASSIVE_REMOTE_DATA_CONNECTION_MODE ) {
return FTPReply . isPositivePreliminary ( appe ( fileName ) ) ;
}
return false ;
}
public boolean completePendingCommand () throws IOException
{
return FTPReply . isPositiveCompletion ( getReply () ) ;
}
public boolean retrieveFile ( final String remote , final OutputStream local )
throws IOException
{
return _retrieveFile ( FTPCmd . RETR . getCommand () , remote , local ) ;
}
protected boolean _retrieveFile ( final String command , final String remote , final OutputStream local )
throws IOException
{
final Socket socket = _openDataConnection_ ( command , remote ) ;
if ( socket == null ) {
return false ;
}
InputStream input = null ;
CSL csl = null ;
try {
try {
if ( fileType == ASCII_FILE_TYPE ) {
input = new FromNetASCIIInputStream ( getBufferedInputStream ( socket . getInputStream () ) ) ;
} else {
input = getBufferedInputStream ( socket . getInputStream () ) ;
}
if ( controlKeepAliveTimeout > 0 ) {
csl = new CSL ( this , controlKeepAliveTimeout , controlKeepAliveReplyTimeout ) ;
}
Util . copyStream ( input , local , getBufferSize () , CopyStreamEvent . UNKNOWN_STREAM_SIZE , mergeListeners ( csl ) ,
false ) ;
} finally {
Util . closeQuietly ( input ) ;
}
return completePendingCommand () ;
} finally {
Util . closeQuietly ( socket ) ;
if ( csl != null ) {
cslDebug = csl . cleanUp () ;
}
}
}
public InputStream retrieveFileStream ( final String remote ) throws IOException
{
return _retrieveFileStream ( FTPCmd . RETR . getCommand () , remote ) ;
}
protected InputStream _retrieveFileStream ( final String command , final String remote )
throws IOException
{
final Socket socket = _openDataConnection_ ( command , remote ) ;
if ( socket == null ) {
return null ;
}
final InputStream input ;
if ( fileType == ASCII_FILE_TYPE ) {
input = new FromNetASCIIInputStream ( getBufferedInputStream ( socket . getInputStream () ) ) ;
} else {
input = socket . getInputStream () ;
}
return new org . apache . commons . net . io . SocketInputStream ( socket , input ) ;
}
public boolean storeFile ( final String remote , final InputStream local )
throws IOException
{
return storeFile ( FTPCmd . STOR , remote , local ) ;
}
public OutputStream storeFileStream ( final String remote ) throws IOException
{
return storeFileStream ( FTPCmd . STOR , remote ) ;
}
public boolean appendFile ( final String remote , final InputStream local )
throws IOException
{
return storeFile ( FTPCmd . APPE , remote , local ) ;
}
public OutputStream appendFileStream ( final String remote ) throws IOException
{
return storeFileStream ( FTPCmd . APPE , remote ) ;
}
public boolean storeUniqueFile ( final String remote , final InputStream local )
throws IOException
{
return storeFile ( FTPCmd . STOU , remote , local ) ;
}
public OutputStream storeUniqueFileStream ( final String remote ) throws IOException
{
return storeFileStream ( FTPCmd . STOU , remote ) ;
}
public boolean storeUniqueFile ( final InputStream local ) throws IOException
{
return storeFile ( FTPCmd . STOU , null , local ) ;
}
public OutputStream storeUniqueFileStream () throws IOException
{
return storeFileStream ( FTPCmd . STOU , null ) ;
}
public boolean allocate ( final int bytes ) throws IOException
{
return FTPReply . isPositiveCompletion ( allo ( bytes ) ) ;
}
public boolean allocate ( final long bytes ) throws IOException
{
return FTPReply . isPositiveCompletion ( allo ( bytes ) ) ;
}
public boolean features () throws IOException {
return FTPReply . isPositiveCompletion ( feat () ) ;
}
public String [] featureValues ( final String feature ) throws IOException {
if ( ! initFeatureMap () ) {
return null ;
}
final Set < String > entries = featuresMap . get ( feature . toUpperCase ( Locale . ENGLISH ) ) ;
if ( entries != null ) {
return entries . toArray ( new String [ entries . size () ] ) ;
}
return null ;
}
public String featureValue ( final String feature ) throws IOException {
final String [] values = featureValues ( feature ) ;
if ( values != null ) {
return values [ 0 ] ;
}
return null ;
}
public boolean hasFeature ( final String feature ) throws IOException {
if ( ! initFeatureMap () ) {
return false ;
}
return featuresMap . containsKey ( feature . toUpperCase ( Locale . ENGLISH ) ) ;
}
public boolean hasFeature ( final String feature , final String value ) throws IOException {
if ( ! initFeatureMap () ) {
return false ;
}
final Set < String > entries = featuresMap . get ( feature . toUpperCase ( Locale . ENGLISH ) ) ;
if ( entries != null ) {
return entries . contains ( value ) ;
}
return false ;
}
private boolean initFeatureMap () throws IOException {
if ( featuresMap == null ) {
final int replyCode = feat () ;
if ( replyCode == FTPReply . NOT_LOGGED_IN ) {
return false ;
}
final boolean success = FTPReply . isPositiveCompletion ( replyCode ) ;
featuresMap = new HashMap <> () ;
if ( ! success ) {
return false ;
}
for ( final String l : getReplyStrings () ) {
if ( l . startsWith ( lr_14 ) ) {
String key ;
String value = lr_1 ;
final int varsep = l . indexOf ( ' ' , 1 ) ;
if ( varsep > 0 ) {
key = l . substring ( 1 , varsep ) ;
value = l . substring ( varsep + 1 ) ;
} else {
key = l . substring ( 1 ) ;
}
key = key . toUpperCase ( Locale . ENGLISH ) ;
Set < String > entries = featuresMap . get ( key ) ;
if ( entries == null ) {
entries = new HashSet <> () ;
featuresMap . put ( key , entries ) ;
}
entries . add ( value ) ;
}
}
}
return true ;
}
public boolean allocate ( final int bytes , final int recordSize ) throws IOException
{
return FTPReply . isPositiveCompletion ( allo ( bytes , recordSize ) ) ;
}
public boolean allocate ( final long bytes , final int recordSize ) throws IOException
{
return FTPReply . isPositiveCompletion ( allo ( bytes , recordSize ) ) ;
}
public boolean doCommand ( final String command , final String params ) throws IOException
{
return FTPReply . isPositiveCompletion ( sendCommand ( command , params ) ) ;
}
public String [] doCommandAsStrings ( final String command , final String params ) throws IOException
{
final boolean success = FTPReply . isPositiveCompletion ( sendCommand ( command , params ) ) ;
if ( success ) {
return getReplyStrings () ;
}
return null ;
}
public FTPFile mlistFile ( final String pathname ) throws IOException
{
final boolean success = FTPReply . isPositiveCompletion ( sendCommand ( FTPCmd . MLST , pathname ) ) ;
if ( success ) {
String reply = getReplyStrings () [ 1 ] ;
if( reply . charAt ( 0 ) != ' ' ) { reply = lr_14 + reply ; }
if ( reply . length () < 3 ) {
throw new MalformedServerReplyException ( lr_15 + reply + lr_16 ) ;
}
final String entry = reply . replaceAll ( lr_17 , lr_1 ) ;
return MLSxEntryParser . parseEntry ( entry ) ;
}
return null ;
}
public FTPFile [] mlistDir () throws IOException
{
return mlistDir ( null ) ;
}
public FTPFile [] mlistDir ( final String pathname ) throws IOException
{
final FTPListParseEngine engine = initiateMListParsing ( pathname ) ;
return engine . getFiles () ;
}
public FTPFile [] mlistDir ( final String pathname , final FTPFileFilter filter ) throws IOException
{
final FTPListParseEngine engine = initiateMListParsing ( pathname ) ;
return engine . getFiles ( filter ) ;
}
protected boolean restart ( final long offset ) throws IOException
{
restartOffset = 0 ;
return FTPReply . isPositiveIntermediate ( rest ( Long . toString ( offset ) ) ) ;
}
public void setRestartOffset ( final long offset )
{
if ( offset >= 0 ) {
restartOffset = offset ;
}
}
public long getRestartOffset ()
{
return restartOffset ;
}
public boolean rename ( final String from , final String to ) throws IOException
{
if ( ! FTPReply . isPositiveIntermediate ( rnfr ( from ) ) ) {
return false ;
}
return FTPReply . isPositiveCompletion ( rnto ( to ) ) ;
}
public boolean abort () throws IOException
{
return FTPReply . isPositiveCompletion ( abor () ) ;
}
public boolean deleteFile ( final String pathname ) throws IOException
{
return FTPReply . isPositiveCompletion ( dele ( pathname ) ) ;
}
public boolean removeDirectory ( final String pathname ) throws IOException
{
return FTPReply . isPositiveCompletion ( rmd ( pathname ) ) ;
}
public boolean makeDirectory ( final String pathname ) throws IOException
{
return FTPReply . isPositiveCompletion ( mkd ( pathname ) ) ;
}
public String printWorkingDirectory () throws IOException
{
if ( pwd () != FTPReply . PATHNAME_CREATED ) {
return null ;
}
return parsePathname ( _replyLines . get ( _replyLines . size () - 1 ) ) ;
}
public boolean sendSiteCommand ( final String arguments ) throws IOException
{
return FTPReply . isPositiveCompletion ( site ( arguments ) ) ;
}
public String getSystemType () throws IOException
{
if ( systemName == null ) {
if ( FTPReply . isPositiveCompletion ( syst () ) ) {
systemName = _replyLines . get ( _replyLines . size () - 1 ) . substring ( 4 ) ;
} else {
final String systDefault = System . getProperty ( FTP_SYSTEM_TYPE_DEFAULT ) ;
if ( systDefault != null ) {
systemName = systDefault ;
} else {
throw new IOException ( lr_18 + getReplyString () ) ;
}
}
}
return systemName ;
}
public String listHelp () throws IOException
{
if ( FTPReply . isPositiveCompletion ( help () ) ) {
return getReplyString () ;
}
return null ;
}
public String listHelp ( final String command ) throws IOException
{
if ( FTPReply . isPositiveCompletion ( help ( command ) ) ) {
return getReplyString () ;
}
return null ;
}
public boolean sendNoOp () throws IOException
{
return FTPReply . isPositiveCompletion ( noop () ) ;
}
public String [] listNames ( final String pathname ) throws IOException
{
final ArrayList < String > results = new ArrayList <> () ;
try ( final Socket socket = _openDataConnection_ ( FTPCmd . NLST , getListArguments ( pathname ) ) ) {
if ( socket == null ) {
return null ;
}
try ( final BufferedReader reader = new BufferedReader (
new InputStreamReader ( socket . getInputStream () , getControlEncoding () ) ) ) {
String line ;
while ( ( line = reader . readLine () ) != null ) {
results . add ( line ) ;
}
}
}
if ( completePendingCommand () ) {
final String [] names = new String [ results . size () ] ;
return results . toArray ( names ) ;
}
return null ;
}
public String [] listNames () throws IOException
{
return listNames ( null ) ;
}
public FTPFile [] listFiles ( final String pathname )
throws IOException
{
final FTPListParseEngine engine = initiateListParsing ( ( String ) null , pathname ) ;
return engine . getFiles () ;
}
public FTPFile [] listFiles ()
throws IOException
{
return listFiles ( ( String ) null ) ;
}
public FTPFile [] listFiles ( final String pathname , final FTPFileFilter filter )
throws IOException
{
final FTPListParseEngine engine = initiateListParsing ( ( String ) null , pathname ) ;
return engine . getFiles ( filter ) ;
}
public FTPFile [] listDirectories () throws IOException {
return listDirectories ( ( String ) null ) ;
}
public FTPFile [] listDirectories ( final String parent ) throws IOException {
return listFiles ( parent , FTPFileFilters . DIRECTORIES ) ;
}
public FTPListParseEngine initiateListParsing ()
throws IOException
{
return initiateListParsing ( ( String ) null ) ;
}
public FTPListParseEngine initiateListParsing ( final String pathname )
throws IOException
{
return initiateListParsing ( ( String ) null , pathname ) ;
}
public FTPListParseEngine initiateListParsing (
final String parserKey , final String pathname )
throws IOException
{
createParser ( parserKey ) ;
return initiateListParsing ( entryParser , pathname ) ;
}
void createParser ( final String parserKey ) throws IOException {
if( entryParser == null || ( parserKey != null && ! entryParserKey . equals ( parserKey ) ) ) {
if ( null != parserKey ) {
entryParser =
parserFactory . createFileEntryParser ( parserKey ) ;
entryParserKey = parserKey ;
} else {
if ( null != configuration && configuration . getServerSystemKey () . length () > 0 ) {
entryParser =
parserFactory . createFileEntryParser ( configuration ) ;
entryParserKey = configuration . getServerSystemKey () ;
} else {
String systemType = System . getProperty ( FTP_SYSTEM_TYPE ) ;
if ( systemType == null ) {
systemType = getSystemType () ;
final Properties override = getOverrideProperties () ;
if ( override != null ) {
final String newType = override . getProperty ( systemType ) ;
if ( newType != null ) {
systemType = newType ;
}
}
}
if ( null != configuration ) {
entryParser = parserFactory . createFileEntryParser ( new FTPClientConfig ( systemType , configuration ) ) ;
} else {
entryParser = parserFactory . createFileEntryParser ( systemType ) ;
}
entryParserKey = systemType ;
}
}
}
}
private FTPListParseEngine initiateListParsing (
final FTPFileEntryParser parser , final String pathname )
throws IOException
{
final Socket socket = _openDataConnection_ ( FTPCmd . LIST , getListArguments ( pathname ) ) ;
final FTPListParseEngine engine = new FTPListParseEngine ( parser , configuration ) ;
if ( socket == null )
{
return engine ;
}
try {
engine . readServerList ( socket . getInputStream () , getControlEncoding () ) ;
}
finally {
Util . closeQuietly ( socket ) ;
}
completePendingCommand () ;
return engine ;
}
public FTPListParseEngine initiateMListParsing () throws IOException
{
return initiateMListParsing ( null ) ;
}
public FTPListParseEngine initiateMListParsing ( final String pathname ) throws IOException
{
final Socket socket = _openDataConnection_ ( FTPCmd . MLSD , pathname ) ;
final FTPListParseEngine engine = new FTPListParseEngine ( MLSxEntryParser . getInstance () , configuration ) ;
if ( socket == null )
{
return engine ;
}
try {
engine . readServerList ( socket . getInputStream () , getControlEncoding () ) ;
}
finally {
Util . closeQuietly ( socket ) ;
completePendingCommand () ;
}
return engine ;
}
protected String getListArguments ( final String pathname ) {
if ( getListHiddenFiles () )
{
if ( pathname != null )
{
final StringBuilder sb = new StringBuilder ( pathname . length () + 3 ) ;
sb . append ( lr_19 ) ;
sb . append ( pathname ) ;
return sb . toString () ;
}
return lr_20 ;
}
return pathname ;
}
public String getStatus () throws IOException
{
if ( FTPReply . isPositiveCompletion ( stat () ) ) {
return getReplyString () ;
}
return null ;
}
public String getStatus ( final String pathname ) throws IOException
{
if ( FTPReply . isPositiveCompletion ( stat ( pathname ) ) ) {
return getReplyString () ;
}
return null ;
}
public String getSize ( final String pathname ) throws IOException
{
if ( FTPReply . isPositiveCompletion ( size ( pathname ) ) ) {
return getReplyStrings () [ 0 ] . substring ( 4 ) ;
}
return null ;
}
public String getModificationTime ( final String pathname ) throws IOException {
if ( FTPReply . isPositiveCompletion ( mdtm ( pathname ) ) ) {
return getReplyStrings () [ 0 ] . substring ( 4 ) ;
}
return null ;
}
public FTPFile mdtmFile ( final String pathname ) throws IOException {
if ( FTPReply . isPositiveCompletion ( mdtm ( pathname ) ) ) {
final String reply = getReplyStrings () [ 0 ] . substring ( 4 ) ;
final FTPFile file = new FTPFile () ;
file . setName ( pathname ) ;
file . setRawListing ( reply ) ;
file . setTimestamp ( MLSxEntryParser . parseGMTdateTime ( reply ) ) ;
return file ;
}
return null ;
}
public boolean setModificationTime ( final String pathname , final String timeval ) throws IOException {
return ( FTPReply . isPositiveCompletion ( mfmt ( pathname , timeval ) ) ) ;
}
public void setBufferSize ( final int bufSize ) {
bufferSize = bufSize ;
}
public int getBufferSize () {
return bufferSize ;
}
public void setSendDataSocketBufferSize ( final int bufSize ) {
sendDataSocketBufferSize = bufSize ;
}
public int getSendDataSocketBufferSize () {
return sendDataSocketBufferSize ;
}
public void setReceieveDataSocketBufferSize ( final int bufSize ) {
receiveDataSocketBufferSize = bufSize ;
}
public int getReceiveDataSocketBufferSize () {
return receiveDataSocketBufferSize ;
}
@Override
public void configure ( final FTPClientConfig config ) {
this . configuration = config ;
}
public void setListHiddenFiles ( final boolean listHiddenFiles ) {
this . listHiddenFiles = listHiddenFiles ;
}
public boolean getListHiddenFiles () {
return this . listHiddenFiles ;
}
public boolean isUseEPSVwithIPv4 () {
return useEPSVwithIPv4 ;
}
public void setUseEPSVwithIPv4 ( final boolean selected ) {
this . useEPSVwithIPv4 = selected ;
}
public void setCopyStreamListener ( final CopyStreamListener listener ) {
copyStreamListener = listener ;
}
public CopyStreamListener getCopyStreamListener () {
return copyStreamListener ;
}
public void setControlKeepAliveTimeout ( final long controlIdle ) {
controlKeepAliveTimeout = controlIdle * 1000 ;
}
public long getControlKeepAliveTimeout () {
return controlKeepAliveTimeout / 1000 ;
}
@Deprecated
public int [] getCslDebug () {
return cslDebug ;
}
public void setControlKeepAliveReplyTimeout ( final int timeout ) {
controlKeepAliveReplyTimeout = timeout ;
}
public int getControlKeepAliveReplyTimeout () {
return controlKeepAliveReplyTimeout ;
}
@Deprecated
public void setPassiveNatWorkaround ( final boolean enabled ) {
if ( enabled ) {
this . passiveNatWorkaroundStrategy = new NatServerResolverImpl ( this ) ;
} else {
this . passiveNatWorkaroundStrategy = null ;
}
}
public void setPassiveNatWorkaroundStrategy ( final HostnameResolver resolver ) {
this . passiveNatWorkaroundStrategy = resolver ;
}
@Override
public String resolve ( final String hostname ) throws UnknownHostException {
String newHostname = hostname ;
final InetAddress host = InetAddress . getByName ( newHostname ) ;
if ( host . isSiteLocalAddress () ) {
final InetAddress remote = this . client . getRemoteAddress () ;
if ( ! remote . isSiteLocalAddress () ) {
newHostname = remote . getHostAddress () ;
}
}
return newHostname ;
}
private OutputStream getBufferedOutputStream ( final OutputStream outputStream ) {
if ( bufferSize > 0 ) {
return new BufferedOutputStream ( outputStream , bufferSize ) ;
}
return new BufferedOutputStream ( outputStream ) ;
}
private InputStream getBufferedInputStream ( final InputStream inputStream ) {
if ( bufferSize > 0 ) {
return new BufferedInputStream ( inputStream , bufferSize ) ;
}
return new BufferedInputStream ( inputStream ) ;
}
@Override
public void bytesTransferred ( final CopyStreamEvent event ) {
bytesTransferred ( event . getTotalBytesTransferred () , event . getBytesTransferred () , event . getStreamSize () ) ;
}
@Override
public void bytesTransferred ( final long totalBytesTransferred ,
final int bytesTransferred , final long streamSize ) {
final long now = System . currentTimeMillis () ;
if ( now - time > idle ) {
try {
parent . __noop () ;
acksAcked ++ ;
} catch ( final SocketTimeoutException e ) {
notAcked ++ ;
} catch ( final IOException e ) {
ioErrors ++ ;
}
time = now ;
}
}
int [] cleanUp () throws IOException {
final int remain = notAcked ;
try {
while( notAcked > 0 ) {
parent . getReply () ;
notAcked -- ;
}
} catch ( final SocketTimeoutException e ) {
} finally {
parent . setSoTimeout ( currentSoTimeout ) ;
}
return new int [] { acksAcked , remain , notAcked , ioErrors } ;
}
private CopyStreamListener mergeListeners ( final CopyStreamListener local ) {
if ( local == null ) {
return copyStreamListener ;
}
if ( copyStreamListener == null ) {
return local ;
}
final CopyStreamAdapter merged = new CopyStreamAdapter () ;
merged . addCopyStreamListener ( local ) ;
merged . addCopyStreamListener ( copyStreamListener ) ;
return merged ;
}
public void setAutodetectUTF8 ( final boolean autodetect )
{
autodetectEncoding = autodetect ;
}
public boolean getAutodetectUTF8 ()
{
return autodetectEncoding ;
}
FTPFileEntryParser getEntryParser () {
return entryParser ;
}
@Deprecated
public String getSystemName () throws IOException
{
if ( systemName == null && FTPReply . isPositiveCompletion ( syst () ) ) {
systemName = _replyLines . get ( _replyLines . size () - 1 ) . substring ( 4 ) ;
}
return systemName ;
}
