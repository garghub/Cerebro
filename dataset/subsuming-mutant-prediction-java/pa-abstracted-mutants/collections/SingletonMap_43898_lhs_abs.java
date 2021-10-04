@Override
public K getKey () {
return key ;
}
@Override
public V getValue () {
return value ;
}
public V setValue ( final V value ) {
final V old = this . value ;
this . value = value ;
return old ;
}
@Override
public boolean isFull () {
return true ;
}
@Override
public int maxSize () {
return 1 ;
}
@Override
public V get ( final Object key ) {
if ( isEqualKey ( key ) ) {
return value ;
}
return null ;
}
@Override
public int size () {
return 1 ;
}
@Override
public boolean isEmpty () {
return false ;
}
@Override
public boolean containsKey ( final Object key ) {
return isEqualKey ( key ) ;
}
@Override
public boolean containsValue ( final Object value ) {
return isEqualValue ( value ) ;
}
@Override
public V put ( final K key , final V value ) {
if ( isEqualKey ( key ) ) {
return setValue ( value ) ;
}
throw new IllegalArgumentException ( lr_1 ) ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > map ) {
switch ( map . size () ) {
case 0 :
return;
case 1 :
final Map . Entry < ? extends K , ? extends V > entry = map . entrySet () . iterator () . next () ;
put ( entry . getKey () , entry . getValue () ) ;
return;
default:
throw new IllegalArgumentException ( lr_2 ) ;
}
}
@Override
public V remove ( final Object key ) {
throw new UnsupportedOperationException () ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
final Map . Entry < K , V > entry = new TiedMapEntry <> ( this , getKey () ) ;
return Collections . singleton ( entry ) ;
}
@Override
public Set < K > keySet () {
return Collections . singleton ( key ) ;
}
@Override
public Collection < V > values () {
return new SingletonValues <> ( this ) ;
}
@Override
public OrderedMapIterator < K , V > mapIterator () {
return new SingletonMapIterator <> ( this ) ;
}
@Override
public K firstKey () {
return getKey () ;
}
@Override
public K lastKey () {
return getKey () ;
}
@Override
public K nextKey ( final K key ) {
return null ;
}
@Override
public K previousKey ( final K key ) {
return null ;
}
protected boolean isEqualKey ( final Object key ) {
return key == null ? getKey () == null : key . equals ( getKey () ) ;
}
protected boolean isEqualValue ( final Object value ) {
return value == null ? getValue () == null : value . equals ( getValue () ) ;
}
@Override
public boolean hasNext () {
return hasNext ;
}
@Override
public K next () {
if ( hasNext == false ) {
throw new NoSuchElementException ( AbstractHashedMap . NO_NEXT_ENTRY ) ;
}
hasNext = false ;
canGetSet = true ;
return parent . getKey () ;
}
@Override
public boolean hasPrevious () {
return hasNext == false ;
}
@Override
public K previous () {
if ( hasNext == true ) {
throw new NoSuchElementException ( AbstractHashedMap . NO_PREVIOUS_ENTRY ) ;
}
hasNext = true ;
return parent . getKey () ;
}
@Override
public void remove () {
throw new UnsupportedOperationException () ;
}
@Override
public K getKey () {
if ( canGetSet == false ) {
throw new IllegalStateException ( AbstractHashedMap . GETKEY_INVALID ) ;
}
return parent . getKey () ;
}
@Override
public V getValue () {
if ( canGetSet == false ) {
throw new IllegalStateException ( AbstractHashedMap . GETVALUE_INVALID ) ;
}
return parent . getValue () ;
}
@Override
public V setValue ( final V value ) {
if ( canGetSet == false ) {
throw new IllegalStateException ( AbstractHashedMap . SETVALUE_INVALID ) ;
}
return parent . setValue ( value ) ;
}
@Override
public void reset () {
hasNext = true ;
}
@Override
public String toString () {
if ( hasNext ) {
return lr_3 ;
}
return lr_4 + getKey () + lr_5 + getValue () + lr_6 ;
}
@Override
public int size () {
return 1 ;
}
@Override
public boolean isEmpty () {
return false ;
}
@Override
public boolean contains ( final Object object ) {
return parent . containsValue ( object ) ;
}
@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public Iterator < V > iterator () {
return new SingletonIterator <> ( parent . getValue () , false ) ;
}
@Override
@SuppressWarnings ( lr_7 )
public SingletonMap < K , V > clone () {
try {
return ( SingletonMap < K , V > ) super . clone () ;
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
final Map < ? , ? > other = ( Map < ? , ? > ) obj ;
if ( other . size () != 1 ) {
return false ;
}
final Map . Entry < ? , ? > entry = other . entrySet () . iterator () . next () ;
return isEqualKey ( entry . getKey () ) && isEqualValue ( entry . getValue () ) ; MST[rv.CRCR3Mutator]MSP[]
}
@Override
public int hashCode () {
return ( getKey () == null ? 0 : getKey () . hashCode () ) ^
( getValue () == null ? 0 : getValue () . hashCode () ) ;
}
@Override
public String toString () {
return new StringBuilder ( 128 )
. append ( '{' )
. append ( getKey () == this ? lr_8 : getKey () )
. append ( '=' )
. append ( getValue () == this ? lr_8 : getValue () )
. append ( '}' )
. toString () ;
}
