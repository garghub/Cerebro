public void testisValidOption ()
{
assertTrue ( TelnetOption . isValidOption ( 0 ) ) ;
assertTrue ( TelnetOption . isValidOption ( 91 ) ) ;
assertTrue ( TelnetOption . isValidOption ( 255 ) ) ;
assertTrue ( ! TelnetOption . isValidOption ( 256 ) ) ;
}
public void testGetOption ()
{
assertEquals ( TelnetOption . getOption ( 0 ) , lr_1 ) ;
assertEquals ( TelnetOption . getOption ( 91 ) , lr_2 ) ;
assertEquals ( TelnetOption . getOption ( 255 ) , lr_3 ) ;
}
