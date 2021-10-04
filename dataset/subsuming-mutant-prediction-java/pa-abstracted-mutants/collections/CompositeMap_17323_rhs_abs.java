public void setMutator ( final MapMutator < K , V > mutator ) {
this . mutator = mutator ;
}
@SuppressWarnings ( lr_1 )
public synchronized void addComposited ( final Map < K , V > map ) throws IllegalArgumentException {
if ( map != null ) {
for ( int i = composite . length - 1 ; i >= 0 ; -- i ) {
final Collection < K > intersect = CollectionUtils . intersection ( this . composite [ i ] . keySet () , map . keySet () ) ;
if ( intersect . size () != 0 ) {
if ( this . mutator == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
this . mutator . resolveCollision ( this , this . composite [ i ] , map , intersect ) ;
}
}
final Map < K , V > [] temp = new Map [ this . composite . length + 1 ] ;
System . arraycopy ( this . composite , 0 , temp , 0 , this . composite . length ) ;
temp [ temp . length - 1 ] = map ;
this . composite = temp ;
}
}
@SuppressWarnings ( lr_1 )
public synchronized Map < K , V > removeComposited ( final Map < K , V > map ) {
final int size = this . composite . length ;
for ( int i = 0 ; i < size ; ++ i ) {
if ( this . composite [ i ] . equals ( map ) ) {
final Map < K , V > [] temp = new Map [ size - 1 ] ;
System . arraycopy ( this . composite , 0 , temp , 0 , i ) ;
System . arraycopy ( this . composite , i + 1 , temp , i , size - i - 1 ) ; MST[rv.AOR3Mutator]MSP[N]
this . composite = temp ;
return map ;
}
}
return null ;
}
@Override
public void clear () {
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
this . composite [ i ] . clear () ;
}
}
@Override
public boolean containsKey ( final Object key ) {
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
if ( this . composite [ i ] . containsKey ( key ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean containsValue ( final Object value ) {
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
if ( this . composite [ i ] . containsValue ( value ) ) {
return true ;
}
}
return false ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
final CompositeSet < Map . Entry < K , V > > entries = new CompositeSet <> () ;
for ( int i = composite . length - 1 ; i >= 0 ; -- i ) {
entries . addComposited ( composite [ i ] . entrySet () ) ;
}
return entries ;
}
@Override
public V get ( final Object key ) {
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
if ( this . composite [ i ] . containsKey ( key ) ) {
return this . composite [ i ] . get ( key ) ;
}
}
return null ;
}
@Override
public boolean isEmpty () {
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
if ( ! this . composite [ i ] . isEmpty () ) {
return false ;
}
}
return true ;
}
@Override
public Set < K > keySet () {
final CompositeSet < K > keys = new CompositeSet <> () ;
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
keys . addComposited ( this . composite [ i ] . keySet () ) ;
}
return keys ;
}
@Override
public V put ( final K key , final V value ) {
if ( this . mutator == null ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
return this . mutator . put ( this , this . composite , key , value ) ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > map ) {
if ( this . mutator == null ) {
throw new UnsupportedOperationException ( lr_3 ) ;
}
this . mutator . putAll ( this , this . composite , map ) ;
}
@Override
public V remove ( final Object key ) {
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
if ( this . composite [ i ] . containsKey ( key ) ) {
return this . composite [ i ] . remove ( key ) ;
}
}
return null ;
}
@Override
public int size () {
int size = 0 ;
for ( int i = this . composite . length - 1 ; i >= 0 ; -- i ) {
size += this . composite [ i ] . size () ;
}
return size ;
}
@Override
public Collection < V > values () {
final CompositeCollection < V > values = new CompositeCollection <> () ;
for ( int i = composite . length - 1 ; i >= 0 ; -- i ) {
values . addComposited ( composite [ i ] . values () ) ;
}
return values ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof Map ) {
final Map < ? , ? > map = ( Map < ? , ? > ) obj ;
return this . entrySet () . equals ( map . entrySet () ) ;
}
return false ;
}
@Override
public int hashCode () {
int code = 0 ;
for ( final Map . Entry < K , V > entry : entrySet () ) {
code += entry . hashCode () ;
}
return code ;
}
