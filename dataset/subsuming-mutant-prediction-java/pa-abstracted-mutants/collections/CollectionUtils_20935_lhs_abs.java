public final int max ( final Object obj ) {
return Math . max ( freqA ( obj ) , freqB ( obj ) ) ;
}
public final int min ( final Object obj ) {
return Math . min ( freqA ( obj ) , freqB ( obj ) ) ;
}
public int freqA ( final Object obj ) {
return getFreq ( obj , cardinalityA ) ;
}
public int freqB ( final Object obj ) {
return getFreq ( obj , cardinalityB ) ;
}
private int getFreq ( final Object obj , final Map < ? , Integer > freqMap ) {
final Integer count = freqMap . get ( obj ) ;
if ( count != null ) {
return count . intValue () ;
}
return 0 ;
}
@Override
public Iterator < O > iterator () {
return elements . iterator () ;
}
public void setCardinality ( final O obj , final int count ) {
for ( int i = 0 ; i < count ; i ++ ) {
newList . add ( obj ) ;
}
}
public Collection < O > list () {
return newList ;
}
@SuppressWarnings ( lr_1 )
public static < T > Collection < T > emptyCollection () {
return EMPTY_COLLECTION ;
}
public static < T > Collection < T > emptyIfNull ( final Collection < T > collection ) {
return collection == null ? CollectionUtils . <T > emptyCollection () : collection ;
}
public static < O > Collection < O > union ( final Iterable < ? extends O > a , final Iterable < ? extends O > b ) {
final SetOperationCardinalityHelper < O > helper = new SetOperationCardinalityHelper <> ( a , b ) ;
for ( final O obj : helper ) {
helper . setCardinality ( obj , helper . max ( obj ) ) ;
}
return helper . list () ;
}
public static < O > Collection < O > intersection ( final Iterable < ? extends O > a , final Iterable < ? extends O > b ) {
final SetOperationCardinalityHelper < O > helper = new SetOperationCardinalityHelper <> ( a , b ) ;
for ( final O obj : helper ) {
helper . setCardinality ( obj , helper . min ( obj ) ) ;
}
return helper . list () ;
}
public static < O > Collection < O > disjunction ( final Iterable < ? extends O > a , final Iterable < ? extends O > b ) {
final SetOperationCardinalityHelper < O > helper = new SetOperationCardinalityHelper <> ( a , b ) ;
for ( final O obj : helper ) {
helper . setCardinality ( obj , helper . max ( obj ) - helper . min ( obj ) ) ;
}
return helper . list () ;
}
public static < O > Collection < O > subtract ( final Iterable < ? extends O > a , final Iterable < ? extends O > b ) {
final Predicate < O > p = TruePredicate . truePredicate () ;
return subtract ( a , b , p ) ;
}
public static < O > Collection < O > subtract ( final Iterable < ? extends O > a ,
final Iterable < ? extends O > b ,
final Predicate < O > p ) {
final ArrayList < O > list = new ArrayList <> () ;
final HashBag < O > bag = new HashBag <> () ;
for ( final O element : b ) {
if ( p . evaluate ( element ) ) {
bag . add ( element ) ;
}
}
for ( final O element : a ) {
if ( ! bag . remove ( element , 1 ) ) {
list . add ( element ) ;
}
}
return list ;
}
public static boolean containsAll ( final Collection < ? > coll1 , final Collection < ? > coll2 ) {
if ( coll2 . isEmpty () ) {
return true ;
}
final Iterator < ? > it = coll1 . iterator () ;
final Set < Object > elementsAlreadySeen = new HashSet <> () ;
for ( final Object nextElement : coll2 ) {
if ( elementsAlreadySeen . contains ( nextElement ) ) {
continue;
}
boolean foundCurrentElement = false ;
while ( it . hasNext () ) {
final Object p = it . next () ;
elementsAlreadySeen . add ( p ) ;
if ( nextElement == null ? p == null : nextElement . equals ( p ) ) {
foundCurrentElement = true ;
break;
}
}
if ( ! foundCurrentElement ) {
return false ;
}
}
return true ;
}
public static < T > boolean containsAny ( final Collection < ? > coll1 , @SuppressWarnings ( lr_1 ) final T ... coll2 ) {
if ( coll1 . size () < coll2 . length ) {
for ( final Object aColl1 : coll1 ) {
if ( ArrayUtils . contains ( coll2 , aColl1 ) ) {
return true ;
}
}
} else {
for ( final Object aColl2 : coll2 ) {
if ( coll1 . contains ( aColl2 ) ) {
return true ;
}
}
}
return false ;
}
public static boolean containsAny ( final Collection < ? > coll1 , final Collection < ? > coll2 ) {
if ( coll1 . size () < coll2 . size () ) {
for ( final Object aColl1 : coll1 ) {
if ( coll2 . contains ( aColl1 ) ) {
return true ;
}
}
} else {
for ( final Object aColl2 : coll2 ) {
if ( coll1 . contains ( aColl2 ) ) {
return true ;
}
}
}
return false ;
}
public static < O > Map < O , Integer > getCardinalityMap ( final Iterable < ? extends O > coll ) {
final Map < O , Integer > count = new HashMap <> () ;
for ( final O obj : coll ) {
final Integer c = count . get ( obj ) ;
if ( c == null ) {
count . put ( obj , Integer . valueOf ( 1 ) ) ;
} else {
count . put ( obj , Integer . valueOf ( c . intValue () + 1 ) ) ;
}
}
return count ;
}
public static boolean isSubCollection ( final Collection < ? > a , final Collection < ? > b ) {
final CardinalityHelper < Object > helper = new CardinalityHelper <> ( a , b ) ;
for ( final Object obj : a ) {
if ( helper . freqA ( obj ) > helper . freqB ( obj ) ) {
return false ;
}
}
return true ;
}
public static boolean isProperSubCollection ( final Collection < ? > a , final Collection < ? > b ) {
return a . size () < b . size () && CollectionUtils . isSubCollection ( a , b ) ;
}
public static boolean isEqualCollection ( final Collection < ? > a , final Collection < ? > b ) {
if ( a . size () != b . size () ) {
return false ;
}
final CardinalityHelper < Object > helper = new CardinalityHelper <> ( a , b ) ;
if ( helper . cardinalityA . size () != helper . cardinalityB . size () ) {
return false ;
}
for ( final Object obj : helper . cardinalityA . keySet () ) {
if ( helper . freqA ( obj ) != helper . freqB ( obj ) ) {
return false ;
}
}
return true ;
}
public static < E > boolean isEqualCollection ( final Collection < ? extends E > a ,
final Collection < ? extends E > b ,
final Equator < ? super E > equator ) {
Objects . requireNonNull ( equator , lr_2 ) ;
if ( a . size () != b . size () ) {
return false ;
}
@SuppressWarnings ( { lr_1 , lr_3 } )
final Transformer < E , ? > transformer = input -> new EquatorWrapper ( equator , input ) ;
return isEqualCollection ( collect ( a , transformer ) , collect ( b , transformer ) ) ;
}
public O getObject () {
return object ;
}
@Override
public boolean equals ( final Object obj ) {
if ( ! ( obj instanceof EquatorWrapper ) ) {
return false ;
}
@SuppressWarnings ( lr_1 )
final EquatorWrapper < O > otherObj = ( EquatorWrapper < O > ) obj ;
return equator . equate ( object , otherObj . getObject () ) ;
}
@Override
public int hashCode () {
return equator . hash ( object ) ;
}
@Deprecated
public static < O > int cardinality ( final O obj , final Iterable < ? super O > collection ) {
return IterableUtils . frequency ( Objects . requireNonNull ( collection , lr_4 ) , obj ) ;
}
@Deprecated
public static < T > T find ( final Iterable < T > collection , final Predicate < ? super T > predicate ) {
return predicate != null ? IterableUtils . find ( collection , predicate ) : null ;
}
@Deprecated
public static < T , C extends Closure < ? super T > > C forAllDo ( final Iterable < T > collection , final C closure ) {
if ( closure != null ) {
IterableUtils . forEach ( collection , closure ) ;
}
return closure ;
}
@Deprecated
public static < T , C extends Closure < ? super T > > C forAllDo ( final Iterator < T > iterator , final C closure ) {
if ( closure != null ) {
IteratorUtils . forEach ( iterator , closure ) ;
}
return closure ;
}
@Deprecated
public static < T , C extends Closure < ? super T > > T forAllButLastDo ( final Iterable < T > collection ,
final C closure ) {
return closure != null ? IterableUtils . forEachButLast ( collection , closure ) : null ;
}
@Deprecated
public static < T , C extends Closure < ? super T > > T forAllButLastDo ( final Iterator < T > iterator , final C closure ) {
return closure != null ? IteratorUtils . forEachButLast ( iterator , closure ) : null ;
}
public static < T > boolean filter ( final Iterable < T > collection , final Predicate < ? super T > predicate ) {
boolean result = false ;
if ( collection != null && predicate != null ) {
for ( final Iterator < T > it = collection . iterator () ; it . hasNext () ; ) {
if ( ! predicate . evaluate ( it . next () ) ) {
it . remove () ;
result = true ;
}
}
}
return result ;
}
public static < T > boolean filterInverse ( final Iterable < T > collection , final Predicate < ? super T > predicate ) {
return filter ( collection , predicate == null ? null : PredicateUtils . notPredicate ( predicate ) ) ;
}
public static < C > void transform ( final Collection < C > collection ,
final Transformer < ? super C , ? extends C > transformer ) {
if ( collection != null && transformer != null ) {
if ( collection instanceof List < ? > ) {
final List < C > list = ( List < C > ) collection ;
for ( final ListIterator < C > it = list . listIterator () ; it . hasNext () ; ) {
it . set ( transformer . transform ( it . next () ) ) ;
}
} else {
final Collection < C > resultCollection = collect ( collection , transformer ) ;
collection . clear () ;
collection . addAll ( resultCollection ) ;
}
}
@Deprecated
public static < C > int countMatches ( final Iterable < C > input , final Predicate < ? super C > predicate ) {
return predicate == null ? 0 : ( int ) IterableUtils . countMatches ( input , predicate ) ;
}
@Deprecated
public static < C > boolean exists ( final Iterable < C > input , final Predicate < ? super C > predicate ) {
return predicate != null && IterableUtils . matchesAny ( input , predicate ) ;
}
@Deprecated
public static < C > boolean matchesAll ( final Iterable < C > input , final Predicate < ? super C > predicate ) {
return predicate != null && IterableUtils . matchesAll ( input , predicate ) ;
}
public static < O > Collection < O > select ( final Iterable < ? extends O > inputCollection ,
final Predicate < ? super O > predicate ) {
final Collection < O > answer = inputCollection instanceof Collection < ? > ?
new ArrayList <> ( ( ( Collection < ? > ) inputCollection ) . size () ) : new ArrayList <> () ;
return select ( inputCollection , predicate , answer ) ;
}
public static < O , R extends Collection < ? super O > > R select ( final Iterable < ? extends O > inputCollection ,
final Predicate < ? super O > predicate , final R outputCollection ) {
if ( inputCollection != null && predicate != null ) {
for ( final O item : inputCollection ) {
if ( predicate . evaluate ( item ) ) {
outputCollection . add ( item ) ;
}
}
}
return outputCollection ;
}
public static < O , R extends Collection < ? super O > > R select ( final Iterable < ? extends O > inputCollection ,
final Predicate < ? super O > predicate , final R outputCollection , final R rejectedCollection ) {
if ( inputCollection != null && predicate != null ) {
for ( final O element : inputCollection ) {
if ( predicate . evaluate ( element ) ) {
outputCollection . add ( element ) ;
} else {
rejectedCollection . add ( element ) ;
}
}
}
return outputCollection ;
}
public static < O > Collection < O > selectRejected ( final Iterable < ? extends O > inputCollection ,
final Predicate < ? super O > predicate ) {
final Collection < O > answer = inputCollection instanceof Collection < ? > ?
new ArrayList <> ( ( ( Collection < ? > ) inputCollection ) . size () ) : new ArrayList <> () ;
return selectRejected ( inputCollection , predicate , answer ) ;
}
public static < O , R extends Collection < ? super O > > R selectRejected ( final Iterable < ? extends O > inputCollection ,
final Predicate < ? super O > predicate , final R outputCollection ) {
if ( inputCollection != null && predicate != null ) {
for ( final O item : inputCollection ) {
if ( ! predicate . evaluate ( item ) ) {
outputCollection . add ( item ) ;
}
}
}
return outputCollection ;
}
public static < I , O > Collection < O > collect ( final Iterable < I > inputCollection ,
final Transformer < ? super I , ? extends O > transformer ) {
final Collection < O > answer = inputCollection instanceof Collection < ? > ?
new ArrayList <> ( ( ( Collection < ? > ) inputCollection ) . size () ) : new ArrayList <> () ;
return collect ( inputCollection , transformer , answer ) ;
}
public static < I , O > Collection < O > collect ( final Iterator < I > inputIterator ,
final Transformer < ? super I , ? extends O > transformer ) {
return collect ( inputIterator , transformer , new ArrayList < O > () ) ;
}
public static < I , O , R extends Collection < ? super O > > R collect ( final Iterable < ? extends I > inputCollection ,
final Transformer < ? super I , ? extends O > transformer , final R outputCollection ) {
if ( inputCollection != null ) {
return collect ( inputCollection . iterator () , transformer , outputCollection ) ;
}
return outputCollection ;
}
public static < I , O , R extends Collection < ? super O > > R collect ( final Iterator < ? extends I > inputIterator ,
final Transformer < ? super I , ? extends O > transformer , final R outputCollection ) {
if ( inputIterator != null && transformer != null ) {
while ( inputIterator . hasNext () ) {
final I item = inputIterator . next () ;
final O value = transformer . transform ( item ) ;
outputCollection . add ( value ) ;
}
}
return outputCollection ;
}
public static < T > boolean addIgnoreNull ( final Collection < T > collection , final T object ) {
Objects . requireNonNull ( collection , lr_4 ) ;
return object != null && collection . add ( object ) ;
}
public static < C > boolean addAll ( final Collection < C > collection , final Iterable < ? extends C > iterable ) {
if ( iterable instanceof Collection < ? > ) {
return collection . addAll ( ( Collection < ? extends C > ) iterable ) ;
}
return addAll ( collection , iterable . iterator () ) ;
}
public static < C > boolean addAll ( final Collection < C > collection , final Iterator < ? extends C > iterator ) {
boolean changed = false ;
while ( iterator . hasNext () ) {
changed |= collection . add ( iterator . next () ) ;
}
return changed ; MST[rv.UOI1Mutator]MSP[]
}
public static < C > boolean addAll ( final Collection < C > collection , final Enumeration < ? extends C > enumeration ) {
boolean changed = false ;
while ( enumeration . hasMoreElements () ) {
changed |= collection . add ( enumeration . nextElement () ) ;
}
return changed ;
}
public static < C > boolean addAll ( final Collection < C > collection , final C ... elements ) {
boolean changed = false ;
for ( final C element : elements ) {
changed |= collection . add ( element ) ;
}
return changed ;
}
@Deprecated
public static < T > T get ( final Iterator < T > iterator , final int index ) {
return IteratorUtils . get ( iterator , index ) ;
}
static void checkIndexBounds ( final int index ) {
if ( index < 0 ) {
throw new IndexOutOfBoundsException ( lr_5 + index ) ;
}
}
@Deprecated
public static < T > T get ( final Iterable < T > iterable , final int index ) {
return IterableUtils . get ( iterable , index ) ;
}
public static Object get ( final Object object , final int index ) {
final int i = index ;
if ( i < 0 ) {
throw new IndexOutOfBoundsException ( lr_5 + i ) ;
}
if ( object instanceof Map < ? , ? > ) {
final Map < ? , ? > map = ( Map < ? , ? > ) object ;
final Iterator < ? > iterator = map . entrySet () . iterator () ;
return IteratorUtils . get ( iterator , i ) ;
} else if ( object instanceof Object [] ) {
return ( ( Object [] ) object ) [ i ] ;
} else if ( object instanceof Iterator < ? > ) {
final Iterator < ? > it = ( Iterator < ? > ) object ;
return IteratorUtils . get ( it , i ) ;
} else if ( object instanceof Iterable < ? > ) {
final Iterable < ? > iterable = ( Iterable < ? > ) object ;
return IterableUtils . get ( iterable , i ) ;
} else if ( object instanceof Enumeration < ? > ) {
final Enumeration < ? > it = ( Enumeration < ? > ) object ;
return EnumerationUtils . get ( it , i ) ;
} else if ( object == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
} else {
try {
return Array . get ( object , i ) ;
} catch ( final IllegalArgumentException ex ) {
throw new IllegalArgumentException ( lr_7 + object . getClass () . getName () ) ;
}
}
}
public static < K , V > Map . Entry < K , V > get ( final Map < K , V > map , final int index ) {
checkIndexBounds ( index ) ;
return get ( map . entrySet () , index ) ;
}
public static int size ( final Object object ) {
if ( object == null ) {
return 0 ;
}
int total = 0 ;
if ( object instanceof Map < ? , ? > ) {
total = ( ( Map < ? , ? > ) object ) . size () ;
} else if ( object instanceof Collection < ? > ) {
total = ( ( Collection < ? > ) object ) . size () ;
} else if ( object instanceof Iterable < ? > ) {
total = IterableUtils . size ( ( Iterable < ? > ) object ) ;
} else if ( object instanceof Object [] ) {
total = ( ( Object [] ) object ) . length ;
} else if ( object instanceof Iterator < ? > ) {
total = IteratorUtils . size ( ( Iterator < ? > ) object ) ;
} else if ( object instanceof Enumeration < ? > ) {
final Enumeration < ? > it = ( Enumeration < ? > ) object ;
while ( it . hasMoreElements () ) {
total ++ ;
it . nextElement () ;
}
}
static boolean sizeIsEmpty ( final Object object ) {
if ( object == null ) {
return true ;
} else if ( object instanceof Collection < ? > ) {
return ( ( Collection < ? > ) object ) . isEmpty () ;
} else if ( object instanceof Iterable < ? > ) {
return IterableUtils . isEmpty ( ( Iterable < ? > ) object ) ;
} else if ( object instanceof Map < ? , ? > ) {
return ( ( Map < ? , ? > ) object ) . isEmpty () ;
} else if ( object instanceof Object [] ) {
return ( ( Object [] ) object ) . length == 0 ;
} else if ( object instanceof Iterator < ? > ) {
return ( ( Iterator < ? > ) object ) . hasNext () == false ;
} else if ( object instanceof Enumeration < ? > ) {
return ( ( Enumeration < ? > ) object ) . hasMoreElements () == false ;
} else {
try {
return Array . getLength ( object ) == 0 ;
} catch ( final IllegalArgumentException ex ) {
throw new IllegalArgumentException ( lr_7 + object . getClass () . getName () ) ;
}
}
}
public static boolean isEmpty ( final Collection < ? > coll ) {
return coll == null || coll . isEmpty () ;
}
public static boolean isNotEmpty ( final Collection < ? > coll ) {
return ! isEmpty ( coll ) ;
}
public static void reverseArray ( final Object [] array ) {
int i = 0 ;
int j = array . length - 1 ;
Object tmp ;
while ( j > i ) {
tmp = array [ j ] ;
array [ j ] = array [ i ] ;
array [ i ] = tmp ;
j -- ;
i ++ ;
}
}
public static boolean isFull ( final Collection < ? extends Object > collection ) {
Objects . requireNonNull ( collection , lr_4 ) ;
if ( collection instanceof BoundedCollection ) {
return ( ( BoundedCollection < ? > ) collection ) . isFull () ;
}
try {
final BoundedCollection < ? > bcoll =
UnmodifiableBoundedCollection . unmodifiableBoundedCollection ( collection ) ;
return bcoll . isFull () ;
} catch ( final IllegalArgumentException ex ) {
return false ;
}
}
public static int maxSize ( final Collection < ? extends Object > collection ) {
Objects . requireNonNull ( collection , lr_4 ) ;
if ( collection instanceof BoundedCollection ) {
return ( ( BoundedCollection < ? > ) collection ) . maxSize () ;
}
try {
final BoundedCollection < ? > bcoll =
UnmodifiableBoundedCollection . unmodifiableBoundedCollection ( collection ) ;
return bcoll . maxSize () ;
} catch ( final IllegalArgumentException ex ) {
return - 1 ;
}
}
public static < O extends Comparable < ? super O > > List < O > collate ( final Iterable < ? extends O > a ,
final Iterable < ? extends O > b ) {
return collate ( a , b , ComparatorUtils . <O > naturalComparator () , true ) ;
}
public static < O extends Comparable < ? super O > > List < O > collate ( final Iterable < ? extends O > a ,
final Iterable < ? extends O > b ,
final boolean includeDuplicates ) {
return collate ( a , b , ComparatorUtils . <O > naturalComparator () , includeDuplicates ) ;
}
public static < O > List < O > collate ( final Iterable < ? extends O > a , final Iterable < ? extends O > b ,
final Comparator < ? super O > c ) {
return collate ( a , b , c , true ) ;
}
public static < O > List < O > collate ( final Iterable < ? extends O > iterableA , final Iterable < ? extends O > iterableB ,
final Comparator < ? super O > comparator , final boolean includeDuplicates ) {
Objects . requireNonNull ( iterableA , lr_8 ) ;
Objects . requireNonNull ( iterableB , lr_9 ) ;
Objects . requireNonNull ( comparator , lr_10 ) ;
final int totalSize = iterableA instanceof Collection < ? > && iterableB instanceof Collection < ? > ?
Math . max ( 1 , ( ( Collection < ? > ) iterableA ) . size () + ( ( Collection < ? > ) iterableB ) . size () ) : 10 ;
final Iterator < O > iterator = new CollatingIterator <> ( comparator , iterableA . iterator () , iterableB . iterator () ) ;
if ( includeDuplicates ) {
return IteratorUtils . toList ( iterator , totalSize ) ;
}
final ArrayList < O > mergedList = new ArrayList <> ( totalSize ) ;
O lastItem = null ;
while ( iterator . hasNext () ) {
final O item = iterator . next () ;
if ( lastItem == null || ! lastItem . equals ( item ) ) {
mergedList . add ( item ) ;
}
lastItem = item ;
}
mergedList . trimToSize () ;
return mergedList ;
}
public static < E > Collection < List < E > > permutations ( final Collection < E > collection ) {
final PermutationIterator < E > it = new PermutationIterator <> ( collection ) ;
final Collection < List < E > > result = new ArrayList <> () ;
while ( it . hasNext () ) {
result . add ( it . next () ) ;
}
return result ;
}
public static < C > Collection < C > retainAll ( final Collection < C > collection , final Collection < ? > retain ) {
return ListUtils . retainAll ( collection , retain ) ;
}
public static < E > Collection < E > retainAll ( final Iterable < E > collection ,
final Iterable < ? extends E > retain ,
final Equator < ? super E > equator ) {
final Transformer < E , EquatorWrapper < E > > transformer = input -> new EquatorWrapper <> ( equator , input ) ;
final Set < EquatorWrapper < E > > retainSet =
collect ( retain , transformer , new HashSet < EquatorWrapper < E > > () ) ;
final List < E > list = new ArrayList <> () ;
for ( final E element : collection ) {
if ( retainSet . contains ( new EquatorWrapper <> ( equator , element ) ) ) {
list . add ( element ) ;
}
}
return list ;
}
public static < E > Collection < E > removeRange ( final Collection < E > input , final int startIndex , final int endIndex ) {
if ( null == input ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( endIndex < startIndex ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
if ( input . size () < endIndex ) {
throw new IndexOutOfBoundsException ( lr_13 ) ;
}
return CollectionUtils . removeCount ( input , startIndex , endIndex - startIndex ) ;
}
public static < E > Collection < E > removeCount ( final Collection < E > input , int startIndex , int count ) {
if ( null == input ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( startIndex < 0 ) {
throw new IndexOutOfBoundsException ( lr_14 ) ;
}
if ( count < 0 ) {
throw new IndexOutOfBoundsException ( lr_15 ) ;
}
if ( input . size () < startIndex + count ) {
throw new IndexOutOfBoundsException (
lr_16 ) ;
}
final Collection < E > result = new ArrayList <> ( count ) ;
final Iterator < E > iterator = input . iterator () ;
while ( count > 0 ) {
if ( startIndex > 0 ) {
startIndex = startIndex - 1 ;
iterator . next () ;
continue;
}
count = count - 1 ;
result . add ( iterator . next () ) ;
iterator . remove () ;
}
return result ;
}
public static < E > Collection < E > removeAll ( final Collection < E > collection , final Collection < ? > remove ) {
return ListUtils . removeAll ( collection , remove ) ;
}
public static < E > Collection < E > removeAll ( final Iterable < E > collection ,
final Iterable < ? extends E > remove ,
final Equator < ? super E > equator ) {
final Transformer < E , EquatorWrapper < E > > transformer = input -> new EquatorWrapper <> ( equator , input ) ;
final Set < EquatorWrapper < E > > removeSet =
collect ( remove , transformer , new HashSet < EquatorWrapper < E > > () ) ;
final List < E > list = new ArrayList <> () ;
for ( final E element : collection ) {
if ( ! removeSet . contains ( new EquatorWrapper <> ( equator , element ) ) ) {
list . add ( element ) ;
}
}
return list ;
}
@Deprecated
public static < C > Collection < C > synchronizedCollection ( final Collection < C > collection ) {
return SynchronizedCollection . synchronizedCollection ( collection ) ;
}
@Deprecated
public static < C > Collection < C > unmodifiableCollection ( final Collection < ? extends C > collection ) {
return UnmodifiableCollection . unmodifiableCollection ( collection ) ;
}
public static < C > Collection < C > predicatedCollection ( final Collection < C > collection ,
final Predicate < ? super C > predicate ) {
return PredicatedCollection . predicatedCollection ( collection , predicate ) ;
}
public static < E > Collection < E > transformingCollection ( final Collection < E > collection ,
final Transformer < ? super E , ? extends E > transformer ) {
return TransformedCollection . transformingCollection ( collection , transformer ) ;
}
public static < E > E extractSingleton ( final Collection < E > collection ) {
Objects . requireNonNull ( collection , lr_4 ) ;
if ( collection . size () != 1 ) {
throw new IllegalArgumentException ( lr_17 ) ;
}
return collection . iterator () . next () ;
}
