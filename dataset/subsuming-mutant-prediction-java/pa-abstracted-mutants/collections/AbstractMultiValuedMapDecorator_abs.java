protected MultiValuedMap < K , V > decorated () {
return map ;
}
@Override
public int size () {
return decorated () . size () ;
}
@Override
public boolean isEmpty () {
return decorated () . isEmpty () ;
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
public boolean containsMapping ( final Object key , final Object value ) {
return decorated () . containsMapping ( key , value ) ;
}
@Override
public Collection < V > get ( final K key ) {
return decorated () . get ( key ) ;
}
@Override
public Collection < V > remove ( final Object key ) {
return decorated () . remove ( key ) ;
}
@Override
public boolean removeMapping ( final Object key , final Object item ) {
return decorated () . removeMapping ( key , item ) ;
}
@Override
public void clear () {
decorated () . clear () ;
}
@Override
public boolean put ( final K key , final V value ) {
return decorated () . put ( key , value ) ;
}
@Override
public Set < K > keySet () {
return decorated () . keySet () ;
}
@Override
public Collection < Entry < K , V > > entries () {
return decorated () . entries () ;
}
@Override
public MultiSet < K > keys () {
return decorated () . keys () ;
}
@Override
public Collection < V > values () {
return decorated () . values () ;
}
@Override
public Map < K , Collection < V > > asMap () {
return decorated () . asMap () ;
}
@Override
public boolean putAll ( final K key , final Iterable < ? extends V > values ) {
return decorated () . putAll ( key , values ) ;
}
@Override
public boolean putAll ( final Map < ? extends K , ? extends V > map ) {
return decorated () . putAll ( map ) ;
}
@Override
public boolean putAll ( final MultiValuedMap < ? extends K , ? extends V > map ) {
return decorated () . putAll ( map ) ;
}
@Override
public MapIterator < K , V > mapIterator () {
return decorated () . mapIterator () ;
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
