@Override
public void testParseFieldsOnDirectory () throws Exception
{
final FTPFile dir = getParser () . parseFTPEntry ( lr_1 ) ;
assertNotNull ( lr_2 , dir ) ;
assertTrue ( lr_3 ,
dir . isDirectory () ) ;
assertEquals ( 0 , dir . getSize () ) ;
assertEquals ( lr_4 , dir . getName () ) ;
assertEquals ( lr_5 ,
df . format ( dir . getTimestamp () . getTime () ) ) ;
}
@Override
public void testParseFieldsOnFile () throws Exception
{
final FTPFile file = getParser () . parseFTPEntry ( lr_6 ) ;
assertNotNull ( lr_2 , file ) ;
assertTrue ( lr_7 ,
file . isFile () ) ;
assertEquals ( 5000000000L , file . getSize () ) ;
assertEquals ( lr_8 , file . getName () ) ;
assertEquals ( lr_9 ,
df . format ( file . getTimestamp () . getTime () ) ) ;
}
@Override
protected String [] getBadListing ()
{
return badsamples ;
}
@Override
protected String [] getGoodListing ()
{
return goodsamples ;
}
@Override
protected FTPFileEntryParser getParser ()
{
final ConfigurableFTPFileEntryParserImpl parser =
new OS2FTPEntryParser () ;
parser . configure ( null ) ;
return parser ;
}
@Override
public void testDefaultPrecision () {
testPrecision ( lr_10 , CalendarUnit . MINUTE ) ;
testPrecision ( lr_11 , CalendarUnit . MINUTE ) ;
}
@Override
public void testRecentPrecision () {
}
