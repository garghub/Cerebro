public static < K , V > BidiMap < K , V > unmodifiableBidiMap ( final BidiMap < ? extends K , ? extends V > map ) {
if ( map instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final BidiMap < K , V > tmpMap = ( BidiMap < K , V > ) map ;
return tmpMap ;
}
return new UnmodifiableBidiMap <> ( map ) ;
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
public MapIterator < K , V > mapIterator () {
final MapIterator < K , V > it = decorated () . mapIterator () ;
return UnmodifiableMapIterator . unmodifiableMapIterator ( it ) ;
}
@Override
public synchronized BidiMap < V , K > inverseBidiMap () {
if ( inverse == null ) {
inverse = new UnmodifiableBidiMap <> ( decorated () . inverseBidiMap () ) ;
inverse . inverse = this ;
}
return inverse ;
}
