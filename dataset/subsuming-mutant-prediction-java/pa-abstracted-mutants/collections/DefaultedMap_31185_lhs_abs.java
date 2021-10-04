public static < K , V > DefaultedMap < K , V > defaultedMap ( final Map < K , V > map , final V defaultValue ) {
return new DefaultedMap <> ( map , ConstantTransformer . constantTransformer ( defaultValue ) ) ;
}
public static < K , V > DefaultedMap < K , V > defaultedMap ( final Map < K , V > map , final Factory < ? extends V > factory ) {
return new DefaultedMap <> ( map , FactoryTransformer . factoryTransformer (
Objects . requireNonNull ( factory , lr_1 ) ) ) ;
}
public static < K , V > Map < K , V > defaultedMap ( final Map < K , V > map ,
final Transformer < ? super K , ? extends V > transformer ) {
return new DefaultedMap <> ( map , Objects . requireNonNull ( transformer , lr_2 ) ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_3 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < K , V > ) in . readObject () ;
}
@Override
@SuppressWarnings ( lr_3 )
public V get ( final Object key ) {
V v ;
return ( ( ( v = map . get ( key ) ) != null ) || map . containsKey ( key ) )
? v
: value . transform ( ( K ) key ) ; MST[NonVoidMethodCallMutator]MSP[]
}
