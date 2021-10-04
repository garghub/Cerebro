public static < T > Predicate < T > notNullPredicate () {
return INSTANCE ;
}
@Override
public boolean evaluate ( final T object ) {
return object != null ;
}
private Object readResolve () {
return INSTANCE ;
}
