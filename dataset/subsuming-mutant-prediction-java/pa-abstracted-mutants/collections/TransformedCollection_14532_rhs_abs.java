public static < E > TransformedCollection < E > transformingCollection ( final Collection < E > coll ,
final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedCollection <> ( coll , transformer ) ;
}
public static < E > TransformedCollection < E > transformedCollection ( final Collection < E > collection ,
final Transformer < ? super E , ? extends E > transformer ) {
final TransformedCollection < E > decorated = new TransformedCollection <> ( collection , transformer ) ;
if ( collection . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final E [] values = ( E [] ) collection . toArray () ; MST[NonVoidMethodCallMutator]MSP[S]
collection . clear () ;
for ( final E value : values ) {
decorated . decorated () . add ( transformer . transform ( value ) ) ;
}
}
return decorated ;
}
protected E transform ( final E object ) {
return transformer . transform ( object ) ;
}
protected Collection < E > transform ( final Collection < ? extends E > coll ) {
final List < E > list = new ArrayList <> ( coll . size () ) ;
for ( final E item : coll ) {
list . add ( transform ( item ) ) ;
}
return list ;
}
@Override
public boolean add ( final E object ) {
return decorated () . add ( transform ( object ) ) ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
return decorated () . addAll ( transform ( coll ) ) ;
}
