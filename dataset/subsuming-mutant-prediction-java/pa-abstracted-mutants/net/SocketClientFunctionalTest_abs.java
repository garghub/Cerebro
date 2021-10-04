public void testProxySettings () throws Exception
{
final Proxy proxy = new Proxy ( Proxy . Type . SOCKS , new InetSocketAddress ( PROXY_HOST , PROXY_PORT ) ) ;
sc . setProxy ( proxy ) ;
sc . connect ( DEST_HOST , DEST_PORT ) ;
assertTrue ( sc . isConnected () ) ;
sc . disconnect () ;
}
