@Override
public void clear () {
root . key = null ;
root . bitIndex = - 1 ;
root . value = null ;
root . parent = null ;
root . left = root ;
root . right = null ;
root . predecessor = root ;
size = 0 ;
incrementModCount () ;
}
@Override
public int size () {
return size ;
}
void incrementSize () {
size ++ ;
incrementModCount () ;
}
void decrementSize () {
size -- ;
incrementModCount () ;
}
private void incrementModCount () {
++ modCount ;
}
@Override
public V put ( final K key , final V value ) {
Objects . requireNonNull ( key , lr_1 ) ;
final int lengthInBits = lengthInBits ( key ) ;
if ( lengthInBits == 0 ) {
if ( root . isEmpty () ) {
incrementSize () ;
} else {
incrementModCount () ;
}
return root . setKeyValue ( key , value ) ;
}
final TrieEntry < K , V > found = getNearestEntryForKey ( key , lengthInBits ) ;
if ( compareKeys ( key , found . key ) ) {
if ( found . isEmpty () ) {
incrementSize () ;
} else {
incrementModCount () ;
}
return found . setKeyValue ( key , value ) ;
}
final int bitIndex = bitIndex ( key , found . key ) ;
if ( ! KeyAnalyzer . isOutOfBoundsIndex ( bitIndex ) ) { MST[rv.ROR1Mutator]MSP[]
if ( KeyAnalyzer . isValidBitIndex ( bitIndex ) ) {
final TrieEntry < K , V > t = new TrieEntry <> ( key , value , bitIndex ) ;
addEntry ( t , lengthInBits ) ;
incrementSize () ;
return null ;
} else if ( KeyAnalyzer . isNullBitKey ( bitIndex ) ) {
if ( root . isEmpty () ) {
incrementSize () ;
} else {
incrementModCount () ;
}
return root . setKeyValue ( key , value ) ;
} else if ( KeyAnalyzer . isEqualBitKey ( bitIndex ) ) {
if ( found != root ) {
incrementModCount () ;
return found . setKeyValue ( key , value ) ;
}
}
}
throw new IllegalArgumentException ( lr_2 + key + lr_3 + value + lr_4 + bitIndex ) ;
}
TrieEntry < K , V > addEntry ( final TrieEntry < K , V > entry , final int lengthInBits ) {
TrieEntry < K , V > current = root . left ;
TrieEntry < K , V > path = root ;
while ( true ) {
if ( current . bitIndex >= entry . bitIndex
|| current . bitIndex <= path . bitIndex ) {
entry . predecessor = entry ;
if ( ! isBitSet ( entry . key , entry . bitIndex , lengthInBits ) ) {
entry . left = entry ;
entry . right = current ;
} else {
entry . left = current ;
entry . right = entry ;
}
entry . parent = path ;
if ( current . bitIndex >= entry . bitIndex ) {
current . parent = entry ;
}
if ( current . bitIndex <= path . bitIndex ) {
current . predecessor = entry ;
}
if ( path == root || ! isBitSet ( entry . key , path . bitIndex , lengthInBits ) ) {
path . left = entry ;
} else {
path . right = entry ;
}
return entry ;
}
path = current ;
if ( ! isBitSet ( entry . key , current . bitIndex , lengthInBits ) ) {
current = current . left ;
} else {
current = current . right ;
}
}
}
@Override
public V get ( final Object k ) {
final TrieEntry < K , V > entry = getEntry ( k ) ;
return entry != null ? entry . getValue () : null ;
}
TrieEntry < K , V > getEntry ( final Object k ) {
final K key = castKey ( k ) ;
if ( key == null ) {
return null ;
}
final int lengthInBits = lengthInBits ( key ) ;
final TrieEntry < K , V > entry = getNearestEntryForKey ( key , lengthInBits ) ;
return ! entry . isEmpty () && compareKeys ( key , entry . key ) ? entry : null ;
}
public Map . Entry < K , V > select ( final K key ) {
final int lengthInBits = lengthInBits ( key ) ;
final Reference < Map . Entry < K , V > > reference = new Reference <> () ;
if ( ! selectR ( root . left , - 1 , key , lengthInBits , reference ) ) {
return reference . get () ;
}
return null ;
}
public K selectKey ( final K key ) {
final Map . Entry < K , V > entry = select ( key ) ;
if ( entry == null ) {
return null ;
}
return entry . getKey () ;
}
public V selectValue ( final K key ) {
final Map . Entry < K , V > entry = select ( key ) ;
if ( entry == null ) {
return null ;
}
return entry . getValue () ;
}
private boolean selectR ( final TrieEntry < K , V > h , final int bitIndex ,
final K key , final int lengthInBits ,
final Reference < Map . Entry < K , V > > reference ) {
if ( h . bitIndex <= bitIndex ) {
if ( ! h . isEmpty () ) {
reference . set ( h ) ;
return false ;
}
return true ;
}
if ( ! isBitSet ( key , h . bitIndex , lengthInBits ) ) {
if ( selectR ( h . left , h . bitIndex , key , lengthInBits , reference ) ) {
return selectR ( h . right , h . bitIndex , key , lengthInBits , reference ) ;
}
} else {
if ( selectR ( h . right , h . bitIndex , key , lengthInBits , reference ) ) {
return selectR ( h . left , h . bitIndex , key , lengthInBits , reference ) ;
}
}
return false ;
}
@Override
public boolean containsKey ( final Object k ) {
if ( k == null ) {
return false ;
}
final K key = castKey ( k ) ;
final int lengthInBits = lengthInBits ( key ) ;
final TrieEntry < K , V > entry = getNearestEntryForKey ( key , lengthInBits ) ;
return ! entry . isEmpty () && compareKeys ( key , entry . key ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( entrySet == null ) {
entrySet = new EntrySet () ;
}
return entrySet ;
}
@Override
public Set < K > keySet () {
if ( keySet == null ) {
keySet = new KeySet () ;
}
return keySet ;
}
@Override
public Collection < V > values () {
if ( values == null ) {
values = new Values () ;
}
return values ;
}
@Override
public V remove ( final Object k ) {
if ( k == null ) {
return null ;
}
final K key = castKey ( k ) ;
final int lengthInBits = lengthInBits ( key ) ;
TrieEntry < K , V > current = root . left ;
TrieEntry < K , V > path = root ;
while ( true ) {
if ( current . bitIndex <= path . bitIndex ) {
if ( ! current . isEmpty () && compareKeys ( key , current . key ) ) {
return removeEntry ( current ) ;
}
return null ;
}
path = current ;
if ( ! isBitSet ( key , current . bitIndex , lengthInBits ) ) {
current = current . left ;
} else {
current = current . right ;
}
}
}
TrieEntry < K , V > getNearestEntryForKey ( final K key , final int lengthInBits ) {
TrieEntry < K , V > current = root . left ;
TrieEntry < K , V > path = root ;
while ( true ) {
if ( current . bitIndex <= path . bitIndex ) {
return current ;
}
path = current ;
if ( ! isBitSet ( key , current . bitIndex , lengthInBits ) ) {
current = current . left ;
} else {
current = current . right ;
}
}
}
V removeEntry ( final TrieEntry < K , V > h ) {
if ( h != root ) {
if ( h . isInternalNode () ) {
removeInternalEntry ( h ) ;
} else {
removeExternalEntry ( h ) ;
}
}
decrementSize () ;
return h . setKeyValue ( null , null ) ;
}
private void removeExternalEntry ( final TrieEntry < K , V > h ) {
if ( h == root ) {
throw new IllegalArgumentException ( lr_5 ) ;
} else if ( ! h . isExternalNode () ) {
throw new IllegalArgumentException ( h + lr_6 ) ;
}
final TrieEntry < K , V > parent = h . parent ;
final TrieEntry < K , V > child = h . left == h ? h . right : h . left ;
if ( parent . left == h ) {
parent . left = child ;
} else {
parent . right = child ;
}
if ( child . bitIndex > parent . bitIndex ) {
child . parent = parent ;
} else {
child . predecessor = parent ;
}
}
private void removeInternalEntry ( final TrieEntry < K , V > h ) {
if ( h == root ) {
throw new IllegalArgumentException ( lr_5 ) ;
} else if ( ! h . isInternalNode () ) {
throw new IllegalArgumentException ( h + lr_7 ) ;
}
final TrieEntry < K , V > p = h . predecessor ;
p . bitIndex = h . bitIndex ;
{
final TrieEntry < K , V > parent = p . parent ;
final TrieEntry < K , V > child = p . left == h ? p . right : p . left ;
if ( p . predecessor == p && p . parent != h ) {
p . predecessor = p . parent ;
}
if ( parent . left == p ) {
parent . left = child ;
} else {
parent . right = child ;
}
if ( child . bitIndex > parent . bitIndex ) {
child . parent = parent ;
}
}
{
if ( h . left . parent == h ) {
h . left . parent = p ;
}
if ( h . right . parent == h ) {
h . right . parent = p ;
}
if ( h . parent . left == h ) {
h . parent . left = p ;
} else {
h . parent . right = p ;
}
}
p . parent = h . parent ;
p . left = h . left ;
p . right = h . right ;
if ( isValidUplink ( p . left , p ) ) {
p . left . predecessor = p ;
}
if ( isValidUplink ( p . right , p ) ) {
p . right . predecessor = p ;
}
}
TrieEntry < K , V > nextEntry ( final TrieEntry < K , V > node ) {
if ( node == null ) {
return firstEntry () ;
}
return nextEntryImpl ( node . predecessor , node , null ) ;
}
TrieEntry < K , V > nextEntryImpl ( final TrieEntry < K , V > start ,
final TrieEntry < K , V > previous , final TrieEntry < K , V > tree ) {
TrieEntry < K , V > current = start ;
if ( previous == null || start != previous . predecessor ) {
while ( ! current . left . isEmpty () ) {
if ( previous == current . left ) {
break;
}
if ( isValidUplink ( current . left , current ) ) {
return current . left ;
}
current = current . left ;
}
}
if ( current . isEmpty () ) {
return null ;
}
if ( current . right == null ) {
return null ;
}
if ( previous != current . right ) {
if ( isValidUplink ( current . right , current ) ) {
return current . right ;
}
return nextEntryImpl ( current . right , previous , tree ) ;
}
while ( current == current . parent . right ) {
if ( current == tree ) {
return null ;
}
current = current . parent ;
}
if ( current == tree ) {
return null ;
}
if ( current . parent . right == null ) {
return null ;
}
if ( previous != current . parent . right
&& isValidUplink ( current . parent . right , current . parent ) ) {
return current . parent . right ;
}
if ( current . parent . right == current . parent ) {
return null ;
}
return nextEntryImpl ( current . parent . right , previous , tree ) ;
}
TrieEntry < K , V > firstEntry () {
if ( isEmpty () ) {
return null ;
}
return followLeft ( root ) ;
}
TrieEntry < K , V > followLeft ( TrieEntry < K , V > node ) {
while ( true ) {
TrieEntry < K , V > child = node . left ;
if ( child . isEmpty () ) {
child = node . right ;
}
if ( child . bitIndex <= node . bitIndex ) {
return child ;
}
node = child ;
}
}
@Override
public Comparator < ? super K > comparator () {
return getKeyAnalyzer () ;
}
@Override
public K firstKey () {
if ( size () == 0 ) {
throw new NoSuchElementException () ;
}
return firstEntry () . getKey () ;
}
@Override
public K lastKey () {
final TrieEntry < K , V > entry = lastEntry () ;
if ( entry != null ) {
return entry . getKey () ;
}
throw new NoSuchElementException () ;
}
@Override
public K nextKey ( final K key ) {
Objects . requireNonNull ( key , lr_1 ) ;
final TrieEntry < K , V > entry = getEntry ( key ) ;
if ( entry != null ) {
final TrieEntry < K , V > nextEntry = nextEntry ( entry ) ;
return nextEntry != null ? nextEntry . getKey () : null ;
}
return null ;
}
@Override
public K previousKey ( final K key ) {
Objects . requireNonNull ( key , lr_1 ) ;
final TrieEntry < K , V > entry = getEntry ( key ) ;
if ( entry != null ) {
final TrieEntry < K , V > prevEntry = previousEntry ( entry ) ;
return prevEntry != null ? prevEntry . getKey () : null ;
}
return null ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
return new TrieMapIterator () ;
}
@Override
public SortedMap < K , V > prefixMap ( final K key ) {
return getPrefixMapByBits ( key , 0 , lengthInBits ( key ) ) ;
}
private SortedMap < K , V > getPrefixMapByBits ( final K key , final int offsetInBits , final int lengthInBits ) {
final int offsetLength = offsetInBits + lengthInBits ;
if ( offsetLength > lengthInBits ( key ) ) {
throw new IllegalArgumentException ( offsetInBits + lr_8
+ lengthInBits + lr_9 + lengthInBits ( key ) ) ;
}
if ( offsetLength == 0 ) {
return this ;
}
return new PrefixRangeMap ( key , offsetInBits , lengthInBits ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
return new RangeEntryMap ( null , toKey ) ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
return new RangeEntryMap ( fromKey , toKey ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
return new RangeEntryMap ( fromKey , null ) ;
}
TrieEntry < K , V > higherEntry ( final K key ) {
final int lengthInBits = lengthInBits ( key ) ;
if ( lengthInBits == 0 ) {
if ( ! root . isEmpty () ) {
if ( size () > 1 ) {
return nextEntry ( root ) ;
}
return null ;
}
return firstEntry () ;
}
final TrieEntry < K , V > found = getNearestEntryForKey ( key , lengthInBits ) ;
if ( compareKeys ( key , found . key ) ) {
return nextEntry ( found ) ;
}
final int bitIndex = bitIndex ( key , found . key ) ;
if ( KeyAnalyzer . isValidBitIndex ( bitIndex ) ) {
final TrieEntry < K , V > added = new TrieEntry <> ( key , null , bitIndex ) ;
addEntry ( added , lengthInBits ) ;
incrementSize () ;
final TrieEntry < K , V > ceil = nextEntry ( added ) ;
removeEntry ( added ) ;
modCount -= 2 ;
return ceil ;
} else if ( KeyAnalyzer . isNullBitKey ( bitIndex ) ) {
if ( ! root . isEmpty () ) {
return firstEntry () ;
} else if ( size () > 1 ) {
return nextEntry ( firstEntry () ) ;
} else {
return null ;
}
} else if ( KeyAnalyzer . isEqualBitKey ( bitIndex ) ) {
return nextEntry ( found ) ;
}
throw new IllegalStateException ( lr_10 + key ) ;
}
TrieEntry < K , V > ceilingEntry ( final K key ) {
final int lengthInBits = lengthInBits ( key ) ;
if ( lengthInBits == 0 ) {
if ( ! root . isEmpty () ) {
return root ;
}
return firstEntry () ;
}
final TrieEntry < K , V > found = getNearestEntryForKey ( key , lengthInBits ) ;
if ( compareKeys ( key , found . key ) ) {
return found ;
}
final int bitIndex = bitIndex ( key , found . key ) ;
if ( KeyAnalyzer . isValidBitIndex ( bitIndex ) ) {
final TrieEntry < K , V > added = new TrieEntry <> ( key , null , bitIndex ) ;
addEntry ( added , lengthInBits ) ;
incrementSize () ;
final TrieEntry < K , V > ceil = nextEntry ( added ) ;
removeEntry ( added ) ;
modCount -= 2 ;
return ceil ;
} else if ( KeyAnalyzer . isNullBitKey ( bitIndex ) ) {
if ( ! root . isEmpty () ) {
return root ;
}
return firstEntry () ;
} else if ( KeyAnalyzer . isEqualBitKey ( bitIndex ) ) {
return found ;
}
throw new IllegalStateException ( lr_10 + key ) ;
}
TrieEntry < K , V > lowerEntry ( final K key ) {
final int lengthInBits = lengthInBits ( key ) ;
if ( lengthInBits == 0 ) {
return null ;
}
final TrieEntry < K , V > found = getNearestEntryForKey ( key , lengthInBits ) ;
if ( compareKeys ( key , found . key ) ) {
return previousEntry ( found ) ;
}
final int bitIndex = bitIndex ( key , found . key ) ;
if ( KeyAnalyzer . isValidBitIndex ( bitIndex ) ) {
final TrieEntry < K , V > added = new TrieEntry <> ( key , null , bitIndex ) ;
addEntry ( added , lengthInBits ) ;
incrementSize () ;
final TrieEntry < K , V > prior = previousEntry ( added ) ;
removeEntry ( added ) ;
modCount -= 2 ;
return prior ;
} else if ( KeyAnalyzer . isNullBitKey ( bitIndex ) ) {
return null ;
} else if ( KeyAnalyzer . isEqualBitKey ( bitIndex ) ) {
return previousEntry ( found ) ;
}
throw new IllegalStateException ( lr_10 + key ) ;
}
TrieEntry < K , V > floorEntry ( final K key ) {
final int lengthInBits = lengthInBits ( key ) ;
if ( lengthInBits == 0 ) {
if ( ! root . isEmpty () ) {
return root ;
}
return null ;
}
final TrieEntry < K , V > found = getNearestEntryForKey ( key , lengthInBits ) ;
if ( compareKeys ( key , found . key ) ) {
return found ;
}
final int bitIndex = bitIndex ( key , found . key ) ;
if ( KeyAnalyzer . isValidBitIndex ( bitIndex ) ) {
final TrieEntry < K , V > added = new TrieEntry <> ( key , null , bitIndex ) ;
addEntry ( added , lengthInBits ) ;
incrementSize () ;
final TrieEntry < K , V > floor = previousEntry ( added ) ;
removeEntry ( added ) ;
modCount -= 2 ;
return floor ;
} else if ( KeyAnalyzer . isNullBitKey ( bitIndex ) ) {
if ( ! root . isEmpty () ) {
return root ;
}
return null ;
} else if ( KeyAnalyzer . isEqualBitKey ( bitIndex ) ) {
return found ;
}
throw new IllegalStateException ( lr_10 + key ) ;
}
TrieEntry < K , V > subtree ( final K prefix , final int offsetInBits , final int lengthInBits ) {
TrieEntry < K , V > current = root . left ;
TrieEntry < K , V > path = root ;
while ( true ) {
if ( current . bitIndex <= path . bitIndex || lengthInBits <= current . bitIndex ) {
break;
}
path = current ;
if ( ! isBitSet ( prefix , offsetInBits + current . bitIndex , offsetInBits + lengthInBits ) ) {
current = current . left ;
} else {
current = current . right ;
}
}
final TrieEntry < K , V > entry = current . isEmpty () ? path : current ;
if ( entry . isEmpty () ) {
return null ;
}
final int endIndexInBits = offsetInBits + lengthInBits ;
if ( entry == root && lengthInBits ( entry . getKey () ) < endIndexInBits ) {
return null ;
}
if ( isBitSet ( prefix , endIndexInBits - 1 , endIndexInBits )
!= isBitSet ( entry . key , lengthInBits - 1 , lengthInBits ( entry . key ) ) ) {
return null ;
}
final int bitIndex = getKeyAnalyzer () . bitIndex ( prefix , offsetInBits , lengthInBits ,
entry . key , 0 , lengthInBits ( entry . getKey () ) ) ;
if ( bitIndex >= 0 && bitIndex < lengthInBits ) {
return null ;
}
return entry ;
}
TrieEntry < K , V > lastEntry () {
return followRight ( root . left ) ;
}
TrieEntry < K , V > followRight ( TrieEntry < K , V > node ) {
if ( node . right == null ) {
return null ;
}
while ( node . right . bitIndex > node . bitIndex ) {
node = node . right ;
}
return node . right ;
}
TrieEntry < K , V > previousEntry ( final TrieEntry < K , V > start ) {
if ( start . predecessor == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( start . predecessor . right == start ) {
if ( isValidUplink ( start . predecessor . left , start . predecessor ) ) {
return start . predecessor . left ;
}
return followRight ( start . predecessor . left ) ;
}
TrieEntry < K , V > node = start . predecessor ;
while ( node . parent != null && node == node . parent . left ) {
node = node . parent ;
}
if ( node . parent == null ) {
return null ;
}
if ( isValidUplink ( node . parent . left , node . parent ) ) {
if ( node . parent . left == root ) {
if ( root . isEmpty () ) {
return null ;
}
return root ;
}
return node . parent . left ;
}
return followRight ( node . parent . left ) ;
}
TrieEntry < K , V > nextEntryInSubtree ( final TrieEntry < K , V > node ,
final TrieEntry < K , V > parentOfSubtree ) {
if ( node == null ) {
return firstEntry () ;
}
return nextEntryImpl ( node . predecessor , node , parentOfSubtree ) ;
}
static boolean isValidUplink ( final TrieEntry < ? , ? > next , final TrieEntry < ? , ? > from ) {
return next != null && next . bitIndex <= from . bitIndex && ! next . isEmpty () ;
}
public void set ( final E item ) {
this . item = item ;
}
public E get () {
return item ;
}
public boolean isEmpty () {
return key == null ;
}
public boolean isInternalNode () {
return left != this && right != this ;
}
public boolean isExternalNode () {
return ! isInternalNode () ;
}
@Override
public String toString () {
final StringBuilder buffer = new StringBuilder () ;
if ( bitIndex == - 1 ) {
buffer . append ( lr_12 ) ;
} else {
buffer . append ( lr_13 ) ;
}
buffer . append ( lr_14 ) . append ( getKey () ) . append ( lr_15 ) . append ( bitIndex ) . append ( lr_16 ) ;
buffer . append ( lr_17 ) . append ( getValue () ) . append ( lr_4 ) ;
if ( parent != null ) {
if ( parent . bitIndex == - 1 ) {
buffer . append ( lr_18 ) . append ( lr_19 ) ;
} else {
buffer . append ( lr_18 ) . append ( parent . getKey () ) . append ( lr_15 ) . append ( parent . bitIndex ) . append ( lr_20 ) ;
}
} else {
buffer . append ( lr_18 ) . append ( lr_21 ) ;
}
buffer . append ( lr_4 ) ;
if ( left != null ) {
if ( left . bitIndex == - 1 ) {
buffer . append ( lr_22 ) . append ( lr_19 ) ;
} else {
buffer . append ( lr_22 ) . append ( left . getKey () ) . append ( lr_15 ) . append ( left . bitIndex ) . append ( lr_20 ) ;
}
} else {
buffer . append ( lr_22 ) . append ( lr_21 ) ;
}
buffer . append ( lr_4 ) ;
if ( right != null ) {
if ( right . bitIndex == - 1 ) {
buffer . append ( lr_23 ) . append ( lr_19 ) ;
} else {
buffer . append ( lr_23 ) . append ( right . getKey () ) . append ( lr_15 ) . append ( right . bitIndex ) . append ( lr_20 ) ;
}
} else {
buffer . append ( lr_23 ) . append ( lr_21 ) ;
}
buffer . append ( lr_4 ) ;
if ( predecessor != null ) {
if ( predecessor . bitIndex == - 1 ) {
buffer . append ( lr_24 ) . append ( lr_19 ) ;
} else {
buffer . append ( lr_24 ) . append ( predecessor . getKey () ) . append ( lr_15 ) .
append ( predecessor . bitIndex ) . append ( lr_20 ) ;
}
}
buffer . append ( lr_25 ) ;
return buffer . toString () ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
return new EntryIterator () ;
}
@Override
public boolean contains ( final Object o ) {
if ( ! ( o instanceof Map . Entry ) ) {
return false ;
}
final TrieEntry < K , V > candidate = getEntry ( ( ( Map . Entry < ? , ? > ) o ) . getKey () ) ;
return candidate != null && candidate . equals ( o ) ;
}
@Override
public boolean remove ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
if ( contains ( obj ) == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
AbstractPatriciaTrie . this . remove ( entry . getKey () ) ;
return true ;
}
@Override
public int size () {
return AbstractPatriciaTrie . this . size () ;
}
@Override
public void clear () {
AbstractPatriciaTrie . this . clear () ;
}
@Override
public Map . Entry < K , V > next () {
return nextEntry () ;
}
@Override
public Iterator < K > iterator () {
return new KeyIterator () ;
}
@Override
public int size () {
return AbstractPatriciaTrie . this . size () ;
}
@Override
public boolean contains ( final Object o ) {
return containsKey ( o ) ;
}
@Override
public boolean remove ( final Object o ) {
final int size = size () ;
AbstractPatriciaTrie . this . remove ( o ) ;
return size != size () ;
}
@Override
public void clear () {
AbstractPatriciaTrie . this . clear () ;
}
@Override
public K next () {
return nextEntry () . getKey () ;
}
@Override
public Iterator < V > iterator () {
return new ValueIterator () ;
}
@Override
public int size () {
return AbstractPatriciaTrie . this . size () ;
}
@Override
public boolean contains ( final Object o ) {
return containsValue ( o ) ;
}
@Override
public void clear () {
AbstractPatriciaTrie . this . clear () ;
}
@Override
public boolean remove ( final Object o ) {
for ( final Iterator < V > it = iterator () ; it . hasNext () ; ) {
final V value = it . next () ;
if ( compare ( value , o ) ) {
it . remove () ;
return true ;
}
}
return false ;
}
@Override
public V next () {
return nextEntry () . getValue () ;
}
protected TrieEntry < K , V > nextEntry () {
if ( expectedModCount != AbstractPatriciaTrie . this . modCount ) {
throw new ConcurrentModificationException () ;
}
final TrieEntry < K , V > e = next ;
if ( e == null ) {
throw new NoSuchElementException () ;
}
next = findNext ( e ) ;
current = e ;
return e ;
}
protected TrieEntry < K , V > findNext ( final TrieEntry < K , V > prior ) {
return AbstractPatriciaTrie . this . nextEntry ( prior ) ;
}
@Override
public boolean hasNext () {
return next != null ;
}
@Override
public void remove () {
if ( current == null ) {
throw new IllegalStateException () ;
}
if ( expectedModCount != AbstractPatriciaTrie . this . modCount ) {
throw new ConcurrentModificationException () ;
}
final TrieEntry < K , V > node = current ;
current = null ;
AbstractPatriciaTrie . this . removeEntry ( node ) ;
expectedModCount = AbstractPatriciaTrie . this . modCount ;
}
@Override
public K next () {
return nextEntry () . getKey () ;
}
@Override
public K getKey () {
if ( current == null ) {
throw new IllegalStateException () ;
}
return current . getKey () ;
}
@Override
public V getValue () {
if ( current == null ) {
throw new IllegalStateException () ;
}
return current . getValue () ;
}
@Override
public V setValue ( final V value ) {
if ( current == null ) {
throw new IllegalStateException () ;
}
return current . setValue ( value ) ;
}
@Override
public boolean hasPrevious () {
return previous != null ;
}
@Override
public K previous () {
return previousEntry () . getKey () ;
}
@Override
protected TrieEntry < K , V > nextEntry () {
final TrieEntry < K , V > nextEntry = super . nextEntry () ;
previous = nextEntry ;
return nextEntry ;
}
protected TrieEntry < K , V > previousEntry () {
if ( expectedModCount != AbstractPatriciaTrie . this . modCount ) {
throw new ConcurrentModificationException () ;
}
final TrieEntry < K , V > e = previous ;
if ( e == null ) {
throw new NoSuchElementException () ;
}
previous = AbstractPatriciaTrie . this . previousEntry ( e ) ;
next = current ;
current = e ;
return current ;
}
@Override
public Comparator < ? super K > comparator () {
return AbstractPatriciaTrie . this . comparator () ;
}
@Override
public boolean containsKey ( final Object key ) {
if ( ! inRange ( castKey ( key ) ) ) {
return false ;
}
return AbstractPatriciaTrie . this . containsKey ( key ) ;
}
@Override
public V remove ( final Object key ) {
if ( ! inRange ( castKey ( key ) ) ) {
return null ;
}
return AbstractPatriciaTrie . this . remove ( key ) ;
}
@Override
public V get ( final Object key ) {
if ( ! inRange ( castKey ( key ) ) ) {
return null ;
}
return AbstractPatriciaTrie . this . get ( key ) ;
}
@Override
public V put ( final K key , final V value ) {
if ( ! inRange ( key ) ) {
throw new IllegalArgumentException ( lr_26 + key ) ;
}
return AbstractPatriciaTrie . this . put ( key , value ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( entrySet == null ) {
entrySet = createEntrySet () ;
}
return entrySet ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
if ( ! inRange2 ( fromKey ) ) {
throw new IllegalArgumentException ( lr_27 + fromKey ) ;
}
if ( ! inRange2 ( toKey ) ) {
throw new IllegalArgumentException ( lr_28 + toKey ) ;
}
return createRangeMap ( fromKey , isFromInclusive () , toKey , isToInclusive () ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
if ( ! inRange2 ( toKey ) ) {
throw new IllegalArgumentException ( lr_28 + toKey ) ;
}
return createRangeMap ( getFromKey () , isFromInclusive () , toKey , isToInclusive () ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
if ( ! inRange2 ( fromKey ) ) {
throw new IllegalArgumentException ( lr_27 + fromKey ) ;
}
return createRangeMap ( fromKey , isFromInclusive () , getToKey () , isToInclusive () ) ;
}
protected boolean inRange ( final K key ) {
final K fromKey = getFromKey () ;
final K toKey = getToKey () ;
return ( fromKey == null || inFromRange ( key , false ) ) && ( toKey == null || inToRange ( key , false ) ) ;
}
protected boolean inRange2 ( final K key ) {
final K fromKey = getFromKey () ;
final K toKey = getToKey () ;
return ( fromKey == null || inFromRange ( key , false ) ) && ( toKey == null || inToRange ( key , true ) ) ;
}
protected boolean inFromRange ( final K key , final boolean forceInclusive ) {
final K fromKey = getFromKey () ;
final boolean fromInclusive = isFromInclusive () ;
final int ret = getKeyAnalyzer () . compare ( key , fromKey ) ;
if ( fromInclusive || forceInclusive ) {
return ret >= 0 ;
}
return ret > 0 ;
}
protected boolean inToRange ( final K key , final boolean forceInclusive ) {
final K toKey = getToKey () ;
final boolean toInclusive = isToInclusive () ;
final int ret = getKeyAnalyzer () . compare ( key , toKey ) ;
if ( toInclusive || forceInclusive ) {
return ret <= 0 ;
}
return ret < 0 ;
}
@Override
public K firstKey () {
Map . Entry < K , V > e = null ;
if ( fromKey == null ) {
e = firstEntry () ;
} else {
if ( fromInclusive ) {
e = ceilingEntry ( fromKey ) ;
} else {
e = higherEntry ( fromKey ) ;
}
}
final K first = e != null ? e . getKey () : null ;
if ( e == null || toKey != null && ! inToRange ( first , false ) ) {
throw new NoSuchElementException () ;
}
return first ;
}
@Override
public K lastKey () {
Map . Entry < K , V > e ;
if ( toKey == null ) {
e = lastEntry () ;
} else {
if ( toInclusive ) {
e = floorEntry ( toKey ) ;
} else {
e = lowerEntry ( toKey ) ;
}
}
final K last = e != null ? e . getKey () : null ;
if ( e == null || fromKey != null && ! inFromRange ( last , false ) ) {
throw new NoSuchElementException () ;
}
return last ;
}
@Override
protected Set < Entry < K , V > > createEntrySet () {
return new RangeEntrySet ( this ) ;
}
@Override
public K getFromKey () {
return fromKey ;
}
@Override
public K getToKey () {
return toKey ;
}
@Override
public boolean isFromInclusive () {
return fromInclusive ;
}
@Override
public boolean isToInclusive () {
return toInclusive ;
}
@Override
protected SortedMap < K , V > createRangeMap ( final K fromKey , final boolean fromInclusive ,
final K toKey , final boolean toInclusive ) {
return new RangeEntryMap ( fromKey , fromInclusive , toKey , toInclusive ) ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
final K fromKey = delegate . getFromKey () ;
final K toKey = delegate . getToKey () ;
TrieEntry < K , V > first = null ;
if ( fromKey == null ) {
first = firstEntry () ;
} else {
first = ceilingEntry ( fromKey ) ;
}
TrieEntry < K , V > last = null ;
if ( toKey != null ) {
last = ceilingEntry ( toKey ) ;
}
return new EntryIterator ( first , last ) ;
}
@Override
public int size () {
if ( size == - 1 || expectedModCount != AbstractPatriciaTrie . this . modCount ) {
size = 0 ;
for ( final Iterator < ? > it = iterator () ; it . hasNext () ; it . next () ) {
++ size ;
}
expectedModCount = AbstractPatriciaTrie . this . modCount ;
}
return size ;
}
@Override
public boolean isEmpty () {
return ! iterator () . hasNext () ;
}
@SuppressWarnings ( lr_29 )
@Override
public boolean contains ( final Object o ) {
if ( ! ( o instanceof Map . Entry ) ) {
return false ;
}
final Map . Entry < K , V > entry = ( Map . Entry < K , V > ) o ;
final K key = entry . getKey () ;
if ( ! delegate . inRange ( key ) ) {
return false ;
}
final TrieEntry < K , V > node = getEntry ( key ) ;
return node != null && compare ( node . getValue () , entry . getValue () ) ;
}
@SuppressWarnings ( lr_29 )
@Override
public boolean remove ( final Object o ) {
if ( ! ( o instanceof Map . Entry ) ) {
return false ;
}
final Map . Entry < K , V > entry = ( Map . Entry < K , V > ) o ;
final K key = entry . getKey () ;
if ( ! delegate . inRange ( key ) ) {
return false ;
}
final TrieEntry < K , V > node = getEntry ( key ) ;
if ( node != null && compare ( node . getValue () , entry . getValue () ) ) {
removeEntry ( node ) ;
return true ;
}
return false ;
}
@Override
public boolean hasNext () {
return next != null && ! compare ( next . key , excludedKey ) ;
}
@Override
public Map . Entry < K , V > next () {
if ( next == null || compare ( next . key , excludedKey ) ) {
throw new NoSuchElementException () ;
}
return nextEntry () ;
}
private int fixup () {
if ( size == - 1 || AbstractPatriciaTrie . this . modCount != expectedModCount ) {
final Iterator < Map . Entry < K , V > > it = super . entrySet () . iterator () ;
size = 0 ;
Map . Entry < K , V > entry = null ;
if ( it . hasNext () ) {
entry = it . next () ;
size = 1 ;
}
fromKey = entry == null ? null : entry . getKey () ;
if ( fromKey != null ) {
final TrieEntry < K , V > prior = previousEntry ( ( TrieEntry < K , V > ) entry ) ;
fromKey = prior == null ? null : prior . getKey () ;
}
toKey = fromKey ;
while ( it . hasNext () ) {
++ size ;
entry = it . next () ;
}
toKey = entry == null ? null : entry . getKey () ;
if ( toKey != null ) {
entry = nextEntry ( ( TrieEntry < K , V > ) entry ) ;
toKey = entry == null ? null : entry . getKey () ;
}
expectedModCount = AbstractPatriciaTrie . this . modCount ;
}
return size ;
}
@Override
public K firstKey () {
fixup () ;
Map . Entry < K , V > e = null ;
if ( fromKey == null ) {
e = firstEntry () ;
} else {
e = higherEntry ( fromKey ) ;
}
final K first = e != null ? e . getKey () : null ;
if ( e == null || ! getKeyAnalyzer () . isPrefix ( prefix , offsetInBits , lengthInBits , first ) ) {
throw new NoSuchElementException () ;
}
return first ;
}
@Override
public K lastKey () {
fixup () ;
Map . Entry < K , V > e = null ;
if ( toKey == null ) {
e = lastEntry () ;
} else {
e = lowerEntry ( toKey ) ;
}
final K last = e != null ? e . getKey () : null ;
if ( e == null || ! getKeyAnalyzer () . isPrefix ( prefix , offsetInBits , lengthInBits , last ) ) {
throw new NoSuchElementException () ;
}
return last ;
}
@Override
protected boolean inRange ( final K key ) {
return getKeyAnalyzer () . isPrefix ( prefix , offsetInBits , lengthInBits , key ) ;
}
@Override
protected boolean inRange2 ( final K key ) {
return inRange ( key ) ;
}
@Override
protected boolean inFromRange ( final K key , final boolean forceInclusive ) {
return getKeyAnalyzer () . isPrefix ( prefix , offsetInBits , lengthInBits , key ) ;
}
@Override
protected boolean inToRange ( final K key , final boolean forceInclusive ) {
return getKeyAnalyzer () . isPrefix ( prefix , offsetInBits , lengthInBits , key ) ;
}
@Override
protected Set < Map . Entry < K , V > > createEntrySet () {
return new PrefixRangeEntrySet ( this ) ;
}
@Override
public K getFromKey () {
return fromKey ;
}
@Override
public K getToKey () {
return toKey ;
}
@Override
public boolean isFromInclusive () {
return false ;
}
@Override
public boolean isToInclusive () {
return false ;
}
@Override
protected SortedMap < K , V > createRangeMap ( final K fromKey , final boolean fromInclusive ,
final K toKey , final boolean toInclusive ) {
return new RangeEntryMap ( fromKey , fromInclusive , toKey , toInclusive ) ;
}
@Override
public void clear () {
final Iterator < Map . Entry < K , V > > it = AbstractPatriciaTrie . this . entrySet () . iterator () ;
final Set < K > currentKeys = keySet () ;
while ( it . hasNext () ) {
if ( currentKeys . contains ( it . next () . getKey () ) ) {
it . remove () ;
}
}
}
@Override
public int size () {
return delegate . fixup () ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
if ( AbstractPatriciaTrie . this . modCount != expectedModCount ) {
prefixStart = subtree ( delegate . prefix , delegate . offsetInBits , delegate . lengthInBits ) ;
expectedModCount = AbstractPatriciaTrie . this . modCount ;
}
if ( prefixStart == null ) {
final Set < Map . Entry < K , V > > empty = Collections . emptySet () ;
return empty . iterator () ;
} else if ( delegate . lengthInBits > prefixStart . bitIndex ) {
return new SingletonIterator ( prefixStart ) ;
} else {
return new EntryIterator ( prefixStart , delegate . prefix , delegate . offsetInBits , delegate . lengthInBits ) ;
}
}
@Override
public boolean hasNext () {
return hit == 0 ;
}
@Override
public Map . Entry < K , V > next () {
if ( hit != 0 ) {
throw new NoSuchElementException () ;
}
++ hit ;
return entry ;
}
@Override
public void remove () {
if ( hit != 1 ) {
throw new IllegalStateException () ;
}
++ hit ;
AbstractPatriciaTrie . this . removeEntry ( entry ) ;
}
@Override
public Map . Entry < K , V > next () {
final Map . Entry < K , V > entry = nextEntry () ;
if ( lastOne ) {
next = null ;
}
return entry ;
}
@Override
protected TrieEntry < K , V > findNext ( final TrieEntry < K , V > prior ) {
return AbstractPatriciaTrie . this . nextEntryInSubtree ( prior , subtree ) ;
}
@Override
public void remove () {
boolean needsFixing = false ;
final int bitIdx = subtree . bitIndex ;
if ( current == subtree ) {
needsFixing = true ;
}
super . remove () ;
if ( bitIdx != subtree . bitIndex || needsFixing ) {
subtree = subtree ( prefix , offset , lengthInBits ) ;
}
if ( lengthInBits >= subtree . bitIndex ) {
lastOne = true ;
}
}
@SuppressWarnings ( lr_29 )
private void readObject ( final ObjectInputStream stream ) throws IOException , ClassNotFoundException {
stream . defaultReadObject () ;
root = new TrieEntry <> ( null , null , - 1 ) ;
final int size = stream . readInt () ;
for ( int i = 0 ; i < size ; i ++ ) {
final K k = ( K ) stream . readObject () ;
final V v = ( V ) stream . readObject () ;
put ( k , v ) ;
}
}
private void writeObject ( final ObjectOutputStream stream ) throws IOException {
stream . defaultWriteObject () ;
stream . writeInt ( this . size () ) ;
for ( final Entry < K , V > entry : entrySet () ) {
stream . writeObject ( entry . getKey () ) ;
stream . writeObject ( entry . getValue () ) ;
}
}
