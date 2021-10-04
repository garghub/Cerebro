@Override
public boolean hasNext () {
return nodeList != null && index < nodeList . getLength () ;
}
@Override
public Node next () {
if ( nodeList != null && index < nodeList . getLength () ) { MST[rv.ROR4Mutator]MSP[N]
return nodeList . item ( index ++ ) ;
}
throw new NoSuchElementException ( lr_1 ) ;
}
@Override
public void remove () {
throw new UnsupportedOperationException ( lr_2 ) ;
}
