@Override
protected String [] getBadListing () {
return badsamples ;
}
@Override
protected String [] getGoodListing () {
return goodsamplesDatasetList ;
}
protected List < String [] > getAllGoodListings () {
final List < String [] > l = new ArrayList <> () ;
l . add ( goodsamplesDatasetList ) ;
l . add ( goodsamplesMemberList ) ;
l . add ( goodsamplesJES1List ) ;
l . add ( goodsamplesJES2List ) ;
l . add ( goodsamplesUnixList ) ;
return l ;
}
@Override
protected FTPFileEntryParser getParser () {
return new MVSFTPEntryParser () ;
}
@Override
public void testGoodListing () throws Exception {
final String [] goodsamples = getGoodListing () ;
final MVSFTPEntryParser parser = new MVSFTPEntryParser () ;
parser . setType ( MVSFTPEntryParser . FILE_LIST_TYPE ) ;
parser . setRegex ( MVSFTPEntryParser . FILE_LIST_REGEX ) ;
for ( final String test : goodsamples ) {
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNotNull ( lr_1 + test , f ) ;
doAdditionalGoodTests ( test , f ) ;
}
}
public void testMemberListing () throws Exception {
final MVSFTPEntryParser parser = new MVSFTPEntryParser () ;
parser . setType ( MVSFTPEntryParser . MEMBER_LIST_TYPE ) ;
parser . setRegex ( MVSFTPEntryParser . MEMBER_LIST_REGEX ) ;
for ( final String test : goodsamplesMemberList ) {
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNotNull ( lr_1 + test , f ) ;
doAdditionalGoodTests ( test , f ) ;
}
}
public void testJesLevel1Listing () {
final MVSFTPEntryParser parser = new MVSFTPEntryParser () ;
parser . setType ( MVSFTPEntryParser . JES_LEVEL_1_LIST_TYPE ) ;
parser . setRegex ( MVSFTPEntryParser . JES_LEVEL_1_LIST_REGEX ) ;
for ( final String test : goodsamplesJES1List ) {
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNotNull ( lr_1 + test , f ) ;
doAdditionalGoodTests ( test , f ) ;
}
}
public void testJesLevel2Listing () {
final MVSFTPEntryParser parser = new MVSFTPEntryParser () ;
parser . setType ( MVSFTPEntryParser . JES_LEVEL_2_LIST_TYPE ) ;
parser . setRegex ( MVSFTPEntryParser . JES_LEVEL_2_LIST_REGEX ) ;
for ( final String test : goodsamplesJES2List ) {
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNotNull ( lr_1 + test , f ) ;
doAdditionalGoodTests ( test , f ) ;
}
}
public void testUnixListings () {
final MVSFTPEntryParser parser = new MVSFTPEntryParser () ;
final List < String > list = new ArrayList <> () ;
Collections . addAll ( list , goodsamplesUnixList ) ;
parser . preParse ( list ) ;
for ( final String test : list ) {
final FTPFile f = parser . parseFTPEntry ( test ) ;
assertNotNull ( lr_1 + test , f ) ;
assertNotNull ( lr_2 + test , f . getName () ) ;
assertNotNull ( lr_3 + test , f . getGroup () ) ;
assertNotNull ( lr_4 + test , f . getUser () ) ;
}
}
@Override
public void testParseFieldsOnDirectory () throws Exception {
final MVSFTPEntryParser parser = new MVSFTPEntryParser () ;
parser . setType ( MVSFTPEntryParser . FILE_LIST_TYPE ) ;
parser . setRegex ( MVSFTPEntryParser . FILE_LIST_REGEX ) ;
FTPFile file = parser
. parseFTPEntry ( lr_5 ) ;
assertNotNull ( lr_6 , file ) ;
assertTrue ( lr_7 , file . isDirectory () ) ;
assertEquals ( lr_8 , file . getName () ) ;
file = parser
. parseFTPEntry ( lr_9 ) ;
assertNotNull ( lr_6 , file ) ;
assertTrue ( lr_7 , file . isDirectory () ) ;
assertEquals ( lr_10 , file . getName () ) ;
}
@Override
public void testParseFieldsOnFile () throws Exception {
FTPFile file = null ;
final MVSFTPEntryParser parser = new MVSFTPEntryParser () ;
parser . setRegex ( MVSFTPEntryParser . FILE_LIST_REGEX ) ;
parser . setType ( MVSFTPEntryParser . FILE_LIST_TYPE ) ;
file = parser . parseFTPEntry ( lr_11 ) ;
assertNotNull ( lr_6 , file ) ;
assertTrue ( lr_12 , file . isFile () ) ;
assertEquals ( lr_13 , file . getName () ) ;
assertNull ( lr_14 , file . getTimestamp () ) ;
parser . setType ( MVSFTPEntryParser . MEMBER_LIST_TYPE ) ;
parser . setRegex ( MVSFTPEntryParser . MEMBER_LIST_REGEX ) ;
file = parser . parseFTPEntry ( lr_15 ) ;
assertNotNull ( lr_6 , file ) ;
assertTrue ( lr_12 , file . isFile () ) ;
assertEquals ( lr_16 , file . getName () ) ;
assertNotNull ( lr_17 , file . getTimestamp () ) ;
file = parser . parseFTPEntry ( lr_18 ) ;
assertNotNull ( lr_6 , file ) ;
assertTrue ( lr_12 , file . isFile () ) ;
assertEquals ( lr_19 , file . getName () ) ;
assertNull ( lr_14 , file . getTimestamp () ) ;
}
@Override
public void doAdditionalGoodTests ( final String test , final FTPFile f ) {
assertNotNull ( lr_20 + test , f . getRawListing () ) ;
assertNotNull ( lr_21 + test , f . getName () ) ;
}
@Override
public void testDefaultPrecision () {
}
@Override
public void testRecentPrecision () {
}
