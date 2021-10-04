public static < E > PredicatedNavigableSet < E > predicatedNavigableSet ( final NavigableSet < E > set ,
final Predicate < ? super E > predicate ) {
return new PredicatedNavigableSet <> ( set , predicate ) ;
}
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
return predicatedNavigableSet ( decorated () . descendingSet () , predicate ) ;
}
@Override
public Iterator < E > descendingIterator () {
return decorated () . descendingIterator () ;
}
@Override
public NavigableSet < E > subSet ( final E fromElement , final boolean fromInclusive , final E toElement ,
final boolean toInclusive ) {
final NavigableSet < E > sub = decorated () . subSet ( fromElement , fromInclusive , toElement , toInclusive ) ;
return predicatedNavigableSet ( sub , predicate ) ;
}
@Override
public NavigableSet < E > headSet ( final E toElement , final boolean inclusive ) {
final NavigableSet < E > head = decorated () . headSet ( toElement , inclusive ) ;
return predicatedNavigableSet ( head , predicate ) ;
}
@Override
public NavigableSet < E > tailSet ( final E fromElement , final boolean inclusive ) {
final NavigableSet < E > tail = decorated () . tailSet ( fromElement , inclusive ) ;
return predicatedNavigableSet ( tail , predicate ) ;
}
