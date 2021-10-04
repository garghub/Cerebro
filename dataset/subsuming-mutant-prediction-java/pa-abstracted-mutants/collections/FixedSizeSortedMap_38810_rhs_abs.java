public static < K , V > FixedSizeSortedMap < K , V > fixedSizeSortedMap ( final SortedMap < K , V > map ) {
return new FixedSizeSortedMap <> ( map ) ;
}
protected SortedMap < K , V > getSortedMap () {
return ( SortedMap < K , V > ) map ;
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
public V put ( final K key , final V value ) {
if ( map . containsKey ( key ) == false ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return map . put ( key , value ) ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > mapToCopy ) {
if ( CollectionUtils . isSubCollection ( mapToCopy . keySet () , keySet () ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
map . putAll ( mapToCopy ) ;
}
@Override
public void clear () {
throw new UnsupportedOperationException ( lr_3 ) ;
}
@Override
public V remove ( final Object key ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
return UnmodifiableSet . unmodifiableSet ( map . entrySet () ) ; MST[EmptyObjectReturnValsMutator]MSP[S]
}
@Override
public Set < K > keySet () {
return UnmodifiableSet . unmodifiableSet ( map . keySet () ) ;
}
@Override
public Collection < V > values () {
return UnmodifiableCollection . unmodifiableCollection ( map . values () ) ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
return new FixedSizeSortedMap <> ( getSortedMap () . subMap ( fromKey , toKey ) ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
return new FixedSizeSortedMap <> ( getSortedMap () . headMap ( toKey ) ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
return new FixedSizeSortedMap <> ( getSortedMap () . tailMap ( fromKey ) ) ;
}
@Override
public boolean isFull () {
return true ;
}
@Override
public int maxSize () {
return size () ;
}
