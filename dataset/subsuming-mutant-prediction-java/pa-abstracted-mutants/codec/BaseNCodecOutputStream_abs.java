@Override
public void close () throws IOException {
eof () ;
flush () ;
out . close () ;
}
public void eof () throws IOException {
if ( doEncode ) {
baseNCodec . encode ( singleByte , 0 , EOF , context ) ;
} else {
baseNCodec . decode ( singleByte , 0 , EOF , context ) ;
}
}
@Override
public void flush () throws IOException {
flush ( true ) ;
}
private void flush ( final boolean propagate ) throws IOException {
final int avail = baseNCodec . available ( context ) ;
if ( avail > 0 ) {
final byte [] buf = new byte [ avail ] ;
final int c = baseNCodec . readResults ( buf , 0 , avail , context ) ;
if ( c > 0 ) {
out . write ( buf , 0 , c ) ;
}
}
if ( propagate ) {
out . flush () ;
}
}
public boolean isStrictDecoding () {
return baseNCodec . isStrictDecoding () ;
}
@Override
public void write ( final byte array [] , final int offset , final int len ) throws IOException {
Objects . requireNonNull ( array , lr_1 ) ;
if ( offset < 0 || len < 0 ) {
throw new IndexOutOfBoundsException () ;
} else if ( offset > array . length || offset + len > array . length ) {
throw new IndexOutOfBoundsException () ;
} else if ( len > 0 ) {
if ( doEncode ) {
baseNCodec . encode ( array , offset , len , context ) ;
} else {
baseNCodec . decode ( array , offset , len , context ) ;
}
flush ( false ) ;
}
}
@Override
public void write ( final int i ) throws IOException {
singleByte [ 0 ] = ( byte ) i ;
write ( singleByte , 0 , 1 ) ;
}
