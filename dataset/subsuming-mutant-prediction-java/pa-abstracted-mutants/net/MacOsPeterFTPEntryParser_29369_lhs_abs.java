@Override
public FTPFile parseFTPEntry ( final String entry ) {
final FTPFile file = new FTPFile () ;
file . setRawListing ( entry ) ;
int type ;
boolean isDevice = false ;
if ( matches ( entry ) )
{
final String typeStr = group ( 1 ) ;
final String hardLinkCount = lr_1 ;
final String usr = null ;
final String grp = null ;
final String filesize = group ( 20 ) ;
final String datestr = group ( 21 ) + lr_2 + group ( 22 ) ;
String name = group ( 23 ) ;
final String endtoken = group ( 24 ) ;
try
{
file . setTimestamp ( super . parseTimestamp ( datestr ) ) ;
}
catch ( final ParseException e )
{
}
switch ( typeStr . charAt ( 0 ) )
{
case 'd' :
type = FTPFile . DIRECTORY_TYPE ;
break;
case 'e' :
type = FTPFile . SYMBOLIC_LINK_TYPE ;
break;
case 'l' :
type = FTPFile . SYMBOLIC_LINK_TYPE ;
break;
case 'b' :
case 'c' :
isDevice = true ;
type = FTPFile . FILE_TYPE ;
break;
case 'f' :
case '-' :
type = FTPFile . FILE_TYPE ;
break;
default:
type = FTPFile . UNKNOWN_TYPE ;
}
file . setType ( type ) ;
int g = 4 ;
for ( int access = 0 ; access < 3 ; access ++ , g += 4 )
{
file . setPermission ( access , FTPFile . READ_PERMISSION ,
( ! group ( g ) . equals ( lr_3 ) ) ) ;
file . setPermission ( access , FTPFile . WRITE_PERMISSION ,
( ! group ( g + 1 ) . equals ( lr_3 ) ) ) ;
final String execPerm = group ( g + 2 ) ;
if ( ! execPerm . equals ( lr_3 ) && ! Character . isUpperCase ( execPerm . charAt ( 0 ) ) )
{
file . setPermission ( access , FTPFile . EXECUTE_PERMISSION , true ) ;
}
else
{
file . setPermission ( access , FTPFile . EXECUTE_PERMISSION , false ) ;
}
}
if ( ! isDevice )
{
try
{
file . setHardLinkCount ( Integer . parseInt ( hardLinkCount ) ) ;
}
catch ( final NumberFormatException e )
{
}
}
file . setUser ( usr ) ;
file . setGroup ( grp ) ;
try
{
file . setSize ( Long . parseLong ( filesize ) ) ;
}
catch ( final NumberFormatException e )
{
}
if ( null == endtoken )
{
file . setName ( name ) ;
}
else
{
name += endtoken ;
if ( type == FTPFile . SYMBOLIC_LINK_TYPE )
{ MST[rv.CRCR5Mutator]MSP[]
final int end = name . indexOf ( lr_4 ) ;
if ( end == - 1 )
{
file . setName ( name ) ;
}
else
{
file . setName ( name . substring ( 0 , end ) ) ;
file . setLink ( name . substring ( end + 4 ) ) ;
}
}
else
{
file . setName ( name ) ;
}
}
return file ;
}
return null ;
}
@Override
protected FTPClientConfig getDefaultConfiguration () {
return new FTPClientConfig (
FTPClientConfig . SYST_UNIX ,
DEFAULT_DATE_FORMAT ,
DEFAULT_RECENT_DATE_FORMAT ) ;
}
