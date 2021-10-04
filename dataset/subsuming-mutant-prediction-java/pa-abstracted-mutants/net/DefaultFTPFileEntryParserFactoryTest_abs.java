public void testDefaultParserFactory () throws Exception {
final DefaultFTPFileEntryParserFactory factory =
new DefaultFTPFileEntryParserFactory () ;
FTPFileEntryParser parser = factory . createFileEntryParser ( lr_1 ) ;
assertTrue ( parser instanceof UnixFTPEntryParser ) ;
parser = factory . createFileEntryParser ( lr_2 ) ;
assertTrue ( parser instanceof UnixFTPEntryParser ) ;
assertFalse ( ( ( UnixFTPEntryParser ) parser ) . trimLeadingSpaces ) ;
parser = factory . createFileEntryParser ( lr_3 ) ;
assertTrue ( parser instanceof UnixFTPEntryParser ) ;
assertTrue ( ( ( UnixFTPEntryParser ) parser ) . trimLeadingSpaces ) ;
parser = factory . createFileEntryParser ( lr_4 ) ;
assertTrue ( parser instanceof UnixFTPEntryParser ) ;
parser = factory . createFileEntryParser ( lr_5 ) ;
assertTrue ( parser instanceof UnixFTPEntryParser ) ;
assertFalse ( parser instanceof EnterpriseUnixFTPEntryParser ) ;
parser = factory . createFileEntryParser ( lr_6 ) ;
assertTrue ( parser instanceof UnixFTPEntryParser ) ;
try {
parser = factory . createFileEntryParser ( lr_7 ) ;
fail ( lr_8 ) ;
} catch ( final ParserInitializationException pie ) {
assertNull ( pie . getCause () ) ;
assertTrue ( pie . getMessage () + lr_9 ,
pie . getMessage () . contains ( lr_10 ) ) ;
}
parser = factory . createFileEntryParser ( lr_11 ) ;
assertTrue ( parser instanceof CompositeFileEntryParser ) ;
parser = factory . createFileEntryParser ( lr_12 ) ;
assertTrue ( parser instanceof VMSFTPEntryParser ) ;
parser = factory . createFileEntryParser ( lr_13 ) ;
assertTrue ( parser instanceof OS2FTPEntryParser ) ;
parser = factory . createFileEntryParser ( lr_14 ) ;
assertTrue ( parser instanceof CompositeFileEntryParser ) ;
parser = factory . createFileEntryParser ( lr_15 ) ;
assertTrue ( parser instanceof CompositeFileEntryParser ) ;
parser = factory . createFileEntryParser ( lr_16 ) ;
try {
parser = factory . createFileEntryParser ( lr_17 ) ;
fail ( lr_18 ) ;
} catch ( final ParserInitializationException pie ) {
assertNull ( pie . getCause () ) ;
}
parser = factory . createFileEntryParser (
lr_19 ) ;
assertTrue ( parser instanceof OS2FTPEntryParser ) ;
try {
factory . createFileEntryParser (
lr_20 ) ;
fail ( lr_21 ) ;
} catch ( final ParserInitializationException pie ) {
final Throwable root = pie . getCause () ;
assertTrue ( root instanceof ClassCastException ) ;
}
try {
factory . createFileEntryParser ( lr_22 ) ;
fail ( lr_23 ) ;
} catch ( final ParserInitializationException pie ) {
final Throwable root = pie . getCause () ;
assertTrue ( root instanceof InstantiationException ) ;
}
try {
factory . createFileEntryParser ( lr_24 ) ;
fail ( lr_23 ) ;
} catch ( final ParserInitializationException pie ) {
final Throwable root = pie . getCause () ;
assertTrue ( root instanceof InstantiationException ) ;
}
}
private void checkParserClass ( final FTPFileEntryParserFactory fact , final String key , final Class < ? > expected ) {
final FTPClientConfig config = key == null ? new FTPClientConfig () : new FTPClientConfig ( key ) ;
final FTPFileEntryParser parser = fact . createFileEntryParser ( config ) ;
assertNotNull ( parser ) ;
assertTrue ( lr_25 + expected . getCanonicalName () + lr_26 + parser . getClass () . getCanonicalName () ,
expected . isInstance ( parser ) ) ;
}
public void testDefaultParserFactoryConfig () throws Exception {
final DefaultFTPFileEntryParserFactory factory =
new DefaultFTPFileEntryParserFactory () ;
try {
factory . createFileEntryParser ( ( FTPClientConfig ) null ) ;
fail ( lr_27 ) ;
} catch ( final NullPointerException npe ) {
}
checkParserClass ( factory , null , UnixFTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_OS400 , OS400FTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_AS400 , CompositeFileEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_L8 , UnixFTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_MVS , MVSFTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_NETWARE , NetwareFTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_NT , NTFTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_OS2 , OS2FTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_UNIX , UnixFTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_VMS , VMSFTPEntryParser . class ) ;
checkParserClass ( factory , FTPClientConfig . SYST_MACOS_PETER , MacOsPeterFTPEntryParser . class ) ;
checkParserClass ( factory , lr_28 , NTFTPEntryParser . class ) ;
checkParserClass ( factory , lr_29 , CompositeFileEntryParser . class ) ;
checkParserClass ( factory , lr_14 , OS400FTPEntryParser . class ) ;
checkParserClass ( factory , lr_30 , CompositeFileEntryParser . class ) ;
}
