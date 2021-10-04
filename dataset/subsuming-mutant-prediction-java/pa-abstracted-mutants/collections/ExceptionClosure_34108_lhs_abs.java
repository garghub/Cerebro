public static < E > Closure < E > exceptionClosure () {
return INSTANCE ;
}
@Override
public void execute ( final E input ) {
throw new FunctorException ( lr_1 ) ;
}
private Object readResolve () {
return INSTANCE ; MST[ReturnValsMutator]MSP[]
}
