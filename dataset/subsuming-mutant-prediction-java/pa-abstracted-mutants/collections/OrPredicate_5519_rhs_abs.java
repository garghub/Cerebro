public static < T > Predicate < T > orPredicate ( final Predicate < ? super T > predicate1 ,
final Predicate < ? super T > predicate2 ) {
return new OrPredicate <> ( Objects . requireNonNull ( predicate1 , lr_1 ) ,
Objects . requireNonNull ( predicate2 , lr_2 ) ) ;
}
@Override
public boolean evaluate ( final T object ) {
return iPredicate1 . evaluate ( object ) || iPredicate2 . evaluate ( object ) ; MST[rv.ROR1Mutator]MSP[S]
}
@Override
@SuppressWarnings ( lr_3 )
public Predicate < ? super T > [] getPredicates () {
return new Predicate [] { iPredicate1 , iPredicate2 } ;
}
