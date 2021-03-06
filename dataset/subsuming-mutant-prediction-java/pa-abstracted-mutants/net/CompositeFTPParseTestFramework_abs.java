@Override
protected String [] getGoodListing ()
{
return getGoodListings () [ 0 ] ;
}
@Override
protected String [] getBadListing ()
{
return getBadListings () [ 0 ] ;
}
public void testConsistentListing () throws Exception
{
final String goodsamples [] [] = getGoodListings () ;
for ( final String [] goodsample : goodsamples )
{
final FTPFileEntryParser parser = getParser () ;
for ( final String test : goodsample ) {
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNotNull ( lr_1 + test ,
f ) ;
doAdditionalGoodTests ( test , f ) ;
}
}
}
@Override
public void testBadListing () throws Exception
{
final String badsamples [] [] = getBadListings () ;
for ( final String [] badsample : badsamples )
{
final FTPFileEntryParser parser = getParser () ;
for ( final String test : badsample ) {
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNull ( lr_2 + test ,
nullFileOrNullDate ( f ) ) ;
doAdditionalBadTests ( test , f ) ;
}
}
}
public void testInconsistentListing () throws Exception
{
final String goodsamples [] [] = getGoodListings () ;
final FTPFileEntryParser parser = getParser () ;
for ( int i = 0 ; i < goodsamples . length ; i ++ )
{
final String test = goodsamples [ i ] [ 0 ] ;
final FTPFile f = parser . parseFTPEntry ( test ) ;
switch ( i )
{
case 0 :
assertNotNull ( lr_1 + test , f ) ;
break;
case 1 :
assertNull ( lr_3 + test , f ) ;
break;
}
}
}
