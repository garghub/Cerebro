@Override
protected NavigableSet < E > decorated () {
return ( NavigableSet < E > ) super . decorated () ;
}
@Override
public E lower ( final E e ) {
return decorated () . lower ( e ) ;
}
@Override
public E floor ( final E e ) {
return decorated () . floor ( e ) ;
}
@Override
public E ceiling ( final E e ) {
return decorated () . ceiling ( e ) ;
}
@Override
public E higher ( final E e ) {
return decorated () . higher ( e ) ;
}
@Override
public E pollFirst () {
return decorated () . pollFirst () ;
}
@Override
public E pollLast () {
return decorated () . pollLast () ;
}
@Override
public NavigableSet < E > descendingSet () {
return decorated () . descendingSet () ;
}
@Override
public Iterator < E > descendingIterator () {
return decorated () . descendingIterator () ;
}
@Override
public NavigableSet < E > subSet ( final E fromElement , final boolean fromInclusive , final E toElement ,
final boolean toInclusive ) {
return decorated () . subSet ( fromElement , fromInclusive , toElement , toInclusive ) ;
}
@Override
public NavigableSet < E > headSet ( final E toElement , final boolean inclusive ) {
return decorated () . headSet ( toElement , inclusive ) ;
}
@Override
public NavigableSet < E > tailSet ( final E fromElement , final boolean inclusive ) {
return decorated () . tailSet ( fromElement , inclusive ) ;
}
