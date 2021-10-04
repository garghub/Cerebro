public boolean completePendingCommand () throws IOException
{
return SMTPReply . isPositiveCompletion ( getReply () ) ; MST[NonVoidMethodCallMutator]MSP[]
}
public boolean login ( final String hostname ) throws IOException
{
return SMTPReply . isPositiveCompletion ( helo ( hostname ) ) ;
}
public boolean login () throws IOException
{
String name ;
InetAddress host ;
host = getLocalAddress () ;
name = host . getHostName () ;
if ( name == null ) {
return false ;
}
return SMTPReply . isPositiveCompletion ( helo ( name ) ) ;
}
public boolean setSender ( final RelayPath path ) throws IOException
{
return SMTPReply . isPositiveCompletion ( mail ( path . toString () ) ) ;
}
public boolean setSender ( final String address ) throws IOException
{
return SMTPReply . isPositiveCompletion ( mail ( lr_1 + address + lr_2 ) ) ;
}
public boolean addRecipient ( final RelayPath path ) throws IOException
{
return SMTPReply . isPositiveCompletion ( rcpt ( path . toString () ) ) ;
}
public boolean addRecipient ( final String address ) throws IOException
{
return SMTPReply . isPositiveCompletion ( rcpt ( lr_1 + address + lr_2 ) ) ;
}
public Writer sendMessageData () throws IOException
{
if ( ! SMTPReply . isPositiveIntermediate ( data () ) ) {
return null ;
}
return new DotTerminatedMessageWriter ( writer ) ;
}
public boolean sendShortMessageData ( final String message ) throws IOException
{
try ( Writer writer = sendMessageData () ) {
if ( writer == null ) {
return false ;
}
writer . write ( message ) ;
}
return completePendingCommand () ;
}
public boolean sendSimpleMessage ( final String sender , final String recipient ,
final String message )
throws IOException
{
if ( ! setSender ( sender ) ) {
return false ;
}
if ( ! addRecipient ( recipient ) ) {
return false ;
}
return sendShortMessageData ( message ) ;
}
public boolean sendSimpleMessage ( final String sender , final String [] recipients ,
final String message )
throws IOException
{
boolean oneSuccess = false ;
int count ;
if ( ! setSender ( sender ) ) {
return false ;
}
for ( count = 0 ; count < recipients . length ; count ++ )
{
if ( addRecipient ( recipients [ count ] ) ) {
oneSuccess = true ;
}
}
if ( ! oneSuccess ) {
return false ;
}
return sendShortMessageData ( message ) ;
}
public boolean logout () throws IOException
{
return SMTPReply . isPositiveCompletion ( quit () ) ;
}
public boolean reset () throws IOException
{
return SMTPReply . isPositiveCompletion ( rset () ) ;
}
public boolean verify ( final String username ) throws IOException
{
int result ;
result = vrfy ( username ) ;
return result == SMTPReply . ACTION_OK ||
result == SMTPReply . USER_NOT_LOCAL_WILL_FORWARD ;
}
public String listHelp () throws IOException
{
if ( SMTPReply . isPositiveCompletion ( help () ) ) {
return getReplyString () ;
}
return null ;
}
public String listHelp ( final String command ) throws IOException
{
if ( SMTPReply . isPositiveCompletion ( help ( command ) ) ) {
return getReplyString () ;
}
return null ;
}
public boolean sendNoOp () throws IOException
{
return SMTPReply . isPositiveCompletion ( noop () ) ;
}
