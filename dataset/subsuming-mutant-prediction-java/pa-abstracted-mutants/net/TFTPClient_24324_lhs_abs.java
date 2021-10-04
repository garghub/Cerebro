public void setMaxTimeouts ( final int numTimeouts )
{
if ( numTimeouts < 1 ) {
maxTimeouts = 1 ;
} else {
maxTimeouts = numTimeouts ;
}
}
public int getMaxTimeouts ()
{
return maxTimeouts ;
}
public long getTotalBytesReceived () {
return totalBytesReceived ;
}
public long getTotalBytesSent () {
return totalBytesSent ;
}
public int receiveFile ( final String fileName , final int mode , OutputStream output ,
InetAddress host , final int port ) throws IOException
{
int bytesRead = 0 ;
int lastBlock = 0 ;
int block = 1 ;
int hostPort = 0 ;
int dataLength = 0 ;
totalBytesReceived = 0 ;
if ( mode == TFTP . ASCII_MODE ) {
output = new FromNetASCIIOutputStream ( output ) ;
}
TFTPPacket sent = new TFTPReadRequestPacket ( host , port , fileName , mode ) ;
final TFTPAckPacket ack = new TFTPAckPacket ( host , port , 0 ) ;
beginBufferedOps () ;
boolean justStarted = true ;
try {
do {
bufferedSend ( sent ) ;
boolean wantReply = true ;
int timeouts = 0 ;
do {
try {
final TFTPPacket received = bufferedReceive () ;
final int recdPort = received . getPort () ;
final InetAddress recdAddress = received . getAddress () ;
if ( justStarted ) {
justStarted = false ;
if ( recdPort == port ) {
final TFTPErrorPacket error = new TFTPErrorPacket ( recdAddress ,
recdPort , TFTPErrorPacket . UNKNOWN_TID ,
lr_1 ) ;
bufferedSend ( error ) ;
throw new IOException ( lr_2 + recdPort + lr_3 ) ;
}
hostPort = recdPort ;
ack . setPort ( hostPort ) ;
if( ! host . equals ( recdAddress ) )
{
host = recdAddress ;
ack . setAddress ( host ) ;
sent . setAddress ( host ) ;
}
}
if ( host . equals ( recdAddress ) && recdPort == hostPort ) {
switch ( received . getType () ) {
case TFTPPacket . ERROR :
TFTPErrorPacket error = ( TFTPErrorPacket ) received ;
throw new IOException ( lr_4 + error . getError () +
lr_5 + error . getMessage () ) ;
case TFTPPacket . DATA :
final TFTPDataPacket data = ( TFTPDataPacket ) received ;
dataLength = data . getDataLength () ;
lastBlock = data . getBlockNumber () ;
if ( lastBlock == block ) {
try {
output . write ( data . getData () , data . getDataOffset () , dataLength ) ;
} catch ( final IOException e ) {
error = new TFTPErrorPacket ( host , hostPort ,
TFTPErrorPacket . OUT_OF_SPACE ,
lr_6 ) ;
bufferedSend ( error ) ;
throw e ;
}
++ block ;
if ( block > 65535 ) {
block = 0 ;
}
wantReply = false ;
} else {
discardPackets () ;
if ( lastBlock == ( block == 0 ? 65535 : block - 1 ) ) {
wantReply = false ;
}
}
break;
default:
throw new IOException ( lr_7 + received . getType () + lr_8 ) ;
}
} else {
final TFTPErrorPacket error = new TFTPErrorPacket ( recdAddress , recdPort ,
TFTPErrorPacket . UNKNOWN_TID ,
lr_9 ) ;
bufferedSend ( error ) ;
}
} catch ( final SocketException e ) {
if ( ++ timeouts >= maxTimeouts ) {
throw new IOException ( lr_10 ) ;
}
} catch ( final InterruptedIOException e ) {
if ( ++ timeouts >= maxTimeouts ) {
throw new IOException ( lr_10 ) ;
}
} catch ( final TFTPPacketException e ) {
throw new IOException ( lr_11 + e . getMessage () ) ;
}
} while( wantReply );
ack . setBlockNumber ( lastBlock ) ;
sent = ack ;
bytesRead += dataLength ;
totalBytesReceived += dataLength ;
} while ( dataLength == TFTPPacket . SEGMENT_SIZE );
bufferedSend ( sent ) ;
} finally {
endBufferedOps () ;
}
return bytesRead ;
}
public int receiveFile ( final String fileName , final int mode , final OutputStream output ,
final String hostname , final int port )
throws UnknownHostException , IOException
{
return receiveFile ( fileName , mode , output , InetAddress . getByName ( hostname ) ,
port ) ;
}
public int receiveFile ( final String fileName , final int mode , final OutputStream output ,
final InetAddress host )
throws IOException
{
return receiveFile ( fileName , mode , output , host , DEFAULT_PORT ) ;
}
public int receiveFile ( final String fileName , final int mode , final OutputStream output ,
final String hostname )
throws UnknownHostException , IOException
{
return receiveFile ( fileName , mode , output , InetAddress . getByName ( hostname ) ,
DEFAULT_PORT ) ;
}
public void sendFile ( final String fileName , final int mode , InputStream input ,
InetAddress host , final int port ) throws IOException
{
int block = 0 ;
int hostPort = 0 ;
boolean justStarted = true ;
boolean lastAckWait = false ;
totalBytesSent = 0L ;
if ( mode == TFTP . ASCII_MODE ) {
input = new ToNetASCIIInputStream ( input ) ;
}
TFTPPacket sent = new TFTPWriteRequestPacket ( host , port , fileName , mode ) ;
final TFTPDataPacket data = new TFTPDataPacket ( host , port , 0 , sendBuffer , 4 , 0 ) ;
beginBufferedOps () ;
try {
do {
bufferedSend ( sent ) ;
boolean wantReply = true ;
int timeouts = 0 ;
do {
try {
final TFTPPacket received = bufferedReceive () ;
final InetAddress recdAddress = received . getAddress () ;
final int recdPort = received . getPort () ;
if ( justStarted ) {
justStarted = false ;
if ( recdPort == port ) {
final TFTPErrorPacket error = new TFTPErrorPacket ( recdAddress ,
recdPort , TFTPErrorPacket . UNKNOWN_TID ,
lr_1 ) ;
bufferedSend ( error ) ;
throw new IOException ( lr_2 + recdPort + lr_3 ) ;
}
hostPort = recdPort ;
data . setPort ( hostPort ) ;
if ( ! host . equals ( recdAddress ) ) {
host = recdAddress ;
data . setAddress ( host ) ;
sent . setAddress ( host ) ;
}
}
if ( host . equals ( recdAddress ) && recdPort == hostPort ) {
switch ( received . getType () ) {
case TFTPPacket . ERROR :
final TFTPErrorPacket error = ( TFTPErrorPacket ) received ;
throw new IOException ( lr_4 + error . getError () +
lr_5 + error . getMessage () ) ;
case TFTPPacket . ACKNOWLEDGEMENT :
final int lastBlock = ( ( TFTPAckPacket ) received ) . getBlockNumber () ;
if ( lastBlock == block ) {
++ block ;
if ( block > 65535 ) {
block = 0 ;
}
wantReply = false ;
} else {
discardPackets () ;
}
break;
default:
throw new IOException ( lr_12 ) ;
}
} else {
final TFTPErrorPacket error = new TFTPErrorPacket ( recdAddress ,
recdPort ,
TFTPErrorPacket . UNKNOWN_TID ,
lr_9 ) ;
bufferedSend ( error ) ;
}
} catch ( final SocketException e ) {
if ( ++ timeouts >= maxTimeouts ) {
throw new IOException ( lr_10 ) ;
}
} catch ( final InterruptedIOException e ) {
if ( ++ timeouts >= maxTimeouts ) {
throw new IOException ( lr_10 ) ;
}
} catch ( final TFTPPacketException e ) {
throw new IOException ( lr_11 + e . getMessage () ) ;
}
} while( wantReply );
if ( lastAckWait ) {
break;
}
int dataLength = TFTPPacket . SEGMENT_SIZE ;
int offset = 4 ;
int totalThisPacket = 0 ;
int bytesRead = 0 ;
while ( dataLength > 0 && MST[rv.ABSMutator]MSP[]
( bytesRead = input . read ( sendBuffer , offset , dataLength ) ) > 0 ) {
offset += bytesRead ;
dataLength -= bytesRead ;
totalThisPacket += bytesRead ;
}
if( totalThisPacket < TFTPPacket . SEGMENT_SIZE ) {
lastAckWait = true ;
}
data . setBlockNumber ( block ) ;
data . setData ( sendBuffer , 4 , totalThisPacket ) ;
sent = data ;
totalBytesSent += totalThisPacket ;
} while ( true );
} finally {
endBufferedOps () ;
}
}
public void sendFile ( final String fileName , final int mode , final InputStream input ,
final String hostname , final int port )
throws UnknownHostException , IOException
{
sendFile ( fileName , mode , input , InetAddress . getByName ( hostname ) , port ) ;
}
public void sendFile ( final String fileName , final int mode , final InputStream input ,
final InetAddress host )
throws IOException
{
sendFile ( fileName , mode , input , host , DEFAULT_PORT ) ;
}
public void sendFile ( final String fileName , final int mode , final InputStream input ,
final String hostname )
throws UnknownHostException , IOException
{
sendFile ( fileName , mode , input , InetAddress . getByName ( hostname ) ,
DEFAULT_PORT ) ;
}
