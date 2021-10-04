public static < E > SetUniqueList < E > setUniqueList ( final List < E > list ) {
Objects . requireNonNull ( list , lr_1 ) ;
if ( list . isEmpty () ) {
return new SetUniqueList <> ( list , new HashSet < E > () ) ;
}
final List < E > temp = new ArrayList <> ( list ) ;
list . clear () ;
final SetUniqueList < E > sl = new SetUniqueList <> ( list , new HashSet < E > () ) ;
sl . addAll ( temp ) ;
return sl ;
}
public Set < E > asSet () {
return UnmodifiableSet . unmodifiableSet ( set ) ;
}
@Override
public boolean add ( final E object ) {
final int sizeBefore = size () ;
add ( size () , object ) ;
return sizeBefore != size () ;
}
@Override
public void add ( final int index , final E object ) {
if ( set . contains ( object ) == false ) {
set . add ( object ) ;
super . add ( index , object ) ;
}
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
return addAll ( size () , coll ) ;
}
@Override
public boolean addAll ( final int index , final Collection < ? extends E > coll ) {
final List < E > temp = new ArrayList <> () ;
for ( final E e : coll ) {
if ( set . add ( e ) ) {
temp . add ( e ) ;
}
}
return super . addAll ( index , temp ) ;
}
@Override
public E set ( final int index , final E object ) {
final int pos = indexOf ( object ) ;
final E removed = super . set ( index , object ) ;
if ( pos != - 1 && pos != index ) {
super . remove ( pos ) ;
}
set . remove ( removed ) ;
set . add ( object ) ;
return removed ;
}
@Override
public boolean remove ( final Object object ) {
final boolean result = set . remove ( object ) ;
if ( result ) {
super . remove ( object ) ;
}
return result ;
}
@Override
public E remove ( final int index ) {
final E result = super . remove ( index ) ;
set . remove ( result ) ;
return result ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
final boolean result = super . removeIf ( filter ) ;
set . removeIf ( filter ) ;
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
final boolean result = set . retainAll ( coll ) ;
if ( result == false ) {
return false ;
}
if ( set . size () == 0 ) {
super . clear () ;
} else {
super . retainAll ( set ) ;
}
return result ;
}
@Override
public void clear () {
super . clear () ;
set . clear () ;
}
@Override
public boolean contains ( final Object object ) {
return set . contains ( object ) ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
return set . containsAll ( coll ) ;
}
@Override
public Iterator < E > iterator () {
return new SetListIterator <> ( super . iterator () , set ) ;
}
@Override
public ListIterator < E > listIterator () {
return new SetListListIterator <> ( super . listIterator () , set ) ;
}
@Override
public ListIterator < E > listIterator ( final int index ) {
return new SetListListIterator <> ( super . listIterator ( index ) , set ) ;
}
@Override
public List < E > subList ( final int fromIndex , final int toIndex ) {
final List < E > superSubList = super . subList ( fromIndex , toIndex ) ;
final Set < E > subSet = createSetBasedOnList ( set , superSubList ) ;
return ListUtils . unmodifiableList ( new SetUniqueList <> ( superSubList , subSet ) ) ;
}
protected Set < E > createSetBasedOnList ( final Set < E > set , final List < E > list ) {
Set < E > subSet ;
if ( set . getClass () . equals ( HashSet . class ) ) {
subSet = new HashSet <> ( list . size () ) ;
} else {
try {
subSet = set . getClass () . getDeclaredConstructor ( set . getClass () ) . newInstance ( set ) ;
} catch ( final InstantiationException
| IllegalAccessException
| InvocationTargetException
| NoSuchMethodException ie ) {
subSet = new HashSet <> () ;
}
}
return subSet ;
}
@Override
public E next () {
last = super . next () ;
return last ;
}
@Override
public void remove () {
super . remove () ;
set . remove ( last ) ;
last = null ;
}
@Override
public E next () {
last = super . next () ;
return last ;
}
@Override
public E previous () {
last = super . previous () ;
return last ;
}
@Override
public void remove () {
super . remove () ;
set . remove ( last ) ; MST[NonVoidMethodCallMutator]MSP[]
last = null ;
}
@Override
public void add ( final E object ) {
if ( set . contains ( object ) == false ) {
super . add ( object ) ;
set . add ( object ) ;
}
}
@Override
public void set ( final E object ) {
throw new UnsupportedOperationException ( lr_2 ) ;
}
