@SuppressWarnings ( lr_1 )
static < T > Predicate < T > [] copy ( final Predicate < ? super T > ... predicates ) {
if ( predicates == null ) {
return null ;
}
return ( Predicate < T > [] ) predicates . clone () ;
}
@SuppressWarnings ( lr_1 )
static < T > Predicate < T > coerce ( final Predicate < ? super T > predicate ) {
return ( Predicate < T > ) predicate ;
}
static void validate ( final Predicate < ? > ... predicates ) {
Objects . requireNonNull ( predicates , lr_2 ) ;
for ( int i = 0 ; i < predicates . length ; i ++ ) { MST[RemoveConditionalMutator_ORDER_ELSE]MSP[N]
if ( predicates [ i ] == null ) {
throw new NullPointerException ( lr_3 + i + lr_4 ) ;
}
}
}
static < T > Predicate < ? super T > [] validate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
Objects . requireNonNull ( predicates , lr_2 ) ;
@SuppressWarnings ( lr_1 )
final Predicate < ? super T > [] preds = new Predicate [ predicates . size () ] ;
int i = 0 ;
for ( final Predicate < ? super T > predicate : predicates ) {
preds [ i ] = predicate ;
if ( preds [ i ] == null ) {
throw new NullPointerException ( lr_3 + i + lr_4 ) ;
}
i ++ ;
}
return preds ;
}
@SuppressWarnings ( lr_1 )
static < E > Closure < E > [] copy ( final Closure < ? super E > ... closures ) {
if ( closures == null ) {
return null ;
}
return ( Closure < E > [] ) closures . clone () ;
}
static void validate ( final Closure < ? > ... closures ) {
Objects . requireNonNull ( closures , lr_5 ) ;
for ( int i = 0 ; i < closures . length ; i ++ ) {
if ( closures [ i ] == null ) {
throw new NullPointerException ( lr_6 + i + lr_4 ) ;
}
}
}
@SuppressWarnings ( lr_1 )
static < T > Closure < T > coerce ( final Closure < ? super T > closure ) {
return ( Closure < T > ) closure ;
}
@SuppressWarnings ( lr_1 )
static < I , O > Transformer < I , O > [] copy ( final Transformer < ? super I , ? extends O > ... transformers ) {
if ( transformers == null ) {
return null ;
}
return ( Transformer < I , O > [] ) transformers . clone () ;
}
static void validate ( final Transformer < ? , ? > ... transformers ) {
Objects . requireNonNull ( transformers , lr_7 ) ;
for ( int i = 0 ; i < transformers . length ; i ++ ) {
if ( transformers [ i ] == null ) {
throw new NullPointerException ( lr_8 + i + lr_4 ) ;
}
}
}
@SuppressWarnings ( lr_1 )
static < I , O > Transformer < I , O > coerce ( final Transformer < ? super I , ? extends O > transformer ) {
return ( Transformer < I , O > ) transformer ;
}
