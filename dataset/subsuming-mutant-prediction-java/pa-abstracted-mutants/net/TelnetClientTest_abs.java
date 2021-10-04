protected void close () {
TelnetClientTest . this . closeConnection (
this . server , this . client , this . port ) ;
}
@Override
public int [] answerSubnegotiation ( final int [] suboptionData , final int suboptionLength )
{
lastSubnegotiation = suboptionData ;
lastSubnegotiationLength = suboptionLength ;
return null ;
}
@Override
protected void tearDown () throws Exception {
NOREAD . close () ;
ANSI . close () ;
OPTIONS . close () ;
STANDARD . close () ;
SMALL_BUFFER . close () ;
try {
Thread . sleep ( 1000 ) ;
} catch ( final InterruptedException ie ) {
}
super . tearDown () ;
}
void closeConnection ( final TelnetTestSimpleServer server , final TelnetClient client , final int port ) {
if ( server != null ) {
server . disconnect () ;
server . stop () ;
}
try {
if ( client != null ) {
client . disconnect () ;
}
} catch ( final IOException e ) {
System . err . println ( lr_1 + port ) ;
System . err . println ( lr_2 + e . getMessage () ) ;
}
}
public void testInitial () throws Exception
{
boolean connect1_ok = false ;
boolean connect2_ok = false ;
boolean connect3_ok = false ;
boolean init2_ok = false ;
boolean add_invalid_ok1 = false ;
boolean add_invalid_ok2 = false ;
final byte buffread2 [] = new byte [ 9 ] ;
final byte expected2 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL ,
( byte ) TelnetOption . ECHO ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
} ;
final SimpleOptionHandler hand = new SimpleOptionHandler ( 550 ) ;
try
{
STANDARD . client . addOptionHandler ( hand ) ;
}
catch ( final Exception e )
{
add_invalid_ok1 = true ;
}
try
{
OPTIONS . client . addOptionHandler ( hand ) ;
}
catch ( final Exception e )
{
add_invalid_ok2 = true ;
}
final InputStream is1 = STANDARD . server . getInputStream () ;
Thread . sleep ( 1000 ) ;
if( is1 . available () == 0 )
{
connect1_ok = true ;
}
Thread . sleep ( 1000 ) ;
final InputStream is2 = OPTIONS . server . getInputStream () ;
if( is2 . available () == 9 )
{
is2 . read ( buffread2 ) ;
connect2_ok = true ;
if ( equalBytes ( buffread2 , expected2 ) ) {
init2_ok = true ;
}
}
final InputStream is3 = ANSI . server . getInputStream () ;
Thread . sleep ( 1000 ) ;
if( is3 . available () == 0 )
{
connect3_ok = true ;
}
assertTrue ( connect1_ok ) ;
assertTrue ( connect2_ok ) ;
assertTrue ( connect3_ok ) ;
assertTrue ( ! STANDARD . client . getLocalOptionState ( TelnetOption . ECHO ) ) ;
assertTrue ( ! STANDARD . client . getRemoteOptionState ( TelnetOption . ECHO ) ) ;
assertTrue ( ! OPTIONS . client . getLocalOptionState ( TelnetOption . ECHO ) ) ;
assertTrue ( ! OPTIONS . client . getRemoteOptionState ( TelnetOption . ECHO ) ) ;
assertTrue ( ! ANSI . client . getLocalOptionState ( TelnetOption . TERMINAL_TYPE ) ) ;
assertTrue ( ! ANSI . client . getRemoteOptionState ( TelnetOption . TERMINAL_TYPE ) ) ;
assertTrue ( init2_ok ) ;
assertTrue ( add_invalid_ok1 ) ;
assertTrue ( add_invalid_ok2 ) ;
}
public void testOptionNegotiation () throws Exception
{
boolean negotiation1_ok = false ;
final byte buffread1 [] = new byte [ 6 ] ;
final byte send1 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO , ( byte ) 15 ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL , ( byte ) 15 ,
} ;
final byte expected1 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT , ( byte ) 15 ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT , ( byte ) 15 ,
} ;
boolean negotiation2_ok = false ;
final byte buffread2 [] = new byte [ 9 ] ;
final byte send2 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT ,
( byte ) TelnetOption . ECHO ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte expected2 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . ECHO ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte buffread2b [] = new byte [ 11 ] ;
final byte send2b [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SB ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) 1 , ( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SE ,
} ;
final byte expected2b [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SB ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) 0 , ( byte ) 'V' , ( byte ) 'T' , ( byte ) '1' , ( byte ) '0' ,
( byte ) '0' ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SE ,
} ;
boolean negotiation3_ok = false ;
final byte buffread3 [] = new byte [ 6 ] ;
final byte send3 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte expected3 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte buffread3b [] = new byte [ 10 ] ;
final byte send3b [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SB ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) 1 , ( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SE ,
} ;
final byte expected3b [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SB ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) 0 , ( byte ) 'A' , ( byte ) 'N' , ( byte ) 'S' , ( byte ) 'I' ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SE ,
} ;
final InputStream is1 = STANDARD . server . getInputStream () ;
final OutputStream os1 = STANDARD . server . getOutputStream () ;
is1 . skip ( is1 . available () ) ;
os1 . write ( send1 ) ;
os1 . flush () ;
Thread . sleep ( 1000 ) ;
if( is1 . available () == 6 )
{
is1 . read ( buffread1 ) ;
if ( equalBytes ( buffread1 , expected1 ) ) {
negotiation1_ok = true ;
}
}
final InputStream is2 = OPTIONS . server . getInputStream () ;
final OutputStream os2 = OPTIONS . server . getOutputStream () ;
Thread . sleep ( 1000 ) ;
is2 . skip ( is2 . available () ) ;
os2 . write ( send2 ) ;
os2 . flush () ;
Thread . sleep ( 1000 ) ;
if( is2 . available () == 9 )
{
is2 . read ( buffread2 ) ;
if ( equalBytes ( buffread2 , expected2 ) ) {
negotiation2_ok = true ;
}
if( negotiation2_ok )
{
negotiation2_ok = false ;
os2 . write ( send2b ) ;
os2 . flush () ;
Thread . sleep ( 1000 ) ;
if( is2 . available () == 11 )
{
is2 . read ( buffread2b ) ;
if ( equalBytes ( buffread2b , expected2b ) ) {
negotiation2_ok = true ;
}
}
}
}
final InputStream is3 = ANSI . server . getInputStream () ;
final OutputStream os3 = ANSI . server . getOutputStream () ;
Thread . sleep ( 1000 ) ;
is3 . skip ( is3 . available () ) ;
os3 . write ( send3 ) ;
os3 . flush () ;
Thread . sleep ( 1000 ) ;
if( is3 . available () == 6 )
{
is3 . read ( buffread3 ) ;
if ( equalBytes ( buffread3 , expected3 ) ) {
negotiation3_ok = true ;
}
if( negotiation3_ok )
{
negotiation3_ok = false ;
os3 . write ( send3b ) ;
os3 . flush () ;
Thread . sleep ( 1000 ) ;
if( is3 . available () == 10 )
{
is3 . read ( buffread3b ) ;
if ( equalBytes ( buffread3b , expected3b ) ) {
negotiation3_ok = true ;
}
}
}
}
assertTrue ( negotiation1_ok ) ;
assertTrue ( negotiation2_ok ) ;
assertTrue ( negotiation3_ok ) ;
assertTrue ( ! STANDARD . client . getLocalOptionState ( 15 ) ) ;
assertTrue ( ! STANDARD . client . getRemoteOptionState ( 15 ) ) ;
assertTrue ( ! STANDARD . client . getLocalOptionState ( TelnetOption . TERMINAL_TYPE ) ) ;
assertTrue ( ! OPTIONS . client . getLocalOptionState ( TelnetOption . ECHO ) ) ;
assertTrue ( ! OPTIONS . client . getRemoteOptionState ( TelnetOption . ECHO ) ) ;
assertTrue ( OPTIONS . client . getLocalOptionState ( TelnetOption . SUPPRESS_GO_AHEAD ) ) ;
assertTrue ( ! OPTIONS . client . getRemoteOptionState ( TelnetOption . SUPPRESS_GO_AHEAD ) ) ;
assertTrue ( OPTIONS . client . getLocalOptionState ( TelnetOption . TERMINAL_TYPE ) ) ;
assertTrue ( ANSI . client . getLocalOptionState ( TelnetOption . TERMINAL_TYPE ) ) ;
assertTrue ( ! OPTIONS . client . getLocalOptionState ( TelnetOption . ECHO ) ) ;
}
public void testOptionRenegotiation () throws Exception
{
boolean negotiation1_ok = false ;
final byte buffread [] = new byte [ 6 ] ;
final byte send [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . ECHO ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte expected [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte buffread2 [] = new byte [ 3 ] ;
final byte send2 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT ,
( byte ) TelnetOption . ECHO ,
} ;
final byte expected2 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . ECHO ,
} ;
final InputStream is = OPTIONS . server . getInputStream () ;
final OutputStream os = OPTIONS . server . getOutputStream () ;
Thread . sleep ( 1000 ) ;
is . skip ( is . available () ) ;
os . write ( send ) ;
os . flush () ;
Thread . sleep ( 1000 ) ;
if( is . available () == 6 )
{
is . read ( buffread ) ;
if ( equalBytes ( buffread , expected ) ) {
negotiation1_ok = true ;
}
if( negotiation1_ok )
{
negotiation1_ok = false ;
os . write ( send2 ) ;
os . flush () ;
Thread . sleep ( 1000 ) ;
if( is . available () == 3 )
{
is . read ( buffread2 ) ;
if ( equalBytes ( buffread2 , expected2 ) ) {
negotiation1_ok = true ;
}
}
}
}
assertTrue ( negotiation1_ok ) ;
assertTrue ( ! OPTIONS . client . getLocalOptionState ( TelnetOption . ECHO ) ) ;
}
public void testNotification () throws Exception
{
final byte buffread1 [] = new byte [ 6 ] ;
final byte send1 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO , ( byte ) 15 ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL , ( byte ) 15 ,
} ;
final byte buffread2 [] = new byte [ 9 ] ;
final byte send2 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . TERMINAL_TYPE ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT ,
( byte ) TelnetOption . ECHO ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte buffread2b [] = new byte [ 11 ] ;
numdo = 0 ;
numdont = 0 ;
numwill = 0 ;
numwont = 0 ;
OPTIONS . client . registerNotifHandler ( this ) ;
final InputStream is1 = STANDARD . server . getInputStream () ;
final OutputStream os1 = STANDARD . server . getOutputStream () ;
is1 . skip ( is1 . available () ) ;
os1 . write ( send1 ) ;
os1 . flush () ;
Thread . sleep ( 500 ) ;
if( is1 . available () > 0 )
{
is1 . read ( buffread1 ) ;
}
final InputStream is2 = OPTIONS . server . getInputStream () ;
final OutputStream os2 = OPTIONS . server . getOutputStream () ;
Thread . sleep ( 500 ) ;
is2 . skip ( is2 . available () ) ;
os2 . write ( send2 ) ;
os2 . flush () ;
Thread . sleep ( 500 ) ;
if( is2 . available () > 0 )
{
is2 . read ( buffread2 ) ;
Thread . sleep ( 1000 ) ;
if( is2 . available () > 0 )
{
is2 . read ( buffread2b ) ;
}
}
assertEquals ( 2 , numdo ) ;
assertEquals ( 1 , numdont ) ;
assertEquals ( 1 , numwont ) ;
assertEquals ( 0 , numwill ) ;
}
public void testDeleteOptionHandler () throws Exception
{
boolean remove_ok = false ;
boolean remove_invalid_ok1 = false ;
boolean remove_invalid_ok2 = false ;
final byte buffread [] = new byte [ 6 ] ;
final byte send [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . ECHO ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final byte expected [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT ,
( byte ) TelnetOption . SUPPRESS_GO_AHEAD
} ;
final InputStream is = OPTIONS . server . getInputStream () ;
final OutputStream os = OPTIONS . server . getOutputStream () ;
Thread . sleep ( 1000 ) ;
is . skip ( is . available () ) ;
os . write ( send ) ;
os . flush () ;
Thread . sleep ( 1000 ) ;
if( is . available () == 0 )
{
OPTIONS . client . deleteOptionHandler ( TelnetOption . SUPPRESS_GO_AHEAD ) ;
Thread . sleep ( 1000 ) ;
if( is . available () == 6 )
{
is . read ( buffread ) ;
if ( equalBytes ( buffread , expected ) ) {
remove_ok = true ;
}
}
}
try
{
OPTIONS . client . deleteOptionHandler ( TelnetOption . SUPPRESS_GO_AHEAD ) ;
}
catch ( final Exception e )
{
remove_invalid_ok1 = true ;
}
try
{
OPTIONS . client . deleteOptionHandler ( 550 ) ;
}
catch ( final Exception e )
{
remove_invalid_ok2 = true ;
}
assertTrue ( remove_ok ) ;
assertTrue ( remove_invalid_ok1 ) ;
assertTrue ( remove_invalid_ok2 ) ;
assertTrue ( OPTIONS . client . getLocalOptionState ( TelnetOption . ECHO ) ) ;
assertTrue ( ! OPTIONS . client . getLocalOptionState ( TelnetOption . SUPPRESS_GO_AHEAD ) ) ;
assertTrue ( ! OPTIONS . client . getLocalOptionState ( TelnetOption . SUPPRESS_GO_AHEAD ) ) ;
}
public void testAYT () throws Exception
{
boolean ayt_true_ok = false ;
boolean ayt_false_ok = false ;
final byte AYT [] = { ( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . AYT } ;
final byte response [] =
{ ( byte ) '[' , ( byte ) 'Y' , ( byte ) 'e' , ( byte ) 's' , ( byte ) ']' } ;
final String inputs [] = new String [ 1 ] ;
final String outputs [] = new String [ 1 ] ;
inputs [ 0 ] = new String ( AYT ) ;
outputs [ 0 ] = new String ( response ) ;
final OutputStream os = ANSI . server . getOutputStream () ;
final InputStream is = ANSI . server . getInputStream () ;
final TelnetTestResponder tr =
new TelnetTestResponder ( is , os , inputs , outputs , 30000 ) ;
assertNotNull ( tr ) ;
final boolean res1 = ANSI . client . sendAYT ( 2000 ) ;
if ( res1 == true ) {
ayt_true_ok = true ;
}
Thread . sleep ( 1000 ) ;
is . skip ( is . available () ) ;
final boolean res2 = ANSI . client . sendAYT ( 2000 ) ;
if ( res2 == false ) {
ayt_false_ok = true ;
}
assertTrue ( ayt_true_ok ) ;
assertTrue ( ayt_false_ok ) ;
}
public void testSpy () throws Exception
{
boolean test1spy_ok = false ;
boolean test2spy_ok = false ;
boolean stopspy_ok = false ;
final byte expected1 [] = { ( byte ) 't' , ( byte ) 'e' , ( byte ) 's' , ( byte ) 't' , ( byte ) '1' } ;
final byte expected2 [] = { ( byte ) 't' , ( byte ) 'e' , ( byte ) 's' , ( byte ) 't' , ( byte ) '2' } ;
try ( final PipedOutputStream po = new PipedOutputStream () ;
final PipedInputStream pi = new PipedInputStream ( po ) ) {
final OutputStream os = STANDARD . server . getOutputStream () ;
final OutputStream ostc = STANDARD . client . getOutputStream () ;
STANDARD . client . registerSpyStream ( po ) ;
os . write ( lr_3 . getBytes () ) ;
os . flush () ;
Thread . sleep ( 1000 ) ;
final byte buffer [] = new byte [ 5 ] ;
if ( pi . available () == 5 ) {
pi . read ( buffer ) ;
if ( equalBytes ( buffer , expected1 ) ) {
test1spy_ok = true ;
}
}
ostc . write ( lr_4 . getBytes () ) ;
ostc . flush () ;
Thread . sleep ( 1000 ) ;
if ( pi . available () == 5 ) {
pi . read ( buffer ) ;
if ( equalBytes ( buffer , expected2 ) ) {
test2spy_ok = true ;
}
}
STANDARD . client . stopSpyStream () ;
os . write ( lr_3 . getBytes () ) ;
os . flush () ;
ostc . write ( lr_4 . getBytes () ) ;
ostc . flush () ;
Thread . sleep ( 1000 ) ;
if ( pi . available () == 0 ) {
stopspy_ok = true ;
}
assertTrue ( test1spy_ok ) ;
assertTrue ( test2spy_ok ) ;
assertTrue ( stopspy_ok ) ;
}
}
public void testSetReaderThread () throws Exception
{
boolean negotiation1_ok = false ;
boolean negotiation2_ok = false ;
boolean read_ok = false ;
final byte buffread1 [] = new byte [ 6 ] ;
final byte send1 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DO , ( byte ) 15 ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WILL , ( byte ) 15 ,
} ;
final byte expected1 [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . WONT , ( byte ) 15 ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . DONT , ( byte ) 15 ,
} ;
final InputStream is1 = NOREAD . server . getInputStream () ;
final OutputStream os1 = NOREAD . server . getOutputStream () ;
is1 . skip ( is1 . available () ) ;
os1 . write ( send1 ) ;
os1 . flush () ;
os1 . write ( lr_5 . getBytes () ) ;
os1 . flush () ;
Thread . sleep ( 1000 ) ;
final InputStream instr = NOREAD . client . getInputStream () ;
final byte [] buff = new byte [ 4 ] ;
int ret_read = 0 ;
ret_read = instr . read ( buff ) ;
if( ret_read == 1 && buff [ 0 ] == 'A' )
{
read_ok = true ;
}
int read = 0 ;
int pos = 0 ;
byte [] tmp = new byte [ 16 ] ;
while ( pos < 5 ) {
read = is1 . read ( tmp ) ;
System . arraycopy ( tmp , 0 , buffread1 , pos , read ) ;
pos += read ;
}
if ( equalBytes ( buffread1 , expected1 ) ) {
negotiation1_ok = true ;
}
final InputStream is2 = STANDARD . server . getInputStream () ;
final OutputStream os2 = STANDARD . server . getOutputStream () ;
Thread . sleep ( 1000 ) ;
is2 . skip ( is2 . available () ) ;
os2 . write ( send1 ) ;
os2 . flush () ;
Thread . sleep ( 1000 ) ;
tmp = new byte [ 16 ] ;
while ( pos < 5 ) {
read = is2 . read ( tmp ) ;
System . arraycopy ( tmp , 0 , buffread1 , pos , read ) ;
pos += read ;
}
is2 . read ( buffread1 ) ;
if ( equalBytes ( buffread1 , expected1 ) ) {
negotiation2_ok = true ;
}
assertTrue ( ! NOREAD . client . getReaderThread () ) ;
assertTrue ( STANDARD . client . getReaderThread () ) ;
assertTrue ( lr_6 + read_ok , read_ok ) ;
assertTrue ( lr_7 + negotiation1_ok , negotiation1_ok ) ;
assertTrue ( lr_8 + negotiation2_ok , negotiation2_ok ) ;
}
public void testMaxSubnegotiationLength () throws Exception
{
final byte send [] =
{
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SB , ( byte ) 99 ,
( byte ) 1 , ( byte ) 2 , ( byte ) 3 ,
( byte ) 4 , ( byte ) 5 , ( byte ) 6 ,
( byte ) 7 , ( byte ) 8 , ( byte ) 9 ,
( byte ) 10 , ( byte ) 11 , ( byte ) 12 ,
( byte ) 13 , ( byte ) 14 , ( byte ) 15 ,
( byte ) TelnetCommand . IAC , ( byte ) TelnetCommand . SE ,
} ;
final OutputStream os1 = SMALL_BUFFER . server . getOutputStream () ;
os1 . write ( send ) ;
os1 . flush () ;
Thread . sleep ( 500 ) ;
assertEquals ( 8 , lastSubnegotiationLength ) ;
assertEquals ( 8 , lastSubnegotiation . length ) ;
assertEquals ( 99 , lastSubnegotiation [ 0 ] ) ;
assertEquals ( 1 , lastSubnegotiation [ 1 ] ) ;
assertEquals ( 2 , lastSubnegotiation [ 2 ] ) ;
assertEquals ( 3 , lastSubnegotiation [ 3 ] ) ;
assertEquals ( 4 , lastSubnegotiation [ 4 ] ) ;
assertEquals ( 5 , lastSubnegotiation [ 5 ] ) ;
assertEquals ( 6 , lastSubnegotiation [ 6 ] ) ;
assertEquals ( 7 , lastSubnegotiation [ 7 ] ) ;
final OutputStream os2 = STANDARD . server . getOutputStream () ;
os2 . write ( send ) ;
os2 . flush () ;
Thread . sleep ( 500 ) ;
assertEquals ( 16 , lastSubnegotiationLength ) ;
assertEquals ( 512 , lastSubnegotiation . length ) ;
assertEquals ( 99 , lastSubnegotiation [ 0 ] ) ;
assertEquals ( 1 , lastSubnegotiation [ 1 ] ) ;
assertEquals ( 2 , lastSubnegotiation [ 2 ] ) ;
assertEquals ( 3 , lastSubnegotiation [ 3 ] ) ;
assertEquals ( 4 , lastSubnegotiation [ 4 ] ) ;
assertEquals ( 5 , lastSubnegotiation [ 5 ] ) ;
assertEquals ( 6 , lastSubnegotiation [ 6 ] ) ;
assertEquals ( 7 , lastSubnegotiation [ 7 ] ) ;
}
protected boolean equalBytes ( final byte a1 [] , final byte a2 [] )
{
if( a1 . length != a2 . length )
{
return false ;
}
boolean result = true ;
for( int ii = 0 ; ii < a1 . length ; ii ++ )
{
if ( a1 [ ii ] != a2 [ ii ] ) {
result = false ;
}
}
return result ;
}
@Override
public void receivedNegotiation ( final int negotiation_code , final int option_code )
{
if( negotiation_code == TelnetNotificationHandler . RECEIVED_DO )
{
numdo ++ ;
}
else if( negotiation_code == TelnetNotificationHandler . RECEIVED_DONT )
{
numdont ++ ;
}
else if( negotiation_code == TelnetNotificationHandler . RECEIVED_WILL )
{
numwill ++ ;
}
else if( negotiation_code == TelnetNotificationHandler . RECEIVED_WONT )
{
numwont ++ ;
}
}
