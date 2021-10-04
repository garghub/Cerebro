@Override
public V get ( final Object key ) {
if ( delegateMap != null ) {
return delegateMap . get ( key ) ;
}
if ( key == null ) {
switch ( size ) {
case 3 :
if ( key3 == null ) {
return value3 ;
}
case 2 :
if ( key2 == null ) {
return value2 ;
}
case 1 :
if ( key1 == null ) {
return value1 ;
}
}
} else {
if ( size > 0 ) {
final int hashCode = key . hashCode () ;
switch ( size ) {
case 3 :
if ( hash3 == hashCode && key . equals ( key3 ) ) {
return value3 ;
}
case 2 :
if ( hash2 == hashCode && key . equals ( key2 ) ) {
return value2 ;
}
case 1 :
if ( hash1 == hashCode && key . equals ( key1 ) ) {
return value1 ;
}
}
}
}
return null ;
}
@Override
public int size () {
if ( delegateMap != null ) {
return delegateMap . size () ;
}
return size ;
}
@Override
public boolean isEmpty () {
return size () == 0 ;
}
@Override
public boolean containsKey ( final Object key ) {
if ( delegateMap != null ) {
return delegateMap . containsKey ( key ) ;
}
if ( key == null ) {
switch ( size ) {
case 3 :
if ( key3 == null ) {
return true ;
}
case 2 :
if ( key2 == null ) {
return true ;
}
case 1 :
if ( key1 == null ) {
return true ;
}
}
} else {
if ( size > 0 ) {
final int hashCode = key . hashCode () ;
switch ( size ) {
case 3 :
if ( hash3 == hashCode && key . equals ( key3 ) ) {
return true ;
}
case 2 :
if ( hash2 == hashCode && key . equals ( key2 ) ) {
return true ;
}
case 1 :
if ( hash1 == hashCode && key . equals ( key1 ) ) {
return true ;
}
}
}
}
return false ;
}
@Override
public boolean containsValue ( final Object value ) {
if ( delegateMap != null ) {
return delegateMap . containsValue ( value ) ;
}
if ( value == null ) {
switch ( size ) {
case 3 :
if ( value3 == null ) {
return true ;
}
case 2 :
if ( value2 == null ) {
return true ;
}
case 1 :
if ( value1 == null ) {
return true ;
}
}
} else {
switch ( size ) {
case 3 :
if ( value . equals ( value3 ) ) {
return true ;
}
case 2 :
if ( value . equals ( value2 ) ) {
return true ;
}
case 1 :
if ( value . equals ( value1 ) ) {
return true ;
}
}
}
return false ;
}
@Override
public V put ( final K key , final V value ) {
if ( delegateMap != null ) {
return delegateMap . put ( key , value ) ;
}
if ( key == null ) {
switch ( size ) {
case 3 :
if ( key3 == null ) {
final V old = value3 ;
value3 = value ;
return old ;
}
case 2 :
if ( key2 == null ) {
final V old = value2 ;
value2 = value ;
return old ;
}
case 1 :
if ( key1 == null ) {
final V old = value1 ;
value1 = value ;
return old ;
}
}
} else {
if ( size > 0 ) {
final int hashCode = key . hashCode () ;
switch ( size ) {
case 3 :
if ( hash3 == hashCode && key . equals ( key3 ) ) {
final V old = value3 ;
value3 = value ;
return old ;
}
case 2 :
if ( hash2 == hashCode && key . equals ( key2 ) ) {
final V old = value2 ;
value2 = value ;
return old ;
}
case 1 :
if ( hash1 == hashCode && key . equals ( key1 ) ) {
final V old = value1 ;
value1 = value ;
return old ;
}
}
}
}
switch ( size ) {
default:
convertToMap () ;
delegateMap . put ( key , value ) ;
return null ;
case 2 :
hash3 = key == null ? 0 : key . hashCode () ;
key3 = key ;
value3 = value ;
break;
case 1 :
hash2 = key == null ? 0 : key . hashCode () ;
key2 = key ;
value2 = value ;
break;
case 0 :
hash1 = key == null ? 0 : key . hashCode () ;
key1 = key ;
value1 = value ;
break;
}
size ++ ;
return null ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > map ) {
final int size = map . size () ;
if ( size == 0 ) {
return;
}
if ( delegateMap != null ) {
delegateMap . putAll ( map ) ;
return;
}
if ( size < 4 ) {
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
put ( entry . getKey () , entry . getValue () ) ;
}
} else {
convertToMap () ;
delegateMap . putAll ( map ) ;
}
}
private void convertToMap () {
delegateMap = createDelegateMap () ;
switch ( size ) {
case 3 :
delegateMap . put ( key3 , value3 ) ;
case 2 :
delegateMap . put ( key2 , value2 ) ;
case 1 :
delegateMap . put ( key1 , value1 ) ;
case 0 :
break;
default:
throw new IllegalStateException ( lr_1 + size ) ;
}
size = 0 ;
hash1 = hash2 = hash3 = 0 ;
key1 = key2 = key3 = null ;
value1 = value2 = value3 = null ;
}
protected AbstractHashedMap < K , V > createDelegateMap () {
return new HashedMap <> () ;
}
@Override
public V remove ( final Object key ) {
if ( delegateMap != null ) {
return delegateMap . remove ( key ) ;
}
if ( size == 0 ) {
return null ;
}
if ( key == null ) {
switch ( size ) {
case 3 :
if ( key3 == null ) {
final V old = value3 ;
hash3 = 0 ;
key3 = null ;
value3 = null ;
size = 2 ;
return old ;
}
if ( key2 == null ) {
final V old = value2 ;
hash2 = hash3 ;
key2 = key3 ;
value2 = value3 ;
hash3 = 0 ;
key3 = null ;
value3 = null ;
size = 2 ;
return old ;
}
if ( key1 == null ) {
final V old = value1 ;
hash1 = hash3 ;
key1 = key3 ;
value1 = value3 ;
hash3 = 0 ;
key3 = null ;
value3 = null ;
size = 2 ;
return old ;
}
return null ;
case 2 :
if ( key2 == null ) {
final V old = value2 ;
hash2 = 0 ;
key2 = null ;
value2 = null ;
size = 1 ;
return old ;
}
if ( key1 == null ) {
final V old = value1 ;
hash1 = hash2 ;
key1 = key2 ;
value1 = value2 ;
hash2 = 0 ;
key2 = null ;
value2 = null ;
size = 1 ;
return old ;
}
return null ;
case 1 :
if ( key1 == null ) {
final V old = value1 ;
hash1 = 0 ;
key1 = null ;
value1 = null ;
size = 0 ;
return old ;
}
}
} else {
if ( size > 0 ) {
final int hashCode = key . hashCode () ;
switch ( size ) {
case 3 :
if ( hash3 == hashCode && key . equals ( key3 ) ) {
final V old = value3 ;
hash3 = 0 ;
key3 = null ;
value3 = null ;
size = 2 ;
return old ;
}
if ( hash2 == hashCode && key . equals ( key2 ) ) {
final V old = value2 ;
hash2 = hash3 ;
key2 = key3 ;
value2 = value3 ;
hash3 = 0 ;
key3 = null ;
value3 = null ;
size = 2 ;
return old ;
}
if ( hash1 == hashCode && key . equals ( key1 ) ) {
final V old = value1 ;
hash1 = hash3 ;
key1 = key3 ;
value1 = value3 ;
hash3 = 0 ;
key3 = null ;
value3 = null ;
size = 2 ;
return old ;
}
return null ;
case 2 :
if ( hash2 == hashCode && key . equals ( key2 ) ) {
final V old = value2 ;
hash2 = 0 ;
key2 = null ;
value2 = null ;
size = 1 ;
return old ;
}
if ( hash1 == hashCode && key . equals ( key1 ) ) {
final V old = value1 ;
hash1 = hash2 ;
key1 = key2 ;
value1 = value2 ;
hash2 = 0 ;
key2 = null ;
value2 = null ;
size = 1 ;
return old ;
}
return null ; MST[ReturnValsMutator]MSP[]
case 1 :
if ( hash1 == hashCode && key . equals ( key1 ) ) {
final V old = value1 ;
hash1 = 0 ;
key1 = null ;
value1 = null ;
size = 0 ;
return old ;
}
}
}
}
return null ;
}
@Override
public void clear () {
if ( delegateMap != null ) {
delegateMap . clear () ;
delegateMap = null ;
} else {
size = 0 ;
hash1 = hash2 = hash3 = 0 ;
key1 = key2 = key3 = null ;
value1 = value2 = value3 = null ;
}
}
@Override
public MapIterator < K , V > mapIterator () {
if ( delegateMap != null ) {
return delegateMap . mapIterator () ;
}
if ( size == 0 ) {
return EmptyMapIterator . <K , V > emptyMapIterator () ;
}
return new FlatMapIterator <> ( this ) ;
}
@Override
public boolean hasNext () {
return nextIndex < parent . size ;
}
@Override
public K next () {
if ( hasNext () == false ) {
throw new NoSuchElementException ( AbstractHashedMap . NO_NEXT_ENTRY ) ;
}
canRemove = true ;
nextIndex ++ ;
return getKey () ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( AbstractHashedMap . REMOVE_INVALID ) ;
}
parent . remove ( getKey () ) ;
nextIndex -- ;
canRemove = false ;
}
@Override
public K getKey () {
if ( canRemove == false ) {
throw new IllegalStateException ( AbstractHashedMap . GETKEY_INVALID ) ;
}
switch ( nextIndex ) {
case 3 :
return parent . key3 ;
case 2 :
return parent . key2 ;
case 1 :
return parent . key1 ;
}
throw new IllegalStateException ( lr_1 + nextIndex ) ;
}
@Override
public V getValue () {
if ( canRemove == false ) {
throw new IllegalStateException ( AbstractHashedMap . GETVALUE_INVALID ) ;
}
switch ( nextIndex ) {
case 3 :
return parent . value3 ;
case 2 :
return parent . value2 ;
case 1 :
return parent . value1 ;
}
throw new IllegalStateException ( lr_1 + nextIndex ) ;
}
@Override
public V setValue ( final V value ) {
if ( canRemove == false ) {
throw new IllegalStateException ( AbstractHashedMap . SETVALUE_INVALID ) ;
}
final V old = getValue () ;
switch ( nextIndex ) {
case 3 :
parent . value3 = value ;
break;
case 2 :
parent . value2 = value ;
break;
case 1 :
parent . value1 = value ;
break;
default:
throw new IllegalStateException ( lr_1 + nextIndex ) ;
}
return old ;
}
@Override
public void reset () {
nextIndex = 0 ;
canRemove = false ;
}
@Override
public String toString () {
if ( canRemove ) {
return lr_2 + getKey () + lr_3 + getValue () + lr_4 ;
}
return lr_5 ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( delegateMap != null ) {
return delegateMap . entrySet () ;
}
return new EntrySet <> ( this ) ;
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
public boolean remove ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
final Object key = entry . getKey () ;
final boolean result = parent . containsKey ( key ) ;
parent . remove ( key ) ;
return result ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
if ( parent . delegateMap != null ) {
return parent . delegateMap . entrySet () . iterator () ;
}
if ( parent . size () == 0 ) {
return EmptyIterator . < Map . Entry < K , V > > emptyIterator () ;
}
return new EntrySetIterator <> ( parent ) ;
}
void setRemoved ( final boolean flag ) {
this . removed = flag ;
}
@Override
public K getKey () {
if ( removed ) {
throw new IllegalStateException ( AbstractHashedMap . GETKEY_INVALID ) ;
}
switch ( index ) {
case 3 :
return parent . key3 ;
case 2 :
return parent . key2 ;
case 1 :
return parent . key1 ;
}
throw new IllegalStateException ( lr_1 + index ) ;
}
@Override
public V getValue () {
if ( removed ) {
throw new IllegalStateException ( AbstractHashedMap . GETVALUE_INVALID ) ;
}
switch ( index ) {
case 3 :
return parent . value3 ;
case 2 :
return parent . value2 ;
case 1 :
return parent . value1 ;
}
throw new IllegalStateException ( lr_1 + index ) ;
}
@Override
public V setValue ( final V value ) {
if ( removed ) {
throw new IllegalStateException ( AbstractHashedMap . SETVALUE_INVALID ) ;
}
final V old = getValue () ;
switch ( index ) {
case 3 :
parent . value3 = value ;
break;
case 2 :
parent . value2 = value ;
break;
case 1 :
parent . value1 = value ;
break;
default:
throw new IllegalStateException ( lr_1 + index ) ;
}
return old ;
}
@Override
public boolean equals ( final Object obj ) {
if ( removed ) {
return false ;
}
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > other = ( Map . Entry < ? , ? > ) obj ;
final Object key = getKey () ;
final Object value = getValue () ;
return ( key == null ? other . getKey () == null : key . equals ( other . getKey () ) ) &&
( value == null ? other . getValue () == null : value . equals ( other . getValue () ) ) ;
}
@Override
public int hashCode () {
if ( removed ) {
return 0 ;
}
final Object key = getKey () ;
final Object value = getValue () ;
return ( key == null ? 0 : key . hashCode () ) ^
( value == null ? 0 : value . hashCode () ) ;
}
@Override
public String toString () {
if ( ! removed ) {
return getKey () + lr_3 + getValue () ;
}
return lr_6 ;
}
public boolean hasNext () {
return nextIndex < parent . size ;
}
public Map . Entry < K , V > nextEntry () {
if ( ! hasNext () ) {
throw new NoSuchElementException ( AbstractHashedMap . NO_NEXT_ENTRY ) ;
}
currentEntry = new FlatMapEntry <> ( parent , ++ nextIndex ) ;
return currentEntry ;
}
public void remove () {
if ( currentEntry == null ) {
throw new IllegalStateException ( AbstractHashedMap . REMOVE_INVALID ) ;
}
parent . remove ( currentEntry . getKey () ) ;
currentEntry . setRemoved ( true ) ;
nextIndex -- ;
currentEntry = null ;
}
@Override
public Map . Entry < K , V > next () {
return nextEntry () ;
}
@Override
public Set < K > keySet () {
if ( delegateMap != null ) {
return delegateMap . keySet () ;
}
return new KeySet <> ( this ) ;
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
if ( parent . delegateMap != null ) {
return parent . delegateMap . keySet () . iterator () ;
}
if ( parent . size () == 0 ) {
return EmptyIterator . <K > emptyIterator () ;
}
return new KeySetIterator <> ( parent ) ;
}
@Override
public K next () {
return nextEntry () . getKey () ;
}
@Override
public Collection < V > values () {
if ( delegateMap != null ) {
return delegateMap . values () ;
}
return new Values <> ( this ) ;
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
if ( parent . delegateMap != null ) {
return parent . delegateMap . values () . iterator () ;
}
if ( parent . size () == 0 ) {
return EmptyIterator . <V > emptyIterator () ;
}
return new ValuesIterator <> ( parent ) ;
}
@Override
public V next () {
return nextEntry () . getValue () ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeInt ( size () ) ;
for ( final MapIterator < ? , ? > it = mapIterator () ; it . hasNext () ; ) {
out . writeObject ( it . next () ) ;
out . writeObject ( it . getValue () ) ;
}
}
@SuppressWarnings ( lr_7 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
final int count = in . readInt () ;
if ( count > 3 ) {
delegateMap = createDelegateMap () ;
}
for ( int i = count ; i > 0 ; i -- ) {
put ( ( K ) in . readObject () , ( V ) in . readObject () ) ;
}
}
@Override
@SuppressWarnings ( lr_7 )
public Flat3Map < K , V > clone () {
try {
final Flat3Map < K , V > cloned = ( Flat3Map < K , V > ) super . clone () ;
if ( cloned . delegateMap != null ) {
cloned . delegateMap = cloned . delegateMap . clone () ;
}
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
if ( delegateMap != null ) {
return delegateMap . equals ( obj ) ;
}
if ( obj instanceof Map == false ) {
return false ;
}
final Map < ? , ? > other = ( Map < ? , ? > ) obj ;
if ( size != other . size () ) {
return false ;
}
if ( size > 0 ) {
Object otherValue = null ;
switch ( size ) {
case 3 :
if ( other . containsKey ( key3 ) == false ) {
return false ;
}
otherValue = other . get ( key3 ) ;
if ( value3 == null ? otherValue != null : ! value3 . equals ( otherValue ) ) {
return false ;
}
case 2 :
if ( other . containsKey ( key2 ) == false ) {
return false ;
}
otherValue = other . get ( key2 ) ;
if ( value2 == null ? otherValue != null : ! value2 . equals ( otherValue ) ) {
return false ;
}
case 1 :
if ( other . containsKey ( key1 ) == false ) {
return false ;
}
otherValue = other . get ( key1 ) ;
if ( value1 == null ? otherValue != null : ! value1 . equals ( otherValue ) ) {
return false ;
}
}
}
return true ;
}
@Override
public int hashCode () {
if ( delegateMap != null ) {
return delegateMap . hashCode () ;
}
int total = 0 ;
switch ( size ) {
case 3 :
total += hash3 ^ ( value3 == null ? 0 : value3 . hashCode () ) ;
case 2 :
total += hash2 ^ ( value2 == null ? 0 : value2 . hashCode () ) ;
case 1 :
total += hash1 ^ ( value1 == null ? 0 : value1 . hashCode () ) ;
case 0 :
break;
default:
throw new IllegalStateException ( lr_1 + size ) ;
}
return total ;
}
@Override
public String toString () {
if ( delegateMap != null ) {
return delegateMap . toString () ;
}
if ( size == 0 ) {
return lr_8 ;
}
final StringBuilder buf = new StringBuilder ( 128 ) ;
buf . append ( '{' ) ;
switch ( size ) {
case 3 :
buf . append ( key3 == this ? lr_9 : key3 ) ;
buf . append ( '=' ) ;
buf . append ( value3 == this ? lr_9 : value3 ) ;
buf . append ( ',' ) ;
case 2 :
buf . append ( key2 == this ? lr_9 : key2 ) ;
buf . append ( '=' ) ;
buf . append ( value2 == this ? lr_9 : value2 ) ;
buf . append ( ',' ) ;
case 1 :
buf . append ( key1 == this ? lr_9 : key1 ) ;
buf . append ( '=' ) ;
buf . append ( value1 == this ? lr_9 : value1 ) ;
break;
default:
throw new IllegalStateException ( lr_1 + size ) ;
}
buf . append ( '}' ) ;
return buf . toString () ;
}
