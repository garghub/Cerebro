public static < T > Predicate < T > nullIsTruePredicate ( final Predicate < ? super T > predicate ) {
return new NullIsTruePredicate <> ( Objects . requireNonNull ( predicate , lr_1 ) ) ;
}
@Override
public boolean evaluate ( final T object ) {
if ( object == null ) {
return true ;
}
return iPredicate . evaluate ( object ) ; MST[BooleanFalseReturnValsMutator]MSP[S]
}
@Override
@SuppressWarnings ( lr_2 )
public Predicate < ? super T > [] getPredicates () {
return new Predicate [] { iPredicate } ;
}
