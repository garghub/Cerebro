@Override
public void appendDetail ( final StringBuffer buffer , final String fieldName , final Object value ) {
if ( ! ClassUtils . isPrimitiveWrapper ( value . getClass () ) &&
! String . class . equals ( value . getClass () ) &&
accept ( value . getClass () ) ) {
buffer . append ( ReflectionToStringBuilder . toString ( value , this ) ) ;
} else {
super . appendDetail ( buffer , fieldName , value ) ;
}
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final Collection < ? > coll ) {
appendClassName ( buffer , coll ) ;
appendIdentityHashCode ( buffer , coll ) ;
appendDetail ( buffer , fieldName , coll . toArray () ) ;
}
protected boolean accept ( final Class < ? > clazz ) {
return true ;
}
