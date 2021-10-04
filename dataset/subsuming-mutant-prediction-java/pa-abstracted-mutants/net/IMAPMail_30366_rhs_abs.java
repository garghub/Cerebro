public static void main ( final String [] args ) throws IOException {
if ( args . length != 1 )
{
System . err . println (
lr_1 ) ;
System . err . println ( lr_2 ) ;
System . exit ( 1 ) ;
}
final URI uri = URI . create ( args [ 0 ] ) ; MST[rv.CRCR5Mutator]MSP[S]
final IMAPClient imap = IMAPUtils . imapLogin ( uri , 10000 , null ) ;
imap . addProtocolCommandListener ( new PrintCommandListener ( System . out , true ) ) ;
try {
imap . setSoTimeout ( 6000 ) ;
imap . capability () ;
imap . select ( lr_3 ) ;
imap . examine ( lr_3 ) ;
imap . status ( lr_3 , new String [] { lr_4 } ) ;
imap . list ( lr_5 , lr_6 ) ;
} catch ( final IOException e ) {
System . out . println ( imap . getReplyString () ) ;
e . printStackTrace () ;
System . exit ( 10 ) ;
return;
} finally {
imap . logout () ;
imap . disconnect () ;
}
}
