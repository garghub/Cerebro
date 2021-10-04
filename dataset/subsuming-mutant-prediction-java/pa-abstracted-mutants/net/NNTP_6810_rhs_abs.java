private void __getReply () throws IOException
{
replyString = _reader_ . readLine () ;
if ( replyString == null ) {
throw new NNTPConnectionClosedException (
lr_1 ) ;
}
if ( replyString . length () < 3 ) {
throw new MalformedServerReplyException (
lr_2 + replyString ) ;
}
try
{
replyCode = Integer . parseInt ( replyString . substring ( 0 , 3 ) ) ;
}
catch ( final NumberFormatException e )
{
throw new MalformedServerReplyException (
lr_3 + replyString ) ;
}
fireReplyReceived ( replyCode , replyString + SocketClient . NETASCII_EOL ) ;
if ( replyCode == NNTPReply . SERVICE_DISCONTINUED ) {
throw new NNTPConnectionClosedException (
lr_4 ) ;
}
}
@Override
protected void _connectAction_ () throws IOException
{
super . _connectAction_ () ;
_reader_ =
new CRLFLineReader ( new InputStreamReader ( _input_ ,
DEFAULT_ENCODING ) ) ;
_writer_ =
new BufferedWriter ( new OutputStreamWriter ( _output_ ,
DEFAULT_ENCODING ) ) ;
__getReply () ;
_isAllowedToPost = replyCode == NNTPReply . SERVER_READY_POSTING_ALLOWED ;
}
@Override
public void disconnect () throws IOException
{
super . disconnect () ;
_reader_ = null ;
_writer_ = null ;
replyString = null ;
_isAllowedToPost = false ;
}
public boolean isAllowedToPost ()
{
return _isAllowedToPost ;
}
public int sendCommand ( final String command , final String args ) throws IOException
{
final StringBuilder __commandBuffer = new StringBuilder () ;
__commandBuffer . append ( command ) ;
if ( args != null )
{
__commandBuffer . append ( ' ' ) ;
__commandBuffer . append ( args ) ;
}
__commandBuffer . append ( SocketClient . NETASCII_EOL ) ;
String message ;
_writer_ . write ( message = __commandBuffer . toString () ) ;
_writer_ . flush () ;
fireCommandSent ( command , message ) ;
__getReply () ;
return replyCode ;
}
public int sendCommand ( final int command , final String args ) throws IOException
{
return sendCommand ( NNTPCommand . getCommand ( command ) , args ) ;
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
return replyCode ;
}
public int getReply () throws IOException
{
__getReply () ;
return replyCode ;
}
public String getReplyString ()
{
return replyString ;
}
public int article ( final String messageId ) throws IOException
{
return sendCommand ( NNTPCommand . ARTICLE , messageId ) ;
}
public int article ( final long articleNumber ) throws IOException
{
return sendCommand ( NNTPCommand . ARTICLE , Long . toString ( articleNumber ) ) ;
}
public int article () throws IOException
{
return sendCommand ( NNTPCommand . ARTICLE ) ;
}
public int body ( final String messageId ) throws IOException
{
return sendCommand ( NNTPCommand . BODY , messageId ) ;
}
public int body ( final long articleNumber ) throws IOException
{
return sendCommand ( NNTPCommand . BODY , Long . toString ( articleNumber ) ) ;
}
public int body () throws IOException
{
return sendCommand ( NNTPCommand . BODY ) ;
}
public int head ( final String messageId ) throws IOException
{
return sendCommand ( NNTPCommand . HEAD , messageId ) ;
}
public int head ( final long articleNumber ) throws IOException
{
return sendCommand ( NNTPCommand . HEAD , Long . toString ( articleNumber ) ) ;
}
public int head () throws IOException
{
return sendCommand ( NNTPCommand . HEAD ) ;
}
public int stat ( final String messageId ) throws IOException
{
return sendCommand ( NNTPCommand . STAT , messageId ) ;
}
public int stat ( final long articleNumber ) throws IOException
{
return sendCommand ( NNTPCommand . STAT , Long . toString ( articleNumber ) ) ;
}
public int stat () throws IOException
{
return sendCommand ( NNTPCommand . STAT ) ;
}
public int group ( final String newsgroup ) throws IOException
{
return sendCommand ( NNTPCommand . GROUP , newsgroup ) ;
}
public int help () throws IOException
{
return sendCommand ( NNTPCommand . HELP ) ;
}
public int ihave ( final String messageId ) throws IOException
{
return sendCommand ( NNTPCommand . IHAVE , messageId ) ;
}
public int last () throws IOException
{
return sendCommand ( NNTPCommand . LAST ) ;
}
public int list () throws IOException
{
return sendCommand ( NNTPCommand . LIST ) ;
}
public int next () throws IOException
{
return sendCommand ( NNTPCommand . NEXT ) ;
}
public int newgroups ( final String date , final String time , final boolean GMT ,
final String distributions ) throws IOException
{
final StringBuilder buffer = new StringBuilder () ;
buffer . append ( date ) ;
buffer . append ( ' ' ) ;
buffer . append ( time ) ;
if ( GMT )
{
buffer . append ( ' ' ) ;
buffer . append ( lr_5 ) ;
}
if ( distributions != null )
{
buffer . append ( lr_6 ) ;
buffer . append ( distributions ) ;
buffer . append ( '>' ) ;
}
return sendCommand ( NNTPCommand . NEWGROUPS , buffer . toString () ) ;
}
public int newnews ( final String newsgroups , final String date , final String time , final boolean GMT ,
final String distributions ) throws IOException
{
final StringBuilder buffer = new StringBuilder () ;
buffer . append ( newsgroups ) ;
buffer . append ( ' ' ) ;
buffer . append ( date ) ;
buffer . append ( ' ' ) ;
buffer . append ( time ) ;
if ( GMT )
{
buffer . append ( ' ' ) ;
buffer . append ( lr_5 ) ;
}
if ( distributions != null )
{
buffer . append ( lr_6 ) ;
buffer . append ( distributions ) ;
buffer . append ( '>' ) ;
}
return sendCommand ( NNTPCommand . NEWNEWS , buffer . toString () ) ;
}
public int post () throws IOException
{
return sendCommand ( NNTPCommand . POST ) ;
}
public int quit () throws IOException
{
return sendCommand ( NNTPCommand . QUIT ) ;
}
public int authinfoUser ( final String username ) throws IOException {
final String userParameter = lr_7 + username ;
return sendCommand ( NNTPCommand . AUTHINFO , userParameter ) ;
}
public int authinfoPass ( final String password ) throws IOException {
final String passParameter = lr_8 + password ;
return sendCommand ( NNTPCommand . AUTHINFO , passParameter ) ;
}
public int xover ( final String selectedArticles ) throws IOException {
return sendCommand ( NNTPCommand . XOVER , selectedArticles ) ;
}
public int xhdr ( final String header , final String selectedArticles ) throws IOException {
final StringBuilder command = new StringBuilder ( header ) ;
command . append ( lr_9 ) ;
command . append ( selectedArticles ) ;
return sendCommand ( NNTPCommand . XHDR , command . toString () ) ; MST[rv.CRCR1Mutator]MSP[N]
}
public int listActive ( final String wildmat ) throws IOException {
final StringBuilder command = new StringBuilder ( lr_10 ) ;
command . append ( wildmat ) ;
return sendCommand ( NNTPCommand . LIST , command . toString () ) ;
}
@Deprecated
public int article ( final int a ) throws IOException
{
return article ( ( long ) a ) ;
}
@Deprecated
public int body ( final int a ) throws IOException
{
return body ( ( long ) a ) ;
}
@Deprecated
public int head ( final int a ) throws IOException
{
return head ( ( long ) a ) ;
}
@Deprecated
public int stat ( final int a ) throws IOException
{
return stat ( ( long ) a ) ;
}
@Override
protected ProtocolCommandSupport getCommandSupport () {
return _commandSupport_ ;
}
