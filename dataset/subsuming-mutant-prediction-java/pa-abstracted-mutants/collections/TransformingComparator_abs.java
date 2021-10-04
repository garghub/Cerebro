@Override
public int compare ( final I obj1 , final I obj2 ) {
final O value1 = this . transformer . transform ( obj1 ) ;
final O value2 = this . transformer . transform ( obj2 ) ;
return this . decorated . compare ( value1 , value2 ) ;
}
@Override
public int hashCode () {
int total = 17 ;
total = total * 37 + ( decorated == null ? 0 : decorated . hashCode () ) ;
total = total * 37 + ( transformer == null ? 0 : transformer . hashCode () ) ;
return total ;
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
final TransformingComparator < ? , ? > comp = ( TransformingComparator < ? , ? > ) object ;
return ( null == decorated ? null == comp . decorated : decorated . equals ( comp . decorated ) ) &&
( null == transformer ? null == comp . transformer : transformer . equals ( comp . transformer ) ) ;
}
return false ;
}
