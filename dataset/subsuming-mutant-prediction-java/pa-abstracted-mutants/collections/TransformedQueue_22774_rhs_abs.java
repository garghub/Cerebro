public static < E > TransformedQueue < E > transformingQueue ( final Queue < E > queue ,
final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedQueue <> ( queue , transformer ) ;
}
public static < E > TransformedQueue < E > transformedQueue ( final Queue < E > queue ,
final Transformer < ? super E , ? extends E > transformer ) {
final TransformedQueue < E > decorated = new TransformedQueue <> ( queue , transformer ) ;
if ( queue . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final E [] values = ( E [] ) queue . toArray () ;
queue . clear () ;
for ( final E value : values ) { MST[rv.ABSMutator]MSP[N]
decorated . decorated () . add ( transformer . transform ( value ) ) ;
}
}
return decorated ;
}
protected Queue < E > getQueue () {
return ( Queue < E > ) decorated () ;
}
@Override
public boolean offer ( final E obj ) {
return getQueue () . offer ( transform ( obj ) ) ;
}
@Override
public E poll () {
return getQueue () . poll () ;
}
@Override
public E peek () {
return getQueue () . peek () ;
}
@Override
public E element () {
return getQueue () . element () ;
}
@Override
public E remove () {
return getQueue () . remove () ;
}
