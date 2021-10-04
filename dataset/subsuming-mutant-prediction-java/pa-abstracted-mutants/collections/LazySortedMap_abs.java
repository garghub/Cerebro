public static < K , V > LazySortedMap < K , V > lazySortedMap ( final SortedMap < K , V > map ,
final Factory < ? extends V > factory ) {
return new LazySortedMap <> ( map , factory ) ;
}
public static < K , V > LazySortedMap < K , V > lazySortedMap ( final SortedMap < K , V > map ,
final Transformer < ? super K , ? extends V > factory ) {
return new LazySortedMap <> ( map , factory ) ;
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
return new LazySortedMap <> ( map , factory ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
final SortedMap < K , V > map = getSortedMap () . headMap ( toKey ) ;
return new LazySortedMap <> ( map , factory ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
final SortedMap < K , V > map = getSortedMap () . tailMap ( fromKey ) ;
return new LazySortedMap <> ( map , factory ) ;
}
