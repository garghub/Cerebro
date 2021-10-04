public static < T > Predicate < T > equalPredicate ( final T object ) {
if ( object == null ) {
return NullPredicate . nullPredicate () ;
}
return new EqualPredicate <> ( object ) ;
}
public static < T > Predicate < T > equalPredicate ( final T object , final Equator < T > equator ) {
if ( object == null ) {
return NullPredicate . nullPredicate () ;
}
return new EqualPredicate <> ( object , equator ) ;
}
@Override
public boolean evaluate ( final T object ) {
if ( equator != null ) {
return equator . equate ( iValue , object ) ;
}
return iValue . equals ( object ) ;
}
public Object getValue () {
return iValue ;
}
