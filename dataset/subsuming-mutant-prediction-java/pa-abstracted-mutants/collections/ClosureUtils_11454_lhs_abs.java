public static < E > Closure < E > exceptionClosure () {
return ExceptionClosure . <E > exceptionClosure () ;
}
public static < E > Closure < E > nopClosure () {
return NOPClosure . <E > nopClosure () ;
}
public static < E > Closure < E > asClosure ( final Transformer < ? super E , ? > transformer ) {
return TransformerClosure . transformerClosure ( transformer ) ;
}
public static < E > Closure < E > forClosure ( final int count , final Closure < ? super E > closure ) {
return ForClosure . forClosure ( count , closure ) ;
}
public static < E > Closure < E > whileClosure ( final Predicate < ? super E > predicate , final Closure < ? super E > closure ) {
return WhileClosure . <E > whileClosure ( predicate , closure , false ) ;
}
public static < E > Closure < E > doWhileClosure ( final Closure < ? super E > closure ,
final Predicate < ? super E > predicate ) {
return WhileClosure . <E > whileClosure ( predicate , closure , true ) ;
}
public static < E > Closure < E > invokerClosure ( final String methodName ) {
return asClosure ( InvokerTransformer . <E , Object > invokerTransformer ( methodName ) ) ;
}
public static < E > Closure < E > invokerClosure ( final String methodName , final Class < ? > [] paramTypes ,
final Object [] args ) {
return asClosure ( InvokerTransformer . <E , Object > invokerTransformer ( methodName , paramTypes , args ) ) ;
}
public static < E > Closure < E > chainedClosure ( final Closure < ? super E > ... closures ) {
return ChainedClosure . chainedClosure ( closures ) ;
}
public static < E > Closure < E > chainedClosure ( final Collection < ? extends Closure < ? super E > > closures ) {
return ChainedClosure . chainedClosure ( closures ) ;
}
public static < E > Closure < E > ifClosure ( final Predicate < ? super E > predicate ,
final Closure < ? super E > trueClosure ) {
return IfClosure . <E > ifClosure ( predicate , trueClosure ) ;
}
public static < E > Closure < E > ifClosure ( final Predicate < ? super E > predicate ,
final Closure < ? super E > trueClosure ,
final Closure < ? super E > falseClosure ) {
return IfClosure . <E > ifClosure ( predicate , trueClosure , falseClosure ) ;
}
public static < E > Closure < E > switchClosure ( final Predicate < ? super E > [] predicates ,
final Closure < ? super E > [] closures ) {
return SwitchClosure . <E > switchClosure ( predicates , closures , null ) ;
}
public static < E > Closure < E > switchClosure ( final Predicate < ? super E > [] predicates ,
final Closure < ? super E > [] closures ,
final Closure < ? super E > defaultClosure ) {
return SwitchClosure . <E > switchClosure ( predicates , closures , defaultClosure ) ; MST[NonVoidMethodCallMutator]MSP[]
}
public static < E > Closure < E > switchClosure ( final Map < Predicate < E > , Closure < E > > predicatesAndClosures ) {
return SwitchClosure . switchClosure ( predicatesAndClosures ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Closure < E > switchMapClosure ( final Map < ? extends E , Closure < E > > objectsAndClosures ) {
Objects . requireNonNull ( objectsAndClosures , lr_2 ) ;
final Closure < ? super E > def = objectsAndClosures . remove ( null ) ;
final int size = objectsAndClosures . size () ;
final Closure < ? super E > [] trs = new Closure [ size ] ;
final Predicate < E > [] preds = new Predicate [ size ] ;
int i = 0 ;
for ( final Map . Entry < ? extends E , Closure < E > > entry : objectsAndClosures . entrySet () ) {
preds [ i ] = EqualPredicate . <E > equalPredicate ( entry . getKey () ) ;
trs [ i ] = entry . getValue () ;
i ++ ;
}
return ClosureUtils . <E > switchClosure ( preds , trs , def ) ;
}
