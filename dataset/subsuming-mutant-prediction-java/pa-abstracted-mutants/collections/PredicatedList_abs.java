public static < T > PredicatedList < T > predicatedList ( final List < T > list , final Predicate < ? super T > predicate ) {
return new PredicatedList <> ( list , predicate ) ;
}
@Override
protected List < E > decorated () {
return ( List < E > ) super . decorated () ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || decorated () . equals ( object ) ;
}
@Override
public int hashCode () {
return decorated () . hashCode () ;
}
@Override
public E get ( final int index ) {
return decorated () . get ( index ) ;
}
@Override
public int indexOf ( final Object object ) {
return decorated () . indexOf ( object ) ;
}
@Override
public int lastIndexOf ( final Object object ) {
return decorated () . lastIndexOf ( object ) ;
}
@Override
public E remove ( final int index ) {
return decorated () . remove ( index ) ;
}
@Override
public void add ( final int index , final E object ) {
validate ( object ) ;
decorated () . add ( index , object ) ;
}
@Override
public boolean addAll ( final int index , final Collection < ? extends E > coll ) {
for ( final E aColl : coll ) {
validate ( aColl ) ;
}
return decorated () . addAll ( index , coll ) ;
}
@Override
public ListIterator < E > listIterator () {
return listIterator ( 0 ) ;
}
@Override
public ListIterator < E > listIterator ( final int i ) {
return new PredicatedListIterator ( decorated () . listIterator ( i ) ) ;
}
@Override
public E set ( final int index , final E object ) {
validate ( object ) ;
return decorated () . set ( index , object ) ;
}
@Override
public List < E > subList ( final int fromIndex , final int toIndex ) {
final List < E > sub = decorated () . subList ( fromIndex , toIndex ) ;
return new PredicatedList <> ( sub , predicate ) ;
}
@Override
public void add ( final E object ) {
validate ( object ) ;
getListIterator () . add ( object ) ;
}
@Override
public void set ( final E object ) {
validate ( object ) ;
getListIterator () . set ( object ) ;
}
