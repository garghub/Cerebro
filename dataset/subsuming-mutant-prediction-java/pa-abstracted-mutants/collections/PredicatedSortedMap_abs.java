public static < K , V > PredicatedSortedMap < K , V > predicatedSortedMap ( final SortedMap < K , V > map ,
final Predicate < ? super K > keyPredicate , final Predicate < ? super V > valuePredicate ) {
return new PredicatedSortedMap <> ( map , keyPredicate , valuePredicate ) ;
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
return new PredicatedSortedMap <> ( map , keyPredicate , valuePredicate ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
final SortedMap < K , V > map = getSortedMap () . headMap ( toKey ) ;
return new PredicatedSortedMap <> ( map , keyPredicate , valuePredicate ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
final SortedMap < K , V > map = getSortedMap () . tailMap ( fromKey ) ;
return new PredicatedSortedMap <> ( map , keyPredicate , valuePredicate ) ;
}
