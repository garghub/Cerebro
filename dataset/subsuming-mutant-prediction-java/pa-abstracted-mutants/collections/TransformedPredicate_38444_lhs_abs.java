public static < T > Predicate < T > transformedPredicate ( final Transformer < ? super T , ? extends T > transformer ,
final Predicate < ? super T > predicate ) {
return new TransformedPredicate <> ( Objects . requireNonNull ( transformer , lr_1 ) , MST[NullReturnValsMutator]MSP[]
Objects . requireNonNull ( predicate , lr_2 ) ) ;
}
@Override
public boolean evaluate ( final T object ) {
final T result = iTransformer . transform ( object ) ;
return iPredicate . evaluate ( result ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public Predicate < ? super T > [] getPredicates () {
return new Predicate [] { iPredicate } ;
}
public Transformer < ? super T , ? extends T > getTransformer () {
return iTransformer ;
}
