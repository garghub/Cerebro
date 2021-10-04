private void updateCurrentIterator () {
if ( callCounter == 0 ) {
currentIterator = nextIterator ( ++ callCounter ) ;
if ( currentIterator == null ) {
currentIterator = EmptyIterator . <E > emptyIterator () ;
chainExhausted = true ;
}
lastUsedIterator = currentIterator ;
}
while ( currentIterator . hasNext () == false && ! chainExhausted ) {
final Iterator < ? extends E > nextIterator = nextIterator ( ++ callCounter ) ;
if ( nextIterator != null ) {
currentIterator = nextIterator ;
} else {
chainExhausted = true ;
}
}
}
@Override
public boolean hasNext () {
updateCurrentIterator () ;
lastUsedIterator = currentIterator ;
return currentIterator . hasNext () ;
}
@Override
public E next () {
updateCurrentIterator () ;
lastUsedIterator = currentIterator ;
return currentIterator . next () ;
}
@Override
public void remove () {
if ( currentIterator == null ) {
updateCurrentIterator () ;
}
lastUsedIterator . remove () ;
}
