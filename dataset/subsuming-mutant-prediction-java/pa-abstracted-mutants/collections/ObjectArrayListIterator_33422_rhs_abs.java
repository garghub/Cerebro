@Override
public boolean hasPrevious () {
return this . index > getStartIndex () ;
}
@Override
public E previous () {
if ( hasPrevious () == false ) {
throw new NoSuchElementException () ;
}
this . lastItemIndex = -- this . index ;
return this . array [ this . index ] ;
}
@Override
public E next () {
if ( hasNext () == false ) {
throw new NoSuchElementException () ;
}
this . lastItemIndex = this . index ; MST[experimental.MemberVariableMutator]MSP[N]
return this . array [ this . index ++ ] ;
}
@Override
public int nextIndex () {
return this . index - getStartIndex () ;
}
@Override
public int previousIndex () {
return this . index - getStartIndex () - 1 ;
}
@Override
public void add ( final E obj ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}
@Override
public void set ( final E obj ) {
if ( this . lastItemIndex == - 1 ) {
throw new IllegalStateException ( lr_2 ) ;
}
this . array [ this . lastItemIndex ] = obj ;
}
@Override
public void reset () {
super . reset () ;
this . lastItemIndex = - 1 ;
}
