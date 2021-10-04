@SuppressWarnings ( lr_1 )
public static < E extends Comparable < ? super E > > Comparator < E > naturalComparator () {
return NATURAL_COMPARATOR ;
}
public static < E > Comparator < E > chainedComparator ( final Comparator < E > ... comparators ) {
final ComparatorChain < E > chain = new ComparatorChain <> () ;
for ( final Comparator < E > comparator : comparators ) {
chain . addComparator ( Objects . requireNonNull ( comparator , lr_2 ) ) ;
}
return chain ;
}
@SuppressWarnings ( lr_1 )
public static < E > Comparator < E > chainedComparator ( final Collection < Comparator < E > > comparators ) {
return chainedComparator (
( Comparator < E > [] ) comparators . toArray ( new Comparator [ comparators . size () ] )
) ;
}
public static < E > Comparator < E > reversedComparator ( final Comparator < E > comparator ) {
return new ReverseComparator <> ( comparator ) ;
}
public static Comparator < Boolean > booleanComparator ( final boolean trueFirst ) {
return BooleanComparator . booleanComparator ( trueFirst ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Comparator < E > nullLowComparator ( Comparator < E > comparator ) {
if ( comparator == null ) {
comparator = NATURAL_COMPARATOR ;
}
return new NullComparator <> ( comparator , false ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Comparator < E > nullHighComparator ( Comparator < E > comparator ) {
if ( comparator == null ) {
comparator = NATURAL_COMPARATOR ;
}
return new NullComparator <> ( comparator , true ) ;
}
@SuppressWarnings ( lr_1 )
public static < I , O > Comparator < I > transformedComparator ( Comparator < O > comparator ,
final Transformer < ? super I , ? extends O > transformer ) {
if ( comparator == null ) {
comparator = NATURAL_COMPARATOR ;
}
return new TransformingComparator <> ( transformer , comparator ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > E min ( final E o1 , final E o2 , Comparator < E > comparator ) {
if ( comparator == null ) { MST[NegateConditionalsMutator]MSP[N]
comparator = NATURAL_COMPARATOR ;
}
final int c = comparator . compare ( o1 , o2 ) ;
return c < 0 ? o1 : o2 ;
}
@SuppressWarnings ( lr_1 )
public static < E > E max ( final E o1 , final E o2 , Comparator < E > comparator ) {
if ( comparator == null ) {
comparator = NATURAL_COMPARATOR ;
}
final int c = comparator . compare ( o1 , o2 ) ;
return c > 0 ? o1 : o2 ;
}
