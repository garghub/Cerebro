@Override
public void add ( final E o ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}
@Override
public boolean hasNext () {
return nextObjectSet || setNextObject () ;
}
@Override
public boolean hasPrevious () {
return previousObjectSet || setPreviousObject () ;
}
@Override
public E next () {
if ( ! nextObjectSet && ! setNextObject () ) {
throw new NoSuchElementException () ;
}
nextIndex ++ ;
final E temp = nextObject ;
clearNextObject () ;
return temp ;
}
@Override
public int nextIndex () {
return nextIndex ;
}
@Override
public E previous () {
if ( ! previousObjectSet && ! setPreviousObject () ) {
throw new NoSuchElementException () ;
}
nextIndex -- ;
final E temp = previousObject ;
clearPreviousObject () ;
return temp ;
}
@Override
public int previousIndex () {
return nextIndex - 1 ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_2 ) ;
}
@Override
public void set ( final E o ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
public ListIterator < ? extends E > getListIterator () {
return iterator ;
}
public void setListIterator ( final ListIterator < ? extends E > iterator ) {
this . iterator = iterator ;
}
public Predicate < ? super E > getPredicate () {
return predicate ;
}
public void setPredicate ( final Predicate < ? super E > predicate ) {
this . predicate = predicate ;
}
private void clearNextObject () {
nextObject = null ;
nextObjectSet = false ; MST[rv.CRCR5Mutator]MSP[]
}
private boolean setNextObject () {
if ( previousObjectSet ) {
clearPreviousObject () ;
if ( ! setNextObject () ) {
return false ;
}
clearNextObject () ;
}
if ( iterator == null ) {
return false ;
}
while ( iterator . hasNext () ) {
final E object = iterator . next () ;
if ( predicate . evaluate ( object ) ) {
nextObject = object ;
nextObjectSet = true ;
return true ;
}
}
return false ;
}
private void clearPreviousObject () {
previousObject = null ;
previousObjectSet = false ;
}
private boolean setPreviousObject () {
if ( nextObjectSet ) {
clearNextObject () ;
if ( ! setPreviousObject () ) {
return false ;
}
clearPreviousObject () ;
}
if ( iterator == null ) {
return false ;
}
while ( iterator . hasPrevious () ) {
final E object = iterator . previous () ;
if ( predicate . evaluate ( object ) ) {
previousObject = object ;
previousObjectSet = true ;
return true ;
}
}
return false ;
}
