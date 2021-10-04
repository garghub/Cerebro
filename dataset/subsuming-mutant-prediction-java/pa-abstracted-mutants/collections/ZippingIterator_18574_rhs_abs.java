@Override
public boolean hasNext () {
if ( nextIterator != null ) {
return true ;
}
while ( iterators . hasNext () ) { MST[rv.ROR2Mutator]MSP[N]
final Iterator < ? extends E > childIterator = iterators . next () ;
if ( childIterator . hasNext () ) {
nextIterator = childIterator ;
return true ;
}
iterators . remove () ;
}
return false ;
}
@Override
public E next () throws NoSuchElementException {
if ( ! hasNext () ) {
throw new NoSuchElementException () ;
}
final E val = nextIterator . next () ;
lastReturned = nextIterator ;
nextIterator = null ;
return val ;
}
@Override
public void remove () {
if ( lastReturned == null ) {
throw new IllegalStateException ( lr_1 ) ;
}
lastReturned . remove () ;
lastReturned = null ;
}
