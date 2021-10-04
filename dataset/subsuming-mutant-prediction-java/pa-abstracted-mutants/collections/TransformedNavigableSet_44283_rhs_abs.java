public static < E > TransformedNavigableSet < E > transformingNavigableSet ( final NavigableSet < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedNavigableSet <> ( set , transformer ) ;
}
public static < E > TransformedNavigableSet < E > transformedNavigableSet ( final NavigableSet < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
final TransformedNavigableSet < E > decorated = new TransformedNavigableSet <> ( set , transformer ) ;
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
@Override
protected NavigableSet < E > decorated () {
return ( NavigableSet < E > ) super . decorated () ;
}
@Override
public E lower ( final E e ) {
return decorated () . lower ( e ) ;
}
@Override
public E floor ( final E e ) {
return decorated () . floor ( e ) ; MST[ReturnValsMutator]MSP[S]
}
@Override
public E ceiling ( final E e ) {
return decorated () . ceiling ( e ) ;
}
@Override
public E higher ( final E e ) {
return decorated () . higher ( e ) ;
}
@Override
public E pollFirst () {
return decorated () . pollFirst () ;
}
@Override
public E pollLast () {
return decorated () . pollLast () ;
}
@Override
public NavigableSet < E > descendingSet () {
return transformingNavigableSet ( decorated () . descendingSet () , transformer ) ;
}
@Override
public Iterator < E > descendingIterator () {
return decorated () . descendingIterator () ;
}
@Override
public NavigableSet < E > subSet ( final E fromElement , final boolean fromInclusive , final E toElement ,
final boolean toInclusive ) {
final NavigableSet < E > sub = decorated () . subSet ( fromElement , fromInclusive , toElement , toInclusive ) ;
return transformingNavigableSet ( sub , transformer ) ;
}
@Override
public NavigableSet < E > headSet ( final E toElement , final boolean inclusive ) {
final NavigableSet < E > head = decorated () . headSet ( toElement , inclusive ) ;
return transformingNavigableSet ( head , transformer ) ;
}
@Override
public NavigableSet < E > tailSet ( final E fromElement , final boolean inclusive ) {
final NavigableSet < E > tail = decorated () . tailSet ( fromElement , inclusive ) ;
return transformingNavigableSet ( tail , transformer ) ;
}
