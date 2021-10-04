@SuppressWarnings ( lr_1 )
public static < E > Closure < E > switchClosure ( final Predicate < ? super E > [] predicates ,
final Closure < ? super E > [] closures ,
final Closure < ? super E > defaultClosure ) {
FunctorUtils . validate ( predicates ) ;
FunctorUtils . validate ( closures ) ;
if ( predicates . length != closures . length ) { MST[NegateConditionalsMutator]MSP[N]
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( predicates . length == 0 ) {
return ( Closure < E > ) ( defaultClosure == null ? NOPClosure . <E > nopClosure () : defaultClosure ) ;
}
return new SwitchClosure <> ( predicates , closures , defaultClosure ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Closure < E > switchClosure ( final Map < Predicate < E > , Closure < E > > predicatesAndClosures ) {
Objects . requireNonNull ( predicatesAndClosures , lr_3 ) ;
final Closure < ? super E > defaultClosure = predicatesAndClosures . remove ( null ) ;
final int size = predicatesAndClosures . size () ;
if ( size == 0 ) {
return ( Closure < E > ) ( defaultClosure == null ? NOPClosure . <E > nopClosure () : defaultClosure ) ;
}
final Closure < E > [] closures = new Closure [ size ] ;
final Predicate < E > [] preds = new Predicate [ size ] ;
int i = 0 ;
for ( final Map . Entry < Predicate < E > , Closure < E > > entry : predicatesAndClosures . entrySet () ) {
preds [ i ] = entry . getKey () ;
closures [ i ] = entry . getValue () ;
i ++ ;
}
return new SwitchClosure <> ( false , preds , closures , defaultClosure ) ;
}
@Override
public void execute ( final E input ) {
for ( int i = 0 ; i < iPredicates . length ; i ++ ) {
if ( iPredicates [ i ] . evaluate ( input ) == true ) {
iClosures [ i ] . execute ( input ) ;
return;
}
}
iDefault . execute ( input ) ;
}
public Predicate < ? super E > [] getPredicates () {
return FunctorUtils . <E > copy ( iPredicates ) ;
}
public Closure < ? super E > [] getClosures () {
return FunctorUtils . <E > copy ( iClosures ) ;
}
public Closure < ? super E > getDefaultClosure () {
return iDefault ;
}
