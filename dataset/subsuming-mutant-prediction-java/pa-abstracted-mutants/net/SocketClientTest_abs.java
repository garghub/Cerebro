public void testProxySettings ()
{
final SocketClient socketClient = new FTPClient () ;
assertNull ( socketClient . getProxy () ) ;
final Proxy proxy = new Proxy ( Proxy . Type . SOCKS , new InetSocketAddress ( PROXY_HOST , PROXY_PORT ) ) ;
socketClient . setProxy ( proxy ) ;
assertEquals ( proxy , socketClient . getProxy () ) ;
assertFalse ( socketClient . isConnected () ) ;
}
