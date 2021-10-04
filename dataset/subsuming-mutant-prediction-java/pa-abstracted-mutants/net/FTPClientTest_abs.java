public void testParseClient () {
for( int i = 0 ; i < TESTS . length ; i += 2 ) {
assertEquals ( lr_1 , TESTS [ i + 1 ] , FTPClient . parsePathname ( TESTS [ i ] ) ) ;
}
}
public void testParserCachingWithKey () throws Exception {
final FTPClient client = new FTPClient () ;
assertNull ( client . getEntryParser () ) ;
client . createParser ( FTPClientConfig . SYST_UNIX ) ;
final FTPFileEntryParser entryParserSYST = client . getEntryParser () ;
assertNotNull ( entryParserSYST ) ;
client . createParser ( FTPClientConfig . SYST_UNIX ) ;
assertSame ( entryParserSYST , client . getEntryParser () ) ;
client . createParser ( FTPClientConfig . SYST_VMS ) ;
final FTPFileEntryParser entryParserVMS = client . getEntryParser () ;
assertNotSame ( entryParserSYST , entryParserVMS ) ;
client . createParser ( FTPClientConfig . SYST_VMS ) ;
assertSame ( entryParserVMS , client . getEntryParser () ) ;
client . createParser ( FTPClientConfig . SYST_UNIX ) ;
assertNotSame ( entryParserVMS , client . getEntryParser () ) ;
}
@Override
public String getSystemType () throws IOException {
return systemType ;
}
public void setSystemType ( final String type ) {
systemType = type ;
}
public void testParserCachingNullKey () throws Exception {
final LocalClient client = new LocalClient () ;
client . setSystemType ( FTPClientConfig . SYST_UNIX ) ;
assertNull ( client . getEntryParser () ) ;
client . createParser ( null ) ;
final FTPFileEntryParser entryParser = client . getEntryParser () ;
assertNotNull ( entryParser ) ;
client . createParser ( null ) ;
assertSame ( entryParser , client . getEntryParser () ) ;
client . setSystemType ( FTPClientConfig . SYST_NT ) ;
client . createParser ( null ) ;
assertSame ( entryParser , client . getEntryParser () ) ;
}
public void testUnparseableFiles () throws Exception {
final ByteArrayOutputStream baos = new ByteArrayOutputStream () ;
baos . write ( lr_2 . getBytes () ) ;
baos . write ( new byte [] { '\r' , '\n' } ) ;
baos . write ( lr_3 . getBytes () ) ;
baos . write ( new byte [] { '\r' , '\n' } ) ;
final FTPFileEntryParser parser = new UnixFTPEntryParser () ;
final FTPClientConfig config = new FTPClientConfig () ;
FTPListParseEngine engine = new FTPListParseEngine ( parser , config ) ;
config . setUnparseableEntries ( false ) ;
engine . readServerList ( new ByteArrayInputStream ( baos . toByteArray () ) , null ) ;
FTPFile [] files = engine . getFiles () ;
assertEquals ( 1 , files . length ) ;
config . setUnparseableEntries ( true ) ;
engine = new FTPListParseEngine ( parser , config ) ;
engine . readServerList ( new ByteArrayInputStream ( baos . toByteArray () ) , null ) ;
files = engine . getFiles () ;
assertEquals ( 2 , files . length ) ;
}
@Override
public InetAddress getRemoteAddress () {
try {
return InetAddress . getByName ( passiveModeServerIP ) ;
} catch ( final Exception e ) {
throw new RuntimeException ( e ) ;
}
}
public void testParsePassiveModeReplyForLocalAddressWithNatWorkaround () throws Exception {
final FTPClient client = new PassiveNatWorkAroundLocalClient ( lr_4 ) ;
client . _parsePassiveModeReply ( lr_5 ) ;
assertEquals ( lr_4 , client . getPassiveHost () ) ;
}
public void testParsePassiveModeReplyForNonLocalAddressWithNatWorkaround () throws Exception {
final FTPClient client = new PassiveNatWorkAroundLocalClient ( lr_4 ) ;
client . _parsePassiveModeReply ( lr_6 ) ;
assertEquals ( lr_7 , client . getPassiveHost () ) ;
}
@SuppressWarnings ( lr_8 )
public void testParsePassiveModeReplyForLocalAddressWithNatWorkaroundDisabled () throws Exception {
final FTPClient client = new PassiveNatWorkAroundLocalClient ( lr_4 ) ;
client . setPassiveNatWorkaround ( false ) ;
client . _parsePassiveModeReply ( lr_5 ) ;
assertEquals ( lr_9 , client . getPassiveHost () ) ;
}
@SuppressWarnings ( lr_8 )
public void testParsePassiveModeReplyForNonLocalAddressWithNatWorkaroundDisabled () throws Exception {
final FTPClient client = new PassiveNatWorkAroundLocalClient ( lr_4 ) ;
client . setPassiveNatWorkaround ( false ) ;
client . _parsePassiveModeReply ( lr_6 ) ;
assertEquals ( lr_7 , client . getPassiveHost () ) ;
}
public void testParsePassiveModeReplyForLocalAddressWithoutNatWorkaroundStrategy () throws Exception {
final FTPClient client = new PassiveNatWorkAroundLocalClient ( lr_4 ) ;
client . setPassiveNatWorkaroundStrategy ( null ) ;
client . _parsePassiveModeReply ( lr_5 ) ;
assertEquals ( lr_9 , client . getPassiveHost () ) ;
}
public void testParsePassiveModeReplyForNonLocalAddressWithoutNatWorkaroundStrategy () throws Exception {
final FTPClient client = new PassiveNatWorkAroundLocalClient ( lr_4 ) ;
client . setPassiveNatWorkaroundStrategy ( null ) ;
client . _parsePassiveModeReply ( lr_6 ) ;
assertEquals ( lr_7 , client . getPassiveHost () ) ;
}
@Override
public String resolve ( final String hostname ) throws UnknownHostException {
return lr_10 ;
}
