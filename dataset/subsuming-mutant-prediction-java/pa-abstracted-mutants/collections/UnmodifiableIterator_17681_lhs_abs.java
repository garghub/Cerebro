public static < E > Iterator < E > unmodifiableIterator ( final Iterator < ? extends E > iterator ) {
Objects . requireNonNull ( iterator , lr_1 ) ;
if ( iterator instanceof Unmodifiable ) {
@SuppressWarnings ( lr_2 )
final Iterator < E > tmpIterator = ( Iterator < E > ) iterator ;
return tmpIterator ;
}
return new UnmodifiableIterator <> ( iterator ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ; MST[ReturnValsMutator]MSP[]
}
@Override
public E next () {
return iterator . next () ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_3 ) ;
}
