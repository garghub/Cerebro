public void testConstants ()
{
assertEquals ( 110 , POP3 . DEFAULT_PORT ) ;
assertEquals ( - 1 , POP3 . DISCONNECTED_STATE ) ;
assertEquals ( 0 , POP3 . AUTHORIZATION_STATE ) ;
assertEquals ( 1 , POP3 . TRANSACTION_STATE ) ;
assertEquals ( 2 , POP3 . UPDATE_STATE ) ;
assertEquals ( 0 , POP3Command . USER ) ;
assertEquals ( 1 , POP3Command . PASS ) ;
assertEquals ( 2 , POP3Command . QUIT ) ;
assertEquals ( 3 , POP3Command . STAT ) ;
assertEquals ( 4 , POP3Command . LIST ) ;
assertEquals ( 5 , POP3Command . RETR ) ;
assertEquals ( 6 , POP3Command . DELE ) ;
assertEquals ( 7 , POP3Command . NOOP ) ;
assertEquals ( 8 , POP3Command . RSET ) ;
assertEquals ( 9 , POP3Command . APOP ) ;
assertEquals ( 10 , POP3Command . TOP ) ;
assertEquals ( 11 , POP3Command . UIDL ) ;
}
public void testPOP3DefaultConstructor ()
{
final POP3 pop = new POP3 () ;
assertEquals ( 110 , pop . getDefaultPort () ) ;
assertEquals ( POP3 . DISCONNECTED_STATE , pop . getState () ) ;
assertNull ( pop . reader ) ;
assertNotNull ( pop . replyLines ) ;
}
public void testPOP3ClientStateTransition () throws Exception
{
final POP3Client pop = new POP3Client () ;
assertEquals ( 110 , pop . getDefaultPort () ) ;
assertEquals ( POP3 . DISCONNECTED_STATE , pop . getState () ) ;
assertNull ( pop . reader ) ;
assertNotNull ( pop . replyLines ) ;
pop . connect ( mailhost ) ;
assertEquals ( POP3 . AUTHORIZATION_STATE , pop . getState () ) ;
pop . login ( user , password ) ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
pop . noop () ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
pop . status () ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
final POP3MessageInfo [] msg = pop . listMessages () ;
if ( msg . length > 0 )
{
pop . deleteMessage ( 1 ) ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
pop . reset () ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
pop . listMessage ( 1 ) ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
pop . listMessages () ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
pop . listUniqueIdentifier ( 1 ) ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
pop . listUniqueIdentifiers () ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
Reader r = pop . retrieveMessage ( 1 ) ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
while( ! r . ready () )
{
Thread . sleep ( 10 ) ;
}
r . close () ;
r = null ;
r = pop . retrieveMessageTop ( 1 , 10 ) ;
assertEquals ( POP3 . TRANSACTION_STATE , pop . getState () ) ;
while( ! r . ready () )
{
Thread . sleep ( 10 ) ;
}
r . close () ;
r = null ;
}
pop . logout () ;
assertEquals ( POP3 . UPDATE_STATE , pop . getState () ) ;
}
