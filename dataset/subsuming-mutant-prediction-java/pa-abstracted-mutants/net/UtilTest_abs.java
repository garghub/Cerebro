@Test
public void testcloseQuietly () {
Util . closeQuietly ( ( Closeable ) null ) ;
Util . closeQuietly ( ( Socket ) null ) ;
}
@Test
public void testReader0 () throws Exception {
final long streamSize = 0 ;
final int bufferSize = 0 ;
Util . copyReader ( source , dest , bufferSize , streamSize , new CSL ( 1 , 1 , streamSize ) ) ;
}
@Test
public void testReader1 () throws Exception {
final long streamSize = 0 ;
final int bufferSize = 1 ;
Util . copyReader ( source , dest , bufferSize , streamSize , new CSL ( 1 , 1 , streamSize ) ) ;
}
@Test
public void testReader_1 () throws Exception {
final long streamSize = 0 ;
final int bufferSize = - 1 ;
Util . copyReader ( source , dest , bufferSize , streamSize , new CSL ( 1 , 1 , streamSize ) ) ;
}
@Test
public void testStream0 () throws Exception {
final long streamSize = 0 ;
final int bufferSize = 0 ;
Util . copyStream ( src , dst , bufferSize , streamSize , new CSL ( 1 , 1 , streamSize ) ) ;
}
@Test
public void testStream1 () throws Exception {
final long streamSize = 0 ;
final int bufferSize = 1 ;
Util . copyStream ( src , dst , bufferSize , streamSize , new CSL ( 1 , 1 , streamSize ) ) ;
}
@Test
public void testStream_1 () throws Exception {
final long streamSize = 0 ;
final int bufferSize = - 1 ;
Util . copyStream ( src , dst , bufferSize , streamSize , new CSL ( 1 , 1 , streamSize ) ) ;
}
@Test
public void testNET550_Reader () throws Exception {
final char [] buff = new char [] { 'a' , 'b' , 'c' , 'd' } ;
final int bufflen = buff . length ;
{
final Reader rdr = new CharArrayReader ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , 1 ) ;
Util . copyReader ( rdr , dest , 1 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final Reader rdr = new CharArrayReader ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , 2 ) ;
Util . copyReader ( rdr , dest , 2 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final Reader rdr = new CharArrayReader ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , bufflen ) ;
Util . copyReader ( rdr , dest , 20 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final Reader rdr = new CharArrayReader ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , bufflen ) ;
Util . copyReader ( rdr , dest , - 1 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final Reader rdr = new CharArrayReader ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , bufflen ) ;
Util . copyReader ( rdr , dest , 0 , 0 , listener ) ;
listener . checkExpected () ;
}
}
@Test
public void testNET550_Stream () throws Exception {
final byte [] buff = new byte [] { 'a' , 'b' , 'c' , 'd' } ;
final int bufflen = buff . length ;
{
final InputStream is = new ByteArrayInputStream ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , 1 ) ;
Util . copyStream ( is , dst , 1 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final InputStream is = new ByteArrayInputStream ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , 2 ) ;
Util . copyStream ( is , dst , 2 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final InputStream is = new ByteArrayInputStream ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , bufflen ) ;
Util . copyStream ( is , dst , 20 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final InputStream is = new ByteArrayInputStream ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , bufflen ) ;
Util . copyStream ( is , dst , - 1 , 0 , listener ) ;
listener . checkExpected () ;
}
{
final InputStream is = new ByteArrayInputStream ( buff ) ;
final CSLtotal listener = new CSLtotal ( bufflen , bufflen ) ;
Util . copyStream ( is , dst , 0 , 0 , listener ) ;
listener . checkExpected () ;
}
}
@Override
public void bytesTransferred ( final CopyStreamEvent event ) {
}
@Override
public void bytesTransferred ( final long totalBytesTransferred , final int bytesTransferred , final long streamSize ) {
Assert . assertEquals ( lr_1 , expectedTotal , totalBytesTransferred ) ;
Assert . assertEquals ( lr_2 , expectedSize , streamSize ) ;
Assert . assertEquals ( lr_3 , expectedBytes , bytesTransferred ) ;
}
@Override
public void bytesTransferred ( final CopyStreamEvent event ) {
}
@Override
public void bytesTransferred ( final long totalBytesTransferred , final int bytesTransferred , final long streamSize ) {
Assert . assertEquals ( lr_3 , expectedBytes , bytesTransferred ) ;
this . totalBytesTransferredTotal = totalBytesTransferred ;
this . bytesTransferredTotal += bytesTransferred ;
}
void checkExpected () {
Assert . assertEquals ( lr_4 , expectedTotal , totalBytesTransferredTotal ) ;
Assert . assertEquals ( lr_5 , totalBytesTransferredTotal , bytesTransferredTotal ) ;
}
