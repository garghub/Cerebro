public static < K , V > ListOrderedMap < K , V > listOrderedMap ( final Map < K , V > map ) {
return new ListOrderedMap <> ( map ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < K , V > ) in . readObject () ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
return new ListOrderedMapIterator <> ( this ) ;
}
@Override
public K firstKey () {
if ( size () == 0 ) {
throw new NoSuchElementException ( lr_2 ) ;
}
return insertOrder . get ( 0 ) ;
}
@Override
public K lastKey () {
if ( size () == 0 ) {
throw new NoSuchElementException ( lr_2 ) ;
}
return insertOrder . get ( size () - 1 ) ;
}
@Override
public K nextKey ( final Object key ) {
final int index = insertOrder . indexOf ( key ) ;
if ( index >= 0 && index < size () - 1 ) {
return insertOrder . get ( index + 1 ) ;
}
return null ;
}
@Override
public K previousKey ( final Object key ) {
final int index = insertOrder . indexOf ( key ) ;
if ( index > 0 ) {
return insertOrder . get ( index - 1 ) ;
}
return null ;
}
@Override
public V put ( final K key , final V value ) {
if ( decorated () . containsKey ( key ) ) {
return decorated () . put ( key , value ) ;
}
final V result = decorated () . put ( key , value ) ;
insertOrder . add ( key ) ;
return result ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > map ) {
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
put ( entry . getKey () , entry . getValue () ) ;
}
}
public void putAll ( int index , final Map < ? extends K , ? extends V > map ) {
if ( index < 0 || index > insertOrder . size () ) { MST[RemoveConditionalMutator_ORDER_IF]MSP[]
throw new IndexOutOfBoundsException ( lr_3 + index + lr_4 + insertOrder . size () ) ;
}
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
final K key = entry . getKey () ;
final boolean contains = containsKey ( key ) ;
put ( index , entry . getKey () , entry . getValue () ) ;
if ( ! contains ) {
index ++ ;
} else {
index = indexOf ( entry . getKey () ) + 1 ;
}
}
}
@Override
public V remove ( final Object key ) {
V result = null ;
if ( decorated () . containsKey ( key ) ) {
result = decorated () . remove ( key ) ;
insertOrder . remove ( key ) ;
}
return result ;
}
@Override
public void clear () {
decorated () . clear () ;
insertOrder . clear () ;
}
@Override
public Set < K > keySet () {
return new KeySetView <> ( this ) ;
}
public List < K > keyList () {
return UnmodifiableList . unmodifiableList ( insertOrder ) ;
}
@Override
public Collection < V > values () {
return new ValuesView <> ( this ) ;
}
public List < V > valueList () {
return new ValuesView <> ( this ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
return new EntrySetView <> ( this , this . insertOrder ) ;
}
@Override
public String toString () {
if ( isEmpty () ) {
return lr_5 ;
}
final StringBuilder buf = new StringBuilder () ;
buf . append ( '{' ) ;
boolean first = true ;
for ( final Map . Entry < K , V > entry : entrySet () ) {
final K key = entry . getKey () ;
final V value = entry . getValue () ;
if ( first ) {
first = false ;
} else {
buf . append ( lr_6 ) ;
}
buf . append ( key == this ? lr_7 : key ) ;
buf . append ( '=' ) ;
buf . append ( value == this ? lr_7 : value ) ;
}
buf . append ( '}' ) ;
return buf . toString () ;
}
public K get ( final int index ) {
return insertOrder . get ( index ) ;
}
public V getValue ( final int index ) {
return get ( insertOrder . get ( index ) ) ;
}
public int indexOf ( final Object key ) {
return insertOrder . indexOf ( key ) ;
}
public V setValue ( final int index , final V value ) {
final K key = insertOrder . get ( index ) ;
return put ( key , value ) ;
}
public V put ( int index , final K key , final V value ) {
if ( index < 0 || index > insertOrder . size () ) {
throw new IndexOutOfBoundsException ( lr_3 + index + lr_4 + insertOrder . size () ) ;
}
final Map < K , V > m = decorated () ;
if ( m . containsKey ( key ) ) {
final V result = m . remove ( key ) ;
final int pos = insertOrder . indexOf ( key ) ;
insertOrder . remove ( pos ) ;
if ( pos < index ) {
index -- ;
}
insertOrder . add ( index , key ) ;
m . put ( key , value ) ;
return result ;
}
insertOrder . add ( index , key ) ;
m . put ( key , value ) ;
return null ;
}
public V remove ( final int index ) {
return remove ( get ( index ) ) ;
}
public List < K > asList () {
return keyList () ;
}
@Override
public int size () {
return this . parent . size () ;
}
@Override
public boolean contains ( final Object value ) {
return this . parent . containsValue ( value ) ;
}
@Override
public void clear () {
this . parent . clear () ;
}
@Override
public V next () {
return getIterator () . next () . getValue () ;
}
@Override
public V get ( final int index ) {
return this . parent . getValue ( index ) ;
}
@Override
public V set ( final int index , final V value ) {
return this . parent . setValue ( index , value ) ;
}
@Override
public V remove ( final int index ) {
return this . parent . remove ( index ) ;
}
@Override
public int size () {
return this . parent . size () ;
}
@Override
public boolean contains ( final Object value ) {
return this . parent . containsKey ( value ) ;
}
@Override
public void clear () {
this . parent . clear () ;
}
@Override
public K next () {
return getIterator () . next () . getKey () ;
}
private Set < Map . Entry < K , V > > getEntrySet () {
if ( entrySet == null ) {
entrySet = parent . decorated () . entrySet () ;
}
return entrySet ;
}
@Override
public int size () {
return this . parent . size () ;
}
@Override
public boolean isEmpty () {
return this . parent . isEmpty () ;
}
@Override
public boolean contains ( final Object obj ) {
return getEntrySet () . contains ( obj ) ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
return getEntrySet () . containsAll ( coll ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public boolean remove ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
if ( getEntrySet () . contains ( obj ) ) {
final Object key = ( ( Map . Entry < K , V > ) obj ) . getKey () ;
parent . remove ( key ) ;
return true ;
}
return false ;
}
@Override
public void clear () {
this . parent . clear () ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
return getEntrySet () . equals ( obj ) ;
}
@Override
public int hashCode () {
return getEntrySet () . hashCode () ;
}
@Override
public String toString () {
return getEntrySet () . toString () ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
return new ListOrderedIterator <> ( parent , insertOrder ) ;
}
@Override
public Map . Entry < K , V > next () {
last = getIterator () . next () ;
return new ListOrderedMapEntry <> ( parent , last ) ;
}
@Override
public void remove () {
super . remove () ;
parent . decorated () . remove ( last ) ;
}
@Override
public V getValue () {
return parent . get ( getKey () ) ;
}
@Override
public V setValue ( final V value ) {
return parent . decorated () . put ( getKey () , value ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public K next () {
last = iterator . next () ;
readable = true ;
return last ;
}
@Override
public boolean hasPrevious () {
return iterator . hasPrevious () ;
}
@Override
public K previous () {
last = iterator . previous () ;
readable = true ;
return last ;
}
@Override
public void remove () {
if ( readable == false ) {
throw new IllegalStateException ( AbstractHashedMap . REMOVE_INVALID ) ;
}
iterator . remove () ;
parent . map . remove ( last ) ;
readable = false ;
}
@Override
public K getKey () {
if ( readable == false ) {
throw new IllegalStateException ( AbstractHashedMap . GETKEY_INVALID ) ;
}
return last ;
}
@Override
public V getValue () {
if ( readable == false ) {
throw new IllegalStateException ( AbstractHashedMap . GETVALUE_INVALID ) ;
}
return parent . get ( last ) ;
}
@Override
public V setValue ( final V value ) {
if ( readable == false ) {
throw new IllegalStateException ( AbstractHashedMap . SETVALUE_INVALID ) ;
}
return parent . map . put ( last , value ) ;
}
@Override
public void reset () {
iterator = parent . insertOrder . listIterator () ;
last = null ;
readable = false ;
}
@Override
public String toString () {
if ( readable == true ) {
return lr_8 + getKey () + lr_9 + getValue () + lr_10 ;
}
return lr_11 ;
}
