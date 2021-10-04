@Override
protected Queue < E > decorated () {
return ( Queue < E > ) super . decorated () ;
}
@Override
public boolean offer ( final E obj ) {
return decorated () . offer ( obj ) ;
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
