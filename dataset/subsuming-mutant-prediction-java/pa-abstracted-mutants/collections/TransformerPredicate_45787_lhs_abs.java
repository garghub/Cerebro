public static < T > Predicate < T > transformerPredicate ( final Transformer < ? super T , Boolean > transformer ) {
return new TransformerPredicate <> ( Objects . requireNonNull ( transformer , lr_1 ) ) ;
}
@Override
public boolean evaluate ( final T object ) {
final Boolean result = iTransformer . transform ( object ) ;
if ( result == null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
throw new FunctorException (
lr_2 ) ;
}
return result . booleanValue () ;
}
public Transformer < ? super T , Boolean > getTransformer () {
return iTransformer ;
}
