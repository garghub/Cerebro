@Override
protected String [] getBadListing () {
return badsamples ;
}
@Override
protected String [] getGoodListing () {
return goodsamples ;
}
public void testNumericDateFormat ()
{
final String testNumericDF =
lr_1 ;
final String testNumericDF2 =
lr_2 ;
final UnixFTPEntryParser parser =
new UnixFTPEntryParser ( UnixFTPEntryParser . NUMERIC_DATE_CONFIG ) ;
final FTPFile f = parser . parseFTPEntry ( testNumericDF ) ;
assertNotNull ( lr_3 + testNumericDF , f ) ;
final Calendar cal = Calendar . getInstance () ;
cal . clear () ;
cal . set ( Calendar . YEAR , 2005 ) ;
cal . set ( Calendar . MONTH , Calendar . APRIL ) ;
cal . set ( Calendar . DAY_OF_MONTH , 8 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 11 ) ;
cal . set ( Calendar . MINUTE , 22 ) ;
assertEquals ( cal . getTime () , f . getTimestamp () . getTime () ) ;
final FTPFile f2 = parser . parseFTPEntry ( testNumericDF2 ) ;
assertNotNull ( lr_3 + testNumericDF2 , f2 ) ;
assertEquals ( lr_4 , lr_5 , f2 . getLink () ) ;
}
@Override
protected FTPFileEntryParser getParser () {
return new UnixFTPEntryParser () ;
}
public void testOwnerNameWithSpaces () {
final FTPFile f = getParser () . parseFTPEntry ( lr_6 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_7 , f . getUser () ) ;
}
public void testOwnerAndGroupNameWithSpaces () {
final FTPFile f = getParser () . parseFTPEntry ( lr_8 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_7 , f . getUser () ) ;
assertEquals ( lr_9 , f . getGroup () ) ;
}
public void testNET294 () {
final FTPFile f = getParser () . parseFTPEntry (
lr_10 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_11 , f . getUser () ) ;
assertEquals ( lr_12 , f . getGroup () ) ;
assertEquals ( 816026400L , f . getSize () ) ;
assertNotNull ( lr_13 , f . getTimestamp () ) ;
assertEquals ( 2008 , f . getTimestamp () . get ( Calendar . YEAR ) ) ;
assertEquals ( lr_14 , f . getName () ) ;
}
public void testGroupNameWithSpaces () {
final FTPFile f = getParser () . parseFTPEntry ( lr_15 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_16 , f . getUser () ) ;
assertEquals ( lr_17 , f . getGroup () ) ;
}
public void testTrailingSpaces () {
final FTPFile f = getParser () . parseFTPEntry ( lr_18 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_19 , f . getName () ) ;
}
public void testLeadingSpacesDefault () {
final FTPFile f = getParser () . parseFTPEntry ( lr_20 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_21 , f . getName () ) ;
}
public void testLeadingSpacesNET566 () {
final FTPFile f = new UnixFTPEntryParser ( null , false ) . parseFTPEntry (
lr_20 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_21 , f . getName () ) ;
}
public void testTrimLeadingSpacesNET566 () {
final FTPFile f = new UnixFTPEntryParser ( null , true ) . parseFTPEntry (
lr_20 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_22 , f . getName () ) ;
}
public void testNameWIthPunctuation () {
final FTPFile f = getParser () . parseFTPEntry ( lr_23 ) ;
assertNotNull ( f ) ;
assertEquals ( lr_24 , f . getName () ) ;
}
public void testNoSpacesBeforeFileSize () {
final FTPFile f = getParser () . parseFTPEntry ( lr_25 ) ;
assertNotNull ( f ) ;
assertEquals ( 41472 , f . getSize () ) ;
assertEquals ( f . getType () , FTPFile . DIRECTORY_TYPE ) ;
assertEquals ( lr_26 , f . getUser () ) ;
assertEquals ( lr_26 , f . getGroup () ) ;
assertEquals ( 1464 , f . getHardLinkCount () ) ;
}
public void testCorrectGroupNameParsing () {
final FTPFile f = getParser () . parseFTPEntry ( lr_27 ) ;
assertNotNull ( f ) ;
assertEquals ( 1 , f . getHardLinkCount () ) ;
assertEquals ( lr_28 , f . getUser () ) ;
assertEquals ( lr_29 , f . getGroup () ) ;
assertEquals ( 12414535 , f . getSize () ) ;
assertEquals ( lr_30 , f . getName () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . DAY_OF_MONTH , 17 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 11 ) ;
cal . set ( Calendar . MINUTE , 7 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
cal . set ( Calendar . MILLISECOND , 0 ) ;
assertEquals ( f . getTimestamp () . get ( Calendar . MONTH ) , cal . get ( Calendar . MONTH ) ) ;
assertEquals ( f . getTimestamp () . get ( Calendar . DAY_OF_MONTH ) , cal . get ( Calendar . DAY_OF_MONTH ) ) ;
assertEquals ( f . getTimestamp () . get ( Calendar . HOUR_OF_DAY ) , cal . get ( Calendar . HOUR_OF_DAY ) ) ;
assertEquals ( f . getTimestamp () . get ( Calendar . MINUTE ) , cal . get ( Calendar . MINUTE ) ) ;
assertEquals ( f . getTimestamp () . get ( Calendar . SECOND ) , cal . get ( Calendar . SECOND ) ) ;
}
public void testFilenamesWithEmbeddedNumbers () {
final FTPFile f = getParser () . parseFTPEntry ( lr_31 ) ;
assertEquals ( lr_32 , f . getName () ) ;
assertEquals ( 5840 , f . getSize () ) ;
assertEquals ( lr_33 , f . getUser () ) ;
assertEquals ( lr_34 , f . getGroup () ) ;
}
@Override
public void testParseFieldsOnDirectory () throws Exception {
final FTPFile f = getParser () . parseFTPEntry ( lr_35 ) ;
assertNotNull ( lr_36 , f ) ;
assertTrue ( lr_37 , f . isDirectory () ) ;
checkPermissions ( f ) ;
assertEquals ( 2 , f . getHardLinkCount () ) ;
assertEquals ( lr_33 , f . getUser () ) ;
assertEquals ( lr_34 , f . getGroup () ) ;
assertEquals ( lr_22 , f . getName () ) ;
assertEquals ( 4096 , f . getSize () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . DAY_OF_MONTH , 1 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 0 ) ;
cal . set ( Calendar . MINUTE , 0 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
if ( f . getTimestamp () . getTime () . before ( cal . getTime () ) ) {
cal . add ( Calendar . YEAR , - 1 ) ;
}
cal . set ( Calendar . DAY_OF_MONTH , 2 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 15 ) ;
cal . set ( Calendar . MINUTE , 13 ) ;
assertEquals ( df . format ( cal . getTime () ) , df . format ( f . getTimestamp () . getTime () ) ) ;
}
@Override
public void testRecentPrecision () {
testPrecision ( lr_35 , CalendarUnit . MINUTE ) ;
}
@Override
public void testDefaultPrecision () {
testPrecision ( lr_38 , CalendarUnit . DAY_OF_MONTH ) ;
}
private void checkPermissions ( final FTPFile f ) {
assertTrue ( lr_39 , f . hasPermission (
FTPFile . USER_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_40 , f . hasPermission (
FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_41 , f . hasPermission (
FTPFile . USER_ACCESS , FTPFile . EXECUTE_PERMISSION ) ) ;
assertTrue ( lr_42 , f . hasPermission (
FTPFile . GROUP_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_43 , ! f . hasPermission (
FTPFile . GROUP_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_44 , f . hasPermission (
FTPFile . GROUP_ACCESS , FTPFile . EXECUTE_PERMISSION ) ) ;
assertTrue ( lr_45 , f . hasPermission (
FTPFile . WORLD_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_46 , ! f . hasPermission (
FTPFile . WORLD_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_47 , f . hasPermission (
FTPFile . WORLD_ACCESS , FTPFile . EXECUTE_PERMISSION ) ) ;
}
@Override
public void testParseFieldsOnFile () throws Exception {
final FTPFile f = getParser ()
. parseFTPEntry (
lr_48 ) ;
assertNotNull ( lr_36 , f ) ;
assertTrue ( lr_49 , f . isFile () ) ;
checkPermissions ( f ) ;
assertEquals ( 2 , f . getHardLinkCount () ) ;
assertEquals ( lr_33 , f . getUser () ) ;
assertEquals ( lr_50 , f . getGroup () ) ;
assertEquals ( lr_22 , f . getName () ) ;
assertEquals ( 5000000000L , f . getSize () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . DAY_OF_MONTH , 1 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 0 ) ;
cal . set ( Calendar . MINUTE , 0 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
if ( f . getTimestamp () . getTime () . before ( cal . getTime () ) ) {
cal . add ( Calendar . YEAR , - 1 ) ;
}
cal . set ( Calendar . DAY_OF_MONTH , 2 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 15 ) ;
cal . set ( Calendar . MINUTE , 13 ) ;
assertEquals ( df . format ( cal . getTime () ) , df . format ( f . getTimestamp () . getTime () ) ) ;
}
public void testParseFieldsOnFileJapaneseTime () throws Exception
{
final FTPFile f = getParser () . parseFTPEntry ( lr_51 ) ;
assertNotNull ( lr_36 , f ) ;
assertTrue ( lr_49 , f . isFile () ) ;
checkPermissions ( f ) ;
assertEquals ( 2 , f . getHardLinkCount () ) ;
assertEquals ( lr_33 , f . getUser () ) ;
assertEquals ( lr_34 , f . getGroup () ) ;
assertEquals ( lr_22 , f . getName () ) ;
assertEquals ( 4096 , f . getSize () ) ;
assertNotNull ( lr_52 , f . getTimestamp () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . DATE , 1 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 0 ) ;
cal . set ( Calendar . MINUTE , 0 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
if ( f . getTimestamp () . getTime () . before ( cal . getTime () ) ) {
cal . add ( Calendar . YEAR , - 1 ) ;
}
cal . set ( Calendar . DATE , 2 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 15 ) ;
cal . set ( Calendar . MINUTE , 13 ) ;
assertEquals ( df . format ( cal . getTime () ) , df . format ( f . getTimestamp () . getTime () ) ) ;
}
public void testParseFieldsOnFileJapaneseYear () throws Exception {
final FTPFile f = getParser () . parseFTPEntry (
lr_53 ) ;
assertNotNull ( lr_36 , f ) ;
assertTrue ( lr_49 , f . isFile () ) ;
checkPermissions ( f ) ;
assertEquals ( 2 , f . getHardLinkCount () ) ;
assertEquals ( lr_33 , f . getUser () ) ;
assertEquals ( lr_34 , f . getGroup () ) ;
assertEquals ( lr_54 , f . getName () ) ;
assertEquals ( 4096 , f . getSize () ) ;
assertNotNull ( lr_52 , f . getTimestamp () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . YEAR , 2003 ) ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . DATE , 2 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 0 ) ;
cal . set ( Calendar . MINUTE , 0 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
assertEquals ( df . format ( cal . getTime () ) , df . format ( f . getTimestamp () . getTime () ) ) ;
}
@Override
protected void doAdditionalGoodTests ( final String test , final FTPFile f ) {
final String link = f . getLink () ;
if ( null != link ) {
final int linklen = link . length () ;
if ( linklen > 0 ) {
assertEquals ( link , test . substring ( test . length () - linklen ) ) ;
assertEquals ( f . getType () , FTPFile . SYMBOLIC_LINK_TYPE ) ;
}
}
final int type = f . getType () ;
switch ( test . charAt ( 0 ) )
{
case 'd' :
assertEquals ( lr_55 + test , type , FTPFile . DIRECTORY_TYPE ) ;
break;
case 'l' :
assertEquals ( lr_55 + test , type , FTPFile . SYMBOLIC_LINK_TYPE ) ;
break;
case 'b' :
case 'c' :
assertEquals ( 0 , f . getHardLinkCount () ) ;
case 'f' :
case '-' :
assertEquals ( lr_55 + test , type , FTPFile . FILE_TYPE ) ;
break;
default:
assertEquals ( lr_55 + test , type , FTPFile . UNKNOWN_TYPE ) ;
}
for ( int access = FTPFile . USER_ACCESS ;
access <= FTPFile . WORLD_ACCESS ; access ++ )
{
for ( int perm = FTPFile . READ_PERMISSION ;
perm <= FTPFile . EXECUTE_PERMISSION ; perm ++ )
{
final int pos = 3 * access + perm + 1 ;
final char permchar = test . charAt ( pos ) ;
assertEquals ( lr_56 + test . substring ( 1 , 10 ) ,
Boolean . valueOf ( f . hasPermission ( access , perm ) ) ,
Boolean . valueOf ( permchar != '-' && ! Character . isUpperCase ( permchar ) ) ) ;
}
}
assertNotNull ( lr_57 , f . getTimestamp () ) ;
}
