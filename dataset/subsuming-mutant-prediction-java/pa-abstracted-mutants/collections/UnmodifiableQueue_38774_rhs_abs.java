public static < E > Queue < E > unmodifiableQueue ( final Queue < ? extends E > queue ) {
if ( queue instanceof Unmodifiable ) {
@SuppressWarnings ( lr_1 )
final Queue < E > tmpQueue = ( Queue < E > ) queue ;
return tmpQueue ;
}
return new UnmodifiableQueue <> ( queue ) ;
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
public boolean offer ( final E obj ) {
throw new UnsupportedOperationException () ; MST[ConstructorCallMutator]MSP[S]
}
@Override
public E poll () {
throw new UnsupportedOperationException () ;
}
@Override
public E remove () {
throw new UnsupportedOperationException () ;
}
