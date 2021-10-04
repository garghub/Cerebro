public static < E > ListOrderedSet < E > listOrderedSet ( final Set < E > set , final List < E > list ) {
Objects . requireNonNull ( set , lr_1 ) ;
Objects . requireNonNull ( list , lr_2 ) ;
if ( set . size () > 0 || list . size () > 0 ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new ListOrderedSet <> ( set , list ) ;
}
public static < E > ListOrderedSet < E > listOrderedSet ( final Set < E > set ) {
return new ListOrderedSet <> ( set ) ;
}
public static < E > ListOrderedSet < E > listOrderedSet ( final List < E > list ) {
Objects . requireNonNull ( list , lr_2 ) ;
CollectionUtils . filter ( list , UniquePredicate . uniquePredicate () ) ;
final Set < E > set = new HashSet <> ( list ) ;
return new ListOrderedSet <> ( set , list ) ;
}
public List < E > asList () {
return UnmodifiableList . unmodifiableList ( setOrder ) ;
}
@Override
public void clear () {
decorated () . clear () ;
setOrder . clear () ;
}
@Override
public OrderedIterator < E > iterator () {
return new OrderedSetIterator <> ( setOrder . listIterator () , decorated () ) ;
}
@Override
public boolean add ( final E object ) {
if ( decorated () . add ( object ) ) {
setOrder . add ( object ) ;
return true ;
}
return false ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
boolean result = false ;
for ( final E e : coll ) {
result |= add ( e ) ;
}
return result ;
}
@Override
public boolean remove ( final Object object ) {
final boolean result = decorated () . remove ( object ) ;
if ( result ) {
setOrder . remove ( object ) ;
}
return result ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
if ( Objects . isNull ( filter ) ) {
return false ;
}
final boolean result = decorated () . removeIf ( filter ) ;
if ( result ) {
setOrder . removeIf ( filter ) ;
}
return result ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
boolean result = false ;
for ( final Object name : coll ) {
result |= remove ( name ) ;
}
return result ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
final boolean result = decorated () . retainAll ( coll ) ;
if ( result == false ) {
return false ;
}
if ( decorated () . isEmpty () ) {
setOrder . clear () ;
} else {
setOrder . removeIf ( e -> ! decorated () . contains ( e ) ) ;
}
return result ;
}
@Override
public Object [] toArray () {
return setOrder . toArray () ;
}
@Override
public < T > T [] toArray ( final T a [] ) {
return setOrder . toArray ( a ) ;
}
public E get ( final int index ) {
return setOrder . get ( index ) ;
}
public int indexOf ( final Object object ) {
return setOrder . indexOf ( object ) ;
}
public void add ( final int index , final E object ) {
if ( ! contains ( object ) ) {
decorated () . add ( object ) ;
setOrder . add ( index , object ) ;
}
}
public boolean addAll ( final int index , final Collection < ? extends E > coll ) {
boolean changed = false ;
final List < E > toAdd = new ArrayList <> () ;
for ( final E e : coll ) {
if ( contains ( e ) ) { MST[rv.ROR4Mutator]MSP[]
continue;
}
decorated () . add ( e ) ;
toAdd . add ( e ) ;
changed = true ;
}
if ( changed ) {
setOrder . addAll ( index , toAdd ) ;
}
return changed ;
}
public E remove ( final int index ) {
final E obj = setOrder . remove ( index ) ;
remove ( obj ) ;
return obj ;
}
@Override
public String toString () {
return setOrder . toString () ;
}
@Override
public E next () {
last = getIterator () . next () ;
return last ;
}
@Override
public void remove () {
set . remove ( last ) ;
getIterator () . remove () ;
last = null ;
}
@Override
public boolean hasPrevious () {
return ( ( ListIterator < E > ) getIterator () ) . hasPrevious () ;
}
@Override
public E previous () {
last = ( ( ListIterator < E > ) getIterator () ) . previous () ;
return last ;
}
