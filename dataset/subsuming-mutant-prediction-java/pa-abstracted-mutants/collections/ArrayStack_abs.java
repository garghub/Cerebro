public boolean empty () {
return isEmpty () ;
}
public E peek () throws EmptyStackException {
final int n = size () ;
if ( n <= 0 ) {
throw new EmptyStackException () ;
}
return get ( n - 1 ) ;
}
public E peek ( final int n ) throws EmptyStackException {
final int m = ( size () - n ) - 1 ;
if ( m < 0 ) {
throw new EmptyStackException () ;
}
return get ( m ) ;
}
public E pop () throws EmptyStackException {
final int n = size () ;
if ( n <= 0 ) {
throw new EmptyStackException () ;
}
return remove ( n - 1 ) ;
}
public E push ( final E item ) {
add ( item ) ;
return item ;
}
public int search ( final Object object ) {
int i = size () - 1 ;
int n = 1 ;
while ( i >= 0 ) {
final Object current = get ( i ) ;
if ( ( object == null && current == null ) ||
( object != null && object . equals ( current ) ) ) {
return n ;
}
i -- ;
n ++ ;
}
return - 1 ;
}
