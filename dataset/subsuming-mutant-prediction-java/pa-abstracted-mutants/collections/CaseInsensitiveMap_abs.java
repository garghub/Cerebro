@Override
protected Object convertKey ( final Object key ) {
if ( key != null ) {
final char [] chars = key . toString () . toCharArray () ;
for ( int i = chars . length - 1 ; i >= 0 ; i -- ) {
chars [ i ] = Character . toLowerCase ( Character . toUpperCase ( chars [ i ] ) ) ;
}
return new String ( chars ) ;
}
return AbstractHashedMap . NULL ;
}
@Override
public CaseInsensitiveMap < K , V > clone () {
return ( CaseInsensitiveMap < K , V > ) super . clone () ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
doReadObject ( in ) ;
}
