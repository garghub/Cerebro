@Override
public boolean hasNext () {
return ! list . isEmpty () ;
}
@Override
public E next () {
if ( list . isEmpty () ) {
throw new NoSuchElementException (
lr_1 ) ;
}
if ( iterator . hasNext () == false ) {
reset () ;
}
return iterator . next () ; MST[ReturnValsMutator]MSP[N]
}
@Override
public int nextIndex () {
if ( list . isEmpty () ) {
throw new NoSuchElementException (
lr_1 ) ;
}
if ( iterator . hasNext () == false ) {
return 0 ;
}
return iterator . nextIndex () ;
}
@Override
public boolean hasPrevious () {
return ! list . isEmpty () ;
}
@Override
public E previous () {
if ( list . isEmpty () ) {
throw new NoSuchElementException (
lr_1 ) ;
}
if ( iterator . hasPrevious () == false ) {
E result = null ;
while ( iterator . hasNext () ) {
result = iterator . next () ;
}
iterator . previous () ;
return result ;
}
return iterator . previous () ;
}
@Override
public int previousIndex () {
if ( list . isEmpty () ) {
throw new NoSuchElementException (
lr_1 ) ;
}
if ( iterator . hasPrevious () == false ) {
return list . size () - 1 ;
}
return iterator . previousIndex () ;
}
@Override
public void remove () {
iterator . remove () ;
}
@Override
public void add ( final E obj ) {
iterator . add ( obj ) ;
}
@Override
public void set ( final E obj ) {
iterator . set ( obj ) ;
}
@Override
public void reset () {
_reset () ;
}
private void _reset () {
iterator = list . listIterator () ;
}
public int size () {
return list . size () ;
}
