static IMAPClient imapLogin ( final URI uri , final int defaultTimeout , final ProtocolCommandListener listener )
throws IOException {
final String userInfo = uri . getUserInfo () ; MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
if ( userInfo == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final String [] userpass = userInfo . split ( lr_2 ) ;
if ( userpass . length != 2 ) {
throw new IllegalArgumentException ( lr_3 + userInfo + lr_4 ) ;
}
final String username = userpass [ 0 ] ;
String password = userpass [ 1 ] ;
password = Utils . getPassword ( username , password ) ;
final IMAPClient imap ;
final String scheme = uri . getScheme () ;
if ( lr_5 . equalsIgnoreCase ( scheme ) ) {
System . out . println ( lr_6 ) ;
imap = new IMAPSClient ( true ) ;
} else if ( lr_7 . equalsIgnoreCase ( scheme ) ) {
imap = new IMAPClient () ;
} else {
throw new IllegalArgumentException ( lr_8 + scheme ) ;
}
final int port = uri . getPort () ;
if ( port != - 1 ) {
imap . setDefaultPort ( port ) ;
}
imap . setDefaultTimeout ( defaultTimeout ) ;
if ( listener != null ) {
imap . addProtocolCommandListener ( listener ) ;
}
final String server = uri . getHost () ;
System . out . println ( lr_9 + server + lr_10 + imap . getDefaultPort () ) ;
try {
imap . connect ( server ) ;
System . out . println ( lr_11 ) ;
} catch ( final IOException e ) {
throw new RuntimeException ( lr_12 , e ) ;
}
if ( ! imap . login ( username , password ) ) {
imap . disconnect () ;
throw new RuntimeException ( lr_13 ) ;
}
return imap ;
}
