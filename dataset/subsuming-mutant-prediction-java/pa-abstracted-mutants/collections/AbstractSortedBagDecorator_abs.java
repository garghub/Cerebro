@Override
protected SortedBag < E > decorated () {
return ( SortedBag < E > ) super . decorated () ;
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
