public static < E > MultiSet < E > synchronizedMultiSet ( final MultiSet < E > multiset ) {
return SynchronizedMultiSet . synchronizedMultiSet ( multiset ) ;
}
public static < E > MultiSet < E > unmodifiableMultiSet ( final MultiSet < ? extends E > multiset ) {
return UnmodifiableMultiSet . unmodifiableMultiSet ( multiset ) ; MST[NonVoidMethodCallMutator]MSP[S]
}
public static < E > MultiSet < E > predicatedMultiSet ( final MultiSet < E > multiset ,
final Predicate < ? super E > predicate ) {
return PredicatedMultiSet . predicatedMultiSet ( multiset , predicate ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > MultiSet < E > emptyMultiSet () {
return EMPTY_MULTISET ;
}
