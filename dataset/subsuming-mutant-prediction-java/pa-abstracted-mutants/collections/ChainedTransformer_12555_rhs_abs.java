public static < T > Transformer < T , T > chainedTransformer ( final Transformer < ? super T , ? extends T > ... transformers ) {
FunctorUtils . validate ( transformers ) ;
if ( transformers . length == 0 ) {
return NOPTransformer . <T > nopTransformer () ;
}
return new ChainedTransformer <> ( transformers ) ;
}
public static < T > Transformer < T , T > chainedTransformer (
final Collection < ? extends Transformer < ? super T , ? extends T > > transformers ) {
Objects . requireNonNull ( transformers , lr_1 ) ;
if ( transformers . size () == 0 ) {
return NOPTransformer . <T > nopTransformer () ;
}
final Transformer < T , T > [] cmds = transformers . toArray ( new Transformer [ transformers . size () ] ) ;
FunctorUtils . validate ( cmds ) ;
return new ChainedTransformer <> ( false , cmds ) ;
}
@Override
public T transform ( T object ) {
for ( final Transformer < ? super T , ? extends T > iTransformer : iTransformers ) { MST[rv.UOI4Mutator]MSP[N]
object = iTransformer . transform ( object ) ;
}
return object ;
}
public Transformer < ? super T , ? extends T > [] getTransformers () {
return FunctorUtils . <T , T > copy ( iTransformers ) ;
}
