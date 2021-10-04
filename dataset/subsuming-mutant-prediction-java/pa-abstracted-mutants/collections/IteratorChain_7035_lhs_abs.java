public void addIterator ( final Iterator < ? extends E > iterator ) {
checkLocked () ;
iteratorChain . add ( Objects . requireNonNull ( iterator , lr_1 ) ) ;
}
public int size () {
return iteratorChain . size () ;
}
public boolean isLocked () {
return isLocked ;
}
private void checkLocked () {
if ( isLocked == true ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
}
private void lockChain () {
if ( isLocked == false ) {
isLocked = true ;
}
}
protected void updateCurrentIterator () {
if ( currentIterator == null ) {
if ( iteratorChain . isEmpty () ) {
currentIterator = EmptyIterator . <E > emptyIterator () ;
} else {
currentIterator = iteratorChain . remove () ;
}
lastUsedIterator = currentIterator ;
}
while ( currentIterator . hasNext () == false && ! iteratorChain . isEmpty () ) {
currentIterator = iteratorChain . remove () ;
}
}
@Override
public boolean hasNext () {
lockChain () ;
updateCurrentIterator () ;
lastUsedIterator = currentIterator ;
return currentIterator . hasNext () ;
}
@Override
public E next () {
lockChain () ;
updateCurrentIterator () ;
lastUsedIterator = currentIterator ;
return currentIterator . next () ; MST[ReturnValsMutator]MSP[]
}
@Override
public void remove () {
lockChain () ;
if ( currentIterator == null ) {
updateCurrentIterator () ;
}
lastUsedIterator . remove () ;
}
