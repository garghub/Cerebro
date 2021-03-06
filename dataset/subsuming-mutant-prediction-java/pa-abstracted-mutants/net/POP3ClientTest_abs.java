private void reset () throws IOException
{
if ( p == null )
{
}
else if ( p . isConnected () )
{
p . disconnect () ;
}
p = null ;
p = new POP3Client () ;
}
private void connect () throws Exception
{
p . connect ( InetAddress . getByName ( mailhost ) ) ;
assertTrue ( p . isConnected () ) ;
assertEquals ( POP3 . AUTHORIZATION_STATE , p . getState () ) ;
}
private void login () throws Exception
{
assertTrue ( p . login ( user , password ) ) ;
assertEquals ( POP3 . TRANSACTION_STATE , p . getState () ) ;
}
public void testValidLoginWithNameAndPassword () throws Exception
{
reset () ;
connect () ;
login () ;
}
public void testInvalidLoginWithBadName () throws Exception
{
reset () ;
connect () ;
assertFalse ( p . login ( lr_1 , password ) ) ;
}
public void testInvalidLoginWithBadPassword () throws Exception
{
reset () ;
connect () ;
assertFalse ( p . login ( user , lr_2 ) ) ;
}
public void testLoginFromWrongState () throws Exception
{
reset () ;
assertFalse ( p . login ( user , password ) ) ;
connect () ;
p . setState ( POP3 . TRANSACTION_STATE ) ;
assertFalse ( p . login ( user , password ) ) ;
p . disconnect () ;
connect () ;
p . setState ( POP3 . UPDATE_STATE ) ;
assertFalse ( p . login ( user , password ) ) ;
p . disconnect () ;
}
public void testLogoutFromAllStates () throws Exception
{
reset () ;
connect () ;
login () ;
assertTrue ( p . logout () ) ;
assertEquals ( POP3 . UPDATE_STATE , p . getState () ) ;
reset () ;
connect () ;
login () ;
p . setState ( POP3 . UPDATE_STATE ) ;
assertTrue ( p . logout () ) ;
}
