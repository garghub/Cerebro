@SuppressWarnings ( lr_1 )
public static < T > Predicate < T > anyPredicate ( final Predicate < ? super T > ... predicates ) {
FunctorUtils . validate ( predicates ) ;
if ( predicates . length == 0 ) {
return FalsePredicate . <T > falsePredicate () ;
}
if ( predicates . length == 1 ) {
return ( Predicate < T > ) predicates [ 0 ] ; MST[rv.CRCR5Mutator]MSP[]
}
return new AnyPredicate <> ( FunctorUtils . copy ( predicates ) ) ;
}
@SuppressWarnings ( lr_1 )
public static < T > Predicate < T > anyPredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
final Predicate < ? super T > [] preds = FunctorUtils . validate ( predicates ) ;
if ( preds . length == 0 ) {
return FalsePredicate . <T > falsePredicate () ;
}
if ( preds . length == 1 ) {
return ( Predicate < T > ) preds [ 0 ] ;
}
return new AnyPredicate <> ( preds ) ;
}
@Override
public boolean evaluate ( final T object ) {
for ( final Predicate < ? super T > iPredicate : iPredicates ) {
if ( iPredicate . evaluate ( object ) ) {
return true ;
}
}
return false ;
}
