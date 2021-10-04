public static void main ( final String [] args ) throws UnknownHostException
{
boolean storeFile = false , binaryTransfer = false , error = false , listFiles = false , listNames = false , hidden = false ;
boolean localActive = false , useEpsvWithIPv4 = false , feat = false , printHash = false ;
boolean mlst = false , mlsd = false , mdtm = false , saveUnparseable = false ;
boolean size = false ;
boolean lenient = false ;
long keepAliveTimeout = - 1 ;
int controlKeepAliveReplyTimeout = - 1 ;
int minParams = 5 ;
String protocol = null ;
String doCommand = null ;
String trustmgr = null ;
String proxyHost = null ;
int proxyPort = 80 ;
String proxyUser = null ;
String proxyPassword = null ;
String username = null ;
String password = null ;
String encoding = null ;
String serverTimeZoneId = null ;
String displayTimeZoneId = null ;
String serverType = null ;
String defaultDateFormat = null ;
String recentDateFormat = null ;
int base = 0 ;
for ( base = 0 ; base < args . length ; base ++ )
{
if ( args [ base ] . equals ( lr_1 ) ) {
storeFile = true ;
}
else if ( args [ base ] . equals ( lr_2 ) ) {
localActive = true ;
}
else if ( args [ base ] . equals ( lr_3 ) ) {
username = lr_4 ;
password = System . getProperty ( lr_5 ) + lr_6 + InetAddress . getLocalHost () . getHostName () ;
}
else if ( args [ base ] . equals ( lr_7 ) ) {
binaryTransfer = true ;
}
else if ( args [ base ] . equals ( lr_8 ) ) {
doCommand = args [ ++ base ] ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_9 ) ) {
mlsd = true ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_10 ) ) {
useEpsvWithIPv4 = true ;
}
else if ( args [ base ] . equals ( lr_11 ) ) {
encoding = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_12 ) ) {
feat = true ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_13 ) ) {
hidden = true ;
}
else if ( args [ base ] . equals ( lr_14 ) ) {
size = true ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_15 ) ) {
keepAliveTimeout = Long . parseLong ( args [ ++ base ] ) ;
}
else if ( args [ base ] . equals ( lr_16 ) ) {
listFiles = true ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_17 ) ) {
mdtm = true ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_18 ) ) {
lenient = true ;
}
else if ( args [ base ] . equals ( lr_19 ) ) {
listNames = true ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_20 ) ) {
protocol = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_21 ) ) {
serverType = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_22 ) ) {
mlst = true ;
minParams = 3 ;
}
else if ( args [ base ] . equals ( lr_23 ) ) {
saveUnparseable = true ;
}
else if ( args [ base ] . equals ( lr_24 ) ) {
controlKeepAliveReplyTimeout = Integer . parseInt ( args [ ++ base ] ) ;
}
else if ( args [ base ] . equals ( lr_25 ) ) {
trustmgr = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_26 ) ) {
defaultDateFormat = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_27 ) ) {
recentDateFormat = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_28 ) ) {
serverTimeZoneId = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_29 ) ) {
displayTimeZoneId = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_30 ) ) {
proxyHost = args [ ++ base ] ;
final String parts [] = proxyHost . split ( lr_31 ) ;
if ( parts . length == 2 ) {
proxyHost = parts [ 0 ] ;
proxyPort = Integer . parseInt ( parts [ 1 ] ) ;
}
}
else if ( args [ base ] . equals ( lr_32 ) ) {
proxyUser = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_33 ) ) {
proxyPassword = args [ ++ base ] ;
}
else if ( args [ base ] . equals ( lr_34 ) ) {
printHash = true ;
}
else {
break;
}
}
final int remain = args . length - base ;
if ( username != null ) {
minParams -= 2 ;
}
if ( remain < minParams )
{
if ( args . length > 0 ) {
System . err . println ( lr_35 + Arrays . toString ( args ) ) ;
}
System . err . println ( USAGE ) ; MST[rv.UOI3Mutator]MSP[S]
System . exit ( 1 ) ;
}
String server = args [ base ++ ] ;
int port = 0 ;
final String parts [] = server . split ( lr_31 ) ;
if ( parts . length == 2 ) {
server = parts [ 0 ] ;
port = Integer . parseInt ( parts [ 1 ] ) ;
}
if ( username == null ) {
username = args [ base ++ ] ;
password = args [ base ++ ] ;
}
String remote = null ;
if ( args . length - base > 0 ) {
remote = args [ base ++ ] ;
}
String local = null ;
if ( args . length - base > 0 ) {
local = args [ base ++ ] ;
}
final FTPClient ftp ;
if ( protocol == null ) {
if( proxyHost != null ) {
System . out . println ( lr_36 + proxyHost ) ;
ftp = new FTPHTTPClient ( proxyHost , proxyPort , proxyUser , proxyPassword ) ;
}
else {
ftp = new FTPClient () ;
}
} else {
FTPSClient ftps ;
if ( protocol . equals ( lr_37 ) ) {
ftps = new FTPSClient ( true ) ;
} else if ( protocol . equals ( lr_38 ) ) {
ftps = new FTPSClient ( false ) ;
} else {
final String prot [] = protocol . split ( lr_39 ) ;
if ( prot . length == 1 ) {
ftps = new FTPSClient ( protocol ) ;
} else {
ftps = new FTPSClient ( prot [ 0 ] , Boolean . parseBoolean ( prot [ 1 ] ) ) ;
}
}
ftp = ftps ;
if ( lr_40 . equals ( trustmgr ) ) {
ftps . setTrustManager ( TrustManagerUtils . getAcceptAllTrustManager () ) ;
} else if ( lr_41 . equals ( trustmgr ) ) {
ftps . setTrustManager ( TrustManagerUtils . getValidateServerCertificateTrustManager () ) ;
} else if ( lr_42 . equals ( trustmgr ) ) {
ftps . setTrustManager ( null ) ;
}
}
if ( printHash ) {
ftp . setCopyStreamListener ( createListener () ) ;
}
if ( keepAliveTimeout >= 0 ) {
ftp . setControlKeepAliveTimeout ( keepAliveTimeout ) ;
}
if ( controlKeepAliveReplyTimeout >= 0 ) {
ftp . setControlKeepAliveReplyTimeout ( controlKeepAliveReplyTimeout ) ;
}
if ( encoding != null ) {
ftp . setControlEncoding ( encoding ) ;
}
ftp . setListHiddenFiles ( hidden ) ;
ftp . addProtocolCommandListener ( new PrintCommandListener ( new PrintWriter ( System . out ) , true ) ) ;
final FTPClientConfig config ;
if ( serverType != null ) {
config = new FTPClientConfig ( serverType ) ;
} else {
config = new FTPClientConfig () ;
}
config . setUnparseableEntries ( saveUnparseable ) ;
if ( defaultDateFormat != null ) {
config . setDefaultDateFormatStr ( defaultDateFormat ) ;
}
if ( recentDateFormat != null ) {
config . setRecentDateFormatStr ( recentDateFormat ) ;
}
ftp . configure ( config ) ;
try
{
int reply ;
if ( port > 0 ) {
ftp . connect ( server , port ) ;
} else {
ftp . connect ( server ) ;
}
System . out . println ( lr_43 + server + lr_44 + ( port > 0 ? port : ftp . getDefaultPort () ) ) ;
reply = ftp . getReplyCode () ;
if ( ! FTPReply . isPositiveCompletion ( reply ) )
{
ftp . disconnect () ;
System . err . println ( lr_45 ) ;
System . exit ( 1 ) ;
}
}
catch ( final IOException e )
{
if ( ftp . isConnected () )
{
try
{
ftp . disconnect () ;
}
catch ( final IOException f )
{
}
}
System . err . println ( lr_46 ) ;
e . printStackTrace () ;
System . exit ( 1 ) ;
}
__main:
try
{
if ( ! ftp . login ( username , password ) )
{
ftp . logout () ;
error = true ;
break __main;
}
System . out . println ( lr_47 + ftp . getSystemType () ) ;
if ( binaryTransfer ) {
ftp . setFileType ( FTP . BINARY_FILE_TYPE ) ;
} else {
ftp . setFileType ( FTP . ASCII_FILE_TYPE ) ;
}
if ( localActive ) {
ftp . enterLocalActiveMode () ;
} else {
ftp . enterLocalPassiveMode () ;
}
ftp . setUseEPSVwithIPv4 ( useEpsvWithIPv4 ) ;
if ( storeFile )
{
try ( InputStream input = new FileInputStream ( local ) ) {
ftp . storeFile ( remote , input ) ;
}
if ( keepAliveTimeout > 0 ) {
showCslStats ( ftp ) ;
}
}
else if ( listFiles || mlsd || mdtm || mlst || listNames || size )
{
if ( mlsd ) {
for ( final FTPFile f : ftp . mlistDir ( remote ) ) {
System . out . println ( f . getRawListing () ) ;
System . out . println ( f . toFormattedString ( displayTimeZoneId ) ) ;
}
}
if ( mdtm ) {
final FTPFile f = ftp . mdtmFile ( remote ) ;
if ( f != null ) {
System . out . println ( f . getRawListing () ) ;
System . out . println ( f . toFormattedString ( displayTimeZoneId ) ) ;
} else {
System . out . println ( lr_48 ) ;
}
}
if ( mlst ) {
final FTPFile f = ftp . mlistFile ( remote ) ;
if ( f != null ) {
System . out . println ( f . toFormattedString ( displayTimeZoneId ) ) ;
}
}
if ( listNames ) {
for ( final String s : ftp . listNames ( remote ) ) {
System . out . println ( s ) ;
}
}
if ( size ) {
System . out . println ( lr_49 + ftp . getSize ( remote ) ) ;
}
if ( listFiles ) {
if ( lenient || serverTimeZoneId != null ) {
config . setLenientFutureDates ( lenient ) ;
if ( serverTimeZoneId != null ) {
config . setServerTimeZoneId ( serverTimeZoneId ) ;
}
ftp . configure ( config ) ;
}
for ( final FTPFile f : ftp . listFiles ( remote ) ) {
System . out . println ( f . getRawListing () ) ;
System . out . println ( f . toFormattedString ( displayTimeZoneId ) ) ;
}
}
}
else if ( feat )
{
if ( remote != null ) {
if ( ftp . hasFeature ( remote ) ) {
System . out . println ( lr_50 + remote ) ;
} else {
if ( FTPReply . isPositiveCompletion ( ftp . getReplyCode () ) ) {
System . out . println ( lr_51 + remote + lr_52 ) ;
} else {
System . out . println ( lr_53 + ftp . getReplyString () ) ;
}
}
final String [] features = ftp . featureValues ( remote ) ;
if ( features != null ) {
for( final String f : features ) {
System . out . println ( lr_51 + remote + lr_54 + f + lr_55 ) ;
}
} else {
if ( FTPReply . isPositiveCompletion ( ftp . getReplyCode () ) ) {
System . out . println ( lr_51 + remote + lr_56 ) ;
} else {
System . out . println ( lr_53 + ftp . getReplyString () ) ;
}
}
} else {
if ( ftp . features () ) {
} else {
System . out . println ( lr_57 + ftp . getReplyString () ) ;
}
}
}
else if ( doCommand != null )
{
if ( ftp . doCommand ( doCommand , remote ) ) {
} else {
System . out . println ( lr_57 + ftp . getReplyString () ) ;
}
}
else
{
try ( OutputStream output = new FileOutputStream ( local ) ) {
ftp . retrieveFile ( remote , output ) ;
}
if ( keepAliveTimeout > 0 ) {
showCslStats ( ftp ) ;
}
}
ftp . noop () ;
ftp . logout () ;
}
catch ( final FTPConnectionClosedException e )
{
error = true ;
System . err . println ( lr_58 ) ;
e . printStackTrace () ;
}
catch ( final IOException e )
{
error = true ;
e . printStackTrace () ;
}
finally
{
if ( ftp . isConnected () )
{
try
{
ftp . disconnect () ;
}
catch ( final IOException f )
{
}
}
}
System . exit ( error ? 1 : 0 ) ;
}
private static void showCslStats ( final FTPClient ftp ) {
@SuppressWarnings ( lr_59 )
final
int [] stats = ftp . getCslDebug () ;
System . out . println ( lr_60 + Arrays . toString ( stats ) ) ;
}
@Override
public void bytesTransferred ( final CopyStreamEvent event ) {
bytesTransferred ( event . getTotalBytesTransferred () , event . getBytesTransferred () , event . getStreamSize () ) ;
}
@Override
public void bytesTransferred ( final long totalBytesTransferred ,
final int bytesTransferred , final long streamSize ) {
final long megs = totalBytesTransferred / 1000000 ;
for ( long l = megsTotal ; l < megs ; l ++ ) {
System . err . print ( lr_61 ) ;
}
megsTotal = megs ;
}
