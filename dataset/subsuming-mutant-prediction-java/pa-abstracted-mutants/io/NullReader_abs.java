public long getPosition () {
return position ;
}
public long getSize () {
return size ;
}
@Override
public void close () throws IOException {
eof = false ;
position = 0 ;
mark = - 1 ;
}
@Override
public synchronized void mark ( final int readlimit ) {
if ( ! markSupported ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}
mark = position ;
this . readlimit = readlimit ;
}
@Override
public boolean markSupported () {
return markSupported ;
}
@Override
public int read () throws IOException {
if ( eof ) {
throw new IOException ( lr_2 ) ;
}
if ( position == size ) {
return doEndOfFile () ;
}
position ++ ;
return processChar () ;
}
@Override
public int read ( final char [] chars ) throws IOException {
return read ( chars , 0 , chars . length ) ;
}
@Override
public int read ( final char [] chars , final int offset , final int length ) throws IOException {
if ( eof ) {
throw new IOException ( lr_2 ) ;
}
if ( position == size ) {
return doEndOfFile () ;
}
position += length ;
int returnLength = length ;
if ( position > size ) {
returnLength = length - (int)( position - size ) ;
position = size ;
}
processChars ( chars , offset , returnLength ) ;
return returnLength ;
}
@Override
public synchronized void reset () throws IOException {
if ( ! markSupported ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}
if ( mark < 0 ) {
throw new IOException ( lr_3 ) ;
}
if ( position > mark + readlimit ) {
throw new IOException ( lr_4 + mark +
lr_5 +
readlimit + lr_6 ) ;
}
position = mark ;
eof = false ;
}
@Override
public long skip ( final long numberOfChars ) throws IOException {
if ( eof ) {
throw new IOException ( lr_7 ) ;
}
if ( position == size ) {
return doEndOfFile () ;
}
position += numberOfChars ;
long returnLength = numberOfChars ;
if ( position > size ) {
returnLength = numberOfChars - ( position - size ) ;
position = size ;
}
return returnLength ;
}
protected int processChar () {
return 0 ;
}
protected void processChars ( final char [] chars , final int offset , final int length ) {
}
private int doEndOfFile () throws EOFException {
eof = true ;
if ( throwEofException ) {
throw new EOFException () ;
}
return EOF ;
}
