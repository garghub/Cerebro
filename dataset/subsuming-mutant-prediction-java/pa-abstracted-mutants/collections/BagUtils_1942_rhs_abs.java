public static < E > Bag < E > synchronizedBag ( final Bag < E > bag ) {
return SynchronizedBag . synchronizedBag ( bag ) ;
}
public static < E > Bag < E > unmodifiableBag ( final Bag < ? extends E > bag ) {
return UnmodifiableBag . unmodifiableBag ( bag ) ; MST[ArgumentPropagationMutator]MSP[S]
}
public static < E > Bag < E > predicatedBag ( final Bag < E > bag , final Predicate < ? super E > predicate ) {
return PredicatedBag . predicatedBag ( bag , predicate ) ;
}
public static < E > Bag < E > transformingBag ( final Bag < E > bag , final Transformer < ? super E , ? extends E > transformer ) {
return TransformedBag . transformingBag ( bag , transformer ) ;
}
public static < E > Bag < E > collectionBag ( final Bag < E > bag ) {
return CollectionBag . collectionBag ( bag ) ;
}
public static < E > SortedBag < E > synchronizedSortedBag ( final SortedBag < E > bag ) {
return SynchronizedSortedBag . synchronizedSortedBag ( bag ) ;
}
public static < E > SortedBag < E > unmodifiableSortedBag ( final SortedBag < E > bag ) {
return UnmodifiableSortedBag . unmodifiableSortedBag ( bag ) ;
}
public static < E > SortedBag < E > predicatedSortedBag ( final SortedBag < E > bag ,
final Predicate < ? super E > predicate ) {
return PredicatedSortedBag . predicatedSortedBag ( bag , predicate ) ;
}
public static < E > SortedBag < E > transformingSortedBag ( final SortedBag < E > bag ,
final Transformer < ? super E , ? extends E > transformer ) {
return TransformedSortedBag . transformingSortedBag ( bag , transformer ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Bag < E > emptyBag () {
return EMPTY_BAG ;
}
@SuppressWarnings ( lr_1 )
public static < E > SortedBag < E > emptySortedBag () {
return ( SortedBag < E > ) EMPTY_SORTED_BAG ;
}
