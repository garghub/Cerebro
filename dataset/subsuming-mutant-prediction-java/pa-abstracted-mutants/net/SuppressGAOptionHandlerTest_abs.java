@Override
protected void setUp ()
{
opthand1 = new SuppressGAOptionHandler () ;
opthand2 = new SuppressGAOptionHandler ( true , true , true , true ) ;
opthand3 = new SuppressGAOptionHandler ( false , false , false , false ) ;
}
@Override
public void testConstructors ()
{
assertEquals ( opthand1 . getOptionCode () , TelnetOption . SUPPRESS_GO_AHEAD ) ;
super . testConstructors () ;
}
@Override
public void testStartSubnegotiation ()
{
final int resp1 [] = opthand1 . startSubnegotiationLocal () ;
final int resp2 [] = opthand1 . startSubnegotiationRemote () ;
assertEquals ( resp1 , null ) ;
assertEquals ( resp2 , null ) ;
}
@Override
public void testAnswerSubnegotiation ()
{
final int subn [] =
{
TelnetCommand . IAC , TelnetCommand . SB , TelnetOption . SUPPRESS_GO_AHEAD ,
1 , TelnetCommand . IAC , TelnetCommand . SE ,
} ;
final int resp1 [] = opthand1 . answerSubnegotiation ( subn , subn . length ) ;
assertEquals ( resp1 , null ) ;
}
