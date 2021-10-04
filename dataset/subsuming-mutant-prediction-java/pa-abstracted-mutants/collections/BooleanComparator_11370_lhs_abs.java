public static BooleanComparator getTrueFirstComparator () {
return TRUE_FIRST ;
}
public static BooleanComparator getFalseFirstComparator () {
return FALSE_FIRST ;
}
public static BooleanComparator booleanComparator ( final boolean trueFirst ) {
return trueFirst ? TRUE_FIRST : FALSE_FIRST ; MST[rv.ROR5Mutator]MSP[]
}
@Override
public int compare ( final Boolean b1 , final Boolean b2 ) {
final boolean v1 = b1 . booleanValue () ;
final boolean v2 = b2 . booleanValue () ;
return ( v1 ^ v2 ) ? ( ( v1 ^ trueFirst ) ? 1 : - 1 ) : 0 ;
}
@Override
public int hashCode () {
final int hash = lr_1 . hashCode () ;
return trueFirst ? - 1 * hash : hash ;
}
@Override
public boolean equals ( final Object object ) {
return ( this == object ) ||
( ( object instanceof BooleanComparator ) &&
( this . trueFirst == ( ( BooleanComparator ) object ) . trueFirst ) ) ;
}
public boolean sortsTrueFirst () {
return trueFirst ;
}
