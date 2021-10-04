private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ; MST[VoidMethodCallMutator]MSP[]
out . writeObject ( decorated () ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
setCollection ( ( Collection < E > ) in . readObject () ) ;
}
