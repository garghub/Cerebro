@Override
public void send ( final byte [] data , final int length , final InetAddress host )
throws IOException
{
send ( data , length , host , DEFAULT_PORT ) ;
}
@Override
public void send ( final byte [] data , final InetAddress host ) throws IOException
{
send ( data , data . length , host , DEFAULT_PORT ) ;
}
public int receive ( final byte [] data , final int length ) throws IOException
{
receivePacket . setData ( data ) ;
receivePacket . setLength ( length ) ;
_socket_ . receive ( receivePacket ) ;
return receivePacket . getLength () ;
}
public int receive ( final byte [] data ) throws IOException
{
return receive ( data , data . length ) ;
}
