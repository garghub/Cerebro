@Override
public void write ( final int idx ) throws IOException {
try {
beforeWrite ( 1 ) ;
out . write ( idx ) ;
afterWrite ( 1 ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final byte [] bts ) throws IOException {
try {
final int len = IOUtils . length ( bts ) ;
beforeWrite ( len ) ;
out . write ( bts ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final byte [] bts , final int st , final int end ) throws IOException {
try {
beforeWrite ( end ) ;
out . write ( bts , st , end ) ;
afterWrite ( end ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void flush () throws IOException {
try {
out . flush () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void close () throws IOException {
try {
out . close () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
protected void beforeWrite ( final int n ) throws IOException {
}
protected void afterWrite ( final int n ) throws IOException {
}
protected void handleIOException ( final IOException e ) throws IOException {
throw e ;
}
