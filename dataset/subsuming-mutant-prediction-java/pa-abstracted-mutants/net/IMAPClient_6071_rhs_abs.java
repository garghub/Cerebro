public boolean capability () throws IOException
{
return doCommand ( IMAPCommand . CAPABILITY ) ;
}
public boolean noop () throws IOException
{
return doCommand ( IMAPCommand . NOOP ) ;
}
public boolean logout () throws IOException
{
return doCommand ( IMAPCommand . LOGOUT ) ;
}
public boolean login ( final String username , final String password ) throws IOException
{
if ( getState () != IMAP . IMAPState . NOT_AUTH_STATE )
{
return false ;
}
if ( ! doCommand ( IMAPCommand . LOGIN , username + lr_1 + password ) )
{
return false ;
}
setState ( IMAP . IMAPState . AUTH_STATE ) ;
return true ;
}
public boolean select ( final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . SELECT , quoteMailboxName ( mailboxName ) ) ;
}
public boolean examine ( final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . EXAMINE , quoteMailboxName ( mailboxName ) ) ;
}
public boolean create ( final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . CREATE , quoteMailboxName ( mailboxName ) ) ;
}
public boolean delete ( final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . DELETE , quoteMailboxName ( mailboxName ) ) ;
}
public boolean rename ( final String oldMailboxName , final String newMailboxName ) throws IOException
{
return doCommand ( IMAPCommand . RENAME , quoteMailboxName ( oldMailboxName ) + lr_1 + quoteMailboxName ( newMailboxName ) ) ;
}
public boolean subscribe ( final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . SUBSCRIBE , quoteMailboxName ( mailboxName ) ) ;
}
public boolean unsubscribe ( final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . UNSUBSCRIBE , quoteMailboxName ( mailboxName ) ) ;
}
public boolean list ( final String refName , final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . LIST , quoteMailboxName ( refName ) + lr_1 + quoteMailboxName ( mailboxName ) ) ;
}
public boolean lsub ( final String refName , final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . LSUB , quoteMailboxName ( refName ) + lr_1 + quoteMailboxName ( mailboxName ) ) ;
}
public boolean status ( final String mailboxName , final String [] itemNames ) throws IOException MST[rv.UOI4Mutator]MSP[S]
{
if ( itemNames == null || itemNames . length < 1 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
final StringBuilder sb = new StringBuilder () ;
sb . append ( quoteMailboxName ( mailboxName ) ) ;
sb . append ( lr_3 ) ;
for ( int i = 0 ; i < itemNames . length ; i ++ )
{
if ( i > 0 ) {
sb . append ( lr_1 ) ;
}
sb . append ( itemNames [ i ] ) ;
}
sb . append ( lr_4 ) ;
return doCommand ( IMAPCommand . STATUS , sb . toString () ) ;
}
public boolean append ( final String mailboxName , final String flags , final String datetime , final String message )
throws IOException {
final StringBuilder args = new StringBuilder ( quoteMailboxName ( mailboxName ) ) ;
if ( flags != null ) {
args . append ( lr_1 ) . append ( flags ) ;
}
if ( datetime != null ) {
args . append ( lr_1 ) ;
if ( datetime . charAt ( 0 ) == DQUOTE ) {
args . append ( datetime ) ;
} else {
args . append ( DQUOTE ) . append ( datetime ) . append ( DQUOTE ) ;
}
}
args . append ( lr_1 ) ;
if ( message . startsWith ( DQUOTE_S ) && message . endsWith ( DQUOTE_S ) ) {
args . append ( message ) ;
return doCommand ( IMAPCommand . APPEND , args . toString () ) ;
}
args . append ( '{' ) . append ( message . getBytes ( IMAP . __DEFAULT_ENCODING ) . length ) . append ( '}' ) ;
final int status = sendCommand ( IMAPCommand . APPEND , args . toString () ) ;
return IMAPReply . isContinuation ( status )
&& IMAPReply . isSuccess ( sendData ( message ) ) ;
}
@Deprecated
public boolean append ( final String mailboxName , final String flags , final String datetime ) throws IOException
{
String args = mailboxName ;
if ( flags != null ) {
args += lr_1 + flags ;
}
if ( datetime != null ) {
if ( datetime . charAt ( 0 ) == '{' ) {
args += lr_1 + datetime ;
} else {
args += lr_5 + datetime + lr_6 ;
}
}
return doCommand ( IMAPCommand . APPEND , args ) ;
}
@Deprecated
public boolean append ( final String mailboxName ) throws IOException
{
return append ( mailboxName , null , null ) ;
}
public boolean check () throws IOException
{
return doCommand ( IMAPCommand . CHECK ) ;
}
public boolean close () throws IOException
{
return doCommand ( IMAPCommand . CLOSE ) ;
}
public boolean expunge () throws IOException
{
return doCommand ( IMAPCommand . EXPUNGE ) ;
}
public boolean search ( final String charset , final String criteria ) throws IOException
{
String args = lr_7 ;
if ( charset != null ) {
args += lr_8 + charset ;
}
args += criteria ;
return doCommand ( IMAPCommand . SEARCH , args ) ;
}
public boolean search ( final String criteria ) throws IOException
{
return search ( null , criteria ) ;
}
public boolean fetch ( final String sequenceSet , final String itemNames ) throws IOException
{
return doCommand ( IMAPCommand . FETCH , sequenceSet + lr_1 + itemNames ) ;
}
public boolean store ( final String sequenceSet , final String itemNames , final String itemValues )
throws IOException
{
return doCommand ( IMAPCommand . STORE , sequenceSet + lr_1 + itemNames + lr_1 + itemValues ) ;
}
public boolean copy ( final String sequenceSet , final String mailboxName ) throws IOException
{
return doCommand ( IMAPCommand . COPY , sequenceSet + lr_1 + quoteMailboxName ( mailboxName ) ) ;
}
public boolean uid ( final String command , final String commandArgs ) throws IOException
{
return doCommand ( IMAPCommand . UID , command + lr_1 + commandArgs ) ;
}
