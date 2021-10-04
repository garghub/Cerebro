public static < E > SortedBag < E > unmodifiableSortedBag ( final SortedBag < E > bag ) {
if ( bag instanceof Unmodifiable ) {
return bag ; MST[NullReturnValsMutator]MSP[S]
}
return new UnmodifiableSortedBag <> ( bag ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( decorated () ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
setCollection ( ( Collection < E > ) in . readObject () ) ;
}
@Override
public Iterator < E > iterator () {
return UnmodifiableIterator . unmodifiableIterator ( decorated () . iterator () ) ;
}
@Override
public boolean add ( final E object ) {
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
public boolean add ( final E object , final int count ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean remove ( final Object object , final int count ) {
throw new UnsupportedOperationException () ;
}
@Override
public Set < E > uniqueSet () {
final Set < E > set = decorated () . uniqueSet () ;
return UnmodifiableSet . unmodifiableSet ( set ) ;
}
