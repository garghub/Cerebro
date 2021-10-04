public static < E > PredicatedMultiSet < E > predicatedMultiSet ( final MultiSet < E > multiset ,
final Predicate < ? super E > predicate ) {
return new PredicatedMultiSet <> ( multiset , predicate ) ;
}
@Override
protected MultiSet < E > decorated () {
return ( MultiSet < E > ) super . decorated () ;
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
public int add ( final E object , final int count ) {
validate ( object ) ;
return decorated () . add ( object , count ) ;
}
@Override
public int remove ( final Object object , final int count ) {
return decorated () . remove ( object , count ) ;
}
@Override
public int getCount ( final Object object ) {
return decorated () . getCount ( object ) ;
}
@Override
public int setCount ( final E object , final int count ) {
validate ( object ) ;
return decorated () . setCount ( object , count ) ;
}
@Override
public Set < E > uniqueSet () {
return decorated () . uniqueSet () ;
}
@Override
public Set < MultiSet . Entry < E > > entrySet () {
return decorated () . entrySet () ;
}
