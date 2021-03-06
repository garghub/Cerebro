@Override
protected String [] [] getBadListings ()
{
return badsamples ;
}
@Override
protected String [] [] getGoodListings ()
{
return goodsamples ;
}
@Override
protected FTPFileEntryParser getParser ()
{
return new CompositeFileEntryParser ( new FTPFileEntryParser []
{
new OS400FTPEntryParser () ,
new UnixFTPEntryParser ()
} ) ;
}
@Override
public void testParseFieldsOnDirectory () throws Exception
{
final FTPFile f = getParser () . parseFTPEntry ( lr_1 ) ;
assertNotNull ( lr_2 ,
f ) ;
assertTrue ( lr_3 ,
f . isDirectory () ) ;
assertEquals ( lr_4 ,
f . getUser () ) ;
assertEquals ( lr_5 ,
f . getName () ) ;
assertEquals ( 36864 ,
f . getSize () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . YEAR , 2004 ) ;
cal . set ( Calendar . DAY_OF_MONTH , 24 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 14 ) ;
cal . set ( Calendar . MINUTE , 6 ) ;
cal . set ( Calendar . SECOND , 34 ) ;
assertEquals ( df . format ( cal . getTime () ) ,
df . format ( f . getTimestamp () . getTime () ) ) ;
}
@Override
protected void doAdditionalGoodTests ( final String test , final FTPFile f )
{
if ( test . startsWith ( lr_6 ) )
{
assertEquals ( lr_7 ,
FTPFile . DIRECTORY_TYPE , f . getType () ) ;
}
}
@Override
public void testParseFieldsOnFile () throws Exception
{
final FTPFile f = getParser () . parseFTPEntry ( lr_8 ) ;
assertNotNull ( lr_2 ,
f ) ;
assertTrue ( lr_9 ,
f . isFile () ) ;
assertEquals ( lr_4 ,
f . getUser () ) ;
assertEquals ( lr_10 ,
f . getName () ) ;
assertEquals ( 5000000000L ,
f . getSize () ) ;
final Calendar cal = Calendar . getInstance () ;
cal . set ( Calendar . DAY_OF_MONTH , 24 ) ;
cal . set ( Calendar . MONTH , Calendar . MARCH ) ;
cal . set ( Calendar . YEAR , 2004 ) ;
cal . set ( Calendar . HOUR_OF_DAY , 14 ) ;
cal . set ( Calendar . MINUTE , 6 ) ;
cal . set ( Calendar . SECOND , 29 ) ;
assertEquals ( df . format ( cal . getTime () ) ,
df . format ( f . getTimestamp () . getTime () ) ) ;
}
@Override
public void testDefaultPrecision () {
}
@Override
public void testRecentPrecision () {
}
