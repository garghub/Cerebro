public void send ( final InetAddress host , final int port ) throws IOException
{
sendPacket . setAddress ( host ) ;
sendPacket . setPort ( port ) ;
_socket_ . send ( sendPacket ) ;
}
public void send ( final InetAddress host ) throws IOException
{
send ( host , DEFAULT_PORT ) ;
}
public byte [] receive () throws IOException
{
int length ;
byte [] result ;
_socket_ . receive ( receivePacket ) ;
result = new byte [ length = receivePacket . getLength () ] ;
System . arraycopy ( receiveData , 0 , result , 0 , length ) ;
return result ;
}
