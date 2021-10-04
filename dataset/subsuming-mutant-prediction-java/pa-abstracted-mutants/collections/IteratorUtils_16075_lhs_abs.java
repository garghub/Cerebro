public static < E > ResettableIterator < E > emptyIterator () {
return EmptyIterator . <E > resettableEmptyIterator () ;
}
public static < E > ResettableListIterator < E > emptyListIterator () {
return EmptyListIterator . <E > resettableEmptyListIterator () ;
}
public static < E > OrderedIterator < E > emptyOrderedIterator () {
return EmptyOrderedIterator . <E > emptyOrderedIterator () ;
}
public static < K , V > MapIterator < K , V > emptyMapIterator () {
return EmptyMapIterator . <K , V > emptyMapIterator () ;
}
public static < K , V > OrderedMapIterator < K , V > emptyOrderedMapIterator () {
return EmptyOrderedMapIterator . <K , V > emptyOrderedMapIterator () ;
}
public static < E > ResettableIterator < E > singletonIterator ( final E object ) {
return new SingletonIterator <> ( object ) ;
}
public static < E > ListIterator < E > singletonListIterator ( final E object ) {
return new SingletonListIterator <> ( object ) ;
}
public static < E > ResettableIterator < E > arrayIterator ( final E ... array ) {
return new ObjectArrayIterator <> ( array ) ;
}
public static < E > ResettableIterator < E > arrayIterator ( final Object array ) {
return new ArrayIterator <> ( array ) ;
}
public static < E > ResettableIterator < E > arrayIterator ( final E [] array , final int start ) {
return new ObjectArrayIterator <> ( array , start ) ;
}
public static < E > ResettableIterator < E > arrayIterator ( final Object array , final int start ) {
return new ArrayIterator <> ( array , start ) ;
}
public static < E > ResettableIterator < E > arrayIterator ( final E [] array , final int start , final int end ) {
return new ObjectArrayIterator <> ( array , start , end ) ;
}
public static < E > ResettableIterator < E > arrayIterator ( final Object array , final int start , final int end ) {
return new ArrayIterator <> ( array , start , end ) ;
}
public static < E > ResettableListIterator < E > arrayListIterator ( final E ... array ) {
return new ObjectArrayListIterator <> ( array ) ;
}
public static < E > ResettableListIterator < E > arrayListIterator ( final Object array ) {
return new ArrayListIterator <> ( array ) ;
}
public static < E > ResettableListIterator < E > arrayListIterator ( final E [] array , final int start ) {
return new ObjectArrayListIterator <> ( array , start ) ;
}
public static < E > ResettableListIterator < E > arrayListIterator ( final Object array , final int start ) {
return new ArrayListIterator <> ( array , start ) ;
}
public static < E > ResettableListIterator < E > arrayListIterator ( final E [] array , final int start , final int end ) {
return new ObjectArrayListIterator <> ( array , start , end ) ;
}
public static < E > ResettableListIterator < E > arrayListIterator ( final Object array , final int start , final int end ) {
return new ArrayListIterator <> ( array , start , end ) ;
}
public static < E > BoundedIterator < E > boundedIterator ( final Iterator < ? extends E > iterator , final long max ) {
return boundedIterator ( iterator , 0 , max ) ;
}
public static < E > BoundedIterator < E > boundedIterator ( final Iterator < ? extends E > iterator ,
final long offset , final long max ) {
return new BoundedIterator <> ( iterator , offset , max ) ;
}
public static < E > Iterator < E > unmodifiableIterator ( final Iterator < E > iterator ) {
return UnmodifiableIterator . unmodifiableIterator ( iterator ) ;
}
public static < E > ListIterator < E > unmodifiableListIterator ( final ListIterator < E > listIterator ) {
return UnmodifiableListIterator . umodifiableListIterator ( listIterator ) ;
}
public static < K , V > MapIterator < K , V > unmodifiableMapIterator ( final MapIterator < K , V > mapIterator ) {
return UnmodifiableMapIterator . unmodifiableMapIterator ( mapIterator ) ;
}
public static < E > Iterator < E > chainedIterator ( final Iterator < ? extends E > iterator1 ,
final Iterator < ? extends E > iterator2 ) {
return new IteratorChain <> ( iterator1 , iterator2 ) ;
}
public static < E > Iterator < E > chainedIterator ( final Iterator < ? extends E > ... iterators ) {
return new IteratorChain <> ( iterators ) ; MST[ConstructorCallMutator]MSP[]
}
public static < E > Iterator < E > chainedIterator ( final Collection < Iterator < ? extends E > > iterators ) {
return new IteratorChain <> ( iterators ) ;
}
public static < E > Iterator < E > collatedIterator ( final Comparator < ? super E > comparator ,
final Iterator < ? extends E > iterator1 ,
final Iterator < ? extends E > iterator2 ) {
@SuppressWarnings ( lr_1 )
final Comparator < E > comp =
comparator == null ? ComparatorUtils . NATURAL_COMPARATOR : ( Comparator < E > ) comparator ;
return new CollatingIterator <> ( comp , iterator1 , iterator2 ) ;
}
public static < E > Iterator < E > collatedIterator ( final Comparator < ? super E > comparator ,
final Iterator < ? extends E > ... iterators ) {
@SuppressWarnings ( lr_1 )
final Comparator < E > comp =
comparator == null ? ComparatorUtils . NATURAL_COMPARATOR : ( Comparator < E > ) comparator ;
return new CollatingIterator <> ( comp , iterators ) ;
}
public static < E > Iterator < E > collatedIterator ( final Comparator < ? super E > comparator ,
final Collection < Iterator < ? extends E > > iterators ) {
@SuppressWarnings ( lr_1 )
final Comparator < E > comp =
comparator == null ? ComparatorUtils . NATURAL_COMPARATOR : ( Comparator < E > ) comparator ;
return new CollatingIterator <> ( comp , iterators ) ;
}
public static < E > Iterator < E > objectGraphIterator ( final E root ,
final Transformer < ? super E , ? extends E > transformer ) {
return new ObjectGraphIterator <> ( root , transformer ) ;
}
public static < I , O > Iterator < O > transformedIterator ( final Iterator < ? extends I > iterator ,
final Transformer < ? super I , ? extends O > transformer ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
Objects . requireNonNull ( transformer , lr_3 ) ;
return new TransformIterator <> ( iterator , transformer ) ;
}
public static < E > Iterator < E > filteredIterator ( final Iterator < ? extends E > iterator ,
final Predicate < ? super E > predicate ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
Objects . requireNonNull ( predicate , lr_4 ) ;
return new FilterIterator <> ( iterator , predicate ) ;
}
public static < E > ListIterator < E > filteredListIterator ( final ListIterator < ? extends E > listIterator ,
final Predicate < ? super E > predicate ) {
Objects . requireNonNull ( listIterator , lr_5 ) ;
Objects . requireNonNull ( predicate , lr_4 ) ;
return new FilterListIterator <> ( listIterator , predicate ) ;
}
public static < E > ResettableIterator < E > loopingIterator ( final Collection < ? extends E > collection ) {
return new LoopingIterator <> ( Objects . requireNonNull ( collection , lr_6 ) ) ;
}
public static < E > ResettableListIterator < E > loopingListIterator ( final List < E > list ) {
return new LoopingListIterator <> ( Objects . requireNonNull ( list , lr_7 ) ) ;
}
public static NodeListIterator nodeListIterator ( final NodeList nodeList ) {
return new NodeListIterator ( Objects . requireNonNull ( nodeList , lr_8 ) ) ;
}
public static NodeListIterator nodeListIterator ( final Node node ) {
return new NodeListIterator ( Objects . requireNonNull ( node , lr_9 ) ) ;
}
public static < E > Iterator < E > peekingIterator ( final Iterator < ? extends E > iterator ) {
return PeekingIterator . peekingIterator ( iterator ) ;
}
public static < E > Iterator < E > pushbackIterator ( final Iterator < ? extends E > iterator ) {
return PushbackIterator . pushbackIterator ( iterator ) ;
}
public static < E > SkippingIterator < E > skippingIterator ( final Iterator < E > iterator , final long offset ) {
return new SkippingIterator <> ( iterator , offset ) ;
}
public static < E > ZippingIterator < E > zippingIterator ( final Iterator < ? extends E > a ,
final Iterator < ? extends E > b ) {
return new ZippingIterator <> ( a , b ) ;
}
public static < E > ZippingIterator < E > zippingIterator ( final Iterator < ? extends E > a ,
final Iterator < ? extends E > b ,
final Iterator < ? extends E > c ) {
return new ZippingIterator <> ( a , b , c ) ;
}
public static < E > ZippingIterator < E > zippingIterator ( final Iterator < ? extends E > ... iterators ) {
return new ZippingIterator <> ( iterators ) ;
}
public static < E > Iterator < E > asIterator ( final Enumeration < ? extends E > enumeration ) {
return new EnumerationIterator <> ( Objects . requireNonNull ( enumeration , lr_10 ) ) ;
}
public static < E > Iterator < E > asIterator ( final Enumeration < ? extends E > enumeration ,
final Collection < ? super E > removeCollection ) {
return new EnumerationIterator <> ( Objects . requireNonNull ( enumeration , lr_10 ) ,
Objects . requireNonNull ( removeCollection , lr_11 ) ) ;
}
public static < E > Enumeration < E > asEnumeration ( final Iterator < ? extends E > iterator ) {
return new IteratorEnumeration <> ( Objects . requireNonNull ( iterator , lr_2 ) ) ;
}
public static < E > Iterable < E > asIterable ( final Iterator < ? extends E > iterator ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
return new IteratorIterable <> ( iterator , false ) ;
}
public static < E > Iterable < E > asMultipleUseIterable ( final Iterator < ? extends E > iterator ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
return new IteratorIterable <> ( iterator , true ) ;
}
public static < E > ListIterator < E > toListIterator ( final Iterator < ? extends E > iterator ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
return new ListIteratorWrapper <> ( iterator ) ;
}
public static Object [] toArray ( final Iterator < ? > iterator ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
final List < ? > list = toList ( iterator , 100 ) ;
return list . toArray () ;
}
public static < E > E [] toArray ( final Iterator < ? extends E > iterator , final Class < E > arrayClass ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
Objects . requireNonNull ( arrayClass , lr_12 ) ;
final List < E > list = toList ( iterator , 100 ) ;
@SuppressWarnings ( lr_1 )
final E [] array = ( E [] ) Array . newInstance ( arrayClass , list . size () ) ;
return list . toArray ( array ) ;
}
public static < E > List < E > toList ( final Iterator < ? extends E > iterator ) {
return toList ( iterator , 10 ) ;
}
public static < E > List < E > toList ( final Iterator < ? extends E > iterator , final int estimatedSize ) {
Objects . requireNonNull ( iterator , lr_2 ) ;
if ( estimatedSize < 1 ) {
throw new IllegalArgumentException ( lr_13 ) ;
}
final List < E > list = new ArrayList <> ( estimatedSize ) ;
while ( iterator . hasNext () ) {
list . add ( iterator . next () ) ;
}
return list ;
}
public static Iterator < ? > getIterator ( final Object obj ) {
if ( obj == null ) {
return emptyIterator () ;
}
if ( obj instanceof Iterator ) {
return ( Iterator < ? > ) obj ;
}
if ( obj instanceof Iterable ) {
return ( ( Iterable < ? > ) obj ) . iterator () ;
}
if ( obj instanceof Object [] ) {
return new ObjectArrayIterator <> ( ( Object [] ) obj ) ;
}
if ( obj instanceof Enumeration ) {
return new EnumerationIterator <> ( ( Enumeration < ? > ) obj ) ;
}
if ( obj instanceof Map ) {
return ( ( Map < ? , ? > ) obj ) . values () . iterator () ;
}
if ( obj instanceof NodeList ) {
return new NodeListIterator ( ( NodeList ) obj ) ;
}
if ( obj instanceof Node ) {
return new NodeListIterator ( ( Node ) obj ) ;
}
if ( obj instanceof Dictionary ) {
return new EnumerationIterator <> ( ( ( Dictionary < ? , ? > ) obj ) . elements () ) ;
} else if ( obj . getClass () . isArray () ) {
return new ArrayIterator <> ( obj ) ;
}
try {
final Method method = obj . getClass () . getMethod ( lr_2 , ( Class [] ) null ) ;
if ( Iterator . class . isAssignableFrom ( method . getReturnType () ) ) {
final Iterator < ? > it = ( Iterator < ? > ) method . invoke ( obj , ( Object [] ) null ) ;
if ( it != null ) {
return it ;
}
}
} catch ( final RuntimeException e ) {
} catch ( final NoSuchMethodException e ) {
} catch ( final IllegalAccessException e ) {
} catch ( final InvocationTargetException e ) {
}
return singletonIterator ( obj ) ;
}
public static < E > void forEach ( final Iterator < E > iterator , final Closure < ? super E > closure ) {
Objects . requireNonNull ( closure , lr_14 ) ;
if ( iterator != null ) {
while ( iterator . hasNext () ) {
final E element = iterator . next () ;
closure . execute ( element ) ;
}
}
}
public static < E > E forEachButLast ( final Iterator < E > iterator , final Closure < ? super E > closure ) {
Objects . requireNonNull ( closure , lr_14 ) ;
if ( iterator != null ) {
while ( iterator . hasNext () ) {
final E element = iterator . next () ;
if ( iterator . hasNext () ) {
closure . execute ( element ) ;
} else {
return element ;
}
}
}
return null ;
}
public static < E > E find ( final Iterator < E > iterator , final Predicate < ? super E > predicate ) {
Objects . requireNonNull ( predicate , lr_4 ) ;
if ( iterator != null ) {
while ( iterator . hasNext () ) {
final E element = iterator . next () ;
if ( predicate . evaluate ( element ) ) {
return element ;
}
}
}
return null ;
}
public static < E > int indexOf ( final Iterator < E > iterator , final Predicate < ? super E > predicate ) {
Objects . requireNonNull ( predicate , lr_4 ) ;
if ( iterator != null ) {
for ( int index = 0 ; iterator . hasNext () ; index ++ ) {
final E element = iterator . next () ;
if ( predicate . evaluate ( element ) ) {
return index ;
}
}
}
return - 1 ;
}
public static < E > boolean matchesAny ( final Iterator < E > iterator , final Predicate < ? super E > predicate ) {
return indexOf ( iterator , predicate ) != - 1 ;
}
public static < E > boolean matchesAll ( final Iterator < E > iterator , final Predicate < ? super E > predicate ) {
Objects . requireNonNull ( predicate , lr_4 ) ;
if ( iterator != null ) {
while ( iterator . hasNext () ) {
final E element = iterator . next () ;
if ( ! predicate . evaluate ( element ) ) {
return false ;
}
}
}
return true ;
}
public static boolean isEmpty ( final Iterator < ? > iterator ) {
return iterator == null || ! iterator . hasNext () ;
}
public static < E > boolean contains ( final Iterator < E > iterator , final Object object ) {
return matchesAny ( iterator , EqualPredicate . equalPredicate ( object ) ) ;
}
public static < E > E get ( final Iterator < E > iterator , final int index ) {
int i = index ;
CollectionUtils . checkIndexBounds ( i ) ;
while ( iterator . hasNext () ) {
i -- ;
if ( i == - 1 ) {
return iterator . next () ;
}
iterator . next () ;
}
throw new IndexOutOfBoundsException ( lr_15 + i ) ;
}
public static < E > E first ( final Iterator < E > iterator ) {
return get ( iterator , 0 ) ;
}
public static int size ( final Iterator < ? > iterator ) {
int size = 0 ;
if ( iterator != null ) {
while ( iterator . hasNext () ) {
iterator . next () ;
size ++ ;
}
}
return size ;
}
public static < E > String toString ( final Iterator < E > iterator ) {
return toString ( iterator , TransformerUtils . stringValueTransformer () ,
DEFAULT_TOSTRING_DELIMITER , DEFAULT_TOSTRING_PREFIX ,
DEFAULT_TOSTRING_SUFFIX ) ;
}
public static < E > String toString ( final Iterator < E > iterator ,
final Transformer < ? super E , String > transformer ) {
return toString ( iterator , transformer , DEFAULT_TOSTRING_DELIMITER ,
DEFAULT_TOSTRING_PREFIX , DEFAULT_TOSTRING_SUFFIX ) ;
}
public static < E > String toString ( final Iterator < E > iterator ,
final Transformer < ? super E , String > transformer ,
final String delimiter ,
final String prefix ,
final String suffix ) {
Objects . requireNonNull ( transformer , lr_3 ) ;
Objects . requireNonNull ( delimiter , lr_16 ) ;
Objects . requireNonNull ( prefix , lr_17 ) ;
Objects . requireNonNull ( suffix , lr_18 ) ;
final StringBuilder stringBuilder = new StringBuilder ( prefix ) ;
if ( iterator != null ) {
while ( iterator . hasNext () ) {
final E element = iterator . next () ;
stringBuilder . append ( transformer . transform ( element ) ) ;
stringBuilder . append ( delimiter ) ;
}
if ( stringBuilder . length () > prefix . length () ) {
stringBuilder . setLength ( stringBuilder . length () - delimiter . length () ) ;
}
}
stringBuilder . append ( suffix ) ;
return stringBuilder . toString () ;
}
