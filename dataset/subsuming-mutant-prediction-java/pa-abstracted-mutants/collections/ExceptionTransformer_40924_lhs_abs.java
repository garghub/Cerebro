public static < I , O > Transformer < I , O > exceptionTransformer () {
return INSTANCE ;
}
@Override
public O transform ( final I input ) {
throw new FunctorException ( lr_1 ) ; MST[ConstructorCallMutator]MSP[]
}
private Object readResolve () {
return INSTANCE ;
}
