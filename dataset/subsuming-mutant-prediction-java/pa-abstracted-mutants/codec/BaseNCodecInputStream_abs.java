@Override
public int available () throws IOException {
return context . eof ? 0 : 1 ;
}
public boolean isStrictDecoding () {
return baseNCodec . isStrictDecoding () ;
}
@Override
public synchronized void mark ( final int readLimit ) {
}
@Override
public boolean markSupported () {
return false ;
}
@Override
public int read () throws IOException {
int r = read ( singleByte , 0 , 1 ) ;
while ( r == 0 ) {
r = read ( singleByte , 0 , 1 ) ;
}
if ( r > 0 ) {
final byte b = singleByte [ 0 ] ;
return b < 0 ? 256 + b : b ;
}
return EOF ;
}
@Override
public int read ( final byte array [] , final int offset , final int len ) throws IOException {
Objects . requireNonNull ( array , lr_1 ) ;
if ( offset < 0 || len < 0 ) {
throw new IndexOutOfBoundsException () ;
} else if ( offset > array . length || offset + len > array . length ) {
throw new IndexOutOfBoundsException () ;
} else if ( len == 0 ) {
return 0 ;
} else {
int readLen = 0 ;
while ( readLen == 0 ) {
if ( ! baseNCodec . hasData ( context ) ) {
final byte [] buf = new byte [ doEncode ? 4096 : 8192 ] ;
final int c = in . read ( buf ) ;
if ( doEncode ) {
baseNCodec . encode ( buf , 0 , c , context ) ;
} else {
baseNCodec . decode ( buf , 0 , c , context ) ;
}
}
readLen = baseNCodec . readResults ( array , offset , len , context ) ;
}
return readLen ;
}
}
@Override
public synchronized void reset () throws IOException {
throw new IOException ( lr_2 ) ;
}
@Override
public long skip ( final long n ) throws IOException {
if ( n < 0 ) {
throw new IllegalArgumentException ( lr_3 + n ) ;
}
final byte [] b = new byte [ 512 ] ;
long todo = n ;
while ( todo > 0 ) {
int len = ( int ) Math . min ( b . length , todo ) ;
len = this . read ( b , 0 , len ) ;
if ( len == EOF ) {
break;
}
todo -= len ;
}
return n - todo ;
}
