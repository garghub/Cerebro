@Override
public DatagramSocket createDatagramSocket () throws SocketException
{
return new DatagramSocket () ;
}
@Override
public DatagramSocket createDatagramSocket ( final int port ) throws SocketException
{
return new DatagramSocket ( port ) ;
}
@Override
public DatagramSocket createDatagramSocket ( final int port , final InetAddress laddr )
throws SocketException
{
return new DatagramSocket ( port , laddr ) ;
}
