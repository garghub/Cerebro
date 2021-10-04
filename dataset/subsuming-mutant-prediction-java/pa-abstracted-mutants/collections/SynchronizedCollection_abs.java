public static < T > SynchronizedCollection < T > synchronizedCollection ( final Collection < T > coll ) {
return new SynchronizedCollection <> ( coll ) ;
}
protected Collection < E > decorated () {
return collection ;
}
@Override
public boolean add ( final E object ) {
synchronized ( lock ) {
return decorated () . add ( object ) ;
}
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
synchronized ( lock ) {
return decorated () . addAll ( coll ) ;
}
}
@Override
public void clear () {
synchronized ( lock ) {
decorated () . clear () ;
}
}
@Override
public boolean contains ( final Object object ) {
synchronized ( lock ) {
return decorated () . contains ( object ) ;
}
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
synchronized ( lock ) {
return decorated () . containsAll ( coll ) ;
}
}
@Override
public boolean isEmpty () {
synchronized ( lock ) {
return decorated () . isEmpty () ;
}
}
@Override
public Iterator < E > iterator () {
return decorated () . iterator () ;
}
@Override
public Object [] toArray () {
synchronized ( lock ) {
return decorated () . toArray () ;
}
}
@Override
public < T > T [] toArray ( final T [] object ) {
synchronized ( lock ) {
return decorated () . toArray ( object ) ;
}
}
@Override
public boolean remove ( final Object object ) {
synchronized ( lock ) {
return decorated () . remove ( object ) ;
}
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
synchronized ( lock ) {
return decorated () . removeIf ( filter ) ;
}
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
synchronized ( lock ) {
return decorated () . removeAll ( coll ) ;
}
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
synchronized ( lock ) {
return decorated () . retainAll ( coll ) ;
}
}
@Override
public int size () {
synchronized ( lock ) {
return decorated () . size () ;
}
}
@Override
public boolean equals ( final Object object ) {
synchronized ( lock ) {
if ( object == this ) {
return true ;
}
return object == this || decorated () . equals ( object ) ;
}
}
@Override
public int hashCode () {
synchronized ( lock ) {
return decorated () . hashCode () ;
}
}
@Override
public String toString () {
synchronized ( lock ) {
return decorated () . toString () ;
}
}
