public static < K , V > MultiKeyMap < K , V > multiKeyMap ( final AbstractHashedMap < MultiKey < ? extends K > , V > map ) {
Objects . requireNonNull ( map , lr_1 ) ;
if ( map . size () > 0 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return new MultiKeyMap <> ( map ) ;
}
public V get ( final Object key1 , final Object key2 ) {
final int hashCode = hash ( key1 , key2 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 ) ) {
return entry . getValue () ;
}
entry = entry . next ;
}
return null ;
}
public boolean containsKey ( final Object key1 , final Object key2 ) {
final int hashCode = hash ( key1 , key2 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 ) ) {
return true ;
}
entry = entry . next ;
}
return false ;
}
public V put ( final K key1 , final K key2 , final V value ) {
final int hashCode = hash ( key1 , key2 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 ) ) {
final V oldValue = entry . getValue () ;
decorated () . updateEntry ( entry , value ) ;
return oldValue ;
}
entry = entry . next ;
}
decorated () . addMapping ( index , hashCode , new MultiKey <> ( key1 , key2 ) , value ) ;
return null ;
}
public V removeMultiKey ( final Object key1 , final Object key2 ) {
final int hashCode = hash ( key1 , key2 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > previous = null ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 ) ) {
final V oldValue = entry . getValue () ;
decorated () . removeMapping ( entry , index , previous ) ;
return oldValue ;
}
previous = entry ;
entry = entry . next ;
}
return null ;
}
protected int hash ( final Object key1 , final Object key2 ) {
int h = 0 ;
if ( key1 != null ) {
h ^= key1 . hashCode () ;
}
if ( key2 != null ) {
h ^= key2 . hashCode () ;
}
h += ~ ( h << 9 ) ;
h ^= h >>> 14 ;
h += h << 4 ;
h ^= h >>> 10 ;
return h ;
}
protected boolean isEqualKey ( final AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry ,
final Object key1 , final Object key2 ) {
final MultiKey < ? extends K > multi = entry . getKey () ;
return
multi . size () == 2 &&
( key1 == multi . getKey ( 0 ) || key1 != null && key1 . equals ( multi . getKey ( 0 ) ) ) &&
( key2 == multi . getKey ( 1 ) || key2 != null && key2 . equals ( multi . getKey ( 1 ) ) ) ;
}
public V get ( final Object key1 , final Object key2 , final Object key3 ) {
final int hashCode = hash ( key1 , key2 , key3 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 ) ) {
return entry . getValue () ;
}
entry = entry . next ;
}
return null ;
}
public boolean containsKey ( final Object key1 , final Object key2 , final Object key3 ) {
final int hashCode = hash ( key1 , key2 , key3 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 ) ) {
return true ;
}
entry = entry . next ;
}
return false ;
}
public V put ( final K key1 , final K key2 , final K key3 , final V value ) {
final int hashCode = hash ( key1 , key2 , key3 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 ) ) {
final V oldValue = entry . getValue () ;
decorated () . updateEntry ( entry , value ) ;
return oldValue ;
}
entry = entry . next ;
}
decorated () . addMapping ( index , hashCode , new MultiKey <> ( key1 , key2 , key3 ) , value ) ;
return null ;
}
public V removeMultiKey ( final Object key1 , final Object key2 , final Object key3 ) {
final int hashCode = hash ( key1 , key2 , key3 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > previous = null ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 ) ) {
final V oldValue = entry . getValue () ;
decorated () . removeMapping ( entry , index , previous ) ;
return oldValue ;
}
previous = entry ;
entry = entry . next ;
}
return null ;
}
protected int hash ( final Object key1 , final Object key2 , final Object key3 ) {
int h = 0 ;
if ( key1 != null ) {
h ^= key1 . hashCode () ;
}
if ( key2 != null ) {
h ^= key2 . hashCode () ;
}
if ( key3 != null ) {
h ^= key3 . hashCode () ;
}
h += ~ ( h << 9 ) ;
h ^= h >>> 14 ;
h += h << 4 ;
h ^= h >>> 10 ;
return h ;
}
protected boolean isEqualKey ( final AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry ,
final Object key1 , final Object key2 , final Object key3 ) {
final MultiKey < ? extends K > multi = entry . getKey () ;
return
multi . size () == 3 &&
( key1 == multi . getKey ( 0 ) || key1 != null && key1 . equals ( multi . getKey ( 0 ) ) ) &&
( key2 == multi . getKey ( 1 ) || key2 != null && key2 . equals ( multi . getKey ( 1 ) ) ) &&
( key3 == multi . getKey ( 2 ) || key3 != null && key3 . equals ( multi . getKey ( 2 ) ) ) ;
}
public V get ( final Object key1 , final Object key2 , final Object key3 , final Object key4 ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 ) ) {
return entry . getValue () ;
}
entry = entry . next ;
}
return null ;
}
public boolean containsKey ( final Object key1 , final Object key2 , final Object key3 , final Object key4 ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 ) ) {
return true ;
}
entry = entry . next ;
}
return false ;
}
public V put ( final K key1 , final K key2 , final K key3 , final K key4 , final V value ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 ) ) {
final V oldValue = entry . getValue () ;
decorated () . updateEntry ( entry , value ) ;
return oldValue ;
}
entry = entry . next ;
}
decorated () . addMapping ( index , hashCode , new MultiKey <> ( key1 , key2 , key3 , key4 ) , value ) ;
return null ;
}
public V removeMultiKey ( final Object key1 , final Object key2 , final Object key3 , final Object key4 ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > previous = null ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 ) ) {
final V oldValue = entry . getValue () ;
decorated () . removeMapping ( entry , index , previous ) ;
return oldValue ;
}
previous = entry ;
entry = entry . next ;
}
return null ;
}
protected int hash ( final Object key1 , final Object key2 , final Object key3 , final Object key4 ) {
int h = 0 ;
if ( key1 != null ) {
h ^= key1 . hashCode () ;
}
if ( key2 != null ) {
h ^= key2 . hashCode () ;
}
if ( key3 != null ) {
h ^= key3 . hashCode () ;
}
if ( key4 != null ) {
h ^= key4 . hashCode () ;
}
h += ~ ( h << 9 ) ;
h ^= h >>> 14 ;
h += h << 4 ;
h ^= h >>> 10 ;
return h ;
}
protected boolean isEqualKey ( final AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry ,
final Object key1 , final Object key2 , final Object key3 , final Object key4 ) {
final MultiKey < ? extends K > multi = entry . getKey () ;
return
multi . size () == 4 &&
( key1 == multi . getKey ( 0 ) || key1 != null && key1 . equals ( multi . getKey ( 0 ) ) ) &&
( key2 == multi . getKey ( 1 ) || key2 != null && key2 . equals ( multi . getKey ( 1 ) ) ) &&
( key3 == multi . getKey ( 2 ) || key3 != null && key3 . equals ( multi . getKey ( 2 ) ) ) &&
( key4 == multi . getKey ( 3 ) || key4 != null && key4 . equals ( multi . getKey ( 3 ) ) ) ;
}
public V get ( final Object key1 , final Object key2 , final Object key3 , final Object key4 , final Object key5 ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 , key5 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 , key5 ) ) {
return entry . getValue () ;
}
entry = entry . next ;
}
return null ;
}
public boolean containsKey ( final Object key1 , final Object key2 , final Object key3 ,
final Object key4 , final Object key5 ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 , key5 ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry =
decorated () . data [ decorated () . hashIndex ( hashCode , decorated () . data . length ) ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 , key5 ) ) {
return true ;
}
entry = entry . next ;
}
return false ;
}
public V put ( final K key1 , final K key2 , final K key3 , final K key4 , final K key5 , final V value ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 , key5 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 , key5 ) ) {
final V oldValue = entry . getValue () ;
decorated () . updateEntry ( entry , value ) ;
return oldValue ;
}
entry = entry . next ;
}
decorated () . addMapping ( index , hashCode , new MultiKey <> ( key1 , key2 , key3 , key4 , key5 ) , value ) ;
return null ;
}
public V removeMultiKey ( final Object key1 , final Object key2 , final Object key3 ,
final Object key4 , final Object key5 ) {
final int hashCode = hash ( key1 , key2 , key3 , key4 , key5 ) ;
final int index = decorated () . hashIndex ( hashCode , decorated () . data . length ) ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry = decorated () . data [ index ] ;
AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > previous = null ;
while ( entry != null ) {
if ( entry . hashCode == hashCode && isEqualKey ( entry , key1 , key2 , key3 , key4 , key5 ) ) {
final V oldValue = entry . getValue () ;
decorated () . removeMapping ( entry , index , previous ) ;
return oldValue ;
}
previous = entry ;
entry = entry . next ;
}
return null ;
}
protected int hash ( final Object key1 , final Object key2 , final Object key3 , final Object key4 , final Object key5 ) {
int h = 0 ;
if ( key1 != null ) {
h ^= key1 . hashCode () ;
}
if ( key2 != null ) {
h ^= key2 . hashCode () ;
}
if ( key3 != null ) {
h ^= key3 . hashCode () ;
}
if ( key4 != null ) {
h ^= key4 . hashCode () ;
}
if ( key5 != null ) {
h ^= key5 . hashCode () ;
}
h += ~ ( h << 9 ) ;
h ^= h >>> 14 ;
h += h << 4 ;
h ^= h >>> 10 ;
return h ;
}
protected boolean isEqualKey ( final AbstractHashedMap . HashEntry < MultiKey < ? extends K > , V > entry ,
final Object key1 , final Object key2 , final Object key3 , final Object key4 , final Object key5 ) {
final MultiKey < ? extends K > multi = entry . getKey () ;
return
multi . size () == 5 &&
( key1 == multi . getKey ( 0 ) || key1 != null && key1 . equals ( multi . getKey ( 0 ) ) ) &&
( key2 == multi . getKey ( 1 ) || key2 != null && key2 . equals ( multi . getKey ( 1 ) ) ) &&
( key3 == multi . getKey ( 2 ) || key3 != null && key3 . equals ( multi . getKey ( 2 ) ) ) &&
( key4 == multi . getKey ( 3 ) || key4 != null && key4 . equals ( multi . getKey ( 3 ) ) ) &&
( key5 == multi . getKey ( 4 ) || key5 != null && key5 . equals ( multi . getKey ( 4 ) ) ) ;
}
public boolean removeAll ( final Object key1 ) {
boolean modified = false ;
final MapIterator < MultiKey < ? extends K > , V > it = mapIterator () ;
while ( it . hasNext () ) {
final MultiKey < ? extends K > multi = it . next () ;
if ( multi . size () >= 1 &&
( key1 == null ? multi . getKey ( 0 ) == null : key1 . equals ( multi . getKey ( 0 ) ) ) ) {
it . remove () ;
modified = true ;
}
}
return modified ;
}
public boolean removeAll ( final Object key1 , final Object key2 ) {
boolean modified = false ;
final MapIterator < MultiKey < ? extends K > , V > it = mapIterator () ;
while ( it . hasNext () ) {
final MultiKey < ? extends K > multi = it . next () ;
if ( multi . size () >= 2 &&
( key1 == null ? multi . getKey ( 0 ) == null : key1 . equals ( multi . getKey ( 0 ) ) ) &&
( key2 == null ? multi . getKey ( 1 ) == null : key2 . equals ( multi . getKey ( 1 ) ) ) ) {
it . remove () ;
modified = true ; MST[InlineConstantMutator]MSP[]
}
}
return modified ;
}
public boolean removeAll ( final Object key1 , final Object key2 , final Object key3 ) {
boolean modified = false ;
final MapIterator < MultiKey < ? extends K > , V > it = mapIterator () ;
while ( it . hasNext () ) {
final MultiKey < ? extends K > multi = it . next () ;
if ( multi . size () >= 3 &&
( key1 == null ? multi . getKey ( 0 ) == null : key1 . equals ( multi . getKey ( 0 ) ) ) &&
( key2 == null ? multi . getKey ( 1 ) == null : key2 . equals ( multi . getKey ( 1 ) ) ) &&
( key3 == null ? multi . getKey ( 2 ) == null : key3 . equals ( multi . getKey ( 2 ) ) ) ) {
it . remove () ;
modified = true ;
}
}
return modified ;
}
public boolean removeAll ( final Object key1 , final Object key2 , final Object key3 , final Object key4 ) {
boolean modified = false ;
final MapIterator < MultiKey < ? extends K > , V > it = mapIterator () ;
while ( it . hasNext () ) {
final MultiKey < ? extends K > multi = it . next () ;
if ( multi . size () >= 4 &&
( key1 == null ? multi . getKey ( 0 ) == null : key1 . equals ( multi . getKey ( 0 ) ) ) &&
( key2 == null ? multi . getKey ( 1 ) == null : key2 . equals ( multi . getKey ( 1 ) ) ) &&
( key3 == null ? multi . getKey ( 2 ) == null : key3 . equals ( multi . getKey ( 2 ) ) ) &&
( key4 == null ? multi . getKey ( 3 ) == null : key4 . equals ( multi . getKey ( 3 ) ) ) ) {
it . remove () ;
modified = true ;
}
}
return modified ;
}
protected void checkKey ( final MultiKey < ? > key ) {
Objects . requireNonNull ( key , lr_3 ) ;
}
@SuppressWarnings ( lr_4 )
@Override
public MultiKeyMap < K , V > clone () {
try {
return ( MultiKeyMap < K , V > ) super . clone () ;
} catch ( final CloneNotSupportedException e ) {
throw new InternalError () ;
}
}
@Override
public V put ( final MultiKey < ? extends K > key , final V value ) {
checkKey ( key ) ;
return super . put ( key , value ) ;
}
@Override
public void putAll ( final Map < ? extends MultiKey < ? extends K > , ? extends V > mapToCopy ) {
for ( final MultiKey < ? extends K > key : mapToCopy . keySet () ) {
checkKey ( key ) ;
}
super . putAll ( mapToCopy ) ;
}
@Override
public MapIterator < MultiKey < ? extends K > , V > mapIterator () {
return decorated () . mapIterator () ;
}
@Override
protected AbstractHashedMap < MultiKey < ? extends K > , V > decorated () {
return ( AbstractHashedMap < MultiKey < ? extends K > , V > ) super . decorated () ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@SuppressWarnings ( lr_4 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < MultiKey < ? extends K > , V > ) in . readObject () ;
}
