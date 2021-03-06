public void testBadListing () throws Exception
{
final String [] badsamples = getBadListing () ;
for ( final String test : badsamples )
{
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNull ( lr_1 + test + lr_2 ,
nullFileOrNullDate ( f ) ) ;
doAdditionalBadTests ( test , f ) ;
}
}
public void testGoodListing () throws Exception
{
final String [] goodsamples = getGoodListing () ;
for ( final String test : goodsamples )
{
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNotNull ( lr_3 + test , f ) ;
doAdditionalGoodTests ( test , f ) ;
}
}
protected void doAdditionalGoodTests ( final String test , final FTPFile f )
{
}
protected void doAdditionalBadTests ( final String test , final FTPFile f )
{
}
@Override
protected void setUp () throws Exception
{
super . setUp () ;
parser = getParser () ;
df = new SimpleDateFormat ( lr_4 , Locale . US ) ;
}
protected FTPFile nullFileOrNullDate ( final FTPFile f ) {
if ( f == null ) {
return null ;
}
if ( f . getTimestamp () == null ) {
return null ;
}
return f ;
}
void testPrecision ( final String listEntry , final CalendarUnit expectedPrecision ) {
final FTPFile file = getParser () . parseFTPEntry ( listEntry ) ;
assertNotNull ( lr_5 + listEntry , file ) ;
final Calendar stamp = file . getTimestamp () ;
assertNotNull ( lr_6 + listEntry , stamp ) ;
final int ordinal = expectedPrecision . ordinal () ;
final CalendarUnit [] values = CalendarUnit . values () ;
for( int i = ordinal ; i < values . length ; i ++ ) {
final CalendarUnit unit = values [ i ] ;
assertTrue ( lr_7 + unit + lr_8 + listEntry , stamp . isSet ( unit . unit ) ) ;
}
if ( ordinal > 0 ) {
final CalendarUnit prevUnit = values [ ordinal - 1 ] ;
assertFalse ( lr_9 + prevUnit + lr_8 + listEntry , stamp . isSet ( prevUnit . unit ) ) ;
}
}
