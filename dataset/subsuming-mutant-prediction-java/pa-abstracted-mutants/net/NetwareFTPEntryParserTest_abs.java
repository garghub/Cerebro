@Override
protected String [] getBadListing () {
return badsamples ;
}
@Override
protected String [] getGoodListing () {
return goodsamples ;
}
@Override
protected FTPFileEntryParser getParser () {
return new NetwareFTPEntryParser () ;
}
@Override
public void testParseFieldsOnDirectory () throws Exception {
final String reply = lr_1 ;
final FTPFile f = getParser () . parseFTPEntry ( reply ) ;
assertNotNull ( lr_2 , f ) ;
assertEquals ( lr_3 , f . getName () ) ;
assertEquals ( 512L , f . getSize () ) ;
assertEquals ( lr_4 , f . getUser () ) ;
assertTrue ( lr_5 , f . isDirectory () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , 3 ) ;
cal . set ( Calendar . DAY_OF_MONTH , 13 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 23 ) ;
cal . set ( Calendar . MINUTE , 12 ) ;
cal . set ( Calendar . SECOND , 0 ) ;
cal . set ( Calendar . MILLISECOND , 0 ) ;
cal . set ( Calendar . YEAR , f . getTimestamp () . get ( Calendar . YEAR ) ) ;
assertEquals ( df . format ( cal . getTime () ) , df . format ( f . getTimestamp ()
. getTime () ) ) ;
}
@Override
public void testParseFieldsOnFile () throws Exception {
final String reply = lr_6 ;
final FTPFile f = getParser () . parseFTPEntry ( reply ) ;
assertNotNull ( lr_2 , f ) ;
assertEquals ( lr_7 , f . getName () ) ;
assertEquals ( 19968L , f . getSize () ) ;
assertEquals ( lr_8 , f . getUser () ) ;
assertTrue ( lr_9 , f . isFile () ) ;
assertTrue ( f . hasPermission ( FTPFile . USER_ACCESS , FTPFile . READ_PERMISSION ) ) ;
assertFalse ( f . hasPermission ( FTPFile . USER_ACCESS , FTPFile . WRITE_PERMISSION ) ) ;
}
@Override
public void testDefaultPrecision () {
testPrecision ( lr_10 , CalendarUnit . DAY_OF_MONTH ) ;
}
@Override
public void testRecentPrecision () {
testPrecision ( lr_11 , CalendarUnit . MINUTE ) ;
}
