@Override
@SuppressWarnings ( lr_1 )
protected Map < K , List < V > > getMap () {
return ( Map < K , List < V > > ) super . getMap () ; MST[NonVoidMethodCallMutator]MSP[]
}
@Override
public List < V > get ( final K key ) {
return wrappedCollection ( key ) ;
}
@Override
List < V > wrappedCollection ( final K key ) {
return new WrappedList ( key ) ;
}
@Override
public List < V > remove ( final Object key ) {
return ListUtils . emptyIfNull ( getMap () . remove ( key ) ) ;
}
@Override
protected List < V > getMapping () {
return getMap () . get ( key ) ;
}
@Override
public void add ( final int index , final V value ) {
List < V > list = getMapping () ;
if ( list == null ) {
list = createCollection () ;
getMap () . put ( key , list ) ;
}
list . add ( index , value ) ;
}
@Override
public boolean addAll ( final int index , final Collection < ? extends V > c ) {
List < V > list = getMapping () ;
if ( list == null ) {
list = createCollection () ;
final boolean changed = list . addAll ( index , c ) ;
if ( changed ) {
getMap () . put ( key , list ) ;
}
return changed ;
}
return list . addAll ( index , c ) ;
}
@Override
public V get ( final int index ) {
final List < V > list = ListUtils . emptyIfNull ( getMapping () ) ;
return list . get ( index ) ;
}
@Override
public int indexOf ( final Object o ) {
final List < V > list = ListUtils . emptyIfNull ( getMapping () ) ;
return list . indexOf ( o ) ;
}
@Override
public int lastIndexOf ( final Object o ) {
final List < V > list = ListUtils . emptyIfNull ( getMapping () ) ;
return list . lastIndexOf ( o ) ;
}
@Override
public ListIterator < V > listIterator () {
return new ValuesListIterator ( key ) ;
}
@Override
public ListIterator < V > listIterator ( final int index ) {
return new ValuesListIterator ( key , index ) ;
}
@Override
public V remove ( final int index ) {
final List < V > list = ListUtils . emptyIfNull ( getMapping () ) ;
final V value = list . remove ( index ) ;
if ( list . isEmpty () ) {
AbstractListValuedMap . this . remove ( key ) ;
}
return value ;
}
@Override
public V set ( final int index , final V value ) {
final List < V > list = ListUtils . emptyIfNull ( getMapping () ) ;
return list . set ( index , value ) ;
}
@Override
public List < V > subList ( final int fromIndex , final int toIndex ) {
final List < V > list = ListUtils . emptyIfNull ( getMapping () ) ;
return list . subList ( fromIndex , toIndex ) ;
}
@Override
public boolean equals ( final Object other ) {
final List < V > list = getMapping () ;
if ( list == null ) {
return Collections . emptyList () . equals ( other ) ;
}
if ( ! ( other instanceof List ) ) {
return false ;
}
final List < ? > otherList = ( List < ? > ) other ;
return ListUtils . isEqualList ( list , otherList ) ;
}
@Override
public int hashCode () {
final List < V > list = getMapping () ;
return ListUtils . hashCodeForList ( list ) ;
}
@Override
public void add ( final V value ) {
if ( getMap () . get ( key ) == null ) {
final List < V > list = createCollection () ;
getMap () . put ( key , list ) ;
this . values = list ;
this . iterator = list . listIterator () ;
}
this . iterator . add ( value ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public boolean hasPrevious () {
return iterator . hasPrevious () ;
}
@Override
public V next () {
return iterator . next () ;
}
@Override
public int nextIndex () {
return iterator . nextIndex () ;
}
@Override
public V previous () {
return iterator . previous () ;
}
@Override
public int previousIndex () {
return iterator . previousIndex () ;
}
@Override
public void remove () {
iterator . remove () ;
if ( values . isEmpty () ) {
getMap () . remove ( key ) ;
}
}
@Override
public void set ( final V value ) {
iterator . set ( value ) ;
}
