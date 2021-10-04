@BeforeClass
public static void oneTimeSetUp () throws IOException
{
server = new SimpleNTPServer ( 0 ) ;
server . connect () ;
try {
server . start () ;
} catch ( final IOException e ) {
Assert . fail ( lr_1 + e ) ;
}
Assert . assertTrue ( server . isStarted () ) ;
boolean running = false ;
for ( int retries = 0 ; retries < 5 ; retries ++ ) {
running = server . isRunning () ;
if ( running ) {
break;
}
try {
Thread . sleep ( 2000 ) ;
} catch ( final InterruptedException e ) {
}
}
Assert . assertTrue ( running ) ;
}
@AfterClass
public static void oneTimeTearDown () {
if ( server != null ) {
server . stop () ;
server = null ;
}
}
@Test
public void testGetTime () throws IOException {
final long currentTime = System . currentTimeMillis () ;
final NTPUDPClient client = new NTPUDPClient () ;
client . setDefaultTimeout ( 2000 ) ;
try {
final InetAddress addr = InetAddress . getByAddress ( lr_2 , new byte [] { 127 , 0 , 0 , 1 } ) ;
final TimeInfo timeInfo = client . getTime ( addr , server . getPort () ) ;
Assert . assertNotNull ( timeInfo ) ;
Assert . assertTrue ( timeInfo . getReturnTime () >= currentTime ) ;
final NtpV3Packet message = timeInfo . getMessage () ;
Assert . assertNotNull ( message ) ;
final TimeStamp rcvTimeStamp = message . getReceiveTimeStamp () ;
final TimeStamp xmitTimeStamp = message . getTransmitTimeStamp () ;
Assert . assertTrue ( xmitTimeStamp . compareTo ( rcvTimeStamp ) >= 0 ) ;
final TimeStamp originateTimeStamp = message . getOriginateTimeStamp () ;
Assert . assertNotNull ( originateTimeStamp ) ;
Assert . assertTrue ( originateTimeStamp . getTime () >= currentTime ) ;
Assert . assertEquals ( NtpV3Packet . MODE_SERVER , message . getMode () ) ;
final TimeStamp referenceTimeStamp = message . getReferenceTimeStamp () ;
Assert . assertNotNull ( referenceTimeStamp ) ;
Assert . assertTrue ( referenceTimeStamp . getTime () >= currentTime ) ;
Assert . assertEquals ( NtpV3Packet . VERSION_3 , message . getVersion () ) ;
Assert . assertEquals ( 1 , message . getStratum () ) ;
Assert . assertEquals ( lr_3 , NtpUtils . getReferenceClock ( message ) ) ;
} finally {
client . close () ;
}
}
