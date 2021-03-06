private void needNewBuffer ( final int newcount ) {
if ( currentBufferIndex < buffers . size () - 1 ) {
filledBufferSum += currentBuffer . length ;
currentBufferIndex ++ ;
currentBuffer = buffers . get ( currentBufferIndex ) ;
} else {
int newBufferSize ;
if ( currentBuffer == null ) {
newBufferSize = newcount ;
filledBufferSum = 0 ;
} else {
newBufferSize = Math . max (
currentBuffer . length << 1 ,
newcount - filledBufferSum ) ;
filledBufferSum += currentBuffer . length ;
}
currentBufferIndex ++ ;
currentBuffer = new byte [ newBufferSize ] ;
buffers . add ( currentBuffer ) ;
}
}
@Override
public void write ( final byte [] b , final int off , final int len ) {
if ( ( off < 0 )
|| ( off > b . length )
|| ( len < 0 )
|| ( ( off + len ) > b . length )
|| ( ( off + len ) < 0 ) ) {
throw new IndexOutOfBoundsException () ;
} else if ( len == 0 ) {
return;
}
synchronized ( this ) {
final int newcount = count + len ;
int remaining = len ;
int inBufferPos = count - filledBufferSum ;
while ( remaining > 0 ) {
final int part = Math . min ( remaining , currentBuffer . length - inBufferPos ) ;
System . arraycopy ( b , off + len - remaining , currentBuffer , inBufferPos , part ) ;
remaining -= part ;
if ( remaining > 0 ) {
needNewBuffer ( newcount ) ;
inBufferPos = 0 ;
}
}
count = newcount ;
}
}
@Override
public synchronized void write ( final int b ) {
int inBufferPos = count - filledBufferSum ;
if ( inBufferPos == currentBuffer . length ) {
needNewBuffer ( count + 1 ) ;
inBufferPos = 0 ;
}
currentBuffer [ inBufferPos ] = ( byte ) b ;
count ++ ;
}
public synchronized int write ( final InputStream in ) throws IOException {
int readCount = 0 ;
int inBufferPos = count - filledBufferSum ;
int n = in . read ( currentBuffer , inBufferPos , currentBuffer . length - inBufferPos ) ;
while ( n != EOF ) {
readCount += n ;
inBufferPos += n ;
count += n ;
if ( inBufferPos == currentBuffer . length ) {
needNewBuffer ( currentBuffer . length ) ;
inBufferPos = 0 ;
}
n = in . read ( currentBuffer , inBufferPos , currentBuffer . length - inBufferPos ) ;
}
return readCount ;
}
public synchronized int size () {
return count ;
}
@Override
public void close () throws IOException {
}
public synchronized void reset () {
count = 0 ;
filledBufferSum = 0 ;
currentBufferIndex = 0 ;
if ( reuseBuffers ) {
currentBuffer = buffers . get ( currentBufferIndex ) ;
} else {
currentBuffer = null ;
final int size = buffers . get ( 0 ) . length ;
buffers . clear () ;
needNewBuffer ( size ) ;
reuseBuffers = true ;
}
}
public synchronized void writeTo ( final OutputStream out ) throws IOException {
int remaining = count ;
for ( final byte [] buf : buffers ) {
final int c = Math . min ( buf . length , remaining ) ;
out . write ( buf , 0 , c ) ;
remaining -= c ;
if ( remaining == 0 ) {
break;
}
}
}
public static InputStream toBufferedInputStream ( final InputStream input )
throws IOException {
return toBufferedInputStream ( input , 1024 ) ;
}
public static InputStream toBufferedInputStream ( final InputStream input , final int size )
throws IOException {
@SuppressWarnings ( lr_1 )
final ByteArrayOutputStream output = new ByteArrayOutputStream ( size ) ;
output . write ( input ) ;
return output . toInputStream () ;
}
public synchronized InputStream toInputStream () {
int remaining = count ;
if ( remaining == 0 ) {
return new ClosedInputStream () ;
}
final List < ByteArrayInputStream > list = new ArrayList <> ( buffers . size () ) ;
for ( final byte [] buf : buffers ) {
final int c = Math . min ( buf . length , remaining ) ;
list . add ( new ByteArrayInputStream ( buf , 0 , c ) ) ;
remaining -= c ;
if ( remaining == 0 ) {
break;
}
}
reuseBuffers = false ;
return new SequenceInputStream ( Collections . enumeration ( list ) ) ;
}
public synchronized byte [] toByteArray () {
int remaining = count ;
if ( remaining == 0 ) {
return EMPTY_BYTE_ARRAY ;
}
final byte newbuf [] = new byte [ remaining ] ;
int pos = 0 ;
for ( final byte [] buf : buffers ) {
final int c = Math . min ( buf . length , remaining ) ;
System . arraycopy ( buf , 0 , newbuf , pos , c ) ;
pos += c ;
remaining -= c ;
if ( remaining == 0 ) {
break;
}
}
return newbuf ;
}
@Override
@Deprecated
public String toString () {
return new String ( toByteArray () , Charset . defaultCharset () ) ;
}
public String toString ( final String enc ) throws UnsupportedEncodingException {
return new String ( toByteArray () , enc ) ;
}
public String toString ( final Charset charset ) {
return new String ( toByteArray () , charset ) ;
}
