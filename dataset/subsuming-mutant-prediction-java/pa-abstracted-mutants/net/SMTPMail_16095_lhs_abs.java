public static void main ( final String [] args )
{
String sender , recipient , subject , fileName , server , cc ;
final List < String > ccList = new ArrayList <> () ;
BufferedReader stdin ;
FileReader fileReader = null ;
Writer writer ;
SimpleSMTPHeader header ;
SMTPClient client ;
if ( args . length < 1 )
{ MST[rv.ROR4Mutator]MSP[]
System . err . println ( lr_1 ) ;
System . exit ( 1 ) ;
}
server = args [ 0 ] ;
stdin = new BufferedReader ( new InputStreamReader ( System . in ) ) ;
try
{
System . out . print ( lr_2 ) ;
System . out . flush () ;
sender = stdin . readLine () ;
System . out . print ( lr_3 ) ;
System . out . flush () ;
recipient = stdin . readLine () ;
System . out . print ( lr_4 ) ;
System . out . flush () ;
subject = stdin . readLine () ;
header = new SimpleSMTPHeader ( sender , recipient , subject ) ;
while ( true )
{
System . out . print ( lr_5 ) ;
System . out . flush () ;
cc = stdin . readLine () ;
if ( cc == null || cc . length () == 0 ) {
break;
}
header . addCC ( cc . trim () ) ;
ccList . add ( cc . trim () ) ;
}
System . out . print ( lr_6 ) ;
System . out . flush () ;
fileName = stdin . readLine () ;
try
{
fileReader = new FileReader ( fileName ) ;
}
catch ( final FileNotFoundException e )
{
System . err . println ( lr_7 + e . getMessage () ) ;
}
client = new SMTPClient () ;
client . addProtocolCommandListener ( new PrintCommandListener (
new PrintWriter ( System . out ) , true ) ) ;
client . connect ( server ) ;
if ( ! SMTPReply . isPositiveCompletion ( client . getReplyCode () ) )
{
client . disconnect () ;
System . err . println ( lr_8 ) ;
System . exit ( 1 ) ;
}
client . login () ;
client . setSender ( sender ) ;
client . addRecipient ( recipient ) ;
for ( final String recpt : ccList ) {
client . addRecipient ( recpt ) ;
}
writer = client . sendMessageData () ;
if ( writer != null )
{
writer . write ( header . toString () ) ;
Util . copyReader ( fileReader , writer ) ;
writer . close () ;
client . completePendingCommand () ;
}
if ( fileReader != null ) {
fileReader . close () ;
}
client . logout () ;
client . disconnect () ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
System . exit ( 1 ) ;
}
}
