public static < K , V > TransformedMultiValuedMap < K , V > transformingMap ( final MultiValuedMap < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
return new TransformedMultiValuedMap <> ( map , keyTransformer , valueTransformer ) ; MST[ReturnValsMutator]MSP[S]
}
public static < K , V > TransformedMultiValuedMap < K , V > transformedMap ( final MultiValuedMap < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
final TransformedMultiValuedMap < K , V > decorated =
new TransformedMultiValuedMap <> ( map , keyTransformer , valueTransformer ) ;
if ( ! map . isEmpty () ) {
final MultiValuedMap < K , V > mapCopy = new ArrayListValuedHashMap <> ( map ) ;
decorated . clear () ;
decorated . putAll ( mapCopy ) ;
}
return decorated ;
}
protected K transformKey ( final K object ) {
if ( keyTransformer == null ) {
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
@Override
public boolean put ( final K key , final V value ) {
return decorated () . put ( transformKey ( key ) , transformValue ( value ) ) ;
}
@Override
public boolean putAll ( final K key , final Iterable < ? extends V > values ) {
Objects . requireNonNull ( values , lr_1 ) ;
final Iterable < V > transformedValues = FluentIterable . of ( values ) . transform ( valueTransformer ) ;
final Iterator < ? extends V > it = transformedValues . iterator () ;
return it . hasNext () && CollectionUtils . addAll ( decorated () . get ( transformKey ( key ) ) , it ) ;
}
@Override
public boolean putAll ( final Map < ? extends K , ? extends V > map ) {
Objects . requireNonNull ( map , lr_2 ) ;
boolean changed = false ;
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
changed |= put ( entry . getKey () , entry . getValue () ) ;
}
return changed ;
}
@Override
public boolean putAll ( final MultiValuedMap < ? extends K , ? extends V > map ) {
Objects . requireNonNull ( map , lr_2 ) ;
boolean changed = false ;
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entries () ) {
changed |= put ( entry . getKey () , entry . getValue () ) ;
}
return changed ;
}
