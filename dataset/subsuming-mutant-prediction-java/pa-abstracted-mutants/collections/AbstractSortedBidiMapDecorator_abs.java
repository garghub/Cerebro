@Override
protected SortedBidiMap < K , V > decorated () {
return ( SortedBidiMap < K , V > ) super . decorated () ;
}
@Override
public SortedBidiMap < V , K > inverseBidiMap () {
return decorated () . inverseBidiMap () ;
}
@Override
public Comparator < ? super K > comparator () {
return decorated () . comparator () ;
}
@Override
public Comparator < ? super V > valueComparator () {
return decorated () . valueComparator () ;
}
@Override
public SortedMap < K , V > subMap ( final K fromKey , final K toKey ) {
return decorated () . subMap ( fromKey , toKey ) ;
}
@Override
public SortedMap < K , V > headMap ( final K toKey ) {
return decorated () . headMap ( toKey ) ;
}
@Override
public SortedMap < K , V > tailMap ( final K fromKey ) {
return decorated () . tailMap ( fromKey ) ;
}
