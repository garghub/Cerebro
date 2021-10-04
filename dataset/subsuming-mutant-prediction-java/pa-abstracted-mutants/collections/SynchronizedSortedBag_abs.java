public static < E > SynchronizedSortedBag < E > synchronizedSortedBag ( final SortedBag < E > bag ) {
return new SynchronizedSortedBag <> ( bag ) ;
}
protected SortedBag < E > getSortedBag () {
return ( SortedBag < E > ) decorated () ;
}
@Override
public synchronized E first () {
synchronized ( lock ) {
return getSortedBag () . first () ;
}
}
@Override
public synchronized E last () {
synchronized ( lock ) {
return getSortedBag () . last () ;
}
}
@Override
public synchronized Comparator < ? super E > comparator () {
synchronized ( lock ) {
return getSortedBag () . comparator () ;
}
}
