@Override
public int compare ( final E obj1 , final E obj2 ) {
return comparator . compare ( obj2 , obj1 ) ;
}
@Override
public int hashCode () {
return lr_1 . hashCode () ^ comparator . hashCode () ;
}
@Override
public boolean equals ( final Object object ) {
if ( this == object ) {
return true ;
}
if ( null == object ) {
return false ;
}
if ( object . getClass () . equals ( this . getClass () ) ) {
final ReverseComparator < ? > thatrc = ( ReverseComparator < ? > ) object ;
return comparator . equals ( thatrc . comparator ) ;
}
return false ;
}
