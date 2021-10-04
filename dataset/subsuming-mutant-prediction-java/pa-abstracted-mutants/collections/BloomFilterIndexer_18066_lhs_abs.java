static void checkPositive ( int bitIndex ) {
if ( bitIndex < 0 ) {
throw new IndexOutOfBoundsException ( lr_1 + bitIndex ) ;
}
}
static int getLongIndex ( int bitIndex ) {
return bitIndex >> DIVIDE_BY_64 ;
}
static long getLongBit ( int bitIndex ) {
return 1L << bitIndex ; MST[rv.UOI3Mutator]MSP[]
}
