@Override
public Writer append ( final char c ) throws IOException {
try {
beforeWrite ( 1 ) ;
out . append ( c ) ;
afterWrite ( 1 ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
return this ;
}
@Override
public Writer append ( final CharSequence csq , final int start , final int end ) throws IOException {
try {
beforeWrite ( end - start ) ;
out . append ( csq , start , end ) ;
afterWrite ( end - start ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
return this ;
}
@Override
public Writer append ( final CharSequence csq ) throws IOException {
try {
final int len = IOUtils . length ( csq ) ;
beforeWrite ( len ) ;
out . append ( csq ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
return this ;
}
@Override
public void write ( final int c ) throws IOException {
try {
beforeWrite ( 1 ) ;
out . write ( c ) ;
afterWrite ( 1 ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final char [] cbuf ) throws IOException {
try {
final int len = IOUtils . length ( cbuf ) ;
beforeWrite ( len ) ;
out . write ( cbuf ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final char [] cbuf , final int off , final int len ) throws IOException {
try {
beforeWrite ( len ) ;
out . write ( cbuf , off , len ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final String str ) throws IOException {
try {
final int len = IOUtils . length ( str ) ;
beforeWrite ( len ) ;
out . write ( str ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final String str , final int off , final int len ) throws IOException {
try {
beforeWrite ( len ) ;
out . write ( str , off , len ) ;
afterWrite ( len ) ;
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
