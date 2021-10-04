public static < K , V > SortedBidiMap < K , V > unmodifiableSortedBidiMap ( final SortedBidiMap < K , ? extends V > map ) {
if ( map instanceof Unmodifiable ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
@SuppressWarnings ( lr_1 )
final SortedBidiMap < K , V > tmpMap = ( SortedBidiMap < K , V > ) map ;
return tmpMap ;
}
return new UnmodifiableSortedBidiMap <> ( map ) ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public V put ( final K key , final V value ) {
throw new UnsupportedOperationException () ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > mapToCopy ) {
throw new UnsupportedOperationException () ;
}
@Override
public V remove ( final Object key ) {
throw new UnsupportedOperationException () ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
final Set < Map . Entry < K , V > > set = super . entrySet () ;
return UnmodifiableEntrySet . unmodifiableEntrySet ( set ) ;
}
@Override
public Set < K > keySet () {
final Set < K > set = super . keySet () ;
return UnmodifiableSet . unmodifiableSet ( set ) ;
}
@Override
public Set < V > values () {
final Set < V > set = super . values () ;
return UnmodifiableSet . unmodifiableSet ( set ) ;
}
@Override
public K removeValue ( final Object value ) {
throw new UnsupportedOperationException () ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
final OrderedMapIterator < K , V > it = decorated () . mapIterator () ;
return UnmodifiableOrderedMapIterator . unmodifiableOrderedMapIterator ( it ) ;
}
@Override
public SortedBidiMap < V , K > inverseBidiMap () {
if ( inverse == null ) {
inverse = new UnmodifiableSortedBidiMap <> ( decorated () . inverseBidiMap () ) ;
inverse . inverse = this ;
}
return inverse ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
final SortedMap < K , V > sm = decorated () . subMap ( fromKey , toKey ) ;
return UnmodifiableSortedMap . unmodifiableSortedMap ( sm ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
final SortedMap < K , V > sm = decorated () . headMap ( toKey ) ;
return UnmodifiableSortedMap . unmodifiableSortedMap ( sm ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
final SortedMap < K , V > sm = decorated () . tailMap ( fromKey ) ;
return UnmodifiableSortedMap . unmodifiableSortedMap ( sm ) ;
}
