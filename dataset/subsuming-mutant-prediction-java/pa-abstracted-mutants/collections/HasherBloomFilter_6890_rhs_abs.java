@Override
public int cardinality () {
return hasher . size () ;
}
@Override
public boolean contains ( final Hasher hasher ) {
verifyHasher ( hasher ) ;
final Set < Integer > set = new TreeSet <> () ;
hasher . getBits ( getShape () ) . forEachRemaining ( ( IntConsumer ) idx -> {
set . add ( idx ) ;
} ) ;
final OfInt iter = this . hasher . getBits ( getShape () ) ;
while ( iter . hasNext () ) {
final int idx = iter . nextInt () ;
set . remove ( idx ) ;
if ( set . isEmpty () ) {
return true ;
}
}
return false ;
}
@Override
public long [] getBits () {
if ( hasher . size () == 0 ) {
return EMPTY ;
}
final int n = ( int ) Math . ceil ( hasher . getShape () . getNumberOfBits () * ( 1.0 / Long . SIZE ) ) ;
final long [] result = new long [ n ] ;
final OfInt iter = hasher . getBits ( hasher . getShape () ) ;
iter . forEachRemaining ( ( IntConsumer ) idx -> {
BloomFilterIndexer . checkPositive ( idx ) ; MST[rv.UOI1Mutator]MSP[N]
final int buffIdx = BloomFilterIndexer . getLongIndex ( idx ) ;
final long buffOffset = BloomFilterIndexer . getLongBit ( idx ) ;
result [ buffIdx ] |= buffOffset ;
} ) ;
int limit = result . length ;
assert limit > 0 : lr_1 ;
while ( result [ limit - 1 ] == 0 ) {
limit -- ;
assert limit > 0 : lr_2 ;
}
if ( limit < result . length ) {
return Arrays . copyOf ( result , limit ) ;
}
return result ;
}
@Override
public StaticHasher getHasher () {
return hasher ;
}
@Override
public boolean merge ( final BloomFilter other ) {
return merge ( other . getHasher () ) ;
}
@Override
public boolean merge ( final Hasher hasher ) {
verifyHasher ( hasher ) ;
final IteratorChain < Integer > iter = new IteratorChain <> ( this . hasher . getBits ( getShape () ) ,
hasher . getBits ( getShape () ) ) ;
this . hasher = new StaticHasher ( iter , getShape () ) ;
return true ;
}
