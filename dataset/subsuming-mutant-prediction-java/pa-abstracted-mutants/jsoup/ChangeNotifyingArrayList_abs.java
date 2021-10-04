@Override
public E set ( int index , E element ) {
onContentsChanged () ;
return super . set ( index , element ) ;
}
@Override
public boolean add ( E e ) {
onContentsChanged () ;
return super . add ( e ) ;
}
@Override
public void add ( int index , E element ) {
onContentsChanged () ;
super . add ( index , element ) ;
}
@Override
public E remove ( int index ) {
onContentsChanged () ;
return super . remove ( index ) ;
}
@Override
public boolean remove ( Object o ) {
onContentsChanged () ;
return super . remove ( o ) ;
}
@Override
public void clear () {
onContentsChanged () ;
super . clear () ;
}
@Override
public boolean addAll ( Collection < ? extends E > c ) {
onContentsChanged () ;
return super . addAll ( c ) ;
}
@Override
public boolean addAll ( int index , Collection < ? extends E > c ) {
onContentsChanged () ;
return super . addAll ( index , c ) ;
}
@Override
protected void removeRange ( int fromIndex , int toIndex ) {
onContentsChanged () ;
super . removeRange ( fromIndex , toIndex ) ;
}
@Override
public boolean removeAll ( Collection < ? > c ) {
onContentsChanged () ;
return super . removeAll ( c ) ;
}
@Override
public boolean retainAll ( Collection < ? > c ) {
onContentsChanged () ;
return super . retainAll ( c ) ;
}
