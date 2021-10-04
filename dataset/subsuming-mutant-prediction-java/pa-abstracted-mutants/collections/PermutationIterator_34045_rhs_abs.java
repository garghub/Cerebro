@Override
public boolean hasNext () {
return nextPermutation != null ;
}
@Override
public List < E > next () {
if ( ! hasNext () ) {
throw new NoSuchElementException () ;
}
int indexOfLargestMobileInteger = - 1 ;
int largestKey = - 1 ;
for ( int i = 0 ; i < keys . length ; i ++ ) {
if ( ( direction [ i ] && i < keys . length - 1 && keys [ i ] > keys [ i + 1 ] ) ||
( ! direction [ i ] && i > 0 && keys [ i ] > keys [ i - 1 ] ) ) {
if ( keys [ i ] > largestKey ) {
largestKey = keys [ i ] ;
indexOfLargestMobileInteger = i ;
}
}
}
if ( largestKey == - 1 ) {
final List < E > toReturn = nextPermutation ;
nextPermutation = null ;
return toReturn ;
}
final int offset = direction [ indexOfLargestMobileInteger ] ? 1 : - 1 ;
final int tmpKey = keys [ indexOfLargestMobileInteger ] ;
keys [ indexOfLargestMobileInteger ] = keys [ indexOfLargestMobileInteger + offset ] ;
keys [ indexOfLargestMobileInteger + offset ] = tmpKey ;
final boolean tmpDirection = direction [ indexOfLargestMobileInteger ] ;
direction [ indexOfLargestMobileInteger ] = direction [ indexOfLargestMobileInteger + offset ] ; MST[MathMutator]MSP[N]
direction [ indexOfLargestMobileInteger + offset ] = tmpDirection ;
final List < E > nextP = new ArrayList <> () ;
for ( int i = 0 ; i < keys . length ; i ++ ) {
if ( keys [ i ] > largestKey ) {
direction [ i ] = ! direction [ i ] ;
}
nextP . add ( objectMap . get ( Integer . valueOf ( keys [ i ] ) ) ) ;
}
final List < E > result = nextPermutation ;
nextPermutation = nextP ;
return result ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_1 ) ;
}
