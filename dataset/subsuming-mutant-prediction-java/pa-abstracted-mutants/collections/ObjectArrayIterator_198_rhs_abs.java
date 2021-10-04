@Override
public boolean hasNext () {
return this . index < this . endIndex ;
}
@Override
public E next () {
if ( hasNext () == false ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[N]
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
