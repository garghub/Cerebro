public static < T > Predicate < T > allPredicate ( final Predicate < ? super T > ... predicates ) {
validate ( predicates ) ;
if ( predicates . length == 0 ) {
return truePredicate () ;
}
if ( predicates . length == 1 ) {
return coerce ( predicates [ 0 ] ) ;
}
return new AllPredicate <> ( FunctorUtils . copy ( predicates ) ) ;
}
public static < T > Predicate < T > allPredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
final Predicate < ? super T > [] preds = validate ( predicates ) ;
if ( preds . length == 0 ) {
return truePredicate () ;
}
if ( preds . length == 1 ) {
return coerce ( preds [ 0 ] ) ;
}
return new AllPredicate <> ( preds ) ;
}
@Override
public boolean evaluate ( final T object ) {
for ( final Predicate < ? super T > iPredicate : iPredicates ) {
if ( ! iPredicate . evaluate ( object ) ) {
return false ;
}
}
return true ;
}
