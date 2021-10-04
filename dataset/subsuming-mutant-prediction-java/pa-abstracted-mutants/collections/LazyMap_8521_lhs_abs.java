public static < K , V > LazyMap < K , V > lazyMap ( final Map < K , V > map , final Factory < ? extends V > factory ) {
return new LazyMap <> ( map , factory ) ;
}
public static < V , K > LazyMap < K , V > lazyMap ( final Map < K , V > map , final Transformer < ? super K , ? extends V > factory ) {
return new LazyMap <> ( map , factory ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < K , V > ) in . readObject () ; MST[NonVoidMethodCallMutator]MSP[]
}
@Override
public V get ( final Object key ) {
if ( map . containsKey ( key ) == false ) {
@SuppressWarnings ( lr_1 )
final K castKey = ( K ) key ;
final V value = factory . transform ( castKey ) ;
map . put ( castKey , value ) ;
return value ;
}
return map . get ( key ) ;
}
