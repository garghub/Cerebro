@Override
public K setKey ( final K key ) {
if ( key == this ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return super . setKey ( key ) ;
}
@Override
public V setValue ( final V value ) {
if ( value == this ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
return super . setValue ( value ) ;
}
public Map . Entry < K , V > toMapEntry () {
return new DefaultMapEntry <> ( this ) ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof DefaultKeyValue == false ) {
return false ; MST[ReturnValsMutator]MSP[N]
}
final DefaultKeyValue < ? , ? > other = ( DefaultKeyValue < ? , ? > ) obj ;
return
( getKey () == null ? other . getKey () == null : getKey () . equals ( other . getKey () ) ) &&
( getValue () == null ? other . getValue () == null : getValue () . equals ( other . getValue () ) ) ;
}
@Override
public int hashCode () {
return ( getKey () == null ? 0 : getKey () . hashCode () ) ^
( getValue () == null ? 0 : getValue () . hashCode () ) ;
}
