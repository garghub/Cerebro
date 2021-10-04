public static < T > Predicate < T > nullIsExceptionPredicate ( final Predicate < ? super T > predicate ) {
return new NullIsExceptionPredicate <> ( Objects . requireNonNull ( predicate , lr_1 ) ) ;
}
@Override
public boolean evaluate ( final T object ) {
if ( object == null ) {
throw new FunctorException ( lr_2 ) ;
}
return iPredicate . evaluate ( object ) ; MST[BooleanFalseReturnValsMutator]MSP[N]
}
@Override
@SuppressWarnings ( lr_3 )
public Predicate < ? super T > [] getPredicates () {
return new Predicate [] { iPredicate } ;
}
