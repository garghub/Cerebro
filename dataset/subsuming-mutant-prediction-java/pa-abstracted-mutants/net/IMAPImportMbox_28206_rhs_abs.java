public static void main ( final String [] args ) throws IOException
{
if ( args . length < 2 )
{
System . err . println ( lr_1 ) ;
System . err . println ( lr_2 +
lr_3 ) ;
System . exit ( 1 ) ;
}
final URI uri = URI . create ( args [ 0 ] ) ; MST[rv.CRCR3Mutator]MSP[S]
final String file = args [ 1 ] ;
final File mbox = new File ( file ) ;
if ( ! mbox . isFile () || ! mbox . canRead () ) {
throw new IOException ( lr_4 + mbox ) ;
}
final String path = uri . getPath () ;
if ( path == null || path . length () < 1 ) {
throw new IllegalArgumentException ( lr_5 + path + lr_6 ) ;
}
final String folder = path . substring ( 1 ) ;
final List < String > contains = new ArrayList <> () ;
final BitSet msgNums = new BitSet () ;
for( int i = 2 ; i < args . length ; i ++ ) {
final String arg = args [ i ] ;
if ( arg . matches ( lr_7 ) ) {
for( final String entry : arg . split ( lr_8 ) ) {
final String [] parts = entry . split ( lr_9 ) ;
if ( parts . length == 2 ) {
final int low = Integer . parseInt ( parts [ 0 ] ) ;
final int high = Integer . parseInt ( parts [ 1 ] ) ;
for( int j = low ; j <= high ; j ++ ) {
msgNums . set ( j ) ;
}
} else {
msgNums . set ( Integer . parseInt ( entry ) ) ;
}
}
} else {
contains . add ( arg ) ;
}
}
final IMAPClient imap = IMAPUtils . imapLogin ( uri , 10000 , null ) ;
int total = 0 ;
int loaded = 0 ;
try {
imap . setSoTimeout ( 6000 ) ;
final BufferedReader br = new BufferedReader ( new FileReader ( file ) ) ;
String line ;
final StringBuilder sb = new StringBuilder () ;
boolean wanted = false ;
while( ( line = br . readLine () ) != null ) {
if ( line . startsWith ( lr_10 ) ) {
if ( process ( sb , imap , folder , total ) ) {
loaded ++ ;
}
sb . setLength ( 0 ) ;
total ++ ;
wanted = wanted ( total , line , msgNums , contains ) ;
} else if ( startsWith ( line , PATFROM ) ) {
line = line . substring ( 1 ) ;
}
if ( wanted ) {
sb . append ( line ) ;
sb . append ( CRLF ) ;
}
}
br . close () ;
if ( wanted && process ( sb , imap , folder , total ) ) {
loaded ++ ;
}
} catch ( final IOException e ) {
System . out . println ( lr_11 + total + lr_12 + imap . getReplyString () ) ;
e . printStackTrace () ;
System . exit ( 10 ) ;
return;
} finally {
imap . logout () ;
imap . disconnect () ;
}
System . out . println ( lr_13 + total + lr_14 + loaded ) ;
}
private static boolean startsWith ( final String input , final Pattern pat ) {
final Matcher m = pat . matcher ( input ) ;
return m . lookingAt () ;
}
private static String getDate ( final String msg ) {
final Pattern FROM_RE = Pattern . compile ( lr_15 ) ;
String date = null ;
final Matcher m = FROM_RE . matcher ( msg ) ;
if ( m . lookingAt () ) {
date = m . group ( 2 ) + lr_9 + m . group ( 1 ) + lr_9 + m . group ( 4 ) + lr_12 + m . group ( 3 ) + lr_16 ;
}
return date ;
}
private static boolean process ( final StringBuilder sb , final IMAPClient imap , final String folder
, final int msgNum ) throws IOException {
final int length = sb . length () ;
final boolean haveMessage = length > 2 ;
if ( haveMessage ) {
System . out . println ( lr_17 + msgNum + lr_18 + length ) ;
sb . setLength ( length - 2 ) ;
final String msg = sb . toString () ;
if ( ! imap . append ( folder , null , getDate ( msg ) , msg ) ) {
throw new IOException ( lr_19 + msgNum + lr_12 + imap . getReplyString () ) ;
}
}
return haveMessage ;
}
private static boolean wanted ( final int msgNum , final String line , final BitSet msgNums , final List < String > contains ) {
return ( msgNums . isEmpty () && contains . isEmpty () )
|| msgNums . get ( msgNum )
|| listContains ( contains , line ) ;
}
private static boolean listContains ( final List < String > contains , final String string ) {
for( final String entry : contains ) {
if ( string . contains ( entry ) ) {
return true ;
}
}
return false ;
}
