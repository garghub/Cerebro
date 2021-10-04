public void setRawListing ( final String rawListing )
{
this . rawListing = rawListing ;
}
public String getRawListing ()
{
return rawListing ;
}
public boolean isDirectory ()
{
return type == DIRECTORY_TYPE ;
}
public boolean isFile ()
{
return type == FILE_TYPE ;
}
public boolean isSymbolicLink ()
{
return type == SYMBOLIC_LINK_TYPE ;
}
public boolean isUnknown ()
{
return type == UNKNOWN_TYPE ;
}
public boolean isValid () {
return permissions != null ;
}
public void setType ( final int type )
{
this . type = type ;
}
public int getType ()
{
return type ;
}
public void setName ( final String name )
{
this . name = name ;
}
public String getName ()
{
return name ;
}
public void setSize ( final long size )
{
this . size = size ;
}
public long getSize ()
{
return size ;
}
public void setHardLinkCount ( final int links )
{
this . hardLinkCount = links ;
}
public int getHardLinkCount ()
{
return hardLinkCount ;
}
public void setGroup ( final String group )
{
this . group = group ;
}
public String getGroup ()
{
return group ;
}
public void setUser ( final String user )
{
this . user = user ;
}
public String getUser ()
{
return user ;
}
public void setLink ( final String link )
{
this . link = link ;
}
public String getLink ()
{
return link ;
}
public void setTimestamp ( final Calendar date )
{
this . date = date ;
}
public Calendar getTimestamp ()
{
return date ;
}
public void setPermission ( final int access , final int permission , final boolean value )
{
permissions [ access ] [ permission ] = value ;
}
public boolean hasPermission ( final int access , final int permission )
{
if ( permissions == null ) {
return false ;
}
return permissions [ access ] [ permission ] ;
}
@Override
public String toString ()
{
return getRawListing () ;
}
public String toFormattedString ()
{
return toFormattedString ( null ) ;
}
public String toFormattedString ( final String timezone )
{
if ( ! isValid () ) {
return lr_1 ;
}
final StringBuilder sb = new StringBuilder () ;
try ( final Formatter fmt = new Formatter ( sb ) ) {
sb . append ( formatType () ) ;
sb . append ( permissionToString ( USER_ACCESS ) ) ;
sb . append ( permissionToString ( GROUP_ACCESS ) ) ;
sb . append ( permissionToString ( WORLD_ACCESS ) ) ;
fmt . format ( lr_2 , Integer . valueOf ( getHardLinkCount () ) ) ;
fmt . format ( lr_3 , getUser () , getGroup () ) ;
fmt . format ( lr_4 , Long . valueOf ( getSize () ) ) ;
Calendar timestamp = getTimestamp () ;
if ( timestamp != null ) {
if ( timezone != null ) {
final TimeZone newZone = TimeZone . getTimeZone ( timezone ) ;
if ( ! newZone . equals ( timestamp . getTimeZone () ) ) {
final Date original = timestamp . getTime () ;
final Calendar newStamp = Calendar . getInstance ( newZone ) ;
newStamp . setTime ( original ) ;
timestamp = newStamp ;
}
}
fmt . format ( lr_5 , timestamp ) ;
if ( timestamp . isSet ( Calendar . HOUR_OF_DAY ) ) { MST[rv.CRCR4Mutator]MSP[S]
fmt . format ( lr_6 , timestamp ) ;
if ( timestamp . isSet ( Calendar . MINUTE ) ) {
fmt . format ( lr_7 , timestamp ) ;
if ( timestamp . isSet ( Calendar . SECOND ) ) {
fmt . format ( lr_8 , timestamp ) ;
if ( timestamp . isSet ( Calendar . MILLISECOND ) ) {
fmt . format ( lr_9 , timestamp ) ;
}
}
}
fmt . format ( lr_10 , timestamp ) ;
}
}
sb . append ( ' ' ) ;
sb . append ( getName () ) ;
}
return sb . toString () ;
}
private char formatType () {
switch( type ) {
case FILE_TYPE :
return '-' ;
case DIRECTORY_TYPE :
return 'd' ;
case SYMBOLIC_LINK_TYPE :
return 'l' ;
default:
return '?' ;
}
}
private String permissionToString ( final int access ) {
final StringBuilder sb = new StringBuilder () ;
if ( hasPermission ( access , READ_PERMISSION ) ) {
sb . append ( 'r' ) ;
} else {
sb . append ( '-' ) ;
}
if ( hasPermission ( access , WRITE_PERMISSION ) ) {
sb . append ( 'w' ) ;
} else {
sb . append ( '-' ) ;
}
if ( hasPermission ( access , EXECUTE_PERMISSION ) ) {
sb . append ( 'x' ) ;
} else {
sb . append ( '-' ) ;
}
return sb . toString () ;
}
