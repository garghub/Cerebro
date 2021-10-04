public static < T > Predicate < T > exceptionPredicate () {
return INSTANCE ; MST[ReturnValsMutator]MSP[N]
}
@Override
public boolean evaluate ( final T object ) {
throw new FunctorException ( lr_1 ) ;
}
private Object readResolve () {
return INSTANCE ;
}
