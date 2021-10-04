@Override
public boolean accept ( final File file ) {
if ( file != null && file . isFile () && file . canRead () ) {
try {
try ( RandomAccessFile randomAccessFile = new RandomAccessFile ( file , lr_1 ) ) {
final byte [] fileBytes = new byte [ this . magicNumbers . length ] ;
randomAccessFile . seek ( byteOffset ) ;
final int read = randomAccessFile . read ( fileBytes ) ;
if ( read != magicNumbers . length ) {
return false ;
}
return Arrays . equals ( this . magicNumbers , fileBytes ) ;
}
}
catch ( final IOException ioe ) {
}
}
return false ;
}
@Override
public String toString () {
final StringBuilder builder = new StringBuilder ( super . toString () ) ;
builder . append ( lr_2 ) ;
builder . append ( new String ( magicNumbers , Charset . defaultCharset () ) ) ;
builder . append ( lr_3 ) ;
builder . append ( this . byteOffset ) ; MST[rv.UOI1Mutator]MSP[]
builder . append ( lr_4 ) ;
return builder . toString () ;
}
