@Override
protected void tearDown () throws Exception
{
testsLeftToRun -- ;
if ( testsLeftToRun <= 0 )
{
if ( tftpS != null )
{
tftpS . shutdown () ;
}
for ( final File file : files )
{
file . delete () ;
}
}
super . tearDown () ;
}
private static File createFile ( final File file , final int size ) throws IOException
{
try ( final OutputStream os = new BufferedOutputStream ( new FileOutputStream ( file ) ) ) {
final byte [] temp = lr_1 . getBytes () ;
for ( int i = 0 ; i < size ; i ++ ) {
os . write ( temp ) ;
}
}
return file ;
}
public void testTFTPBinaryDownloads () throws Exception
{
for ( int i = 0 ; i < 6 ; i ++ )
{
testDownload ( TFTP . BINARY_MODE , files [ i ] ) ;
}
}
public void testASCIIDownloads () throws Exception
{
for ( int i = 0 ; i < 6 ; i ++ )
{
try {
testDownload ( TFTP . ASCII_MODE , files [ i ] ) ;
} catch ( final IOException e ) {
fail ( lr_2 + i + lr_3 + e . toString () ) ;
}
}
}
public void testTFTPBinaryUploads () throws Exception
{
for ( int i = 0 ; i < 6 ; i ++ )
{
testUpload ( TFTP . BINARY_MODE , files [ i ] ) ;
}
}
public void testASCIIUploads () throws Exception
{
for ( int i = 0 ; i < 6 ; i ++ )
{
testUpload ( TFTP . ASCII_MODE , files [ i ] ) ;
}
}
public void testHugeUploads () throws Exception
{
for ( int i = 5 ; i < files . length ; i ++ )
{
testUpload ( TFTP . BINARY_MODE , files [ i ] ) ;
}
}
public void testHugeDownloads () throws Exception
{
for ( int i = 5 ; i < files . length ; i ++ )
{
testDownload ( TFTP . BINARY_MODE , files [ i ] ) ;
}
}
private void testDownload ( final int mode , final File file ) throws IOException
{
final TFTPClient tftp = new TFTPClient () ;
tftp . open () ;
tftp . setSoTimeout ( 2000 ) ;
final File out = new File ( serverDirectory , filePrefix + lr_4 ) ;
out . delete () ;
assertTrue ( lr_5 , ! out . exists () ) ;
try ( final FileOutputStream output = new FileOutputStream ( out ) ) {
tftp . receiveFile ( file . getName () , mode , output , lr_6 , SERVER_PORT ) ;
}
assertTrue ( lr_7 , out . exists () ) ;
assertTrue ( lr_8 + file , filesIdentical ( out , file ) ) ;
out . delete () ;
}
private void testUpload ( final int mode , final File file ) throws Exception
{
final TFTPClient tftp = new TFTPClient () ;
tftp . open () ;
tftp . setSoTimeout ( 2000 ) ;
final File in = new File ( serverDirectory , filePrefix + lr_9 ) ;
in . delete () ;
assertTrue ( lr_5 , ! in . exists () ) ;
try ( final FileInputStream fis = new FileInputStream ( file ) ) {
tftp . sendFile ( in . getName () , mode , fis , lr_6 , SERVER_PORT ) ;
}
Thread . sleep ( 100 ) ;
assertTrue ( lr_7 , in . exists () ) ;
assertTrue ( lr_8 + file , filesIdentical ( file , in ) ) ;
in . delete () ;
}
private boolean filesIdentical ( final File a , final File b ) throws IOException
{
if ( ! a . exists () || ! b . exists () ) {
return false ;
}
if ( a . length () != b . length () ) {
return false ;
}
try ( final InputStream fisA = new BufferedInputStream ( new FileInputStream ( a ) ) ;
final InputStream fisB = new BufferedInputStream ( new FileInputStream ( b ) ) ) {
int aBit = fisA . read () ;
int bBit = fisB . read () ;
while ( aBit != - 1 ) {
if ( aBit != bBit ) {
fisA . close () ;
fisB . close () ;
return false ;
}
aBit = fisA . read () ;
bBit = fisB . read () ;
}
}
return true ;
}
