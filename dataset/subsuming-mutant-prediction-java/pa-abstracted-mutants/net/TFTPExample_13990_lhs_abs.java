@Override MST[NegateConditionalsMutator]MSP[]
protected void trace ( final String direction , final TFTPPacket packet ) {
System . out . println ( direction + lr_1 + packet ) ;
}
private static boolean send ( final int transferMode , final String hostname , final String localFilename ,
final String remoteFilename , final TFTPClient tftp ) {
boolean closed ;
FileInputStream input = null ;
try
{
input = new FileInputStream ( localFilename ) ;
}
catch ( final IOException e )
{
tftp . close () ;
throw new RuntimeException ( lr_2 , e ) ;
}
open ( tftp ) ;
try
{
final String [] parts = hostname . split ( lr_3 ) ;
if ( parts . length == 2 ) {
tftp . sendFile ( remoteFilename , transferMode , input , parts [ 0 ] , Integer . parseInt ( parts [ 1 ] ) ) ;
} else {
tftp . sendFile ( remoteFilename , transferMode , input , hostname ) ;
}
}
catch ( final UnknownHostException e )
{
System . err . println ( lr_4 ) ;
System . err . println ( e . getMessage () ) ;
System . exit ( 1 ) ;
}
catch ( final IOException e )
{
System . err . println ( lr_5 ) ;
System . err . println ( e . getMessage () ) ;
System . exit ( 1 ) ;
}
finally
{
closed = close ( tftp , input ) ;
}
return closed ;
}
private static boolean receive ( final int transferMode , final String hostname , final String localFilename ,
final String remoteFilename , final TFTPClient tftp ) {
boolean closed ;
FileOutputStream output = null ;
File file ;
file = new File ( localFilename ) ;
if ( file . exists () )
{
System . err . println ( lr_6 + localFilename + lr_7 ) ;
return false ;
}
try
{
output = new FileOutputStream ( file ) ;
}
catch ( final IOException e )
{
tftp . close () ;
throw new RuntimeException ( lr_8 , e ) ;
}
open ( tftp ) ;
try
{
final String [] parts = hostname . split ( lr_3 ) ;
if ( parts . length == 2 ) {
tftp . receiveFile ( remoteFilename , transferMode , output , parts [ 0 ] , Integer . parseInt ( parts [ 1 ] ) ) ;
} else {
tftp . receiveFile ( remoteFilename , transferMode , output , hostname ) ;
}
}
catch ( final UnknownHostException e )
{
System . err . println ( lr_4 ) ;
System . err . println ( e . getMessage () ) ;
System . exit ( 1 ) ;
}
catch ( final IOException e )
{
System . err . println (
lr_9 ) ;
System . err . println ( e . getMessage () ) ;
System . exit ( 1 ) ;
}
finally
{
closed = close ( tftp , output ) ;
}
return closed ;
}
private static boolean close ( final TFTPClient tftp , final Closeable output ) {
boolean closed ;
tftp . close () ;
try
{
if ( output != null ) {
output . close () ;
}
closed = true ;
}
catch ( final IOException e )
{
closed = false ;
System . err . println ( lr_10 ) ;
System . err . println ( e . getMessage () ) ;
}
return closed ;
}
private static void open ( final TFTPClient tftp ) {
try
{
tftp . open () ;
}
catch ( final SocketException e )
{
throw new RuntimeException ( lr_11 , e ) ;
}
}
