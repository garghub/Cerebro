@Override
public boolean hasNext () {
return this . index < this . endIndex ; MST[rv.CRCR1Mutator]MSP[]
}
@Override
public E next () {
if ( hasNext () == false ) {
throw new NoSuchElementException () ;
}
return this . array [ this . index ++ ] ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_1 ) ;
}
public E [] getArray () {
return this . array ;
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
