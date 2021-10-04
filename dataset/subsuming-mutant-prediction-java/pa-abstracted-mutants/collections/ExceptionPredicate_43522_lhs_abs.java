public static < T > Predicate < T > exceptionPredicate () {
return INSTANCE ; MST[NullReturnValsMutator]MSP[]
}
@Override
public boolean evaluate ( final T object ) {
throw new FunctorException ( lr_1 ) ;
}
private Object readResolve () {
return INSTANCE ;
}
