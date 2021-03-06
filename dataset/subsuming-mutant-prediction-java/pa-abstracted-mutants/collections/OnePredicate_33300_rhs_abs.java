@SuppressWarnings ( lr_1 )
public static < T > Predicate < T > onePredicate ( final Predicate < ? super T > ... predicates ) {
FunctorUtils . validate ( predicates ) ;
if ( predicates . length == 0 ) {
return FalsePredicate . <T > falsePredicate () ;
}
if ( predicates . length == 1 ) {
return ( Predicate < T > ) predicates [ 0 ] ;
}
return new OnePredicate <> ( FunctorUtils . copy ( predicates ) ) ;
}
public static < T > Predicate < T > onePredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
final Predicate < ? super T > [] preds = FunctorUtils . validate ( predicates ) ;
return new OnePredicate <> ( preds ) ;
}
@Override
public boolean evaluate ( final T object ) {
boolean match = false ;
for ( final Predicate < ? super T > iPredicate : iPredicates ) { MST[rv.UOI2Mutator]MSP[N]
if ( iPredicate . evaluate ( object ) ) {
if ( match ) {
return false ;
}
match = true ;
}
}
return match ;
}
