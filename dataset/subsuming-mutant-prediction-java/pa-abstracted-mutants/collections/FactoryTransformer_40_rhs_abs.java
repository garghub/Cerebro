public static < I , O > Transformer < I , O > factoryTransformer ( final Factory < ? extends O > factory ) {
return new FactoryTransformer <> ( Objects . requireNonNull ( factory , lr_1 ) ) ;
}
@Override
public O transform ( final I input ) {
return iFactory . create () ;
}
public Factory < ? extends O > getFactory () {
return iFactory ; MST[NullReturnValsMutator]MSP[S]
}
