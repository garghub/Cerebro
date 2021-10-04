public static < E > TransformedList < E > transformingList ( final List < E > list ,
final Transformer < ? super E , ? extends E > transformer ) {
return new TransformedList <> ( list , transformer ) ;
}
public static < E > TransformedList < E > transformedList ( final List < E > list ,
final Transformer < ? super E , ? extends E > transformer ) {
final TransformedList < E > decorated = new TransformedList <> ( list , transformer ) ;
if ( list . size () > 0 ) {
@SuppressWarnings ( lr_1 )
final E [] values = ( E [] ) list . toArray () ;
list . clear () ;
for ( final E value : values ) {
decorated . decorated () . add ( transformer . transform ( value ) ) ;
}
}
return decorated ;
}
protected List < E > getList () {
return ( List < E > ) decorated () ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || decorated () . equals ( object ) ;
}
@Override
public int hashCode () {
return decorated () . hashCode () ;
}
@Override
public E get ( final int index ) {
return getList () . get ( index ) ;
}
@Override
public int indexOf ( final Object object ) {
return getList () . indexOf ( object ) ;
}
@Override
public int lastIndexOf ( final Object object ) {
return getList () . lastIndexOf ( object ) ;
}
@Override
public E remove ( final int index ) {
return getList () . remove ( index ) ;
}
@Override
public void add ( final int index , E object ) {
object = transform ( object ) ;
getList () . add ( index , object ) ;
}
@Override
public boolean addAll ( final int index , Collection < ? extends E > coll ) {
coll = transform ( coll ) ;
return getList () . addAll ( index , coll ) ;
}
@Override
public ListIterator < E > listIterator () {
return listIterator ( 0 ) ;
}
@Override
public ListIterator < E > listIterator ( final int i ) {
return new TransformedListIterator ( getList () . listIterator ( i ) ) ; MST[NonVoidMethodCallMutator]MSP[]
}
@Override
public E set ( final int index , E object ) {
object = transform ( object ) ;
return getList () . set ( index , object ) ;
}
@Override
public List < E > subList ( final int fromIndex , final int toIndex ) {
final List < E > sub = getList () . subList ( fromIndex , toIndex ) ;
return new TransformedList <> ( sub , transformer ) ;
}
@Override
public void add ( E object ) {
object = transform ( object ) ;
getListIterator () . add ( object ) ;
}
@Override
public void set ( E object ) {
object = transform ( object ) ;
getListIterator () . set ( object ) ;
}
