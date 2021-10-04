public static < T > Factory < T > exceptionFactory () {
return INSTANCE ;
}
@Override
public T create () {
throw new FunctorException ( lr_1 ) ; MST[ConstructorCallMutator]MSP[S]
}
private Object readResolve () {
return INSTANCE ;
}
