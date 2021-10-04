public static < T > Predicate < T > andPredicate ( final Predicate < ? super T > predicate1 ,
final Predicate < ? super T > predicate2 ) {
return new AndPredicate <> ( Objects . requireNonNull ( predicate1 , lr_1 ) ,
Objects . requireNonNull ( predicate2 , lr_2 ) ) ;
}
@Override
public boolean evaluate ( final T object ) {
return iPredicate1 . evaluate ( object ) && iPredicate2 . evaluate ( object ) ; MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
}
@Override
@SuppressWarnings ( lr_3 )
public Predicate < ? super T > [] getPredicates () {
return new Predicate [] { iPredicate1 , iPredicate2 } ;
}
