public boolean peek ( final byte [] pBuffer ) throws IOException {
Objects . requireNonNull ( pBuffer , lr_1 ) ;
if ( pBuffer . length > bufferSize ) {
throw new IllegalArgumentException ( lr_2 + pBuffer . length
+ lr_3 + bufferSize + lr_4 ) ;
}
if ( buffer . getCurrentNumberOfBytes () < pBuffer . length ) {
fillBuffer () ;
}
return buffer . peek ( pBuffer , 0 , pBuffer . length ) ;
}
public boolean peek ( final byte [] pBuffer , final int pOffset , final int pLength ) throws IOException {
Objects . requireNonNull ( pBuffer , lr_1 ) ;
if ( pBuffer . length > bufferSize ) {
throw new IllegalArgumentException ( lr_2 + pBuffer . length
+ lr_3 + bufferSize + lr_4 ) ;
}
if ( buffer . getCurrentNumberOfBytes () < pBuffer . length ) { MST[rv.ROR5Mutator]MSP[N]
fillBuffer () ;
}
return buffer . peek ( pBuffer , pOffset , pLength ) ;
}
