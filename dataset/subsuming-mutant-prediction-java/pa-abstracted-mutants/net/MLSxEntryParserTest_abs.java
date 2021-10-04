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
return MLSxEntryParser . getInstance () ;
}
@Override
protected FTPFile nullFileOrNullDate ( final FTPFile f ) {
return f ;
}
@Override
public void testParseFieldsOnFile () throws Exception {
}
@Override
public void testParseFieldsOnDirectory () throws Exception {
}
@Override
public void testDefaultPrecision () {
testPrecision ( lr_1 , CalendarUnit . SECOND ) ;
}
@Override
public void testRecentPrecision () {
testPrecision ( lr_2 , CalendarUnit . MILLISECOND ) ;
}
