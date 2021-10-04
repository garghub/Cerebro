public static < T > Transformer < T , T > cloneTransformer () {
return INSTANCE ;
}
@Override
public T transform ( final T input ) {
if ( input == null ) {
return null ;
}
return PrototypeFactory . prototypeFactory ( input ) . create () ;
}
