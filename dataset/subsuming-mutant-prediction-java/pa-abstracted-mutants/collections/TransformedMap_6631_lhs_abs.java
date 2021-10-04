public static < K , V > TransformedMap < K , V > transformingMap ( final Map < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
return new TransformedMap <> ( map , keyTransformer , valueTransformer ) ;
}
public static < K , V > TransformedMap < K , V > transformedMap ( final Map < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
final TransformedMap < K , V > decorated = new TransformedMap <> ( map , keyTransformer , valueTransformer ) ;
if ( map . size () > 0 ) {
final Map < K , V > transformed = decorated . transformMap ( map ) ;
decorated . clear () ;
decorated . decorated () . putAll ( transformed ) ;
}
return decorated ;
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
protected K transformKey ( final K object ) {
if ( keyTransformer == null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
return object ;
}
return keyTransformer . transform ( object ) ;
}
protected V transformValue ( final V object ) {
if ( valueTransformer == null ) {
return object ;
}
return valueTransformer . transform ( object ) ;
}
@SuppressWarnings ( lr_1 )
protected Map < K , V > transformMap ( final Map < ? extends K , ? extends V > map ) {
if ( map . isEmpty () ) {
return ( Map < K , V > ) map ;
}
final Map < K , V > result = new LinkedMap <> ( map . size () ) ;
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
result . put ( transformKey ( entry . getKey () ) , transformValue ( entry . getValue () ) ) ;
}
return result ;
}
@Override
protected V checkSetValue ( final V value ) {
return valueTransformer . transform ( value ) ;
}
@Override
protected boolean isSetValueChecking () {
return valueTransformer != null ;
}
@Override
public V put ( K key , V value ) {
key = transformKey ( key ) ;
value = transformValue ( value ) ;
return decorated () . put ( key , value ) ;
}
@Override
public void putAll ( Map < ? extends K , ? extends V > mapToCopy ) {
mapToCopy = transformMap ( mapToCopy ) ;
decorated () . putAll ( mapToCopy ) ;
}
