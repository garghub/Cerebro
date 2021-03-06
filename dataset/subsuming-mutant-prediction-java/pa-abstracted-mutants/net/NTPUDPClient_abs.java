public TimeInfo getTime ( final InetAddress host , final int port ) throws IOException
{
if ( ! isOpen () )
{
open () ;
}
final NtpV3Packet message = new NtpV3Impl () ;
message . setMode ( NtpV3Packet . MODE_CLIENT ) ;
message . setVersion ( version ) ;
final DatagramPacket sendPacket = message . getDatagramPacket () ;
sendPacket . setAddress ( host ) ;
sendPacket . setPort ( port ) ;
final NtpV3Packet recMessage = new NtpV3Impl () ;
final DatagramPacket receivePacket = recMessage . getDatagramPacket () ;
final TimeStamp now = TimeStamp . getCurrentTime () ;
message . setTransmitTime ( now ) ;
_socket_ . send ( sendPacket ) ;
_socket_ . receive ( receivePacket ) ;
final long returnTime = System . currentTimeMillis () ;
final TimeInfo info = new TimeInfo ( recMessage , returnTime , false ) ;
return info ;
}
public TimeInfo getTime ( final InetAddress host ) throws IOException
{
return getTime ( host , NtpV3Packet . NTP_PORT ) ;
}
public int getVersion ()
{
return version ;
}
public void setVersion ( final int version )
{
this . version = version ;
}
