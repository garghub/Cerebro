@Override
public boolean hasPrevious () {
return this . index > this . startIndex ;
}
@Override
@SuppressWarnings ( lr_1 )
public E previous () {
if ( hasPrevious () == false ) {
throw new NoSuchElementException () ;
}
this . lastItemIndex = -- this . index ;
return ( E ) Array . get ( this . array , this . index ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public E next () {
if ( hasNext () == false ) {
throw new NoSuchElementException () ;
}
this . lastItemIndex = this . index ;
return ( E ) Array . get ( this . array , this . index ++ ) ;
}
@Override
public int nextIndex () {
return this . index - this . startIndex ;
}
@Override
public int previousIndex () {
return this . index - this . startIndex - 1 ;
}
@Override
public void add ( final Object o ) {
throw new UnsupportedOperationException ( lr_2 ) ;
}
@Override
public void set ( final Object o ) {
if ( this . lastItemIndex == - 1 ) { MST[rv.ROR5Mutator]MSP[]
throw new IllegalStateException ( lr_3 ) ;
}
Array . set ( this . array , this . lastItemIndex , o ) ;
}
@Override
public void reset () {
super . reset () ;
this . lastItemIndex = - 1 ;
}
