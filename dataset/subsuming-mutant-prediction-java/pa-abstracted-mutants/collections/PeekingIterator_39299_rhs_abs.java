public static < E > PeekingIterator < E > peekingIterator ( final Iterator < ? extends E > iterator ) {
Objects . requireNonNull ( iterator , lr_1 ) ;
if ( iterator instanceof PeekingIterator < ? > ) {
@SuppressWarnings ( lr_2 )
final PeekingIterator < E > it = ( PeekingIterator < E > ) iterator ;
return it ;
}
return new PeekingIterator <> ( iterator ) ;
}
private void fill () {
if ( exhausted || slotFilled ) {
return;
}
if ( iterator . hasNext () ) {
slot = iterator . next () ;
slotFilled = true ;
} else {
exhausted = true ;
slot = null ;
slotFilled = false ;
}
}
@Override
public boolean hasNext () {
if ( exhausted ) {
return false ;
}
return slotFilled || iterator . hasNext () ;
}
public E peek () {
fill () ; MST[VoidMethodCallMutator]MSP[N]
return exhausted ? null : slot ;
}
public E element () {
fill () ;
if ( exhausted ) {
throw new NoSuchElementException () ;
}
return slot ;
}
@Override
public E next () {
if ( ! hasNext () ) {
throw new NoSuchElementException () ;
}
final E x = slotFilled ? slot : iterator . next () ;
slot = null ;
slotFilled = false ;
return x ;
}
@Override
public void remove () {
if ( slotFilled ) {
throw new IllegalStateException ( lr_3 ) ;
}
iterator . remove () ;
}
