public static < K , V > SortedMap < K , V > unmodifiableSortedMap ( final SortedMap < K , ? extends V > map ) {
if ( map instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final SortedMap < K , V > tmpMap = ( SortedMap < K , V > ) map ;
return tmpMap ;
}
return new UnmodifiableSortedMap <> ( map ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
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
public Set < Map . Entry < K , V > > entrySet () {
return UnmodifiableEntrySet . unmodifiableEntrySet ( super . entrySet () ) ;
}
@Override
public Set < K > keySet () {
return UnmodifiableSet . unmodifiableSet ( super . keySet () ) ;
}
@Override
public Collection < V > values () {
return UnmodifiableCollection . unmodifiableCollection ( super . values () ) ;
}
@Override
public K firstKey () {
return decorated () . firstKey () ;
}
@Override
public K lastKey () {
return decorated () . lastKey () ;
}
@Override
public Comparator < ? super K > comparator () {
return decorated () . comparator () ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
return new UnmodifiableSortedMap <> ( decorated () . subMap ( fromKey , toKey ) ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
return new UnmodifiableSortedMap <> ( decorated () . headMap ( toKey ) ) ; MST[ConstructorCallMutator]MSP[N]
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
return new UnmodifiableSortedMap <> ( decorated () . tailMap ( fromKey ) ) ;
}
