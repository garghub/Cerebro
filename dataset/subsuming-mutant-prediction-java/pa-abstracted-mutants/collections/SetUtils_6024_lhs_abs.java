public < S extends Set < E > > void copyInto ( final S set ) {
CollectionUtils . addAll ( set , this ) ;
}
@Override
public Iterator < E > iterator () {
return IteratorUtils . unmodifiableIterator ( createIterator () ) ;
}
@Override
public int size () {
return IteratorUtils . size ( iterator () ) ;
}
public Set < E > toSet () {
final Set < E > set = new HashSet <> ( size () ) ;
copyInto ( set ) ;
return set ;
}
@Override
public boolean contains ( final Object o ) {
return setA . contains ( o ) && ! setB . contains ( o ) ;
}
@Override
public Iterator < E > createIterator () {
return IteratorUtils . filteredIterator ( setA . iterator () , notContainedInB ) ;
}
@Override
public boolean contains ( final Object o ) {
return setA . contains ( o ) ^ setB . contains ( o ) ;
}
@Override
public Iterator < E > createIterator () {
return IteratorUtils . chainedIterator ( aMinusB . iterator () , bMinusA . iterator () ) ;
}
@Override
public boolean isEmpty () {
return aMinusB . isEmpty () && bMinusA . isEmpty () ;
}
@Override
public int size () {
return aMinusB . size () + bMinusA . size () ;
}
public static < T > Set < T > emptyIfNull ( final Set < T > set ) {
return set == null ? Collections . <T > emptySet () : set ;
}
public static < E > Set < E > emptySet () {
return Collections . <E > emptySet () ;
}
@SuppressWarnings ( lr_1 )
public static < E > SortedSet < E > emptySortedSet () {
return EMPTY_SORTED_SET ;
}
public static < T > int hashCodeForSet ( final Collection < T > set ) {
if ( set == null ) {
return 0 ;
}
int hashCode = 0 ;
for ( final T obj : set ) {
if ( obj != null ) {
hashCode += obj . hashCode () ;
}
}
return hashCode ; MST[rv.UOI1Mutator]MSP[]
}
public static < E > HashSet < E > hashSet ( final E ... items ) {
if ( items == null ) {
return null ;
}
return new HashSet <> ( Arrays . asList ( items ) ) ;
}
@Override
public boolean contains ( final Object o ) {
return setA . contains ( o ) && setB . contains ( o ) ;
}
@Override
public Iterator < E > createIterator () {
return IteratorUtils . filteredIterator ( setA . iterator () , containedInB ) ;
}
public static boolean isEqualSet ( final Collection < ? > set1 , final Collection < ? > set2 ) {
if ( set1 == set2 ) {
return true ;
}
if ( set1 == null || set2 == null || set1 . size () != set2 . size () ) {
return false ;
}
return set1 . containsAll ( set2 ) ;
}
public static < E > Set < E > newIdentityHashSet () {
return Collections . newSetFromMap ( new IdentityHashMap < E , Boolean > () ) ;
}
public static < E > Set < E > orderedSet ( final Set < E > set ) {
return ListOrderedSet . listOrderedSet ( set ) ;
}
public static < E > SortedSet < E > predicatedNavigableSet ( final NavigableSet < E > set ,
final Predicate < ? super E > predicate ) {
return PredicatedNavigableSet . predicatedNavigableSet ( set , predicate ) ;
}
public static < E > Set < E > predicatedSet ( final Set < E > set , final Predicate < ? super E > predicate ) {
return PredicatedSet . predicatedSet ( set , predicate ) ;
}
public static < E > SortedSet < E > predicatedSortedSet ( final SortedSet < E > set ,
final Predicate < ? super E > predicate ) {
return PredicatedSortedSet . predicatedSortedSet ( set , predicate ) ;
}
public static < E > Set < E > synchronizedSet ( final Set < E > set ) {
return Collections . synchronizedSet ( set ) ;
}
public static < E > SortedSet < E > synchronizedSortedSet ( final SortedSet < E > set ) {
return Collections . synchronizedSortedSet ( set ) ;
}
public static < E > SortedSet < E > transformedNavigableSet ( final NavigableSet < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
return TransformedNavigableSet . transformingNavigableSet ( set , transformer ) ;
}
public static < E > Set < E > transformedSet ( final Set < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
return TransformedSet . transformingSet ( set , transformer ) ;
}
public static < E > SortedSet < E > transformedSortedSet ( final SortedSet < E > set ,
final Transformer < ? super E , ? extends E > transformer ) {
return TransformedSortedSet . transformingSortedSet ( set , transformer ) ;
}
@Override
public boolean contains ( final Object o ) {
return setA . contains ( o ) || setB . contains ( o ) ;
}
@Override
public Iterator < E > createIterator () {
return IteratorUtils . chainedIterator ( setA . iterator () , bMinusA . iterator () ) ;
}
@Override
public boolean isEmpty () {
return setA . isEmpty () && setB . isEmpty () ;
}
@Override
public int size () {
return setA . size () + bMinusA . size () ;
}
public static < E > SortedSet < E > unmodifiableNavigableSet ( final NavigableSet < E > set ) {
return UnmodifiableNavigableSet . unmodifiableNavigableSet ( set ) ;
}
public static < E > Set < E > unmodifiableSet ( final E ... items ) {
if ( items == null ) {
return null ;
}
return UnmodifiableSet . unmodifiableSet ( hashSet ( items ) ) ;
}
public static < E > Set < E > unmodifiableSet ( final Set < ? extends E > set ) {
return UnmodifiableSet . unmodifiableSet ( set ) ;
}
public static < E > SortedSet < E > unmodifiableSortedSet ( final SortedSet < E > set ) {
return UnmodifiableSortedSet . unmodifiableSortedSet ( set ) ;
}
