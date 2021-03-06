public static void dump ( final byte [] data , final long offset ,
final OutputStream stream , final int index )
throws IOException , ArrayIndexOutOfBoundsException ,
IllegalArgumentException {
if ( index < 0 || index >= data . length ) {
throw new ArrayIndexOutOfBoundsException (
lr_1 + index + lr_2
+ data . length ) ;
}
if ( stream == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
long display_offset = offset + index ;
final StringBuilder buffer = new StringBuilder ( 74 ) ;
for ( int j = index ; j < data . length ; j += 16 ) {
int chars_read = data . length - j ;
if ( chars_read > 16 ) {
chars_read = 16 ;
}
dump ( buffer , display_offset ) . append ( ' ' ) ;
for ( int k = 0 ; k < 16 ; k ++ ) {
if ( k < chars_read ) {
dump ( buffer , data [ k + j ] ) ;
} else {
buffer . append ( lr_4 ) ;
}
buffer . append ( ' ' ) ;
}
for ( int k = 0 ; k < chars_read ; k ++ ) {
if ( data [ k + j ] >= ' ' && data [ k + j ] < 127 ) {
buffer . append ( ( char ) data [ k + j ] ) ;
} else {
buffer . append ( '.' ) ;
}
}
buffer . append ( EOL ) ;
stream . write ( buffer . toString () . getBytes ( Charset . defaultCharset () ) ) ;
stream . flush () ;
buffer . setLength ( 0 ) ;
display_offset += chars_read ;
}
}
private static StringBuilder dump ( final StringBuilder _lbuffer , final long value ) {
for ( int j = 0 ; j < 8 ; j ++ ) {
_lbuffer
. append ( _hexcodes [ (int) ( value >> _shifts [ j ] ) & 15 ] ) ;
}
return _lbuffer ;
}
private static StringBuilder dump ( final StringBuilder _cbuffer , final byte value ) {
for ( int j = 0 ; j < 2 ; j ++ ) {
_cbuffer . append ( _hexcodes [ value >> _shifts [ j + 6 ] & 15 ] ) ;
}
return _cbuffer ;
}
