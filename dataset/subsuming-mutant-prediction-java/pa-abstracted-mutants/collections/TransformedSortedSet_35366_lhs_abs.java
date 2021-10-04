public static < E > TransformedSortedSet < E > transformingSortedSet ( final SortedSet < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedSortedSet <> ( set , transformer ) ;
}
public static < E > TransformedSortedSet < E > transformedSortedSet ( final SortedSet < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
final TransformedSortedSet < E > decorated = new TransformedSortedSet <> ( set , transformer ) ;
if ( set . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final E [] values = ( E [] ) set . toArray () ;
set . clear () ;
for ( final E value : values ) {
decorated . decorated () . add ( transformer . transform ( value ) ) ;
}
}
return decorated ;
}
protected SortedSet < E > getSortedSet () {
return ( SortedSet < E > ) decorated () ;
}
@Override
public E first () {
return getSortedSet () . first () ;
}
@Override
public E last () {
return getSortedSet () . last () ;
}
@Override
public Comparator < ? super E > comparator () {
return getSortedSet () . comparator () ;
}
@Override
public SortedSet < E > subSet ( final E fromElement , final E toElement ) {
final SortedSet < E > set = getSortedSet () . subSet ( fromElement , toElement ) ;
return new TransformedSortedSet <> ( set , transformer ) ;
}
@Override
public SortedSet < E > headSet ( final E toElement ) {
final SortedSet < E > set = getSortedSet () . headSet ( toElement ) ;
return new TransformedSortedSet <> ( set , transformer ) ;
}
@Override
public SortedSet < E > tailSet ( final E fromElement ) {
final SortedSet < E > set = getSortedSet () . tailSet ( fromElement ) ;
return new TransformedSortedSet <> ( set , transformer ) ; MST[ConstructorCallMutator]MSP[]
}
