public static < E > TransformedSet < E > transformingSet ( final Set < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedSet <> ( set , transformer ) ;
}
public static < E > Set < E > transformedSet ( final Set < E > set , final Transformer < ? super E , ? extends E > transformer ) {
final TransformedSet < E > decorated = new TransformedSet <> ( set , transformer ) ;
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
public boolean equals ( final Object object ) {
return object == this || decorated () . equals ( object ) ; MST[rv.CRCR6Mutator]MSP[S]
}
@Override
public int hashCode () {
return decorated () . hashCode () ;
}
