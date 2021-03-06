@Override
public int read () throws IOException {
try {
beforeRead ( 1 ) ;
final int b = in . read () ;
afterRead ( b != EOF ? 1 : EOF ) ;
return b ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return EOF ;
}
}
@Override
public int read ( final byte [] bts ) throws IOException {
try {
beforeRead ( IOUtils . length ( bts ) ) ;
final int n = in . read ( bts ) ;
afterRead ( n ) ;
return n ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return EOF ;
}
}
@Override
public int read ( final byte [] bts , final int off , final int len ) throws IOException {
try {
beforeRead ( len ) ;
final int n = in . read ( bts , off , len ) ;
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
public int available () throws IOException {
try {
return super . available () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
return 0 ;
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
public synchronized void mark ( final int readlimit ) {
in . mark ( readlimit ) ;
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
