private void reset () throws IOException
{
if ( pop3Client == null )
{
}
else if ( pop3Client . isConnected () )
{
pop3Client . disconnect () ;
}
pop3Client = null ;
pop3Client = new POP3Client () ;
}
private void connect () throws Exception
{
pop3Client . connect ( InetAddress . getByName ( mailhost ) ) ;
assertTrue ( pop3Client . isConnected () ) ;
assertEquals ( POP3 . AUTHORIZATION_STATE , pop3Client . getState () ) ;
}
private void login () throws Exception
{
assertTrue ( pop3Client . login ( user , password ) ) ;
assertEquals ( POP3 . TRANSACTION_STATE , pop3Client . getState () ) ;
}
public void testNoopCommand () throws Exception
{
reset () ;
connect () ;
assertFalse ( pop3Client . noop () ) ;
login () ;
assertTrue ( pop3Client . noop () ) ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
assertFalse ( pop3Client . noop () ) ;
}
public void testStatus () throws Exception
{
reset () ;
connect () ;
assertNull ( pop3Client . status () ) ;
login () ;
final POP3MessageInfo msg = pop3Client . status () ;
assertTrue ( msg . number > 0 ) ;
assertTrue ( msg . size > 0 ) ;
assertNull ( msg . identifier ) ;
pop3Client . logout () ;
reset () ;
connect () ;
assertTrue ( pop3Client . login ( emptyUser , password ) ) ;
final POP3MessageInfo msg2 = pop3Client . status () ;
assertEquals ( 0 , msg2 . number ) ;
assertEquals ( 0 , msg2 . size ) ;
assertNull ( msg2 . identifier ) ;
pop3Client . logout () ;
reset () ;
connect () ;
login () ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
assertNull ( pop3Client . status () ) ;
}
public void testListMessagesOnFullMailbox () throws Exception
{
reset () ;
connect () ;
login () ;
POP3MessageInfo [] msg = pop3Client . listMessages () ;
assertTrue ( msg . length > 0 ) ;
for( int i = 0 ; i < msg . length ; i ++ )
{
assertNotNull ( msg [ i ] ) ;
assertEquals ( i + 1 , msg [ i ] . number ) ;
assertTrue ( msg [ i ] . size > 0 ) ;
assertNull ( msg [ i ] . identifier ) ;
}
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
msg = pop3Client . listMessages () ;
assertNull ( msg ) ;
}
public void testListMessageOnFullMailbox () throws Exception
{
reset () ;
connect () ;
login () ;
POP3MessageInfo msg = pop3Client . listMessage ( 1 ) ;
assertNotNull ( msg ) ;
assertEquals ( 1 , msg . number ) ;
assertTrue ( msg . size > 0 ) ;
assertNull ( msg . identifier ) ;
msg = pop3Client . listMessage ( 0 ) ;
assertNull ( msg ) ;
msg = pop3Client . listMessage ( 100000 ) ;
assertNull ( msg ) ;
msg = pop3Client . listMessage ( - 2 ) ;
assertNull ( msg ) ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
msg = pop3Client . listMessage ( 1 ) ;
assertNull ( msg ) ;
}
public void testListMessagesOnEmptyMailbox () throws Exception
{
reset () ;
connect () ;
assertTrue ( pop3Client . login ( emptyUser , password ) ) ;
POP3MessageInfo [] msg = pop3Client . listMessages () ;
assertEquals ( 0 , msg . length ) ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
msg = pop3Client . listMessages () ;
assertNull ( msg ) ;
}
public void testListMessageOnEmptyMailbox () throws Exception
{
reset () ;
connect () ;
assertTrue ( pop3Client . login ( emptyUser , password ) ) ;
final POP3MessageInfo msg = pop3Client . listMessage ( 1 ) ;
assertNull ( msg ) ;
}
public void testListUniqueIDsOnFullMailbox () throws Exception
{
reset () ;
connect () ;
login () ;
POP3MessageInfo [] msg = pop3Client . listUniqueIdentifiers () ;
assertTrue ( msg . length > 0 ) ;
for( int i = 0 ; i < msg . length ; i ++ )
{
assertNotNull ( msg [ i ] ) ;
assertEquals ( i + 1 , msg [ i ] . number ) ;
assertNotNull ( msg [ i ] . identifier ) ;
}
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
msg = pop3Client . listUniqueIdentifiers () ;
assertNull ( msg ) ;
}
public void testListUniqueIDOnFullMailbox () throws Exception
{
reset () ;
connect () ;
login () ;
POP3MessageInfo msg = pop3Client . listUniqueIdentifier ( 1 ) ;
assertNotNull ( msg ) ;
assertEquals ( 1 , msg . number ) ;
assertNotNull ( msg . identifier ) ;
msg = pop3Client . listUniqueIdentifier ( 0 ) ;
assertNull ( msg ) ;
msg = pop3Client . listUniqueIdentifier ( 100000 ) ;
assertNull ( msg ) ;
msg = pop3Client . listUniqueIdentifier ( - 2 ) ;
assertNull ( msg ) ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
msg = pop3Client . listUniqueIdentifier ( 1 ) ;
assertNull ( msg ) ;
}
public void testListUniqueIDsOnEmptyMailbox () throws Exception
{
reset () ;
connect () ;
assertTrue ( pop3Client . login ( emptyUser , password ) ) ;
POP3MessageInfo [] msg = pop3Client . listUniqueIdentifiers () ;
assertEquals ( 0 , msg . length ) ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
msg = pop3Client . listUniqueIdentifiers () ;
assertNull ( msg ) ;
}
public void testListUniqueIdentifierOnEmptyMailbox () throws Exception
{
reset () ;
connect () ;
assertTrue ( pop3Client . login ( emptyUser , password ) ) ;
final POP3MessageInfo msg = pop3Client . listUniqueIdentifier ( 1 ) ;
assertNull ( msg ) ;
}
public void testRetrieveMessageOnFullMailbox () throws Exception
{
reset () ;
connect () ;
login () ;
int reportedSize = 0 ;
int actualSize = 0 ;
final POP3MessageInfo [] msg = pop3Client . listMessages () ;
assertTrue ( msg . length > 0 ) ;
for ( int i = msg . length ; i > 0 ; i -- )
{
reportedSize = msg [ i - 1 ] . size ;
final Reader r = pop3Client . retrieveMessage ( i ) ;
assertNotNull ( r ) ;
int delaycount = 0 ;
if ( ! r . ready () )
{
Thread . sleep ( 500 ) ;
delaycount ++ ;
if ( delaycount == 4 )
{
break;
}
}
while( r . ready () )
{
r . read () ;
actualSize ++ ;
}
assertTrue ( actualSize >= reportedSize ) ;
}
}
public void testRetrieveMessageOnEmptyMailbox () throws Exception
{
reset () ;
connect () ;
assertTrue ( pop3Client . login ( emptyUser , password ) ) ;
assertNull ( pop3Client . retrieveMessage ( 1 ) ) ;
}
public void testRetrieveMessageShouldFails () throws Exception
{
reset () ;
connect () ;
login () ;
assertNull ( pop3Client . retrieveMessage ( 0 ) ) ;
assertNull ( pop3Client . retrieveMessage ( - 2 ) ) ;
assertNull ( pop3Client . retrieveMessage ( 100000 ) ) ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
assertNull ( pop3Client . retrieveMessage ( 1 ) ) ;
}
public void testRetrieveMessageTopOnFullMailbox () throws Exception
{
reset () ;
connect () ;
login () ;
final int numLines = 10 ;
final POP3MessageInfo [] msg = pop3Client . listMessages () ;
assertTrue ( msg . length > 0 ) ;
for ( int i = 0 ; i < msg . length ; i ++ )
{
Reader r = pop3Client . retrieveMessageTop ( i + 1 , numLines ) ;
assertNotNull ( r ) ;
r . close () ;
r = null ;
}
}
public void testRetrieveOverSizedMessageTopOnFullMailbox () throws Exception
{
reset () ;
connect () ;
login () ;
int reportedSize = 0 ;
int actualSize = 0 ;
final POP3MessageInfo msg = pop3Client . listMessage ( 1 ) ;
reportedSize = msg . size ;
final Reader r = pop3Client . retrieveMessageTop ( 1 , 100000 ) ;
assertNotNull ( r ) ;
int delaycount = 0 ;
while( ! r . ready () )
{
Thread . sleep ( 500 ) ;
delaycount ++ ;
if ( delaycount == 4 )
{
break;
}
}
while( r . ready () )
{
r . read () ;
actualSize ++ ;
}
assertTrue ( actualSize >= reportedSize ) ;
}
public void testRetrieveMessageTopOnEmptyMailbox () throws Exception
{
reset () ;
connect () ;
assertTrue ( pop3Client . login ( emptyUser , password ) ) ;
assertNull ( pop3Client . retrieveMessageTop ( 1 , 10 ) ) ;
}
public void testRetrieveMessageTopShouldFails () throws Exception
{
reset () ;
connect () ;
login () ;
assertNull ( pop3Client . retrieveMessageTop ( 0 , 10 ) ) ;
assertNull ( pop3Client . retrieveMessageTop ( - 2 , 10 ) ) ;
assertNull ( pop3Client . retrieveMessageTop ( 100000 , 10 ) ) ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
assertNull ( pop3Client . retrieveMessageTop ( 1 , 10 ) ) ;
}
public void testDeleteWithReset () throws Exception
{
reset () ;
connect () ;
login () ;
POP3MessageInfo [] msg = pop3Client . listMessages () ;
final int numMessages = msg . length ;
int numDeleted = 0 ;
for ( int i = 0 ; i < numMessages - 1 ; i ++ )
{
pop3Client . deleteMessage ( i + 1 ) ;
numDeleted ++ ;
}
assertEquals ( numMessages , numDeleted + 1 ) ;
pop3Client . reset () ;
pop3Client . logout () ;
reset () ;
connect () ;
login () ;
msg = pop3Client . listMessages () ;
assertEquals ( numMessages , msg . length ) ;
}
public void testDelete () throws Exception
{
reset () ;
connect () ;
login () ;
POP3MessageInfo [] msg = pop3Client . listMessages () ;
final int numMessages = msg . length ;
int numDeleted = 0 ;
for ( int i = 0 ; i < numMessages - 3 ; i ++ )
{
pop3Client . deleteMessage ( i + 1 ) ;
numDeleted ++ ;
}
assertEquals ( numMessages , numDeleted + 3 ) ;
pop3Client . logout () ;
reset () ;
connect () ;
login () ;
msg = pop3Client . listMessages () ;
assertEquals ( numMessages - numDeleted , msg . length ) ;
}
public void testResetAndDeleteShouldFails () throws Exception
{
reset () ;
connect () ;
login () ;
pop3Client . setState ( POP3 . UPDATE_STATE ) ;
assertFalse ( pop3Client . reset () ) ;
assertFalse ( pop3Client . deleteMessage ( 1 ) ) ;
}
