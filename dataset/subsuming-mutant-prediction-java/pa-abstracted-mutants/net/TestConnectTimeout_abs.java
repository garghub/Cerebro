public void testConnectTimeout () throws SocketException , IOException {
final FTPClient client = new FTPClient () ;
client . setConnectTimeout ( 1000 ) ;
try {
client . connect ( lr_1 , 1234 ) ;
fail ( lr_2 ) ;
}
catch ( final ConnectException se ) {
assertTrue ( true ) ;
}
catch ( final SocketTimeoutException se ) {
assertTrue ( true ) ;
}
catch ( final UnknownHostException ue ) {
assertTrue ( true ) ;
}
}
