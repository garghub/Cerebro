@Override
public boolean hasMoreElements () {
return iterator . hasNext () ;
}
@Override
public E nextElement () {
return iterator . next () ;
}
public Iterator < ? extends E > getIterator () {
return iterator ;
}
public void setIterator ( final Iterator < ? extends E > iterator ) {
this . iterator = iterator ;
}
