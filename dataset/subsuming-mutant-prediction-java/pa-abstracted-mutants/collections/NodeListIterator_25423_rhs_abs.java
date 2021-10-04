@Override MST[rv.CRCR3Mutator]MSP[N]
public boolean hasNext () {
return nodeList != null && index < nodeList . getLength () ;
}
@Override
public Node next () {
if ( nodeList != null && index < nodeList . getLength () ) {
return nodeList . item ( index ++ ) ;
}
throw new NoSuchElementException ( lr_1 ) ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_2 ) ;
}
