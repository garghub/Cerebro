public static BufferedInputStream buffer ( final InputStream inputStream ) {
if ( inputStream == null ) {
throw new NullPointerException () ;
}
return inputStream instanceof BufferedInputStream ?
( BufferedInputStream ) inputStream : new BufferedInputStream ( inputStream ) ;
}
public static BufferedInputStream buffer ( final InputStream inputStream , final int size ) {
if ( inputStream == null ) {
throw new NullPointerException () ;
}
return inputStream instanceof BufferedInputStream ?
( BufferedInputStream ) inputStream : new BufferedInputStream ( inputStream , size ) ;
}
public static BufferedOutputStream buffer ( final OutputStream outputStream ) {
if ( outputStream == null ) {
throw new NullPointerException () ;
}
return outputStream instanceof BufferedOutputStream ?
( BufferedOutputStream ) outputStream : new BufferedOutputStream ( outputStream ) ;
}
public static BufferedOutputStream buffer ( final OutputStream outputStream , final int size ) {
if ( outputStream == null ) {
throw new NullPointerException () ;
}
return outputStream instanceof BufferedOutputStream ?
( BufferedOutputStream ) outputStream : new BufferedOutputStream ( outputStream , size ) ;
}
public static BufferedReader buffer ( final Reader reader ) {
return reader instanceof BufferedReader ? ( BufferedReader ) reader : new BufferedReader ( reader ) ;
}
public static BufferedReader buffer ( final Reader reader , final int size ) {
return reader instanceof BufferedReader ? ( BufferedReader ) reader : new BufferedReader ( reader , size ) ;
}
public static BufferedWriter buffer ( final Writer writer ) {
return writer instanceof BufferedWriter ? ( BufferedWriter ) writer : new BufferedWriter ( writer ) ;
}
public static BufferedWriter buffer ( final Writer writer , final int size ) {
return writer instanceof BufferedWriter ? ( BufferedWriter ) writer : new BufferedWriter ( writer , size ) ;
}
public static Writer writer ( final Appendable appendable ) {
Objects . requireNonNull ( appendable , lr_1 ) ;
if ( appendable instanceof Writer ) {
return ( Writer ) appendable ;
}
if ( appendable instanceof StringBuilder ) {
return new StringBuilderWriter ( ( StringBuilder ) appendable ) ;
}
return new AppendableWriter <> ( appendable ) ;
}
public static void close ( final URLConnection conn ) {
if ( conn instanceof HttpURLConnection ) {
( ( HttpURLConnection ) conn ) . disconnect () ;
}
}
@Deprecated
public static void closeQuietly ( final Closeable closeable ) {
try {
if ( closeable != null ) {
closeable . close () ;
}
} catch ( final IOException ioe ) {
}
}
@Deprecated
public static void closeQuietly ( final Closeable ... closeables ) {
if ( closeables == null ) {
return;
}
for ( final Closeable closeable : closeables ) {
closeQuietly ( closeable ) ;
}
}
@Deprecated
public static void closeQuietly ( final InputStream input ) {
closeQuietly ( ( Closeable ) input ) ;
}
@Deprecated
public static void closeQuietly ( final OutputStream output ) {
closeQuietly ( ( Closeable ) output ) ;
}
@Deprecated
public static void closeQuietly ( final Reader input ) {
closeQuietly ( ( Closeable ) input ) ;
}
@Deprecated
public static void closeQuietly ( final Selector selector ) {
if ( selector != null ) {
try {
selector . close () ;
} catch ( final IOException ioe ) {
}
}
}
@Deprecated
public static void closeQuietly ( final ServerSocket sock ) {
if ( sock != null ) {
try {
sock . close () ;
} catch ( final IOException ioe ) {
}
}
}
@Deprecated
public static void closeQuietly ( final Socket sock ) {
if ( sock != null ) {
try {
sock . close () ;
} catch ( final IOException ioe ) {
}
}
}
@Deprecated
public static void closeQuietly ( final Writer output ) {
closeQuietly ( ( Closeable ) output ) ;
}
public static boolean contentEquals ( InputStream input1 , InputStream input2 )
throws IOException {
if ( input1 == input2 ) {
return true ;
}
if ( ! ( input1 instanceof BufferedInputStream ) ) {
input1 = new BufferedInputStream ( input1 ) ;
}
if ( ! ( input2 instanceof BufferedInputStream ) ) {
input2 = new BufferedInputStream ( input2 ) ;
}
int ch = input1 . read () ;
while ( EOF != ch ) {
final int ch2 = input2 . read () ;
if ( ch != ch2 ) {
return false ;
}
ch = input1 . read () ;
}
final int ch2 = input2 . read () ;
return ch2 == EOF ;
}
public static boolean contentEquals ( Reader input1 , Reader input2 )
throws IOException {
if ( input1 == input2 ) {
return true ;
}
input1 = toBufferedReader ( input1 ) ;
input2 = toBufferedReader ( input2 ) ;
int ch = input1 . read () ;
while ( EOF != ch ) {
final int ch2 = input2 . read () ;
if ( ch != ch2 ) {
return false ;
}
ch = input1 . read () ;
}
final int ch2 = input2 . read () ;
return ch2 == EOF ;
}
public static boolean contentEqualsIgnoreEOL ( final Reader input1 , final Reader input2 )
throws IOException {
if ( input1 == input2 ) {
return true ;
}
final BufferedReader br1 = toBufferedReader ( input1 ) ;
final BufferedReader br2 = toBufferedReader ( input2 ) ;
String line1 = br1 . readLine () ;
String line2 = br2 . readLine () ;
while ( line1 != null && line2 != null && line1 . equals ( line2 ) ) {
line1 = br1 . readLine () ;
line2 = br2 . readLine () ;
}
return line1 == null ? line2 == null ? true : false : line1 . equals ( line2 ) ;
}
public static int copy ( final InputStream input , final OutputStream output ) throws IOException {
final long count = copyLarge ( input , output ) ;
if ( count > Integer . MAX_VALUE ) {
return - 1 ;
}
return ( int ) count ;
}
public static long copy ( final InputStream input , final OutputStream output , final int bufferSize )
throws IOException {
return copyLarge ( input , output , new byte [ bufferSize ] ) ;
}
@Deprecated
public static void copy ( final InputStream input , final Writer output )
throws IOException {
copy ( input , output , Charset . defaultCharset () ) ;
}
public static void copy ( final InputStream input , final Writer output , final Charset inputEncoding )
throws IOException {
final InputStreamReader in = new InputStreamReader ( input , Charsets . toCharset ( inputEncoding ) ) ;
copy ( in , output ) ;
}
public static void copy ( final InputStream input , final Writer output , final String inputEncoding )
throws IOException {
copy ( input , output , Charsets . toCharset ( inputEncoding ) ) ;
}
@Deprecated
public static void copy ( final Reader input , final OutputStream output )
throws IOException {
copy ( input , output , Charset . defaultCharset () ) ;
}
public static void copy ( final Reader input , final OutputStream output , final Charset outputEncoding )
throws IOException {
final OutputStreamWriter out = new OutputStreamWriter ( output , Charsets . toCharset ( outputEncoding ) ) ;
copy ( input , out ) ;
out . flush () ;
}
public static void copy ( final Reader input , final OutputStream output , final String outputEncoding )
throws IOException {
copy ( input , output , Charsets . toCharset ( outputEncoding ) ) ;
}
public static long copy ( final Reader input , final Appendable output ) throws IOException {
return copy ( input , output , CharBuffer . allocate ( DEFAULT_BUFFER_SIZE ) ) ;
}
public static int copy ( final Reader input , final Writer output ) throws IOException {
final long count = copyLarge ( input , output ) ;
if ( count > Integer . MAX_VALUE ) {
return - 1 ;
}
return ( int ) count ;
}
public static long copyLarge ( final InputStream input , final OutputStream output )
throws IOException {
return copy ( input , output , DEFAULT_BUFFER_SIZE ) ;
}
public static long copyLarge ( final InputStream input , final OutputStream output , final byte [] buffer )
throws IOException {
long count = 0 ;
int n ;
while ( EOF != ( n = input . read ( buffer ) ) ) {
output . write ( buffer , 0 , n ) ;
count += n ;
}
return count ;
}
public static long copyLarge ( final InputStream input , final OutputStream output , final long inputOffset ,
final long length ) throws IOException {
return copyLarge ( input , output , inputOffset , length , new byte [ DEFAULT_BUFFER_SIZE ] ) ;
}
public static long copyLarge ( final InputStream input , final OutputStream output ,
final long inputOffset , final long length , final byte [] buffer ) throws IOException {
if ( inputOffset > 0 ) {
skipFully ( input , inputOffset ) ;
}
if ( length == 0 ) {
return 0 ;
}
final int bufferLength = buffer . length ;
int bytesToRead = bufferLength ;
if ( length > 0 && length < bufferLength ) {
bytesToRead = ( int ) length ;
}
int read ;
long totalRead = 0 ;
while ( bytesToRead > 0 && EOF != ( read = input . read ( buffer , 0 , bytesToRead ) ) ) {
output . write ( buffer , 0 , read ) ;
totalRead += read ;
if ( length > 0 ) {
bytesToRead = ( int ) Math . min ( length - totalRead , bufferLength ) ;
}
}
return totalRead ;
}
public static long copy ( final Reader input , final Appendable output , final CharBuffer buffer ) throws IOException {
long count = 0 ;
int n ;
while ( EOF != ( n = input . read ( buffer ) ) ) {
buffer . flip () ;
output . append ( buffer , 0 , n ) ;
count += n ;
}
return count ;
}
public static long copyLarge ( final Reader input , final Writer output ) throws IOException {
return copyLarge ( input , output , new char [ DEFAULT_BUFFER_SIZE ] ) ;
}
public static long copyLarge ( final Reader input , final Writer output , final char [] buffer ) throws IOException {
long count = 0 ;
int n ;
while ( EOF != ( n = input . read ( buffer ) ) ) {
output . write ( buffer , 0 , n ) ;
count += n ;
}
return count ;
}
public static long copyLarge ( final Reader input , final Writer output , final long inputOffset , final long length )
throws IOException {
return copyLarge ( input , output , inputOffset , length , new char [ DEFAULT_BUFFER_SIZE ] ) ;
}
public static long copyLarge ( final Reader input , final Writer output , final long inputOffset , final long length ,
final char [] buffer )
throws IOException {
if ( inputOffset > 0 ) {
skipFully ( input , inputOffset ) ;
}
if ( length == 0 ) {
return 0 ;
}
int bytesToRead = buffer . length ;
if ( length > 0 && length < buffer . length ) {
bytesToRead = ( int ) length ;
}
int read ;
long totalRead = 0 ;
while ( bytesToRead > 0 && EOF != ( read = input . read ( buffer , 0 , bytesToRead ) ) ) {
output . write ( buffer , 0 , read ) ;
totalRead += read ;
if ( length > 0 ) {
bytesToRead = ( int ) Math . min ( length - totalRead , buffer . length ) ;
}
}
return totalRead ;
}
public static LineIterator lineIterator ( final InputStream input , final Charset encoding ) throws IOException {
return new LineIterator ( new InputStreamReader ( input , Charsets . toCharset ( encoding ) ) ) ;
}
public static LineIterator lineIterator ( final InputStream input , final String encoding ) throws IOException {
return lineIterator ( input , Charsets . toCharset ( encoding ) ) ;
}
public static LineIterator lineIterator ( final Reader reader ) {
return new LineIterator ( reader ) ;
}
public static int read ( final InputStream input , final byte [] buffer ) throws IOException {
return read ( input , buffer , 0 , buffer . length ) ;
}
public static int read ( final InputStream input , final byte [] buffer , final int offset , final int length )
throws IOException {
if ( length < 0 ) {
throw new IllegalArgumentException ( lr_2 + length ) ;
}
int remaining = length ;
while ( remaining > 0 ) {
final int location = length - remaining ;
final int count = input . read ( buffer , offset + location , remaining ) ;
if ( EOF == count ) {
break;
}
remaining -= count ;
}
return length - remaining ;
}
public static int read ( final ReadableByteChannel input , final ByteBuffer buffer ) throws IOException {
final int length = buffer . remaining () ;
while ( buffer . remaining () > 0 ) {
final int count = input . read ( buffer ) ;
if ( EOF == count ) {
break;
}
}
return length - buffer . remaining () ;
}
public static int read ( final Reader input , final char [] buffer ) throws IOException {
return read ( input , buffer , 0 , buffer . length ) ;
}
public static int read ( final Reader input , final char [] buffer , final int offset , final int length )
throws IOException {
if ( length < 0 ) {
throw new IllegalArgumentException ( lr_2 + length ) ;
}
int remaining = length ;
while ( remaining > 0 ) {
final int location = length - remaining ;
final int count = input . read ( buffer , offset + location , remaining ) ;
if ( EOF == count ) {
break;
}
remaining -= count ;
}
return length - remaining ;
}
public static void readFully ( final InputStream input , final byte [] buffer ) throws IOException {
readFully ( input , buffer , 0 , buffer . length ) ;
}
public static void readFully ( final InputStream input , final byte [] buffer , final int offset , final int length )
throws IOException {
final int actual = read ( input , buffer , offset , length ) ;
if ( actual != length ) {
throw new EOFException ( lr_3 + length + lr_4 + actual ) ;
}
}
public static byte [] readFully ( final InputStream input , final int length ) throws IOException {
final byte [] buffer = new byte [ length ] ;
readFully ( input , buffer , 0 , buffer . length ) ;
return buffer ;
}
public static void readFully ( final ReadableByteChannel input , final ByteBuffer buffer ) throws IOException {
final int expected = buffer . remaining () ;
final int actual = read ( input , buffer ) ; MST[NonVoidMethodCallMutator]MSP[]
if ( actual != expected ) {
throw new EOFException ( lr_3 + expected + lr_4 + actual ) ;
}
}
public static void readFully ( final Reader input , final char [] buffer ) throws IOException {
readFully ( input , buffer , 0 , buffer . length ) ;
}
public static void readFully ( final Reader input , final char [] buffer , final int offset , final int length )
throws IOException {
final int actual = read ( input , buffer , offset , length ) ;
if ( actual != length ) {
throw new EOFException ( lr_3 + length + lr_4 + actual ) ;
}
}
@Deprecated
public static List < String > readLines ( final InputStream input ) throws IOException {
return readLines ( input , Charset . defaultCharset () ) ;
}
public static List < String > readLines ( final InputStream input , final Charset encoding ) throws IOException {
final InputStreamReader reader = new InputStreamReader ( input , Charsets . toCharset ( encoding ) ) ;
return readLines ( reader ) ;
}
public static List < String > readLines ( final InputStream input , final String encoding ) throws IOException {
return readLines ( input , Charsets . toCharset ( encoding ) ) ;
}
public static List < String > readLines ( final Reader input ) throws IOException {
final BufferedReader reader = toBufferedReader ( input ) ;
final List < String > list = new ArrayList <> () ;
String line = reader . readLine () ;
while ( line != null ) {
list . add ( line ) ;
line = reader . readLine () ;
}
return list ;
}
public static byte [] resourceToByteArray ( final String name ) throws IOException {
return resourceToByteArray ( name , null ) ;
}
public static byte [] resourceToByteArray ( final String name , final ClassLoader classLoader ) throws IOException {
return toByteArray ( resourceToURL ( name , classLoader ) ) ;
}
public static String resourceToString ( final String name , final Charset encoding ) throws IOException {
return resourceToString ( name , encoding , null ) ;
}
public static String resourceToString ( final String name , final Charset encoding , final ClassLoader classLoader ) throws IOException {
return toString ( resourceToURL ( name , classLoader ) , encoding ) ;
}
public static URL resourceToURL ( final String name ) throws IOException {
return resourceToURL ( name , null ) ;
}
public static URL resourceToURL ( final String name , final ClassLoader classLoader ) throws IOException {
final URL resource = classLoader == null ? IOUtils . class . getResource ( name ) : classLoader . getResource ( name ) ;
if ( resource == null ) {
throw new IOException ( lr_5 + name ) ;
}
return resource ;
}
public static long skip ( final InputStream input , final long toSkip ) throws IOException {
if ( toSkip < 0 ) {
throw new IllegalArgumentException ( lr_6 + toSkip ) ;
}
if ( SKIP_BYTE_BUFFER == null ) {
SKIP_BYTE_BUFFER = new byte [ SKIP_BUFFER_SIZE ] ;
}
long remain = toSkip ;
while ( remain > 0 ) {
final long n = input . read ( SKIP_BYTE_BUFFER , 0 , ( int ) Math . min ( remain , SKIP_BUFFER_SIZE ) ) ;
if ( n < 0 ) {
break;
}
remain -= n ;
}
return toSkip - remain ;
}
public static long skip ( final ReadableByteChannel input , final long toSkip ) throws IOException {
if ( toSkip < 0 ) {
throw new IllegalArgumentException ( lr_6 + toSkip ) ;
}
final ByteBuffer skipByteBuffer = ByteBuffer . allocate ( ( int ) Math . min ( toSkip , SKIP_BUFFER_SIZE ) ) ;
long remain = toSkip ;
while ( remain > 0 ) {
skipByteBuffer . position ( 0 ) ;
skipByteBuffer . limit ( ( int ) Math . min ( remain , SKIP_BUFFER_SIZE ) ) ;
final int n = input . read ( skipByteBuffer ) ;
if ( n == EOF ) {
break;
}
remain -= n ;
}
return toSkip - remain ;
}
public static long skip ( final Reader input , final long toSkip ) throws IOException {
if ( toSkip < 0 ) {
throw new IllegalArgumentException ( lr_6 + toSkip ) ;
}
if ( SKIP_CHAR_BUFFER == null ) {
SKIP_CHAR_BUFFER = new char [ SKIP_BUFFER_SIZE ] ;
}
long remain = toSkip ;
while ( remain > 0 ) {
final long n = input . read ( SKIP_CHAR_BUFFER , 0 , ( int ) Math . min ( remain , SKIP_BUFFER_SIZE ) ) ;
if ( n < 0 ) {
break;
}
remain -= n ;
}
return toSkip - remain ;
}
public static void skipFully ( final InputStream input , final long toSkip ) throws IOException {
if ( toSkip < 0 ) {
throw new IllegalArgumentException ( lr_7 + toSkip ) ;
}
final long skipped = skip ( input , toSkip ) ;
if ( skipped != toSkip ) {
throw new EOFException ( lr_8 + toSkip + lr_4 + skipped ) ;
}
}
public static void skipFully ( final ReadableByteChannel input , final long toSkip ) throws IOException {
if ( toSkip < 0 ) {
throw new IllegalArgumentException ( lr_7 + toSkip ) ;
}
final long skipped = skip ( input , toSkip ) ;
if ( skipped != toSkip ) {
throw new EOFException ( lr_8 + toSkip + lr_4 + skipped ) ;
}
}
public static void skipFully ( final Reader input , final long toSkip ) throws IOException {
final long skipped = skip ( input , toSkip ) ;
if ( skipped != toSkip ) {
throw new EOFException ( lr_9 + toSkip + lr_4 + skipped ) ;
}
}
public static InputStream toBufferedInputStream ( final InputStream input ) throws IOException {
return ByteArrayOutputStream . toBufferedInputStream ( input ) ;
}
public static InputStream toBufferedInputStream ( final InputStream input , final int size ) throws IOException {
return ByteArrayOutputStream . toBufferedInputStream ( input , size ) ;
}
public static BufferedReader toBufferedReader ( final Reader reader ) {
return reader instanceof BufferedReader ? ( BufferedReader ) reader : new BufferedReader ( reader ) ;
}
public static BufferedReader toBufferedReader ( final Reader reader , final int size ) {
return reader instanceof BufferedReader ? ( BufferedReader ) reader : new BufferedReader ( reader , size ) ;
}
public static byte [] toByteArray ( final InputStream input ) throws IOException {
try ( final ByteArrayOutputStream output = new ByteArrayOutputStream () ) {
copy ( input , output ) ;
return output . toByteArray () ;
}
}
public static byte [] toByteArray ( final InputStream input , final int size ) throws IOException {
if ( size < 0 ) {
throw new IllegalArgumentException ( lr_10 + size ) ;
}
if ( size == 0 ) {
return new byte [ 0 ] ;
}
final byte [] data = new byte [ size ] ;
int offset = 0 ;
int read ;
while ( offset < size && ( read = input . read ( data , offset , size - offset ) ) != EOF ) {
offset += read ;
}
if ( offset != size ) {
throw new IOException ( lr_11 + offset + lr_12 + size ) ;
}
return data ;
}
public static byte [] toByteArray ( final InputStream input , final long size ) throws IOException {
if ( size > Integer . MAX_VALUE ) {
throw new IllegalArgumentException ( lr_13 + size ) ;
}
return toByteArray ( input , ( int ) size ) ;
}
@Deprecated
public static byte [] toByteArray ( final Reader input ) throws IOException {
return toByteArray ( input , Charset . defaultCharset () ) ;
}
public static byte [] toByteArray ( final Reader input , final Charset encoding ) throws IOException {
try ( final ByteArrayOutputStream output = new ByteArrayOutputStream () ) {
copy ( input , output , encoding ) ;
return output . toByteArray () ;
}
}
public static byte [] toByteArray ( final Reader input , final String encoding ) throws IOException {
return toByteArray ( input , Charsets . toCharset ( encoding ) ) ;
}
@Deprecated
public static byte [] toByteArray ( final String input ) throws IOException {
return input . getBytes ( Charset . defaultCharset () ) ;
}
public static byte [] toByteArray ( final URI uri ) throws IOException {
return IOUtils . toByteArray ( uri . toURL () ) ;
}
public static byte [] toByteArray ( final URL url ) throws IOException {
final URLConnection conn = url . openConnection () ;
try {
return IOUtils . toByteArray ( conn ) ;
} finally {
close ( conn ) ;
}
}
public static byte [] toByteArray ( final URLConnection urlConn ) throws IOException {
try ( InputStream inputStream = urlConn . getInputStream () ) {
return IOUtils . toByteArray ( inputStream ) ;
}
}
@Deprecated
public static char [] toCharArray ( final InputStream is ) throws IOException {
return toCharArray ( is , Charset . defaultCharset () ) ;
}
public static char [] toCharArray ( final InputStream is , final Charset encoding )
throws IOException {
final CharArrayWriter output = new CharArrayWriter () ;
copy ( is , output , encoding ) ;
return output . toCharArray () ;
}
public static char [] toCharArray ( final InputStream is , final String encoding ) throws IOException {
return toCharArray ( is , Charsets . toCharset ( encoding ) ) ;
}
public static char [] toCharArray ( final Reader input ) throws IOException {
final CharArrayWriter sw = new CharArrayWriter () ;
copy ( input , sw ) ;
return sw . toCharArray () ;
}
@Deprecated
public static InputStream toInputStream ( final CharSequence input ) {
return toInputStream ( input , Charset . defaultCharset () ) ;
}
public static InputStream toInputStream ( final CharSequence input , final Charset encoding ) {
return toInputStream ( input . toString () , encoding ) ;
}
public static InputStream toInputStream ( final CharSequence input , final String encoding ) throws IOException {
return toInputStream ( input , Charsets . toCharset ( encoding ) ) ;
}
@Deprecated
public static InputStream toInputStream ( final String input ) {
return toInputStream ( input , Charset . defaultCharset () ) ;
}
public static InputStream toInputStream ( final String input , final Charset encoding ) {
return new ByteArrayInputStream ( input . getBytes ( Charsets . toCharset ( encoding ) ) ) ;
}
public static InputStream toInputStream ( final String input , final String encoding ) throws IOException {
final byte [] bytes = input . getBytes ( Charsets . toCharset ( encoding ) ) ;
return new ByteArrayInputStream ( bytes ) ;
}
@Deprecated
public static String toString ( final byte [] input ) throws IOException {
return new String ( input , Charset . defaultCharset () ) ;
}
public static String toString ( final byte [] input , final String encoding ) throws IOException {
return new String ( input , Charsets . toCharset ( encoding ) ) ;
}
@Deprecated
public static String toString ( final InputStream input ) throws IOException {
return toString ( input , Charset . defaultCharset () ) ;
}
public static String toString ( final InputStream input , final Charset encoding ) throws IOException {
try ( final StringBuilderWriter sw = new StringBuilderWriter () ) {
copy ( input , sw , encoding ) ;
return sw . toString () ;
}
}
public static String toString ( final InputStream input , final String encoding )
throws IOException {
return toString ( input , Charsets . toCharset ( encoding ) ) ;
}
public static String toString ( final Reader input ) throws IOException {
try ( final StringBuilderWriter sw = new StringBuilderWriter () ) {
copy ( input , sw ) ;
return sw . toString () ;
}
}
@Deprecated
public static String toString ( final URI uri ) throws IOException {
return toString ( uri , Charset . defaultCharset () ) ;
}
public static String toString ( final URI uri , final Charset encoding ) throws IOException {
return toString ( uri . toURL () , Charsets . toCharset ( encoding ) ) ;
}
public static String toString ( final URI uri , final String encoding ) throws IOException {
return toString ( uri , Charsets . toCharset ( encoding ) ) ;
}
@Deprecated
public static String toString ( final URL url ) throws IOException {
return toString ( url , Charset . defaultCharset () ) ;
}
public static String toString ( final URL url , final Charset encoding ) throws IOException {
try ( InputStream inputStream = url . openStream () ) {
return toString ( inputStream , encoding ) ;
}
}
public static String toString ( final URL url , final String encoding ) throws IOException {
return toString ( url , Charsets . toCharset ( encoding ) ) ;
}
public static void write ( final byte [] data , final OutputStream output )
throws IOException {
if ( data != null ) {
output . write ( data ) ;
}
}
@Deprecated
public static void write ( final byte [] data , final Writer output ) throws IOException {
write ( data , output , Charset . defaultCharset () ) ;
}
public static void write ( final byte [] data , final Writer output , final Charset encoding ) throws IOException {
if ( data != null ) {
output . write ( new String ( data , Charsets . toCharset ( encoding ) ) ) ;
}
}
public static void write ( final byte [] data , final Writer output , final String encoding ) throws IOException {
write ( data , output , Charsets . toCharset ( encoding ) ) ;
}
@Deprecated
public static void write ( final char [] data , final OutputStream output )
throws IOException {
write ( data , output , Charset . defaultCharset () ) ;
}
public static void write ( final char [] data , final OutputStream output , final Charset encoding ) throws IOException {
if ( data != null ) {
output . write ( new String ( data ) . getBytes ( Charsets . toCharset ( encoding ) ) ) ;
}
}
public static void write ( final char [] data , final OutputStream output , final String encoding )
throws IOException {
write ( data , output , Charsets . toCharset ( encoding ) ) ;
}
public static void write ( final char [] data , final Writer output ) throws IOException {
if ( data != null ) {
output . write ( data ) ;
}
}
@Deprecated
public static void write ( final CharSequence data , final OutputStream output )
throws IOException {
write ( data , output , Charset . defaultCharset () ) ;
}
public static void write ( final CharSequence data , final OutputStream output , final Charset encoding )
throws IOException {
if ( data != null ) {
write ( data . toString () , output , encoding ) ;
}
}
public static void write ( final CharSequence data , final OutputStream output , final String encoding )
throws IOException {
write ( data , output , Charsets . toCharset ( encoding ) ) ;
}
public static void write ( final CharSequence data , final Writer output ) throws IOException {
if ( data != null ) {
write ( data . toString () , output ) ;
}
}
@Deprecated
public static void write ( final String data , final OutputStream output )
throws IOException {
write ( data , output , Charset . defaultCharset () ) ;
}
public static void write ( final String data , final OutputStream output , final Charset encoding ) throws IOException {
if ( data != null ) {
output . write ( data . getBytes ( Charsets . toCharset ( encoding ) ) ) ;
}
}
public static void write ( final String data , final OutputStream output , final String encoding )
throws IOException {
write ( data , output , Charsets . toCharset ( encoding ) ) ;
}
public static void write ( final String data , final Writer output ) throws IOException {
if ( data != null ) {
output . write ( data ) ;
}
}
@Deprecated
public static void write ( final StringBuffer data , final OutputStream output )
throws IOException {
write ( data , output , ( String ) null ) ;
}
@Deprecated
public static void write ( final StringBuffer data , final OutputStream output , final String encoding )
throws IOException {
if ( data != null ) {
output . write ( data . toString () . getBytes ( Charsets . toCharset ( encoding ) ) ) ;
}
}
@Deprecated
public static void write ( final StringBuffer data , final Writer output )
throws IOException {
if ( data != null ) {
output . write ( data . toString () ) ;
}
}
public static void writeChunked ( final byte [] data , final OutputStream output )
throws IOException {
if ( data != null ) {
int bytes = data . length ;
int offset = 0 ;
while ( bytes > 0 ) {
final int chunk = Math . min ( bytes , DEFAULT_BUFFER_SIZE ) ;
output . write ( data , offset , chunk ) ;
bytes -= chunk ;
offset += chunk ;
}
}
}
public static void writeChunked ( final char [] data , final Writer output ) throws IOException {
if ( data != null ) {
int bytes = data . length ;
int offset = 0 ;
while ( bytes > 0 ) {
final int chunk = Math . min ( bytes , DEFAULT_BUFFER_SIZE ) ;
output . write ( data , offset , chunk ) ;
bytes -= chunk ;
offset += chunk ;
}
}
}
@Deprecated
public static void writeLines ( final Collection < ? > lines , final String lineEnding ,
final OutputStream output ) throws IOException {
writeLines ( lines , lineEnding , output , Charset . defaultCharset () ) ;
}
public static void writeLines ( final Collection < ? > lines , String lineEnding , final OutputStream output ,
final Charset encoding ) throws IOException {
if ( lines == null ) {
return;
}
if ( lineEnding == null ) {
lineEnding = LINE_SEPARATOR ;
}
final Charset cs = Charsets . toCharset ( encoding ) ;
for ( final Object line : lines ) {
if ( line != null ) {
output . write ( line . toString () . getBytes ( cs ) ) ;
}
output . write ( lineEnding . getBytes ( cs ) ) ;
}
}
public static void writeLines ( final Collection < ? > lines , final String lineEnding ,
final OutputStream output , final String encoding ) throws IOException {
writeLines ( lines , lineEnding , output , Charsets . toCharset ( encoding ) ) ;
}
public static void writeLines ( final Collection < ? > lines , String lineEnding ,
final Writer writer ) throws IOException {
if ( lines == null ) {
return;
}
if ( lineEnding == null ) {
lineEnding = LINE_SEPARATOR ;
}
for ( final Object line : lines ) {
if ( line != null ) {
writer . write ( line . toString () ) ;
}
writer . write ( lineEnding ) ;
}
}
public static int length ( final byte [] array ) {
return array == null ? 0 : array . length ;
}
public static int length ( final char [] array ) {
return array == null ? 0 : array . length ;
}
public static int length ( final CharSequence csq ) {
return csq == null ? 0 : csq . length () ;
}
public static int length ( final Object [] array ) {
return array == null ? 0 : array . length ;
}
