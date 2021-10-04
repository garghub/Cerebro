protected Map . Entry < K , V > getMapEntry () {
return entry ;
}
@Override
public K getKey () {
return entry . getKey () ;
}
@Override
public V getValue () {
return entry . getValue () ;
}
@Override
public V setValue ( final V object ) {
return entry . setValue ( object ) ;
}
@Override
public boolean equals ( final Object object ) {
if ( object == this ) {
return true ;
}
return entry . equals ( object ) ;
}
@Override
public int hashCode () {
return entry . hashCode () ;
}
@Override
public String toString () {
return entry . toString () ;
}
