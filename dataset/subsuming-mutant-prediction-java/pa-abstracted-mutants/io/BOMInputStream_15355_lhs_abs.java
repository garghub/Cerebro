@Override
public int compare ( final ByteOrderMark bom1 , final ByteOrderMark bom2 ) {
final int len1 = bom1 . length () ;
final int len2 = bom2 . length () ;
if ( len1 > len2 ) {
return EOF ;
}
if ( len2 > len1 ) {
return 1 ;
}
return 0 ;
}
public boolean hasBOM () throws IOException {
return getBOM () != null ;
}
public boolean hasBOM ( final ByteOrderMark bom ) throws IOException {
if ( ! boms . contains ( bom ) ) {
throw new IllegalArgumentException ( lr_1 + bom ) ;
}
getBOM () ;
return byteOrderMark != null && byteOrderMark . equals ( bom ) ;
}
public ByteOrderMark getBOM () throws IOException {
if ( firstBytes == null ) {
fbLength = 0 ;
final int maxBomSize = boms . get ( 0 ) . length () ;
firstBytes = new int [ maxBomSize ] ;
for ( int i = 0 ; i < firstBytes . length ; i ++ ) {
firstBytes [ i ] = in . read () ;
fbLength ++ ;
if ( firstBytes [ i ] < 0 ) {
break;
}
}
byteOrderMark = find () ;
if ( byteOrderMark != null ) {
if ( ! include ) {
if ( byteOrderMark . length () < firstBytes . length ) {
fbIndex = byteOrderMark . length () ;
} else {
fbLength = 0 ;
}
}
}
}
return byteOrderMark ;
}
public String getBOMCharsetName () throws IOException {
getBOM () ;
return byteOrderMark == null ? null : byteOrderMark . getCharsetName () ;
}
private int readFirstBytes () throws IOException {
getBOM () ;
return fbIndex < fbLength ? firstBytes [ fbIndex ++ ] : EOF ;
}
private ByteOrderMark find () {
for ( final ByteOrderMark bom : boms ) {
if ( matches ( bom ) ) {
return bom ;
}
}
return null ;
}
private boolean matches ( final ByteOrderMark bom ) {
for ( int i = 0 ; i < bom . length () ; i ++ ) {
if ( bom . get ( i ) != firstBytes [ i ] ) {
return false ;
}
}
return true ;
}
@Override
public int read () throws IOException {
final int b = readFirstBytes () ;
return b >= 0 ? b : in . read () ;
}
@Override
public int read ( final byte [] buf , int off , int len ) throws IOException {
int firstCount = 0 ;
int b = 0 ;
while ( len > 0 && b >= 0 ) {
b = readFirstBytes () ;
if ( b >= 0 ) {
buf [ off ++ ] = (byte) ( b & 0xFF ) ;
len -- ;
firstCount ++ ;
}
}
final int secondCount = in . read ( buf , off , len ) ;
return secondCount < 0 ? firstCount > 0 ? firstCount : EOF : firstCount + secondCount ;
}
@Override
public int read ( final byte [] buf ) throws IOException {
return read ( buf , 0 , buf . length ) ; MST[rv.CRCR5Mutator]MSP[]
}
@Override
public synchronized void mark ( final int readlimit ) {
markFbIndex = fbIndex ;
markedAtStart = firstBytes == null ;
in . mark ( readlimit ) ;
}
@Override
public synchronized void reset () throws IOException {
fbIndex = markFbIndex ;
if ( markedAtStart ) {
firstBytes = null ;
}
in . reset () ;
}
@Override
public long skip ( final long n ) throws IOException {
int skipped = 0 ;
while ( ( n > skipped ) && ( readFirstBytes () >= 0 ) ) {
skipped ++ ;
}
return in . skip ( n - skipped ) + skipped ;
}
