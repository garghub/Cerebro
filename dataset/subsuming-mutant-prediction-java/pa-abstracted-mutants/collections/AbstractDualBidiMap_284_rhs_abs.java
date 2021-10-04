@Override
public V get ( final Object key ) {
return normalMap . get ( key ) ;
}
@Override
public int size () {
return normalMap . size () ;
}
@Override
public boolean isEmpty () {
return normalMap . isEmpty () ;
}
@Override
public boolean containsKey ( final Object key ) {
return normalMap . containsKey ( key ) ;
}
@Override
public boolean equals ( final Object obj ) {
return normalMap . equals ( obj ) ;
}
@Override
public int hashCode () {
return normalMap . hashCode () ;
}
@Override
public String toString () {
return normalMap . toString () ;
}
@Override
public V put ( final K key , final V value ) {
if ( normalMap . containsKey ( key ) ) {
reverseMap . remove ( normalMap . get ( key ) ) ;
}
if ( reverseMap . containsKey ( value ) ) {
normalMap . remove ( reverseMap . get ( value ) ) ;
}
final V obj = normalMap . put ( key , value ) ; MST[NonVoidMethodCallMutator]MSP[N]
reverseMap . put ( value , key ) ;
return obj ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > map ) {
for ( final Map . Entry < ? extends K , ? extends V > entry : map . entrySet () ) {
put ( entry . getKey () , entry . getValue () ) ;
}
}
@Override
public V remove ( final Object key ) {
V value = null ;
if ( normalMap . containsKey ( key ) ) {
value = normalMap . remove ( key ) ;
reverseMap . remove ( value ) ;
}
return value ;
}
@Override
public void clear () {
normalMap . clear () ;
reverseMap . clear () ;
}
@Override
public boolean containsValue ( final Object value ) {
return reverseMap . containsKey ( value ) ;
}
@Override
public MapIterator < K , V > mapIterator () {
return new BidiMapIterator <> ( this ) ;
}
@Override
public K getKey ( final Object value ) {
return reverseMap . get ( value ) ;
}
@Override
public K removeValue ( final Object value ) {
K key = null ;
if ( reverseMap . containsKey ( value ) ) {
key = reverseMap . remove ( value ) ;
normalMap . remove ( key ) ;
}
return key ;
}
@Override
public BidiMap < V , K > inverseBidiMap () {
if ( inverseBidiMap == null ) {
inverseBidiMap = createBidiMap ( reverseMap , normalMap , this ) ;
}
return inverseBidiMap ;
}
@Override
public Set < K > keySet () {
if ( keySet == null ) {
keySet = new KeySet <> ( this ) ;
}
return keySet ;
}
protected Iterator < K > createKeySetIterator ( final Iterator < K > iterator ) {
return new KeySetIterator <> ( iterator , this ) ;
}
@Override
public Set < V > values () {
if ( values == null ) {
values = new Values <> ( this ) ;
}
return values ;
}
protected Iterator < V > createValuesIterator ( final Iterator < V > iterator ) {
return new ValuesIterator <> ( iterator , this ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
if ( entrySet == null ) {
entrySet = new EntrySet <> ( this ) ;
}
return entrySet ;
}
protected Iterator < Map . Entry < K , V > > createEntrySetIterator ( final Iterator < Map . Entry < K , V > > iterator ) {
return new EntrySetIterator <> ( iterator , this ) ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || decorated () . equals ( object ) ;
}
@Override
public int hashCode () {
return decorated () . hashCode () ;
}
@Override
public boolean removeIf ( final Predicate < ? super E > filter ) {
if ( parent . isEmpty () || Objects . isNull ( filter ) ) {
return false ;
}
boolean modified = false ;
final Iterator < ? > it = iterator () ;
while ( it . hasNext () ) {
@SuppressWarnings ( lr_1 )
final E e = ( E ) it . next () ;
if ( filter . test ( e ) ) {
it . remove () ;
modified = true ;
}
}
return modified ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
if ( parent . isEmpty () || coll . isEmpty () ) {
return false ;
}
boolean modified = false ;
final Iterator < ? > it = coll . iterator () ;
while ( it . hasNext () ) {
modified |= remove ( it . next () ) ;
}
return modified ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
if ( parent . isEmpty () ) {
return false ;
}
if ( coll . isEmpty () ) {
parent . clear () ;
return true ;
}
boolean modified = false ;
final Iterator < E > it = iterator () ;
while ( it . hasNext () ) {
if ( coll . contains ( it . next () ) == false ) {
it . remove () ;
modified = true ;
}
}
return modified ;
}
@Override
public void clear () {
parent . clear () ;
}
@Override
public Iterator < K > iterator () {
return parent . createKeySetIterator ( super . iterator () ) ;
}
@Override
public boolean contains ( final Object key ) {
return parent . normalMap . containsKey ( key ) ;
}
@Override
public boolean remove ( final Object key ) {
if ( parent . normalMap . containsKey ( key ) ) {
final Object value = parent . normalMap . remove ( key ) ;
parent . reverseMap . remove ( value ) ;
return true ;
}
return false ;
}
@Override
public K next () {
lastKey = super . next () ;
canRemove = true ;
return lastKey ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
final Object value = parent . normalMap . get ( lastKey ) ;
super . remove () ;
parent . reverseMap . remove ( value ) ;
lastKey = null ;
canRemove = false ;
}
@Override
public Iterator < V > iterator () {
return parent . createValuesIterator ( super . iterator () ) ;
}
@Override
public boolean contains ( final Object value ) {
return parent . reverseMap . containsKey ( value ) ;
}
@Override
public boolean remove ( final Object value ) {
if ( parent . reverseMap . containsKey ( value ) ) {
final Object key = parent . reverseMap . remove ( value ) ;
parent . normalMap . remove ( key ) ;
return true ;
}
return false ;
}
@Override
public V next () {
lastValue = super . next () ;
canRemove = true ;
return lastValue ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
super . remove () ;
parent . reverseMap . remove ( lastValue ) ;
lastValue = null ;
canRemove = false ;
}
@Override
public Iterator < Map . Entry < K , V > > iterator () {
return parent . createEntrySetIterator ( super . iterator () ) ;
}
@Override
public boolean remove ( final Object obj ) {
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > entry = ( Map . Entry < ? , ? > ) obj ;
final Object key = entry . getKey () ;
if ( parent . containsKey ( key ) ) {
final V value = parent . normalMap . get ( key ) ;
if ( value == null ? entry . getValue () == null : value . equals ( entry . getValue () ) ) {
parent . normalMap . remove ( key ) ;
parent . reverseMap . remove ( value ) ;
return true ;
}
}
return false ;
}
@Override
public Map . Entry < K , V > next () {
last = new MapEntry <> ( super . next () , parent ) ;
canRemove = true ;
return last ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
final Object value = last . getValue () ;
super . remove () ;
parent . reverseMap . remove ( value ) ;
last = null ;
canRemove = false ;
}
@Override
public V setValue ( final V value ) {
final K key = MapEntry . this . getKey () ;
if ( parent . reverseMap . containsKey ( value ) &&
parent . reverseMap . get ( value ) != key ) {
throw new IllegalArgumentException (
lr_3 ) ;
}
parent . put ( key , value ) ;
return super . setValue ( value ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public K next () {
last = iterator . next () ;
canRemove = true ;
return last . getKey () ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
final V value = last . getValue () ;
iterator . remove () ;
parent . reverseMap . remove ( value ) ;
last = null ;
canRemove = false ;
}
@Override
public K getKey () {
if ( last == null ) {
throw new IllegalStateException (
lr_4 ) ;
}
return last . getKey () ;
}
@Override
public V getValue () {
if ( last == null ) {
throw new IllegalStateException (
lr_5 ) ;
}
return last . getValue () ;
}
@Override
public V setValue ( final V value ) {
if ( last == null ) {
throw new IllegalStateException (
lr_6 ) ;
}
if ( parent . reverseMap . containsKey ( value ) &&
parent . reverseMap . get ( value ) != last . getKey () ) {
throw new IllegalArgumentException (
lr_3 ) ;
}
return parent . put ( last . getKey () , value ) ;
}
@Override
public void reset () {
iterator = parent . normalMap . entrySet () . iterator () ;
last = null ;
canRemove = false ;
}
@Override
public String toString () {
if ( last != null ) {
return lr_7 + getKey () + lr_8 + getValue () + lr_9 ;
}
return lr_10 ;
}
