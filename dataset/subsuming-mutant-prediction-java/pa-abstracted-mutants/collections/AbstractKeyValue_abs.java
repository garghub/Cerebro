@Override
public K getKey () {
return key ;
}
protected K setKey ( final K key ) {
final K old = this . key ;
this . key = key ;
return old ;
}
@Override
public V getValue () {
return value ;
}
protected V setValue ( final V value ) {
final V old = this . value ;
this . value = value ;
return old ;
}
@Override
public String toString () {
return new StringBuilder ()
. append ( getKey () )
. append ( '=' )
. append ( getValue () )
. toString () ;
}
