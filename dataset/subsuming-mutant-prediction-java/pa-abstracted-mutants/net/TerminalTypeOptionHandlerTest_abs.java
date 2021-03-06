@Override
protected void setUp ()
{
opthand1 = new TerminalTypeOptionHandler ( lr_1 ) ;
opthand2 = new TerminalTypeOptionHandler ( lr_2 , true , true , true , true ) ;
opthand3 = new TerminalTypeOptionHandler ( lr_2 , false , false , false , false ) ;
}
@Override
public void testConstructors ()
{
assertEquals ( opthand1 . getOptionCode () , TelnetOption . TERMINAL_TYPE ) ;
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
TelnetOption . TERMINAL_TYPE , 1
} ;
final int expected1 [] =
{
TelnetOption . TERMINAL_TYPE , 0 , 'V' , 'T' , '1' , '0' , '0'
} ;
final int expected2 [] =
{
TelnetOption . TERMINAL_TYPE , 0 , 'A' , 'N' , 'S' , 'I'
} ;
final int resp1 [] = opthand1 . answerSubnegotiation ( subn , subn . length ) ;
final int resp2 [] = opthand2 . answerSubnegotiation ( subn , subn . length ) ;
assertTrue ( equalInts ( resp1 , expected1 ) ) ;
assertTrue ( equalInts ( resp2 , expected2 ) ) ;
}
protected boolean equalInts ( final int a1 [] , final int a2 [] )
{
if( a1 . length != a2 . length )
{
return false ;
}
boolean result = true ;
for( int ii = 0 ; ii < a1 . length ; ii ++ )
{
if( a1 [ ii ] != a2 [ ii ] ) {
result = false ;
}
}
return result ;
}
