private boolean open ( final String host , final int port ) throws Exception {
System . out . println ( lr_1 + host ) ;
out = new PrintWriter ( new FileWriter ( new File ( DOWNLOAD_DIR , host + lr_2 ) ) ) ;
listener = new PrintCommandListener ( out ) ;
addProtocolCommandListener ( listener ) ;
setConnectTimeout ( 30000 ) ;
try {
connect ( host , port ) ;
} catch ( final Exception e ) {
System . out . println ( e ) ;
return false ;
}
enterLocalPassiveMode () ;
System . out . println ( lr_3 + host ) ;
return login ( lr_4 , lr_5 ) ;
}
private void info () throws IOException {
syst () ;
help () ;
feat () ;
removeProtocolCommandListener ( listener ) ;
}
private void download ( final String path , final FTPCmd command , final File fileName ) throws Exception {
Socket socket ;
if ( ( socket = _openDataConnection_ ( command , getListArguments ( path ) ) ) == null ) {
System . out . println ( getReplyString () ) ;
return;
}
final InputStream inputStream = socket . getInputStream () ;
final OutputStream outputStream = new FileOutputStream ( fileName ) ;
Util . copyStream ( inputStream , outputStream ) ;
inputStream . close () ;
socket . close () ;
outputStream . close () ;
if ( ! completePendingCommand () )
{
System . out . println ( getReplyString () ) ;
}
}
public static void main ( final String [] args ) throws Exception {
String host ;
final int port = 21 ;
String path ;
new File ( DOWNLOAD_DIR ) . mkdirs () ;
final DownloadListings self = new DownloadListings () ;
final OutputStream os = new FileOutputStream ( new File ( DOWNLOAD_DIR , lr_6 ) ) ;
self . addProtocolCommandListener ( new PrintCommandListener ( new PrintWriter ( os ) , true ) ) ;
final Reader is = new FileReader ( lr_7 ) ;
final BufferedReader rdr = new BufferedReader ( is ) ;
String line ;
while( ( line = rdr . readLine () ) != null ) {
if ( line . startsWith ( lr_8 ) ) {
final String [] parts = line . split ( lr_9 ) ;
final String target = parts [ 2 ] ;
host = target . substring ( lr_10 . length () ) ;
final int slash = host . indexOf ( '/' ) ;
path = host . substring ( slash ) ;
host = host . substring ( 0 , slash ) ;
System . out . println ( host + lr_11 + path ) ;
if ( self . open ( host , port ) ) {
try {
self . info () ;
self . download ( path , FTPCmd . LIST , new File ( DOWNLOAD_DIR , host + lr_12 ) ) ;
self . download ( path , FTPCmd . MLSD , new File ( DOWNLOAD_DIR , host + lr_13 ) ) ;
} catch ( final Exception e ) {
e . printStackTrace () ;
} finally {
self . disconnect () ;
}
self . removeProtocolCommandListener ( self . listener ) ;
self . out . close () ;
}
}
}
os . close () ;
rdr . close () ;
}
