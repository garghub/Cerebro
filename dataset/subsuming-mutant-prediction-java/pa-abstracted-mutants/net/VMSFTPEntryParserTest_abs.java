public void testWholeListParse () throws IOException
{
final VMSFTPEntryParser parser = new VMSFTPEntryParser () ;
parser . configure ( null ) ;
final FTPListParseEngine engine = new FTPListParseEngine ( parser ) ;
engine . readServerList (
new ByteArrayInputStream ( fullListing . getBytes () ) , null ) ;
final FTPFile [] files = engine . getFiles () ;
assertEquals ( 6 , files . length ) ;
assertFileInListing ( files , lr_1 ) ;
assertFileInListing ( files , lr_2 ) ;
assertFileInListing ( files , lr_3 ) ;
assertFileNotInListing ( files , lr_4 ) ;
}
public void testWholeListParseWithVersioning () throws IOException
{
final VMSFTPEntryParser parser = new VMSVersioningFTPEntryParser () ;
parser . configure ( null ) ;
final FTPListParseEngine engine = new FTPListParseEngine ( parser ) ;
engine . readServerList (
new ByteArrayInputStream ( fullListing . getBytes () ) , null ) ;
final FTPFile [] files = engine . getFiles () ;
assertEquals ( 3 , files . length ) ;
assertFileInListing ( files , lr_4 ) ;
assertFileInListing ( files , lr_5 ) ;
assertFileInListing ( files , lr_6 ) ;
assertFileNotInListing ( files , lr_7 ) ;
assertFileNotInListing ( files , lr_2 ) ;
}
public void assertFileInListing ( final FTPFile [] listing , final String name ) {
for ( final FTPFile element : listing )
{
if ( name . equals ( element . getName () ) ) {
return;
}
}
fail ( lr_8 + name + lr_9 ) ;
}
public void assertFileNotInListing ( final FTPFile [] listing , final String name ) {
for ( final FTPFile element : listing )
{
if ( name . equals ( element . getName () ) ) {
fail ( lr_10 + name + lr_11 ) ;
}
}
}
@Override
public void testParseFieldsOnDirectory () throws Exception
{
FTPFile dir = getParser () . parseFTPEntry (
lr_12 ) ;
assertTrue ( lr_13 ,
dir . isDirectory () ) ;
assertEquals ( lr_14 ,
dir . getName () ) ;
assertEquals ( 512 ,
dir . getSize () ) ;
assertEquals ( lr_15 ,
df . format ( dir . getTimestamp () . getTime () ) ) ;
assertEquals ( lr_16 ,
dir . getGroup () ) ;
assertEquals ( lr_17 ,
dir . getUser () ) ;
checkPermisions ( dir , 0775 ) ;
dir = getParser () . parseFTPEntry (
lr_18 ) ;
assertTrue ( lr_13 ,
dir . isDirectory () ) ;
assertEquals ( lr_14 ,
dir . getName () ) ;
assertEquals ( 512 ,
dir . getSize () ) ;
assertEquals ( lr_15 ,
df . format ( dir . getTimestamp () . getTime () ) ) ;
assertEquals ( null ,
dir . getGroup () ) ;
assertEquals ( lr_19 ,
dir . getUser () ) ;
checkPermisions ( dir , 0705 ) ;
}
@Override
public void testParseFieldsOnFile () throws Exception
{
FTPFile file = getParser () . parseFTPEntry (
lr_20 ) ;
assertTrue ( lr_21 ,
file . isFile () ) ;
assertEquals ( lr_3 ,
file . getName () ) ;
assertEquals ( 9 * 512 ,
file . getSize () ) ;
assertEquals ( lr_15 ,
df . format ( file . getTimestamp () . getTime () ) ) ;
assertEquals ( lr_16 ,
file . getGroup () ) ;
assertEquals ( lr_17 ,
file . getUser () ) ;
checkPermisions ( file , 0764 ) ;
file = getParser () . parseFTPEntry ( lr_22 ) ;
assertTrue ( lr_21 ,
file . isFile () ) ;
assertEquals ( lr_3 ,
file . getName () ) ;
assertEquals ( 9 * 512 ,
file . getSize () ) ;
assertEquals ( lr_15 ,
df . format ( file . getTimestamp () . getTime () ) ) ;
assertEquals ( null ,
file . getGroup () ) ;
assertEquals ( lr_19 ,
file . getUser () ) ;
checkPermisions ( file , 0400 ) ;
}
@Override
public void testDefaultPrecision () {
testPrecision (
lr_22 , CalendarUnit . SECOND ) ;
}
@Override
public void testRecentPrecision () {
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
new VMSFTPEntryParser () ;
parser . configure ( null ) ;
return parser ;
}
protected FTPFileEntryParser getVersioningParser ()
{
final ConfigurableFTPFileEntryParserImpl parser =
new VMSVersioningFTPEntryParser () ;
parser . configure ( null ) ;
return parser ;
}
private void checkPermisions ( final FTPFile dir , final int octalPerm )
{
int permMask = 1 << 8 ;
assertTrue ( lr_23 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . USER_ACCESS ,
FTPFile . READ_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_24 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . USER_ACCESS ,
FTPFile . WRITE_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_25 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . USER_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_26 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . GROUP_ACCESS ,
FTPFile . READ_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_27 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . GROUP_ACCESS ,
FTPFile . WRITE_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_28 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . GROUP_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_29 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . WORLD_ACCESS ,
FTPFile . READ_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_30 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . WORLD_ACCESS ,
FTPFile . WRITE_PERMISSION ) ) ;
permMask >>= 1 ;
assertTrue ( lr_31 ,
( permMask & octalPerm ) != 0 == dir . hasPermission ( FTPFile . WORLD_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
}
