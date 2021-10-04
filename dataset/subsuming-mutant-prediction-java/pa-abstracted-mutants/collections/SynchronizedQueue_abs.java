public static < E > SynchronizedQueue < E > synchronizedQueue ( final Queue < E > queue ) {
return new SynchronizedQueue <> ( queue ) ;
}
@Override
protected Queue < E > decorated () {
return ( Queue < E > ) super . decorated () ;
}
@Override
public E element () {
synchronized ( lock ) {
return decorated () . element () ;
}
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
synchronized ( lock ) {
return decorated () . equals ( object ) ;
}
}
@Override
public int hashCode () {
synchronized ( lock ) {
return decorated () . hashCode () ;
}
}
@Override
public boolean offer ( final E e ) {
synchronized ( lock ) {
return decorated () . offer ( e ) ;
}
}
@Override
public E peek () {
synchronized ( lock ) {
return decorated () . peek () ;
}
}
@Override
public E poll () {
synchronized ( lock ) {
return decorated () . poll () ;
}
}
@Override
public E remove () {
synchronized ( lock ) {
return decorated () . remove () ;
}
}
