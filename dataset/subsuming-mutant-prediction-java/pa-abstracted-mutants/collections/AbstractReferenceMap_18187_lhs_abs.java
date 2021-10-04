public static ReferenceStrength resolve ( final int value ) {
switch ( value ) {
case 0 :
return HARD ;
case 1 :
return SOFT ;
case 2 :
return WEAK ;
default:
throw new IllegalArgumentException () ;
}
}
@Override
protected void init () {
queue = new ReferenceQueue <> () ;
}
@Override
public int size () {
purgeBeforeRead () ;
return super . size () ;
}
@Override
public boolean isEmpty () {
purgeBeforeRead () ;
return super . isEmpty () ;
}
@Override
public boolean containsKey ( final Object key ) {
purgeBeforeRead () ;
final Entry < K , V > entry = getEntry ( key ) ;
if ( entry == null ) {
return false ;
}
return entry . getValue () != null ;
}
@Override
public boolean containsValue ( final Object value ) {
purgeBeforeRead () ;
if ( value == null ) {
return false ;
}
return super . containsValue ( value ) ;
}
@Override
public V get ( final Object key ) {
purgeBeforeRead () ;
final Entry < K , V > entry = getEntry ( key ) ;
if ( entry == null ) {
return null ;
}
return entry . getValue () ;
}
@Override
public V put ( final K key , final V value ) {
Objects . requireNonNull ( key , lr_1 ) ;
Objects . requireNonNull ( value , lr_2 ) ;
purgeBeforeWrite () ;
return super . put ( key , value ) ;
}
@Override
public V remove ( final Object key ) {
if ( key == null ) {
return null ;
}
purgeBeforeWrite () ;
return super . remove ( key ) ;
}
@Override
public void clear () {
super . clear () ;
while ( queue . poll () != null ) {
}
}
@Override
public MapIterator < K , V > mapIterator () {
return new ReferenceMapIterator <> ( this ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( entrySet == null ) {
entrySet = new ReferenceEntrySet <> ( this ) ;
}
return entrySet ;
}
@Override
public Set < K > keySet () {
if ( keySet == null ) {
keySet = new ReferenceKeySet <> ( this ) ;
}
return keySet ;
}
@Override
public Collection < V > values () {
if ( values == null ) {
values = new ReferenceValues <> ( this ) ;
}
return values ;
}
protected void purgeBeforeRead () {
purge () ;
}
protected void purgeBeforeWrite () {
purge () ;
}
protected void purge () {
Reference < ? > ref = queue . poll () ;
while ( ref != null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
purge ( ref ) ;
ref = queue . poll () ;
}
}
protected void purge ( final Reference < ? > ref ) {
final int hash = ref . hashCode () ;
final int index = hashIndex ( hash , data . length ) ;
HashEntry < K , V > previous = null ;
HashEntry < K , V > entry = data [ index ] ;
while ( entry != null ) {
final ReferenceEntry < K , V > refEntry = ( ReferenceEntry < K , V > ) entry ;
if ( refEntry . purge ( ref ) ) {
if ( previous == null ) {
data [ index ] = entry . next ;
} else {
previous . next = entry . next ;
}
this . size -- ;
refEntry . onPurge () ;
return;
}
previous = entry ;
entry = entry . next ;
}
}
@Override
protected HashEntry < K , V > getEntry ( final Object key ) {
if ( key == null ) {
return null ;
}
return super . getEntry ( key ) ;
}
protected int hashEntry ( final Object key , final Object value ) {
return ( key == null ? 0 : key . hashCode () ) ^
( value == null ? 0 : value . hashCode () ) ;
}
@Override
@SuppressWarnings ( lr_3 )
protected boolean isEqualKey ( final Object key1 , Object key2 ) {
key2 = keyType == ReferenceStrength . HARD ? key2 : ( ( Reference < K > ) key2 ) . get () ;
return key1 == key2 || key1 . equals ( key2 ) ;
}
@Override
protected ReferenceEntry < K , V > createEntry ( final HashEntry < K , V > next , final int hashCode ,
final K key , final V value ) {
return new ReferenceEntry <> ( this , next , hashCode , key , value ) ;
}
@Override
protected Iterator < Map . Entry < K , V > > createEntrySetIterator () {
return new ReferenceEntrySetIterator <> ( this ) ;
}
@Override
protected Iterator < K > createKeySetIterator () {
return new ReferenceKeySetIterator <> ( this ) ;
}
@Override
protected Iterator < V > createValuesIterator () {
return new ReferenceValuesIterator <> ( this ) ;
}
@Override
public Object [] toArray () {
return toArray ( new Object [ size () ] ) ;
}
@Override
public < T > T [] toArray ( final T [] arr ) {
final ArrayList < Map . Entry < K , V > > list = new ArrayList <> ( size () ) ;
for ( final Map . Entry < K , V > entry : this ) {
list . add ( new DefaultMapEntry <> ( entry ) ) ;
}
return list . toArray ( arr ) ;
}
@Override
public Object [] toArray () {
return toArray ( new Object [ size () ] ) ;
}
@Override
public < T > T [] toArray ( final T [] arr ) {
final List < K > list = new ArrayList <> ( size () ) ;
for ( final K key : this ) {
list . add ( key ) ;
}
return list . toArray ( arr ) ;
}
@Override
public Object [] toArray () {
return toArray ( new Object [ size () ] ) ;
}
@Override
public < T > T [] toArray ( final T [] arr ) {
final List < V > list = new ArrayList <> ( size () ) ;
for ( final V value : this ) {
list . add ( value ) ;
}
return list . toArray ( arr ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public K getKey () {
return (K) ( parent . keyType == ReferenceStrength . HARD ? key : ( ( Reference < K > ) key ) . get () ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public V getValue () {
return (V) ( parent . valueType == ReferenceStrength . HARD ? value : ( ( Reference < V > ) value ) . get () ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public V setValue ( final V obj ) {
final V old = getValue () ;
if ( parent . valueType != ReferenceStrength . HARD ) {
( ( Reference < V > ) value ) . clear () ;
}
value = toReference ( parent . valueType , obj , hashCode ) ;
return old ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
final Object entryKey = entry . getKey () ;
final Object entryValue = entry . getValue () ;
if ( entryKey == null || entryValue == null ) {
return false ;
}
return parent . isEqualKey ( entryKey , key ) &&
parent . isEqualValue ( entryValue , getValue () ) ;
}
@Override
public int hashCode () {
return parent . hashEntry ( getKey () , getValue () ) ;
}
protected < T > Object toReference ( final ReferenceStrength type , final T referent , final int hash ) {
if ( type == ReferenceStrength . HARD ) {
return referent ;
}
if ( type == ReferenceStrength . SOFT ) {
return new SoftRef <> ( hash , referent , parent . queue ) ;
}
if ( type == ReferenceStrength . WEAK ) {
return new WeakRef <> ( hash , referent , parent . queue ) ;
}
throw new Error () ;
}
protected void onPurge () {
}
protected boolean purge ( final Reference < ? > ref ) {
boolean r = parent . keyType != ReferenceStrength . HARD && key == ref ;
r = r || parent . valueType != ReferenceStrength . HARD && value == ref ;
if ( r ) {
if ( parent . keyType != ReferenceStrength . HARD ) {
( ( Reference < ? > ) key ) . clear () ;
}
if ( parent . valueType != ReferenceStrength . HARD ) {
( ( Reference < ? > ) value ) . clear () ;
} else if ( parent . purgeValues ) {
nullValue () ;
}
}
return r ;
}
protected ReferenceEntry < K , V > next () {
return ( ReferenceEntry < K , V > ) next ;
}
protected void nullValue () {
value = null ;
}
public boolean hasNext () {
checkMod () ;
while ( nextNull () ) {
ReferenceEntry < K , V > e = entry ;
int i = index ;
while ( e == null && i > 0 ) {
i -- ;
e = ( ReferenceEntry < K , V > ) parent . data [ i ] ;
}
entry = e ;
index = i ;
if ( e == null ) {
currentKey = null ;
currentValue = null ;
return false ;
}
nextKey = e . getKey () ;
nextValue = e . getValue () ;
if ( nextNull () ) {
entry = entry . next () ;
}
}
return true ;
}
private void checkMod () {
if ( parent . modCount != expectedModCount ) {
throw new ConcurrentModificationException () ;
}
}
private boolean nextNull () {
return nextKey == null || nextValue == null ;
}
protected ReferenceEntry < K , V > nextEntry () {
checkMod () ;
if ( nextNull () && ! hasNext () ) {
throw new NoSuchElementException () ;
}
previous = entry ;
entry = entry . next () ;
currentKey = nextKey ;
currentValue = nextValue ;
nextKey = null ;
nextValue = null ;
return previous ;
}
protected ReferenceEntry < K , V > currentEntry () {
checkMod () ;
return previous ;
}
public void remove () {
checkMod () ;
if ( previous == null ) {
throw new IllegalStateException () ;
}
parent . remove ( currentKey ) ;
previous = null ;
currentKey = null ;
currentValue = null ;
expectedModCount = parent . modCount ;
}
@Override
public Map . Entry < K , V > next () {
return nextEntry () ;
}
@Override
public K next () {
return nextEntry () . getKey () ;
}
@Override
public V next () {
return nextEntry () . getValue () ;
}
@Override
public K next () {
return nextEntry () . getKey () ;
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
public int hashCode () {
return hash ;
}
@Override
public int hashCode () {
return hash ;
}
@Override
protected void doWriteObject ( final ObjectOutputStream out ) throws IOException {
out . writeInt ( keyType . value ) ;
out . writeInt ( valueType . value ) ;
out . writeBoolean ( purgeValues ) ;
out . writeFloat ( loadFactor ) ;
out . writeInt ( data . length ) ;
for ( final MapIterator < K , V > it = mapIterator () ; it . hasNext () ; ) {
out . writeObject ( it . next () ) ;
out . writeObject ( it . getValue () ) ;
}
out . writeObject ( null ) ;
}
@Override
@SuppressWarnings ( lr_3 )
protected void doReadObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
this . keyType = ReferenceStrength . resolve ( in . readInt () ) ;
this . valueType = ReferenceStrength . resolve ( in . readInt () ) ;
this . purgeValues = in . readBoolean () ;
this . loadFactor = in . readFloat () ;
final int capacity = in . readInt () ;
init () ;
data = new HashEntry [ capacity ] ;
threshold = calculateThreshold ( data . length , loadFactor ) ;
while ( true ) {
final K key = ( K ) in . readObject () ;
if ( key == null ) {
break;
}
final V value = ( V ) in . readObject () ;
put ( key , value ) ;
}
}
protected boolean isKeyType ( final ReferenceStrength type ) {
return this . keyType == type ;
}
protected boolean isValueType ( final ReferenceStrength type ) {
return this . valueType == type ;
}
