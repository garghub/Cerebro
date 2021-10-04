public static < K , V > FixedSizeMap < K , V > fixedSizeMap ( final Map < K , V > map ) {
return new FixedSizeMap <> ( map ) ;
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
for ( final K key : mapToCopy . keySet () ) {
if ( ! containsKey ( key ) ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
map . putAll ( mapToCopy ) ;
}
@Override
public void clear () {
throw new UnsupportedOperationException ( lr_3 ) ; MST[ConstructorCallMutator]MSP[S]
}
@Override
public V remove ( final Object key ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
final Set < Map . Entry < K , V > > set = map . entrySet () ;
return UnmodifiableSet . unmodifiableSet ( set ) ;
}
@Override
public Set < K > keySet () {
final Set < K > set = map . keySet () ;
return UnmodifiableSet . unmodifiableSet ( set ) ;
}
@Override
public Collection < V > values () {
final Collection < V > coll = map . values () ;
return UnmodifiableCollection . unmodifiableCollection ( coll ) ;
}
@Override
public boolean isFull () {
return true ;
}
@Override
public int maxSize () {
return size () ;
}
