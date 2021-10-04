@Override
protected void setUp ()
{
msg1 = lr_1 ;
code1 = 13 ;
exc1 = new InvalidTelnetOptionException ( msg1 , code1 ) ;
}
public void testConstructors ()
{
assertTrue ( exc1 . getMessage () . indexOf ( msg1 ) >= 0 ) ;
assertTrue ( exc1 . getMessage () . indexOf ( lr_2 + code1 ) >= 0 ) ;
}
