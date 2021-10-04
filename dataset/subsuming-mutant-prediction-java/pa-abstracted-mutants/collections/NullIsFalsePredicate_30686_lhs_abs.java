public static < T > Predicate < T > nullIsFalsePredicate ( final Predicate < ? super T > predicate ) {
return new NullIsFalsePredicate <> ( Objects . requireNonNull ( predicate , lr_1 ) ) ; MST[NullReturnValsMutator]MSP[]
}
@Override
public boolean evaluate ( final T object ) {
if ( object == null ) {
return false ;
}
return iPredicate . evaluate ( object ) ;
}
@Override
@SuppressWarnings ( lr_2 )
public Predicate < ? super T > [] getPredicates () {
return new Predicate [] { iPredicate } ;
}
