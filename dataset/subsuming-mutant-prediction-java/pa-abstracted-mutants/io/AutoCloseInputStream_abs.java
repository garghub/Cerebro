@Override
public void close () throws IOException {
in . close () ;
in = new ClosedInputStream () ;
}
@Override
protected void afterRead ( final int n ) throws IOException {
if ( n == EOF ) {
close () ;
}
}
@Override
protected void finalize () throws Throwable {
close () ;
super . finalize () ;
}
