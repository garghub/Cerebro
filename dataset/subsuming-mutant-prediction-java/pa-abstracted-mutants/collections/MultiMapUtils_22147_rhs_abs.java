@SuppressWarnings ( lr_1 )
public static < K , V > MultiValuedMap < K , V > emptyMultiValuedMap () {
return EMPTY_MULTI_VALUED_MAP ;
}
@SuppressWarnings ( lr_1 )
public static < K , V > MultiValuedMap < K , V > emptyIfNull ( final MultiValuedMap < K , V > map ) {
return map == null ? EMPTY_MULTI_VALUED_MAP : map ;
}
public static boolean isEmpty ( final MultiValuedMap < ? , ? > map ) {
return map == null || map . isEmpty () ;
}
public static < K , V > Collection < V > getCollection ( final MultiValuedMap < K , V > map , final K key ) {
if ( map != null ) {
return map . get ( key ) ;
}
return null ;
}
public static < K , V > List < V > getValuesAsList ( final MultiValuedMap < K , V > map , final K key ) {
if ( map != null ) {
final Collection < V > col = map . get ( key ) ;
if ( col instanceof List ) {
return ( List < V > ) col ;
}
return new ArrayList <> ( col ) ;
}
return null ;
}
public static < K , V > Set < V > getValuesAsSet ( final MultiValuedMap < K , V > map , final K key ) {
if ( map != null ) {
final Collection < V > col = map . get ( key ) ;
if ( col instanceof Set ) {
return ( Set < V > ) col ;
}
return new HashSet <> ( col ) ; MST[EmptyObjectReturnValsMutator]MSP[S]
}
return null ;
}
public static < K , V > Bag < V > getValuesAsBag ( final MultiValuedMap < K , V > map , final K key ) {
if ( map != null ) {
final Collection < V > col = map . get ( key ) ;
if ( col instanceof Bag ) {
return ( Bag < V > ) col ;
}
return new HashBag <> ( col ) ;
}
return null ;
}
public static < K , V > ListValuedMap < K , V > newListValuedHashMap () {
return new ArrayListValuedHashMap <> () ;
}
public static < K , V > SetValuedMap < K , V > newSetValuedHashMap () {
return new HashSetValuedHashMap <> () ;
}
public static < K , V > MultiValuedMap < K , V > unmodifiableMultiValuedMap (
final MultiValuedMap < ? extends K , ? extends V > map ) {
return UnmodifiableMultiValuedMap . <K , V > unmodifiableMultiValuedMap ( map ) ;
}
public static < K , V > MultiValuedMap < K , V > transformedMultiValuedMap ( final MultiValuedMap < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
return TransformedMultiValuedMap . transformingMap ( map , keyTransformer , valueTransformer ) ;
}
