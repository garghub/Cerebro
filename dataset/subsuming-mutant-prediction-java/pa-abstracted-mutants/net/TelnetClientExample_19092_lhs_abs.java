public static void main ( final String [] args ) throws Exception
{
FileOutputStream fout = null ;
if( args . length < 1 ) MST[rv.CRCR3Mutator]MSP[]
{
System . err . println ( lr_1 ) ;
System . exit ( 1 ) ;
}
final String remoteip = args [ 0 ] ;
int remoteport ;
if ( args . length > 1 )
{
remoteport = Integer . parseInt ( args [ 1 ] ) ;
}
else
{
remoteport = 23 ;
}
try
{
fout = new FileOutputStream ( lr_2 , true ) ;
}
catch ( final IOException e )
{
System . err . println (
lr_3
+ e . getMessage () ) ;
}
tc = new TelnetClient () ;
final TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler ( lr_4 , false , false , true , false ) ;
final EchoOptionHandler echoopt = new EchoOptionHandler ( true , false , true , false ) ;
final SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler ( true , true , true , true ) ;
try
{
tc . addOptionHandler ( ttopt ) ;
tc . addOptionHandler ( echoopt ) ;
tc . addOptionHandler ( gaopt ) ;
}
catch ( final InvalidTelnetOptionException e )
{
System . err . println ( lr_5 + e . getMessage () ) ;
}
while ( true )
{
boolean end_loop = false ;
try
{
tc . connect ( remoteip , remoteport ) ;
final Thread reader = new Thread ( new TelnetClientExample () ) ;
tc . registerNotifHandler ( new TelnetClientExample () ) ;
System . out . println ( lr_6 ) ;
System . out . println ( lr_7 ) ;
System . out . println ( lr_8 ) ;
System . out . println ( lr_9 ) ;
System . out . println ( lr_10 ) ;
System . out . println ( lr_11 ) ;
System . out . println ( lr_12 ) ;
System . out . println ( lr_13 ) ;
reader . start () ;
final OutputStream outstr = tc . getOutputStream () ;
final byte [] buff = new byte [ 1024 ] ;
int ret_read = 0 ;
do
{
try
{
ret_read = System . in . read ( buff ) ;
if( ret_read > 0 )
{
final String line = new String ( buff , 0 , ret_read ) ;
if( line . startsWith ( lr_14 ) )
{
try
{
System . out . println ( lr_15 ) ;
System . out . println ( lr_16 + tc . sendAYT ( 5000 ) ) ;
}
catch ( final IOException e )
{
System . err . println ( lr_17 + e . getMessage () ) ;
}
}
else if( line . startsWith ( lr_18 ) )
{
System . out . println ( lr_19 ) ;
for( int ii = 0 ; ii < 25 ; ii ++ ) {
System . out . println ( lr_20 + ii + lr_21 + tc . getLocalOptionState ( ii ) +
lr_22 + ii + lr_21 + tc . getRemoteOptionState ( ii ) ) ;
}
}
else if( line . startsWith ( lr_23 ) )
{
final StringTokenizer st = new StringTokenizer ( new String ( buff ) ) ;
try
{
st . nextToken () ;
final int opcode = Integer . parseInt ( st . nextToken () ) ;
final boolean initlocal = Boolean . parseBoolean ( st . nextToken () ) ;
final boolean initremote = Boolean . parseBoolean ( st . nextToken () ) ;
final boolean acceptlocal = Boolean . parseBoolean ( st . nextToken () ) ;
final boolean acceptremote = Boolean . parseBoolean ( st . nextToken () ) ;
final SimpleOptionHandler opthand = new SimpleOptionHandler ( opcode , initlocal , initremote ,
acceptlocal , acceptremote ) ;
tc . addOptionHandler ( opthand ) ;
}
catch ( final Exception e )
{
if( e instanceof InvalidTelnetOptionException )
{
System . err . println ( lr_24 + e . getMessage () ) ;
}
else
{
System . err . println ( lr_25 ) ;
System . err . println ( lr_26 ) ;
System . err . println ( lr_27 ) ;
System . err . println ( lr_28 ) ;
}
}
}
else if( line . startsWith ( lr_29 ) )
{
final StringTokenizer st = new StringTokenizer ( new String ( buff ) ) ;
try
{
st . nextToken () ;
final int opcode = new Integer ( st . nextToken () ) . intValue () ;
tc . deleteOptionHandler ( opcode ) ;
}
catch ( final Exception e )
{
if( e instanceof InvalidTelnetOptionException )
{
System . err . println ( lr_30 + e . getMessage () ) ;
}
else
{
System . err . println ( lr_31 ) ;
System . err . println ( lr_32 ) ;
System . err . println ( lr_33 ) ;
}
}
}
else if( line . startsWith ( lr_34 ) )
{
tc . registerSpyStream ( fout ) ;
}
else if( line . startsWith ( lr_35 ) )
{
tc . stopSpyStream () ;
}
else if( line . matches ( lr_36 ) )
{
final byte toSend = buff [ 1 ] ;
if ( toSend == '^' ) {
outstr . write ( toSend ) ;
} else {
outstr . write ( toSend - 'A' + 1 ) ;
}
outstr . flush () ;
}
else
{
try
{
outstr . write ( buff , 0 , ret_read ) ;
outstr . flush () ;
}
catch ( final IOException e )
{
end_loop = true ;
}
}
}
}
catch ( final IOException e )
{
System . err . println ( lr_37 + e . getMessage () ) ;
end_loop = true ;
}
}
while( ret_read > 0 && end_loop == false );
try
{
tc . disconnect () ;
}
catch ( final IOException e )
{
System . err . println ( lr_38 + e . getMessage () ) ;
}
}
catch ( final IOException e )
{
System . err . println ( lr_38 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
}
}
@Override
public void receivedNegotiation ( final int negotiation_code , final int option_code )
{
String command = null ;
switch ( negotiation_code ) {
case TelnetNotificationHandler . RECEIVED_DO :
command = lr_39 ;
break;
case TelnetNotificationHandler . RECEIVED_DONT :
command = lr_40 ;
break;
case TelnetNotificationHandler . RECEIVED_WILL :
command = lr_41 ;
break;
case TelnetNotificationHandler . RECEIVED_WONT :
command = lr_42 ;
break;
case TelnetNotificationHandler . RECEIVED_COMMAND :
command = lr_43 ;
break;
default:
command = Integer . toString ( negotiation_code ) ;
break;
}
System . out . println ( lr_44 + command + lr_45 + option_code ) ;
}
@Override
public void run ()
{
final InputStream instr = tc . getInputStream () ;
try
{
final byte [] buff = new byte [ 1024 ] ;
int ret_read = 0 ;
do
{
ret_read = instr . read ( buff ) ;
if( ret_read > 0 )
{
System . out . print ( new String ( buff , 0 , ret_read ) ) ;
}
}
while ( ret_read >= 0 );
}
catch ( final IOException e )
{
System . err . println ( lr_46 + e . getMessage () ) ;
}
try
{
tc . disconnect () ;
}
catch ( final IOException e )
{
System . err . println ( lr_47 + e . getMessage () ) ;
}
}
