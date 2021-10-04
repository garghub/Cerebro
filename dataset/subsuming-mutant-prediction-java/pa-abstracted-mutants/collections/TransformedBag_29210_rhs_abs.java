public static < E > Bag < E > transformingBag ( final Bag < E > bag , final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedBag <> ( bag , transformer ) ;
}
public static < E > Bag < E > transformedBag ( final Bag < E > bag , final Transformer < ? super E , ? extends E > transformer ) {
final TransformedBag < E > decorated = new TransformedBag <> ( bag , transformer ) ;
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
protected Bag < E > getBag () {
return ( Bag < E > ) decorated () ;
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
public int getCount ( final Object object ) {
return getBag () . getCount ( object ) ;
}
@Override
public boolean remove ( final Object object , final int nCopies ) {
return getBag () . remove ( object , nCopies ) ; MST[rv.UOI4Mutator]MSP[S]
}
@Override
public boolean add ( final E object , final int nCopies ) {
return getBag () . add ( transform ( object ) , nCopies ) ;
}
@Override
public Set < E > uniqueSet () {
final Set < E > set = getBag () . uniqueSet () ;
return TransformedSet . <E > transformingSet ( set , transformer ) ;
}
