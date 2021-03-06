@Override
public DynamicHasher build () throws IllegalArgumentException {
return new DynamicHasher ( function , buffers ) ;
}
@Override
public final Builder with ( final byte property ) {
return with ( new byte [] { property } ) ;
}
@Override
public final Builder with ( final byte [] property ) {
buffers . add ( property ) ;
return this ;
}
@Override
public final Builder with ( final String property ) {
return with ( property . getBytes ( StandardCharsets . UTF_8 ) ) ;
}
@Override
public boolean hasNext () {
return buffer < buffers . size () - 1 || funcCount < shape . getNumberOfHashFunctions () ;
}
@Override
public int nextInt () {
if ( hasNext () ) {
if ( funcCount >= shape . getNumberOfHashFunctions () ) {
funcCount = 0 ;
buffer ++ ;
}
return ( int ) Math . floorMod ( function . apply ( buffers . get ( buffer ) , funcCount ++ ) ,
( long ) shape . getNumberOfBits () ) ;
}
throw new NoSuchElementException () ;
}
@Override
public boolean hasNext () {
return false ;
}
@Override
public int nextInt () {
throw new NoSuchElementException () ;
}
@Override
public PrimitiveIterator . OfInt getBits ( final Shape shape ) {
HashFunctionValidator . checkAreEqual ( getHashFunctionIdentity () ,
shape . getHashFunctionIdentity () ) ;
return buffers . isEmpty () ? NoValuesIterator . INSTANCE : new Iterator ( shape ) ;
}
@Override
public HashFunctionIdentity getHashFunctionIdentity () {
return function ;
}
@Override
public boolean isEmpty () {
return buffers . isEmpty () ;
}
