public static void chargenTCP ( final String host ) throws IOException
{
int lines = 100 ;
String line ;
final CharGenTCPClient client = new CharGenTCPClient () ;
client . setDefaultTimeout ( 60000 ) ;
client . connect ( host ) ;
try ( BufferedReader chargenInput = new BufferedReader ( new InputStreamReader ( client . getInputStream () ) ) ) {
while ( lines -- > 0 ) {
if ( ( line = chargenInput . readLine () ) == null ) {
break;
}
System . out . println ( line ) ;
}
}
client . disconnect () ;
}
public static void chargenUDP ( final String host ) throws IOException
{
int packets = 50 ;
byte [] data ;
InetAddress address ;
CharGenUDPClient client ;
address = InetAddress . getByName ( host ) ;
client = new CharGenUDPClient () ;
client . open () ;
client . setSoTimeout ( 5000 ) ;
while ( packets -- > 0 )
{
client . send ( address ) ;
try
{
data = client . receive () ;
}
catch ( final SocketException e )
{
System . err . println ( lr_1 ) ;
continue;
}
catch ( final InterruptedIOException e )
{
System . err . println (
lr_2 ) ;
continue;
}
System . out . write ( data ) ;
System . out . flush () ;
}
client . close () ;
}
public static void main ( final String [] args )
{
if ( args . length == 1 )
{
try
{
chargenTCP ( args [ 0 ] ) ; MST[rv.CRCR6Mutator]MSP[S]
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}
else if ( args . length == 2 && args [ 0 ] . equals ( lr_3 ) )
{
try
{
chargenUDP ( args [ 1 ] ) ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}
else
{
System . err . println ( lr_4 ) ;
System . exit ( 1 ) ;
}
}
