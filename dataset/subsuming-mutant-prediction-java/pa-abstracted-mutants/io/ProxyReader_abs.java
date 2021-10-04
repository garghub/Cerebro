@Override
public int read () throws IOException {
try {
beforeRead ( 1 ) ;
final int c = in . read () ;
afterRead ( c != EOF ? 1 : EOF ) ;
return c ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return EOF ;
}
}
@Override
public int read ( final char [] chr ) throws IOException {
try {
beforeRead ( IOUtils . length ( chr ) ) ;
final int n = in . read ( chr ) ;
afterRead ( n ) ;
return n ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return EOF ;
}
}
@Override
public int read ( final char [] chr , final int st , final int len ) throws IOException {
try {
beforeRead ( len ) ;
final int n = in . read ( chr , st , len ) ;
afterRead ( n ) ;
return n ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return EOF ;
}
}
@Override
public int read ( final CharBuffer target ) throws IOException {
try {
beforeRead ( IOUtils . length ( target ) ) ;
final int n = in . read ( target ) ;
afterRead ( n ) ;
return n ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return EOF ;
}
}
@Override
public long skip ( final long ln ) throws IOException {
try {
return in . skip ( ln ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return 0 ;
}
}
@Override
public boolean ready () throws IOException {
try {
return in . ready () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return false ;
}
}
@Override
public void close () throws IOException {
try {
in . close () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public synchronized void mark ( final int idx ) throws IOException {
try {
in . mark ( idx ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public synchronized void reset () throws IOException {
try {
in . reset () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public boolean markSupported () {
return in . markSupported () ;
}
protected void beforeRead ( final int n ) throws IOException {
}
protected void afterRead ( final int n ) throws IOException {
}
protected void handleIOException ( final IOException e ) throws IOException {
throw e ;
}
