private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
super . doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
super . doReadObject ( new HashMap < E , MutableInteger > () , in ) ;
}
