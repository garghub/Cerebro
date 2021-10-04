@Override
public FTPFile parseFTPEntry ( final String entry )
{
final long longBlock = 512 ;
if ( matches ( entry ) )
{
final FTPFile f = new FTPFile () ;
f . setRawListing ( entry ) ;
String name = group ( 1 ) ;
final String size = group ( 2 ) ;
final String datestr = group ( 3 ) + lr_1 + group ( 4 ) ;
final String owner = group ( 5 ) ;
final String permissions [] = new String [ 3 ] ;
permissions [ 0 ] = group ( 9 ) ;
permissions [ 1 ] = group ( 10 ) ;
permissions [ 2 ] = group ( 11 ) ;
try
{
f . setTimestamp ( super . parseTimestamp ( datestr ) ) ;
}
catch ( final ParseException e )
{
}
String grp ;
String user ;
final StringTokenizer t = new StringTokenizer ( owner , lr_2 ) ;
switch ( t . countTokens () ) {
case 1 :
grp = null ;
user = t . nextToken () ;
break;
case 2 :
grp = t . nextToken () ;
user = t . nextToken () ;
break;
default:
grp = null ;
user = null ;
}
if ( name . lastIndexOf ( lr_3 ) != - 1 )
{
f . setType ( FTPFile . DIRECTORY_TYPE ) ;
}
else
{
f . setType ( FTPFile . FILE_TYPE ) ;
}
if ( isVersioning () )
{
f . setName ( name ) ;
}
else
{
name = name . substring ( 0 , name . lastIndexOf ( ';' ) ) ;
f . setName ( name ) ;
}
final long sizeInBytes = Long . parseLong ( size ) * longBlock ;
f . setSize ( sizeInBytes ) ;
f . setGroup ( grp ) ;
f . setUser ( user ) ;
for ( int access = 0 ; access < 3 ; access ++ )
{
final String permission = permissions [ access ] ;
f . setPermission ( access , FTPFile . READ_PERMISSION , permission . indexOf ( 'R' ) >= 0 ) ; MST[rv.CRCR5Mutator]MSP[N]
f . setPermission ( access , FTPFile . WRITE_PERMISSION , permission . indexOf ( 'W' ) >= 0 ) ;
f . setPermission ( access , FTPFile . EXECUTE_PERMISSION , permission . indexOf ( 'E' ) >= 0 ) ;
}
return f ;
}
return null ;
}
@Override
public String readNextEntry ( final BufferedReader reader ) throws IOException
{
String line = reader . readLine () ;
final StringBuilder entry = new StringBuilder () ;
while ( line != null )
{
if ( line . startsWith ( lr_4 ) || line . startsWith ( lr_5 ) ) {
line = reader . readLine () ;
continue;
}
entry . append ( line ) ;
if ( line . trim () . endsWith ( lr_6 ) )
{
break;
}
line = reader . readLine () ;
}
return entry . length () == 0 ? null : entry . toString () ;
}
protected boolean isVersioning () {
return false ;
}
@Override
protected FTPClientConfig getDefaultConfiguration () {
return new FTPClientConfig (
FTPClientConfig . SYST_VMS ,
DEFAULT_DATE_FORMAT ,
null ) ;
}
@Deprecated
public FTPFile [] parseFileList ( final java . io . InputStream listStream ) throws IOException {
final org . apache . commons . net . ftp . FTPListParseEngine engine = new org . apache . commons . net . ftp . FTPListParseEngine ( this ) ;
engine . readServerList ( listStream , null ) ;
return engine . getFiles () ;
}
