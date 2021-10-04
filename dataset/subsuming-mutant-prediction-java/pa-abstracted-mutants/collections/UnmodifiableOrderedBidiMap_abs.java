public static < K , V > OrderedBidiMap < K , V > unmodifiableOrderedBidiMap (
final OrderedBidiMap < ? extends K , ? extends V > map ) {
if ( map instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final OrderedBidiMap < K , V > tmpMap = ( OrderedBidiMap < K , V > ) map ;
return tmpMap ;
}
return new UnmodifiableOrderedBidiMap <> ( map ) ;
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
public OrderedBidiMap < V , K > inverseBidiMap () {
return inverseOrderedBidiMap () ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
final OrderedMapIterator < K , V > it = decorated () . mapIterator () ;
return UnmodifiableOrderedMapIterator . unmodifiableOrderedMapIterator ( it ) ;
}
public OrderedBidiMap < V , K > inverseOrderedBidiMap () {
if ( inverse == null ) {
inverse = new UnmodifiableOrderedBidiMap <> ( decorated () . inverseBidiMap () ) ;
inverse . inverse = this ;
}
return inverse ;
}
