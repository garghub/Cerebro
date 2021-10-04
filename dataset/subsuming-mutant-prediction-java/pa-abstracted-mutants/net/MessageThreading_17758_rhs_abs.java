public static void main ( final String [] args ) throws SocketException , IOException {
if ( args . length != 2 && args . length != 4 ) {
System . out . println ( lr_1 ) ;
return;
}
final String hostname = args [ 0 ] ;
final String newsgroup = args [ 1 ] ;
final NNTPClient client = new NNTPClient () ; MST[ConstructorCallMutator]MSP[N]
client . addProtocolCommandListener ( new PrintCommandListener ( new PrintWriter ( System . out ) , true ) ) ;
client . connect ( hostname ) ;
if ( args . length == 4 ) {
final String user = args [ 2 ] ;
final String password = args [ 3 ] ;
if( ! client . authenticate ( user , password ) ) {
System . out . println ( lr_2 + user + lr_3 ) ;
System . exit ( 1 ) ;
}
}
final String fmt [] = client . listOverviewFmt () ;
if ( fmt != null ) {
System . out . println ( lr_4 ) ;
for( final String s : fmt ) {
System . out . println ( s ) ;
}
} else {
System . out . println ( lr_5 ) ;
}
final NewsgroupInfo group = new NewsgroupInfo () ;
client . selectNewsgroup ( newsgroup , group ) ;
final long lowArticleNumber = group . getFirstArticleLong () ;
final long highArticleNumber = lowArticleNumber + 5000 ;
System . out . println ( lr_6 + lowArticleNumber + lr_7 + highArticleNumber + lr_8 ) ;
final Iterable < Article > articles = client . iterateArticleInfo ( lowArticleNumber , highArticleNumber ) ;
System . out . println ( lr_9 ) ;
final Threader threader = new Threader () ;
final Article root = ( Article ) threader . thread ( articles ) ;
Article . printThread ( root , 0 ) ;
}
