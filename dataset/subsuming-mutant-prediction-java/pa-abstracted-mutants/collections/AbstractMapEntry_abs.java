@Override
public V setValue ( final V value ) {
return super . setValue ( value ) ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == this ) {
return true ;
}
if ( obj instanceof Map . Entry == false ) {
return false ;
}
final Map . Entry < ? , ? > other = ( Map . Entry < ? , ? > ) obj ;
return
( getKey () == null ? other . getKey () == null : getKey () . equals ( other . getKey () ) ) &&
( getValue () == null ? other . getValue () == null : getValue () . equals ( other . getValue () ) ) ;
}
@Override
public int hashCode () {
return ( getKey () == null ? 0 : getKey () . hashCode () ) ^
( getValue () == null ? 0 : getValue () . hashCode () ) ;
}
