@Override
public void close () throws IOException {
target . close () ;
}
@Override
public void reset () throws IOException {
charsRead = markedAt ;
target . reset () ;
}
@Override
public void mark ( final int readAheadLimit ) throws IOException {
this . readAheadLimit = readAheadLimit - charsRead ;
markedAt = charsRead ;
target . mark ( readAheadLimit ) ;
}
@Override
public int read () throws IOException {
if ( charsRead >= maxCharsFromTargetReader ) {
return - 1 ;
}
if ( markedAt >= 0 && ( charsRead - markedAt ) >= readAheadLimit ) {
return - 1 ;
}
charsRead ++ ;
return target . read () ;
}
@Override
public int read ( final char [] cbuf , final int off , final int len ) throws IOException {
int c ;
for ( int i = 0 ; i < len ; i ++ ) {
c = read () ;
if ( c == - 1 ) {
return i == 0 ? - 1 : i ;
}
cbuf [ off + i ] = ( char ) c ;
}
return len ;
}
