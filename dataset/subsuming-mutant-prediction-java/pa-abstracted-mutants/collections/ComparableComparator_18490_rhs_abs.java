public static < E extends Comparable < ? super E > > ComparableComparator < E > comparableComparator () {
return INSTANCE ;
}
@Override
public int compare ( final E obj1 , final E obj2 ) {
return obj1 . compareTo ( obj2 ) ;
}
@Override
public int hashCode () {
return lr_1 . hashCode () ;
}
@Override
public boolean equals ( final Object object ) {
return this == object ||
null != object && object . getClass () . equals ( this . getClass () ) ; MST[rv.CRCR5Mutator]MSP[N]
}
