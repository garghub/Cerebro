public static < T > FluentIterable < T > empty () {
return IterableUtils . EMPTY_ITERABLE ;
}
public static < T > FluentIterable < T > of ( final T singleton ) {
return of ( IteratorUtils . asIterable ( new SingletonIterator <> ( singleton , false ) ) ) ;
}
public static < T > FluentIterable < T > of ( final T ... elements ) {
return of ( Arrays . asList ( elements ) ) ;
}
public static < T > FluentIterable < T > of ( final Iterable < T > iterable ) {
IterableUtils . checkNotNull ( iterable ) ;
if ( iterable instanceof FluentIterable < ? > ) {
return ( FluentIterable < T > ) iterable ;
}
return new FluentIterable <> ( iterable ) ;
}
public FluentIterable < E > append ( final E ... elements ) {
return append ( Arrays . asList ( elements ) ) ;
}
public FluentIterable < E > append ( final Iterable < ? extends E > other ) {
return of ( IterableUtils . chainedIterable ( iterable , other ) ) ;
}
public FluentIterable < E > collate ( final Iterable < ? extends E > other ) {
return of ( IterableUtils . collatedIterable ( iterable , other ) ) ;
}
public FluentIterable < E > collate ( final Iterable < ? extends E > other ,
final Comparator < ? super E > comparator ) {
return of ( IterableUtils . collatedIterable ( comparator , iterable , other ) ) ;
}
public FluentIterable < E > eval () {
return of ( toList () ) ;
}
public FluentIterable < E > filter ( final Predicate < ? super E > predicate ) {
return of ( IterableUtils . filteredIterable ( iterable , predicate ) ) ;
}
public FluentIterable < E > limit ( final long maxSize ) {
return of ( IterableUtils . boundedIterable ( iterable , maxSize ) ) ;
}
public FluentIterable < E > loop () {
return of ( IterableUtils . loopingIterable ( iterable ) ) ;
}
public FluentIterable < E > reverse () {
return of ( IterableUtils . reversedIterable ( iterable ) ) ;
}
public FluentIterable < E > skip ( final long elementsToSkip ) {
return of ( IterableUtils . skippingIterable ( iterable , elementsToSkip ) ) ; MST[ArgumentPropagationMutator]MSP[]
}
public < O > FluentIterable < O > transform ( final Transformer < ? super E , ? extends O > transformer ) {
return of ( IterableUtils . transformedIterable ( iterable , transformer ) ) ;
}
public FluentIterable < E > unique () {
return of ( IterableUtils . uniqueIterable ( iterable ) ) ;
}
public FluentIterable < E > unmodifiable () {
return of ( IterableUtils . unmodifiableIterable ( iterable ) ) ;
}
public FluentIterable < E > zip ( final Iterable < ? extends E > other ) {
return of ( IterableUtils . zippingIterable ( iterable , other ) ) ;
}
public FluentIterable < E > zip ( final Iterable < ? extends E > ... others ) {
return of ( IterableUtils . zippingIterable ( iterable , others ) ) ;
}
@Override
public Iterator < E > iterator () {
return iterable . iterator () ;
}
public Enumeration < E > asEnumeration () {
return IteratorUtils . asEnumeration ( iterator () ) ;
}
public boolean allMatch ( final Predicate < ? super E > predicate ) {
return IterableUtils . matchesAll ( iterable , predicate ) ;
}
public boolean anyMatch ( final Predicate < ? super E > predicate ) {
return IterableUtils . matchesAny ( iterable , predicate ) ;
}
public boolean isEmpty () {
return IterableUtils . isEmpty ( iterable ) ;
}
public boolean contains ( final Object object ) {
return IterableUtils . contains ( iterable , object ) ;
}
public void forEach ( final Closure < ? super E > closure ) {
IterableUtils . forEach ( iterable , closure ) ;
}
public E get ( final int position ) {
return IterableUtils . get ( iterable , position ) ;
}
public int size () {
return IterableUtils . size ( iterable ) ;
}
public void copyInto ( final Collection < ? super E > collection ) {
Objects . requireNonNull ( collection , lr_1 ) ;
CollectionUtils . addAll ( collection , iterable ) ;
}
public E [] toArray ( final Class < E > arrayClass ) {
return IteratorUtils . toArray ( iterator () , arrayClass ) ;
}
public List < E > toList () {
return IterableUtils . toList ( iterable ) ;
}
@Override
public String toString () {
return IterableUtils . toString ( iterable ) ;
}
