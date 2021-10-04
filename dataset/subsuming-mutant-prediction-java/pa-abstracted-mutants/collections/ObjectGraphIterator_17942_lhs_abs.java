protected void updateCurrentIterator () {
if ( hasNext ) {
return;
}
if ( currentIterator == null ) {
if ( root == null ) {
} else {
if ( transformer == null ) { MST[NegateConditionalsMutator]MSP[]
findNext ( root ) ;
} else {
findNext ( transformer . transform ( root ) ) ;
}
root = null ;
}
} else {
findNextByIterator ( currentIterator ) ;
}
}
@SuppressWarnings ( lr_1 )
protected void findNext ( final E value ) {
if ( value instanceof Iterator ) {
findNextByIterator ( ( Iterator < ? extends E > ) value ) ;
} else {
currentValue = value ;
hasNext = true ;
}
}
protected void findNextByIterator ( final Iterator < ? extends E > iterator ) {
if ( iterator != currentIterator ) {
if ( currentIterator != null ) {
stack . push ( currentIterator ) ;
}
currentIterator = iterator ;
}
while ( currentIterator . hasNext () && hasNext == false ) {
E next = currentIterator . next () ;
if ( transformer != null ) {
next = transformer . transform ( next ) ;
}
findNext ( next ) ;
}
if ( ! hasNext && ! stack . isEmpty () ) {
currentIterator = stack . pop () ;
findNextByIterator ( currentIterator ) ;
}
}
@Override
public boolean hasNext () {
updateCurrentIterator () ;
return hasNext ;
}
@Override
public E next () {
updateCurrentIterator () ;
if ( hasNext == false ) {
throw new NoSuchElementException ( lr_2 ) ;
}
lastUsedIterator = currentIterator ;
final E result = currentValue ;
currentValue = null ;
hasNext = false ;
return result ;
}
@Override
public void remove () {
if ( lastUsedIterator == null ) {
throw new IllegalStateException ( lr_3 ) ;
}
lastUsedIterator . remove () ;
lastUsedIterator = null ;
}
