@Override
public LinkedMap < K , V > clone () {
return ( LinkedMap < K , V > ) super . clone () ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
doReadObject ( in ) ;
}
public K get ( final int index ) {
return getEntry ( index ) . getKey () ;
}
public V getValue ( final int index ) {
return getEntry ( index ) . getValue () ;
}
public int indexOf ( Object key ) {
key = convertKey ( key ) ;
int i = 0 ;
for ( LinkEntry < K , V > entry = header . after ; entry != header ; entry = entry . after , i ++ ) {
if ( isEqualKey ( key , entry . key ) ) {
return i ;
}
}
return - 1 ;
}
public V remove ( final int index ) {
return remove ( get ( index ) ) ;
}
public List < K > asList () {
return new LinkedMapList <> ( this ) ;
}
@Override
public int size () {
return parent . size () ;
}
@Override
public K get ( final int index ) {
return parent . get ( index ) ;
}
@Override
public boolean contains ( final Object obj ) {
return parent . containsKey ( obj ) ;
}
@Override
public int indexOf ( final Object obj ) {
return parent . indexOf ( obj ) ;
}
@Override
public int lastIndexOf ( final Object obj ) {
return parent . indexOf ( obj ) ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
return parent . keySet () . containsAll ( coll ) ;
}
@Override
public K remove ( final int index ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean remove ( final Object obj ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeIf ( final Predicate < ? super K > filter ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
throw new UnsupportedOperationException () ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public Object [] toArray () {
return parent . keySet () . toArray () ;
}
@Override
public < T > T [] toArray ( final T [] array ) {
return parent . keySet () . toArray ( array ) ;
}
@Override
public Iterator < K > iterator () {
return UnmodifiableIterator . unmodifiableIterator ( parent . keySet () . iterator () ) ;
}
@Override
public ListIterator < K > listIterator () {
return UnmodifiableListIterator . umodifiableListIterator ( super . listIterator () ) ;
}
@Override
public ListIterator < K > listIterator ( final int fromIndex ) {
return UnmodifiableListIterator . umodifiableListIterator ( super . listIterator ( fromIndex ) ) ;
}
@Override
public List < K > subList ( final int fromIndexInclusive , final int toIndexExclusive ) {
return UnmodifiableList . unmodifiableList ( super . subList ( fromIndexInclusive , toIndexExclusive ) ) ;
}
