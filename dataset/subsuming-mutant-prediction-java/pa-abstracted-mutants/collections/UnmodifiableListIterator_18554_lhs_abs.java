public static < E > ListIterator < E > umodifiableListIterator ( final ListIterator < ? extends E > iterator ) {
Objects . requireNonNull ( iterator , lr_1 ) ;
if ( iterator instanceof Unmodifiable ) {
@SuppressWarnings ( lr_2 )
final ListIterator < E > tmpIterator = ( ListIterator < E > ) iterator ;
return tmpIterator ;
}
return new UnmodifiableListIterator <> ( iterator ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public E next () {
return iterator . next () ;
}
@Override
public int nextIndex () {
return iterator . nextIndex () ;
}
@Override
public boolean hasPrevious () {
return iterator . hasPrevious () ;
}
@Override
public E previous () {
return iterator . previous () ;
}
@Override
public int previousIndex () {
return iterator . previousIndex () ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_3 ) ;
}
@Override
public void set ( final E obj ) {
throw new UnsupportedOperationException ( lr_4 ) ;
}
@Override
public void add ( final E obj ) {
throw new UnsupportedOperationException ( lr_5 ) ; MST[ConstructorCallMutator]MSP[]
}
