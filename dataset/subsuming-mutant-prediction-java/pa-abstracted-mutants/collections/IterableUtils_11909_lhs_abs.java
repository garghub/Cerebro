@Override
public Iterator < Object > iterator () {
return IteratorUtils . emptyIterator () ;
}
@SuppressWarnings ( lr_1 )
public static < E > Iterable < E > emptyIterable () {
return EMPTY_ITERABLE ;
}
@SuppressWarnings ( lr_1 )
public static < E > Iterable < E > chainedIterable ( final Iterable < ? extends E > a ,
final Iterable < ? extends E > b ) {
return chainedIterable ( new Iterable [] { a , b } ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Iterable < E > chainedIterable ( final Iterable < ? extends E > a ,
final Iterable < ? extends E > b ,
final Iterable < ? extends E > c ) {
return chainedIterable ( new Iterable [] { a , b , c } ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Iterable < E > chainedIterable ( final Iterable < ? extends E > a ,
final Iterable < ? extends E > b ,
final Iterable < ? extends E > c ,
final Iterable < ? extends E > d ) {
return chainedIterable ( new Iterable [] { a , b , c , d } ) ;
}
@Override
protected Iterator < ? extends E > nextIterator ( final int count ) {
if ( count > iterables . length ) {
return null ;
}
return iterables [ count - 1 ] . iterator () ;
}
@Override
public Iterator < E > iterator () {
return IteratorUtils . collatedIterator ( null , a . iterator () , b . iterator () ) ;
}
@Override
public Iterator < E > iterator () {
return IteratorUtils . collatedIterator ( comparator , a . iterator () , b . iterator () ) ;
}
@Override
public Iterator < E > iterator () {
return IteratorUtils . filteredIterator ( emptyIteratorIfNull ( iterable ) , predicate ) ;
}
@Override
public Iterator < E > iterator () {
return IteratorUtils . boundedIterator ( iterable . iterator () , maxSize ) ;
}
@Override
protected Iterator < ? extends E > nextIterator ( final int count ) {
if ( IterableUtils . isEmpty ( iterable ) ) {
return null ;
}
return iterable . iterator () ;
}
@Override
public Iterator < E > iterator () {
final List < E > list = ( iterable instanceof List < ? > ) ?
( List < E > ) iterable :
IteratorUtils . toList ( iterable . iterator () ) ;
return new ReverseListIterator <> ( list ) ;
}
@Override MST[ReturnValsMutator]MSP[]
public Iterator < E > iterator () {
return IteratorUtils . skippingIterator ( iterable . iterator () , elementsToSkip ) ;
}
@Override
public Iterator < O > iterator () {
return IteratorUtils . transformedIterator ( iterable . iterator () , transformer ) ;
}
@Override
public Iterator < E > iterator () {
return new UniqueFilterIterator <> ( iterable . iterator () ) ;
}
public static < E > Iterable < E > unmodifiableIterable ( final Iterable < E > iterable ) {
checkNotNull ( iterable ) ;
if ( iterable instanceof UnmodifiableIterable < ? > ) {
return iterable ;
}
return new UnmodifiableIterable <> ( iterable ) ;
}
@Override
public Iterator < E > iterator () {
return IteratorUtils . unmodifiableIterator ( unmodifiable . iterator () ) ;
}
@Override
public Iterator < E > iterator () {
return IteratorUtils . zippingIterator ( a . iterator () , b . iterator () ) ;
}
@Override
public Iterator < E > iterator () {
@SuppressWarnings ( lr_1 )
final
Iterator < ? extends E > [] iterators = new Iterator [ others . length + 1 ] ;
iterators [ 0 ] = first . iterator () ;
for ( int i = 0 ; i < others . length ; i ++ ) {
iterators [ i + 1 ] = others [ i ] . iterator () ;
}
return IteratorUtils . zippingIterator ( iterators ) ;
}
public static < E > Iterable < E > emptyIfNull ( final Iterable < E > iterable ) {
return iterable == null ? IterableUtils . <E > emptyIterable () : iterable ;
}
public static < E > void forEach ( final Iterable < E > iterable , final Closure < ? super E > closure ) {
IteratorUtils . forEach ( emptyIteratorIfNull ( iterable ) , closure ) ;
}
public static < E > E forEachButLast ( final Iterable < E > iterable , final Closure < ? super E > closure ) {
return IteratorUtils . forEachButLast ( emptyIteratorIfNull ( iterable ) , closure ) ;
}
public static < E > E find ( final Iterable < E > iterable , final Predicate < ? super E > predicate ) {
return IteratorUtils . find ( emptyIteratorIfNull ( iterable ) , predicate ) ;
}
public static < E > int indexOf ( final Iterable < E > iterable , final Predicate < ? super E > predicate ) {
return IteratorUtils . indexOf ( emptyIteratorIfNull ( iterable ) , predicate ) ;
}
public static < E > boolean matchesAll ( final Iterable < E > iterable , final Predicate < ? super E > predicate ) {
return IteratorUtils . matchesAll ( emptyIteratorIfNull ( iterable ) , predicate ) ;
}
public static < E > boolean matchesAny ( final Iterable < E > iterable , final Predicate < ? super E > predicate ) {
return IteratorUtils . matchesAny ( emptyIteratorIfNull ( iterable ) , predicate ) ;
}
public static < E > long countMatches ( final Iterable < E > input , final Predicate < ? super E > predicate ) {
Objects . requireNonNull ( predicate , lr_2 ) ;
return size ( filteredIterable ( emptyIfNull ( input ) , predicate ) ) ;
}
public static boolean isEmpty ( final Iterable < ? > iterable ) {
if ( iterable instanceof Collection < ? > ) {
return ( ( Collection < ? > ) iterable ) . isEmpty () ;
}
return IteratorUtils . isEmpty ( emptyIteratorIfNull ( iterable ) ) ;
}
public static < E > boolean contains ( final Iterable < E > iterable , final Object object ) {
if ( iterable instanceof Collection < ? > ) {
return ( ( Collection < E > ) iterable ) . contains ( object ) ;
}
return IteratorUtils . contains ( emptyIteratorIfNull ( iterable ) , object ) ;
}
public static < E > boolean contains ( final Iterable < ? extends E > iterable , final E object ,
final Equator < ? super E > equator ) {
Objects . requireNonNull ( equator , lr_3 ) ;
return matchesAny ( iterable , EqualPredicate . equalPredicate ( object , equator ) ) ;
}
public static < E , T extends E > int frequency ( final Iterable < E > iterable , final T obj ) {
if ( iterable instanceof Set < ? > ) {
return ( ( Set < E > ) iterable ) . contains ( obj ) ? 1 : 0 ;
}
if ( iterable instanceof Bag < ? > ) {
return ( ( Bag < E > ) iterable ) . getCount ( obj ) ;
}
return size ( filteredIterable ( emptyIfNull ( iterable ) , EqualPredicate . <E > equalPredicate ( obj ) ) ) ;
}
public static < T > T get ( final Iterable < T > iterable , final int index ) {
CollectionUtils . checkIndexBounds ( index ) ;
if ( iterable instanceof List < ? > ) {
return ( ( List < T > ) iterable ) . get ( index ) ;
}
return IteratorUtils . get ( emptyIteratorIfNull ( iterable ) , index ) ;
}
public static < T > T first ( final Iterable < T > iterable ) {
return get ( iterable , 0 ) ;
}
public static int size ( final Iterable < ? > iterable ) {
if ( iterable instanceof Collection < ? > ) {
return ( ( Collection < ? > ) iterable ) . size () ;
}
return IteratorUtils . size ( emptyIteratorIfNull ( iterable ) ) ;
}
public static < O > List < List < O > > partition ( final Iterable < ? extends O > iterable ,
final Predicate < ? super O > predicate ) {
Objects . requireNonNull ( predicate , lr_2 ) ;
@SuppressWarnings ( { lr_1 , lr_4 } )
final Factory < List < O > > factory = FactoryUtils . instantiateFactory ( ( Class ) ArrayList . class ) ;
@SuppressWarnings ( lr_1 )
final Predicate < ? super O > [] predicates = new Predicate [] { predicate } ;
return partition ( iterable , factory , predicates ) ;
}
public static < O > List < List < O > > partition ( final Iterable < ? extends O > iterable ,
final Predicate < ? super O > ... predicates ) {
@SuppressWarnings ( { lr_1 , lr_4 } )
final Factory < List < O > > factory = FactoryUtils . instantiateFactory ( ( Class ) ArrayList . class ) ;
return partition ( iterable , factory , predicates ) ;
}
public static < O , R extends Collection < O > > List < R > partition ( final Iterable < ? extends O > iterable ,
final Factory < R > partitionFactory , final Predicate < ? super O > ... predicates ) {
if ( iterable == null ) {
final Iterable < O > empty = emptyIterable () ;
return partition ( empty , partitionFactory , predicates ) ;
}
Objects . requireNonNull ( predicates , lr_5 ) ;
for ( final Predicate < ? > predicate : predicates ) {
Objects . requireNonNull ( predicate , lr_2 ) ;
}
if ( predicates . length < 1 ) {
final R singlePartition = partitionFactory . create () ;
CollectionUtils . addAll ( singlePartition , iterable ) ;
return Collections . singletonList ( singlePartition ) ;
}
final int numberOfPredicates = predicates . length ;
final int numberOfPartitions = numberOfPredicates + 1 ;
final List < R > partitions = new ArrayList <> ( numberOfPartitions ) ;
for ( int i = 0 ; i < numberOfPartitions ; ++ i ) {
partitions . add ( partitionFactory . create () ) ;
}
for ( final O element : iterable ) {
boolean elementAssigned = false ;
for ( int i = 0 ; i < numberOfPredicates ; ++ i ) {
if ( predicates [ i ] . evaluate ( element ) ) {
partitions . get ( i ) . add ( element ) ;
elementAssigned = true ;
break;
}
}
if ( ! elementAssigned ) {
partitions . get ( numberOfPredicates ) . add ( element ) ;
}
}
return partitions ;
}
public static < E > List < E > toList ( final Iterable < E > iterable ) {
return IteratorUtils . toList ( emptyIteratorIfNull ( iterable ) ) ;
}
public static < E > String toString ( final Iterable < E > iterable ) {
return IteratorUtils . toString ( emptyIteratorIfNull ( iterable ) ) ;
}
public static < E > String toString ( final Iterable < E > iterable ,
final Transformer < ? super E , String > transformer ) {
Objects . requireNonNull ( transformer , lr_6 ) ;
return IteratorUtils . toString ( emptyIteratorIfNull ( iterable ) , transformer ) ;
}
public static < E > String toString ( final Iterable < E > iterable ,
final Transformer < ? super E , String > transformer ,
final String delimiter ,
final String prefix ,
final String suffix ) {
return IteratorUtils . toString ( emptyIteratorIfNull ( iterable ) ,
transformer , delimiter , prefix , suffix ) ;
}
static void checkNotNull ( final Iterable < ? > iterable ) {
Objects . requireNonNull ( iterable , lr_7 ) ;
}
static void checkNotNull ( final Iterable < ? > ... iterables ) {
Objects . requireNonNull ( iterables , lr_8 ) ;
for ( final Iterable < ? > iterable : iterables ) {
checkNotNull ( iterable ) ;
}
}
private static < E > Iterator < E > emptyIteratorIfNull ( final Iterable < E > iterable ) {
return iterable != null ? iterable . iterator () : IteratorUtils . <E > emptyIterator () ;
}
