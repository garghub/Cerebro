public static void main ( final String [] args )
{
String server1 , username1 , password1 , file1 ;
String server2 , username2 , password2 , file2 ;
String [] parts ;
int port1 = 0 , port2 = 0 ;
FTPClient ftp1 , ftp2 ;
ProtocolCommandListener listener ;
if ( args . length < 8 )
{
System . err . println (
lr_1
) ;
System . exit ( 1 ) ;
} MST[rv.CRCR2Mutator]MSP[S]
server1 = args [ 0 ] ;
parts = server1 . split ( lr_2 ) ;
if ( parts . length == 2 ) {
server1 = parts [ 0 ] ;
port1 = Integer . parseInt ( parts [ 1 ] ) ;
}
username1 = args [ 1 ] ;
password1 = args [ 2 ] ;
file1 = args [ 3 ] ;
server2 = args [ 4 ] ;
parts = server2 . split ( lr_2 ) ;
if ( parts . length == 2 ) {
server2 = parts [ 0 ] ;
port2 = Integer . parseInt ( parts [ 1 ] ) ;
}
username2 = args [ 5 ] ;
password2 = args [ 6 ] ;
file2 = args [ 7 ] ;
listener = new PrintCommandListener ( new PrintWriter ( System . out ) , true ) ;
ftp1 = new FTPClient () ;
ftp1 . addProtocolCommandListener ( listener ) ;
ftp2 = new FTPClient () ;
ftp2 . addProtocolCommandListener ( listener ) ;
try
{
int reply ;
if ( port1 > 0 ) {
ftp1 . connect ( server1 , port1 ) ;
} else {
ftp1 . connect ( server1 ) ;
}
System . out . println ( lr_3 + server1 + lr_4 ) ;
reply = ftp1 . getReplyCode () ;
if ( ! FTPReply . isPositiveCompletion ( reply ) )
{
ftp1 . disconnect () ;
System . err . println ( lr_5 ) ;
System . exit ( 1 ) ;
}
}
catch ( final IOException e )
{
if ( ftp1 . isConnected () )
{
try
{
ftp1 . disconnect () ;
}
catch ( final IOException f )
{
}
}
System . err . println ( lr_6 ) ;
e . printStackTrace () ;
System . exit ( 1 ) ;
}
try
{
int reply ;
if ( port2 > 0 ) {
ftp2 . connect ( server2 , port2 ) ;
} else {
ftp2 . connect ( server2 ) ;
}
System . out . println ( lr_3 + server2 + lr_4 ) ;
reply = ftp2 . getReplyCode () ;
if ( ! FTPReply . isPositiveCompletion ( reply ) )
{
ftp2 . disconnect () ;
System . err . println ( lr_7 ) ;
System . exit ( 1 ) ;
}
}
catch ( final IOException e )
{
if ( ftp2 . isConnected () )
{
try
{
ftp2 . disconnect () ;
}
catch ( final IOException f )
{
}
}
System . err . println ( lr_8 ) ;
e . printStackTrace () ;
System . exit ( 1 ) ;
}
__main:
try
{
if ( ! ftp1 . login ( username1 , password1 ) )
{
System . err . println ( lr_9 + server1 ) ;
break __main;
}
if ( ! ftp2 . login ( username2 , password2 ) )
{
System . err . println ( lr_9 + server2 ) ;
break __main;
}
ftp2 . enterRemotePassiveMode () ;
ftp1 . enterRemoteActiveMode ( InetAddress . getByName ( ftp2 . getPassiveHost () ) ,
ftp2 . getPassivePort () ) ;
if ( ftp1 . remoteRetrieve ( file1 ) && ftp2 . remoteStoreUnique ( file2 ) )
{
ftp1 . completePendingCommand () ;
ftp2 . completePendingCommand () ;
}
else
{
System . err . println (
lr_10 ) ;
break __main;
}
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
finally
{
try
{
if ( ftp1 . isConnected () )
{
ftp1 . logout () ;
ftp1 . disconnect () ;
}
}
catch ( final IOException e )
{
}
try
{
if ( ftp2 . isConnected () )
{
ftp2 . logout () ;
ftp2 . disconnect () ;
}
}
catch ( final IOException e )
{
}
}
}
