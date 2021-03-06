@Override
public int compare ( final E o1 , final E o2 ) {
if ( o1 == o2 ) {
return 0 ;
}
if ( o1 == null ) {
return this . nullsAreHigh ? 1 : - 1 ;
}
if ( o2 == null ) {
return this . nullsAreHigh ? - 1 : 1 ;
}
return this . nonNullComparator . compare ( o1 , o2 ) ;
}
@Override
public int hashCode () {
return ( nullsAreHigh ? - 1 : 1 ) * nonNullComparator . hashCode () ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == null ) {
return false ;
}
if ( obj == this ) {
return true ;
}
if ( ! obj . getClass () . equals ( this . getClass () ) ) {
return false ;
}
final NullComparator < ? > other = ( NullComparator < ? > ) obj ;
return this . nullsAreHigh == other . nullsAreHigh &&
this . nonNullComparator . equals ( other . nonNullComparator ) ;
}
