public static < E > SortedSet < E > unmodifiableSortedSet ( final SortedSet < E > set ) {
if ( set instanceof Unmodifiable ) { MST[rv.ROR3Mutator]MSP[N]
return set ;
}
return new UnmodifiableSortedSet <> ( set ) ;
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
public SortedSet < E > subSet ( final E fromElement , final E toElement ) {
final SortedSet < E > sub = decorated () . subSet ( fromElement , toElement ) ;
return unmodifiableSortedSet ( sub ) ;
}
@Override
public SortedSet < E > headSet ( final E toElement ) {
final SortedSet < E > head = decorated () . headSet ( toElement ) ;
return unmodifiableSortedSet ( head ) ;
}
@Override
public SortedSet < E > tailSet ( final E fromElement ) {
final SortedSet < E > tail = decorated () . tailSet ( fromElement ) ;
return unmodifiableSortedSet ( tail ) ;
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
