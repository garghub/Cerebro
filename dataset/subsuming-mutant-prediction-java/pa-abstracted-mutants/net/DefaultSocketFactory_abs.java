@Override
public Socket createSocket () throws IOException
{
if ( connProxy != null )
{
return new Socket ( connProxy ) ;
}
return new Socket () ;
}
@Override
public Socket createSocket ( final String host , final int port )
throws UnknownHostException , IOException
{
if ( connProxy != null )
{
final Socket s = new Socket ( connProxy ) ;
s . connect ( new InetSocketAddress ( host , port ) ) ;
return s ;
}
return new Socket ( host , port ) ;
}
@Override
public Socket createSocket ( final InetAddress address , final int port )
throws IOException
{
if ( connProxy != null )
{
final Socket s = new Socket ( connProxy ) ;
s . connect ( new InetSocketAddress ( address , port ) ) ;
return s ;
}
return new Socket ( address , port ) ;
}
@Override
public Socket createSocket ( final String host , final int port ,
final InetAddress localAddr , final int localPort )
throws UnknownHostException , IOException
{
if ( connProxy != null )
{
final Socket s = new Socket ( connProxy ) ;
s . bind ( new InetSocketAddress ( localAddr , localPort ) ) ;
s . connect ( new InetSocketAddress ( host , port ) ) ;
return s ;
}
return new Socket ( host , port , localAddr , localPort ) ;
}
@Override
public Socket createSocket ( final InetAddress address , final int port ,
final InetAddress localAddr , final int localPort )
throws IOException
{
if ( connProxy != null )
{
final Socket s = new Socket ( connProxy ) ;
s . bind ( new InetSocketAddress ( localAddr , localPort ) ) ;
s . connect ( new InetSocketAddress ( address , port ) ) ;
return s ;
}
return new Socket ( address , port , localAddr , localPort ) ;
}
public ServerSocket createServerSocket ( final int port ) throws IOException
{
return new ServerSocket ( port ) ;
}
public ServerSocket createServerSocket ( final int port , final int backlog )
throws IOException
{
return new ServerSocket ( port , backlog ) ;
}
public ServerSocket createServerSocket ( final int port , final int backlog ,
final InetAddress bindAddr )
throws IOException
{
return new ServerSocket ( port , backlog , bindAddr ) ;
}
