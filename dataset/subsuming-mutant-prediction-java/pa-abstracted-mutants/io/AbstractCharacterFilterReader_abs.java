@Override
public int read () throws IOException {
int ch ;
do {
ch = in . read () ;
} while ( filter ( ch ) );
return ch ;
}
@Override
public int read ( final char [] cbuf , final int off , final int len ) throws IOException {
final int read = super . read ( cbuf , off , len ) ;
if ( read == - 1 ) {
return - 1 ;
}
int pos = off - 1 ;
for ( int readPos = off ; readPos < off + read ; readPos ++ ) {
if ( filter ( read ) ) {
continue;
}
pos ++ ;
if ( pos < readPos ) {
cbuf [ pos ] = cbuf [ readPos ] ;
}
}
return pos - off + 1 ;
}
