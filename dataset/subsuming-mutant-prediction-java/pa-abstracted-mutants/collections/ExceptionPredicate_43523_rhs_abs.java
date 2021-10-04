public static < T > Predicate < T > exceptionPredicate () {
return INSTANCE ;
}
@Override
public boolean evaluate ( final T object ) {
throw new FunctorException ( lr_1 ) ; MST[ConstructorCallMutator]MSP[S]
}
private Object readResolve () {
return INSTANCE ;
}
