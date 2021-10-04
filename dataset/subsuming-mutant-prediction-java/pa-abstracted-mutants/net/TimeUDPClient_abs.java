public long getTime ( final InetAddress host , final int port ) throws IOException
{
long time ;
DatagramPacket sendPacket , receivePacket ;
sendPacket =
new DatagramPacket ( dummyData , dummyData . length , host , port ) ;
receivePacket = new DatagramPacket ( timeData , timeData . length ) ;
_socket_ . send ( sendPacket ) ;
_socket_ . receive ( receivePacket ) ;
time = 0L ;
time |= ( ( ( timeData [ 0 ] & 0xff ) << 24 ) & 0xffffffffL ) ;
time |= ( ( ( timeData [ 1 ] & 0xff ) << 16 ) & 0xffffffffL ) ;
time |= ( ( ( timeData [ 2 ] & 0xff ) << 8 ) & 0xffffffffL ) ;
time |= ( ( timeData [ 3 ] & 0xff ) & 0xffffffffL ) ;
return time ;
}
public long getTime ( final InetAddress host ) throws IOException
{
return getTime ( host , DEFAULT_PORT ) ;
}
public Date getDate ( final InetAddress host , final int port ) throws IOException
{
return new Date ( ( getTime ( host , port ) - SECONDS_1900_TO_1970 ) * 1000L ) ;
}
public Date getDate ( final InetAddress host ) throws IOException
{
return new Date ( ( getTime ( host , DEFAULT_PORT ) -
SECONDS_1900_TO_1970 ) * 1000L ) ;
}
