@Override
public void testParseFieldsOnDirectory () throws Exception
{
}
@Override
public void testParseFieldsOnFile () throws Exception
{
final FTPFile file = getParser () . parseFTPEntry ( lr_1 ) ;
final Calendar today = Calendar . getInstance () ;
int year = today . get ( Calendar . YEAR ) ;
assertTrue ( lr_2 , file . isFile () ) ;
assertEquals ( lr_3 , file . getName () ) ;
assertEquals ( 5000000000L , file . getSize () ) ;
assertEquals ( lr_4 , file . getUser () ) ;
assertEquals ( lr_5 , file . getGroup () ) ;
if ( today . get ( Calendar . MONTH ) < Calendar . AUGUST ) {
-- year ;
}
final Calendar timestamp = file . getTimestamp () ;
assertEquals ( year , timestamp . get ( Calendar . YEAR ) ) ;
assertEquals ( Calendar . AUGUST , timestamp . get ( Calendar . MONTH ) ) ;
assertEquals ( 12 , timestamp . get ( Calendar . DAY_OF_MONTH ) ) ;
assertEquals ( 13 , timestamp . get ( Calendar . HOUR_OF_DAY ) ) ;
assertEquals ( 56 , timestamp . get ( Calendar . MINUTE ) ) ;
assertEquals ( 0 , timestamp . get ( Calendar . SECOND ) ) ;
checkPermisions ( file ) ;
}
@Override
public void testRecentPrecision () {
testPrecision ( lr_1 , CalendarUnit . MINUTE ) ;
}
@Override
public void testDefaultPrecision () {
testPrecision ( lr_6 , CalendarUnit . DAY_OF_MONTH ) ;
}
@Override
protected String [] getBadListing ()
{
return BADSAMPLES ;
}
@Override
protected String [] getGoodListing ()
{
return GOODSAMPLES ;
}
@Override
protected FTPFileEntryParser getParser ()
{
return new EnterpriseUnixFTPEntryParser () ;
}
private void checkPermisions ( final FTPFile dir )
{
assertTrue ( lr_7 ,
! dir . hasPermission ( FTPFile . USER_ACCESS ,
FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_8 ,
! dir . hasPermission ( FTPFile . USER_ACCESS ,
FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_9 ,
! dir . hasPermission ( FTPFile . USER_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
assertTrue ( lr_10 ,
! dir . hasPermission ( FTPFile . GROUP_ACCESS ,
FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_11 ,
! dir . hasPermission ( FTPFile . GROUP_ACCESS ,
FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_12 ,
! dir . hasPermission ( FTPFile . GROUP_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
assertTrue ( lr_13 ,
! dir . hasPermission ( FTPFile . WORLD_ACCESS ,
FTPFile . READ_PERMISSION ) ) ;
assertTrue ( lr_14 ,
! dir . hasPermission ( FTPFile . WORLD_ACCESS ,
FTPFile . WRITE_PERMISSION ) ) ;
assertTrue ( lr_15 ,
! dir . hasPermission ( FTPFile . WORLD_ACCESS ,
FTPFile . EXECUTE_PERMISSION ) ) ;
}
