protected void init () {
}
@Override
public V get ( Object key ) {
key = convertKey ( key ) ;
final int hashCode = hash ( key ) ;
HashEntry < K , V > entry = data [ hashIndex ( hashCode , data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( key , entry . key ) ) {
return entry . getValue () ;
}
entry = entry . next ;
}
return null ;
}
@Override
public int size () {
return size ;
}
@Override
public boolean isEmpty () {
return size == 0 ;
}
@Override
public boolean containsKey ( Object key ) {
key = convertKey ( key ) ;
final int hashCode = hash ( key ) ;
HashEntry < K , V > entry = data [ hashIndex ( hashCode , data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( key , entry . key ) ) {
return true ;
}
entry = entry . next ;
}
return false ;
}
@Override
public boolean containsValue ( final Object value ) {
if ( value == null ) {
for ( final HashEntry < K , V > element : data ) {
HashEntry < K , V > entry = element ;
while ( entry != null ) {
if ( entry . getValue () == null ) {
return true ;
}
entry = entry . next ;
}
}
} else {
for ( final HashEntry < K , V > element : data ) {
HashEntry < K , V > entry = element ;
while ( entry != null ) {
if ( isEqualValue ( value , entry . getValue () ) ) {
return true ;
}
entry = entry . next ;
}
}
}
return false ;
}
@Override
public V put ( final K key , final V value ) {
final Object convertedKey = convertKey ( key ) ;
final int hashCode = hash ( convertedKey ) ;
final int index = hashIndex ( hashCode , data . length ) ;
HashEntry < K , V > entry = data [ index ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( convertedKey , entry . key ) ) {
final V oldValue = entry . getValue () ;
updateEntry ( entry , value ) ;
return oldValue ;
}
entry = entry . next ;
}
addMapping ( index , hashCode , key , value ) ;
return null ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > map ) {
_putAll ( map ) ;
}
private void _putAll ( final Map < ? extends K , ? extends V > map ) {
final int mapSize = map . size () ;
if ( mapSize == 0 ) {
return;
}
final int newSize = (int) ( ( size + mapSize ) / loadFactor + 1 ) ;
ensureCapacity ( calculateNewCapacity ( newSize ) ) ;
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
put ( entry . getKey () , entry . getValue () ) ;
}
}
@Override
public V remove ( Object key ) {
key = convertKey ( key ) ;
final int hashCode = hash ( key ) ;
final int index = hashIndex ( hashCode , data . length ) ;
HashEntry < K , V > entry = data [ index ] ;
HashEntry < K , V > previous = null ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( key , entry . key ) ) {
final V oldValue = entry . getValue () ;
removeMapping ( entry , index , previous ) ;
return oldValue ;
}
previous = entry ;
entry = entry . next ;
}
return null ;
}
@Override
public void clear () {
modCount ++ ;
final HashEntry < K , V > [] data = this . data ;
for ( int i = data . length - 1 ; i >= 0 ; i -- ) {
data [ i ] = null ;
}
size = 0 ;
}
protected Object convertKey ( final Object key ) {
return key == null ? NULL : key ;
}
protected int hash ( final Object key ) {
int h = key . hashCode () ;
h += ~ ( h << 9 ) ;
h ^= h >>> 14 ;
h += h << 4 ;
h ^= h >>> 10 ;
return h ;
}
protected boolean isEqualKey ( final Object key1 , final Object key2 ) {
return key1 == key2 || key1 . equals ( key2 ) ;
}
protected boolean isEqualValue ( final Object value1 , final Object value2 ) {
return value1 == value2 || value1 . equals ( value2 ) ;
}
protected int hashIndex ( final int hashCode , final int dataSize ) {
return hashCode & dataSize - 1 ;
}
protected HashEntry < K , V > getEntry ( Object key ) {
key = convertKey ( key ) ;
final int hashCode = hash ( key ) ;
HashEntry < K , V > entry = data [ hashIndex ( hashCode , data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( key , entry . key ) ) {
return entry ;
}
entry = entry . next ;
}
return null ;
}
protected void updateEntry ( final HashEntry < K , V > entry , final V newValue ) {
entry . setValue ( newValue ) ;
}
protected void reuseEntry ( final HashEntry < K , V > entry , final int hashIndex , final int hashCode ,
final K key , final V value ) {
entry . next = data [ hashIndex ] ;
entry . hashCode = hashCode ;
entry . key = key ;
entry . value = value ;
}
protected void addMapping ( final int hashIndex , final int hashCode , final K key , final V value ) {
modCount ++ ;
final HashEntry < K , V > entry = createEntry ( data [ hashIndex ] , hashCode , key , value ) ;
addEntry ( entry , hashIndex ) ;
size ++ ;
checkCapacity () ;
}
protected HashEntry < K , V > createEntry ( final HashEntry < K , V > next , final int hashCode , final K key , final V value ) {
return new HashEntry <> ( next , hashCode , convertKey ( key ) , value ) ;
}
protected void addEntry ( final HashEntry < K , V > entry , final int hashIndex ) {
data [ hashIndex ] = entry ;
}
protected void removeMapping ( final HashEntry < K , V > entry , final int hashIndex , final HashEntry < K , V > previous ) {
modCount ++ ;
removeEntry ( entry , hashIndex , previous ) ;
size -- ;
destroyEntry ( entry ) ;
}
protected void removeEntry ( final HashEntry < K , V > entry , final int hashIndex , final HashEntry < K , V > previous ) {
if ( previous == null ) {
data [ hashIndex ] = entry . next ;
} else {
previous . next = entry . next ;
}
}
protected void destroyEntry ( final HashEntry < K , V > entry ) {
entry . next = null ;
entry . key = null ;
entry . value = null ;
}
protected void checkCapacity () {
if ( size >= threshold ) {
final int newCapacity = data . length * 2 ;
if ( newCapacity <= MAXIMUM_CAPACITY ) {
ensureCapacity ( newCapacity ) ;
}
}
}
@SuppressWarnings ( lr_1 )
protected void ensureCapacity ( final int newCapacity ) {
final int oldCapacity = data . length ;
if ( newCapacity <= oldCapacity ) {
return;
}
if ( size == 0 ) {
threshold = calculateThreshold ( newCapacity , loadFactor ) ;
data = new HashEntry [ newCapacity ] ;
} else {
final HashEntry < K , V > oldEntries [] = data ;
final HashEntry < K , V > newEntries [] = new HashEntry [ newCapacity ] ;
modCount ++ ;
for ( int i = oldCapacity - 1 ; i >= 0 ; i -- ) {
HashEntry < K , V > entry = oldEntries [ i ] ;
if ( entry != null ) {
oldEntries [ i ] = null ;
do {
final HashEntry < K , V > next = entry . next ;
final int index = hashIndex ( entry . hashCode , newCapacity ) ;
entry . next = newEntries [ index ] ;
newEntries [ index ] = entry ;
entry = next ;
} while ( entry != null );
}
}
threshold = calculateThreshold ( newCapacity , loadFactor ) ;
data = newEntries ;
}
}
protected int calculateNewCapacity ( final int proposedCapacity ) {
int newCapacity = 1 ;
if ( proposedCapacity > MAXIMUM_CAPACITY ) {
newCapacity = MAXIMUM_CAPACITY ;
} else {
while ( newCapacity < proposedCapacity ) {
newCapacity <<= 1 ;
}
if ( newCapacity > MAXIMUM_CAPACITY ) {
newCapacity = MAXIMUM_CAPACITY ;
}
}
return newCapacity ;
}
protected int calculateThreshold ( final int newCapacity , final float factor ) {
return (int) ( newCapacity * factor ) ;
}
protected HashEntry < K , V > entryNext ( final HashEntry < K , V > entry ) {
return entry . next ;
}
protected int entryHashCode ( final HashEntry < K , V > entry ) {
return entry . hashCode ;
}
protected K entryKey ( final HashEntry < K , V > entry ) {
return entry . getKey () ;
}
protected V entryValue ( final HashEntry < K , V > entry ) {
return entry . getValue () ;
}
@Override
public MapIterator < K , V > mapIterator () {
if ( size == 0 ) {
return EmptyMapIterator . <K , V > emptyMapIterator () ;
}
return new HashMapIterator <> ( this ) ;
}
@Override
public K next () {
return super . nextEntry () . getKey () ;
}
@Override
public K getKey () {
final HashEntry < K , V > current = currentEntry () ;
if ( current == null ) {
throw new IllegalStateException ( AbstractHashedMap . GETKEY_INVALID ) ;
}
return current . getKey () ;
}
@Override
public V getValue () {
final HashEntry < K , V > current = currentEntry () ;
if ( current == null ) {
throw new IllegalStateException ( AbstractHashedMap . GETVALUE_INVALID ) ;
}
return current . getValue () ;
}
@Override
public V setValue ( final V value ) {
final HashEntry < K , V > current = currentEntry () ;
if ( current == null ) {
throw new IllegalStateException ( AbstractHashedMap . SETVALUE_INVALID ) ;
}
return current . setValue ( value ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( entrySet == null ) {
entrySet = new EntrySet <> ( this ) ;
}
return entrySet ;
}
protected Iterator < Map . Entry < K , V > > createEntrySetIterator () {
if ( size () == 0 ) {
return EmptyIterator . < Map . Entry < K , V > > emptyIterator () ;
}
return new EntrySetIterator <> ( this ) ;
}
@Override
public int size () {
return parent . size () ;
}
@Override
public void clear () {
parent . clear () ;
}
@Override
public boolean contains ( final Object entry ) {
if ( entry instanceof Map . Entry ) {
final Map . Entry < ? , ? > e = ( Map . Entry < ? , ? > ) entry ;
final Entry < K , V > match = parent . getEntry ( e . getKey () ) ;
return match != null && match . equals ( e ) ;
}
return false ;
}
@Override
public boolean remove ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
if ( contains ( obj ) == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
parent . remove ( entry . getKey () ) ;
return true ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
return parent . createEntrySetIterator () ;
}
@Override
public Map . Entry < K , V > next () {
return super . nextEntry () ;
}
@Override
public Set < K > keySet () {
if ( keySet == null ) {
keySet = new KeySet <> ( this ) ;
}
return keySet ;
}
protected Iterator < K > createKeySetIterator () {
if ( size () == 0 ) {
return EmptyIterator . <K > emptyIterator () ;
}
return new KeySetIterator <> ( this ) ;
}
@Override
public int size () {
return parent . size () ;
}
@Override
public void clear () {
parent . clear () ;
}
@Override
public boolean contains ( final Object key ) {
return parent . containsKey ( key ) ;
}
@Override
public boolean remove ( final Object key ) {
final boolean result = parent . containsKey ( key ) ;
parent . remove ( key ) ;
return result ;
}
@Override
public Iterator < K > iterator () {
return parent . createKeySetIterator () ;
}
@Override
public K next () {
return super . nextEntry () . getKey () ;
}
@Override
public Collection < V > values () {
if ( values == null ) {
values = new Values <> ( this ) ;
}
return values ;
}
protected Iterator < V > createValuesIterator () {
if ( size () == 0 ) {
return EmptyIterator . <V > emptyIterator () ;
}
return new ValuesIterator <> ( this ) ;
}
@Override
public int size () {
return parent . size () ;
}
@Override
public void clear () {
parent . clear () ;
}
@Override
public boolean contains ( final Object value ) {
return parent . containsValue ( value ) ;
}
@Override
public Iterator < V > iterator () {
return parent . createValuesIterator () ;
}
@Override
public V next () {
return super . nextEntry () . getValue () ;
}
@Override
@SuppressWarnings ( lr_1 )
public K getKey () {
if ( key == NULL ) {
return null ;
}
return ( K ) key ;
}
@Override
@SuppressWarnings ( lr_1 )
public V getValue () {
return ( V ) value ;
}
@Override
@SuppressWarnings ( lr_1 )
public V setValue ( final V value ) {
final Object old = this . value ;
this . value = value ;
return ( V ) old ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > other = ( Map . Entry < ? , ? > ) obj ;
return
( getKey () == null ? other . getKey () == null : getKey () . equals ( other . getKey () ) ) &&
( getValue () == null ? other . getValue () == null : getValue () . equals ( other . getValue () ) ) ;
}
@Override
public int hashCode () {
return ( getKey () == null ? 0 : getKey () . hashCode () ) ^
( getValue () == null ? 0 : getValue () . hashCode () ) ;
}
@Override
public String toString () {
return new StringBuilder () . append ( getKey () ) . append ( '=' ) . append ( getValue () ) . toString () ;
}
public boolean hasNext () {
return next != null ;
}
protected HashEntry < K , V > nextEntry () {
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
final HashEntry < K , V > newCurrent = next ;
if ( newCurrent == null ) {
throw new NoSuchElementException ( AbstractHashedMap . NO_NEXT_ENTRY ) ;
}
final HashEntry < K , V > [] data = parent . data ;
int i = hashIndex ;
HashEntry < K , V > n = newCurrent . next ;
while ( n == null && i > 0 ) {
n = data [ -- i ] ;
}
next = n ;
hashIndex = i ;
last = newCurrent ;
return newCurrent ; MST[ReturnValsMutator]MSP[]
}
protected HashEntry < K , V > currentEntry () {
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
@Override
public String toString () {
if ( last != null ) {
return lr_2 + last . getKey () + lr_3 + last . getValue () + lr_4 ;
}
return lr_5 ;
}
protected void doWriteObject ( final ObjectOutputStream out ) throws IOException {
out . writeFloat ( loadFactor ) ;
out . writeInt ( data . length ) ;
out . writeInt ( size ) ;
for ( final MapIterator < K , V > it = mapIterator () ; it . hasNext () ; ) {
out . writeObject ( it . next () ) ;
out . writeObject ( it . getValue () ) ;
}
}
@SuppressWarnings ( lr_1 )
protected void doReadObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
loadFactor = in . readFloat () ;
final int capacity = in . readInt () ;
final int size = in . readInt () ;
init () ;
threshold = calculateThreshold ( capacity , loadFactor ) ;
data = new HashEntry [ capacity ] ;
for ( int i = 0 ; i < size ; i ++ ) {
final K key = ( K ) in . readObject () ;
final V value = ( V ) in . readObject () ;
put ( key , value ) ;
}
}
@Override
@SuppressWarnings ( lr_1 )
protected AbstractHashedMap < K , V > clone () {
try {
final AbstractHashedMap < K , V > cloned = ( AbstractHashedMap < K , V > ) super . clone () ;
cloned . data = new HashEntry [ data . length ] ;
cloned . entrySet = null ;
cloned . keySet = null ;
cloned . values = null ;
cloned . modCount = 0 ;
cloned . size = 0 ;
cloned . init () ;
cloned . putAll ( this ) ;
return cloned ;
} catch ( final CloneNotSupportedException ex ) {
throw new InternalError () ;
}
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof Map == false ) {
return false ;
}
final Map < ? , ? > map = ( Map < ? , ? > ) obj ;
if ( map . size () != size () ) {
return false ;
}
final MapIterator < ? , ? > it = mapIterator () ;
try {
while ( it . hasNext () ) {
final Object key = it . next () ;
final Object value = it . getValue () ;
if ( value == null ) {
if ( map . get ( key ) != null || map . containsKey ( key ) == false ) {
return false ;
}
} else {
if ( value . equals ( map . get ( key ) ) == false ) {
return false ;
}
}
}
} catch ( final ClassCastException ignored ) {
return false ;
} catch ( final NullPointerException ignored ) {
return false ;
}
return true ;
}
@Override
public int hashCode () {
int total = 0 ;
final Iterator < Map . Entry < K , V > > it = createEntrySetIterator () ;
while ( it . hasNext () ) {
total += it . next () . hashCode () ;
}
return total ;
}
@Override
public String toString () {
if ( size () == 0 ) {
return lr_6 ;
}
final StringBuilder buf = new StringBuilder ( 32 * size () ) ;
buf . append ( '{' ) ;
final MapIterator < K , V > it = mapIterator () ;
boolean hasNext = it . hasNext () ;
while ( hasNext ) {
final K key = it . next () ;
final V value = it . getValue () ;
buf . append ( key == this ? lr_7 : key )
. append ( '=' )
. append ( value == this ? lr_7 : value ) ;
hasNext = it . hasNext () ;
if ( hasNext ) {
buf . append ( ',' ) . append ( ' ' ) ;
}
}
buf . append ( '}' ) ;
return buf . toString () ;
}
