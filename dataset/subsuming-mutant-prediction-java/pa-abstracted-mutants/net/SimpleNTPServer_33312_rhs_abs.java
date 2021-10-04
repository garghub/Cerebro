public int getPort ()
{
return port ;
}
public boolean isRunning ()
{
return running ;
}
public boolean isStarted ()
{
return started ;
}
public void connect () throws IOException
{
if ( socket == null )
{
socket = new DatagramSocket ( port ) ;
if ( port == 0 ) {
port = socket . getLocalPort () ;
}
System . out . println ( lr_1 + port + lr_2 ) ;
}
}
public void start () throws IOException
{
if ( socket == null )
{
connect () ;
}
if ( ! started )
{
started = true ;
new Thread ( this ) . start () ;
}
}
@Override
public void run ()
{
running = true ;
final byte buffer [] = new byte [ 48 ] ;
final DatagramPacket request = new DatagramPacket ( buffer , buffer . length ) ;
do {
try {
socket . receive ( request ) ;
final long rcvTime = System . currentTimeMillis () ;
handlePacket ( request , rcvTime ) ;
} catch ( final IOException e ) {
if ( running )
{
e . printStackTrace () ;
}
}
} while ( running );
}
protected void handlePacket ( final DatagramPacket request , final long rcvTime ) throws IOException
{
final NtpV3Packet message = new NtpV3Impl () ;
message . setDatagramPacket ( request ) ;
System . out . printf ( lr_3 , request . getAddress () . getHostAddress () ,
NtpUtils . getModeName ( message . getMode () ) ) ;
if ( message . getMode () == NtpV3Packet . MODE_CLIENT ) {
final NtpV3Packet response = new NtpV3Impl () ;
response . setStratum ( 1 ) ;
response . setMode ( NtpV3Packet . MODE_SERVER ) ;
response . setVersion ( NtpV3Packet . VERSION_3 ) ;
response . setPrecision ( - 20 ) ;
response . setPoll ( 0 ) ;
response . setRootDelay ( 62 ) ;
response . setRootDispersion ( (int) ( 16.51 * 65.536 ) ) ;
response . setOriginateTimeStamp ( message . getTransmitTimeStamp () ) ;
response . setReceiveTimeStamp ( TimeStamp . getNtpTime ( rcvTime ) ) ; MST[NonVoidMethodCallMutator]MSP[N]
response . setReferenceTime ( response . getReceiveTimeStamp () ) ;
response . setReferenceId ( 0x4C434C00 ) ;
response . setTransmitTime ( TimeStamp . getNtpTime ( System . currentTimeMillis () ) ) ;
final DatagramPacket dp = response . getDatagramPacket () ;
dp . setPort ( request . getPort () ) ;
dp . setAddress ( request . getAddress () ) ;
socket . send ( dp ) ;
}
}
public void stop ()
{
running = false ;
if ( socket != null )
{
socket . close () ;
socket = null ;
}
started = false ;
}
public static void main ( final String [] args )
{
int port = NtpV3Packet . NTP_PORT ;
if ( args . length != 0 )
{
try {
port = Integer . parseInt ( args [ 0 ] ) ;
} catch ( final NumberFormatException nfe ) {
nfe . printStackTrace () ;
}
}
final SimpleNTPServer timeServer = new SimpleNTPServer ( port ) ;
try {
timeServer . start () ;
} catch ( final IOException e ) {
e . printStackTrace () ;
}
}
