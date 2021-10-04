@Override
protected OrderedBidiMap < K , V > decorated () {
return ( OrderedBidiMap < K , V > ) super . decorated () ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
return decorated () . mapIterator () ;
}
@Override
public K firstKey () {
return decorated () . firstKey () ;
}
@Override
public K lastKey () {
return decorated () . lastKey () ;
}
@Override
public K nextKey ( final K key ) {
return decorated () . nextKey ( key ) ;
}
@Override
public K previousKey ( final K key ) {
return decorated () . previousKey ( key ) ;
}
@Override
public OrderedBidiMap < V , K > inverseBidiMap () {
return decorated () . inverseBidiMap () ;
}
