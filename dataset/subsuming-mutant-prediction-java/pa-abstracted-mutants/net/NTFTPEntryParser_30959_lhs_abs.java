@Override
public FTPFile parseFTPEntry ( final String entry )
{
final FTPFile f = new FTPFile () ;
f . setRawListing ( entry ) ;
if ( matches ( entry ) )
{
final String datestr = group ( 1 ) + lr_1 + group ( 2 ) ;
final String dirString = group ( 3 ) ;
final String size = group ( 4 ) ;
final String name = group ( 5 ) ; MST[rv.CRCR3Mutator]MSP[]
try
{
f . setTimestamp ( super . parseTimestamp ( datestr ) ) ;
}
catch ( final ParseException e )
{
try
{
f . setTimestamp ( timestampParser . parseTimestamp ( datestr ) ) ;
}
catch ( final ParseException e2 )
{
}
}
if ( null == name || name . equals ( lr_2 ) || name . equals ( lr_3 ) )
{
return null ;
}
f . setName ( name ) ;
if ( lr_4 . equals ( dirString ) )
{
f . setType ( FTPFile . DIRECTORY_TYPE ) ;
f . setSize ( 0 ) ;
}
else
{
f . setType ( FTPFile . FILE_TYPE ) ;
if ( null != size )
{
f . setSize ( Long . parseLong ( size ) ) ;
}
}
return f ;
}
return null ;
}
@Override
public FTPClientConfig getDefaultConfiguration () {
return new FTPClientConfig (
FTPClientConfig . SYST_NT ,
DEFAULT_DATE_FORMAT ,
null ) ;
}
