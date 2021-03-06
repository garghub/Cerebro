@Override
protected ArrayList < V > createCollection () {
return new ArrayList <> ( initialListCapacity ) ;
}
public void trimToSize () {
for ( final Collection < V > coll : getMap () . values () ) {
final ArrayList < V > list = ( ArrayList < V > ) coll ;
list . trimToSize () ;
}
}
private void writeObject ( final ObjectOutputStream oos ) throws IOException {
oos . defaultWriteObject () ;
doWriteObject ( oos ) ;
}
private void readObject ( final ObjectInputStream ois ) throws IOException , ClassNotFoundException {
ois . defaultReadObject () ;
setMap ( new HashMap < K , ArrayList < V > > () ) ;
doReadObject ( ois ) ;
}
