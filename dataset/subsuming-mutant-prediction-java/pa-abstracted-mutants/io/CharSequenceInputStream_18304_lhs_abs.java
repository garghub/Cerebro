private void fillBuffer () throws CharacterCodingException {
this . bbuf . compact () ;
final CoderResult result = this . encoder . encode ( this . cbuf , this . bbuf , true ) ;
if ( result . isError () ) {
result . throwException () ;
}
this . bbuf . flip () ;
}
@Override
public int read ( final byte [] b , int off , int len ) throws IOException {
if ( b == null ) {
throw new NullPointerException ( lr_1 ) ;
}
if ( len < 0 || ( off + len ) > b . length ) {
throw new IndexOutOfBoundsException ( lr_2 + b . length +
lr_3 + off + lr_4 + len ) ;
}
if ( len == 0 ) {
return 0 ;
}
if ( ! this . bbuf . hasRemaining () && ! this . cbuf . hasRemaining () ) {
return EOF ;
}
int bytesRead = 0 ;
while ( len > 0 ) {
if ( this . bbuf . hasRemaining () ) {
final int chunk = Math . min ( this . bbuf . remaining () , len ) ;
this . bbuf . get ( b , off , chunk ) ;
off += chunk ;
len -= chunk ; MST[rv.AOD1Mutator]MSP[]
bytesRead += chunk ;
} else {
fillBuffer () ;
if ( ! this . bbuf . hasRemaining () && ! this . cbuf . hasRemaining () ) {
break;
}
}
}
return bytesRead == 0 && ! this . cbuf . hasRemaining () ? EOF : bytesRead ;
}
@Override
public int read () throws IOException {
for (; ; ) {
if ( this . bbuf . hasRemaining () ) {
return this . bbuf . get () & 0xFF ;
}
fillBuffer () ;
if ( ! this . bbuf . hasRemaining () && ! this . cbuf . hasRemaining () ) {
return EOF ;
}
}
}
@Override
public int read ( final byte [] b ) throws IOException {
return read ( b , 0 , b . length ) ;
}
@Override
public long skip ( long n ) throws IOException {
long skipped = 0 ;
while ( n > 0 && available () > 0 ) {
this . read () ;
n -- ;
skipped ++ ;
}
return skipped ;
}
@Override
public int available () throws IOException {
return this . bbuf . remaining () + this . cbuf . remaining () ;
}
@Override
public void close () throws IOException {
}
@Override
public synchronized void mark ( final int readlimit ) {
this . mark_cbuf = this . cbuf . position () ;
this . mark_bbuf = this . bbuf . position () ;
this . cbuf . mark () ;
this . bbuf . mark () ;
}
@Override
public synchronized void reset () throws IOException {
if ( this . mark_cbuf != NO_MARK ) {
if ( this . cbuf . position () != 0 ) {
this . encoder . reset () ;
this . cbuf . rewind () ;
this . bbuf . rewind () ;
this . bbuf . limit ( 0 ) ;
while( this . cbuf . position () < this . mark_cbuf ) {
this . bbuf . rewind () ;
this . bbuf . limit ( 0 ) ;
fillBuffer () ;
}
}
if ( this . cbuf . position () != this . mark_cbuf ) {
throw new IllegalStateException ( lr_5 + cbuf . position () + lr_6 +
lr_7 + this . mark_cbuf ) ;
}
this . bbuf . position ( this . mark_bbuf ) ;
this . mark_cbuf = NO_MARK ;
this . mark_bbuf = NO_MARK ;
}
}
@Override
public boolean markSupported () {
return true ;
}
