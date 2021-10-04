@Override
public boolean chunkReceived ( final IMAP imap ) {
return true ;
}
private void getReply () throws IOException
{
getReply ( true ) ;
}
private void getReply ( final boolean wantTag ) throws IOException
{
_replyLines . clear () ;
String line = _reader . readLine () ;
if ( line == null ) {
throw new EOFException ( lr_1 ) ;
}
_replyLines . add ( line ) ;
if ( wantTag ) {
while( IMAPReply . isUntagged ( line ) ) {
int literalCount = IMAPReply . literalCount ( line ) ;
final boolean isMultiLine = literalCount >= 0 ;
while ( literalCount >= 0 ) {
line = _reader . readLine () ;
if ( line == null ) {
throw new EOFException ( lr_1 ) ;
}
_replyLines . add ( line ) ;
literalCount -= line . length () + 2 ;
}
if ( isMultiLine ) {
final IMAPChunkListener il = chunkListener ;
if ( il != null ) {
final boolean clear = il . chunkReceived ( this ) ;
if ( clear ) {
fireReplyReceived ( IMAPReply . PARTIAL , getReplyString () ) ;
_replyLines . clear () ;
}
}
}
line = _reader . readLine () ;
if ( line == null ) {
throw new EOFException ( lr_1 ) ;
}
_replyLines . add ( line ) ;
}
replyCode = IMAPReply . getReplyCode ( line ) ;
} else {
replyCode = IMAPReply . getUntaggedReplyCode ( line ) ;
}
fireReplyReceived ( replyCode , getReplyString () ) ;
}
@Override
protected void fireReplyReceived ( final int replyCode , final String ignored ) {
if ( getCommandSupport () . getListenerCount () > 0 ) {
getCommandSupport () . fireReplyReceived ( replyCode , getReplyString () ) ;
}
}
@Override
protected void _connectAction_ () throws IOException
{
super . _connectAction_ () ;
_reader =
new CRLFLineReader ( new InputStreamReader ( _input_ ,
__DEFAULT_ENCODING ) ) ;
__writer =
new BufferedWriter ( new OutputStreamWriter ( _output_ ,
__DEFAULT_ENCODING ) ) ;
final int tmo = getSoTimeout () ;
if ( tmo <= 0 ) {
setSoTimeout ( connectTimeout ) ;
}
getReply ( false ) ;
if ( tmo <= 0 ) {
setSoTimeout ( tmo ) ;
}
setState ( IMAPState . NOT_AUTH_STATE ) ;
}
protected void setState ( final IMAP . IMAPState state )
{
this . state = state ;
}
public IMAP . IMAPState getState ()
{
return state ;
}
@Override
public void disconnect () throws IOException
{
super . disconnect () ;
_reader = null ;
__writer = null ;
_replyLines . clear () ;
setState ( IMAPState . DISCONNECTED_STATE ) ;
}
private int sendCommandWithID ( final String commandID , final String command , final String args ) throws IOException
{
final StringBuilder __commandBuffer = new StringBuilder () ;
if ( commandID != null )
{
__commandBuffer . append ( commandID ) ;
__commandBuffer . append ( ' ' ) ;
}
__commandBuffer . append ( command ) ;
if ( args != null )
{
__commandBuffer . append ( ' ' ) ;
__commandBuffer . append ( args ) ;
}
__commandBuffer . append ( SocketClient . NETASCII_EOL ) ;
final String message = __commandBuffer . toString () ;
__writer . write ( message ) ;
__writer . flush () ;
fireCommandSent ( command , message ) ;
getReply () ;
return replyCode ;
}
public int sendCommand ( final String command , final String args ) throws IOException
{
return sendCommandWithID ( generateCommandID () , command , args ) ;
}
public int sendCommand ( final String command ) throws IOException
{
return sendCommand ( command , null ) ;
}
public int sendCommand ( final IMAPCommand command , final String args ) throws IOException
{
return sendCommand ( command . getIMAPCommand () , args ) ;
}
public boolean doCommand ( final IMAPCommand command , final String args ) throws IOException
{
return IMAPReply . isSuccess ( sendCommand ( command , args ) ) ;
}
public int sendCommand ( final IMAPCommand command ) throws IOException
{
return sendCommand ( command , null ) ;
}
public boolean doCommand ( final IMAPCommand command ) throws IOException
{
return IMAPReply . isSuccess ( sendCommand ( command ) ) ;
}
public int sendData ( final String command ) throws IOException
{
return sendCommandWithID ( null , command , null ) ;
}
public String [] getReplyStrings ()
{
return _replyLines . toArray ( new String [ _replyLines . size () ] ) ;
}
public String getReplyString ()
{
final StringBuilder buffer = new StringBuilder ( 256 ) ;
for ( final String s : _replyLines )
{
buffer . append ( s ) ;
buffer . append ( SocketClient . NETASCII_EOL ) ;
}
return buffer . toString () ;
}
public void setChunkListener ( final IMAPChunkListener listener ) { MST[rv.UOI2Mutator]MSP[S]
chunkListener = listener ;
}
protected String generateCommandID ()
{
final String res = new String ( initialID ) ;
boolean carry = true ;
for ( int i = initialID . length - 1 ; carry && i >= 0 ; i -- )
{
if ( initialID [ i ] == 'Z' )
{
initialID [ i ] = 'A' ;
}
else
{
initialID [ i ] ++ ;
carry = false ;
}
}
return res ;
}
static String quoteMailboxName ( final String input ) {
if ( input == null ) {
return null ;
}
if ( input . isEmpty () ) {
return lr_2 ;
}
if ( input . length () > 1 && input . startsWith ( lr_3 ) && input . endsWith ( lr_3 ) ) {
return input ;
}
if ( input . contains ( lr_4 ) ) {
return lr_3 + input . replaceAll ( lr_5 , lr_6 ) + lr_3 ;
}
return input ;
}
