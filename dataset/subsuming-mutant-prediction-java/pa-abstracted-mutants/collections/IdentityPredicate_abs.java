public static < T > Predicate < T > identityPredicate ( final T object ) {
if ( object == null ) {
return NullPredicate . <T > nullPredicate () ;
}
return new IdentityPredicate <> ( object ) ;
}
@Override
public boolean evaluate ( final T object ) {
return iValue == object ;
}
public T getValue () {
return iValue ;
}
