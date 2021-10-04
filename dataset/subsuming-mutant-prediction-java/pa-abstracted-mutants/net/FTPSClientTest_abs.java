@Parameters ( name = lr_1 )
public static Boolean [] testConstructurData () {
return new Boolean [] { Boolean . FALSE , Boolean . TRUE } ;
}
@AfterClass
public static void afterClass () {
if ( TlsProtocols == null ) {
System . getProperties () . remove ( JDK_TLS_CLIENT_PROTOCOLS ) ;
} else {
System . setProperty ( JDK_TLS_CLIENT_PROTOCOLS , TlsProtocols ) ;
}
}
private static String getTestHomeDirectory () {
return System . getProperty ( lr_2 , lr_3 ) ;
}
@BeforeClass
public static void setUpClass () throws Exception {
TlsProtocols = System . getProperty ( JDK_TLS_CLIENT_PROTOCOLS ) ;
System . setProperty ( JDK_TLS_CLIENT_PROTOCOLS , lr_4 ) ;
setUpClass ( implicit ) ;
}
static void setUpClass ( final boolean implicit ) throws FtpException , IOException {
if ( Server != null ) {
return;
}
SocketPort = 0 ;
final FtpServerFactory serverFactory = new FtpServerFactory () ;
final PropertiesUserManagerFactory propertiesUserManagerFactory = new PropertiesUserManagerFactory () ;
final URL userPropsResource = ClassLoader . getSystemClassLoader () . getResource ( USER_PROPS_RES ) ;
Assert . assertNotNull ( USER_PROPS_RES , userPropsResource ) ;
propertiesUserManagerFactory . setUrl ( userPropsResource ) ;
final UserManager userManager = propertiesUserManagerFactory . createUserManager () ;
final BaseUser user = ( BaseUser ) userManager . getUserByName ( lr_5 ) ;
user . setHomeDirectory ( getTestHomeDirectory () ) ;
serverFactory . setUserManager ( userManager ) ;
final ListenerFactory factory = new ListenerFactory () ;
factory . setPort ( SocketPort ) ;
final URL serverJksResource = ClassLoader . getSystemClassLoader () . getResource ( SERVER_JKS_RES ) ;
Assert . assertNotNull ( SERVER_JKS_RES , serverJksResource ) ;
final SslConfigurationFactory sllConfigFactory = new SslConfigurationFactory () ;
final File keyStoreFile = FileUtils . toFile ( serverJksResource ) ;
Assert . assertTrue ( keyStoreFile . toString () , keyStoreFile . exists () ) ;
sllConfigFactory . setKeystoreFile ( keyStoreFile ) ;
sllConfigFactory . setKeystorePassword ( lr_6 ) ;
sllConfigFactory . setSslProtocol ( lr_7 ) ;
factory . setSslConfiguration ( sllConfigFactory . createSslConfiguration () ) ;
factory . setImplicitSsl ( implicit ) ;
serverFactory . addListener ( lr_8 , factory . createListener () ) ;
Server = serverFactory . createServer () ;
Server . start () ;
SocketPort = ( ( org . apache . ftpserver . impl . DefaultFtpServer ) Server ) . getListener ( lr_8 ) . getPort () ;
ConnectionUri = lr_9 + SocketPort ;
}
private void assertClientCode ( final FTPSClient client ) {
final int replyCode = client . getReplyCode () ;
assertTrue ( FTPReply . isPositiveCompletion ( replyCode ) ) ;
}
private FTPSClient loginClient () throws SocketException , IOException {
final FTPSClient client = new FTPSClient ( implicit ) ;
client . setEndpointCheckingEnabled ( endpointCheckingEnabled ) ;
client . connect ( lr_10 , SocketPort ) ;
assertClientCode ( client ) ;
assertEquals ( SocketPort , client . getRemotePort () ) ;
assertTrue ( client . login ( lr_5 , lr_5 ) ) ;
assertClientCode ( client ) ;
client . setFileType ( FTP . BINARY_FILE_TYPE ) ;
assertClientCode ( client ) ;
client . execPBSZ ( 0 ) ;
assertClientCode ( client ) ;
client . execPROT ( lr_11 ) ;
assertClientCode ( client ) ;
return client ;
}
private void retrieveFile ( final String pathname ) throws SocketException , IOException {
final FTPSClient client = loginClient () ;
try {
assertTrue ( pathname , client . retrieveFile ( pathname , NullOutputStream . NULL_OUTPUT_STREAM ) ) ;
assertTrue ( pathname , client . retrieveFile ( pathname , NullOutputStream . NULL_OUTPUT_STREAM ) ) ;
} finally {
client . disconnect () ;
}
}
private void testListFiles ( final String pathname ) throws SocketException , IOException {
final FTPSClient client = loginClient () ;
try {
assertNotNull ( client . listFiles ( pathname ) ) ;
assertNotNull ( client . listFiles ( pathname ) ) ;
} finally {
client . disconnect () ;
}
}
@Test
public void testListFilesPathNameEmpty () throws SocketException , IOException {
testListFiles ( lr_12 ) ;
}
@Test
public void testListFilesPathNameJunk () throws SocketException , IOException {
testListFiles ( lr_13 ) ;
}
@Test
public void testListFilesPathNameNull () throws SocketException , IOException {
testListFiles ( null ) ;
}
@Test
public void testListFilesPathNameRoot () throws SocketException , IOException {
testListFiles ( lr_14 ) ;
}
@Test
public void testOpenClose () throws SocketException , IOException {
loginClient () . disconnect () ;
}
@Test
public void testRetrieveFilePathNameRoot () throws SocketException , IOException {
retrieveFile ( lr_15 ) ;
}
