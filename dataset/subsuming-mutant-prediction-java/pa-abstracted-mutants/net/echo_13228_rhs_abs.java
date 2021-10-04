public static void echoTCP ( final String host ) throws IOException
{
final EchoTCPClient client = new EchoTCPClient () ;
BufferedReader input , echoInput ;
PrintWriter echoOutput ;
String line ;
client . setDefaultTimeout ( 60000 ) ;
client . connect ( host ) ;
System . out . println ( lr_1 + host + lr_2 ) ;
input = new BufferedReader ( new InputStreamReader ( System . in ) ) ;
echoOutput =
new PrintWriter ( new OutputStreamWriter ( client . getOutputStream () ) , true ) ;
echoInput =
new BufferedReader ( new InputStreamReader ( client . getInputStream () ) ) ;
while ( ( line = input . readLine () ) != null )
{
echoOutput . println ( line ) ;
System . out . println ( echoInput . readLine () ) ;
}
echoOutput . close () ;
echoInput . close () ;
echoInput . close () ;
client . disconnect () ;
}
public static void echoUDP ( final String host ) throws IOException
{
int length , count ;
byte [] data ;
String line ;
BufferedReader input ;
InetAddress address ;
EchoUDPClient client ;
input = new BufferedReader ( new InputStreamReader ( System . in ) ) ;
address = InetAddress . getByName ( host ) ;
client = new EchoUDPClient () ;
client . open () ;
client . setSoTimeout ( 5000 ) ;
System . out . println ( lr_3 + host + lr_2 ) ;
while ( ( line = input . readLine () ) != null )
{
data = line . getBytes () ;
client . send ( data , address ) ;
count = 0 ;
do
{
try
{
length = client . receive ( data ) ;
}
catch ( final SocketException e )
{
System . err . println (
lr_4 ) ;
break;
}
catch ( final InterruptedIOException e )
{
System . err . println (
lr_5 ) ;
break;
}
System . out . print ( new String ( data , 0 , length ) ) ;
count += length ;
}
while ( count < data . length );
System . out . println () ;
}
client . close () ;
}
public static void main ( final String [] args )
{
if ( args . length == 1 )
{
try
{
echoTCP ( args [ 0 ] ) ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
} MST[rv.ROR2Mutator]MSP[S]
else if ( args . length == 2 && args [ 0 ] . equals ( lr_6 ) )
{
try
{
echoUDP ( args [ 1 ] ) ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}
else
{
System . err . println ( lr_7 ) ;
System . exit ( 1 ) ;
}
}
