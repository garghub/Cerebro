@Override
protected HashSet < V > createCollection () {
return new HashSet <> ( initialSetCapacity ) ;
}
private void writeObject ( final ObjectOutputStream oos ) throws IOException {
oos . defaultWriteObject () ;
doWriteObject ( oos ) ;
}
private void readObject ( final ObjectInputStream ois ) throws IOException , ClassNotFoundException {
ois . defaultReadObject () ;
setMap ( new HashMap < K , HashSet < V > > () ) ;
doReadObject ( ois ) ;
}
