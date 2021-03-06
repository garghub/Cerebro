public static < E > PredicatedSortedSet < E > predicatedSortedSet ( final SortedSet < E > set ,
final Predicate < ? super E > predicate ) {
return new PredicatedSortedSet <> ( set , predicate ) ;
}
@Override
protected SortedSet < E > decorated () {
return ( SortedSet < E > ) super . decorated () ;
}
@Override
public Comparator < ? super E > comparator () {
return decorated () . comparator () ;
}
@Override
public E first () {
return decorated () . first () ;
}
@Override
public E last () {
return decorated () . last () ;
}
@Override
public SortedSet < E > subSet ( final E fromElement , final E toElement ) {
final SortedSet < E > sub = decorated () . subSet ( fromElement , toElement ) ;
return new PredicatedSortedSet <> ( sub , predicate ) ;
}
@Override
public SortedSet < E > headSet ( final E toElement ) {
final SortedSet < E > head = decorated () . headSet ( toElement ) ;
return new PredicatedSortedSet <> ( head , predicate ) ;
}
@Override
public SortedSet < E > tailSet ( final E fromElement ) {
final SortedSet < E > tail = decorated () . tailSet ( fromElement ) ;
return new PredicatedSortedSet <> ( tail , predicate ) ;
}
