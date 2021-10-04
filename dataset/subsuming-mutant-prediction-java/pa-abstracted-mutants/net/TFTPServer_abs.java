@Override
public void write ( final int b ) {}
@Override
public void write ( final byte [] b ) throws IOException {}
public void setMaxTimeoutRetries ( final int retries )
{
if ( retries < 0 )
{
throw new RuntimeException ( lr_1 ) ;
}
maxTimeoutRetries_ = retries ;
}
public int getMaxTimeoutRetries ()
{
return maxTimeoutRetries_ ;
}
public void setSocketTimeout ( final int timeout )
{
if ( timeout < 10 )
{
throw new RuntimeException ( lr_1 ) ;
}
socketTimeout_ = timeout ;
}
public int getSocketTimeout ()
{
return socketTimeout_ ;
}
private void launch ( final File serverReadDirectory , final File serverWriteDirectory ) throws IOException
{
log_ . println ( lr_2 + port_ + lr_3
+ serverReadDirectory + lr_4 + serverWriteDirectory
+ lr_5 + mode_ ) ;
serverReadDirectory_ = serverReadDirectory . getCanonicalFile () ;
if ( ! serverReadDirectory_ . exists () || ! serverReadDirectory . isDirectory () )
{
throw new IOException ( lr_6 + serverReadDirectory_
+ lr_7 ) ;
}
serverWriteDirectory_ = serverWriteDirectory . getCanonicalFile () ;
if ( ! serverWriteDirectory_ . exists () || ! serverWriteDirectory . isDirectory () )
{
throw new IOException ( lr_8 + serverWriteDirectory_
+ lr_7 ) ;
}
serverTftp_ = new TFTP () ;
socketTimeout_ = serverTftp_ . getDefaultTimeout () ;
serverTftp_ . setDefaultTimeout ( 0 ) ;
if ( laddr_ != null ) {
serverTftp_ . open ( port_ , laddr_ ) ;
} else {
serverTftp_ . open ( port_ ) ;
}
serverThread = new Thread ( this ) ;
serverThread . setDaemon ( true ) ;
serverThread . start () ;
}
@Override
protected void finalize () throws Throwable
{
shutdown () ;
}
public boolean isRunning () throws Exception
{
if ( shutdownServer && serverException != null )
{
throw serverException ;
}
return ! shutdownServer ;
}
@Override
public void run ()
{
try
{
while ( ! shutdownServer )
{
TFTPPacket tftpPacket ;
tftpPacket = serverTftp_ . receive () ;
final TFTPTransfer tt = new TFTPTransfer ( tftpPacket ) ;
synchronized( transfers_ )
{
transfers_ . add ( tt ) ;
}
final Thread thread = new Thread ( tt ) ;
thread . setDaemon ( true ) ;
thread . start () ;
}
}
catch ( final Exception e )
{
if ( ! shutdownServer )
{
serverException = e ;
logError_ . println ( lr_9 + e ) ;
}
}
finally
{
shutdownServer = true ;
if ( serverTftp_ != null && serverTftp_ . isOpen () )
{
serverTftp_ . close () ;
}
}
}
public void shutdown ()
{
shutdownServer = true ;
synchronized( transfers_ )
{
final Iterator < TFTPTransfer > it = transfers_ . iterator () ;
while ( it . hasNext () )
{
it . next () . shutdown () ;
}
}
try
{
serverTftp_ . close () ;
}
catch ( final RuntimeException e )
{
}
try {
serverThread . join () ;
} catch ( final InterruptedException e ) {
}
}
public void shutdown ()
{
shutdownTransfer = true ;
try
{
transferTftp_ . close () ;
}
catch ( final RuntimeException e )
{
}
}
@Override
public void run ()
{
try
{
transferTftp_ = newTFTP () ;
transferTftp_ . beginBufferedOps () ;
transferTftp_ . setDefaultTimeout ( socketTimeout_ ) ;
transferTftp_ . open () ;
if ( tftpPacket_ instanceof TFTPReadRequestPacket )
{
handleRead ( ( TFTPReadRequestPacket ) tftpPacket_ ) ;
}
else if ( tftpPacket_ instanceof TFTPWriteRequestPacket )
{
handleWrite ( ( TFTPWriteRequestPacket ) tftpPacket_ ) ;
}
else
{
log_ . println ( lr_10 + tftpPacket_ + lr_11 ) ;
}
}
catch ( final Exception e )
{
if ( ! shutdownTransfer )
{
logError_
. println ( lr_12
+ e ) ;
}
}
finally
{
try
{
if ( transferTftp_ != null && transferTftp_ . isOpen () )
{
transferTftp_ . endBufferedOps () ;
transferTftp_ . close () ;
}
}
catch ( final Exception e )
{
}
synchronized( transfers_ )
{
transfers_ . remove ( this ) ;
}
}
}
private void handleRead ( final TFTPReadRequestPacket trrp ) throws IOException , TFTPPacketException
{
InputStream is = null ;
try
{
if ( mode_ == ServerMode . PUT_ONLY )
{
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( trrp . getAddress () , trrp
. getPort () , TFTPErrorPacket . ILLEGAL_OPERATION ,
lr_13 ) ) ;
return;
}
try
{
is = new BufferedInputStream ( new FileInputStream ( buildSafeFile (
serverReadDirectory_ , trrp . getFilename () , false ) ) ) ;
}
catch ( final FileNotFoundException e )
{
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( trrp . getAddress () , trrp
. getPort () , TFTPErrorPacket . FILE_NOT_FOUND , e . getMessage () ) ) ;
return;
}
catch ( final Exception e )
{
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( trrp . getAddress () , trrp
. getPort () , TFTPErrorPacket . UNDEFINED , e . getMessage () ) ) ;
return;
}
if ( trrp . getMode () == TFTP . NETASCII_MODE )
{
is = new ToNetASCIIInputStream ( is ) ;
}
final byte [] temp = new byte [ TFTPDataPacket . MAX_DATA_LENGTH ] ;
TFTPPacket answer ;
int block = 1 ;
boolean sendNext = true ;
int readLength = TFTPDataPacket . MAX_DATA_LENGTH ;
TFTPDataPacket lastSentData = null ;
while ( readLength == TFTPDataPacket . MAX_DATA_LENGTH && ! shutdownTransfer )
{
if ( sendNext )
{
readLength = is . read ( temp ) ;
if ( readLength == - 1 )
{
readLength = 0 ;
}
lastSentData = new TFTPDataPacket ( trrp . getAddress () , trrp . getPort () , block ,
temp , 0 , readLength ) ;
sendData ( transferTftp_ , lastSentData ) ;
}
answer = null ;
int timeoutCount = 0 ;
while ( ! shutdownTransfer
&& ( answer == null || ! answer . getAddress () . equals ( trrp . getAddress () ) || answer
. getPort () != trrp . getPort () ) )
{
if ( answer != null )
{
log_ . println ( lr_14 ) ;
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( answer . getAddress () ,
answer . getPort () , TFTPErrorPacket . UNKNOWN_TID ,
lr_15 ) ) ;
}
try
{
answer = transferTftp_ . bufferedReceive () ;
}
catch ( final SocketTimeoutException e )
{
if ( timeoutCount >= maxTimeoutRetries_ )
{
throw e ;
}
timeoutCount ++ ;
transferTftp_ . bufferedSend ( lastSentData ) ;
continue;
}
}
if ( answer == null || ! ( answer instanceof TFTPAckPacket ) )
{
if ( ! shutdownTransfer )
{
logError_
. println ( lr_16
+ answer + lr_17 ) ;
}
break;
}
final TFTPAckPacket ack = ( TFTPAckPacket ) answer ;
if ( ack . getBlockNumber () != block )
{
sendNext = false ;
}
else
{
block ++ ;
if ( block > 65535 )
{
block = 0 ;
}
sendNext = true ;
}
}
}
finally
{
try
{
if ( is != null )
{
is . close () ;
}
}
catch ( final IOException e )
{
}
}
}
private void handleWrite ( final TFTPWriteRequestPacket twrp ) throws IOException ,
TFTPPacketException
{
OutputStream bos = null ;
try
{
if ( mode_ == ServerMode . GET_ONLY )
{
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( twrp . getAddress () , twrp
. getPort () , TFTPErrorPacket . ILLEGAL_OPERATION ,
lr_18 ) ) ;
return;
}
int lastBlock = 0 ;
final String fileName = twrp . getFilename () ;
try
{
final File temp = buildSafeFile ( serverWriteDirectory_ , fileName , true ) ;
if ( temp . exists () )
{
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( twrp . getAddress () , twrp
. getPort () , TFTPErrorPacket . FILE_EXISTS , lr_19 ) ) ;
return;
}
bos = new BufferedOutputStream ( new FileOutputStream ( temp ) ) ;
if ( twrp . getMode () == TFTP . NETASCII_MODE )
{
bos = new FromNetASCIIOutputStream ( bos ) ;
}
}
catch ( final Exception e )
{
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( twrp . getAddress () , twrp
. getPort () , TFTPErrorPacket . UNDEFINED , e . getMessage () ) ) ;
return;
}
TFTPAckPacket lastSentAck = new TFTPAckPacket ( twrp . getAddress () , twrp . getPort () , 0 ) ;
sendData ( transferTftp_ , lastSentAck ) ;
while ( true )
{
TFTPPacket dataPacket = null ;
int timeoutCount = 0 ;
while ( ! shutdownTransfer
&& ( dataPacket == null
|| ! dataPacket . getAddress () . equals ( twrp . getAddress () ) || dataPacket
. getPort () != twrp . getPort () ) )
{
if ( dataPacket != null )
{
log_ . println ( lr_14 ) ;
transferTftp_ . bufferedSend ( new TFTPErrorPacket ( dataPacket . getAddress () ,
dataPacket . getPort () , TFTPErrorPacket . UNKNOWN_TID ,
lr_15 ) ) ;
}
try
{
dataPacket = transferTftp_ . bufferedReceive () ;
}
catch ( final SocketTimeoutException e )
{
if ( timeoutCount >= maxTimeoutRetries_ )
{
throw e ;
}
transferTftp_ . bufferedSend ( lastSentAck ) ;
timeoutCount ++ ;
continue;
}
}
if ( dataPacket != null && dataPacket instanceof TFTPWriteRequestPacket )
{
lastSentAck = new TFTPAckPacket ( twrp . getAddress () , twrp . getPort () , 0 ) ;
transferTftp_ . bufferedSend ( lastSentAck ) ;
}
else if ( dataPacket == null || ! ( dataPacket instanceof TFTPDataPacket ) )
{
if ( ! shutdownTransfer )
{
logError_
. println ( lr_16
+ dataPacket + lr_17 ) ;
}
break;
}
else
{
final int block = ( ( TFTPDataPacket ) dataPacket ) . getBlockNumber () ;
final byte [] data = ( ( TFTPDataPacket ) dataPacket ) . getData () ;
final int dataLength = ( ( TFTPDataPacket ) dataPacket ) . getDataLength () ;
final int dataOffset = ( ( TFTPDataPacket ) dataPacket ) . getDataOffset () ;
if ( block > lastBlock || lastBlock == 65535 && block == 0 )
{
bos . write ( data , dataOffset , dataLength ) ;
lastBlock = block ;
}
lastSentAck = new TFTPAckPacket ( twrp . getAddress () , twrp . getPort () , block ) ;
sendData ( transferTftp_ , lastSentAck ) ;
if ( dataLength < TFTPDataPacket . MAX_DATA_LENGTH )
{
bos . close () ;
for ( int i = 0 ; i < maxTimeoutRetries_ ; i ++ )
{
try
{
dataPacket = transferTftp_ . bufferedReceive () ;
}
catch ( final SocketTimeoutException e )
{
break;
}
if ( dataPacket != null
&& ( ! dataPacket . getAddress () . equals ( twrp . getAddress () ) || dataPacket
. getPort () != twrp . getPort () ) )
{
transferTftp_
. bufferedSend ( new TFTPErrorPacket ( dataPacket
. getAddress () , dataPacket . getPort () ,
TFTPErrorPacket . UNKNOWN_TID ,
lr_15 ) ) ;
}
else
{
transferTftp_ . bufferedSend ( lastSentAck ) ;
}
}
break;
}
}
}
}
finally
{
if ( bos != null )
{
bos . close () ;
}
}
}
private File buildSafeFile ( final File serverDirectory , final String fileName , final boolean createSubDirs )
throws IOException
{
File temp = new File ( serverDirectory , fileName ) ;
temp = temp . getCanonicalFile () ;
if ( ! isSubdirectoryOf ( serverDirectory , temp ) )
{
throw new IOException ( lr_20 ) ;
}
if ( createSubDirs )
{
createDirectory ( temp . getParentFile () ) ;
}
return temp ;
}
private void createDirectory ( final File file ) throws IOException
{
final File parent = file . getParentFile () ;
if ( parent == null )
{
throw new IOException ( lr_21 ) ;
}
if ( ! parent . exists () )
{
createDirectory ( parent ) ;
}
if ( parent . isDirectory () )
{
if ( file . isDirectory () )
{
return;
}
final boolean result = file . mkdir () ;
if ( ! result )
{
throw new IOException ( lr_22 ) ;
}
}
else
{
throw new IOException (
lr_23 ) ;
}
}
private boolean isSubdirectoryOf ( final File parent , final File child )
{
final File childsParent = child . getParentFile () ;
if ( childsParent == null )
{
return false ;
}
if ( childsParent . equals ( parent ) )
{
return true ;
}
return isSubdirectoryOf ( parent , childsParent ) ;
}
public void setLog ( final PrintStream log )
{
this . log_ = log ;
}
public void setLogError ( final PrintStream logError )
{
this . logError_ = logError ;
}
TFTP newTFTP () {
return new TFTP () ;
}
void sendData ( final TFTP tftp , final TFTPPacket data ) throws IOException {
tftp . bufferedSend ( data ) ;
}
