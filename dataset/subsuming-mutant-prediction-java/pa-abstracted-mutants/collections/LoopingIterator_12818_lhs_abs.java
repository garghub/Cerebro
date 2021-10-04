@Override
public boolean hasNext () {
return collection . size () > 0 ;
}
@Override
public E next () {
if ( collection . size () == 0 ) { MST[rv.ROR2Mutator]MSP[]
throw new NoSuchElementException ( lr_1 ) ;
}
if ( iterator . hasNext () == false ) {
reset () ;
}
return iterator . next () ;
}
@Override
public void remove () {
iterator . remove () ;
}
@Override
public void reset () {
iterator = collection . iterator () ;
}
public int size () {
return collection . size () ;
}
