protected MapIterator < K , V > getMapIterator () {
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
