public static < T > Predicate < T > falsePredicate () {
return INSTANCE ;
}
@Override
public boolean evaluate ( final T object ) {
return false ;
}
private Object readResolve () {
return INSTANCE ;
}
