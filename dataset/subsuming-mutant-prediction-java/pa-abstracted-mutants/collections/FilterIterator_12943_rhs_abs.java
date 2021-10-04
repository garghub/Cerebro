@Override
public boolean hasNext () {
return nextObjectSet || setNextObject () ;
}
@Override
public E next () {
if ( ! nextObjectSet && ! setNextObject () ) {
throw new NoSuchElementException () ;
}
nextObjectSet = false ;
return nextObject ;
}
@Override
public void remove () {
if ( nextObjectSet ) {
throw new IllegalStateException ( lr_1 ) ;
}
iterator . remove () ;
}
public Iterator < ? extends E > getIterator () {
return iterator ;
}
public void setIterator ( final Iterator < ? extends E > iterator ) {
this . iterator = iterator ;
nextObject = null ;
nextObjectSet = false ;
}
public Predicate < ? super E > getPredicate () {
return predicate ;
}
public void setPredicate ( final Predicate < ? super E > predicate ) {
this . predicate = predicate ;
nextObject = null ;
nextObjectSet = false ;
}
private boolean setNextObject () {
while ( iterator . hasNext () ) { MST[NonVoidMethodCallMutator]MSP[N]
final E object = iterator . next () ;
if ( predicate . evaluate ( object ) ) {
nextObject = object ;
nextObjectSet = true ;
return true ;
}
}
return false ;
}
