public static < E > Bag < E > collectionBag ( final Bag < E > bag ) {
return new CollectionBag <> ( bag ) ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
out . writeObject ( decorated () ) ;
}
@SuppressWarnings ( lr_1 )
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
setCollection ( ( Collection < E > ) in . readObject () ) ;
}
@Override
public boolean containsAll ( final Collection < ? > coll ) {
final Iterator < ? > e = coll . iterator () ;
while ( e . hasNext () ) {
if ( ! contains ( e . next () ) ) {
return false ;
}
}
return true ; MST[ReturnValsMutator]MSP[S]
}
@Override
public boolean add ( final E object ) {
return add ( object , 1 ) ;
}
@Override
public boolean addAll ( final Collection < ? extends E > coll ) {
boolean changed = false ;
final Iterator < ? extends E > i = coll . iterator () ;
while ( i . hasNext () ) {
final boolean added = add ( i . next () , 1 ) ;
changed = changed || added ;
}
return changed ;
}
@Override
public boolean remove ( final Object object ) {
return remove ( object , 1 ) ;
}
@Override
public boolean removeAll ( final Collection < ? > coll ) {
if ( coll != null ) {
boolean result = false ;
final Iterator < ? > i = coll . iterator () ;
while ( i . hasNext () ) {
final Object obj = i . next () ;
final boolean changed = remove ( obj , getCount ( obj ) ) ;
result = result || changed ;
}
return result ;
}
return decorated () . removeAll ( null ) ;
}
@Override
public boolean retainAll ( final Collection < ? > coll ) {
if ( coll != null ) {
boolean modified = false ;
final Iterator < E > e = iterator () ;
while ( e . hasNext () ) {
if ( ! coll . contains ( e . next () ) ) {
e . remove () ;
modified = true ;
}
}
return modified ;
}
return decorated () . retainAll ( null ) ;
}
@Override
public boolean add ( final E object , final int count ) {
decorated () . add ( object , count ) ;
return true ;
}
