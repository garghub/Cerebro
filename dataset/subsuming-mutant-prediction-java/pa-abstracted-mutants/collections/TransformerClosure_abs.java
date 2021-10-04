public static < E > Closure < E > transformerClosure ( final Transformer < ? super E , ? > transformer ) {
if ( transformer == null ) {
return NOPClosure . <E > nopClosure () ;
}
return new TransformerClosure <> ( transformer ) ;
}
@Override
public void execute ( final E input ) {
iTransformer . transform ( input ) ;
}
public Transformer < ? super E , ? > getTransformer () {
return iTransformer ;
}
