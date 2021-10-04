protected void openConnections () throws Exception
{
try {
server1 = new TimeTestSimpleServer ( _port ) ;
server1 . connect () ;
} catch ( final IOException ioe )
{
_port = 4000 ;
server1 = new TimeTestSimpleServer ( _port ) ;
server1 . connect () ;
}
server1 . start () ;
}
public void testInitial () {
final TimeZone utcZone = TimeZone . getTimeZone ( lr_1 ) ;
final Calendar calendar = Calendar . getInstance ( utcZone ) ;
calendar . set ( 1900 , Calendar . JANUARY , 1 , 0 , 0 , 0 ) ;
calendar . set ( Calendar . MILLISECOND , 0 ) ;
final long baseTime = calendar . getTime () . getTime () / 1000L ;
assertEquals ( baseTime , - TimeTCPClient . SECONDS_1900_TO_1970 ) ;
}
public void testCompareTimes () throws Exception
{
openConnections () ;
long time , time2 ;
long clientTime , clientTime2 ;
final TimeTCPClient client = new TimeTCPClient () ;
try
{
final InetAddress localHost = InetAddress . getByName ( lr_2 ) ;
try
{
client . setDefaultTimeout ( 60000 ) ;
client . connect ( localHost , _port ) ;
clientTime = client . getDate () . getTime () ;
time = System . currentTimeMillis () ;
} catch ( final IOException e ) {
fail ( lr_3 + e + lr_4 + localHost + lr_5 + _port ) ;
throw e ;
} finally
{
if( client . isConnected () ) {
client . disconnect () ;
}
}
try
{
client . setDefaultTimeout ( 60000 ) ;
client . connect ( localHost , _port ) ;
clientTime2 = ( client . getTime () - TimeTCPClient . SECONDS_1900_TO_1970 ) * 1000L ;
time2 = System . currentTimeMillis () ;
} finally
{
if( client . isConnected () ) {
client . disconnect () ;
}
}
} finally
{
closeConnections () ;
}
assertTrue ( Math . abs ( time - clientTime ) < 5000 ) ;
assertTrue ( Math . abs ( time2 - clientTime2 ) < 5000 ) ;
}
protected void closeConnections ()
{
try
{
server1 . stop () ;
Thread . sleep ( 1000 ) ;
} catch ( final Exception e )
{
}
}
