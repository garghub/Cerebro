@Override
public int andCardinality ( final BloomFilter other ) {
verifyShape ( other ) ;
final long [] mine = getBits () ;
final long [] theirs = other . getBits () ;
final int limit = Integer . min ( mine . length , theirs . length ) ;
int count = 0 ;
for ( int i = 0 ; i < limit ; i ++ ) {
count += Long . bitCount ( mine [ i ] & theirs [ i ] ) ;
}
return count ;
}
@Override
public int cardinality () {
int count = 0 ;
for ( final long bits : getBits () ) {
count += Long . bitCount ( bits ) ;
}
return count ;
}
@Override
public boolean contains ( final BloomFilter other ) {
verifyShape ( other ) ;
return other . cardinality () == andCardinality ( other ) ;
}
@Override
public boolean contains ( final Hasher hasher ) {
verifyHasher ( hasher ) ;
final long [] buff = getBits () ;
final OfInt iter = hasher . getBits ( shape ) ;
while ( iter . hasNext () ) {
final int idx = iter . nextInt () ;
BloomFilterIndexer . checkPositive ( idx ) ;
final int buffIdx = BloomFilterIndexer . getLongIndex ( idx ) ;
final long buffOffset = BloomFilterIndexer . getLongBit ( idx ) ;
if ( ( buff [ buffIdx ] & buffOffset ) == 0 ) {
return false ;
}
}
return true ;
}
@Override
public final Shape getShape () {
return shape ;
}
public final boolean isFull () {
return cardinality () == getShape () . getNumberOfBits () ; MST[rv.ROR3Mutator]MSP[]
}
@Override
public int orCardinality ( final BloomFilter other ) {
return opCardinality ( other , ( a , b ) -> a | b ) ;
}
protected void verifyHasher ( final Hasher hasher ) {
if ( shape . getHashFunctionIdentity () . getSignature () != hasher . getHashFunctionIdentity () . getSignature () ) {
throw new IllegalArgumentException (
String . format ( lr_1 ,
HashFunctionIdentity . asCommonString ( hasher . getHashFunctionIdentity () ) ,
shape . toString () ) ) ;
}
}
protected void verifyShape ( final BloomFilter other ) {
verifyShape ( other . getShape () ) ;
}
protected void verifyShape ( final Shape shape ) {
if ( ! this . shape . equals ( shape ) ) {
throw new IllegalArgumentException ( String . format ( lr_2 , shape , this . shape ) ) ;
}
}
@Override
public int xorCardinality ( final BloomFilter other ) {
return opCardinality ( other , ( a , b ) -> a ^ b ) ;
}
private int opCardinality ( final BloomFilter other , LongBinaryOperator operation ) {
verifyShape ( other ) ;
final long [] mine = getBits () ;
final long [] theirs = other . getBits () ;
long [] small ;
long [] big ;
if ( mine . length > theirs . length ) {
big = mine ;
small = theirs ;
} else {
small = mine ;
big = theirs ;
}
int count = 0 ;
for ( int i = 0 ; i < small . length ; i ++ ) {
count += Long . bitCount ( operation . applyAsLong ( small [ i ] , big [ i ] ) ) ;
}
for ( int i = small . length ; i < big . length ; i ++ ) {
count += Long . bitCount ( big [ i ] ) ;
}
return count ;
}
