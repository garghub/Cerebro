protected void checkBound ( final int bound , final int len , final String type ) { MST[rv.CRCR6Mutator]MSP[]
if ( bound > len ) {
throw new ArrayIndexOutOfBoundsException (
lr_1 + type +
lr_2
) ;
}
if ( bound < 0 ) {
throw new ArrayIndexOutOfBoundsException (
lr_1 + type +
lr_3
) ;
}
}
@Override
public boolean hasNext () {
return index < endIndex ;
}
@Override
@SuppressWarnings ( lr_4 )
public E next () {
if ( hasNext () == false ) {
throw new NoSuchElementException () ;
}
return ( E ) Array . get ( array , index ++ ) ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_5 ) ;
}
public Object getArray () {
return array ;
}
public int getStartIndex () {
return this . startIndex ;
}
public int getEndIndex () {
return this . endIndex ;
}
@Override
public void reset () {
this . index = this . startIndex ;
}
