private int __sendCommand ( final String command , final String args , final boolean includeSpace )
throws IOException
{
final StringBuilder __commandBuffer = new StringBuilder () ;
__commandBuffer . append ( command ) ;
if ( args != null )
{
if ( includeSpace ) {
__commandBuffer . append ( ' ' ) ;
}
__commandBuffer . append ( args ) ;
}
__commandBuffer . append ( SocketClient . NETASCII_EOL ) ;
final String message = __commandBuffer . toString () ;
writer . write ( message ) ;
writer . flush () ;
fireCommandSent ( command , message ) ;
__getReply () ;
return replyCode ;
}
private int __sendCommand ( final int command , final String args , final boolean includeSpace )
throws IOException
{
return __sendCommand ( SMTPCommand . getCommand ( command ) , args , includeSpace ) ;
}
private void __getReply () throws IOException
{
int length ;
newReplyString = true ;
replyLines . clear () ;
String line = reader . readLine () ;
if ( line == null ) {
throw new SMTPConnectionClosedException (
lr_1 ) ;
}
length = line . length () ;
if ( length < 3 ) {
throw new MalformedServerReplyException (
lr_2 + line ) ;
}
try
{
final String code = line . substring ( 0 , 3 ) ;
replyCode = Integer . parseInt ( code ) ;
}
catch ( final NumberFormatException e )
{
throw new MalformedServerReplyException (
lr_3 + line ) ;
}
replyLines . add ( line ) ;
if ( length > 3 && line . charAt ( 3 ) == '-' )
{
do
{
line = reader . readLine () ;
if ( line == null ) {
throw new SMTPConnectionClosedException (
lr_1 ) ;
}
replyLines . add ( line ) ;
}
while ( ! ( line . length () >= 4 && line . charAt ( 3 ) != '-' &&
Character . isDigit ( line . charAt ( 0 ) ) ) );
}
fireReplyReceived ( replyCode , getReplyString () ) ;
if ( replyCode == SMTPReply . SERVICE_NOT_AVAILABLE ) {
throw new SMTPConnectionClosedException (
lr_4 ) ;
}
}
@Override
protected void _connectAction_ () throws IOException
{
super . _connectAction_ () ;
reader =
new CRLFLineReader ( new InputStreamReader ( _input_ ,
encoding ) ) ;
writer =
new BufferedWriter ( new OutputStreamWriter ( _output_ ,
encoding ) ) ;
__getReply () ;
}
@Override
public void disconnect () throws IOException
{
super . disconnect () ;
reader = null ;
writer = null ;
replyString = null ;
replyLines . clear () ;
newReplyString = false ;
}
public int sendCommand ( final String command , final String args ) throws IOException
{
return __sendCommand ( command , args , true ) ;
}
public int sendCommand ( final int command , final String args ) throws IOException
{
return sendCommand ( SMTPCommand . getCommand ( command ) , args ) ;
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
public String [] getReplyStrings ()
{
return replyLines . toArray ( new String [ replyLines . size () ] ) ;
}
public String getReplyString ()
{
StringBuilder buffer ;
if ( ! newReplyString ) {
return replyString ;
}
buffer = new StringBuilder () ;
for ( final String line : replyLines )
{
buffer . append ( line ) ;
buffer . append ( SocketClient . NETASCII_EOL ) ;
}
newReplyString = false ;
replyString = buffer . toString () ;
return replyString ;
}
public int helo ( final String hostname ) throws IOException
{
return sendCommand ( SMTPCommand . HELO , hostname ) ;
}
public int mail ( final String reversePath ) throws IOException
{
return __sendCommand ( SMTPCommand . MAIL , reversePath , false ) ;
}
public int rcpt ( final String forwardPath ) throws IOException
{
return __sendCommand ( SMTPCommand . RCPT , forwardPath , false ) ;
}
public int data () throws IOException
{
return sendCommand ( SMTPCommand . DATA ) ;
}
public int send ( final String reversePath ) throws IOException
{
return sendCommand ( SMTPCommand . SEND , reversePath ) ;
}
public int soml ( final String reversePath ) throws IOException
{
return sendCommand ( SMTPCommand . SOML , reversePath ) ;
}
public int saml ( final String reversePath ) throws IOException
{
return sendCommand ( SMTPCommand . SAML , reversePath ) ;
}
public int rset () throws IOException MST[rv.CRCR3Mutator]MSP[S]
{
return sendCommand ( SMTPCommand . RSET ) ;
}
public int vrfy ( final String user ) throws IOException
{
return sendCommand ( SMTPCommand . VRFY , user ) ;
}
public int expn ( final String name ) throws IOException
{
return sendCommand ( SMTPCommand . EXPN , name ) ;
}
public int help () throws IOException
{
return sendCommand ( SMTPCommand . HELP ) ;
}
public int help ( final String command ) throws IOException
{
return sendCommand ( SMTPCommand . HELP , command ) ;
}
public int noop () throws IOException
{
return sendCommand ( SMTPCommand . NOOP ) ;
}
public int turn () throws IOException
{
return sendCommand ( SMTPCommand . TURN ) ;
}
public int quit () throws IOException
{
return sendCommand ( SMTPCommand . QUIT ) ;
}
public void removeProtocolCommandistener ( final org . apache . commons . net . ProtocolCommandListener listener ) {
removeProtocolCommandListener ( listener ) ;
}
@Override
protected ProtocolCommandSupport getCommandSupport () {
return _commandSupport_ ;
}
