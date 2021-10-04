@Override
public boolean hasNext () {
if ( savedException != null ) {
throw new NoSuchElementException ( savedException . toString () ) ;
}
return line != null ;
}
@Override
public String next () throws NoSuchElementException {
if ( savedException != null ) {
throw new NoSuchElementException ( savedException . toString () ) ;
}
final String prev = line ;
if ( prev == null ) {
throw new NoSuchElementException () ;
}
try {
line = reader . readLine () ;
if ( line == null ) {
Util . closeQuietly ( reader ) ;
}
} catch ( final IOException ex ) {
savedException = ex ;
Util . closeQuietly ( reader ) ;
}
return prev ;
}
@Override
public void remove () {
throw new UnsupportedOperationException () ;
}
@Override
public Iterator < String > iterator () {
return this ;
}
