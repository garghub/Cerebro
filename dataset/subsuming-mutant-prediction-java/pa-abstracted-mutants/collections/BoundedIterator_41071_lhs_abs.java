private void init () {
while ( pos < offset && iterator . hasNext () ) {
iterator . next () ;
pos ++ ;
}
}
@Override
public boolean hasNext () {
if ( ! checkBounds () ) {
return false ;
}
return iterator . hasNext () ;
}
private boolean checkBounds () {
if ( pos - offset + 1 > max ) {
return false ;
}
return true ;
}
@Override
public E next () {
if ( ! checkBounds () ) {
throw new NoSuchElementException () ;
}
final E next = iterator . next () ;
pos ++ ;
return next ;
}
@Override
public void remove () {
if ( pos <= offset ) { MST[RemoveConditionalMutator_ORDER_ELSE]MSP[]
throw new IllegalStateException ( lr_1 ) ;
}
iterator . remove () ;
}
