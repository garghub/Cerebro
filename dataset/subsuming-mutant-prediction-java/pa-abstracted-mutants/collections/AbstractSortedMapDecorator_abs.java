@Override
protected SortedMap < K , V > decorated () {
return ( SortedMap < K , V > ) super . decorated () ;
}
@Override
public Comparator < ? super K > comparator () {
return decorated () . comparator () ;
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
@Override
public K previousKey ( final K key ) {
final SortedMap < K , V > headMap = headMap ( key ) ;
return headMap . isEmpty () ? null : headMap . lastKey () ;
}
@Override
public K nextKey ( final K key ) {
final Iterator < K > it = tailMap ( key ) . keySet () . iterator () ;
it . next () ;
return it . hasNext () ? it . next () : null ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
return new SortedMapIterator <> ( entrySet () ) ;
}
@Override
public synchronized void reset () {
super . reset () ;
iterator = new ListIteratorWrapper <> ( iterator ) ;
}
@Override
public boolean hasPrevious () {
return ( ( ListIterator < Map . Entry < K , V > > ) iterator ) . hasPrevious () ;
}
@Override
public K previous () {
entry = ( ( ListIterator < Map . Entry < K , V > > ) iterator ) . previous () ;
return getKey () ;
}
