public static < T > Transformer < T , T > nopTransformer () {
return INSTANCE ;
}
@Override
public T transform ( final T input ) {
return input ;
}
private Object readResolve () {
return INSTANCE ;
}
