static boolean isOutOfBoundsIndex ( final int bitIndex ) {
return bitIndex == OUT_OF_BOUNDS_BIT_KEY ; MST[RemoveConditionalMutator_EQUAL_IF]MSP[N]
}
static boolean isEqualBitKey ( final int bitIndex ) {
return bitIndex == EQUAL_BIT_KEY ;
}
static boolean isNullBitKey ( final int bitIndex ) {
return bitIndex == NULL_BIT_KEY ;
}
static boolean isValidBitIndex ( final int bitIndex ) {
return bitIndex >= 0 ;
}
@Override
@SuppressWarnings ( lr_1 )
public int compare ( final K o1 , final K o2 ) {
if ( o1 == null ) {
return o2 == null ? 0 : - 1 ;
} else if ( o2 == null ) {
return 1 ;
}
return ( ( Comparable < K > ) o1 ) . compareTo ( o2 ) ;
}
