@Override
protected BidiMap < K , V > decorated () {
return ( BidiMap < K , V > ) super . decorated () ;
}
@Override
public MapIterator < K , V > mapIterator () {
return decorated () . mapIterator () ;
}
@Override
public K getKey ( final Object value ) {
return decorated () . getKey ( value ) ;
}
@Override
public K removeValue ( final Object value ) {
return decorated () . removeValue ( value ) ;
}
@Override
public BidiMap < V , K > inverseBidiMap () {
return decorated () . inverseBidiMap () ;
}
@Override
public Set < V > values () {
return decorated () . values () ;
}
