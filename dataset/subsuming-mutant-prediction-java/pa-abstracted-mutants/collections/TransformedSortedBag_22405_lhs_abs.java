public static < E > TransformedSortedBag < E > transformingSortedBag ( final SortedBag < E > bag ,
final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedSortedBag <> ( bag , transformer ) ; MST[ReturnValsMutator]MSP[]
}
public static < E > TransformedSortedBag < E > transformedSortedBag ( final SortedBag < E > bag ,
final Transformer < ? super E , ? extends E > transformer ) {
final TransformedSortedBag < E > decorated = new TransformedSortedBag <> ( bag , transformer ) ;
if ( bag . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final E [] values = ( E [] ) bag . toArray () ;
bag . clear () ;
for ( final E value : values ) {
decorated . decorated () . add ( transformer . transform ( value ) ) ;
}
}
return decorated ;
}
protected SortedBag < E > getSortedBag () {
return ( SortedBag < E > ) decorated () ;
}
@Override
public E first () {
return getSortedBag () . first () ;
}
@Override
public E last () {
return getSortedBag () . last () ;
}
@Override
public Comparator < ? super E > comparator () {
return getSortedBag () . comparator () ;
}
