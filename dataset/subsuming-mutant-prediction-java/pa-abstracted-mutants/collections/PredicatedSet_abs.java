public static < E > PredicatedSet < E > predicatedSet ( final Set < E > set , final Predicate < ? super E > predicate ) {
return new PredicatedSet <> ( set , predicate ) ;
}
@Override
protected Set < E > decorated () {
return ( Set < E > ) super . decorated () ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || decorated () . equals ( object ) ;
}
@Override
public int hashCode () {
return decorated () . hashCode () ;
}
