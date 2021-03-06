private void fillBuffer () throws IOException {
if ( ! endOfInput && ( lastCoderResult == null || lastCoderResult . isUnderflow () ) ) {
encoderIn . compact () ;
final int position = encoderIn . position () ;
final int c = reader . read ( encoderIn . array () , position , encoderIn . remaining () ) ;
if ( c == EOF ) {
endOfInput = true ;
} else {
encoderIn . position ( position + c ) ;
}
encoderIn . flip () ;
}
encoderOut . compact () ;
lastCoderResult = encoder . encode ( encoderIn , encoderOut , endOfInput ) ;
encoderOut . flip () ;
}
@Override
public int read ( final byte [] b , int off , int len ) throws IOException {
if ( b == null ) {
throw new NullPointerException ( lr_1 ) ;
}
if ( len < 0 || off < 0 || ( off + len ) > b . length ) {
throw new IndexOutOfBoundsException ( lr_2 + b . length +
lr_3 + off + lr_4 + len ) ;
}
int read = 0 ;
if ( len == 0 ) {
return 0 ;
}
while ( len > 0 ) {
if ( encoderOut . hasRemaining () ) {
final int c = Math . min ( encoderOut . remaining () , len ) ;
encoderOut . get ( b , off , c ) ;
off += c ;
len -= c ;
read += c ;
} else {
fillBuffer () ;
if ( endOfInput && ! encoderOut . hasRemaining () ) {
break;
}
}
}
return read == 0 && endOfInput ? EOF : read ;
}
@Override
public int read ( final byte [] b ) throws IOException {
return read ( b , 0 , b . length ) ;
}
@Override
public int read () throws IOException {
for (; ; ) {
if ( encoderOut . hasRemaining () ) {
return encoderOut . get () & 0xFF ;
}
fillBuffer () ;
if ( endOfInput && ! encoderOut . hasRemaining () ) {
return EOF ;
}
}
}
@Override
public void close () throws IOException {
reader . close () ;
}
