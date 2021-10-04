@SuppressWarnings ( lr_1 )
public static < I , O > Transformer < I , O > switchTransformer ( final Predicate < ? super I > [] predicates ,
final Transformer < ? super I , ? extends O > [] transformers ,
final Transformer < ? super I , ? extends O > defaultTransformer ) {
FunctorUtils . validate ( predicates ) ;
FunctorUtils . validate ( transformers ) ;
if ( predicates . length != transformers . length ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( predicates . length == 0 ) {
return ( Transformer < I , O > ) ( defaultTransformer == null ? ConstantTransformer . <I , O > nullTransformer () :
defaultTransformer ) ;
}
return new SwitchTransformer <> ( predicates , transformers , defaultTransformer ) ;
}
@SuppressWarnings ( lr_1 )
public static < I , O > Transformer < I , O > switchTransformer (
final Map < ? extends Predicate < ? super I > , ? extends Transformer < ? super I , ? extends O > > map ) {
Objects . requireNonNull ( map , lr_3 ) ;
if ( map . size () == 0 ) {
return ConstantTransformer . <I , O > nullTransformer () ;
}
final Transformer < ? super I , ? extends O > defaultTransformer = map . remove ( null ) ;
final int size = map . size () ;
if ( size == 0 ) {
return ( Transformer < I , O > ) ( defaultTransformer == null ? ConstantTransformer . <I , O > nullTransformer () :
defaultTransformer ) ;
}
final Transformer < ? super I , ? extends O > [] transformers = new Transformer [ size ] ;
final Predicate < ? super I > [] preds = new Predicate [ size ] ;
int i = 0 ;
for ( final Map . Entry < ? extends Predicate < ? super I > ,
? extends Transformer < ? super I , ? extends O > > entry : map . entrySet () ) {
preds [ i ] = entry . getKey () ;
transformers [ i ] = entry . getValue () ;
i ++ ;
}
return new SwitchTransformer <> ( false , preds , transformers , defaultTransformer ) ;
}
@Override
public O transform ( final I input ) {
for ( int i = 0 ; i < iPredicates . length ; i ++ ) {
if ( iPredicates [ i ] . evaluate ( input ) == true ) {
return iTransformers [ i ] . transform ( input ) ;
}
}
return iDefault . transform ( input ) ; MST[NullReturnValsMutator]MSP[N]
}
public Predicate < ? super I > [] getPredicates () {
return FunctorUtils . <I > copy ( iPredicates ) ;
}
public Transformer < ? super I , ? extends O > [] getTransformers () {
return FunctorUtils . <I , O > copy ( iTransformers ) ;
}
public Transformer < ? super I , ? extends O > getDefaultTransformer () {
return iDefault ;
}
