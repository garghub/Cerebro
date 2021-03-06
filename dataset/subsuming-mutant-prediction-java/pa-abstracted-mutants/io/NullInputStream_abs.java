public long getPosition () {
return position ;
}
public long getSize () {
return size ;
}
@Override
public int available () {
final long avail = size - position ;
if ( avail <= 0 ) {
return 0 ;
} else if ( avail > Integer . MAX_VALUE ) {
return Integer . MAX_VALUE ;
} else {
return ( int ) avail ;
}
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
return processByte () ;
}
@Override
public int read ( final byte [] bytes ) throws IOException {
return read ( bytes , 0 , bytes . length ) ;
}
@Override
public int read ( final byte [] bytes , final int offset , final int length ) throws IOException {
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
processBytes ( bytes , offset , returnLength ) ;
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
public long skip ( final long numberOfBytes ) throws IOException {
if ( eof ) {
throw new IOException ( lr_7 ) ;
}
if ( position == size ) {
return doEndOfFile () ;
}
position += numberOfBytes ;
long returnLength = numberOfBytes ;
if ( position > size ) {
returnLength = numberOfBytes - ( position - size ) ;
position = size ;
}
return returnLength ;
}
protected int processByte () {
return 0 ;
}
protected void processBytes ( final byte [] bytes , final int offset , final int length ) {
}
private int doEndOfFile () throws EOFException {
eof = true ;
if ( throwEofException ) {
throw new EOFException () ;
}
return EOF ;
}
