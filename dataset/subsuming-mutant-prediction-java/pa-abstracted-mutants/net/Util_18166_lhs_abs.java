public static long copyStream ( final InputStream source , final OutputStream dest ,
final int bufferSize , final long streamSize ,
final CopyStreamListener listener ,
final boolean flush )
throws CopyStreamException
{
int numBytes ;
long total = 0 ;
final byte [] buffer = new byte [ bufferSize > 0 ? bufferSize : DEFAULT_COPY_BUFFER_SIZE ] ;
try
{
while ( ( numBytes = source . read ( buffer ) ) != - 1 )
{
if ( numBytes == 0 )
{
final int singleByte = source . read () ;
if ( singleByte < 0 ) {
break;
}
dest . write ( singleByte ) ;
if( flush ) {
dest . flush () ;
}
++ total ;
if ( listener != null ) {
listener . bytesTransferred ( total , 1 , streamSize ) ;
}
continue;
}
dest . write ( buffer , 0 , numBytes ) ;
if( flush ) {
dest . flush () ;
}
total += numBytes ;
if ( listener != null ) {
listener . bytesTransferred ( total , numBytes , streamSize ) ;
}
}
}
catch ( final IOException e )
{
throw new CopyStreamException ( lr_1 ,
total , e ) ;
}
return total ; MST[rv.UOI1Mutator]MSP[]
}
public static long copyStream ( final InputStream source , final OutputStream dest ,
final int bufferSize , final long streamSize ,
final CopyStreamListener listener )
throws CopyStreamException
{
return copyStream ( source , dest , bufferSize , streamSize , listener ,
true ) ;
}
public static long copyStream ( final InputStream source , final OutputStream dest ,
final int bufferSize )
throws CopyStreamException
{
return copyStream ( source , dest , bufferSize ,
CopyStreamEvent . UNKNOWN_STREAM_SIZE , null ) ;
}
public static long copyStream ( final InputStream source , final OutputStream dest )
throws CopyStreamException
{
return copyStream ( source , dest , DEFAULT_COPY_BUFFER_SIZE ) ;
}
public static long copyReader ( final Reader source , final Writer dest ,
final int bufferSize , final long streamSize ,
final CopyStreamListener listener )
throws CopyStreamException
{
int numChars ;
long total = 0 ;
final char [] buffer = new char [ bufferSize > 0 ? bufferSize : DEFAULT_COPY_BUFFER_SIZE ] ;
try
{
while ( ( numChars = source . read ( buffer ) ) != - 1 )
{
if ( numChars == 0 )
{
final int singleChar = source . read () ;
if ( singleChar < 0 ) {
break;
}
dest . write ( singleChar ) ;
dest . flush () ;
++ total ;
if ( listener != null ) {
listener . bytesTransferred ( total , 1 , streamSize ) ;
}
continue;
}
dest . write ( buffer , 0 , numChars ) ;
dest . flush () ;
total += numChars ;
if ( listener != null ) {
listener . bytesTransferred ( total , numChars , streamSize ) ;
}
}
}
catch ( final IOException e )
{
throw new CopyStreamException ( lr_1 ,
total , e ) ;
}
return total ;
}
public static long copyReader ( final Reader source , final Writer dest ,
final int bufferSize )
throws CopyStreamException
{
return copyReader ( source , dest , bufferSize ,
CopyStreamEvent . UNKNOWN_STREAM_SIZE , null ) ;
}
public static long copyReader ( final Reader source , final Writer dest )
throws CopyStreamException
{
return copyReader ( source , dest , DEFAULT_COPY_BUFFER_SIZE ) ;
}
public static void closeQuietly ( final Closeable closeable ) {
if ( closeable != null ) {
try {
closeable . close () ;
} catch ( final IOException e ) {
}
}
}
public static void closeQuietly ( final Socket socket ) {
if ( socket != null ) {
try {
socket . close () ;
} catch ( final IOException e ) {
}
}
}
