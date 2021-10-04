public static < E > Closure < E > exceptionClosure () {
return INSTANCE ;
}
@Override
public void execute ( final E input ) {
throw new FunctorException ( lr_1 ) ; MST[ConstructorCallMutator]MSP[S]
}
private Object readResolve () {
return INSTANCE ;
}
