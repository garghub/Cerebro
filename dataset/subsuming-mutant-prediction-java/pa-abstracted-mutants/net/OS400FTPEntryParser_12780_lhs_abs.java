@Override
public FTPFile parseFTPEntry ( final String entry )
{
final FTPFile file = new FTPFile () ;
file . setRawListing ( entry ) ;
int type ;
if ( matches ( entry ) )
{
final String usr = group ( 1 ) ;
final String filesize = group ( 2 ) ;
String datestr = lr_1 ;
if ( ! isNullOrEmpty ( group ( 3 ) ) || ! isNullOrEmpty ( group ( 4 ) ) )
{
datestr = group ( 3 ) + lr_2 + group ( 4 ) ; MST[rv.CRCR3Mutator]MSP[]
}
final String typeStr = group ( 5 ) ;
String name = group ( 6 ) ;
boolean mustScanForPathSeparator = true ;
try
{
file . setTimestamp ( super . parseTimestamp ( datestr ) ) ;
}
catch ( final ParseException e )
{
}
if ( typeStr . equalsIgnoreCase ( lr_3 ) )
{
type = FTPFile . FILE_TYPE ;
if ( isNullOrEmpty ( filesize ) || isNullOrEmpty ( name ) )
{
return null ;
}
}
else if ( typeStr . equalsIgnoreCase ( lr_4 ) )
{
type = FTPFile . DIRECTORY_TYPE ;
if ( isNullOrEmpty ( filesize ) || isNullOrEmpty ( name ) )
{
return null ;
}
}
else if ( typeStr . equalsIgnoreCase ( lr_5 ) )
{
if ( name != null && name . toUpperCase ( Locale . ROOT ) . endsWith ( lr_6 ) )
{
mustScanForPathSeparator = false ;
type = FTPFile . FILE_TYPE ;
}
else
{
return null ;
}
}
else if ( typeStr . equalsIgnoreCase ( lr_7 ) )
{
mustScanForPathSeparator = false ;
type = FTPFile . FILE_TYPE ;
if ( isNullOrEmpty ( name ) )
{
return null ;
}
if ( ! ( isNullOrEmpty ( filesize ) && isNullOrEmpty ( datestr ) ) )
{
return null ;
}
name = name . replace ( '/' , File . separatorChar ) ;
}
else
{
type = FTPFile . UNKNOWN_TYPE ;
}
file . setType ( type ) ;
file . setUser ( usr ) ;
try
{
file . setSize ( Long . parseLong ( filesize ) ) ;
}
catch ( final NumberFormatException e )
{
}
if ( name . endsWith ( lr_8 ) )
{
name = name . substring ( 0 , name . length () - 1 ) ;
}
if ( mustScanForPathSeparator )
{
final int pos = name . lastIndexOf ( '/' ) ;
if ( pos > - 1 )
{
name = name . substring ( pos + 1 ) ;
}
}
file . setName ( name ) ;
return file ;
}
return null ;
}
private boolean isNullOrEmpty ( final String string ) {
if ( string == null || string . length () == 0 ) {
return true ;
}
return false ;
}
@Override
protected FTPClientConfig getDefaultConfiguration () {
return new FTPClientConfig (
FTPClientConfig . SYST_OS400 ,
DEFAULT_DATE_FORMAT ,
null ) ;
}
