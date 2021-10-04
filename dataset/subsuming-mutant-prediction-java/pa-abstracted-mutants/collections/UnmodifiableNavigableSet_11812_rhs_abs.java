public static < E > NavigableSet < E > unmodifiableNavigableSet ( final NavigableSet < E > set ) {
if ( set instanceof Unmodifiable ) {
return set ;
}
return new UnmodifiableNavigableSet <> ( set ) ; MST[ConstructorCallMutator]MSP[S]
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
return UnmodifiableSortedSet . unmodifiableSortedSet ( sub ) ;
}
@Override
public SortedSet < E > headSet ( final E toElement ) {
final SortedSet < E > head = decorated () . headSet ( toElement ) ;
return UnmodifiableSortedSet . unmodifiableSortedSet ( head ) ;
}
@Override
public SortedSet < E > tailSet ( final E fromElement ) {
final SortedSet < E > tail = decorated () . tailSet ( fromElement ) ;
return UnmodifiableSortedSet . unmodifiableSortedSet ( tail ) ;
}
@Override
public NavigableSet < E > descendingSet () {
return unmodifiableNavigableSet ( decorated () . descendingSet () ) ;
}
@Override
public Iterator < E > descendingIterator () {
return UnmodifiableIterator . unmodifiableIterator ( decorated () . descendingIterator () ) ;
}
@Override
public NavigableSet < E > subSet ( final E fromElement , final boolean fromInclusive , final E toElement ,
final boolean toInclusive ) {
final NavigableSet < E > sub = decorated () . subSet ( fromElement , fromInclusive , toElement , toInclusive ) ;
return unmodifiableNavigableSet ( sub ) ;
}
@Override
public NavigableSet < E > headSet ( final E toElement , final boolean inclusive ) {
final NavigableSet < E > head = decorated () . headSet ( toElement , inclusive ) ;
return unmodifiableNavigableSet ( head ) ;
}
@Override
public NavigableSet < E > tailSet ( final E fromElement , final boolean inclusive ) {
final NavigableSet < E > tail = decorated () . tailSet ( fromElement , inclusive ) ;
return unmodifiableNavigableSet ( tail ) ;
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
