public static < T > Predicate < T > truePredicate () {
return INSTANCE ;
}
@Override
public boolean evaluate ( final T object ) {
return true ;
}
private Object readResolve () {
return INSTANCE ;
}
