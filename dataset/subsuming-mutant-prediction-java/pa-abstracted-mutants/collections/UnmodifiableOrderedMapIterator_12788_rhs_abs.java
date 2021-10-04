public static < K , V > OrderedMapIterator < K , V > unmodifiableOrderedMapIterator (
final OrderedMapIterator < K , ? extends V > iterator ) {
Objects . requireNonNull ( iterator , lr_1 ) ;
if ( iterator instanceof Unmodifiable ) {
@SuppressWarnings ( lr_2 )
final OrderedMapIterator < K , V > tmpIterator = ( OrderedMapIterator < K , V > ) iterator ;
return tmpIterator ;
}
return new UnmodifiableOrderedMapIterator <> ( iterator ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ; MST[BooleanFalseReturnValsMutator]MSP[N]
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
public K getKey () {
return iterator . getKey () ;
}
@Override
public V getValue () {
return iterator . getValue () ;
}
@Override
public V setValue ( final V value ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_4 ) ;
}
