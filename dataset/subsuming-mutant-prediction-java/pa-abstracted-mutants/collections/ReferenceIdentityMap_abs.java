@Override
protected int hash ( final Object key ) {
return System . identityHashCode ( key ) ;
}
@Override
protected int hashEntry ( final Object key , final Object value ) {
return System . identityHashCode ( key ) ^
System . identityHashCode ( value ) ;
}
@Override
protected boolean isEqualKey ( final Object key1 , Object key2 ) {
key2 = isKeyType ( ReferenceStrength . HARD ) ? key2 : ( ( Reference < ? > ) key2 ) . get () ;
return key1 == key2 ;
}
@Override
protected boolean isEqualValue ( final Object value1 , final Object value2 ) {
return value1 == value2 ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
doReadObject ( in ) ;
}
