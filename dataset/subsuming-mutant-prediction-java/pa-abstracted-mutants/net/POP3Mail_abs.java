public static void printMessageInfo ( final BufferedReader reader , final int id ) throws IOException {
String from = lr_1 ;
String subject = lr_1 ;
String line ;
while ( ( line = reader . readLine () ) != null )
{
final String lower = line . toLowerCase ( Locale . ENGLISH ) ;
if ( lower . startsWith ( lr_2 ) ) {
from = line . substring ( 6 ) . trim () ;
} else if ( lower . startsWith ( lr_3 ) ) {
subject = line . substring ( 9 ) . trim () ;
}
}
System . out . println ( Integer . toString ( id ) + lr_4 + from + lr_5 + subject ) ;
}
public static void main ( final String [] args )
{
if ( args . length < 3 )
{
System . err . println (
lr_6 ) ;
System . exit ( 1 ) ;
}
final String arg0 [] = args [ 0 ] . split ( lr_7 ) ;
final String server = arg0 [ 0 ] ;
final String username = args [ 1 ] ;
String password = args [ 2 ] ;
try {
password = Utils . getPassword ( username , password ) ;
} catch ( final IOException e1 ) {
System . err . println ( lr_8 + e1 . getMessage () ) ;
return;
}
final String proto = args . length > 3 ? args [ 3 ] : null ;
final boolean implicit = args . length > 4 ? Boolean . parseBoolean ( args [ 4 ] ) : false ;
POP3Client pop3 ;
if ( proto != null ) {
System . out . println ( lr_9 + proto ) ;
pop3 = new POP3SClient ( proto , implicit ) ;
} else {
pop3 = new POP3Client () ;
}
int port ;
if ( arg0 . length == 2 ) {
port = Integer . parseInt ( arg0 [ 1 ] ) ;
} else {
port = pop3 . getDefaultPort () ;
}
System . out . println ( lr_10 + server + lr_11 + port ) ;
pop3 . setDefaultTimeout ( 60000 ) ;
pop3 . addProtocolCommandListener ( new PrintCommandListener ( new PrintWriter ( System . out ) , true ) ) ;
try
{
pop3 . connect ( server ) ;
}
catch ( final IOException e )
{
System . err . println ( lr_12 ) ;
e . printStackTrace () ;
return;
}
try
{
if ( ! pop3 . login ( username , password ) )
{
System . err . println ( lr_13 ) ;
pop3 . disconnect () ;
return;
}
final POP3MessageInfo status = pop3 . status () ;
if ( status == null ) {
System . err . println ( lr_14 ) ;
pop3 . logout () ;
pop3 . disconnect () ;
return;
}
System . out . println ( lr_15 + status ) ;
final POP3MessageInfo [] messages = pop3 . listMessages () ;
if ( messages == null )
{
System . err . println ( lr_16 ) ;
pop3 . logout () ;
pop3 . disconnect () ;
return;
}
else if ( messages . length == 0 )
{
System . out . println ( lr_17 ) ;
pop3 . logout () ;
pop3 . disconnect () ;
return;
}
System . out . println ( lr_18 + messages . length ) ;
for ( final POP3MessageInfo msginfo : messages ) {
final BufferedReader reader = ( BufferedReader ) pop3 . retrieveMessageTop ( msginfo . number , 0 ) ;
if ( reader == null ) {
System . err . println ( lr_19 ) ;
pop3 . logout () ;
pop3 . disconnect () ;
return;
}
printMessageInfo ( reader , msginfo . number ) ;
}
pop3 . logout () ;
pop3 . disconnect () ;
}
catch ( final IOException e )
{
e . printStackTrace () ;
return;
}
}
