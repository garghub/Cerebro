@Override
public boolean hasNext () {
return beforeFirst && ! removed ;
}
@Override
public boolean hasPrevious () {
return ! beforeFirst && ! removed ;
}
@Override
public int nextIndex () {
return beforeFirst ? 0 : 1 ;
}
@Override
public int previousIndex () {
return beforeFirst ? - 1 : 0 ; MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
}
@Override
public E next () {
if ( ! beforeFirst || removed ) {
throw new NoSuchElementException () ;
}
beforeFirst = false ;
nextCalled = true ;
return object ;
}
@Override
public E previous () {
if ( beforeFirst || removed ) {
throw new NoSuchElementException () ;
}
beforeFirst = true ;
return object ;
}
@Override
public void remove () {
if ( ! nextCalled || removed ) {
throw new IllegalStateException () ;
}
object = null ;
removed = true ;
}
@Override
public void add ( final E obj ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}
@Override
public void set ( final E obj ) {
if ( ! nextCalled || removed ) {
throw new IllegalStateException () ;
}
this . object = obj ;
}
@Override
public void reset () {
beforeFirst = true ;
nextCalled = false ;
}
