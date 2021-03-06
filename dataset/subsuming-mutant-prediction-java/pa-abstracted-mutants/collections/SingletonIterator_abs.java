@Override
public boolean hasNext () {
return beforeFirst && ! removed ;
}
@Override
public E next () {
if ( ! beforeFirst || removed ) {
throw new NoSuchElementException () ;
}
beforeFirst = false ;
return object ;
}
@Override
public void remove () {
if ( removeAllowed ) {
if ( removed || beforeFirst ) {
throw new IllegalStateException () ;
}
object = null ;
removed = true ;
} else {
throw new UnsupportedOperationException () ;
}
}
@Override
public void reset () {
beforeFirst = true ;
}
