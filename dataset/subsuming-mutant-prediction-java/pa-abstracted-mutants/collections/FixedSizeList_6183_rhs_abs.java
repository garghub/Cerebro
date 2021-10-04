public static < E > FixedSizeList < E > fixedSizeList ( final List < E > list ) {
return new FixedSizeList <> ( list ) ;
}
@Override
public boolean add ( final E object ) {
throw unsupportedOperationException () ;
}
@Override
public void add ( final int index , final E object ) {
throw unsupportedOperationException () ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
throw unsupportedOperationException () ;
}
@Override
public boolean addAll ( final int index , final Collection < ? extends E > coll ) {
throw unsupportedOperationException () ;
}
@Override
public void clear () {
throw unsupportedOperationException () ;
}
@Override
public E get ( final int index ) {
return decorated () . get ( index ) ;
}
@Override
public int indexOf ( final Object object ) {
return decorated () . indexOf ( object ) ;
}
@Override
public Iterator < E > iterator () {
return UnmodifiableIterator . unmodifiableIterator ( decorated () . iterator () ) ;
}
@Override
public int lastIndexOf ( final Object object ) {
return decorated () . lastIndexOf ( object ) ;
}
@Override
public ListIterator < E > listIterator () {
return new FixedSizeListIterator ( decorated () . listIterator ( 0 ) ) ;
}
@Override
public ListIterator < E > listIterator ( final int index ) {
return new FixedSizeListIterator ( decorated () . listIterator ( index ) ) ;
}
@Override
public E remove ( final int index ) {
throw unsupportedOperationException () ;
}
@Override
public boolean remove ( final Object object ) {
throw unsupportedOperationException () ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
throw unsupportedOperationException () ; MST[NonVoidMethodCallMutator]MSP[N]
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
throw unsupportedOperationException () ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
throw unsupportedOperationException () ;
}
@Override
public E set ( final int index , final E object ) {
return decorated () . set ( index , object ) ;
}
@Override
public List < E > subList ( final int fromIndex , final int toIndex ) {
final List < E > sub = decorated () . subList ( fromIndex , toIndex ) ;
return new FixedSizeList <> ( sub ) ;
}
@Override
public void remove () {
throw unsupportedOperationException () ;
}
@Override
public void add ( final Object object ) {
throw unsupportedOperationException () ;
}
@Override
public boolean isFull () {
return true ;
}
@Override
public int maxSize () {
return size () ;
}
private static UnsupportedOperationException unsupportedOperationException () {
return new UnsupportedOperationException ( lr_1 ) ;
}
