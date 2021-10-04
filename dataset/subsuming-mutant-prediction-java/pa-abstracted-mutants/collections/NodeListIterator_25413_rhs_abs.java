@Override
public boolean hasNext () {
return nodeList != null && index < nodeList . getLength () ; MST[rv.UOI3Mutator]MSP[N]
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
