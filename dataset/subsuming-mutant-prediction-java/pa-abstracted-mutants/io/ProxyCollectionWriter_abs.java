protected void afterWrite ( final int n ) throws IOException {
}
@Override
public Writer append ( final char c ) throws IOException {
try {
beforeWrite ( 1 ) ;
super . append ( c ) ;
afterWrite ( 1 ) ;
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
super . append ( csq ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
return this ;
}
@Override
public Writer append ( final CharSequence csq , final int start , final int end ) throws IOException {
try {
beforeWrite ( end - start ) ;
super . append ( csq , start , end ) ;
afterWrite ( end - start ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
return this ;
}
protected void beforeWrite ( final int n ) throws IOException {
}
@Override
public void close () throws IOException {
try {
super . close () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void flush () throws IOException {
try {
super . flush () ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
protected void handleIOException ( final IOException e ) throws IOException {
throw e ;
}
@Override
public void write ( final char [] cbuf ) throws IOException {
try {
final int len = IOUtils . length ( cbuf ) ;
beforeWrite ( len ) ;
super . write ( cbuf ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final char [] cbuf , final int off , final int len ) throws IOException {
try {
beforeWrite ( len ) ;
super . write ( cbuf , off , len ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final int c ) throws IOException {
try {
beforeWrite ( 1 ) ;
super . write ( c ) ;
afterWrite ( 1 ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final String str ) throws IOException {
try {
final int len = IOUtils . length ( str ) ;
beforeWrite ( len ) ;
super . write ( str ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
@Override
public void write ( final String str , final int off , final int len ) throws IOException {
try {
beforeWrite ( len ) ;
super . write ( str , off , len ) ;
afterWrite ( len ) ;
} catch ( final IOException e ) {
handleIOException ( e ) ;
}
}
