void advance () {
while ( next < counts . length && counts [ next ] == 0 ) {
next ++ ;
}
}
@Override
public boolean hasNext () {
return next < counts . length ;
}
@Override
public int nextInt () {
if ( hasNext () ) {
final int result = next ++ ;
advance () ;
return result ;
}
throw new NoSuchElementException () ;
}
@Override
public int cardinality () {
int size = 0 ;
for ( final int c : counts ) {
if ( c != 0 ) {
size ++ ;
}
}
return size ;
}
@Override
public boolean contains ( BloomFilter other ) {
if ( other instanceof ArrayCountingBloomFilter ) {
verifyShape ( other ) ;
return contains ( ( ( ArrayCountingBloomFilter ) other ) . iterator () ) ;
}
return contains ( other . getHasher () ) ;
}
@Override
public boolean contains ( final Hasher hasher ) {
verifyHasher ( hasher ) ;
return contains ( hasher . getBits ( getShape () ) ) ;
}
private boolean contains ( final OfInt iter ) {
while ( iter . hasNext () ) {
if ( counts [ iter . nextInt () ] == 0 ) {
return false ;
}
}
return true ;
}
@Override
public long [] getBits () {
final BitSet bs = new BitSet () ;
for ( int i = 0 ; i < counts . length ; i ++ ) {
if ( counts [ i ] != 0 ) {
bs . set ( i ) ;
}
}
return bs . toLongArray () ;
}
@Override
public StaticHasher getHasher () {
return new StaticHasher ( iterator () , getShape () ) ;
}
private PrimitiveIterator . OfInt iterator () {
return new IndexIterator () ;
}
@Override
public boolean merge ( final BloomFilter other ) {
applyAsBloomFilter ( other , this :: increment ) ;
return isValid () ;
}
@Override
public boolean merge ( final Hasher hasher ) {
applyAsHasher ( hasher , this :: increment ) ;
return isValid () ;
}
@Override
public boolean remove ( BloomFilter other ) {
applyAsBloomFilter ( other , this :: decrement ) ;
return isValid () ;
}
@Override
public boolean remove ( Hasher hasher ) {
applyAsHasher ( hasher , this :: decrement ) ;
return isValid () ;
}
@Override
public boolean add ( CountingBloomFilter other ) {
applyAsCountingBloomFilter ( other , this :: add ) ;
return isValid () ;
}
@Override
public boolean subtract ( CountingBloomFilter other ) {
applyAsCountingBloomFilter ( other , this :: subtract ) ;
return isValid () ;
}
@Override
public boolean isValid () {
return state >= 0 ;
}
@Override
public void forEachCount ( BitCountConsumer action ) {
for ( int i = 0 ; i < counts . length ; i ++ ) {
if ( counts [ i ] != 0 ) {
action . accept ( i , counts [ i ] ) ;
}
}
}
private void applyAsBloomFilter ( final BloomFilter other , final IntConsumer action ) {
verifyShape ( other ) ;
if ( other instanceof ArrayCountingBloomFilter ) {
final int [] counts2 = ( ( ArrayCountingBloomFilter ) other ) . counts ;
for ( int i = 0 ; i < counts2 . length ; i ++ ) {
if ( counts2 [ i ] != 0 ) {
action . accept ( i ) ;
}
}
} else {
BitSet . valueOf ( other . getBits () ) . stream () . forEach ( action ) ;
}
}
private void applyAsHasher ( final Hasher hasher , final IntConsumer action ) {
verifyHasher ( hasher ) ;
IndexFilters . distinctIndexes ( hasher , getShape () , action ) ;
}
private void applyAsCountingBloomFilter ( final CountingBloomFilter other , final BitCountConsumer action ) {
verifyShape ( other ) ;
other . forEachCount ( action ) ;
}
private void increment ( int idx ) {
final int updated = counts [ idx ] + 1 ;
state |= updated ;
counts [ idx ] = updated ;
}
private void decrement ( int idx ) {
final int updated = counts [ idx ] - 1 ;
state |= updated ;
counts [ idx ] = updated ;
}
private void add ( int idx , int addend ) {
final int updated = counts [ idx ] + addend ;
state |= updated ;
counts [ idx ] = updated ;
}
private void subtract ( int idx , int subtrahend ) {
final int updated = counts [ idx ] - subtrahend ;
state |= updated ;
counts [ idx ] = updated ;
}
