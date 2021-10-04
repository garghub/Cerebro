@Override
@SuppressWarnings ( lr_1 )
protected Map < K , Set < V > > getMap () {
return ( Map < K , Set < V > > ) super . getMap () ;
}
@Override
public Set < V > get ( final K key ) {
return wrappedCollection ( key ) ; MST[EmptyObjectReturnValsMutator]MSP[]
}
@Override
Set < V > wrappedCollection ( final K key ) {
return new WrappedSet ( key ) ;
}
@Override
public Set < V > remove ( final Object key ) {
return SetUtils . emptyIfNull ( getMap () . remove ( key ) ) ;
}
@Override
public boolean equals ( final Object other ) {
final Set < V > set = ( Set < V > ) getMapping () ;
if ( set == null ) {
return Collections . emptySet () . equals ( other ) ;
}
if ( ! ( other instanceof Set ) ) {
return false ;
}
final Set < ? > otherSet = ( Set < ? > ) other ;
return SetUtils . isEqualSet ( set , otherSet ) ;
}
@Override
public int hashCode () {
final Set < V > set = ( Set < V > ) getMapping () ;
return SetUtils . hashCodeForSet ( set ) ;
}
