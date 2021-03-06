@Override
public int andCardinality ( final BloomFilter other ) {
if ( other instanceof BitSetBloomFilter ) {
verifyShape ( other ) ;
final BitSet result = ( BitSet ) bitSet . clone () ;
result . and ( ( ( BitSetBloomFilter ) other ) . bitSet ) ;
return result . cardinality () ;
}
return super . andCardinality ( other ) ;
}
@Override
public int cardinality () {
return bitSet . cardinality () ;
}
@Override
public boolean contains ( final Hasher hasher ) {
verifyHasher ( hasher ) ;
final OfInt iter = hasher . getBits ( getShape () ) ;
while ( iter . hasNext () ) {
if ( ! bitSet . get ( iter . nextInt () ) ) {
return false ;
}
}
return true ;
}
@Override
public long [] getBits () {
return bitSet . toLongArray () ;
}
@Override
public StaticHasher getHasher () {
return new StaticHasher ( bitSet . stream () . iterator () , getShape () ) ;
}
@Override
public boolean merge ( final BloomFilter other ) {
verifyShape ( other ) ;
if ( other instanceof BitSetBloomFilter ) {
bitSet . or ( ( ( BitSetBloomFilter ) other ) . bitSet ) ;
} else {
bitSet . or ( BitSet . valueOf ( other . getBits () ) ) ;
}
return true ;
}
@Override
public boolean merge ( final Hasher hasher ) {
verifyHasher ( hasher ) ;
hasher . getBits ( getShape () ) . forEachRemaining ( ( IntConsumer ) bitSet :: set ) ;
return true ;
}
@Override
public int orCardinality ( final BloomFilter other ) {
if ( other instanceof BitSetBloomFilter ) {
verifyShape ( other ) ;
final BitSet result = ( BitSet ) bitSet . clone () ;
result . or ( ( ( BitSetBloomFilter ) other ) . bitSet ) ;
return result . cardinality () ;
}
return super . orCardinality ( other ) ;
}
@Override
public int xorCardinality ( final BloomFilter other ) {
if ( other instanceof BitSetBloomFilter ) {
verifyShape ( other ) ;
final BitSet result = ( BitSet ) bitSet . clone () ;
result . xor ( ( ( BitSetBloomFilter ) other ) . bitSet ) ;
return result . cardinality () ;
}
return super . xorCardinality ( other ) ;
}
