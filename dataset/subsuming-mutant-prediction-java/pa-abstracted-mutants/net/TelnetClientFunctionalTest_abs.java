@Override
protected void setUp ()
{
tc1 = new TelnetClient () ;
}
public void testFunctionalTest () throws Exception
{
boolean testresult = false ;
tc1 . connect ( lr_1 , 3000 ) ;
try ( final InputStream is = tc1 . getInputStream () ;
final OutputStream os = tc1 . getOutputStream () ) {
boolean cont = waitForString ( is , lr_2 , 30000 ) ;
if ( cont ) {
os . write ( lr_3 . getBytes () ) ;
os . flush () ;
cont = waitForString ( is , lr_4 , 30000 ) ;
}
if ( cont ) {
os . write ( lr_5 . getBytes () ) ;
os . flush () ;
cont = waitForString ( is , lr_6 , 30000 ) ;
}
if ( cont ) {
cont = waitForString ( is , lr_7 , 30000 ) ;
}
if ( cont ) {
os . write ( lr_8 . getBytes () ) ;
os . flush () ;
tc1 . disconnect () ;
testresult = true ;
}
assertTrue ( testresult ) ;
}
}
public boolean waitForString ( final InputStream is , final String end , final long timeout ) throws Exception
{
final byte buffer [] = new byte [ 32 ] ;
final long starttime = System . currentTimeMillis () ;
String readbytes = lr_9 ;
while( ( readbytes . indexOf ( end ) < 0 ) &&
( ( System . currentTimeMillis () - starttime ) < timeout ) )
{
if( is . available () > 0 )
{
final int ret_read = is . read ( buffer ) ;
readbytes = readbytes + new String ( buffer , 0 , ret_read ) ;
}
else
{
Thread . sleep ( 500 ) ;
}
}
if( readbytes . indexOf ( end ) >= 0 )
{
return ( true ) ;
}
return ( false ) ;
}
