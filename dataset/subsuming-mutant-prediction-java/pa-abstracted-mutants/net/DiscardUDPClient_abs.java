public void send ( final byte [] data , final int length , final InetAddress host , final int port )
throws IOException
{
sendPacket . setData ( data ) ;
sendPacket . setLength ( length ) ;
sendPacket . setAddress ( host ) ;
sendPacket . setPort ( port ) ;
_socket_ . send ( sendPacket ) ;
}
public void send ( final byte [] data , final int length , final InetAddress host )
throws IOException
{
send ( data , length , host , DEFAULT_PORT ) ;
}
public void send ( final byte [] data , final InetAddress host ) throws IOException
{
send ( data , data . length , host , DEFAULT_PORT ) ;
}
