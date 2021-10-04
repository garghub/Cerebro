public static < T > Predicate < T > notPredicate ( final Predicate < ? super T > predicate ) {
return new NotPredicate <> ( Objects . requireNonNull ( predicate , lr_1 ) ) ; MST[NullReturnValsMutator]MSP[]
}
@Override
public boolean evaluate ( final T object ) {
return ! iPredicate . evaluate ( object ) ;
}
@Override
@SuppressWarnings ( lr_2 )
public Predicate < ? super T > [] getPredicates () {
return new Predicate [] { iPredicate } ;
}
