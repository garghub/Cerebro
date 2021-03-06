public static < T > Predicate < T > nonePredicate ( final Predicate < ? super T > ... predicates ) {
FunctorUtils . validate ( predicates ) ;
if ( predicates . length == 0 ) {
return TruePredicate . <T > truePredicate () ;
}
return new NonePredicate <> ( FunctorUtils . copy ( predicates ) ) ;
}
public static < T > Predicate < T > nonePredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
final Predicate < ? super T > [] preds = FunctorUtils . validate ( predicates ) ;
if ( preds . length == 0 ) {
return TruePredicate . <T > truePredicate () ;
}
return new NonePredicate <> ( preds ) ;
}
@Override
public boolean evaluate ( final T object ) {
for ( final Predicate < ? super T > iPredicate : iPredicates ) {
if ( iPredicate . evaluate ( object ) ) {
return false ;
}
}
return true ;
}
