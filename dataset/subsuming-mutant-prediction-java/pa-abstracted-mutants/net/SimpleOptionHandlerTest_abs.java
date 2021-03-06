@Override
protected void setUp ()
{
opthand1 = new SimpleOptionHandler ( 4 ) ;
opthand2 = new SimpleOptionHandler ( 8 , true , true , true , true ) ;
opthand3 = new SimpleOptionHandler ( 91 , false , false , false , false ) ;
}
@Override
public void testConstructors ()
{
assertEquals ( opthand1 . getOptionCode () , 4 ) ;
assertEquals ( opthand2 . getOptionCode () , 8 ) ;
assertEquals ( opthand3 . getOptionCode () , 91 ) ;
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
TelnetCommand . IAC , TelnetCommand . SB , 4 ,
1 , TelnetCommand . IAC , TelnetCommand . SE ,
} ;
final int resp1 [] = opthand1 . answerSubnegotiation ( subn , subn . length ) ;
assertEquals ( resp1 , null ) ;
}
