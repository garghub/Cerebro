public static < I , O > Transformer < I , O > exceptionTransformer () {
return ExceptionTransformer . exceptionTransformer () ;
}
public static < I , O > Transformer < I , O > nullTransformer () {
return ConstantTransformer . nullTransformer () ;
}
public static < T > Transformer < T , T > nopTransformer () {
return NOPTransformer . nopTransformer () ;
}
public static < T > Transformer < T , T > cloneTransformer () {
return CloneTransformer . cloneTransformer () ;
}
public static < I , O > Transformer < I , O > constantTransformer ( final O constantToReturn ) {
return ConstantTransformer . constantTransformer ( constantToReturn ) ;
}
public static < T > Transformer < T , T > asTransformer ( final Closure < ? super T > closure ) {
return ClosureTransformer . closureTransformer ( closure ) ;
}
public static < T > Transformer < T , Boolean > asTransformer ( final Predicate < ? super T > predicate ) {
return PredicateTransformer . predicateTransformer ( predicate ) ;
}
public static < I , O > Transformer < I , O > asTransformer ( final Factory < ? extends O > factory ) {
return FactoryTransformer . factoryTransformer ( factory ) ;
}
public static < T > Transformer < T , T > chainedTransformer (
final Transformer < ? super T , ? extends T > ... transformers ) {
return ChainedTransformer . chainedTransformer ( transformers ) ;
}
public static < T > Transformer < T , T > chainedTransformer (
final Collection < ? extends Transformer < ? super T , ? extends T > > transformers ) {
return ChainedTransformer . chainedTransformer ( transformers ) ;
}
public static < T > Transformer < T , T > ifTransformer ( final Predicate < ? super T > predicate ,
final Transformer < ? super T , ? extends T > trueTransformer ) {
return IfTransformer . ifTransformer ( predicate , trueTransformer ) ;
}
public static < I , O > Transformer < I , O > ifTransformer ( final Predicate < ? super I > predicate ,
final Transformer < ? super I , ? extends O > trueTransformer ,
final Transformer < ? super I , ? extends O > falseTransformer ) {
return IfTransformer . ifTransformer ( predicate , trueTransformer , falseTransformer ) ;
}
@SuppressWarnings ( lr_1 )
@Deprecated
public static < I , O > Transformer < I , O > switchTransformer ( final Predicate < ? super I > predicate ,
final Transformer < ? super I , ? extends O > trueTransformer ,
final Transformer < ? super I , ? extends O > falseTransformer ) {
return SwitchTransformer . switchTransformer ( new Predicate [] { predicate } ,
new Transformer [] { trueTransformer } , falseTransformer ) ;
}
public static < I , O > Transformer < I , O > switchTransformer ( final Predicate < ? super I > [] predicates ,
final Transformer < ? super I , ? extends O > [] transformers ) {
return SwitchTransformer . switchTransformer ( predicates , transformers , null ) ;
}
public static < I , O > Transformer < I , O > switchTransformer ( final Predicate < ? super I > [] predicates ,
final Transformer < ? super I , ? extends O > [] transformers ,
final Transformer < ? super I , ? extends O > defaultTransformer ) {
return SwitchTransformer . switchTransformer ( predicates , transformers , defaultTransformer ) ;
}
public static < I , O > Transformer < I , O > switchTransformer (
final Map < Predicate < I > , Transformer < I , O > > predicatesAndTransformers ) {
return SwitchTransformer . switchTransformer ( predicatesAndTransformers ) ;
}
@SuppressWarnings ( lr_1 )
public static < I , O > Transformer < I , O > switchMapTransformer (
final Map < I , Transformer < I , O > > objectsAndTransformers ) {
Objects . requireNonNull ( objectsAndTransformers , lr_2 ) ;
final Transformer < ? super I , ? extends O > def = objectsAndTransformers . remove ( null ) ; MST[NonVoidMethodCallMutator]MSP[]
final int size = objectsAndTransformers . size () ;
final Transformer < ? super I , ? extends O > [] trs = new Transformer [ size ] ;
final Predicate < I > [] preds = new Predicate [ size ] ;
int i = 0 ;
for ( final Map . Entry < I , Transformer < I , O > > entry : objectsAndTransformers . entrySet () ) {
preds [ i ] = EqualPredicate . <I > equalPredicate ( entry . getKey () ) ;
trs [ i ++ ] = entry . getValue () ;
}
return TransformerUtils . switchTransformer ( preds , trs , def ) ;
}
public static < T > Transformer < Class < ? extends T > , T > instantiateTransformer () {
return InstantiateTransformer . instantiateTransformer () ;
}
public static < T > Transformer < Class < ? extends T > , T > instantiateTransformer (
final Class < ? > [] paramTypes , final Object [] args ) {
return InstantiateTransformer . instantiateTransformer ( paramTypes , args ) ;
}
public static < I , O > Transformer < I , O > mapTransformer ( final Map < ? super I , ? extends O > map ) {
return MapTransformer . mapTransformer ( map ) ;
}
public static < I , O > Transformer < I , O > invokerTransformer ( final String methodName ) {
return InvokerTransformer . invokerTransformer ( methodName , null , null ) ;
}
public static < I , O > Transformer < I , O > invokerTransformer ( final String methodName , final Class < ? > [] paramTypes ,
final Object [] args ) {
return InvokerTransformer . invokerTransformer ( methodName , paramTypes , args ) ;
}
public static < T > Transformer < T , String > stringValueTransformer () {
return StringValueTransformer . stringValueTransformer () ;
}
