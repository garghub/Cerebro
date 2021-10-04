@Override
public K getKey () {
return key ;
}
@Override
public V getValue () {
return map . get ( key ) ;
}
@Override
public V setValue ( final V value ) {
if ( value == this ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return map . put ( key , value ) ;
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
final Object value = getValue () ;
return
( key == null ? other . getKey () == null : key . equals ( other . getKey () ) ) &&
( value == null ? other . getValue () == null : value . equals ( other . getValue () ) ) ; MST[NonVoidMethodCallMutator]MSP[]
}
@Override
public int hashCode () {
final Object value = getValue () ;
return ( getKey () == null ? 0 : getKey () . hashCode () ) ^
( value == null ? 0 : value . hashCode () ) ;
}
@Override
public String toString () {
return getKey () + lr_2 + getValue () ;
}
