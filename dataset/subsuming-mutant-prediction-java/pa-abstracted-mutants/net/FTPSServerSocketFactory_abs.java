@Override
public ServerSocket createServerSocket () throws IOException {
return init ( this . context . getServerSocketFactory () . createServerSocket () ) ;
}
@Override
public ServerSocket createServerSocket ( final int port ) throws IOException {
return init ( this . context . getServerSocketFactory () . createServerSocket ( port ) ) ;
}
@Override
public ServerSocket createServerSocket ( final int port , final int backlog ) throws IOException {
return init ( this . context . getServerSocketFactory () . createServerSocket ( port , backlog ) ) ;
}
@Override
public ServerSocket createServerSocket ( final int port , final int backlog , final InetAddress ifAddress ) throws IOException {
return init ( this . context . getServerSocketFactory () . createServerSocket ( port , backlog , ifAddress ) ) ;
}
public ServerSocket init ( final ServerSocket socket ) {
( ( SSLServerSocket ) socket ) . setUseClientMode ( true ) ;
return socket ;
}
