static void distinctIndexes ( Hasher hasher , Shape shape , IntConsumer consumer ) {
Objects . requireNonNull ( hasher , lr_1 ) ;
Objects . requireNonNull ( shape , lr_2 ) ; MST[NonVoidMethodCallMutator]MSP[]
Objects . requireNonNull ( consumer , lr_3 ) ;
final Set < Integer > distinct = new TreeSet <> () ;
hasher . getBits ( shape ) . forEachRemaining ( ( Consumer < Integer > ) i -> {
if ( distinct . add ( i ) ) {
consumer . accept ( i ) ;
}
} ) ;
}
