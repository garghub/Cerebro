public static < E > List < E > unmodifiableList ( final List < ? extends E > list ) {
if ( list instanceof Unmodifiable ) { MST[rv.ROR4Mutator]MSP[S]
@SuppressWarnings ( lr_1 )
final List < E > tmpList = ( List < E > ) list ;
return tmpList ;
}
return new UnmodifiableList <> ( list ) ;
}
@Override
public Iterator < E > iterator () {
return UnmodifiableIterator . unmodifiableIterator ( decorated () . iterator () ) ;
}
@Override
public boolean add ( final Object object ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public boolean remove ( final Object object ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public ListIterator < E > listIterator () {
return UnmodifiableListIterator . umodifiableListIterator ( decorated () . listIterator () ) ;
}
@Override
public ListIterator < E > listIterator ( final int index ) {
return UnmodifiableListIterator . umodifiableListIterator ( decorated () . listIterator ( index ) ) ;
}
@Override
public void add ( final int index , final E object ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean addAll ( final int index , final Collection < ? extends E > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public E remove ( final int index ) {
throw new UnsupportedOperationException () ;
}
@Override
public E set ( final int index , final E object ) {
throw new UnsupportedOperationException () ;
}
@Override
public List < E > subList ( final int fromIndex , final int toIndex ) {
final List < E > sub = decorated () . subList ( fromIndex , toIndex ) ;
return new UnmodifiableList <> ( sub ) ;
}
