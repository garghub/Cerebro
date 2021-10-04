public final T getObject () {
return object ;
}
@Override
public T get () throws ConcurrentException {
return getObject () ;
}
@Override
public int hashCode () {
return getObject () != null ? getObject () . hashCode () : 0 ;
}
@SuppressWarnings ( lr_1 )
@Override
public boolean equals ( final Object obj ) {
if ( this == obj ) {
return true ;
}
if ( ! ( obj instanceof ConstantInitializer < ? > ) ) {
return false ;
}
final ConstantInitializer < ? > c = ( ConstantInitializer < ? > ) obj ;
return ObjectUtils . equals ( getObject () , c . getObject () ) ;
}
@Override
public String toString () {
return String . format ( FMT_TO_STRING , Integer . valueOf ( System . identityHashCode ( this ) ) ,
String . valueOf ( getObject () ) ) ;
}
