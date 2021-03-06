public static void main ( final String [] args )
{
int argIdx ;
String file = null ;
for( argIdx = 0 ; argIdx < args . length ; argIdx ++ ) {
if ( args [ argIdx ] . equals ( lr_1 ) ) {
file = args [ ++ argIdx ] ;
} else {
break;
}
}
final int argCount = args . length - argIdx ;
if ( argCount < 3 )
{
System . err . println (
lr_2 ) ;
System . exit ( 1 ) ;
}
final String arg0 [] = args [ argIdx ++ ] . split ( lr_3 ) ;
final String server = arg0 [ 0 ] ;
final String username = args [ argIdx ++ ] ;
String password = args [ argIdx ++ ] ;
try {
password = Utils . getPassword ( username , password ) ;
} catch ( final IOException e1 ) {
System . err . println ( lr_4 + e1 . getMessage () ) ;
return;
}
final String proto = argCount > 3 ? args [ argIdx ++ ] : null ;
final boolean implicit = argCount > 4 ? Boolean . parseBoolean ( args [ argIdx ++ ] ) : false ;
POP3Client pop3 ;
if ( proto != null ) {
System . out . println ( lr_5 + proto ) ;
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
System . out . println ( lr_6 + server + lr_7 + port ) ;
pop3 . setDefaultTimeout ( 60000 ) ;
try
{
pop3 . connect ( server ) ;
}
catch ( final IOException e )
{
System . err . println ( lr_8 ) ;
e . printStackTrace () ;
return;
}
try
{
if ( ! pop3 . login ( username , password ) )
{
System . err . println ( lr_9 ) ;
pop3 . disconnect () ;
return;
}
final POP3MessageInfo status = pop3 . status () ;
if ( status == null ) {
System . err . println ( lr_10 ) ;
pop3 . logout () ;
pop3 . disconnect () ;
return;
}
System . out . println ( lr_11 + status ) ;
final int count = status . number ;
if ( file != null ) {
System . out . println ( lr_12 + count ) ;
final File mbox = new File ( file ) ;
if ( mbox . isDirectory () ) {
System . out . println ( lr_13 + mbox ) ;
for ( int i = 1 ; i <= count ; i ++ ) {
try ( final OutputStreamWriter fw = new OutputStreamWriter (
new FileOutputStream ( new File ( mbox , i + lr_14 ) ) , StandardCharsets . ISO_8859_1 ) ) {
writeFile ( pop3 , fw , i ) ;
}
}
} else {
System . out . println ( lr_15 + mbox ) ;
try ( final OutputStreamWriter fw = new OutputStreamWriter ( new FileOutputStream ( mbox ) ,
StandardCharsets . ISO_8859_1 ) ) {
for ( int i = 1 ; i <= count ; i ++ ) {
writeMbox ( pop3 , fw , i ) ;
}
}
}
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
private static void writeFile ( final POP3Client pop3 , final OutputStreamWriter fw , final int i ) throws IOException {
try ( final BufferedReader r = ( BufferedReader ) pop3 . retrieveMessage ( i ) ) {
String line ;
while ( ( line = r . readLine () ) != null ) {
fw . write ( line ) ;
fw . write ( lr_16 ) ;
}
}
}
private static void writeMbox ( final POP3Client pop3 , final OutputStreamWriter fw , final int i ) throws IOException {
final SimpleDateFormat DATE_FORMAT
= new SimpleDateFormat ( lr_17 ) ;
final String replyTo = lr_18 ;
final Date received = new Date () ;
try ( final BufferedReader r = ( BufferedReader ) pop3 . retrieveMessage ( i ) ) {
fw . append ( lr_19 ) ;
fw . append ( replyTo ) ;
fw . append ( ' ' ) ;
fw . append ( DATE_FORMAT . format ( received ) ) ;
fw . append ( lr_16 ) ;
String line ;
while ( ( line = r . readLine () ) != null ) {
if ( startsWith ( line , PATFROM ) ) {
fw . write ( lr_20 ) ;
}
fw . write ( line ) ;
fw . write ( lr_16 ) ;
}
fw . write ( lr_16 ) ;
}
}
private static boolean startsWith ( final String input , final Pattern pat ) {
final Matcher m = pat . matcher ( input ) ;
return m . lookingAt () ;
}
