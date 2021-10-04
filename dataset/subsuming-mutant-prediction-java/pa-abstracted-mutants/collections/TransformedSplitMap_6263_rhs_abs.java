public static < J , K , U , V > TransformedSplitMap < J , K , U , V > transformingMap ( final Map < K , V > map ,
final Transformer < ? super J , ? extends K > keyTransformer ,
final Transformer < ? super U , ? extends V > valueTransformer ) {
return new TransformedSplitMap <> ( map , keyTransformer , valueTransformer ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( decorated () ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ; MST[VoidMethodCallMutator]MSP[S]
map = ( Map < K , V > ) in . readObject () ;
}
protected K transformKey ( final J object ) {
return keyTransformer . transform ( object ) ;
}
protected V transformValue ( final U object ) {
return valueTransformer . transform ( object ) ;
}
@SuppressWarnings ( lr_1 )
protected Map < K , V > transformMap ( final Map < ? extends J , ? extends U > map ) {
if ( map . isEmpty () ) {
return ( Map < K , V > ) map ;
}
final Map < K , V > result = new LinkedMap <> ( map . size () ) ;
for ( final Map . Entry < ? extends J , ? extends U > entry : map . entrySet () ) {
result . put ( transformKey ( entry . getKey () ) , transformValue ( entry . getValue () ) ) ;
}
return result ;
}
protected V checkSetValue ( final U value ) {
return valueTransformer . transform ( value ) ;
}
@Override
public V put ( final J key , final U value ) {
return decorated () . put ( transformKey ( key ) , transformValue ( value ) ) ;
}
@Override
public void putAll ( final Map < ? extends J , ? extends U > mapToCopy ) {
decorated () . putAll ( transformMap ( mapToCopy ) ) ;
}
@Override
public void clear () {
decorated () . clear () ;
}
