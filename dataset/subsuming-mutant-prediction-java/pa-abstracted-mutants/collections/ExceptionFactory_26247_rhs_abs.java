public static < T > Factory < T > exceptionFactory () {
return INSTANCE ; MST[NullReturnValsMutator]MSP[N]
}
@Override
public T create () {
throw new FunctorException ( lr_1 ) ;
}
private Object readResolve () {
return INSTANCE ;
}
