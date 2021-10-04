private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
doReadObject ( in ) ;
}
