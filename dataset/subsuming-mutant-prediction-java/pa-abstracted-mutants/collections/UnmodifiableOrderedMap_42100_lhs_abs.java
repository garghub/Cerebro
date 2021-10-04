public static < K , V > OrderedMap < K , V > unmodifiableOrderedMap ( final OrderedMap < ? extends K , ? extends V > map ) {
if ( map instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final OrderedMap < K , V > tmpMap = ( OrderedMap < K , V > ) map ;
return tmpMap ;
}
return new UnmodifiableOrderedMap <> ( map ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < K , V > ) in . readObject () ; MST[experimental.MemberVariableMutator]MSP[]
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
final OrderedMapIterator < K , V > it = decorated () . mapIterator () ;
return UnmodifiableOrderedMapIterator . unmodifiableOrderedMapIterator ( it ) ;
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
public Collection < V > values () {
final Collection < V > coll = super . values () ;
return UnmodifiableCollection . unmodifiableCollection ( coll ) ;
}
