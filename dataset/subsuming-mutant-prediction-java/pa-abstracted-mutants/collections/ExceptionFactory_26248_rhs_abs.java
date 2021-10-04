public static < T > Factory < T > exceptionFactory () {
return INSTANCE ;
}
@Override
public T create () {
throw new FunctorException ( lr_1 ) ;
}
private Object readResolve () {
return INSTANCE ; MST[NullReturnValsMutator]MSP[S]
}
