public static < E > Closure < E > exceptionClosure () {
return INSTANCE ; MST[NullReturnValsMutator]MSP[N]
}
@Override
public void execute ( final E input ) {
throw new FunctorException ( lr_1 ) ;
}
private Object readResolve () {
return INSTANCE ;
}
