@Override
protected void init () {
header = createEntry ( null , - 1 , null , null ) ;
header . before = header . after = header ;
}
@Override
public boolean containsValue ( final Object value ) {
if ( value == null ) {
for ( LinkEntry < K , V > entry = header . after ; entry != header ; entry = entry . after ) {
if ( entry . getValue () == null ) {
return true ;
}
}
} else {
for ( LinkEntry < K , V > entry = header . after ; entry != header ; entry = entry . after ) {
if ( isEqualValue ( value , entry . getValue () ) ) {
return true ;
}
}
}
return false ;
}
@Override
public void clear () {
super . clear () ;
header . before = header . after = header ;
}
@Override
public K firstKey () {
if ( size == 0 ) {
throw new NoSuchElementException ( lr_1 ) ;
}
return header . after . getKey () ;
}
@Override
public K lastKey () {
if ( size == 0 ) {
throw new NoSuchElementException ( lr_1 ) ;
}
return header . before . getKey () ;
}
@Override
public K nextKey ( final Object key ) {
final LinkEntry < K , V > entry = getEntry ( key ) ;
return entry == null || entry . after == header ? null : entry . after . getKey () ;
}
@Override
protected LinkEntry < K , V > getEntry ( final Object key ) {
return ( LinkEntry < K , V > ) super . getEntry ( key ) ;
}
@Override
public K previousKey ( final Object key ) {
final LinkEntry < K , V > entry = getEntry ( key ) ;
return entry == null || entry . before == header ? null : entry . before . getKey () ;
}
protected LinkEntry < K , V > getEntry ( final int index ) {
if ( index < 0 ) {
throw new IndexOutOfBoundsException ( lr_2 + index + lr_3 ) ;
}
if ( index >= size ) {
throw new IndexOutOfBoundsException ( lr_2 + index + lr_4 + size ) ;
}
LinkEntry < K , V > entry ;
if ( index < size / 2 ) {
entry = header . after ;
for ( int currentIndex = 0 ; currentIndex < index ; currentIndex ++ ) {
entry = entry . after ;
}
} else {
entry = header ;
for ( int currentIndex = size ; currentIndex > index ; currentIndex -- ) {
entry = entry . before ;
}
}
return entry ;
}
@Override
protected void addEntry ( final HashEntry < K , V > entry , final int hashIndex ) {
final LinkEntry < K , V > link = ( LinkEntry < K , V > ) entry ;
link . after = header ;
link . before = header . before ;
header . before . after = link ;
header . before = link ;
data [ hashIndex ] = link ;
}
@Override
protected LinkEntry < K , V > createEntry ( final HashEntry < K , V > next , final int hashCode , final K key , final V value ) {
return new LinkEntry <> ( next , hashCode , convertKey ( key ) , value ) ;
}
@Override
protected void removeEntry ( final HashEntry < K , V > entry , final int hashIndex , final HashEntry < K , V > previous ) {
final LinkEntry < K , V > link = ( LinkEntry < K , V > ) entry ;
link . before . after = link . after ;
link . after . before = link . before ;
link . after = null ;
link . before = null ; MST[experimental.MemberVariableMutator]MSP[]
super . removeEntry ( entry , hashIndex , previous ) ;
}
protected LinkEntry < K , V > entryBefore ( final LinkEntry < K , V > entry ) {
return entry . before ;
}
protected LinkEntry < K , V > entryAfter ( final LinkEntry < K , V > entry ) {
return entry . after ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
if ( size == 0 ) {
return EmptyOrderedMapIterator . <K , V > emptyOrderedMapIterator () ;
}
return new LinkMapIterator <> ( this ) ;
}
@Override
public K next () {
return super . nextEntry () . getKey () ;
}
@Override
public K previous () {
return super . previousEntry () . getKey () ;
}
@Override
public K getKey () {
final LinkEntry < K , V > current = currentEntry () ;
if ( current == null ) {
throw new IllegalStateException ( AbstractHashedMap . GETKEY_INVALID ) ;
}
return current . getKey () ;
}
@Override
public V getValue () {
final LinkEntry < K , V > current = currentEntry () ;
if ( current == null ) {
throw new IllegalStateException ( AbstractHashedMap . GETVALUE_INVALID ) ;
}
return current . getValue () ;
}
@Override
public V setValue ( final V value ) {
final LinkEntry < K , V > current = currentEntry () ;
if ( current == null ) {
throw new IllegalStateException ( AbstractHashedMap . SETVALUE_INVALID ) ;
}
return current . setValue ( value ) ;
}
@Override
protected Iterator < Map . Entry < K , V > > createEntrySetIterator () {
if ( size () == 0 ) {
return EmptyOrderedIterator . < Map . Entry < K , V > > emptyOrderedIterator () ;
}
return new EntrySetIterator <> ( this ) ;
}
@Override
public Map . Entry < K , V > next () {
return super . nextEntry () ;
}
@Override
public Map . Entry < K , V > previous () {
return super . previousEntry () ;
}
@Override
protected Iterator < K > createKeySetIterator () {
if ( size () == 0 ) {
return EmptyOrderedIterator . <K > emptyOrderedIterator () ;
}
return new KeySetIterator <> ( this ) ;
}
@Override
public K next () {
return super . nextEntry () . getKey () ;
}
@Override
public K previous () {
return super . previousEntry () . getKey () ;
}
@Override
protected Iterator < V > createValuesIterator () {
if ( size () == 0 ) {
return EmptyOrderedIterator . <V > emptyOrderedIterator () ;
}
return new ValuesIterator <> ( this ) ;
}
@Override
public V next () {
return super . nextEntry () . getValue () ;
}
@Override
public V previous () {
return super . previousEntry () . getValue () ;
}
public boolean hasNext () {
return next != parent . header ;
}
public boolean hasPrevious () {
return next . before != parent . header ;
}
protected LinkEntry < K , V > nextEntry () {
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
if ( next == parent . header ) {
throw new NoSuchElementException ( AbstractHashedMap . NO_NEXT_ENTRY ) ;
}
last = next ;
next = next . after ;
return last ;
}
protected LinkEntry < K , V > previousEntry () {
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
final LinkEntry < K , V > previous = next . before ;
if ( previous == parent . header ) {
throw new NoSuchElementException ( AbstractHashedMap . NO_PREVIOUS_ENTRY ) ;
}
next = previous ;
last = previous ;
return last ;
}
protected LinkEntry < K , V > currentEntry () {
return last ;
}
public void remove () {
if ( last == null ) {
throw new IllegalStateException ( AbstractHashedMap . REMOVE_INVALID ) ;
}
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
parent . remove ( last . getKey () ) ;
last = null ;
expectedModCount = parent . modCount ;
}
public void reset () {
last = null ;
next = parent . header . after ;
}
@Override
public String toString () {
if ( last != null ) {
return lr_5 + last . getKey () + lr_6 + last . getValue () + lr_7 ;
}
return lr_8 ;
}
