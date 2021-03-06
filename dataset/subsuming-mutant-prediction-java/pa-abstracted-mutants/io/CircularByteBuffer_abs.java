public byte read () {
if ( currentNumberOfBytes <= 0 ) {
throw new IllegalStateException ( lr_1 ) ;
}
final byte b = buffer [ startOffset ] ;
-- currentNumberOfBytes ;
if ( ++ startOffset == buffer . length ) {
startOffset = 0 ;
}
return b ;
}
public void read ( final byte [] pBuffer , final int pOffset , final int pLength ) {
Objects . requireNonNull ( pBuffer ) ;
if ( pOffset < 0 || pOffset >= pBuffer . length ) {
throw new IllegalArgumentException ( lr_2 + pOffset ) ;
}
if ( pLength < 0 || pLength > buffer . length ) {
throw new IllegalArgumentException ( lr_3 + pLength ) ;
}
if ( pOffset + pLength > pBuffer . length ) {
throw new IllegalArgumentException ( lr_4
+ pBuffer . length + lr_5
+ ( pOffset + pLength - 1 ) ) ;
}
if ( currentNumberOfBytes < pLength ) {
throw new IllegalStateException ( lr_6 + currentNumberOfBytes
+ lr_7 + pLength ) ;
}
int offset = pOffset ;
for ( int i = 0 ; i < pLength ; i ++ ) {
pBuffer [ offset ++ ] = buffer [ startOffset ] ;
-- currentNumberOfBytes ;
if ( ++ startOffset == buffer . length ) {
startOffset = 0 ;
}
}
}
public void add ( final byte pByte ) {
if ( currentNumberOfBytes >= buffer . length ) {
throw new IllegalStateException ( lr_8 ) ;
}
buffer [ endOffset ] = pByte ;
++ currentNumberOfBytes ;
if ( ++ endOffset == buffer . length ) {
endOffset = 0 ;
}
}
public boolean peek ( final byte [] pBuffer , final int pOffset , final int pLength ) {
Objects . requireNonNull ( pBuffer , lr_9 ) ;
if ( pOffset < 0 || pOffset >= pBuffer . length ) {
throw new IllegalArgumentException ( lr_2 + pOffset ) ;
}
if ( pLength < 0 || pLength > buffer . length ) {
throw new IllegalArgumentException ( lr_3 + pLength ) ;
}
if ( pLength < currentNumberOfBytes ) {
return false ;
}
int offset = startOffset ;
for ( int i = 0 ; i < pLength ; i ++ ) {
if ( buffer [ offset ] != pBuffer [ i + pOffset ] ) {
return false ;
}
if ( ++ offset == buffer . length ) {
offset = 0 ;
}
}
return true ;
}
public void add ( final byte [] pBuffer , final int pOffset , final int pLength ) {
Objects . requireNonNull ( pBuffer , lr_9 ) ;
if ( pOffset < 0 || pOffset >= pBuffer . length ) {
throw new IllegalArgumentException ( lr_2 + pOffset ) ;
}
if ( pLength < 0 ) {
throw new IllegalArgumentException ( lr_3 + pLength ) ;
}
if ( currentNumberOfBytes + pLength > buffer . length ) {
throw new IllegalStateException ( lr_8 ) ;
}
for ( int i = 0 ; i < pLength ; i ++ ) {
buffer [ endOffset ] = pBuffer [ pOffset + i ] ;
if ( ++ endOffset == buffer . length ) {
endOffset = 0 ;
}
}
currentNumberOfBytes += pLength ;
}
public boolean hasSpace () {
return currentNumberOfBytes < buffer . length ;
}
public boolean hasSpace ( final int pBytes ) {
return currentNumberOfBytes + pBytes <= buffer . length ;
}
public boolean hasBytes () {
return currentNumberOfBytes > 0 ;
}
public int getSpace () {
return buffer . length - currentNumberOfBytes ;
}
public int getCurrentNumberOfBytes () {
return currentNumberOfBytes ;
}
public void clear () {
startOffset = 0 ;
endOffset = 0 ;
currentNumberOfBytes = 0 ;
}
