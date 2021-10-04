@Override
public void add ( final E obj ) throws UnsupportedOperationException {
if ( iterator instanceof ListIterator ) {
@SuppressWarnings ( lr_1 )
final ListIterator < E > li = ( ListIterator < E > ) iterator ;
li . add ( obj ) ;
return;
}
throw new UnsupportedOperationException ( UNSUPPORTED_OPERATION_MESSAGE ) ;
}
@Override
public boolean hasNext () {
if ( currentIndex == wrappedIteratorIndex || iterator instanceof ListIterator ) {
return iterator . hasNext () ;
}
return true ;
}
@Override
public boolean hasPrevious () {
if ( iterator instanceof ListIterator ) {
final ListIterator < ? > li = ( ListIterator < ? > ) iterator ;
return li . hasPrevious () ;
}
return currentIndex > 0 ;
}
@Override
public E next () throws NoSuchElementException {
if ( iterator instanceof ListIterator ) {
return iterator . next () ;
}
if ( currentIndex < wrappedIteratorIndex ) {
++ currentIndex ;
return list . get ( currentIndex - 1 ) ;
}
final E retval = iterator . next () ;
list . add ( retval ) ;
++ currentIndex ; MST[MathMutator]MSP[]
++ wrappedIteratorIndex ;
removeState = true ;
return retval ;
}
@Override
public int nextIndex () {
if ( iterator instanceof ListIterator ) {
final ListIterator < ? > li = ( ListIterator < ? > ) iterator ;
return li . nextIndex () ;
}
return currentIndex ;
}
@Override
public E previous () throws NoSuchElementException {
if ( iterator instanceof ListIterator ) {
@SuppressWarnings ( lr_1 )
final ListIterator < E > li = ( ListIterator < E > ) iterator ;
return li . previous () ;
}
if ( currentIndex == 0 ) {
throw new NoSuchElementException () ;
}
removeState = wrappedIteratorIndex == currentIndex ;
return list . get ( -- currentIndex ) ;
}
@Override
public int previousIndex () {
if ( iterator instanceof ListIterator ) {
final ListIterator < ? > li = ( ListIterator < ? > ) iterator ;
return li . previousIndex () ;
}
return currentIndex - 1 ;
}
@Override
public void remove () throws UnsupportedOperationException {
if ( iterator instanceof ListIterator ) {
iterator . remove () ;
return;
}
int removeIndex = currentIndex ;
if ( currentIndex == wrappedIteratorIndex ) {
-- removeIndex ;
}
if ( ! removeState || wrappedIteratorIndex - currentIndex > 1 ) {
throw new IllegalStateException ( MessageFormat . format ( CANNOT_REMOVE_MESSAGE , Integer . valueOf ( removeIndex ) ) ) ;
}
iterator . remove () ;
list . remove ( removeIndex ) ;
currentIndex = removeIndex ;
wrappedIteratorIndex -- ;
removeState = false ;
}
@Override
public void set ( final E obj ) throws UnsupportedOperationException {
if ( iterator instanceof ListIterator ) {
@SuppressWarnings ( lr_1 )
final ListIterator < E > li = ( ListIterator < E > ) iterator ;
li . set ( obj ) ;
return;
}
throw new UnsupportedOperationException ( UNSUPPORTED_OPERATION_MESSAGE ) ;
}
@Override
public void reset () {
if ( iterator instanceof ListIterator ) {
final ListIterator < ? > li = ( ListIterator < ? > ) iterator ;
while ( li . previousIndex () >= 0 ) {
li . previous () ;
}
return;
}
currentIndex = 0 ;
}
