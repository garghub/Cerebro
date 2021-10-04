@Override
public T getValue () {
return this . value ;
}
@Override
public void setValue ( final T value ) {
this . value = value ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj == null ) {
return false ;
}
if ( this == obj ) {
return true ;
}
if ( this . getClass () == obj . getClass () ) {
final MutableObject < ? > that = ( MutableObject < ? > ) obj ;
return this . value . equals ( that . value ) ;
}
return false ;
}
@Override
public int hashCode () {
return value == null ? 0 : value . hashCode () ;
}
@Override
public String toString () {
return value == null ? lr_1 : value . toString () ;
}
