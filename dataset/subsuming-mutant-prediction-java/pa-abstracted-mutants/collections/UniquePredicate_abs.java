public static < T > Predicate < T > uniquePredicate () {
return new UniquePredicate <> () ;
}
@Override
public boolean evaluate ( final T object ) {
return iSet . add ( object ) ;
}
