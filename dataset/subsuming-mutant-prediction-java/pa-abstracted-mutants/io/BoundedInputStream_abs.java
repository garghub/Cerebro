@Override
public int read () throws IOException {
if ( max >= 0 && pos >= max ) {
return EOF ;
}
final int result = in . read () ;
pos ++ ;
return result ;
}
@Override
public int read ( final byte [] b ) throws IOException {
return this . read ( b , 0 , b . length ) ;
}
@Override
public int read ( final byte [] b , final int off , final int len ) throws IOException {
if ( max >= 0 && pos >= max ) {
return EOF ;
}
final long maxRead = max >= 0 ? Math . min ( len , max - pos ) : len ;
final int bytesRead = in . read ( b , off , ( int ) maxRead ) ;
if ( bytesRead == EOF ) {
return EOF ;
}
pos += bytesRead ;
return bytesRead ;
}
@Override
public long skip ( final long n ) throws IOException {
final long toSkip = max >= 0 ? Math . min ( n , max - pos ) : n ;
final long skippedBytes = in . skip ( toSkip ) ;
pos += skippedBytes ;
return skippedBytes ;
}
@Override
public int available () throws IOException {
if ( max >= 0 && pos >= max ) {
return 0 ;
}
return in . available () ;
}
@Override
public String toString () {
return in . toString () ;
}
@Override
public void close () throws IOException {
if ( propagateClose ) {
in . close () ;
}
}
@Override
public synchronized void reset () throws IOException {
in . reset () ;
pos = mark ;
}
@Override
public synchronized void mark ( final int readlimit ) {
in . mark ( readlimit ) ;
mark = pos ;
}
@Override
public boolean markSupported () {
return in . markSupported () ;
}
public boolean isPropagateClose () {
return propagateClose ;
}
public void setPropagateClose ( final boolean propagateClose ) {
this . propagateClose = propagateClose ;
}
