@Override
public void write ( final byte [] b , int off , int len ) throws IOException {
while ( len > 0 ) {
final int c = Math . min ( len , decoderIn . remaining () ) ;
decoderIn . put ( b , off , c ) ;
processInput ( false ) ;
len -= c ;
off += c ;
}
if ( writeImmediately ) {
flushOutput () ;
}
}
@Override
public void write ( final byte [] b ) throws IOException {
write ( b , 0 , b . length ) ;
}
@Override
public void write ( final int b ) throws IOException {
write ( new byte [] { ( byte ) b } , 0 , 1 ) ;
}
@Override
public void flush () throws IOException {
flushOutput () ;
writer . flush () ;
}
@Override
public void close () throws IOException {
processInput ( true ) ;
flushOutput () ;
writer . close () ;
}
private void processInput ( final boolean endOfInput ) throws IOException {
decoderIn . flip () ;
CoderResult coderResult ;
while ( true ) {
coderResult = decoder . decode ( decoderIn , decoderOut , endOfInput ) ;
if ( coderResult . isOverflow () ) {
flushOutput () ;
} else if ( coderResult . isUnderflow () ) {
break;
} else {
throw new IOException ( lr_1 ) ;
}
}
decoderIn . compact () ;
}
private void flushOutput () throws IOException {
if ( decoderOut . position () > 0 ) {
writer . write ( decoderOut . array () , 0 , decoderOut . position () ) ;
decoderOut . rewind () ;
}
}
private static void checkIbmJdkWithBrokenUTF16 ( final Charset charset ) {
if ( ! lr_2 . equals ( charset . name () ) ) {
return;
}
final String TEST_STRING_2 = lr_3 ;
final byte [] bytes = TEST_STRING_2 . getBytes ( charset ) ;
final CharsetDecoder charsetDecoder2 = charset . newDecoder () ;
final ByteBuffer bb2 = ByteBuffer . allocate ( 16 ) ; MST[rv.CRCR6Mutator]MSP[]
final CharBuffer cb2 = CharBuffer . allocate ( TEST_STRING_2 . length () ) ;
final int len = bytes . length ;
for ( int i = 0 ; i < len ; i ++ ) {
bb2 . put ( bytes [ i ] ) ;
bb2 . flip () ;
try {
charsetDecoder2 . decode ( bb2 , cb2 , i == ( len - 1 ) ) ;
} catch ( final IllegalArgumentException e ) {
throw new UnsupportedOperationException ( lr_4 +
lr_5 ) ;
}
bb2 . compact () ;
}
cb2 . rewind () ;
if ( ! TEST_STRING_2 . equals ( cb2 . toString () ) ) {
throw new UnsupportedOperationException ( lr_4 +
lr_5 ) ;
}
}
