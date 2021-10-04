public String getTime ( final InetAddress host , final int port ) throws IOException
{
DatagramPacket sendPacket , receivePacket ;
sendPacket =
new DatagramPacket ( dummyData , dummyData . length , host , port ) ;
receivePacket = new DatagramPacket ( timeData , timeData . length ) ;
_socket_ . send ( sendPacket ) ;
_socket_ . receive ( receivePacket ) ;
return new String ( receivePacket . getData () , 0 , receivePacket . getLength () , getCharset () ) ;
}
public String getTime ( final InetAddress host ) throws IOException
{
return getTime ( host , DEFAULT_PORT ) ;
}
