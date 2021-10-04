@SuppressWarnings ( lr_1 )
public static < T > Transformer < T , String > stringValueTransformer () {
return ( Transformer < T , String > ) INSTANCE ;
}
@Override
public String transform ( final T input ) {
return String . valueOf ( input ) ; MST[EmptyObjectReturnValsMutator]MSP[S]
}
private Object readResolve () {
return INSTANCE ;
}
