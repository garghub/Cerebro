public static < K , V > TransformedSortedMap < K , V > transformingSortedMap ( final SortedMap < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
return new TransformedSortedMap <> ( map , keyTransformer , valueTransformer ) ;
}
public static < K , V > TransformedSortedMap < K , V > transformedSortedMap ( final SortedMap < K , V > map ,
final Transformer < ? super K , ? extends K > keyTransformer ,
final Transformer < ? super V , ? extends V > valueTransformer ) {
final TransformedSortedMap < K , V > decorated =
new TransformedSortedMap <> ( map , keyTransformer , valueTransformer ) ;
if ( map . size () > 0 ) {
final Map < K , V > transformed = decorated . transformMap ( map ) ;
decorated . clear () ;
decorated . decorated () . putAll ( transformed ) ;
}
return decorated ;
}
protected SortedMap < K , V > getSortedMap () {
return ( SortedMap < K , V > ) map ;
}
@Override
public K firstKey () {
return getSortedMap () . firstKey () ;
}
@Override
public K lastKey () {
return getSortedMap () . lastKey () ;
}
@Override
public Comparator < ? super K > comparator () {
return getSortedMap () . comparator () ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
final SortedMap < K , V > map = getSortedMap () . subMap ( fromKey , toKey ) ;
return new TransformedSortedMap <> ( map , keyTransformer , valueTransformer ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
final SortedMap < K , V > map = getSortedMap () . headMap ( toKey ) ;
return new TransformedSortedMap <> ( map , keyTransformer , valueTransformer ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
final SortedMap < K , V > map = getSortedMap () . tailMap ( fromKey ) ;
return new TransformedSortedMap <> ( map , keyTransformer , valueTransformer ) ;
}
