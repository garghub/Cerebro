public static final String getModeName ( final int mode )
{
return TFTPRequestPacket . _modeStrings [ mode ] ;
}
public final void discardPackets () throws IOException
{
int to ;
DatagramPacket datagram ;
datagram = new DatagramPacket ( new byte [ PACKET_SIZE ] , PACKET_SIZE ) ;
to = getSoTimeout () ;
setSoTimeout ( 1 ) ;
try
{
while ( true ) {
_socket_ . receive ( datagram ) ;
}
}
catch ( final SocketException e )
{
}
catch ( final InterruptedIOException e )
{
}
setSoTimeout ( to ) ;
}
public final TFTPPacket bufferedReceive () throws IOException ,
InterruptedIOException , SocketException , TFTPPacketException
{
receiveDatagram . setData ( receiveBuffer ) ;
receiveDatagram . setLength ( receiveBuffer . length ) ;
_socket_ . receive ( receiveDatagram ) ;
final TFTPPacket newTFTPPacket = TFTPPacket . newTFTPPacket ( receiveDatagram ) ;
trace ( lr_1 , newTFTPPacket ) ;
return newTFTPPacket ;
}
public final void bufferedSend ( final TFTPPacket packet ) throws IOException
{
trace ( lr_2 , packet ) ;
_socket_ . send ( packet . _newDatagram ( sendDatagram , sendBuffer ) ) ;
}
public final void beginBufferedOps ()
{
receiveBuffer = new byte [ PACKET_SIZE ] ;
receiveDatagram =
new DatagramPacket ( receiveBuffer , receiveBuffer . length ) ;
sendBuffer = new byte [ PACKET_SIZE ] ;
sendDatagram =
new DatagramPacket ( sendBuffer , sendBuffer . length ) ;
}
public final void endBufferedOps ()
{
receiveBuffer = null ;
receiveDatagram = null ;
sendBuffer = null ;
sendDatagram = null ;
}
public final void send ( final TFTPPacket packet ) throws IOException
{
trace ( lr_2 , packet ) ;
_socket_ . send ( packet . newDatagram () ) ;
}
public final TFTPPacket receive () throws IOException , InterruptedIOException , MST[rv.CRCR4Mutator]MSP[]
SocketException , TFTPPacketException
{
DatagramPacket packet ;
packet = new DatagramPacket ( new byte [ PACKET_SIZE ] , PACKET_SIZE ) ;
_socket_ . receive ( packet ) ;
final TFTPPacket newTFTPPacket = TFTPPacket . newTFTPPacket ( packet ) ;
trace ( lr_1 , newTFTPPacket ) ;
return newTFTPPacket ;
}
protected void trace ( final String direction , final TFTPPacket packet ) {
}
