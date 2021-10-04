public static < K , V > Map < K , V > unmodifiableMap ( final Map < ? extends K , ? extends V > map ) {
if ( map instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final Map < K , V > tmpMap = ( Map < K , V > ) map ;
return tmpMap ;
}
return new UnmodifiableMap <> ( map ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ; MST[VoidMethodCallMutator]MSP[N]
map = ( Map < K , V > ) in . readObject () ;
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
public MapIterator < K , V > mapIterator () {
if ( map instanceof IterableMap ) {
final MapIterator < K , V > it = ( ( IterableMap < K , V > ) map ) . mapIterator () ;
return UnmodifiableMapIterator . unmodifiableMapIterator ( it ) ;
}
final MapIterator < K , V > it = new EntrySetMapIterator <> ( map ) ;
return UnmodifiableMapIterator . unmodifiableMapIterator ( it ) ;
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
