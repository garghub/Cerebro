@Override
public V get ( final Object key ) {
return get ( key , true ) ;
}
public V get ( final Object key , final boolean updateToMRU ) {
final LinkEntry < K , V > entry = getEntry ( key ) ;
if ( entry == null ) {
return null ;
}
if ( updateToMRU ) {
moveToMRU ( entry ) ;
}
return entry . getValue () ;
}
protected void moveToMRU ( final LinkEntry < K , V > entry ) {
if ( entry . after != header ) {
modCount ++ ;
if ( entry . before == null ) {
throw new IllegalStateException ( lr_1 +
lr_2 ) ;
}
entry . before . after = entry . after ;
entry . after . before = entry . before ;
entry . after = header ;
entry . before = header . before ;
header . before . after = entry ;
header . before = entry ;
} else if ( entry == header ) {
throw new IllegalStateException ( lr_3 +
lr_2 ) ;
}
}
@Override
protected void updateEntry ( final HashEntry < K , V > entry , final V newValue ) {
moveToMRU ( ( LinkEntry < K , V > ) entry ) ;
entry . setValue ( newValue ) ;
}
@Override
protected void addMapping ( final int hashIndex , final int hashCode , final K key , final V value ) {
if ( isFull () ) {
LinkEntry < K , V > reuse = header . after ;
boolean removeLRUEntry = false ;
if ( scanUntilRemovable ) {
while ( reuse != header && reuse != null ) {
if ( removeLRU ( reuse ) ) {
removeLRUEntry = true ;
break;
}
reuse = reuse . after ;
}
if ( reuse == null ) {
throw new IllegalStateException (
lr_4 + header . after + lr_5 + header . before +
lr_6 + key + lr_7 + value + lr_8 + size + lr_9 + maxSize +
lr_10 ) ;
}
} else {
removeLRUEntry = removeLRU ( reuse ) ;
}
if ( removeLRUEntry ) {
if ( reuse == null ) {
throw new IllegalStateException (
lr_11 + header . after + lr_5 + header . before +
lr_6 + key + lr_7 + value + lr_8 + size + lr_9 + maxSize +
lr_10 ) ;
}
reuseMapping ( reuse , hashIndex , hashCode , key , value ) ;
} else {
super . addMapping ( hashIndex , hashCode , key , value ) ;
}
} else {
super . addMapping ( hashIndex , hashCode , key , value ) ;
}
}
protected void reuseMapping ( final LinkEntry < K , V > entry , final int hashIndex , final int hashCode ,
final K key , final V value ) {
try {
final int removeIndex = hashIndex ( entry . hashCode , data . length ) ;
final HashEntry < K , V > [] tmp = data ;
HashEntry < K , V > loop = tmp [ removeIndex ] ;
HashEntry < K , V > previous = null ;
while ( loop != entry && loop != null ) {
previous = loop ;
loop = loop . next ;
}
if ( loop == null ) {
throw new IllegalStateException (
lr_12 + data [ removeIndex ] + lr_13 + previous +
lr_6 + key + lr_7 + value + lr_8 + size + lr_9 + maxSize +
lr_2 ) ;
}
modCount ++ ; MST[experimental.MemberVariableMutator]MSP[]
removeEntry ( entry , removeIndex , previous ) ;
reuseEntry ( entry , hashIndex , hashCode , key , value ) ;
addEntry ( entry , hashIndex ) ;
} catch ( final NullPointerException ex ) {
throw new IllegalStateException (
lr_14 + entry + lr_15 + ( entry == header ) +
lr_6 + key + lr_7 + value + lr_8 + size + lr_9 + maxSize +
lr_2 ) ;
}
}
protected boolean removeLRU ( final LinkEntry < K , V > entry ) {
return true ;
}
@Override
public boolean isFull () {
return size >= maxSize ;
}
@Override
public int maxSize () {
return maxSize ;
}
public boolean isScanUntilRemovable () {
return scanUntilRemovable ;
}
@Override
public LRUMap < K , V > clone () {
return ( LRUMap < K , V > ) super . clone () ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
doReadObject ( in ) ;
}
@Override
protected void doWriteObject ( final ObjectOutputStream out ) throws IOException {
out . writeInt ( maxSize ) ;
super . doWriteObject ( out ) ;
}
@Override
protected void doReadObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
maxSize = in . readInt () ;
super . doReadObject ( in ) ;
}
