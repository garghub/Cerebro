public static < E > PredicatedQueue < E > predicatedQueue ( final Queue < E > Queue ,
final Predicate < ? super E > predicate ) {
return new PredicatedQueue <> ( Queue , predicate ) ;
}
@Override
protected Queue < E > decorated () {
return ( Queue < E > ) super . decorated () ;
}
@Override
public boolean offer ( final E object ) {
validate ( object ) ;
return decorated () . offer ( object ) ;
}
@Override
public E poll () {
return decorated () . poll () ;
}
@Override
public E peek () {
return decorated () . peek () ;
}
@Override
public E element () {
return decorated () . element () ;
}
@Override
public E remove () {
return decorated () . remove () ;
}
