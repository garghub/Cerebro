protected OrderedMapIterator < K , V > getOrderedMapIterator () {
return iterator ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public K next () {
return iterator . next () ;
}
@Override
public boolean hasPrevious () {
return iterator . hasPrevious () ;
}
@Override
public K previous () {
return iterator . previous () ;
}
@Override
public void remove () {
iterator . remove () ;
}
@Override
public K getKey () {
return iterator . getKey () ;
}
@Override
public V getValue () {
return iterator . getValue () ;
}
@Override
public V setValue ( final V obj ) {
return iterator . setValue ( obj ) ;
}
