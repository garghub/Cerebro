protected ListIterator < E > getListIterator () {
return iterator ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public E next () {
return iterator . next () ;
}
@Override
public int nextIndex () {
return iterator . nextIndex () ;
}
@Override
public boolean hasPrevious () {
return iterator . hasPrevious () ;
}
@Override
public E previous () {
return iterator . previous () ;
}
@Override
public int previousIndex () {
return iterator . previousIndex () ;
}
@Override
public void remove () {
iterator . remove () ;
}
@Override
public void set ( final E obj ) {
iterator . set ( obj ) ;
}
@Override
public void add ( final E obj ) {
iterator . add ( obj ) ;
}
