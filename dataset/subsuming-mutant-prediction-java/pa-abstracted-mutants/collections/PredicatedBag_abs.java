public static < E > PredicatedBag < E > predicatedBag ( final Bag < E > bag , final Predicate < ? super E > predicate ) {
return new PredicatedBag <> ( bag , predicate ) ;
}
@Override
protected Bag < E > decorated () {
return ( Bag < E > ) super . decorated () ;
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
public boolean add ( final E object , final int count ) {
validate ( object ) ;
return decorated () . add ( object , count ) ;
}
@Override
public boolean remove ( final Object object , final int count ) {
return decorated () . remove ( object , count ) ;
}
@Override
public Set < E > uniqueSet () {
return decorated () . uniqueSet () ;
}
@Override
public int getCount ( final Object object ) {
return decorated () . getCount ( object ) ;
}
