protected Map < K , V > decorated () {
return map ;
}
@Override
public void clear () {
decorated () . clear () ;
}
@Override
public boolean containsKey ( final Object key ) {
return decorated () . containsKey ( key ) ;
}
@Override
public boolean containsValue ( final Object value ) {
return decorated () . containsValue ( value ) ;
}
@Override
public Set < Map . Entry < K , V > > entrySet () {
return decorated () . entrySet () ;
}
@Override
public V get ( final Object key ) {
return decorated () . get ( key ) ;
}
@Override
public boolean isEmpty () {
return decorated () . isEmpty () ;
}
@Override
public Set < K > keySet () {
return decorated () . keySet () ;
}
@Override
public V put ( final K key , final V value ) {
return decorated () . put ( key , value ) ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > mapToCopy ) {
decorated () . putAll ( mapToCopy ) ;
}
@Override
public V remove ( final Object key ) {
return decorated () . remove ( key ) ;
}
@Override
public int size () {
return decorated () . size () ;
}
@Override
public Collection < V > values () {
return decorated () . values () ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
return decorated () . equals ( object ) ;
}
@Override
public int hashCode () {
return decorated () . hashCode () ;
}
@Override
public String toString () {
return decorated () . toString () ;
}
