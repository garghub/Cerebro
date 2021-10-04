@Override
public boolean add ( final E object ) {
if ( comparator () == null && ! ( object instanceof Comparable ) ) {
Objects . requireNonNull ( object , lr_1 ) ;
throw new IllegalArgumentException ( lr_2 + object . getClass () + lr_3 +
lr_4 ) ;
}
return super . add ( object ) ;
}
@Override
public E first () {
return getMap () . firstKey () ;
}
@Override
public E last () {
return getMap () . lastKey () ;
}
@Override
public Comparator < ? super E > comparator () {
return getMap () . comparator () ;
}
@Override
protected SortedMap < E , AbstractMapBag . MutableInteger > getMap () {
return ( SortedMap < E , AbstractMapBag . MutableInteger > ) super . getMap () ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( comparator () ) ;
super . doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
@SuppressWarnings ( lr_5 )
final Comparator < ? super E > comp = ( Comparator < ? super E > ) in . readObject () ;
super . doReadObject ( new TreeMap < E , MutableInteger > ( comp ) , in ) ; MST[VoidMethodCallMutator]MSP[S]
}
