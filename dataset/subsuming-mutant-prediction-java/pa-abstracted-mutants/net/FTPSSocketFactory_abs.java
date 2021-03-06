@Override
public Socket createSocket () throws IOException {
return this . context . getSocketFactory () . createSocket () ;
}
@Override
public Socket createSocket ( final String address , final int port ) throws UnknownHostException , IOException {
return this . context . getSocketFactory () . createSocket ( address , port ) ;
}
@Override
public Socket createSocket ( final InetAddress address , final int port ) throws IOException {
return this . context . getSocketFactory () . createSocket ( address , port ) ;
}
@Override
public Socket createSocket ( final String address , final int port , final InetAddress localAddress , final int localPort )
throws UnknownHostException , IOException {
return this . context . getSocketFactory () . createSocket ( address , port , localAddress , localPort ) ;
}
@Override
public Socket createSocket ( final InetAddress address , final int port , final InetAddress localAddress ,
final int localPort ) throws IOException {
return this . context . getSocketFactory () . createSocket ( address , port , localAddress , localPort ) ;
}
@Deprecated
public java . net . ServerSocket createServerSocket ( final int port ) throws IOException {
return this . init ( this . context . getServerSocketFactory () . createServerSocket ( port ) ) ;
}
@Deprecated
public java . net . ServerSocket createServerSocket ( final int port , final int backlog ) throws IOException {
return this . init ( this . context . getServerSocketFactory () . createServerSocket ( port , backlog ) ) ;
}
@Deprecated
public java . net . ServerSocket createServerSocket ( final int port , final int backlog , final InetAddress ifAddress )
throws IOException {
return this . init ( this . context . getServerSocketFactory () . createServerSocket ( port , backlog , ifAddress ) ) ;
}
@Deprecated
public java . net . ServerSocket init ( final java . net . ServerSocket socket ) throws IOException {
( ( javax . net . ssl . SSLServerSocket ) socket ) . setUseClientMode ( true ) ;
return socket ;
}
