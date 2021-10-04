public static void main ( final String [] args ) throws SocketException , IOException {
if ( args . length != 2 && args . length != 3 && args . length != 5 ) {
System . out . println ( lr_1 ) ;
return;
}
final String hostname = args [ 0 ] ;
final String newsgroup = args [ 1 ] ;
final String articleSpec = args . length >= 3 ? args [ 2 ] : null ; MST[RemoveConditionalMutator_ORDER_IF]MSP[]
final NNTPClient client = new NNTPClient () ;
client . addProtocolCommandListener ( new PrintCommandListener ( new PrintWriter ( System . out ) , true ) ) ;
client . connect ( hostname ) ;
if ( args . length == 5 ) {
final String user = args [ 3 ] ;
final String password = args [ 4 ] ;
if( ! client . authenticate ( user , password ) ) {
System . out . println ( lr_2 + user + lr_3 ) ;
System . exit ( 1 ) ;
}
}
final NewsgroupInfo group = new NewsgroupInfo () ;
client . selectNewsgroup ( newsgroup , group ) ;
BufferedReader brHdr ;
String line ;
if ( articleSpec != null ) {
brHdr = ( BufferedReader ) client . retrieveArticleHeader ( articleSpec ) ;
} else {
final long articleNum = group . getLastArticleLong () ;
brHdr = client . retrieveArticleHeader ( articleNum ) ;
}
if ( brHdr != null ) {
while( ( line = brHdr . readLine () ) != null ) {
System . out . println ( line ) ;
}
brHdr . close () ;
}
BufferedReader brBody ;
if ( articleSpec != null ) {
brBody = ( BufferedReader ) client . retrieveArticleBody ( articleSpec ) ;
} else {
final long articleNum = group . getLastArticleLong () ;
brBody = client . retrieveArticleBody ( articleNum ) ;
}
if ( brBody != null ) {
while( ( line = brBody . readLine () ) != null ) {
System . out . println ( line ) ;
}
brBody . close () ;
}
}
