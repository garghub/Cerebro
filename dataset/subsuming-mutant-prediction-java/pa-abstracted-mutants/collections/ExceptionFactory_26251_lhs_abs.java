public static < T > Factory < T > exceptionFactory () {
return INSTANCE ; MST[ReturnValsMutator]MSP[]
}
@Override
public T create () {
throw new FunctorException ( lr_1 ) ;
}
private Object readResolve () {
return INSTANCE ;
}
