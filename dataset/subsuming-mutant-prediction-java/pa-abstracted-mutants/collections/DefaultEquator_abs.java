public static < T > DefaultEquator < T > defaultEquator () {
return DefaultEquator . INSTANCE ;
}
@Override
public boolean equate ( final T o1 , final T o2 ) {
return o1 == o2 || o1 != null && o1 . equals ( o2 ) ;
}
@Override
public int hash ( final T o ) {
return o == null ? HASHCODE_NULL : o . hashCode () ;
}
private Object readResolve () {
return INSTANCE ;
}
