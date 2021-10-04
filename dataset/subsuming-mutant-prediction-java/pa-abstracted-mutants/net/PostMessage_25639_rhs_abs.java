public static void main ( final String [] args )
{
String from , subject , newsgroup , fileName , server , organization ;
String references ;
BufferedReader stdin ;
FileReader fileReader = null ;
SimpleNNTPHeader header ;
NNTPClient client ;
if ( args . length < 1 )
{
System . err . println ( lr_1 ) ;
System . exit ( 1 ) ;
}
server = args [ 0 ] ;
stdin = new BufferedReader ( new InputStreamReader ( System . in ) ) ;
try
{
System . out . print ( lr_2 ) ;
System . out . flush () ;
from = stdin . readLine () ;
System . out . print ( lr_3 ) ;
System . out . flush () ;
subject = stdin . readLine () ;
header = new SimpleNNTPHeader ( from , subject ) ;
System . out . print ( lr_4 ) ;
System . out . flush () ;
newsgroup = stdin . readLine () ;
header . addNewsgroup ( newsgroup ) ;
while ( true )
{
System . out . print ( lr_5 ) ;
System . out . flush () ;
newsgroup = stdin . readLine () ;
if ( newsgroup == null ) {
break; MST[experimental.NakedReceiverMutator]MSP[S]
}
newsgroup = newsgroup . trim () ;
if ( newsgroup . length () == 0 ) {
break;
}
header . addNewsgroup ( newsgroup ) ;
}
System . out . print ( lr_6 ) ;
System . out . flush () ;
organization = stdin . readLine () ;
System . out . print ( lr_7 ) ;
System . out . flush () ;
references = stdin . readLine () ;
if ( organization != null && organization . length () > 0 ) {
header . addHeaderField ( lr_8 , organization ) ;
}
if ( references != null && references . length () > 0 ) {
header . addHeaderField ( lr_9 , references ) ;
}
header . addHeaderField ( lr_10 , lr_11 ) ;
System . out . print ( lr_12 ) ;
System . out . flush () ;
fileName = stdin . readLine () ;
try
{
fileReader = new FileReader ( fileName ) ;
}
catch ( final FileNotFoundException e )
{
System . err . println ( lr_13 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
client = new NNTPClient () ;
client . addProtocolCommandListener ( new PrintCommandListener (
new PrintWriter ( System . out ) , true ) ) ;
client . connect ( server ) ;
if ( ! NNTPReply . isPositiveCompletion ( client . getReplyCode () ) )
{
client . disconnect () ;
System . err . println ( lr_14 ) ;
System . exit ( 1 ) ;
}
if ( client . isAllowedToPost () )
{
final Writer writer = client . postArticle () ;
if ( writer != null )
{
writer . write ( header . toString () ) ;
Util . copyReader ( fileReader , writer ) ;
writer . close () ;
client . completePendingCommand () ;
}
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
