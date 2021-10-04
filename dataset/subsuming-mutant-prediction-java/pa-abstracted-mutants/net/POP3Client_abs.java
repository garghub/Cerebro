private static POP3MessageInfo parseStatus ( final String line )
{
int num , size ;
StringTokenizer tokenizer ;
tokenizer = new StringTokenizer ( line ) ;
if ( ! tokenizer . hasMoreElements () ) {
return null ;
}
num = size = 0 ;
try
{
num = Integer . parseInt ( tokenizer . nextToken () ) ;
if ( ! tokenizer . hasMoreElements () ) {
return null ;
}
size = Integer . parseInt ( tokenizer . nextToken () ) ;
}
catch ( final NumberFormatException e )
{
return null ;
}
return new POP3MessageInfo ( num , size ) ;
}
private static POP3MessageInfo parseUID ( String line )
{
int num ;
StringTokenizer tokenizer ;
tokenizer = new StringTokenizer ( line ) ;
if ( ! tokenizer . hasMoreElements () ) {
return null ;
}
num = 0 ;
try
{
num = Integer . parseInt ( tokenizer . nextToken () ) ;
if ( ! tokenizer . hasMoreElements () ) {
return null ;
}
line = tokenizer . nextToken () ;
}
catch ( final NumberFormatException e )
{
return null ;
}
return new POP3MessageInfo ( num , line ) ;
}
public boolean capa () throws IOException
{
if ( sendCommand ( POP3Command . CAPA ) == POP3Reply . OK ) {
getAdditionalReply () ;
return true ;
}
return false ;
}
public boolean login ( final String username , final String password ) throws IOException
{
if ( getState () != AUTHORIZATION_STATE ) {
return false ;
}
if ( sendCommand ( POP3Command . USER , username ) != POP3Reply . OK ) {
return false ;
}
if ( sendCommand ( POP3Command . PASS , password ) != POP3Reply . OK ) {
return false ;
}
setState ( TRANSACTION_STATE ) ;
return true ;
}
public boolean login ( final String username , String timestamp , final String secret )
throws IOException , NoSuchAlgorithmException
{
int i ;
byte [] digest ;
StringBuilder buffer , digestBuffer ;
MessageDigest md5 ;
if ( getState () != AUTHORIZATION_STATE ) {
return false ;
}
md5 = MessageDigest . getInstance ( lr_1 ) ;
timestamp += secret ;
digest = md5 . digest ( timestamp . getBytes ( getCharset () ) ) ;
digestBuffer = new StringBuilder ( 128 ) ;
for ( i = 0 ; i < digest . length ; i ++ ) {
final int digit = digest [ i ] & 0xff ;
if ( digit <= 15 ) {
digestBuffer . append ( lr_2 ) ;
}
digestBuffer . append ( Integer . toHexString ( digit ) ) ;
}
buffer = new StringBuilder ( 256 ) ;
buffer . append ( username ) ;
buffer . append ( ' ' ) ;
buffer . append ( digestBuffer . toString () ) ;
if ( sendCommand ( POP3Command . APOP , buffer . toString () ) != POP3Reply . OK ) {
return false ;
}
setState ( TRANSACTION_STATE ) ;
return true ;
}
public boolean logout () throws IOException
{
if ( getState () == TRANSACTION_STATE ) {
setState ( UPDATE_STATE ) ;
}
sendCommand ( POP3Command . QUIT ) ;
return replyCode == POP3Reply . OK ;
}
public boolean noop () throws IOException
{
if ( getState () == TRANSACTION_STATE ) {
return sendCommand ( POP3Command . NOOP ) == POP3Reply . OK ;
}
return false ;
}
public boolean deleteMessage ( final int messageId ) throws IOException
{
if ( getState () == TRANSACTION_STATE ) {
return sendCommand ( POP3Command . DELE , Integer . toString ( messageId ) )
== POP3Reply . OK ;
}
return false ;
}
public boolean reset () throws IOException
{
if ( getState () == TRANSACTION_STATE ) {
return sendCommand ( POP3Command . RSET ) == POP3Reply . OK ;
}
return false ;
}
public POP3MessageInfo status () throws IOException
{
if ( getState () != TRANSACTION_STATE ) {
return null ;
}
if ( sendCommand ( POP3Command . STAT ) != POP3Reply . OK ) {
return null ;
}
return parseStatus ( lastReplyLine . substring ( 3 ) ) ;
}
public POP3MessageInfo listMessage ( final int messageId ) throws IOException
{
if ( getState () != TRANSACTION_STATE ) {
return null ;
}
if ( sendCommand ( POP3Command . LIST , Integer . toString ( messageId ) )
!= POP3Reply . OK ) {
return null ;
}
return parseStatus ( lastReplyLine . substring ( 3 ) ) ;
}
public POP3MessageInfo [] listMessages () throws IOException
{
if ( getState () != TRANSACTION_STATE ) {
return null ;
}
if ( sendCommand ( POP3Command . LIST ) != POP3Reply . OK ) {
return null ;
}
getAdditionalReply () ;
final POP3MessageInfo [] messages = new POP3MessageInfo [ replyLines . size () - 2 ] ;
final ListIterator < String > en = replyLines . listIterator ( 1 ) ;
for ( int line = 0 ; line < messages . length ; line ++ ) {
messages [ line ] = parseStatus ( en . next () ) ;
}
return messages ;
}
public POP3MessageInfo listUniqueIdentifier ( final int messageId )
throws IOException
{
if ( getState () != TRANSACTION_STATE ) {
return null ;
}
if ( sendCommand ( POP3Command . UIDL , Integer . toString ( messageId ) )
!= POP3Reply . OK ) {
return null ;
}
return parseUID ( lastReplyLine . substring ( 3 ) ) ;
}
public POP3MessageInfo [] listUniqueIdentifiers () throws IOException
{
if ( getState () != TRANSACTION_STATE ) {
return null ;
}
if ( sendCommand ( POP3Command . UIDL ) != POP3Reply . OK ) {
return null ;
}
getAdditionalReply () ;
final POP3MessageInfo [] messages = new POP3MessageInfo [ replyLines . size () - 2 ] ;
final ListIterator < String > en = replyLines . listIterator ( 1 ) ;
for ( int line = 0 ; line < messages . length ; line ++ ) {
messages [ line ] = parseUID ( en . next () ) ;
}
return messages ;
}
public Reader retrieveMessage ( final int messageId ) throws IOException
{
if ( getState () != TRANSACTION_STATE ) {
return null ;
}
if ( sendCommand ( POP3Command . RETR , Integer . toString ( messageId ) ) != POP3Reply . OK ) {
return null ;
}
return new DotTerminatedMessageReader ( reader ) ;
}
public Reader retrieveMessageTop ( final int messageId , final int numLines )
throws IOException
{
if ( numLines < 0 || getState () != TRANSACTION_STATE ) {
return null ;
}
if ( sendCommand ( POP3Command . TOP , Integer . toString ( messageId ) + lr_3 +
Integer . toString ( numLines ) ) != POP3Reply . OK ) {
return null ;
}
return new DotTerminatedMessageReader ( reader ) ;
}
