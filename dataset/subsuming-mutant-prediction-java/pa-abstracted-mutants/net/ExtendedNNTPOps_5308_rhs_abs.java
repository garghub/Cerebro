private void demo ( final String host , final String user , final String password ) {
try {
client . connect ( host ) ;
if ( user != null && password != null ) {
final boolean success = client . authenticate ( user , password ) ;
if ( success ) {
System . out . println ( lr_1 ) ;
} else {
System . out . println ( lr_2 + client . getReplyString () ) ;
}
}
final NewsgroupInfo testGroup = new NewsgroupInfo () ;
client . selectNewsgroup ( lr_3 , testGroup ) ;
final long lowArticleNumber = testGroup . getFirstArticleLong () ;
final long highArticleNumber = lowArticleNumber + 100 ;
final Iterable < Article > articles = client . iterateArticleInfo ( lowArticleNumber , highArticleNumber ) ;
for ( final Article article : articles ) {
if ( article . isDummy () ) {
System . out . println ( lr_4 + article . getSubject () ) ;
} else {
System . out . println ( article . getSubject () ) ;
}
}
final NewsgroupInfo [] fanGroups = client . listNewsgroups ( lr_5 ) ;
for ( final NewsgroupInfo fanGroup : fanGroups )
{
System . out . println ( fanGroup . getNewsgroup () ) ;
}
} catch ( final IOException e ) {
e . printStackTrace () ;
}
}
public static void main ( final String [] args ) {
ExtendedNNTPOps ops ;
final int argc = args . length ;
if ( argc < 1 ) {
System . err . println ( lr_6 ) ;
System . exit ( 1 ) ; MST[rv.CRCR6Mutator]MSP[S]
}
ops = new ExtendedNNTPOps () ;
ops . demo ( args [ 0 ] , argc >= 3 ? args [ 1 ] : null , argc >= 3 ? args [ 2 ] : null ) ;
}
