public static < T > Transformer < T , Boolean > predicateTransformer ( final Predicate < ? super T > predicate ) {
if ( predicate == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return new PredicateTransformer <> ( predicate ) ; MST[NullReturnValsMutator]MSP[S]
}
@Override
public Boolean transform ( final T input ) {
return Boolean . valueOf ( iPredicate . evaluate ( input ) ) ;
}
public Predicate < ? super T > getPredicate () {
return iPredicate ;
}
