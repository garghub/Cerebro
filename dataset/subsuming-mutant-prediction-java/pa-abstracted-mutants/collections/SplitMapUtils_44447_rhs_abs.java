@Override
public void clear () {
throw new UnsupportedOperationException () ;
}
@Override
public boolean containsKey ( final Object key ) {
return get . containsKey ( key ) ;
}
@Override
public boolean containsValue ( final Object value ) {
return get . containsValue ( value ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
return UnmodifiableEntrySet . unmodifiableEntrySet ( get . entrySet () ) ;
}
@Override
public boolean equals ( final Object arg0 ) {
if ( arg0 == this ) {
return true ;
}
return arg0 instanceof WrappedGet && ( ( WrappedGet < ? , ? > ) arg0 ) . get . equals ( this . get ) ;
}
@Override
public V get ( final Object key ) {
return get . get ( key ) ;
}
@Override
public int hashCode () {
return ( lr_1 . hashCode () << 4 ) | get . hashCode () ;
}
@Override
public boolean isEmpty () {
return get . isEmpty () ;
}
@Override
public Set < K > keySet () {
return UnmodifiableSet . unmodifiableSet ( get . keySet () ) ;
}
@Override
public V put ( final K key , final V value ) {
throw new UnsupportedOperationException () ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > t ) {
throw new UnsupportedOperationException () ;
}
@Override
public V remove ( final Object key ) {
return get . remove ( key ) ;
}
@Override
public int size () {
return get . size () ;
}
@Override
public Collection < V > values () {
return UnmodifiableCollection . unmodifiableCollection ( get . values () ) ;
}
@Override
public MapIterator < K , V > mapIterator () {
MapIterator < K , V > it ;
if ( get instanceof IterableGet ) {
it = ( ( IterableGet < K , V > ) get ) . mapIterator () ;
} else {
it = new EntrySetToMapIteratorAdapter <> ( get . entrySet () ) ;
}
return UnmodifiableMapIterator . unmodifiableMapIterator ( it ) ;
}
@Override
public void clear () {
put . clear () ;
}
@Override
public boolean containsKey ( final Object key ) {
throw new UnsupportedOperationException () ;
}
@Override
public boolean containsValue ( final Object value ) {
throw new UnsupportedOperationException () ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
throw new UnsupportedOperationException () ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
return obj instanceof WrappedPut && ( ( WrappedPut < ? , ? > ) obj ) . put . equals ( this . put ) ; MST[rv.ROR2Mutator]MSP[N]
}
@Override
public V get ( final Object key ) {
throw new UnsupportedOperationException () ;
}
@Override
public int hashCode () {
return ( lr_2 . hashCode () << 4 ) | put . hashCode () ;
}
@Override
public boolean isEmpty () {
throw new UnsupportedOperationException () ;
}
@Override
public Set < K > keySet () {
throw new UnsupportedOperationException () ;
}
@Override
@SuppressWarnings ( lr_3 )
public V put ( final K key , final V value ) {
return ( V ) put . put ( key , value ) ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > t ) {
put . putAll ( t ) ;
}
@Override
public V remove ( final Object key ) {
throw new UnsupportedOperationException () ;
}
@Override
public int size () {
throw new UnsupportedOperationException () ;
}
@Override
public Collection < V > values () {
throw new UnsupportedOperationException () ;
}
@SuppressWarnings ( lr_3 )
public static < K , V > IterableMap < K , V > readableMap ( final Get < K , V > get ) {
Objects . requireNonNull ( get , lr_4 ) ;
if ( get instanceof Map ) {
return get instanceof IterableMap ?
( ( IterableMap < K , V > ) get ) :
MapUtils . iterableMap ( ( Map < K , V > ) get ) ;
}
return new WrappedGet <> ( get ) ;
}
@SuppressWarnings ( lr_3 )
public static < K , V > Map < K , V > writableMap ( final Put < K , V > put ) {
Objects . requireNonNull ( put , lr_5 ) ;
if ( put instanceof Map ) {
return ( Map < K , V > ) put ;
}
return new WrappedPut <> ( put ) ;
}
