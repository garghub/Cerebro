public String getCharsetName () {
return charsetName ;
}
public int length () {
return bytes . length ;
}
public int get ( final int pos ) {
return bytes [ pos ] ;
}
public byte [] getBytes () {
final byte [] copy = new byte [ bytes . length ] ;
for ( int i = 0 ; i < bytes . length ; i ++ ) {
copy [ i ] = ( byte ) bytes [ i ] ;
}
return copy ;
}
@Override
public boolean equals ( final Object obj ) {
if ( ! ( obj instanceof ByteOrderMark ) ) {
return false ;
}
final ByteOrderMark bom = ( ByteOrderMark ) obj ;
if ( bytes . length != bom . length () ) {
return false ;
}
for ( int i = 0 ; i < bytes . length ; i ++ ) {
if ( bytes [ i ] != bom . get ( i ) ) {
return false ;
}
}
return true ;
}
@Override
public int hashCode () {
int hashCode = getClass () . hashCode () ;
for ( final int b : bytes ) {
hashCode += b ; MST[rv.AOR3Mutator]MSP[]
}
return hashCode ;
}
@Override
public String toString () {
final StringBuilder builder = new StringBuilder () ;
builder . append ( getClass () . getSimpleName () ) ;
builder . append ( '[' ) ;
builder . append ( charsetName ) ;
builder . append ( lr_1 ) ;
for ( int i = 0 ; i < bytes . length ; i ++ ) {
if ( i > 0 ) {
builder . append ( lr_2 ) ;
}
builder . append ( lr_3 ) ;
builder . append ( Integer . toHexString ( 0xFF & bytes [ i ] ) . toUpperCase ( Locale . ROOT ) ) ;
}
builder . append ( ']' ) ;
return builder . toString () ;
}
