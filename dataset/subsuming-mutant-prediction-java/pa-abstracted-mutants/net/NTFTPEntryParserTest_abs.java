@Override
protected String [] [] getGoodListings ()
{
return goodsamples ;
}
@Override
protected String [] [] getBadListings ()
{
return badsamples ;
}
@Override
protected FTPFileEntryParser getParser ()
{
return new CompositeFileEntryParser ( new FTPFileEntryParser []
{
new NTFTPEntryParser () ,
new UnixFTPEntryParser ()
} ) ;
}
@Override
public void testParseFieldsOnDirectory () throws Exception
{
FTPFile dir = getParser () . parseFTPEntry ( lr_1 ) ;
assertNotNull ( lr_2 , dir ) ;
assertEquals ( lr_3 ,
df . format ( dir . getTimestamp () . getTime () ) ) ;
assertTrue ( lr_4 ,
dir . isDirectory () ) ;
assertEquals ( lr_5 , dir . getName () ) ;
assertEquals ( 0 , dir . getSize () ) ;
dir = getParser () . parseFTPEntry ( lr_6 ) ;
assertNotNull ( lr_2 , dir ) ;
assertTrue ( lr_4 ,
dir . isDirectory () ) ;
assertEquals ( lr_7 , dir . getName () ) ;
assertEquals ( 0 , dir . getSize () ) ;
}
public void testParseLeadingDigits () {
final FTPFile file = getParser () . parseFTPEntry ( lr_8 ) ;
assertNotNull ( lr_9 , file ) ;
assertEquals ( lr_10 , file . getName () ) ;
assertEquals ( 5000000000L , file . getSize () ) ;
Calendar timestamp = file . getTimestamp () ;
assertNotNull ( lr_11 , timestamp ) ;
assertEquals ( lr_12 , df . format ( timestamp . getTime () ) ) ;
final FTPFile dir = getParser () . parseFTPEntry ( lr_13 ) ;
assertNotNull ( lr_9 , dir ) ;
assertEquals ( lr_10 , dir . getName () ) ;
timestamp = dir . getTimestamp () ;
assertNotNull ( lr_11 , timestamp ) ;
assertEquals ( lr_14 , df . format ( timestamp . getTime () ) ) ;
}
public void testNET339 () {
final FTPFile file = getParser () . parseFTPEntry ( lr_15 ) ;
assertNotNull ( lr_9 , file ) ;
assertEquals ( lr_10 , file . getName () ) ;
assertEquals ( 5000000000L , file . getSize () ) ;
Calendar timestamp = file . getTimestamp () ;
assertNotNull ( lr_11 , timestamp ) ;
assertEquals ( lr_16 , df . format ( timestamp . getTime () ) ) ;
final FTPFile dir = getParser () . parseFTPEntry ( lr_17 ) ;
assertNotNull ( lr_9 , dir ) ;
assertEquals ( lr_10 , dir . getName () ) ;
timestamp = dir . getTimestamp () ;
assertNotNull ( lr_11 , timestamp ) ;
assertEquals ( lr_18 , df . format ( timestamp . getTime () ) ) ;
}
@Override
public void testParseFieldsOnFile () throws Exception
{
FTPFile f = getParser () . parseFTPEntry ( lr_19 ) ;
assertNotNull ( lr_2 , f ) ;
assertEquals ( lr_12 ,
df . format ( f . getTimestamp () . getTime () ) ) ;
assertTrue ( lr_20 ,
f . isFile () ) ;
assertEquals ( lr_21 , f . getName () ) ;
assertEquals ( 5000000000L , f . getSize () ) ;
f = getParser () . parseFTPEntry (
lr_22 ) ;
assertNotNull ( lr_2 , f ) ;
final Calendar cal = Calendar . getInstance () ;
cal . setTime ( f . getTimestamp () . getTime () ) ;
assertEquals ( lr_23 , 3 , cal . get ( Calendar . HOUR ) ) ;
assertTrue ( lr_20 ,
f . isFile () ) ;
assertEquals ( 17707 , f . getSize () ) ;
}
@Override
protected void doAdditionalGoodTests ( final String test , final FTPFile f )
{
if ( test . indexOf ( lr_24 ) >= 0 )
{
assertEquals ( lr_25 ,
FTPFile . DIRECTORY_TYPE , f . getType () ) ;
}
}
public void testDirectoryBeginningWithNumber () throws Exception
{
final FTPFile f = getParser () . parseFTPEntry ( directoryBeginningWithNumber ) ;
assertEquals ( lr_26 , lr_27 , f . getName () ) ;
}
public void testDirectoryBeginningWithNumberFollowedBySpaces () throws Exception
{
FTPFile f = getParser () . parseFTPEntry ( lr_28 ) ;
assertEquals ( lr_26 , lr_29 , f . getName () ) ;
f = getParser () . parseFTPEntry ( lr_30 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_26 , lr_31 , f . getName () ) ;
}
public void testGroupNameWithSpaces () {
final FTPFile f = getParser () . parseFTPEntry ( lr_32 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_33 , f . getUser () ) ;
assertEquals ( lr_34 , f . getGroup () ) ;
}
private int testNET516 ( final String charset ) throws Exception {
final FTPFileEntryParser parser = new NTFTPEntryParser () ;
final FTPListParseEngine engine = new FTPListParseEngine ( parser ) ;
engine . readServerList ( new ByteArrayInputStream ( listFilesByteTrace ) , charset ) ;
final FTPFile [] ftpfiles = engine . getFiles () ;
return ftpfiles . length ;
}
public void testNET516 () throws Exception {
final int utf = testNET516 ( lr_35 ) ;
assertEquals ( LISTFILE_COUNT , utf ) ;
final int ascii = testNET516 ( lr_36 ) ;
assertEquals ( LISTFILE_COUNT , ascii ) ;
final int iso8859_1 = testNET516 ( lr_37 ) ;
assertEquals ( LISTFILE_COUNT , iso8859_1 ) ;
}
@Override
public void testDefaultPrecision () {
testPrecision ( lr_38 , CalendarUnit . MINUTE ) ;
testPrecision ( lr_39 , CalendarUnit . MINUTE ) ;
}
@Override
public void testRecentPrecision () {
}
