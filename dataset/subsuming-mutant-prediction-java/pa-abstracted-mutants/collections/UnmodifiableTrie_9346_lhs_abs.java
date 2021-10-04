public static < K , V > Trie < K , V > unmodifiableTrie ( final Trie < K , ? extends V > trie ) {
if ( trie instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final Trie < K , V > tmpTrie = ( Trie < K , V > ) trie ;
return tmpTrie ;
}
return new UnmodifiableTrie <> ( trie ) ;
}
@Override
public Set < Entry < K , V > > entrySet () {
return Collections . unmodifiableSet ( delegate . entrySet () ) ; MST[ArgumentPropagationMutator]MSP[]
}
@Override
public Set < K > keySet () {
return Collections . unmodifiableSet ( delegate . keySet () ) ;
}
@Override
public Collection < V > values () {
return Collections . unmodifiableCollection ( delegate . values () ) ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public boolean containsKey ( final Object key ) {
return delegate . containsKey ( key ) ;
}
@Override
public boolean containsValue ( final Object value ) {
return delegate . containsValue ( value ) ;
}
@Override
public V get ( final Object key ) {
return delegate . get ( key ) ;
}
@Override
public boolean isEmpty () {
return delegate . isEmpty () ;
}
@Override
public V put ( final K key , final V value ) {
throw new UnsupportedOperationException () ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > m ) {
throw new UnsupportedOperationException () ;
}
@Override
public V remove ( final Object key ) {
throw new UnsupportedOperationException () ;
}
@Override
public int size () {
return delegate . size () ;
}
@Override
public K firstKey () {
return delegate . firstKey () ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
return Collections . unmodifiableSortedMap ( delegate . headMap ( toKey ) ) ;
}
@Override
public K lastKey () {
return delegate . lastKey () ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
return Collections . unmodifiableSortedMap ( delegate . subMap ( fromKey , toKey ) ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
return Collections . unmodifiableSortedMap ( delegate . tailMap ( fromKey ) ) ;
}
@Override
public SortedMap < K , V > prefixMap ( final K key ) {
return Collections . unmodifiableSortedMap ( delegate . prefixMap ( key ) ) ;
}
@Override
public Comparator < ? super K > comparator () {
return delegate . comparator () ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
final OrderedMapIterator < K , V > it = delegate . mapIterator () ;
return UnmodifiableOrderedMapIterator . unmodifiableOrderedMapIterator ( it ) ;
}
@Override
public K nextKey ( final K key ) {
return delegate . nextKey ( key ) ;
}
@Override
public K previousKey ( final K key ) {
return delegate . previousKey ( key ) ;
}
@Override
public int hashCode () {
return delegate . hashCode () ;
}
@Override
public boolean equals ( final Object obj ) {
return delegate . equals ( obj ) ;
}
@Override
public String toString () {
return delegate . toString () ;
}
