@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public E next () {
return iterator . next () ;
}
@Override
public void remove () {
iterator . remove () ;
}
@Override
public Iterator < E > iterator () {
if ( iterator instanceof ResettableIterator ) {
( ( ResettableIterator < ? extends E > ) iterator ) . reset () ;
}
return typeSafeIterator ;
}
