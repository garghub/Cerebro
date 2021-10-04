@Override
protected BidiMap < V , K > createBidiMap ( final Map < V , K > normalMap , final Map < K , V > reverseMap ,
final BidiMap < K , V > inverseBidiMap ) {
return new DualLinkedHashBidiMap <> ( normalMap , reverseMap , inverseBidiMap ) ; MST[ReturnValsMutator]MSP[]
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( normalMap ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
normalMap = new LinkedHashMap <> () ;
reverseMap = new LinkedHashMap <> () ;
@SuppressWarnings ( lr_1 )
final Map < K , V > map = ( Map < K , V > ) in . readObject () ;
putAll ( map ) ;
}
