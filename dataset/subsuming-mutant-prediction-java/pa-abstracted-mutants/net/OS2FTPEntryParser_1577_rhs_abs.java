@Override
public FTPFile parseFTPEntry ( final String entry )
{
final FTPFile f = new FTPFile () ;
if ( matches ( entry ) )
{
final String size = group ( 1 ) ;
final String attrib = group ( 2 ) ; MST[NonVoidMethodCallMutator]MSP[N]
final String dirString = group ( 3 ) ;
final String datestr = group ( 4 ) + lr_1 + group ( 5 ) ;
final String name = group ( 6 ) ;
try
{
f . setTimestamp ( super . parseTimestamp ( datestr ) ) ;
}
catch ( final ParseException e )
{
}
if ( dirString . trim () . equals ( lr_2 ) || attrib . trim () . equals ( lr_2 ) )
{
f . setType ( FTPFile . DIRECTORY_TYPE ) ;
}
else
{
f . setType ( FTPFile . FILE_TYPE ) ;
}
f . setName ( name . trim () ) ;
f . setSize ( Long . parseLong ( size . trim () ) ) ;
return f ;
}
return null ;
}
@Override
protected FTPClientConfig getDefaultConfiguration () {
return new FTPClientConfig (
FTPClientConfig . SYST_OS2 ,
DEFAULT_DATE_FORMAT ,
null ) ;
}
