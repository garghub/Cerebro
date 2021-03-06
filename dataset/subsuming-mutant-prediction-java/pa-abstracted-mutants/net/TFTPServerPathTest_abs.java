public void testReadOnly () throws IOException
{
final TFTPServer tftpS = new TFTPServer ( serverDirectory , serverDirectory , SERVER_PORT ,
ServerMode . GET_ONLY , null , null ) ;
final TFTPClient tftp = new TFTPClient () ;
tftp . open () ;
tftp . setSoTimeout ( 2000 ) ;
final File file = new File ( serverDirectory , filePrefix + lr_1 ) ;
file . createNewFile () ;
final File out = new File ( serverDirectory , filePrefix + lr_2 ) ;
out . delete () ;
assertTrue ( lr_3 , ! out . exists () ) ;
try ( final FileOutputStream output = new FileOutputStream ( out ) ) {
tftp . receiveFile ( file . getName () , TFTP . BINARY_MODE , output , lr_4 , SERVER_PORT ) ;
}
assertTrue ( lr_5 , out . exists () ) ;
out . delete () ;
try ( final FileInputStream fis = new FileInputStream ( file ) ) {
tftp . sendFile ( out . getName () , TFTP . BINARY_MODE , fis , lr_4 , SERVER_PORT ) ;
fail ( lr_6 ) ;
} catch ( final IOException e ) {
}
file . delete () ;
tftpS . shutdown () ;
}
public void testWriteOnly () throws IOException
{
final TFTPServer tftpS = new TFTPServer ( serverDirectory , serverDirectory , SERVER_PORT ,
ServerMode . PUT_ONLY , null , null ) ;
final TFTPClient tftp = new TFTPClient () ;
tftp . open () ;
tftp . setSoTimeout ( 2000 ) ;
final File file = new File ( serverDirectory , filePrefix + lr_1 ) ;
file . createNewFile () ;
final File out = new File ( serverDirectory , filePrefix + lr_2 ) ;
out . delete () ;
assertTrue ( lr_3 , ! out . exists () ) ;
try ( final FileOutputStream output = new FileOutputStream ( out ) ) {
tftp . receiveFile ( file . getName () , TFTP . BINARY_MODE , output , lr_4 , SERVER_PORT ) ;
fail ( lr_7 ) ;
} catch ( final IOException e ) {
}
out . delete () ;
try ( final FileInputStream fis = new FileInputStream ( file ) ) {
tftp . sendFile ( out . getName () , TFTP . BINARY_MODE , fis , lr_4 , SERVER_PORT ) ;
}
assertTrue ( lr_5 , out . exists () ) ;
file . delete () ;
out . delete () ;
tftpS . shutdown () ;
}
public void testWriteOutsideHome () throws IOException
{
final TFTPServer tftpS = new TFTPServer ( serverDirectory , serverDirectory , SERVER_PORT ,
ServerMode . GET_AND_PUT , null , null ) ;
final TFTPClient tftp = new TFTPClient () ;
tftp . open () ;
final File file = new File ( serverDirectory , filePrefix + lr_1 ) ;
file . createNewFile () ;
assertFalse ( lr_8 , new File ( serverDirectory , lr_9 ) . exists () ) ;
try ( final FileInputStream fis = new FileInputStream ( file ) ) {
tftp . sendFile ( lr_9 , TFTP . BINARY_MODE , fis , lr_4 , SERVER_PORT ) ;
fail ( lr_10 ) ;
} catch ( final IOException e ) {
}
assertFalse ( lr_11 ,
new File ( serverDirectory , lr_9 ) . exists () ) ;
file . delete () ;
tftpS . shutdown () ;
}
