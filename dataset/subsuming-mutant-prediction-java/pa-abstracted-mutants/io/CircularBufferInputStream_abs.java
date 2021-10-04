protected void fillBuffer () throws IOException {
if ( eofSeen ) {
return;
}
int space = buffer . getSpace () ;
final byte [] buf = new byte [ space ] ;
while ( space > 0 ) {
final int res = in . read ( buf , 0 , space ) ;
if ( res == - 1 ) {
eofSeen = true ;
return;
} else if ( res > 0 ) {
buffer . add ( buf , 0 , res ) ;
space -= res ;
}
}
}
protected boolean haveBytes ( final int pNumber ) throws IOException {
if ( buffer . getCurrentNumberOfBytes () < pNumber ) {
fillBuffer () ;
}
return buffer . hasBytes () ;
}
@Override
public int read () throws IOException {
if ( ! haveBytes ( 1 ) ) {
return - 1 ;
}
return buffer . read () ;
}
@Override
public int read ( final byte [] pBuffer ) throws IOException {
return read ( pBuffer , 0 , pBuffer . length ) ;
}
@Override
public int read ( final byte [] pBuffer , final int pOffset , final int pLength ) throws IOException {
Objects . requireNonNull ( pBuffer , lr_1 ) ;
if ( pOffset < 0 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( pLength < 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( ! haveBytes ( pLength ) ) {
return - 1 ;
}
final int result = Math . min ( pLength , buffer . getCurrentNumberOfBytes () ) ;
for ( int i = 0 ; i < result ; i ++ ) {
pBuffer [ pOffset + i ] = buffer . read () ;
}
return result ;
}
@Override
public void close () throws IOException {
in . close () ;
eofSeen = true ;
buffer . clear () ;
}
