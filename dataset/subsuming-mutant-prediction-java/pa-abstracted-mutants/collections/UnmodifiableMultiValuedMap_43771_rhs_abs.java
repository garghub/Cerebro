@SuppressWarnings ( lr_1 )
public static < K , V > UnmodifiableMultiValuedMap < K , V > unmodifiableMultiValuedMap (
final MultiValuedMap < ? extends K , ? extends V > map ) {
if ( map instanceof Unmodifiable ) {
return ( UnmodifiableMultiValuedMap < K , V > ) map ;
}
return new UnmodifiableMultiValuedMap <> ( map ) ; MST[ConstructorCallMutator]MSP[N]
}
@Override
public Collection < V > remove ( final Object key ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeMapping ( final Object key , final Object item ) {
throw new UnsupportedOperationException () ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public Collection < V > get ( final K key ) {
return UnmodifiableCollection . unmodifiableCollection ( decorated () . get ( key ) ) ;
}
@Override
public boolean put ( final K key , final V value ) {
throw new UnsupportedOperationException () ;
}
@Override
public Set < K > keySet () {
return UnmodifiableSet . unmodifiableSet ( decorated () . keySet () ) ;
}
@Override
public Collection < Entry < K , V > > entries () {
return UnmodifiableCollection . unmodifiableCollection ( decorated () . entries () ) ;
}
@Override
public MultiSet < K > keys () {
return UnmodifiableMultiSet . unmodifiableMultiSet ( decorated () . keys () ) ;
}
@Override
public Collection < V > values () {
return UnmodifiableCollection . unmodifiableCollection ( decorated () . values () ) ;
}
@Override
public Map < K , Collection < V > > asMap () {
return UnmodifiableMap . unmodifiableMap ( decorated () . asMap () ) ;
}
@Override
public MapIterator < K , V > mapIterator () {
return UnmodifiableMapIterator . unmodifiableMapIterator ( decorated () . mapIterator () ) ;
}
@Override
public boolean putAll ( final K key , final Iterable < ? extends V > values ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean putAll ( final Map < ? extends K , ? extends V > map ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean putAll ( final MultiValuedMap < ? extends K , ? extends V > map ) {
throw new UnsupportedOperationException () ;
}
