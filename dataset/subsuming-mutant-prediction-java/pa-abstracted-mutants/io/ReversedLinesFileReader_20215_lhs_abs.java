public String readLine () throws IOException {
String line = currentFilePart . readLine () ;
while ( line == null ) { MST[NegateConditionalsMutator]MSP[]
currentFilePart = currentFilePart . rollOver () ;
if ( currentFilePart != null ) {
line = currentFilePart . readLine () ;
} else {
break;
}
}
if( EMPTY_STRING . equals ( line ) && ! trailingNewlineOfFileSkipped ) {
trailingNewlineOfFileSkipped = true ;
line = readLine () ;
}
return line ;
}
@Override
public void close () throws IOException {
channel . close () ;
}
private FilePart rollOver () throws IOException {
if ( currentLastBytePos > - 1 ) {
throw new IllegalStateException ( lr_1
+ lr_2 + currentLastBytePos ) ;
}
if ( no > 1 ) {
return new FilePart ( no - 1 , blockSize , leftOver ) ;
}
if ( leftOver != null ) {
throw new IllegalStateException ( lr_3
+ new String ( leftOver , encoding ) ) ;
}
return null ;
}
private String readLine () throws IOException {
String line = null ;
int newLineMatchByteCount ;
final boolean isLastFilePart = no == 1 ;
int i = currentLastBytePos ;
while ( i > - 1 ) {
if ( ! isLastFilePart && i < avoidNewlineSplitBufferSize ) {
createLeftOver () ;
break;
}
if ( ( newLineMatchByteCount = getNewLineMatchByteCount ( data , i ) ) > 0 ) {
final int lineStart = i + 1 ;
final int lineLengthBytes = currentLastBytePos - lineStart + 1 ;
if ( lineLengthBytes < 0 ) {
throw new IllegalStateException ( lr_4 + lineLengthBytes ) ;
}
final byte [] lineData = new byte [ lineLengthBytes ] ;
System . arraycopy ( data , lineStart , lineData , 0 , lineLengthBytes ) ;
line = new String ( lineData , encoding ) ;
currentLastBytePos = i - newLineMatchByteCount ;
break;
}
i -= byteDecrement ;
if ( i < 0 ) {
createLeftOver () ;
break;
}
}
if ( isLastFilePart && leftOver != null ) {
line = new String ( leftOver , encoding ) ;
leftOver = null ;
}
return line ;
}
private void createLeftOver () {
final int lineLengthBytes = currentLastBytePos + 1 ;
if ( lineLengthBytes > 0 ) {
leftOver = new byte [ lineLengthBytes ] ;
System . arraycopy ( data , 0 , leftOver , 0 , lineLengthBytes ) ;
} else {
leftOver = null ;
}
currentLastBytePos = - 1 ;
}
private int getNewLineMatchByteCount ( final byte [] data , final int i ) {
for ( final byte [] newLineSequence : newLineSequences ) {
boolean match = true ;
for ( int j = newLineSequence . length - 1 ; j >= 0 ; j -- ) {
final int k = i + j - ( newLineSequence . length - 1 ) ;
match &= k >= 0 && data [ k ] == newLineSequence [ j ] ;
}
if ( match ) {
return newLineSequence . length ;
}
}
return 0 ;
}
