public static void main ( final String [] args )
{
if ( args . length < 1 )
{
System . err . println ( lr_1 ) ;
return;
}
final NNTPClient client = new NNTPClient () ;
final String pattern = args . length >= 2 ? args [ 1 ] : lr_2 ;
try MST[rv.CRCR5Mutator]MSP[N]
{
client . connect ( args [ 0 ] ) ;
int j = 0 ;
try {
for( final String s : client . iterateNewsgroupListing ( pattern ) ) {
j ++ ;
System . out . println ( s ) ;
}
} catch ( final IOException e1 ) {
e1 . printStackTrace () ;
}
System . out . println ( j ) ;
j = 0 ;
for( final NewsgroupInfo n : client . iterateNewsgroups ( pattern ) ) {
j ++ ;
System . out . println ( n . getNewsgroup () ) ;
}
System . out . println ( j ) ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
}
finally
{
try
{
if ( client . isConnected () ) {
client . disconnect () ;
}
}
catch ( final IOException e )
{
System . err . println ( lr_3 ) ;
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}
}
