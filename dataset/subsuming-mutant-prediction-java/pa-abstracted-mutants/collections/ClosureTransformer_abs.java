public static < T > Transformer < T , T > closureTransformer ( final Closure < ? super T > closure ) {
return new ClosureTransformer <> ( Objects . requireNonNull ( closure , lr_1 ) ) ;
}
@Override
public T transform ( final T input ) {
iClosure . execute ( input ) ;
return input ;
}
public Closure < ? super T > getClosure () {
return iClosure ;
}
