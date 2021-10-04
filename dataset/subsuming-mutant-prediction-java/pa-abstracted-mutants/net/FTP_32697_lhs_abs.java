private boolean __strictCheck ( final String line , final String code ) {
return ! ( line . startsWith ( code ) && line . charAt ( REPLY_CODE_LEN ) == ' ' ) ;
}
private boolean __lenientCheck ( final String line ) {
return ! ( line . length () > REPLY_CODE_LEN && line . charAt ( REPLY_CODE_LEN ) != '-' &&
Character . isDigit ( line . charAt ( 0 ) ) ) ;
}
private void __getReply () throws IOException
{
__getReply ( true ) ;
}
protected void __getReplyNoReport () throws IOException
{
__getReply ( false ) ;
}
private void __getReply ( final boolean reportReply ) throws IOException
{
int length ;
_newReplyString = true ;
_replyLines . clear () ;
String line = _controlInput_ . readLine () ;
if ( line == null ) {
throw new FTPConnectionClosedException (
lr_1 ) ;
}
length = line . length () ;
if ( length < REPLY_CODE_LEN ) {
throw new MalformedServerReplyException (
lr_2 + line ) ;
}
String code = null ;
try
{
code = line . substring ( 0 , REPLY_CODE_LEN ) ;
_replyCode = Integer . parseInt ( code ) ;
}
catch ( final NumberFormatException e )
{
throw new MalformedServerReplyException (
lr_3 + line ) ;
}
_replyLines . add ( line ) ;
if ( length > REPLY_CODE_LEN ) {
final char sep = line . charAt ( REPLY_CODE_LEN ) ;
if ( sep == '-' ) {
do
{
line = _controlInput_ . readLine () ;
if ( line == null ) {
throw new FTPConnectionClosedException (
lr_1 ) ;
}
_replyLines . add ( line ) ;
}
while ( isStrictMultilineParsing () ? __strictCheck ( line , code ) : __lenientCheck ( line ) );
} else if ( isStrictReplyParsing () ) {
if ( length == REPLY_CODE_LEN + 1 ) {
throw new MalformedServerReplyException ( lr_4 + line + lr_5 ) ;
} else if ( sep != ' ' ) {
throw new MalformedServerReplyException ( lr_6 + line + lr_5 ) ;
}
}
} else if ( isStrictReplyParsing () ) {
throw new MalformedServerReplyException ( lr_4 + line + lr_5 ) ;
}
if ( reportReply ) {
fireReplyReceived ( _replyCode , getReplyString () ) ;
}
if ( _replyCode == FTPReply . SERVICE_NOT_AVAILABLE ) {
throw new FTPConnectionClosedException ( lr_7 ) ;
}
}
@Override
protected void _connectAction_ () throws IOException
{
_connectAction_ ( null ) ;
}
protected void _connectAction_ ( final Reader socketIsReader ) throws IOException {
super . _connectAction_ () ;
if( socketIsReader == null ) {
_controlInput_ =
new CRLFLineReader ( new InputStreamReader ( _input_ , getControlEncoding () ) ) ;
} else {
_controlInput_ = new CRLFLineReader ( socketIsReader ) ;
}
_controlOutput_ =
new BufferedWriter ( new OutputStreamWriter ( _output_ , getControlEncoding () ) ) ;
if ( connectTimeout > 0 ) {
final int original = _socket_ . getSoTimeout () ;
_socket_ . setSoTimeout ( connectTimeout ) ;
try {
__getReply () ;
if ( FTPReply . isPositivePreliminary ( _replyCode ) ) {
__getReply () ;
}
} catch ( final SocketTimeoutException e ) {
final IOException ioe = new IOException ( lr_8 ) ;
ioe . initCause ( e ) ;
throw ioe ;
} finally {
_socket_ . setSoTimeout ( original ) ;
}
} else {
__getReply () ;
if ( FTPReply . isPositivePreliminary ( _replyCode ) ) {
__getReply () ;
}
}
}
public void setControlEncoding ( final String encoding ) {
_controlEncoding = encoding ;
}
public String getControlEncoding () {
return _controlEncoding ;
}
@Override
public void disconnect () throws IOException
{
super . disconnect () ;
_controlInput_ = null ;
_controlOutput_ = null ;
_newReplyString = false ;
_replyString = null ;
}
public int sendCommand ( final String command , final String args ) throws IOException
{
if ( _controlOutput_ == null ) {
throw new IOException ( lr_9 ) ;
}
final String message = __buildMessage ( command , args ) ;
__send ( message ) ;
fireCommandSent ( command , message ) ;
__getReply () ;
return _replyCode ;
}
private String __buildMessage ( final String command , final String args ) {
final StringBuilder __commandBuffer = new StringBuilder () ;
__commandBuffer . append ( command ) ;
if ( args != null )
{
__commandBuffer . append ( ' ' ) ;
__commandBuffer . append ( args ) ;
}
__commandBuffer . append ( SocketClient . NETASCII_EOL ) ;
return __commandBuffer . toString () ;
}
private void __send ( final String message ) throws IOException ,
FTPConnectionClosedException , SocketException {
try{
_controlOutput_ . write ( message ) ;
_controlOutput_ . flush () ;
}
catch ( final SocketException e )
{
if ( ! isConnected () )
{
throw new FTPConnectionClosedException ( lr_10 ) ;
}
throw e ;
}
}
protected void __noop () throws IOException {
final String msg = __buildMessage ( FTPCmd . NOOP . getCommand () , null ) ;
__send ( msg ) ;
__getReplyNoReport () ;
}
@Deprecated
public int sendCommand ( final int command , final String args ) throws IOException
{
return sendCommand ( FTPCommand . getCommand ( command ) , args ) ;
}
public int sendCommand ( final FTPCmd command ) throws IOException {
return sendCommand ( command , null ) ;
}
public int sendCommand ( final FTPCmd command , final String args ) throws IOException {
return sendCommand ( command . getCommand () , args ) ;
}
public int sendCommand ( final String command ) throws IOException
{
return sendCommand ( command , null ) ;
}
public int sendCommand ( final int command ) throws IOException
{
return sendCommand ( command , null ) ;
}
public int getReplyCode ()
{
return _replyCode ;
}
public int getReply () throws IOException
{
__getReply () ;
return _replyCode ;
}
public String [] getReplyStrings ()
{
return _replyLines . toArray ( new String [ _replyLines . size () ] ) ;
}
public String getReplyString ()
{
StringBuilder buffer ;
if ( ! _newReplyString ) {
return _replyString ;
}
buffer = new StringBuilder ( 256 ) ;
for ( final String line : _replyLines ) {
buffer . append ( line ) ;
buffer . append ( SocketClient . NETASCII_EOL ) ;
}
_newReplyString = false ;
return _replyString = buffer . toString () ;
}
public int user ( final String username ) throws IOException
{
return sendCommand ( FTPCmd . USER , username ) ;
}
public int pass ( final String password ) throws IOException
{
return sendCommand ( FTPCmd . PASS , password ) ;
}
public int acct ( final String account ) throws IOException
{
return sendCommand ( FTPCmd . ACCT , account ) ;
}
public int abor () throws IOException
{
return sendCommand ( FTPCmd . ABOR ) ;
}
public int cwd ( final String directory ) throws IOException
{
return sendCommand ( FTPCmd . CWD , directory ) ;
}
public int cdup () throws IOException
{
return sendCommand ( FTPCmd . CDUP ) ;
}
public int quit () throws IOException
{
return sendCommand ( FTPCmd . QUIT ) ;
}
public int rein () throws IOException
{
return sendCommand ( FTPCmd . REIN ) ;
}
public int smnt ( final String dir ) throws IOException
{
return sendCommand ( FTPCmd . SMNT , dir ) ;
}
public int port ( final InetAddress host , final int port ) throws IOException
{
int num ;
final StringBuilder info = new StringBuilder ( 24 ) ;
info . append ( host . getHostAddress () . replace ( '.' , ',' ) ) ;
num = port >>> 8 ;
info . append ( ',' ) ;
info . append ( num ) ;
info . append ( ',' ) ;
num = port & 0xff ;
info . append ( num ) ;
return sendCommand ( FTPCmd . PORT , info . toString () ) ;
}
public int eprt ( final InetAddress host , final int port ) throws IOException
{
int num ;
final StringBuilder info = new StringBuilder () ;
String h ;
h = host . getHostAddress () ;
num = h . indexOf ( '%' ) ;
if ( num > 0 ) {
h = h . substring ( 0 , num ) ;
}
info . append ( lr_11 ) ;
if ( host instanceof Inet4Address ) {
info . append ( lr_12 ) ;
} else if ( host instanceof Inet6Address ) {
info . append ( lr_13 ) ;
}
info . append ( lr_11 ) ;
info . append ( h ) ;
info . append ( lr_11 ) ;
info . append ( port ) ;
info . append ( lr_11 ) ;
return sendCommand ( FTPCmd . EPRT , info . toString () ) ;
}
public int pasv () throws IOException
{
return sendCommand ( FTPCmd . PASV ) ;
}
public int epsv () throws IOException
{
return sendCommand ( FTPCmd . EPSV ) ; MST[rv.UOI3Mutator]MSP[]
}
public int type ( final int fileType , final int formatOrByteSize ) throws IOException
{
final StringBuilder arg = new StringBuilder () ;
arg . append ( modes . charAt ( fileType ) ) ;
arg . append ( ' ' ) ;
if ( fileType == LOCAL_FILE_TYPE ) {
arg . append ( formatOrByteSize ) ;
} else {
arg . append ( modes . charAt ( formatOrByteSize ) ) ;
}
return sendCommand ( FTPCmd . TYPE , arg . toString () ) ;
}
public int type ( final int fileType ) throws IOException
{
return sendCommand ( FTPCmd . TYPE ,
modes . substring ( fileType , fileType + 1 ) ) ;
}
public int stru ( final int structure ) throws IOException
{
return sendCommand ( FTPCmd . STRU ,
modes . substring ( structure , structure + 1 ) ) ;
}
public int mode ( final int mode ) throws IOException
{
return sendCommand ( FTPCmd . MODE ,
modes . substring ( mode , mode + 1 ) ) ;
}
public int retr ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . RETR , pathname ) ;
}
public int stor ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . STOR , pathname ) ;
}
public int stou () throws IOException
{
return sendCommand ( FTPCmd . STOU ) ;
}
public int stou ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . STOU , pathname ) ;
}
public int appe ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . APPE , pathname ) ;
}
public int allo ( final int bytes ) throws IOException
{
return sendCommand ( FTPCmd . ALLO , Integer . toString ( bytes ) ) ;
}
public int allo ( final long bytes ) throws IOException
{
return sendCommand ( FTPCmd . ALLO , Long . toString ( bytes ) ) ;
}
public int feat () throws IOException
{
return sendCommand ( FTPCmd . FEAT ) ;
}
public int allo ( final int bytes , final int recordSize ) throws IOException
{
return sendCommand ( FTPCmd . ALLO , Integer . toString ( bytes ) + lr_14 +
Integer . toString ( recordSize ) ) ;
}
public int allo ( final long bytes , final int recordSize ) throws IOException
{
return sendCommand ( FTPCmd . ALLO , Long . toString ( bytes ) + lr_14 +
Integer . toString ( recordSize ) ) ;
}
public int rest ( final String marker ) throws IOException
{
return sendCommand ( FTPCmd . REST , marker ) ;
}
public int mdtm ( final String file ) throws IOException
{
return sendCommand ( FTPCmd . MDTM , file ) ;
}
public int mfmt ( final String pathname , final String timeval ) throws IOException
{
return sendCommand ( FTPCmd . MFMT , timeval + lr_15 + pathname ) ;
}
public int rnfr ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . RNFR , pathname ) ;
}
public int rnto ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . RNTO , pathname ) ;
}
public int dele ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . DELE , pathname ) ;
}
public int rmd ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . RMD , pathname ) ;
}
public int mkd ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . MKD , pathname ) ;
}
public int pwd () throws IOException
{
return sendCommand ( FTPCmd . PWD ) ;
}
public int list () throws IOException
{
return sendCommand ( FTPCmd . LIST ) ;
}
public int list ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . LIST , pathname ) ;
}
public int mlsd () throws IOException
{
return sendCommand ( FTPCmd . MLSD ) ;
}
public int mlsd ( final String path ) throws IOException
{
return sendCommand ( FTPCmd . MLSD , path ) ;
}
public int mlst () throws IOException
{
return sendCommand ( FTPCmd . MLST ) ;
}
public int mlst ( final String path ) throws IOException
{
return sendCommand ( FTPCmd . MLST , path ) ;
}
public int nlst () throws IOException
{
return sendCommand ( FTPCmd . NLST ) ;
}
public int nlst ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . NLST , pathname ) ;
}
public int site ( final String parameters ) throws IOException
{
return sendCommand ( FTPCmd . SITE , parameters ) ;
}
public int size ( final String parameters ) throws IOException
{
return sendCommand ( FTPCmd . SIZE , parameters ) ;
}
public int syst () throws IOException
{
return sendCommand ( FTPCmd . SYST ) ;
}
public int stat () throws IOException
{
return sendCommand ( FTPCmd . STAT ) ;
}
public int stat ( final String pathname ) throws IOException
{
return sendCommand ( FTPCmd . STAT , pathname ) ;
}
public int help () throws IOException
{
return sendCommand ( FTPCmd . HELP ) ;
}
public int help ( final String command ) throws IOException
{
return sendCommand ( FTPCmd . HELP , command ) ;
}
public int noop () throws IOException
{
return sendCommand ( FTPCmd . NOOP ) ;
}
public boolean isStrictMultilineParsing () {
return strictMultilineParsing ;
}
public void setStrictMultilineParsing ( final boolean strictMultilineParsing ) {
this . strictMultilineParsing = strictMultilineParsing ;
}
public boolean isStrictReplyParsing () {
return strictReplyParsing ;
}
public void setStrictReplyParsing ( final boolean strictReplyParsing ) {
this . strictReplyParsing = strictReplyParsing ;
}
@Override
protected ProtocolCommandSupport getCommandSupport () {
return _commandSupport_ ;
}
