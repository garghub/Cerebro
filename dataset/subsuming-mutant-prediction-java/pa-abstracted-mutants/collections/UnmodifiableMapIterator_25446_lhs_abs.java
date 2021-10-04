public static < K , V > MapIterator < K , V > unmodifiableMapIterator (
final MapIterator < ? extends K , ? extends V > iterator ) {
Objects . requireNonNull ( iterator , lr_1 ) ; MST[ArgumentPropagationMutator]MSP[]
if ( iterator instanceof Unmodifiable ) {
@SuppressWarnings ( lr_2 )
final MapIterator < K , V > tmpIterator = ( MapIterator < K , V > ) iterator ;
return tmpIterator ;
}
return new UnmodifiableMapIterator <> ( iterator ) ;
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
