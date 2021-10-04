private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( decorated () ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ; MST[VoidMethodCallMutator]MSP[]
setCollection ( ( Collection < E > ) in . readObject () ) ;
}
