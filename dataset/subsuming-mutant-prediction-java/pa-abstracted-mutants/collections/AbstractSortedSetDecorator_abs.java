@Override
protected SortedSet < E > decorated () {
return ( SortedSet < E > ) super . decorated () ;
}
@Override
public SortedSet < E > subSet ( final E fromElement , final E toElement ) {
return decorated () . subSet ( fromElement , toElement ) ;
}
@Override
public SortedSet < E > headSet ( final E toElement ) {
return decorated () . headSet ( toElement ) ;
}
@Override
public SortedSet < E > tailSet ( final E fromElement ) {
return decorated () . tailSet ( fromElement ) ;
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
public Comparator < ? super E > comparator () {
return decorated () . comparator () ;
}
