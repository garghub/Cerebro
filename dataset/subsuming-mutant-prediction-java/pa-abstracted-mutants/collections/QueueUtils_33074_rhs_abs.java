public static < E > Queue < E > synchronizedQueue ( final Queue < E > queue ) {
return SynchronizedQueue . synchronizedQueue ( queue ) ; MST[NullReturnValsMutator]MSP[S]
}
public static < E > Queue < E > unmodifiableQueue ( final Queue < ? extends E > queue ) {
return UnmodifiableQueue . unmodifiableQueue ( queue ) ;
}
public static < E > Queue < E > predicatedQueue ( final Queue < E > queue , final Predicate < ? super E > predicate ) {
return PredicatedQueue . predicatedQueue ( queue , predicate ) ;
}
public static < E > Queue < E > transformingQueue ( final Queue < E > queue ,
final Transformer < ? super E , ? extends E > transformer ) {
return TransformedQueue . transformingQueue ( queue , transformer ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Queue < E > emptyQueue () {
return EMPTY_QUEUE ;
}
